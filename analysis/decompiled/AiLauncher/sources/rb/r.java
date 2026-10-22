package rb;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlinx.serialization.descriptors.SerialDescriptor;
import ob.AbstractC5018a;
import qb.AbstractC5171a;
import sb.AbstractC5465c;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001f\u001a\u00020\u001a8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lrb/r;", "Lob/a;", "Lrb/a;", "lexer", "Lqb/a;", "json", "<init>", "(Lrb/a;Lqb/a;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "", "decodeElementIndex", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "decodeInt", "()I", "", "decodeLong", "()J", "", "decodeByte", "()B", "", "decodeShort", "()S", Const.INTENT_KEY_PKGNAME, "Lrb/a;", "Lsb/c;", "c", "Lsb/c;", "getSerializersModule", "()Lsb/c;", "serializersModule", "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class r extends AbstractC5018a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final JsonReader lexer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final AbstractC5465c serializersModule;

    public r(JsonReader lexer, AbstractC5171a json) {
        kotlin.jvm.internal.p.i(lexer, "lexer");
        kotlin.jvm.internal.p.i(json, "json");
        this.lexer = lexer;
        this.serializersModule = json.getSerializersModule();
    }

    @Override // ob.AbstractC5018a, kotlinx.serialization.encoding.Decoder
    public byte decodeByte() {
        JsonReader jsonReader = this.lexer;
        String strS = jsonReader.s();
        try {
            return La.L.a(strS);
        } catch (IllegalArgumentException unused) {
            JsonReader.z(jsonReader, "Failed to parse type 'UByte' for input '" + strS + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }

    @Override // ob.c
    public int decodeElementIndex(SerialDescriptor descriptor) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        throw new IllegalStateException("unsupported");
    }

    @Override // ob.AbstractC5018a, kotlinx.serialization.encoding.Decoder
    public int decodeInt() {
        JsonReader jsonReader = this.lexer;
        String strS = jsonReader.s();
        try {
            return La.L.d(strS);
        } catch (IllegalArgumentException unused) {
            JsonReader.z(jsonReader, "Failed to parse type 'UInt' for input '" + strS + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }

    @Override // ob.AbstractC5018a, kotlinx.serialization.encoding.Decoder
    public long decodeLong() {
        JsonReader jsonReader = this.lexer;
        String strS = jsonReader.s();
        try {
            return La.L.g(strS);
        } catch (IllegalArgumentException unused) {
            JsonReader.z(jsonReader, "Failed to parse type 'ULong' for input '" + strS + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }

    @Override // ob.AbstractC5018a, kotlinx.serialization.encoding.Decoder
    public short decodeShort() {
        JsonReader jsonReader = this.lexer;
        String strS = jsonReader.s();
        try {
            return La.L.j(strS);
        } catch (IllegalArgumentException unused) {
            JsonReader.z(jsonReader, "Failed to parse type 'UShort' for input '" + strS + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }

    @Override // ob.c
    public AbstractC5465c getSerializersModule() {
        return this.serializersModule;
    }
}
