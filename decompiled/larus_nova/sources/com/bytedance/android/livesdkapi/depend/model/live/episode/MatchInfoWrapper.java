package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.heytap.mcssdk.constant.b;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0019\u001a\u00020\tHÆ\u0003JJ\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\tHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/MatchInfoWrapper;", "", "matchId", "", b.f276361k, "", "contentId", ShortVideoSegments.KEY_CAMERA_ID, "cameraType", "", "(JLjava/util/List;JLjava/lang/Long;I)V", "getCameraId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCameraType", "()I", "getContentId", "()J", "getEventId", "()Ljava/util/List;", "getMatchId", "component1", "component2", "component3", "component4", "component5", "copy", "(JLjava/util/List;JLjava/lang/Long;I)Lcom/bytedance/android/livesdkapi/depend/model/live/episode/MatchInfoWrapper;", "equals", "", "other", "hashCode", "toString", "", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MatchInfoWrapper {
    private final Long cameraId;
    private final int cameraType;
    private final long contentId;
    private final List<Long> eventId;
    private final long matchId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MatchInfoWrapper copy$default(MatchInfoWrapper r100, long r101, List r110, long r111, Long r112, int r113, int r114, Object r115) {
        if ((r114 & 1) == 0) goto L5;
        long r102 = r100.matchId;
    L7:
        if ((r114 & 2) == 0) goto L9;
        List r103 = r100.eventId;
    L11:
        if ((r114 & 4) == 0) goto L13;
        long r104 = r100.contentId;
    L15:
        if ((r114 & 8) == 0) goto L17;
        Long r105 = r100.cameraId;
    L19:
        if ((r114 & 16) == 0) goto L21;
        int r106 = r100.cameraType;
    L23:
        return r100.copy(r102, r103, r104, r105, r106);
    L21:
        r106 = r113;
        goto L23
    L17:
        r105 = r112;
        goto L19
    L13:
        r104 = r111;
        goto L15
    L9:
        r103 = r110;
        goto L11
    L5:
        r102 = r101;
        goto L7
    }

    public final long component1() {
        return this.matchId;
    }

    public final List<Long> component2() {
        return this.eventId;
    }

    public final long component3() {
        return this.contentId;
    }

    public final Long component4() {
        return this.cameraId;
    }

    public final int component5() {
        return this.cameraType;
    }

    public final MatchInfoWrapper copy(long r110, List<Long> r111, long r112, Long r113, int r114) {
        return new MatchInfoWrapper(r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof MatchInfoWrapper) == false) goto L16;
        MatchInfoWrapper r101 = (MatchInfoWrapper) r100;
        if (this.matchId == r101.matchId) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.eventId, r101.eventId) == true) goto L10;
        return false;
    L10:
        if (this.contentId == r101.contentId) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cameraId, r101.cameraId) == true) goto L14;
        return false;
    L14:
        if (this.cameraType == r101.cameraType) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        long r100 = this.matchId;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        List<Long> r102 = this.eventId;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        long r105 = this.contentId;
        int r106 = (((r101 + r104) * 31) + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        Long r107 = this.cameraId;
        if (r107 == null) goto L10;
        r103 = r107.hashCode();
    L10:
        return ((r106 + r103) * 31) + this.cameraType;
    L5:
        r104 = 0;
        goto L6
    }

    public String toString() {
        return "MatchInfoWrapper(matchId=" + this.matchId + ", eventId=" + this.eventId + ", contentId=" + this.contentId + ", cameraId=" + this.cameraId + ", cameraType=" + this.cameraType + ")";
    }

    public final Long getCameraId() {
        return this.cameraId;
    }

    public final int getCameraType() {
        return this.cameraType;
    }

    public final long getContentId() {
        return this.contentId;
    }

    public final List<Long> getEventId() {
        return this.eventId;
    }

    public final long getMatchId() {
        return this.matchId;
    }

    public MatchInfoWrapper(long r100, List<Long> r101, long r102, Long r103, int r104) {
        this.matchId = r100;
        this.eventId = r101;
        this.contentId = r102;
        this.cameraId = r103;
        this.cameraType = r104;
    }
}
