package com.bytedance.android.shopping.anchorv4.launcher;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J&\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\fJ\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0002\u0010\u0006R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\b\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/launcher/SplitParam;", "Ljava/io/Serializable;", "isInSplit", "", "splitForPadMode", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSplitForPadMode", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/bytedance/android/shopping/anchorv4/launcher/SplitParam;", "equals", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SplitParam implements Serializable {

    @SerializedName("is_in_split")
    private final Boolean isInSplit;

    @SerializedName("split_for_pad_mode")
    private final Boolean splitForPadMode;

    /* JADX WARN: Multi-variable type inference failed */
    public SplitParam() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SplitParam copy$default(SplitParam r100, Boolean r101, Boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.isInSplit;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.splitForPadMode;
    L9:
        return r100.copy(r101, r102);
    }

    public final Boolean component1() {
        return this.isInSplit;
    }

    public final Boolean component2() {
        return this.splitForPadMode;
    }

    public final SplitParam copy(Boolean r100, Boolean r101) {
        return new SplitParam(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SplitParam) == false) goto L10;
        SplitParam r101 = (SplitParam) r100;
        if (Intrinsics.areEqual(this.isInSplit, r101.isInSplit) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.splitForPadMode, r101.splitForPadMode) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        Boolean r100 = this.isInSplit;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.splitForPadMode;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "SplitParam(isInSplit=" + this.isInSplit + ", splitForPadMode=" + this.splitForPadMode + ")";
    }

    public final Boolean getSplitForPadMode() {
        return this.splitForPadMode;
    }

    public final Boolean isInSplit() {
        return this.isInSplit;
    }

    public SplitParam(Boolean r100, Boolean r101) {
        this.isInSplit = r100;
        this.splitForPadMode = r101;
    }

    public /* synthetic */ SplitParam(Boolean r100, Boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = Boolean.FALSE;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = Boolean.FALSE;
    L8:
        this(r100, r101);
    }
}
