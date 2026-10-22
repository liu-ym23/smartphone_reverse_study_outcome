package cc2;

/* JADX INFO: loaded from: classes9.dex */
public abstract class l extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23203a;

    public static final class a extends l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f23204b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f23205c = null;

        static {
            f23205c = new a();
            f23204b = "Hiboard";
        }

        public a() {
        }

        @Override // cc2.o
        public final String b() {
            return f23204b;
        }
    }

    public static final class b extends l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f23206b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f23207c = null;

        static {
            f23207c = new b();
            f23206b = "Keyboard";
        }

        public b() {
        }

        @Override // cc2.o
        public final String b() {
            return f23206b;
        }
    }

    public static final class c extends l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f23208b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f23209c = null;

        static {
            f23209c = new c();
            f23208b = "PublicScreenStretch";
        }

        public c() {
        }

        @Override // cc2.o
        public final String b() {
            return f23208b;
        }
    }

    public l() {
        this.f23203a = "PortraitDanmaku";
    }

    @Override // cc2.o
    public final String a() {
        return this.f23203a;
    }
}
