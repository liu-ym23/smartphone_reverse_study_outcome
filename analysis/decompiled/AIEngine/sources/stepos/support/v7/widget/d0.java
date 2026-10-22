package stepos.support.v7.widget;

import android.view.View;
import android.view.Window;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d0 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final ge.b f12731a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e0 f12732b;

    public d0(e0 e0Var) {
        this.f12732b = e0Var;
        this.f12731a = new ge.b(e0Var.f12757a.getContext(), e0Var.f12764i);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        e0 e0Var = this.f12732b;
        Window.Callback callback = e0Var.f12767l;
        if (callback == null || !e0Var.f12768m) {
            return;
        }
        callback.onMenuItemSelected(0, this.f12731a);
    }
}
