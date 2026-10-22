package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import retrofit2.Converter;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends Converter.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f24020a;

    public a(Gson r10) {
        this.f24020a = r10;
    }

    public static a d(Gson r10) {
        if (r10 == null) goto L6;
        return new a(r10);
    L6:
        throw new NullPointerException("gson == null");
    }

    @Override // retrofit2.Converter.a
    public Converter a(Type r10, Annotation[] r11, Annotation[] r12, Retrofit r13) {
        TypeAdapter r14 = this.f24020a.getAdapter(TypeToken.get(r10));
        return new b(this.f24020a, r14);
    }

    @Override // retrofit2.Converter.a
    public Converter b(Type r10, Annotation[] r11, Retrofit r12) {
        TypeAdapter r13 = this.f24020a.getAdapter(TypeToken.get(r10));
        return new c(this.f24020a, r13);
    }
}
