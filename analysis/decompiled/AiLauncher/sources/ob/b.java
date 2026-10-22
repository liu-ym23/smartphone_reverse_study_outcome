package ob;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.t;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Encoder;
import lb.m;
import pb.C5118r0;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0015\u0010\u0004J\u0017\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020)H\u0016¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020,H\u0016¢\u0006\u0004\b-\u0010.J\u001f\u00100\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b2\u00103J%\u00104\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u000e¢\u0006\u0004\b4\u00105J%\u00106\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0018¢\u0006\u0004\b6\u00107J%\u00108\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u001b¢\u0006\u0004\b8\u00109J%\u0010:\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b:\u0010;J%\u0010<\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020 ¢\u0006\u0004\b<\u0010=J%\u0010>\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020#¢\u0006\u0004\b>\u0010?J%\u0010@\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020&¢\u0006\u0004\b@\u0010AJ%\u0010B\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020)¢\u0006\u0004\bB\u0010CJ%\u0010D\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020,¢\u0006\u0004\bD\u0010EJ\u001d\u0010F\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\bF\u0010GJA\u0010K\u001a\u00020\t\"\n\b\u0000\u0010H*\u0004\u0018\u00010\u00112\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\f\u0010J\u001a\b\u0012\u0004\u0012\u00028\u00000I2\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0004\bK\u0010LJA\u0010M\u001a\u00020\t\"\b\b\u0000\u0010H*\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\f\u0010J\u001a\b\u0012\u0004\u0012\u00028\u00000I2\b\u0010\u0012\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\bM\u0010L¨\u0006N"}, d2 = {"Lob/b;", "Lkotlinx/serialization/encoding/Encoder;", "Lob/d;", "<init>", "()V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "beginStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lob/d;", "LY8/t;", "endStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "", "index", "", ExifInterface.LONGITUDE_EAST, "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", "", UxipConstants.f30680s, "F", "(Ljava/lang/Object;)V", "m", "p", "(Z)V", "", Const.INTENT_KEY_UMID, "(B)V", "", "o", "(S)V", "z", "(I)V", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(J)V", "", "r", "(F)V", "", "c", "(D)V", "", "s", "(C)V", "", "D", "(Ljava/lang/String;)V", "enumDescriptor", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Encoder;", "v", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IZ)V", "n", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IB)V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lkotlinx/serialization/descriptors/SerialDescriptor;IS)V", "t", "(Lkotlinx/serialization/descriptors/SerialDescriptor;II)V", "C", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IJ)V", "q", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IF)V", "B", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ID)V", "l", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IC)V", "w", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILjava/lang/String;)V", Const.INTENT_KEY_PKGNAME, "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Lkotlinx/serialization/encoding/Encoder;", ExifInterface.GPS_DIRECTION_TRUE, "Llb/m;", "serializer", "x", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILlb/m;Ljava/lang/Object;)V", "k", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class b implements Encoder, d {
    @Override // ob.d
    public final void A(SerialDescriptor descriptor, int index, short value) {
        p.i(descriptor, "descriptor");
        if (E(descriptor, index)) {
            o(value);
        }
    }

    @Override // ob.d
    public final void B(SerialDescriptor descriptor, int index, double value) {
        p.i(descriptor, "descriptor");
        if (E(descriptor, index)) {
            c(value);
        }
    }

    @Override // ob.d
    public final void C(SerialDescriptor descriptor, int index, long value) {
        p.i(descriptor, "descriptor");
        if (E(descriptor, index)) {
            i(value);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void D(String value) {
        p.i(value, "value");
        F(value);
    }

    public boolean E(SerialDescriptor descriptor, int index) {
        p.i(descriptor, "descriptor");
        return true;
    }

    public void F(Object value) {
        p.i(value, "value");
        throw new SerializationException("Non-serializable " + t.b(value.getClass()) + " is not supported by " + t.b(getClass()) + " encoder");
    }

    @Override // ob.d
    public final Encoder b(SerialDescriptor descriptor, int index) {
        p.i(descriptor, "descriptor");
        return E(descriptor, index) ? h(descriptor.g(index)) : C5118r0.f38406a;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public d beginStructure(SerialDescriptor descriptor) {
        p.i(descriptor, "descriptor");
        return this;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void c(double value) {
        F(Double.valueOf(value));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void d(byte value) {
        F(Byte.valueOf(value));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public <T> void e(m<? super T> mVar, T t10) {
        super.e(mVar, t10);
    }

    @Override // ob.d
    public void endStructure(SerialDescriptor descriptor) {
        p.i(descriptor, "descriptor");
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public d f(SerialDescriptor serialDescriptor, int i10) {
        return super.f(serialDescriptor, i10);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void g(SerialDescriptor enumDescriptor, int index) {
        p.i(enumDescriptor, "enumDescriptor");
        F(Integer.valueOf(index));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public Encoder h(SerialDescriptor descriptor) {
        p.i(descriptor, "descriptor");
        return this;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void i(long value) {
        F(Long.valueOf(value));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public <T> void j(m<? super T> mVar, T t10) {
        super.j(mVar, t10);
    }

    @Override // ob.d
    public <T> void k(SerialDescriptor descriptor, int index, m<? super T> serializer, T value) {
        p.i(descriptor, "descriptor");
        p.i(serializer, "serializer");
        if (E(descriptor, index)) {
            j(serializer, value);
        }
    }

    @Override // ob.d
    public final void l(SerialDescriptor descriptor, int index, char value) {
        p.i(descriptor, "descriptor");
        if (E(descriptor, index)) {
            s(value);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void m() {
        throw new SerializationException("'null' is not supported by default");
    }

    @Override // ob.d
    public final void n(SerialDescriptor descriptor, int index, byte value) {
        p.i(descriptor, "descriptor");
        if (E(descriptor, index)) {
            d(value);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void o(short value) {
        F(Short.valueOf(value));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void p(boolean value) {
        F(Boolean.valueOf(value));
    }

    @Override // ob.d
    public final void q(SerialDescriptor descriptor, int index, float value) {
        p.i(descriptor, "descriptor");
        if (E(descriptor, index)) {
            r(value);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void r(float value) {
        F(Float.valueOf(value));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void s(char value) {
        F(Character.valueOf(value));
    }

    @Override // ob.d
    public final void t(SerialDescriptor descriptor, int index, int value) {
        p.i(descriptor, "descriptor");
        if (E(descriptor, index)) {
            z(value);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void u() {
        super.u();
    }

    @Override // ob.d
    public final void v(SerialDescriptor descriptor, int index, boolean value) {
        p.i(descriptor, "descriptor");
        if (E(descriptor, index)) {
            p(value);
        }
    }

    @Override // ob.d
    public final void w(SerialDescriptor descriptor, int index, String value) {
        p.i(descriptor, "descriptor");
        p.i(value, "value");
        if (E(descriptor, index)) {
            D(value);
        }
    }

    @Override // ob.d
    public <T> void x(SerialDescriptor descriptor, int index, m<? super T> serializer, T value) {
        p.i(descriptor, "descriptor");
        p.i(serializer, "serializer");
        if (E(descriptor, index)) {
            e(serializer, value);
        }
    }

    @Override // ob.d
    public boolean y(SerialDescriptor serialDescriptor, int i10) {
        return super.y(serialDescriptor, i10);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void z(int value) {
        F(Integer.valueOf(value));
    }
}
