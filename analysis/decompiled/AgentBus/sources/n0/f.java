package n0;

/* loaded from: classes.dex */
public final class f extends q7.m implements p7.n {

    /* renamed from: g, reason: collision with root package name */
    public static final f f6791g = new f(2);

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        String str = (String) obj;
        k kVar = (k) obj2;
        if (str.length() == 0) {
            return kVar.toString();
        }
        return str + ", " + kVar;
    }
}
