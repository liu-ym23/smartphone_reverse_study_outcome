package com.alibaba.fastjson.support.retrofit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import h3.C0611u;
import h3.M;
import h3.Z;
import h3.f0;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.regex.Pattern;
import retrofit2.Converter;
import retrofit2.Retrofit;

/* loaded from: classes.dex */
public class Retrofit2ConverterFactory extends Converter.Factory {
    private static final Feature[] EMPTY_SERIALIZER_FEATURES;
    private static final M MEDIA_TYPE;
    private Feature[] features;
    private SerializeConfig serializeConfig;
    private SerializerFeature[] serializerFeatures;
    private ParserConfig parserConfig = ParserConfig.getGlobalInstance();
    private int featureValues = JSON.DEFAULT_PARSER_FEATURE;

    public final class RequestBodyConverter<T> implements Converter<T, Z> {
        public RequestBodyConverter() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // retrofit2.Converter
        public /* bridge */ /* synthetic */ Z convert(Object obj) throws IOException {
            return convert((RequestBodyConverter<T>) obj);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // retrofit2.Converter
        public Z convert(T t4) throws IOException {
            return Z.create(Retrofit2ConverterFactory.MEDIA_TYPE, JSON.toJSONBytes(t4, Retrofit2ConverterFactory.this.serializeConfig == null ? SerializeConfig.globalInstance : Retrofit2ConverterFactory.this.serializeConfig, Retrofit2ConverterFactory.this.serializerFeatures == null ? SerializerFeature.EMPTY : Retrofit2ConverterFactory.this.serializerFeatures));
        }
    }

    public final class ResponseBodyConverter<T> implements Converter<f0, T> {
        private Type type;

        public ResponseBodyConverter(Type type) {
            this.type = type;
        }

        @Override // retrofit2.Converter
        public T convert(f0 f0Var) throws IOException {
            try {
                T t4 = (T) JSON.parseObject(f0Var.string(), this.type, Retrofit2ConverterFactory.this.parserConfig, Retrofit2ConverterFactory.this.featureValues, Retrofit2ConverterFactory.this.features != null ? Retrofit2ConverterFactory.this.features : Retrofit2ConverterFactory.EMPTY_SERIALIZER_FEATURES);
                f0Var.close();
                return t4;
            } catch (Throwable th) {
                f0Var.close();
                throw th;
            }
        }
    }

    static {
        Pattern pattern = M.f12732d;
        MEDIA_TYPE = C0611u.t("application/json; charset=UTF-8");
        EMPTY_SERIALIZER_FEATURES = new Feature[0];
    }

    public ParserConfig getParserConfig() {
        return this.parserConfig;
    }

    public int getParserFeatureValues() {
        return this.featureValues;
    }

    public Feature[] getParserFeatures() {
        return this.features;
    }

    public SerializeConfig getSerializeConfig() {
        return this.serializeConfig;
    }

    public SerializerFeature[] getSerializerFeatures() {
        return this.serializerFeatures;
    }

    @Override // retrofit2.Converter.Factory
    public Converter<?, Z> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        return new RequestBodyConverter();
    }

    @Override // retrofit2.Converter.Factory
    public Converter<f0, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        return new ResponseBodyConverter(type);
    }

    public Retrofit2ConverterFactory setParserConfig(ParserConfig parserConfig) {
        this.parserConfig = parserConfig;
        return this;
    }

    public Retrofit2ConverterFactory setParserFeatureValues(int i4) {
        this.featureValues = i4;
        return this;
    }

    public Retrofit2ConverterFactory setParserFeatures(Feature[] featureArr) {
        this.features = featureArr;
        return this;
    }

    public Retrofit2ConverterFactory setSerializeConfig(SerializeConfig serializeConfig) {
        this.serializeConfig = serializeConfig;
        return this;
    }

    public Retrofit2ConverterFactory setSerializerFeatures(SerializerFeature[] serializerFeatureArr) {
        this.serializerFeatures = serializerFeatureArr;
        return this;
    }
}
