package pb;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import lb.InterfaceC4883a;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\t\b\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00132\u0006\u0010\r\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0017¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00162\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00028\u0000H\u0017¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lpb/b;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/serialization/KSerializer;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "Lob/c;", "", "klassName", "Llb/a;", Const.INTENT_KEY_UMID, "(Lob/c;Ljava/lang/String;)Llb/a;", "Llb/m;", "e", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)Llb/m;", "compositeDecoder", "c", "(Lob/c;)Ljava/lang/Object;", "Lw9/d;", "f", "()Lw9/d;", "baseClass", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: pb.b, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC5086b<T> implements KSerializer<T> {
    public final T c(ob.c compositeDecoder) {
        return (T) ob.c.c(compositeDecoder, getDescriptor(), 1, lb.f.a(this, compositeDecoder, compositeDecoder.decodeStringElement(getDescriptor(), 0)), null, 8, null);
    }

    public InterfaceC4883a<T> d(ob.c decoder, String klassName) {
        kotlin.jvm.internal.p.i(decoder, "decoder");
        return decoder.getSerializersModule().e(f(), klassName);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // lb.InterfaceC4883a
    public final T deserialize(Decoder decoder) {
        T t10;
        kotlin.jvm.internal.p.i(decoder, "decoder");
        SerialDescriptor descriptor = getDescriptor();
        ob.c cVarBeginStructure = decoder.beginStructure(descriptor);
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        if (cVarBeginStructure.decodeSequentially()) {
            t10 = (T) c(cVarBeginStructure);
        } else {
            Object objC = null;
            while (true) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(getDescriptor());
                if (iDecodeElementIndex != -1) {
                    if (iDecodeElementIndex == 0) {
                        ref$ObjectRef.f34820a = (T) cVarBeginStructure.decodeStringElement(getDescriptor(), iDecodeElementIndex);
                    } else {
                        if (iDecodeElementIndex != 1) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Invalid index in polymorphic deserialization of ");
                            String str = (String) ref$ObjectRef.f34820a;
                            if (str == null) {
                                str = "unknown class";
                            }
                            sb2.append(str);
                            sb2.append("\n Expected 0, 1 or DECODE_DONE(-1), but found ");
                            sb2.append(iDecodeElementIndex);
                            throw new SerializationException(sb2.toString());
                        }
                        T t11 = ref$ObjectRef.f34820a;
                        if (t11 == 0) {
                            throw new IllegalArgumentException("Cannot read polymorphic value before its type token");
                        }
                        ref$ObjectRef.f34820a = t11;
                        objC = ob.c.c(cVarBeginStructure, getDescriptor(), iDecodeElementIndex, lb.f.a(this, cVarBeginStructure, (String) t11), null, 8, null);
                    }
                } else {
                    if (objC == null) {
                        throw new IllegalArgumentException(("Polymorphic value has not been read for class " + ((String) ref$ObjectRef.f34820a)).toString());
                    }
                    kotlin.jvm.internal.p.g(objC, "null cannot be cast to non-null type T of kotlinx.serialization.internal.AbstractPolymorphicSerializer");
                    t10 = (T) objC;
                }
            }
        }
        cVarBeginStructure.endStructure(descriptor);
        return t10;
    }

    public lb.m<T> e(Encoder encoder, T value) {
        kotlin.jvm.internal.p.i(encoder, "encoder");
        kotlin.jvm.internal.p.i(value, "value");
        return encoder.getSerializersModule().f(f(), value);
    }

    public abstract InterfaceC5745d<T> f();

    @Override // lb.m
    public final void serialize(Encoder encoder, T value) {
        kotlin.jvm.internal.p.i(encoder, "encoder");
        kotlin.jvm.internal.p.i(value, "value");
        lb.m<? super T> mVarB = lb.f.b(this, encoder, value);
        SerialDescriptor descriptor = getDescriptor();
        ob.d dVarBeginStructure = encoder.beginStructure(descriptor);
        dVarBeginStructure.w(getDescriptor(), 0, mVarB.getDescriptor().getSerialName());
        SerialDescriptor descriptor2 = getDescriptor();
        kotlin.jvm.internal.p.g(mVarB, "null cannot be cast to non-null type kotlinx.serialization.SerializationStrategy<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        dVarBeginStructure.x(descriptor2, 1, mVarB, value);
        dVarBeginStructure.endStructure(descriptor);
    }
}
