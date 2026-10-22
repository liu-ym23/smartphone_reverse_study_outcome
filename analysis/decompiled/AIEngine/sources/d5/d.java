package d5;

import com.google.gson.stream.JsonToken;
import java.io.IOException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d extends u<Number> {
    @Override // d5.u
    public final Number a(k5.a aVar) throws IOException {
        if (aVar.R0() != JsonToken.f5478l) {
            return Double.valueOf(aVar.I0());
        }
        aVar.N0();
        return null;
    }

    @Override // d5.u
    public final void b(k5.b bVar, Number number) throws IOException {
        Number number2 = number;
        if (number2 == null) {
            bVar.c0();
            return;
        }
        double dDoubleValue = number2.doubleValue();
        i.a(dDoubleValue);
        bVar.H0(dDoubleValue);
    }
}
