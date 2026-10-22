package cc.dd.dd.cc.dd.dd;

import java.io.Closeable;
import java.io.IOException;
import java.util.EventObject;

/* loaded from: classes2.dex */
public final class c extends EventObject {

    /* renamed from: a, reason: collision with root package name */
    public final long f2133a;
    public final Exception b;

    public c(Closeable closeable, long j5, IOException iOException) {
        super(closeable);
        this.f2133a = j5;
        this.b = iOException;
    }
}
