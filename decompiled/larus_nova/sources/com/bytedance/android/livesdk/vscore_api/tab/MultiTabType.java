package com.bytedance.android.livesdk.vscore_api.tab;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0086\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_api/tab/MultiTabType;", "", "", "tabId", "J", "getTabId", "()J", "", "logParam", "Ljava/lang/String;", "getLogParam", "()Ljava/lang/String;", "title", "getTitle", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "PUBLIC_INTERACT_TAB", "LINE_UP_TAB", "GAME_DATA_TAB", "PREDICTED_TAB", "HIGHLIGHTS_TAB", "REPLAY_TAB", "SCHEDULE_TAB", "MEDAL_TAB", "HOTSPOT_TAB", "FESTIVAL_TAB", "CHANNEL_CHAT_TAB", UserProfileEvent.POSITION_NONE, "ACTIVITY_TAB", "BROADCAST_TAB", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum MultiTabType extends Enum<MultiTabType> {
    public static final MultiTabType ACTIVITY_TAB = null;
    public static final MultiTabType BROADCAST_TAB = null;
    public static final MultiTabType CHANNEL_CHAT_TAB = null;
    public static final a Companion = null;
    public static final MultiTabType FESTIVAL_TAB = null;
    public static final MultiTabType GAME_DATA_TAB = null;
    public static final MultiTabType HIGHLIGHTS_TAB = null;
    public static final MultiTabType HOTSPOT_TAB = null;
    public static final MultiTabType LINE_UP_TAB = null;
    public static final MultiTabType MEDAL_TAB = null;
    public static final MultiTabType NONE = null;
    public static final MultiTabType PREDICTED_TAB = null;
    public static final MultiTabType PUBLIC_INTERACT_TAB = null;
    public static final MultiTabType REPLAY_TAB = null;
    public static final MultiTabType SCHEDULE_TAB = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MultiTabType[] f159523a = null;
    private final String logParam;
    private final long tabId;
    private final String title;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static MultiTabType a(long r100) {
            MultiTabType[] r101 = MultiTabType.values();
            ArrayList r102 = new ArrayList(r101.length);
            int r103 = r101.length;
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L9;
            MultiTabType r105 = r101[r104];
            if (r105.getTabId() == r100) goto L6;
            r102.add(Unit.INSTANCE);
            r104 = r104 + 1;
            goto L3
        L6:
            return r105;
        L9:
            return MultiTabType.NONE;
        }
    }

    @JvmStatic
    public static final MultiTabType getTabClassWithId(long r100) {
        Companion.getClass();
        return a.a(r100);
    }

    public static MultiTabType valueOf(String r100) {
        return (MultiTabType) r27.a.a(MultiTabType.class, r100);
    }

    public static MultiTabType[] values() {
        return (MultiTabType[]) f159523a.clone();
    }

    static {
        MultiTabType r100 = new MultiTabType("PUBLIC_INTERACT_TAB", 0, 0, "interactive", "直播");
        PUBLIC_INTERACT_TAB = r100;
        MultiTabType r101 = new MultiTabType("LINE_UP_TAB", 1, 1, "line_up", "阵容");
        LINE_UP_TAB = r101;
        MultiTabType r102 = new MultiTabType("GAME_DATA_TAB", 2, 2, "game_data", "赛况");
        GAME_DATA_TAB = r102;
        MultiTabType r103 = new MultiTabType("PREDICTED_TAB", 3, 3, "predicted", "预测");
        PREDICTED_TAB = r103;
        MultiTabType r104 = new MultiTabType("HIGHLIGHTS_TAB", 4, 4, "highlights", "看点");
        HIGHLIGHTS_TAB = r104;
        MultiTabType r105 = new MultiTabType("REPLAY_TAB", 5, 5, "replay", "回放");
        REPLAY_TAB = r105;
        MultiTabType r106 = new MultiTabType("SCHEDULE_TAB", 6, 6, "yyh_game_schedule", "赛程");
        SCHEDULE_TAB = r106;
        MultiTabType r107 = new MultiTabType("MEDAL_TAB", 7, 7, "yyh_medal", "奖牌");
        MEDAL_TAB = r107;
        MultiTabType r108 = new MultiTabType("HOTSPOT_TAB", 8, 8, "yyh_hotspot", "热点");
        HOTSPOT_TAB = r108;
        MultiTabType r109 = new MultiTabType("FESTIVAL_TAB", 9, 9, "vs_springfestival", "新春季");
        FESTIVAL_TAB = r109;
        MultiTabType r110 = new MultiTabType("CHANNEL_CHAT_TAB", 10, 10, "chat", "聊天");
        CHANNEL_CHAT_TAB = r110;
        MultiTabType r111 = new MultiTabType(UserProfileEvent.POSITION_NONE, 11, -1, "none", "无");
        NONE = r111;
        MultiTabType r112 = new MultiTabType("ACTIVITY_TAB", 12, 500, "vs_activity", "活动");
        ACTIVITY_TAB = r112;
        MultiTabType r113 = new MultiTabType("BROADCAST_TAB", 13, 501, "vs_more_live", "排播");
        BROADCAST_TAB = r113;
        f159523a = new MultiTabType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113};
        Companion = new a();
    }

    public final String getLogParam() {
        return this.logParam;
    }

    public final long getTabId() {
        return this.tabId;
    }

    public final String getTitle() {
        return this.title;
    }

    public MultiTabType(String r100, int r101, long r102, String r103, String r104) {
        super(r100, r101);
        this.tabId = r102;
        this.logParam = r103;
        this.title = r104;
    }
}
