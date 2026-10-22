package com.scp.moderation.crypto;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.scp.moderation.crypto.model.SensitiveWord;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class WordJsonCodec {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonMapper f5545a;

    /* renamed from: b, reason: collision with root package name */
    public static final TypeReference<List<SensitiveWord>> f5546b;

    static {
        JsonMapper jsonMapper = new JsonMapper();
        DeserializationFeature deserializationFeature = new DeserializationFeature[]{DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES}[0];
        DeserializationConfig deserializationConfig = jsonMapper.h;
        int i10 = deserializationConfig.f3660p;
        int i11 = (~deserializationFeature.f3689b) & i10;
        if (i11 != i10) {
            deserializationConfig = new DeserializationConfig(deserializationConfig, deserializationConfig.f3827a, i11);
        }
        jsonMapper.h = deserializationConfig;
        MapperFeature[] mapperFeatureArr = {MapperFeature.ALLOW_COERCION_OF_SCALARS};
        jsonMapper.h = deserializationConfig.n(mapperFeatureArr);
        SerializationConfig serializationConfigN = jsonMapper.f3725c.n(mapperFeatureArr);
        jsonMapper.f3725c = serializationConfigN;
        SerializationFeature serializationFeature = new SerializationFeature[]{SerializationFeature.INDENT_OUTPUT}[0];
        int i12 = serializationConfigN.f3761o;
        int i13 = (~serializationFeature.f3781b) & i12;
        if (i13 != i12) {
            serializationConfigN = new SerializationConfig(serializationConfigN, serializationConfigN.f3827a, i13);
        }
        jsonMapper.f3725c = serializationConfigN;
        f5545a = jsonMapper;
        f5546b = new TypeReference<List<SensitiveWord>>() { // from class: com.scp.moderation.crypto.WordJsonCodec.1
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x010d  */
    /* JADX WARN: Type inference failed for: r13v20 */
    /* JADX WARN: Type inference failed for: r13v21, types: [e0.a, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r13v23 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.List<com.scp.moderation.crypto.model.SensitiveWord> a(byte[] r24) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 588
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scp.moderation.crypto.WordJsonCodec.a(byte[]):java.util.List");
    }
}
