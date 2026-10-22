package L4;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0007\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0001\u0004\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"LL4/g;", "", "<init>", "()V", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_UMID, "c", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "LL4/g$a;", "LL4/g$b;", "LL4/g$c;", "LL4/g$d;", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class g {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0007¨\u0006\u0014"}, d2 = {"LL4/g$a;", "LL4/g;", "", "name", "<init>", "(Ljava/lang/String;)V", "component1", "()Ljava/lang/String;", ChatTracker.CLICK_COPY, "(Ljava/lang/String;)LL4/g$a;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class a extends g {
        private final String name;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String name) {
            super(null);
            kotlin.jvm.internal.p.i(name, "name");
            this.name = name;
        }

        public static /* synthetic */ a copy$default(a aVar, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = aVar.name;
            }
            return aVar.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final a copy(String name) {
            kotlin.jvm.internal.p.i(name, "name");
            return new a(name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof a) && kotlin.jvm.internal.p.d(this.name, ((a) other).name);
        }

        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            return this.name.hashCode();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007HÖ\u0003¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"LL4/g$b;", "LL4/g;", "<init>", "()V", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class b extends g {
        public static final b INSTANCE = new b();

        private b() {
            super(null);
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof b);
        }

        public int hashCode() {
            return -234191153;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007HÖ\u0003¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"LL4/g$c;", "LL4/g;", "<init>", "()V", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class c extends g {
        public static final c INSTANCE = new c();

        private c() {
            super(null);
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof c);
        }

        public int hashCode() {
            return -234191152;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007HÖ\u0003¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"LL4/g$d;", "LL4/g;", "<init>", "()V", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class d extends g {
        public static final d INSTANCE = new d();

        private d() {
            super(null);
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof d);
        }

        public int hashCode() {
            return -234191146;
        }
    }

    public /* synthetic */ g(kotlin.jvm.internal.i iVar) {
        this();
    }

    public final String toString() {
        if (kotlin.jvm.internal.p.d(this, d.INSTANCE)) {
            return "AgentSize.S";
        }
        if (kotlin.jvm.internal.p.d(this, c.INSTANCE)) {
            return "AgentSize.M";
        }
        if (kotlin.jvm.internal.p.d(this, b.INSTANCE)) {
            return "AgentSize.L";
        }
        if (!(this instanceof a)) {
            throw new NoWhenBranchMatchedException();
        }
        return "AgentSize.Custom(" + ((a) this).getName() + ")";
    }

    private g() {
    }
}
