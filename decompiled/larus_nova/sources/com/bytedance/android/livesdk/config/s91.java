package com.bytedance.android.livesdk.config;

import com.bytedance.android.shopping.slice.action.entity.SendClosePdpEventParam;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/config/s91;", "", "", "lynxScheme", "Ljava/lang/String;", "getLynxScheme", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "lynxUrl", "getLynxUrl", "d", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class s91 {

    @SerializedName("lynx_scheme")
    private String lynxScheme;

    @SerializedName(SendClosePdpEventParam.KEY_LYNX_URL)
    private String lynxUrl;

    public s91() {
        this(0);
    }

    public final String a() {
        return this.lynxScheme;
    }

    public final String b() {
        return this.lynxUrl;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof s91) == false) goto L10;
        s91 r101 = (s91) r100;
        if (Intrinsics.areEqual(this.lynxScheme, r101.lynxScheme) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.lynxUrl, r101.lynxUrl) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.lynxScheme;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.lynxUrl;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LynxPageConfig(lynxScheme=" + this.lynxScheme + ", lynxUrl=" + this.lynxUrl + ")";
    }

    public s91(int r100) {
        Intrinsics.checkNotNullParameter("", "lynxScheme");
        Intrinsics.checkNotNullParameter("", "lynxUrl");
        this.lynxScheme = "";
        this.lynxUrl = "";
    }

    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.lynxScheme = r100;
    }

    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.lynxUrl = r100;
    }
}
