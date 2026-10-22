package kotlinx.serialization.internal;

import b5.y;
import b5.z;
import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0003B\t\bB¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\u00020\t*\u00020\u0002H\u0094\u0080\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\u0005*\u00020\u0002H\u0094\u0080\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u000f\u001a\u00020\u0002H\u0094\u0080\u0004¢\u0006\u0004\b\u0010\u0010\u0011J*\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0094\u0080\u0004J)\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\tH\u0094\u0080\u0004¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lkotlinx/serialization/internal/UShortArraySerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlin/UShortArray;", "Lkotlinx/serialization/internal/PrimitiveArraySerializer;", "Lkotlin/UShort;", "Lkotlinx/serialization/internal/UShortArrayBuilder;", "<init>", "()V", "collectionSize", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "collectionSize-rL5Bavg", "([S)I", "toBuilder", "toBuilder-rL5Bavg", "([S)Lkotlinx/serialization/internal/UShortArrayBuilder;", "empty", "empty-amswpOA", "()[S", "readElement", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "decoder", "Lkotlinx/serialization/encoding/CompositeDecoder;", "index", "builder", "checkIndex", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "writeContent", "encoder", "Lkotlinx/serialization/encoding/CompositeEncoder;", "content", "size", "writeContent-eny0XGE", "(Lkotlinx/serialization/encoding/CompositeEncoder;[SI)V", "kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
@ExperimentalSerializationApi
/* loaded from: classes.dex */
public final class UShortArraySerializer extends PrimitiveArraySerializer<y, z, UShortArrayBuilder> implements KSerializer<z> {
    public static final UShortArraySerializer INSTANCE = new UShortArraySerializer();

    private UShortArraySerializer() {
        super(BuiltinSerializersKt.serializer(y.f918b));
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public /* synthetic */ int collectionSize(Object obj) {
        return m32collectionSizerL5Bavg(((z) obj).f920a);
    }

    /* renamed from: collectionSize-rL5Bavg, reason: not valid java name */
    public int m32collectionSizerL5Bavg(short[] collectionSize) {
        p.e(collectionSize, "$this$collectionSize");
        return collectionSize.length;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public /* synthetic */ z empty() {
        return new z(m33emptyamswpOA());
    }

    /* renamed from: empty-amswpOA, reason: not valid java name */
    public short[] m33emptyamswpOA() {
        return new short[0];
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public /* synthetic */ Object toBuilder(Object obj) {
        return m34toBuilderrL5Bavg(((z) obj).f920a);
    }

    /* renamed from: toBuilder-rL5Bavg, reason: not valid java name */
    public UShortArrayBuilder m34toBuilderrL5Bavg(short[] toBuilder) {
        p.e(toBuilder, "$this$toBuilder");
        return new UShortArrayBuilder(toBuilder, null);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public /* synthetic */ void writeContent(CompositeEncoder compositeEncoder, z zVar, int i8) {
        m35writeContenteny0XGE(compositeEncoder, zVar.f920a, i8);
    }

    /* renamed from: writeContent-eny0XGE, reason: not valid java name */
    public void m35writeContenteny0XGE(CompositeEncoder encoder, short[] content, int size) {
        p.e(encoder, "encoder");
        p.e(content, "content");
        for (int i8 = 0; i8 < size; i8++) {
            encoder.encodeInlineElement(getDescriptor(), i8).encodeShort(content[i8]);
        }
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public void readElement(CompositeDecoder decoder, int index, UShortArrayBuilder builder, boolean checkIndex) {
        p.e(decoder, "decoder");
        p.e(builder, "builder");
        builder.m30appendxj2QHRw$kotlinx_serialization_core(decoder.decodeInlineElement(getDescriptor(), index).decodeShort());
    }
}
