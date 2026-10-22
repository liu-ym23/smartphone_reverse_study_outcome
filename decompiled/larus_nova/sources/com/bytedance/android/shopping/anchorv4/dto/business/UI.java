package com.bytedance.android.shopping.anchorv4.dto.business;

import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003J-\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u000b\u001a\u00020\u0002HÖ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/business/UI;", "Ljava/io/Serializable;", "", "component1", "component2", "Lcom/bytedance/android/shopping/anchorv4/dto/business/a;", "component3", "containerType", "resourceAddress", "style", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getContainerType", "()Ljava/lang/String;", "getResourceAddress", "Lcom/bytedance/android/shopping/anchorv4/dto/business/a;", "getStyle", "()Lcom/bytedance/android/shopping/anchorv4/dto/business/a;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/dto/business/a;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UI implements Serializable {

    @SerializedName(ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE)
    private final String containerType;

    @SerializedName("resource_addr")
    private final String resourceAddress;

    @SerializedName("style")
    private final a style;

    public UI() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ UI copy$default(UI r100, String r101, String r102, a r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.containerType;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.resourceAddress;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.style;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.containerType;
    }

    public final String component2() {
        return this.resourceAddress;
    }

    public final a component3() {
        return this.style;
    }

    public final UI copy(String r100, String r101, a r102) {
        return new UI(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof UI) == false) goto L12;
        UI r101 = (UI) r100;
        if (Intrinsics.areEqual(this.containerType, r101.containerType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.resourceAddress, r101.resourceAddress) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.style, r101.style) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.containerType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.resourceAddress;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        a r107 = this.style;
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
        return "UI(containerType=" + this.containerType + ", resourceAddress=" + this.resourceAddress + ", style=" + this.style + ")";
    }

    public final String getContainerType() {
        return this.containerType;
    }

    public final String getResourceAddress() {
        return this.resourceAddress;
    }

    public final a getStyle() {
        return this.style;
    }

    public UI(String r100, String r101, a r102) {
        this.containerType = r100;
        this.resourceAddress = r101;
        this.style = r102;
    }

    public /* synthetic */ UI(String r100, String r101, a r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "native";
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
