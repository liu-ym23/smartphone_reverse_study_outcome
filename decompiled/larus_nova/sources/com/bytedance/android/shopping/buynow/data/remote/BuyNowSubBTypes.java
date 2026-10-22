package com.bytedance.android.shopping.buynow.data.remote;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/buynow/data/remote/BuyNowSubBTypes;", "", "", "type", "I", "getType", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "UNKNOWN", "NATIVE", "MICRO", "H5", "TOUTIAO", "TOUTIAOLITE", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum BuyNowSubBTypes extends Enum<BuyNowSubBTypes> {
    public static final a Companion = null;
    public static final BuyNowSubBTypes H5 = null;
    public static final BuyNowSubBTypes MICRO = null;
    public static final BuyNowSubBTypes NATIVE = null;
    public static final BuyNowSubBTypes TOUTIAO = null;
    public static final BuyNowSubBTypes TOUTIAOLITE = null;
    public static final BuyNowSubBTypes UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BuyNowSubBTypes[] f170905a = null;
    private final int type;

    public static final class a {
        public a() {
        }
    }

    static {
        BuyNowSubBTypes r100 = new BuyNowSubBTypes("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        BuyNowSubBTypes r101 = new BuyNowSubBTypes("NATIVE", 1, 1);
        NATIVE = r101;
        BuyNowSubBTypes r102 = new BuyNowSubBTypes("MICRO", 2, 2);
        MICRO = r102;
        BuyNowSubBTypes r103 = new BuyNowSubBTypes("H5", 3, 3);
        H5 = r103;
        BuyNowSubBTypes r104 = new BuyNowSubBTypes("TOUTIAO", 4, 13);
        TOUTIAO = r104;
        BuyNowSubBTypes r105 = new BuyNowSubBTypes("TOUTIAOLITE", 5, 35);
        TOUTIAOLITE = r105;
        f170905a = new BuyNowSubBTypes[]{r100, r101, r102, r103, r104, r105};
        Companion = new a();
    }

    public static BuyNowSubBTypes valueOf(String r100) {
        return (BuyNowSubBTypes) r27.a.a(BuyNowSubBTypes.class, r100);
    }

    public static BuyNowSubBTypes[] values() {
        return (BuyNowSubBTypes[]) f170905a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public BuyNowSubBTypes(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
