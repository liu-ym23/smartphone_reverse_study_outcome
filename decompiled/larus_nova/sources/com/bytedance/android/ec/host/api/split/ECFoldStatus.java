package com.bytedance.android.ec.host.api.split;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/ec/host/api/split/ECFoldStatus;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "UNKNOWN", "SMALL", "FOLD", "FLAT", "HUAWEI_FLAT", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ECFoldStatus extends Enum<ECFoldStatus> {
    public static final a Companion = null;
    public static final ECFoldStatus FLAT = null;
    public static final ECFoldStatus FOLD = null;
    public static final ECFoldStatus HUAWEI_FLAT = null;
    public static final ECFoldStatus SMALL = null;
    public static final ECFoldStatus UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ECFoldStatus[] f46187a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.ec.host.api.split.ECFoldStatus$a] */
    static {
        ECFoldStatus r100 = new ECFoldStatus("UNKNOWN", 0, -1);
        UNKNOWN = r100;
        ECFoldStatus r101 = new ECFoldStatus("SMALL", 1, 0);
        SMALL = r101;
        ECFoldStatus r102 = new ECFoldStatus("FOLD", 2, 1);
        FOLD = r102;
        ECFoldStatus r103 = new ECFoldStatus("FLAT", 3, 3);
        FLAT = r103;
        ECFoldStatus r104 = new ECFoldStatus("HUAWEI_FLAT", 4, 4);
        HUAWEI_FLAT = r104;
        f46187a = new ECFoldStatus[]{r100, r101, r102, r103, r104};
        Companion = new a();
    }

    public static ECFoldStatus valueOf(String r100) {
        return (ECFoldStatus) r27.a.a(ECFoldStatus.class, r100);
    }

    public static ECFoldStatus[] values() {
        return (ECFoldStatus[]) f46187a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public ECFoldStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
