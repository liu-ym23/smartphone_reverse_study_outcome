package m3;

import a3.c;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.BaseJsonNode;
import java.io.IOException;
import v2.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonMapper f10484a;

    /* renamed from: b, reason: collision with root package name */
    public static final ObjectWriter f10485b;

    /* renamed from: c, reason: collision with root package name */
    public static final ObjectReader f10486c;

    static {
        JsonMapper jsonMapper = new JsonMapper();
        f10484a = jsonMapper;
        f10485b = new ObjectWriter(jsonMapper, jsonMapper.f3725c);
        d dVar = jsonMapper.f3725c.f3760n;
        if (dVar == null) {
            dVar = ObjectWriter.h;
        }
        ObjectWriter.GeneratorSettings generatorSettings = ObjectWriter.GeneratorSettings.f3740b;
        if (generatorSettings != (dVar == null ? generatorSettings : new ObjectWriter.GeneratorSettings(dVar))) {
        }
        f10486c = new ObjectReader(jsonMapper, jsonMapper.h, jsonMapper.f3724b.j(b3.d.class));
    }

    public static byte[] a(BaseJsonNode baseJsonNode) {
        byte[] bArr;
        JsonMapper jsonMapper = f10484a;
        jsonMapper.getClass();
        c cVar = new c(jsonMapper.f3723a.a());
        try {
            jsonMapper.e(jsonMapper.f(cVar), baseJsonNode);
            byte[] bArrP = cVar.P();
            cVar.K();
            a3.a aVar = cVar.f14a;
            if (aVar != null && (bArr = cVar.f17d) != null) {
                aVar.f10a.set(2, bArr);
                cVar.f17d = null;
            }
            return bArrP;
        } catch (JsonProcessingException e10) {
            throw e10;
        } catch (IOException e11) {
            throw JsonMappingException.e(e11);
        }
    }
}
