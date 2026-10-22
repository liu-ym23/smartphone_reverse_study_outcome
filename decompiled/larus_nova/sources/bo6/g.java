package bo6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0010R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lbo6/g;", "", "", "host", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setHost", "(Ljava/lang/String;)V", "activity", "getActivity", "setActivity", "channel", "b", "setChannel", "bundle", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setBundle", "", "pageType", "I", "d", "()I", "setPageType", "(I)V", "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName("activity")
    private String activity;

    @SerializedName("bundle")
    private String bundle;

    @SerializedName("channel")
    private String channel;

    @SerializedName("host")
    private String host;

    @SerializedName("page_type")
    private int pageType;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.host, r101.host) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.activity, r101.activity) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.channel, r101.channel) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bundle, r101.bundle) == true) goto L21;
        return false;
    L21:
        if (this.pageType == r101.pageType) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.host;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.activity;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.channel;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.bundle;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return ((r109 + r101) * 31) + this.pageType;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PendantPageRule(host=" + this.host + ", activity=" + this.activity + ", channel=" + this.channel + ", bundle=" + this.bundle + ", pageType=" + this.pageType + ')';
    }

    public final boolean e() {
        if (ap6.a.b(this.channel) == true) goto L5;
    L7:
        return false;
    L5:
        if (ap6.a.b(this.bundle) == false) goto L7;
        return true;
    }

    public g() {
        this.host = null;
        this.activity = null;
        this.channel = null;
        this.bundle = null;
        this.pageType = 0;
    }

    public final String a() {
        return this.bundle;
    }

    public final String b() {
        return this.channel;
    }

    public final String c() {
        return this.host;
    }

    public final int d() {
        return this.pageType;
    }

    public final String getActivity() {
        return this.activity;
    }
}
