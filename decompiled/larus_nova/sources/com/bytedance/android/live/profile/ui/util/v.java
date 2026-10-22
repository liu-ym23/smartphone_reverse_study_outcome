package com.bytedance.android.live.profile.ui.util;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import com.bytedance.common.utility.UIUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class v extends TouchDelegate {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f86962b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<TouchDelegate> f86963a;

    public static final class a {
        public a() {
        }

        public static void a(View r100, View r101, int r102, int r103, int r104, int r110) {
            Intrinsics.checkNotNullParameter(r100, "$this$addTouchDelegateToAncestor");
            if (r101 == null) goto L46;
            Intrinsics.checkNotNullParameter(r100, "delegateView");
            Intrinsics.checkNotNullParameter(r101, "ancestorView");
            View r105 = r100;
        L5:
            Object r106 = r105.getParent();
            int r107 = 0;
            if (r106 == r101) goto L7;
            if ((r106 instanceof View) == false) goto L11;
            r105 = (View) r106;
            goto L5
        L11:
            boolean r108 = false;
        L12:
            if (r108 == false) goto L49;
            int[] r109 = UIUtils.getLocationInAncestor(r100, r101);
            if (r109 != null) goto L17;
            return;
        L17:
            Rect r111 = new Rect();
            if (ArraysKt.getLastIndex(r109) < 0) goto L20;
            int r112 = r109[0];
        L21:
            r111.left = r112 - r102;
            if (1 > ArraysKt.getLastIndex(r109)) goto L24;
            int r113 = r109[1];
        L25:
            r111.top = r113 - r103;
            if (ArraysKt.getLastIndex(r109) < 0) goto L28;
            int r114 = r109[0];
        L29:
            r111.right = (r114 + r100.getWidth()) + r104;
            if (1 > ArraysKt.getLastIndex(r109)) goto L32;
            r107 = r109[1];
        L32:
            r111.bottom = (r107 + r100.getHeight()) + r110;
            TouchDelegate r115 = new TouchDelegate(r111, r100);
            Intrinsics.checkNotNullParameter(r101, "$this$addTouchDelegate");
            Intrinsics.checkNotNullParameter(r115, "touchDelegateVal");
            Rect r116 = new Rect();
            TouchDelegate r117 = r101.getTouchDelegate();
            if ((r117 instanceof v) == false) goto L40;
            TouchDelegate r118 = r101.getTouchDelegate();
            if (r118 == null) goto L38;
            ((v) r118).a(r115);
            return;
        L38:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.profile.ui.util.TouchDelegateComposite");
        L40:
            if ((r117 instanceof TouchDelegate) == false) goto L42;
            v r119 = new v(r116, r101);
            r119.a(r101.getTouchDelegate());
            r119.a(r115);
            r101.setTouchDelegate(r119);
            return;
        L42:
            v r120 = new v(r116, r101);
            r120.a(r115);
            r101.setTouchDelegate(r120);
            return;
        L28:
            r114 = 0;
            goto L29
        L24:
            r113 = 0;
            goto L25
        L20:
            r112 = 0;
            goto L21
        L49:
            return;
        L7:
            r108 = true;
            goto L12
        }
    }

    static {
        f86962b = new a();
    }

    public final void a(TouchDelegate r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        ((ArrayList) this.f86963a).add(r100);
    }

    @Override // android.view.TouchDelegate
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        float r101 = r100.getX();
        float r102 = r100.getY();
        Iterator r103 = ((ArrayList) this.f86963a).iterator();
    L3:
        boolean r104 = false;
    L5:
        if (r103.hasNext() == false) goto L10;
        TouchDelegate r105 = (TouchDelegate) r103.next();
        r100.setLocation(r101, r102);
        if (r105.onTouchEvent(r100) == true) goto L9;
        if (r104 == false) goto L3;
    L9:
        r104 = true;
        goto L5
    L10:
        return r104;
    }

    public v(Rect r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "bounds");
        Intrinsics.checkNotNullParameter(r101, "delegateView");
        super(r100, r101);
        this.f86963a = new ArrayList();
    }
}
