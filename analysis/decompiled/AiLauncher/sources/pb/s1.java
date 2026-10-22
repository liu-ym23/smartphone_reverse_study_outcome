package pb;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0001¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000e8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lpb/s1;", "Lkotlinx/serialization/KSerializer;", "LY8/t;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "c", "(Lkotlinx/serialization/encoding/Encoder;LY8/t;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", Const.INTENT_KEY_PKGNAME, "(Lkotlinx/serialization/encoding/Decoder;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class s1 implements KSerializer<Y8.t> {

    /* renamed from: b, reason: collision with root package name */
    public static final s1 f38417b = new s1();

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C5130x0<Y8.t> f38418a = new C5130x0<>("kotlin.Unit", Y8.t.f7040a);

    public void b(Decoder decoder) {
        kotlin.jvm.internal.p.i(decoder, "decoder");
        this.f38418a.deserialize(decoder);
    }

    @Override // lb.m
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void serialize(Encoder encoder, Y8.t value) {
        kotlin.jvm.internal.p.i(encoder, "encoder");
        kotlin.jvm.internal.p.i(value, "value");
        this.f38418a.serialize(encoder, value);
    }

    @Override // lb.InterfaceC4883a
    public /* bridge */ /* synthetic */ Object deserialize(Decoder decoder) {
        b(decoder);
        return Y8.t.f7040a;
    }

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public SerialDescriptor getDescriptor() {
        return this.f38418a.getDescriptor();
    }
}
