package com.bytedance.android.accessibilityLib_Core.base.largertoucharea;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes43.dex */
public final class TouchDelegateComposite extends TouchDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<WeakReference<View>, TouchDelegate> f38139a;

    @Override // android.view.TouchDelegate
    public final boolean onTouchEvent(final MotionEvent r100) {
        return a(r100, new AnonymousClass1(r100));
    }

    @Override // android.view.TouchDelegate
    public final boolean onTouchExplorationHoverEvent(final MotionEvent r100) {
        return a(r100, new C97721(r100));
    }

    public TouchDelegateComposite(View r100, Rect r101) {
        super(r101, r100);
        this.f38139a = new ConcurrentHashMap();
    }

    public final boolean a(MotionEvent r100, Function1<? super TouchDelegate, Boolean> r101) {
        float r102 = r100.getX();
        float r103 = r100.getY();
        Iterator<Map.Entry<WeakReference<View>, TouchDelegate>> r104 = this.f38139a.entrySet().iterator();
        boolean r105 = false;
    L4:
        if (r104.hasNext() == false) goto L18;
        Map.Entry<WeakReference<View>, TouchDelegate> r106 = r104.next();
        r100.setLocation(r102, r103);
        View r107 = r106.getKey().get();
        if (r107 == null) goto L16;
        if (r107.getVisibility() != 0) goto L16;
        if (r101.invoke(r106.getValue()).booleanValue() == true) goto L14;
        if (r105 == true) goto L14;
        r105 = false;
    L14:
        r105 = true;
    L16:
        if (("callEvent result = " + r105 + ",x = " + r102 + ",y = " + r103) == null) goto L4;
        Context r108 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
        goto L4
    L18:
        return r105;
    }
}
