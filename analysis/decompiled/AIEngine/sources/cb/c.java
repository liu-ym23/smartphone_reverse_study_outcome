package cb;

import com.stepos.core.ota.confirmui.ModelConfirmFlow;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3318a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3319b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3320c;

    public /* synthetic */ c(int i10, int i11, Object obj) {
        this.f3318a = i11;
        this.f3319b = obj;
        this.f3320c = i10;
    }

    @Override // zb.a
    public final Object invoke() {
        switch (this.f3318a) {
            case 0:
                i iVar = (i) this.f3319b;
                return iVar.f3340e.deleteGroup(this.f3320c);
            case 1:
                i iVar2 = (i) this.f3319b;
                return iVar2.f3340e.cancelGroup(this.f3320c);
            default:
                return ModelConfirmFlow.showResourceGateBlocked$lambda$72((ModelConfirmFlow) this.f3319b, this.f3320c);
        }
    }
}
