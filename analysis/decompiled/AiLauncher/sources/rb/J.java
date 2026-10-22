package rb;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.internal.WriteMode;
import qb.AbstractC5171a;
import qb.JsonConfiguration;
import sb.AbstractC5465c;

@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fB1\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\u0004\b\u000b\u0010\u000fJ\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J+\u0010\u001c\u001a\u00020\u001b\"\u0004\b\u0000\u0010\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00182\u0006\u0010\u001a\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b!\u0010\"J\u001f\u0010#\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b#\u0010\u0016JA\u0010%\u001a\u00020\u001b\"\b\b\u0000\u0010\u0017*\u00020$2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00182\b\u0010\u001a\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020'2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u001bH\u0016¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0014H\u0016¢\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020.H\u0016¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u000201H\u0016¢\u0006\u0004\b2\u00103J\u0017\u00104\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0012H\u0016¢\u0006\u0004\b4\u00105J\u0017\u00107\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u000206H\u0016¢\u0006\u0004\b7\u00108J\u0017\u0010:\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u000209H\u0016¢\u0006\u0004\b:\u0010;J\u0017\u0010=\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020<H\u0016¢\u0006\u0004\b=\u0010>J\u0017\u0010@\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020?H\u0016¢\u0006\u0004\b@\u0010AJ\u0017\u0010C\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020BH\u0016¢\u0006\u0004\bC\u0010DJ\u001f\u0010F\u001a\u00020\u001b2\u0006\u0010E\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\bF\u0010GJ\u001f\u0010J\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020B2\u0006\u0010I\u001a\u00020BH\u0002¢\u0006\u0004\bJ\u0010KR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bL\u0010PR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010QR\u001e\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010RR\u001a\u0010W\u001a\u00020S8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010T\u001a\u0004\bU\u0010VR\u0014\u0010[\u001a\u00020X8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010]\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010\\R\u0018\u0010_\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010^R\u0018\u0010`\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u0010^¨\u0006a"}, d2 = {"Lrb/J;", "Lqb/s;", "Lob/b;", "Lrb/j;", "composer", "Lqb/a;", "json", "Lkotlinx/serialization/json/internal/WriteMode;", "mode", "", "modeReuseCache", "<init>", "(Lrb/j;Lqb/a;Lkotlinx/serialization/json/internal/WriteMode;[Lqb/s;)V", "Lrb/q;", "output", "(Lrb/q;Lqb/a;Lkotlinx/serialization/json/internal/WriteMode;[Lqb/s;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "", "index", "", "y", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", ExifInterface.GPS_DIRECTION_TRUE, "Llb/m;", "serializer", UxipConstants.f30680s, "LY8/t;", "e", "(Llb/m;Ljava/lang/Object;)V", "Lob/d;", "beginStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lob/d;", "endStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", ExifInterface.LONGITUDE_EAST, "", "k", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILlb/m;Ljava/lang/Object;)V", "Lkotlinx/serialization/encoding/Encoder;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Encoder;", "m", "()V", "p", "(Z)V", "", Const.INTENT_KEY_UMID, "(B)V", "", "o", "(S)V", "z", "(I)V", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(J)V", "", "r", "(F)V", "", "c", "(D)V", "", "s", "(C)V", "", "D", "(Ljava/lang/String;)V", "enumDescriptor", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)V", "discriminator", "serialName", "G", "(Ljava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_APIKEY, "Lrb/j;", Const.INTENT_KEY_PKGNAME, "Lqb/a;", "()Lqb/a;", "Lkotlinx/serialization/json/internal/WriteMode;", "[Lqb/s;", "Lsb/c;", "Lsb/c;", "getSerializersModule", "()Lsb/c;", "serializersModule", "Lqb/f;", "f", "Lqb/f;", "configuration", "Z", "forceQuoting", "Ljava/lang/String;", "polymorphicDiscriminator", "polymorphicSerialName", "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class J extends ob.b implements qb.s {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final C5260j composer;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final AbstractC5171a json;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final WriteMode mode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final qb.s[] modeReuseCache;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final AbstractC5465c serializersModule;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final JsonConfiguration configuration;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public boolean forceQuoting;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public String polymorphicDiscriminator;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public String polymorphicSerialName;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f38956a;

        static {
            int[] iArr = new int[WriteMode.values().length];
            try {
                iArr[WriteMode.LIST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WriteMode.MAP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WriteMode.POLY_OBJ.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f38956a = iArr;
        }
    }

    public J(C5260j composer, AbstractC5171a json, WriteMode mode, qb.s[] sVarArr) {
        kotlin.jvm.internal.p.i(composer, "composer");
        kotlin.jvm.internal.p.i(json, "json");
        kotlin.jvm.internal.p.i(mode, "mode");
        this.composer = composer;
        this.json = json;
        this.mode = mode;
        this.modeReuseCache = sVarArr;
        this.serializersModule = getJson().getSerializersModule();
        this.configuration = getJson().getConfiguration();
        int iOrdinal = mode.ordinal();
        if (sVarArr != null) {
            qb.s sVar = sVarArr[iOrdinal];
            if (sVar == null && sVar == this) {
                return;
            }
            sVarArr[iOrdinal] = this;
        }
    }

    @Override // ob.b, kotlinx.serialization.encoding.Encoder
    public void D(String value) {
        kotlin.jvm.internal.p.i(value, "value");
        this.composer.n(value);
    }

    @Override // ob.b
    public boolean E(SerialDescriptor descriptor, int index) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        int i10 = a.f38956a[this.mode.ordinal()];
        if (i10 != 1) {
            boolean z10 = false;
            if (i10 != 2) {
                if (i10 != 3) {
                    if (!this.composer.getWritingFirst()) {
                        this.composer.f(',');
                    }
                    this.composer.c();
                    D(u.h(descriptor, getJson(), index));
                    this.composer.f(':');
                    this.composer.p();
                } else {
                    if (index == 0) {
                        this.forceQuoting = true;
                    }
                    if (index == 1) {
                        this.composer.f(',');
                        this.composer.p();
                        this.forceQuoting = false;
                    }
                }
            } else if (this.composer.getWritingFirst()) {
                this.forceQuoting = true;
                this.composer.c();
            } else {
                if (index % 2 == 0) {
                    this.composer.f(',');
                    this.composer.c();
                    z10 = true;
                } else {
                    this.composer.f(':');
                    this.composer.p();
                }
                this.forceQuoting = z10;
            }
        } else {
            if (!this.composer.getWritingFirst()) {
                this.composer.f(',');
            }
            this.composer.c();
        }
        return true;
    }

    public final void G(String discriminator, String serialName) {
        this.composer.c();
        D(discriminator);
        this.composer.f(':');
        this.composer.p();
        D(serialName);
    }

    @Override // qb.s
    /* renamed from: a, reason: from getter */
    public AbstractC5171a getJson() {
        return this.json;
    }

    @Override // ob.b, kotlinx.serialization.encoding.Encoder
    public ob.d beginStructure(SerialDescriptor descriptor) {
        qb.s sVar;
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        WriteMode writeModeB = T.b(getJson(), descriptor);
        char c10 = writeModeB.begin;
        if (c10 != 0) {
            this.composer.f(c10);
            this.composer.b();
        }
        String str = this.polymorphicDiscriminator;
        if (str != null) {
            String serialName = this.polymorphicSerialName;
            if (serialName == null) {
                serialName = descriptor.getSerialName();
            }
            G(str, serialName);
            this.polymorphicDiscriminator = null;
            this.polymorphicSerialName = null;
        }
        if (this.mode == writeModeB) {
            return this;
        }
        qb.s[] sVarArr = this.modeReuseCache;
        return (sVarArr == null || (sVar = sVarArr[writeModeB.ordinal()]) == null) ? new J(this.composer, getJson(), writeModeB, this.modeReuseCache) : sVar;
    }

    @Override // ob.b, kotlinx.serialization.encoding.Encoder
    public void c(double value) {
        if (this.forceQuoting) {
            D(String.valueOf(value));
        } else {
            this.composer.g(value);
        }
        if (!this.configuration.getAllowSpecialFloatingPointValues() && Math.abs(value) > Double.MAX_VALUE) {
            throw C5268s.b(Double.valueOf(value), this.composer.writer.toString());
        }
    }

    @Override // ob.b, kotlinx.serialization.encoding.Encoder
    public void d(byte value) {
        if (this.forceQuoting) {
            D(String.valueOf((int) value));
        } else {
            this.composer.e(value);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0061  */
    @Override // ob.b, kotlinx.serialization.encoding.Encoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <T> void e(lb.m<? super T> r4, T r5) {
        /*
            r3 = this;
            java.lang.String r0 = "serializer"
            kotlin.jvm.internal.p.i(r4, r0)
            qb.a r0 = r3.getJson()
            qb.f r0 = r0.getConfiguration()
            boolean r0 = r0.getUseArrayPolymorphism()
            if (r0 == 0) goto L17
            r4.serialize(r3, r5)
            return
        L17:
            boolean r0 = r4 instanceof pb.AbstractC5086b
            if (r0 == 0) goto L2c
            qb.a r1 = r3.getJson()
            qb.f r1 = r1.getConfiguration()
            kotlinx.serialization.json.ClassDiscriminatorMode r1 = r1.getClassDiscriminatorMode()
            kotlinx.serialization.json.ClassDiscriminatorMode r2 = kotlinx.serialization.json.ClassDiscriminatorMode.NONE
            if (r1 == r2) goto L74
            goto L61
        L2c:
            qb.a r1 = r3.getJson()
            qb.f r1 = r1.getConfiguration()
            kotlinx.serialization.json.ClassDiscriminatorMode r1 = r1.getClassDiscriminatorMode()
            int[] r2 = rb.H.a.f38936a
            int r1 = r1.ordinal()
            r1 = r2[r1]
            r2 = 1
            if (r1 == r2) goto L74
            r2 = 2
            if (r1 == r2) goto L74
            r2 = 3
            if (r1 != r2) goto L6e
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r4.getDescriptor()
            nb.l r1 = r1.getKind()
            nb.m$a r2 = nb.AbstractC4960m.a.f37293a
            boolean r2 = kotlin.jvm.internal.p.d(r1, r2)
            if (r2 != 0) goto L61
            nb.m$d r2 = nb.AbstractC4960m.d.f37296a
            boolean r1 = kotlin.jvm.internal.p.d(r1, r2)
            if (r1 == 0) goto L74
        L61:
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r4.getDescriptor()
            qb.a r2 = r3.getJson()
            java.lang.String r1 = rb.H.c(r1, r2)
            goto L75
        L6e:
            kotlin.NoWhenBranchMatchedException r3 = new kotlin.NoWhenBranchMatchedException
            r3.<init>()
            throw r3
        L74:
            r1 = 0
        L75:
            if (r0 == 0) goto Lbb
            r0 = r4
            pb.b r0 = (pb.AbstractC5086b) r0
            if (r5 == 0) goto L97
            lb.m r0 = lb.f.b(r0, r3, r5)
            if (r1 == 0) goto L90
            rb.H.a(r4, r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r4 = r0.getDescriptor()
            nb.l r4 = r4.getKind()
            rb.H.b(r4)
        L90:
            java.lang.String r4 = "null cannot be cast to non-null type kotlinx.serialization.SerializationStrategy<T of kotlinx.serialization.json.internal.PolymorphicKt.encodePolymorphically>"
            kotlin.jvm.internal.p.g(r0, r4)
            r4 = r0
            goto Lbb
        L97:
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
        Lbb:
            if (r1 == 0) goto Lc9
            kotlinx.serialization.descriptors.SerialDescriptor r0 = r4.getDescriptor()
            java.lang.String r0 = r0.getSerialName()
            r3.polymorphicDiscriminator = r1
            r3.polymorphicSerialName = r0
        Lc9:
            r4.serialize(r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rb.J.e(lb.m, java.lang.Object):void");
    }

    @Override // ob.b, ob.d
    public void endStructure(SerialDescriptor descriptor) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        if (this.mode.end != 0) {
            this.composer.q();
            this.composer.d();
            this.composer.f(this.mode.end);
        }
    }

    @Override // ob.b, kotlinx.serialization.encoding.Encoder
    public void g(SerialDescriptor enumDescriptor, int index) {
        kotlin.jvm.internal.p.i(enumDescriptor, "enumDescriptor");
        D(enumDescriptor.e(index));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public AbstractC5465c getSerializersModule() {
        return this.serializersModule;
    }

    @Override // ob.b, kotlinx.serialization.encoding.Encoder
    public Encoder h(SerialDescriptor descriptor) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        if (K.b(descriptor)) {
            C5260j c5262l = this.composer;
            if (!(c5262l instanceof C5262l)) {
                c5262l = new C5262l(c5262l.writer, this.forceQuoting);
            }
            return new J(c5262l, getJson(), this.mode, (qb.s[]) null);
        }
        if (K.a(descriptor)) {
            C5260j c5261k = this.composer;
            if (!(c5261k instanceof C5261k)) {
                c5261k = new C5261k(c5261k.writer, this.forceQuoting);
            }
            return new J(c5261k, getJson(), this.mode, (qb.s[]) null);
        }
        if (this.polymorphicDiscriminator == null) {
            return super.h(descriptor);
        }
        this.polymorphicSerialName = descriptor.getSerialName();
        return this;
    }

    @Override // ob.b, kotlinx.serialization.encoding.Encoder
    public void i(long value) {
        if (this.forceQuoting) {
            D(String.valueOf(value));
        } else {
            this.composer.j(value);
        }
    }

    @Override // ob.b, ob.d
    public <T> void k(SerialDescriptor descriptor, int index, lb.m<? super T> serializer, T value) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        kotlin.jvm.internal.p.i(serializer, "serializer");
        if (value != null || this.configuration.getExplicitNulls()) {
            super.k(descriptor, index, serializer, value);
        }
    }

    @Override // ob.b, kotlinx.serialization.encoding.Encoder
    public void m() {
        this.composer.k("null");
    }

    @Override // ob.b, kotlinx.serialization.encoding.Encoder
    public void o(short value) {
        if (this.forceQuoting) {
            D(String.valueOf((int) value));
        } else {
            this.composer.l(value);
        }
    }

    @Override // ob.b, kotlinx.serialization.encoding.Encoder
    public void p(boolean value) {
        if (this.forceQuoting) {
            D(String.valueOf(value));
        } else {
            this.composer.m(value);
        }
    }

    @Override // ob.b, kotlinx.serialization.encoding.Encoder
    public void r(float value) {
        if (this.forceQuoting) {
            D(String.valueOf(value));
        } else {
            this.composer.h(value);
        }
        if (!this.configuration.getAllowSpecialFloatingPointValues() && Math.abs(value) > Float.MAX_VALUE) {
            throw C5268s.b(Float.valueOf(value), this.composer.writer.toString());
        }
    }

    @Override // ob.b, kotlinx.serialization.encoding.Encoder
    public void s(char value) {
        D(String.valueOf(value));
    }

    @Override // ob.b, ob.d
    public boolean y(SerialDescriptor descriptor, int index) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        return this.configuration.getEncodeDefaults();
    }

    @Override // ob.b, kotlinx.serialization.encoding.Encoder
    public void z(int value) {
        if (this.forceQuoting) {
            D(String.valueOf(value));
        } else {
            this.composer.i(value);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public J(InterfaceC5267q output, AbstractC5171a json, WriteMode mode, qb.s[] modeReuseCache) {
        this(C5264n.a(output, json), json, mode, modeReuseCache);
        kotlin.jvm.internal.p.i(output, "output");
        kotlin.jvm.internal.p.i(json, "json");
        kotlin.jvm.internal.p.i(mode, "mode");
        kotlin.jvm.internal.p.i(modeReuseCache, "modeReuseCache");
    }
}
