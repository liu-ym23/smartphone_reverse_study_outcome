package g5;

import com.google.gson.JsonSyntaxException;
import com.google.gson.ToNumberPolicy;
import com.google.gson.stream.JsonToken;
import d5.u;
import java.io.IOException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h extends u<Number> {

    /* renamed from: b, reason: collision with root package name */
    public static final g f8992b = new g(new h(ToNumberPolicy.f5439b));

    /* renamed from: a, reason: collision with root package name */
    public final d5.t f8993a;

    public h(d5.t tVar) {
        this.f8993a = tVar;
    }

    @Override // d5.u
    public final Number a(k5.a aVar) throws IOException {
        JsonToken jsonTokenR0 = aVar.R0();
        int iOrdinal = jsonTokenR0.ordinal();
        if (iOrdinal == 5 || iOrdinal == 6) {
            return this.f8993a.a(aVar);
        }
        if (iOrdinal == 8) {
            aVar.N0();
            return null;
        }
        throw new JsonSyntaxException("Expecting number, got: " + jsonTokenR0 + "; at path " + aVar.S());
    }

    @Override // d5.u
    public final void b(k5.b bVar, Number number) throws IOException {
        bVar.J0(number);
    }
}
