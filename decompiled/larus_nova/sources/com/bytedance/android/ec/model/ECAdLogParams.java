package com.bytedance.android.ec.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0002\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/ec/model/ECAdLogParams;", "Ljava/io/Serializable;", "isFromAd", "", "enableCommonAdTrack", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getEnableCommonAdTrack", "()Ljava/lang/String;", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/android/ec/model/ECAdLogParams;", "equals", "", "other", "", "hashCode", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECAdLogParams implements Serializable {
    private final String enableCommonAdTrack;
    private final Integer isFromAd;

    /* JADX WARN: Multi-variable type inference failed */
    public ECAdLogParams() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ECAdLogParams copy$default(ECAdLogParams r100, Integer r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.isFromAd;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.enableCommonAdTrack;
    L9:
        return r100.copy(r101, r102);
    }

    public final Integer component1() {
        return this.isFromAd;
    }

    public final String component2() {
        return this.enableCommonAdTrack;
    }

    public final ECAdLogParams copy(Integer r100, String r101) {
        return new ECAdLogParams(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECAdLogParams) == false) goto L10;
        ECAdLogParams r101 = (ECAdLogParams) r100;
        if (Intrinsics.areEqual(this.isFromAd, r101.isFromAd) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.enableCommonAdTrack, r101.enableCommonAdTrack) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        Integer r100 = this.isFromAd;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.enableCommonAdTrack;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ECAdLogParams(isFromAd=" + this.isFromAd + ", enableCommonAdTrack=" + this.enableCommonAdTrack + ")";
    }

    public final String getEnableCommonAdTrack() {
        return this.enableCommonAdTrack;
    }

    public final Integer isFromAd() {
        return this.isFromAd;
    }

    public ECAdLogParams(Integer r100, String r101) {
        this.isFromAd = r100;
        this.enableCommonAdTrack = r101;
    }

    public /* synthetic */ ECAdLogParams(Integer r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
