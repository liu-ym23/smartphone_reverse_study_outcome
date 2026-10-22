package com.bytedance.android.livesdk.dislike;

import com.bytedance.android.live.base.model.longpresspanel.ItemIdentity;
import com.bytedance.android.live.base.model.longpresspanel.LiveLongPressItemType;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;
import com.larus.nova.R;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.tencent.open.SocialConstants;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b#\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u00022\u00020\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\bJ\t\u0010\r\u001a\u00020\fH\u0096\u0001J\t\u0010\u000f\u001a\u00020\u000eH\u0096\u0001R\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\n\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010$\u001a\u00020#8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\u000b\u0010&R\"\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\u001c\u001a\u0004\b(\u0010\u001e\"\u0004\b)\u0010*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bE¨\u0006F"}, d2 = {"Lcom/bytedance/android/livesdk/dislike/ItemType;", "", "Lcom/bytedance/android/livesdk/dislike/k;", "", "", "isFeed", "", "getPriority", "(Z)Ljava/lang/Integer;", "", "getIdentity", "getItemType", "Lq61/b;", SoloKtvContext.SOLO_PAGE_ENTRANCE, "Lq61/b$a;", "entranceBuilder", "Lcom/bytedance/android/live/base/model/longpresspanel/ItemIdentity;", DownloadHelper.IDENTITY, "Lcom/bytedance/android/live/base/model/longpresspanel/ItemIdentity;", "()Lcom/bytedance/android/live/base/model/longpresspanel/ItemIdentity;", "type", "I", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "priority", "hasLandingPage", "Z", "getHasLandingPage", "()Z", "imgRes", "Ljava/lang/Integer;", "getImgRes", "()Ljava/lang/Integer;", "Lcom/bytedance/android/live/base/model/longpresspanel/LiveLongPressItemType;", "itemType", "Lcom/bytedance/android/live/base/model/longpresspanel/LiveLongPressItemType;", "()Lcom/bytedance/android/live/base/model/longpresspanel/LiveLongPressItemType;", "clearColorFilter", "getClearColorFilter", "setClearColorFilter", "(Z)V", "BLANK_SPACE", "MORE_FRIENDS", "CLEAR_SCREEN", "SHARE", "SHARE_FANS", "DISLIKE", "IM_MESSAGE", "IMAGE_RECOGNITION", "SHARE_LIVE_TO_DAILY", "LIVE_NOTIFICATION", "OPT_RECOMMEND", "DISLIKE_CURRENT_LIVE", "DISLIKE_CONTENT", "DISLIKE_ANCHOR", "DISLIKE_TYPE", OpenNetMethod.REPORT, "RECOMMEND_TO_FRIENDS", "WATCH_LATER", "FOLLOW", "UNFOLLOW", "FLOAT_WINDOW", "ADD_TO_DESKTOP", "FEED_LIVE_SHARE", "SCREEN_RECORD", "AUDIO_FEEDBACK", "PK_FEEDBACK", "DOU_PLUS", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ItemType extends Enum<ItemType> implements k {
    public static final ItemType ADD_TO_DESKTOP = null;
    public static final ItemType AUDIO_FEEDBACK = null;
    public static final ItemType BLANK_SPACE = null;
    public static final ItemType CLEAR_SCREEN = null;
    public static final ItemType DISLIKE = null;
    public static final ItemType DISLIKE_ANCHOR = null;
    public static final ItemType DISLIKE_CONTENT = null;
    public static final ItemType DISLIKE_CURRENT_LIVE = null;
    public static final ItemType DISLIKE_TYPE = null;
    public static final ItemType DOU_PLUS = null;
    public static final ItemType FEED_LIVE_SHARE = null;
    public static final ItemType FLOAT_WINDOW = null;
    public static final ItemType FOLLOW = null;
    public static final ItemType IMAGE_RECOGNITION = null;
    public static final ItemType IM_MESSAGE = null;
    public static final ItemType LIVE_NOTIFICATION = null;
    public static final ItemType MORE_FRIENDS = null;
    public static final ItemType OPT_RECOMMEND = null;
    public static final ItemType PK_FEEDBACK = null;
    public static final ItemType RECOMMEND_TO_FRIENDS = null;
    public static final ItemType REPORT = null;
    public static final ItemType SCREEN_RECORD = null;
    public static final ItemType SHARE = null;
    public static final ItemType SHARE_FANS = null;
    public static final ItemType SHARE_LIVE_TO_DAILY = null;
    public static final ItemType UNFOLLOW = null;
    public static final ItemType WATCH_LATER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ItemType[] f122004a = null;
    private boolean clearColorFilter;
    private final String desc;
    private final boolean hasLandingPage;
    private final ItemIdentity identity;
    private final Integer imgRes;
    private final LiveLongPressItemType itemType;
    private final int priority;
    private final int type;

    public ItemType() {
        throw null;
    }

    public static ItemType valueOf(String r100) {
        return (ItemType) r27.a.a(ItemType.class, r100);
    }

    public static ItemType[] values() {
        return (ItemType[]) f122004a.clone();
    }

    public q61.b entrance() {
        return this.identity.entrance();
    }

    public q61.b.a entranceBuilder() {
        return this.identity.entranceBuilder();
    }

    static {
        ItemType[] r100 = new ItemType[27];
        ItemType r110 = new ItemType("BLANK_SPACE", 0, ItemIdentity.BLANK, 0, "占位", 0, false, null, null, false, 224, null);
        BLANK_SPACE = r110;
        r100[0] = r110;
        ItemType r101 = new ItemType("MORE_FRIENDS", 1, ItemIdentity.MORE_FRIENDS, 1, "更多朋友", 0, false, null, null, false, 224, null);
        MORE_FRIENDS = r101;
        r100[1] = r101;
        ItemType r102 = new ItemType("CLEAR_SCREEN", 2, ItemIdentity.CLEAR_SCREEN, 1, "清屏", 0, false, null, null, false, 224, null);
        CLEAR_SCREEN = r102;
        r100[2] = r102;
        ItemType r103 = new ItemType("SHARE", 3, ItemIdentity.SHARE, 1, "分享", 0, false, null, null, false, 224, null);
        SHARE = r103;
        r100[3] = r103;
        ItemType r104 = new ItemType("SHARE_FANS", 4, ItemIdentity.SHARE_FANS, 1, "分享到粉丝", 0, false, null, null, false, 224, null);
        SHARE_FANS = r104;
        r100[4] = r104;
        ItemType r105 = new ItemType("DISLIKE", 5, ItemIdentity.DISLIKE, 1, "不感兴趣", 0, false, null, null, false, 224, null);
        DISLIKE = r105;
        r100[5] = r105;
        ItemType r106 = new ItemType("IM_MESSAGE", 6, ItemIdentity.IM_MESSAGE, 1, "私信站内好友", 0, false, null, null, false, 224, null);
        IM_MESSAGE = r106;
        r100[6] = r106;
        ItemType r107 = new ItemType("IMAGE_RECOGNITION", 7, ItemIdentity.IMAGE_RECOGNITION, 1, "识图", 0, false, null, null, false, 224, null);
        IMAGE_RECOGNITION = r107;
        r100[7] = r107;
        ItemIdentity r108 = ItemIdentity.SHARE_LIVE_TO_DAILY;
        IMiddlewareHostApp r109 = (IMiddlewareHostApp) jc1.k.f(IMiddlewareHostApp.class);
        if (r109 == null) goto L6;
        String r111 = r109.replaceBrand("转发到{social_brand}");
        if (r111 == null) goto L6;
    L7:
        ItemType r112 = new ItemType("SHARE_LIVE_TO_DAILY", 8, r108, 1, r111, 0, false, null, null, false, 224, null);
        SHARE_LIVE_TO_DAILY = r112;
        r100[8] = r112;
        ItemType r113 = new ItemType("LIVE_NOTIFICATION", 9, ItemIdentity.LIVE_NOTIFICATION, 2, "开播提醒", 2000, false, Integer.valueOf(R.drawable.ttlive_open_live_notify_icon_new), null, false, 192, null);
        LIVE_NOTIFICATION = r113;
        r100[9] = r113;
        ItemType r114 = new ItemType("OPT_RECOMMEND", 10, ItemIdentity.OPT_RECOMMEND, 2, "优化推荐", 1900, true, Integer.valueOf(R.drawable.ttlive_opt_live_rec_icon_new), null, false, 192, null);
        OPT_RECOMMEND = r114;
        r100[10] = r114;
        ItemType r115 = new ItemType("DISLIKE_CURRENT_LIVE", 11, ItemIdentity.DISLIKE_CURRENT_LIVE, 2, "不感兴趣当前直播", 1700, false, Integer.valueOf(R.drawable.ttlive_dislike_current_live_icon_new), null, false, 192, null);
        DISLIKE_CURRENT_LIVE = r115;
        r100[11] = r115;
        ItemType r116 = new ItemType("DISLIKE_CONTENT", 12, ItemIdentity.DISLIKE_CONTENT, 2, "减少此类型直播", 1700, false, Integer.valueOf(R.drawable.ttlive_dislike_live_type_icon_new), null, false, 192, null);
        DISLIKE_CONTENT = r116;
        r100[12] = r116;
        ItemType r117 = new ItemType("DISLIKE_ANCHOR", 13, ItemIdentity.DISLIKE_ANCHOR, 2, "不看该主播", 1600, false, Integer.valueOf(R.drawable.ttlive_dislike_anchor_icon_new), null, false, 192, null);
        DISLIKE_ANCHOR = r117;
        r100[13] = r117;
        ItemType r118 = new ItemType("DISLIKE_TYPE", 14, ItemIdentity.DISLIKE_TYPE, 2, "减少直播推荐", 1500, false, Integer.valueOf(R.drawable.ttlive_dislike_live_icon_new), null, false, 192, null);
        DISLIKE_TYPE = r118;
        r100[14] = r118;
        ItemType r119 = new ItemType(OpenNetMethod.REPORT, 15, ItemIdentity.REPORT, 2, "举报", 1400, false, Integer.valueOf(R.drawable.ttlive_report_icon_new), null, false, 192, null);
        REPORT = r119;
        r100[15] = r119;
        ItemType r120 = new ItemType("RECOMMEND_TO_FRIENDS", 16, ItemIdentity.RECOMMEND_TO_FRIENDS, 1, "推荐给朋友", 9999, true, Integer.valueOf(R.drawable.ttlive_rec_to_friends_icon_new), null, true, 64, null);
        RECOMMEND_TO_FRIENDS = r120;
        r100[16] = r120;
        ItemType r121 = new ItemType("WATCH_LATER", 17, ItemIdentity.WATCH_LATER, 2, "稍后再看", 1900, false, Integer.valueOf(R.drawable.ttlive_ic_watch_later_button), null, false, 192, null);
        WATCH_LATER = r121;
        r100[17] = r121;
        ItemType r122 = new ItemType("FOLLOW", 18, ItemIdentity.FOLLOW, 2, "关注", 1800, false, Integer.valueOf(R.drawable.ttlive_follow_icon_new), null, false, 192, null);
        FOLLOW = r122;
        r100[18] = r122;
        ItemType r123 = new ItemType("UNFOLLOW", 19, ItemIdentity.UNFOLLOW, 2, "取消关注", 1300, false, Integer.valueOf(R.drawable.ttlive_unfollow_icon_new), null, false, 192, null);
        UNFOLLOW = r123;
        r100[19] = r123;
        ItemType r124 = new ItemType("FLOAT_WINDOW", 20, ItemIdentity.FLOAT_WINDOW, 2, "小窗播放", 1200, false, Integer.valueOf(R.drawable.ttlive_float_window_icon_new), null, false, 192, null);
        FLOAT_WINDOW = r124;
        r100[20] = r124;
        ItemType r125 = new ItemType("ADD_TO_DESKTOP", 21, ItemIdentity.ADD_TO_DESKTOP, 2, "添加到桌面", 1100, false, Integer.valueOf(R.drawable.ttlive_add_to_desktop_new_icon), null, false, 192, null);
        ADD_TO_DESKTOP = r125;
        r100[21] = r125;
        ItemType r126 = new ItemType("FEED_LIVE_SHARE", 22, ItemIdentity.FEED_LIVE_SHARE, 2, "一起看", 1000, true, Integer.valueOf(R.drawable.ttlive_live_feed_share_icon_new), null, false, 192, null);
        FEED_LIVE_SHARE = r126;
        r100[22] = r126;
        ItemType r127 = new ItemType("SCREEN_RECORD", 23, ItemIdentity.SCREEN_RECORD, 2, "开始录屏", 900, false, Integer.valueOf(R.drawable.ttlive_screen_record_icon_new), null, false, 192, null);
        SCREEN_RECORD = r127;
        r100[23] = r127;
        ItemType r128 = new ItemType("AUDIO_FEEDBACK", 24, ItemIdentity.AUDIO_FEEDBACK, 2, "音视频反馈", 800, false, Integer.valueOf(R.drawable.ttlive_audio_feedback_icon_new), null, false, 192, null);
        AUDIO_FEEDBACK = r128;
        r100[24] = r128;
        ItemType r129 = new ItemType("PK_FEEDBACK", 25, ItemIdentity.PK_FEEDBACK, 2, "pk反馈", 700, false, Integer.valueOf(R.drawable.ttlive_pk_feedback_icon_new), null, false, 192, null);
        PK_FEEDBACK = r129;
        r100[25] = r129;
        ItemType r130 = new ItemType("DOU_PLUS", 26, ItemIdentity.DOU_PLUS, 2, "上热门", 700, false, Integer.valueOf(R.drawable.ttlive_old_long_press_dou_plus), null, false, 192, null);
        DOU_PLUS = r130;
        r100[26] = r130;
        f122004a = r100;
        return;
    L6:
        r111 = "转发到日常";
        goto L7
    }

    public final boolean getClearColorFilter() {
        return this.clearColorFilter;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final boolean getHasLandingPage() {
        return this.hasLandingPage;
    }

    public final ItemIdentity getIdentity() {
        return this.identity;
    }

    public final Integer getImgRes() {
        return this.imgRes;
    }

    public final LiveLongPressItemType getItemType() {
        return this.itemType;
    }

    public String getIdentity(boolean r100) {
        String r101 = o.a(this.identity, r100).getIdentity();
        if (r101 != null) goto L9;
        String r102 = this.identity.name();
        Locale r103 = Locale.ROOT;
        if (r102 == null) goto L8;
        return r102.toLowerCase(r103);
    L8:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L9:
        return r101;
    }

    @Override // com.bytedance.android.livesdk.dislike.k
    public Integer getItemType(boolean r100) {
        Integer r101 = o.a(this.identity, r100).getType();
        if (r101 == null) goto L5;
        int r102 = r101.intValue();
    L7:
        return Integer.valueOf(r102);
    L5:
        r102 = this.type;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.dislike.k
    public Integer getPriority(boolean r100) {
        Integer r101 = o.a(this.identity, r100).getPriority();
        if (r101 == null) goto L5;
        int r102 = r101.intValue();
    L7:
        return Integer.valueOf(r102);
    L5:
        r102 = this.priority;
        goto L7
    }

    public final void setClearColorFilter(boolean r100) {
        this.clearColorFilter = r100;
    }

    public ItemType(String r100, int r101, ItemIdentity r102, int r103, String r104, int r105, boolean r106, Integer r107, LiveLongPressItemType r108, boolean r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 32) == 0) goto L6;
        r107 = null;
    L6:
        if ((r111 & 64) == 0) goto L9;
        r108 = LiveLongPressItemType.NORMAL;
    L9:
        if ((r111 & 128) == 0) goto L11;
        r110 = false;
    L11:
        super(r100, r101);
        this.identity = r102;
        this.type = r103;
        this.desc = r104;
        this.priority = r105;
        this.hasLandingPage = r106;
        this.imgRes = r107;
        this.itemType = r108;
        this.clearColorFilter = r110;
    }
}
