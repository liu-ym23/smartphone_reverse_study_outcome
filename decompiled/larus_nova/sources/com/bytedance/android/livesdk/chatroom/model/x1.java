package com.bytedance.android.livesdk.chatroom.model;

import com.amap.api.col.s.ce;
import com.bytedance.android.live.base.model.Appointment;
import com.bytedance.android.livesdk.end.EndingPageGuideCardInfo;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\"\u001a\u0004\u0018\u00010!8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001c\u0010'\u001a\u0004\u0018\u00010&8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001c\u0010,\u001a\u0004\u0018\u00010+8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001c\u00101\u001a\u0004\u0018\u0001008\u0006X\u0087\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001c\u00106\u001a\u0004\u0018\u0001058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R(\u0010<\u001a\u0010\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020;\u0018\u00010:8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?¨\u0006@"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/x1;", "", "Lcom/bytedance/android/livesdk/chatroom/model/d0;", "anchorInfo", "Lcom/bytedance/android/livesdk/chatroom/model/d0;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/chatroom/model/d0;", "", "nextWaitSeconds", "Ljava/lang/Integer;", "e", "()Ljava/lang/Integer;", "Lcom/bytedance/android/livesdk/chatroom/model/a3;", "recommendedRooms", "Lcom/bytedance/android/livesdk/chatroom/model/a3;", "f", "()Lcom/bytedance/android/livesdk/chatroom/model/a3;", "", "Lcom/bytedance/android/live/base/model/Appointment;", "appointmentList", "Ljava/util/List;", "b", "()Ljava/util/List;", "Lcom/bytedance/android/livesdk/chatroom/model/g0;", LiveEndPageData.TAG_RESERVATION, "Lcom/bytedance/android/livesdk/chatroom/model/g0;", ce.f26391f, "()Lcom/bytedance/android/livesdk/chatroom/model/g0;", "Lcom/bytedance/android/livesdk/chatroom/model/z1;", "endReplayInfo", "Lcom/bytedance/android/livesdk/chatroom/model/z1;", "c", "()Lcom/bytedance/android/livesdk/chatroom/model/z1;", "Lcom/bytedance/android/livesdk/chatroom/model/e0;", "endCardInfo", "Lcom/bytedance/android/livesdk/chatroom/model/e0;", "getEndCardInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/e0;", "Lcom/bytedance/android/livesdk/chatroom/model/b0;", "previewVideo", "Lcom/bytedance/android/livesdk/chatroom/model/b0;", "getPreviewVideo", "()Lcom/bytedance/android/livesdk/chatroom/model/b0;", "Lcom/bytedance/android/livesdk/end/EndingPageGuideCardInfo;", "guideCardInfo", "Lcom/bytedance/android/livesdk/end/EndingPageGuideCardInfo;", "d", "()Lcom/bytedance/android/livesdk/end/EndingPageGuideCardInfo;", "Lyu1/b;", "scheduleButton", "Lyu1/b;", "h", "()Lyu1/b;", "Lcom/bytedance/android/livesdk/chatroom/model/f0;", "livePromoteCard", "Lcom/bytedance/android/livesdk/chatroom/model/f0;", "getLivePromoteCard", "()Lcom/bytedance/android/livesdk/chatroom/model/f0;", "", "", "buryPointExtra", "Ljava/util/Map;", "getBuryPointExtra", "()Ljava/util/Map;", "room_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class x1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c0 f106985a;

    @SerializedName("anchor_info")
    private final d0 anchorInfo;

    @SerializedName("appointment_list")
    private final List<Appointment> appointmentList;

    @SerializedName("bury_point_extra")
    private final Map<String, String> buryPointExtra;

    @SerializedName("ending_page_card")
    private final e0 endCardInfo;

    @SerializedName("ending_replay_info")
    private final z1 endReplayInfo;

    @SerializedName("guide_card_info")
    private final EndingPageGuideCardInfo guideCardInfo;

    @SerializedName("live_promote_card")
    private final f0 livePromoteCard;

    @SerializedName("next_wait_seconds")
    private final Integer nextWaitSeconds;

    @SerializedName("live_preview_video")
    private final b0 previewVideo;

    @SerializedName("recommend_room")
    private final a3 recommendedRooms;

    @SerializedName("decoration_reservation")
    private final g0 reservation;

    @SerializedName("schedule_button")
    private final yu1.b scheduleButton;

    public x1() {
        this(null, null, null, null, UnixStat.PERM_MASK);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof x1) == false) goto L30;
        x1 r101 = (x1) r100;
        if (Intrinsics.areEqual(this.anchorInfo, r101.anchorInfo) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.nextWaitSeconds, r101.nextWaitSeconds) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.recommendedRooms, r101.recommendedRooms) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appointmentList, r101.appointmentList) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.reservation, r101.reservation) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.endReplayInfo, r101.endReplayInfo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.endCardInfo, r101.endCardInfo) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.previewVideo, r101.previewVideo) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.guideCardInfo, r101.guideCardInfo) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.scheduleButton, r101.scheduleButton) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.livePromoteCard, r101.livePromoteCard) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.buryPointExtra, r101.buryPointExtra) == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    public final int hashCode() {
        d0 r100 = this.anchorInfo;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.nextWaitSeconds;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        a3 r107 = this.recommendedRooms;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<Appointment> r110 = this.appointmentList;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        g0 r113 = this.reservation;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        z1 r116 = this.endReplayInfo;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        e0 r119 = this.endCardInfo;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        b0 r122 = this.previewVideo;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        EndingPageGuideCardInfo r125 = this.guideCardInfo;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        yu1.b r128 = this.scheduleButton;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        f0 r131 = this.livePromoteCard;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        Map<String, String> r134 = this.buryPointExtra;
        if (r134 == null) goto L50;
        r101 = r134.hashCode();
    L50:
        return r133 + r101;
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LiveEndInfo(anchorInfo=" + this.anchorInfo + ", nextWaitSeconds=" + this.nextWaitSeconds + ", recommendedRooms=" + this.recommendedRooms + ", appointmentList=" + this.appointmentList + ", reservation=" + this.reservation + ", endReplayInfo=" + this.endReplayInfo + ", endCardInfo=" + this.endCardInfo + ", previewVideo=" + this.previewVideo + ", guideCardInfo=" + this.guideCardInfo + ", scheduleButton=" + this.scheduleButton + ", livePromoteCard=" + this.livePromoteCard + ", buryPointExtra=" + this.buryPointExtra + ")";
    }

    public final String i() {
        a3 r100 = this.recommendedRooms;
        if (r100 == null) goto L20;
        Map<Long, Long> r101 = r100.b();
        if (r101 == null) goto L20;
        List<IRoom> r102 = this.recommendedRooms.a();
        if (r102 != null) goto L10;
        return "0";
    L10:
        Iterator<T> r103 = r102.iterator();
    L12:
        if (r103.hasNext() == false) goto L20;
        Long r104 = r101.get(Long.valueOf(((IRoom) r103.next()).getId()));
        if (r104 == null) goto L12;
        if (r104.longValue() != 1) goto L12;
        return "1";
    L20:
        return "0";
    }

    public final d0 a() {
        return this.anchorInfo;
    }

    public final List<Appointment> b() {
        return this.appointmentList;
    }

    public final z1 c() {
        return this.endReplayInfo;
    }

    public final EndingPageGuideCardInfo d() {
        return this.guideCardInfo;
    }

    public final Integer e() {
        return this.nextWaitSeconds;
    }

    public final a3 f() {
        return this.recommendedRooms;
    }

    public final g0 g() {
        return this.reservation;
    }

    public final yu1.b h() {
        return this.scheduleButton;
    }

    public final boolean j(long r110) {
        a3 r100 = this.recommendedRooms;
        Object r101 = null;
        if (r100 == null) goto L20;
        Map<Long, Long> r102 = r100.b();
        if (r102 == null) goto L20;
        Set<Map.Entry<Long, Long>> r103 = r102.entrySet();
        if (r103 == null) goto L20;
        Iterator<T> r104 = r103.iterator();
    L10:
        if (r104.hasNext() == false) goto L19;
        Object r105 = r104.next();
        Map.Entry r106 = (Map.Entry) r105;
        if (((Number) r106.getKey()).longValue() == r110) goto L14;
    L16:
        boolean r107 = false;
    L17:
        if (r107 == false) goto L10;
        r101 = r105;
        goto L19
    L14:
        if (((Number) r106.getValue()).longValue() != 1) goto L16;
        r107 = true;
    L19:
        r101 = (Map.Entry) r101;
    L20:
        if (r101 != null) goto L29;
        return false;
    L29:
        return true;
    }

    public x1(d0 r100, Integer r101, a3 r102, List r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this.anchorInfo = r100;
        this.nextWaitSeconds = r101;
        this.recommendedRooms = r102;
        this.appointmentList = r103;
        this.reservation = null;
        this.endReplayInfo = null;
        this.endCardInfo = null;
        this.previewVideo = null;
        this.guideCardInfo = null;
        this.scheduleButton = null;
        this.livePromoteCard = null;
        this.buryPointExtra = null;
    }
}
