package n6;

import java.io.Closeable;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class w implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public static final v f4162a;

    static {
        c7.i iVar = c7.i.d;
        kotlin.jvm.internal.p.e(iVar, "<this>");
        c7.f fVar = new c7.f();
        fVar.u(iVar);
        f4162a = new v(iVar.f1165a.length, fVar);
    }

    public abstract long a();

    public abstract o b();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        o6.d.a(e());
    }

    public abstract c7.h e();
}
