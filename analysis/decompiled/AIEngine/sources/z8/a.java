package z8;

import com.stepos.core.model.ModelLifecycleImpl;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14278a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ModelLifecycleImpl f14279b;

    public /* synthetic */ a(ModelLifecycleImpl modelLifecycleImpl, int i10) {
        this.f14278a = i10;
        this.f14279b = modelLifecycleImpl;
    }

    @Override // zb.a
    public final Object invoke() {
        boolean zCleanup$lambda$6;
        int i10 = this.f14278a;
        ModelLifecycleImpl modelLifecycleImpl = this.f14279b;
        switch (i10) {
            case 0:
                zCleanup$lambda$6 = ModelLifecycleImpl.cleanup$lambda$6(modelLifecycleImpl);
                break;
            default:
                zCleanup$lambda$6 = ModelLifecycleImpl.close$lambda$5(modelLifecycleImpl);
                break;
        }
        return Boolean.valueOf(zCleanup$lambda$6);
    }
}
