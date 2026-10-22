package kotlinx.serialization.encoding;

import c5.n;
import com.stepos.stepclaw.SecurePrefs;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.descriptors.SerialDescriptor;
import p5.l;
import p5.q;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a4\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\bH\u0086\u0088\u0004ø\u0001\u0000\u001a<\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\bH\u0086\u0088\u0004ø\u0001\u0000\u001ac\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u000e24\b\u0004\u0010\u0005\u001a.\u0012\u0004\u0012\u00020\u0007\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\bH\u0086\u0088\u0004ø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0013"}, d2 = {"encodeStructure", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lkotlinx/serialization/encoding/Encoder;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "block", "Lkotlin/Function1;", "Lkotlinx/serialization/encoding/CompositeEncoder;", "Lkotlin/ExtensionFunctionType;", "encodeCollection", "collectionSize", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "E", "collection", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "index", "kotlinx-serialization-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EncodingKt {
    public static final void encodeCollection(Encoder encoder, SerialDescriptor descriptor, int i8, l block) {
        p.e(encoder, "<this>");
        p.e(descriptor, "descriptor");
        p.e(block, "block");
        CompositeEncoder compositeEncoderBeginCollection = encoder.beginCollection(descriptor, i8);
        block.invoke(compositeEncoderBeginCollection);
        compositeEncoderBeginCollection.endStructure(descriptor);
    }

    public static final void encodeStructure(Encoder encoder, SerialDescriptor descriptor, l block) {
        p.e(encoder, "<this>");
        p.e(descriptor, "descriptor");
        p.e(block, "block");
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor);
        block.invoke(compositeEncoderBeginStructure);
        compositeEncoderBeginStructure.endStructure(descriptor);
    }

    public static final <E> void encodeCollection(Encoder encoder, SerialDescriptor descriptor, Collection<? extends E> collection, q block) {
        p.e(encoder, "<this>");
        p.e(descriptor, "descriptor");
        p.e(collection, "collection");
        p.e(block, "block");
        CompositeEncoder compositeEncoderBeginCollection = encoder.beginCollection(descriptor, collection.size());
        int i8 = 0;
        for (Object obj : collection) {
            int i9 = i8 + 1;
            if (i8 >= 0) {
                block.invoke(compositeEncoderBeginCollection, Integer.valueOf(i8), obj);
                i8 = i9;
            } else {
                n.m0();
                throw null;
            }
        }
        compositeEncoderBeginCollection.endStructure(descriptor);
    }
}
