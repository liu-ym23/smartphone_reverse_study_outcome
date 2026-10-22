package K1;

import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
public final class f implements t, J1.f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f4035a = new f();

    @Override // K1.t
    public void a(m mVar, Object obj, Object obj2, Type type) throws IOException {
        z zVar = mVar.f4048b;
        Boolean bool = (Boolean) obj;
        if (bool == null) {
            if ((zVar.f4092c & SerializerFeature.WriteNullBooleanAsFalse.mask) != 0) {
                zVar.write("false");
                return;
            } else {
                zVar.Y();
                return;
            }
        }
        if (bool.booleanValue()) {
            zVar.write("true");
        } else {
            zVar.write("false");
        }
    }

    @Override // J1.f
    public <T> T b(I1.b bVar, Type type, Object obj) {
        I1.d dVar = bVar.f3258e;
        int iA0 = dVar.a0();
        if (iA0 == 6) {
            dVar.t(16);
            return (T) Boolean.TRUE;
        }
        if (iA0 == 7) {
            dVar.t(16);
            return (T) Boolean.FALSE;
        }
        if (iA0 == 2) {
            int iJ = dVar.j();
            dVar.t(16);
            return iJ == 1 ? (T) Boolean.TRUE : (T) Boolean.FALSE;
        }
        Object objJ = bVar.J();
        if (objJ == null) {
            return null;
        }
        return (T) L1.d.f(objJ);
    }
}
