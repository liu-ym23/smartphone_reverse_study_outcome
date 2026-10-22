package com.bytedance.android.shopping.anchorv4.voavhs.head;

import com.bytedance.android.ecom.arch.slice.BaseSlice;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R(\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/p;", "", "", "", "templateData", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "", "sliceType", "I", "getSliceType", "()I", "sliceId", "Ljava/lang/String;", "getSliceId", "()Ljava/lang/String;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/q;", ThumbGlideUrl.SOURCE_TEMPLATE, "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/q;", "b", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/head/q;", "showAction", "getShowAction", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient IAction f168810a;

    @SerializedName("show_action")
    private final Map<String, Object> showAction;

    @SerializedName(BaseSlice.KEY_SLICE_ID)
    private final String sliceId;

    @SerializedName("slice_type")
    private final int sliceType;

    @SerializedName(ThumbGlideUrl.SOURCE_TEMPLATE)
    private final q template;

    @SerializedName("data")
    private final Map<String, Object> templateData;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == false) goto L16;
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.templateData, r101.templateData) == true) goto L8;
        return false;
    L8:
        if (this.sliceType == r101.sliceType) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.sliceId, r101.sliceId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.template, r101.template) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.showAction, r101.showAction) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        Map<String, Object> r100 = this.templateData;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.sliceType) * 31;
        String r104 = this.sliceId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        q r107 = this.template;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, Object> r110 = this.showAction;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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

    public final String toString() {
        return "Slice(templateData=" + this.templateData + ", sliceType=" + this.sliceType + ", sliceId=" + this.sliceId + ", template=" + this.template + ", showAction=" + this.showAction + ")";
    }

    public final IAction a() {
        if (this.f168810a != null) goto L6;
        this.f168810a = com.bytedance.android.ecom.arch.slice.action.n.a(this.showAction);
    L6:
        return this.f168810a;
    }

    public p() {
        this.templateData = null;
        this.sliceType = 0;
        this.sliceId = null;
        this.template = null;
        this.showAction = null;
    }

    public final q b() {
        return this.template;
    }

    public final Map<String, Object> c() {
        return this.templateData;
    }
}
