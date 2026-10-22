package com.bytedance.android.shopping.ligo.container.event;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J5\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/ligo/container/event/AddCartExtraData;", "Ljava/io/Serializable;", PickerReporterConstants.KEY.TARGET, "", "addCartStartTime", "", "addCartSuccessTime", "productInfo", "Lcom/bytedance/android/shopping/ligo/container/event/AddCartProductInfoData;", "(Ljava/lang/String;JJLcom/bytedance/android/shopping/ligo/container/event/AddCartProductInfoData;)V", "getAddCartStartTime", "()J", "getAddCartSuccessTime", "getProductInfo", "()Lcom/bytedance/android/shopping/ligo/container/event/AddCartProductInfoData;", "getTarget", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AddCartExtraData implements Serializable {

    @SerializedName("operation_start_time")
    private final long addCartStartTime;

    @SerializedName("cart_add_end_time")
    private final long addCartSuccessTime;

    @SerializedName("product_info")
    private final AddCartProductInfoData productInfo;

    @SerializedName(PickerReporterConstants.KEY.TARGET)
    private final String target;

    public static /* synthetic */ AddCartExtraData copy$default(AddCartExtraData r100, String r101, long r102, long r103, AddCartProductInfoData r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.target;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.addCartStartTime;
    L8:
        long r104 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.addCartSuccessTime;
    L11:
        long r105 = r103;
        if ((r111 & 8) == 0) goto L14;
        r110 = r100.productInfo;
    L14:
        String r106 = r101;
        return r100.copy(r106, r104, r105, r110);
    }

    public final String component1() {
        return this.target;
    }

    public final long component2() {
        return this.addCartStartTime;
    }

    public final long component3() {
        return this.addCartSuccessTime;
    }

    public final AddCartProductInfoData component4() {
        return this.productInfo;
    }

    public final AddCartExtraData copy(String r100, long r110, long r111, AddCartProductInfoData r112) {
        return new AddCartExtraData(r100, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AddCartExtraData) == false) goto L14;
        AddCartExtraData r101 = (AddCartExtraData) r100;
        if (Intrinsics.areEqual(this.target, r101.target) == true) goto L8;
        return false;
    L8:
        if (this.addCartStartTime == r101.addCartStartTime) goto L10;
        return false;
    L10:
        if (this.addCartSuccessTime == r101.addCartSuccessTime) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.productInfo, r101.productInfo) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r100 = this.target;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.addCartStartTime;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.addCartSuccessTime;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        AddCartProductInfoData r107 = this.productInfo;
        if (r107 == null) goto L10;
        r101 = r107.hashCode();
    L10:
        return r106 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "AddCartExtraData(target=" + this.target + ", addCartStartTime=" + this.addCartStartTime + ", addCartSuccessTime=" + this.addCartSuccessTime + ", productInfo=" + this.productInfo + ")";
    }

    public final long getAddCartStartTime() {
        return this.addCartStartTime;
    }

    public final long getAddCartSuccessTime() {
        return this.addCartSuccessTime;
    }

    public final AddCartProductInfoData getProductInfo() {
        return this.productInfo;
    }

    public final String getTarget() {
        return this.target;
    }

    public AddCartExtraData(String r100, long r101, long r102, AddCartProductInfoData r103) {
        this.target = r100;
        this.addCartStartTime = r101;
        this.addCartSuccessTime = r102;
        this.productInfo = r103;
    }
}
