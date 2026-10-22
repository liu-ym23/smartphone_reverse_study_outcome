package C4;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final C7.f f297a = kotlin.a.a(new Ba.a(2));
    public static final C7.f b = kotlin.a.a(new Ba.a(3));
    public static final C7.f c = kotlin.a.a(new Ba.a(4));
    public static final C7.f d = kotlin.a.a(new Ba.a(5));
    public static final C7.f e = kotlin.a.a(new Ba.a(6));

    public static g a(String str) {
        Object obj = null;
        if (str == null || str.length() == 0) {
            return null;
        }
        Iterator it = ((List) e.getF4884a()).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (k.b(((g) next).f296a, str)) {
                obj = next;
                break;
            }
        }
        return (g) obj;
    }
}
