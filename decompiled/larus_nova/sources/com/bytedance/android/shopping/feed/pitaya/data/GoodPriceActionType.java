package com.bytedance.android.shopping.feed.pitaya.data;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/feed/pitaya/data/GoodPriceActionType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "DELETE", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GoodPriceActionType extends Enum<GoodPriceActionType> {
    public static final GoodPriceActionType DELETE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GoodPriceActionType[] f175126a = null;
    private final String type;

    static {
        GoodPriceActionType r100 = new GoodPriceActionType();
        DELETE = r100;
        f175126a = new GoodPriceActionType[]{r100};
    }

    public static GoodPriceActionType valueOf(String r100) {
        return (GoodPriceActionType) a.a(GoodPriceActionType.class, r100);
    }

    public static GoodPriceActionType[] values() {
        return (GoodPriceActionType[]) f175126a.clone();
    }

    public GoodPriceActionType() {
        super("DELETE", 0);
        this.type = "delete";
    }

    public final String getType() {
        return this.type;
    }
}
