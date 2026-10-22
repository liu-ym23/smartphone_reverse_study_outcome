package pb;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import mb.C4931a;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0013\u001a\u00020\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lpb/r1;", "Lkotlinx/serialization/KSerializer;", "LY8/r;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "c", "(Lkotlinx/serialization/encoding/Encoder;S)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", Const.INTENT_KEY_PKGNAME, "(Lkotlinx/serialization/encoding/Decoder;)S", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class r1 implements KSerializer<Y8.r> {

    /* renamed from: a, reason: collision with root package name */
    public static final r1 f38408a = new r1();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final SerialDescriptor descriptor = T.a("kotlin.UShort", C4931a.G(kotlin.jvm.internal.w.f34838a));

    public short b(Decoder decoder) {
        kotlin.jvm.internal.p.i(decoder, "decoder");
        return Y8.r.b(decoder.decodeInline(getDescriptor()).decodeShort());
    }

    public void c(Encoder encoder, short value) {
        kotlin.jvm.internal.p.i(encoder, "encoder");
        encoder.h(getDescriptor()).o(value);
    }

    @Override // lb.InterfaceC4883a
    public /* bridge */ /* synthetic */ Object deserialize(Decoder decoder) {
        return Y8.r.a(b(decoder));
    }

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // lb.m
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        c(encoder, ((Y8.r) obj).getData());
    }
}
