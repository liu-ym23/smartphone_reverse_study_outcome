package com.bytedance.android.shopping.abscontainer.common_biz.custom_event.common;

import b43.c;
import i33.a;
import j33.f;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes12.dex */
public final class RegexCheck {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f164238a = 0;

    static {
    }

    public static void b(a r110, String r111, Map r112) {
        Object r100 = r112.get("failed_trigger");
        Object r101 = null;
        if ((r100 instanceof String) == true) goto L5;
        r100 = null;
    L5:
        String r102 = (String) r100;
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        Object r103 = r112.get("trigger_match_vo");
        if ((r103 instanceof Map) == true) goto L11;
        r103 = null;
    L11:
        final Map r104 = (Map) r103;
        boolean r105 = false;
        if (r104 == null) goto L32;
        List<z33.a> r113 = r110.c().o(new RegexCheck$triggerFailedEvent$matchedNodes$1(r104));
        if (r113 == null) goto L55;
        Iterator<T> r114 = r113.iterator();
    L17:
        if (r114.hasNext() == false) goto L58;
        z33.a r106 = (z33.a) r114.next();
        if (r102.length() <= 0) goto L21;
        boolean r107 = true;
    L22:
        if (r107 == false) goto L17;
        f r108 = r110.c();
        String r109 = r106.d();
        Object r115 = r112.get("scene");
        if ((r115 instanceof String) == true) goto L26;
        r115 = null;
    L26:
        String r116 = (String) r115;
        if (r116 != null) goto L29;
        String r117 = "";
    L30:
        r108.j(null, r109, r102, null, r117);
        goto L17
    L29:
        r117 = r116;
        goto L30
    L21:
        r107 = false;
        goto L22
    L58:
        return;
    L55:
        return;
    L32:
        if (r102.length() <= 0) goto L34;
        boolean r118 = true;
    L35:
        if (r118 == true) goto L37;
        return;
    L37:
        if (r111.length() <= 0) goto L39;
        r105 = true;
    L39:
        if (r105 == false) goto L57;
        f r119 = r110.c();
        Object r120 = r112.get("scene");
        if ((r120 instanceof String) == false) goto L44;
        r101 = r120;
    L44:
        String r121 = (String) r101;
        if (r121 != null) goto L47;
        String r122 = "";
    L48:
        r119.j(null, r111, r102, null, r122);
        return;
    L47:
        r122 = r121;
        goto L48
    L57:
        return;
    L34:
        r118 = false;
        goto L35
    }

    public static boolean a(String r100, a r101, List r102, Map r103, e43.a r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "selfEventName");
        Intrinsics.checkNotNullParameter(r101, "abilities");
        Intrinsics.checkNotNullParameter(r102, "regexRules");
        Intrinsics.checkNotNullParameter(r104, "eventData");
        Intrinsics.checkNotNullParameter(r105, "nodeId");
        Iterator r106 = r102.iterator();
    L3:
        boolean r107 = true;
        if (r106.hasNext() == false) goto L45;
        Map r108 = (Map) r106.next();
        Object r109 = r108.get("field_path");
        Object r110 = null;
        if ((r109 instanceof String) == true) goto L8;
        r109 = null;
    L8:
        String r111 = (String) r109;
        if (r111 != null) goto L11;
    L14:
        if (r107 == true) goto L38;
        Object r112 = r108.get("regex");
        if ((r112 instanceof String) == false) goto L20;
        r110 = r112;
    L20:
        String r113 = (String) r110;
        Object r114 = "";
        if (r113 != null) goto L23;
        r113 = "";
    L23:
        c r115 = c.f17507a;
        Object r116 = m43.a.a(r103, r111);
        if ((r116 instanceof Boolean) == false) goto L27;
        r114 = r116.toString();
    L35:
        if (new Regex(r113).matches((CharSequence) r114) == true) goto L3;
        b(r101, r105, r108);
        goto L38
    L27:
        if ((r116 instanceof Number) == false) goto L29;
        r114 = String.valueOf(r116);
        goto L35
    L29:
        if (r116 == null) goto L35;
        if ((r116 instanceof String) == false) goto L37;
        r114 = r116;
        goto L35
    L37:
        b(r101, r105, r108);
    L38:
        return false;
    L11:
        if (r111.length() == 0) goto L14;
        r107 = false;
        goto L14
    L45:
        return true;
    }
}
