package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fasterxml.jackson.databind.node.BaseJsonNode;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.util.a;
import java.io.Closeable;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import n3.f;
import v2.d;
import v2.e;
import x2.b;
import y2.h;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class ObjectWriter implements Serializable {
    public static final MinimalPrettyPrinter h = new MinimalPrettyPrinter();

    /* renamed from: a, reason: collision with root package name */
    public final SerializationConfig f3735a;

    /* renamed from: b, reason: collision with root package name */
    public final DefaultSerializerProvider f3736b;

    /* renamed from: c, reason: collision with root package name */
    public final f f3737c;

    /* renamed from: d, reason: collision with root package name */
    public final JsonFactory f3738d;

    /* renamed from: e, reason: collision with root package name */
    public final GeneratorSettings f3739e = GeneratorSettings.f3740b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class GeneratorSettings implements Serializable {

        /* renamed from: b, reason: collision with root package name */
        public static final GeneratorSettings f3740b = new GeneratorSettings(null);

        /* renamed from: a, reason: collision with root package name */
        public final d f3741a;

        public GeneratorSettings(d dVar) {
            this.f3741a = dVar;
        }
    }

    public ObjectWriter(ObjectMapper objectMapper, SerializationConfig serializationConfig) {
        this.f3735a = serializationConfig;
        this.f3736b = objectMapper.f3726d;
        this.f3737c = objectMapper.f3727e;
        this.f3738d = objectMapper.f3723a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(h hVar, BaseJsonNode baseJsonNode) {
        SerializationFeature serializationFeature = SerializationFeature.CLOSE_CLOSEABLE;
        SerializationConfig serializationConfig = this.f3735a;
        boolean zQ = serializationConfig.q(serializationFeature);
        f fVar = this.f3737c;
        DefaultSerializerProvider defaultSerializerProvider = this.f3736b;
        if (zQ && (baseJsonNode instanceof Closeable)) {
            Closeable closeable = (Closeable) baseJsonNode;
            try {
                DefaultSerializerProvider.Impl impl = (DefaultSerializerProvider.Impl) defaultSerializerProvider;
                impl.getClass();
                new DefaultSerializerProvider.Impl(impl, serializationConfig, fVar).I(hVar, baseJsonNode);
            } catch (Exception e10) {
                e = e10;
            }
            try {
                closeable.close();
                hVar.close();
                return;
            } catch (Exception e11) {
                e = e11;
                closeable = null;
                a.g(hVar, closeable, e);
                throw null;
            }
        }
        try {
            DefaultSerializerProvider.Impl impl2 = (DefaultSerializerProvider.Impl) defaultSerializerProvider;
            impl2.getClass();
            new DefaultSerializerProvider.Impl(impl2, serializationConfig, fVar).I(hVar, baseJsonNode);
            hVar.close();
        } catch (Exception e12) {
            Annotation[] annotationArr = a.f4529a;
            hVar.n1(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT);
            try {
                hVar.close();
            } catch (Exception e13) {
                e12.addSuppressed(e13);
            }
            a.C(e12);
            a.D(e12);
            throw new RuntimeException(e12);
        }
    }

    public final h b(x2.f fVar) {
        JsonFactory jsonFactory = this.f3738d;
        b bVar = new b(jsonFactory.a(), fVar, false);
        jsonFactory.getClass();
        h hVar = new h(bVar, jsonFactory.f3531e, jsonFactory.h, fVar, jsonFactory.f3533k);
        e eVar = jsonFactory.f3532j;
        if (eVar != JsonFactory.f3526o) {
            hVar.f13977m = eVar;
        }
        this.f3735a.o(hVar);
        d dVarK = this.f3739e.f3741a;
        if (dVarK != null) {
            if (dVarK == h) {
                hVar.f3540a = null;
            } else {
                if (dVarK instanceof a3.d) {
                    dVarK = ((a3.d) dVarK).k();
                }
                hVar.f3540a = dVarK;
            }
        }
        return hVar;
    }
}
