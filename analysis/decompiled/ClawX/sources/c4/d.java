package c4;

import a6.c1;
import io.ktor.utils.io.h0;
import io.ktor.utils.io.p;
import io.ktor.utils.io.q0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.y;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f1075b = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "content");

    /* renamed from: a, reason: collision with root package name */
    public final p f1076a;
    private volatile /* synthetic */ Object content;

    public d(p origin) {
        kotlin.jvm.internal.p.e(origin, "origin");
        this.f1076a = origin;
        this.content = null;
    }

    public final p a() throws Throwable {
        if (this.f1076a.a() != null) {
            Throwable thA = this.f1076a.a();
            kotlin.jvm.internal.p.b(thA);
            throw thA;
        }
        y yVar = new y();
        Object obj = this.content;
        yVar.f3686a = obj;
        f5.c cVar = null;
        if (obj == null) {
            b bVar = new b(this);
            yVar.f3686a = bVar;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1075b;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, bVar)) {
                if (atomicReferenceFieldUpdater.get(this) != null) {
                    Object obj2 = this.content;
                    kotlin.jvm.internal.p.b(obj2);
                    yVar.f3686a = obj2;
                }
            }
            return ((q0) ((b) yVar.f3686a).f1070b.getValue()).f3233a;
        }
        return h0.v(c1.f144a, null, new c(yVar, 0, cVar), 3).f3233a;
    }
}
