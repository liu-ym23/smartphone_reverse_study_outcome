package com.bytedance.android.shopping.anchorv4.voavhs.logistics;

import com.bytedance.android.shopping.anchorv4.dto.base.ShowEvent;
import com.bytedance.android.shopping.anchorv4.dto.components.LongContentLabelComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.TagsScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.google.gson.annotations.SerializedName;
import com.ss.cast.discovery.mdns.nsdhelper.NsdHelper;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r¢\u0006\u0002\u0010\u0012J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010%\u001a\u00020\rHÆ\u0003J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fHÆ\u0003J\t\u0010'\u001a\u00020\rHÆ\u0003Jq\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\rHÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\rHÖ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0011\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018¨\u00060"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/ServiceComponent;", "Ljava/io/Serializable;", "header", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "detailContent", "", "Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;", "additionalInfo", "Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/LogisticsAdditionalInfo;", "processItems", "Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;", "suffix", "space", "", "showEvent", "", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ShowEvent;", NsdHelper.serviceTypeKey, "(Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/LogisticsAdditionalInfo;Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;ILjava/util/List;I)V", "getAdditionalInfo", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/LogisticsAdditionalInfo;", "getDetailContent", "()Ljava/util/List;", "getHeader", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "getProcessItems", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;", "getServiceType", "()I", "getShowEvent", "getSpace", "getSuffix", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ServiceComponent implements Serializable {

    @SerializedName("additional_info")
    private final LogisticsAdditionalInfo additionalInfo;

    @SerializedName("detail_content")
    private final List<LongContentLabelComponent> detailContent;

    @SerializedName("header")
    private final TextWithOneIconElement header;

    @SerializedName("process_item")
    private final TagsScrollBoxComponent processItems;

    @SerializedName("service_type")
    private final int serviceType;

    @SerializedName("show_event")
    private final List<ShowEvent> showEvent;

    /* JADX INFO: renamed from: space, reason: collision with root package name */
    @SerializedName("space")
    private final int f169979space;

    @SerializedName("suffix")
    private final TextWithOneIconElement suffix;

    public ServiceComponent() {
        this(null, null, null, null, null, 0, null, 0, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ServiceComponent copy$default(ServiceComponent r100, TextWithOneIconElement r110, List r111, LogisticsAdditionalInfo r112, TagsScrollBoxComponent r113, TextWithOneIconElement r114, int r115, List r116, int r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        TextWithOneIconElement r101 = r100.header;
    L7:
        if ((r118 & 2) == 0) goto L9;
        List r102 = r100.detailContent;
    L11:
        if ((r118 & 4) == 0) goto L13;
        LogisticsAdditionalInfo r103 = r100.additionalInfo;
    L15:
        if ((r118 & 8) == 0) goto L17;
        TagsScrollBoxComponent r104 = r100.processItems;
    L19:
        if ((r118 & 16) == 0) goto L21;
        TextWithOneIconElement r105 = r100.suffix;
    L23:
        if ((r118 & 32) == 0) goto L25;
        int r106 = r100.f169979space;
    L27:
        if ((r118 & 64) == 0) goto L29;
        List r107 = r100.showEvent;
    L31:
        if ((r118 & 128) == 0) goto L33;
        int r108 = r100.serviceType;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final TextWithOneIconElement component1() {
        return this.header;
    }

    public final List<LongContentLabelComponent> component2() {
        return this.detailContent;
    }

    public final LogisticsAdditionalInfo component3() {
        return this.additionalInfo;
    }

    public final TagsScrollBoxComponent component4() {
        return this.processItems;
    }

    public final TextWithOneIconElement component5() {
        return this.suffix;
    }

    public final int component6() {
        return this.f169979space;
    }

    public final List<ShowEvent> component7() {
        return this.showEvent;
    }

    public final int component8() {
        return this.serviceType;
    }

    public final ServiceComponent copy(TextWithOneIconElement r110, List<LongContentLabelComponent> r111, LogisticsAdditionalInfo r112, TagsScrollBoxComponent r113, TextWithOneIconElement r114, int r115, List<ShowEvent> r116, int r117) {
        return new ServiceComponent(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ServiceComponent) == false) goto L22;
        ServiceComponent r101 = (ServiceComponent) r100;
        if (Intrinsics.areEqual(this.header, r101.header) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.detailContent, r101.detailContent) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.additionalInfo, r101.additionalInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.processItems, r101.processItems) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.suffix, r101.suffix) == true) goto L16;
        return false;
    L16:
        if (this.f169979space == r101.f169979space) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.showEvent, r101.showEvent) == true) goto L20;
        return false;
    L20:
        if (this.serviceType == r101.serviceType) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        TextWithOneIconElement r100 = this.header;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<LongContentLabelComponent> r104 = this.detailContent;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        LogisticsAdditionalInfo r107 = this.additionalInfo;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        TagsScrollBoxComponent r110 = this.processItems;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        TextWithOneIconElement r113 = this.suffix;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (((r112 + r114) * 31) + this.f169979space) * 31;
        List<ShowEvent> r116 = this.showEvent;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return ((r115 + r101) * 31) + this.serviceType;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ServiceComponent(header=" + this.header + ", detailContent=" + this.detailContent + ", additionalInfo=" + this.additionalInfo + ", processItems=" + this.processItems + ", suffix=" + this.suffix + ", space=" + this.f169979space + ", showEvent=" + this.showEvent + ", serviceType=" + this.serviceType + ")";
    }

    public final LogisticsAdditionalInfo getAdditionalInfo() {
        return this.additionalInfo;
    }

    public final List<LongContentLabelComponent> getDetailContent() {
        return this.detailContent;
    }

    public final TextWithOneIconElement getHeader() {
        return this.header;
    }

    public final TagsScrollBoxComponent getProcessItems() {
        return this.processItems;
    }

    public final int getServiceType() {
        return this.serviceType;
    }

    public final List<ShowEvent> getShowEvent() {
        return this.showEvent;
    }

    public final int getSpace() {
        return this.f169979space;
    }

    public final TextWithOneIconElement getSuffix() {
        return this.suffix;
    }

    public ServiceComponent(TextWithOneIconElement r100, List<LongContentLabelComponent> r101, LogisticsAdditionalInfo r102, TagsScrollBoxComponent r103, TextWithOneIconElement r104, int r105, List<ShowEvent> r106, int r107) {
        this.header = r100;
        this.detailContent = r101;
        this.additionalInfo = r102;
        this.processItems = r103;
        this.suffix = r104;
        this.f169979space = r105;
        this.showEvent = r106;
        this.serviceType = r107;
    }

    public /* synthetic */ ServiceComponent(TextWithOneIconElement r110, List r111, LogisticsAdditionalInfo r112, TagsScrollBoxComponent r113, TextWithOneIconElement r114, int r115, List r116, int r117, int r118, DefaultConstructorMarker r210) {
        List r100 = null;
        if ((r118 & 1) == 0) goto L5;
        TextWithOneIconElement r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        List r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        LogisticsAdditionalInfo r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        TagsScrollBoxComponent r104 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        TextWithOneIconElement r105 = null;
    L22:
        int r106 = 0;
        if ((r118 & 32) == 0) goto L25;
        int r107 = 0;
    L27:
        if ((r118 & 64) != 0) goto L31;
        r100 = r116;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r106 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r107, r100, r106);
        return;
    L25:
        r107 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L22
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
