package l3;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.BeanProperty;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class l extends k3.e {

    /* renamed from: a, reason: collision with root package name */
    public final k3.c f10218a;

    /* renamed from: b, reason: collision with root package name */
    public final BeanProperty f10219b;

    public l(k3.c cVar, BeanProperty beanProperty) {
        this.f10218a = cVar;
        this.f10219b = beanProperty;
    }

    @Override // k3.e
    public String b() {
        return null;
    }

    @Override // k3.e
    public final WritableTypeId e(JsonGenerator jsonGenerator, WritableTypeId writableTypeId) throws JsonGenerationException {
        if (writableTypeId.f3621c == null) {
            Object obj = writableTypeId.f3619a;
            Class<?> cls = writableTypeId.f3620b;
            k3.c cVar = this.f10218a;
            writableTypeId.f3621c = cls == null ? cVar.a(obj) : cVar.e(cls, obj);
        }
        jsonGenerator.getClass();
        Object obj2 = writableTypeId.f3621c;
        JsonToken jsonToken = writableTypeId.f3624f;
        if (jsonGenerator.C()) {
            writableTypeId.f3625g = false;
            jsonGenerator.i1(obj2);
        } else {
            String strValueOf = obj2 instanceof String ? (String) obj2 : String.valueOf(obj2);
            writableTypeId.f3625g = true;
            WritableTypeId.Inclusion inclusion = writableTypeId.f3623e;
            if (jsonToken != JsonToken.START_OBJECT) {
                inclusion.getClass();
                if (inclusion == WritableTypeId.Inclusion.f3628c || inclusion == WritableTypeId.Inclusion.f3629d) {
                    inclusion = WritableTypeId.Inclusion.f3626a;
                    writableTypeId.f3623e = inclusion;
                }
            }
            int iOrdinal = inclusion.ordinal();
            if (iOrdinal == 1) {
                jsonGenerator.c1();
                jsonGenerator.H0(strValueOf);
            } else {
                if (iOrdinal == 2) {
                    jsonGenerator.d1(writableTypeId.f3619a);
                    jsonGenerator.H0(writableTypeId.f3622d);
                    jsonGenerator.f1(strValueOf);
                    return writableTypeId;
                }
                if (iOrdinal != 3 && iOrdinal != 4) {
                    jsonGenerator.Z0();
                    jsonGenerator.f1(strValueOf);
                }
            }
        }
        if (jsonToken == JsonToken.START_OBJECT) {
            jsonGenerator.d1(writableTypeId.f3619a);
            return writableTypeId;
        }
        if (jsonToken == JsonToken.START_ARRAY) {
            jsonGenerator.Z0();
        }
        return writableTypeId;
    }

    @Override // k3.e
    public final WritableTypeId f(JsonGenerator jsonGenerator, WritableTypeId writableTypeId) {
        jsonGenerator.getClass();
        JsonToken jsonToken = writableTypeId.f3624f;
        if (jsonToken == JsonToken.START_OBJECT) {
            jsonGenerator.G0();
        } else if (jsonToken == JsonToken.START_ARRAY) {
            jsonGenerator.C0();
        }
        if (writableTypeId.f3625g) {
            int iOrdinal = writableTypeId.f3623e.ordinal();
            if (iOrdinal == 0) {
                jsonGenerator.C0();
            } else if (iOrdinal != 2 && iOrdinal != 3) {
                if (iOrdinal != 4) {
                    jsonGenerator.G0();
                    return writableTypeId;
                }
                Object obj = writableTypeId.f3621c;
                String strValueOf = obj instanceof String ? (String) obj : String.valueOf(obj);
                jsonGenerator.H0(writableTypeId.f3622d);
                jsonGenerator.f1(strValueOf);
                return writableTypeId;
            }
        }
        return writableTypeId;
    }
}
