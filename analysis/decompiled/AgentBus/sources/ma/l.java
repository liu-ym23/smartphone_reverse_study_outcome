package ma;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final class l extends CancellationException {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f6502f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(String str, int i2) {
        super(str);
        this.f6502f = i2;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        switch (this.f6502f) {
            case 0:
                setStackTrace(new StackTraceElement[0]);
                break;
            case 1:
                setStackTrace(new StackTraceElement[0]);
                break;
            default:
                setStackTrace(new StackTraceElement[0]);
                break;
        }
        return this;
    }
}
