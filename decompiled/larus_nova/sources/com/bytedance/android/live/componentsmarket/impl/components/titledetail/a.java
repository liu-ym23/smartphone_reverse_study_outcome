package com.bytedance.android.live.componentsmarket.impl.components.titledetail;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f64696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArrayList<InterfaceC1061a> f64697b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static View f64698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f64699d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Integer f64700e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static ViewGroup f64701f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static ViewGroup.LayoutParams f64702g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static View f64703h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Integer f64704i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static ViewGroup f64705j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static ViewGroup.LayoutParams f64706k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static View f64707l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static Integer f64708m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static ViewGroup f64709n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static ViewGroup.LayoutParams f64710o;

    /* JADX INFO: renamed from: com.bytedance.android.live.componentsmarket.impl.components.titledetail.a$a, reason: collision with other inner class name */
    public interface InterfaceC1061a {
        void onHide();

        void onShow();
    }

    public interface b {
        ViewGroup B2();

        void C4();

        ViewGroup J4();

        boolean isShowing();

        ViewGroup r3();

        void y2();
    }

    static {
        f64697b = new ArrayList();
    }

    public static void a() {
        b r100 = f64696a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (f64698c != null) goto L7;
        return;
    L7:
        if (f64703h != null) goto L9;
        return;
    L9:
        if (f64707l != null) goto L12;
        return;
    L12:
        if (r100.isShowing() != true) goto L79;
        b r101 = f64696a;
        if (r101 == null) goto L17;
        r101.C4();
    L17:
        Iterator<InterfaceC1061a> r102 = f64697b.iterator();
    L19:
        if (r102.hasNext() == false) goto L21;
        r102.next().onHide();
        goto L19
    L21:
        int r103 = 0;
        if (f64703h == null) goto L39;
        b r104 = f64696a;
        if (r104 == null) goto L28;
        ViewGroup r105 = r104.r3();
        if (r105 == null) goto L28;
        r105.removeAllViews();
    L28:
        View r106 = f64703h;
        if (r106 == null) goto L31;
        r106.setLayoutParams(f64706k);
    L31:
        ViewGroup r107 = f64705j;
        if (r107 == null) goto L39;
        View r108 = f64703h;
        Integer r109 = f64704i;
        if (r109 == null) goto L36;
        int r110 = r109.intValue();
    L37:
        r107.addView(r108, r110);
        goto L39
    L36:
        r110 = 0;
    L39:
        if (f64707l == null) goto L56;
        b r111 = f64696a;
        if (r111 == null) goto L45;
        ViewGroup r112 = r111.B2();
        if (r112 == null) goto L45;
        r112.removeAllViews();
    L45:
        View r113 = f64707l;
        if (r113 == null) goto L48;
        r113.setLayoutParams(f64710o);
    L48:
        ViewGroup r114 = f64709n;
        if (r114 == null) goto L56;
        View r115 = f64707l;
        Integer r116 = f64708m;
        if (r116 == null) goto L53;
        int r117 = r116.intValue();
    L54:
        r114.addView(r115, r117);
        goto L56
    L53:
        r117 = 0;
    L56:
        if (f64698c == null) goto L76;
        b r118 = f64696a;
        if (r118 == null) goto L62;
        ViewGroup r119 = r118.J4();
        if (r119 == null) goto L62;
        r119.removeAllViews();
    L62:
        View r120 = f64698c;
        if (r120 == null) goto L65;
        r120.setLayoutParams(f64702g);
    L65:
        ViewGroup r121 = f64701f;
        if (r121 == null) goto L77;
        View r122 = f64698c;
        Integer r123 = f64700e;
        if (r123 == null) goto L70;
        r103 = r123.intValue();
    L70:
        r121.addView(r122, r103);
        return;
    L77:
        return;
    L76:
        return;
    }
}
