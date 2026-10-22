package com.bytedance.android.live.base.model;

import com.bytedance.android.live.base.model.user.n0;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.base.model.user.p0;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
@IgnoreProtoFieldCheck
public class Appointment {
    public static final int APPOINTMENT_TYPE_DATE = 11;
    public static final int APPOINTMENT_TYPE_ITEM = 19;

    @SerializedName("anchor_id")
    long anchorId;

    @SerializedName("anchor_id_str")
    String anchorIdStr;

    @SerializedName("anchor_open_id")
    String anchorOpenId;

    @SerializedName("anchor_open_id_str")
    String anchorOpenIdStr;

    @SerializedName("appointment_id")
    public long appointmentId;

    @SerializedName("appointment_id_str")
    public String appointmentIdStr;

    @SerializedName("appointment_type")
    public int appointmentType;

    @SerializedName("feed_img_url")
    public String coverImgUrl;

    @SerializedName("due_start_time")
    public String dueStartTime;

    @SerializedName("end_time")
    public long endTime;

    @SerializedName("group_id")
    public String groupId;

    @SerializedName("inside_push_text")
    public String insidePushText;

    @SerializedName("inside_push_title")
    public String insidePushTitle;

    @SerializedName("is_living")
    public Boolean isLiving;

    @SerializedName("is_subscribed")
    public Boolean isReserved;

    @SerializedName("live_fragments_map")
    public Map<Long, LiveFragments> liveExtractsMap;

    @SerializedName(OnekeyLoginConstants.CU_KEY_OPERATOR)
    public String operator;

    @SerializedName("feed_jump_url")
    public String programJumpUrl;

    @SerializedName("room_id")
    public long roomId;

    @SerializedName("room_id_str")
    public String roomIdStr;

    @SerializedName("sec_anchor_id")
    public String secAnchorId;

    @SerializedName("show_status")
    public int showStatus;

    @SerializedName(ILoadStallMonitor.START_TIME)
    public long startTime;

    @SerializedName("feed_subtitle")
    public String subTitle;

    @SerializedName("subscriber_count")
    public int subscriberCount;

    @SerializedName("feed_title")
    public String title;

    public static class LiveFragments {
        public static final long EXTRACT_TYPE_HIGHLIGHTS = 1;
        public static final long EXTRACT_TYPE_REPLAY = 3;

        @SerializedName("item_ids")
        public List<Long> extractItemIds;

        public LiveFragments() {
        }
    }

    public Appointment() {
    }

    public String getAnchorIdStr() {
        return n0.e(Long.valueOf(this.anchorId), this.anchorOpenId);
    }

    public o0 getUserIdCompat() {
        Long r100 = Long.valueOf(this.anchorId);
        String r101 = this.anchorOpenId;
        int r102 = n0.f58945a;
        o0.f58946a.getClass();
        if (r100 == null) goto L5;
        String r103 = String.valueOf(r100.longValue());
    L7:
        return new p0(r103, r101);
    L5:
        r103 = null;
        goto L7
    }
}
