package io.ktor.server.config;

import b8.InterfaceC1455a;
import b8.InterfaceC1461g;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.descriptors.SerialDescriptor;
import nb.AbstractC4959l;
import nb.AbstractC4960m;
import ob.AbstractC5018a;
import sb.AbstractC5465c;
import sb.d;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0010\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0004H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\f2\u0006\u0010)\u001a\u00020\nH\u0016¢\u0006\u0004\b*\u0010\u000eJ\u0017\u0010,\u001a\u00020+2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b,\u0010-R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010.R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010/R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u00100\u001a\u0004\b1\u00102R\"\u00103\u001a\u00020\f8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u0010\u001a\"\u0004\b6\u00107R\"\u00108\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b8\u0010/\u001a\u0004\b9\u0010(\"\u0004\b:\u0010;¨\u0006<"}, d2 = {"Lio/ktor/server/config/HoconDecoder;", "Lob/a;", "Lb8/a;", "config", "", "path", "Lsb/c;", "serializersModule", "<init>", "(Lb8/a;Ljava/lang/String;Lsb/c;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "", "decodeElementIndex", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "", "decodeNotNullMark", "()Z", "decodeBoolean", "", "decodeByte", "()B", "", "decodeShort", "()S", "decodeInt", "()I", "", "decodeLong", "()J", "", "decodeFloat", "()F", "", "decodeDouble", "()D", "", "decodeChar", "()C", "decodeString", "()Ljava/lang/String;", "enumDescriptor", "decodeEnum", "Lob/c;", "beginStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lob/c;", "Lb8/a;", "Ljava/lang/String;", "Lsb/c;", "getSerializersModule", "()Lsb/c;", "elementIndex", "I", "getElementIndex", "setElementIndex", "(I)V", "currentPath", "getCurrentPath", "setCurrentPath", "(Ljava/lang/String;)V", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public class HoconDecoder extends AbstractC5018a {
    private final InterfaceC1455a config;
    private String currentPath;
    private int elementIndex;
    private final String path;
    private final AbstractC5465c serializersModule;

    public /* synthetic */ HoconDecoder(InterfaceC1455a interfaceC1455a, String str, AbstractC5465c abstractC5465c, int i10, i iVar) {
        this(interfaceC1455a, (i10 & 2) != 0 ? "" : str, (i10 & 4) != 0 ? d.a() : abstractC5465c);
    }

    @Override // ob.AbstractC5018a, kotlinx.serialization.encoding.Decoder
    public ob.c beginStructure(SerialDescriptor descriptor) {
        p.i(descriptor, "descriptor");
        AbstractC4959l kind = descriptor.getKind();
        p.g(kind, "null cannot be cast to non-null type kotlinx.serialization.descriptors.StructureKind");
        AbstractC4960m abstractC4960m = (AbstractC4960m) kind;
        if (p.d(abstractC4960m, AbstractC4960m.b.f37294a)) {
            InterfaceC1461g interfaceC1461gU = this.config.u(this.currentPath);
            p.h(interfaceC1461gU, "getList(...)");
            return new HoconListDecoder(interfaceC1461gU, getSerializersModule());
        }
        if (p.d(abstractC4960m, AbstractC4960m.c.f37295a)) {
            InterfaceC1455a interfaceC1455aK = this.config.z(this.currentPath).k();
            p.h(interfaceC1455aK, "toConfig(...)");
            return new HoconMapDecoder(interfaceC1455aK, getSerializersModule());
        }
        if (p.d(abstractC4960m, AbstractC4960m.a.f37293a) || p.d(abstractC4960m, AbstractC4960m.d.f37296a)) {
            return new HoconDecoder(this.config, this.currentPath, getSerializersModule());
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // ob.AbstractC5018a, kotlinx.serialization.encoding.Decoder
    public boolean decodeBoolean() {
        return this.config.i(this.currentPath);
    }

    @Override // ob.AbstractC5018a, kotlinx.serialization.encoding.Decoder
    public byte decodeByte() {
        return (byte) this.config.n(this.currentPath);
    }

    @Override // ob.AbstractC5018a, kotlinx.serialization.encoding.Decoder
    public char decodeChar() {
        return this.config.t(this.currentPath).charAt(0);
    }

    @Override // ob.AbstractC5018a, kotlinx.serialization.encoding.Decoder
    public double decodeDouble() {
        return this.config.J(this.currentPath);
    }

    @Override // ob.c
    public int decodeElementIndex(SerialDescriptor descriptor) {
        p.i(descriptor, "descriptor");
        if (this.elementIndex >= descriptor.getElementsCount()) {
            return -1;
        }
        int i10 = this.elementIndex;
        this.elementIndex = i10 + 1;
        String strE = descriptor.e(i10);
        if (this.path.length() != 0) {
            strE = this.path + '.' + strE;
        }
        if (!this.config.H(strE)) {
            return -1;
        }
        this.currentPath = strE;
        return i10;
    }

    @Override // ob.AbstractC5018a, kotlinx.serialization.encoding.Decoder
    public int decodeEnum(SerialDescriptor enumDescriptor) {
        p.i(enumDescriptor, "enumDescriptor");
        return enumDescriptor.c(decodeString());
    }

    @Override // ob.AbstractC5018a, kotlinx.serialization.encoding.Decoder
    public float decodeFloat() {
        return (float) this.config.J(this.currentPath);
    }

    @Override // ob.AbstractC5018a, kotlinx.serialization.encoding.Decoder
    public int decodeInt() {
        return this.config.n(this.currentPath);
    }

    @Override // ob.AbstractC5018a, kotlinx.serialization.encoding.Decoder
    public long decodeLong() {
        return this.config.j(this.currentPath);
    }

    @Override // ob.AbstractC5018a, kotlinx.serialization.encoding.Decoder
    public boolean decodeNotNullMark() {
        return this.config.H(this.currentPath) && !this.config.A(this.currentPath);
    }

    @Override // ob.AbstractC5018a, kotlinx.serialization.encoding.Decoder
    public short decodeShort() {
        return (short) this.config.n(this.currentPath);
    }

    @Override // ob.AbstractC5018a, kotlinx.serialization.encoding.Decoder
    public String decodeString() {
        String strT = this.config.t(this.currentPath);
        p.h(strT, "getString(...)");
        return strT;
    }

    public final String getCurrentPath() {
        return this.currentPath;
    }

    public final int getElementIndex() {
        return this.elementIndex;
    }

    @Override // ob.c
    public AbstractC5465c getSerializersModule() {
        return this.serializersModule;
    }

    public final void setCurrentPath(String str) {
        p.i(str, "<set-?>");
        this.currentPath = str;
    }

    public final void setElementIndex(int i10) {
        this.elementIndex = i10;
    }

    public HoconDecoder(InterfaceC1455a config, String path, AbstractC5465c serializersModule) {
        p.i(config, "config");
        p.i(path, "path");
        p.i(serializersModule, "serializersModule");
        this.config = config;
        this.path = path;
        this.serializersModule = serializersModule;
        this.currentPath = path;
    }
}
