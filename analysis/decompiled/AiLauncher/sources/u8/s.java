package u8;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class s implements r {

    /* renamed from: a, reason: collision with root package name */
    public final Map<p, Object> f42506a = new HashMap(3);

    @Override // u8.r
    public <T> void a(p<T> pVar, T t10) {
        if (t10 == null) {
            this.f42506a.remove(pVar);
        } else {
            this.f42506a.put(pVar, t10);
        }
    }

    @Override // u8.r
    public <T> T b(p<T> pVar) {
        return (T) this.f42506a.get(pVar);
    }

    @Override // u8.r
    public <T> T c(p<T> pVar, T t10) {
        T t11 = (T) this.f42506a.get(pVar);
        return t11 != null ? t11 : t10;
    }
}
