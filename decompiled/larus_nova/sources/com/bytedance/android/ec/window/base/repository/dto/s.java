package com.bytedance.android.ec.window.base.repository.dto;

import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/ec/window/base/repository/dto/s;", "", "", "data", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "name", "e", "moduleUrl", "d", "", "containerType", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "componentType", "getComponentType", "", "Lcom/bytedance/android/ec/window/base/repository/dto/t;", "rules", "Ljava/util/List;", "f", "()Ljava/util/List;", "", "coverBottomTab", "Z", "b", "()Z", "setCoverBottomTab", "(Z)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class s {

    @SerializedName("component_type")
    private final int componentType;

    @SerializedName(ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE)
    private final int containerType;

    @SerializedName("cover_bottom_tab")
    private boolean coverBottomTab;

    @SerializedName("data")
    private final String data;

    @SerializedName("module_url")
    private final String moduleUrl;

    @SerializedName("name")
    private final String name;

    @SerializedName("rules")
    private final List<t> rules;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof s) == false) goto L20;
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.moduleUrl, r101.moduleUrl) == true) goto L12;
        return false;
    L12:
        if (this.containerType == r101.containerType) goto L14;
        return false;
    L14:
        if (this.componentType == r101.componentType) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.rules, r101.rules) == true) goto L18;
        return false;
    L18:
        if (this.coverBottomTab == r101.coverBottomTab) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        String r100 = this.data;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.name;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.moduleUrl;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (((((r106 + r108) * 31) + this.containerType) * 31) + this.componentType) * 31;
        List<t> r110 = this.rules;
        if (r110 == null) goto L17;
        r101 = r110.hashCode();
    L17:
        int r111 = (r109 + r101) * 31;
        boolean r112 = this.coverBottomTab;
        ?? r113 = r112;
        if (r112 == false) goto L21;
        r113 = 1;
    L21:
        return r111 + r113;
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
        return "WindowHybridComponentDTO(data=" + this.data + ", name=" + this.name + ", moduleUrl=" + this.moduleUrl + ", containerType=" + this.containerType + ", componentType=" + this.componentType + ", rules=" + this.rules + ", coverBottomTab=" + this.coverBottomTab + ")";
    }

    public s() {
        Intrinsics.checkNotNullParameter("", "name");
        this.data = "";
        this.name = "";
        this.moduleUrl = "";
        this.containerType = 0;
        this.componentType = 0;
        this.rules = null;
        this.coverBottomTab = false;
    }

    public final int a() {
        return this.containerType;
    }

    public final boolean b() {
        return this.coverBottomTab;
    }

    public final String c() {
        return this.data;
    }

    public final String d() {
        return this.moduleUrl;
    }

    public final String e() {
        return this.name;
    }

    public final List<t> f() {
        return this.rules;
    }
}
