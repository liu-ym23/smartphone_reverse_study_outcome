package z9;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a7\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0016\u0010\u0004\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00028\u00000\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/Function1;", "Ljava/lang/Class;", "compute", "Lz9/b;", Const.INTENT_KEY_APIKEY, "(Lp9/l;)Lz9/b;", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: z9.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6407c {
    static {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Class.forName("java.lang.ClassValue"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.h(objB)) {
            objB = Boolean.TRUE;
        }
        Object objB2 = Result.b(objB);
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB2)) {
            objB2 = bool;
        }
        ((Boolean) objB2).getClass();
    }

    public static final <V> AbstractC6405b<V> a(InterfaceC5074l<? super Class<?>, ? extends V> compute) {
        kotlin.jvm.internal.p.i(compute, "compute");
        return new C6421j(compute);
    }
}
