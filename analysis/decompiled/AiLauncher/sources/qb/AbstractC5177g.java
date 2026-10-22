package qb;

import androidx.exifinterface.media.ExifInterface;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import lb.InterfaceC4883a;
import nb.AbstractC4951d;
import nb.C4958k;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\n\u001a\u00020\t2\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00028\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00182\u0006\u0010\u0017\u001a\u00020\u0016H$¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001bR\u001a\u0010\u001d\u001a\u00020\u001c8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lqb/g;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/serialization/KSerializer;", "Lw9/d;", "baseClass", "<init>", "(Lw9/d;)V", "subClass", "", "throwSubtypeNotRegistered", "(Lw9/d;Lw9/d;)Ljava/lang/Void;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "Lqb/i;", "element", "Llb/a;", "selectDeserializer", "(Lqb/i;)Llb/a;", "Lw9/d;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: qb.g, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC5177g<T> implements KSerializer<T> {
    private final InterfaceC5745d<T> baseClass;
    private final SerialDescriptor descriptor;

    public AbstractC5177g(InterfaceC5745d<T> baseClass) {
        kotlin.jvm.internal.p.i(baseClass, "baseClass");
        this.baseClass = baseClass;
        this.descriptor = C4958k.h("JsonContentPolymorphicSerializer<" + baseClass.t() + '>', AbstractC4951d.b.f37262a, new SerialDescriptor[0], null, 8, null);
    }

    private final Void throwSubtypeNotRegistered(InterfaceC5745d<?> subClass, InterfaceC5745d<?> baseClass) {
        String strT = subClass.t();
        if (strT == null) {
            strT = String.valueOf(subClass);
        }
        throw new SerializationException("Class '" + strT + "' is not registered for polymorphic serialization " + ("in the scope of '" + baseClass.t() + '\'') + ".\nMark the base class as 'sealed' or register the serializer explicitly.");
    }

    @Override // lb.InterfaceC4883a
    public final T deserialize(Decoder decoder) {
        kotlin.jvm.internal.p.i(decoder, "decoder");
        InterfaceC5178h interfaceC5178hD = r.d(decoder);
        i iVarB = interfaceC5178hD.b();
        InterfaceC4883a<T> interfaceC4883aSelectDeserializer = selectDeserializer(iVarB);
        kotlin.jvm.internal.p.g(interfaceC4883aSelectDeserializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.json.JsonContentPolymorphicSerializer>");
        return (T) interfaceC5178hD.getJson().b((KSerializer) interfaceC4883aSelectDeserializer, iVarB);
    }

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    public abstract InterfaceC4883a<T> selectDeserializer(i element);

    @Override // lb.m
    public final void serialize(Encoder encoder, T value) {
        kotlin.jvm.internal.p.i(encoder, "encoder");
        kotlin.jvm.internal.p.i(value, "value");
        KSerializer kSerializerF = encoder.getSerializersModule().f(this.baseClass, value);
        if (kSerializerF == null) {
            KSerializer kSerializerF2 = lb.u.f(kotlin.jvm.internal.t.b(value.getClass()));
            if (kSerializerF2 == null) {
                throwSubtypeNotRegistered(kotlin.jvm.internal.t.b(value.getClass()), this.baseClass);
                throw new KotlinNothingValueException();
            }
            kSerializerF = kSerializerF2;
        }
        ((KSerializer) kSerializerF).serialize(encoder, value);
    }
}
