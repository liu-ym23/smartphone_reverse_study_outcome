package K1;

import java.io.IOException;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
public class A implements t, J1.f {

    /* renamed from: a, reason: collision with root package name */
    public static A f4024a = new A();

    @Override // K1.t
    public void a(m mVar, Object obj, Object obj2, Type type) throws IOException {
        String str = (String) obj;
        z zVar = mVar.f4048b;
        if (str == null) {
            zVar.Y();
        } else {
            zVar.e0(str);
        }
    }

    @Override // J1.f
    public <T> T b(I1.b bVar, Type type, Object obj) {
        return (T) bVar.T0();
    }
}
