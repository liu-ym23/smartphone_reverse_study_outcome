package L4;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0007\u0011\u0012\u0013\u0014\u0015\u0016\u0017B\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0086\u0002¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0007\u0082\u0001\u0007\u0018\u0019\u001a\u001b\u001c\u001d\u001e¨\u0006\u001f"}, d2 = {"LL4/f;", "", "", "key", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/lang/String;", "getKey", Const.INTENT_KEY_UMID, "c", Const.INTENT_KEY_BACKGROUND_COMMAND, "f", Const.INTENT_KEY_PKGNAME, "e", Const.INTENT_KEY_APIKEY, "LL4/f$a;", "LL4/f$b;", "LL4/f$c;", "LL4/f$d;", "LL4/f$e;", "LL4/f$f;", "LL4/f$g;", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: L4.f, reason: from toString */
/* loaded from: classes2.dex */
public abstract class AgentPlace {
    private final String key;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"LL4/f$a;", "LL4/f;", "<init>", "()V", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: L4.f$a */
    public static final /* data */ class a extends AgentPlace {
        public static final a INSTANCE = new a();

        private a() {
            super("agent_space", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"LL4/f$b;", "LL4/f;", "<init>", "()V", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: L4.f$b */
    public static final /* data */ class b extends AgentPlace {
        public static final b INSTANCE = new b();

        private b() {
            super("chat_view", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"LL4/f$c;", "LL4/f;", "<init>", "()V", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: L4.f$c */
    public static final /* data */ class c extends AgentPlace {
        public static final c INSTANCE = new c();

        private c() {
            super("launcher", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"LL4/f$d;", "LL4/f;", "<init>", "()V", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: L4.f$d */
    public static final /* data */ class d extends AgentPlace {
        public static final d INSTANCE = new d();

        private d() {
            super("none", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"LL4/f$e;", "LL4/f;", "<init>", "()V", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: L4.f$e */
    public static final /* data */ class e extends AgentPlace {
        public static final e INSTANCE = new e();

        private e() {
            super("oobe", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"LL4/f$f;", "LL4/f;", "<init>", "()V", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: L4.f$f, reason: collision with other inner class name */
    public static final /* data */ class C0071f extends AgentPlace {
        public static final C0071f INSTANCE = new C0071f();

        private C0071f() {
            super(com.stepos.ailauncher.chat.trace.c.POSITION_REPAIR, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"LL4/f$g;", "LL4/f;", "<init>", "()V", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: L4.f$g */
    public static final /* data */ class g extends AgentPlace {
        public static final g INSTANCE = new g();

        private g() {
            super("skill_market", null);
        }
    }

    public /* synthetic */ AgentPlace(String str, kotlin.jvm.internal.i iVar) {
        this(str);
    }

    public final boolean equals(Object other) {
        return (other instanceof AgentPlace) && kotlin.jvm.internal.p.d(((AgentPlace) other).key, this.key);
    }

    public final String getKey() {
        return this.key;
    }

    public final int hashCode() {
        return this.key.hashCode();
    }

    public final String toString() {
        return "AgentPlace(" + this.key + ")";
    }

    private AgentPlace(String str) {
        this.key = str;
    }
}
