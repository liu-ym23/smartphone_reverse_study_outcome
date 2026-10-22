package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/config/r6;", "", "", "enable", "Z", "getEnable", "()Z", "", "", "panels", "Ljava/util/List;", "b", "()Ljava/util/List;", "optDigg", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r6 {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("opt_digg")
    private final boolean optDigg;

    @SerializedName("panels")
    private final List<String> panels;

    public r6() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof r6) == false) goto L12;
        r6 r101 = (r6) r100;
        if (this.enable == r101.enable) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.panels, r101.panels) == true) goto L10;
        return false;
    L10:
        if (this.optDigg == r101.optDigg) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public final int hashCode() {
        boolean r100 = this.enable;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        List<String> r104 = this.panels;
        if (r104 == null) goto L8;
        int r105 = r104.hashCode();
    L9:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.optDigg;
        if (r107 == true) goto L14;
        r101 = r107;
    L14:
        return r106 + r101;
    L8:
        r105 = 0;
        goto L9
    }

    public final String toString() {
        return "GamePanelConfig(enable=" + this.enable + ", panels=" + this.panels + ", optDigg=" + this.optDigg + ")";
    }

    public final boolean a() {
        return this.optDigg;
    }

    public final List<String> b() {
        return this.panels;
    }

    public r6(Object r100) {
        ArrayList r101 = new ArrayList();
        Intrinsics.checkNotNullParameter(r101, "panels");
        this.enable = false;
        this.panels = r101;
        this.optDigg = false;
    }
}
