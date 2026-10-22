package pb;

import Z8.C1168p;
import Z8.C1173v;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import nb.AbstractC4960m;
import nb.C4948a;
import nb.C4958k;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\u0007\u0010\bB'\b\u0011\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u0007\u0010\fJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0006\u001a\u00028\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001b\u0010\"\u001a\u00020\u001d8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Lpb/x0;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/serialization/KSerializer;", "", "serialName", "objectInstance", "<init>", "(Ljava/lang/String;Ljava/lang/Object;)V", "", "", "classAnnotations", "(Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/annotation/Annotation;)V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "Ljava/lang/Object;", "", Const.INTENT_KEY_PKGNAME, "Ljava/util/List;", "_annotations", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "c", "LY8/h;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: pb.x0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5130x0<T> implements KSerializer<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final T objectInstance;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public List<? extends Annotation> _annotations;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Y8.h descriptor;

    public C5130x0(final String serialName, T objectInstance) {
        kotlin.jvm.internal.p.i(serialName, "serialName");
        kotlin.jvm.internal.p.i(objectInstance, "objectInstance");
        this.objectInstance = objectInstance;
        this._annotations = C1173v.m();
        this.descriptor = C4848b.a(LazyThreadSafetyMode.PUBLICATION, new InterfaceC5063a() { // from class: pb.v0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return C5130x0.d(serialName, this);
            }
        });
    }

    public static final SerialDescriptor d(String str, final C5130x0 c5130x0) {
        return C4958k.g(str, AbstractC4960m.d.f37296a, new SerialDescriptor[0], new InterfaceC5074l() { // from class: pb.w0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C5130x0.e(this.f38430a, (C4948a) obj);
            }
        });
    }

    public static final Y8.t e(C5130x0 c5130x0, C4948a buildSerialDescriptor) {
        kotlin.jvm.internal.p.i(buildSerialDescriptor, "$this$buildSerialDescriptor");
        buildSerialDescriptor.h(c5130x0._annotations);
        return Y8.t.f7040a;
    }

    @Override // lb.InterfaceC4883a
    public T deserialize(Decoder decoder) {
        int iDecodeElementIndex;
        kotlin.jvm.internal.p.i(decoder, "decoder");
        SerialDescriptor descriptor = getDescriptor();
        ob.c cVarBeginStructure = decoder.beginStructure(descriptor);
        if (cVarBeginStructure.decodeSequentially() || (iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(getDescriptor())) == -1) {
            Y8.t tVar = Y8.t.f7040a;
            cVarBeginStructure.endStructure(descriptor);
            return this.objectInstance;
        }
        throw new SerializationException("Unexpected index " + iDecodeElementIndex);
    }

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor) this.descriptor.getValue();
    }

    @Override // lb.m
    public void serialize(Encoder encoder, T value) {
        kotlin.jvm.internal.p.i(encoder, "encoder");
        kotlin.jvm.internal.p.i(value, "value");
        encoder.beginStructure(getDescriptor()).endStructure(getDescriptor());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C5130x0(String serialName, T objectInstance, Annotation[] classAnnotations) {
        this(serialName, objectInstance);
        kotlin.jvm.internal.p.i(serialName, "serialName");
        kotlin.jvm.internal.p.i(objectInstance, "objectInstance");
        kotlin.jvm.internal.p.i(classAnnotations, "classAnnotations");
        this._annotations = C1168p.d(classAnnotations);
    }
}
