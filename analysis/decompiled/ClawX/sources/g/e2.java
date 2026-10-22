package g;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e2 implements m0 {

    /* renamed from: a, reason: collision with root package name */
    public Toolbar f2691a;

    /* renamed from: b, reason: collision with root package name */
    public int f2692b;

    /* renamed from: c, reason: collision with root package name */
    public View f2693c;
    public Drawable d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f2694e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f2695f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2696g;

    /* renamed from: h, reason: collision with root package name */
    public CharSequence f2697h;

    /* renamed from: i, reason: collision with root package name */
    public CharSequence f2698i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f2699j;

    /* renamed from: k, reason: collision with root package name */
    public Window.Callback f2700k;

    /* renamed from: l, reason: collision with root package name */
    public int f2701l;

    /* renamed from: m, reason: collision with root package name */
    public Drawable f2702m;

    public final void a(int i8) {
        View view;
        Toolbar toolbar = this.f2691a;
        int i9 = this.f2692b ^ i8;
        this.f2692b = i8;
        if (i9 != 0) {
            if ((i9 & 4) != 0) {
                if ((i8 & 4) != 0) {
                    b();
                }
                if ((this.f2692b & 4) != 0) {
                    Drawable drawable = this.f2695f;
                    if (drawable == null) {
                        drawable = this.f2702m;
                    }
                    toolbar.setNavigationIcon(drawable);
                } else {
                    toolbar.setNavigationIcon((Drawable) null);
                }
            }
            if ((i9 & 3) != 0) {
                c();
            }
            if ((i9 & 8) != 0) {
                if ((i8 & 8) != 0) {
                    toolbar.setTitle(this.f2697h);
                    toolbar.setSubtitle(this.f2698i);
                } else {
                    toolbar.setTitle((CharSequence) null);
                    toolbar.setSubtitle((CharSequence) null);
                }
            }
            if ((i9 & 16) == 0 || (view = this.f2693c) == null) {
                return;
            }
            if ((i8 & 16) != 0) {
                toolbar.addView(view);
            } else {
                toolbar.removeView(view);
            }
        }
    }

    public final void b() {
        Toolbar toolbar = this.f2691a;
        if ((this.f2692b & 4) != 0) {
            if (TextUtils.isEmpty(this.f2699j)) {
                toolbar.setNavigationContentDescription(this.f2701l);
            } else {
                toolbar.setNavigationContentDescription(this.f2699j);
            }
        }
    }

    public final void c() {
        Drawable drawable;
        int i8 = this.f2692b;
        if ((i8 & 2) == 0) {
            drawable = null;
        } else if ((i8 & 1) == 0 || (drawable = this.f2694e) == null) {
            drawable = this.d;
        }
        this.f2691a.setLogo(drawable);
    }
}
