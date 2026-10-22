package com.bytedance.android.livesdk.chatroom.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/AccompanimentMode;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", "MAIN_SINGER", "CENTRALIZATION", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum AccompanimentMode extends Enum<AccompanimentMode> {
    public static final AccompanimentMode CENTRALIZATION = null;
    public static final AccompanimentMode MAIN_SINGER = null;
    public static final AccompanimentMode UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AccompanimentMode[] f106886a = null;
    private final int value;

    static {
        AccompanimentMode r100 = new AccompanimentMode("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        AccompanimentMode r101 = new AccompanimentMode("MAIN_SINGER", 1, 0);
        MAIN_SINGER = r101;
        AccompanimentMode r102 = new AccompanimentMode("CENTRALIZATION", 2, 1);
        CENTRALIZATION = r102;
        f106886a = new AccompanimentMode[]{r100, r101, r102};
    }

    public static AccompanimentMode valueOf(String r100) {
        return (AccompanimentMode) r27.a.a(AccompanimentMode.class, r100);
    }

    public static AccompanimentMode[] values() {
        return (AccompanimentMode[]) f106886a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public AccompanimentMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
