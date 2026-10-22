package y1;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList f6321a = new CopyOnWriteArrayList();

    public static e2.c a(String str) throws GeneralSecurityException {
        boolean zStartsWith;
        Iterator it = f6321a.iterator();
        while (it.hasNext()) {
            e2.c cVar = (e2.c) it.next();
            synchronized (cVar) {
                zStartsWith = str.toLowerCase(Locale.US).startsWith("android-keystore://");
            }
            if (zStartsWith) {
                return cVar;
            }
        }
        throw new GeneralSecurityException(m0.f.c("No KMS client does support: ", str));
    }
}
