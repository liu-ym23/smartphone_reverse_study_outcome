package kotlin;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Result;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0007\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u0005H\u0001¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"", "exception", "", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Throwable;)Ljava/lang/Object;", "Lkotlin/Result;", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: kotlin.c, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C4849c {
    public static final Object a(Throwable exception) {
        p.i(exception, "exception");
        return new Result.Failure(exception);
    }

    public static final void b(Object obj) throws Throwable {
        if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).exception;
        }
    }
}
