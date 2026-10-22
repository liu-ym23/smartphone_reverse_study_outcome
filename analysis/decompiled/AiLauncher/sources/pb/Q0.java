package pb;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Map;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import nb.AbstractC4952e;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u00006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\b\u0010\t\u001a+\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\r\"\b\b\u0000\u0010\u000b*\u00020\n*\b\u0012\u0004\u0012\u00028\u00000\fH\u0000¢\u0006\u0004\b\u000e\u0010\u000f\"(\u0010\u0012\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0011¨\u0006\u0013"}, d2 = {"", "serialName", "Lnb/e;", "kind", "Lkotlinx/serialization/descriptors/SerialDescriptor;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Lnb/e;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "LY8/t;", "c", "(Ljava/lang/String;)V", "", ExifInterface.GPS_DIRECTION_TRUE, "Lw9/d;", "Lkotlinx/serialization/KSerializer;", Const.INTENT_KEY_PKGNAME, "(Lw9/d;)Lkotlinx/serialization/KSerializer;", "", "Ljava/util/Map;", "BUILTIN_SERIALIZERS", "kotlinx-serialization-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Q0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Map<InterfaceC5745d<?>, KSerializer<?>> f38309a = C0.i();

    public static final SerialDescriptor a(String serialName, AbstractC4952e kind) {
        kotlin.jvm.internal.p.i(serialName, "serialName");
        kotlin.jvm.internal.p.i(kind, "kind");
        c(serialName);
        return new PrimitiveDescriptor(serialName, kind);
    }

    public static final <T> KSerializer<T> b(InterfaceC5745d<T> interfaceC5745d) {
        kotlin.jvm.internal.p.i(interfaceC5745d, "<this>");
        return (KSerializer) f38309a.get(interfaceC5745d);
    }

    public static final void c(String serialName) {
        kotlin.jvm.internal.p.i(serialName, "serialName");
        for (KSerializer<?> kSerializer : f38309a.values()) {
            if (kotlin.jvm.internal.p.d(serialName, kSerializer.getDescriptor().getSerialName())) {
                throw new IllegalArgumentException(La.w.n("\n                The name of serial descriptor should uniquely identify associated serializer.\n                For serial name " + serialName + " there already exists " + kotlin.jvm.internal.t.b(kSerializer.getClass()).t() + ".\n                Please refer to SerialDescriptor documentation for additional information.\n            "));
            }
        }
    }
}
