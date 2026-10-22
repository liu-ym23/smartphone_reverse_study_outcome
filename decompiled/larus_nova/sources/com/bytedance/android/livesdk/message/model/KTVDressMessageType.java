package com.bytedance.android.livesdk.message.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/KTVDressMessageType;", "", "", "value", "I", "getValue", "()I", "TYPE_UNKNOWN", "TYPE_ADD", "TYPE_CHANGE", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum KTVDressMessageType extends Enum<KTVDressMessageType> {
    public static final KTVDressMessageType TYPE_ADD = null;
    public static final KTVDressMessageType TYPE_CHANGE = null;
    public static final KTVDressMessageType TYPE_UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KTVDressMessageType[] f153560a = null;
    private final int value;

    static {
        KTVDressMessageType r100 = new KTVDressMessageType("TYPE_UNKNOWN", 0, 0);
        TYPE_UNKNOWN = r100;
        KTVDressMessageType r101 = new KTVDressMessageType("TYPE_ADD", 1, 1);
        TYPE_ADD = r101;
        KTVDressMessageType r102 = new KTVDressMessageType("TYPE_CHANGE", 2, 2);
        TYPE_CHANGE = r102;
        f153560a = new KTVDressMessageType[]{r100, r101, r102};
    }

    public static KTVDressMessageType valueOf(String r100) {
        return (KTVDressMessageType) r27.a.a(KTVDressMessageType.class, r100);
    }

    public static KTVDressMessageType[] values() {
        return (KTVDressMessageType[]) f153560a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public KTVDressMessageType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
