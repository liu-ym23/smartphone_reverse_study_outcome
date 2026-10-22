package qb;

import com.autonavi.aps.amapapi.config.Const;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import nb.AbstractC4959l;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a\u0013\u0010\n\u001a\u00020\t*\u00020\u0005H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u0013\u0010\r\u001a\u00020\f*\u00020\u0000H\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u001d\u0010\u0012\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lkotlinx/serialization/encoding/Encoder;", "encoder", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lkotlinx/serialization/encoding/Encoder;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lkotlinx/serialization/encoding/Decoder;)V", "Lqb/h;", Const.INTENT_KEY_UMID, "(Lkotlinx/serialization/encoding/Decoder;)Lqb/h;", "Lqb/s;", "e", "(Lkotlinx/serialization/encoding/Encoder;)Lqb/s;", "Lkotlin/Function0;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "deferred", "f", "(Lp9/a;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlinx-serialization-json"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class r {

    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0016\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"qb/r$a", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "index", "", "e", "(I)Ljava/lang/String;", "name", "c", "(Ljava/lang/String;)I", "", "", "f", "(I)Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(I)Lkotlinx/serialization/descriptors/SerialDescriptor;", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(I)Z", Const.INTENT_KEY_APIKEY, "LY8/h;", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "original", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Ljava/lang/String;", "serialName", "Lnb/l;", "getKind", "()Lnb/l;", "kind", Const.INTENT_KEY_UMID, "()I", "elementsCount", "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements SerialDescriptor {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Y8.h original;

        public a(InterfaceC5063a<? extends SerialDescriptor> interfaceC5063a) {
            this.original = C4848b.b(interfaceC5063a);
        }

        public final SerialDescriptor a() {
            return (SerialDescriptor) this.original.getValue();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public boolean b() {
            return super.b();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public int c(String name) {
            kotlin.jvm.internal.p.i(name, "name");
            return a().c(name);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        /* renamed from: d */
        public int getElementsCount() {
            return a().getElementsCount();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public String e(int index) {
            return a().e(index);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public List<Annotation> f(int index) {
            return a().f(index);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public SerialDescriptor g(int index) {
            return a().g(index);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public List<Annotation> getAnnotations() {
            return super.getAnnotations();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public AbstractC4959l getKind() {
            return a().getKind();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        /* renamed from: h */
        public String getSerialName() {
            return a().getSerialName();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public boolean i(int index) {
            return a().i(index);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        /* renamed from: isInline */
        public boolean getIsInline() {
            return super.getIsInline();
        }
    }

    public static final InterfaceC5178h d(Decoder decoder) {
        kotlin.jvm.internal.p.i(decoder, "<this>");
        InterfaceC5178h interfaceC5178h = decoder instanceof InterfaceC5178h ? (InterfaceC5178h) decoder : null;
        if (interfaceC5178h != null) {
            return interfaceC5178h;
        }
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Decoder to be JsonDecoder, got " + kotlin.jvm.internal.t.b(decoder.getClass()));
    }

    public static final s e(Encoder encoder) {
        kotlin.jvm.internal.p.i(encoder, "<this>");
        s sVar = encoder instanceof s ? (s) encoder : null;
        if (sVar != null) {
            return sVar;
        }
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Encoder to be JsonEncoder, got " + kotlin.jvm.internal.t.b(encoder.getClass()));
    }

    public static final SerialDescriptor f(InterfaceC5063a<? extends SerialDescriptor> interfaceC5063a) {
        return new a(interfaceC5063a);
    }

    public static final void g(Decoder decoder) {
        d(decoder);
    }

    public static final void h(Encoder encoder) {
        e(encoder);
    }
}
