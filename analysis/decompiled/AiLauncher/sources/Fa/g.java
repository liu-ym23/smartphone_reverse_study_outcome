package Fa;

/* loaded from: classes5.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f2637a;

    public static final class a extends g {

        /* renamed from: b, reason: collision with root package name */
        public static final a f2638b = new a();

        public a() {
            super(false, null);
        }
    }

    public static final class b extends g {

        /* renamed from: b, reason: collision with root package name */
        public final String f2639b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String error) {
            super(false, null);
            kotlin.jvm.internal.p.i(error, "error");
            this.f2639b = error;
        }
    }

    public static final class c extends g {

        /* renamed from: b, reason: collision with root package name */
        public static final c f2640b = new c();

        public c() {
            super(true, null);
        }
    }

    public /* synthetic */ g(boolean z10, kotlin.jvm.internal.i iVar) {
        this(z10);
    }

    public final boolean a() {
        return this.f2637a;
    }

    public g(boolean z10) {
        this.f2637a = z10;
    }
}
