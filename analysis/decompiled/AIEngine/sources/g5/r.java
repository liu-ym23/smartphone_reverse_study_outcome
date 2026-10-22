package g5;

import com.google.gson.reflect.TypeToken;
import d5.u;
import d5.v;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class r implements v {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Class f9064a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u f9065b;

    public r(Class cls, u uVar) {
        this.f9064a = cls;
        this.f9065b = uVar;
    }

    @Override // d5.v
    public final <T> u<T> b(d5.i iVar, TypeToken<T> typeToken) {
        if (typeToken.getRawType() == this.f9064a) {
            return this.f9065b;
        }
        return null;
    }

    public final String toString() {
        return "Factory[type=" + this.f9064a.getName() + ",adapter=" + this.f9065b + "]";
    }
}
