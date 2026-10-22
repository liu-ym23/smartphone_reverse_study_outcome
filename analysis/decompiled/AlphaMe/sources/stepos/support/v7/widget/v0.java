package stepos.support.v7.widget;

import L3.C0094a;
import android.view.View;
import android.view.Window;

/* loaded from: classes2.dex */
public final class v0 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15158a;

    /* renamed from: b, reason: collision with root package name */
    public final C0094a f15159b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w0 f15160c;

    public /* synthetic */ v0(w0 w0Var, C0094a c0094a, int i4) {
        this.f15158a = i4;
        this.f15160c = w0Var;
        this.f15159b = c0094a;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i4 = this.f15158a;
        C0094a c0094a = this.f15159b;
        w0 w0Var = this.f15160c;
        switch (i4) {
            case 0:
                Window.Callback callback = w0Var.f15211k;
                if (callback != null && w0Var.f15212l) {
                    callback.onMenuItemSelected(0, c0094a);
                    break;
                }
                break;
            case 1:
                Window.Callback callback2 = w0Var.f15211k;
                if (callback2 != null && w0Var.f15212l) {
                    callback2.onMenuItemSelected(0, c0094a);
                    break;
                }
                break;
            default:
                Window.Callback callback3 = w0Var.f15211k;
                if (callback3 != null && w0Var.f15212l) {
                    callback3.onMenuItemSelected(0, c0094a);
                    break;
                }
                break;
        }
    }

    public v0(w0 w0Var) {
        this.f15158a = 0;
        this.f15160c = w0Var;
        this.f15159b = new C0094a(w0Var.f15201a.getContext(), w0Var.f15208h);
    }
}
