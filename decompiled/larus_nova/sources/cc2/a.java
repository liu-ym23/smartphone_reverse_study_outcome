package cc2;

/* JADX INFO: loaded from: classes9.dex */
public abstract class a extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23133a;

    /* JADX INFO: renamed from: cc2.a$a, reason: collision with other inner class name */
    public static final class C0427a extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f23134b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final C0427a f23135c = null;

        static {
            f23135c = new C0427a();
            f23134b = "ChatChannelEvent";
        }

        public C0427a() {
        }

        @Override // cc2.o
        public final String b() {
            return f23134b;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f23136b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f23137c = null;

        static {
            f23137c = new b();
            f23136b = "LinkMode";
        }

        public b() {
        }

        @Override // cc2.o
        public final String b() {
            return f23136b;
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f23138b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f23139c = null;

        static {
            f23139c = new c();
            f23138b = "ShowAIClone";
        }

        public c() {
        }

        @Override // cc2.o
        public final String b() {
            return f23138b;
        }
    }

    public a() {
        this.f23133a = "ai_entrance";
    }

    @Override // cc2.o
    public final String a() {
        return this.f23133a;
    }
}
