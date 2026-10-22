package pb;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlinx.serialization.descriptors.SerialDescriptor;
import nb.AbstractC4959l;
import nb.C4955h;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a!\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0013\u0010\u0007\u001a\u00020\u0006*\u00020\u0000H\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "typeParams", "", Const.INTENT_KEY_PKGNAME, "(Lkotlinx/serialization/descriptors/SerialDescriptor;[Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "", "c", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Ljava/lang/String;", "kotlinx-serialization-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class K0 {
    public static final int b(SerialDescriptor serialDescriptor, SerialDescriptor[] typeParams) {
        kotlin.jvm.internal.p.i(serialDescriptor, "<this>");
        kotlin.jvm.internal.p.i(typeParams, "typeParams");
        int iHashCode = (serialDescriptor.getSerialName().hashCode() * 31) + Arrays.hashCode(typeParams);
        Iterable<SerialDescriptor> iterableA = C4955h.a(serialDescriptor);
        Iterator<SerialDescriptor> it = iterableA.iterator();
        int iHashCode2 = 1;
        int i10 = 1;
        while (true) {
            int iHashCode3 = 0;
            if (!it.hasNext()) {
                break;
            }
            int i11 = i10 * 31;
            String serialName = it.next().getSerialName();
            if (serialName != null) {
                iHashCode3 = serialName.hashCode();
            }
            i10 = i11 + iHashCode3;
        }
        Iterator<SerialDescriptor> it2 = iterableA.iterator();
        while (it2.hasNext()) {
            int i12 = iHashCode2 * 31;
            AbstractC4959l kind = it2.next().getKind();
            iHashCode2 = i12 + (kind != null ? kind.hashCode() : 0);
        }
        return (((iHashCode * 31) + i10) * 31) + iHashCode2;
    }

    public static final String c(final SerialDescriptor serialDescriptor) {
        kotlin.jvm.internal.p.i(serialDescriptor, "<this>");
        return Z8.F.A0(C5685n.s(0, serialDescriptor.getElementsCount()), ", ", serialDescriptor.getSerialName() + '(', ")", 0, null, new InterfaceC5074l() { // from class: pb.J0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return K0.d(serialDescriptor, ((Integer) obj).intValue());
            }
        }, 24, null);
    }

    public static final CharSequence d(SerialDescriptor serialDescriptor, int i10) {
        return serialDescriptor.e(i10) + ": " + serialDescriptor.g(i10).getSerialName();
    }
}
