package m;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class v2 implements c1 {

    /* renamed from: a, reason: collision with root package name */
    public Toolbar f8097a;

    /* renamed from: b, reason: collision with root package name */
    public int f8098b;

    /* renamed from: c, reason: collision with root package name */
    public View f8099c;

    /* renamed from: d, reason: collision with root package name */
    public Drawable f8100d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f8101e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f8102f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f8103g;

    /* renamed from: h, reason: collision with root package name */
    public CharSequence f8104h;
    public CharSequence i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f8105j;

    /* renamed from: k, reason: collision with root package name */
    public Window.Callback f8106k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f8107l;

    /* renamed from: m, reason: collision with root package name */
    public k f8108m;

    /* renamed from: n, reason: collision with root package name */
    public int f8109n;

    /* renamed from: o, reason: collision with root package name */
    public Drawable f8110o;

    public final void a(int i) {
        View view;
        Toolbar toolbar = this.f8097a;
        int i3 = this.f8098b ^ i;
        this.f8098b = i;
        if (i3 != 0) {
            if ((i3 & 4) != 0) {
                if ((i & 4) != 0) {
                    c();
                }
                if ((this.f8098b & 4) != 0) {
                    Drawable drawable = this.f8102f;
                    if (drawable == null) {
                        drawable = this.f8110o;
                    }
                    toolbar.setNavigationIcon(drawable);
                } else {
                    toolbar.setNavigationIcon((Drawable) null);
                }
            }
            if ((i3 & 3) != 0) {
                d();
            }
            if ((i3 & 8) != 0) {
                if ((i & 8) != 0) {
                    toolbar.setTitle(this.f8104h);
                    toolbar.setSubtitle(this.i);
                } else {
                    toolbar.setTitle((CharSequence) null);
                    toolbar.setSubtitle((CharSequence) null);
                }
            }
            if ((i3 & 16) == 0 || (view = this.f8099c) == null) {
                return;
            }
            if ((i & 16) != 0) {
                toolbar.addView(view);
            } else {
                toolbar.removeView(view);
            }
        }
    }

    public final n3.o0 b(int i, long j10) {
        n3.o0 o0VarA = n3.k0.a(this.f8097a);
        o0VarA.a(i == 0 ? 1.0f : 0.0f);
        o0VarA.c(j10);
        k.j jVar = new k.j(1);
        jVar.f6852j = this;
        jVar.i = i;
        jVar.f6851h = false;
        VarHandle.storeStoreFence();
        o0VarA.e(jVar);
        return o0VarA;
    }

    public final void c() {
        if ((this.f8098b & 4) != 0) {
            boolean zIsEmpty = TextUtils.isEmpty(this.f8105j);
            Toolbar toolbar = this.f8097a;
            if (zIsEmpty) {
                toolbar.setNavigationContentDescription(this.f8109n);
            } else {
                toolbar.setNavigationContentDescription(this.f8105j);
            }
        }
    }

    public final void d() {
        Drawable drawable;
        int i = this.f8098b;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) == 0 || (drawable = this.f8101e) == null) {
            drawable = this.f8100d;
        }
        this.f8097a.setLogo(drawable);
    }
}
