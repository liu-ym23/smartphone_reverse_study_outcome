package bb;

import android.view.MotionEvent;
import android.view.View;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f5955a;

    public b(List r10) {
        q.g(r10, "listeners");
        this.f5955a = r10;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r10, MotionEvent r11) {
        q.g(r10, "v");
        q.g(r11, "event");
        Iterator r12 = this.f5955a.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        if (((View.OnTouchListener) r12.next()).onTouch(r10, r11) == false) goto L4;
        return true;
    L9:
        return false;
    }
}
