package a4;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R%\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u001a\u001a\u0004\b\u0013\u0010\u001b¨\u0006\u001c"}, d2 = {"La4/v;", "", "", "ok", "", "", "payload", "La4/u;", "error", "<init>", "(ZLjava/util/Map;La4/u;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Z", Const.INTENT_KEY_PKGNAME, "()Z", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "La4/u;", "()La4/u;", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: a4.v, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class InvokeResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean ok;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final Map<String, Object> payload;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final InvokeError error;

    public InvokeResult(boolean z10, Map<String, ? extends Object> payload, InvokeError invokeError) {
        kotlin.jvm.internal.p.i(payload, "payload");
        this.ok = z10;
        this.payload = payload;
        this.error = invokeError;
    }

    /* renamed from: a, reason: from getter */
    public final InvokeError getError() {
        return this.error;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getOk() {
        return this.ok;
    }

    public final Map<String, Object> c() {
        return this.payload;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InvokeResult)) {
            return false;
        }
        InvokeResult invokeResult = (InvokeResult) other;
        return this.ok == invokeResult.ok && kotlin.jvm.internal.p.d(this.payload, invokeResult.payload) && kotlin.jvm.internal.p.d(this.error, invokeResult.error);
    }

    public int hashCode() {
        int iHashCode = ((Boolean.hashCode(this.ok) * 31) + this.payload.hashCode()) * 31;
        InvokeError invokeError = this.error;
        return iHashCode + (invokeError == null ? 0 : invokeError.hashCode());
    }

    public String toString() {
        return "InvokeResult(ok=" + this.ok + ", payload=" + this.payload + ", error=" + this.error + ")";
    }
}
