package R4;

import java.util.Objects;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public class j extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    private final int f5022a;

    /* renamed from: b, reason: collision with root package name */
    private final String f5023b;

    /* renamed from: c, reason: collision with root package name */
    private final transient t<?> f5024c;

    public j(t<?> tVar) {
        super(a(tVar));
        this.f5022a = tVar.b();
        this.f5023b = tVar.f();
        this.f5024c = tVar;
    }

    private static String a(t<?> tVar) {
        Objects.requireNonNull(tVar, "response == null");
        return "HTTP " + tVar.b() + " " + tVar.f();
    }

    @Nullable
    public t<?> b() {
        return this.f5024c;
    }
}
