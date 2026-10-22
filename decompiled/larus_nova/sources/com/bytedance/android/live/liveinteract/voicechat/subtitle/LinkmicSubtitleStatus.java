package com.bytedance.android.live.liveinteract.voicechat.subtitle;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/subtitle/LinkmicSubtitleStatus;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", "CHECK_IN", "OPEN", "CLOSE", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LinkmicSubtitleStatus extends Enum<LinkmicSubtitleStatus> {
    public static final LinkmicSubtitleStatus CHECK_IN = null;
    public static final LinkmicSubtitleStatus CLOSE = null;
    public static final LinkmicSubtitleStatus OPEN = null;
    public static final LinkmicSubtitleStatus UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LinkmicSubtitleStatus[] f80652a = null;
    private final int value;

    static {
        LinkmicSubtitleStatus r100 = new LinkmicSubtitleStatus("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        LinkmicSubtitleStatus r101 = new LinkmicSubtitleStatus("CHECK_IN", 1, 1);
        CHECK_IN = r101;
        LinkmicSubtitleStatus r102 = new LinkmicSubtitleStatus("OPEN", 2, 2);
        OPEN = r102;
        LinkmicSubtitleStatus r103 = new LinkmicSubtitleStatus("CLOSE", 3, 3);
        CLOSE = r103;
        f80652a = new LinkmicSubtitleStatus[]{r100, r101, r102, r103};
    }

    public static LinkmicSubtitleStatus valueOf(String r100) {
        return (LinkmicSubtitleStatus) r27.a.a(LinkmicSubtitleStatus.class, r100);
    }

    public static LinkmicSubtitleStatus[] values() {
        return (LinkmicSubtitleStatus[]) f80652a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LinkmicSubtitleStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
