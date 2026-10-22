package W3;

import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"LW3/b;", "", "<init>", "()V", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "LW3/b$a;", "LW3/b$b;", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class b {

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\t¨\u0006\u0015"}, d2 = {"LW3/b$a;", "LW3/b;", "", "code", "", "message", "<init>", "(ILjava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "I", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: W3.b$a, reason: from toString */
    public static final /* data */ class Failure extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final int code;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final String message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failure(int i10, String message) {
            super(null);
            p.i(message, "message");
            this.code = i10;
            this.message = message;
        }

        /* renamed from: a, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        /* renamed from: b, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Failure)) {
                return false;
            }
            Failure failure = (Failure) other;
            return this.code == failure.code && p.d(this.message, failure.message);
        }

        public int hashCode() {
            return (Integer.hashCode(this.code) * 31) + this.message.hashCode();
        }

        public String toString() {
            return "Failure(code=" + this.code + ", message=" + this.message + ")";
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0017\u001a\u0004\b\u0013\u0010\n¨\u0006\u0018"}, d2 = {"LW3/b$b;", "LW3/b;", "", "LW3/a;", "nodes", "", "extra", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", "Ljava/lang/String;", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: W3.b$b, reason: collision with other inner class name and from toString */
    public static final /* data */ class Success extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final List<EditTextNode> nodes;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final String extra;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(List<EditTextNode> nodes, String extra) {
            super(null);
            p.i(nodes, "nodes");
            p.i(extra, "extra");
            this.nodes = nodes;
            this.extra = extra;
        }

        /* renamed from: a, reason: from getter */
        public final String getExtra() {
            return this.extra;
        }

        public final List<EditTextNode> b() {
            return this.nodes;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Success)) {
                return false;
            }
            Success success = (Success) other;
            return p.d(this.nodes, success.nodes) && p.d(this.extra, success.extra);
        }

        public int hashCode() {
            return (this.nodes.hashCode() * 31) + this.extra.hashCode();
        }

        public String toString() {
            return "Success(nodes=" + this.nodes + ", extra=" + this.extra + ")";
        }
    }

    public /* synthetic */ b(i iVar) {
        this();
    }

    public b() {
    }
}
