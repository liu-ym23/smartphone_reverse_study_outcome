package com.bytedance.android.livesdk.castscreen.castscreenapi.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/castscreen/castscreenapi/model/PlayType;", "", "", "value", "J", "getValue", "()J", "Unknown", "PC", "Pad", "PCPad", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PlayType extends Enum<PlayType> {
    public static final PlayType PC = null;
    public static final PlayType PCPad = null;
    public static final PlayType Pad = null;
    public static final PlayType Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PlayType[] f104458a = null;
    private final long value;

    static {
        PlayType r100 = new PlayType("Unknown", 0, 0);
        Unknown = r100;
        PlayType r101 = new PlayType("PC", 1, 1);
        PC = r101;
        PlayType r102 = new PlayType("Pad", 2, 2);
        Pad = r102;
        PlayType r103 = new PlayType("PCPad", 3, 3);
        PCPad = r103;
        f104458a = new PlayType[]{r100, r101, r102, r103};
    }

    public static PlayType valueOf(String r100) {
        return (PlayType) r27.a.a(PlayType.class, r100);
    }

    public static PlayType[] values() {
        return (PlayType[]) f104458a.clone();
    }

    public final long getValue() {
        return this.value;
    }

    public PlayType(String r100, int r101, long r102) {
        super(r100, r101);
        this.value = r102;
    }
}
