package u1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d implements t1.h {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f13750c;

    public static final int a(int i, long j10) {
        int i3 = y1.f13975b;
        return ((int) (j10 >> (i * 15))) & 32767;
    }

    public int b() {
        switch (this.f13750c) {
            case 1:
                return 16;
            default:
                return 8;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [xb.a, yb.l] */
    @Override // t1.h
    public Object d(t1.i iVar) {
        return iVar.f13135a.invoke();
    }
}
