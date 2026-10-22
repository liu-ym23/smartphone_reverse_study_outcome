package com.bytedance.android.livesdk.livecommerce.event;

/* JADX INFO: loaded from: classes10.dex */
public final class a1 extends u0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f147722d = 0;

    public static final class a {
        public static String a(boolean r100, boolean r101, boolean r102) {
            if (r101 == false) goto L4;
            String r103 = "livesdk_list_tab_more_";
        L6:
            if (r102 == false) goto L8;
            String r104 = "anchor_";
        L9:
            String r105 = r103.concat(r104);
            StringBuilder r106 = new StringBuilder();
            r106.append(r105);
            if (r100 == false) goto L12;
            String r107 = "show";
        L13:
            r106.append(r107);
            return r106.toString();
        L12:
            r107 = "click";
            goto L13
        L8:
            r104 = "";
            goto L9
        L4:
            r103 = "livesdk_list_tab_";
            goto L6
        }
    }

    static {
    }

    public a1(boolean r100, boolean r101) {
        super(a.a(r100, true, r101));
        f(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, "live_list_card");
        f("anchor_id", l0.i("anchor_id"));
        f("enter_from_merge", l0.d());
        f("enter_method", l0.i("enter_method"));
        f("room_id", l0.i("room_id"));
        f("page_name", "live_list");
        f("source_page", l0.n());
        f("group_id", l0.i("group_id"));
        f(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, l0.d());
        f(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, l0.e());
    }
}
