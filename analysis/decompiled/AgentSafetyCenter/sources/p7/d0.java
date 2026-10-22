package p7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class d0 extends m7.n {
    @Override // m7.n
    public final Object read(u7.a aVar) {
        ArrayList arrayList = new ArrayList();
        aVar.d();
        while (aVar.H()) {
            try {
                arrayList.add(Integer.valueOf(aVar.Q()));
            } catch (NumberFormatException e10) {
                throw new m7.h(e10);
            }
        }
        aVar.n();
        int size = arrayList.size();
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
        for (int i = 0; i < size; i++) {
            atomicIntegerArray.set(i, ((Integer) arrayList.get(i)).intValue());
        }
        return atomicIntegerArray;
    }

    @Override // m7.n
    public final void write(u7.c cVar, Object obj) throws IOException {
        cVar.e();
        int length = ((AtomicIntegerArray) obj).length();
        for (int i = 0; i < length; i++) {
            cVar.P(r5.get(i));
        }
        cVar.n();
    }
}
