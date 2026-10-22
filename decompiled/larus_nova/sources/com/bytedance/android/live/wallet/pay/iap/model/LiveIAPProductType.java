package com.bytedance.android.live.wallet.pay.iap.model;

import com.bytedance.caijing.sdk.biz.googleiap.api.constants.CJProductType;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/wallet/pay/iap/model/LiveIAPProductType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "INAPP", "SUBS", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LiveIAPProductType extends Enum<LiveIAPProductType> {
    public static final LiveIAPProductType INAPP = null;
    public static final LiveIAPProductType SUBS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveIAPProductType[] f102696a = null;
    private final String value;

    static {
        LiveIAPProductType r100 = new LiveIAPProductType("INAPP", 0, CJProductType.INAPP);
        INAPP = r100;
        LiveIAPProductType r101 = new LiveIAPProductType("SUBS", 1, CJProductType.SUBS);
        SUBS = r101;
        f102696a = new LiveIAPProductType[]{r100, r101};
    }

    public static LiveIAPProductType valueOf(String r100) {
        return (LiveIAPProductType) a.a(LiveIAPProductType.class, r100);
    }

    public static LiveIAPProductType[] values() {
        return (LiveIAPProductType[]) f102696a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public LiveIAPProductType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
