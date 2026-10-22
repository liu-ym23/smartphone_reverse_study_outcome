package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/dialog/MicPanelType;", "", "UNKNOWN", "VIDEO_COMMON_WINDOW_LAYOUT", "AUDIO_COMMON_WINDOW_LAYOUT", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MicPanelType extends Enum<MicPanelType> {
    public static final MicPanelType AUDIO_COMMON_WINDOW_LAYOUT = null;
    public static final MicPanelType UNKNOWN = null;
    public static final MicPanelType VIDEO_COMMON_WINDOW_LAYOUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MicPanelType[] f71957a = null;

    static {
        MicPanelType r100 = new MicPanelType("UNKNOWN", 0);
        UNKNOWN = r100;
        MicPanelType r101 = new MicPanelType("VIDEO_COMMON_WINDOW_LAYOUT", 1);
        VIDEO_COMMON_WINDOW_LAYOUT = r101;
        MicPanelType r102 = new MicPanelType("AUDIO_COMMON_WINDOW_LAYOUT", 2);
        AUDIO_COMMON_WINDOW_LAYOUT = r102;
        f71957a = new MicPanelType[]{r100, r101, r102};
    }

    public static MicPanelType valueOf(String r100) {
        return (MicPanelType) r27.a.a(MicPanelType.class, r100);
    }

    public static MicPanelType[] values() {
        return (MicPanelType[]) f71957a.clone();
    }

    public MicPanelType(String r100, int r101) {
        super(r100, r101);
    }
}
