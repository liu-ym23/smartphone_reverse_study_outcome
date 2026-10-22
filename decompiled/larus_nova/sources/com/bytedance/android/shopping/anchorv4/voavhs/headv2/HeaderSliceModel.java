package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.bytedance.android.ecom.arch.slice.BaseSlice;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b.\u0010/J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0017\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003JQ\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\t\u0010\u0013\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÖ\u0003R\"\u0010\u0019\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\"\u001a\u0004\b#\u0010$R(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010(\u001a\u0004\b)\u0010*R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010+\u001a\u0004\b,\u0010-¨\u00060"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderSliceModel;", "Ljava/io/Serializable;", "", "component1", "Lcom/bytedance/android/ecom/arch/slice/render/SlcElement;", "component2", "", "", "component3", "Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "component4", "Lcom/bytedance/android/ecom/arch/slice/g;", "component5", "sliceId", "sliceTemplate", "sliceTemplateData", "showActions", "geckoSlice", "copy", "toString", "", "hashCode", "other", "", "equals", "hasReportedShowEvent", "Z", "getHasReportedShowEvent", "()Z", "setHasReportedShowEvent", "(Z)V", "Ljava/lang/String;", "getSliceId", "()Ljava/lang/String;", "Lcom/bytedance/android/ecom/arch/slice/render/SlcElement;", "getSliceTemplate", "()Lcom/bytedance/android/ecom/arch/slice/render/SlcElement;", "Ljava/util/Map;", "getSliceTemplateData", "()Ljava/util/Map;", "Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "getShowActions", "()Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "Lcom/bytedance/android/ecom/arch/slice/g;", "getGeckoSlice", "()Lcom/bytedance/android/ecom/arch/slice/g;", "<init>", "(Ljava/lang/String;Lcom/bytedance/android/ecom/arch/slice/render/SlcElement;Ljava/util/Map;Lcom/bytedance/android/ecom/arch/slice/action/IAction;Lcom/bytedance/android/ecom/arch/slice/g;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeaderSliceModel implements Serializable {

    @SerializedName("slice")
    private final com.bytedance.android.ecom.arch.slice.g geckoSlice;
    private boolean hasReportedShowEvent;

    @SerializedName("show_actions")
    private final IAction showActions;

    @SerializedName(BaseSlice.KEY_SLICE_ID)
    private final String sliceId;

    @SerializedName("slice_template")
    private final SlcElement sliceTemplate;

    @SerializedName("slice_template_data")
    private final Map<String, Object> sliceTemplateData;

    public HeaderSliceModel() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HeaderSliceModel copy$default(HeaderSliceModel r100, String r101, SlcElement r102, Map r103, IAction r104, com.bytedance.android.ecom.arch.slice.g r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.sliceId;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.sliceTemplate;
    L8:
        SlcElement r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.sliceTemplateData;
    L11:
        Map r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.showActions;
    L14:
        IAction r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.geckoSlice;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.sliceId;
    }

    public final SlcElement component2() {
        return this.sliceTemplate;
    }

    public final Map<String, Object> component3() {
        return this.sliceTemplateData;
    }

    public final IAction component4() {
        return this.showActions;
    }

    public final com.bytedance.android.ecom.arch.slice.g component5() {
        return this.geckoSlice;
    }

    public final HeaderSliceModel copy(String r100, SlcElement r101, Map<String, ? extends Object> r110, IAction r111, com.bytedance.android.ecom.arch.slice.g r112) {
        return new HeaderSliceModel(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof HeaderSliceModel) == false) goto L16;
        HeaderSliceModel r101 = (HeaderSliceModel) r100;
        if (Intrinsics.areEqual(this.sliceId, r101.sliceId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.sliceTemplate, r101.sliceTemplate) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.sliceTemplateData, r101.sliceTemplateData) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.showActions, r101.showActions) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.geckoSlice, r101.geckoSlice) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r100 = this.sliceId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        SlcElement r104 = this.sliceTemplate;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, Object> r107 = this.sliceTemplateData;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        IAction r110 = this.showActions;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        com.bytedance.android.ecom.arch.slice.g r113 = this.geckoSlice;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
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
        return "HeaderSliceModel(sliceId=" + this.sliceId + ", sliceTemplate=" + this.sliceTemplate + ", sliceTemplateData=" + this.sliceTemplateData + ", showActions=" + this.showActions + ", geckoSlice=" + this.geckoSlice + ")";
    }

    public final com.bytedance.android.ecom.arch.slice.g getGeckoSlice() {
        return this.geckoSlice;
    }

    public final boolean getHasReportedShowEvent() {
        return this.hasReportedShowEvent;
    }

    public final IAction getShowActions() {
        return this.showActions;
    }

    public final String getSliceId() {
        return this.sliceId;
    }

    public final SlcElement getSliceTemplate() {
        return this.sliceTemplate;
    }

    public final Map<String, Object> getSliceTemplateData() {
        return this.sliceTemplateData;
    }

    public final void setHasReportedShowEvent(boolean r100) {
        this.hasReportedShowEvent = r100;
    }

    public HeaderSliceModel(String r100, SlcElement r101, Map<String, ? extends Object> r102, IAction r103, com.bytedance.android.ecom.arch.slice.g r104) {
        this.sliceId = r100;
        this.sliceTemplate = r101;
        this.sliceTemplateData = r102;
        this.showActions = r103;
        this.geckoSlice = r104;
    }

    public /* synthetic */ HeaderSliceModel(String r100, SlcElement r101, Map r102, IAction r103, com.bytedance.android.ecom.arch.slice.g r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        SlcElement r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        Map r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        IAction r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        com.bytedance.android.ecom.arch.slice.g r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
