package com.bytedance.android.livesdk.vscore_api.paidlive.ability.common;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_api/paidlive/ability/common/PaidPreloadDataType;", "", "", "dataName", "Ljava/lang/String;", "getDataName", "()Ljava/lang/String;", "BUY_PANEL", "vs-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PaidPreloadDataType extends Enum<PaidPreloadDataType> {
    public static final PaidPreloadDataType BUY_PANEL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PaidPreloadDataType[] f159413a = null;
    private final String dataName;

    static {
        PaidPreloadDataType r100 = new PaidPreloadDataType();
        BUY_PANEL = r100;
        f159413a = new PaidPreloadDataType[]{r100};
    }

    public static PaidPreloadDataType valueOf(String r100) {
        return (PaidPreloadDataType) a.a(PaidPreloadDataType.class, r100);
    }

    public static PaidPreloadDataType[] values() {
        return (PaidPreloadDataType[]) f159413a.clone();
    }

    public PaidPreloadDataType() {
        super("BUY_PANEL", 0);
        this.dataName = "buy_panel";
    }

    public final String getDataName() {
        return this.dataName;
    }
}
