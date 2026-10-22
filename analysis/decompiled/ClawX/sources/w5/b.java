package w5;

import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b extends c5.c {

    /* renamed from: c, reason: collision with root package name */
    public final Iterator f6203c;
    public final com.stepos.stepclaw.gateway.d d;

    /* renamed from: e, reason: collision with root package name */
    public final HashSet f6204e;

    public b(Iterator source, com.stepos.stepclaw.gateway.d dVar) {
        p.e(source, "source");
        this.f6203c = source;
        this.d = dVar;
        this.f6204e = new HashSet();
    }

    @Override // c5.c
    public final void a() {
        Object next;
        do {
            Iterator it = this.f6203c;
            if (!it.hasNext()) {
                this.f1079a = 2;
                return;
            } else {
                next = it.next();
            }
        } while (!this.f6204e.add(this.d.invoke(next)));
        this.f1080b = next;
        this.f1079a = 1;
    }
}
