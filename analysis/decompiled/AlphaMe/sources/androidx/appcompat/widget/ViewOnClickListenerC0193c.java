package androidx.appcompat.widget;

import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import j.AbstractC0624c;
import k.C0647a;

/* renamed from: androidx.appcompat.widget.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewOnClickListenerC0193c implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3068a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f3069b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3070c;

    public /* synthetic */ ViewOnClickListenerC0193c(int i4, ViewGroup viewGroup, Object obj) {
        this.f3068a = i4;
        this.f3070c = viewGroup;
        this.f3069b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i4 = this.f3068a;
        Object obj = this.f3069b;
        switch (i4) {
            case 0:
                ((AbstractC0624c) obj).a();
                break;
            case 1:
                g1 g1Var = (g1) this.f3070c;
                Window.Callback callback = g1Var.f3097k;
                if (callback != null && g1Var.f3098l) {
                    callback.onMenuItemSelected(0, (C0647a) obj);
                    break;
                }
                break;
            default:
                ((K3.c) obj).a();
                break;
        }
    }

    public ViewOnClickListenerC0193c(g1 g1Var) {
        this.f3068a = 1;
        this.f3070c = g1Var;
        this.f3069b = new C0647a(g1Var.f3087a.getContext(), g1Var.f3094h);
    }
}
