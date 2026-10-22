package s;

/* renamed from: s.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0833c extends Throwable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14128a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0833c(int i4) {
        super("Failure occurred while trying to finish a future.");
        this.f14128a = i4;
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        switch (this.f14128a) {
            case 0:
                synchronized (this) {
                }
                return this;
            default:
                synchronized (this) {
                }
                return this;
        }
    }
}
