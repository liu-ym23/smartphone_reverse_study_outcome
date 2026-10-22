package pb;

import Z8.C1173v;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Encoder;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b7\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b'\u0018\u0000*\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u00012\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u00028\u0000*\u00020\u00072\u0006\u0010\n\u001a\u00020\tH$¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u0018H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u001bH\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u001eH\u0014¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010\"\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020!H\u0014¢\u0006\u0004\b\"\u0010#J\u001f\u0010$\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u000bH\u0014¢\u0006\u0004\b$\u0010%J\u001f\u0010'\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020&H\u0014¢\u0006\u0004\b'\u0010(J\u001f\u0010*\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020)H\u0014¢\u0006\u0004\b*\u0010+J'\u0010.\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\tH\u0014¢\u0006\u0004\b.\u0010/J\u001f\u00101\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u00100\u001a\u00020\u0007H\u0014¢\u0006\u0004\b1\u00102J\u0017\u00104\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u0007H\u0016¢\u0006\u0004\b4\u00105J\u0015\u00106\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b6\u00107J\u0015\u00108\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0015¢\u0006\u0004\b8\u00109J\u0015\u0010:\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0018¢\u0006\u0004\b:\u0010;J\u0015\u0010<\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b<\u0010=J\u0015\u0010>\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u001b¢\u0006\u0004\b>\u0010?J\u0015\u0010@\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u001e¢\u0006\u0004\b@\u0010AJ\u0015\u0010B\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020!¢\u0006\u0004\bB\u0010CJ\u0015\u0010D\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020&¢\u0006\u0004\bD\u0010EJ\u0015\u0010F\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020)¢\u0006\u0004\bF\u0010GJ\u001d\u0010H\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\bH\u0010IJ\u0015\u0010J\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u0007¢\u0006\u0004\bJ\u0010KJ\u0017\u0010L\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u0007H\u0014¢\u0006\u0004\bL\u0010KJ%\u0010M\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\bM\u0010NJ%\u0010O\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0015¢\u0006\u0004\bO\u0010PJ%\u0010Q\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0018¢\u0006\u0004\bQ\u0010RJ%\u0010S\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t¢\u0006\u0004\bS\u0010TJ%\u0010U\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u001b¢\u0006\u0004\bU\u0010VJ%\u0010W\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u001e¢\u0006\u0004\bW\u0010XJ%\u0010Y\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020!¢\u0006\u0004\bY\u0010ZJ%\u0010[\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020&¢\u0006\u0004\b[\u0010\\J%\u0010]\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020)¢\u0006\u0004\b]\u0010^J\u001d\u0010_\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b_\u0010`JA\u0010c\u001a\u00020\u0012\"\n\b\u0001\u0010\u000e*\u0004\u0018\u00010\u00012\u0006\u00103\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010b\u001a\b\u0012\u0004\u0012\u00028\u00010a2\u0006\u0010\u0011\u001a\u00028\u0001H\u0016¢\u0006\u0004\bc\u0010dJA\u0010e\u001a\u00020\u0012\"\b\b\u0001\u0010\u000e*\u00020\u00012\u0006\u00103\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010b\u001a\b\u0012\u0004\u0012\u00028\u00010a2\b\u0010\u0011\u001a\u0004\u0018\u00018\u0001H\u0016¢\u0006\u0004\be\u0010dJ\u0017\u0010g\u001a\u00020\u00122\u0006\u0010f\u001a\u00028\u0000H\u0004¢\u0006\u0004\bg\u0010hJ\u000f\u0010i\u001a\u00028\u0000H\u0004¢\u0006\u0004\bi\u0010jR$\u0010o\u001a\u0012\u0012\u0004\u0012\u00028\u00000kj\b\u0012\u0004\u0012\u00028\u0000`l8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\u0014\u0010q\u001a\u00028\u00008DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bp\u0010jR\u0016\u0010s\u001a\u0004\u0018\u00018\u00008DX\u0084\u0004¢\u0006\u0006\u001a\u0004\br\u0010j¨\u0006t"}, d2 = {"Lpb/c1;", "", "Tag", "Lkotlinx/serialization/encoding/Encoder;", "Lob/d;", "<init>", "()V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", Const.JSON_KEY_DESC, "", "index", "", ExifInterface.LONGITUDE_EAST, "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", ExifInterface.GPS_DIRECTION_TRUE, "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Ljava/lang/Object;", "tag", UxipConstants.f30680s, "LY8/t;", "M", "(Ljava/lang/Object;I)V", "", "G", "(Ljava/lang/Object;B)V", "", "O", "(Ljava/lang/Object;S)V", "", "N", "(Ljava/lang/Object;J)V", "", "K", "(Ljava/lang/Object;F)V", "", "I", "(Ljava/lang/Object;D)V", "F", "(Ljava/lang/Object;Z)V", "", "H", "(Ljava/lang/Object;C)V", "", "P", "(Ljava/lang/Object;Ljava/lang/String;)V", "enumDescriptor", "ordinal", "J", "(Ljava/lang/Object;Lkotlinx/serialization/descriptors/SerialDescriptor;I)V", "inlineDescriptor", "L", "(Ljava/lang/Object;Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Encoder;", "descriptor", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Encoder;", "p", "(Z)V", Const.INTENT_KEY_UMID, "(B)V", "o", "(S)V", "z", "(I)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(J)V", "r", "(F)V", "c", "(D)V", "s", "(C)V", "D", "(Ljava/lang/String;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)V", "endStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "Q", "v", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IZ)V", "n", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IB)V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lkotlinx/serialization/descriptors/SerialDescriptor;IS)V", "t", "(Lkotlinx/serialization/descriptors/SerialDescriptor;II)V", "C", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IJ)V", "q", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IF)V", "B", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ID)V", "l", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IC)V", "w", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILjava/lang/String;)V", Const.INTENT_KEY_PKGNAME, "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Lkotlinx/serialization/encoding/Encoder;", "Llb/m;", "serializer", "x", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILlb/m;Ljava/lang/Object;)V", "k", "name", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Ljava/lang/Object;)V", "U", "()Ljava/lang/Object;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", Const.INTENT_KEY_APIKEY, "Ljava/util/ArrayList;", "tagStack", "R", "currentTag", ExifInterface.LATITUDE_SOUTH, "currentTagOrNull", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class c1<Tag> implements Encoder, ob.d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final ArrayList<Tag> tagStack = new ArrayList<>();

    private final boolean E(SerialDescriptor desc, int index) {
        V(T(desc, index));
        return true;
    }

    @Override // ob.d
    public final void A(SerialDescriptor descriptor, int index, short value) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        O(T(descriptor, index), value);
    }

    @Override // ob.d
    public final void B(SerialDescriptor descriptor, int index, double value) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        I(T(descriptor, index), value);
    }

    @Override // ob.d
    public final void C(SerialDescriptor descriptor, int index, long value) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        N(T(descriptor, index), value);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void D(String value) {
        kotlin.jvm.internal.p.i(value, "value");
        P(U(), value);
    }

    public abstract void F(Tag tag, boolean value);

    public abstract void G(Tag tag, byte value);

    public abstract void H(Tag tag, char value);

    public abstract void I(Tag tag, double value);

    public abstract void J(Tag tag, SerialDescriptor enumDescriptor, int ordinal);

    public abstract void K(Tag tag, float value);

    public Encoder L(Tag tag, SerialDescriptor inlineDescriptor) {
        kotlin.jvm.internal.p.i(inlineDescriptor, "inlineDescriptor");
        V(tag);
        return this;
    }

    public abstract void M(Tag tag, int value);

    public abstract void N(Tag tag, long value);

    public abstract void O(Tag tag, short value);

    public abstract void P(Tag tag, String value);

    public abstract void Q(SerialDescriptor descriptor);

    public final Tag R() {
        return (Tag) Z8.F.C0(this.tagStack);
    }

    public final Tag S() {
        return (Tag) Z8.F.E0(this.tagStack);
    }

    public abstract Tag T(SerialDescriptor serialDescriptor, int i10);

    public final Tag U() {
        if (this.tagStack.isEmpty()) {
            throw new SerializationException("No tag in stack for requested element");
        }
        ArrayList<Tag> arrayList = this.tagStack;
        return arrayList.remove(C1173v.o(arrayList));
    }

    public final void V(Tag name) {
        this.tagStack.add(name);
    }

    @Override // ob.d
    public final Encoder b(SerialDescriptor descriptor, int index) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        return L(T(descriptor, index), descriptor.g(index));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void c(double value) {
        I(U(), value);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void d(byte value) {
        G(U(), value);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public abstract <T> void e(lb.m<? super T> mVar, T t10);

    @Override // ob.d
    public final void endStructure(SerialDescriptor descriptor) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        if (!this.tagStack.isEmpty()) {
            U();
        }
        Q(descriptor);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public ob.d f(SerialDescriptor serialDescriptor, int i10) {
        return super.f(serialDescriptor, i10);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void g(SerialDescriptor enumDescriptor, int index) {
        kotlin.jvm.internal.p.i(enumDescriptor, "enumDescriptor");
        J(U(), enumDescriptor, index);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public Encoder h(SerialDescriptor descriptor) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        return L(U(), descriptor);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void i(long value) {
        N(U(), value);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public <T> void j(lb.m<? super T> mVar, T t10) {
        super.j(mVar, t10);
    }

    @Override // ob.d
    public <T> void k(SerialDescriptor descriptor, int index, lb.m<? super T> serializer, T value) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        kotlin.jvm.internal.p.i(serializer, "serializer");
        if (E(descriptor, index)) {
            j(serializer, value);
        }
    }

    @Override // ob.d
    public final void l(SerialDescriptor descriptor, int index, char value) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        H(T(descriptor, index), value);
    }

    @Override // ob.d
    public final void n(SerialDescriptor descriptor, int index, byte value) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        G(T(descriptor, index), value);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void o(short value) {
        O(U(), value);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void p(boolean value) {
        F(U(), value);
    }

    @Override // ob.d
    public final void q(SerialDescriptor descriptor, int index, float value) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        K(T(descriptor, index), value);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void r(float value) {
        K(U(), value);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void s(char value) {
        H(U(), value);
    }

    @Override // ob.d
    public final void t(SerialDescriptor descriptor, int index, int value) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        M(T(descriptor, index), value);
    }

    @Override // ob.d
    public final void v(SerialDescriptor descriptor, int index, boolean value) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        F(T(descriptor, index), value);
    }

    @Override // ob.d
    public final void w(SerialDescriptor descriptor, int index, String value) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        kotlin.jvm.internal.p.i(value, "value");
        P(T(descriptor, index), value);
    }

    @Override // ob.d
    public <T> void x(SerialDescriptor descriptor, int index, lb.m<? super T> serializer, T value) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        kotlin.jvm.internal.p.i(serializer, "serializer");
        if (E(descriptor, index)) {
            e(serializer, value);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void z(int value) {
        M(U(), value);
    }
}
