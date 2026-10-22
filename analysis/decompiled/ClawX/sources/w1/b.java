package w1;

import android.view.View;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements View.OnFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6082a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f6083b;

    public /* synthetic */ b(p pVar, int i8) {
        this.f6082a = i8;
        this.f6083b = pVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        int i8 = this.f6082a;
        p pVar = this.f6083b;
        switch (i8) {
            case 0:
                e eVar = (e) pVar;
                eVar.s(eVar.t());
                break;
            default:
                l lVar = (l) pVar;
                lVar.f6109l = z;
                lVar.p();
                if (!z) {
                    lVar.s(false);
                    lVar.f6110m = false;
                    break;
                }
                break;
        }
    }
}
