package cc3;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes13.dex */
public final class d implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f23231a = null;

    static {
        f23231a = new d();
    }

    public d() {
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        r100.getParent().getParent().requestDisallowInterceptTouchEvent(true);
        r100.getParent().requestDisallowInterceptTouchEvent(true);
        return false;
    }
}
