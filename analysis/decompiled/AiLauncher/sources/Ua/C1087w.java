package Ua;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a+\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\n\u001a!\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LUa/u;", "Lkotlin/Result;", "result", "", Const.INTENT_KEY_UMID, "(LUa/u;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/g;", "parent", Const.INTENT_KEY_PKGNAME, "(Lkotlinx/coroutines/g;)LUa/u;", UxipConstants.f30680s, Const.INTENT_KEY_APIKEY, "(Ljava/lang/Object;)LUa/u;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: Ua.w, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C1087w {
    public static final <T> InterfaceC1083u<T> a(T t10) {
        C1085v c1085v = new C1085v(null);
        c1085v.complete(t10);
        return c1085v;
    }

    public static final <T> InterfaceC1083u<T> b(kotlinx.coroutines.g gVar) {
        return new C1085v(gVar);
    }

    public static /* synthetic */ InterfaceC1083u c(kotlinx.coroutines.g gVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVar = null;
        }
        return b(gVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> boolean d(InterfaceC1083u<T> interfaceC1083u, Object obj) {
        Throwable thE = Result.e(obj);
        return thE == null ? interfaceC1083u.complete(obj) : interfaceC1083u.e(thE);
    }
}
