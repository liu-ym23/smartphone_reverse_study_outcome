package kotlinx.serialization.internal;

import a6.w;
import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.p;
import kotlinx.serialization.SerializationException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0081\u0080\u0004\u001a\"\u0010\u0000\u001a\u00020\u00012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0081\u0080\u0004¨\u0006\u0007"}, d2 = {"throwSubtypeNotRegistered", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "subClassName", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "baseClass", "Lkotlin/reflect/KClass;", "subClass", "kotlinx-serialization-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AbstractPolymorphicSerializerKt {
    public static final Void throwSubtypeNotRegistered(String str, v5.c baseClass) {
        String string;
        p.e(baseClass, "baseClass");
        StringBuilder sb = new StringBuilder("in the polymorphic scope of '");
        h hVar = (h) baseClass;
        sb.append(hVar.b());
        sb.append('\'');
        String string2 = sb.toString();
        if (str == null) {
            string = "Class discriminator was missing and no default serializers were registered " + string2 + '.';
        } else {
            StringBuilder sbV = a8.b.v("Serializer for subclass '", str, "' is not found ", string2, ".\nCheck if class with serial name '");
            a8.b.A(sbV, str, "' exists and serializer is registered in a corresponding SerializersModule.\nTo be registered automatically, class '", str, "' has to be '@Serializable', and the base class '");
            sbV.append(hVar.b());
            sbV.append("' has to be sealed and '@Serializable'.");
            string = sbV.toString();
        }
        throw new SerializationException(string);
    }

    public static final Void throwSubtypeNotRegistered(v5.c subClass, v5.c baseClass) {
        p.e(subClass, "subClass");
        p.e(baseClass, "baseClass");
        String strB = ((h) subClass).b();
        if (strB == null) {
            strB = String.valueOf(subClass);
        }
        throwSubtypeNotRegistered(strB, baseClass);
        throw new w();
    }
}
