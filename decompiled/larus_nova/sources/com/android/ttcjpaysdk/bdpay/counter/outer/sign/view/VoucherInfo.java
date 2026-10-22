package com.android.ttcjpaysdk.bdpay.counter.outer.sign.view;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002Bm\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0017\u001a\u00020\rHÆ\u0003Jq\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\rHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/view/VoucherInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "voucherWorth", "", "voucherMeasure", "voucherLabel", "voucherDesc", "voucherTopLabel", "leftMsgDesc", "voucherLeftDesc", "voucherBgType", "countDown", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoucherInfo implements CJPayObject, Serializable {
    public int countDown;
    public String leftMsgDesc;
    public String voucherBgType;
    public String voucherDesc;
    public String voucherLabel;
    public String voucherLeftDesc;
    public String voucherMeasure;
    public String voucherTopLabel;
    public String voucherWorth;

    public VoucherInfo() {
        this(null, null, null, null, null, null, null, null, 0, 511, null);
    }

    public static /* synthetic */ VoucherInfo copy$default(VoucherInfo r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, String r118, int r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = r110.voucherWorth;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.voucherMeasure;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r102 = r110.voucherLabel;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r103 = r110.voucherDesc;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r104 = r110.voucherTopLabel;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r105 = r110.leftMsgDesc;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r106 = r110.voucherLeftDesc;
    L31:
        if ((r210 & 128) == 0) goto L33;
        String r107 = r110.voucherBgType;
    L35:
        if ((r210 & 256) == 0) goto L37;
        int r108 = r110.countDown;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.voucherWorth;
    }

    public final String component2() {
        return this.voucherMeasure;
    }

    public final String component3() {
        return this.voucherLabel;
    }

    public final String component4() {
        return this.voucherDesc;
    }

    public final String component5() {
        return this.voucherTopLabel;
    }

    public final String component6() {
        return this.leftMsgDesc;
    }

    public final String component7() {
        return this.voucherLeftDesc;
    }

    public final String component8() {
        return this.voucherBgType;
    }

    public final int component9() {
        return this.countDown;
    }

    public final VoucherInfo copy(String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, int r210) {
        Intrinsics.checkNotNullParameter(r117, "voucherBgType");
        return new VoucherInfo(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof VoucherInfo) == true) goto L8;
        return false;
    L8:
        VoucherInfo r101 = (VoucherInfo) r100;
        if (Intrinsics.areEqual(this.voucherWorth, r101.voucherWorth) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.voucherMeasure, r101.voucherMeasure) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.voucherLabel, r101.voucherLabel) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.voucherDesc, r101.voucherDesc) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.voucherTopLabel, r101.voucherTopLabel) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.leftMsgDesc, r101.leftMsgDesc) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.voucherLeftDesc, r101.voucherLeftDesc) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.voucherBgType, r101.voucherBgType) == true) goto L33;
        return false;
    L33:
        if (this.countDown == r101.countDown) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        String r100 = this.voucherWorth;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.voucherMeasure;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.voucherLabel;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.voucherDesc;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.voucherTopLabel;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.leftMsgDesc;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.voucherLeftDesc;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return ((((r118 + r101) * 31) + this.voucherBgType.hashCode()) * 31) + this.countDown;
    L25:
        r117 = r116.hashCode();
        goto L26
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
        return "VoucherInfo(voucherWorth=" + this.voucherWorth + ", voucherMeasure=" + this.voucherMeasure + ", voucherLabel=" + this.voucherLabel + ", voucherDesc=" + this.voucherDesc + ", voucherTopLabel=" + this.voucherTopLabel + ", leftMsgDesc=" + this.leftMsgDesc + ", voucherLeftDesc=" + this.voucherLeftDesc + ", voucherBgType=" + this.voucherBgType + ", countDown=" + this.countDown + ')';
    }

    public VoucherInfo(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, int r110) {
        Intrinsics.checkNotNullParameter(r107, "voucherBgType");
        this.voucherWorth = r100;
        this.voucherMeasure = r101;
        this.voucherLabel = r102;
        this.voucherDesc = r103;
        this.voucherTopLabel = r104;
        this.leftMsgDesc = r105;
        this.voucherLeftDesc = r106;
        this.voucherBgType = r107;
        this.countDown = r110;
    }

    public /* synthetic */ VoucherInfo(String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, int r118, int r119, DefaultConstructorMarker r210) {
        String r100 = null;
        if ((r119 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r119 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r119 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r119 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r119 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r119 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r119 & 64) != 0) goto L31;
        r100 = r116;
    L31:
        if ((r119 & 128) == 0) goto L33;
        String r107 = "";
    L35:
        if ((r119 & 256) == 0) goto L37;
        int r108 = 0;
    L38:
        this(r101, r102, r103, r104, r105, r106, r100, r107, r108);
        return;
    L37:
        r108 = r118;
        goto L38
    L33:
        r107 = r117;
        goto L35
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
