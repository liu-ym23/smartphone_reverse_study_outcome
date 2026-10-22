package com.obric.oui.orecyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bytedance.keva.KevaImpl;
import com.obric.oui.orecyclerview.base.SmoothInterpolator;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: LinearSmoothScroller.java */
/* JADX INFO: loaded from: classes4.dex */
public class o extends RecyclerView.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final LinearInterpolator f35818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final SmoothInterpolator f35819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected PointF f35820c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected int f35821d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int f35822e;
    private final DisplayMetrics f;
    private boolean g;
    private float h;

    private int b(int r1, int r2) {
        int r0 = r1 - r2;
        if ((r1 * r0) > 0) goto L6;
        return 0;
    L6:
        return r0;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.r
    public void a() {
    }

    public o(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.f35818a = new LinearInterpolator();
        this.f35819b = new SmoothInterpolator();
        this.g = false;
        this.f35821d = 0;
        this.f35822e = 0;
        this.f = ZeusTransformUtils.getResources(r4, "com.obric.aiagent.plugin").getDisplayMetrics();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.r
    public void a(View r3, RecyclerView.s r4, RecyclerView.r.a r5) {
        int r6 = b(r3, c());
        int r7 = a(r3, d());
        int r0 = a((int) Math.sqrt((r6 * r6) + (r7 * r7)));
        if (r0 <= 0) goto L6;
        r5.update(-r6, -r7, r0, this.f35819b);
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.r
    public void a(int r1, int r2, RecyclerView.s r3, RecyclerView.r.a r4) {
        if (j() != 0) goto L6;
        f();
        return;
    L6:
        this.f35821d = b(this.f35821d, r1);
        int r5 = b(this.f35822e, r2);
        this.f35822e = r5;
        if (this.f35821d != 0) goto L11;
        if (r5 != 0) goto L12;
        a(r4);
        return;
    L12:
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.r
    public void b() {
        this.f35822e = 0;
        this.f35821d = 0;
        this.f35820c = null;
    }

    public float a(DisplayMetrics r1) {
        return 50.0f / r1.densityDpi;
    }

    private float k() {
        if (this.g == true) goto L6;
        this.h = a(this.f);
        this.g = true;
    L6:
        return this.h;
    }

    public int a(int r3) {
        return (int) Math.ceil(((double) b(r3)) / 0.2d);
    }

    public int b(int r1) {
        return (int) Math.ceil(Math.abs(r1) * k());
    }

    public int c() {
        PointF r0 = this.f35820c;
        if (r0 != null) goto L5;
    L11:
        return 0;
    L5:
        if (r0.x == 0.0f) goto L11;
        if (this.f35820c.x <= 0.0f) goto L10;
        return 1;
    L10:
        return -1;
    }

    public int d() {
        PointF r0 = this.f35820c;
        if (r0 != null) goto L5;
    L11:
        return 0;
    L5:
        if (r0.y == 0.0f) goto L11;
        if (this.f35820c.y <= 0.0f) goto L10;
        return 1;
    L10:
        return -1;
    }

    public void a(RecyclerView.r.a r5) {
        PointF r0 = d(i());
        if (r0 != null) goto L5;
    L11:
        r5.a(i());
        f();
        return;
    L5:
        if (r0.x == 0.0f) goto L7;
    L9:
        a(r0);
        this.f35820c = r0;
        this.f35821d = (int) (r0.x * 10000.0f);
        this.f35822e = (int) (r0.y * 10000.0f);
        r5.update((int) (this.f35821d * 1.2f), (int) (this.f35822e * 1.2f), (int) (b(KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD) * 1.2f), this.f35818a);
        return;
    L7:
        if (r0.y != 0.0f) goto L9;
        goto L9
    }

    public int a(int r1, int r2, int r3, int r4, int r5) {
        if (r5 == (-1)) goto L20;
        if (r5 != 0) goto L6;
        int r6 = r3 - r1;
        if (r6 <= 0) goto L14;
        return r6;
    L14:
        int r7 = r4 - r2;
        if (r7 >= 0) goto L17;
        return r7;
    L17:
        return 0;
    L6:
        if (r5 != 1) goto L10;
        return r4 - r2;
    L10:
        throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
    L20:
        return r3 - r1;
    }

    public int a(View r11, int r12) {
        RecyclerView.h r0 = e();
        if (r0 != null) goto L5;
        return 0;
    L5:
        if (r0.g() == false) goto L11;
        RecyclerView.LayoutParams r1 = (RecyclerView.LayoutParams) ZeusTransformUtils.preCheckCast(r11.getLayoutParams(), RecyclerView.LayoutParams.class, "com.obric.aiagent.plugin");
        return a(r0.i(r11) - r1.topMargin, r0.k(r11) + r1.bottomMargin, r0.E(), r0.C() - r0.G(), r12);
    L11:
        return 0;
    }

    public int b(View r11, int r12) {
        RecyclerView.h r0 = e();
        if (r0 != null) goto L5;
        return 0;
    L5:
        if (r0.f() == false) goto L11;
        RecyclerView.LayoutParams r1 = (RecyclerView.LayoutParams) ZeusTransformUtils.preCheckCast(r11.getLayoutParams(), RecyclerView.LayoutParams.class, "com.obric.aiagent.plugin");
        return a(r0.h(r11) - r1.leftMargin, r0.j(r11) + r1.rightMargin, r0.D(), r0.B() - r0.F(), r12);
    L11:
        return 0;
    }
}
