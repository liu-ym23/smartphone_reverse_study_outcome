package androidx.core.os;

import android.os.Handler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a1\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086\b\u001a1\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086\b¨\u0006\f"}, d2 = {"postAtTime", "Ljava/lang/Runnable;", "Landroid/os/Handler;", "uptimeMillis", "", "token", "", "action", "Lkotlin/Function0;", "", "postDelayed", "delayInMillis", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class HandlerKt {
    public static final Runnable postAtTime(Handler r100, long r101, Object r102, Function0<Unit> r103) {
        HandlerKt$postAtTime$runnable$1 r104 = new HandlerKt$postAtTime$runnable$1(r103);
        r100.postAtTime(r104, r102, r101);
        return r104;
    }

    public static final Runnable postDelayed(Handler r100, long r101, Object r102, Function0<Unit> r103) {
        HandlerKt$postDelayed$runnable$1 r104 = new HandlerKt$postDelayed$runnable$1(r103);
        if (r102 != null) goto L5;
        r100.postDelayed(r104, r101);
    L6:
        return r104;
    L5:
        HandlerCompat.postDelayed(r100, r104, r102, r101);
        goto L6
    }

    public static /* synthetic */ Runnable postAtTime$default(Handler r100, long r101, Object r102, Function0 r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L5;
        r102 = null;
    L5:
        HandlerKt$postAtTime$runnable$1 r106 = new HandlerKt$postAtTime$runnable$1(r103);
        r100.postAtTime(r106, r102, r101);
        return r106;
    }

    public static /* synthetic */ Runnable postDelayed$default(Handler r100, long r101, Object r102, Function0 r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L5;
        r102 = null;
    L5:
        HandlerKt$postDelayed$runnable$1 r106 = new HandlerKt$postDelayed$runnable$1(r103);
        if (r102 != null) goto L8;
        r100.postDelayed(r106, r101);
    L9:
        return r106;
    L8:
        HandlerCompat.postDelayed(r100, r106, r102, r101);
        goto L9
    }
}
