package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ChangeClipBounds.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f2824a = null;

    static {
        f2824a = new String[]{"android:clipBounds:clip"};
    }

    @Override // androidx.transition.s
    public String[] a() {
        return f2824a;
    }

    private void d(w r4) {
        View r3 = r4.f2870b;
        if (r3.getVisibility() != 8) goto L5;
        return;
    L5:
        Rect r0 = ViewCompat.H(r3);
        r4.f2869a.put("android:clipBounds:clip", r0);
        if (r0 != null) goto L9;
        Rect r1 = new Rect(0, 0, r3.getWidth(), r3.getHeight());
        r4.f2869a.put("android:clipBounds:bounds", r1);
        return;
    }

    @Override // androidx.transition.s
    public void a(w r1) {
        d(r1);
    }

    @Override // androidx.transition.s
    public void b(w r1) {
        d(r1);
    }

    @Override // androidx.transition.s
    public Animator a(ViewGroup r8, w r9, w r10) {
        ObjectAnimator r11 = null;
        if (r9 == null) goto L28;
        if (r10 == null) goto L28;
        if (r9.f2869a.containsKey("android:clipBounds:clip") == false) goto L28;
        if (r10.f2869a.containsKey("android:clipBounds:clip") == false) goto L28;
        Rect r0 = (Rect) ZeusTransformUtils.preCheckCast(r9.f2869a.get("android:clipBounds:clip"), Rect.class, "com.obric.aiagent.plugin");
        Rect r1 = (Rect) ZeusTransformUtils.preCheckCast(r10.f2869a.get("android:clipBounds:clip"), Rect.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L13;
        boolean r5 = true;
    L14:
        if (r0 != null) goto L18;
        if (r1 != null) goto L18;
        return null;
    L18:
        if (r0 != null) goto L20;
        r0 = (Rect) ZeusTransformUtils.preCheckCast(r9.f2869a.get("android:clipBounds:bounds"), Rect.class, "com.obric.aiagent.plugin");
    L23:
        if (r0.equals(r1) == false) goto L25;
        return null;
    L25:
        ViewCompat.a(r10.f2870b, r0);
        r11 = ObjectAnimator.ofObject(r10.f2870b, af.f2792b, new RectEvaluator(new Rect()), new Rect[]{r0, r1});
        if (r5 == false) goto L28;
        final View r12 = r10.f2870b;
        r11.addListener(new ChangeClipBounds$1(this, r12));
        goto L28
    L20:
        if (r1 != null) goto L23;
        r1 = (Rect) ZeusTransformUtils.preCheckCast(r10.f2869a.get("android:clipBounds:bounds"), Rect.class, "com.obric.aiagent.plugin");
        goto L23
    L13:
        r5 = false;
    L28:
        return r11;
    }
}
