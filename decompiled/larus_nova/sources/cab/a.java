package cab;

import android.graphics.drawable.Drawable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements Drawable.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f22979a;

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable r100, Runnable r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "who");
        Intrinsics.checkNotNullParameter(r101, "what");
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable r100, Runnable r101) {
        Intrinsics.checkNotNullParameter(r100, "who");
        Intrinsics.checkNotNullParameter(r101, "what");
    }

    public a(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onInvalidateDrawable");
        this.f22979a = r100;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "who");
        this.f22979a.invoke();
    }
}
