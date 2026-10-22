package com.bytedance.android.livesdkapi.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001a\u0010\u0011\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0014\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerExtraRenderLogInfo;", "", "()V", "isLiveStreaming", "", "()Z", "setLiveStreaming", "(Z)V", "streamLayout", "", "getStreamLayout", "()Ljava/lang/String;", "setStreamLayout", "(Ljava/lang/String;)V", "toAnchorId", "getToAnchorId", "setToAnchorId", "toRoomId", "getToRoomId", "setToRoomId", "toRoomName", "getToRoomName", "setToRoomName", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerExtraRenderLogInfo {
    private boolean isLiveStreaming;
    private String streamLayout;
    private String toAnchorId;
    private String toRoomId;
    private String toRoomName;

    public PlayerExtraRenderLogInfo() {
        this.streamLayout = "";
        this.toAnchorId = "";
        this.toRoomId = "";
        this.toRoomName = "";
    }

    public final String getStreamLayout() {
        return this.streamLayout;
    }

    public final String getToAnchorId() {
        return this.toAnchorId;
    }

    public final String getToRoomId() {
        return this.toRoomId;
    }

    public final String getToRoomName() {
        return this.toRoomName;
    }

    public final boolean isLiveStreaming() {
        return this.isLiveStreaming;
    }

    public final void setLiveStreaming(boolean r100) {
        this.isLiveStreaming = r100;
    }

    public final void setStreamLayout(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.streamLayout = r100;
    }

    public final void setToAnchorId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.toAnchorId = r100;
    }

    public final void setToRoomId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.toRoomId = r100;
    }

    public final void setToRoomName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.toRoomName = r100;
    }
}
