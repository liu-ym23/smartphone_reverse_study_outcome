package f1;

import j0.i;
import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public abstract class b extends CancellationException {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f3356f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(String str, int i2) {
        super(str);
        this.f3356f = i2;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        switch (this.f3356f) {
            case 0:
                setStackTrace(c.f3357a);
                break;
            default:
                setStackTrace(i.f5084a);
                break;
        }
        return this;
    }
}
