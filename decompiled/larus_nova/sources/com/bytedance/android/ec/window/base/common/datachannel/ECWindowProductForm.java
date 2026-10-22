package com.bytedance.android.ec.window.base.common.datachannel;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/window/base/common/datachannel/ECWindowProductForm;", "", "", "des", "Ljava/lang/String;", "getDes", "()Ljava/lang/String;", "SINGLE_PRODUCT", "DOUBLE_PRODUCT", "FLOW", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ECWindowProductForm extends Enum<ECWindowProductForm> {
    public static final ECWindowProductForm DOUBLE_PRODUCT = null;
    public static final ECWindowProductForm FLOW = null;
    public static final ECWindowProductForm SINGLE_PRODUCT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ECWindowProductForm[] f49149a = null;
    private final String des;

    static {
        ECWindowProductForm r100 = new ECWindowProductForm("SINGLE_PRODUCT", 0, "single_product");
        SINGLE_PRODUCT = r100;
        ECWindowProductForm r101 = new ECWindowProductForm("DOUBLE_PRODUCT", 1, "double_product");
        DOUBLE_PRODUCT = r101;
        ECWindowProductForm r102 = new ECWindowProductForm("FLOW", 2, BytedCertConstant.CertKey.FLOW);
        FLOW = r102;
        f49149a = new ECWindowProductForm[]{r100, r101, r102};
    }

    public static ECWindowProductForm valueOf(String r100) {
        return (ECWindowProductForm) a.a(ECWindowProductForm.class, r100);
    }

    public static ECWindowProductForm[] values() {
        return (ECWindowProductForm[]) f49149a.clone();
    }

    public final String getDes() {
        return this.des;
    }

    public ECWindowProductForm(String r100, int r101, String r102) {
        super(r100, r101);
        this.des = r102;
    }
}
