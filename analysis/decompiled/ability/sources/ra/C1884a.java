package ra;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import qa.AbstractC1858j;
import qa.InterfaceC1859k;
import qa.N;

/* renamed from: ra.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1884a extends AbstractC1858j {

    /* renamed from: a, reason: collision with root package name */
    public final Gson f5686a;

    public C1884a(Gson gson) {
        this.f5686a = gson;
    }

    public static C1884a c(Gson gson) {
        if (gson != null) {
            return new C1884a(gson);
        }
        throw new NullPointerException("gson == null");
    }

    @Override // qa.AbstractC1858j
    public final InterfaceC1859k a(Type type) {
        TypeToken<?> typeToken = TypeToken.get(type);
        Gson gson = this.f5686a;
        return new b(gson, gson.getAdapter(typeToken));
    }

    @Override // qa.AbstractC1858j
    public final InterfaceC1859k b(Type type, Annotation[] annotationArr, N n) {
        TypeToken<?> typeToken = TypeToken.get(type);
        Gson gson = this.f5686a;
        return new O2.a(9, gson, gson.getAdapter(typeToken));
    }
}
