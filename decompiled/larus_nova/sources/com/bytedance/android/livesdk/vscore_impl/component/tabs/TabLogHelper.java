package com.bytedance.android.livesdk.vscore_impl.component.tabs;

import com.alibaba.gaiax.model.GXAnimation;
import com.bytedance.android.livesdk.vscore_api.tab.MultiTabType;
import com.bytedance.android.livesdk.vscore_impl.component.tabs.popup.MultiTabBubbleManager;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.vs.MultiTab;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.optimize.statistics.FrescoMonitorConst;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class TabLogHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f159919a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_impl/component/tabs/TabLogHelper$LoadStatus;", "", GXAnimation.STATE_START, "SUCCESS", "FAILED", "CANCEL", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LoadStatus extends Enum<LoadStatus> {
        public static final LoadStatus CANCEL = null;
        public static final LoadStatus FAILED = null;
        public static final LoadStatus START = null;
        public static final LoadStatus SUCCESS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LoadStatus[] f159920a = null;

        static {
            LoadStatus r100 = new LoadStatus(GXAnimation.STATE_START, 0);
            START = r100;
            LoadStatus r101 = new LoadStatus("SUCCESS", 1);
            SUCCESS = r101;
            LoadStatus r102 = new LoadStatus("FAILED", 2);
            FAILED = r102;
            LoadStatus r103 = new LoadStatus("CANCEL", 3);
            CANCEL = r103;
            f159920a = new LoadStatus[]{r100, r101, r102, r103};
        }

        public static LoadStatus valueOf(String r100) {
            return (LoadStatus) r27.a.a(LoadStatus.class, r100);
        }

        public static LoadStatus[] values() {
            return (LoadStatus[]) f159920a.clone();
        }

        public LoadStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
    }

    public static void c(List r100, w r101) {
        Intrinsics.checkNotNullParameter(r101, "tabLogger");
        if (r100 == null) goto L15;
        Iterator r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L19;
        e r103 = (e) r102.next();
        Pair[] r104 = new Pair[3];
        String r105 = r103.f159952c;
        if (r105 != null) goto L10;
        r105 = "";
    L10:
        r104[0] = TuplesKt.to("tab_title", r105);
        MultiTabType.a r106 = MultiTabType.Companion;
        long r107 = r103.f159951b;
        r106.getClass();
        r104[1] = TuplesKt.to("tab_type", MultiTabType.a.a(r107).getLogParam());
        LinkedList<MultiTab.Bubble> r108 = MultiTabBubbleManager.f159974a;
        if (MultiTabBubbleManager.a(r103.f159951b) == false) goto L13;
        String r109 = "1";
    L14:
        r104[2] = TuplesKt.to("is_bubble", r109);
        r101.a(MapsKt.mutableMapOf(r104));
        goto L6
    L13:
        r109 = "0";
        goto L14
    L19:
        return;
    }

    public static void a(LoadStatus r100, DataCenter r101, Map r102) {
        Intrinsics.checkNotNullParameter(r100, "loadStatus");
        if (r101 != null) goto L6;
        return;
    L6:
        if (com.bytedance.android.livesdk.chatroom.vs_base.util.h.c(r101) == true) goto L8;
        return;
    L8:
        if (com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r101).isMergeFirstShow() == false) goto L10;
        String r103 = "vs_first_show_merge";
    L11:
        Map r104 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("stream_type", r103), TuplesKt.to(FrescoMonitorConst.LOAD_STATUS, String.valueOf(r100.ordinal()))});
        if (r102 == null) goto L14;
        r104.putAll(r102);
    L14:
        Unit r105 = Unit.INSTANCE;
        b("livesdk_live_tab_load_status", r104, null);
        return;
    L10:
        r103 = "vs_live_merge";
        goto L11
    }

    public static void b(String r100, Map r101, DataCenter r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "logMap");
        LinkedHashMap r103 = new LinkedHashMap();
        r103.putAll(r101);
        if (r102 == null) goto L18;
        IRoom r104 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r102);
        if (r104 == null) goto L18;
        r103.put("room_id", String.valueOf(r104.getRoomId()));
        r103.put("anchor_id", IRoomKt_androidKt.getAnchorId(r104));
        if (r104.isMergeVSRoom() == true) goto L18;
        EpisodeExtraInfo r105 = lu2.c.a(r104);
        if (r105 != null) goto L11;
    L13:
        boolean r106 = false;
    L14:
        if (r106 == false) goto L16;
        String r107 = "game_match_co_streaming";
    L17:
        r103.put("vs_episode_stage", r107);
        goto L18
    L16:
        r107 = "co_streaming";
        goto L17
    L11:
        if (r105.getShareType() != 1) goto L13;
        r106 = true;
    L18:
        com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.l().sendLog(r100, r103, new Object[]{Integer.TYPE, am2.x.class});
    }
}
