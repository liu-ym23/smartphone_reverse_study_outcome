package androidx.core.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

@Deprecated
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public OverScroller f13250a;

    public h(Context context, Interpolator interpolator) {
        this.f13250a = interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
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
    public void c(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        this.f13250a.fling(i10, i11, i12, i13, i14, i15, i16, i17);
    }

    @Deprecated
    public int d() {
        return this.f13250a.getFinalY();
    }
}
