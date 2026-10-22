package com.bytedance.android.shopping.anchorv3.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f165356a = 0;

    static {
    }

    public static String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "enterMethod");
        switch(r100.hashCode()) {
            case -2032820721: goto L57;
            case -1743475325: goto L54;
            case -1576467622: goto L51;
            case -1489749402: goto L48;
            case -1405530461: goto L45;
            case -1195363553: goto L42;
            case -1042897765: goto L39;
            case -1008311216: goto L36;
            case -985715424: goto L33;
            case -762577321: goto L30;
            case -690537951: goto L27;
            case 153863135: goto L24;
            case 349301470: goto L21;
            case 433931546: goto L18;
            case 1243267108: goto L15;
            case 1705178010: goto L12;
            case 2089057309: goto L9;
            case 2143185499: goto L6;
            default: goto L59;
        };
    L59:
        return "open_url";
    L6:
        if (r100.equals("ec_recommend") == false) goto L59;
        return "ec_recommend";
    L9:
        if (r100.equals("click_search_result") == false) goto L59;
        return "search_result";
    L12:
        if (r100.equals("click_transform_card") == false) goto L59;
        return "transform_card";
    L15:
        if (r100.equals("click_related_product") == false) goto L59;
        return "full_screen_card";
    L18:
        if (r100.equals("click_store_product") == false) goto L59;
        return "store_page";
    L21:
        if (r100.equals("ec_result") == false) goto L59;
        return "ec_result";
    L24:
        if (r100.equals("click_video_tag") == false) goto L59;
        return "video_cart_tag";
    L27:
        if (r100.equals("flagshop_im") == false) goto L59;
        return "flagshop_im";
    L30:
        if (r100.equals("click_live_commerce") == false) goto L59;
        return "live_slide_card";
    L33:
        if (r100.equals("click_shopping_cart") == false) goto L59;
        return "shopping_cart";
    L36:
        if (r100.equals("click_message") == false) goto L59;
        return com.bytedance.android.ec.core.event.a.KEY_MESSAGE;
    L39:
        if (r100.equals("click_track_card") == false) goto L59;
        return "track_card";
    L42:
        if (r100.equals("click_classification_result") == false) goto L59;
        return "classification_result";
    L45:
        if (r100.equals("click_tuwen_tag") == false) goto L59;
        return "tuwen_cart_tag";
    L48:
        if (r100.equals("click_guess_you_like_product") == false) goto L59;
        return "guess_you_like";
    L51:
        if (r100.equals("click_collection_card") == false) goto L59;
        return "collection_card";
    L54:
        if (r100.equals("click_comment_tag") == false) goto L59;
        return "comment_cart_tag";
    L57:
        if (r100.equals("click_pop_up_card") == false) goto L59;
        return "pop_up_card";
    }
}
