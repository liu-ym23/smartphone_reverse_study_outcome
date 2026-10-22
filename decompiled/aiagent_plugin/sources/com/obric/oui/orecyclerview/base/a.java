package com.obric.oui.orecyclerview.base;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.animation.AnimationUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: EdgeEffectAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0962a f35508a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f35509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f35510c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f35511d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f35512e;
    private d f;
    private float g;
    private float h;
    private float i;
    private int j;
    private boolean k;
    private final DisplayMetrics l;

    /* JADX INFO: renamed from: com.obric.oui.orecyclerview.base.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: EdgeEffectAdapter.kt */
    public static final class C0962a {
        public /* synthetic */ C0962a(d.h.b.h r1) {
            this();
        }

        private C0962a() {
        }
    }

    static {
        f35508a = new C0962a(null);
    }

    public a(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        Context r7 = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
        this.f35509b = r7;
        this.f35511d = -1;
        this.f35512e = -1;
        this.f = new d();
        this.k = true;
        this.l = ZeusTransformUtils.getResources(r7, "com.obric.aiagent.plugin").getDisplayMetrics();
    }

    public final boolean a() {
        return this.k;
    }

    public final float b() {
        return this.g;
    }

    public final void a(int r3) {
        float r4 = b(r3 / 1000.0f);
        this.f35511d = AnimationUtils.currentAnimationTimeMillis();
        this.f.a(r4, 0.0f);
        this.j = 2;
        this.k = false;
    }

    public final float a(float r8, boolean r9, boolean r10) {
        boolean r1 = false;
        if (Math.signum(r8) != Math.signum(this.g)) goto L5;
        boolean r0 = true;
    L7:
        if (r0 != r9) goto L59;
        if (r10 == true) goto L59;
        float r11 = b(r8);
        if (this.j == 1) goto L21;
        float r4 = b.f35513a.b(Math.abs(b(this.g)), this.f35510c) * (-Math.signum(this.g));
        this.h = r4;
        if (r4 != 0.0f) goto L15;
        boolean r5 = true;
    L16:
        if (r5 == false) goto L18;
        float r6 = Math.signum(r11);
    L19:
        this.i = r6;
    L26:
        float r7 = this.h;
        float r12 = r11 + r7;
        this.h = r12;
        float r13 = Math.signum(r12);
        float r14 = this.i;
        if (r13 != r14) goto L29;
        boolean r15 = true;
    L30:
        if (r15 == true) goto L40;
        if (r14 != 0.0f) goto L34;
        boolean r16 = true;
    L35:
        if (r16 == true) goto L40;
        if (r9 == false) goto L38;
        this.h = 0.0f;
        this.i = 0.0f;
        r12 = 0.0f;
    L45:
        this.g = a((-b.f35513a.a(Math.abs(r12), this.f35510c)) * Math.signum(r12));
        this.j = 1;
        this.k = false;
        if (r0 == false) goto L58;
        if (r12 != 0.0f) goto L50;
        boolean r17 = true;
    L51:
        if (r17 == true) goto L53;
        return r8;
    L53:
        if (r7 != 0.0f) goto L55;
        r1 = true;
    L55:
        if (r1 == false) goto L62;
        return r8;
    L62:
        return -a(r7);
    L50:
        r17 = false;
        goto L51
    L58:
        return 0.0f;
    L38:
        this.i = Math.signum(r12);
        goto L45
    L34:
        r16 = false;
    L40:
        if (this.h != 0.0f) goto L42;
        boolean r18 = true;
    L43:
        if (r18 == false) goto L45;
        this.i = 0.0f;
        goto L45
    L42:
        r18 = false;
        goto L43
    L29:
        r15 = false;
        goto L30
    L18:
        r6 = Math.signum(r4);
        goto L19
    L15:
        r5 = false;
        goto L16
    L21:
        if (this.i != 0.0f) goto L23;
        boolean r19 = true;
    L24:
        if (r19 == false) goto L26;
        this.i = Math.signum(r11);
        goto L26
    L23:
        r19 = false;
    L59:
        return 0.0f;
    L5:
        r0 = false;
        goto L7
    }

    public final void c() {
        float r0 = b(this.g);
        this.f35511d = AnimationUtils.currentAnimationTimeMillis();
        this.f.a((-r0) / 100.0f, r0);
        this.j = 2;
        this.k = false;
    }

    public final boolean d() {
        if (this.f35511d != (-1)) goto L6;
        return false;
    L6:
        if (this.j != 1) goto L8;
        return true;
    L8:
        long r3 = AnimationUtils.currentAnimationTimeMillis() - this.f35511d;
        this.f35512e = r3;
        d.a r0 = this.f.a(r3);
        this.g = a(r0.a());
        boolean r1 = r0.b();
        this.k = r1;
        if (r1 == false) goto L12;
        this.j = 0;
    L12:
        return !r1;
    }

    public final void b(int r1) {
        this.f35510c = b(r1);
    }

    private final float a(float r2) {
        return TypedValue.applyDimension(1, r2, this.l);
    }

    private final float b(float r1) {
        return r1 / this.l.density;
    }
}
