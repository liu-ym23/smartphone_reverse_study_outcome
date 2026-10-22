package j4;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010$\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR$\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR$\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR0\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lj4/b;", "", "<init>", "()V", "", "response_mode", "Ljava/lang/String;", "getResponse_mode", "()Ljava/lang/String;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)V", "conversation_id", "getConversation_id", Const.INTENT_KEY_APIKEY, "query", "getQuery", "c", "user", "getUser", "e", "", "inputs", "Ljava/util/Map;", "getInputs", "()Ljava/util/Map;", Const.INTENT_KEY_PKGNAME, "(Ljava/util/Map;)V", "Companion", "protocol_dify_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Map<String, String> inputs;
    private String response_mode;
    private String user;
    private String conversation_id = "";
    private String query = "";

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\u000b\u001a\u00020\n2\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lj4/b$a;", "", "<init>", "()V", "", "", "input", "query", "conversationId", "userId", "Lj4/b;", Const.INTENT_KEY_APIKEY, "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lj4/b;", "protocol_dify_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: j4.b$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final b a(Map<String, String> input, String query, String conversationId, String userId) {
            p.i(query, "query");
            p.i(conversationId, "conversationId");
            p.i(userId, "userId");
            b bVar = new b();
            bVar.b(input);
            bVar.c(query);
            bVar.e(userId);
            bVar.d("streaming");
            bVar.a(conversationId);
            return bVar;
        }

        public Companion() {
        }
    }

    public final void a(String str) {
        this.conversation_id = str;
    }

    public final void b(Map<String, String> map) {
        this.inputs = map;
    }

    public final void c(String str) {
        this.query = str;
    }

    public final void d(String str) {
        this.response_mode = str;
    }

    public final void e(String str) {
        this.user = str;
    }
}
