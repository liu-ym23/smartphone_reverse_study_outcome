package com.bytedance.android.gamecp.business.gamedetail.component.intro;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/intro/f;", "", "", "rotation", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "url", "b", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("rotation")
    private final String rotation;

    @SerializedName("url")
    private final String url;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L10;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.rotation, r101.rotation) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.rotation;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.url;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "Image(rotation=" + this.rotation + ", url=" + this.url + ")";
    }

    public f() {
        this.rotation = "";
        this.url = "";
    }

    public final String a() {
        return this.rotation;
    }

    public final String b() {
        return this.url;
    }
}
