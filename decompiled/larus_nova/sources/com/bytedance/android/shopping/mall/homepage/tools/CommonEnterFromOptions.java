package com.bytedance.android.shopping.mall.homepage.tools;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/tools/CommonEnterFromOptions;", "", "addPreviousPage", "", "(Z)V", "getAddPreviousPage", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonEnterFromOptions {
    private final boolean addPreviousPage;

    public CommonEnterFromOptions() {
        boolean r100 = false;
        this(r100, 1, null);
    }

    public static /* synthetic */ CommonEnterFromOptions copy$default(CommonEnterFromOptions r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.addPreviousPage;
    L6:
        return r100.copy(r101);
    }

    public final boolean component1() {
        return this.addPreviousPage;
    }

    public final CommonEnterFromOptions copy(boolean r100) {
        return new CommonEnterFromOptions(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CommonEnterFromOptions) == true) goto L6;
        return false;
    L6:
        if (this.addPreviousPage == ((CommonEnterFromOptions) r100).addPreviousPage) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        boolean r100 = this.addPreviousPage;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public String toString() {
        return "CommonEnterFromOptions(addPreviousPage=" + this.addPreviousPage + ")";
    }

    public final boolean getAddPreviousPage() {
        return this.addPreviousPage;
    }

    public CommonEnterFromOptions(boolean r100) {
        this.addPreviousPage = r100;
    }

    public /* synthetic */ CommonEnterFromOptions(boolean r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = false;
    L5:
        this(r100);
    }
}
