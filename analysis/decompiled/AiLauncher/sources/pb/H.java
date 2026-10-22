package pb;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.lang.Enum;
import java.util.Arrays;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0001\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001b\u0010!\u001a\u00020\u00168VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lpb/H;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/serialization/KSerializer;", "", "serialName", "", "values", "<init>", "(Ljava/lang/String;[Ljava/lang/Enum;)V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "f", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Enum;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "e", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Enum;", "toString", "()Ljava/lang/String;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "c", "(Ljava/lang/String;)Lkotlinx/serialization/descriptors/SerialDescriptor;", Const.INTENT_KEY_APIKEY, "[Ljava/lang/Enum;", Const.INTENT_KEY_PKGNAME, "Lkotlinx/serialization/descriptors/SerialDescriptor;", "overriddenDescriptor", "LY8/h;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class H<T extends Enum<T>> implements KSerializer<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final T[] values;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public SerialDescriptor overriddenDescriptor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Y8.h descriptor;

    public H(final String serialName, T[] values) {
        kotlin.jvm.internal.p.i(serialName, "serialName");
        kotlin.jvm.internal.p.i(values, "values");
        this.values = values;
        this.descriptor = C4848b.b(new InterfaceC5063a() { // from class: pb.G
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return H.d(this.f38277a, serialName);
            }
        });
    }

    public static final SerialDescriptor d(H h10, String str) {
        SerialDescriptor serialDescriptor = h10.overriddenDescriptor;
        return serialDescriptor == null ? h10.c(str) : serialDescriptor;
    }

    public final SerialDescriptor c(String serialName) {
        F f10 = new F(serialName, this.values.length);
        for (T t10 : this.values) {
            I0.o(f10, t10.name(), false, 2, null);
        }
        return f10;
    }

    @Override // lb.InterfaceC4883a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public T deserialize(Decoder decoder) {
        kotlin.jvm.internal.p.i(decoder, "decoder");
        int iDecodeEnum = decoder.decodeEnum(getDescriptor());
        if (iDecodeEnum >= 0) {
            T[] tArr = this.values;
            if (iDecodeEnum < tArr.length) {
                return tArr[iDecodeEnum];
            }
        }
        throw new SerializationException(iDecodeEnum + " is not among valid " + getDescriptor().getSerialName() + " enum values, values size is " + this.values.length);
    }

    @Override // lb.m
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void serialize(Encoder encoder, T value) {
        kotlin.jvm.internal.p.i(encoder, "encoder");
        kotlin.jvm.internal.p.i(value, "value");
        int iO0 = Z8.r.o0(this.values, value);
        if (iO0 != -1) {
            encoder.g(getDescriptor(), iO0);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(value);
        sb2.append(" is not a valid enum ");
        sb2.append(getDescriptor().getSerialName());
        sb2.append(", must be one of ");
        String string = Arrays.toString(this.values);
        kotlin.jvm.internal.p.h(string, "toString(...)");
        sb2.append(string);
        throw new SerializationException(sb2.toString());
    }

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor) this.descriptor.getValue();
    }

    public String toString() {
        return "kotlinx.serialization.internal.EnumSerializer<" + getDescriptor().getSerialName() + '>';
    }
}
