package com.android.ttcjpaysdk.kmp.common.view.voucher_tag;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import nuc.b2;
import nuc.q2;
import nuc.v2;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002&'B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007B9\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\tHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0001¢\u0006\u0002\b%R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010¨\u0006("}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/view/voucher_tag/VoucherMsgInfo;", "", "leftMsg", "", "rightMsg", "tagShowType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLeftMsg$annotations", "()V", "getLeftMsg", "()Ljava/lang/String;", "getRightMsg$annotations", "getRightMsg", "getTagShowType$annotations", "getTagShowType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cj_common_release", "$serializer", "Companion", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class VoucherMsgInfo {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private final String leftMsg;
    private final String rightMsg;
    private final String tagShowType;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/view/voucher_tag/VoucherMsgInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/android/ttcjpaysdk/kmp/common/view/voucher_tag/VoucherMsgInfo;", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final juc.d<VoucherMsgInfo> serializer() {
            return VoucherMsgInfo$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public VoucherMsgInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ VoucherMsgInfo copy$default(VoucherMsgInfo r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.leftMsg;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.rightMsg;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.tagShowType;
    L12:
        return r100.copy(r101, r102, r103);
    }

    @SerialName("left_msg")
    public static /* synthetic */ void getLeftMsg$annotations() {
    }

    @SerialName("right_msg")
    public static /* synthetic */ void getRightMsg$annotations() {
    }

    @SerialName("tag_show_type")
    public static /* synthetic */ void getTagShowType$annotations() {
    }

    public final String component1() {
        return this.leftMsg;
    }

    public final String component2() {
        return this.rightMsg;
    }

    public final String component3() {
        return this.tagShowType;
    }

    public final VoucherMsgInfo copy(String r100, String r101, String r102) {
        return new VoucherMsgInfo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof VoucherMsgInfo) == true) goto L8;
        return false;
    L8:
        VoucherMsgInfo r101 = (VoucherMsgInfo) r100;
        if (Intrinsics.areEqual(this.leftMsg, r101.leftMsg) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rightMsg, r101.rightMsg) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.tagShowType, r101.tagShowType) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.leftMsg;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.rightMsg;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.tagShowType;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "VoucherMsgInfo(leftMsg=" + this.leftMsg + ", rightMsg=" + this.rightMsg + ", tagShowType=" + this.tagShowType + ')';
    }

    public final String getLeftMsg() {
        return this.leftMsg;
    }

    public final String getRightMsg() {
        return this.rightMsg;
    }

    public final String getTagShowType() {
        return this.tagShowType;
    }

    public VoucherMsgInfo(String r100, String r101, String r102) {
        this.leftMsg = r100;
        this.rightMsg = r101;
        this.tagShowType = r102;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$cj_common_release(VoucherMsgInfo r100, muc.d r101, luc.f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.leftMsg);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.rightMsg);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        r103 = true;
    L26:
        if (r103 == false) goto L29;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.tagShowType);
        return;
    L29:
        return;
    L24:
        if (r100.tagShowType == null) goto L26;
    L15:
        if (r100.rightMsg != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.leftMsg != null) goto L4;
        r104 = false;
        goto L9
    }

    public /* synthetic */ VoucherMsgInfo(int r100, String r101, String r102, String r103, q2 r104) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, VoucherMsgInfo$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.leftMsg = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.rightMsg = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.tagShowType = null;
        return;
    L15:
        this.tagShowType = r103;
        return;
    L11:
        this.rightMsg = r102;
        goto L13
    L7:
        this.leftMsg = r101;
        goto L9
    }

    public /* synthetic */ VoucherMsgInfo(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
