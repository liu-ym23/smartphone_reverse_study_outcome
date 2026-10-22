package cc2;

/* JADX INFO: loaded from: classes9.dex */
public abstract class k extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23198a;

    public static final class a extends k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f23199b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f23200c = null;

        static {
            f23200c = new a();
            f23199b = "AnswerQuestionContainer";
        }

        public a() {
        }

        @Override // cc2.o
        public final String b() {
            return f23199b;
        }
    }

    public static final class b extends k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f23201b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f23202c = null;

        static {
            f23202c = new b();
            f23201b = "PublicScreenStretch";
        }

        public b() {
        }

        @Override // cc2.o
        public final String b() {
            return f23201b;
        }
    }

    public k() {
        this.f23198a = "PinContainer";
    }

    @Override // cc2.o
    public final String a() {
        return this.f23198a;
    }
}
