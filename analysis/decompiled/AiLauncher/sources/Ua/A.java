package Ua;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import e9.InterfaceC4014c;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a!\u0010\u0003\u001a\u0004\u0018\u00010\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a-\u0010\u0007\u001a\u0004\u0018\u00010\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a3\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0000¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Result;", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Object;)Ljava/lang/Object;", "LUa/l;", "caller", "c", "(Ljava/lang/Object;LUa/l;)Ljava/lang/Object;", VoiceWakeupReceiver.EXTRA_STATE, "Le9/c;", "uCont", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class A {
    public static final <T> Object a(Object obj, InterfaceC4014c<? super T> interfaceC4014c) {
        if (!(obj instanceof C1091z)) {
            return Result.b(obj);
        }
        Result.Companion companion = Result.INSTANCE;
        return Result.b(C4849c.a(((C1091z) obj).cause));
    }

    public static final <T> Object b(Object obj) {
        Throwable thE = Result.e(obj);
        return thE == null ? obj : new C1091z(thE, false, 2, null);
    }

    public static final <T> Object c(Object obj, InterfaceC1066l<?> interfaceC1066l) {
        Throwable thE = Result.e(obj);
        return thE == null ? obj : new C1091z(thE, false, 2, null);
    }
}
