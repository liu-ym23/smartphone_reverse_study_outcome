package com.bytedance.android.ecom.arch.slice.render;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/ecom/arch/slice/render/n;", "", "", "disableScale", "Z", "c", "()Z", "", "version", "Ljava/lang/Integer;", "getVersion", "()Ljava/lang/Integer;", "", "customScaleKey", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "disableAdaptScreen", "b", "slice-render_release"}, k = 1, mv = {1, 4, 0})
public final class n {

    @SerializedName("custom_scale_key")
    private final String customScaleKey;

    @SerializedName("disable_adapt_screen")
    private final boolean disableAdaptScreen;

    @SerializedName("disable_scale")
    private final boolean disableScale;

    @SerializedName("version")
    private final Integer version;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n) == false) goto L14;
        n r101 = (n) r100;
        if (this.disableScale == r101.disableScale) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.customScaleKey, r101.customScaleKey) == true) goto L12;
        return false;
    L12:
        if (this.disableAdaptScreen == r101.disableAdaptScreen) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public final int hashCode() {
        boolean r100 = this.disableScale;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        Integer r104 = this.version;
        int r105 = 0;
        if (r104 == null) goto L8;
        int r106 = r104.hashCode();
    L9:
        int r107 = (r103 + r106) * 31;
        String r108 = this.customScaleKey;
        if (r108 == null) goto L12;
        r105 = r108.hashCode();
    L12:
        int r109 = (r107 + r105) * 31;
        boolean r110 = this.disableAdaptScreen;
        if (r110 == true) goto L17;
        r101 = r110;
    L17:
        return r109 + r101;
    L8:
        r106 = 0;
        goto L9
    }

    public final String toString() {
        return "SlcTemplateConfig(disableScale=" + this.disableScale + ", version=" + this.version + ", customScaleKey=" + this.customScaleKey + ", disableAdaptScreen=" + this.disableAdaptScreen + ")";
    }

    public n() {
        this.disableScale = false;
        this.version = null;
        this.customScaleKey = null;
        this.disableAdaptScreen = false;
    }

    public final String a() {
        return this.customScaleKey;
    }

    public final boolean b() {
        return this.disableAdaptScreen;
    }

    public final boolean c() {
        return this.disableScale;
    }
}
