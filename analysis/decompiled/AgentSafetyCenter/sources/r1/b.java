package r1;

import java.util.concurrent.CancellationException;
import s0.h;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class b extends CancellationException {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10364c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(String str, int i) {
        super(str);
        this.f10364c = i;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        switch (this.f10364c) {
            case 0:
                setStackTrace(c.f10365a);
                break;
            default:
                setStackTrace(h.f11182a);
                break;
        }
        return this;
    }
}
