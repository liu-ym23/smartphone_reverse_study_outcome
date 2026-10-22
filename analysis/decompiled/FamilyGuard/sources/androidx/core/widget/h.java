package androidx.core.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

@Deprecated
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    OverScroller f9898a;

    h(Context context, Interpolator interpolator) {
        this.f9898a = interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
    }

    @Deprecated
    public static h a(Context context) {
        return b(context, null);
    }

    @Deprecated
    public static h b(Context context, Interpolator interpolator) {
        return new h(context, interpolator);
    }

    @Deprecated
    public void c(int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        this.f9898a.fling(i5, i6, i7, i8, i9, i10, i11, i12);
    }

    @Deprecated
    public int d() {
        return this.f9898a.getFinalY();
    }
}
