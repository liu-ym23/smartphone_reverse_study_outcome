package h6;

import com.stepos.aiengine.modelmanager.ModelManagerFragment;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class h implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9313a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ModelManagerFragment f9314b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ s f9315c;

    public /* synthetic */ h(ModelManagerFragment modelManagerFragment, s sVar, int i10) {
        this.f9313a = i10;
        this.f9314b = modelManagerFragment;
        this.f9315c = sVar;
    }

    @Override // zb.a
    public final Object invoke() {
        switch (this.f9313a) {
            case 0:
                return ModelManagerFragment.onPrimaryAction$lambda$44(this.f9314b, this.f9315c);
            default:
                return ModelManagerFragment.onUninstall$lambda$57(this.f9314b, this.f9315c);
        }
    }
}
