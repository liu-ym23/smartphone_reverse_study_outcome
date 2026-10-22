package com.bytedance.android.shopping.orderlist.common.freq;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u001d\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0003HÆ\u0003J\u0006\u0010\u0011\u001a\u00020\u0012Jc\u0010\u0013\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00032\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00032\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001R*\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR*\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR*\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStorage;", "Ljava/io/Serializable;", "view", "", "", "", "", "click", "close", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "getClick", "()Ljava/util/Map;", "getClose", "getView", "component1", "component2", "component3", "containsContent", "", "copy", "equals", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FreqStorage implements Serializable {

    @SerializedName("click")
    private final Map<String, List<Long>> click;

    @SerializedName("close")
    private final Map<String, List<Long>> close;

    @SerializedName("view")
    private final Map<String, List<Long>> view;

    public FreqStorage() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FreqStorage copy$default(FreqStorage r100, Map r101, Map r102, Map r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.view;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.click;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.close;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Map<String, List<Long>> component1() {
        return this.view;
    }

    public final Map<String, List<Long>> component2() {
        return this.click;
    }

    public final Map<String, List<Long>> component3() {
        return this.close;
    }

    public final FreqStorage copy(Map<String, List<Long>> r100, Map<String, List<Long>> r101, Map<String, List<Long>> r102) {
        return new FreqStorage(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof FreqStorage) == false) goto L12;
        FreqStorage r101 = (FreqStorage) r100;
        if (Intrinsics.areEqual(this.view, r101.view) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.click, r101.click) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.close, r101.close) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        Map<String, List<Long>> r100 = this.view;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, List<Long>> r104 = this.click;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, List<Long>> r107 = this.close;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "FreqStorage(view=" + this.view + ", click=" + this.click + ", close=" + this.close + ")";
    }

    public final boolean containsContent() {
        if (this.view == null) goto L5;
    L10:
        return true;
    L5:
        if (this.click != null) goto L10;
        if (this.close != null) goto L10;
        return false;
    }

    public final Map<String, List<Long>> getClick() {
        return this.click;
    }

    public final Map<String, List<Long>> getClose() {
        return this.close;
    }

    public final Map<String, List<Long>> getView() {
        return this.view;
    }

    public FreqStorage(Map<String, List<Long>> r100, Map<String, List<Long>> r101, Map<String, List<Long>> r102) {
        this.view = r100;
        this.click = r101;
        this.close = r102;
    }

    public /* synthetic */ FreqStorage(Map r100, Map r101, Map r102, int r103, DefaultConstructorMarker r104) {
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
