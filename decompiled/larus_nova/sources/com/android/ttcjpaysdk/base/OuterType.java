package com.android.ttcjpaysdk.base;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/OuterType;", "", "value", "", "(Ljava/lang/String;II)V", "TYPE_THIRD_APP", "TYPE_BROWSER", "TYPE_UNKNOWN", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum OuterType extends Enum<OuterType> {
    private static final /* synthetic */ OuterType[] $VALUES = null;
    public static final OuterType TYPE_BROWSER = null;
    public static final OuterType TYPE_THIRD_APP = null;
    public static final OuterType TYPE_UNKNOWN = null;

    private static final /* synthetic */ OuterType[] $values() {
        return new OuterType[]{TYPE_THIRD_APP, TYPE_BROWSER, TYPE_UNKNOWN};
    }

    public static OuterType valueOf(String r100) {
        return (OuterType) r27.a.a(OuterType.class, r100);
    }

    public static OuterType[] values() {
        return (OuterType[]) $VALUES.clone();
    }

    static {
        TYPE_THIRD_APP = new OuterType("TYPE_THIRD_APP", 0, 1);
        TYPE_BROWSER = new OuterType("TYPE_BROWSER", 1, 2);
        TYPE_UNKNOWN = new OuterType("TYPE_UNKNOWN", 2, -1);
        $VALUES = $values();
    }

    private OuterType(String r100, int r101, int r102) {
        super(r100, r101);
    }
}
