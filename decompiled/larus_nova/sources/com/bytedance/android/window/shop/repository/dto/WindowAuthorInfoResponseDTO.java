package com.bytedance.android.window.shop.repository.dto;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J!\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/WindowAuthorInfoResponseDTO;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "Lcom/bytedance/android/window/shop/repository/dto/l;", "component1", "Lcom/bytedance/android/window/shop/repository/dto/o;", "component2", "windowAuthorInfo", "windowCartEntryInfo", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/bytedance/android/window/shop/repository/dto/l;", "getWindowAuthorInfo", "()Lcom/bytedance/android/window/shop/repository/dto/l;", "Lcom/bytedance/android/window/shop/repository/dto/o;", "getWindowCartEntryInfo", "()Lcom/bytedance/android/window/shop/repository/dto/o;", "<init>", "(Lcom/bytedance/android/window/shop/repository/dto/l;Lcom/bytedance/android/window/shop/repository/dto/o;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowAuthorInfoResponseDTO extends CommerceBaseResponse {

    @SerializedName("window_author_info")
    private final l windowAuthorInfo;

    @SerializedName("cart_entry_info")
    private final o windowCartEntryInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public WindowAuthorInfoResponseDTO() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ WindowAuthorInfoResponseDTO copy$default(WindowAuthorInfoResponseDTO r100, l r101, o r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.windowAuthorInfo;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.windowCartEntryInfo;
    L9:
        return r100.copy(r101, r102);
    }

    public final l component1() {
        return this.windowAuthorInfo;
    }

    public final o component2() {
        return this.windowCartEntryInfo;
    }

    public final WindowAuthorInfoResponseDTO copy(l r100, o r101) {
        return new WindowAuthorInfoResponseDTO(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof WindowAuthorInfoResponseDTO) == false) goto L10;
        WindowAuthorInfoResponseDTO r101 = (WindowAuthorInfoResponseDTO) r100;
        if (Intrinsics.areEqual(this.windowAuthorInfo, r101.windowAuthorInfo) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.windowCartEntryInfo, r101.windowCartEntryInfo) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        l r100 = this.windowAuthorInfo;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        o r104 = this.windowCartEntryInfo;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "WindowAuthorInfoResponseDTO(windowAuthorInfo=" + this.windowAuthorInfo + ", windowCartEntryInfo=" + this.windowCartEntryInfo + ")";
    }

    public final l getWindowAuthorInfo() {
        return this.windowAuthorInfo;
    }

    public final o getWindowCartEntryInfo() {
        return this.windowCartEntryInfo;
    }

    public WindowAuthorInfoResponseDTO(l r100, o r101) {
        this.windowAuthorInfo = r100;
        this.windowCartEntryInfo = r101;
    }

    public /* synthetic */ WindowAuthorInfoResponseDTO(l r100, o r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
