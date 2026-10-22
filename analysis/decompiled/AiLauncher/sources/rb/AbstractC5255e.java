package rb;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Encoder;
import nb.AbstractC4951d;
import nb.AbstractC4952e;
import nb.AbstractC4959l;
import nb.AbstractC4960m;
import p9.InterfaceC5074l;
import pb.AbstractC5117q0;
import qb.AbstractC5171a;
import qb.C5168A;
import qb.JsonConfiguration;
import sb.AbstractC5465c;

@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0002\r\u0012\b2\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0016H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010#\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u0006H&¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0006H&¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0007H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0007H\u0016¢\u0006\u0004\b)\u0010(J\u0017\u0010*\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b*\u0010+J\u001f\u0010-\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u0016H\u0014¢\u0006\u0004\b-\u0010.J\u001f\u00100\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020/H\u0014¢\u0006\u0004\b0\u00101J\u001f\u00103\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010,\u001a\u000202H\u0014¢\u0006\u0004\b3\u00104J\u001f\u00106\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010,\u001a\u000205H\u0014¢\u0006\u0004\b6\u00107J\u001f\u00109\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010,\u001a\u000208H\u0014¢\u0006\u0004\b9\u0010:J+\u0010>\u001a\u00020\u0007\"\u0004\b\u0000\u0010;2\f\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000<2\u0006\u0010,\u001a\u00028\u0000H\u0016¢\u0006\u0004\b>\u0010?J\u001f\u0010A\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020@H\u0014¢\u0006\u0004\bA\u0010BJ\u001f\u0010C\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u001aH\u0014¢\u0006\u0004\bC\u0010DJ\u001f\u0010F\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020EH\u0014¢\u0006\u0004\bF\u0010GJ\u001f\u0010H\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000bH\u0014¢\u0006\u0004\bH\u0010IJ'\u0010L\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020\u00102\u0006\u0010K\u001a\u00020\u0016H\u0014¢\u0006\u0004\bL\u0010MJ\u001f\u0010O\u001a\u00020N2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\bO\u0010PJ\u0017\u0010Q\u001a\u00020N2\u0006\u0010\u0015\u001a\u00020\u0010H\u0016¢\u0006\u0004\bQ\u0010RJ\u0017\u0010T\u001a\u00020S2\u0006\u0010\u0015\u001a\u00020\u0010H\u0016¢\u0006\u0004\bT\u0010UJ\u0017\u0010V\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0010H\u0014¢\u0006\u0004\bV\u0010WR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[R&\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_R\u0014\u0010c\u001a\u00020`8\u0004X\u0085\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010dR\u0018\u0010g\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010dR\u0011\u0010k\u001a\u00020h8F¢\u0006\u0006\u001a\u0004\bi\u0010j\u0082\u0001\u0003lmn¨\u0006o"}, d2 = {"Lrb/e;", "Lpb/q0;", "Lqb/s;", "Lqb/a;", "json", "Lkotlin/Function1;", "Lqb/i;", "LY8/t;", "nodeConsumer", "<init>", "(Lqb/a;Lp9/l;)V", "", "tag", "rb/e$b", "r0", "(Ljava/lang/String;)Lrb/e$b;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "inlineDescriptor", "rb/e$a", "q0", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;)Lrb/e$a;", "descriptor", "", "index", "X", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Ljava/lang/String;", "", "y", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", "parentName", "childName", ExifInterface.LONGITUDE_WEST, "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "key", "element", "s0", "(Ljava/lang/String;Lqb/i;)V", "o0", "()Lqb/i;", "u", "()V", "m", "l0", "(Ljava/lang/String;)V", UxipConstants.f30680s, "j0", "(Ljava/lang/String;I)V", "", "d0", "(Ljava/lang/String;B)V", "", "m0", "(Ljava/lang/String;S)V", "", "k0", "(Ljava/lang/String;J)V", "", "h0", "(Ljava/lang/String;F)V", ExifInterface.GPS_DIRECTION_TRUE, "Llb/m;", "serializer", "e", "(Llb/m;Ljava/lang/Object;)V", "", "f0", "(Ljava/lang/String;D)V", "c0", "(Ljava/lang/String;Z)V", "", "e0", "(Ljava/lang/String;C)V", "n0", "(Ljava/lang/String;Ljava/lang/String;)V", "enumDescriptor", "ordinal", "g0", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;I)V", "Lkotlinx/serialization/encoding/Encoder;", "i0", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Encoder;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Encoder;", "Lob/d;", "beginStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lob/d;", "Q", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", Const.INTENT_KEY_PKGNAME, "Lqb/a;", Const.INTENT_KEY_APIKEY, "()Lqb/a;", "c", "Lp9/l;", "p0", "()Lp9/l;", "Lqb/f;", Const.INTENT_KEY_UMID, "Lqb/f;", "configuration", "Ljava/lang/String;", "polymorphicDiscriminator", "f", "polymorphicSerialName", "Lsb/c;", "getSerializersModule", "()Lsb/c;", "serializersModule", "Lrb/x;", "Lrb/C;", "Lrb/E;", "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: rb.e, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC5255e extends AbstractC5117q0 implements qb.s {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final AbstractC5171a json;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5074l<qb.i, Y8.t> nodeConsumer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final JsonConfiguration configuration;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public String polymorphicDiscriminator;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public String polymorphicSerialName;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"rb/e$a", "Lob/b;", "", UxipConstants.f30680s, "LY8/t;", "D", "(Ljava/lang/String;)V", "Lsb/c;", "getSerializersModule", "()Lsb/c;", "serializersModule", "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: rb.e$a */
    public static final class a extends ob.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f38977b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SerialDescriptor f38978c;

        public a(String str, SerialDescriptor serialDescriptor) {
            this.f38977b = str;
            this.f38978c = serialDescriptor;
        }

        @Override // ob.b, kotlinx.serialization.encoding.Encoder
        public void D(String value) {
            kotlin.jvm.internal.p.i(value, "value");
            AbstractC5255e.this.s0(this.f38977b, new qb.w(value, false, this.f38978c));
        }

        @Override // kotlinx.serialization.encoding.Encoder
        public AbstractC5465c getSerializersModule() {
            return AbstractC5255e.this.getJson().getSerializersModule();
        }
    }

    @Metadata(d1 = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0019\u001a\u00020\u00148\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"rb/e$b", "Lob/b;", "", "s", "LY8/t;", "G", "(Ljava/lang/String;)V", "", UxipConstants.f30680s, "z", "(I)V", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(J)V", "", Const.INTENT_KEY_UMID, "(B)V", "", "o", "(S)V", "Lsb/c;", Const.INTENT_KEY_APIKEY, "Lsb/c;", "getSerializersModule", "()Lsb/c;", "serializersModule", "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: rb.e$b */
    public static final class b extends ob.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final AbstractC5465c serializersModule;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f38981c;

        public b(String str) {
            this.f38981c = str;
            this.serializersModule = AbstractC5255e.this.getJson().getSerializersModule();
        }

        public final void G(String s10) {
            kotlin.jvm.internal.p.i(s10, "s");
            AbstractC5255e.this.s0(this.f38981c, new qb.w(s10, false, null, 4, null));
        }

        @Override // ob.b, kotlinx.serialization.encoding.Encoder
        public void d(byte value) {
            G(Y8.k.j(Y8.k.b(value)));
        }

        @Override // kotlinx.serialization.encoding.Encoder
        public AbstractC5465c getSerializersModule() {
            return this.serializersModule;
        }

        @Override // ob.b, kotlinx.serialization.encoding.Encoder
        public void i(long value) {
            G(Long.toUnsignedString(Y8.o.b(value)));
        }

        @Override // ob.b, kotlinx.serialization.encoding.Encoder
        public void o(short value) {
            G(Y8.r.i(Y8.r.b(value)));
        }

        @Override // ob.b, kotlinx.serialization.encoding.Encoder
        public void z(int value) {
            G(Integer.toUnsignedString(Y8.m.b(value)));
        }
    }

    public /* synthetic */ AbstractC5255e(AbstractC5171a abstractC5171a, InterfaceC5074l interfaceC5074l, kotlin.jvm.internal.i iVar) {
        this(abstractC5171a, interfaceC5074l);
    }

    public static final Y8.t b0(AbstractC5255e abstractC5255e, qb.i node) {
        kotlin.jvm.internal.p.i(node, "node");
        abstractC5255e.s0(abstractC5255e.R(), node);
        return Y8.t.f7040a;
    }

    @Override // pb.c1
    public void Q(SerialDescriptor descriptor) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        this.nodeConsumer.invoke(o0());
    }

    @Override // pb.AbstractC5117q0
    public String W(String parentName, String childName) {
        kotlin.jvm.internal.p.i(parentName, "parentName");
        kotlin.jvm.internal.p.i(childName, "childName");
        return childName;
    }

    @Override // pb.AbstractC5117q0
    public String X(SerialDescriptor descriptor, int index) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        return u.h(descriptor, this.json, index);
    }

    @Override // qb.s
    /* renamed from: a, reason: from getter */
    public final AbstractC5171a getJson() {
        return this.json;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public ob.d beginStructure(SerialDescriptor descriptor) {
        AbstractC5255e c5250e;
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        InterfaceC5074l<qb.i, Y8.t> interfaceC5074l = S() == null ? this.nodeConsumer : new InterfaceC5074l() { // from class: rb.d
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AbstractC5255e.b0(this.f38970a, (qb.i) obj);
            }
        };
        AbstractC4959l kind = descriptor.getKind();
        if (kotlin.jvm.internal.p.d(kind, AbstractC4960m.b.f37294a) || (kind instanceof AbstractC4951d)) {
            c5250e = new C5250E(this.json, interfaceC5074l);
        } else if (kotlin.jvm.internal.p.d(kind, AbstractC4960m.c.f37295a)) {
            AbstractC5171a abstractC5171a = this.json;
            SerialDescriptor serialDescriptorA = T.a(descriptor.g(0), abstractC5171a.getSerializersModule());
            AbstractC4959l kind2 = serialDescriptorA.getKind();
            if ((kind2 instanceof AbstractC4952e) || kotlin.jvm.internal.p.d(kind2, AbstractC4959l.b.f37292a)) {
                c5250e = new G(this.json, interfaceC5074l);
            } else {
                if (!abstractC5171a.getConfiguration().getAllowStructuredMapKeys()) {
                    throw C5268s.d(serialDescriptorA);
                }
                c5250e = new C5250E(this.json, interfaceC5074l);
            }
        } else {
            c5250e = new C5248C(this.json, interfaceC5074l);
        }
        String str = this.polymorphicDiscriminator;
        if (str != null) {
            if (c5250e instanceof G) {
                G g10 = (G) c5250e;
                g10.s0("key", qb.j.c(str));
                String serialName = this.polymorphicSerialName;
                if (serialName == null) {
                    serialName = descriptor.getSerialName();
                }
                g10.s0(UxipConstants.f30680s, qb.j.c(serialName));
            } else {
                String serialName2 = this.polymorphicSerialName;
                if (serialName2 == null) {
                    serialName2 = descriptor.getSerialName();
                }
                c5250e.s0(str, qb.j.c(serialName2));
            }
            this.polymorphicDiscriminator = null;
            this.polymorphicSerialName = null;
        }
        return c5250e;
    }

    @Override // pb.c1
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public void F(String tag, boolean value) {
        kotlin.jvm.internal.p.i(tag, "tag");
        s0(tag, qb.j.a(Boolean.valueOf(value)));
    }

    @Override // pb.c1
    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public void G(String tag, byte value) {
        kotlin.jvm.internal.p.i(tag, "tag");
        s0(tag, qb.j.b(Byte.valueOf(value)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0087  */
    @Override // pb.c1, kotlinx.serialization.encoding.Encoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <T> void e(lb.m<? super T> r4, T r5) {
        /*
            r3 = this;
            java.lang.String r0 = "serializer"
            kotlin.jvm.internal.p.i(r4, r0)
            java.lang.Object r0 = r3.S()
            if (r0 != 0) goto L2b
            kotlinx.serialization.descriptors.SerialDescriptor r0 = r4.getDescriptor()
            sb.c r1 = r3.getSerializersModule()
            kotlinx.serialization.descriptors.SerialDescriptor r0 = rb.T.a(r0, r1)
            boolean r0 = rb.S.b(r0)
            if (r0 != 0) goto L1e
            goto L2b
        L1e:
            rb.x r0 = new rb.x
            qb.a r1 = r3.json
            p9.l<qb.i, Y8.t> r3 = r3.nodeConsumer
            r0.<init>(r1, r3)
            r0.e(r4, r5)
            return
        L2b:
            qb.a r0 = r3.getJson()
            qb.f r0 = r0.getConfiguration()
            boolean r0 = r0.getUseArrayPolymorphism()
            if (r0 == 0) goto L3d
            r4.serialize(r3, r5)
            return
        L3d:
            boolean r0 = r4 instanceof pb.AbstractC5086b
            if (r0 == 0) goto L52
            qb.a r1 = r3.getJson()
            qb.f r1 = r1.getConfiguration()
            kotlinx.serialization.json.ClassDiscriminatorMode r1 = r1.getClassDiscriminatorMode()
            kotlinx.serialization.json.ClassDiscriminatorMode r2 = kotlinx.serialization.json.ClassDiscriminatorMode.NONE
            if (r1 == r2) goto L9a
            goto L87
        L52:
            qb.a r1 = r3.getJson()
            qb.f r1 = r1.getConfiguration()
            kotlinx.serialization.json.ClassDiscriminatorMode r1 = r1.getClassDiscriminatorMode()
            int[] r2 = rb.H.a.f38936a
            int r1 = r1.ordinal()
            r1 = r2[r1]
            r2 = 1
            if (r1 == r2) goto L9a
            r2 = 2
            if (r1 == r2) goto L9a
            r2 = 3
            if (r1 != r2) goto L94
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r4.getDescriptor()
            nb.l r1 = r1.getKind()
            nb.m$a r2 = nb.AbstractC4960m.a.f37293a
            boolean r2 = kotlin.jvm.internal.p.d(r1, r2)
            if (r2 != 0) goto L87
            nb.m$d r2 = nb.AbstractC4960m.d.f37296a
            boolean r1 = kotlin.jvm.internal.p.d(r1, r2)
            if (r1 == 0) goto L9a
        L87:
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r4.getDescriptor()
            qb.a r2 = r3.getJson()
            java.lang.String r1 = rb.H.c(r1, r2)
            goto L9b
        L94:
            kotlin.NoWhenBranchMatchedException r3 = new kotlin.NoWhenBranchMatchedException
            r3.<init>()
            throw r3
        L9a:
            r1 = 0
        L9b:
            if (r0 == 0) goto Le1
            r0 = r4
            pb.b r0 = (pb.AbstractC5086b) r0
            if (r5 == 0) goto Lbd
            lb.m r0 = lb.f.b(r0, r3, r5)
            if (r1 == 0) goto Lb6
            rb.H.a(r4, r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r4 = r0.getDescriptor()
            nb.l r4 = r4.getKind()
            rb.H.b(r4)
        Lb6:
            java.lang.String r4 = "null cannot be cast to non-null type kotlinx.serialization.SerializationStrategy<T of kotlinx.serialization.json.internal.PolymorphicKt.encodePolymorphically>"
            kotlin.jvm.internal.p.g(r0, r4)
            r4 = r0
            goto Le1
        Lbd:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Value for serializer "
            r3.append(r4)
            kotlinx.serialization.descriptors.SerialDescriptor r4 = r0.getDescriptor()
            r3.append(r4)
            java.lang.String r4 = " should always be non-null. Please report issue to the kotlinx.serialization tracker."
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r3 = r3.toString()
            r4.<init>(r3)
            throw r4
        Le1:
            if (r1 == 0) goto Lef
            kotlinx.serialization.descriptors.SerialDescriptor r0 = r4.getDescriptor()
            java.lang.String r0 = r0.getSerialName()
            r3.polymorphicDiscriminator = r1
            r3.polymorphicSerialName = r0
        Lef:
            r4.serialize(r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rb.AbstractC5255e.e(lb.m, java.lang.Object):void");
    }

    @Override // pb.c1
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public void H(String tag, char value) {
        kotlin.jvm.internal.p.i(tag, "tag");
        s0(tag, qb.j.c(String.valueOf(value)));
    }

    @Override // pb.c1
    /* renamed from: f0, reason: merged with bridge method [inline-methods] */
    public void I(String tag, double value) {
        kotlin.jvm.internal.p.i(tag, "tag");
        s0(tag, qb.j.b(Double.valueOf(value)));
        if (!this.configuration.getAllowSpecialFloatingPointValues() && Math.abs(value) > Double.MAX_VALUE) {
            throw C5268s.c(Double.valueOf(value), tag, o0().toString());
        }
    }

    @Override // pb.c1
    /* renamed from: g0, reason: merged with bridge method [inline-methods] */
    public void J(String tag, SerialDescriptor enumDescriptor, int ordinal) {
        kotlin.jvm.internal.p.i(tag, "tag");
        kotlin.jvm.internal.p.i(enumDescriptor, "enumDescriptor");
        s0(tag, qb.j.c(enumDescriptor.e(ordinal)));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final AbstractC5465c getSerializersModule() {
        return this.json.getSerializersModule();
    }

    @Override // pb.c1, kotlinx.serialization.encoding.Encoder
    public Encoder h(SerialDescriptor descriptor) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        if (S() == null) {
            return new x(this.json, this.nodeConsumer).h(descriptor);
        }
        if (this.polymorphicDiscriminator != null) {
            this.polymorphicSerialName = descriptor.getSerialName();
        }
        return super.h(descriptor);
    }

    @Override // pb.c1
    /* renamed from: h0, reason: merged with bridge method [inline-methods] */
    public void K(String tag, float value) {
        kotlin.jvm.internal.p.i(tag, "tag");
        s0(tag, qb.j.b(Float.valueOf(value)));
        if (!this.configuration.getAllowSpecialFloatingPointValues() && Math.abs(value) > Float.MAX_VALUE) {
            throw C5268s.c(Float.valueOf(value), tag, o0().toString());
        }
    }

    @Override // pb.c1
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public Encoder L(String tag, SerialDescriptor inlineDescriptor) {
        kotlin.jvm.internal.p.i(tag, "tag");
        kotlin.jvm.internal.p.i(inlineDescriptor, "inlineDescriptor");
        return K.b(inlineDescriptor) ? r0(tag) : K.a(inlineDescriptor) ? q0(tag, inlineDescriptor) : super.L(tag, inlineDescriptor);
    }

    @Override // pb.c1
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void M(String tag, int value) {
        kotlin.jvm.internal.p.i(tag, "tag");
        s0(tag, qb.j.b(Integer.valueOf(value)));
    }

    @Override // pb.c1
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void N(String tag, long value) {
        kotlin.jvm.internal.p.i(tag, "tag");
        s0(tag, qb.j.b(Long.valueOf(value)));
    }

    public void l0(String tag) {
        kotlin.jvm.internal.p.i(tag, "tag");
        s0(tag, C5168A.INSTANCE);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void m() {
        String strS = S();
        if (strS == null) {
            this.nodeConsumer.invoke(C5168A.INSTANCE);
        } else {
            l0(strS);
        }
    }

    @Override // pb.c1
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void O(String tag, short value) {
        kotlin.jvm.internal.p.i(tag, "tag");
        s0(tag, qb.j.b(Short.valueOf(value)));
    }

    @Override // pb.c1
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void P(String tag, String value) {
        kotlin.jvm.internal.p.i(tag, "tag");
        kotlin.jvm.internal.p.i(value, "value");
        s0(tag, qb.j.c(value));
    }

    public abstract qb.i o0();

    public final InterfaceC5074l<qb.i, Y8.t> p0() {
        return this.nodeConsumer;
    }

    public final a q0(String tag, SerialDescriptor inlineDescriptor) {
        return new a(tag, inlineDescriptor);
    }

    public final b r0(String tag) {
        return new b(tag);
    }

    public abstract void s0(String key, qb.i element);

    @Override // kotlinx.serialization.encoding.Encoder
    public void u() {
    }

    @Override // ob.d
    public boolean y(SerialDescriptor descriptor, int index) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        return this.configuration.getEncodeDefaults();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AbstractC5255e(AbstractC5171a abstractC5171a, InterfaceC5074l<? super qb.i, Y8.t> interfaceC5074l) {
        this.json = abstractC5171a;
        this.nodeConsumer = interfaceC5074l;
        this.configuration = abstractC5171a.getConfiguration();
    }
}
