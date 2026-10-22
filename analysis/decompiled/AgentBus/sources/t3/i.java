package t3;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList f9716a = new CopyOnWriteArrayList();

    public static z3.c a(String str) throws GeneralSecurityException {
        boolean zStartsWith;
        Iterator it = f9716a.iterator();
        while (it.hasNext()) {
            z3.c cVar = (z3.c) it.next();
            synchronized (cVar) {
                zStartsWith = str.toLowerCase(Locale.US).startsWith("android-keystore://");
            }
            if (zStartsWith) {
                return cVar;
            }
        }
        throw new GeneralSecurityException(a1.a.w("No KMS client does support: ", str));
    }
}
