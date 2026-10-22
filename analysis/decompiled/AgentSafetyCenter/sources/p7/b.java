package p7;

import java.lang.reflect.Array;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends m7.n {

    /* renamed from: c, reason: collision with root package name */
    public static final a f9832c = new a();

    /* renamed from: a, reason: collision with root package name */
    public Class f9833a;

    /* renamed from: b, reason: collision with root package name */
    public r f9834b;

    @Override // m7.n
    public final Object read(u7.a aVar) throws ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        Class cls = this.f9833a;
        if (aVar.Y() == u7.b.f14169m) {
            aVar.U();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.d();
        while (aVar.H()) {
            arrayList.add(this.f9834b.f9894c.read(aVar));
        }
        aVar.n();
        int size = arrayList.size();
        if (!cls.isPrimitive()) {
            return arrayList.toArray((Object[]) Array.newInstance((Class<?>) cls, size));
        }
        Object objNewInstance = Array.newInstance((Class<?>) cls, size);
        for (int i = 0; i < size; i++) {
            Array.set(objNewInstance, i, arrayList.get(i));
        }
        return objNewInstance;
    }

    @Override // m7.n
    public final void write(u7.c cVar, Object obj) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (obj == null) {
            cVar.C();
            return;
        }
        cVar.e();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.f9834b.write(cVar, Array.get(obj, i));
        }
        cVar.n();
    }
}
