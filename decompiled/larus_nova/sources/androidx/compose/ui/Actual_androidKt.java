package androidx.compose.ui;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000\u001a\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0000\u001a\u0012\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"currentTimeMillis", "", "handler", "Landroid/os/Handler;", "postDelayed", "", "delayMillis", "block", "Lkotlin/Function0;", "", "removePost", "token", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class Actual_androidKt {
    private static final Handler handler = null;

    public static /* synthetic */ void a(Function0 r100) {
        postDelayed$lambda$0(r100);
    }

    static {
        handler = new Handler(Looper.getMainLooper());
    }

    public static final long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    private static final void postDelayed$lambda$0(Function0 r100) {
        r100.invoke();
    }

    public static final void removePost(Object r100) {
        if ((r100 instanceof Runnable) == false) goto L5;
        Runnable r101 = (Runnable) r100;
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        handler.removeCallbacks((Runnable) r100);
        return;
    L5:
        r101 = null;
        goto L6
    }

    public static final Object postDelayed(long r100, final Function0<Unit> r101) {
        Runnable r102 = new a(r101);
        handler.postDelayed(r102, r100);
        return r102;
    }
}
