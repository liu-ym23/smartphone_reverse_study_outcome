package com.bytedance.android.ecom.arch.slice.render.util.touch_delegate;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewParent;
import com.bytedance.android.ecom.arch.slice.render.widget.SlcRootView;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes44.dex */
public final class SlcTouchDelegateHelper {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f50772d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SlcHackTouchDelegate f50773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f50774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakReference<View> f50775c;

    public static final class Companion {
        public Companion() {
        }

        public static int[] b(View r100, View r101) {
            int[] r102 = new int[2];
            float[] r103 = {0.0f, 0.0f};
            r103[0] = r100.getLeft() + 0.0f;
            r103[1] = r103[1] + r100.getTop();
            ViewParent r104 = r100.getParent();
        L4:
            if ((r104 instanceof View) == false) goto L9;
            View r105 = (View) r104;
            if (r104 == r101) goto L7;
            r103[0] = r103[0] - r105.getScrollX();
            r103[1] = r103[1] - r105.getScrollY();
            r103[0] = r103[0] + r105.getLeft();
            r103[1] = r103[1] + r105.getTop();
            r104 = r105.getParent();
            goto L4
        L7:
            boolean r106 = true;
        L10:
            if (r106 == true) goto L13;
            return null;
        L13:
            r102[0] = (int) r103[0];
            r102[1] = (int) r103[1];
            return r102;
        L9:
            r106 = false;
            goto L10
        }

        public static View a(View r100, int r101, int r110, int r111, int r112) {
            if (r100 != null) goto L6;
            return null;
        L6:
            if ((r100 instanceof SlcRootView) == false) goto L8;
            return null;
        L8:
            final Ref.IntRef r102 = new Ref.IntRef();
            r102.element = 1;
            Object r103 = r100.getParent();
            if ((r103 instanceof View) == true) goto L11;
            r103 = null;
        L11:
            View r104 = (View) r103;
        L12:
            if (r104 == null) goto L47;
            if ((r104 instanceof SlcRootView) == true) goto L47;
            int[] r105 = b(r100, r104);
            if (r105 == null) goto L17;
            int r106 = r105[0];
            if ((r106 - r101) < (-1)) goto L23;
            if ((r105[1] - r110) < (-1)) goto L29;
            if (((r106 + r100.getWidth()) + r111) > (r104.getWidth() + 1)) goto L35;
            if (((r105[1] + r100.getHeight()) + r112) <= (r104.getHeight() + 1)) goto L45;
            Object r107 = r104.getParent();
            if ((r107 instanceof View) == true) goto L44;
            r107 = null;
        L44:
            r104 = (View) r107;
            r102.element++;
            goto L12
        L45:
            int r108 = com.bytedance.android.ecom.arch.slice.utils.a.f51057a;
            com.bytedance.android.ecom.arch.slice.utils.a.a(new SlcTouchDelegateHelper$Companion$findAncestorViewForDelegateWhenAfterLayout$1(r102));
            return r104;
        L35:
            Object r109 = r104.getParent();
            if ((r109 instanceof View) == true) goto L38;
            r109 = null;
        L38:
            r104 = (View) r109;
            r102.element++;
            goto L12
        L29:
            Object r113 = r104.getParent();
            if ((r113 instanceof View) == true) goto L32;
            r113 = null;
        L32:
            r104 = (View) r113;
            r102.element++;
            goto L12
        L23:
            Object r114 = r104.getParent();
            if ((r114 instanceof View) == true) goto L26;
            r114 = null;
        L26:
            r104 = (View) r114;
            r102.element++;
            goto L12
        L17:
            Object r115 = r104.getParent();
            if ((r115 instanceof View) == true) goto L20;
            r115 = null;
        L20:
            r104 = (View) r115;
            r102.element++;
        L47:
            int r116 = com.bytedance.android.ecom.arch.slice.utils.a.f51057a;
            com.bytedance.android.ecom.arch.slice.utils.a.a(new SlcTouchDelegateHelper$Companion$findAncestorViewForDelegateWhenAfterLayout$2(r102));
            return r104;
        }
    }

    public SlcTouchDelegateHelper() {
        throw null;
    }

    static {
        f50772d = new Companion();
    }

    public final void b() {
        View r100 = this.f50775c.get();
        TouchDelegate r101 = null;
        if (r100 == null) goto L5;
        TouchDelegate r102 = r100.getTouchDelegate();
    L7:
        if ((r102 instanceof SlcTouchDelegateComposite) == false) goto L22;
        final SlcHackTouchDelegate r103 = this.f50773a;
        if (r103 == null) goto L23;
        View r104 = this.f50775c.get();
        if (r104 == null) goto L13;
        TouchDelegate r105 = r104.getTouchDelegate();
    L15:
        if ((r105 instanceof SlcTouchDelegateComposite) == false) goto L18;
        r101 = r105;
    L18:
        SlcTouchDelegateComposite r106 = (SlcTouchDelegateComposite) r101;
        if (r106 == null) goto L24;
        int r107 = com.bytedance.android.ecom.arch.slice.utils.a.f51057a;
        com.bytedance.android.ecom.arch.slice.utils.a.a(new SlcTouchDelegateComposite$removeDelegate$1(r103));
        r106.f50771a.remove(r103);
        return;
    L24:
        return;
    L13:
        r105 = null;
        goto L15
    L23:
        return;
    L22:
        return;
    L5:
        r102 = null;
        goto L7
    }

    public SlcTouchDelegateHelper(View r100, WeakReference r101) {
        this.f50774b = r100;
        this.f50775c = r101;
    }

    public final void a(int r100, int r101, int r102, int r103) {
        final View r104 = this.f50775c.get();
        if (r104 != null) goto L7;
        int r105 = com.bytedance.android.ecom.arch.slice.utils.a.f51057a;
        com.bytedance.android.ecom.arch.slice.utils.a.a(new SlcTouchDelegateHelper$addDelegate$1(this));
        return;
    L7:
        if (this.f50774b.getWidth() != 0) goto L9;
    L34:
        int r106 = com.bytedance.android.ecom.arch.slice.utils.a.f51057a;
        com.bytedance.android.ecom.arch.slice.utils.a.a(new SlcTouchDelegateHelper$addDelegate$2(this, r104));
        return;
    L9:
        if (this.f50774b.getHeight() == 0) goto L34;
        if (r104.getWidth() == 0) goto L34;
        if (r104.getHeight() == 0) goto L34;
        Companion r107 = f50772d;
        View r108 = this.f50774b;
        r107.getClass();
        int[] r109 = Companion.b(r108, r104);
        if (r109 != null) goto L19;
        int r110 = com.bytedance.android.ecom.arch.slice.utils.a.f51057a;
        com.bytedance.android.ecom.arch.slice.utils.a.a(new SlcTouchDelegateHelper$addDelegate$3(this));
        return;
    L19:
        Rect r111 = new Rect();
        int r112 = r109[0];
        r111.left = r112 - r100;
        r111.top = r109[1] - r101;
        r111.right = (r112 + this.f50774b.getWidth()) + r102;
        r111.bottom = (r109[1] + this.f50774b.getHeight()) + r103;
        SlcHackTouchDelegate r113 = new SlcHackTouchDelegate(r111, this.f50774b);     // Catch: Exception -> L31
        b();
        this.f50773a = r113;
        if ((r104.getTouchDelegate() instanceof SlcTouchDelegateComposite) == false) goto L29;
        TouchDelegate r114 = r104.getTouchDelegate();
        if ((r114 instanceof SlcTouchDelegateComposite) == true) goto L26;
        r114 = null;
    L26:
        SlcTouchDelegateComposite r115 = (SlcTouchDelegateComposite) r114;
        if (r115 == null) goto L38;
        r115.a(r113);
        return;
    L38:
        return;
    L29:
        SlcTouchDelegateComposite r116 = new SlcTouchDelegateComposite(r104);
        r116.a(r113);
        r104.setTouchDelegate(r116);
        return;
    L31:
        e = move-exception;
        nq.a.f(e, "创建SlcHackTouchDelegate失败");
    }
}
