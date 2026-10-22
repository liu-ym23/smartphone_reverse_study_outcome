package androidx.recyclerview.base;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.animation.AnimationUtils;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class EdgeEffectAdapter {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f3984l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f3986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f3987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f3988d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f3989e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f3990f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f3991g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f3992h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f3993i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f3994j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final DisplayMetrics f3995k;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f3984l = new a(null);
    }

    public EdgeEffectAdapter(Context r10) {
        q.g(r10, "context");
        this.f3985a = r10;
        this.f3987c = -1;
        this.f3988d = -1;
        this.f3989e = new c();
        this.f3994j = true;
        this.f3995k = r10.getResources().getDisplayMetrics();
    }

    public final boolean a() {
        if (this.f3987c != (-1)) goto L6;
        return false;
    L6:
        if (this.f3993i != 1) goto L8;
        return true;
    L8:
        long r10 = AnimationUtils.currentAnimationTimeMillis() - this.f3987c;
        this.f3988d = r10;
        c.a r11 = this.f3989e.b(r10);
        this.f3990f = h(r11.a());
        boolean r12 = r11.b();
        this.f3994j = r12;
        if (r12 == false) goto L12;
        this.f3993i = 0;
    L12:
        return !r12;
    }

    public final float b(float r10) {
        return r10 / this.f3995k.density;
    }

    public final float c() {
        return this.f3990f;
    }

    public final boolean d() {
        return this.f3994j;
    }

    public final void e(int r10) {
        float r11 = b(r10 / 1000.0f);
        this.f3987c = AnimationUtils.currentAnimationTimeMillis();
        this.f3989e.a(r11, 0.0f);
        this.f3993i = 2;
        this.f3994j = false;
    }

    public final float f(float r10, boolean r11, boolean r12) {
        if (Math.signum(r10) != Math.signum(this.f3990f)) goto L5;
        boolean r13 = true;
    L7:
        if (r13 != r11) goto L41;
        if (r12 == true) goto L41;
        float r14 = b(r10);
        if (this.f3993i == 1) goto L18;
        float r15 = androidx.recyclerview.base.a.f4006a.a(Math.abs(b(this.f3990f)), this.f3986b) * (-Math.signum(this.f3990f));
        this.f3991g = r15;
        if (r15 != 0.0f) goto L15;
        float r16 = Math.signum(r14);
    L16:
        this.f3992h = r16;
    L20:
        float r17 = this.f3991g;
        float r18 = r14 + r17;
        this.f3991g = r18;
        float r19 = Math.signum(r18);
        float r20 = this.f3992h;
        if (r19 == r20) goto L26;
        if (r20 == 0.0f) goto L26;
        if (r11 == false) goto L30;
        this.f3991g = 0.0f;
        this.f3992h = 0.0f;
        r18 = 0.0f;
    L31:
        this.f3990f = h((-androidx.recyclerview.base.a.f4006a.b(Math.abs(r18), this.f3986b)) * Math.signum(r18));
        this.f3993i = 1;
        this.f3994j = false;
        if (r13 == false) goto L40;
        if (r18 == 0.0f) goto L36;
        return r10;
    L36:
        if (r17 != 0.0f) goto L43;
        return r10;
    L43:
        return -h(r17);
    L40:
        return 0.0f;
    L30:
        this.f3992h = Math.signum(r18);
    L26:
        if (this.f3991g != 0.0f) goto L31;
        this.f3992h = 0.0f;
        goto L31
    L15:
        r16 = Math.signum(r15);
        goto L16
    L18:
        if (this.f3992h != 0.0f) goto L20;
        this.f3992h = Math.signum(r14);
    L41:
        return 0.0f;
    L5:
        r13 = false;
        goto L7
    }

    public final void g() {
        float r10 = b(this.f3990f);
        this.f3987c = AnimationUtils.currentAnimationTimeMillis();
        this.f3989e.a((-r10) / 100.0f, r10);
        this.f3993i = 2;
        this.f3994j = false;
    }

    public final float h(float r10) {
        return TypedValue.applyDimension(1, r10, this.f3995k);
    }

    public final void i(int r10) {
        this.f3986b = b(r10);
    }
}
