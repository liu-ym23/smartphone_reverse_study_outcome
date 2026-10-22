package io.ktor.server.config;

import La.K;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.descriptors.SerialDescriptor;
import nb.AbstractC4959l;
import nb.AbstractC4960m;
import ob.AbstractC5018a;
import sb.AbstractC5465c;
import sb.d;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b \u0018\u00002\u00020\u0001B/\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\n2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u001f\u0010(\u001a\u00020'2\u0006\u0010&\u001a\u00020\"2\u0006\u0010\u0005\u001a\u00020\u0003H\u0004¢\u0006\u0004\b(\u0010)R&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0004\u0010*\u001a\u0004\b+\u0010,R\u001a\u0010\u0005\u001a\u00020\u00038\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0005\u0010-\u001a\u0004\b.\u0010/R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u00100\u001a\u0004\b1\u00102¨\u00063"}, d2 = {"Lio/ktor/server/config/AbstractMapConfigDecoder;", "Lob/a;", "", "", C3081a.FOCUS_MAP_NAME, "path", "Lsb/c;", "serializersModule", "<init>", "(Ljava/util/Map;Ljava/lang/String;Lsb/c;)V", "", "decodeInt", "()I", "", "decodeLong", "()J", "", "decodeFloat", "()F", "", "decodeDouble", "()D", "", "decodeBoolean", "()Z", "", "decodeChar", "()C", "", "decodeByte", "()B", "", "decodeShort", "()S", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "enumDescriptor", "decodeEnum", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "descriptor", "Lob/c;", "beginStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Ljava/lang/String;)Lob/c;", "Ljava/util/Map;", "getMap", "()Ljava/util/Map;", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", "Lsb/c;", "getSerializersModule", "()Lsb/c;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class AbstractMapConfigDecoder extends AbstractC5018a {
    private final Map<String, String> map;
    private final String path;
    private final AbstractC5465c serializersModule;

    public /* synthetic */ AbstractMapConfigDecoder(Map map, String str, AbstractC5465c abstractC5465c, int i10, i iVar) {
        this(map, (i10 & 2) != 0 ? "" : str, (i10 & 4) != 0 ? d.a() : abstractC5465c);
    }

    public final ob.c beginStructure(SerialDescriptor descriptor, String path) {
        p.i(descriptor, "descriptor");
        p.i(path, "path");
        AbstractC4959l kind = descriptor.getKind();
        AbstractC4960m abstractC4960m = kind instanceof AbstractC4960m ? (AbstractC4960m) kind : null;
        if (abstractC4960m != null) {
            if (!p.d(abstractC4960m, AbstractC4960m.b.f37294a)) {
                return p.d(abstractC4960m, AbstractC4960m.c.f37295a) ? new SubMapConfigDecoder(this.map, path, getSerializersModule()) : new MapConfigDecoder(this.map, path, getSerializersModule());
            }
            Map<String, String> map = this.map;
            return new ListMapConfigDecoder(map, path, MapConfigDecoderKt.listSize(map, path), getSerializersModule());
        }
        throw new IllegalStateException(("Expected structure but found " + descriptor.getKind()).toString());
    }

    @Override // ob.AbstractC5018a, kotlinx.serialization.encoding.Decoder
    public boolean decodeBoolean() {
        return Boolean.parseBoolean(decodeString());
    }

    @Override // ob.AbstractC5018a, kotlinx.serialization.encoding.Decoder
    public byte decodeByte() {
        return Byte.parseByte(decodeString());
    }

    @Override // ob.AbstractC5018a, kotlinx.serialization.encoding.Decoder
    public char decodeChar() {
        return K.Q1(decodeString());
    }

    @Override // ob.AbstractC5018a, kotlinx.serialization.encoding.Decoder
    public double decodeDouble() {
        return Double.parseDouble(decodeString());
    }

    @Override // ob.c
    public abstract /* synthetic */ int decodeElementIndex(SerialDescriptor serialDescriptor);

    @Override // ob.AbstractC5018a, kotlinx.serialization.encoding.Decoder
    public int decodeEnum(SerialDescriptor enumDescriptor) {
        p.i(enumDescriptor, "enumDescriptor");
        return enumDescriptor.c(decodeString());
    }

    @Override // ob.AbstractC5018a, kotlinx.serialization.encoding.Decoder
    public float decodeFloat() {
        return Float.parseFloat(decodeString());
    }

    @Override // ob.AbstractC5018a, kotlinx.serialization.encoding.Decoder
    public int decodeInt() {
        return Integer.parseInt(decodeString());
    }

    @Override // ob.AbstractC5018a, kotlinx.serialization.encoding.Decoder
    public long decodeLong() {
        return Long.parseLong(decodeString());
    }

    @Override // ob.AbstractC5018a, kotlinx.serialization.encoding.Decoder
    public short decodeShort() {
        return Short.parseShort(decodeString());
    }

    public final Map<String, String> getMap() {
        return this.map;
    }

    public final String getPath() {
        return this.path;
    }

    @Override // ob.c
    public AbstractC5465c getSerializersModule() {
        return this.serializersModule;
    }

    public AbstractMapConfigDecoder(Map<String, String> map, String path, AbstractC5465c serializersModule) {
        p.i(map, "map");
        p.i(path, "path");
        p.i(serializersModule, "serializersModule");
        this.map = map;
        this.path = path;
        this.serializersModule = serializersModule;
    }
}
