package g5;

import com.google.gson.reflect.TypeToken;
import d5.u;
import d5.v;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class s implements v {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Class f9066a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Class f9067b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ u f9068c;

    public s(Class cls, Class cls2, u uVar) {
        this.f9066a = cls;
        this.f9067b = cls2;
        this.f9068c = uVar;
    }

    @Override // d5.v
    public final <T> u<T> b(d5.i iVar, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        if (rawType == this.f9066a || rawType == this.f9067b) {
            return this.f9068c;
        }
        return null;
    }

    public final String toString() {
        return "Factory[type=" + this.f9067b.getName() + "+" + this.f9066a.getName() + ",adapter=" + this.f9068c + "]";
    }
}
