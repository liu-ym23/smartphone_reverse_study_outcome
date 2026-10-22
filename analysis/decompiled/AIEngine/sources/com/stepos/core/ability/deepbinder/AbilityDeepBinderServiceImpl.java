package com.stepos.core.ability.deepbinder;

import ai.onnxruntime.a;
import android.os.Binder;
import android.util.Log;
import com.stepos.base.model.ModelReleaseReason;
import com.stepos.core.ability.AbilityBinderImpl;
import com.stepos.core.ability.AbilityInfo;
import com.stepos.core.ability.AbilityManager;
import com.stepos.core.ability.security.PermissionGuard;
import com.stepos.core.callback.IReleaseCallback;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.telemetry.b;
import com.stepos.core.data.base.Content;
import com.stepos.core.deepbinder.IAbilityDeepBinderService;
import com.stepos.core.deepbinder.IInferenceStreamCallback;
import com.stepos.core.deepbinder.IModelChangeListener;
import com.stepos.core.deepbinder.IReleaseListener;
import com.stepos.core.error.AIEngineError;
import com.stepos.core.model.manager.j;
import com.stepos.core.ota.d;
import com.stepos.deepbinder.core.api.IRecycle;
import com.stepos.deepbinder.core.entity.ext.CallerData;
import com.stepos.deepbinder.service.DeepBinderService;
import h0.e;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.g;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AbilityDeepBinderServiceImpl implements IAbilityDeepBinderService, IRecycle {
    private final String TAG;
    private final String abilityId;
    private final Object binderLock;
    private volatile AbilityBinderImpl cachedBinder;
    private volatile boolean recycled;
    private final ConcurrentHashMap<String, Pair<Integer, IReleaseCallback>> releaseAdapters;

    public AbilityDeepBinderServiceImpl(String abilityId) {
        g.f(abilityId, "abilityId");
        this.abilityId = abilityId;
        this.TAG = "AbilityDeepBinderSvcImpl";
        AbilityManager.INSTANCE.registerActiveImpl(abilityId, this);
        this.binderLock = new Object();
        this.releaseAdapters = new ConcurrentHashMap<>();
    }

    private final AbilityBinderImpl createBinderLocked(AbilityBinderImpl abilityBinderImpl) {
        Pair<Integer, Integer> pairResolveCaller = resolveCaller();
        int iIntValue = pairResolveCaller.f9985a.intValue();
        int iIntValue2 = pairResolveCaller.f9986b.intValue();
        AbilityManager abilityManager = AbilityManager.INSTANCE;
        AbilityBinderImpl binderByCallerAndAbility = abilityManager.getBinderByCallerAndAbility(iIntValue, iIntValue2, this.abilityId);
        if (abilityBinderImpl == null) {
            LogModule logModule = LogModule.IPC;
            String str = this.TAG;
            StringBuilder sbF = e.f("binderImpl lazy init: abilityId=", this.abilityId, ", callerUid=", iIntValue, ", callerPid=");
            sbF.append(iIntValue2);
            AIEngineLogger.d(logModule, str, sbF.toString());
            return binderByCallerAndAbility;
        }
        LogModule logModule2 = LogModule.IPC;
        String str2 = this.TAG;
        String str3 = this.abilityId;
        String token = abilityBinderImpl.getToken();
        String token2 = binderByCallerAndAbility.getToken();
        StringBuilder sbS = a.s("binderImpl REBUILT after hard release (reuse-after-release self-heal): abilityId=", str3, ", oldToken=", token, ", newToken=");
        d.o(iIntValue, token2, ", callerUid=", ", callerPid=", sbS);
        sbS.append(iIntValue2);
        AIEngineLogger.w(logModule2, str2, sbS.toString());
        try {
            abilityManager.registerActiveImpl(this.abilityId, this);
            n nVar = n.f10413a;
            return binderByCallerAndAbility;
        } catch (Throwable th) {
            c.a(th);
            return binderByCallerAndAbility;
        }
    }

    private final boolean enforceInfer() {
        return PermissionGuard.INSTANCE.checkInfer(Binder.getCallingUid(), Binder.getCallingPid());
    }

    private final AbilityBinderImpl getBinderImpl() {
        AbilityBinderImpl abilityBinderImplCreateBinderLocked;
        synchronized (this.binderLock) {
            abilityBinderImplCreateBinderLocked = this.cachedBinder;
            if (abilityBinderImplCreateBinderLocked == null) {
                abilityBinderImplCreateBinderLocked = createBinderLocked(null);
                this.cachedBinder = abilityBinderImplCreateBinderLocked;
            }
        }
        return abilityBinderImplCreateBinderLocked;
    }

    private final AbilityBinderImpl obtainBinderForNewOp() {
        synchronized (this.binderLock) {
            AbilityBinderImpl abilityBinderImpl = this.cachedBinder;
            if (abilityBinderImpl != null && !abilityBinderImpl.isHardReleased()) {
                return abilityBinderImpl;
            }
            this.recycled = false;
            AbilityBinderImpl abilityBinderImplCreateBinderLocked = createBinderLocked(abilityBinderImpl);
            this.cachedBinder = abilityBinderImplCreateBinderLocked;
            return abilityBinderImplCreateBinderLocked;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0024 A[PHI: r2
      0x0024: PHI (r2v7 java.lang.Integer) = (r2v1 java.lang.Integer), (r2v9 java.lang.Integer) binds: [B:21:0x0035, B:15:0x0022] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final kotlin.Pair<java.lang.Integer, java.lang.Integer> resolveCaller() {
        /*
            r3 = this;
            com.stepos.deepbinder.service.DeepBinderService r3 = com.stepos.deepbinder.service.DeepBinderService.INSTANCE     // Catch: java.lang.Throwable -> L7
            com.stepos.deepbinder.core.entity.ext.CallerData r3 = r3.getCurrentCallerData()     // Catch: java.lang.Throwable -> L7
            goto Lc
        L7:
            r3 = move-exception
            kotlin.Result$Failure r3 = kotlin.c.a(r3)
        Lc:
            boolean r0 = r3 instanceof kotlin.Result.Failure
            r1 = 0
            if (r0 == 0) goto L12
            r3 = r1
        L12:
            com.stepos.deepbinder.core.entity.ext.CallerData r3 = (com.stepos.deepbinder.core.entity.ext.CallerData) r3
            if (r3 == 0) goto L29
            int r0 = r3.getUid()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            if (r0 <= 0) goto L21
            goto L22
        L21:
            r2 = r1
        L22:
            if (r2 == 0) goto L29
        L24:
            int r0 = r2.intValue()
            goto L3c
        L29:
            int r0 = android.os.Binder.getCallingUid()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            if (r0 <= 0) goto L34
            goto L35
        L34:
            r2 = r1
        L35:
            if (r2 == 0) goto L38
            goto L24
        L38:
            int r0 = android.os.Process.myUid()
        L3c:
            if (r3 == 0) goto L51
            int r3 = r3.getPid()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            if (r3 <= 0) goto L49
            goto L4a
        L49:
            r2 = r1
        L4a:
            if (r2 == 0) goto L51
            int r3 = r2.intValue()
            goto L67
        L51:
            int r3 = android.os.Binder.getCallingPid()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            if (r3 <= 0) goto L5c
            r1 = r2
        L5c:
            if (r1 == 0) goto L63
            int r3 = r1.intValue()
            goto L67
        L63:
            int r3 = android.os.Process.myPid()
        L67:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            kotlin.Pair r1 = new kotlin.Pair
            r1.<init>(r0, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.deepbinder.AbilityDeepBinderServiceImpl.resolveCaller():kotlin.Pair");
    }

    @Override // com.stepos.core.deepbinder.IAbilityDeepBinderService
    public boolean acquire() {
        if (!enforceInfer()) {
            return false;
        }
        if (!AbilityManager.INSTANCE.containsAbility(this.abilityId)) {
            a.w("acquire rejected: ability not registered: ", this.abilityId, LogModule.IPC, this.TAG);
            return false;
        }
        AIEngineLogger.d(LogModule.IPC, this.TAG, "acquire: " + this.abilityId);
        return AbilityBinderImpl.handleAcquire$default(obtainBinderForNewOp(), 0L, 1, null);
    }

    @Override // com.stepos.core.deepbinder.IAbilityDeepBinderService
    public boolean cancel() {
        if (!enforceInfer()) {
            return false;
        }
        AIEngineLogger.d(LogModule.IPC, this.TAG, "cancel: " + this.abilityId);
        return getBinderImpl().handleCancel();
    }

    @Override // com.stepos.core.deepbinder.IAbilityDeepBinderService
    public boolean cancelInfer(String inferId) {
        g.f(inferId, "inferId");
        if (!enforceInfer()) {
            return false;
        }
        AIEngineLogger.d(LogModule.IPC, this.TAG, a.l("cancelInfer: inferId=", inferId, ", abilityId=", this.abilityId));
        return getBinderImpl().handleCancelInfer(inferId);
    }

    @Override // com.stepos.core.deepbinder.IAbilityDeepBinderService
    public void completeInput(String inferId) {
        g.f(inferId, "inferId");
        if (enforceInfer()) {
            AIEngineLogger.d(LogModule.IPC, this.TAG, a.l("completeInput: inferId=", inferId, ", abilityId=", this.abilityId));
            getBinderImpl().handleCompleteInput(inferId);
        }
    }

    @Override // com.stepos.core.deepbinder.IAbilityDeepBinderService
    public Content execute(String action, Content content) {
        g.f(action, "action");
        if (!enforceInfer()) {
            return null;
        }
        AIEngineLogger.d(LogModule.IPC, this.TAG, a.l("execute: action=", action, ", abilityId=", this.abilityId));
        return getBinderImpl().handleExecute(action, content);
    }

    @Override // com.stepos.core.deepbinder.IAbilityDeepBinderService
    public void feedInput(String inferId, Content input) {
        g.f(inferId, "inferId");
        g.f(input, "input");
        if (enforceInfer()) {
            AIEngineLogger.d(LogModule.IPC, this.TAG, a.l("feedInput: inferId=", inferId, ", abilityId=", this.abilityId));
            getBinderImpl().handleFeedInput(inferId, input);
        }
    }

    @Override // com.stepos.core.deepbinder.IAbilityDeepBinderService
    public AbilityInfo getInfo() {
        if (enforceInfer()) {
            return getBinderImpl().getInfo();
        }
        return null;
    }

    @Override // com.stepos.core.deepbinder.IAbilityDeepBinderService
    public void infer(String inferId, Content input, IInferenceStreamCallback callback) throws Throwable {
        g.f(inferId, "inferId");
        g.f(input, "input");
        g.f(callback, "callback");
        if (!enforceInfer()) {
            AIEngineLogger.w(LogModule.IPC, this.TAG, a.l("infer: permission denied, abilityId=", this.abilityId, ", inferId=", inferId));
            callback.onError(inferId, AIEngineError.PERMISSION_DENIED, "Permission denied");
            return;
        }
        if (!AbilityManager.INSTANCE.containsAbility(this.abilityId)) {
            AIEngineLogger.w(LogModule.IPC, this.TAG, a.l("infer rejected: ability not registered: ", this.abilityId, ", inferId=", inferId));
            callback.onError(inferId, AIEngineError.ABILITY_NOT_REGISTERED, "Ability not registered: " + this.abilityId);
            return;
        }
        LogModule logModule = LogModule.IPC;
        String str = this.TAG;
        String str2 = this.abilityId;
        int iIdentityHashCode = System.identityHashCode(this);
        String simpleName = input.getClass().getSimpleName();
        int type = input.getType();
        StringBuilder sbS = a.s("================ [CHAT-IPC-IN] ================\nabilityId=", str2, ", inferId=", inferId, ", svc=");
        e.h(iIdentityHashCode, "\ninputClass=", simpleName, ", contentType=", sbS);
        sbS.append(type);
        sbS.append("\n==============================================");
        AIEngineLogger.i(logModule, str, sbS.toString());
        AbilityBinderImpl abilityBinderImplObtainBinderForNewOp = obtainBinderForNewOp();
        DeepBinderCallbackAdapter deepBinderCallbackAdapter = new DeepBinderCallbackAdapter(inferId, callback, abilityBinderImplObtainBinderForNewOp);
        abilityBinderImplObtainBinderForNewOp.onInferStart(inferId);
        abilityBinderImplObtainBinderForNewOp.handleInfer(inferId, input, deepBinderCallbackAdapter);
    }

    @Override // com.stepos.core.deepbinder.IAbilityDeepBinderService
    public int inferSync(String inferId, Content input, IInferenceStreamCallback callback) {
        g.f(inferId, "inferId");
        g.f(input, "input");
        g.f(callback, "callback");
        if (!enforceInfer()) {
            AIEngineLogger.w(LogModule.IPC, this.TAG, a.l("inferSync: permission denied, abilityId=", this.abilityId, ", inferId=", inferId));
            return AIEngineError.PERMISSION_DENIED;
        }
        if (!AbilityManager.INSTANCE.containsAbility(this.abilityId)) {
            AIEngineLogger.w(LogModule.IPC, this.TAG, a.l("inferSync rejected: ability not registered: ", this.abilityId, ", inferId=", inferId));
            return AIEngineError.ABILITY_NOT_REGISTERED;
        }
        LogModule logModule = LogModule.IPC;
        String str = this.TAG;
        String str2 = this.abilityId;
        int iIdentityHashCode = System.identityHashCode(this);
        String simpleName = input.getClass().getSimpleName();
        int type = input.getType();
        StringBuilder sbS = a.s("============ [CHAT-IPC-IN-SYNC] ============\nabilityId=", str2, ", inferId=", inferId, ", svc=");
        e.h(iIdentityHashCode, "\ninputClass=", simpleName, ", contentType=", sbS);
        sbS.append(type);
        sbS.append("\n→ capture caller + async submit, ack=SUCCESS\n===========================================");
        AIEngineLogger.i(logModule, str, sbS.toString());
        AbilityBinderImpl abilityBinderImplObtainBinderForNewOp = obtainBinderForNewOp();
        DeepBinderCallbackAdapter deepBinderCallbackAdapter = new DeepBinderCallbackAdapter(inferId, callback, abilityBinderImplObtainBinderForNewOp);
        CallerData currentCallerData = DeepBinderService.INSTANCE.getCurrentCallerData();
        abilityBinderImplObtainBinderForNewOp.onInferStart(inferId);
        abilityBinderImplObtainBinderForNewOp.submitInferAsync(inferId, input, deepBinderCallbackAdapter, currentCallerData);
        String str3 = this.TAG;
        StringBuilder sbS2 = a.s("inferSync: ACCEPTED abilityId=", this.abilityId, ", inferId=", inferId, ", caller=");
        sbS2.append(currentCallerData);
        AIEngineLogger.i(logModule, str3, sbS2.toString());
        return 0;
    }

    @Override // com.stepos.deepbinder.core.api.IRecycle
    public void onRecycle() {
        AIEngineLogger.w(LogModule.IPC, this.TAG, d.h("▶▶ [DIAG] onRecycle CALLED: abilityId=", System.identityHashCode(this), this.abilityId, ", svc="), new Throwable("onRecycle stacktrace"));
        synchronized (this.binderLock) {
            this.recycled = true;
            try {
                AbilityBinderImpl abilityBinderImpl = this.cachedBinder;
                if (abilityBinderImpl != null) {
                    AbilityManager.releaseAbility$default(AbilityManager.INSTANCE, abilityBinderImpl.getToken(), false, ModelReleaseReason.f6323d, 2, null);
                    n nVar = n.f10413a;
                }
            } catch (Throwable th) {
                c.a(th);
            }
        }
        Set<String> setKeySet = this.releaseAdapters.keySet();
        g.e(setKeySet, "<get-keys>(...)");
        for (String str : kotlin.collections.a.O0(setKeySet)) {
            g.c(str);
            unregisterReleaseListener(str);
        }
        try {
            AbilityManager.INSTANCE.unregisterActiveImpl(this);
            n nVar2 = n.f10413a;
        } catch (Throwable th2) {
            c.a(th2);
        }
    }

    @Override // com.stepos.core.deepbinder.IAbilityDeepBinderService
    public void registerModelChangeListener(String listenerId, IModelChangeListener listener) {
        g.f(listenerId, "listenerId");
        g.f(listener, "listener");
        if (enforceInfer()) {
            ConcurrentHashMap<String, ConcurrentHashMap<String, IModelChangeListener>> concurrentHashMap = f7.c.f8774a;
            String abilityId = this.abilityId;
            g.f(abilityId, "abilityId");
            ConcurrentHashMap<String, IModelChangeListener> concurrentHashMapComputeIfAbsent = f7.c.f8774a.computeIfAbsent(abilityId, new j(new b(24), 2));
            g.e(concurrentHashMapComputeIfAbsent, "computeIfAbsent(...)");
            ConcurrentHashMap<String, IModelChangeListener> concurrentHashMap2 = concurrentHashMapComputeIfAbsent;
            IModelChangeListener iModelChangeListenerPut = concurrentHashMap2.put(listenerId, listener);
            if (iModelChangeListenerPut != null && iModelChangeListenerPut != listener) {
                try {
                    iModelChangeListenerPut.onRecycle();
                } catch (Exception e10) {
                    String message = e10.getMessage();
                    StringBuilder sbS = a.s("register: old listener onRecycle failed for ", abilityId, "/", listenerId, ": ");
                    sbS.append(message);
                    Log.w("ModelChangeBroadcaster", sbS.toString());
                }
            }
            int size = concurrentHashMap2.size();
            StringBuilder sbS2 = a.s("register: abilityId=", abilityId, " listenerId=", listenerId, " (total=");
            sbS2.append(size);
            sbS2.append(")");
            Log.d("ModelChangeBroadcaster", sbS2.toString());
            AIEngineLogger.i(LogModule.IPC, this.TAG, a.l("registerModelChangeListener: abilityId=", this.abilityId, " listenerId=", listenerId));
        }
    }

    @Override // com.stepos.core.deepbinder.IAbilityDeepBinderService
    public void registerReleaseListener(final String listenerId, final IReleaseListener listener) {
        g.f(listenerId, "listenerId");
        g.f(listener, "listener");
        if (enforceInfer()) {
            int iIntValue = resolveCaller().f9985a.intValue();
            IReleaseCallback.Stub stub = new IReleaseCallback.Stub() { // from class: com.stepos.core.ability.deepbinder.AbilityDeepBinderServiceImpl$registerReleaseListener$adapter$1
                @Override // com.stepos.core.callback.IReleaseCallback
                public void onReleased(String str, int i10, String str2) {
                    Object objA;
                    IReleaseListener iReleaseListener = listener;
                    if (str == null) {
                        str = "";
                    }
                    if (str2 == null) {
                        str2 = "";
                    }
                    try {
                        iReleaseListener.onReleased(str, i10, str2);
                        objA = n.f10413a;
                    } catch (Throwable th) {
                        objA = c.a(th);
                    }
                    AbilityDeepBinderServiceImpl abilityDeepBinderServiceImpl = this;
                    String str3 = listenerId;
                    if (Result.b(objA) != null) {
                        a.w("release listener dead, auto-unregister: listenerId=", str3, LogModule.IPC, abilityDeepBinderServiceImpl.TAG);
                        abilityDeepBinderServiceImpl.unregisterReleaseListener(str3);
                    }
                }
            };
            Pair<Integer, IReleaseCallback> pairPut = this.releaseAdapters.put(listenerId, new Pair<>(Integer.valueOf(iIntValue), stub));
            if (pairPut != null) {
                int iIntValue2 = pairPut.f9985a.intValue();
                IReleaseCallback iReleaseCallback = pairPut.f9986b;
                d6.c.f8388a.getClass();
                d6.c.c(iReleaseCallback, iIntValue2);
            }
            d6.c.f8388a.b(stub, iIntValue);
            LogModule logModule = LogModule.IPC;
            String str = this.TAG;
            StringBuilder sbS = a.s("registerReleaseListener: abilityId=", this.abilityId, " listenerId=", listenerId, " uid=");
            sbS.append(iIntValue);
            AIEngineLogger.i(logModule, str, sbS.toString());
        }
    }

    @Override // com.stepos.core.deepbinder.IAbilityDeepBinderService
    public void release() {
        if (enforceInfer()) {
            AIEngineLogger.d(LogModule.IPC, this.TAG, "release(hard): " + this.abilityId);
            synchronized (this.binderLock) {
                AbilityBinderImpl abilityBinderImpl = this.cachedBinder;
                if (abilityBinderImpl != null) {
                    AbilityManager.releaseAbility$default(AbilityManager.INSTANCE, abilityBinderImpl.getToken(), true, null, 4, null);
                    n nVar = n.f10413a;
                }
            }
            try {
                AbilityManager.INSTANCE.unregisterActiveImpl(this);
                n nVar2 = n.f10413a;
            } catch (Throwable th) {
                c.a(th);
            }
        }
    }

    @Override // com.stepos.core.deepbinder.IAbilityDeepBinderService
    public void unregisterModelChangeListener(String listenerId) {
        g.f(listenerId, "listenerId");
        if (enforceInfer()) {
            ConcurrentHashMap<String, ConcurrentHashMap<String, IModelChangeListener>> concurrentHashMap = f7.c.f8774a;
            String abilityId = this.abilityId;
            g.f(abilityId, "abilityId");
            ConcurrentHashMap<String, ConcurrentHashMap<String, IModelChangeListener>> concurrentHashMap2 = f7.c.f8774a;
            ConcurrentHashMap<String, IModelChangeListener> concurrentHashMap3 = concurrentHashMap2.get(abilityId);
            if (concurrentHashMap3 != null) {
                concurrentHashMap3.remove(listenerId);
                if (concurrentHashMap3.isEmpty()) {
                    concurrentHashMap2.remove(abilityId);
                }
                Log.d("ModelChangeBroadcaster", "unregister: abilityId=" + abilityId + " listenerId=" + listenerId);
            }
            AIEngineLogger.i(LogModule.IPC, this.TAG, a.l("unregisterModelChangeListener: abilityId=", this.abilityId, " listenerId=", listenerId));
        }
    }

    @Override // com.stepos.core.deepbinder.IAbilityDeepBinderService
    public void unregisterReleaseListener(String listenerId) {
        g.f(listenerId, "listenerId");
        Pair<Integer, IReleaseCallback> pairRemove = this.releaseAdapters.remove(listenerId);
        if (pairRemove == null) {
            return;
        }
        int iIntValue = pairRemove.f9985a.intValue();
        IReleaseCallback iReleaseCallback = pairRemove.f9986b;
        d6.c.f8388a.getClass();
        d6.c.c(iReleaseCallback, iIntValue);
        LogModule logModule = LogModule.IPC;
        String str = this.TAG;
        StringBuilder sbS = a.s("unregisterReleaseListener: abilityId=", this.abilityId, " listenerId=", listenerId, " uid=");
        sbS.append(iIntValue);
        AIEngineLogger.i(logModule, str, sbS.toString());
    }
}
