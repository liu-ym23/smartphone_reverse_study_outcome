package g5;

import com.google.gson.reflect.TypeToken;
import d5.u;
import d5.v;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g implements v {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f8991a;

    public g(h hVar) {
        this.f8991a = hVar;
    }

    @Override // d5.v
    public final <T> u<T> b(d5.i iVar, TypeToken<T> typeToken) {
        if (typeToken.getRawType() == Number.class) {
            return this.f8991a;
        }
        return null;
    }
}
