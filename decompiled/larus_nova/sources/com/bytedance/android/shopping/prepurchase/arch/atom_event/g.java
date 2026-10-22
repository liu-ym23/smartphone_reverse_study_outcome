package com.bytedance.android.shopping.prepurchase.arch.atom_event;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0005R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/arch/atom_event/g;", "", "", "promotionSource", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "", "ecomGroupType", "Ljava/lang/String;", "getEcomGroupType", "()Ljava/lang/String;", "carrierSource", "getCarrierSource", "ecomEntranceForm", "getEcomEntranceForm", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f180689a = 0;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE)
    private final String carrierSource;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM)
    private final String ecomEntranceForm;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE)
    private final String ecomGroupType;

    @SerializedName(PdpOpenThirdParam.KEY_PROMOTION_SOURCE)
    private final long promotionSource;

    public static final class a {
        public static g a(Map r100) {
            Object r101 = null;
            if (r100 != null) goto L5;
            return null;
        L5:
            Object r102 = r100.get(PdpOpenThirdParam.KEY_PROMOTION_SOURCE);
            if ((r102 instanceof Long) == true) goto L8;
            r102 = null;
        L8:
            Long r103 = (Long) r102;
            if (r103 == null) goto L11;
            long r104 = r103.longValue();
        L12:
            long r105 = r104;
            Object r106 = r100.get(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE);
            if ((r106 instanceof String) == true) goto L15;
            r106 = null;
        L15:
            String r107 = (String) r106;
            Object r108 = r100.get(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE);
            if ((r108 instanceof String) == true) goto L18;
            r108 = null;
        L18:
            String r109 = (String) r108;
            Object r110 = r100.get(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM);
            if ((r110 instanceof String) == false) goto L23;
            r101 = r110;
        L23:
            return new g(r105, r107, r109, (String) r101);
        L11:
            r104 = 0;
            goto L12
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L14;
        g r101 = (g) r100;
        if (this.promotionSource == r101.promotionSource) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.ecomGroupType, r101.ecomGroupType) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.carrierSource, r101.carrierSource) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.ecomEntranceForm, r101.ecomEntranceForm) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        long r100 = this.promotionSource;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.ecomGroupType;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.carrierSource;
        if (r106 == null) goto L9;
        int r107 = r106.hashCode();
    L10:
        int r108 = (r105 + r107) * 31;
        String r109 = this.ecomEntranceForm;
        if (r109 == null) goto L14;
        r103 = r109.hashCode();
    L14:
        return r108 + r103;
    L9:
        r107 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "PDPLegalVerificationActionAtomEventParams(promotionSource=" + this.promotionSource + ", ecomGroupType=" + this.ecomGroupType + ", carrierSource=" + this.carrierSource + ", ecomEntranceForm=" + this.ecomEntranceForm + ")";
    }

    public g() {
        this(0, "", "", "");
    }

    public final long a() {
        return this.promotionSource;
    }

    public g(long r100, String r101, String r102, String r103) {
        this.promotionSource = r100;
        this.ecomGroupType = r101;
        this.carrierSource = r102;
        this.ecomEntranceForm = r103;
    }
}
