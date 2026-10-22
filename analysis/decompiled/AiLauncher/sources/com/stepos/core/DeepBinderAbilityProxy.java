package com.stepos.core;

import android.os.IBinder;
import com.stepos.core.ability.AbilityInfo;
import com.stepos.core.ability.IAIAbility;
import com.stepos.core.ability.IChatSession;
import com.stepos.core.callback.IBoolCallback;
import com.stepos.core.callback.IInferenceCallback;
import com.stepos.core.callback.IReleaseCallback;
import com.stepos.core.data.base.Content;
import com.stepos.core.deepbinder.IAbilityDeepBinderService;
import com.stepos.core.deepbinder.IReleaseListener;
import com.stepos.core.transport.factory.RebuildableAbilityService;
import io.ktor.http.LinkHeader;
import java.util.UUID;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Result;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\bJ\u0011\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0016\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u001a\u001a\u0004\u0018\u00010\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u001c\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010!\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b!\u0010\"J\u0019\u0010#\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\tH\u0016¢\u0006\u0004\b%\u0010\u000bJ\u0011\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b'\u0010(J\u0019\u0010*\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\tH\u0016¢\u0006\u0004\b,\u0010\u000bJ\u000f\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b.\u0010/R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00100R\u0014\u00101\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00104\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105¨\u00066"}, d2 = {"Lcom/stepos/core/DeepBinderAbilityProxy;", "Lcom/stepos/core/ability/IAIAbility$Stub;", "Lcom/stepos/core/transport/factory/RebuildableAbilityService;", "svc", "<init>", "(Lcom/stepos/core/transport/factory/RebuildableAbilityService;)V", "", "acquire", "()Z", "LY8/t;", "release", "()V", "cancel", "Lcom/stepos/core/ability/AbilityInfo;", "getInfo", "()Lcom/stepos/core/ability/AbilityInfo;", "", "inferId", "Lcom/stepos/core/data/base/Content;", "input", "Lcom/stepos/core/callback/IInferenceCallback;", "callback", "infer", "(Ljava/lang/String;Lcom/stepos/core/data/base/Content;Lcom/stepos/core/callback/IInferenceCallback;)V", "action", "params", "execute", "(Ljava/lang/String;Lcom/stepos/core/data/base/Content;)Lcom/stepos/core/data/base/Content;", "feedInput", "(Ljava/lang/String;Lcom/stepos/core/data/base/Content;)V", "completeInput", "(Ljava/lang/String;)V", "Lcom/stepos/core/callback/IBoolCallback;", LinkHeader.Rel.PreLoad, "(Lcom/stepos/core/callback/IBoolCallback;)V", "cancelInfer", "(Ljava/lang/String;)Z", "cancelByUser", "Lcom/stepos/core/ability/IChatSession;", "createSession", "()Lcom/stepos/core/ability/IChatSession;", "Lcom/stepos/core/callback/IReleaseCallback;", "registerReleaseCallback", "(Lcom/stepos/core/callback/IReleaseCallback;)V", "unregisterReleaseCallback", "Landroid/os/IBinder;", "asBinder", "()Landroid/os/IBinder;", "Lcom/stepos/core/transport/factory/RebuildableAbilityService;", "releaseListenerId", "Ljava/lang/String;", "Lcom/stepos/core/deepbinder/IReleaseListener;", "releaseListener", "Lcom/stepos/core/deepbinder/IReleaseListener;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DeepBinderAbilityProxy extends IAIAbility.Stub {
    private volatile IReleaseListener releaseListener;
    private final String releaseListenerId;
    private final RebuildableAbilityService svc;

    public DeepBinderAbilityProxy(RebuildableAbilityService svc) {
        kotlin.jvm.internal.p.i(svc, "svc");
        this.svc = svc;
        this.releaseListenerId = "release-" + UUID.randomUUID();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean acquire$lambda$1$lambda$0(IAbilityDeepBinderService it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.acquire();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean cancel$lambda$3$lambda$2(IAbilityDeepBinderService it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t completeInput$lambda$11$lambda$10(String str, IAbilityDeepBinderService it) {
        kotlin.jvm.internal.p.i(it, "it");
        it.completeInput(str);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Content execute$lambda$7$lambda$6(String str, Content content, IAbilityDeepBinderService it) {
        kotlin.jvm.internal.p.i(it, "it");
        if (str == null) {
            str = "";
        }
        return it.execute(str, content);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t feedInput$lambda$9$lambda$8(String str, Content content, IAbilityDeepBinderService it) {
        kotlin.jvm.internal.p.i(it, "it");
        it.feedInput(str, content);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AbilityInfo getInfo$lambda$5$lambda$4(IAbilityDeepBinderService it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t registerReleaseCallback$lambda$13$lambda$12(DeepBinderAbilityProxy deepBinderAbilityProxy, DeepBinderAbilityProxy$registerReleaseCallback$listener$1 deepBinderAbilityProxy$registerReleaseCallback$listener$1, IAbilityDeepBinderService it) {
        kotlin.jvm.internal.p.i(it, "it");
        it.registerReleaseListener(deepBinderAbilityProxy.releaseListenerId, deepBinderAbilityProxy$registerReleaseCallback$listener$1);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t unregisterReleaseCallback$lambda$15$lambda$14(DeepBinderAbilityProxy deepBinderAbilityProxy, IAbilityDeepBinderService it) {
        kotlin.jvm.internal.p.i(it, "it");
        it.unregisterReleaseListener(deepBinderAbilityProxy.releaseListenerId);
        return Y8.t.f7040a;
    }

    @Override // com.stepos.core.ability.IAIAbility
    public boolean acquire() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            Boolean bool = (Boolean) this.svc.withRetry(new InterfaceC5074l() { // from class: com.stepos.core.v
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(DeepBinderAbilityProxy.acquire$lambda$1$lambda$0((IAbilityDeepBinderService) obj));
                }
            });
            bool.booleanValue();
            objB = Result.b(bool);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Boolean bool2 = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool2;
        }
        return ((Boolean) objB).booleanValue();
    }

    @Override // com.stepos.core.ability.IAIAbility.Stub, android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // com.stepos.core.ability.IAIAbility
    public boolean cancel() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            Boolean bool = (Boolean) this.svc.withRetry(new InterfaceC5074l() { // from class: com.stepos.core.r
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(DeepBinderAbilityProxy.cancel$lambda$3$lambda$2((IAbilityDeepBinderService) obj));
                }
            });
            bool.booleanValue();
            objB = Result.b(bool);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Boolean bool2 = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool2;
        }
        return ((Boolean) objB).booleanValue();
    }

    @Override // com.stepos.core.ability.IAIAbility
    public void cancelByUser() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.stepos.core.ability.IAIAbility
    public boolean cancelInfer(String inferId) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.stepos.core.ability.IAIAbility
    public void completeInput(final String inferId) {
        if (inferId != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                this.svc.withRetry(new InterfaceC5074l() { // from class: com.stepos.core.t
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return DeepBinderAbilityProxy.completeInput$lambda$11$lambda$10(inferId, (IAbilityDeepBinderService) obj);
                    }
                });
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
    }

    @Override // com.stepos.core.ability.IAIAbility
    public IChatSession createSession() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.stepos.core.ability.IAIAbility
    public Content execute(final String action, final Content params) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b((Content) this.svc.withRetry(new InterfaceC5074l() { // from class: com.stepos.core.s
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return DeepBinderAbilityProxy.execute$lambda$7$lambda$6(action, params, (IAbilityDeepBinderService) obj);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        return (Content) objB;
    }

    @Override // com.stepos.core.ability.IAIAbility
    public void feedInput(final String inferId, final Content input) {
        if (inferId == null || input == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            this.svc.withRetry(new InterfaceC5074l() { // from class: com.stepos.core.w
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return DeepBinderAbilityProxy.feedInput$lambda$9$lambda$8(inferId, input, (IAbilityDeepBinderService) obj);
                }
            });
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

    @Override // com.stepos.core.ability.IAIAbility
    public AbilityInfo getInfo() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b((AbilityInfo) this.svc.withRetry(new InterfaceC5074l() { // from class: com.stepos.core.q
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return DeepBinderAbilityProxy.getInfo$lambda$5$lambda$4((IAbilityDeepBinderService) obj);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        return (AbilityInfo) objB;
    }

    @Override // com.stepos.core.ability.IAIAbility
    public void infer(String inferId, Content input, IInferenceCallback callback) {
    }

    @Override // com.stepos.core.ability.IAIAbility
    public void preload(IBoolCallback callback) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.stepos.core.DeepBinderAbilityProxy$registerReleaseCallback$listener$1, com.stepos.core.deepbinder.IReleaseListener] */
    @Override // com.stepos.core.ability.IAIAbility
    public void registerReleaseCallback(final IReleaseCallback callback) {
        if (callback == null) {
            unregisterReleaseCallback();
            return;
        }
        final ?? r02 = new IReleaseListener() { // from class: com.stepos.core.DeepBinderAbilityProxy$registerReleaseCallback$listener$1
            @Override // com.stepos.core.deepbinder.IReleaseListener
            public void onRecycle() {
            }

            @Override // com.stepos.core.deepbinder.IReleaseListener
            public void onReleased(String modelId, int reasonCode, String message) {
                kotlin.jvm.internal.p.i(modelId, "modelId");
                kotlin.jvm.internal.p.i(message, "message");
                IReleaseCallback iReleaseCallback = callback;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    iReleaseCallback.onReleased(modelId, reasonCode, message);
                    Result.b(Y8.t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.b(C4849c.a(th));
                }
            }
        };
        this.releaseListener = r02;
        try {
            Result.Companion companion = Result.INSTANCE;
            this.svc.withRetry(new InterfaceC5074l() { // from class: com.stepos.core.x
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return DeepBinderAbilityProxy.registerReleaseCallback$lambda$13$lambda$12(this.f29652a, r02, (IAbilityDeepBinderService) obj);
                }
            });
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

    @Override // com.stepos.core.ability.IAIAbility
    public void release() {
    }

    @Override // com.stepos.core.ability.IAIAbility
    public void unregisterReleaseCallback() {
        if (this.releaseListener == null) {
            return;
        }
        this.releaseListener = null;
        try {
            Result.Companion companion = Result.INSTANCE;
            this.svc.withRetry(new InterfaceC5074l() { // from class: com.stepos.core.u
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return DeepBinderAbilityProxy.unregisterReleaseCallback$lambda$15$lambda$14(this.f29649a, (IAbilityDeepBinderService) obj);
                }
            });
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }
}
