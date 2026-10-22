package com.bytedance.android.livesdkapi.depend.message;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/GetDressPageListMode;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "LIST_MODE_UNKNOWN", "LIST_MODE_PREVIEW", "LIST_MODE_FULL", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum GetDressPageListMode extends Enum<GetDressPageListMode> {
    private static final /* synthetic */ GetDressPageListMode[] $VALUES = null;
    public static final GetDressPageListMode LIST_MODE_FULL = null;
    public static final GetDressPageListMode LIST_MODE_PREVIEW = null;
    public static final GetDressPageListMode LIST_MODE_UNKNOWN = null;
    private final int value;

    static {
        GetDressPageListMode r100 = new GetDressPageListMode("LIST_MODE_UNKNOWN", 0, 0);
        LIST_MODE_UNKNOWN = r100;
        GetDressPageListMode r101 = new GetDressPageListMode("LIST_MODE_PREVIEW", 1, 1);
        LIST_MODE_PREVIEW = r101;
        GetDressPageListMode r102 = new GetDressPageListMode("LIST_MODE_FULL", 2, 2);
        LIST_MODE_FULL = r102;
        $VALUES = new GetDressPageListMode[]{r100, r101, r102};
    }

    public static GetDressPageListMode valueOf(String r100) {
        return (GetDressPageListMode) a.a(GetDressPageListMode.class, r100);
    }

    public static GetDressPageListMode[] values() {
        return (GetDressPageListMode[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    private GetDressPageListMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
