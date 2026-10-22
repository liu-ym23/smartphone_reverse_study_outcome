package com.bytedance.android.live.profit.lottery;

import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class f3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static x2 f88073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, x2> f88074b = null;

    static {
        f88074b = new HashMap();
    }

    public static void a(t r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ReadOnlyProperty r101 = w2.f88234e;
        KProperty<?>[] r102 = w2.f88230a;
        if (((ArrayList) r101.getValue(null, r102[3])) != null) goto L7;
        return;
    L7:
        if (((ArrayList) r101.getValue(null, r102[3])).size() <= 0) goto L61;
        Iterator r103 = ((ArrayList) r101.getValue(null, r102[3])).iterator();
    L10:
        if (r103.hasNext() == false) goto L62;
        x2 r104 = (x2) r103.next();
        if (TextUtils.isEmpty(r104.lotteryType) == true) goto L10;
        String r105 = r104.lotteryType;
        Integer r106 = Integer.valueOf(r100.f88197d);
        if (r106 != null) goto L28;
        i r107 = yt0.c.f();
        if (r107 == null) goto L26;
        com.bytedance.live.datacontext.n<? extends g> r108 = r107.getCurrentLottery();
        if (r108 == null) goto L26;
        g r109 = r108.getValue();
        if (r109 == null) goto L26;
        LotteryState r110 = r109.getState();
        if (r110 == null) goto L26;
        t r111 = l.a(r110);
        if (r111 == null) goto L26;
        int r112 = r111.f88197d;
    L27:
        String r113 = String.valueOf(r112);
    L30:
        if (TextUtils.equals(r105, r113) == false) goto L10;
        f88073a = r104;
        String r114 = r100.f88203j;
        if (r114 != null) goto L52;
    L50:
        f88074b.put(r104.lotteryType, f88073a);
        goto L10
    L52:
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L47
        a3 r116 = (a3) GsonHelper.get().fromJson(r114, a3.class);     // Catch: Throwable -> L47
        u0 r117 = r116.iconConfig;     // Catch: Throwable -> L47
        if (r117 == null) goto L38;
        x2 r118 = f88073a;     // Catch: Throwable -> L47
        if (r118 == null) goto L38;
        Intrinsics.checkNotNull(r118);     // Catch: Throwable -> L47
        r118.iconConfig = r117;     // Catch: Throwable -> L47
    L38:
        l3 r119 = r116.tempStateConfig;     // Catch: Throwable -> L47
        if (r119 == null) goto L44;
        x2 r120 = f88073a;     // Catch: Throwable -> L47
        if (r120 == null) goto L43;
        Intrinsics.checkNotNull(r120);     // Catch: Throwable -> L47
        r120.tempStateConfig = r119;     // Catch: Throwable -> L47
    L43:
        Unit r121 = Unit.INSTANCE;     // Catch: Throwable -> L47
    L45:
        Object r122 = Result.m9449constructorimpl(r121);     // Catch: Throwable -> L47
    L49:
        Result.m9448boximpl(r122);
        goto L50
    L44:
        r121 = null;
    L47:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L26:
        r112 = 0;
        goto L27
    L28:
        r113 = String.valueOf(r106.intValue());
        goto L30
    L62:
        return;
    }

    public static boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "lotteryType");
        if (f88074b.get(r100) == null) goto L5;
        return true;
    L5:
        return false;
    }
}
