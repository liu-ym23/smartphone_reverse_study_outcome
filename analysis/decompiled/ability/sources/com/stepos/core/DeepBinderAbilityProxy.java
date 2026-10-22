package com.stepos.core;

import android.os.IBinder;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.core.ability.AbilityInfo;
import com.stepos.core.ability.IAIAbility;
import com.stepos.core.ability.IChatSession;
import com.stepos.core.callback.IBoolCallback;
import com.stepos.core.callback.IInferenceCallback;
import com.stepos.core.data.base.Content;
import com.stepos.core.deepbinder.IAbilityDeepBinderService;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Result;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\bJ\u0011\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0016\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u001a\u001a\u0004\u0018\u00010\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u001c\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010!\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b!\u0010\"J\u0019\u0010#\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\tH\u0016¢\u0006\u0004\b%\u0010\u000bJ\u0011\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b*\u0010+R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010,¨\u0006-"}, d2 = {"Lcom/stepos/core/DeepBinderAbilityProxy;", "Lcom/stepos/core/ability/IAIAbility$Stub;", "Lcom/stepos/core/deepbinder/IAbilityDeepBinderService;", "abilityService", AppAgent.CONSTRUCT, "(Lcom/stepos/core/deepbinder/IAbilityDeepBinderService;)V", "", "acquire", "()Z", "LC7/r;", "release", "()V", "cancel", "Lcom/stepos/core/ability/AbilityInfo;", "getInfo", "()Lcom/stepos/core/ability/AbilityInfo;", "", "inferId", "Lcom/stepos/core/data/base/Content;", "input", "Lcom/stepos/core/callback/IInferenceCallback;", "callback", "infer", "(Ljava/lang/String;Lcom/stepos/core/data/base/Content;Lcom/stepos/core/callback/IInferenceCallback;)V", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "params", "execute", "(Ljava/lang/String;Lcom/stepos/core/data/base/Content;)Lcom/stepos/core/data/base/Content;", "feedInput", "(Ljava/lang/String;Lcom/stepos/core/data/base/Content;)V", "completeInput", "(Ljava/lang/String;)V", "Lcom/stepos/core/callback/IBoolCallback;", "preload", "(Lcom/stepos/core/callback/IBoolCallback;)V", "cancelInfer", "(Ljava/lang/String;)Z", "cancelByUser", "Lcom/stepos/core/ability/IChatSession;", "createSession", "()Lcom/stepos/core/ability/IChatSession;", "Landroid/os/IBinder;", "asBinder", "()Landroid/os/IBinder;", "Lcom/stepos/core/deepbinder/IAbilityDeepBinderService;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DeepBinderAbilityProxy extends IAIAbility.Stub {
    private final IAbilityDeepBinderService abilityService;

    public DeepBinderAbilityProxy(IAbilityDeepBinderService abilityService) {
        k.f(abilityService, "abilityService");
        this.abilityService = abilityService;
    }

    @Override // com.stepos.core.ability.IAIAbility
    public boolean acquire() {
        Object objA;
        try {
            objA = Boolean.valueOf(this.abilityService.acquire());
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        return ((Boolean) objA).booleanValue();
    }

    @Override // com.stepos.core.ability.IAIAbility.Stub, android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // com.stepos.core.ability.IAIAbility
    public boolean cancel() {
        Object objA;
        try {
            objA = Boolean.valueOf(this.abilityService.cancel());
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        return ((Boolean) objA).booleanValue();
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
    public void completeInput(String inferId) {
        if (inferId != null) {
            try {
                this.abilityService.completeInput(inferId);
            } catch (Throwable th) {
                kotlin.b.a(th);
            }
        }
    }

    @Override // com.stepos.core.ability.IAIAbility
    public IChatSession createSession() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.stepos.core.ability.IAIAbility
    public Content execute(String action, Content params) {
        Object objA;
        try {
            IAbilityDeepBinderService iAbilityDeepBinderService = this.abilityService;
            if (action == null) {
                action = "";
            }
            objA = iAbilityDeepBinderService.execute(action, params);
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        return (Content) objA;
    }

    @Override // com.stepos.core.ability.IAIAbility
    public void feedInput(String inferId, Content input) {
        if (inferId == null || input == null) {
            return;
        }
        try {
            this.abilityService.feedInput(inferId, input);
        } catch (Throwable th) {
            kotlin.b.a(th);
        }
    }

    @Override // com.stepos.core.ability.IAIAbility
    public AbilityInfo getInfo() {
        Object objA;
        try {
            objA = this.abilityService.getInfo();
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        return (AbilityInfo) objA;
    }

    @Override // com.stepos.core.ability.IAIAbility
    public void infer(String inferId, Content input, IInferenceCallback callback) {
    }

    @Override // com.stepos.core.ability.IAIAbility
    public void preload(IBoolCallback callback) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.stepos.core.ability.IAIAbility
    public void release() {
    }
}
