package stepos.support.v7.widget;

import android.view.View;
import android.view.Window;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class u1 implements View.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f12841c;

    /* renamed from: f, reason: collision with root package name */
    public te.a f12842f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ v1 f12843g;

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f12841c) {
            case 0:
                v1 v1Var = this.f12843g;
                Window.Callback callback = v1Var.f12880k;
                if (callback != null && v1Var.f12881l) {
                    callback.onMenuItemSelected(0, this.f12842f);
                    break;
                }
                break;
            case 1:
                v1 v1Var2 = this.f12843g;
                Window.Callback callback2 = v1Var2.f12880k;
                if (callback2 != null && v1Var2.f12881l) {
                    callback2.onMenuItemSelected(0, this.f12842f);
                    break;
                }
                break;
            default:
                v1 v1Var3 = this.f12843g;
                Window.Callback callback3 = v1Var3.f12880k;
                if (callback3 != null && v1Var3.f12881l) {
                    callback3.onMenuItemSelected(0, this.f12842f);
                    break;
                }
                break;
        }
    }
}
