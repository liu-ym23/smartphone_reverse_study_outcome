package o8;

/* loaded from: classes.dex */
public final class f extends f0 {

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f7813l = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public static final f8.t a(f8.t tVar) {
        q7.k.e(tVar, "functionDescriptor");
        e9.f name = ((i8.m) tVar).getName();
        q7.k.d(name, "functionDescriptor.name");
        if (b(name)) {
            return (f8.t) l9.d.b(tVar, e.f7799h);
        }
        return null;
    }

    public static boolean b(e9.f fVar) {
        q7.k.e(fVar, "<this>");
        return f0.f7818e.contains(fVar);
    }
}
