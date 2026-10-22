package com.bytedance.android.shopping.store.slicecard;

import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoBehaviors;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u001c\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/store/slicecard/SliceActionType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "GROUP", "PRODUCT_ADD_CART", "TRACK", "TOAST", "UPDATE_ITEM_STATES", "UPDATE_ITEM_STATUS_SELF", "OPEN_SCHEMA", "OPEN_LIVE_ROOM_SCHEMA", "FOLLOW_SHOP", "PRODUCT_SUBSCRIBE", "TRACK_SHOW_PRODUCT", "OPEN_PRODUCT_DETAIL", "SHARE", "SEARCH", "CLICK_SORT_ITEM", "CLICK_SWITCH_LAYOUT", "CLOSE_SHOP", "CLOSE_SPLIT", "OPEN_PRODUCT_DETAIL_WITH_CALLBACK", "CLOSE", "PUBLISH_X_EVENT", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SliceActionType extends Enum<SliceActionType> {
    public static final SliceActionType CLICK_SORT_ITEM = null;
    public static final SliceActionType CLICK_SWITCH_LAYOUT = null;
    public static final SliceActionType CLOSE = null;
    public static final SliceActionType CLOSE_SHOP = null;
    public static final SliceActionType CLOSE_SPLIT = null;
    public static final a Companion = null;
    public static final SliceActionType FOLLOW_SHOP = null;
    public static final SliceActionType GROUP = null;
    public static final SliceActionType OPEN_LIVE_ROOM_SCHEMA = null;
    public static final SliceActionType OPEN_PRODUCT_DETAIL = null;
    public static final SliceActionType OPEN_PRODUCT_DETAIL_WITH_CALLBACK = null;
    public static final SliceActionType OPEN_SCHEMA = null;
    public static final SliceActionType PRODUCT_ADD_CART = null;
    public static final SliceActionType PRODUCT_SUBSCRIBE = null;
    public static final SliceActionType PUBLISH_X_EVENT = null;
    public static final SliceActionType SEARCH = null;
    public static final SliceActionType SHARE = null;
    public static final SliceActionType TOAST = null;
    public static final SliceActionType TRACK = null;
    public static final SliceActionType TRACK_SHOW_PRODUCT = null;
    public static final SliceActionType UPDATE_ITEM_STATES = null;
    public static final SliceActionType UPDATE_ITEM_STATUS_SELF = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SliceActionType[] f186327a = null;
    private final String type;

    public static final class a {
        public a() {
        }

        public static SliceActionType a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            SliceActionType[] r101 = SliceActionType.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            SliceActionType r104 = r101[r103];
            if (Intrinsics.areEqual(r104.getType(), r100) == true) goto L12;
            r103 = r103 + 1;
            goto L3
        L12:
            return r104;
        L8:
            return null;
        }
    }

    public static SliceActionType valueOf(String r100) {
        return (SliceActionType) r27.a.a(SliceActionType.class, r100);
    }

    public static SliceActionType[] values() {
        return (SliceActionType[]) f186327a.clone();
    }

    static {
        SliceActionType r100 = new SliceActionType("GROUP", 0, "Group");
        GROUP = r100;
        SliceActionType r101 = new SliceActionType("PRODUCT_ADD_CART", 1, "ProductAddCart");
        PRODUCT_ADD_CART = r101;
        SliceActionType r102 = new SliceActionType("TRACK", 2, "Track");
        TRACK = r102;
        SliceActionType r103 = new SliceActionType("TOAST", 3, "Toast");
        TOAST = r103;
        SliceActionType r104 = new SliceActionType("UPDATE_ITEM_STATES", 4, "UpdateItemStates");
        UPDATE_ITEM_STATES = r104;
        SliceActionType r105 = new SliceActionType("UPDATE_ITEM_STATUS_SELF", 5, "UpdateSelfItemStates");
        UPDATE_ITEM_STATUS_SELF = r105;
        SliceActionType r106 = new SliceActionType("OPEN_SCHEMA", 6, "OpenSchema");
        OPEN_SCHEMA = r106;
        SliceActionType r107 = new SliceActionType("OPEN_LIVE_ROOM_SCHEMA", 7, "OpenLiveRoomSchema");
        OPEN_LIVE_ROOM_SCHEMA = r107;
        SliceActionType r108 = new SliceActionType("FOLLOW_SHOP", 8, "FollowShop");
        FOLLOW_SHOP = r108;
        SliceActionType r109 = new SliceActionType("PRODUCT_SUBSCRIBE", 9, "ProductSubscribe");
        PRODUCT_SUBSCRIBE = r109;
        SliceActionType r110 = new SliceActionType("TRACK_SHOW_PRODUCT", 10, "TrackShowProduct");
        TRACK_SHOW_PRODUCT = r110;
        SliceActionType r111 = new SliceActionType("OPEN_PRODUCT_DETAIL", 11, "OpenProductDetail");
        OPEN_PRODUCT_DETAIL = r111;
        SliceActionType r112 = new SliceActionType("SHARE", 12, "Share");
        SHARE = r112;
        SliceActionType r113 = new SliceActionType("SEARCH", 13, "Search");
        SEARCH = r113;
        SliceActionType r114 = new SliceActionType("CLICK_SORT_ITEM", 14, "ClickSortItem");
        CLICK_SORT_ITEM = r114;
        SliceActionType r115 = new SliceActionType("CLICK_SWITCH_LAYOUT", 15, "ClickSwitchLayout");
        CLICK_SWITCH_LAYOUT = r115;
        SliceActionType r116 = new SliceActionType("CLOSE_SHOP", 16, "CloseShop");
        CLOSE_SHOP = r116;
        SliceActionType r117 = new SliceActionType("CLOSE_SPLIT", 17, "CloseSplit");
        CLOSE_SPLIT = r117;
        SliceActionType r118 = new SliceActionType("OPEN_PRODUCT_DETAIL_WITH_CALLBACK", 18, "OpenProductDetailWithCallback");
        OPEN_PRODUCT_DETAIL_WITH_CALLBACK = r118;
        SliceActionType r119 = new SliceActionType("CLOSE", 19, CancelRetainContactInfoBehaviors.ClosePage);
        CLOSE = r119;
        SliceActionType r120 = new SliceActionType("PUBLISH_X_EVENT", 20, "PublishXEvent");
        PUBLISH_X_EVENT = r120;
        f186327a = new SliceActionType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120};
        Companion = new a();
    }

    public final String getType() {
        return this.type;
    }

    public SliceActionType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
