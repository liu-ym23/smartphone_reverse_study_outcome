package com.bytedance.android.livehostapi.business.castscreen.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastPlayConfig;", "", "()V", "continuousPlay", "", "getContinuousPlay", "()Ljava/lang/Integer;", "setContinuousPlay", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "danmakuSetting", "Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastDanmakuSetting;", "getDanmakuSetting", "()Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastDanmakuSetting;", "setDanmakuSetting", "(Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastDanmakuSetting;)V", "keepPlayList", "getKeepPlayList", "()I", "setKeepPlayList", "(I)V", "playerType", "getPlayerType", "setPlayerType", "uiType", "getUiType", "setUiType", "toString", "", "Companion", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCastPlayConfig {
    public static final Companion Companion = null;
    public static final int DECODE_TYPE_HARD = 0;
    public static final int DECODE_TYPE_SOFT = 1;
    public static final int PLAYER_TYPE_OS = 2;
    public static final int PLAYER_TYPE_OWN = 0;
    public static final int PLAYER_TYPE_UNSET = -1;
    public static final int UI_TYPE_ONE = 1;
    public static final int UI_TYPE_THREE = 3;
    public static final int UI_TYPE_TWO = 2;
    private Integer continuousPlay;
    private LiveCastDanmakuSetting danmakuSetting;
    private int keepPlayList;
    private int playerType;
    private int uiType;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastPlayConfig$Companion;", "", "()V", "DECODE_TYPE_HARD", "", "DECODE_TYPE_SOFT", "PLAYER_TYPE_OS", "PLAYER_TYPE_OWN", "PLAYER_TYPE_UNSET", "UI_TYPE_ONE", "UI_TYPE_THREE", "UI_TYPE_TWO", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public String toString() {
        return "LiveCastPlayConfig{playerType: " + this.playerType + ", uiType: " + this.uiType + ", continuousPlay: " + this.continuousPlay + ",}";
    }

    public LiveCastPlayConfig() {
        this.playerType = -1;
        this.uiType = 1;
        this.danmakuSetting = new LiveCastDanmakuSetting();
    }

    public final Integer getContinuousPlay() {
        return this.continuousPlay;
    }

    public final LiveCastDanmakuSetting getDanmakuSetting() {
        return this.danmakuSetting;
    }

    public final int getKeepPlayList() {
        return this.keepPlayList;
    }

    public final int getPlayerType() {
        return this.playerType;
    }

    public final int getUiType() {
        return this.uiType;
    }

    public final void setContinuousPlay(Integer r100) {
        this.continuousPlay = r100;
    }

    public final void setDanmakuSetting(LiveCastDanmakuSetting r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.danmakuSetting = r100;
    }

    public final void setKeepPlayList(int r100) {
        this.keepPlayList = r100;
    }

    public final void setPlayerType(int r100) {
        this.playerType = r100;
    }

    public final void setUiType(int r100) {
        this.uiType = r100;
    }
}
