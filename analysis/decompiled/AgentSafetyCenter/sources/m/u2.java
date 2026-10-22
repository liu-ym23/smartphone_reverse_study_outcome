package m;

import android.view.View;
import android.view.Window;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class u2 implements View.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public l.a f8087c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ v2 f8088f;

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        v2 v2Var = this.f8088f;
        Window.Callback callback = v2Var.f8106k;
        if (callback == null || !v2Var.f8107l) {
            return;
        }
        callback.onMenuItemSelected(0, this.f8087c);
    }
}
