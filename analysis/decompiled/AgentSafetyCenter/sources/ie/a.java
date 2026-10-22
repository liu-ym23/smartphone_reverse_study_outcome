package ie;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class a implements l {

    /* renamed from: f, reason: collision with root package name */
    public static final a f5967f = new a(0);

    /* renamed from: g, reason: collision with root package name */
    public static final a f5968g = new a(1);

    /* renamed from: h, reason: collision with root package name */
    public static final a f5969h = new a(2);
    public static final a i = new a(3);

    /* renamed from: j, reason: collision with root package name */
    public static final a f5970j = new a(4);

    /* renamed from: k, reason: collision with root package name */
    public static final a f5971k = new a(5);

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5972c;

    public /* synthetic */ a(int i3) {
        this.f5972c = i3;
    }

    /* JADX WARN: Finally extract failed */
    @Override // ie.l
    public final Object convert(Object obj) {
        switch (this.f5972c) {
            case 0:
                return obj.toString();
            case 1:
                ad.h0 h0Var = (ad.h0) obj;
                try {
                    ad.g0 g0VarC = w0.c(h0Var);
                    h0Var.close();
                    return g0VarC;
                } catch (Throwable th) {
                    h0Var.close();
                    throw th;
                }
            case 2:
                return (ad.c0) obj;
            case 3:
                return (ad.h0) obj;
            case 4:
                ((ad.h0) obj).close();
                return jb.v.f6774a;
            default:
                ((ad.h0) obj).close();
                return null;
        }
    }
}
