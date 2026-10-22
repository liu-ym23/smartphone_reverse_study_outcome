package com.bytedance.android.livesdk.livecommerce.eventcenter;

import com.bytedance.android.ec.core.utils.w0;
import kotlin.jvm.internal.Intrinsics;
import sl.m;
import sl.n;

/* JADX INFO: loaded from: classes10.dex */
public final class a {
    public static final com.bytedance.android.livesdk.livecommerce.ability.f<?> a(sl.g r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$convert2Standard");
        int r101 = r100.a();
        Object r102 = null;
        if (r101 != 1) goto L5;
        sl.a r103 = r100.b();
        if (r103 != null) goto L20;
        return null;
    L20:
        String r104 = c(r100.a(), r103.a());
        String r105 = "";
        switch(r104.hashCode()) {
            case -1236338690: goto L51;
            case -826929628: goto L42;
            case 804212474: goto L33;
            case 1045365711: goto L24;
            default: goto L60;
        };
    L24:
        if (r104.equals("add_cart_jump") == false) goto L60;
        int r106 = w0.f45736a;
        sl.a r107 = r100.b();
        if (r107 == null) goto L31;
        String r108 = r107.b();
        if (r108 == null) goto L31;
        r105 = r108;
    L31:
        r102 = w0.b(r105, sl.c.class);
        goto L60
    L33:
        if (r104.equals("add_cart_open_page_list") == false) goto L60;
        int r109 = w0.f45736a;
        sl.a r110 = r100.b();
        if (r110 == null) goto L40;
        String r111 = r110.b();
        if (r111 == null) goto L40;
        r105 = r111;
    L40:
        r102 = w0.b(r105, sl.d.class);
        goto L60
    L42:
        if (r104.equals("open_page_list_show_dialog") == false) goto L60;
        int r112 = w0.f45736a;
        sl.a r113 = r100.b();
        if (r113 == null) goto L49;
        String r114 = r113.b();
        if (r114 == null) goto L49;
        r105 = r114;
    L49:
        r102 = w0.b(r105, sl.f.class);
        goto L60
    L51:
        if (r104.equals("add_cart") == false) goto L60;
        int r115 = w0.f45736a;
        sl.a r116 = r100.b();
        if (r116 == null) goto L58;
        String r117 = r116.b();
        if (r117 == null) goto L58;
        r105 = r117;
    L58:
        r102 = w0.b(r105, sl.b.class);
    L60:
        return new com.bytedance.android.livesdk.livecommerce.ability.f("LiveList", r104, r102);
    L5:
        if (r101 != 3) goto L7;
        sl.k r118 = r100.c();
        if (r118 != null) goto L16;
        return null;
    L16:
        return new com.bytedance.android.livesdk.livecommerce.ability.f("LiveList", c(r100.a(), null), r118);
    L7:
        if (r101 == 4) goto L9;
        return null;
    L9:
        m r119 = r100.d();
        if (r119 != null) goto L12;
        return null;
    L12:
        return new com.bytedance.android.livesdk.livecommerce.ability.f("LiveList", c(r100.a(), null), new n(r119.a(), r119.b(), 4));
    }

    public static final Object b(String r100, sl.h r101) {
        String r102 = null;
        if (r101 != null) goto L5;
        return null;
    L5:
        int r103 = r100.hashCode();
        if (r103 == (-60996298)) goto L19;
        if (r103 == 1779691326) goto L11;
        return null;
    L11:
        if (r100.equals("biz_change_store") == false) goto L29;
        int r104 = w0.f45736a;
        sl.a r105 = r101.b();
        if (r105 == null) goto L16;
        String r106 = r105.b();
        if (r106 == null) goto L16;
    L30:
        return w0.b(r106, sl.e.class);
    L16:
        r106 = "";
        goto L30
    L29:
        return null;
    L19:
        if (r100.equals("open_schema") == false) goto L31;
        m r107 = r101.c();
        if (r107 == null) goto L23;
        int r108 = r107.a();
    L24:
        m r109 = r101.c();
        if (r109 == null) goto L28;
        r102 = r109.b();
    L28:
        return new n(r108, r102, 4);
    L23:
        r108 = 0;
        goto L24
    L31:
        return null;
    }

    public static final String c(int r100, String r101) {
        if (r100 != 1) goto L5;
        if (r101 != null) goto L14;
        return "none";
    L14:
        switch(r101.hashCode()) {
            case -2097270865: goto L29;
            case -811145358: goto L26;
            case -424159202: goto L23;
            case -2350374: goto L20;
            case 462619172: goto L17;
            default: goto L45;
        };
    L45:
        return "none";
    L17:
        if (r101.equals("OPEN_PAGE_LIST_SHOW_DIALOG") == false) goto L34;
        return "open_page_list_show_dialog";
    L34:
        return "none";
    L20:
        if (r101.equals("ADD_CART_OPEN_PAGE_LIST") == false) goto L36;
        return "add_cart_open_page_list";
    L36:
        return "none";
    L23:
        if (r101.equals("ADD_CART") == false) goto L38;
        return "add_cart";
    L38:
        return "none";
    L26:
        if (r101.equals("CHANGE_STORE") == false) goto L40;
        return "biz_change_store";
    L40:
        return "none";
    L29:
        if (r101.equals("ADD_CART_JUMP") == false) goto L42;
        return "add_cart_jump";
    L42:
        return "none";
    L5:
        if (r100 != 3) goto L7;
        return "show_dialog";
    L7:
        if (r100 != 4) goto L43;
        return "open_schema";
    L43:
        return "none";
    }
}
