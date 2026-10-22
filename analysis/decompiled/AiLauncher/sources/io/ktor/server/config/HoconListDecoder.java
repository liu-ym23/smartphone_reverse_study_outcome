package io.ktor.server.config;

import b8.InterfaceC1455a;
import b8.InterfaceC1461g;
import b8.j;
import b8.p;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.i;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import nb.AbstractC4959l;
import nb.AbstractC4960m;
import ob.AbstractC5018a;
import sb.AbstractC5465c;
import sb.d;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\fJ\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001eR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020$8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006("}, d2 = {"Lio/ktor/server/config/HoconListDecoder;", "Lob/a;", "Lb8/g;", "list", "Lsb/c;", "serializersModule", "<init>", "(Lb8/g;Lsb/c;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "", "decodeElementIndex", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "", "decodeValue", "()Ljava/lang/Object;", "", "decodeString", "()Ljava/lang/String;", "enumDescriptor", "decodeEnum", "", "decodeLong", "()J", "", "decodeDouble", "()D", "Lob/c;", "beginStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lob/c;", "Lb8/g;", "Lsb/c;", "getSerializersModule", "()Lsb/c;", "elementIndex", "I", "Lb8/p;", "getCurrentElement", "()Lb8/p;", "currentElement", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HoconListDecoder extends AbstractC5018a {
    private int elementIndex;
    private final InterfaceC1461g list;
    private final AbstractC5465c serializersModule;

    public /* synthetic */ HoconListDecoder(InterfaceC1461g interfaceC1461g, AbstractC5465c abstractC5465c, int i10, i iVar) {
        this(interfaceC1461g, (i10 & 2) != 0 ? d.a() : abstractC5465c);
    }

    private final p getCurrentElement() {
        p pVar = this.list.get(this.elementIndex - 1);
        kotlin.jvm.internal.p.h(pVar, "get(...)");
        return pVar;
    }

    @Override // ob.AbstractC5018a, kotlinx.serialization.encoding.Decoder
    public ob.c beginStructure(SerialDescriptor descriptor) {
        InterfaceC1455a interfaceC1455aK;
        InterfaceC1455a interfaceC1455aK2;
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        AbstractC4959l kind = descriptor.getKind();
        kotlin.jvm.internal.p.g(kind, "null cannot be cast to non-null type kotlinx.serialization.descriptors.StructureKind");
        AbstractC4960m abstractC4960m = (AbstractC4960m) kind;
        if (kotlin.jvm.internal.p.d(abstractC4960m, AbstractC4960m.b.f37294a)) {
            p currentElement = getCurrentElement();
            InterfaceC1461g interfaceC1461g = currentElement instanceof InterfaceC1461g ? (InterfaceC1461g) currentElement : null;
            if (interfaceC1461g != null) {
                return new HoconListDecoder(interfaceC1461g, getSerializersModule());
            }
            throw new SerializationException("Expected a ConfigList but got " + getCurrentElement());
        }
        if (kotlin.jvm.internal.p.d(abstractC4960m, AbstractC4960m.c.f37295a)) {
            p currentElement2 = getCurrentElement();
            j jVar = currentElement2 instanceof j ? (j) currentElement2 : null;
            if (jVar != null && (interfaceC1455aK2 = jVar.k()) != null) {
                return new HoconMapDecoder(interfaceC1455aK2, getSerializersModule());
            }
            throw new SerializationException("Expected a ConfigObject but got " + getCurrentElement());
        }
        if (!kotlin.jvm.internal.p.d(abstractC4960m, AbstractC4960m.a.f37293a) && !kotlin.jvm.internal.p.d(abstractC4960m, AbstractC4960m.d.f37296a)) {
            throw new NoWhenBranchMatchedException();
        }
        p currentElement3 = getCurrentElement();
        j jVar2 = currentElement3 instanceof j ? (j) currentElement3 : null;
        if (jVar2 != null && (interfaceC1455aK = jVar2.k()) != null) {
            return new HoconDecoder(interfaceC1455aK, "", getSerializersModule());
        }
        throw new SerializationException("Expected a ConfigObject but got " + getCurrentElement());
    }

    @Override // ob.AbstractC5018a, kotlinx.serialization.encoding.Decoder
    public double decodeDouble() {
        Object objA = this.list.get(this.elementIndex - 1).a();
        if (objA instanceof Integer) {
            return ((Number) objA).intValue();
        }
        if (objA instanceof Long) {
            return ((Number) objA).longValue();
        }
        if (objA instanceof Double) {
            return ((Number) objA).doubleValue();
        }
        throw new SerializationException("Cannot decode Double from " + objA);
    }

    @Override // ob.c
    public int decodeElementIndex(SerialDescriptor descriptor) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        if (this.elementIndex >= this.list.size()) {
            return -1;
        }
        int i10 = this.elementIndex;
        this.elementIndex = i10 + 1;
        return i10;
    }

    @Override // ob.AbstractC5018a, kotlinx.serialization.encoding.Decoder
    public int decodeEnum(SerialDescriptor enumDescriptor) {
        kotlin.jvm.internal.p.i(enumDescriptor, "enumDescriptor");
        return enumDescriptor.c(decodeString());
    }

    @Override // ob.AbstractC5018a, kotlinx.serialization.encoding.Decoder
    public long decodeLong() {
        Object objA = getCurrentElement().a();
        if (objA instanceof Integer) {
            return ((Number) objA).intValue();
        }
        if (objA instanceof Long) {
            return ((Number) objA).longValue();
        }
        throw new SerializationException("Cannot decode Long from " + objA);
    }

    @Override // ob.AbstractC5018a, kotlinx.serialization.encoding.Decoder
    public String decodeString() {
        return getCurrentElement().a().toString();
    }

    @Override // ob.AbstractC5018a
    public Object decodeValue() {
        Object objA = getCurrentElement().a();
        kotlin.jvm.internal.p.h(objA, "unwrapped(...)");
        return objA;
    }

    @Override // ob.c
    public AbstractC5465c getSerializersModule() {
        return this.serializersModule;
    }

    public HoconListDecoder(InterfaceC1461g list, AbstractC5465c serializersModule) {
        kotlin.jvm.internal.p.i(list, "list");
        kotlin.jvm.internal.p.i(serializersModule, "serializersModule");
        this.list = list;
        this.serializersModule = serializersModule;
    }
}
