package androidx.appcompat.widget;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public final class g1 implements InterfaceC0216n0 {

    /* renamed from: a, reason: collision with root package name */
    public Toolbar f3087a;

    /* renamed from: b, reason: collision with root package name */
    public int f3088b;

    /* renamed from: c, reason: collision with root package name */
    public View f3089c;

    /* renamed from: d, reason: collision with root package name */
    public Drawable f3090d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f3091e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f3092f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f3093g;

    /* renamed from: h, reason: collision with root package name */
    public CharSequence f3094h;

    /* renamed from: i, reason: collision with root package name */
    public CharSequence f3095i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f3096j;

    /* renamed from: k, reason: collision with root package name */
    public Window.Callback f3097k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f3098l;

    /* renamed from: m, reason: collision with root package name */
    public C0217o f3099m;

    /* renamed from: n, reason: collision with root package name */
    public int f3100n;

    /* renamed from: o, reason: collision with root package name */
    public Drawable f3101o;

    public final void a(int i4) {
        View view;
        int i5 = this.f3088b ^ i4;
        this.f3088b = i4;
        if (i5 != 0) {
            if ((i5 & 4) != 0) {
                if ((i4 & 4) != 0) {
                    c();
                }
                int i6 = this.f3088b & 4;
                Toolbar toolbar = this.f3087a;
                if (i6 != 0) {
                    Drawable drawable = this.f3092f;
                    if (drawable == null) {
                        drawable = this.f3101o;
                    }
                    toolbar.setNavigationIcon(drawable);
                } else {
                    toolbar.setNavigationIcon((Drawable) null);
                }
            }
            if ((i5 & 3) != 0) {
                d();
            }
            int i7 = i5 & 8;
            Toolbar toolbar2 = this.f3087a;
            if (i7 != 0) {
                if ((i4 & 8) != 0) {
                    toolbar2.setTitle(this.f3094h);
                    toolbar2.setSubtitle(this.f3095i);
                } else {
                    toolbar2.setTitle((CharSequence) null);
                    toolbar2.setSubtitle((CharSequence) null);
                }
            }
            if ((i5 & 16) == 0 || (view = this.f3089c) == null) {
                return;
            }
            if ((i4 & 16) != 0) {
                toolbar2.addView(view);
            } else {
                toolbar2.removeView(view);
            }
        }
    }

    public final K.e0 b(int i4, long j4) {
        K.e0 e0VarA = K.S.a(this.f3087a);
        e0VarA.a(i4 == 0 ? 1.0f : Property.DEFAULT_FLOAT_VALUE);
        e0VarA.c(j4);
        e0VarA.e(new j.l(i4, 1, this));
        return e0VarA;
    }

    public final void c() {
        if ((this.f3088b & 4) != 0) {
            boolean zIsEmpty = TextUtils.isEmpty(this.f3096j);
            Toolbar toolbar = this.f3087a;
            if (zIsEmpty) {
                toolbar.setNavigationContentDescription(this.f3100n);
            } else {
                toolbar.setNavigationContentDescription(this.f3096j);
            }
        }
    }

    public final void d() {
        Drawable drawable;
        int i4 = this.f3088b;
        if ((i4 & 2) == 0) {
            drawable = null;
        } else if ((i4 & 1) == 0 || (drawable = this.f3091e) == null) {
            drawable = this.f3090d;
        }
        this.f3087a.setLogo(drawable);
    }
}
