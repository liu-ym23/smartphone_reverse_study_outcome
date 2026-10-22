package b3;

import com.fasterxml.jackson.core.JsonGenerator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface e {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class a implements e {
        public boolean isEmpty() {
            return false;
        }
    }

    void a(JsonGenerator jsonGenerator, h hVar);

    void b(JsonGenerator jsonGenerator, h hVar, k3.e eVar);
}
