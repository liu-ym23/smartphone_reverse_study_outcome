package bk5;

/* JADX INFO: loaded from: classes18.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19364a;

    public static final class a extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f19365b = null;

        static {
            f19365b = new a();
        }

        public a() {
            super("default");
        }
    }

    public static final class b extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f19366b = null;

        static {
            f19366b = new b();
        }

        public b() {
            super("document");
        }
    }

    public static final class c extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f19367b = null;

        static {
            f19367b = new c();
        }

        public c() {
            super("drive");
        }
    }

    public final String getType() {
        return this.f19364a;
    }

    public final String toString() {
        return this.f19364a;
    }

    public e(String r100) {
        this.f19364a = r100;
    }
}
