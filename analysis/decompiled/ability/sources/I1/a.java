package I1;

import M0.h;
import java.util.concurrent.ScheduledFuture;

/* loaded from: classes2.dex */
public final class a {
    public static volatile a f;

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f791a;
    public volatile boolean b;
    public volatile boolean c;
    public h d;
    public ScheduledFuture e;

    public static a a() {
        if (f == null) {
            synchronized (a.class) {
                try {
                    if (f == null) {
                        a aVar = new a();
                        aVar.f791a = false;
                        aVar.b = false;
                        aVar.c = false;
                        f = aVar;
                    }
                } finally {
                }
            }
        }
        return f;
    }
}
