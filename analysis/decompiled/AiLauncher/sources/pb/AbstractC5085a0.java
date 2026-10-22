package pb;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u00028\u00020\u0004B%\b\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00028\u00022\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00028\u0001H$¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00028\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00048\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u0018\u0010\t\u001a\u00028\u0000*\u00028\u00028$X¤\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001cR\u0018\u0010\n\u001a\u00028\u0001*\u00028\u00028$X¤\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001c\u0082\u0001\u0002\u001e\u001f¨\u0006 "}, d2 = {"Lpb/a0;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "R", "Lkotlinx/serialization/KSerializer;", "keySerializer", "valueSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "key", UxipConstants.f30680s, "f", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "LY8/t;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "Lkotlinx/serialization/KSerializer;", "c", "()Lkotlinx/serialization/KSerializer;", Const.INTENT_KEY_PKGNAME, "e", "(Ljava/lang/Object;)Ljava/lang/Object;", Const.INTENT_KEY_UMID, "Lpb/k0;", "Lpb/z0;", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: pb.a0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC5085a0<K, V, R> implements KSerializer<R> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final KSerializer<K> keySerializer;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final KSerializer<V> valueSerializer;

    public /* synthetic */ AbstractC5085a0(KSerializer kSerializer, KSerializer kSerializer2, kotlin.jvm.internal.i iVar) {
        this(kSerializer, kSerializer2);
    }

    public abstract K b(R r10);

    public final KSerializer<K> c() {
        return this.keySerializer;
    }

    public abstract V d(R r10);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // lb.InterfaceC4883a
    public R deserialize(Decoder decoder) {
        R r10;
        kotlin.jvm.internal.p.i(decoder, "decoder");
        SerialDescriptor descriptor = getDescriptor();
        ob.c cVarBeginStructure = decoder.beginStructure(descriptor);
        if (cVarBeginStructure.decodeSequentially()) {
            r10 = (R) f(ob.c.c(cVarBeginStructure, getDescriptor(), 0, c(), null, 8, null), ob.c.c(cVarBeginStructure, getDescriptor(), 1, e(), null, 8, null));
        } else {
            Object objC = f1.f38353a;
            Object objC2 = f1.f38353a;
            while (true) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(getDescriptor());
                if (iDecodeElementIndex != -1) {
                    if (iDecodeElementIndex == 0) {
                        objC = ob.c.c(cVarBeginStructure, getDescriptor(), 0, c(), null, 8, null);
                    } else {
                        if (iDecodeElementIndex != 1) {
                            throw new SerializationException("Invalid index: " + iDecodeElementIndex);
                        }
                        objC2 = ob.c.c(cVarBeginStructure, getDescriptor(), 1, e(), null, 8, null);
                    }
                } else {
                    if (objC == f1.f38353a) {
                        throw new SerializationException("Element 'key' is missing");
                    }
                    if (objC2 == f1.f38353a) {
                        throw new SerializationException("Element 'value' is missing");
                    }
                    r10 = (R) f(objC, objC2);
                }
            }
        }
        cVarBeginStructure.endStructure(descriptor);
        return r10;
    }

    public final KSerializer<V> e() {
        return this.valueSerializer;
    }

    public abstract R f(K key, V value);

    @Override // lb.m
    public void serialize(Encoder encoder, R value) {
        kotlin.jvm.internal.p.i(encoder, "encoder");
        ob.d dVarBeginStructure = encoder.beginStructure(getDescriptor());
        dVarBeginStructure.x(getDescriptor(), 0, this.keySerializer, b(value));
        dVarBeginStructure.x(getDescriptor(), 1, this.valueSerializer, d(value));
        dVarBeginStructure.endStructure(getDescriptor());
    }

    public AbstractC5085a0(KSerializer<K> kSerializer, KSerializer<V> kSerializer2) {
        this.keySerializer = kSerializer;
        this.valueSerializer = kSerializer2;
    }
}
