package com.obric.appstore.ui.menu;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import androidx.core.view.ViewCompat;
import bg.h;
import com.bytedanceos.common.ui.widget.SearchChipsView;
import com.obric.oui.common.style.IOUIAlpha;
import com.obric.oui.popover.OPopover;
import com.obric.oui.popover.e;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class PopMenu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f11041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OPopover f11042b;

    public static final class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f11043a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PopMenu f11044b;

        public a(View r10, PopMenu r11) {
            this.f11043a = r10;
            this.f11044b = r11;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r10) {
            q.g(r10, "view");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r10) {
            q.g(r10, "view");
            this.f11043a.removeOnAttachStateChangeListener(this);
            this.f11044b.b();
        }
    }

    public PopMenu() {
    }

    public static /* synthetic */ void a(PopMenu r10, View r11) {
        g(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void g(PopMenu r10, View r11) {
        q.g(r10, "this$0");
        q.g(r11, "$anchor");
        r10.b();
        r11.setSelected(false);
        if ((r11 instanceof IOUIAlpha) == false) goto L5;
        IOUIAlpha r12 = (IOUIAlpha) r11;
    L6:
        if (r12 == null) goto L9;
        r12.setChangeAlphaWhenPress(true);
        return;
    L9:
        return;
    L5:
        r12 = null;
        goto L6
    }

    public final void b() {
        OPopover r10 = this.f11042b;
        if (r10 == null) goto L5;
        r10.dismiss();
    L5:
        this.f11042b = null;
        this.f11041a = null;
    }

    public final Object c() {
        Object r10 = this.f11041a;
        if (r10 != null) goto L6;
        return null;
    L6:
        return r10;
    }

    public final boolean d() {
        OPopover r10 = this.f11042b;
        if (r10 != null) goto L5;
        return false;
    L5:
        if (r10.isShowing() == true) goto L7;
        return false;
    L7:
        return true;
    }

    public final void e(View r10, int[] r11, List r12, Function1 r13) {
        q.g(r10, "anchor");
        q.g(r12, Card.KEY_ITEMS);
        q.g(r13, "listener");
        f(null, r10, r11, r12, r13);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f(Object r30, final View r31, int[] r32, List r33, final Function1 r34) {
        q.g(r31, "anchor");
        q.g(r33, Card.KEY_ITEMS);
        q.g(r34, "listener");
        b();
        Context r10 = r31.getContext();
        IOUIAlpha r11 = null;
        if ((r10 instanceof Activity) == false) goto L5;
        Activity r12 = (Activity) r10;
    L6:
        if (r12 != null) goto L9;
        return;
    L9:
        if (r12.isFinishing() == false) goto L11;
        return;
    L11:
        int r13 = yf.b.b(TypedValue.applyDimension(1, SearchChipsView.GRAY, Resources.getSystem().getDisplayMetrics()));
        OPopover.a r14 = new OPopover.a(r12);
        OPopoverEntranceMenuView.Builder r15 = new OPopoverEntranceMenuView.Builder(r12);
        r15.g(r13);
        Iterator r16 = r33.iterator();
    L13:
        if (r16.hasNext() == false) goto L15;
        final b r17 = (b) r16.next();
        OPopoverEntranceMenuView.Builder.c(r15, Integer.valueOf(r17.a()), null, null, r17.c(), null, null, false, null, new PopMenu$show$popover$1$1$1(r34, r17, this), 246, null);
        goto L13
    L15:
        OPopover r18 = r14.V(r15.d()).a();
        r18.setOnDismissListener(new com.obric.appstore.ui.menu.a(this, r31));
        if ((r31 instanceof IOUIAlpha) == false) goto L18;
        r11 = (IOUIAlpha) r31;
    L18:
        int r19 = 0;
        if (r11 == null) goto L21;
        r11.setChangeAlphaWhenPress(false);
    L21:
        r31.setSelected(true);
        int r20 = r31.getMeasuredWidth() / 2;
        if (r32 != null) goto L24;
        int r21 = 0;
    L25:
        if (r32 == null) goto L28;
        r19 = r32[1] - yf.b.b(TypedValue.applyDimension(1, 25, Resources.getSystem().getDisplayMetrics()));
    L28:
        e.b(e.f16131a, r18, r31, 48, true, 0.0f, r21, r19, false, 0, 0, false, 1936, null);
        if (ViewCompat.S(r31) == true) goto L32;
        b();
    L33:
        this.f11042b = r18;
        this.f11041a = r30;
        return;
    L32:
        r31.addOnAttachStateChangeListener(new a(r31, this));
        goto L33
    L24:
        int r22 = r13 / 2;
        r21 = h.k(r32[0] - r20, (-r20) + r22, r20 - r22);
        goto L25
    L5:
        r12 = null;
        goto L6
    }
}
