package ob;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Encoder;
import lb.m;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0017¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\tH&¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000fH&¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0015H&¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H&¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u001aH&¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u001dH&¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010!\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020 H&¢\u0006\u0004\b!\u0010\"J'\u0010$\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020#H&¢\u0006\u0004\b$\u0010%J\u001f\u0010'\u001a\u00020&2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b'\u0010(JA\u0010,\u001a\u00020\u0004\"\n\b\u0000\u0010)*\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\f\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000*2\u0006\u0010\f\u001a\u00028\u0000H&¢\u0006\u0004\b,\u0010-JA\u0010.\u001a\u00020\u0004\"\b\b\u0000\u0010)*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\f\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000*2\b\u0010\f\u001a\u0004\u0018\u00018\u0000H'¢\u0006\u0004\b.\u0010-¨\u0006/À\u0006\u0003"}, d2 = {"Lob/d;", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "LY8/t;", "endStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "", "index", "", "y", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", UxipConstants.f30680s, "v", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IZ)V", "", "n", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IB)V", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lkotlinx/serialization/descriptors/SerialDescriptor;IS)V", "", "l", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IC)V", "t", "(Lkotlinx/serialization/descriptors/SerialDescriptor;II)V", "", "C", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IJ)V", "", "q", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IF)V", "", "B", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ID)V", "", "w", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILjava/lang/String;)V", "Lkotlinx/serialization/encoding/Encoder;", Const.INTENT_KEY_PKGNAME, "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Lkotlinx/serialization/encoding/Encoder;", ExifInterface.GPS_DIRECTION_TRUE, "Llb/m;", "serializer", "x", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILlb/m;Ljava/lang/Object;)V", "k", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface d {
    void A(SerialDescriptor descriptor, int index, short value);

    void B(SerialDescriptor descriptor, int index, double value);

    void C(SerialDescriptor descriptor, int index, long value);

    Encoder b(SerialDescriptor descriptor, int index);

    void endStructure(SerialDescriptor descriptor);

    <T> void k(SerialDescriptor descriptor, int index, m<? super T> serializer, T value);

    void l(SerialDescriptor descriptor, int index, char value);

    void n(SerialDescriptor descriptor, int index, byte value);

    void q(SerialDescriptor descriptor, int index, float value);

    void t(SerialDescriptor descriptor, int index, int value);

    void v(SerialDescriptor descriptor, int index, boolean value);

    void w(SerialDescriptor descriptor, int index, String value);

    <T> void x(SerialDescriptor descriptor, int index, m<? super T> serializer, T value);

    default boolean y(SerialDescriptor descriptor, int index) {
        p.i(descriptor, "descriptor");
        return true;
    }
}
