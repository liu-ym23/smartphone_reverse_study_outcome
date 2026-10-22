package com.bytedance.android.livesdkapi.player.preload.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0018B3\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\b\u0010\u0017\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\n\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdkapi/player/preload/model/PlayerPreloadRequest;", "", "delayedTime", "", "preloadType", "", "parallelWithOtherRequests", "", "streamData", "", "resolution", "(JIZLjava/lang/String;Ljava/lang/String;)V", "getDelayedTime", "()J", "getParallelWithOtherRequests", "()Z", "getPreloadType", "()I", "getResolution", "()Ljava/lang/String;", "setResolution", "(Ljava/lang/String;)V", "getStreamData", "toString", "Builder", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerPreloadRequest {
    private final long delayedTime;
    private final boolean parallelWithOtherRequests;
    private final int preloadType;
    private String resolution;
    private final String streamData;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/player/preload/model/PlayerPreloadRequest$Builder;", "", "()V", "delayedTime", "", "parallelWithOtherRequests", "", "preloadType", "", "resolution", "", "streamData", "build", "Lcom/bytedance/android/livesdkapi/player/preload/model/PlayerPreloadRequest;", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Builder {
        private long delayedTime;
        private boolean parallelWithOtherRequests;
        private int preloadType;
        private String resolution;
        private String streamData;

        public final PlayerPreloadRequest build() {
            return new PlayerPreloadRequest(this.delayedTime, this.preloadType, this.parallelWithOtherRequests, this.streamData, this.resolution, null);
        }

        public Builder() {
            this.preloadType = -1;
            this.streamData = "";
        }

        public final Builder delayedTime(long r100) {
            if (r100 <= 0) goto L5;
            this.delayedTime = r100;
        L5:
            return this;
        }

        public final Builder preloadType(int r100) {
            this.preloadType = r100;
            return this;
        }

        public final Builder resolution(String r100) {
            this.resolution = r100;
            return this;
        }

        public final Builder streamData(String r100) {
            Intrinsics.checkNotNullParameter(r100, "streamData");
            this.streamData = r100;
            return this;
        }
    }

    public String toString() {
        return "PlayerPreloadRequest@" + hashCode() + ": {delayedTime, preloadType, parallelWithOtherRequests,resolution} = { " + this.delayedTime + ", " + this.preloadType + ", " + this.parallelWithOtherRequests + ',' + this.resolution + " }";
    }

    public final long getDelayedTime() {
        return this.delayedTime;
    }

    public final boolean getParallelWithOtherRequests() {
        return this.parallelWithOtherRequests;
    }

    public final int getPreloadType() {
        return this.preloadType;
    }

    public final String getResolution() {
        return this.resolution;
    }

    public final String getStreamData() {
        return this.streamData;
    }

    public final void setResolution(String r100) {
        this.resolution = r100;
    }

    private PlayerPreloadRequest(long r100, int r101, boolean r102, String r103, String r104) {
        this.delayedTime = r100;
        this.preloadType = r101;
        this.parallelWithOtherRequests = r102;
        this.streamData = r103;
        this.resolution = r104;
    }

    public /* synthetic */ PlayerPreloadRequest(long r100, int r101, boolean r102, String r103, String r104, DefaultConstructorMarker r105) {
        this(r100, r101, r102, r103, r104);
    }

    public /* synthetic */ PlayerPreloadRequest(long r100, int r110, boolean r111, String r112, String r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 16) == 0) goto L5;
        r113 = null;
    L5:
        this(r100, r110, r111, r112, r113);
    }
}
