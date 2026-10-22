package retrofit2.converter.gson;

import F1.n;
import com.google.gson.reflect.TypeToken;
import h3.Z;
import h3.f0;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import retrofit2.Converter;
import retrofit2.Retrofit;

/* loaded from: classes2.dex */
public final class GsonConverterFactory extends Converter.Factory {
    private final n gson;

    private GsonConverterFactory(n nVar) {
        this.gson = nVar;
    }

    public static GsonConverterFactory create(n nVar) {
        if (nVar != null) {
            return new GsonConverterFactory(nVar);
        }
        throw new NullPointerException("gson == null");
    }

    @Override // retrofit2.Converter.Factory
    public Converter<?, Z> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        return new GsonRequestBodyConverter(this.gson, this.gson.e(TypeToken.get(type)));
    }

    @Override // retrofit2.Converter.Factory
    public Converter<f0, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        return new GsonResponseBodyConverter(this.gson, this.gson.e(TypeToken.get(type)));
    }

    public static GsonConverterFactory create() {
        return create(new n());
    }
}
