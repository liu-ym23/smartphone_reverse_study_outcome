package com.bytedance.android.rts.util;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.rts.foundation.j;
import com.bytedance.rts.foundation.m;
import com.bytedance.rts.foundation.r;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f163405a = null;

    public static final class a {
        public a() {
        }

        public static Map a(String r100) {
            LinkedHashMap r101 = new LinkedHashMap();
            if (r100 == null) goto L5;
            int r102 = j.d(r.f(r100, "?", -1));
        L7:
            if (r102 <= 1) goto L11;
            if (r100 == null) goto L10;
            String r103 = (String) ListProtector.get(r.f(r100, "?", -1), 1);
        L12:
            if (r103 == null) goto L17;
            Iterator<T> r104 = r.f(r103, "&", -1).iterator();
        L15:
            if (r104.hasNext() == false) goto L17;
            ArrayList<String> r105 = r.f((String) r104.next(), ContainerUtils.KEY_VALUE_DELIMITER, -1);
            m.e(r101, ListProtector.get(r105, 0), ListProtector.get(r105, 1));
        L17:
            return r101;
        L10:
            r103 = null;
            goto L12
        L11:
            r103 = "";
            goto L12
        L5:
            r102 = 0;
            goto L7
        }

        public static String b(String r110) {
            Intrinsics.checkNotNullParameter("style", "paramName");
            if (r110 == null) goto L5;
            int r100 = StringsKt.indexOf$default(r110, "#", 0, false, 6, null);
        L7:
            if (r100 == (-1)) goto L11;
            if (r110 == null) goto L10;
            r110 = r.e(r110, 0, r100);
            goto L11
        L10:
            r110 = null;
        L11:
            if (r110 == null) goto L13;
            Integer r101 = Integer.valueOf(StringsKt.indexOf$default(r110, "?", 0, false, 6, null));
        L14:
            if (r101 != null) goto L17;
        L18:
            if (r101 != null) goto L21;
        L43:
            return null;
        L21:
            if (r110 == null) goto L23;
            String r111 = r.e(r110, r101.intValue() + 1, r110.length());
        L25:
            if (Intrinsics.areEqual(r111, "") == false) goto L27;
            return null;
        L27:
            if (r111 == null) goto L29;
            ArrayList<String> r112 = r.f(r111, "&", -1);
        L30:
            int r102 = 0;
        L31:
            if (r112 == null) goto L33;
            Integer r103 = Integer.valueOf(j.d(r112));
        L35:
            if (r102 >= r103.intValue()) goto L43;
            Intrinsics.checkNotNull(r112);
            ArrayList<String> r104 = r.f((String) ListProtector.get(r112, r102), ContainerUtils.KEY_VALUE_DELIMITER, -1);
            if (j.d(r104) != 2) goto L42;
            String r105 = (String) ListProtector.get(r104, 0);
            String r106 = (String) ListProtector.get(r104, 1);
            if (Intrinsics.areEqual(r105, "style") == false) goto L42;
            return r106;
        L42:
            r102 = r102 + 1;
            goto L31
        L33:
            r103 = null;
            goto L35
        L29:
            r112 = null;
            goto L30
        L23:
            r111 = null;
            goto L25
        L17:
            if (r101.intValue() == (-1)) goto L43;
        L13:
            r101 = null;
            goto L14
        L5:
            r100 = 0;
            goto L7
        }

        public static void c(String r110, String r111) {
            Intrinsics.checkNotNullParameter("city_code", "paramName");
            if (r111 == null) goto L5;
            ArrayList<String> r112 = r.f(r111, "#", 2);
        L6:
            String r100 = (String) ListProtector.get(r112, 0);
            String r113 = (String) ListProtector.get(r112, 1);
            ArrayList<String> r101 = r.f(r100, "?", 2);
            String r102 = (String) ListProtector.get(r101, 0);
            String r103 = (String) ListProtector.get(r101, 1);
            ArrayList r104 = j.k(new ArrayList[0]);
            if ((!Intrinsics.areEqual(r103, "")) == false) goto L21;
            ArrayList<String> r105 = r.f(r103, "&", -1);
            int r114 = 0;
        L10:
            if (r114 >= j.d(r105)) goto L21;
            ArrayList<String> r115 = r.f((String) ListProtector.get(r105, r114), ContainerUtils.KEY_VALUE_DELIMITER, -1);
            if (j.d(r115) != 2) goto L20;
            String r116 = (String) ListProtector.get(r115, 0);
            String r117 = (String) ListProtector.get(r115, 1);
            if (Intrinsics.areEqual(r116, "city_code") == false) goto L19;
            if (r110 != null) goto L18;
            r117 = "";
            goto L19
        L18:
            r117 = r110;
        L19:
            j.j(r104, j.k(new String[]{r116, r117}));
        L20:
            r114 = r114 + 1;
        L21:
            j.g(j.h(r104, RTSLiveUrlUtils$Companion$setUrlParams$newQueryString$1.INSTANCE), "&");
            if ((!Intrinsics.areEqual(r113, "")) == false) goto L28;
            new StringBuilder("#").append(r113);
            return;
        L28:
            return;
        L5:
            r112 = j.k(new String[]{"", ""});
            goto L6
        }
    }

    static {
        f163405a = new a();
    }
}
