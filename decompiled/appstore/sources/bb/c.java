package bb;

import android.view.MotionEvent;
import android.view.View;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f5956a;

    public c() {
    }

    public final int[] a() {
        return this.f5956a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r10, MotionEvent r11) {
        q.g(r10, "v");
        q.g(r11, "event");
        if (r11.getAction() != 0) goto L8;
        int[] r12 = this.f5956a;
        if (r12 != null) goto L7;
        this.f5956a = new int[]{(int) r11.getX(), (int) r11.getY()};
        goto L8
    L7:
        q.d(r12);
        r12[0] = (int) r11.getX();
        int[] r13 = this.f5956a;
        q.d(r13);
        r13[1] = (int) r11.getY();
    L8:
        return false;
    }
}
