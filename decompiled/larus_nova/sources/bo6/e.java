package bo6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR*\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lbo6/e;", "", "", "pendantEnable", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "setPendantEnable", "(Ljava/lang/Boolean;)V", "goldPendantEnable", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setGoldPendantEnable", "", "Lbo6/h;", "pendantScenes", "Ljava/util/List;", "c", "()Ljava/util/List;", "setPendantScenes", "(Ljava/util/List;)V", "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("gold_pendant_enable")
    private Boolean goldPendantEnable;

    @SerializedName("pendant_enable")
    private Boolean pendantEnable;

    @SerializedName("pendant_scenes")
    private List<h> pendantScenes;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.pendantEnable, r101.pendantEnable) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.goldPendantEnable, r101.goldPendantEnable) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.pendantScenes, r101.pendantScenes) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.pendantEnable;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.goldPendantEnable;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<h> r107 = this.pendantScenes;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PendantAllowedPage(pendantEnable=" + this.pendantEnable + ", goldPendantEnable=" + this.goldPendantEnable + ", pendantScenes=" + this.pendantScenes + ')';
    }

    public e() {
        this.pendantEnable = null;
        this.goldPendantEnable = null;
        this.pendantScenes = null;
    }

    public final Boolean a() {
        return this.goldPendantEnable;
    }

    public final Boolean b() {
        return this.pendantEnable;
    }

    public final List<h> c() {
        return this.pendantScenes;
    }
}
