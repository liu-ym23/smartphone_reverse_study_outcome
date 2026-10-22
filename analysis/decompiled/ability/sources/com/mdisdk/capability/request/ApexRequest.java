package com.mdisdk.capability.request;

import B7.a;
import C7.r;
import D7.v;
import J7.c;
import S7.n;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.core.JsonPointer;
import com.mdisdk.base.ALog;
import com.mdisdk.capability.aidl.IGrabNodeCallback;
import com.mdisdk.capability.model.RequestInfo;
import com.mdisdk.capability.model.ResultInfo;
import com.mdisdk.capability.model.WindowStateInfo;
import com.mdisdk.capability.request.ApexResult;
import com.mdisdk.capability.thirdpart.RequestMain;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.C1724q;
import m9.InterfaceC1723p;
import m9.InterfaceC1733z;
import m9.c0;
import v7.o;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 $2\u00020\u0001:\u0002$%B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\"\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0086@¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\"\u001a\u00060!R\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/mdisdk/capability/request/ApexRequest;", "", "Landroid/content/Context;", "context", AppAgent.CONSTRUCT, "(Landroid/content/Context;)V", "Lcom/mdisdk/capability/model/RequestInfo;", "requestInfo", "Lcom/mdisdk/capability/request/ApexResult;", "executeRequest", "(Lcom/mdisdk/capability/model/RequestInfo;LH7/c;)Ljava/lang/Object;", "Landroid/content/Intent;", "buildRequestIntent", "(Lcom/mdisdk/capability/model/RequestInfo;)Landroid/content/Intent;", "Landroid/os/Bundle;", "generateBasicBundle", "()Landroid/os/Bundle;", "LC7/r;", "cancelPendingRequest", "()V", "cleanup", "", "timeoutMillis", "request", "(Lcom/mdisdk/capability/model/RequestInfo;JLH7/c;)Ljava/lang/Object;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "runningRequest", "Lcom/mdisdk/capability/model/RequestInfo;", "Lm9/p;", "pendingResult", "Lm9/p;", "Lcom/mdisdk/capability/request/ApexRequest$ApexCallback;", "callbackBinder", "Lcom/mdisdk/capability/request/ApexRequest$ApexCallback;", "Companion", "ApexCallback", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ApexRequest {
    private static final long DEFAULT_TIMEOUT_MS = 2000;
    private static final String TAG = "ApexRequest";
    private final ApexCallback callbackBinder;
    private final Context context;
    private InterfaceC1723p pendingResult;
    private volatile RequestInfo runningRequest;

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\rJ!\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R2\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u00180\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0013R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010 ¨\u0006\""}, d2 = {"Lcom/mdisdk/capability/request/ApexRequest$ApexCallback;", "Lcom/mdisdk/capability/aidl/IGrabNodeCallback$Stub;", AppAgent.CONSTRUCT, "(Lcom/mdisdk/capability/request/ApexRequest;)V", "Landroid/content/Intent;", "intent", "", "resultCode", "LC7/r;", "parseAndStoreWindow", "(Landroid/content/Intent;I)V", "Lcom/mdisdk/capability/request/ApexResult;", "buildApexResult", "()Lcom/mdisdk/capability/request/ApexResult;", "buildSnapshotResult", "result", "onGrabNodeCallback", "(ILandroid/content/Intent;)V", "maxWindowCount", "I", "callbackCount", "", "Ljava/util/ArrayList;", "Lcom/mdisdk/capability/model/WindowStateInfo;", "Lkotlin/collections/ArrayList;", "windows", "Ljava/util/Map;", "lastResultCode", "firstSuccessResultCode", "Ljava/lang/Integer;", "", "hasSuccessResult", "Z", "isCompleted", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ApexCallback extends IGrabNodeCallback.Stub {
        private int callbackCount;
        private Integer firstSuccessResultCode;
        private boolean hasSuccessResult;
        private boolean isCompleted;
        private int maxWindowCount = -1;
        private Map<Integer, ArrayList<WindowStateInfo>> windows = new LinkedHashMap();
        private int lastResultCode = -1;

        public ApexCallback() {
        }

        private final ApexResult buildApexResult() {
            RequestInfo requestInfo = ApexRequest.this.runningRequest;
            if (requestInfo == null) {
                return ApexResult.Companion.error$default(ApexResult.INSTANCE, "No running request", null, 2, null);
            }
            String function = requestInfo.getFunction();
            StringBuilder sbV = a.v("[BUILD_RESULT] function=", function, ", hasSuccessResult=");
            sbV.append(this.hasSuccessResult);
            sbV.append(", lastResultCode=");
            sbV.append(this.lastResultCode);
            sbV.append(", firstSuccessResultCode=");
            sbV.append(this.firstSuccessResultCode);
            ALog.d$default(ApexRequest.TAG, sbV.toString(), null, 4, null);
            if (k.b(function, RequestInfo.FUNCTION_SNAPSHOT)) {
                if (!this.windows.isEmpty()) {
                    return buildSnapshotResult();
                }
                ALog.w$default(ApexRequest.TAG, "[BUILD_RESULT] Snapshot failed: no window data received", null, 4, null);
                return ApexResult.Companion.error$default(ApexResult.INSTANCE, "No window data received for snapshot", null, 2, null);
            }
            if (this.hasSuccessResult) {
                ALog.d$default(ApexRequest.TAG, a.m("[BUILD_RESULT] Action '", function, "' succeeded"), null, 4, null);
                ApexResult.Companion companion = ApexResult.INSTANCE;
                k.c(function);
                return companion.action(function, "Action '" + function + "' completed successfully");
            }
            StringBuilder sbV2 = a.v("[BUILD_RESULT] Action '", function, "' failed with lastResultCode=");
            sbV2.append(this.lastResultCode);
            ALog.w$default(ApexRequest.TAG, sbV2.toString(), null, 4, null);
            ApexResult.Companion companion2 = ApexResult.INSTANCE;
            StringBuilder sbV3 = a.v("Action '", function, "' failed with resultCode=");
            sbV3.append(this.lastResultCode);
            return ApexResult.Companion.error$default(companion2, sbV3.toString(), null, 2, null);
        }

        private final ApexResult buildSnapshotResult() {
            String activityClassName;
            String packageName;
            Map<Integer, ArrayList<WindowStateInfo>> map = this.windows;
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry<Integer, ArrayList<WindowStateInfo>> entry : map.entrySet()) {
                int iIntValue = entry.getKey().intValue();
                ArrayList<WindowStateInfo> value = entry.getValue();
                WindowStateInfo windowStateInfo = (WindowStateInfo) v.D0(0, value);
                String str = (windowStateInfo == null || (packageName = windowStateInfo.getPackageName()) == null) ? "" : packageName;
                WindowStateInfo windowStateInfo2 = (WindowStateInfo) v.D0(0, value);
                arrayList.add(new DisplaySnapshot(iIntValue, true, str, (windowStateInfo2 == null || (activityClassName = windowStateInfo2.getActivityClassName()) == null) ? "" : activityClassName, value, null, 32, null));
            }
            UiSnapshot uiSnapshot = new UiSnapshot(arrayList);
            ALog.d$default(ApexRequest.TAG, "Built UiSnapshot with " + arrayList.size() + " displays, " + this.windows.size() + " windows", null, 4, null);
            return ApexResult.INSTANCE.snapshot(uiSnapshot);
        }

        private final void parseAndStoreWindow(Intent intent, int resultCode) {
            Integer displayId;
            Bundle extras = intent.getExtras();
            if (extras == null) {
                ALog.w$default(ApexRequest.TAG, ">>> [parse] extras is NULL — callbackCount already incremented!", null, 4, null);
                return;
            }
            ResultInfo resultInfo = (ResultInfo) extras.getParcelable("result");
            if (resultInfo == null) {
                ALog.w$default(ApexRequest.TAG, ">>> [parse] ResultInfo is NULL — callbackCount incremented but hasSuccessResult NOT updated!", null, 4, null);
                return;
            }
            RequestInfo requestInfo = ApexRequest.this.runningRequest;
            if (requestInfo == null || resultInfo.getRequestId() != requestInfo.getRequestId()) {
                StringBuilder sb = new StringBuilder(">>> [parse] RequestId MISMATCH: expected=");
                RequestInfo requestInfo2 = ApexRequest.this.runningRequest;
                sb.append(requestInfo2 != null ? Long.valueOf(requestInfo2.getRequestId()) : null);
                sb.append(", got=");
                sb.append(resultInfo.getRequestId());
                sb.append(" — callbackCount incremented but hasSuccessResult NOT updated!");
                ALog.w$default(ApexRequest.TAG, sb.toString(), null, 4, null);
                return;
            }
            int resultCode2 = resultInfo.getResultCode();
            RequestInfo requestInfo3 = ApexRequest.this.runningRequest;
            String function = requestInfo3 != null ? requestInfo3.getFunction() : null;
            StringBuilder sbT = androidx.appfunctions.metadata.a.t(resultCode2, "ResultInfo: function=", function, ", currentResultCode=", ", hasSuccessResult=");
            sbT.append(this.hasSuccessResult);
            sbT.append(", callbackCount=");
            sbT.append(this.callbackCount);
            sbT.append(JsonPointer.SEPARATOR);
            sbT.append(this.maxWindowCount);
            ALog.d$default(ApexRequest.TAG, sbT.toString(), null, 4, null);
            boolean zB = k.b(function, RequestInfo.FUNCTION_SNAPSHOT);
            if (!zB) {
                if (this.hasSuccessResult) {
                    ALog.d$default(ApexRequest.TAG, "[SKIP] Already has success result (firstSuccessResultCode=" + this.firstSuccessResultCode + "), skipping this callback with resultCode=" + resultCode2, null, 4, null);
                    return;
                }
                if (resultCode2 == 0) {
                    this.hasSuccessResult = true;
                    this.firstSuccessResultCode = Integer.valueOf(resultCode2);
                    ALog.d$default(ApexRequest.TAG, a.m("[SUCCESS] Function '", function, "' succeeded on this window, subsequent errors from other windows will be ignored"), null, 4, null);
                } else {
                    ALog.d$default(ApexRequest.TAG, androidx.constraintlayout.core.dsl.a.d(resultCode2, "[PENDING] Function '", function, "' failed on this window (resultCode=", "), waiting for other windows..."), null, 4, null);
                }
            }
            this.lastResultCode = resultCode2;
            WindowStateInfo windowStateInfo = resultInfo.getWindowStateInfo();
            if (windowStateInfo == null) {
                ALog.w$default(ApexRequest.TAG, "WindowStateInfo is null in result", null, 4, null);
                return;
            }
            RequestInfo requestInfo4 = ApexRequest.this.runningRequest;
            int iIntValue = (requestInfo4 == null || (displayId = requestInfo4.getDisplayId()) == null) ? 0 : displayId.intValue();
            Map<Integer, ArrayList<WindowStateInfo>> map = this.windows;
            Integer numValueOf = Integer.valueOf(iIntValue);
            ArrayList<WindowStateInfo> arrayList = map.get(numValueOf);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                map.put(numValueOf, arrayList);
            }
            arrayList.add(windowStateInfo);
            ALog.d$default(ApexRequest.TAG, "Stored window for display " + iIntValue + ": " + windowStateInfo.getPackageName() + ", windowType=" + windowStateInfo.getWindowType(), null, 4, null);
            if (zB) {
                this.hasSuccessResult = true;
            }
        }

        @Override // com.mdisdk.capability.aidl.IGrabNodeCallback
        public synchronized void onGrabNodeCallback(int result, Intent intent) {
            if (this.isCompleted) {
                ALog.d$default(ApexRequest.TAG, ">>> [CB] already completed, ignoring. rawResult=" + result, null, 4, null);
                return;
            }
            this.callbackCount++;
            ALog.d$default(ApexRequest.TAG, ">>> [CB#" + this.callbackCount + "] rawResult=" + result + "  maxWindowCount=" + this.maxWindowCount + "  hasSuccess=" + this.hasSuccessResult, null, 4, null);
            if (intent == null) {
                ALog.w$default(ApexRequest.TAG, ">>> [CB#" + this.callbackCount + "] intent is NULL — callbackCount incremented but no result processed!", null, 4, null);
                return;
            }
            intent.setExtrasClassLoader(ResultInfo.class.getClassLoader());
            if (this.maxWindowCount <= -1) {
                this.maxWindowCount = intent.getIntExtra("window_count", 1);
                ALog.d$default(ApexRequest.TAG, ">>> [CB#" + this.callbackCount + "] maxWindowCount read from intent = " + this.maxWindowCount, null, 4, null);
            }
            parseAndStoreWindow(intent, result);
            RequestInfo requestInfo = ApexRequest.this.runningRequest;
            if (!k.b(requestInfo != null ? requestInfo.getFunction() : null, RequestInfo.FUNCTION_SNAPSHOT) && this.hasSuccessResult) {
                ALog.d$default(ApexRequest.TAG, ">>> [CB#" + this.callbackCount + "] non-snapshot SUCCESS → completing immediately", null, 4, null);
                this.isCompleted = true;
                InterfaceC1723p interfaceC1723p = ApexRequest.this.pendingResult;
                if (interfaceC1723p != null) {
                    ((C1724q) interfaceC1723p).U(buildApexResult());
                }
            } else if (this.callbackCount >= this.maxWindowCount) {
                ALog.d$default(ApexRequest.TAG, ">>> [CB#" + this.callbackCount + "] all " + this.maxWindowCount + " windows received → completing. hasSuccess=" + this.hasSuccessResult, null, 4, null);
                this.isCompleted = true;
                InterfaceC1723p interfaceC1723p2 = ApexRequest.this.pendingResult;
                if (interfaceC1723p2 != null) {
                    ((C1724q) interfaceC1723p2).U(buildApexResult());
                }
            } else {
                ALog.d$default(ApexRequest.TAG, ">>> [CB#" + this.callbackCount + "] still waiting (" + this.callbackCount + " / " + this.maxWindowCount + "), hasSuccess=" + this.hasSuccessResult, null, 4, null);
            }
        }
    }

    @c(c = "com.mdisdk.capability.request.ApexRequest", f = "ApexRequest.kt", l = {133}, m = "executeRequest")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.mdisdk.capability.request.ApexRequest$executeRequest$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexRequest.this.executeRequest(null, this);
        }
    }

    @c(c = "com.mdisdk.capability.request.ApexRequest", f = "ApexRequest.kt", l = {102}, m = "request")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.mdisdk.capability.request.ApexRequest$request$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10221 extends ContinuationImpl {
        long J$0;
        int label;
        /* synthetic */ Object result;

        public C10221(H7.c<? super C10221> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexRequest.this.request(null, 0L, this);
        }
    }

    @c(c = "com.mdisdk.capability.request.ApexRequest$request$2", f = "ApexRequest.kt", l = {o.META_DATA_FIELD_NUMBER}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Lcom/mdisdk/capability/request/ApexResult;", "<anonymous>", "(Lm9/z;)Lcom/mdisdk/capability/request/ApexResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.mdisdk.capability.request.ApexRequest$request$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ RequestInfo $requestInfo;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(RequestInfo requestInfo, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$requestInfo = requestInfo;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return ApexRequest.this.new AnonymousClass2(this.$requestInfo, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
                return obj;
            }
            b.b(obj);
            ApexRequest apexRequest = ApexRequest.this;
            RequestInfo requestInfo = this.$requestInfo;
            this.label = 1;
            Object objExecuteRequest = apexRequest.executeRequest(requestInfo, this);
            return objExecuteRequest == coroutineSingletons ? coroutineSingletons : objExecuteRequest;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super ApexResult> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public ApexRequest(Context context) {
        k.f(context, "context");
        this.context = context;
        this.callbackBinder = new ApexCallback();
    }

    private final Intent buildRequestIntent(RequestInfo requestInfo) {
        Bundle bundleGenerateBasicBundle = generateBasicBundle();
        Intent intent = new Intent();
        intent.putExtras(bundleGenerateBasicBundle);
        intent.putExtra("requestInfo", requestInfo);
        intent.putExtra("targetWindowTitle", requestInfo.getWindowTitle());
        intent.putExtra("targetFindPackage", requestInfo.getPackageName());
        return intent;
    }

    private final void cancelPendingRequest() {
        c0 c0Var = this.pendingResult;
        if (c0Var != null) {
            ((kotlinx.coroutines.c) c0Var).cancel(null);
        }
        cleanup();
    }

    private final void cleanup() {
        this.runningRequest = null;
        this.pendingResult = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object executeRequest(com.mdisdk.capability.model.RequestInfo r7, H7.c<? super com.mdisdk.capability.request.ApexResult> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.mdisdk.capability.request.ApexRequest.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            com.mdisdk.capability.request.ApexRequest$executeRequest$1 r0 = (com.mdisdk.capability.request.ApexRequest.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.mdisdk.capability.request.ApexRequest$executeRequest$1 r0 = new com.mdisdk.capability.request.ApexRequest$executeRequest$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.b.b(r8)     // Catch: java.lang.Throwable -> L27
            goto L82
        L27:
            r7 = move-exception
            goto L86
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            kotlin.b.b(r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r2 = "Execute request: id="
            r8.<init>(r2)
            long r4 = r7.getRequestId()
            r8.append(r4)
            java.lang.String r2 = ", function="
            r8.append(r2)
            java.lang.String r2 = r7.getFunction()
            r8.append(r2)
            java.lang.String r2 = ", package="
            r8.append(r2)
            java.lang.String r2 = r7.getPackageName()
            r8.append(r2)
            java.lang.String r8 = r8.toString()
            r2 = 4
            java.lang.String r4 = "ApexRequest"
            r5 = 0
            com.mdisdk.base.ALog.d$default(r4, r8, r5, r2, r5)
            m9.q r8 = new m9.q
            r8.<init>()
            r6.pendingResult = r8
            r6.runningRequest = r7
            android.content.Intent r7 = r6.buildRequestIntent(r7)     // Catch: java.lang.Throwable -> L27
            com.mdisdk.capability.framework.IFrameworkBridge r2 = com.mdisdk.capability.framework.FrameworkBridgeFactory.get()     // Catch: java.lang.Throwable -> L27
            r2.apexRequest(r7)     // Catch: java.lang.Throwable -> L27
            r0.label = r3     // Catch: java.lang.Throwable -> L27
            java.lang.Object r8 = r8.z(r0)     // Catch: java.lang.Throwable -> L27
            if (r8 != r1) goto L82
            return r1
        L82:
            r6.cleanup()
            return r8
        L86:
            r6.cleanup()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mdisdk.capability.request.ApexRequest.executeRequest(com.mdisdk.capability.model.RequestInfo, H7.c):java.lang.Object");
    }

    private final Bundle generateBasicBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("targetDexPackage", this.context.getPackageName());
        bundle.putString("targetDexClass", RequestMain.class.getName());
        bundle.putString("targetDexMethod", "handleApexRequest");
        bundle.putBinder("targetDexBinder", this.callbackBinder.asBinder());
        return bundle;
    }

    public static /* synthetic */ Object request$default(ApexRequest apexRequest, RequestInfo requestInfo, long j5, H7.c cVar, int i, Object obj) {
        if ((i & 2) != 0) {
            j5 = DEFAULT_TIMEOUT_MS;
        }
        return apexRequest.request(requestInfo, j5, cVar);
    }

    public final Context getContext() {
        return this.context;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object request(com.mdisdk.capability.model.RequestInfo r6, long r7, H7.c<? super com.mdisdk.capability.request.ApexResult> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.mdisdk.capability.request.ApexRequest.C10221
            if (r0 == 0) goto L13
            r0 = r9
            com.mdisdk.capability.request.ApexRequest$request$1 r0 = (com.mdisdk.capability.request.ApexRequest.C10221) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.mdisdk.capability.request.ApexRequest$request$1 r0 = new com.mdisdk.capability.request.ApexRequest$request$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            java.lang.String r3 = "ApexRequest"
            r4 = 1
            if (r2 == 0) goto L37
            if (r2 != r4) goto L2f
            long r7 = r0.J$0
            kotlin.b.b(r9)     // Catch: java.lang.Exception -> L2b kotlinx.coroutines.TimeoutCancellationException -> L2d
            goto L4b
        L2b:
            r6 = move-exception
            goto L4e
        L2d:
            r6 = move-exception
            goto L5f
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.b.b(r9)
            com.mdisdk.capability.request.ApexRequest$request$2 r9 = new com.mdisdk.capability.request.ApexRequest$request$2     // Catch: java.lang.Exception -> L2b kotlinx.coroutines.TimeoutCancellationException -> L2d
            r2 = 0
            r9.<init>(r6, r2)     // Catch: java.lang.Exception -> L2b kotlinx.coroutines.TimeoutCancellationException -> L2d
            r0.J$0 = r7     // Catch: java.lang.Exception -> L2b kotlinx.coroutines.TimeoutCancellationException -> L2d
            r0.label = r4     // Catch: java.lang.Exception -> L2b kotlinx.coroutines.TimeoutCancellationException -> L2d
            java.lang.Object r9 = kotlinx.coroutines.a.o(r7, r9, r0)     // Catch: java.lang.Exception -> L2b kotlinx.coroutines.TimeoutCancellationException -> L2d
            if (r9 != r1) goto L4b
            return r1
        L4b:
            com.mdisdk.capability.request.ApexResult r9 = (com.mdisdk.capability.request.ApexResult) r9     // Catch: java.lang.Exception -> L2b kotlinx.coroutines.TimeoutCancellationException -> L2d
            return r9
        L4e:
            java.lang.String r7 = "Request failed"
            com.mdisdk.base.ALog.e(r3, r7, r6)
            r5.cancelPendingRequest()
            com.mdisdk.capability.request.ApexResult$Companion r5 = com.mdisdk.capability.request.ApexResult.INSTANCE
            java.lang.String r7 = "Request execution failed"
            com.mdisdk.capability.request.ApexResult$Error r5 = r5.error(r7, r6)
            goto L73
        L5f:
            java.lang.String r9 = "Request timeout after "
            java.lang.String r0 = " ms"
            java.lang.String r9 = androidx.compose.foundation.b.q(r7, r9, r0)
            com.mdisdk.base.ALog.w(r3, r9, r6)
            r5.cancelPendingRequest()
            com.mdisdk.capability.request.ApexResult$Companion r5 = com.mdisdk.capability.request.ApexResult.INSTANCE
            com.mdisdk.capability.request.ApexResult$Timeout r5 = r5.timeout(r7)
        L73:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mdisdk.capability.request.ApexRequest.request(com.mdisdk.capability.model.RequestInfo, long, H7.c):java.lang.Object");
    }
}
