package X4;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.contract.OperaErrorKind;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0015\u0010\u000bR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0019\u0010\u000b¨\u0006\u001a"}, d2 = {"LX4/b;", "", "", "identifier", "displayName", "Lcom/stepos/ailauncher/agent/contract/OperaErrorKind;", "kind", "msg", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/agent/contract/OperaErrorKind;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "Lcom/stepos/ailauncher/agent/contract/OperaErrorKind;", "c", "()Lcom/stepos/ailauncher/agent/contract/OperaErrorKind;", Const.INTENT_KEY_UMID, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: X4.b, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class OperaError {
    private final String displayName;
    private final String identifier;
    private final OperaErrorKind kind;
    private final String msg;

    public OperaError(String identifier, String displayName, OperaErrorKind kind, String str) {
        p.i(identifier, "identifier");
        p.i(displayName, "displayName");
        p.i(kind, "kind");
        this.identifier = identifier;
        this.displayName = displayName;
        this.kind = kind;
        this.msg = str;
    }

    /* renamed from: a, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: b, reason: from getter */
    public final String getIdentifier() {
        return this.identifier;
    }

    /* renamed from: c, reason: from getter */
    public final OperaErrorKind getKind() {
        return this.kind;
    }

    /* renamed from: d, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OperaError)) {
            return false;
        }
        OperaError operaError = (OperaError) other;
        return p.d(this.identifier, operaError.identifier) && p.d(this.displayName, operaError.displayName) && this.kind == operaError.kind && p.d(this.msg, operaError.msg);
    }

    public int hashCode() {
        int iHashCode = ((((this.identifier.hashCode() * 31) + this.displayName.hashCode()) * 31) + this.kind.hashCode()) * 31;
        String str = this.msg;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "OperaError(identifier=" + this.identifier + ", displayName=" + this.displayName + ", kind=" + this.kind + ", msg=" + this.msg + ")";
    }
}
