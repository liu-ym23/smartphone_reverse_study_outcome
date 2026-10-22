package j2;

import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f17797a;

    private w(FrameLayout frameLayout) {
        this.f17797a = frameLayout;
    }

    public static w a(View view) {
        if (view != null) {
            return new w((FrameLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    public FrameLayout b() {
        return this.f17797a;
    }
}
