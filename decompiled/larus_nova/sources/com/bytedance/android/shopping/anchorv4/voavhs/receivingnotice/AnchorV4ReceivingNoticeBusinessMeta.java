package com.bytedance.android.shopping.anchorv4.voavhs.receivingnotice;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0019\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006HÆ\u0003J5\u0010\u000e\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001R&\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/receivingnotice/AnchorV4ReceivingNoticeBusinessMeta;", "Ljava/io/Serializable;", "jumpUrls", "", "", "logisticTypes", "", "(Ljava/util/Map;Ljava/util/List;)V", "getJumpUrls", "()Ljava/util/Map;", "getLogisticTypes", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4ReceivingNoticeBusinessMeta implements Serializable {

    @SerializedName("jump_urls")
    private final Map<String, String> jumpUrls;

    @SerializedName("logistic_types")
    private final List<String> logisticTypes;

    /* JADX WARN: Multi-variable type inference failed */
    public AnchorV4ReceivingNoticeBusinessMeta() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnchorV4ReceivingNoticeBusinessMeta copy$default(AnchorV4ReceivingNoticeBusinessMeta r100, Map r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.jumpUrls;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.logisticTypes;
    L9:
        return r100.copy(r101, r102);
    }

    public final Map<String, String> component1() {
        return this.jumpUrls;
    }

    public final List<String> component2() {
        return this.logisticTypes;
    }

    public final AnchorV4ReceivingNoticeBusinessMeta copy(Map<String, String> r100, List<String> r101) {
        return new AnchorV4ReceivingNoticeBusinessMeta(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AnchorV4ReceivingNoticeBusinessMeta) == false) goto L10;
        AnchorV4ReceivingNoticeBusinessMeta r101 = (AnchorV4ReceivingNoticeBusinessMeta) r100;
        if (Intrinsics.areEqual(this.jumpUrls, r101.jumpUrls) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.logisticTypes, r101.logisticTypes) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        Map<String, String> r100 = this.jumpUrls;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.logisticTypes;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "AnchorV4ReceivingNoticeBusinessMeta(jumpUrls=" + this.jumpUrls + ", logisticTypes=" + this.logisticTypes + ")";
    }

    public final Map<String, String> getJumpUrls() {
        return this.jumpUrls;
    }

    public final List<String> getLogisticTypes() {
        return this.logisticTypes;
    }

    public AnchorV4ReceivingNoticeBusinessMeta(Map<String, String> r100, List<String> r101) {
        this.jumpUrls = r100;
        this.logisticTypes = r101;
    }

    public /* synthetic */ AnchorV4ReceivingNoticeBusinessMeta(Map r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
