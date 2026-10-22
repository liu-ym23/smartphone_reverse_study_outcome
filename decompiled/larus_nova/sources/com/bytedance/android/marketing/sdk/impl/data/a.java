package com.bytedance.android.marketing.sdk.impl.data;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R$\u0010\u0007\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\b\u001a\u0004\b\u0011\u0010\nR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\b\u001a\u0004\b\u001a\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/marketing/sdk/impl/data/a;", "", "", "schema", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "data", "Ljava/lang/Object;", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "uiConfig", "getUiConfig", "setUiConfig", "layoutInfo", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "isDefaultView", "Ljava/lang/Boolean;", "d", "()Ljava/lang/Boolean;", "isRootView", "e", "taskConfig", "c", "ec-biz-marketing-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("data")
    private Object data;

    @SerializedName("is_default_view")
    private final Boolean isDefaultView;

    @SerializedName("is_root_view")
    private final Boolean isRootView;

    @SerializedName("layout_info")
    private final Object layoutInfo;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("task_config")
    private final Object taskConfig;

    @SerializedName("ui_config")
    private Object uiConfig;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L20;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.uiConfig, r101.uiConfig) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.layoutInfo, r101.layoutInfo) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.isDefaultView, r101.isDefaultView) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.isRootView, r101.isRootView) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.taskConfig, r101.taskConfig) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final Map<String, Object> f() {
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("schema", this.schema), TuplesKt.to("data", this.data), TuplesKt.to("ui_config", this.uiConfig), TuplesKt.to("taskConfig", this.taskConfig), TuplesKt.to("layoutInfo", this.layoutInfo), TuplesKt.to("isRootView", this.isRootView), TuplesKt.to("isDefaultView", this.isDefaultView)});
    }

    public final int hashCode() {
        String r100 = this.schema;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Object r104 = this.data;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Object r107 = this.uiConfig;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Object r110 = this.layoutInfo;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.isDefaultView;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.isRootView;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Object r119 = this.taskConfig;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
    L25:
        r117 = 0;
        goto L26
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
        return "CompData(schema=" + this.schema + ", data=" + this.data + ", uiConfig=" + this.uiConfig + ", layoutInfo=" + this.layoutInfo + ", isDefaultView=" + this.isDefaultView + ", isRootView=" + this.isRootView + ", taskConfig=" + this.taskConfig + ")";
    }

    public final Object a() {
        return this.layoutInfo;
    }

    public final String b() {
        return this.schema;
    }

    public final Object c() {
        return this.taskConfig;
    }

    public final Boolean d() {
        return this.isDefaultView;
    }

    public final Boolean e() {
        return this.isRootView;
    }
}
