package com.obric.oui.common.util;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: TouchDelegateComposite.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TouchDelegateComposite extends TouchDelegate {
    private final List<TouchDelegate> delegates;
    private final Rect emptyRect;

    public TouchDelegateComposite(View r2, Rect r3) {
        o.e(r2, "view");
        o.e(r3, "emptyRect");
        super(r3, r2);
        this.emptyRect = r3;
        this.delegates = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    }

    public /* synthetic */ TouchDelegateComposite(View r1, Rect r2, int r3, d.h.b.h r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = new Rect();
    L5:
        this(r1, r2);
    }

    public final void addDelegate(TouchDelegate r2) {
        o.e(r2, "delegate");
        this.delegates.add(r2);
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(MotionEvent r8) {
        o.e(r8, "event");
        float r0 = r8.getX();
        float r1 = r8.getY();
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(this.delegates, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L3:
        boolean r4 = false;
    L5:
        if (r7.hasNext() == false) goto L10;
        TouchDelegate r5 = (TouchDelegate) ZeusTransformUtils.preCheckCast(r7.next(), TouchDelegate.class, "com.obric.aiagent.plugin");
        r8.setLocation(r0, r1);
        if (r5.onTouchEvent(r8) == true) goto L9;
        if (r4 == false) goto L3;
    L9:
        r4 = true;
        goto L5
    L10:
        return r4;
    }
}
