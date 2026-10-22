package p;

/* loaded from: classes.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    public static final float f8176a = ((float) 0.125d) / 18;

    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Object, java.util.List] */
    public static final boolean a(c1.f fVar, long j2) {
        Object obj;
        ?? r62 = fVar.f1795a;
        int size = r62.size();
        boolean z4 = false;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                obj = null;
                break;
            }
            obj = r62.get(i2);
            if (c1.k.a(((c1.l) obj).f1804a, j2)) {
                break;
            }
            i2++;
        }
        c1.l lVar = (c1.l) obj;
        if (lVar != null && lVar.f1807d) {
            z4 = true;
        }
        return true ^ z4;
    }
}
