package m3;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class j {

    /* renamed from: d, reason: collision with root package name */
    public static final ArrayList f13622d = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    public Object f13623a;

    /* renamed from: b, reason: collision with root package name */
    public o f13624b;

    /* renamed from: c, reason: collision with root package name */
    public j f13625c;

    public static j a(Object obj, o oVar) {
        ArrayList arrayList = f13622d;
        synchronized (arrayList) {
            try {
                int size = arrayList.size();
                if (size <= 0) {
                    j jVar = new j();
                    jVar.f13623a = obj;
                    jVar.f13624b = oVar;
                    return jVar;
                }
                j jVar2 = (j) arrayList.remove(size - 1);
                jVar2.f13623a = obj;
                jVar2.f13624b = oVar;
                jVar2.f13625c = null;
                return jVar2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
