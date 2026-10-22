package pb;

import Z8.C1173v;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import lb.InterfaceC4883a;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0002\b.\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b'\u0018\u0000*\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u00012\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\u000b\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00072\u0006\u0010\b\u001a\u00028\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u0010\u001a\u00028\u0000*\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000eH$¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\b\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\b\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\b\u001a\u00028\u0000H\u0014¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020#2\u0006\u0010\b\u001a\u00028\u0000H\u0014¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020&2\u0006\u0010\b\u001a\u00028\u0000H\u0014¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020)2\u0006\u0010\b\u001a\u00028\u0000H\u0014¢\u0006\u0004\b*\u0010+J\u001f\u0010-\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010,\u001a\u00020\rH\u0014¢\u0006\u0004\b-\u0010.J\u001f\u00100\u001a\u00020\u00032\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010/\u001a\u00020\rH\u0014¢\u0006\u0004\b0\u00101J3\u00106\u001a\u00028\u0001\"\n\b\u0001\u00102*\u0004\u0018\u00010\u00012\f\u00104\u001a\b\u0012\u0004\u0012\u00028\u0001032\b\u00105\u001a\u0004\u0018\u00018\u0001H\u0014¢\u0006\u0004\b6\u00107J\u0017\u00109\u001a\u00020\u00032\u0006\u00108\u001a\u00020\rH\u0016¢\u0006\u0004\b9\u0010:J\u000f\u0010<\u001a\u0004\u0018\u00010;¢\u0006\u0004\b<\u0010=J\r\u0010>\u001a\u00020\u0012¢\u0006\u0004\b>\u0010?J\r\u0010@\u001a\u00020\u0015¢\u0006\u0004\b@\u0010AJ\r\u0010B\u001a\u00020\u0018¢\u0006\u0004\bB\u0010CJ\r\u0010D\u001a\u00020\u000e¢\u0006\u0004\bD\u0010EJ\r\u0010F\u001a\u00020\u001d¢\u0006\u0004\bF\u0010GJ\r\u0010H\u001a\u00020 ¢\u0006\u0004\bH\u0010IJ\r\u0010J\u001a\u00020#¢\u0006\u0004\bJ\u0010KJ\r\u0010L\u001a\u00020&¢\u0006\u0004\bL\u0010MJ\r\u0010N\u001a\u00020)¢\u0006\u0004\bN\u0010OJ\u0015\u0010P\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\r¢\u0006\u0004\bP\u0010QJ\u001d\u0010R\u001a\u00020\u00122\u0006\u00108\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\bR\u0010SJ\u001d\u0010T\u001a\u00020\u00152\u0006\u00108\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\bT\u0010UJ\u001d\u0010V\u001a\u00020\u00182\u0006\u00108\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\bV\u0010WJ\u001d\u0010X\u001a\u00020\u000e2\u0006\u00108\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\bX\u0010YJ\u001d\u0010Z\u001a\u00020\u001d2\u0006\u00108\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\bZ\u0010[J\u001d\u0010\\\u001a\u00020 2\u0006\u00108\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\\\u0010]J\u001d\u0010^\u001a\u00020#2\u0006\u00108\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b^\u0010_J\u001d\u0010`\u001a\u00020&2\u0006\u00108\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b`\u0010aJ\u001d\u0010b\u001a\u00020)2\u0006\u00108\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\bb\u0010cJ\u001d\u0010d\u001a\u00020\u00032\u0006\u00108\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\bd\u0010eJA\u0010f\u001a\u00028\u0001\"\n\b\u0001\u00102*\u0004\u0018\u00010\u00012\u0006\u00108\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u00104\u001a\b\u0012\u0004\u0012\u00028\u0001032\b\u00105\u001a\u0004\u0018\u00018\u0001¢\u0006\u0004\bf\u0010gJC\u0010h\u001a\u0004\u0018\u00018\u0001\"\b\b\u0001\u00102*\u00020\u00012\u0006\u00108\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u0001032\b\u00105\u001a\u0004\u0018\u00018\u0001¢\u0006\u0004\bh\u0010gJ\u0017\u0010k\u001a\u00020j2\u0006\u0010i\u001a\u00028\u0000H\u0004¢\u0006\u0004\bk\u0010lJ\u000f\u0010m\u001a\u00028\u0000H\u0004¢\u0006\u0004\bm\u0010nR*\u0010u\u001a\u0012\u0012\u0004\u0012\u00028\u00000oj\b\u0012\u0004\u0012\u00028\u0000`p8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bq\u0010r\u001a\u0004\bs\u0010tR\u0016\u0010x\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010wR\u0016\u0010z\u001a\u0004\u0018\u00018\u00008DX\u0084\u0004¢\u0006\u0006\u001a\u0004\by\u0010n¨\u0006{"}, d2 = {"Lpb/b1;", "", "Tag", "Lkotlinx/serialization/encoding/Decoder;", "Lob/c;", "<init>", "()V", ExifInterface.LONGITUDE_EAST, "tag", "Lkotlin/Function0;", "block", "y", "(Ljava/lang/Object;Lp9/a;)Ljava/lang/Object;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "index", "u", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Ljava/lang/Object;", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/Object;)Z", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/Object;)B", "", "r", "(Ljava/lang/Object;)S", "p", "(Ljava/lang/Object;)I", "", "q", "(Ljava/lang/Object;)J", "", "n", "(Ljava/lang/Object;)F", "", "l", "(Ljava/lang/Object;)D", "", "k", "(Ljava/lang/Object;)C", "", "s", "(Ljava/lang/Object;)Ljava/lang/String;", "enumDescriptor", "m", "(Ljava/lang/Object;Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "inlineDescriptor", "o", "(Ljava/lang/Object;Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Decoder;", ExifInterface.GPS_DIRECTION_TRUE, "Llb/a;", "deserializer", "previousValue", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Llb/a;Ljava/lang/Object;)Ljava/lang/Object;", "descriptor", "decodeInline", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Decoder;", "", "decodeNull", "()Ljava/lang/Void;", "decodeBoolean", "()Z", "decodeByte", "()B", "decodeShort", "()S", "decodeInt", "()I", "decodeLong", "()J", "decodeFloat", "()F", "decodeDouble", "()D", "decodeChar", "()C", "decodeString", "()Ljava/lang/String;", "decodeEnum", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "decodeBooleanElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", "decodeByteElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)B", "decodeShortElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)S", "decodeIntElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)I", "decodeLongElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)J", "decodeFloatElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)F", "decodeDoubleElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)D", "decodeCharElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)C", "decodeStringElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Ljava/lang/String;", "decodeInlineElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Lkotlinx/serialization/encoding/Decoder;", "decodeSerializableElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILlb/a;Ljava/lang/Object;)Ljava/lang/Object;", "decodeNullableSerializableElement", "name", "LY8/t;", "x", "(Ljava/lang/Object;)V", "w", "()Ljava/lang/Object;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", Const.INTENT_KEY_PKGNAME, "Ljava/util/ArrayList;", "v", "()Ljava/util/ArrayList;", "tagStack", "c", "Z", "flag", "t", "currentTagOrNull", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class b1<Tag> implements Decoder, ob.c {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final ArrayList<Tag> tagStack = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public boolean flag;

    public static final Object f(b1 b1Var, InterfaceC4883a interfaceC4883a, Object obj) {
        return (interfaceC4883a.getDescriptor().b() || b1Var.decodeNotNullMark()) ? b1Var.h(interfaceC4883a, obj) : b1Var.decodeNull();
    }

    public static final Object g(b1 b1Var, InterfaceC4883a interfaceC4883a, Object obj) {
        return b1Var.h(interfaceC4883a, obj);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final boolean decodeBoolean() {
        return i(w());
    }

    @Override // ob.c
    public final boolean decodeBooleanElement(SerialDescriptor descriptor, int index) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        return i(u(descriptor, index));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final byte decodeByte() {
        return j(w());
    }

    @Override // ob.c
    public final byte decodeByteElement(SerialDescriptor descriptor, int index) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        return j(u(descriptor, index));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final char decodeChar() {
        return k(w());
    }

    @Override // ob.c
    public final char decodeCharElement(SerialDescriptor descriptor, int index) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        return k(u(descriptor, index));
    }

    @Override // ob.c
    public int decodeCollectionSize(SerialDescriptor serialDescriptor) {
        return super.decodeCollectionSize(serialDescriptor);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final double decodeDouble() {
        return l(w());
    }

    @Override // ob.c
    public final double decodeDoubleElement(SerialDescriptor descriptor, int index) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        return l(u(descriptor, index));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final int decodeEnum(SerialDescriptor enumDescriptor) {
        kotlin.jvm.internal.p.i(enumDescriptor, "enumDescriptor");
        return m(w(), enumDescriptor);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final float decodeFloat() {
        return n(w());
    }

    @Override // ob.c
    public final float decodeFloatElement(SerialDescriptor descriptor, int index) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        return n(u(descriptor, index));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public Decoder decodeInline(SerialDescriptor descriptor) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        return o(w(), descriptor);
    }

    @Override // ob.c
    public final Decoder decodeInlineElement(SerialDescriptor descriptor, int index) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        return o(u(descriptor, index), descriptor.g(index));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final int decodeInt() {
        return p(w());
    }

    @Override // ob.c
    public final int decodeIntElement(SerialDescriptor descriptor, int index) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        return p(u(descriptor, index));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final long decodeLong() {
        return q(w());
    }

    @Override // ob.c
    public final long decodeLongElement(SerialDescriptor descriptor, int index) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        return q(u(descriptor, index));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final Void decodeNull() {
        return null;
    }

    @Override // ob.c
    public final <T> T decodeNullableSerializableElement(SerialDescriptor descriptor, int index, final InterfaceC4883a<? extends T> deserializer, final T previousValue) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        kotlin.jvm.internal.p.i(deserializer, "deserializer");
        return (T) y(u(descriptor, index), new InterfaceC5063a() { // from class: pb.a1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return b1.f(this.f38337a, deserializer, previousValue);
            }
        });
    }

    @Override // ob.c
    public boolean decodeSequentially() {
        return super.decodeSequentially();
    }

    @Override // ob.c
    public final <T> T decodeSerializableElement(SerialDescriptor descriptor, int index, final InterfaceC4883a<? extends T> deserializer, final T previousValue) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        kotlin.jvm.internal.p.i(deserializer, "deserializer");
        return (T) y(u(descriptor, index), new InterfaceC5063a() { // from class: pb.Z0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return b1.g(this.f38332a, deserializer, previousValue);
            }
        });
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public abstract <T> T decodeSerializableValue(InterfaceC4883a<? extends T> interfaceC4883a);

    @Override // kotlinx.serialization.encoding.Decoder
    public final short decodeShort() {
        return r(w());
    }

    @Override // ob.c
    public final short decodeShortElement(SerialDescriptor descriptor, int index) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        return r(u(descriptor, index));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final String decodeString() {
        return s(w());
    }

    @Override // ob.c
    public final String decodeStringElement(SerialDescriptor descriptor, int index) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        return s(u(descriptor, index));
    }

    public <T> T h(InterfaceC4883a<? extends T> deserializer, T previousValue) {
        kotlin.jvm.internal.p.i(deserializer, "deserializer");
        return (T) decodeSerializableValue(deserializer);
    }

    public abstract boolean i(Tag tag);

    public abstract byte j(Tag tag);

    public abstract char k(Tag tag);

    public abstract double l(Tag tag);

    public abstract int m(Tag tag, SerialDescriptor enumDescriptor);

    public abstract float n(Tag tag);

    public Decoder o(Tag tag, SerialDescriptor inlineDescriptor) {
        kotlin.jvm.internal.p.i(inlineDescriptor, "inlineDescriptor");
        x(tag);
        return this;
    }

    public abstract int p(Tag tag);

    public abstract long q(Tag tag);

    public abstract short r(Tag tag);

    public abstract String s(Tag tag);

    public final Tag t() {
        return (Tag) Z8.F.E0(this.tagStack);
    }

    public abstract Tag u(SerialDescriptor serialDescriptor, int i10);

    public final ArrayList<Tag> v() {
        return this.tagStack;
    }

    public final Tag w() {
        ArrayList<Tag> arrayList = this.tagStack;
        Tag tagRemove = arrayList.remove(C1173v.o(arrayList));
        this.flag = true;
        return tagRemove;
    }

    public final void x(Tag name) {
        this.tagStack.add(name);
    }

    public final <E> E y(Tag tag, InterfaceC5063a<? extends E> block) {
        x(tag);
        E eInvoke = block.invoke();
        if (!this.flag) {
            w();
        }
        this.flag = false;
        return eInvoke;
    }
}
