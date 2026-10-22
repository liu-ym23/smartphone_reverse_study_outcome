package com.android.ttcjpaysdk.base.ui.data;

import com.android.ttcjpaysdk.base.CJPayConstant;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/CJPayRetainInfoV2NativeBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "input_pwd_retain_info", "Lcom/android/ttcjpaysdk/base/ui/data/RetainInfoGroups;", "unput_pwd_retain_info", "verify_retain_info", CJPayConstant.CJ_PAY_RETAIN_INFO_V2_INFO_KEY2, "Lcom/android/ttcjpaysdk/base/ui/data/MerchantRetainInfo;", CJPayConstant.CJ_PAY_RETAIN_INFO_V2_DEFAULT_NATIVE_KEY, "lynx_retain_info", "(Lcom/android/ttcjpaysdk/base/ui/data/RetainInfoGroups;Lcom/android/ttcjpaysdk/base/ui/data/RetainInfoGroups;Lcom/android/ttcjpaysdk/base/ui/data/RetainInfoGroups;Lcom/android/ttcjpaysdk/base/ui/data/MerchantRetainInfo;Lcom/android/ttcjpaysdk/base/ui/data/RetainInfoGroups;Lcom/android/ttcjpaysdk/base/ui/data/RetainInfoGroups;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayRetainInfoV2NativeBean implements CJPayObject {
    public RetainInfoGroups default_native_retain_info;
    public RetainInfoGroups input_pwd_retain_info;
    public RetainInfoGroups lynx_retain_info;
    public MerchantRetainInfo merchant_retain_info;
    public RetainInfoGroups unput_pwd_retain_info;
    public RetainInfoGroups verify_retain_info;

    public CJPayRetainInfoV2NativeBean() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ CJPayRetainInfoV2NativeBean copy$default(CJPayRetainInfoV2NativeBean r100, RetainInfoGroups r101, RetainInfoGroups r102, RetainInfoGroups r103, MerchantRetainInfo r104, RetainInfoGroups r105, RetainInfoGroups r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.input_pwd_retain_info;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.unput_pwd_retain_info;
    L8:
        RetainInfoGroups r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.verify_retain_info;
    L11:
        RetainInfoGroups r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.merchant_retain_info;
    L14:
        MerchantRetainInfo r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.default_native_retain_info;
    L17:
        RetainInfoGroups r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.lynx_retain_info;
    L20:
        RetainInfoGroups r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final RetainInfoGroups component1() {
        return this.input_pwd_retain_info;
    }

    public final RetainInfoGroups component2() {
        return this.unput_pwd_retain_info;
    }

    public final RetainInfoGroups component3() {
        return this.verify_retain_info;
    }

    public final MerchantRetainInfo component4() {
        return this.merchant_retain_info;
    }

    public final RetainInfoGroups component5() {
        return this.default_native_retain_info;
    }

    public final RetainInfoGroups component6() {
        return this.lynx_retain_info;
    }

    public final CJPayRetainInfoV2NativeBean copy(RetainInfoGroups r100, RetainInfoGroups r110, RetainInfoGroups r111, MerchantRetainInfo r112, RetainInfoGroups r113, RetainInfoGroups r114) {
        return new CJPayRetainInfoV2NativeBean(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJPayRetainInfoV2NativeBean) == true) goto L8;
        return false;
    L8:
        CJPayRetainInfoV2NativeBean r101 = (CJPayRetainInfoV2NativeBean) r100;
        if (Intrinsics.areEqual(this.input_pwd_retain_info, r101.input_pwd_retain_info) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.unput_pwd_retain_info, r101.unput_pwd_retain_info) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.verify_retain_info, r101.verify_retain_info) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.merchant_retain_info, r101.merchant_retain_info) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.default_native_retain_info, r101.default_native_retain_info) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.lynx_retain_info, r101.lynx_retain_info) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        RetainInfoGroups r100 = this.input_pwd_retain_info;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        RetainInfoGroups r104 = this.unput_pwd_retain_info;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        RetainInfoGroups r107 = this.verify_retain_info;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        MerchantRetainInfo r110 = this.merchant_retain_info;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        RetainInfoGroups r113 = this.default_native_retain_info;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        RetainInfoGroups r116 = this.lynx_retain_info;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CJPayRetainInfoV2NativeBean(input_pwd_retain_info=" + this.input_pwd_retain_info + ", unput_pwd_retain_info=" + this.unput_pwd_retain_info + ", verify_retain_info=" + this.verify_retain_info + ", merchant_retain_info=" + this.merchant_retain_info + ", default_native_retain_info=" + this.default_native_retain_info + ", lynx_retain_info=" + this.lynx_retain_info + ')';
    }

    public CJPayRetainInfoV2NativeBean(RetainInfoGroups r100, RetainInfoGroups r101, RetainInfoGroups r102, MerchantRetainInfo r103, RetainInfoGroups r104, RetainInfoGroups r105) {
        this.input_pwd_retain_info = r100;
        this.unput_pwd_retain_info = r101;
        this.verify_retain_info = r102;
        this.merchant_retain_info = r103;
        this.default_native_retain_info = r104;
        this.lynx_retain_info = r105;
    }

    public /* synthetic */ CJPayRetainInfoV2NativeBean(RetainInfoGroups r100, RetainInfoGroups r101, RetainInfoGroups r102, MerchantRetainInfo r103, RetainInfoGroups r110, RetainInfoGroups r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        RetainInfoGroups r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        RetainInfoGroups r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        RetainInfoGroups r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        MerchantRetainInfo r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        RetainInfoGroups r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        RetainInfoGroups r115 = null;
    L26:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
