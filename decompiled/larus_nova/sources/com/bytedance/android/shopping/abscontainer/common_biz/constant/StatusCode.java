package com.bytedance.android.shopping.abscontainer.common_biz.constant;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/abscontainer/common_biz/constant/StatusCode;", "", "", "value", "I", "getValue", "()I", "OK", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum StatusCode extends Enum<StatusCode> {
    public static final StatusCode OK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StatusCode[] f164226a = null;
    private final int value;

    static {
        StatusCode r100 = new StatusCode();
        OK = r100;
        f164226a = new StatusCode[]{r100};
    }

    public static StatusCode valueOf(String r100) {
        return (StatusCode) a.a(StatusCode.class, r100);
    }

    public static StatusCode[] values() {
        return (StatusCode[]) f164226a.clone();
    }

    public StatusCode() {
        super("OK", 0);
        this.value = 0;
    }

    public final int getValue() {
        return this.value;
    }
}
