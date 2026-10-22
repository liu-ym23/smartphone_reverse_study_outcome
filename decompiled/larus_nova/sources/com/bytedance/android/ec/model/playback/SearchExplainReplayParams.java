package com.bytedance.android.ec.model.playback;

import com.larus.bmhome.share.panel.ShareChannel;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\b\u0086\b\u0018\u0000 :2\u00020\u0001:\u0001;B\u007f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b8\u00109J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0088\u0001\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u001d\u001a\u00020\u0002HÖ\u0001J\t\u0010\u001e\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b$\u0010%R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u0012\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b)\u0010%R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010#\u001a\u0004\b*\u0010%R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010#\u001a\u0004\b+\u0010%R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u0016\u0010,\u001a\u0004\b-\u0010.R$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010#\u001a\u0004\b/\u0010%\"\u0004\b0\u00101R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\u0018\u00102\u001a\u0004\b3\u00104R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u0019\u0010&\u001a\u0004\b5\u0010(R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u001a\u00106\u001a\u0004\b7\u0010\u0010¨\u0006<"}, d2 = {"Lcom/bytedance/android/ec/model/playback/SearchExplainReplayParams;", "Ljava/io/Serializable;", "", "component1", "component2", "component3", "component4", "component5", "Lcom/bytedance/android/ec/model/playback/LogExtraData;", "component6", "component7", "Lcom/bytedance/android/ec/model/playback/PlaybackEventExtraData;", "component8", "component9", "", "component10", "()Ljava/lang/Integer;", "commentaryInfo", "userInfo", "uid", "secAuthorId", "followStatus", "logExtraData", com.bytedance.android.ec.core.event.a.KEY_TRACKER, "playbackExtraData", ShareChannel.DOUYIN, "replayVideoStartTime", "copy", "(Ljava/lang/String;Ljava/io/Serializable;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/playback/LogExtraData;Ljava/lang/String;Lcom/bytedance/android/ec/model/playback/PlaybackEventExtraData;Ljava/io/Serializable;Ljava/lang/Integer;)Lcom/bytedance/android/ec/model/playback/SearchExplainReplayParams;", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getCommentaryInfo", "()Ljava/lang/String;", "Ljava/io/Serializable;", "getUserInfo", "()Ljava/io/Serializable;", "getUid", "getSecAuthorId", "getFollowStatus", "Lcom/bytedance/android/ec/model/playback/LogExtraData;", "getLogExtraData", "()Lcom/bytedance/android/ec/model/playback/LogExtraData;", "getTracker", "setTracker", "(Ljava/lang/String;)V", "Lcom/bytedance/android/ec/model/playback/PlaybackEventExtraData;", "getPlaybackExtraData", "()Lcom/bytedance/android/ec/model/playback/PlaybackEventExtraData;", "getAweme", "Ljava/lang/Integer;", "getReplayVideoStartTime", "<init>", "(Ljava/lang/String;Ljava/io/Serializable;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/playback/LogExtraData;Ljava/lang/String;Lcom/bytedance/android/ec/model/playback/PlaybackEventExtraData;Ljava/io/Serializable;Ljava/lang/Integer;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class SearchExplainReplayParams implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;
    private final Serializable aweme;
    private final String commentaryInfo;
    private final String followStatus;
    private final LogExtraData logExtraData;
    private final PlaybackEventExtraData playbackExtraData;
    private final Integer replayVideoStartTime;
    private final String secAuthorId;
    private String tracker;
    private final String uid;
    private final Serializable userInfo;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public SearchExplainReplayParams() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public static /* synthetic */ SearchExplainReplayParams copy$default(SearchExplainReplayParams r110, String r111, Serializable r112, String r113, String r114, String r115, LogExtraData r116, String r117, PlaybackEventExtraData r118, Serializable r210, Integer r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.commentaryInfo;
    L7:
        if ((r212 & 2) == 0) goto L9;
        Serializable r101 = r110.userInfo;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r102 = r110.uid;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r103 = r110.secAuthorId;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r104 = r110.followStatus;
    L23:
        if ((r212 & 32) == 0) goto L25;
        LogExtraData r105 = r110.logExtraData;
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r106 = r110.tracker;
    L31:
        if ((r212 & 128) == 0) goto L33;
        PlaybackEventExtraData r107 = r110.playbackExtraData;
    L35:
        if ((r212 & 256) == 0) goto L37;
        Serializable r119 = r110.aweme;
    L39:
        if ((r212 & 512) == 0) goto L41;
        Integer r108 = r110.replayVideoStartTime;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.commentaryInfo;
    }

    public final Integer component10() {
        return this.replayVideoStartTime;
    }

    public final Serializable component2() {
        return this.userInfo;
    }

    public final String component3() {
        return this.uid;
    }

    public final String component4() {
        return this.secAuthorId;
    }

    public final String component5() {
        return this.followStatus;
    }

    public final LogExtraData component6() {
        return this.logExtraData;
    }

    public final String component7() {
        return this.tracker;
    }

    public final PlaybackEventExtraData component8() {
        return this.playbackExtraData;
    }

    public final Serializable component9() {
        return this.aweme;
    }

    public final SearchExplainReplayParams copy(String r110, Serializable r111, String r112, String r113, String r114, LogExtraData r115, String r116, PlaybackEventExtraData r210, Serializable r211, Integer r212) {
        return new SearchExplainReplayParams(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SearchExplainReplayParams) == false) goto L26;
        SearchExplainReplayParams r101 = (SearchExplainReplayParams) r100;
        if (Intrinsics.areEqual(this.commentaryInfo, r101.commentaryInfo) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.userInfo, r101.userInfo) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.uid, r101.uid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.secAuthorId, r101.secAuthorId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.followStatus, r101.followStatus) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.logExtraData, r101.logExtraData) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.tracker, r101.tracker) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.playbackExtraData, r101.playbackExtraData) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.aweme, r101.aweme) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.replayVideoStartTime, r101.replayVideoStartTime) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        String r100 = this.commentaryInfo;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Serializable r104 = this.userInfo;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.uid;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.secAuthorId;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.followStatus;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        LogExtraData r116 = this.logExtraData;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.tracker;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        PlaybackEventExtraData r122 = this.playbackExtraData;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Serializable r125 = this.aweme;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.replayVideoStartTime;
        if (r128 == null) goto L42;
        r101 = r128.hashCode();
    L42:
        return r127 + r101;
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

    public String toString() {
        return "SearchExplainReplayParams(commentaryInfo=" + this.commentaryInfo + ", userInfo=" + this.userInfo + ", uid=" + this.uid + ", secAuthorId=" + this.secAuthorId + ", followStatus=" + this.followStatus + ", logExtraData=" + this.logExtraData + ", tracker=" + this.tracker + ", playbackExtraData=" + this.playbackExtraData + ", aweme=" + this.aweme + ", replayVideoStartTime=" + this.replayVideoStartTime + ")";
    }

    public final Serializable getAweme() {
        return this.aweme;
    }

    public final String getCommentaryInfo() {
        return this.commentaryInfo;
    }

    public final String getFollowStatus() {
        return this.followStatus;
    }

    public final LogExtraData getLogExtraData() {
        return this.logExtraData;
    }

    public final PlaybackEventExtraData getPlaybackExtraData() {
        return this.playbackExtraData;
    }

    public final Integer getReplayVideoStartTime() {
        return this.replayVideoStartTime;
    }

    public final String getSecAuthorId() {
        return this.secAuthorId;
    }

    public final String getTracker() {
        return this.tracker;
    }

    public final String getUid() {
        return this.uid;
    }

    public final Serializable getUserInfo() {
        return this.userInfo;
    }

    public final void setTracker(String r100) {
        this.tracker = r100;
    }

    public SearchExplainReplayParams(String r100, Serializable r101, String r102, String r103, String r104, LogExtraData r105, String r106, PlaybackEventExtraData r107, Serializable r108, Integer r110) {
        this.commentaryInfo = r100;
        this.userInfo = r101;
        this.uid = r102;
        this.secAuthorId = r103;
        this.followStatus = r104;
        this.logExtraData = r105;
        this.tracker = r106;
        this.playbackExtraData = r107;
        this.aweme = r108;
        this.replayVideoStartTime = r110;
    }

    public /* synthetic */ SearchExplainReplayParams(String r110, Serializable r111, String r112, String r113, String r114, LogExtraData r115, String r116, PlaybackEventExtraData r117, Serializable r210, Integer r211, int r212, DefaultConstructorMarker r213) {
        Integer r100 = null;
        if ((r212 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r212 & 2) == 0) goto L9;
        Serializable r102 = null;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r212 & 32) == 0) goto L25;
        LogExtraData r106 = null;
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r212 & 128) == 0) goto L33;
        PlaybackEventExtraData r108 = null;
    L35:
        if ((r212 & 256) == 0) goto L37;
        Serializable r118 = null;
    L39:
        if ((r212 & 512) != 0) goto L42;
        r100 = r211;
    L42:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r118, r100);
        return;
    L37:
        r118 = r210;
        goto L39
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
