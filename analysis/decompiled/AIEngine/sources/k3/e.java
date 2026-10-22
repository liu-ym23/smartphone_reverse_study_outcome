package k3;

import a3.k;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.BeanProperty;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class e {
    public abstract e a(BeanProperty beanProperty);

    public abstract String b();

    public abstract JsonTypeInfo.As c();

    public final WritableTypeId d(JsonToken jsonToken, Object obj) {
        WritableTypeId writableTypeId = new WritableTypeId(jsonToken, obj);
        int iOrdinal = c().ordinal();
        if (iOrdinal == 0) {
            writableTypeId.f3623e = WritableTypeId.Inclusion.f3628c;
            writableTypeId.f3622d = b();
            return writableTypeId;
        }
        if (iOrdinal == 1) {
            writableTypeId.f3623e = WritableTypeId.Inclusion.f3627b;
            return writableTypeId;
        }
        if (iOrdinal == 2) {
            writableTypeId.f3623e = WritableTypeId.Inclusion.f3626a;
            return writableTypeId;
        }
        if (iOrdinal == 3) {
            writableTypeId.f3623e = WritableTypeId.Inclusion.f3630e;
            writableTypeId.f3622d = b();
            return writableTypeId;
        }
        if (iOrdinal != 4) {
            k.a();
            throw null;
        }
        writableTypeId.f3623e = WritableTypeId.Inclusion.f3629d;
        writableTypeId.f3622d = b();
        return writableTypeId;
    }

    public abstract WritableTypeId e(JsonGenerator jsonGenerator, WritableTypeId writableTypeId);

    public abstract WritableTypeId f(JsonGenerator jsonGenerator, WritableTypeId writableTypeId);
}
