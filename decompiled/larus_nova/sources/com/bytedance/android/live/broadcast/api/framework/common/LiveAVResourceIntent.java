package com.bytedance.android.live.broadcast.api.framework.common;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/framework/common/LiveAVResourceIntent;", "", "", "value", "I", "getValue", "()I", "StartCapture", "StopCapture", "SetAudioMute", "ResumeAudioMute", "CloseAllCapture", "SwitchAVPushSource", "StartPush", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveAVResourceIntent extends Enum<LiveAVResourceIntent> {
    public static final LiveAVResourceIntent CloseAllCapture = null;
    public static final LiveAVResourceIntent ResumeAudioMute = null;
    public static final LiveAVResourceIntent SetAudioMute = null;
    public static final LiveAVResourceIntent StartCapture = null;
    public static final LiveAVResourceIntent StartPush = null;
    public static final LiveAVResourceIntent StopCapture = null;
    public static final LiveAVResourceIntent SwitchAVPushSource = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveAVResourceIntent[] f58982a = null;
    private final int value;

    static {
        LiveAVResourceIntent r100 = new LiveAVResourceIntent("StartCapture", 0, 0);
        StartCapture = r100;
        LiveAVResourceIntent r101 = new LiveAVResourceIntent("StopCapture", 1, 1);
        StopCapture = r101;
        LiveAVResourceIntent r102 = new LiveAVResourceIntent("SetAudioMute", 2, 2);
        SetAudioMute = r102;
        LiveAVResourceIntent r103 = new LiveAVResourceIntent("ResumeAudioMute", 3, 3);
        ResumeAudioMute = r103;
        LiveAVResourceIntent r104 = new LiveAVResourceIntent("CloseAllCapture", 4, 4);
        CloseAllCapture = r104;
        LiveAVResourceIntent r105 = new LiveAVResourceIntent("SwitchAVPushSource", 5, 5);
        SwitchAVPushSource = r105;
        LiveAVResourceIntent r106 = new LiveAVResourceIntent("StartPush", 6, 6);
        StartPush = r106;
        f58982a = new LiveAVResourceIntent[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static LiveAVResourceIntent valueOf(String r100) {
        return (LiveAVResourceIntent) r27.a.a(LiveAVResourceIntent.class, r100);
    }

    public static LiveAVResourceIntent[] values() {
        return (LiveAVResourceIntent[]) f58982a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LiveAVResourceIntent(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
