package com.bytedance.android.shopping.anchorv4.voavhs.processflow;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/processflow/AnchorV4ProcessFlowMeta;", "Ljava/io/Serializable;", "businessMeta", "Lcom/bytedance/android/shopping/anchorv4/voavhs/processflow/AnchorV4ProcessFlowBusinessMeta;", "(Lcom/bytedance/android/shopping/anchorv4/voavhs/processflow/AnchorV4ProcessFlowBusinessMeta;)V", "getBusinessMeta", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/processflow/AnchorV4ProcessFlowBusinessMeta;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4ProcessFlowMeta implements Serializable {

    @SerializedName("business_meta")
    private final AnchorV4ProcessFlowBusinessMeta businessMeta;

    /* JADX WARN: Multi-variable type inference failed */
    public AnchorV4ProcessFlowMeta() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ AnchorV4ProcessFlowMeta copy$default(AnchorV4ProcessFlowMeta r100, AnchorV4ProcessFlowBusinessMeta r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.businessMeta;
    L6:
        return r100.copy(r101);
    }

    public final AnchorV4ProcessFlowBusinessMeta component1() {
        return this.businessMeta;
    }

    public final AnchorV4ProcessFlowMeta copy(AnchorV4ProcessFlowBusinessMeta r100) {
        return new AnchorV4ProcessFlowMeta(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AnchorV4ProcessFlowMeta) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.businessMeta, ((AnchorV4ProcessFlowMeta) r100).businessMeta) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        AnchorV4ProcessFlowBusinessMeta r100 = this.businessMeta;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public String toString() {
        return "AnchorV4ProcessFlowMeta(businessMeta=" + this.businessMeta + ")";
    }

    public final AnchorV4ProcessFlowBusinessMeta getBusinessMeta() {
        return this.businessMeta;
    }

    public AnchorV4ProcessFlowMeta(AnchorV4ProcessFlowBusinessMeta r100) {
        this.businessMeta = r100;
    }

    public /* synthetic */ AnchorV4ProcessFlowMeta(AnchorV4ProcessFlowBusinessMeta r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
