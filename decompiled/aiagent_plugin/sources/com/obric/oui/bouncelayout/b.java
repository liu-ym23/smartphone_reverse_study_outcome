package com.obric.oui.bouncelayout;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: BounceClickDuringOverScrollDelegate.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f34139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.h.a.a<Float> f34140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.a<BounceEdgeEffect[]> f34141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f34142d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f34143e;
    private final int f;
    private float g;
    private float h;
    private boolean i;
    private boolean j;

    public b(View r3, d.h.a.a<Float> r4, d.h.a.a<BounceEdgeEffect[]> r5) {
        d.h.a.a<Float> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a<BounceEdgeEffect[]> r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r3, "target");
        o.e(r6, "translationProvider");
        o.e(r7, "effectsProvider");
        this.f34139a = r3;
        this.f34140b = r6;
        this.f34141c = r7;
        this.f34142d = true;
        this.f = ViewConfiguration.get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getScaledTouchSlop();
    }

    public final boolean a() {
        return this.f34142d;
    }

    public final float b() {
        return this.f34143e;
    }

    public final void a(boolean r2) {
        this.f34142d = r2;
        d r0 = d.f34149a;
        if (d.a() == false) goto L6;
        d.a(this.f34139a, "allowClickDuringOverScroll", o.a("allow=", Boolean.valueOf(r2)));
        return;
    }

    public final void a(MotionEvent r5) {
        o.e(r5, "event");
        int r0 = r5.getActionMasked();
        if (r0 != 0) goto L5;
        this.g = r5.getX();
        this.h = r5.getY();
        this.j = false;
        this.f34143e = ((Number) ZeusTransformUtils.preCheckCast(this.f34140b.invoke(), Number.class, "com.obric.aiagent.plugin")).floatValue();
        this.i = c(r5);
        d r6 = d.f34149a;
        if (d.a() == false) goto L24;
        d.a(this.f34139a, "allowClickDownDecision", "allow=" + a() + " allowClick=" + this.i + " translation=" + b() + ' ' + c());
    L24:
        if (this.i == false) goto L35;
        ViewParent r4 = this.f34139a.getParent();
        if (r4 == null) goto L37;
        r4.requestDisallowInterceptTouchEvent(true);
        return;
    L37:
        return;
    L35:
        return;
    L5:
        if (r0 == 2) goto L8;
        return;
    L8:
        if (this.i == true) goto L10;
        return;
    L10:
        if (this.j == false) goto L12;
        return;
    L12:
        if (d(r5) == false) goto L32;
        this.j = true;
        ViewParent r1 = this.f34139a.getParent();
        if (r1 == null) goto L17;
        r1.requestDisallowInterceptTouchEvent(false);
    L17:
        d r2 = d.f34149a;
        if (d.a() == false) goto L33;
        d.a(this.f34139a, "allowClickCancelByDrag", "dx=" + (r5.getX() - this.g) + " dy=" + (r5.getY() - this.h) + " touchSlop=" + this.f);
        return;
    L33:
        return;
    }

    public final boolean b(MotionEvent r4) {
        o.e(r4, "event");
        if (this.i == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        d r1 = d.f34149a;
        if (d.a() == false) goto L14;
        if (r0 == false) goto L12;
    L13:
        d.a(this.f34139a, "allowClickChildTouch", "action=" + r4.getActionMasked() + " allowChild=" + r0);
        goto L14
    L12:
        if (r4.getActionMasked() == 0) goto L13;
    L14:
        return r0;
    L5:
        if (this.j == true) goto L7;
        r0 = true;
        goto L8
    }

    public final Boolean a(MotionEvent r8, float r9, float r10, d.h.a.a<Boolean> r11) {
        d.h.a.a r12 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r8, "event");
        o.e(r12, "dispatch");
        if (this.i == true) goto L6;
        e(r8);
        return null;
    L6:
        d r0 = d.f34149a;
        if (d.a() == false) goto L9;
        d.a(this.f34139a, "allowClickDispatch", "action=" + r8.getActionMasked() + " movedBeyondSlop=" + this.j + " rawX=" + r8.getX() + " rawY=" + r8.getY() + " offsetX=" + r9 + " offsetY=" + r10);
    L9:
        boolean r3 = true;
        if (r9 != 0.0f) goto L12;
        boolean r2 = true;
    L14:
        if (r2 == true) goto L16;
    L26:
        r8.offsetLocation(r9, r10);
        boolean r13 = ((Boolean) ZeusTransformUtils.preCheckCast(r12.invoke(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        r8.offsetLocation(-r9, -r10);
        d r14 = d.f34149a;
        if (d.a() == false) goto L29;
        d.a(this.f34139a, "allowClickDispatchResult", o.a("handled=", Boolean.valueOf(r13)));
    L29:
        e(r8);
        return Boolean.valueOf(r13);
    L16:
        if (r10 == 0.0f) goto L19;
        r3 = false;
    L19:
        if (r3 == false) goto L26;
        boolean r15 = ((Boolean) ZeusTransformUtils.preCheckCast(r12.invoke(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        d r16 = d.f34149a;
        if (d.a() == false) goto L24;
        d.a(this.f34139a, "allowClickDispatchResult", o.a("handled=", Boolean.valueOf(r15)));
    L24:
        e(r8);
        return Boolean.valueOf(r15);
    L12:
        r2 = false;
        goto L14
    }

    private final boolean c(MotionEvent r8) {
        if (this.f34142d == true) goto L5;
        return false;
    L5:
        if (r8.getActionMasked() != 0) goto L33;
        Object[] r7 = (Object[]) ZeusTransformUtils.preCheckCast(this.f34141c.invoke(), Object[].class, "com.obric.aiagent.plugin");
        int r9 = r7.length;
        int r2 = 0;
    L9:
        if (r2 >= r9) goto L34;
        BounceEdgeEffect r4 = (BounceEdgeEffect) ZeusTransformUtils.preCheckCast(r7[r2], BounceEdgeEffect.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L13;
    L25:
        boolean r5 = false;
    L26:
        if (r5 == true) goto L32;
        r2 = r2 + 1;
        goto L9
    L32:
        return true;
    L13:
        if (r4.getDistance() != 0.0f) goto L15;
        boolean r6 = true;
    L16:
        if (r6 == true) goto L18;
    L24:
        r5 = true;
        goto L26
    L18:
        if (r4.getTranslation() != 0.0f) goto L20;
        boolean r10 = true;
    L21:
        if (r10 == false) goto L24;
        if (r4.isFinished() == true) goto L25;
    L20:
        r10 = false;
        goto L21
    L15:
        r6 = false;
        goto L16
    L34:
        return false;
    L33:
        return false;
    }

    private final boolean d(MotionEvent r3) {
        float r0 = r3.getX() - this.g;
        float r4 = r3.getY() - this.h;
        float r1 = (r0 * r0) + (r4 * r4);
        int r2 = this.f;
        if (r1 <= (r2 * r2)) goto L5;
        return true;
    L5:
        return false;
    }

    private final void e(MotionEvent r3) {
        if (r3.getActionMasked() != 1) goto L5;
    L6:
        this.f34143e = 0.0f;
        this.i = false;
        this.j = false;
        return;
    L5:
        if (r3.getActionMasked() == 3) goto L6;
    }

    private final String c() {
        Object[] r11 = (Object[]) ZeusTransformUtils.preCheckCast(this.f34141c.invoke(), Object[].class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r11.length), Collection.class, "com.obric.aiagent.plugin");
        int r2 = r11.length;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r3 >= r2) goto L10;
        int r6 = r4 + 1;
        BounceEdgeEffect r5 = (BounceEdgeEffect) ZeusTransformUtils.preCheckCast(r11[r3], BounceEdgeEffect.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L7;
        String r7 = "effect" + r4 + "=null";
    L8:
        r0.add(r7);
        r3 = r3 + 1;
        r4 = r6;
        goto L3
    L7:
        r7 = "effect" + r4 + "(distance=" + r5.getDistance() + ",translation=" + r5.getTranslation() + ",finished=" + r5.isFinished() + ')';
        goto L8
    L10:
        return "effects=[" + p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" ", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null) + ']';
    }
}
