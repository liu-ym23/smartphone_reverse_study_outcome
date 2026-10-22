package com.bytedance.android.shopping.anchorv4.event_chain.custom_event.bottombtn;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R*\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R*\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0018\u0010\u0011R*\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/event_chain/custom_event/bottombtn/f;", "", "", "componentType", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "componentId", "c", "componentKey", "d", "actionSource", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "incomingData", "Ljava/util/Map;", "f", "()Ljava/util/Map;", "", "needAnimation", "Z", "getNeedAnimation", "()Z", "lynxInnerPosition", ce.f26391f, "closePopupAction", "b", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("action_source")
    private final String actionSource;

    @SerializedName("close_popup_action")
    private final Map<String, Object> closePopupAction;

    @SerializedName("component_id")
    private final String componentId;

    @SerializedName("component_key")
    private final String componentKey;

    @SerializedName("component_type")
    private final String componentType;

    @SerializedName("incoming_data")
    private final Map<String, Object> incomingData;

    @SerializedName("lynx_inner_position")
    private final Map<String, Object> lynxInnerPosition;

    @SerializedName("need_animation")
    private final boolean needAnimation;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L22;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.componentType, r101.componentType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.componentId, r101.componentId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.componentKey, r101.componentKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.actionSource, r101.actionSource) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.incomingData, r101.incomingData) == true) goto L16;
        return false;
    L16:
        if (this.needAnimation == r101.needAnimation) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.lynxInnerPosition, r101.lynxInnerPosition) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.closePopupAction, r101.closePopupAction) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v24 */
    public final int hashCode() {
        String r100 = this.componentType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.componentId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.componentKey;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.actionSource;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, Object> r113 = this.incomingData;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        boolean r116 = this.needAnimation;
        ?? r117 = r116;
        if (r116 == false) goto L25;
        r117 = 1;
    L25:
        int r118 = (r115 + r117) * 31;
        Map<String, Object> r119 = this.lynxInnerPosition;
        if (r119 == null) goto L28;
        int r120 = r119.hashCode();
    L29:
        int r121 = (r118 + r120) * 31;
        Map<String, Object> r122 = this.closePopupAction;
        if (r122 == null) goto L33;
        r101 = r122.hashCode();
    L33:
        return r121 + r101;
    L28:
        r120 = 0;
        goto L29
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

    public final String toString() {
        return "QCPXCouponBackEventFields(componentType=" + this.componentType + ", componentId=" + this.componentId + ", componentKey=" + this.componentKey + ", actionSource=" + this.actionSource + ", incomingData=" + this.incomingData + ", needAnimation=" + this.needAnimation + ", lynxInnerPosition=" + this.lynxInnerPosition + ", closePopupAction=" + this.closePopupAction + ")";
    }

    public final String a() {
        return this.actionSource;
    }

    public final Map<String, Object> b() {
        return this.closePopupAction;
    }

    public final String c() {
        return this.componentId;
    }

    public final String d() {
        return this.componentKey;
    }

    public final String e() {
        return this.componentType;
    }

    public final Map<String, Object> f() {
        return this.incomingData;
    }

    public final Map<String, Object> g() {
        return this.lynxInnerPosition;
    }

    public f(String r100, String r101, String r102, String r103, Map<String, ? extends Object> r104, boolean r105, Map<String, ? extends Object> r106, Map<String, ? extends Object> r107) {
        Intrinsics.checkNotNullParameter(r100, "componentType");
        Intrinsics.checkNotNullParameter(r101, "componentId");
        Intrinsics.checkNotNullParameter(r102, "componentKey");
        Intrinsics.checkNotNullParameter(r103, "actionSource");
        this.componentType = r100;
        this.componentId = r101;
        this.componentKey = r102;
        this.actionSource = r103;
        this.incomingData = r104;
        this.needAnimation = r105;
        this.lynxInnerPosition = r106;
        this.closePopupAction = r107;
    }
}
