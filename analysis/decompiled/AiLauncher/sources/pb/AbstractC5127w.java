package pb;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0003\b!\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u0002*\u0004\b\u0002\u0010\u00042\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005B\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u000b\u001a\u00020\n*\u00028\u0001H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r*\u00028\u0001H\u0014¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lpb/w;", ExifInterface.LONGITUDE_EAST, "", "C", "B", "Lpb/v;", "Lkotlinx/serialization/KSerializer;", "element", "<init>", "(Lkotlinx/serialization/KSerializer;)V", "", "q", "(Ljava/util/Collection;)I", "", "p", "(Ljava/util/Collection;)Ljava/util/Iterator;", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: pb.w, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC5127w<E, C extends Collection<? extends E>, B> extends AbstractC5125v<E, C, B> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC5127w(KSerializer<E> element) {
        super(element, null);
        kotlin.jvm.internal.p.i(element, "element");
    }

    @Override // pb.AbstractC5084a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public Iterator<E> e(C c10) {
        kotlin.jvm.internal.p.i(c10, "<this>");
        return c10.iterator();
    }

    @Override // pb.AbstractC5084a
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public int f(C c10) {
        kotlin.jvm.internal.p.i(c10, "<this>");
        return c10.size();
    }
}
