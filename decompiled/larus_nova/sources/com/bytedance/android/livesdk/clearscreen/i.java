package com.bytedance.android.livesdk.clearscreen;

import android.view.View;
import android.view.ViewPropertyAnimator;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.core.element.tetris.TetrisElement;
import com.bytedance.android.live.core.tetris.layer.core.element.widget.WidgetElement;
import com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenConst$AnimType;
import com.bytedance.android.livesdk.config.e81;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Element<?> f119423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v70.c f119424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f119425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ClearScreenConst$AnimType f119426d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f119427e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewPropertyAnimator f119428f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f119429g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DataCenter f119430h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final d90.d f119431i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f119432j;

    public i() {
        this(0);
    }

    public final Float a() {
        if (this.f119427e == false) goto L7;
        View r100 = this.f119425c;
        if (r100 == null) goto L11;
        float r101 = r100.getAlpha();
    L13:
        return Float.valueOf(r101);
    L11:
        return null;
    L7:
        v70.c r102 = this.f119424b;
        if (r102 == null) goto L11;
        r101 = r102.f553414a.getAlpha();
        goto L13
    }

    public final ViewPropertyAnimator b() {
        if (this.f119427e == false) goto L7;
        View r100 = this.f119425c;
        if (r100 == null) goto L10;
        ViewPropertyAnimator r101 = r100.animate();
    L11:
        this.f119428f = r101;
        return r101;
    L10:
        r101 = null;
        goto L11
    L7:
        v70.c r102 = this.f119424b;
        if (r102 == null) goto L10;
        r101 = r102.a();
        goto L11
    }

    public final boolean c() {
        if (this.f119427e == false) goto L10;
        View r100 = this.f119425c;
        if (r100 != null) goto L7;
        return false;
    L7:
        if (r100.getVisibility() != 0) goto L17;
        return true;
    L17:
        return false;
    L10:
        v70.c r101 = this.f119424b;
        if (r101 != null) goto L13;
        return false;
    L13:
        if (r101.getVisibility() != 0) goto L19;
        return true;
    L19:
        return false;
    }

    public i(int r100) {
        this.f119432j = false;
        this.f119426d = ClearScreenConst$AnimType.TRANS;
        this.f119429g = "";
    }

    public final void d(ArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "clearGoneList");
        if (e81.f120097c.getValue().booleanValue() == true) goto L5;
        return;
    L5:
        if (e81.f120098d.getValue().booleanValue() == false) goto L62;
        boolean r101 = this.f119427e;
        if (r101 == true) goto L19;
        Element<?> r102 = this.f119423a;
        if ((r102 instanceof WidgetElement) == false) goto L19;
        if (r102 == null) goto L18;
        com.bytedance.android.livesdk.common.i r103 = (com.bytedance.android.livesdk.common.i) ((WidgetElement) r102).f(com.bytedance.android.livesdk.common.i.class);
        if (r103 == null) goto L57;
        String r104 = r103.cg();
        if (r104 == null) goto L58;
        r100.remove(r104);
        return;
    L58:
        return;
    L57:
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.layer.core.element.widget.WidgetElement");
    L19:
        if (r101 == true) goto L60;
        Element<?> r105 = this.f119423a;
        if ((r105 instanceof TetrisElement) == false) goto L61;
        if (r105 == null) goto L42;
        List<Element<?>> r106 = ((TetrisElement) r105).f65698m;
        ArrayList r107 = new ArrayList();
        Iterator<T> r108 = r106.iterator();
    L25:
        if (r108.hasNext() == false) goto L29;
        Object r109 = r108.next();
        if ((((Element) r109) instanceof WidgetElement) == false) goto L25;
        r107.add(r109);
        goto L25
    L29:
        Iterator r110 = r107.iterator();
    L31:
        if (r110.hasNext() == false) goto L63;
        Element r111 = (Element) r110.next();
        if (r111 == null) goto L40;
        com.bytedance.android.livesdk.common.i r112 = (com.bytedance.android.livesdk.common.i) ((WidgetElement) r111).f(com.bytedance.android.livesdk.common.i.class);
        if (r112 == null) goto L31;
        String r113 = r112.cg();
        if (r113 == null) goto L31;
        r100.remove(r113);
        goto L31
    L40:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.layer.core.element.widget.WidgetElement");
    L63:
        return;
    L42:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.layer.core.element.tetris.TetrisElement");
    L61:
        return;
    L60:
        return;
    }

    public final void e(int r100) {
        if (this.f119427e == false) goto L7;
        View r101 = this.f119425c;
        if (r101 == null) goto L11;
        r101.setVisibility(r100);
        return;
    L11:
        return;
    L7:
        v70.c r102 = this.f119424b;
        if (r102 == null) goto L13;
        r102.setVisibility(r100);
        return;
    }

    public i(Element<?> r100, ClearScreenConst$AnimType r101) {
        Intrinsics.checkNotNullParameter(r100, "element");
        Intrinsics.checkNotNullParameter(r101, "animType");
        this(0);
        this.f119424b = r100.h();
        this.f119426d = r101;
        this.f119423a = r100;
        this.f119427e = false;
        this.f119429g = r100.f65662d.f497558a;
    }

    public i(View r100, ClearScreenConst$AnimType r101, String r102, d90.d r103) {
        Intrinsics.checkNotNullParameter(r101, "animType");
        Intrinsics.checkNotNullParameter(r102, "description");
        this(0);
        this.f119425c = r100;
        this.f119426d = r101;
        this.f119427e = true;
        this.f119429g = r102;
        this.f119431i = r103;
        if (r103 == null) goto L5;
        DataCenter r104 = r103.f467480h;
    L6:
        this.f119430h = r104;
        return;
    L5:
        r104 = null;
        goto L6
    }
}
