package zc;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import tb.AbstractC5529B;
import tb.AbstractC5531D;
import yc.h;
import yc.w;

/* loaded from: classes5.dex */
public final class a extends h.a {

    /* renamed from: a, reason: collision with root package name */
    public final Gson f45470a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f45471b;

    public a(Gson gson, boolean z10) {
        this.f45470a = gson;
        this.f45471b = z10;
    }

    public static a f() {
        return g(new Gson());
    }

    public static a g(Gson gson) {
        if (gson != null) {
            return new a(gson, false);
        }
        throw new NullPointerException("gson == null");
    }

    @Override // yc.h.a
    public h<?, AbstractC5529B> c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, w wVar) {
        return new b(this.f45470a, this.f45470a.getAdapter(TypeToken.get(type)), this.f45471b);
    }

    @Override // yc.h.a
    public h<AbstractC5531D, ?> d(Type type, Annotation[] annotationArr, w wVar) {
        return new c(this.f45470a, this.f45470a.getAdapter(TypeToken.get(type)));
    }
}
