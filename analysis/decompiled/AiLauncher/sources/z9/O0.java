package z9;

import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonPointer;
import kotlin.Metadata;
import o9.C5013a;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u0002*\u00060\u0000j\u0002`\u0001H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0005\u001a\u00020\u0000*\u00060\u0000j\u0002`\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\t*\u00020\u00072\n\u0010\b\u001a\u00060\u0000j\u0002`\u0001H\u0000¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"", "Lkotlin/reflect/jvm/internal/impl/km/ClassName;", "Lga/b;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Lga/b;", "c", "(Ljava/lang/String;)Ljava/lang/String;", "Ljava/lang/ClassLoader;", "name", "Lw9/d;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/ClassLoader;Ljava/lang/String;)Lw9/d;", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class O0 {
    public static final InterfaceC5745d<?> a(ClassLoader classLoader, String name) {
        kotlin.jvm.internal.p.i(classLoader, "<this>");
        kotlin.jvm.internal.p.i(name, "name");
        Class clsP = c1.p(classLoader, b(name), 0, 2, null);
        if (clsP != null) {
            return C5013a.e(clsP);
        }
        return null;
    }

    public static final ga.b b(String str) {
        kotlin.jvm.internal.p.i(str, "<this>");
        boolean zX = La.D.X(str, ".", false, 2, null);
        if (zX) {
            str = str.substring(1);
            kotlin.jvm.internal.p.h(str, "substring(...)");
        }
        return new ga.b(new ga.c(La.D.S(La.H.y1(str, JsonPointer.SEPARATOR, ""), JsonPointer.SEPARATOR, '.', false, 4, null)), new ga.c(La.H.s1(str, JsonPointer.SEPARATOR, null, 2, null)), zX);
    }

    public static final String c(String str) {
        kotlin.jvm.internal.p.i(str, "<this>");
        if (!La.D.X(str, ".", false, 2, null)) {
            return La.H.s1(La.H.s1(str, JsonPointer.SEPARATOR, null, 2, null), '.', null, 2, null);
        }
        throw new IllegalArgumentException(("Local class is not supported: " + str).toString());
    }
}
