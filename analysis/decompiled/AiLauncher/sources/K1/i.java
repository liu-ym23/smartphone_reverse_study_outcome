package K1;

import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
public class i implements t {
    @Override // K1.t
    public void a(m mVar, Object obj, Object obj2, Type type) throws IOException {
        z zVar = mVar.f4048b;
        if ((zVar.f4092c & SerializerFeature.WriteEnumUsingToString.mask) == 0) {
            zVar.writeInt(((Enum) obj).ordinal());
            return;
        }
        String string = ((Enum) obj).toString();
        if ((zVar.f4092c & SerializerFeature.UseSingleQuotes.mask) != 0) {
            zVar.k0(string);
        } else {
            zVar.g0(string, (char) 0, false);
        }
    }
}
