package com.bytedance.android.shopping.abscontainer.common_biz.constant;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/abscontainer/common_biz/constant/PayStatus;", "", "", "rawValue", "I", "getRawValue", "()I", "SUCCESS", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PayStatus extends Enum<PayStatus> {
    public static final PayStatus SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PayStatus[] f164223a = null;
    private final int rawValue;

    static {
        PayStatus r100 = new PayStatus();
        SUCCESS = r100;
        f164223a = new PayStatus[]{r100};
    }

    public static PayStatus valueOf(String r100) {
        return (PayStatus) a.a(PayStatus.class, r100);
    }

    public static PayStatus[] values() {
        return (PayStatus[]) f164223a.clone();
    }

    public PayStatus() {
        super("SUCCESS", 0);
        this.rawValue = 1;
    }

    public final int getRawValue() {
        return this.rawValue;
    }
}
