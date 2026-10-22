package com.bytedance.android.livesdk.clearscreen;

import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenHelper;
import com.bytedance.android.livesdk.utils.condition.base.Condition;
import com.bytedance.android.livesdk.utils.condition.base.ConditionConstant$ConditionType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes8.dex */
public final class ClearGuideManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static com.bytedance.android.livesdk.utils.condition.base.e f119354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f119355b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f119356c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f119357d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f119358e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f119359f = null;

    public static ArrayList c() {
        return (ArrayList) f119355b.getValue();
    }

    static {
        f119355b = LazyKt.lazy(ClearGuideManager$showClearEntranceGuideTriggers$2.INSTANCE);
        if (ClearScreenHelper.d(null) == false) goto L5;
        String r100 = "live.pref.PREF_CLEARSCREEN_ENTRANCE_GUIDE_V2";
    L6:
        f119356c = r100;
        f119357d = "live.pref.PREF_CLEARSCREEN_PERFORMANCE_POWER_GUIDE";
        f119358e = "live.pref.PREF_CLEARSCREEN_PERFORMANCE_STALL_GUIDE";
        f119359f = "live.pref.PREF_CLEARSCREEN_PERFORMANCE_TIMESTAMP";
        return;
    L5:
        r100 = "live.pref.PREF_CLEARSCREEN_ENTRANCE_GUIDE";
        goto L6
    }

    public static void a() {
        Iterator r100 = c().iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        com.bytedance.android.livesdk.utils.condition.base.c r101 = (com.bytedance.android.livesdk.utils.condition.base.c) r100.next();
        if (r101 == null) goto L4;
        Iterator r102 = ((HashMap) r101.f158921a.getValue()).values().iterator();
    L9:
        if (r102.hasNext() == false) goto L4;
        ((Condition) r102.next()).b();
        goto L9
    }

    public static Condition b(com.bytedance.android.livesdk.utils.condition.base.e r100, ConditionConstant$ConditionType r101, ConditionConstant$ConditionType r102) {
        return new Condition(r101, r100, new d(r102));
    }
}
