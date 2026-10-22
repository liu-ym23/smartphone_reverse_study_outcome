package com.bytedance.android.livesdkapi.depend.message;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/ChangeDressMode;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "CHANGE_MODE_UNKNOWN", "CHANGE_MODE_UPDATE", "CHANGE_MODE_UNDRESS", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ChangeDressMode extends Enum<ChangeDressMode> {
    private static final /* synthetic */ ChangeDressMode[] $VALUES = null;
    public static final ChangeDressMode CHANGE_MODE_UNDRESS = null;
    public static final ChangeDressMode CHANGE_MODE_UNKNOWN = null;
    public static final ChangeDressMode CHANGE_MODE_UPDATE = null;
    private final int value;

    static {
        ChangeDressMode r100 = new ChangeDressMode("CHANGE_MODE_UNKNOWN", 0, 0);
        CHANGE_MODE_UNKNOWN = r100;
        ChangeDressMode r101 = new ChangeDressMode("CHANGE_MODE_UPDATE", 1, 1);
        CHANGE_MODE_UPDATE = r101;
        ChangeDressMode r102 = new ChangeDressMode("CHANGE_MODE_UNDRESS", 2, 2);
        CHANGE_MODE_UNDRESS = r102;
        $VALUES = new ChangeDressMode[]{r100, r101, r102};
    }

    public static ChangeDressMode valueOf(String r100) {
        return (ChangeDressMode) a.a(ChangeDressMode.class, r100);
    }

    public static ChangeDressMode[] values() {
        return (ChangeDressMode[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    private ChangeDressMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
