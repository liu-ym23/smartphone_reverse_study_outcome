package m4;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \n2\u00020\u0001:\u0005\u000b\f\r\u000e\u000fB\u0019\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\bR\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\t\u0082\u0001\u0004\u0010\u0011\u0012\u0013¨\u0006\u0014"}, d2 = {"Lm4/a;", "", "", "code", "", "message", "<init>", "(ILjava/lang/String;)V", "I", "Ljava/lang/String;", "Companion", "c", "e", Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "Lm4/a$a;", "Lm4/a$b;", "Lm4/a$d;", "Lm4/a$e;", "business_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: m4.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC4898a {
    public static final int ERROR_AGENT_INTERNAL_ERROR = -300;
    public static final int ERROR_CLIENT_NOT_FOUND = -201;
    public static final int ERROR_NOT_INIT = -200;
    public static final int ERROR_NO_NETWORK = -100;
    public static final int ERROR_UNKNOW = -999;
    public final int code;
    public final String message;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0012"}, d2 = {"Lm4/a$a;", "Lm4/a;", "", "originMsg", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getOriginMsg", "business_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: m4.a$a, reason: collision with other inner class name and from toString */
    public static final /* data */ class AgentInternalError extends AbstractC4898a {
        private final String originMsg;

        public AgentInternalError(String str) {
            super(AbstractC4898a.ERROR_AGENT_INTERNAL_ERROR, str == null ? "Agent端 内部错误" : str, null);
            this.originMsg = str;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AgentInternalError) && p.d(this.originMsg, ((AgentInternalError) other).originMsg);
        }

        public int hashCode() {
            String str = this.originMsg;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "AgentInternalError(originMsg=" + this.originMsg + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0012"}, d2 = {"Lm4/a$b;", "Lm4/a;", "", "type", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getType", "business_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: m4.a$b, reason: from toString */
    public static final /* data */ class ClientNotFound extends AbstractC4898a {
        private final String type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ClientNotFound(String type) {
            super(AbstractC4898a.ERROR_CLIENT_NOT_FOUND, "未找到 " + type + " 类型的 Client", null);
            p.i(type, "type");
            this.type = type;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ClientNotFound) && p.d(this.type, ((ClientNotFound) other).type);
        }

        public int hashCode() {
            return this.type.hashCode();
        }

        public String toString() {
            return "ClientNotFound(type=" + this.type + ")";
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lm4/a$d;", "Lm4/a;", "<init>", "()V", "business_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: m4.a$d */
    public static final class d extends AbstractC4898a {
        public static final d INSTANCE = new d();

        public d() {
            super(-100, "当前网络不可用，请检查网络", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lm4/a$e;", "Lm4/a;", "<init>", "()V", "business_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: m4.a$e */
    public static final class e extends AbstractC4898a {
        public static final e INSTANCE = new e();

        public e() {
            super(AbstractC4898a.ERROR_NOT_INIT, "SDK 未初始化，请先调用 init()", null);
        }
    }

    public /* synthetic */ AbstractC4898a(int i10, String str, i iVar) {
        this(i10, str);
    }

    public AbstractC4898a(int i10, String str) {
        this.code = i10;
        this.message = str;
    }
}
