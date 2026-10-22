package Ua;

import Za.C1188h;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u0007\u001a\u00020\u0001*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0018\u0010\t\u001a\u00020\u0001*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\n"}, d2 = {"Le9/c;", "", "c", "(Le9/c;)Ljava/lang/String;", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Object;)Ljava/lang/String;", "hexAddress", Const.INTENT_KEY_APIKEY, "classSimpleName", "kotlinx-coroutines-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class N {
    public static final String a(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String c(InterfaceC4014c<?> interfaceC4014c) {
        Object objB;
        if (interfaceC4014c instanceof C1188h) {
            return ((C1188h) interfaceC4014c).toString();
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(interfaceC4014c + '@' + b(interfaceC4014c));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.e(objB) != null) {
            objB = interfaceC4014c.getClass().getName() + '@' + b(interfaceC4014c);
        }
        return (String) objB;
    }
}
