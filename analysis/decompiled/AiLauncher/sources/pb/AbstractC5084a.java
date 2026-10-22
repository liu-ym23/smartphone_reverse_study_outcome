package pb;

import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import io.ktor.http.ContentDisposition;
import java.util.Iterator;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.encoding.Decoder;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u00028\u00010\u0004B\t\b\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\b\u001a\u00020\u0007*\u00028\u0001H$¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n*\u00028\u0001H$¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00028\u0002H$¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u0007*\u00028\u0002H$¢\u0006\u0004\b\u000f\u0010\tJ\u0013\u0010\u0010\u001a\u00028\u0001*\u00028\u0002H$¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00028\u0002*\u00028\u0001H$¢\u0006\u0004\b\u0012\u0010\u0011J\u001b\u0010\u0015\u001a\u00020\u0014*\u00028\u00022\u0006\u0010\u0013\u001a\u00020\u0007H$¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u001a\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00018\u0001H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ1\u0010#\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00028\u00022\b\b\u0002\u0010\"\u001a\u00020!H$¢\u0006\u0004\b#\u0010$J/\u0010&\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u001e2\u0006\u0010 \u001a\u00028\u00022\u0006\u0010%\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H$¢\u0006\u0004\b&\u0010'J\u001f\u0010(\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u001e2\u0006\u0010 \u001a\u00028\u0002H\u0002¢\u0006\u0004\b(\u0010)\u0082\u0001\u0002*+¨\u0006,"}, d2 = {"Lpb/a;", "Element", CoreUtil.STR_DEX_COLLECTION_NAME, "Builder", "Lkotlinx/serialization/KSerializer;", "<init>", "()V", "", "f", "(Ljava/lang/Object;)I", "", "e", "(Ljava/lang/Object;)Ljava/util/Iterator;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/Object;", "c", "m", "(Ljava/lang/Object;)Ljava/lang/Object;", "l", ContentDisposition.Parameters.Size, "LY8/t;", Const.INTENT_KEY_UMID, "(Ljava/lang/Object;I)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "previous", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lkotlinx/serialization/encoding/Decoder;Ljava/lang/Object;)Ljava/lang/Object;", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "Lob/c;", "index", "builder", "", "checkIndex", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lob/c;ILjava/lang/Object;Z)V", "startIndex", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lob/c;Ljava/lang/Object;II)V", "k", "(Lob/c;Ljava/lang/Object;)I", "Lpb/v;", "Lpb/m0;", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: pb.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC5084a<Element, Collection, Builder> implements KSerializer<Collection> {
    public /* synthetic */ AbstractC5084a(kotlin.jvm.internal.i iVar) {
        this();
    }

    public static /* synthetic */ void j(AbstractC5084a abstractC5084a, ob.c cVar, int i10, Object obj, boolean z10, int i11, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readElement");
        }
        if ((i11 & 8) != 0) {
            z10 = true;
        }
        abstractC5084a.i(cVar, i10, obj, z10);
    }

    public abstract Builder b();

    public abstract int c(Builder builder);

    public abstract void d(Builder builder, int i10);

    public Collection deserialize(Decoder decoder) {
        kotlin.jvm.internal.p.i(decoder, "decoder");
        return g(decoder, null);
    }

    public abstract Iterator<Element> e(Collection collection);

    public abstract int f(Collection collection);

    public final Collection g(Decoder decoder, Collection previous) {
        Builder builderB;
        kotlin.jvm.internal.p.i(decoder, "decoder");
        if (previous == null || (builderB = l(previous)) == null) {
            builderB = b();
        }
        Builder builder = builderB;
        int iC = c(builder);
        ob.c cVarBeginStructure = decoder.beginStructure(getDescriptor());
        if (!cVarBeginStructure.decodeSequentially()) {
            while (true) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(getDescriptor());
                if (iDecodeElementIndex == -1) {
                    break;
                }
                j(this, cVarBeginStructure, iC + iDecodeElementIndex, builder, false, 8, null);
            }
        } else {
            h(cVarBeginStructure, builder, iC, k(cVarBeginStructure, builder));
        }
        cVarBeginStructure.endStructure(getDescriptor());
        return m(builder);
    }

    public abstract void h(ob.c decoder, Builder builder, int startIndex, int size);

    public abstract void i(ob.c decoder, int index, Builder builder, boolean checkIndex);

    public final int k(ob.c decoder, Builder builder) {
        int iDecodeCollectionSize = decoder.decodeCollectionSize(getDescriptor());
        d(builder, iDecodeCollectionSize);
        return iDecodeCollectionSize;
    }

    public abstract Builder l(Collection collection);

    public abstract Collection m(Builder builder);

    public AbstractC5084a() {
    }
}
