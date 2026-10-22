package com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.ktv.common.util.u;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a {
    static {
    }

    public static void c(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Iterator<View> r101 = UtilityKotlinExtentionsKt.g(r100).iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        KeyEvent.Callback r102 = (View) r101.next();
        if ((r102 instanceof ViewGroup) == false) goto L9;
        c((ViewGroup) r102);
    L9:
        if ((r102 instanceof u) == false) goto L4;
        ((u) r102).onVHPaused();
        goto L4
    }

    public static void d(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Iterator<View> r101 = UtilityKotlinExtentionsKt.g(r100).iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        KeyEvent.Callback r102 = (View) r101.next();
        if ((r102 instanceof ViewGroup) == false) goto L9;
        d((ViewGroup) r102);
    L9:
        if ((r102 instanceof u) == false) goto L4;
        ((u) r102).onVHResume();
        goto L4
    }

    public static void e(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Iterator<View> r101 = UtilityKotlinExtentionsKt.g(r100).iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        KeyEvent.Callback r102 = (View) r101.next();
        if ((r102 instanceof ViewGroup) == false) goto L9;
        e((ViewGroup) r102);
    L9:
        if ((r102 instanceof u) == false) goto L4;
        ((u) r102).onVHSelected();
        goto L4
    }

    public static void f(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Iterator<View> r101 = UtilityKotlinExtentionsKt.g(r100).iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        KeyEvent.Callback r102 = (View) r101.next();
        if ((r102 instanceof ViewGroup) == false) goto L9;
        f((ViewGroup) r102);
    L9:
        if ((r102 instanceof u) == false) goto L4;
        ((u) r102).onVHUnSelected();
        goto L4
    }

    public static void a(ViewGroup r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, "logMsg");
        Iterator<View> r102 = UtilityKotlinExtentionsKt.g(r100).iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        KeyEvent.Callback r103 = (View) r102.next();
        if ((r103 instanceof ViewGroup) == false) goto L9;
        a((ViewGroup) r103, r101);
    L9:
        if ((r103 instanceof u) == false) goto L4;
        ((u) r103).attachFromWindow(r101);
        goto L4
    }

    public static void b(ViewGroup r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, "logMsg");
        Iterator<View> r102 = UtilityKotlinExtentionsKt.g(r100).iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        KeyEvent.Callback r103 = (View) r102.next();
        if ((r103 instanceof ViewGroup) == false) goto L9;
        b((ViewGroup) r103, r101);
    L9:
        if ((r103 instanceof u) == false) goto L4;
        ((u) r103).detachFromWindow(r101);
        goto L4
    }
}
