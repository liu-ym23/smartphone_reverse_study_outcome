package com.bytedance.android.ecom.arch.slice.render.util.touch_delegate;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class SlcTouchDelegateComposite extends TouchDelegate {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Rect f50770b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<SlcHackTouchDelegate> f50771a;

    public static final class a {
    }

    static {
        f50770b = new Rect();
    }

    public SlcTouchDelegateComposite(View r100) {
        super(f50770b, r100);
        this.f50771a = new ArrayList();
    }

    public final void a(final SlcHackTouchDelegate r100) {
        Iterator<SlcHackTouchDelegate> r101 = this.f50771a.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        if (r101.next().f50769e != r100.f50769e) goto L4;
        int r102 = com.bytedance.android.ecom.arch.slice.utils.a.f51057a;
        com.bytedance.android.ecom.arch.slice.utils.a.a(new SlcTouchDelegateComposite$addDelegate$1(r100));
        r101.remove();
        goto L4
    L8:
        int r103 = com.bytedance.android.ecom.arch.slice.utils.a.f51057a;
        com.bytedance.android.ecom.arch.slice.utils.a.a(new SlcTouchDelegateComposite$addDelegate$2(r100));
        this.f50771a.add(r100);
    }

    @Override // android.view.TouchDelegate
    public final boolean onTouchEvent(MotionEvent r110) {
        float r100 = r110.getX();
        float r101 = r110.getY();
        if ((!this.f50771a.isEmpty()) == false) goto L23;
        int r102 = this.f50771a.size() - 1;
        boolean r103 = false;
    L5:
        if (r102 < 0) goto L18;
        final SlcHackTouchDelegate r104 = (SlcHackTouchDelegate) CollectionsKt.getOrNull(this.f50771a, r102);
        if (r104 == null) goto L16;
        r110.setLocation(r100, r101);
        final boolean r105 = r104.onTouchEvent(r110);
        int r106 = com.bytedance.android.ecom.arch.slice.utils.a.f51057a;
        com.bytedance.android.ecom.arch.slice.utils.a.a(new AnonymousClass1(r104, r105));
        if (r105 == true) goto L13;
        if (r103 == true) goto L13;
        r103 = false;
    L14:
        if (r103 == false) goto L16;
    L13:
        r103 = true;
    L16:
        r102 = r102 - 1;
    L18:
        return r103;
    L23:
        return false;
    }
}
