package m7;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8247a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ n f8248b;

    public /* synthetic */ c(int i) {
        this.f8247a = i;
    }

    @Override // m7.n
    public final Object read(u7.a aVar) {
        switch (this.f8247a) {
            case 0:
                return new AtomicLong(((Number) this.f8248b.read(aVar)).longValue());
            default:
                ArrayList arrayList = new ArrayList();
                aVar.d();
                while (aVar.H()) {
                    arrayList.add(Long.valueOf(((Number) this.f8248b.read(aVar)).longValue()));
                }
                aVar.n();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i = 0; i < size; i++) {
                    atomicLongArray.set(i, ((Long) arrayList.get(i)).longValue());
                }
                return atomicLongArray;
        }
    }

    @Override // m7.n
    public final void write(u7.c cVar, Object obj) {
        switch (this.f8247a) {
            case 0:
                this.f8248b.write(cVar, Long.valueOf(((AtomicLong) obj).get()));
                break;
            default:
                AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
                cVar.e();
                int length = atomicLongArray.length();
                for (int i = 0; i < length; i++) {
                    this.f8248b.write(cVar, Long.valueOf(atomicLongArray.get(i)));
                }
                cVar.n();
                break;
        }
    }
}
