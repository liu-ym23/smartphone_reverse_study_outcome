package com.bytedance.android.livesdk.chatroom.vs.gesture;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public class b implements ko1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f117693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f117694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f117695c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f117696d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f117697e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f117698f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f117699g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f117700h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f117701i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f117702j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ViewGroup f117703k;

    public void d(boolean r100) {
        throw null;
    }

    @Override // ko1.c
    public final void a() {
        this.f117693a.f117706c = true;
        this.f117695c.f117729q = true;
        this.f117702j.getViewTreeObserver().addOnPreDrawListener(new a(this));
    }

    @Override // ko1.c
    public boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "resetType");
        if (this.f117702j.getScaleX() == 1.0f) goto L5;
    L7:
        this.f117702j.setScaleX(1.0f);
        this.f117702j.setScaleY(1.0f);
        this.f117702j.setX(this.f117700h);
        this.f117702j.setY(this.f117701i);
        this.f117702j.setPivotX(this.f117698f);
        this.f117702j.setPivotY(this.f117699g);
        c r101 = this.f117693a;
        r101.f117704a = 1.0f;
        r101.f117705b = 1.0f;
        r101.f117709f = false;
        r101.f117710g = true;
        e r102 = this.f117695c;
        r102.f117713a = 1.0f;
        r102.f117730r = 1.0f;
        r102.f117731s = 1.0f;
        r102.f117714b = 0.0f;
        r102.f117715c = 0.0f;
        r102.f117716d = 0.0f;
        r102.f117717e = 0.0f;
        r102.f117718f = 0.0f;
        r102.f117719g = 0.0f;
        r102.f117720h = false;
        r102.f117721i = 0;
        r102.f117722j = 0;
        r102.f117723k = 0;
        r102.f117724l = 0;
        r102.f117725m = 0.0f;
        r102.f117726n = 0.0f;
        r102.f117727o = 0.0f;
        r102.f117728p = 0.0f;
        d(false);
        return true;
    L5:
        if (this.f117702j.getScaleY() != 1.0f) goto L7;
        return false;
    }

    @Override // ko1.c
    public boolean c(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        if (r110.getPointerCount() != 1) goto L9;
        if (this.f117697e == false) goto L9;
        return this.f117696d.onTouchEvent(r110);
    L9:
        if (r110.getPointerCount() == 2) goto L15;
        if (this.f117697e == false) goto L15;
        return false;
    L15:
        if (r110.getAction() != 1) goto L17;
        boolean r100 = true;
    L18:
        this.f117697e = r100;
        if (r100 == false) goto L30;
        c r101 = this.f117693a;
        if (r101.f117706c == false) goto L30;
        if (r101.f117705b >= r101.f117708e) goto L30;
        r101.f117704a = 1.0f;
        Float r102 = Float.valueOf(1.0f);
        Float r103 = Float.valueOf(r101.f117704a);
        if (r102 == null) goto L27;
        r101.f117711h.setScaleX(r102.floatValue());
    L27:
        if (r103 == null) goto L29;
        r101.f117711h.setScaleY(r103.floatValue());
    L29:
        r101.f117705b = r101.f117704a;
    L30:
        c r104 = this.f117693a;
        float r105 = r104.f117704a;
        float r106 = r104.f117707d;
        if (r105 > (r106 * 1.0f)) goto L35;
        r106 = r104.f117708e;
        if (r105 < (r106 * 1.0f)) goto L35;
    L36:
        e r107 = this.f117695c;
        float r108 = r107.f117721i;
        float r109 = r108 * r105;
        r107.f117716d = r109;
        r107.f117717e = r107.f117722j * r105;
        if (r109 < r107.f117723k) goto L39;
        float r111 = r109 - r108;
        float r112 = 2;
        r107.f117725m = (r111 / r112) - (r107.f117733u.getWidth() - r107.f117732t.getRight());
        float r113 = ((r107.f117716d - r107.f117721i) / r112) - r107.f117732t.getLeft();
        r107.f117727o = r113;
        float r114 = r107.f117730r;
        if (r105 >= r114) goto L61;
        float r115 = r107.f117714b;
        if (r115 >= 0) goto L61;
        if ((-r115) <= r107.f117725m) goto L61;
        float r116 = (r107.f117718f - r107.f117716d) / r112;
        r107.a(r107.f117732t.getTranslationX() + r116);
        r107.f117714b += r116;
    L67:
        float r117 = r107.f117717e;
        if (r117 >= r107.f117724l) goto L85;
        float r118 = 2;
        r107.f117726n = r107.f117732t.getTop() - ((r107.f117717e - r107.f117722j) / r118);
        r107.f117728p = (r107.f117733u.getHeight() - r107.f117732t.getBottom()) - ((r107.f117717e - r107.f117722j) / r118);
        if (r107.f117729q == false) goto L72;
        r107.f117715c = 0.0f;
        r107.b(0.0f);
    L72:
        float r119 = r107.f117731s;
        if (r105 <= r119) goto L79;
        float r120 = r107.f117715c;
        if (r120 >= 0) goto L79;
        if ((-r120) <= r107.f117726n) goto L79;
        float r121 = (r107.f117717e - r107.f117719g) / r118;
        r107.b(r107.f117732t.getTranslationY() + r121);
        r107.f117715c += r121;
    L98:
        r107.f117718f = r107.f117716d;
        r107.f117719g = r107.f117717e;
        r107.f117713a = r105;
        r107.f117730r = r105;
        r107.f117731s = r105;
        if (r105 <= 1.0f) goto L101;
        d(true);
    L103:
        return this.f117694b.onTouchEvent(r110);
    L101:
        d(false);
    L79:
        if (r105 <= r119) goto L98;
        float r122 = r107.f117715c;
        if (r122 <= 0) goto L98;
        if (r122 <= r107.f117728p) goto L98;
        float r123 = (r107.f117717e - r107.f117719g) / r118;
        r107.b(r107.f117732t.getTranslationY() - r123);
        r107.f117715c -= r123;
        goto L98
    L85:
        float r124 = 2;
        r107.f117726n = ((r117 - r107.f117722j) / r124) - (r107.f117733u.getHeight() - r107.f117732t.getBottom());
        float r125 = ((r107.f117717e - r107.f117722j) / r124) - r107.f117732t.getTop();
        r107.f117728p = r125;
        float r126 = r107.f117731s;
        if (r105 >= r126) goto L92;
        float r127 = r107.f117715c;
        if (r127 >= 0) goto L92;
        if ((-r127) <= r107.f117726n) goto L92;
        float r128 = (r107.f117719g - r107.f117717e) / r124;
        r107.b(r107.f117732t.getTranslationY() + r128);
        r107.f117715c += r128;
    L92:
        if (r105 >= r126) goto L98;
        float r129 = r107.f117715c;
        if (r129 <= 0) goto L98;
        if (r129 <= r125) goto L98;
        float r130 = (r107.f117719g - r107.f117717e) / r124;
        r107.b(r107.f117732t.getTranslationY() - r130);
        r107.f117715c -= r130;
    L61:
        if (r105 >= r114) goto L67;
        float r131 = r107.f117714b;
        if (r131 <= 0) goto L67;
        if (r131 <= r113) goto L67;
        float r132 = (r107.f117718f - r107.f117716d) / r112;
        r107.a(r107.f117732t.getTranslationX() - r132);
        r107.f117714b -= r132;
        goto L67
    L39:
        if (r107.f117729q == false) goto L41;
        r107.f117714b = 0.0f;
        r107.a(0.0f);
    L41:
        float r133 = 2;
        r107.f117725m = r107.f117732t.getLeft() - ((r107.f117716d - r107.f117721i) / r133);
        float r134 = r107.f117733u.getWidth() - r107.f117732t.getRight();
        float r135 = r107.f117716d;
        float r136 = r134 - ((r135 - r107.f117721i) / r133);
        r107.f117727o = r136;
        float r137 = r107.f117730r;
        if (r105 <= r137) goto L48;
        float r138 = r107.f117714b;
        if (r138 >= 0) goto L48;
        if ((-r138) <= r107.f117725m) goto L48;
        float r139 = (r135 - r107.f117718f) / r133;
        r107.a(r107.f117732t.getTranslationX() + r139);
        r107.f117714b += r139;
    L48:
        if (r105 <= r137) goto L67;
        float r140 = r107.f117714b;
        if (r140 <= 0) goto L67;
        if (r140 <= r136) goto L67;
        float r141 = (r135 - r107.f117718f) / r133;
        r107.a(r107.f117732t.getTranslationX() - r141);
        r107.f117714b -= r141;
    L35:
        r105 = r106 * 1.0f;
        goto L36
    L17:
        r100 = false;
        goto L18
    }

    public b(Context r100, View r101, ViewGroup r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "targetView");
        Intrinsics.checkNotNullParameter(r102, "viewGroup");
        this.f117702j = r101;
        this.f117703k = r102;
        c r103 = new c(r101, r102);
        this.f117693a = r103;
        this.f117694b = new d(r100, r103);
        e r104 = new e(r101, r102);
        this.f117695c = r104;
        this.f117696d = new f(r100, r104);
        this.f117697e = true;
        r101.setClickable(false);
        this.f117700h = r101.getX();
        this.f117701i = r101.getY();
        this.f117698f = r101.getPivotX();
        this.f117699g = r101.getPivotY();
    }
}
