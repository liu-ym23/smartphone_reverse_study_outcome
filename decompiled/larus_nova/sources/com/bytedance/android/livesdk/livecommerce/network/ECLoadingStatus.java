package com.bytedance.android.livesdk.livecommerce.network;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/network/ECLoadingStatus;", "", "SUCCESS", "ERROR", "LOADING", "EMPTY", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ECLoadingStatus extends Enum<ECLoadingStatus> {
    public static final ECLoadingStatus EMPTY = null;
    public static final ECLoadingStatus ERROR = null;
    public static final ECLoadingStatus LOADING = null;
    public static final ECLoadingStatus SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ECLoadingStatus[] f149492a = null;

    static {
        ECLoadingStatus r100 = new ECLoadingStatus("SUCCESS", 0);
        SUCCESS = r100;
        ECLoadingStatus r101 = new ECLoadingStatus("ERROR", 1);
        ERROR = r101;
        ECLoadingStatus r102 = new ECLoadingStatus("LOADING", 2);
        LOADING = r102;
        ECLoadingStatus r103 = new ECLoadingStatus("EMPTY", 3);
        EMPTY = r103;
        f149492a = new ECLoadingStatus[]{r100, r101, r102, r103};
    }

    public static ECLoadingStatus valueOf(String r100) {
        return (ECLoadingStatus) a.a(ECLoadingStatus.class, r100);
    }

    public static ECLoadingStatus[] values() {
        return (ECLoadingStatus[]) f149492a.clone();
    }

    public ECLoadingStatus(String r100, int r101) {
        super(r100, r101);
    }
}
