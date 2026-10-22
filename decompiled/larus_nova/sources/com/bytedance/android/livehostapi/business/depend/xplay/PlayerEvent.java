package com.bytedance.android.livehostapi.business.depend.xplay;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/xplay/PlayerEvent;", "", "code", "", "data", "Lorg/json/JSONObject;", "(ILorg/json/JSONObject;)V", "getCode", "()I", "getData", "()Lorg/json/JSONObject;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerEvent {
    public static final Companion Companion = null;
    public static final int EVENT_AUD_UPSTREAM = 31;
    public static final int EVENT_BYTECPVIEW_UPDATE_SIZE = 30;
    public static final int EVENT_CONNECTION_INTERRUPTED = 16;
    public static final int EVENT_CONNECTION_LOST = 22;
    public static final int EVENT_DETECT_DELAY = 12;
    public static final int EVENT_FIRST_FRAME = 8;
    public static final int EVENT_FIRST_FRAME_TIMEOUT = 9;
    public static final int EVENT_GAME_CLOSE = 18;
    public static final int EVENT_GAME_EXIT = 17;
    public static final int EVENT_GAME_PLATFORM_TYPE = 20;
    public static final int EVENT_HOST_OFFLINE = 25;
    public static final int EVENT_MERGE_STREAM_RESULT = 41;
    public static final int EVENT_MOUSE_STATE_CHANGE = 21;
    public static final int EVENT_NETWORK_CHANGE = 0;
    public static final int EVENT_NETWORK_DETECTION_RESULT = 28;
    public static final int EVENT_NETWORK_DETECTION_STOP = 29;
    public static final int EVENT_NETWORK_QUALITY_FLUCTUATE = 26;
    public static final int EVENT_PAUSE = 4;
    public static final int EVENT_PERFORMANCE_DETECT_STATS = 40;
    public static final int EVENT_PERFORMANCE_STATS = 13;
    public static final int EVENT_PLAY = 2;
    public static final int EVENT_PUSH_STREAM_RESULT = 38;
    public static final int EVENT_RECONNECTION = 5;
    public static final int EVENT_RECONNECTION_FAIL = 6;
    public static final int EVENT_START_REQUEST_GAME = 1;
    public static final int EVENT_STOP = 3;
    public static final int EVENT_TIME_DOWN_CALLBACK = 15;
    public static final int EVENT_TIME_DOWN_START = 14;
    public static final int EVENT_TIME_OVER = 11;
    public static final int EVENT_TIME_UPDATE = 27;
    public static final int EVENT_TOKEN_EXPIRE = 7;
    public static final int EVENT_USER_JOIN = 23;
    public static final int EVENT_USER_OFFLINE = 24;
    public static final int EVENT_VIDEO_CODEC_TYPE_CHANGED = 36;
    public static final int EVENT_VIDEO_STATE_CHANGE = 33;
    private final int code;
    private final JSONObject data;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b#\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/xplay/PlayerEvent$Companion;", "", "()V", "EVENT_AUD_UPSTREAM", "", "EVENT_BYTECPVIEW_UPDATE_SIZE", "EVENT_CONNECTION_INTERRUPTED", "EVENT_CONNECTION_LOST", "EVENT_DETECT_DELAY", "EVENT_FIRST_FRAME", "EVENT_FIRST_FRAME_TIMEOUT", "EVENT_GAME_CLOSE", "EVENT_GAME_EXIT", "EVENT_GAME_PLATFORM_TYPE", "EVENT_HOST_OFFLINE", "EVENT_MERGE_STREAM_RESULT", "EVENT_MOUSE_STATE_CHANGE", "EVENT_NETWORK_CHANGE", "EVENT_NETWORK_DETECTION_RESULT", "EVENT_NETWORK_DETECTION_STOP", "EVENT_NETWORK_QUALITY_FLUCTUATE", "EVENT_PAUSE", "EVENT_PERFORMANCE_DETECT_STATS", "EVENT_PERFORMANCE_STATS", "EVENT_PLAY", "EVENT_PUSH_STREAM_RESULT", "EVENT_RECONNECTION", "EVENT_RECONNECTION_FAIL", "EVENT_START_REQUEST_GAME", "EVENT_STOP", "EVENT_TIME_DOWN_CALLBACK", "EVENT_TIME_DOWN_START", "EVENT_TIME_OVER", "EVENT_TIME_UPDATE", "EVENT_TOKEN_EXPIRE", "EVENT_USER_JOIN", "EVENT_USER_OFFLINE", "EVENT_VIDEO_CODEC_TYPE_CHANGED", "EVENT_VIDEO_STATE_CHANGE", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ PlayerEvent copy$default(PlayerEvent r100, int r101, JSONObject r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.code;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.data;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.code;
    }

    public final JSONObject component2() {
        return this.data;
    }

    public final PlayerEvent copy(int r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r101, "data");
        return new PlayerEvent(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PlayerEvent) == false) goto L10;
        PlayerEvent r101 = (PlayerEvent) r100;
        if (this.code == r101.code) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        int r100 = this.code * 31;
        JSONObject r101 = this.data;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public String toString() {
        return "PlayerEvent(code=" + this.code + ", data=" + this.data + ")";
    }

    public final int getCode() {
        return this.code;
    }

    public final JSONObject getData() {
        return this.data;
    }

    public PlayerEvent(int r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r101, "data");
        this.code = r100;
        this.data = r101;
    }
}
