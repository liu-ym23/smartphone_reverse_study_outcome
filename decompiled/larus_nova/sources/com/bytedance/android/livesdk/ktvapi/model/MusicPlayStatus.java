package com.bytedance.android.livesdk.ktvapi.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/model/MusicPlayStatus;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", "PAUSED", "PLAYING", "STOP", "livektv-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MusicPlayStatus extends Enum<MusicPlayStatus> {
    public static final MusicPlayStatus PAUSED = null;
    public static final MusicPlayStatus PLAYING = null;
    public static final MusicPlayStatus STOP = null;
    public static final MusicPlayStatus UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MusicPlayStatus[] f142324a = null;
    private final int value;

    static {
        MusicPlayStatus r100 = new MusicPlayStatus("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        MusicPlayStatus r101 = new MusicPlayStatus("PAUSED", 1, 1);
        PAUSED = r101;
        MusicPlayStatus r102 = new MusicPlayStatus("PLAYING", 2, 2);
        PLAYING = r102;
        MusicPlayStatus r103 = new MusicPlayStatus("STOP", 3, 3);
        STOP = r103;
        f142324a = new MusicPlayStatus[]{r100, r101, r102, r103};
    }

    public static MusicPlayStatus valueOf(String r100) {
        return (MusicPlayStatus) a.a(MusicPlayStatus.class, r100);
    }

    public static MusicPlayStatus[] values() {
        return (MusicPlayStatus[]) f142324a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public MusicPlayStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
