package S4;

import R4.t;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class e<T> {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final t<T> f5269a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final Throwable f5270b;

    private e(@Nullable t<T> tVar, @Nullable Throwable th) {
        this.f5269a = tVar;
        this.f5270b = th;
    }

    public static <T> e<T> a(Throwable th) {
        if (th != null) {
            return new e<>(null, th);
        }
        throw new NullPointerException("error == null");
    }

    public static <T> e<T> b(t<T> tVar) {
        if (tVar != null) {
            return new e<>(tVar, null);
        }
        throw new NullPointerException("response == null");
    }
}
