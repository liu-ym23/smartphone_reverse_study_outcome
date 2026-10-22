package com.bytedance.android.livesdk.ktvapi;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/KtvRoomUserLabel;", "", "UNKNOWN", "SINGER", "NEXT", "ORDERED", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum KtvRoomUserLabel extends Enum<KtvRoomUserLabel> {
    public static final KtvRoomUserLabel NEXT = null;
    public static final KtvRoomUserLabel ORDERED = null;
    public static final KtvRoomUserLabel SINGER = null;
    public static final KtvRoomUserLabel UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KtvRoomUserLabel[] f142291a = null;

    static {
        KtvRoomUserLabel r100 = new KtvRoomUserLabel("UNKNOWN", 0);
        UNKNOWN = r100;
        KtvRoomUserLabel r101 = new KtvRoomUserLabel("SINGER", 1);
        SINGER = r101;
        KtvRoomUserLabel r102 = new KtvRoomUserLabel("NEXT", 2);
        NEXT = r102;
        KtvRoomUserLabel r103 = new KtvRoomUserLabel("ORDERED", 3);
        ORDERED = r103;
        f142291a = new KtvRoomUserLabel[]{r100, r101, r102, r103};
    }

    public static KtvRoomUserLabel valueOf(String r100) {
        return (KtvRoomUserLabel) a.a(KtvRoomUserLabel.class, r100);
    }

    public static KtvRoomUserLabel[] values() {
        return (KtvRoomUserLabel[]) f142291a.clone();
    }

    public KtvRoomUserLabel(String r100, int r101) {
        super(r100, r101);
    }
}
