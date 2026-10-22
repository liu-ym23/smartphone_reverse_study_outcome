package com.bytedance.android.ec.core.data;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0011\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/ec/core/data/ParamsForceRule;", "Ljava/io/Serializable;", "removeIfEmpty", "", "", "forceString", "(Ljava/util/List;Ljava/util/List;)V", "getForceString", "()Ljava/util/List;", "getRemoveIfEmpty", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ParamsForceRule implements Serializable {

    @SerializedName("force_string")
    private final List<String> forceString;

    @SerializedName("remove_if_empty")
    private final List<String> removeIfEmpty;

    /* JADX WARN: Multi-variable type inference failed */
    public ParamsForceRule() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ParamsForceRule copy$default(ParamsForceRule r100, List r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.removeIfEmpty;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.forceString;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<String> component1() {
        return this.removeIfEmpty;
    }

    public final List<String> component2() {
        return this.forceString;
    }

    public final ParamsForceRule copy(List<String> r100, List<String> r101) {
        return new ParamsForceRule(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ParamsForceRule) == false) goto L10;
        ParamsForceRule r101 = (ParamsForceRule) r100;
        if (Intrinsics.areEqual(this.removeIfEmpty, r101.removeIfEmpty) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.forceString, r101.forceString) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        List<String> r100 = this.removeIfEmpty;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.forceString;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ParamsForceRule(removeIfEmpty=" + this.removeIfEmpty + ", forceString=" + this.forceString + ")";
    }

    public final List<String> getForceString() {
        return this.forceString;
    }

    public final List<String> getRemoveIfEmpty() {
        return this.removeIfEmpty;
    }

    public ParamsForceRule(List<String> r100, List<String> r101) {
        this.removeIfEmpty = r100;
        this.forceString = r101;
    }

    public /* synthetic */ ParamsForceRule(List r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
