package pb;

import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentDisposition;
import java.util.Iterator;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Encoder;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004B\u0017\b\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\r\u001a\u00020\f*\u00028\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00028\u0000H$¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J/\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00028\u00022\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ/\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00028\u00022\u0006\u0010\u001c\u001a\u00020\u001bH\u0014¢\u0006\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010$\u001a\u00020!8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#\u0082\u0001\u0003%&'¨\u0006("}, d2 = {"Lpb/v;", "Element", CoreUtil.STR_DEX_COLLECTION_NAME, "Builder", "Lpb/a;", "Lkotlinx/serialization/KSerializer;", "elementSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;)V", "", "index", "element", "LY8/t;", "o", "(Ljava/lang/Object;ILjava/lang/Object;)V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "serialize", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "Lob/c;", "decoder", "builder", "startIndex", ContentDisposition.Parameters.Size, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lob/c;Ljava/lang/Object;II)V", "", "checkIndex", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lob/c;ILjava/lang/Object;Z)V", Const.INTENT_KEY_APIKEY, "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lpb/w;", "Lpb/O0;", "Lpb/R0;", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: pb.v, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC5125v<Element, Collection, Builder> extends AbstractC5084a<Element, Collection, Builder> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final KSerializer<Element> elementSerializer;

    public /* synthetic */ AbstractC5125v(KSerializer kSerializer, kotlin.jvm.internal.i iVar) {
        this(kSerializer);
    }

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public abstract SerialDescriptor getDescriptor();

    @Override // pb.AbstractC5084a
    public final void h(ob.c decoder, Builder builder, int startIndex, int size) {
        kotlin.jvm.internal.p.i(decoder, "decoder");
        if (size < 0) {
            throw new IllegalArgumentException("Size must be known in advance when using READ_ALL");
        }
        for (int i10 = 0; i10 < size; i10++) {
            i(decoder, startIndex + i10, builder, false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pb.AbstractC5084a
    public void i(ob.c decoder, int index, Builder builder, boolean checkIndex) {
        kotlin.jvm.internal.p.i(decoder, "decoder");
        o(builder, index, ob.c.c(decoder, getDescriptor(), index, this.elementSerializer, null, 8, null));
    }

    public abstract void o(Builder builder, int i10, Element element);

    @Override // lb.m
    public void serialize(Encoder encoder, Collection value) {
        kotlin.jvm.internal.p.i(encoder, "encoder");
        int iF = f(value);
        SerialDescriptor descriptor = getDescriptor();
        ob.d dVarF = encoder.f(descriptor, iF);
        Iterator<Element> itE = e(value);
        for (int i10 = 0; i10 < iF; i10++) {
            dVarF.x(getDescriptor(), i10, this.elementSerializer, itE.next());
        }
        dVarF.endStructure(descriptor);
    }

    public AbstractC5125v(KSerializer<Element> kSerializer) {
        super(null);
        this.elementSerializer = kSerializer;
    }
}
