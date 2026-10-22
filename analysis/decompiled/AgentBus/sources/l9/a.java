package l9;

import d7.t;
import d7.z;
import i8.r0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class a implements ea.a {

    /* renamed from: g, reason: collision with root package name */
    public static final a f5889g = new a(0);

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5890f;

    public /* synthetic */ a(int i2) {
        this.f5890f = i2;
    }

    @Override // ea.a
    public final Iterable b(Object obj) {
        switch (this.f5890f) {
            case 0:
                int i2 = d.f5893a;
                Collection collectionR = ((r0) obj).r();
                ArrayList arrayList = new ArrayList(t.A0(collectionR, 10));
                Iterator it = ((ArrayList) collectionR).iterator();
                while (it.hasNext()) {
                    arrayList.add(((r0) it.next()).a());
                }
                return arrayList;
            default:
                f8.c cVar = (f8.c) obj;
                Collection collectionR2 = cVar != null ? cVar.r() : null;
                return collectionR2 == null ? z.f2978f : collectionR2;
        }
    }
}
