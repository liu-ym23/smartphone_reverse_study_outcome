package W6;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\nR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"LW6/b;", "", "", "success", "", "message", "data", "<init>", "(ZLjava/lang/String;Ljava/lang/Object;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Z", "getSuccess", "()Z", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "getMessage", "c", "Ljava/lang/Object;", "getData", "()Ljava/lang/Object;", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: W6.b, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class StorageResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean success;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String message;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final Object data;

    public StorageResult(boolean z10, String str, Object obj) {
        this.success = z10;
        this.message = str;
        this.data = obj;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StorageResult)) {
            return false;
        }
        StorageResult storageResult = (StorageResult) other;
        return this.success == storageResult.success && p.d(this.message, storageResult.message) && p.d(this.data, storageResult.data);
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.success) * 31;
        String str = this.message;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Object obj = this.data;
        return iHashCode2 + (obj != null ? obj.hashCode() : 0);
    }

    public String toString() {
        return "StorageResult(success=" + this.success + ", message=" + this.message + ", data=" + this.data + ")";
    }

    public /* synthetic */ StorageResult(boolean z10, String str, Object obj, int i10, i iVar) {
        this(z10, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : obj);
    }
}
