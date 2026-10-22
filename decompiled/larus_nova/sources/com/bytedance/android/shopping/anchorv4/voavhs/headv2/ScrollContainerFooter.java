package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ScrollContainerFooter;", "Ljava/io/Serializable;", "url", "", "slice", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderSliceModel;", "scrollAction", "Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "(Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderSliceModel;Lcom/bytedance/android/ecom/arch/slice/action/IAction;)V", "getScrollAction", "()Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "getSlice", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderSliceModel;", "getUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ScrollContainerFooter implements Serializable {

    @SerializedName("scroll_action")
    private final IAction scrollAction;

    @SerializedName("slice")
    private final HeaderSliceModel slice;

    @SerializedName("url")
    private final String url;

    public ScrollContainerFooter() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ScrollContainerFooter copy$default(ScrollContainerFooter r100, String r101, HeaderSliceModel r102, IAction r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.url;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.slice;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.scrollAction;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.url;
    }

    public final HeaderSliceModel component2() {
        return this.slice;
    }

    public final IAction component3() {
        return this.scrollAction;
    }

    public final ScrollContainerFooter copy(String r100, HeaderSliceModel r101, IAction r102) {
        return new ScrollContainerFooter(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ScrollContainerFooter) == false) goto L12;
        ScrollContainerFooter r101 = (ScrollContainerFooter) r100;
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.slice, r101.slice) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.scrollAction, r101.scrollAction) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.url;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        HeaderSliceModel r104 = this.slice;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        IAction r107 = this.scrollAction;
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
        return "ScrollContainerFooter(url=" + this.url + ", slice=" + this.slice + ", scrollAction=" + this.scrollAction + ")";
    }

    public final IAction getScrollAction() {
        return this.scrollAction;
    }

    public final HeaderSliceModel getSlice() {
        return this.slice;
    }

    public final String getUrl() {
        return this.url;
    }

    public ScrollContainerFooter(String r100, HeaderSliceModel r101, IAction r102) {
        this.url = r100;
        this.slice = r101;
        this.scrollAction = r102;
    }

    public /* synthetic */ ScrollContainerFooter(String r100, HeaderSliceModel r101, IAction r102, int r103, DefaultConstructorMarker r104) {
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
