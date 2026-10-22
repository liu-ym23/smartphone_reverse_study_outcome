package com.bytedance.android.livesdk.ktvapi.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/model/KtvRoomStatus;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", "WAITING", "PLAYING", "livektv-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum KtvRoomStatus extends Enum<KtvRoomStatus> {
    public static final KtvRoomStatus PLAYING = null;
    public static final KtvRoomStatus UNKNOWN = null;
    public static final KtvRoomStatus WAITING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KtvRoomStatus[] f142321a = null;
    private final int value;

    static {
        KtvRoomStatus r100 = new KtvRoomStatus("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        KtvRoomStatus r101 = new KtvRoomStatus("WAITING", 1, 1);
        WAITING = r101;
        KtvRoomStatus r102 = new KtvRoomStatus("PLAYING", 2, 2);
        PLAYING = r102;
        f142321a = new KtvRoomStatus[]{r100, r101, r102};
    }

    public static KtvRoomStatus valueOf(String r100) {
        return (KtvRoomStatus) a.a(KtvRoomStatus.class, r100);
    }

    public static KtvRoomStatus[] values() {
        return (KtvRoomStatus[]) f142321a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public KtvRoomStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
