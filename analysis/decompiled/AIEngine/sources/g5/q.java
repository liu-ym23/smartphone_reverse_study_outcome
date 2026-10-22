package g5;

import com.google.gson.reflect.TypeToken;
import d5.u;
import d5.v;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class q implements v {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TypeToken f9062a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u f9063b;

    public q(TypeToken typeToken, u uVar) {
        this.f9062a = typeToken;
        this.f9063b = uVar;
    }

    @Override // d5.v
    public final <T> u<T> b(d5.i iVar, TypeToken<T> typeToken) {
        if (typeToken.equals(this.f9062a)) {
            return this.f9063b;
        }
        return null;
    }
}
