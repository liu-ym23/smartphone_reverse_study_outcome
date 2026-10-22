package com.bytedance.android.live.base.model.longpresspanel;

import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;
import com.ss.android.lark.url.card.UrlCardProperty;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import q61.b;
import q61.c;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\"\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(¨\u0006)"}, d2 = {"Lcom/bytedance/android/live/base/model/longpresspanel/ItemIdentity;", "", "", "Lq61/b;", SoloKtvContext.SOLO_PAGE_ENTRANCE, "Lq61/b$a;", "entranceBuilder", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "BLANK", "FLOAT_WINDOW", "FEED_LIVE_SHARE", "ADD_TO_DESKTOP", OpenNetMethod.REPORT, "SCREEN_RECORD", "AUDIO_FEEDBACK", "DISLIKE", "DISLIKE_CURRENT_LIVE", "DISLIKE_CONTENT", "DISLIKE_TYPE", "DISLIKE_ANCHOR", "SHARE", "OPT_RECOMMEND", "LIVE_AI_WATCH_ASSISTANT", "LIVE_NOTIFICATION", "FOLLOW", "UNFOLLOW", "IM_MESSAGE", "SHARE_FANS", "RECOMMEND_TO_FRIENDS", "SHARE_LIVE_TO_DAILY", "DANMAKU_SETTING", "MORE_FRIENDS", "PK_FEEDBACK", "CLEAR_SCREEN", "DOU_PLUS", "IMAGE_RECOGNITION", "WATCH_LATER", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ItemIdentity extends Enum<ItemIdentity> {
    public static final ItemIdentity ADD_TO_DESKTOP = null;
    public static final ItemIdentity AUDIO_FEEDBACK = null;
    public static final ItemIdentity BLANK = null;
    public static final ItemIdentity CLEAR_SCREEN = null;
    public static final ItemIdentity DANMAKU_SETTING = null;
    public static final ItemIdentity DISLIKE = null;
    public static final ItemIdentity DISLIKE_ANCHOR = null;
    public static final ItemIdentity DISLIKE_CONTENT = null;
    public static final ItemIdentity DISLIKE_CURRENT_LIVE = null;
    public static final ItemIdentity DISLIKE_TYPE = null;
    public static final ItemIdentity DOU_PLUS = null;
    public static final ItemIdentity FEED_LIVE_SHARE = null;
    public static final ItemIdentity FLOAT_WINDOW = null;
    public static final ItemIdentity FOLLOW = null;
    public static final ItemIdentity IMAGE_RECOGNITION = null;
    public static final ItemIdentity IM_MESSAGE = null;
    public static final ItemIdentity LIVE_AI_WATCH_ASSISTANT = null;
    public static final ItemIdentity LIVE_NOTIFICATION = null;
    public static final ItemIdentity MORE_FRIENDS = null;
    public static final ItemIdentity OPT_RECOMMEND = null;
    public static final ItemIdentity PK_FEEDBACK = null;
    public static final ItemIdentity RECOMMEND_TO_FRIENDS = null;
    public static final ItemIdentity REPORT = null;
    public static final ItemIdentity SCREEN_RECORD = null;
    public static final ItemIdentity SHARE = null;
    public static final ItemIdentity SHARE_FANS = null;
    public static final ItemIdentity SHARE_LIVE_TO_DAILY = null;
    public static final ItemIdentity UNFOLLOW = null;
    public static final ItemIdentity WATCH_LATER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ItemIdentity[] f58840a = null;
    private final String key;

    public static ItemIdentity valueOf(String r100) {
        return (ItemIdentity) a.a(ItemIdentity.class, r100);
    }

    public static ItemIdentity[] values() {
        return (ItemIdentity[]) f58840a.clone();
    }

    static {
        ItemIdentity r100 = new ItemIdentity("BLANK", 0, "blank");
        BLANK = r100;
        ItemIdentity r101 = new ItemIdentity("FLOAT_WINDOW", 1, "float_window");
        FLOAT_WINDOW = r101;
        ItemIdentity r102 = new ItemIdentity("FEED_LIVE_SHARE", 2, "feed_live_share");
        FEED_LIVE_SHARE = r102;
        ItemIdentity r103 = new ItemIdentity("ADD_TO_DESKTOP", 3, "add_to_desktop");
        ADD_TO_DESKTOP = r103;
        ItemIdentity r104 = new ItemIdentity(OpenNetMethod.REPORT, 4, "report");
        REPORT = r104;
        ItemIdentity r105 = new ItemIdentity("SCREEN_RECORD", 5, "screen_record");
        SCREEN_RECORD = r105;
        ItemIdentity r106 = new ItemIdentity("AUDIO_FEEDBACK", 6, "audio_feedback");
        AUDIO_FEEDBACK = r106;
        ItemIdentity r107 = new ItemIdentity("DISLIKE", 7, AppConstants.BUNDLE_DISLIKE);
        DISLIKE = r107;
        ItemIdentity r108 = new ItemIdentity("DISLIKE_CURRENT_LIVE", 8, "dislike_current_live");
        DISLIKE_CURRENT_LIVE = r108;
        ItemIdentity r109 = new ItemIdentity("DISLIKE_CONTENT", 9, "dislike_content");
        DISLIKE_CONTENT = r109;
        ItemIdentity r110 = new ItemIdentity("DISLIKE_TYPE", 10, "dislike_type");
        DISLIKE_TYPE = r110;
        ItemIdentity r111 = new ItemIdentity("DISLIKE_ANCHOR", 11, "dislike_anchor");
        DISLIKE_ANCHOR = r111;
        ItemIdentity r112 = new ItemIdentity("SHARE", 12, "share");
        SHARE = r112;
        ItemIdentity r113 = new ItemIdentity("OPT_RECOMMEND", 13, "opt_recommend");
        OPT_RECOMMEND = r113;
        ItemIdentity r114 = new ItemIdentity("LIVE_AI_WATCH_ASSISTANT", 14, "live_ai_watch_assistant");
        LIVE_AI_WATCH_ASSISTANT = r114;
        ItemIdentity r115 = new ItemIdentity("LIVE_NOTIFICATION", 15, "live_notification");
        LIVE_NOTIFICATION = r115;
        ItemIdentity r116 = new ItemIdentity("FOLLOW", 16, "follow");
        FOLLOW = r116;
        ItemIdentity r117 = new ItemIdentity("UNFOLLOW", 17, "unfollow");
        UNFOLLOW = r117;
        ItemIdentity r118 = new ItemIdentity("IM_MESSAGE", 18, UrlCardProperty.URL_PREVIEW_BUSINESS_HOST);
        IM_MESSAGE = r118;
        ItemIdentity r119 = new ItemIdentity("SHARE_FANS", 19, "share_fans");
        SHARE_FANS = r119;
        ItemIdentity r120 = new ItemIdentity("RECOMMEND_TO_FRIENDS", 20, "recommend_to_friends");
        RECOMMEND_TO_FRIENDS = r120;
        ItemIdentity r121 = new ItemIdentity("SHARE_LIVE_TO_DAILY", 21, "share_live_to_daily");
        SHARE_LIVE_TO_DAILY = r121;
        ItemIdentity r122 = new ItemIdentity("DANMAKU_SETTING", 22, "danmaku_setting");
        DANMAKU_SETTING = r122;
        ItemIdentity r123 = new ItemIdentity("MORE_FRIENDS", 23, "more_friends");
        MORE_FRIENDS = r123;
        ItemIdentity r124 = new ItemIdentity("PK_FEEDBACK", 24, "pk_feedback");
        PK_FEEDBACK = r124;
        ItemIdentity r125 = new ItemIdentity("CLEAR_SCREEN", 25, "clear_screen");
        CLEAR_SCREEN = r125;
        ItemIdentity r126 = new ItemIdentity("DOU_PLUS", 26, IPerformanceManager.SCENE_CLICK_DOU_PLUS);
        DOU_PLUS = r126;
        ItemIdentity r127 = new ItemIdentity("IMAGE_RECOGNITION", 27, "image_recognition");
        IMAGE_RECOGNITION = r127;
        ItemIdentity r128 = new ItemIdentity("WATCH_LATER", 28, "watch_later");
        WATCH_LATER = r128;
        f58840a = new ItemIdentity[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128};
    }

    public b entrance() {
        int r100 = cz.b.f465992a;
        Intrinsics.checkNotNullParameter(this, DownloadHelper.IDENTITY);
        return new c(cz.b.a(this));
    }

    public b.a entranceBuilder() {
        return cz.b.a(this);
    }

    public final String getKey() {
        return this.key;
    }

    public ItemIdentity(String r100, int r101, String r102) {
        super(r100, r101);
        this.key = r102;
    }
}
