package com.bytedance.android.live.liveinteract.videotalk.avatarmix;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/avatarmix/MicseatType;", "", "Empty", "VideoVoice", "Video", "Voice", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MicseatType extends Enum<MicseatType> {
    public static final MicseatType Empty = null;
    public static final MicseatType Video = null;
    public static final MicseatType VideoVoice = null;
    public static final MicseatType Voice = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MicseatType[] f79069a = null;

    static {
        MicseatType r100 = new MicseatType("Empty", 0);
        Empty = r100;
        MicseatType r101 = new MicseatType("VideoVoice", 1);
        VideoVoice = r101;
        MicseatType r102 = new MicseatType("Video", 2);
        Video = r102;
        MicseatType r103 = new MicseatType("Voice", 3);
        Voice = r103;
        f79069a = new MicseatType[]{r100, r101, r102, r103};
    }

    public static MicseatType valueOf(String r100) {
        return (MicseatType) r27.a.a(MicseatType.class, r100);
    }

    public static MicseatType[] values() {
        return (MicseatType[]) f79069a.clone();
    }

    public MicseatType(String r100, int r101) {
        super(r100, r101);
    }
}
