package stepos.support.v7.widget;

import Va.C0263a;
import android.view.View;
import android.view.Window;

/* loaded from: classes4.dex */
public final class E0 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6456a;
    public final C0263a b;
    public final /* synthetic */ G0 c;

    public /* synthetic */ E0(G0 g02, C0263a c0263a, int i) {
        this.f6456a = i;
        this.c = g02;
        this.b = c0263a;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f6456a) {
            case 0:
                G0 g02 = this.c;
                Window.Callback callback = g02.k;
                if (callback != null && g02.l) {
                    callback.onMenuItemSelected(0, this.b);
                    break;
                }
                break;
            case 1:
                G0 g03 = this.c;
                Window.Callback callback2 = g03.k;
                if (callback2 != null && g03.l) {
                    callback2.onMenuItemSelected(0, this.b);
                    break;
                }
                break;
            default:
                G0 g04 = this.c;
                Window.Callback callback3 = g04.k;
                if (callback3 != null && g04.l) {
                    callback3.onMenuItemSelected(0, this.b);
                    break;
                }
                break;
        }
    }

    public E0(G0 g02) {
        this.f6456a = 0;
        this.c = g02;
        this.b = new C0263a(g02.f6462a.getContext(), g02.h);
    }
}
