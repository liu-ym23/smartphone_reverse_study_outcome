package com.bytedance.android.livesdk.announce;

import am3.g;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.appointment.AnnouncementAnchorGetResponse.Data")
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\bG\b\u0007\u0018\u0000 \u0082\u00012\u00020\u0001:\u0002\u0083\u0001B\t¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0000J\u0010\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\u0005J\u0006\u0010\u000f\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u0011\u001a\u00020\u0000J\u0006\u0010\u0012\u001a\u00020\u0000J\b\u0010\u0013\u001a\u00020\u0007H\u0016R\u0016\u0010\u0014\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0015R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001cR\u0016\u0010\"\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u001cR\u001e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010&\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b&\u0010 R\u0016\u0010'\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b'\u0010 R\u0016\u0010(\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b(\u0010\u001aR\u0016\u0010)\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b)\u0010\u001aR\u0016\u0010*\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b*\u0010\u0015R\u0016\u0010+\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b+\u0010\u0015R\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000b0#8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b,\u0010%R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020.0-8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b/\u0010%R\u001e\u00101\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b1\u0010%R\u0016\u00102\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b2\u0010\u001cR\u0016\u00103\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b3\u0010\u001cR\u0016\u00104\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b4\u0010\u0015R\u0016\u00105\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b5\u0010\u0015R\u0016\u00106\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b6\u0010\u001cR\u0016\u00107\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b7\u0010 R\u0018\u00109\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010;\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010>\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010@\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010B\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bB\u0010\u001aR\u0016\u0010C\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bC\u0010\u001cR\u001e\u0010D\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bD\u0010%R(\u0010E\u001a\b\u0012\u0004\u0012\u00020\u000b0#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010%\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010J\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010 \u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010O\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010 \u001a\u0004\bP\u0010L\"\u0004\bQ\u0010NR\"\u0010R\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010 \u001a\u0004\bS\u0010L\"\u0004\bT\u0010NR(\u0010U\u001a\b\u0012\u0004\u0012\u00020\u000b0#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010%\u001a\u0004\bV\u0010G\"\u0004\bW\u0010IR\"\u0010X\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bX\u0010\u0015\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\"\u0010]\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010\u0015\u001a\u0004\b^\u0010Z\"\u0004\b_\u0010\\R\"\u0010`\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b`\u0010\u0015\u001a\u0004\ba\u0010Z\"\u0004\bb\u0010\\R\"\u0010c\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bc\u0010\u0015\u001a\u0004\bd\u0010Z\"\u0004\be\u0010\\R\"\u0010f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bf\u0010\u0015\u001a\u0004\bg\u0010Z\"\u0004\bh\u0010\\R\"\u0010i\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bi\u0010\u0015\u001a\u0004\bj\u0010Z\"\u0004\bk\u0010\\R\"\u0010l\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bl\u0010\u0015\u001a\u0004\bm\u0010Z\"\u0004\bn\u0010\\R$\u0010o\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bo\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u0013\u0010v\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\bu\u0010LR\u0013\u0010x\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\bw\u0010LR\u0011\u0010y\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\by\u0010ZR\u0011\u0010|\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\bz\u0010{R\u0011\u0010~\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b}\u0010{R\u0011\u0010\u007f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u007f\u0010Z¨\u0006\u0084\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/announce/AnnouncementInfo;", "Ljava/io/Serializable;", "", "initDateInfo", "other", "", "redPacketChanged", "", "timeStr", "Lcom/bytedance/android/livesdk/announce/b;", "generateDateInfo", "", "toTimeMs", "generateAllGroupIdList", "canPublish", "containRedPackage", "hasValidAnnouncement", "copy", "copyOpt", "toString", "available", "Z", "switchStatus", "switchCanOpen", "", "bannedStatus", "I", "banFinishTime", "J", "banType", "stickerBan", "stickerBanToast", "Ljava/lang/String;", "scheduledTime", "scheduledDate", "", "scheduledWeekDays", "Ljava/util/List;", "scheduledTimeText", "content", "auditStatus", "maxEditContentTime", "reachMaxUpdateLimit", "groupSwitch", "checkedGroupIdList", "", "Lcom/bytedance/android/livesdk/announce/AnnouncementFanGroupInfo;", "allFanGroupList", "Lcom/bytedance/android/livesdk/announce/RedPacket;", "redPackets", "groupRemindTime", "factionBrokerId", "isSingle", "highestPriority", "nextLiveStartTime", "nextLiveStartTimeStr", "Lcom/bytedance/android/livesdk/announce/e;", "hint", "Lcom/bytedance/android/livesdk/announce/e;", Keys.API_PARAM_KEY_SDK_EXPIRETIME, "Ljava/lang/Long;", "Lcom/bytedance/android/livesdk/announce/AnnouncementSubscribeInfo;", "subscribeInfo", "Lcom/bytedance/android/livesdk/announce/AnnouncementSubscribeInfo;", "isHighlightOn", "Ljava/lang/Boolean;", "autoPublishSwitch", "announcementId", "videoItemIds", "selectedVideoItemIds", "getSelectedVideoItemIds", "()Ljava/util/List;", "setSelectedVideoItemIds", "(Ljava/util/List;)V", AppConstants.BUNDLE_TIP, "getTip", "()Ljava/lang/String;", "setTip", "(Ljava/lang/String;)V", "tipUrl", "getTipUrl", "setTipUrl", "urlDesc", "getUrlDesc", "setUrlDesc", "allGroupIdList", "getAllGroupIdList", "setAllGroupIdList", "editContent", "getEditContent", "()Z", "setEditContent", "(Z)V", "editTime", "getEditTime", "setEditTime", "editFanGroupList", "getEditFanGroupList", "setEditFanGroupList", "editFanGroupRemindTime", "getEditFanGroupRemindTime", "setEditFanGroupRemindTime", "editFanGroupSwitch", "getEditFanGroupSwitch", "setEditFanGroupSwitch", "editAutoPublishSwitch", "getEditAutoPublishSwitch", "setEditAutoPublishSwitch", "editVideoBind", "getEditVideoBind", "setEditVideoBind", "dateInfo", "Lcom/bytedance/android/livesdk/announce/b;", "getDateInfo", "()Lcom/bytedance/android/livesdk/announce/b;", "setDateInfo", "(Lcom/bytedance/android/livesdk/announce/b;)V", "getRedPacketPrompt", "redPacketPrompt", "getRedPacketOrderNo", "redPacketOrderNo", "isValid", "getPublishStatus", "()I", "publishStatus", "getAutoPublishStatus", "autoPublishStatus", "isValidForPushDialog", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnnouncementInfo implements Serializable, h {
    public static final int AUDIT_STATUS_AUDITING = 1;
    public static final int AUDIT_STATUS_EXPIRED = 4;
    public static final int AUDIT_STATUS_NOT_PASSED = 2;
    public static final int AUDIT_STATUS_NO_SCENE = 0;
    public static final int AUDIT_STATUS_PASSED = 3;
    public static final int AUTO_PUBLISH_CHECK_FAIL_AUTO_PUBLISH_SWITCH_CLOSE = 104;
    public static final int BAN_REASON_AUDIT = 0;
    public static final int BAN_REASON_TIME = 0;
    public static final int BAN_STATUS_BAN_WITH_FINISH_TIME = 1;
    public static final int BAN_STATUS_NOT_BANNED = 0;
    public static final a Companion = null;
    public static final int PUBLISH_CHECK_FAIL_ALREADY_PUSH = 101;
    public static final int PUBLISH_CHECK_FAIL_ANNOUNCEMENT_SWITCH_CLOSE = 103;
    public static final int PUBLISH_CHECK_FAIL_AUDIT_STATUS = 106;
    public static final int PUBLISH_CHECK_FAIL_INVALID_TIME = 102;
    public static final int PUBLISH_CHECK_FAIL_UNAVAILABLE = 105;
    public static final int PUBLISH_CHECK_SUCCESS = 0;

    @SerializedName("all_group_list")
    public List<AnnouncementFanGroupInfo> allFanGroupList;
    private List<Long> allGroupIdList;

    @SerializedName("announcement_id")
    public long announcementId;

    @SerializedName("audit_status")
    public int auditStatus;

    @SerializedName("auto_publish_highlight")
    public int autoPublishSwitch;

    @SerializedName("available")
    public boolean available;

    @SerializedName("ban_finish_time")
    public long banFinishTime;

    @SerializedName("ban_type")
    public int banType;

    @SerializedName("banned")
    public int bannedStatus;

    @SerializedName("group_id_list")
    public List<Long> checkedGroupIdList;

    @SerializedName("content")
    public String content;

    @IgnoreProtoFieldCheck
    private b dateInfo;
    private boolean editAutoPublishSwitch;
    private boolean editContent;
    private boolean editFanGroupList;
    private boolean editFanGroupRemindTime;
    private boolean editFanGroupSwitch;
    private boolean editTime;
    private boolean editVideoBind;

    @IgnoreProtoFieldCheck
    @SerializedName("expire_time")
    public Long expireTime;

    @SerializedName("faction_broker_id")
    public long factionBrokerId;

    @SerializedName("group_remind_time")
    public long groupRemindTime;

    @SerializedName("group_switch")
    public boolean groupSwitch;

    @IgnoreProtoFieldCheck
    @SerializedName("highest_priority")
    public boolean highestPriority;

    @IgnoreProtoFieldCheck
    @SerializedName("hint")
    public e hint;

    @SerializedName("appointment_container_open")
    public Boolean isHighlightOn;

    @IgnoreProtoFieldCheck
    @SerializedName("is_single")
    public boolean isSingle;

    @SerializedName("update_limit")
    public int maxEditContentTime;

    @IgnoreProtoFieldCheck
    @SerializedName("next_live_start_time")
    public long nextLiveStartTime;

    @IgnoreProtoFieldCheck
    @SerializedName("next_live_start_time_str")
    public String nextLiveStartTimeStr;

    @SerializedName("reach_update_limit")
    public boolean reachMaxUpdateLimit;

    @SerializedName("red_packets")
    public List<RedPacket> redPackets;

    @SerializedName("scheduled_date")
    public long scheduledDate;

    @SerializedName("scheduled_time")
    public long scheduledTime;

    @SerializedName("scheduled_time_text")
    public String scheduledTimeText;

    @SerializedName("scheduled_weekdays")
    public List<Integer> scheduledWeekDays;
    private List<Long> selectedVideoItemIds;

    @SerializedName("sticker_ban")
    public boolean stickerBan;

    @SerializedName("sticker_ban_toast")
    public String stickerBanToast;

    @SerializedName("subscribe_info")
    public AnnouncementSubscribeInfo subscribeInfo;

    @SerializedName("switch_can_open")
    public boolean switchCanOpen;

    @SerializedName("switch")
    public boolean switchStatus;
    private String tip;
    private String tipUrl;
    private String urlDesc;

    @SerializedName("video_item_ids")
    public List<Long> videoItemIds;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final boolean containRedPackage() {
        List<RedPacket> r100 = this.redPackets;
        if (r100 == null) goto L7;
        Intrinsics.checkNotNull(r100);
        if (r100.isEmpty() == true) goto L7;
        return true;
    L7:
        return false;
    }

    public final AnnouncementInfo copy() {
        AnnouncementInfo r100 = new AnnouncementInfo();
        r100.content = this.content;
        r100.scheduledTimeText = this.scheduledTimeText;
        r100.groupSwitch = this.groupSwitch;
        r100.checkedGroupIdList = new ArrayList();
        Iterator<Long> r101 = this.checkedGroupIdList.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        long r102 = r101.next().longValue();
        r100.checkedGroupIdList.add(Long.valueOf(r102));
        goto L4
    L6:
        r100.scheduledWeekDays = new ArrayList();
        List<Integer> r103 = this.scheduledWeekDays;
        Intrinsics.checkNotNull(r103);
        Iterator<Integer> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L12;
        int r105 = r104.next().intValue();
        List<Integer> r106 = r100.scheduledWeekDays;
        if (r106 == null) goto L8;
        r106.add(Integer.valueOf(r105));
        goto L8
    L12:
        r100.scheduledDate = this.scheduledDate;
        r100.scheduledTime = this.scheduledTime;
        r100.autoPublishSwitch = this.autoPublishSwitch;
        r100.expireTime = this.expireTime;
        r100.groupRemindTime = this.groupRemindTime;
        return r100;
    }

    public final AnnouncementInfo copyOpt() {
        AnnouncementInfo r100 = new AnnouncementInfo();
        r100.content = this.content;
        r100.scheduledTimeText = this.scheduledTimeText;
        r100.groupSwitch = this.groupSwitch;
        r100.checkedGroupIdList = new ArrayList();
        Iterator<Long> r101 = this.checkedGroupIdList.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        long r102 = r101.next().longValue();
        r100.checkedGroupIdList.add(Long.valueOf(r102));
        goto L4
    L6:
        r100.scheduledWeekDays = new ArrayList();
        List<Integer> r103 = this.scheduledWeekDays;
        Intrinsics.checkNotNull(r103);
        Iterator<Integer> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L12;
        int r105 = r104.next().intValue();
        List<Integer> r106 = r100.scheduledWeekDays;
        if (r106 == null) goto L8;
        r106.add(Integer.valueOf(r105));
        goto L8
    L12:
        r100.scheduledDate = this.scheduledDate;
        r100.scheduledTime = this.scheduledTime;
        r100.autoPublishSwitch = this.autoPublishSwitch;
        r100.expireTime = this.expireTime;
        r100.groupRemindTime = this.groupRemindTime;
        r100.redPackets = new ArrayList();
        List<RedPacket> r107 = this.redPackets;
        if (r107 == null) goto L22;
        Intrinsics.checkNotNull(r107);
        if (r107.isEmpty() == true) goto L22;
        List<RedPacket> r108 = this.redPackets;
        Intrinsics.checkNotNull(r108);
        Iterator<RedPacket> r109 = r108.iterator();
    L18:
        if (r109.hasNext() == false) goto L22;
        RedPacket r110 = r109.next();
        RedPacket r111 = new RedPacket();
        r111.prompt = r110.prompt;
        r111.setCurrency(r110.getCurrency());
        r111.orderNo = r110.orderNo;
        r111.setAmount(r110.getAmount());
        List<RedPacket> r112 = r100.redPackets;
        if (r112 == null) goto L18;
        r112.add(r111);
    L22:
        return r100;
    }

    public final void generateAllGroupIdList() {
        this.allGroupIdList.clear();
        int r100 = this.allFanGroupList.size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L5;
        this.allGroupIdList.add(Long.valueOf(((AnnouncementFanGroupInfo) ListProtector.get(this.allFanGroupList, r101)).groupId));
        r101 = r101 + 1;
        goto L3
    }

    public final int getAutoPublishStatus() {
        if (this.autoPublishSwitch == 1) goto L6;
        return 104;
    L6:
        return getPublishStatus();
    }

    public final int getPublishStatus() {
        Boolean r100 = this.isHighlightOn;
        Intrinsics.checkNotNull(r100);
        if (r100.booleanValue() == false) goto L7;
        return 101;
    L7:
        if (isValid() == true) goto L11;
        return 102;
    L11:
        if (this.switchStatus == true) goto L15;
        return 103;
    L15:
        if (this.available == true) goto L19;
        return 105;
    L19:
        if (this.auditStatus == 3) goto L21;
        return 106;
    L21:
        return 0;
    }

    public final boolean hasValidAnnouncement() {
        if (this.auditStatus == 3) goto L5;
    L9:
        return false;
    L5:
        if (isValid() == false) goto L9;
        if (this.available == false) goto L9;
        return true;
    }

    public final void initDateInfo() {
        String r100 = this.scheduledTimeText;
        int r101 = 0;
        if (r100 == null) goto L11;
        Intrinsics.checkNotNull(r100);
        if (r100.length() != 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L11;
        this.dateInfo = generateDateInfo(this.scheduledTimeText);
        return;
    L7:
        r102 = false;
    L11:
        this.dateInfo = new b(r101);
    }

    public final boolean isValid() {
        List<Integer> r100 = this.scheduledWeekDays;
        Intrinsics.checkNotNull(r100);
        if (r100.isEmpty() == true) goto L5;
    L8:
        return true;
    L5:
        if (this.scheduledDate != 0) goto L8;
        return false;
    }

    public String toString() {
        return "AnnouncementInfo{available=" + this.available + ", switchStatus=" + this.switchStatus + ", switchCanOpen=" + this.switchCanOpen + ", bannedStatus=" + this.bannedStatus + ", banFinishTime=" + this.banFinishTime + ", banType=" + this.banType + ", stickerBan=" + this.stickerBan + ", stickerBanToast='" + this.stickerBanToast + "', scheduledTime=" + this.scheduledTime + ", scheduledDate=" + this.scheduledDate + ", scheduledWeekDays=" + this.scheduledWeekDays + ", scheduledTimeText='" + this.scheduledTimeText + "', content='" + this.content + "', auditStatus=" + this.auditStatus + ", maxEditContentTime=" + this.maxEditContentTime + ", reachMaxUpdateLimit=" + this.reachMaxUpdateLimit + ", groupSwitch=" + this.groupSwitch + ", checkedGroupIdList=" + this.checkedGroupIdList + ", allFanGroupList=" + this.allFanGroupList + ", groupRemindTime=" + this.groupRemindTime + ", subscribeInfo=" + this.subscribeInfo + ", isHighlightOn=" + this.isHighlightOn + ", tip='" + this.tip + "', tipUrl='" + this.tipUrl + "', urlDesc='" + this.urlDesc + "', editContent=" + this.editContent + ", editTime=" + this.editTime + ", editFanGroupList=" + this.editFanGroupList + ", editFanGroupRemindTime=" + this.editFanGroupRemindTime + ", editFanGroupSwitch=" + this.editFanGroupSwitch + '}';
    }

    public final long toTimeMs() {
        return CastLongProtector.parseLong(String.valueOf(this.nextLiveStartTime) + "000");
    L5:
        return 0;
    }

    public AnnouncementInfo() {
        this.nextLiveStartTimeStr = "";
        this.expireTime = 0L;
        this.selectedVideoItemIds = new ArrayList();
        this.tip = "";
        this.tipUrl = "";
        this.urlDesc = "查看示例";
        this.allGroupIdList = new ArrayList();
        this.scheduledWeekDays = new ArrayList();
        this.scheduledTimeText = "";
        this.content = "";
        this.auditStatus = 3;
        this.maxEditContentTime = 3;
        this.checkedGroupIdList = new ArrayList();
        this.allFanGroupList = new ArrayList();
        this.redPackets = new ArrayList();
        this.groupRemindTime = -1;
        this.subscribeInfo = new AnnouncementSubscribeInfo();
        this.isHighlightOn = Boolean.FALSE;
        this.autoPublishSwitch = 1;
        this.announcementId = -1;
        this.videoItemIds = new ArrayList();
    }

    public final boolean canPublish() {
        if (isValid() == true) goto L5;
    L13:
        return false;
    L5:
        if (this.switchStatus == false) goto L13;
        if (this.available == false) goto L13;
        if (this.auditStatus != 3) goto L13;
        Boolean r100 = this.isHighlightOn;
        Intrinsics.checkNotNull(r100);
        if (r100.booleanValue() == true) goto L13;
        return true;
    }

    public final String getRedPacketOrderNo() {
        if (containRedPackage() == false) goto L5;
        List<RedPacket> r100 = this.redPackets;
        Intrinsics.checkNotNull(r100);
        return ((RedPacket) ListProtector.get(r100, 0)).orderNo;
    L5:
        return "";
    }

    public final String getRedPacketPrompt() {
        if (containRedPackage() == false) goto L5;
        List<RedPacket> r100 = this.redPackets;
        Intrinsics.checkNotNull(r100);
        return ((RedPacket) ListProtector.get(r100, 0)).prompt;
    L5:
        return "";
    }

    public final boolean isValidForPushDialog() {
        if (hasValidAnnouncement() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.switchStatus == false) goto L7;
        return true;
    }

    public final List<Long> getAllGroupIdList() {
        return this.allGroupIdList;
    }

    public final b getDateInfo() {
        return this.dateInfo;
    }

    public final boolean getEditAutoPublishSwitch() {
        return this.editAutoPublishSwitch;
    }

    public final boolean getEditContent() {
        return this.editContent;
    }

    public final boolean getEditFanGroupList() {
        return this.editFanGroupList;
    }

    public final boolean getEditFanGroupRemindTime() {
        return this.editFanGroupRemindTime;
    }

    public final boolean getEditFanGroupSwitch() {
        return this.editFanGroupSwitch;
    }

    public final boolean getEditTime() {
        return this.editTime;
    }

    public final boolean getEditVideoBind() {
        return this.editVideoBind;
    }

    public final List<Long> getSelectedVideoItemIds() {
        return this.selectedVideoItemIds;
    }

    public final String getTip() {
        return this.tip;
    }

    public final String getTipUrl() {
        return this.tipUrl;
    }

    public final String getUrlDesc() {
        return this.urlDesc;
    }

    public AnnouncementInfo(g r100) {
        this.scheduledWeekDays = new ArrayList();
        this.checkedGroupIdList = new ArrayList();
        this.allFanGroupList = new ArrayList();
        this.redPackets = new ArrayList();
        this.videoItemIds = new ArrayList();
        this.nextLiveStartTimeStr = "";
        this.expireTime = 0L;
        this.selectedVideoItemIds = new ArrayList();
        this.tip = "";
        this.tipUrl = "";
        this.urlDesc = "查看示例";
        this.allGroupIdList = new ArrayList();
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L36;
        switch(r103) {
            case 1: goto L35;
            case 2: goto L34;
            case 3: goto L33;
            case 4: goto L32;
            case 5: goto L31;
            case 6: goto L30;
            case 7: goto L29;
            case 8: goto L27;
            case 9: goto L26;
            case 10: goto L25;
            case 11: goto L24;
            case 12: goto L23;
            case 13: goto L22;
            case 14: goto L21;
            case 15: goto L19;
            case 16: goto L18;
            case 17: goto L17;
            case 18: goto L16;
            case 19: goto L15;
            case 20: goto L14;
            case 21: goto L13;
            case 22: goto L12;
            case 23: goto L11;
            case 24: goto L10;
            case 25: goto L9;
            case 26: goto L8;
            case 27: goto L6;
            case 28: goto L7;
            default: goto L6;
        };
    L7:
        List r104 = this.redPackets;
        Object r105 = new RedPacket(r100);
    L28:
        r104.add(r105);
        goto L3
    L8:
        this.factionBrokerId = r100.j();
        goto L3
    L9:
        r104 = this.videoItemIds;
    L20:
        r105 = Long.valueOf(r100.j());
        goto L28
    L10:
        this.announcementId = r100.j();
        r102 = r102 | 16;
        goto L3
    L11:
        this.autoPublishSwitch = r100.i();
        r102 = r102 | 8;
        goto L3
    L12:
        this.stickerBanToast = am3.h.c(r100);
        goto L3
    L13:
        this.stickerBan = am3.h.a(r100);
        goto L3
    L14:
        this.isHighlightOn = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L15:
        this.subscribeInfo = new AnnouncementSubscribeInfo(r100);
        goto L3
    L16:
        this.banType = r100.i();
        goto L3
    L17:
        this.groupRemindTime = r100.j();
        r102 = r102 | 4;
        goto L3
    L18:
        r104 = this.allFanGroupList;
        r105 = new AnnouncementFanGroupInfo(r100);
        goto L28
    L19:
        r104 = this.checkedGroupIdList;
        goto L20
    L21:
        this.groupSwitch = am3.h.a(r100);
        goto L3
    L22:
        this.reachMaxUpdateLimit = am3.h.a(r100);
        goto L3
    L23:
        this.maxEditContentTime = r100.i();
        r102 = r102 | 2;
        goto L3
    L24:
        this.auditStatus = r100.i();
        r102 = r102 | 1;
        goto L3
    L25:
        this.content = am3.h.c(r100);
        goto L3
    L26:
        this.scheduledTimeText = am3.h.c(r100);
        goto L3
    L27:
        r104 = this.scheduledWeekDays;
        r105 = Integer.valueOf(r100.i());
        goto L28
    L29:
        this.scheduledDate = r100.i();
        goto L3
    L30:
        this.scheduledTime = r100.i();
        goto L3
    L31:
        this.banFinishTime = r100.j();
        goto L3
    L32:
        this.bannedStatus = r100.i();
        goto L3
    L33:
        this.switchCanOpen = am3.h.a(r100);
        goto L3
    L34:
        this.switchStatus = am3.h.a(r100);
        goto L3
    L35:
        this.available = am3.h.a(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L36:
        r100.d(r101);
        if (this.scheduledWeekDays.isEmpty() == false) goto L40;
        this.scheduledWeekDays = new ArrayList();
    L40:
        if (this.scheduledTimeText != null) goto L43;
        this.scheduledTimeText = "";
    L43:
        if (this.content != null) goto L46;
        this.content = "";
    L46:
        if ((r102 & 1) != 0) goto L49;
        this.auditStatus = 3;
    L49:
        if ((r102 & 2) != 0) goto L52;
        this.maxEditContentTime = 3;
    L52:
        if (this.checkedGroupIdList.isEmpty() == false) goto L55;
        this.checkedGroupIdList = new ArrayList();
    L55:
        if (this.allFanGroupList.isEmpty() == false) goto L58;
        this.allFanGroupList = new ArrayList();
    L58:
        if (this.redPackets.isEmpty() == false) goto L61;
        this.redPackets = new ArrayList();
    L61:
        if ((r102 & 4) != 0) goto L64;
        this.groupRemindTime = -1;
    L64:
        if (this.subscribeInfo != null) goto L67;
        this.subscribeInfo = new AnnouncementSubscribeInfo();
    L67:
        if (this.isHighlightOn != null) goto L70;
        this.isHighlightOn = Boolean.FALSE;
    L70:
        if ((r102 & 8) != 0) goto L73;
        this.autoPublishSwitch = 1;
    L73:
        if ((r102 & 16) != 0) goto L76;
        this.announcementId = -1;
    L76:
        if (this.videoItemIds.isEmpty() == false) goto L133;
        this.videoItemIds = new ArrayList();
        return;
    }

    public final b generateDateInfo(String r110) {
        Date r100 = null;
        SimpleDateFormat r101 = new SimpleDateFormat("yyyyMMdd-HHmm");     // Catch: Exception -> L15
        String r102 = String.valueOf(this.scheduledTime) + "";     // Catch: Exception -> L15
        int r103 = 4 - r102.length();     // Catch: Exception -> L15
        int r104 = 0;
    L4:
        if (r104 >= r103) goto L7;
        r102 = '0' + r102;     // Catch: Exception -> L15
        r104 = r104 + 1;     // Catch: Exception -> L15
        goto L4
    L7:
        if (this.scheduledDate == 0) goto L9;
        r100 = r101.parse(this.scheduledDate + '-' + r102);     // Catch: Exception -> L15
    L17:
        ArrayList r105 = new ArrayList();
        List<Integer> r106 = this.scheduledWeekDays;
        Intrinsics.checkNotNull(r106);
        Iterator<Integer> r107 = r106.iterator();
    L19:
        if (r107.hasNext() == false) goto L28;
        int r108 = r107.next().intValue();
        String[] r109 = c.f103134a;
        String r111 = c.f103137d.get(Integer.valueOf(r108));
        if (r111 == null) goto L19;
        if (r111.length() != 0) goto L25;
        boolean r112 = true;
    L26:
        if (r112 == true) goto L19;
        r105.add(new d(r111, true));
        goto L19
    L25:
        r112 = false;
        goto L26
    L28:
        Intrinsics.checkNotNull(r110);
        return new b(r100, r105, r110, this.scheduledWeekDays);
    L9:
        List<Integer> r113 = this.scheduledWeekDays;     // Catch: Exception -> L15
        if (r113 == null) goto L17;
        Intrinsics.checkNotNull(r113);     // Catch: Exception -> L15
        if (r113.isEmpty() == true) goto L17;
        r100 = r101.parse(new SimpleDateFormat("yyyyMMdd").format(new Date()) + '-' + r102);     // Catch: Exception -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    public final boolean redPacketChanged(AnnouncementInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        List<RedPacket> r101 = this.redPackets;
        if (r101 == null) goto L8;
        Intrinsics.checkNotNull(r101);
        if (r101.isEmpty() == true) goto L8;
        List<RedPacket> r102 = this.redPackets;
        Intrinsics.checkNotNull(r102);
        int r103 = r102.size();
    L9:
        List<RedPacket> r104 = r100.redPackets;
        if (r104 == null) goto L15;
        Intrinsics.checkNotNull(r104);
        if (r104.isEmpty() == true) goto L15;
        List<RedPacket> r105 = r100.redPackets;
        Intrinsics.checkNotNull(r105);
        int r106 = r105.size();
    L17:
        if (r103 == r106) goto L19;
    L18:
        return true;
    L19:
        if (r103 != 1) goto L22;
        if (r106 != 1) goto L22;
        List<RedPacket> r107 = this.redPackets;
        Intrinsics.checkNotNull(r107);
        String r108 = ((RedPacket) ListProtector.get(r107, 0)).orderNo;
        List<RedPacket> r109 = r100.redPackets;
        Intrinsics.checkNotNull(r109);
        return !Intrinsics.areEqual(r108, ((RedPacket) ListProtector.get(r109, 0)).orderNo);
    L22:
        if (r103 != 0) goto L18;
        if (r106 != 0) goto L18;
        return false;
    L15:
        r106 = 0;
    L8:
        r103 = 0;
        goto L9
    }

    public final void setAllGroupIdList(List<Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.allGroupIdList = r100;
    }

    public final void setDateInfo(b r100) {
        this.dateInfo = r100;
    }

    public final void setEditAutoPublishSwitch(boolean r100) {
        this.editAutoPublishSwitch = r100;
    }

    public final void setEditContent(boolean r100) {
        this.editContent = r100;
    }

    public final void setEditFanGroupList(boolean r100) {
        this.editFanGroupList = r100;
    }

    public final void setEditFanGroupRemindTime(boolean r100) {
        this.editFanGroupRemindTime = r100;
    }

    public final void setEditFanGroupSwitch(boolean r100) {
        this.editFanGroupSwitch = r100;
    }

    public final void setEditTime(boolean r100) {
        this.editTime = r100;
    }

    public final void setEditVideoBind(boolean r100) {
        this.editVideoBind = r100;
    }

    public final void setSelectedVideoItemIds(List<Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.selectedVideoItemIds = r100;
    }

    public final void setTip(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.tip = r100;
    }

    public final void setTipUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.tipUrl = r100;
    }

    public final void setUrlDesc(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.urlDesc = r100;
    }
}
