package g;

import android.graphics.Typeface;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class y extends w.b {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f2869e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f2870f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ WeakReference f2871g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ d0 f2872h;

    public y(d0 d0Var, int i8, int i9, WeakReference weakReference) {
        this.f2872h = d0Var;
        this.f2869e = i8;
        this.f2870f = i9;
        this.f2871g = weakReference;
    }

    @Override // w.b
    public final void e(Typeface typeface) {
        int i8 = this.f2869e;
        if (i8 != -1) {
            typeface = c0.a(typeface, i8, (this.f2870f & 2) != 0);
        }
        d0 d0Var = this.f2872h;
        if (d0Var.f2687m) {
            d0Var.f2686l = typeface;
            TextView textView = (TextView) this.f2871g.get();
            if (textView != null) {
                if (textView.isAttachedToWindow()) {
                    textView.post(new z(textView, typeface, d0Var.f2684j));
                } else {
                    textView.setTypeface(typeface, d0Var.f2684j);
                }
            }
        }
    }

    @Override // w.b
    public final void d(int i8) {
    }
}
