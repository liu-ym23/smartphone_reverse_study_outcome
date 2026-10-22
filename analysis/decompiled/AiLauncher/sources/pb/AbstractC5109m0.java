package pb;

import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentDisposition;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Encoder;
import nb.AbstractC4952e;
import v9.C5678g;
import v9.C5685n;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0014\b\u0003\u0010\u0005*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042 \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006B%\b\u0004\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00028\u00032\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0004¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00028\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b8\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\b8\u0006¢\u0006\f\n\u0004\b$\u0010!\u001a\u0004\b%\u0010#R\u0014\u0010)\u001a\u00020&8&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(\u0082\u0001\u0002*+¨\u0006,"}, d2 = {"Lpb/m0;", "Key", "Value", CoreUtil.STR_DEX_COLLECTION_NAME, "", "Builder", "Lpb/a;", "", "Lkotlinx/serialization/KSerializer;", "keySerializer", "valueSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "Lob/c;", "decoder", "builder", "", "startIndex", ContentDisposition.Parameters.Size, "LY8/t;", "p", "(Lob/c;Ljava/util/Map;II)V", "index", "", "checkIndex", "q", "(Lob/c;ILjava/util/Map;Z)V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "serialize", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", Const.INTENT_KEY_APIKEY, "Lkotlinx/serialization/KSerializer;", "n", "()Lkotlinx/serialization/KSerializer;", Const.INTENT_KEY_PKGNAME, "o", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lpb/O;", "Lpb/c0;", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: pb.m0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC5109m0<Key, Value, Collection, Builder extends Map<Key, Value>> extends AbstractC5084a<Map.Entry<? extends Key, ? extends Value>, Collection, Builder> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final KSerializer<Key> keySerializer;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final KSerializer<Value> valueSerializer;

    public /* synthetic */ AbstractC5109m0(KSerializer kSerializer, KSerializer kSerializer2, kotlin.jvm.internal.i iVar) {
        this(kSerializer, kSerializer2);
    }

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public abstract SerialDescriptor getDescriptor();

    public final KSerializer<Key> n() {
        return this.keySerializer;
    }

    public final KSerializer<Value> o() {
        return this.valueSerializer;
    }

    @Override // pb.AbstractC5084a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public final void h(ob.c decoder, Builder builder, int startIndex, int size) {
        kotlin.jvm.internal.p.i(decoder, "decoder");
        kotlin.jvm.internal.p.i(builder, "builder");
        if (size < 0) {
            throw new IllegalArgumentException("Size must be known in advance when using READ_ALL");
        }
        C5678g c5678gR = C5685n.r(C5685n.s(0, size * 2), 2);
        int first = c5678gR.getFirst();
        int last = c5678gR.getLast();
        int step = c5678gR.getStep();
        if ((step <= 0 || first > last) && (step >= 0 || last > first)) {
            return;
        }
        while (true) {
            i(decoder, startIndex + first, builder, false);
            if (first == last) {
                return;
            } else {
                first += step;
            }
        }
    }

    @Override // pb.AbstractC5084a
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public final void i(ob.c decoder, int index, Builder builder, boolean checkIndex) {
        int iDecodeElementIndex;
        kotlin.jvm.internal.p.i(decoder, "decoder");
        kotlin.jvm.internal.p.i(builder, "builder");
        Object objC = ob.c.c(decoder, getDescriptor(), index, this.keySerializer, null, 8, null);
        if (checkIndex) {
            iDecodeElementIndex = decoder.decodeElementIndex(getDescriptor());
            if (iDecodeElementIndex != index + 1) {
                throw new IllegalArgumentException(("Value must follow key in a map, index for key: " + index + ", returned index for value: " + iDecodeElementIndex).toString());
            }
        } else {
            iDecodeElementIndex = index + 1;
        }
        int i10 = iDecodeElementIndex;
        builder.put(objC, (!builder.containsKey(objC) || (this.valueSerializer.getDescriptor().getKind() instanceof AbstractC4952e)) ? ob.c.c(decoder, getDescriptor(), i10, this.valueSerializer, null, 8, null) : decoder.decodeSerializableElement(getDescriptor(), i10, this.valueSerializer, kotlin.collections.a.j(builder, objC)));
    }

    @Override // lb.m
    public void serialize(Encoder encoder, Collection value) {
        kotlin.jvm.internal.p.i(encoder, "encoder");
        int iF = f(value);
        SerialDescriptor descriptor = getDescriptor();
        ob.d dVarF = encoder.f(descriptor, iF);
        Iterator<Map.Entry<? extends Key, ? extends Value>> itE = e(value);
        int i10 = 0;
        while (itE.hasNext()) {
            Map.Entry<? extends Key, ? extends Value> next = itE.next();
            Key key = next.getKey();
            Value value2 = next.getValue();
            int i11 = i10 + 1;
            dVarF.x(getDescriptor(), i10, n(), key);
            i10 += 2;
            dVarF.x(getDescriptor(), i11, o(), value2);
        }
        dVarF.endStructure(descriptor);
    }

    public AbstractC5109m0(KSerializer<Key> kSerializer, KSerializer<Value> kSerializer2) {
        super(null);
        this.keySerializer = kSerializer;
        this.valueSerializer = kSerializer2;
    }
}
