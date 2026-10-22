package a4;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    public static final s9.d f198a = new s9.d(1);

    public static void a(i5.l lVar) {
        t3.f fVar;
        ArrayList arrayList = new ArrayList();
        d4.a aVar = d4.a.f2836b;
        Iterator it = ((ConcurrentMap) lVar.f4687g).values().iterator();
        while (it.hasNext()) {
            for (t3.k kVar : (List) it.next()) {
                int iOrdinal = kVar.f9720d.ordinal();
                if (iOrdinal == 1) {
                    fVar = t3.f.f9709c;
                } else if (iOrdinal == 2) {
                    fVar = t3.f.f9710d;
                } else {
                    if (iOrdinal != 3) {
                        throw new IllegalStateException("Unknown key status");
                    }
                    fVar = t3.f.f9711e;
                }
                int i2 = kVar.f9722f;
                String strSubstring = kVar.f9723g;
                if (strSubstring.startsWith("type.googleapis.com/google.crypto.")) {
                    strSubstring = strSubstring.substring(34);
                }
                arrayList.add(new d4.b(fVar, i2, strSubstring, kVar.f9721e.name()));
            }
        }
        t3.k kVar2 = (t3.k) lVar.f4688h;
        Integer numValueOf = kVar2 != null ? Integer.valueOf(kVar2.f9722f) : null;
        if (numValueOf != null) {
            try {
                int iIntValue = numValueOf.intValue();
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    if (((d4.b) it2.next()).f2839b == iIntValue) {
                    }
                }
                throw new GeneralSecurityException("primary key ID is not present in entries");
            } catch (GeneralSecurityException e10) {
                throw new IllegalStateException(e10);
            }
        }
        Collections.unmodifiableList(arrayList);
    }
}
