package rb;

import Z8.Y;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Set;
import kotlin.Metadata;
import kotlinx.serialization.descriptors.SerialDescriptor;
import mb.C4931a;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\"\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003\"\u0018\u0010\b\u001a\u00020\u0005*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u0018\u0010\t\u001a\u00020\u0005*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0007¨\u0006\n"}, d2 = {"", "Lkotlinx/serialization/descriptors/SerialDescriptor;", Const.INTENT_KEY_APIKEY, "Ljava/util/Set;", "unsignedNumberDescriptors", "", Const.INTENT_KEY_PKGNAME, "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Z", "isUnsignedNumber", "isUnquotedLiteral", "kotlinx-serialization-json"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class K {

    /* renamed from: a, reason: collision with root package name */
    public static final Set<SerialDescriptor> f38957a = Y.j(C4931a.v(Y8.m.INSTANCE).getDescriptor(), C4931a.w(Y8.o.INSTANCE).getDescriptor(), C4931a.u(Y8.k.INSTANCE).getDescriptor(), C4931a.x(Y8.r.INSTANCE).getDescriptor());

    public static final boolean a(SerialDescriptor serialDescriptor) {
        kotlin.jvm.internal.p.i(serialDescriptor, "<this>");
        return serialDescriptor.getIsInline() && kotlin.jvm.internal.p.d(serialDescriptor, qb.j.l());
    }

    public static final boolean b(SerialDescriptor serialDescriptor) {
        kotlin.jvm.internal.p.i(serialDescriptor, "<this>");
        return serialDescriptor.getIsInline() && f38957a.contains(serialDescriptor);
    }
}
