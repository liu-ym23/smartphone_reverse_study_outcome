package x4;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.f;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public final class a extends Converter.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f25424a;

    public a(Gson r10) {
        if (r10 == null) goto L7;
        this.f25424a = r10;
        return;
    L7:
        throw new NullPointerException("gson == null");
    }

    public static a f() {
        return g(new Gson());
    }

    public static a g(Gson r10) {
        return new a(r10);
    }

    @Override // com.bytedance.retrofit2.Converter.a
    public Converter c(Type r10, Annotation[] r11, Annotation[] r12, f r13) {
        TypeAdapter r14 = this.f25424a.getAdapter(TypeToken.get(r10));
        return new b(this.f25424a, r14);
    }

    @Override // com.bytedance.retrofit2.Converter.a
    public Converter d(Type r10, Annotation[] r11, f r12) {
        TypeAdapter r13 = this.f25424a.getAdapter(TypeToken.get(r10));
        return new c(this.f25424a, r13);
    }
}
