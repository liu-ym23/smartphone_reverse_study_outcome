package nd;

import android.graphics.RectF;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.obric.oui.common.style.IOUILayout;
import com.obric.oui.common.style.Shadow;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f22448a = null;

    static {
        f22448a = new b();
    }

    public b() {
    }

    public static final void a(ViewGroup r12, float r13, int r14, int r15, boolean r16, boolean r17, RectF r18, RectF r19) {
        q.g(r12, "tabContainer");
        q.g(r18, "outLayerBounds");
        q.g(r19, "outOverlayBounds");
        int r10 = r12.getChildCount();
        int r11 = 0;
        int r20 = 0;
        int r21 = 0;
        int r22 = 0;
    L3:
        if (r20 >= r10) goto L19;
        int r23 = r20 + 1;
        KeyEvent.Callback r24 = r12.getChildAt(r20);
        if ((r24 instanceof IOUILayout) == false) goto L9;
        List<Shadow> r25 = ((IOUILayout) r24).getCurrentShadows();
        if (r25 == null) goto L9;
        Iterator<Shadow> r26 = r25.iterator();
    L12:
        if (r26.hasNext() == false) goto L9;
        Shadow r27 = r26.next();
        if (r27 == null) goto L12;
        if (r27.u() == false) goto L12;
        r21 = Math.max(r21, (int) Math.ceil((Math.abs(r27.f()) + r27.i()) + r27.j()));
        r22 = Math.max(r22, (int) Math.ceil((Math.abs(r27.g()) + r27.i()) + r27.j()));
    L9:
        r20 = r23;
        goto L3
    L19:
        if (r16 == false) goto L21;
        int r28 = 0;
    L22:
        float r29 = r13 - r28;
        float r30 = r14 + r13;
        if (r17 == true) goto L26;
        r11 = r21;
    L26:
        float r31 = r22;
        r18.set(r29, -r31, r11 + r30, r15 + r31);
        if (r16 == false) goto L29;
        float r32 = r18.left;
    L30:
        if (r17 == false) goto L32;
        r30 = r18.right;
    L32:
        r19.set(r32, r18.top, r30, r18.bottom);
        return;
    L29:
        r32 = r13;
        goto L30
    L21:
        r28 = r21;
        goto L22
    }
}
