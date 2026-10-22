package i4;

import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.p;
import t1.f;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final f f3146a;

    /* renamed from: b, reason: collision with root package name */
    public static final f f3147b;

    /* renamed from: c, reason: collision with root package name */
    public static final f f3148c;
    public static final f d;

    /* renamed from: e, reason: collision with root package name */
    public static final f f3149e;

    static {
        int i8 = 17;
        f3146a = new f(i8);
        f3147b = new f(i8);
        f3148c = new f(i8);
        d = new f(i8);
        f3149e = new f(i8);
    }

    public static final Throwable a(Throwable th) {
        p.e(th, "<this>");
        Throwable cause = th;
        while (true) {
            if (!(cause instanceof CancellationException)) {
                if (cause == null) {
                    break;
                }
                return cause;
            }
            CancellationException cancellationException = (CancellationException) cause;
            if (cause.equals(cancellationException.getCause())) {
                break;
            }
            cause = cancellationException.getCause();
        }
        return th;
    }
}
