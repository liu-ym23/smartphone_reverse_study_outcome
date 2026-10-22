package f2;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    public static final t1.f f2578a = new t1.f(13);

    public static void a(a4.d dVar) throws GeneralSecurityException {
        y1.f fVar;
        ArrayList arrayList = new ArrayList();
        i2.a aVar = i2.a.f3137b;
        Iterator it = ((ConcurrentMap) dVar.f96b).values().iterator();
        while (it.hasNext()) {
            for (y1.k kVar : (List) it.next()) {
                int iOrdinal = kVar.d.ordinal();
                if (iOrdinal == 1) {
                    fVar = y1.f.f6315c;
                } else if (iOrdinal == 2) {
                    fVar = y1.f.d;
                } else {
                    if (iOrdinal != 3) {
                        throw new IllegalStateException("Unknown key status");
                    }
                    fVar = y1.f.f6316e;
                }
                int i8 = kVar.f6326f;
                String strSubstring = kVar.f6327g;
                if (strSubstring.startsWith("type.googleapis.com/google.crypto.")) {
                    strSubstring = strSubstring.substring(34);
                }
                arrayList.add(new i2.b(fVar, i8, strSubstring, kVar.f6325e.name()));
            }
        }
        y1.k kVar2 = (y1.k) dVar.f97c;
        Integer numValueOf = kVar2 != null ? Integer.valueOf(kVar2.f6326f) : null;
        if (numValueOf != null) {
            try {
                int iIntValue = numValueOf.intValue();
                int size = arrayList.size();
                int i9 = 0;
                while (i9 < size) {
                    Object obj = arrayList.get(i9);
                    i9++;
                    if (((i2.b) obj).f3140b == iIntValue) {
                    }
                }
                throw new GeneralSecurityException("primary key ID is not present in entries");
            } catch (GeneralSecurityException e9) {
                throw new IllegalStateException(e9);
            }
        }
        Collections.unmodifiableList(arrayList);
    }
}
