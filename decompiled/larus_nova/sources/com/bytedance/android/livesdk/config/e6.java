package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/config/e6;", "", "", "enableActivateGecko", "Z", "b", "()Z", "", "", "activatePaths", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e6 {

    @SerializedName("activate_paths")
    private final List<String> activatePaths;

    @SerializedName("enable_activate_gecko")
    private final boolean enableActivateGecko;

    public e6() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e6) == false) goto L10;
        e6 r101 = (e6) r100;
        if (this.enableActivateGecko == r101.enableActivateGecko) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.activatePaths, r101.activatePaths) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean r100 = this.enableActivateGecko;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        List<String> r103 = this.activatePaths;
        if (r103 == null) goto L8;
        int r104 = r103.hashCode();
    L10:
        return r102 + r104;
    L8:
        r104 = 0;
        goto L10
    }

    public final String toString() {
        return "GameGeckoActivateConfig(enableActivateGecko=" + this.enableActivateGecko + ", activatePaths=" + this.activatePaths + ")";
    }

    public final List<String> a() {
        return this.activatePaths;
    }

    public final boolean b() {
        return this.enableActivateGecko;
    }

    public /* synthetic */ e6(int r100) {
        this(false, null);
    }

    public e6(boolean r100, List<String> r101) {
        this.enableActivateGecko = r100;
        this.activatePaths = r101;
    }
}
