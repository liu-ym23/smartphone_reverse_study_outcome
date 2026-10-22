package com.bytedance.android.live.service.preinflate;

import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0011\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0015\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010R\u001b\u0010\u001a\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0017\u0018\u00010\u00168F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019j\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/¨\u00060"}, d2 = {"Lcom/bytedance/android/live/service/preinflate/ProfilePreInflateViewInfo;", "", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "", "used", "Z", "getUsed", "()Z", "setUsed", "(Z)V", "", "getResId", "()I", "resId", "getTag", "tag", "getCount", "count", "Ljava/lang/Class;", "Landroid/view/View;", "getContainerViewClass", "()Ljava/lang/Class;", "containerViewClass", "TTLIVE_PROFILE_LAYOUT_PORT", "TTLIVE_PROFILE_LAYOUT_LAND", "TTLIVE_PROFILE_LAYOUT_HD", "TTLIVE_PROFILE_VISITOR_COUNT", "TTLIVE_PROFILE_GROUP_LIVE_MEMBER", "TTLIVE_PROFILE_GIFT_EXHIBITION_NEW", "TTLIVE_PROFILE_FANS_VIP", "TTLIVE_PROFILE_DRESS_PREVIEW", "TTLIVE_PROFILE_DRESS_PREVIEW_DEFAULT", "TTLIVE_PROFILE_TEXT_INFO", "TTLIVE_PROFILE_ANNOUNCE", "TTLIVE_PROFILE_FOLLOE_BUTTON", "TTLIVE_PROFILE_FANS_GROUP_BUTTON", "TTLIVE_PROFILE_BUTTON", "TTLIVE_PROFILE_OWNER_CENTER_BUTTON", "TTLIVE_PROFILE_ECOM_SET_BUTTON", "TTLIVE_PROFILE_HONOUR_CARD_NEW", "TTLIVE_PROFILE_TAG", "TTLIVE_PROFILE_POI_TAG", "TTLIVE_PROFILE_LIVE_HONOR_TAG", "TTLIVE_PROFILE_LOCAL_LIFE", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ProfilePreInflateViewInfo extends Enum<ProfilePreInflateViewInfo> {
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_ANNOUNCE = null;
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_BUTTON = null;
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_DRESS_PREVIEW = null;
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_DRESS_PREVIEW_DEFAULT = null;
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_ECOM_SET_BUTTON = null;
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_FANS_GROUP_BUTTON = null;
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_FANS_VIP = null;
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_FOLLOE_BUTTON = null;
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_GIFT_EXHIBITION_NEW = null;
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_GROUP_LIVE_MEMBER = null;
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_HONOUR_CARD_NEW = null;
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_LAYOUT_HD = null;
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_LAYOUT_LAND = null;
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_LAYOUT_PORT = null;
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_LIVE_HONOR_TAG = null;
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_LOCAL_LIFE = null;
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_OWNER_CENTER_BUTTON = null;
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_POI_TAG = null;
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_TAG = null;
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_TEXT_INFO = null;
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_VISITOR_COUNT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ProfilePreInflateViewInfo[] f100879a = null;
    private final String key;
    private boolean used;

    public ProfilePreInflateViewInfo() {
        throw null;
    }

    public static ProfilePreInflateViewInfo valueOf(String r100) {
        return (ProfilePreInflateViewInfo) r27.a.a(ProfilePreInflateViewInfo.class, r100);
    }

    public static ProfilePreInflateViewInfo[] values() {
        return (ProfilePreInflateViewInfo[]) f100879a.clone();
    }

    static {
        ProfilePreInflateViewInfo r100 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_LAYOUT_PORT", 0, "TTLIVE_PROFILE_LAYOUT_PORT", false, 2, null);
        TTLIVE_PROFILE_LAYOUT_PORT = r100;
        ProfilePreInflateViewInfo r101 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_LAYOUT_LAND", 1, "TTLIVE_PROFILE_LAYOUT_LAND", false, 2, null);
        TTLIVE_PROFILE_LAYOUT_LAND = r101;
        ProfilePreInflateViewInfo r102 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_LAYOUT_HD", 2, "TTLIVE_PROFILE_LAYOUT_HD", false, 2, null);
        TTLIVE_PROFILE_LAYOUT_HD = r102;
        ProfilePreInflateViewInfo r103 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_VISITOR_COUNT", 3, "TTLIVE_PROFILE_VISITOR_COUNT", false, 2, null);
        TTLIVE_PROFILE_VISITOR_COUNT = r103;
        ProfilePreInflateViewInfo r104 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_GROUP_LIVE_MEMBER", 4, "TTLIVE_PROFILE_GROUP_LIVE_MEMBER", false, 2, null);
        TTLIVE_PROFILE_GROUP_LIVE_MEMBER = r104;
        ProfilePreInflateViewInfo r105 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_GIFT_EXHIBITION_NEW", 5, "TTLIVE_PROFILE_GIFT_EXHIBITION_NEW", false, 2, null);
        TTLIVE_PROFILE_GIFT_EXHIBITION_NEW = r105;
        ProfilePreInflateViewInfo r106 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_FANS_VIP", 6, "TTLIVE_PROFILE_FANS_VIP", false, 2, null);
        TTLIVE_PROFILE_FANS_VIP = r106;
        ProfilePreInflateViewInfo r107 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_DRESS_PREVIEW", 7, "TTLIVE_PROFILE_DRESS_PREVIEW", false, 2, null);
        TTLIVE_PROFILE_DRESS_PREVIEW = r107;
        ProfilePreInflateViewInfo r108 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_DRESS_PREVIEW_DEFAULT", 8, "TTLIVE_PROFILE_DRESS_PREVIEW_DEFAULT", false, 2, null);
        TTLIVE_PROFILE_DRESS_PREVIEW_DEFAULT = r108;
        ProfilePreInflateViewInfo r109 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_TEXT_INFO", 9, "TTLIVE_PROFILE_TEXT_INFO", false, 2, null);
        TTLIVE_PROFILE_TEXT_INFO = r109;
        ProfilePreInflateViewInfo r110 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_ANNOUNCE", 10, "TTLIVE_PROFILE_ANNOUNCE", false, 2, null);
        TTLIVE_PROFILE_ANNOUNCE = r110;
        ProfilePreInflateViewInfo r111 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_FOLLOE_BUTTON", 11, "TTLIVE_PROFILE_FOLLOE_BUTTON", false, 2, null);
        TTLIVE_PROFILE_FOLLOE_BUTTON = r111;
        ProfilePreInflateViewInfo r112 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_FANS_GROUP_BUTTON", 12, "TTLIVE_PROFILE_FANS_GROUP_BUTTON", false, 2, null);
        TTLIVE_PROFILE_FANS_GROUP_BUTTON = r112;
        ProfilePreInflateViewInfo r113 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_BUTTON", 13, "TTLIVE_PROFILE_BUTTON", false, 2, null);
        TTLIVE_PROFILE_BUTTON = r113;
        ProfilePreInflateViewInfo r114 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_OWNER_CENTER_BUTTON", 14, "TTLIVE_PROFILE_OWNER_CENTER_BUTTON", false, 2, null);
        TTLIVE_PROFILE_OWNER_CENTER_BUTTON = r114;
        ProfilePreInflateViewInfo r115 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_ECOM_SET_BUTTON", 15, "TTLIVE_PROFILE_ECOM_SET_BUTTON", false, 2, null);
        TTLIVE_PROFILE_ECOM_SET_BUTTON = r115;
        ProfilePreInflateViewInfo r116 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_HONOUR_CARD_NEW", 16, "TTLIVE_PROFILE_HONOUR_CARD_NEW", false, 2, null);
        TTLIVE_PROFILE_HONOUR_CARD_NEW = r116;
        ProfilePreInflateViewInfo r117 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_TAG", 17, "TTLIVE_PROFILE_TAG", false, 2, null);
        TTLIVE_PROFILE_TAG = r117;
        ProfilePreInflateViewInfo r118 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_POI_TAG", 18, "TTLIVE_PROFILE_POI_TAG", false, 2, null);
        TTLIVE_PROFILE_POI_TAG = r118;
        ProfilePreInflateViewInfo r119 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_LIVE_HONOR_TAG", 19, "TTLIVE_PROFILE_LIVE_HONOR_TAG", false, 2, null);
        TTLIVE_PROFILE_LIVE_HONOR_TAG = r119;
        ProfilePreInflateViewInfo r120 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_LOCAL_LIFE", 20, "TTLIVE_PROFILE_LOCAL_LIFE", false, 2, null);
        TTLIVE_PROFILE_LOCAL_LIFE = r120;
        f100879a = new ProfilePreInflateViewInfo[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120};
    }

    public final Class<? extends View> getContainerViewClass() {
        int r100 = c.f100895c[ordinal()];
        if (r100 != 1) goto L5;
        return null;
    L5:
        if (r100 != 2) goto L7;
        return null;
    L7:
        if (r100 == 3) goto L12;
        return FrameLayout.class;
    L12:
        return null;
    }

    public final int getCount() {
        int r100 = c.f100894b[ordinal()];
        if (r100 != 1) goto L5;
        return 3;
    L5:
        if (r100 == 2) goto L10;
        if (r100 != 3) goto L8;
    L9:
        return 1;
    L8:
        if (r100 != 4) goto L9;
        return 3;
    L10:
        return 2;
    }

    public final int getResId() {
        switch(c.f100893a[ordinal()]) {
            case 1: goto L29;
            case 2: goto L28;
            case 3: goto L25;
            case 4: goto L23;
            case 5: goto L22;
            case 6: goto L21;
            case 7: goto L20;
            case 8: goto L19;
            case 9: goto L18;
            case 10: goto L17;
            case 11: goto L16;
            case 12: goto L15;
            case 13: goto L14;
            case 14: goto L13;
            case 15: goto L12;
            case 16: goto L11;
            case 17: goto L10;
            case 18: goto L9;
            case 19: goto L8;
            case 20: goto L7;
            case 21: goto L6;
            default: goto L5;
        };
    L6:
        return R.layout.ttlive_profile_v3_local_life_group_shop_layout;
    L7:
        return R.layout.ttlive_profile_live_life_honor_layout;
    L8:
        return R.layout.ttlive_profile_poi_tag_layout;
    L9:
        return R.layout.ttlive_profile_standard_tag_view;
    L10:
        return R.layout.ttlive_profile_standard_honour_card_view_v3;
    L11:
        return R.layout.ttlive_profile_v3_anchor_set_button_layout;
    L12:
        return R.layout.ttlive_profile_v3_owner_center_button_layout;
    L13:
        return R.layout.ttlive_profile_v3_button_layout;
    L14:
        return R.layout.ttlive_profile_v3_fans_group_button_layout;
    L15:
        return R.layout.ttlive_profile_v3_follow_button_layout;
    L16:
        return R.layout.ttlive_profile_v3_announce_layout;
    L17:
        return R.layout.ttlive_profile_v3_text_layout;
    L18:
        return R.layout.ttlive_profile_v3_dress_preview_default_layout;
    L19:
        return R.layout.ttlive_profile_v3_dress_preview_layout;
    L20:
        return R.layout.ttlive_profile_fans_club_vip_layout;
    L21:
        return R.layout.ttlive_profile_gift_exhibition_component_profile_new;
    L22:
        return R.layout.ttlive_profile_group_live_member_component;
    L23:
        return R.layout.ttlive_profile_v3_visitor_count_layout;
    L28:
        return R.layout.ttlive_dialog_new_live_profile_v3_land;
    L29:
        return R.layout.ttlive_dialog_new_live_profile_v3_port;
    L5:
        throw new NoWhenBranchMatchedException();
    L25:
        if (PadConfigUtils.c() == false) goto L27;
        return R.layout.ttlive_dialog_new_live_profile_v3_hd_new_new;
    L27:
        return 0;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getTag() {
        return this.key;
    }

    public final boolean getUsed() {
        return this.used;
    }

    public final void setUsed(boolean r100) {
        this.used = r100;
    }

    public ProfilePreInflateViewInfo(String r100, int r101, String r102, boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L5;
        r103 = false;
    L5:
        super(r100, r101);
        this.key = r102;
        this.used = r103;
    }
}
