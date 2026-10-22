package bo6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010¨\u0006\u0014"}, d2 = {"Lbo6/h;", "", "", "scenekey", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setScenekey", "(Ljava/lang/String;)V", "", "Lbo6/g;", "sceneValues", "Ljava/util/List;", "b", "()Ljava/util/List;", "setSceneValues", "(Ljava/util/List;)V", "sceneIgnore", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setSceneIgnore", "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3})
public final class h {

    @SerializedName("scene_ignore")
    private List<g> sceneIgnore;

    @SerializedName("scene_values")
    private List<g> sceneValues;

    @SerializedName("scene_key")
    private String scenekey;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.scenekey, r101.scenekey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sceneValues, r101.sceneValues) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sceneIgnore, r101.sceneIgnore) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.scenekey;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<g> r104 = this.sceneValues;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<g> r107 = this.sceneIgnore;
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
        return "PendantPageScene(scenekey=" + this.scenekey + ", sceneValues=" + this.sceneValues + ", sceneIgnore=" + this.sceneIgnore + ')';
    }

    public h() {
        this.scenekey = null;
        this.sceneValues = null;
        this.sceneIgnore = null;
    }

    public final List<g> a() {
        return this.sceneIgnore;
    }

    public final List<g> b() {
        return this.sceneValues;
    }

    public final String c() {
        return this.scenekey;
    }
}
