package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.transition.s;
import androidx.transition.w;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: TextScale.java */
/* JADX INFO: loaded from: classes2.dex */
public class k extends s {
    public k() {
    }

    @Override // androidx.transition.s
    public void a(w r1) {
        d(r1);
    }

    @Override // androidx.transition.s
    public void b(w r1) {
        d(r1);
    }

    private void d(w r3) {
        if (ZeusTransformUtils.instanceOf(r3.f2870b, TextView.class) == false) goto L6;
        TextView r2 = (TextView) ZeusTransformUtils.preCheckCast(r3.f2870b, TextView.class, "com.obric.aiagent.plugin");
        r3.f2869a.put("android:textscale:scale", Float.valueOf(r2.getScaleX()));
        return;
    }

    @Override // androidx.transition.s
    public Animator a(ViewGroup r6, w r7, w r8) {
        if (r7 == null) goto L22;
        if (r8 != null) goto L6;
        return null;
    L6:
        if (ZeusTransformUtils.instanceOf(r7.f2870b, TextView.class) == true) goto L8;
        return null;
    L8:
        if (ZeusTransformUtils.instanceOf(r8.f2870b, TextView.class) == false) goto L25;
        final TextView r0 = (TextView) ZeusTransformUtils.preCheckCast(r8.f2870b, TextView.class, "com.obric.aiagent.plugin");
        Map<String, Object> r9 = r7.f2869a;
        Map<String, Object> r10 = r8.f2869a;
        float r4 = 1.0f;
        if (r9.get("android:textscale:scale") == null) goto L13;
        float r11 = ((Float) ZeusTransformUtils.preCheckCast(r9.get("android:textscale:scale"), Float.class, "com.obric.aiagent.plugin")).floatValue();
    L15:
        if (r10.get("android:textscale:scale") == null) goto L18;
        r4 = ((Float) ZeusTransformUtils.preCheckCast(r10.get("android:textscale:scale"), Float.class, "com.obric.aiagent.plugin")).floatValue();
    L18:
        if (r11 != r4) goto L20;
        return null;
    L20:
        ValueAnimator r12 = ValueAnimator.ofFloat(new float[]{r11, r4});
        r12.addUpdateListener(new TextScale$1(this, r0));
        return r12;
    L13:
        r11 = 1.0f;
        goto L15
    L25:
        return null;
    L22:
        return null;
    }
}
