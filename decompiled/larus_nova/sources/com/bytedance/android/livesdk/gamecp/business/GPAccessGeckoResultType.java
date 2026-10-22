package com.bytedance.android.livesdk.gamecp.business;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/gamecp/business/GPAccessGeckoResultType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "SUCCESS", "FAIL", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GPAccessGeckoResultType extends Enum<GPAccessGeckoResultType> {
    public static final GPAccessGeckoResultType FAIL = null;
    public static final GPAccessGeckoResultType SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GPAccessGeckoResultType[] f125419a = null;
    private final String value;

    static {
        GPAccessGeckoResultType r100 = new GPAccessGeckoResultType("SUCCESS", 0, "success");
        SUCCESS = r100;
        GPAccessGeckoResultType r101 = new GPAccessGeckoResultType("FAIL", 1, "fail");
        FAIL = r101;
        f125419a = new GPAccessGeckoResultType[]{r100, r101};
    }

    public static GPAccessGeckoResultType valueOf(String r100) {
        return (GPAccessGeckoResultType) a.a(GPAccessGeckoResultType.class, r100);
    }

    public static GPAccessGeckoResultType[] values() {
        return (GPAccessGeckoResultType[]) f125419a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public GPAccessGeckoResultType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
