package bb;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5954a;

    public a() {
    }

    public final void a(View r10) {
        q.g(r10, "v");
        this.f5954a = true;
        ViewParent r11 = r10.getParent();
        if (r11 == null) goto L6;
        r11.requestDisallowInterceptTouchEvent(true);
        return;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r10, MotionEvent r11) {
        q.g(r10, "v");
        q.g(r11, "event");
        int r12 = r11.getActionMasked();
        if (r12 != 0) goto L5;
        this.f5954a = false;
    L18:
        return false;
    L5:
        if (r12 != 1) goto L7;
    L14:
        this.f5954a = false;
        ViewParent r13 = r10.getParent();
        if (r13 == null) goto L18;
        r13.requestDisallowInterceptTouchEvent(false);
        goto L18
    L7:
        if (r12 == 2) goto L12;
        if (r12 == 3) goto L14;
    L12:
        if (this.f5954a == false) goto L18;
        return true;
    }
}
