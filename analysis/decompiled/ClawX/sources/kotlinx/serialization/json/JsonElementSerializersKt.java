package kotlinx.serialization.json;

import b5.e;
import b8.h;
import com.stepos.stepclaw.SecurePrefs;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.z;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import p5.a;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0082\u0080\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0082\u0080\u0004\u001a\u000e\u0010\u0006\u001a\u00020\u0007*\u00020\u0005H\u0080\u0080\u0004\u001a\u000e\u0010\b\u001a\u00020\t*\u00020\u0003H\u0080\u0080\u0004\u001a\u0018\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0082\u0080\u0004¨\u0006\u000e"}, d2 = {"verify", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "asJsonDecoder", "Lkotlinx/serialization/json/JsonDecoder;", "asJsonEncoder", "Lkotlinx/serialization/json/JsonEncoder;", "defer", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "deferred", "Lkotlin/Function0;", "kotlinx-serialization-json"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class JsonElementSerializersKt {
    public static final JsonDecoder asJsonDecoder(Decoder decoder) {
        p.e(decoder, "<this>");
        JsonDecoder jsonDecoder = decoder instanceof JsonDecoder ? (JsonDecoder) decoder : null;
        if (jsonDecoder != null) {
            return jsonDecoder;
        }
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Decoder to be JsonDecoder, got " + z.a(decoder.getClass()));
    }

    public static final JsonEncoder asJsonEncoder(Encoder encoder) {
        p.e(encoder, "<this>");
        JsonEncoder jsonEncoder = encoder instanceof JsonEncoder ? (JsonEncoder) encoder : null;
        if (jsonEncoder != null) {
            return jsonEncoder;
        }
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Encoder to be JsonEncoder, got " + z.a(encoder.getClass()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SerialDescriptor defer(a aVar) {
        return new SerialDescriptor(aVar) { // from class: kotlinx.serialization.json.JsonElementSerializersKt.defer.1
            private final e original$delegate;

            {
                this.original$delegate = h.x(aVar);
            }

            private final SerialDescriptor getOriginal() {
                return (SerialDescriptor) this.original$delegate.getValue();
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public /* bridge */ List<Annotation> getAnnotations() {
                return super.getAnnotations();
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public List<Annotation> getElementAnnotations(int index) {
                return getOriginal().getElementAnnotations(index);
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public SerialDescriptor getElementDescriptor(int index) {
                return getOriginal().getElementDescriptor(index);
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public int getElementIndex(String name) {
                p.e(name, "name");
                return getOriginal().getElementIndex(name);
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public String getElementName(int index) {
                return getOriginal().getElementName(index);
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public int getElementsCount() {
                return getOriginal().getElementsCount();
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public SerialKind getKind() {
                return getOriginal().getKind();
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public String getSerialName() {
                return getOriginal().getSerialName();
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public boolean isElementOptional(int index) {
                return getOriginal().isElementOptional(index);
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            /* renamed from: isInline */
            public /* bridge */ boolean getIsInline() {
                return super.getIsInline();
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public /* bridge */ boolean isNullable() {
                return super.isNullable();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void verify(Encoder encoder) {
        asJsonEncoder(encoder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void verify(Decoder decoder) {
        asJsonDecoder(decoder);
    }
}
