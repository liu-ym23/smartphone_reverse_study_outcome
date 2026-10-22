package ea;

import java.util.Arrays;
import kotlin.jvm.internal.p;

/* renamed from: ea.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4019c extends AbstractC4017a {

    /* renamed from: h, reason: collision with root package name */
    public static final a f32403h = new a(null);

    /* renamed from: i, reason: collision with root package name */
    public static final C4019c f32404i;

    /* renamed from: j, reason: collision with root package name */
    public static final C4019c f32405j;

    /* renamed from: k, reason: collision with root package name */
    public static final C4019c f32406k;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f32407g;

    /* renamed from: ea.c$a */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    static {
        C4019c c4019c = new C4019c(2, 2, 0);
        f32404i = c4019c;
        f32405j = c4019c.m();
        f32406k = new C4019c(new int[0]);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4019c(int[] versionArray, boolean z10) {
        super(Arrays.copyOf(versionArray, versionArray.length));
        p.i(versionArray, "versionArray");
        this.f32407g = z10;
    }

    public final boolean h(C4019c metadataVersionFromLanguageVersion) {
        p.i(metadataVersionFromLanguageVersion, "metadataVersionFromLanguageVersion");
        return i(metadataVersionFromLanguageVersion.k(this.f32407g));
    }

    public final boolean i(C4019c c4019c) {
        if ((a() == 1 && b() == 0) || a() == 0) {
            return false;
        }
        return !l(c4019c);
    }

    public final boolean j() {
        return this.f32407g;
    }

    public final C4019c k(boolean z10) {
        C4019c c4019c = z10 ? f32404i : f32405j;
        return c4019c.l(this) ? c4019c : this;
    }

    public final boolean l(C4019c c4019c) {
        if (a() > c4019c.a()) {
            return true;
        }
        return a() >= c4019c.a() && b() > c4019c.b();
    }

    public final C4019c m() {
        return (a() == 1 && b() == 9) ? new C4019c(2, 0, 0) : new C4019c(a(), b() + 1, 0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C4019c(int... numbers) {
        this(numbers, false);
        p.i(numbers, "numbers");
    }
}
