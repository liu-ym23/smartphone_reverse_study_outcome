package qb;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import nb.AbstractC4951d;
import nb.C4948a;
import nb.C4958k;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0014\u001a\u00020\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lqb/q;", "Lkotlinx/serialization/KSerializer;", "Lqb/i;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "o", "(Lkotlinx/serialization/encoding/Encoder;Lqb/i;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "n", "(Lkotlinx/serialization/encoding/Decoder;)Lqb/i;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", Const.INTENT_KEY_PKGNAME, "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class q implements KSerializer<i> {

    /* renamed from: a, reason: collision with root package name */
    public static final q f38674a = new q();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final SerialDescriptor descriptor = C4958k.g("kotlinx.serialization.json.JsonElement", AbstractC4951d.b.f37262a, new SerialDescriptor[0], new InterfaceC5074l() { // from class: qb.k
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return q.h((C4948a) obj);
        }
    });

    public static final Y8.t h(C4948a buildSerialDescriptor) {
        kotlin.jvm.internal.p.i(buildSerialDescriptor, "$this$buildSerialDescriptor");
        C4948a.b(buildSerialDescriptor, "JsonPrimitive", r.f(new InterfaceC5063a() { // from class: qb.l
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return q.i();
            }
        }), null, false, 12, null);
        C4948a.b(buildSerialDescriptor, "JsonNull", r.f(new InterfaceC5063a() { // from class: qb.m
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return q.j();
            }
        }), null, false, 12, null);
        C4948a.b(buildSerialDescriptor, "JsonLiteral", r.f(new InterfaceC5063a() { // from class: qb.n
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return q.k();
            }
        }), null, false, 12, null);
        C4948a.b(buildSerialDescriptor, "JsonObject", r.f(new InterfaceC5063a() { // from class: qb.o
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return q.l();
            }
        }), null, false, 12, null);
        C4948a.b(buildSerialDescriptor, "JsonArray", r.f(new InterfaceC5063a() { // from class: qb.p
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return q.m();
            }
        }), null, false, 12, null);
        return Y8.t.f7040a;
    }

    public static final SerialDescriptor i() {
        return G.f38628a.getDescriptor();
    }

    public static final SerialDescriptor j() {
        return C5169B.f38620a.getDescriptor();
    }

    public static final SerialDescriptor k() {
        return x.f38680a.getDescriptor();
    }

    public static final SerialDescriptor l() {
        return E.f38623a.getDescriptor();
    }

    public static final SerialDescriptor m() {
        return C5173c.f38635a.getDescriptor();
    }

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // lb.InterfaceC4883a
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public i deserialize(Decoder decoder) {
        kotlin.jvm.internal.p.i(decoder, "decoder");
        return r.d(decoder).b();
    }

    @Override // lb.m
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void serialize(Encoder encoder, i value) {
        kotlin.jvm.internal.p.i(encoder, "encoder");
        kotlin.jvm.internal.p.i(value, "value");
        r.h(encoder);
        if (value instanceof F) {
            encoder.e(G.f38628a, value);
        } else if (value instanceof D) {
            encoder.e(E.f38623a, value);
        } else {
            if (!(value instanceof C5172b)) {
                throw new NoWhenBranchMatchedException();
            }
            encoder.e(C5173c.f38635a, value);
        }
    }
}
