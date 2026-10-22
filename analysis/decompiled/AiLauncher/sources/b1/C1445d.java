package b1;

import Ua.N0;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.coroutines.d;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u001a1\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u0004\u0012\u00028\u00000\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u000f\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\b\u0010\t*\u001c\u0010\n\u001a\u0004\b\u0000\u0010\u0000\"\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u000b"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/ThreadLocal;", "Landroidx/room/concurrent/ThreadLocal;", UxipConstants.f30680s, "Lkotlin/coroutines/d$b;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/ThreadLocal;Ljava/lang/Object;)Lkotlin/coroutines/d$b;", "", Const.INTENT_KEY_PKGNAME, "()J", "ThreadLocal", "room-runtime"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* renamed from: b1.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1445d {
    public static final <T> d.b a(ThreadLocal<T> threadLocal, T t10) {
        p.i(threadLocal, "<this>");
        return N0.a(threadLocal, t10);
    }

    public static final long b() {
        return Thread.currentThread().getId();
    }
}
