package com.bytedance.android.marketing.sdk.impl.utils;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class CommonUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CommonUtils f162812a = null;

    public CommonUtils() {
    }

    static {
        f162812a = new CommonUtils();
    }

    public static JSONObject b() {
        JSONObject r100 = new JSONObject();
        boolean r101 = ECServiceManager.f42805a;
        r100.put("session_preferred_hand_result", ((s83.g) ECServiceManager.c(s83.g.class)).F("session_preferred"));
        r100.put("most_used_hand_result", ((s83.g) ECServiceManager.c(s83.g.class)).F("most_used"));
        return r100;
    }

    public static Activity c() {
        IHybridHostService r100 = com.bytedance.android.ec.hybrid.a.h();
        if (r100 == null) goto L7;
        yj.i r101 = r100.getIHybridHostAppInfo();
        if (r101 == null) goto L7;
        return r101.a();
    L7:
        return null;
    }

    public static String a(Activity r100, Collection r101) {
        Intrinsics.checkNotNullParameter(r101, "targetSimpleNames");
        if (r100.isFinishing() == false) goto L6;
        return null;
    L6:
        if ((!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) == false) goto L8;
        return null;
    L8:
        HashSet r102 = SequencesKt.toHashSet(SequencesKt.filter(CollectionsKt.asSequence(r101), CommonUtils$findFragmentSimpleNameHit$targetSet$1.INSTANCE));
        if (r102.isEmpty() == false) goto L12;
        return null;
    L12:
        if ((r100 instanceof FragmentActivity) == true) goto L109;
        int r103 = Build.VERSION.SDK_INT;
        if (r103 >= 26) goto L54;
        return null;
    L54:
        if (r103 < 35) goto L103;
        return null;
    L103:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L64
        FragmentManager r105 = r100.getFragmentManager();     // Catch: Throwable -> L64
        if (r105 == null) goto L59;
        List<Fragment> r106 = r105.getFragments();     // Catch: Throwable -> L64
    L60:
        if (r106 != null) goto L62;
        r106 = CollectionsKt.emptyList();     // Catch: Throwable -> L64
    L62:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L64
    L66:
        List r108 = CollectionsKt.emptyList();
        if (Result.m9455isFailureimpl(r107) == false) goto L69;
        r107 = r108;
    L69:
        List r109 = (List) r107;
        if (r109.isEmpty() == true) goto L131;
        ArrayDeque r110 = new ArrayDeque();
        Iterator r111 = r109.iterator();
    L74:
        if (r111.hasNext() == false) goto L77;
        r110.addLast(TuplesKt.to(r111.next(), 0));
    L77:
        if ((!r110.isEmpty()) == false) goto L132;
        Pair r112 = (Pair) r110.removeLast();
        Object r113 = r112.component1();
        int r114 = ((Number) r112.component2()).intValue();
        String r115 = r113.getClass().getSimpleName();
        if (r102.contains(r115) == true) goto L102;
        if (r114 >= 8) goto L77;
        Fragment r116 = (Fragment) r113;
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L91
        FragmentManager r118 = r116.getChildFragmentManager();     // Catch: Throwable -> L91
        if (r118 == null) goto L86;
        List<Fragment> r119 = r118.getFragments();     // Catch: Throwable -> L91
    L87:
        if (r119 != null) goto L89;
        r119 = CollectionsKt.emptyList();     // Catch: Throwable -> L91
    L89:
        Object r120 = Result.m9449constructorimpl(r119);     // Catch: Throwable -> L91
    L93:
        List r121 = CollectionsKt.emptyList();
        if (Result.m9455isFailureimpl(r120) == false) goto L96;
        r120 = r121;
    L96:
        List r122 = (List) r120;
        if ((!r122.isEmpty()) == false) goto L77;
        Iterator r123 = r122.iterator();
    L100:
        if (r123.hasNext() == false) goto L77;
        r110.addLast(TuplesKt.to(r123.next(), Integer.valueOf(r114 + 1)));
        goto L100
    L86:
        r119 = null;
    L91:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L102:
        return r115;
    L132:
        return null;
    L131:
        return null;
    L59:
        r106 = null;
    L64:
        th = move-exception;
        Result.Companion r125 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L66
    L109:
        Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L15
        Object r127 = Result.m9449constructorimpl(((FragmentActivity) r100).getSupportFragmentManager().getFragments());     // Catch: Throwable -> L15
    L17:
        List r128 = CollectionsKt.emptyList();
        if (Result.m9455isFailureimpl(r127) == false) goto L20;
        r127 = r128;
    L20:
        List r129 = (List) r127;
        if (r129.isEmpty() == true) goto L130;
        ArrayDeque r130 = new ArrayDeque();
        Iterator r131 = r129.iterator();
    L25:
        if (r131.hasNext() == false) goto L28;
        r130.addLast(TuplesKt.to(r131.next(), 0));
    L28:
        if ((!r130.isEmpty()) == false) goto L133;
        Pair r132 = (Pair) r130.removeLast();
        Object r133 = r132.component1();
        int r134 = ((Number) r132.component2()).intValue();
        r115 = r133.getClass().getSimpleName();
        if (r102.contains(r115) == true) goto L102;
        if (r134 >= 8) goto L28;
        androidx.fragment.app.Fragment r135 = (androidx.fragment.app.Fragment) r133;
        if (r135.isAdded() == true) goto L107;
        List r136 = CollectionsKt.emptyList();
    L45:
        if ((!r136.isEmpty()) == false) goto L28;
        Iterator r137 = r136.iterator();
    L48:
        if (r137.hasNext() == false) goto L28;
        r130.addLast(TuplesKt.to(r137.next(), Integer.valueOf(r134 + 1)));
        goto L48
    L107:
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L38
        Object r139 = Result.m9449constructorimpl(r135.getChildFragmentManager().getFragments());     // Catch: Throwable -> L38
    L40:
        List r140 = CollectionsKt.emptyList();
        if (Result.m9455isFailureimpl(r139) == false) goto L43;
        r139 = r140;
    L43:
        r136 = (List) r139;
    L38:
        th = move-exception;
        Result.Companion r141 = Result.Companion;
        r139 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L40
    L133:
        return null;
    L130:
        return null;
    L15:
        th = move-exception;
        Result.Companion r142 = Result.Companion;
        r127 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    }
}
