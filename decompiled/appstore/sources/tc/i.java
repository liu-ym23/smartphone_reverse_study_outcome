package tc;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class i extends TouchDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f24782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f24783b;

    public i(View r10, Rect r11) {
        q.g(r10, "view");
        q.g(r11, "emptyRect");
        super(r11, r10);
        this.f24782a = r11;
        this.f24783b = new ArrayList();
    }

    public final void a(TouchDelegate r10) {
        q.g(r10, "delegate");
        this.f24783b.add(r10);
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(MotionEvent r10) {
        q.g(r10, "event");
        float r11 = r10.getX();
        float r12 = r10.getY();
        Iterator r13 = this.f24783b.iterator();
    L3:
        boolean r14 = false;
    L5:
        if (r13.hasNext() == false) goto L10;
        TouchDelegate r15 = (TouchDelegate) r13.next();
        r10.setLocation(r11, r12);
        if (r15.onTouchEvent(r10) == true) goto L9;
        if (r14 == false) goto L3;
    L9:
        r14 = true;
        goto L5
    L10:
        return r14;
    }

    public /* synthetic */ i(View r10, Rect r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = new Rect();
    L5:
        this(r10, r11);
    }
}
