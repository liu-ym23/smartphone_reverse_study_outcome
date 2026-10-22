package d5;

import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLongArray;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h extends u {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8352a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u f8353b;

    public /* synthetic */ h(u uVar, int i10) {
        this.f8352a = i10;
        this.f8353b = uVar;
    }

    @Override // d5.u
    public final Object a(k5.a aVar) throws IOException {
        switch (this.f8352a) {
            case 0:
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.x0()) {
                    arrayList.add(Long.valueOf(((Number) this.f8353b.a(aVar)).longValue()));
                }
                aVar.K();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i10 = 0; i10 < size; i10++) {
                    atomicLongArray.set(i10, ((Long) arrayList.get(i10)).longValue());
                }
                return atomicLongArray;
            default:
                if (aVar.R0() != JsonToken.f5478l) {
                    return this.f8353b.a(aVar);
                }
                aVar.N0();
                return null;
        }
    }

    @Override // d5.u
    public final void b(k5.b bVar, Object obj) throws IOException {
        switch (this.f8352a) {
            case 0:
                AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
                bVar.o();
                int length = atomicLongArray.length();
                for (int i10 = 0; i10 < length; i10++) {
                    this.f8353b.b(bVar, Long.valueOf(atomicLongArray.get(i10)));
                }
                bVar.K();
                break;
            default:
                if (obj == null) {
                    bVar.c0();
                    break;
                } else {
                    this.f8353b.b(bVar, obj);
                    break;
                }
        }
    }
}
