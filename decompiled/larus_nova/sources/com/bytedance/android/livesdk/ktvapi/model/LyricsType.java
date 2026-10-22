package com.bytedance.android.livesdk.ktvapi.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/model/LyricsType;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", "LRC", "KRC", "livektv-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LyricsType extends Enum<LyricsType> {
    public static final LyricsType KRC = null;
    public static final LyricsType LRC = null;
    public static final LyricsType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LyricsType[] f142323a = null;
    private final int value;

    static {
        LyricsType r100 = new LyricsType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        LyricsType r101 = new LyricsType("LRC", 1, 2);
        LRC = r101;
        LyricsType r102 = new LyricsType("KRC", 2, 3);
        KRC = r102;
        f142323a = new LyricsType[]{r100, r101, r102};
    }

    public static LyricsType valueOf(String r100) {
        return (LyricsType) a.a(LyricsType.class, r100);
    }

    public static LyricsType[] values() {
        return (LyricsType[]) f142323a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LyricsType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
