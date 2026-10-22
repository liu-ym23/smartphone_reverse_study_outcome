package com.bytedance.android.live.room.report;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f100249a = null;

    public static final class a {
        public a() {
        }

        public static String a(String r100, String r101) {
            if (Intrinsics.areEqual(r100, UserProfileEvent.POSITION_GUEST_LINK) == false) goto L6;
            return UserProfileEvent.POSITION_GUEST_LINK;
        L6:
            if (Intrinsics.areEqual(r100, UserProfileEvent.SOURCE_ANCHOR_AVATAR) == false) goto L9;
            return UserProfileEvent.DATA_TYPE_CARD_ANCHOR;
        L9:
            if (Intrinsics.areEqual(r101, UserProfileEvent.DATA_TYPE_CARD_PK_ANCHOR) == false) goto L12;
            return UserProfileEvent.DATA_TYPE_CARD_PK_ANCHOR;
        L12:
            if (Intrinsics.areEqual(r101, UserProfileEvent.DATA_TYPE_CARD_LINKED_ANCHOR) == false) goto L15;
            return UserProfileEvent.DATA_TYPE_CARD_LINKED_ANCHOR;
        L15:
            if (Intrinsics.areEqual(r100, UserProfileEvent.SOURCE_BARRAGE) == false) goto L19;
            return UserProfileEvent.DATA_TYPE_CARD_BARRAGE;
        L19:
            if (Intrinsics.areEqual(r100, "personal_profile") == false) goto L23;
            return UserProfileEvent.DATA_TYPE_CARD_AUDIENCE;
        L23:
            if (Intrinsics.areEqual(r101, UserProfileEvent.DATA_TYPE_CARD_HOURLY_RANK) == false) goto L26;
            return UserProfileEvent.DATA_TYPE_CARD_HOURLY_RANK;
        L26:
            if (Intrinsics.areEqual(r101, UserProfileEvent.DATA_TYPE_CARD_LINKED_AUDIENCE_MULTIAUDIENCE) == false) goto L29;
            return UserProfileEvent.DATA_TYPE_CARD_LINKED_AUDIENCE_MULTIAUDIENCE;
        L29:
            if (Intrinsics.areEqual(r101, UserProfileEvent.DATA_TYPE_CARD_LINKED_AUDIENCE) == false) goto L32;
            return UserProfileEvent.DATA_TYPE_CARD_LINKED_AUDIENCE;
        L32:
            if (Intrinsics.areEqual(r101, "user_gift") == false) goto L35;
            return UserProfileEvent.DATA_TYPE_CARD_SEND_GIFT_INFO;
        L35:
            if (Intrinsics.areEqual(r100, UserProfileEvent.POSITION_TOP_SINGLE_ROOM_RANK) == false) goto L39;
            return "data_card_contribution_list";
        L39:
            if (Intrinsics.areEqual(r100, UserProfileEvent.POSITION_SINGLE_ROOM_RANK) == false) goto L43;
            return "data_card_audience_list";
        L43:
            if (Intrinsics.areEqual(r101, "data_card_vip_list") == false) goto L46;
            return "data_card_vip_list";
        L46:
            if (Intrinsics.areEqual(r101, UserProfileEvent.DATA_TYPE_CARD_INCOME_INFO) == false) goto L48;
        L54:
            return UserProfileEvent.DATA_TYPE_CARD_INCOME_INFO;
        L48:
            if (Intrinsics.areEqual(r101, "null") == true) goto L54;
            if (r101 == null) goto L54;
            if (Intrinsics.areEqual(r101, UserProfileEvent.DATA_TYPE_CARD_SEND_GIFT_INFO) == true) goto L54;
            return UserProfileEvent.DATA_TYPE_CARD_ANCHOR;
        }

        public final String getType(String r100, String r101, boolean r102) {
            if (r102 == false) goto L6;
            return "report_message";
        L6:
            if (r100 != null) goto L8;
        L9:
            if (r101 != null) goto L11;
            return "report_user";
        L11:
            if (StringsKt.contains$default(r101, "anchor", false, 2, null) != true) goto L17;
            return "report_anchor";
        L17:
            return "report_user";
        L8:
            if (StringsKt.contains$default(r100, "anchor", false, 2, null) != true) goto L9;
            return "report_anchor";
        }
    }

    static {
        f100249a = new a();
    }
}
