package w0;

import xb.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f extends yb.l implements p {

    /* renamed from: c, reason: collision with root package name */
    public static final f f15108c = new f(2);

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        String str = (String) obj;
        k kVar = (k) obj2;
        if (str.length() == 0) {
            return kVar.toString();
        }
        return str + ", " + kVar;
    }
}
