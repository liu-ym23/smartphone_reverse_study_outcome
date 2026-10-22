package com.bytedance.android.window.shop.repository.dto;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003J'\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/WindowExtensionDataListResponseDTO;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "", "Lcom/bytedance/android/window/shop/repository/dto/c;", "component1", "Lcom/bytedance/android/window/shop/repository/dto/w;", "component2", "mixFullCards", "controlInfo", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/util/List;", "getMixFullCards", "()Ljava/util/List;", "Lcom/bytedance/android/window/shop/repository/dto/w;", "getControlInfo", "()Lcom/bytedance/android/window/shop/repository/dto/w;", "<init>", "(Ljava/util/List;Lcom/bytedance/android/window/shop/repository/dto/w;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowExtensionDataListResponseDTO extends CommerceBaseResponse {

    @SerializedName("control_info")
    private final w controlInfo;

    @SerializedName("mix_full_cards")
    private final List<c> mixFullCards;

    /* JADX WARN: Multi-variable type inference failed */
    public WindowExtensionDataListResponseDTO() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WindowExtensionDataListResponseDTO copy$default(WindowExtensionDataListResponseDTO r100, List r101, w r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.mixFullCards;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.controlInfo;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<c> component1() {
        return this.mixFullCards;
    }

    public final w component2() {
        return this.controlInfo;
    }

    public final WindowExtensionDataListResponseDTO copy(List<c> r100, w r101) {
        return new WindowExtensionDataListResponseDTO(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof WindowExtensionDataListResponseDTO) == false) goto L10;
        WindowExtensionDataListResponseDTO r101 = (WindowExtensionDataListResponseDTO) r100;
        if (Intrinsics.areEqual(this.mixFullCards, r101.mixFullCards) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.controlInfo, r101.controlInfo) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        List<c> r100 = this.mixFullCards;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        w r104 = this.controlInfo;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "WindowExtensionDataListResponseDTO(mixFullCards=" + this.mixFullCards + ", controlInfo=" + this.controlInfo + ")";
    }

    public final w getControlInfo() {
        return this.controlInfo;
    }

    public final List<c> getMixFullCards() {
        return this.mixFullCards;
    }

    public WindowExtensionDataListResponseDTO(List<c> r100, w r101) {
        this.mixFullCards = r100;
        this.controlInfo = r101;
    }

    public /* synthetic */ WindowExtensionDataListResponseDTO(List r100, w r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
