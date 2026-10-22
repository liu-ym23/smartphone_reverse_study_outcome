package com.bytedance.android.live.v3;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements sb1.a {
    public b() {
    }

    public static boolean b(Object r100, Object r101) {
        if ((r101 instanceof ArrayList) == true) goto L5;
        return false;
    L5:
        ArrayList r102 = (ArrayList) r101;
        if (r102.isEmpty() == false) goto L8;
        return false;
    L8:
        Object r103 = ListProtector.get(r102, 0);
        if ((r103 instanceof Integer) == false) goto L27;
        int r104 = com.bytedance.android.live.impl.b.c(r100);
        Iterable r105 = (Iterable) r101;
        if ((r105 instanceof Collection) == true) goto L13;
    L15:
        Iterator r106 = r105.iterator();
    L17:
        if (r106.hasNext() == false) goto L106;
        Object r107 = r106.next();
        if ((r107 instanceof Integer) == true) goto L21;
    L23:
        boolean r108 = false;
    L24:
        if (r108 == false) goto L17;
    L79:
        return true;
    L21:
        if (Intrinsics.areEqual(r107, Integer.valueOf(r104)) == false) goto L23;
        r108 = true;
        goto L24
    L106:
        return false;
    L13:
        if (((Collection) r105).isEmpty() == false) goto L15;
        return false;
    L27:
        if ((r103 instanceof Double) == false) goto L45;
        double r109 = com.bytedance.android.live.impl.b.b(r100);
        Iterable r110 = (Iterable) r101;
        if ((r110 instanceof Collection) == true) goto L31;
    L33:
        Iterator r111 = r110.iterator();
    L35:
        if (r111.hasNext() == false) goto L107;
        Object r112 = r111.next();
        if ((r112 instanceof Double) == true) goto L39;
    L41:
        boolean r113 = false;
    L42:
        if (r113 == false) goto L35;
    L39:
        if (Intrinsics.areEqual((Double) r112, r109) == false) goto L41;
        r113 = true;
        goto L42
    L107:
        return false;
    L31:
        if (((Collection) r110).isEmpty() == false) goto L33;
        return false;
    L45:
        if ((r103 instanceof Long) == false) goto L63;
        long r114 = com.bytedance.android.live.impl.b.d(r100);
        Iterable r115 = (Iterable) r101;
        if ((r115 instanceof Collection) == true) goto L49;
    L51:
        Iterator r116 = r115.iterator();
    L53:
        if (r116.hasNext() == false) goto L108;
        Object r117 = r116.next();
        if ((r117 instanceof Long) == true) goto L57;
    L59:
        boolean r118 = false;
    L60:
        if (r118 == false) goto L53;
    L57:
        if (Intrinsics.areEqual(r117, Long.valueOf(r114)) == false) goto L59;
        r118 = true;
        goto L60
    L108:
        return false;
    L49:
        if (((Collection) r115).isEmpty() == false) goto L51;
        return false;
    L63:
        if ((r103 instanceof String) == false) goto L101;
        String r119 = com.bytedance.android.live.impl.b.e(r100);
        Iterable r120 = (Iterable) r101;
        if ((r120 instanceof Collection) == true) goto L67;
    L69:
        Iterator r121 = r120.iterator();
    L71:
        if (r121.hasNext() == false) goto L109;
        Object r122 = r121.next();
        if ((r122 instanceof String) == true) goto L75;
    L77:
        boolean r123 = false;
    L78:
        if (r123 == false) goto L71;
    L75:
        if (Intrinsics.areEqual(r122, r119) == false) goto L77;
        r123 = true;
        goto L78
    L109:
        return false;
    L67:
        if (((Collection) r120).isEmpty() == false) goto L69;
        return false;
    L101:
        return false;
    }

    public static boolean c(Object r100, Object r101) {
        boolean r102 = r101 instanceof Integer;
        if (r102 == false) goto L11;
        int r103 = com.bytedance.android.live.impl.b.c(r100);
        if (r102 == true) goto L8;
    L23:
        return false;
    L8:
        if (r103 != ((Integer) r101).intValue()) goto L23;
    L22:
        return true;
    L11:
        if ((r101 instanceof Double) == true) goto L13;
        boolean r104 = r101 instanceof Long;
        if (r104 == false) goto L25;
        long r105 = com.bytedance.android.live.impl.b.d(r100);
        if (r104 == false) goto L23;
        if (r105 != ((Long) r101).longValue()) goto L23;
    L25:
        return Intrinsics.areEqual(r100, r101);
    L13:
        if (com.bytedance.android.live.impl.b.b(r100) != ((Number) r101).doubleValue()) goto L23;
        goto L23
    }

    public static boolean d(Object r100, Object r110) {
        if ((r110 instanceof ArrayList) == false) goto L49;
        ArrayList r111 = (ArrayList) r110;
        if (r111.size() != 2) goto L58;
        Object r101 = ListProtector.get(r111, 0);
        Object r102 = null;
        if ((r101 instanceof Integer) == false) goto L22;
        int r103 = com.bytedance.android.live.impl.b.c(r100);
        if (r103 < ((Integer) r101).intValue()) goto L50;
        Object r112 = ListProtector.get(r111, 1);
        if ((r112 instanceof Integer) == false) goto L15;
        r102 = r112;
    L15:
        Integer r104 = (Integer) r102;
        if (r104 != null) goto L18;
        return false;
    L18:
        if (r103 > r104.intValue()) goto L51;
    L47:
        return true;
    L51:
        return false;
    L50:
        return false;
    L22:
        if ((r101 instanceof Double) == false) goto L36;
        double r105 = com.bytedance.android.live.impl.b.b(r100);
        if (r105 < ((Double) r101).doubleValue()) goto L52;
        Object r106 = ListProtector.get(r111, 1);
        if ((r106 instanceof Double) == false) goto L29;
        r102 = r106;
    L29:
        Double r107 = (Double) r102;
        if (r107 != null) goto L32;
        return false;
    L32:
        if (r105 <= r107.doubleValue()) goto L47;
        return false;
    L52:
        return false;
    L36:
        if ((r101 instanceof Long) == false) goto L54;
        long r108 = com.bytedance.android.live.impl.b.d(r100);
        if (r108 < ((Long) r101).longValue()) goto L55;
        Object r109 = ListProtector.get(r111, 1);
        if ((r109 instanceof Long) == false) goto L43;
        r102 = r109;
    L43:
        Long r113 = (Long) r102;
        if (r113 != null) goto L46;
        return false;
    L46:
        if (r108 <= r113.longValue()) goto L47;
        return false;
    L55:
        return false;
    L54:
        return false;
    L58:
        return false;
    L49:
        return false;
    }

    @Override // sb1.a
    public final boolean a(Object r100, Object r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "currentCharacter");
        if (r101 == null) goto L105;
        if (r102 == null) goto L105;
        switch(r102.hashCode()) {
            case -913705004: goto L104;
            case -567445985: goto L102;
            case -83901120: goto L97;
            case 60: goto L80;
            case 62: goto L63;
            case 1084: goto L58;
            case 1921: goto L41;
            case 1952: goto L38;
            case 1983: goto L21;
            case 3365: goto L18;
            case 35078: goto L13;
            case 96673: goto L10;
            default: goto L105;
        };
    L104:
        r102.equals("all not");
        goto L105
    L10:
        if (r102.equals("all") == false) goto L105;
    L100:
        return true;
    L13:
        if (r102.equals("!in") == false) goto L105;
        if (d(r100, r101) == true) goto L105;
    L18:
        if (r102.equals("in") == false) goto L105;
        return d(r100, r101);
    L21:
        if (r102.equals(">=") == false) goto L105;
        if ((r101 instanceof Integer) == false) goto L28;
        if (com.bytedance.android.live.impl.b.c(r100) < ((Number) r101).intValue()) goto L105;
    L28:
        if ((r101 instanceof Double) == false) goto L33;
        if (com.bytedance.android.live.impl.b.b(r100) < ((Number) r101).doubleValue()) goto L105;
    L33:
        if ((r101 instanceof Long) == false) goto L105;
        if (com.bytedance.android.live.impl.b.d(r100) < ((Number) r101).longValue()) goto L105;
    L38:
        if (r102.equals("==") == false) goto L105;
        return c(r100, r101);
    L41:
        if (r102.equals("<=") == false) goto L105;
        if ((r101 instanceof Integer) == false) goto L48;
        if (com.bytedance.android.live.impl.b.c(r100) > ((Number) r101).intValue()) goto L105;
    L48:
        if ((r101 instanceof Double) == false) goto L53;
        if (com.bytedance.android.live.impl.b.b(r100) > ((Number) r101).doubleValue()) goto L105;
    L53:
        if ((r101 instanceof Long) == false) goto L105;
        if (com.bytedance.android.live.impl.b.d(r100) > ((Number) r101).longValue()) goto L105;
    L58:
        if (r102.equals("!=") == false) goto L105;
        if (c(r100, r101) == true) goto L105;
    L63:
        if (r102.equals(">") == false) goto L105;
        if ((r101 instanceof Integer) == false) goto L70;
        if (com.bytedance.android.live.impl.b.c(r100) <= ((Number) r101).intValue()) goto L105;
    L70:
        if ((r101 instanceof Double) == false) goto L75;
        if (com.bytedance.android.live.impl.b.b(r100) <= ((Number) r101).doubleValue()) goto L105;
    L75:
        if ((r101 instanceof Long) == false) goto L105;
        if (com.bytedance.android.live.impl.b.d(r100) <= ((Number) r101).longValue()) goto L105;
    L80:
        if (r102.equals("<") == false) goto L105;
        if ((r101 instanceof Integer) == false) goto L87;
        if (com.bytedance.android.live.impl.b.c(r100) >= ((Number) r101).intValue()) goto L105;
    L87:
        if ((r101 instanceof Double) == false) goto L92;
        if (com.bytedance.android.live.impl.b.b(r100) >= ((Number) r101).doubleValue()) goto L105;
    L92:
        if ((r101 instanceof Long) == false) goto L105;
        if (com.bytedance.android.live.impl.b.d(r100) >= ((Number) r101).longValue()) goto L105;
    L97:
        if (r102.equals("!contains") == false) goto L105;
        if (b(r100, r101) == true) goto L105;
    L102:
        if (r102.equals("contains") == false) goto L105;
        return b(r100, r101);
    L105:
        return false;
    }
}
