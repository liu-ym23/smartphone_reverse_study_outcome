package pb;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlinx.serialization.SerializationException;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0006\u001a%\u0010\u0005\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\b\u001a\u00020\u00042\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0001¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"", "subClassName", "Lw9/d;", "baseClass", "", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Lw9/d;)Ljava/lang/Void;", "subClass", Const.INTENT_KEY_PKGNAME, "(Lw9/d;Lw9/d;)Ljava/lang/Void;", "kotlinx-serialization-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: pb.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5088c {
    public static final Void a(String str, InterfaceC5745d<?> baseClass) {
        String str2;
        kotlin.jvm.internal.p.i(baseClass, "baseClass");
        String str3 = "in the polymorphic scope of '" + baseClass.t() + '\'';
        if (str == null) {
            str2 = "Class discriminator was missing and no default serializers were registered " + str3 + '.';
        } else {
            str2 = "Serializer for subclass '" + str + "' is not found " + str3 + ".\nCheck if class with serial name '" + str + "' exists and serializer is registered in a corresponding SerializersModule.\nTo be registered automatically, class '" + str + "' has to be '@Serializable', and the base class '" + baseClass.t() + "' has to be sealed and '@Serializable'.";
        }
        throw new SerializationException(str2);
    }

    public static final Void b(InterfaceC5745d<?> subClass, InterfaceC5745d<?> baseClass) {
        kotlin.jvm.internal.p.i(subClass, "subClass");
        kotlin.jvm.internal.p.i(baseClass, "baseClass");
        String strT = subClass.t();
        if (strT == null) {
            strT = String.valueOf(subClass);
        }
        a(strT, baseClass);
        throw new KotlinNothingValueException();
    }
}
