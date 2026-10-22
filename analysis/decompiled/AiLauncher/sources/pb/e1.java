package pb;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.Triple;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import nb.C4948a;
import nb.C4958k;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00050\u0004B1\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ1\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J)\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0019\u0010\u0018R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u001bR\u001a\u0010!\u001a\u00020\u001d8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lpb/e1;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "Lkotlinx/serialization/KSerializer;", "Lkotlin/Triple;", "aSerializer", "bSerializer", "cSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lkotlinx/serialization/encoding/Encoder;Lkotlin/Triple;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "f", "(Lkotlinx/serialization/encoding/Decoder;)Lkotlin/Triple;", "Lob/c;", "composite", "c", "(Lob/c;)Lkotlin/Triple;", Const.INTENT_KEY_UMID, Const.INTENT_KEY_APIKEY, "Lkotlinx/serialization/KSerializer;", Const.INTENT_KEY_PKGNAME, "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class e1<A, B, C> implements KSerializer<Triple<? extends A, ? extends B, ? extends C>> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final KSerializer<A> aSerializer;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final KSerializer<B> bSerializer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final KSerializer<C> cSerializer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final SerialDescriptor descriptor;

    public e1(KSerializer<A> aSerializer, KSerializer<B> bSerializer, KSerializer<C> cSerializer) {
        kotlin.jvm.internal.p.i(aSerializer, "aSerializer");
        kotlin.jvm.internal.p.i(bSerializer, "bSerializer");
        kotlin.jvm.internal.p.i(cSerializer, "cSerializer");
        this.aSerializer = aSerializer;
        this.bSerializer = bSerializer;
        this.cSerializer = cSerializer;
        this.descriptor = C4958k.d("kotlin.Triple", new SerialDescriptor[0], new InterfaceC5074l() { // from class: pb.d1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return e1.e(this.f38344a, (C4948a) obj);
            }
        });
    }

    public static final Y8.t e(e1 e1Var, C4948a buildClassSerialDescriptor) {
        kotlin.jvm.internal.p.i(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
        C4948a.b(buildClassSerialDescriptor, AMapLocationStaticsEntity.FIRST_LOCATE, e1Var.aSerializer.getDescriptor(), null, false, 12, null);
        C4948a.b(buildClassSerialDescriptor, "second", e1Var.bSerializer.getDescriptor(), null, false, 12, null);
        C4948a.b(buildClassSerialDescriptor, "third", e1Var.cSerializer.getDescriptor(), null, false, 12, null);
        return Y8.t.f7040a;
    }

    public final Triple<A, B, C> c(ob.c composite) {
        Object objC = ob.c.c(composite, getDescriptor(), 0, this.aSerializer, null, 8, null);
        Object objC2 = ob.c.c(composite, getDescriptor(), 1, this.bSerializer, null, 8, null);
        Object objC3 = ob.c.c(composite, getDescriptor(), 2, this.cSerializer, null, 8, null);
        composite.endStructure(getDescriptor());
        return new Triple<>(objC, objC2, objC3);
    }

    public final Triple<A, B, C> d(ob.c composite) {
        ob.c cVar;
        Object objC = f1.f38353a;
        Object objC2 = f1.f38353a;
        Object objC3 = f1.f38353a;
        while (true) {
            int iDecodeElementIndex = composite.decodeElementIndex(getDescriptor());
            if (iDecodeElementIndex == -1) {
                composite.endStructure(getDescriptor());
                if (objC == f1.f38353a) {
                    throw new SerializationException("Element 'first' is missing");
                }
                if (objC2 == f1.f38353a) {
                    throw new SerializationException("Element 'second' is missing");
                }
                if (objC3 != f1.f38353a) {
                    return new Triple<>(objC, objC2, objC3);
                }
                throw new SerializationException("Element 'third' is missing");
            }
            if (iDecodeElementIndex == 0) {
                cVar = composite;
                objC = ob.c.c(cVar, getDescriptor(), 0, this.aSerializer, null, 8, null);
            } else if (iDecodeElementIndex == 1) {
                cVar = composite;
                objC2 = ob.c.c(cVar, getDescriptor(), 1, this.bSerializer, null, 8, null);
            } else {
                if (iDecodeElementIndex != 2) {
                    throw new SerializationException("Unexpected index " + iDecodeElementIndex);
                }
                objC3 = ob.c.c(composite, getDescriptor(), 2, this.cSerializer, null, 8, null);
            }
            composite = cVar;
        }
    }

    @Override // lb.InterfaceC4883a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Triple<A, B, C> deserialize(Decoder decoder) {
        kotlin.jvm.internal.p.i(decoder, "decoder");
        ob.c cVarBeginStructure = decoder.beginStructure(getDescriptor());
        return cVarBeginStructure.decodeSequentially() ? c(cVarBeginStructure) : d(cVarBeginStructure);
    }

    @Override // lb.m
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void serialize(Encoder encoder, Triple<? extends A, ? extends B, ? extends C> value) {
        kotlin.jvm.internal.p.i(encoder, "encoder");
        kotlin.jvm.internal.p.i(value, "value");
        ob.d dVarBeginStructure = encoder.beginStructure(getDescriptor());
        dVarBeginStructure.x(getDescriptor(), 0, this.aSerializer, value.d());
        dVarBeginStructure.x(getDescriptor(), 1, this.bSerializer, value.e());
        dVarBeginStructure.x(getDescriptor(), 2, this.cSerializer, value.f());
        dVarBeginStructure.endStructure(getDescriptor());
    }

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }
}
