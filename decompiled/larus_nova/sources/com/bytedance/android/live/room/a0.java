package com.bytedance.android.live.room;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes47.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f98863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArrayList<a> f98864b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static View f98865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Integer f98866d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static ViewGroup f98867e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static ViewGroup.LayoutParams f98868f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static View f98869g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Integer f98870h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static ViewGroup f98871i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static ViewGroup.LayoutParams f98872j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static View f98873k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static Integer f98874l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static ViewGroup f98875m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static ViewGroup.LayoutParams f98876n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static String f98877o;

    public interface a {
        void onHide();

        void onShow();
    }

    public interface b {
        ViewGroup B2();

        void C4();

        ViewGroup J4();

        TextView Jp();

        boolean isShowing();

        ViewGroup r3();

        void y2();
    }

    static {
        f98864b = new ArrayList();
        f98877o = "";
    }

    public static void a() {
        ALogger.e("VSLiveDetailService", "hideVSLiveDetail");
        b r100 = f98863a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (f98865c != null) goto L7;
        return;
    L7:
        if (f98869g != null) goto L9;
        return;
    L9:
        if (f98873k != null) goto L12;
        return;
    L12:
        if (r100.isShowing() != true) goto L79;
        b r101 = f98863a;
        if (r101 == null) goto L17;
        r101.C4();
    L17:
        Iterator<a> r102 = f98864b.iterator();
    L19:
        if (r102.hasNext() == false) goto L21;
        r102.next().onHide();
        goto L19
    L21:
        int r103 = 0;
        if (f98865c == null) goto L39;
        b r104 = f98863a;
        if (r104 == null) goto L28;
        ViewGroup r105 = r104.J4();
        if (r105 == null) goto L28;
        r105.removeAllViews();
    L28:
        View r106 = f98865c;
        if (r106 == null) goto L31;
        r106.setLayoutParams(f98868f);
    L31:
        ViewGroup r107 = f98867e;
        if (r107 == null) goto L39;
        View r108 = f98865c;
        Integer r109 = f98866d;
        if (r109 == null) goto L36;
        int r110 = r109.intValue();
    L37:
        r107.addView(r108, r110);
        goto L39
    L36:
        r110 = 0;
    L39:
        if (f98873k == null) goto L56;
        b r111 = f98863a;
        if (r111 == null) goto L45;
        ViewGroup r112 = r111.B2();
        if (r112 == null) goto L45;
        r112.removeAllViews();
    L45:
        View r113 = f98873k;
        if (r113 == null) goto L48;
        r113.setLayoutParams(f98876n);
    L48:
        ViewGroup r114 = f98875m;
        if (r114 == null) goto L56;
        View r115 = f98873k;
        Integer r116 = f98874l;
        if (r116 == null) goto L53;
        int r117 = r116.intValue();
    L54:
        r114.addView(r115, r117);
        goto L56
    L53:
        r117 = 0;
    L56:
        if (f98869g == null) goto L76;
        b r118 = f98863a;
        if (r118 == null) goto L62;
        ViewGroup r119 = r118.r3();
        if (r119 == null) goto L62;
        r119.removeAllViews();
    L62:
        View r120 = f98869g;
        if (r120 == null) goto L65;
        r120.setLayoutParams(f98872j);
    L65:
        ViewGroup r121 = f98871i;
        if (r121 == null) goto L77;
        View r122 = f98869g;
        Integer r123 = f98870h;
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
