package w1;

import android.text.Editable;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class m extends p1.j {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f6116a;

    public m(o oVar) {
        this.f6116a = oVar;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        this.f6116a.b().a();
    }

    @Override // p1.j, android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
        this.f6116a.b().b();
    }
}
