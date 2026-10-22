package uc;

import kotlinx.serialization.json.internal.JsonDecodingException;
import tc.b1;
import tc.p0;
import tc.y;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final y f13210a = p0.a("kotlinx.serialization.json.JsonUnquotedLiteral", b1.f12964a);

    public static final Integer a(t tVar) {
        Long lValueOf;
        try {
            lValueOf = Long.valueOf(new vc.m(tVar.a()).h());
        } catch (JsonDecodingException unused) {
            lValueOf = null;
        }
        if (lValueOf != null) {
            long jLongValue = lValueOf.longValue();
            if (-2147483648L <= jLongValue && jLongValue <= 2147483647L) {
                return Integer.valueOf((int) jLongValue);
            }
        }
        return null;
    }

    public static final t b(g gVar) {
        t tVar = gVar instanceof t ? (t) gVar : null;
        if (tVar != null) {
            return tVar;
        }
        throw new IllegalArgumentException("Element " + kotlin.jvm.internal.i.a(gVar.getClass()) + " is not a JsonPrimitive");
    }
}
