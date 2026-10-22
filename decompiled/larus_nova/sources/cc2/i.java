package cc2;

/* JADX INFO: loaded from: classes9.dex */
public abstract class i extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23186a;

    public static final class a extends i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f23187b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f23188c = null;

        static {
            f23188c = new a();
            f23187b = "LandscapeInteractLayerHide";
        }

        public a() {
        }

        @Override // cc2.o
        public final String b() {
            return f23187b;
        }
    }

    public static final class b extends i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f23189b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f23190c = null;

        static {
            f23190c = new b();
            f23189b = "PanelCover";
        }

        public b() {
        }

        @Override // cc2.o
        public final String b() {
            return f23189b;
        }
    }

    public static final class c extends i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f23191b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f23192c = null;

        static {
            f23192c = new c();
            f23191b = "RightBottomCardShow";
        }

        public c() {
        }

        @Override // cc2.o
        public final String b() {
            return f23191b;
        }
    }

    public i() {
        this.f23186a = "FlowLike";
    }

    @Override // cc2.o
    public final String a() {
        return this.f23186a;
    }
}
