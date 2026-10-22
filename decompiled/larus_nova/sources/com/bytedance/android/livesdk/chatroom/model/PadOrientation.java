package com.bytedance.android.livesdk.chatroom.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/PadOrientation;", "", "PORTRAIT", "LANDSCAPE", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PadOrientation extends Enum<PadOrientation> {
    public static final PadOrientation LANDSCAPE = null;
    public static final PadOrientation PORTRAIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PadOrientation[] f106899a = null;

    static {
        PadOrientation r100 = new PadOrientation("PORTRAIT", 0);
        PORTRAIT = r100;
        PadOrientation r101 = new PadOrientation("LANDSCAPE", 1);
        LANDSCAPE = r101;
        f106899a = new PadOrientation[]{r100, r101};
    }

    public static PadOrientation valueOf(String r100) {
        return (PadOrientation) r27.a.a(PadOrientation.class, r100);
    }

    public static PadOrientation[] values() {
        return (PadOrientation[]) f106899a.clone();
    }

    public PadOrientation(String r100, int r101) {
        super(r100, r101);
    }
}
