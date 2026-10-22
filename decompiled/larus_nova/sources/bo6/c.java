package bo6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lbo6/c;", "", "", "pendantLynxUrl", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "pendantLynxData", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("life_pendant_lynx_data")
    private final String pendantLynxData;

    @SerializedName("life_pendant_lynx_url")
    private final String pendantLynxUrl;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.pendantLynxUrl, r101.pendantLynxUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.pendantLynxData, r101.pendantLynxData) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.pendantLynxUrl;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.pendantLynxData;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "LifePendantBizData(pendantLynxUrl=" + this.pendantLynxUrl + ", pendantLynxData=" + this.pendantLynxData + ')';
    }

    public c() {
        this.pendantLynxUrl = null;
        this.pendantLynxData = null;
    }

    public final String a() {
        return this.pendantLynxData;
    }

    public final String b() {
        return this.pendantLynxUrl;
    }
}
