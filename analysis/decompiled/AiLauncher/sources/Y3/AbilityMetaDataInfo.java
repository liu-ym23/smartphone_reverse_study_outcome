package Y3;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0013\u001a\u0004\b\u0016\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\n¨\u0006\u001b"}, d2 = {"LY3/b;", "", "", "method", "description", "inputSchema", "packageName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "getMethod", Const.INTENT_KEY_PKGNAME, "getDescription", "c", "getInputSchema", Const.INTENT_KEY_UMID, "getPackageName", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: Y3.b, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class AbilityMetaDataInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String method;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String description;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String inputSchema;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final String packageName;

    public AbilityMetaDataInfo(String method, String description, String inputSchema, String packageName) {
        p.i(method, "method");
        p.i(description, "description");
        p.i(inputSchema, "inputSchema");
        p.i(packageName, "packageName");
        this.method = method;
        this.description = description;
        this.inputSchema = inputSchema;
        this.packageName = packageName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AbilityMetaDataInfo)) {
            return false;
        }
        AbilityMetaDataInfo abilityMetaDataInfo = (AbilityMetaDataInfo) other;
        return p.d(this.method, abilityMetaDataInfo.method) && p.d(this.description, abilityMetaDataInfo.description) && p.d(this.inputSchema, abilityMetaDataInfo.inputSchema) && p.d(this.packageName, abilityMetaDataInfo.packageName);
    }

    public int hashCode() {
        return (((((this.method.hashCode() * 31) + this.description.hashCode()) * 31) + this.inputSchema.hashCode()) * 31) + this.packageName.hashCode();
    }

    public String toString() {
        return "AbilityMetaDataInfo(method=" + this.method + ", description=" + this.description + ", inputSchema=" + this.inputSchema + ", packageName=" + this.packageName + ")";
    }
}
