package pb;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\b\u001a\u00020\u0002*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0006H\u0004¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000e\u0010\tJ\u001f\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0002H\u0004¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lpb/p0;", "Lpb/b1;", "", "<init>", "()V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "index", "B", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Ljava/lang/String;", "nestedName", "C", "(Ljava/lang/String;)Ljava/lang/String;", "descriptor", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "parentName", "childName", "z", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "D", "()Ljava/lang/String;", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: pb.p0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC5115p0 extends b1<String> {
    public String A(SerialDescriptor descriptor, int index) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        return descriptor.e(index);
    }

    @Override // pb.b1
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public final String u(SerialDescriptor serialDescriptor, int i10) {
        kotlin.jvm.internal.p.i(serialDescriptor, "<this>");
        return C(A(serialDescriptor, i10));
    }

    public final String C(String nestedName) {
        kotlin.jvm.internal.p.i(nestedName, "nestedName");
        String strT = t();
        if (strT == null) {
            strT = "";
        }
        return z(strT, nestedName);
    }

    public final String D() {
        return v().isEmpty() ? "$" : Z8.F.A0(v(), ".", "$.", null, 0, null, null, 60, null);
    }

    public abstract String z(String parentName, String childName);
}
