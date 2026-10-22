package x4;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u001aA\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00002\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"", "sessionId", "boundSessionId", "Lkotlin/Function1;", "", "hostMatches", "globalSessionId", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;Lp9/l;Ljava/lang/String;)Z", "chatcore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class w {
    public static final boolean a(String sessionId, String str, InterfaceC5074l<? super String, Boolean> interfaceC5074l, String str2) {
        Object objB;
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        if (interfaceC5074l != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Boolean boolInvoke = interfaceC5074l.invoke(sessionId);
                boolInvoke.booleanValue();
                objB = Result.b(boolInvoke);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Boolean bool = Boolean.FALSE;
            if (Result.g(objB)) {
                objB = bool;
            }
            return ((Boolean) objB).booleanValue();
        }
        if (str == null || str.length() <= 0) {
            str = null;
        }
        if (str != null) {
            return kotlin.jvm.internal.p.d(str, sessionId);
        }
        if (str2 == null) {
            return false;
        }
        if (str2.length() <= 0) {
            str2 = null;
        }
        if (str2 == null) {
            return false;
        }
        return kotlin.jvm.internal.p.d(str2, sessionId);
    }
}
