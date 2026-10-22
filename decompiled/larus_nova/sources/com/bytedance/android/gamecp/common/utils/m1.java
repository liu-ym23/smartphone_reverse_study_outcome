package com.bytedance.android.gamecp.common.utils;

import android.content.SharedPreferences;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f57241a = 0;

    public m1() {
    }

    static {
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "spKey");
        Lazy r101 = Sp.f57189a;
        SharedPreferences r102 = (SharedPreferences) r101.getValue();
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(String.class)) == false) goto L5;
        Object r103 = f1.d(r102, r100);
    L43:
        String r104 = (String) r103;
        long r105 = System.currentTimeMillis();
        if (r104 != null) goto L46;
    L49:
        boolean r106 = true;
    L50:
        if (r106 == false) goto L52;
        f1.g((SharedPreferences) r101.getValue(), r100, String.valueOf(r105));
        return;
    L52:
        f1.g((SharedPreferences) r101.getValue(), r100, r105 + '#' + r104);
        return;
    L46:
        if (r104.length() == 0) goto L49;
        r106 = false;
        goto L50
    L5:
        Object r107 = null;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Boolean.TYPE)) == false) goto L13;
        Boolean r108 = Boolean.valueOf(f1.f(r102, r100));
        if ((r108 instanceof String) == false) goto L11;
        r107 = r108;
    L11:
        r103 = (String) r107;
        goto L43
    L13:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L20;
        Float r109 = Float.valueOf(f1.a(r102, r100));
        if ((r109 instanceof String) == false) goto L18;
        r107 = r109;
    L18:
        r103 = (String) r107;
        goto L43
    L20:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L27;
        Long r110 = Long.valueOf(f1.c(r102, r100));
        if ((r110 instanceof String) == false) goto L25;
        r107 = r110;
    L25:
        r103 = (String) r107;
        goto L43
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L34;
        Integer r111 = Integer.valueOf(f1.b(r102, r100));
        if ((r111 instanceof String) == false) goto L32;
        r107 = r111;
    L32:
        r103 = (String) r107;
        goto L43
    L34:
        if (Set.class.isAssignableFrom(String.class) == false) goto L40;
        Set<String> r112 = f1.e(r102, r100, new HashSet());
        if ((r112 instanceof String) == false) goto L39;
        r107 = r112;
    L39:
        r103 = (String) r107;
        goto L43
    L40:
        yr.b.b(6, "Sp", "return type no support " + Reflection.getOrCreateKotlinClass(String.class));
        if (cs.a.a() == true) goto L55;
        r103 = String.class.newInstance();
        goto L43
    L55:
        throw new Exception("get " + r100 + " sp is  no support " + Reflection.getOrCreateKotlinClass(String.class) + '}');
    }

    public static boolean b(String r210, List r211) {
        Intrinsics.checkNotNullParameter(r210, "spKey");
        List r100 = r211;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L155;
        if (r211 == null) goto L19;
        Iterator r102 = r211.iterator();
    L14:
        if (r102.hasNext() == false) goto L19;
        Pair r103 = (Pair) r102.next();
        int r104 = ((Number) r103.component1()).intValue();
        int r105 = ((Number) r103.component2()).intValue();
        if (r104 <= 0) goto L155;
        if (r105 > 0) goto L14;
    L19:
        Intrinsics.checkNotNullParameter(r210, "spKey");
        SharedPreferences r106 = (SharedPreferences) Sp.f57189a.getValue();
        int r107 = 6;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(String.class)) == false) goto L23;
        Object r108 = f1.d(r106, r210);
    L55:
        String r110 = (String) r108;
        if (r110 != null) goto L58;
    L61:
        boolean r109 = true;
    L63:
        if (r109 == false) goto L65;
        int r111 = 0;
    L67:
        if (r111 != 0) goto L69;
        yr.b.b(4, "FrequencyManager", "isReachLimit, totalVisitCount=0");
    L157:
        return false;
    L69:
        if (r211 == null) goto L156;
        Iterator r112 = r211.iterator();
    L72:
        if (r112.hasNext() == false) goto L156;
        Pair r113 = (Pair) r112.next();
        int r114 = ((Number) r113.component1()).intValue();
        int r115 = ((Number) r113.component2()).intValue();
        Intrinsics.checkNotNullParameter(r210, "spKey");
        if (r114 > 0) goto L161;
    L123:
        int r116 = r115;
        int r117 = 0;
    L150:
        if (r117 == (-1)) goto L154;
        if (r117 >= r116) goto L154;
        r107 = 6;
    L154:
        yr.b.b(4, "FrequencyManager", "isReachLimit, day=" + r114 + ", dayVisitCount=" + r117 + ", visitMax=" + r116);
        Intrinsics.checkNotNullParameter(r210, "spKey");
        goto L155
    L161:
        SharedPreferences r118 = (SharedPreferences) Sp.f57189a.getValue();     // Catch: Exception -> L144
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(String.class)) == false) goto L80;
        Object r119 = f1.d(r118, r210);     // Catch: Exception -> L144
    L112:
        String r212 = (String) r119;     // Catch: Exception -> L144
        if (r212 != null) goto L115;
    L118:
        boolean r120 = true;
    L119:
        if (r120 == true) goto L123;
        List r121 = StringsKt.split$default(r212, new String[]{"#"}, false, 0, 6, null);     // Catch: Exception -> L144
        if (r121.isEmpty() == true) goto L123;
        r116 = r115;
        long r122 = System.currentTimeMillis();     // Catch: Exception -> L142
        Calendar r123 = Calendar.getInstance();     // Catch: Exception -> L142
        r123.setTime(new Date(r122));     // Catch: Exception -> L142
        r123.set(11, 0);     // Catch: Exception -> L142
        r123.set(12, 0);     // Catch: Exception -> L142
        r123.set(13, 0);     // Catch: Exception -> L142
        r123.set(14, 0);     // Catch: Exception -> L142
        long r213 = r123.getTimeInMillis() - ((long) ((r114 - 1) * BaseConstants.Time.DAY));     // Catch: Exception -> L142
        Iterator r124 = r121.iterator();     // Catch: Exception -> L142
        r117 = 0;
    L127:
        if (r124.hasNext() == false) goto L150;
        String r125 = (String) r124.next();     // Catch: Exception -> L142
        Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L131
        Object r127 = Result.m9449constructorimpl(Long.valueOf(CastLongProtector.parseLong(r125)));     // Catch: Throwable -> L131
    L134:
        if (Result.m9455isFailureimpl(r127) == false) goto L136;
        r127 = null;
    L136:
        Long r128 = (Long) r127;     // Catch: Exception -> L142
        if (r128 == null) goto L127;
        if (r128.longValue() < r213) goto L150;
        r117 = r117 + 1;     // Catch: Exception -> L142
    L131:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Exception -> L142
        r127 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L142
    L142:
        e = e;
    L148:
        yr.b.b(6, "FrequencyManager", "getXDayVisitCount erorr, cause: " + e);
        r117 = -1;
        goto L150
    L115:
        if (r212.length() == 0) goto L118;
        r120 = false;
        goto L119
    L80:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Boolean.TYPE)) == false) goto L86;
        Object r130 = Boolean.valueOf(f1.f(r118, r210));     // Catch: Exception -> L144
        if ((r130 instanceof String) == true) goto L84;
        r130 = null;
    L84:
        r119 = (String) r130;     // Catch: Exception -> L144
        goto L112
    L86:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L92;
        Object r131 = Float.valueOf(f1.a(r118, r210));     // Catch: Exception -> L144
        if ((r131 instanceof String) == true) goto L90;
        r131 = null;
    L90:
        r119 = (String) r131;     // Catch: Exception -> L144
        goto L112
    L92:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L98;
        Object r132 = Long.valueOf(f1.c(r118, r210));     // Catch: Exception -> L144
        if ((r132 instanceof String) == true) goto L96;
        r132 = null;
    L96:
        r119 = (String) r132;     // Catch: Exception -> L144
        goto L112
    L98:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L104;
        Object r133 = Integer.valueOf(f1.b(r118, r210));     // Catch: Exception -> L144
        if ((r133 instanceof String) == true) goto L102;
        r133 = null;
    L102:
        r119 = (String) r133;     // Catch: Exception -> L144
        goto L112
    L104:
        if (Set.class.isAssignableFrom(String.class) == false) goto L109;
        Object r134 = f1.e(r118, r210, new HashSet());     // Catch: Exception -> L144
        if ((r134 instanceof String) == true) goto L108;
        r134 = null;
    L108:
        r119 = (String) r134;     // Catch: Exception -> L144
        goto L112
    L109:
        yr.b.b(r107, "Sp", "return type no support " + Reflection.getOrCreateKotlinClass(String.class));     // Catch: Exception -> L144
        if (cs.a.a() == true) goto L146;
        r119 = String.class.newInstance();     // Catch: Exception -> L144
        goto L112
    L146:
        r116 = r115;
        throw new Exception("get " + r210 + " sp is  no support " + Reflection.getOrCreateKotlinClass(String.class) + '}');     // Catch: Exception -> L142
    L144:
        e = e;
        r116 = r115;
    L156:
        yr.b.b(4, "FrequencyManager", "isReachLimit, no reach limit");
        Intrinsics.checkNotNullParameter(r210, "spKey");
        goto L157
    L65:
        r111 = StringsKt.split$default(r110, new String[]{"#"}, false, 0, 6, null).size();
        goto L67
    L58:
        if (r110.length() == 0) goto L61;
        r109 = false;
        goto L63
    L23:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Boolean.TYPE)) == false) goto L29;
        Object r135 = Boolean.valueOf(f1.f(r106, r210));
        if ((r135 instanceof String) == true) goto L27;
        r135 = null;
    L27:
        r108 = (String) r135;
        goto L55
    L29:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L35;
        Object r136 = Float.valueOf(f1.a(r106, r210));
        if ((r136 instanceof String) == true) goto L33;
        r136 = null;
    L33:
        r108 = (String) r136;
        goto L55
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Object r137 = Long.valueOf(f1.c(r106, r210));
        if ((r137 instanceof String) == true) goto L39;
        r137 = null;
    L39:
        r108 = (String) r137;
        goto L55
    L41:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L47;
        Object r138 = Integer.valueOf(f1.b(r106, r210));
        if ((r138 instanceof String) == true) goto L45;
        r138 = null;
    L45:
        r108 = (String) r138;
        goto L55
    L47:
        if (Set.class.isAssignableFrom(String.class) == false) goto L52;
        Object r139 = f1.e(r106, r210, new HashSet());
        if ((r139 instanceof String) == true) goto L51;
        r139 = null;
    L51:
        r108 = (String) r139;
        goto L55
    L52:
        yr.b.b(6, "Sp", "return type no support " + Reflection.getOrCreateKotlinClass(String.class));
        if (cs.a.a() == true) goto L160;
        r108 = String.class.newInstance();
        goto L55
    L160:
        throw new Exception("get " + r210 + " sp is  no support " + Reflection.getOrCreateKotlinClass(String.class) + '}');
    L155:
        return true;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }
}
