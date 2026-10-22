package com.bytedance.android.livesdk.chatroom.view;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/view/PreviewType;", "", "UNKNOWN", "SERVER_IMAGE", "VIDEO", "LOCAL_IMAGE", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PreviewType extends Enum<PreviewType> {
    public static final PreviewType LOCAL_IMAGE = null;
    public static final PreviewType SERVER_IMAGE = null;
    public static final PreviewType UNKNOWN = null;
    public static final PreviewType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PreviewType[] f114724a = null;

    static {
        PreviewType r100 = new PreviewType("UNKNOWN", 0);
        UNKNOWN = r100;
        PreviewType r101 = new PreviewType("SERVER_IMAGE", 1);
        SERVER_IMAGE = r101;
        PreviewType r102 = new PreviewType("VIDEO", 2);
        VIDEO = r102;
        PreviewType r103 = new PreviewType("LOCAL_IMAGE", 3);
        LOCAL_IMAGE = r103;
        f114724a = new PreviewType[]{r100, r101, r102, r103};
    }

    public static PreviewType valueOf(String r100) {
        return (PreviewType) r27.a.a(PreviewType.class, r100);
    }

    public static PreviewType[] values() {
        return (PreviewType[]) f114724a.clone();
    }

    public PreviewType(String r100, int r101) {
        super(r100, r101);
    }
}
