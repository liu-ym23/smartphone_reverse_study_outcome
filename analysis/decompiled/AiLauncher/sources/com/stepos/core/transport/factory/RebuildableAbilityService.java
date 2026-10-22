package com.stepos.core.transport.factory;

import androidx.exifinterface.media.ExifInterface;
import com.stepos.core.deepbinder.IAbilityDeepBinderService;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\tJ'\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/stepos/core/transport/factory/RebuildableAbilityService;", "", "Lkotlin/Function0;", "Lcom/stepos/core/deepbinder/IAbilityDeepBinderService;", "factory", "<init>", "(Lp9/a;)V", "stale", "rebuild", "(Lcom/stepos/core/deepbinder/IAbilityDeepBinderService;)Lcom/stepos/core/deepbinder/IAbilityDeepBinderService;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "block", "withRetry", "(Lp9/l;)Ljava/lang/Object;", "Lp9/a;", "current", "Lcom/stepos/core/deepbinder/IAbilityDeepBinderService;", "getService", "()Lcom/stepos/core/deepbinder/IAbilityDeepBinderService;", "service", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RebuildableAbilityService {
    private volatile IAbilityDeepBinderService current;
    private final InterfaceC5063a<IAbilityDeepBinderService> factory;

    /* JADX WARN: Multi-variable type inference failed */
    public RebuildableAbilityService(InterfaceC5063a<? extends IAbilityDeepBinderService> factory) {
        p.i(factory, "factory");
        this.factory = factory;
        this.current = (IAbilityDeepBinderService) factory.invoke();
    }

    private final synchronized IAbilityDeepBinderService rebuild(IAbilityDeepBinderService stale) {
        try {
            if (this.current == stale) {
                this.current = this.factory.invoke();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.current;
    }

    /* renamed from: getService, reason: from getter */
    public final IAbilityDeepBinderService getCurrent() {
        return this.current;
    }

    public final <T> T withRetry(InterfaceC5074l<? super IAbilityDeepBinderService, ? extends T> block) {
        p.i(block, "block");
        IAbilityDeepBinderService iAbilityDeepBinderService = this.current;
        try {
            return block.invoke(iAbilityDeepBinderService);
        } catch (Throwable th) {
            if (DeepBinderExtKt.isDeadProxy(th)) {
                return block.invoke(this.rebuild(iAbilityDeepBinderService));
            }
            throw th;
        }
    }
}
