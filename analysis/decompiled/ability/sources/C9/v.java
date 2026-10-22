package C9;

import ca.AbstractC0897f;
import kotlinx.serialization.json.internal.JsonDecodingException;

/* loaded from: classes4.dex */
public final class v implements x9.b {

    /* renamed from: a, reason: collision with root package name */
    public static final v f334a = new v();
    public static final z9.h b = z2.l.m("kotlinx.serialization.json.JsonNull", z9.j.c, new z9.g[0]);

    @Override // x9.InterfaceC2123a
    public final Object deserialize(A9.e decoder) {
        kotlin.jvm.internal.k.f(decoder, "decoder");
        AbstractC0897f.n(decoder);
        if (decoder.decodeNotNullMark()) {
            throw new JsonDecodingException("Expected 'null' literal");
        }
        decoder.decodeNull();
        return u.INSTANCE;
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final z9.g getDescriptor() {
        return b;
    }

    @Override // x9.f
    public final void serialize(A9.f fVar, Object obj) {
        u value = (u) obj;
        kotlin.jvm.internal.k.f(value, "value");
        AbstractC0897f.l(fVar);
        fVar.encodeNull();
    }
}
