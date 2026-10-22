package com.bytedance.android.ec.hybrid.card.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/hybrid/card/api/ECLynxCardErrorType;", "", "FAILED", "TIMEOUT", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ECLynxCardErrorType extends Enum<ECLynxCardErrorType> {
    public static final ECLynxCardErrorType FAILED = null;
    public static final ECLynxCardErrorType TIMEOUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ECLynxCardErrorType[] f46309a = null;

    static {
        ECLynxCardErrorType r100 = new ECLynxCardErrorType("FAILED", 0);
        FAILED = r100;
        ECLynxCardErrorType r101 = new ECLynxCardErrorType("TIMEOUT", 1);
        TIMEOUT = r101;
        f46309a = new ECLynxCardErrorType[]{r100, r101};
    }

    public static ECLynxCardErrorType valueOf(String r100) {
        return (ECLynxCardErrorType) r27.a.a(ECLynxCardErrorType.class, r100);
    }

    public static ECLynxCardErrorType[] values() {
        return (ECLynxCardErrorType[]) f46309a.clone();
    }

    public ECLynxCardErrorType(String r100, int r101) {
        super(r100, r101);
    }
}
