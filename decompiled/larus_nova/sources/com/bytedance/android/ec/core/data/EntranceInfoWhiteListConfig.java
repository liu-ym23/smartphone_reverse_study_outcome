package com.bytedance.android.ec.core.data;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u001d\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\nJ8\u0010\u0012\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR2\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/ec/core/data/EntranceInfoWhiteListConfig;", "Ljava/io/Serializable;", "whiteList", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "enable", "", "(Ljava/util/HashSet;Ljava/lang/Integer;)V", "getEnable", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getWhiteList", "()Ljava/util/HashSet;", "setWhiteList", "(Ljava/util/HashSet;)V", "component1", "component2", "copy", "(Ljava/util/HashSet;Ljava/lang/Integer;)Lcom/bytedance/android/ec/core/data/EntranceInfoWhiteListConfig;", "equals", "", "other", "", "hashCode", "toString", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EntranceInfoWhiteListConfig implements Serializable {

    @SerializedName("enable")
    private final Integer enable;

    @SerializedName("white_list")
    private HashSet<String> whiteList;

    /* JADX WARN: Multi-variable type inference failed */
    public EntranceInfoWhiteListConfig() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EntranceInfoWhiteListConfig copy$default(EntranceInfoWhiteListConfig r100, HashSet r101, Integer r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.whiteList;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.enable;
    L9:
        return r100.copy(r101, r102);
    }

    public final HashSet<String> component1() {
        return this.whiteList;
    }

    public final Integer component2() {
        return this.enable;
    }

    public final EntranceInfoWhiteListConfig copy(HashSet<String> r100, Integer r101) {
        return new EntranceInfoWhiteListConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof EntranceInfoWhiteListConfig) == false) goto L10;
        EntranceInfoWhiteListConfig r101 = (EntranceInfoWhiteListConfig) r100;
        if (Intrinsics.areEqual(this.whiteList, r101.whiteList) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.enable, r101.enable) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        HashSet<String> r100 = this.whiteList;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.enable;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "EntranceInfoWhiteListConfig(whiteList=" + this.whiteList + ", enable=" + this.enable + ")";
    }

    public final Integer getEnable() {
        return this.enable;
    }

    public final HashSet<String> getWhiteList() {
        return this.whiteList;
    }

    public final void setWhiteList(HashSet<String> r100) {
        this.whiteList = r100;
    }

    public EntranceInfoWhiteListConfig(HashSet<String> r100, Integer r101) {
        this.whiteList = r100;
        this.enable = r101;
    }

    public /* synthetic */ EntranceInfoWhiteListConfig(HashSet r100, Integer r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        this(r100, r101);
    }
}
