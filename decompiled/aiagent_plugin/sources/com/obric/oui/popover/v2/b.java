package com.obric.oui.popover.v2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ab;
import com.obric.oui.common.style.f;
import com.obric.oui.common.style.j;
import com.obric.oui.common.util.g;
import com.obric.oui.popover.menu.OPopoverMenuView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;
import d.l.n;
import d.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: OPopoverBase.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f36047a = null;

    /* JADX INFO: compiled from: OPopoverBase.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f36048a = null;

        static {
            f36048a = new a();
        }

        private a() {
        }

        public static final /* synthetic */ View a(a r2, Context r3, int r4, View r5) {
            return r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, r5);
        }

        public static final /* synthetic */ void a(a r0, View r1, int r2) {
            r0.a(r1, r2);
        }

        private final View a(Context r4, int r5, View r6) {
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            boolean r1 = true;
            if (r5 != 1) goto L5;
            float r7 = 90.0f;
        L10:
            if (r7 == 0.0f) goto L13;
            r1 = false;
        L13:
            if (r1 == false) goto L15;
            return r6;
        L15:
            OPopoverLandscapeWrapper r8 = new OPopoverLandscapeWrapper(r3);
            r8.setOrientationAngle(r7);
            r8.addView(r6);
            return (View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin");
        L5:
            if (r5 == 3) goto L7;
            r7 = 0.0f;
            goto L10
        L7:
            r7 = 270.0f;
            goto L10
        }

        private final void a(View r3, int r4) {
            if (ZeusTransformUtils.instanceOf(r3, OPopoverMenuView.class) == false) goto L6;
            ((OPopoverMenuView) ZeusTransformUtils.preCheckCast(r3, OPopoverMenuView.class, "com.obric.aiagent.plugin")).setPopoverMaxHeight(r4);
        L6:
            if (ZeusTransformUtils.instanceOf(r3, ViewGroup.class) == false) goto L11;
            Iterator<View> r2 = ab.b((ViewGroup) ZeusTransformUtils.preCheckCast(r3, ViewGroup.class, "com.obric.aiagent.plugin")).a();
        L9:
            if (r2.hasNext() == false) goto L13;
            View r5 = (View) ZeusTransformUtils.preCheckCast(r2.next(), View.class, "com.obric.aiagent.plugin");
            f36048a.a(r5, r4);
            goto L9
        L13:
            return;
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.popover.v2.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OPopoverBase.kt */
    public static final class C0977b {

        /* JADX INFO: renamed from: com.obric.oui.popover.v2.b$b$a */
        /* JADX INFO: compiled from: OPopoverBase.kt */
        static final class a extends p implements d.h.a.a<x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b<T> f36049a;

            a(b<T> r3) {
                this.f36049a = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
                super(0);
            }

            @Override // d.h.a.a
            public /* synthetic */ x invoke() {
                a();
                return x.f38692a;
            }

            public final void a() {
                this.f36049a.onPopoverShownInternal();
            }
        }

        /* JADX INFO: renamed from: com.obric.oui.popover.v2.b$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OPopoverBase.kt */
        static final class C0978b extends p implements d.h.a.a<x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b<T> f36050a;

            C0978b(b<T> r3) {
                this.f36050a = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
                super(0);
            }

            @Override // d.h.a.a
            public /* synthetic */ x invoke() {
                a();
                return x.f38692a;
            }

            public final void a() {
                this.f36050a.setPopoverAnimator(null);
            }
        }

        /* JADX INFO: renamed from: com.obric.oui.popover.v2.b$b$c */
        /* JADX INFO: compiled from: OPopoverBase.kt */
        static final class c extends p implements d.h.a.a<x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b<T> f36051a;

            c(b<T> r3) {
                this.f36051a = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
                super(0);
            }

            @Override // d.h.a.a
            public /* synthetic */ x invoke() {
                a();
                return x.f38692a;
            }

            public final void a() {
                this.f36051a.setPopoverAnimator(null);
                this.f36051a.finishPopoverDismissInternal();
            }
        }

        /* JADX INFO: renamed from: com.obric.oui.popover.v2.b$b$d */
        /* JADX INFO: compiled from: OPopoverBase.kt */
        static final class d extends p implements d.h.a.a<x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b<T> f36052a;

            d(b<T> r3) {
                this.f36052a = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
                super(0);
            }

            @Override // d.h.a.a
            public /* synthetic */ x invoke() {
                a();
                return x.f38692a;
            }

            public final void a() {
                this.f36052a.onPopoverShownInternal();
            }
        }

        public static <T> boolean a(b<T> r2) {
            o.e((b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin"), "this");
            return true;
        }

        public static <T> Animator b(b<T> r2) {
            o.e((b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin"), "this");
            return null;
        }

        public static <T> Animator c(b<T> r2) {
            o.e((b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin"), "this");
            return null;
        }

        public static <T> View a(b<T> r2, View r3) {
            o.e((b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin"), "this");
            if (r3 == null) goto L6;
            return r3;
        L6:
            throw new IllegalArgumentException("mView must be not null".toString());
        }

        public static /* synthetic */ OPopoverLayout a(b r2, View r3, int r4, int r5, Object r6) {
            b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
            if (r6 != null) goto L10;
            if ((r5 & 2) == 0) goto L8;
            r4 = 3;
        L8:
            return r7.createPopoverBubbleLayout(r3, r4);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createPopoverBubbleLayout");
        }

        public static <T> OPopoverLayout a(b<T> r5, View r6, int r7) {
            b r8 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.aiagent.plugin");
            o.e(r8, "this");
            o.e(r6, "contentView");
            OPopoverLayout r0 = new OPopoverLayout((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getPopoverContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r8.getPopoverEnableBubbleMaterial(), r8.getPopoverMaterials(), r7);
            r0.setBackgroundColor(0);
            r0.setGravity(17);
            r0.addView(a.a(b.f36047a, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getPopoverContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r8.getPopoverDisplayOrientation(), r6));
            r0.setCornerRadius(g.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getPopoverContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), OPopoverLayout.Companion.a()));
            if (r8.getPopoverBgColor() == 0) goto L6;
            r0.setBgColor(r8.getPopoverBgColor());
        L6:
            if (r0.isEnableMaterial() == true) goto L8;
            r0.setBorderColor(r8.getPopoverBorderColor());
            r0.setBorderWidth(r8.getPopoverBorderWidth());
        L8:
            r0.setTransparentBg(r8.getPopoverTransparentBg());
            return r0;
        }

        public static <T> void a(b<T> r2, View r3, int r4, int r5) {
            b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
            o.e(r6, "this");
            o.e(r3, "target");
            if (r6.getPopoverWidth() != 0) goto L5;
        L7:
            r3.measure(r4, r5);
            return;
        L5:
            if (r6.getPopoverHeight() == 0) goto L7;
            r3.measure(View.MeasureSpec.makeMeasureSpec(r6.getPopoverWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(r6.getPopoverHeight(), 1073741824));
        }

        public static <T> void a(b<T> r4, int r5, View r6, int r7, int r8) {
            b r9 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.aiagent.plugin");
            o.e(r9, "this");
            o.e(r6, "measureTarget");
            if (r5 > 0) goto L5;
            return;
        L5:
            int r10 = n.c(r5 - (r9.getPopoverBubbleLayout().getArrowHeight() * 2), 0);
            a.a(b.f36047a, (View) ZeusTransformUtils.preCheckCast(r9.getPopoverBubbleLayout(), View.class, "com.obric.aiagent.plugin"), r10);
            r9.getPopoverBubbleLayout().requestLayout();
            r9.measurePopoverContent(r6, r7, r8);
        }

        public static <T> float a(b<T> r2, float r3, int r4, float r5) {
            o.e((b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin"), "this");
            if (Float.isNaN(r3) == false) goto L6;
            return r5;
        L6:
            return r3 - r4;
        }

        public static <T> int d(b<T> r2) {
            b r3 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
            o.e(r3, "this");
            int r4 = r3.getPopoverDisplayOrientation();
            if (r4 != 1) goto L5;
            return 90;
        L5:
            if (r4 == 3) goto L7;
            return 0;
        L7:
            return 270;
        }

        public static <T> void a(b<T> r2, int r3) {
            b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
            o.e(r4, "this");
            r4.setPopoverGravity(OPopover.Companion.a(r3));
        }

        public static <T> void b(b<T> r2, int r3) {
            b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
            o.e(r4, "this");
            r4.setPopoverXOffset(r3);
        }

        public static <T> void c(b<T> r2, int r3) {
            b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
            o.e(r4, "this");
            r4.setPopoverYOffset(r3);
        }

        public static <T> View e(b<T> r2) {
            b r3 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
            o.e(r3, "this");
            return (View) ZeusTransformUtils.preCheckCast(r3.getPopoverBubbleLayout(), View.class, "com.obric.aiagent.plugin");
        }

        public static <T> void a(b<T> r2, int r3, int r4) {
            b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
            o.e(r5, "this");
            r5.measurePopoverContent(r5.getContentViewInternal(), r3, r4);
        }

        public static <T> void f(b<T> r5) {
            b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.aiagent.plugin");
            o.e(r6, "this");
            r6.measurePopoverContent(r6.getContentViewInternal(), 0, 0);
            r6.getPopoverWindowFrame().setPivotX(r6.resolvePopoverPivot(r6.getPopoverAnchorCenterX(), r6.getPopoverPopupOriginX(), r6.getPopoverWindowFrame().getMeasuredWidth() / 2.0f));
            r6.getPopoverWindowFrame().setPivotY(r6.resolvePopoverPivot(r6.getPopoverAnchorCenterY(), r6.getPopoverPopupOriginY(), r6.getPopoverWindowFrame().getMeasuredHeight() / 2.0f));
        }

        public static /* synthetic */ void a(b r2, ViewGroup r3, d.h.a.a r4, int r5, Object r6) {
            b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
            d.h.a.a<x> r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
            if (r6 != null) goto L13;
            if ((r5 & 1) == 0) goto L8;
            r3 = r7.getPopoverWindowFrame();
        L8:
            if ((r5 & 2) == 0) goto L10;
            r8 = null;
        L10:
            r7.showPopoverDirectlyInternal(r3, r8);
            return;
        L13:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showPopoverDirectlyInternal");
        }

        public static <T> void a(b<T> r2, ViewGroup r3, d.h.a.a<x> r4) {
            b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
            d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
            o.e(r5, "this");
            o.e(r3, "view");
            r5.resetPopoverAnimatedViewState((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"));
            r3.setVisibility(0);
            if (r6 == null) goto L7;
            r6.invoke();
            return;
        }

        public static /* synthetic */ AnimatorSet a(b r4, boolean r5, int r6, boolean r7, Animator r8, d.h.a.a r9, d.h.a.a r10, int r11, Object r12) {
            b r13 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.aiagent.plugin");
            d.h.a.a<x> r14 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.a.a<x> r15 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r10, d.h.a.a.class, "com.obric.aiagent.plugin");
            if (r12 != null) goto L25;
            if ((r11 & 2) == 0) goto L7;
            r6 = r13.getPopoverGravity();
        L7:
            int r16 = r6;
            if ((r11 & 4) == 0) goto L10;
            r7 = true;
        L10:
            boolean r0 = r7;
            if ((r11 & 8) == 0) goto L13;
            Animator r1 = null;
        L15:
            if ((r11 & 16) == 0) goto L17;
            d.h.a.a<x> r2 = null;
        L19:
            if ((r11 & 32) == 0) goto L21;
            d.h.a.a<x> r3 = null;
        L23:
            return r13.startPopoverVisibilityAnimationInternal(r5, r16, r0, r1, r2, r3);
        L21:
            r3 = r15;
            goto L23
        L17:
            r2 = r14;
            goto L19
        L13:
            r1 = r8;
            goto L15
        L25:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startPopoverVisibilityAnimationInternal");
        }

        public static <T> AnimatorSet a(b<T> r13, boolean r14, int r15, boolean r16, Animator r17, d.h.a.a<x> r18, d.h.a.a<x> r19) {
            b r0 = (b) ZeusTransformUtils.wrapperContextForParams(r13, b.class, "com.obric.aiagent.plugin");
            d.h.a.a<x> r11 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r18, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.a.a<x> r12 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r19, d.h.a.a.class, "com.obric.aiagent.plugin");
            o.e(r0, "this");
            r0.updatePopoverPivotInternal();
            return com.obric.oui.popover.v2.a.f36043a.a(r0.getPopoverWindowFrame(), r16, r15, r0.getPopoverWindowFrame().getPivotX(), r0.getPopoverWindowFrame().getPivotY(), r14, r17, r11, r12);
        }

        public static /* synthetic */ void a(b r2, View r3, int r4, Object r5) {
            b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
            if (r5 != null) goto L10;
            if ((r4 & 1) == 0) goto L7;
            r3 = (View) ZeusTransformUtils.preCheckCast(r6.getPopoverWindowFrame(), View.class, "com.obric.aiagent.plugin");
        L7:
            r6.resetPopoverAnimatedViewState(r3);
            return;
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resetPopoverAnimatedViewState");
        }

        public static <T> void b(b<T> r2, View r3) {
            o.e((b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin"), "this");
            o.e(r3, "view");
            r3.setAlpha(1.0f);
            r3.setScaleX(1.0f);
            r3.setScaleY(1.0f);
            r3.setTranslationY(0.0f);
        }

        public static <T> c d(b<T> r9, int r10) {
            b r11 = (b) ZeusTransformUtils.wrapperContextForParams(r9, b.class, "com.obric.aiagent.plugin");
            o.e(r11, "this");
            if (r10 == 0) goto L5;
            List<j> r12 = f.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getPopoverContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r10);
            o.c(r12, "extractShadowInfo(popoverContext, shadowStyleRes)");
            Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin");
            c r14 = new c(0, 0, 0, 0, 15, null);
            Iterator<T> r15 = r13.iterator();
        L8:
            if (r15.hasNext() == false) goto L10;
            j r0 = (j) ZeusTransformUtils.preCheckCast(r15.next(), j.class, "com.obric.aiagent.plugin");
            r14.a(Math.max(r14.a(), d.i.a.a(r0.b() - r0.c())));
            r14.b(Math.max(r14.b(), d.i.a.a(r0.b() - r0.d())));
            r14.c(Math.max(r14.c(), d.i.a.a(r0.b() + r0.c())));
            r14.d(Math.max(r14.d(), d.i.a.a(r0.b() + r0.d())));
            goto L8
        L10:
            return r14;
        L5:
            return new c(0, 0, 0, 0, 15, null);
        }

        public static <T> float e(b<T> r3, int r4) {
            b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
            o.e(r5, "this");
            float r0 = 0.0f;
            if (r4 != 0) goto L5;
            return 0.0f;
        L5:
            List<j> r6 = f.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getPopoverContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4);
            o.c(r6, "extractShadowInfo(popoverContext, shadowStyleRes)");
            Iterator<T> r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L7:
            if (r7.hasNext() == false) goto L9;
            r0 = r0 + ((j) ZeusTransformUtils.preCheckCast(r7.next(), j.class, "com.obric.aiagent.plugin")).b();
            goto L7
        L9:
            return r0;
        }

        public static /* synthetic */ void a(b r2, int r3, View r4, int r5, Object r6) {
            b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
            if (r6 != null) goto L10;
            if ((r5 & 2) == 0) goto L7;
            r4 = r7.getContentViewInternal();
        L7:
            r7.setMaxContentHeightInternal(r3, r4);
            return;
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMaxContentHeightInternal");
        }

        public static <T> void a(b<T> r2, int r3, View r4) {
            b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
            o.e(r5, "this");
            o.e(r4, "measureTarget");
            if (r5.isPopoverBubbleLayoutInitialized() == false) goto L8;
            if (r3 <= 0) goto L9;
            r5.setPopoverMaxContentHeight(r3, r4, Integer.MIN_VALUE, Integer.MIN_VALUE);
            return;
        L9:
            return;
        }

        public static <T> boolean g(b<T> r4) {
            b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.aiagent.plugin");
            o.e(r5, "this");
            if (r5.getPopoverShowWithAnimation() == true) goto L5;
        L7:
            return false;
        L5:
            if (r5.getPopoverAnimationDurationMillis() <= 0) goto L7;
            return true;
        }

        public static <T> void h(b<T> r2) {
            b r3 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
            o.e(r3, "this");
            AnimatorSet r0 = r3.getPopoverAnimator();
            if (r0 == null) goto L6;
            r0.cancel();
        L6:
            r3.setPopoverAnimator(null);
        }

        public static <T> void i(b<T> r3) {
            b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
            o.e(r4, "this");
            a(r4, null, (d.h.a.a) ZeusTransformUtils.preCheckCast(new d(r4), d.h.a.a.class, "com.obric.aiagent.plugin"), 1, null);
        }

        public static <T> void j(b<T> r9) {
            b r10 = (b) ZeusTransformUtils.wrapperContextForParams(r9, b.class, "com.obric.aiagent.plugin");
            o.e(r10, "this");
            r10.cancelPopoverAnimatorInternal();
            boolean r5 = r10.getPopoverAnimationIsWindowMode();
            r10.setPopoverAnimator(r10.startPopoverVisibilityAnimationInternal(true, r10.resolvePopoverAnimationGravityInternal(), r5, r10.getPopoverEnterAnimator(), (d.h.a.a) ZeusTransformUtils.preCheckCast(new a(r10), d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(new C0978b(r10), d.h.a.a.class, "com.obric.aiagent.plugin")));
        }

        public static <T> void k(b<T> r11) {
            b r12 = (b) ZeusTransformUtils.wrapperContextForParams(r11, b.class, "com.obric.aiagent.plugin");
            o.e(r12, "this");
            r12.cancelPopoverAnimatorInternal();
            r12.onPopoverStartDismissInternal();
            boolean r5 = r12.getPopoverAnimationIsWindowMode();
            r12.setPopoverAnimator(a(r12, false, r12.resolvePopoverAnimationGravityInternal(), r5, r12.getPopoverExitAnimator(), null, (d.h.a.a) ZeusTransformUtils.preCheckCast(new c(r12), d.h.a.a.class, "com.obric.aiagent.plugin"), 16, null));
        }

        public static <T> void l(b<T> r6) {
            b<?> r1 = (b) ZeusTransformUtils.wrapperContextForParams(r6, b.class, "com.obric.aiagent.plugin");
            o.e(r1, "this");
            d.f36057a.a(r1, r1.getPopoverCoverPreviousWhenStacked(), r1.getPopoverStackCoverColor(), r1.getPopoverStackAlphaPrevious(), r1.getPopoverStackScalePrevious());
        }

        public static <T> void m(b<T> r2) {
            b<?> r3 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
            o.e(r3, "this");
            if (r3.getPopoverPushedToStack() == false) goto L5;
            return;
        L5:
            r3.setPopoverPushedToStack(true);
            d.f36057a.a(r3);
        }

        public static <T> void n(b<T> r2) {
            b<?> r3 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
            o.e(r3, "this");
            if (r3.getPopoverRemovedFromStack() == false) goto L5;
            return;
        L5:
            r3.setPopoverRemovedFromStack(true);
            d.f36057a.b(r3);
        }
    }

    /* JADX INFO: compiled from: OPopoverBase.kt */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f36053a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f36054b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f36055c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f36056d;

        public c() {
            this(0, 0, 0, 0, 15, null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (this.f36053a == r6.f36053a) goto L12;
            return false;
        L12:
            if (this.f36054b == r6.f36054b) goto L15;
            return false;
        L15:
            if (this.f36055c == r6.f36055c) goto L18;
            return false;
        L18:
            if (this.f36056d == r6.f36056d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.f36053a) * 31) + Integer.hashCode(this.f36054b)) * 31) + Integer.hashCode(this.f36055c)) * 31) + Integer.hashCode(this.f36056d);
        }

        public String toString() {
            return "ShadowPadding(left=" + this.f36053a + ", top=" + this.f36054b + ", right=" + this.f36055c + ", bottom=" + this.f36056d + ')';
        }

        public c(int r1, int r2, int r3, int r4) {
            this.f36053a = r1;
            this.f36054b = r2;
            this.f36055c = r3;
            this.f36056d = r4;
        }

        public /* synthetic */ c(int r2, int r3, int r4, int r5, int r6, h r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = 0;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = 0;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = 0;
        L12:
            if ((r6 & 8) == 0) goto L14;
            r5 = 0;
        L14:
            this(r2, r3, r4, r5);
        }

        public final int a() {
            return this.f36053a;
        }

        public final void a(int r1) {
            this.f36053a = r1;
        }

        public final int b() {
            return this.f36054b;
        }

        public final void b(int r1) {
            this.f36054b = r1;
        }

        public final int c() {
            return this.f36055c;
        }

        public final void c(int r1) {
            this.f36055c = r1;
        }

        public final int d() {
            return this.f36056d;
        }

        public final void d(int r1) {
            this.f36056d = r1;
        }
    }

    /* JADX INFO: compiled from: OPopoverBase.kt */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f36057a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final List<WeakReference<b<?>>> f36058b = null;

        /* JADX INFO: compiled from: OPopoverBase.kt */
        static final class a extends p implements d.h.a.b<WeakReference<b<?>>, Boolean> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f36059a = null;

            static {
                f36059a = new a();
            }

            a() {
                super(1);
            }

            @Override // d.h.a.b
            public /* synthetic */ Boolean invoke(WeakReference<b<?>> r3) {
                return a((WeakReference) ZeusTransformUtils.preCheckCast(r3, WeakReference.class, "com.obric.aiagent.plugin"));
            }

            public final Boolean a(WeakReference<b<?>> r2) {
                o.e(r2, "ref");
                b r1 = (b) ZeusTransformUtils.preCheckCast(r2.get(), b.class, "com.obric.aiagent.plugin");
                if (r1 != null) goto L5;
            L8:
                boolean r3 = true;
            L10:
                return Boolean.valueOf(r3);
            L5:
                if (r1.isPopoverShowing() == false) goto L8;
                r3 = false;
                goto L10
            }
        }

        /* JADX INFO: renamed from: com.obric.oui.popover.v2.b$d$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OPopoverBase.kt */
        static final class C0979b extends p implements d.h.a.b<WeakReference<b<?>>, Boolean> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b<?> f36060a;

            C0979b(b<?> r3) {
                this.f36060a = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
                super(1);
            }

            public final Boolean a(WeakReference<b<?>> r2) {
                o.e(r2, "it");
                if (r2.get() != this.f36060a) goto L5;
                boolean r1 = true;
            L7:
                return Boolean.valueOf(r1);
            L5:
                r1 = false;
                goto L7
            }

            @Override // d.h.a.b
            public /* synthetic */ Boolean invoke(WeakReference<b<?>> r3) {
                return a((WeakReference) ZeusTransformUtils.preCheckCast(r3, WeakReference.class, "com.obric.aiagent.plugin"));
            }
        }

        /* JADX INFO: compiled from: OPopoverBase.kt */
        static final class c extends p implements d.h.a.b<WeakReference<b<?>>, Boolean> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b<?> f36061a;

            c(b<?> r3) {
                this.f36061a = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
                super(1);
            }

            public final Boolean a(WeakReference<b<?>> r2) {
                o.e(r2, "it");
                if (r2.get() != this.f36061a) goto L5;
                boolean r1 = true;
            L7:
                return Boolean.valueOf(r1);
            L5:
                r1 = false;
                goto L7
            }

            @Override // d.h.a.b
            public /* synthetic */ Boolean invoke(WeakReference<b<?>> r3) {
                return a((WeakReference) ZeusTransformUtils.preCheckCast(r3, WeakReference.class, "com.obric.aiagent.plugin"));
            }
        }

        private d() {
        }

        static {
            f36057a = new d();
            f36058b = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        }

        public final synchronized void a(b<?> r5, boolean r6, int r7, float r8, float r9) {
            monitor-enter(this);
            b<?> r10 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
            o.e(r10, "current");     // Catch: Throwable -> L10
            OPopoverLayout.setCovered$default(r10.getPopoverBubbleLayout(), false, 0, 2, null);     // Catch: Throwable -> L10
            if (r6 == true) goto L7;
            monitor-exit(this);
            return;
        L7:
            a(r10, r7, r8, r9);     // Catch: Throwable -> L10
            monitor-exit(this);
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public final synchronized void a(b<?> r5) {
            monitor-enter(this);
            b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
            o.e(r6, "current");     // Catch: Throwable -> L6
            a();     // Catch: Throwable -> L6
            List<WeakReference<b<?>>> r0 = f36058b;     // Catch: Throwable -> L6
            d.a.p.a(r0, (d.h.a.b) ZeusTransformUtils.preCheckCast(new c(r6), d.h.a.b.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L6
            r0.add(new WeakReference(r6));     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public final synchronized void b(b<?> r4) {
            monitor-enter(this);
            b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
            o.e(r5, "current");     // Catch: Throwable -> L9
            a();     // Catch: Throwable -> L9
            d.a.p.a(f36058b, (d.h.a.b) ZeusTransformUtils.preCheckCast(new C0979b(r5), d.h.a.b.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L9
            b<?> r0 = a(this, null, 1, null);     // Catch: Throwable -> L9
            if (r0 == null) goto L7;
            com.obric.oui.popover.v2.a.f36043a.a(r0, true, 1.0f, 1.0f);     // Catch: Throwable -> L9
        L7:
            monitor-exit(this);
            return;
        L9:
            th = move-exception;
            throw th;
        }

        private final synchronized void a() {
            monitor-enter(this);
            d.a.p.a(f36058b, (d.h.a.b) ZeusTransformUtils.preCheckCast(a.f36059a, d.h.a.b.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        static /* synthetic */ b a(d r1, b r2, int r3, Object r4) {
            b<?> r5 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
            if ((r3 & 1) == 0) goto L6;
            r5 = null;
        L6:
            return r1.c(r5);
        }

        private final synchronized b<?> c(b<?> r5) {
            monitor-enter(this);
            b<?> r6 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
            a();     // Catch: Throwable -> L19
            int r0 = f36058b.size() - 1;     // Catch: Throwable -> L19
            if (r0 < 0) goto L17;
        L5:
            int r1 = r0 - 1;     // Catch: Throwable -> L19
            b<?> r2 = (b) ZeusTransformUtils.preCheckCast(((WeakReference) ZeusTransformUtils.preCheckCast(f36058b.get(r0), WeakReference.class, "com.obric.aiagent.plugin")).get(), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
            if (r2 == null) goto L11;
            if (r6 == null) goto L14;
            if (r2 == r6) goto L11;
        L14:
            monitor-exit(this);
            return r2;
        L11:
            if (r1 < 0) goto L17;
            r0 = r1;
        L17:
            monitor-exit(this);
            return null;
        L19:
            th = move-exception;
            throw th;
        }

        private final synchronized void a(b<?> r2, int r3, float r4, float r5) {
            monitor-enter(this);
            b<?> r6 = c((b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L10
            if (r6 != null) goto L7;
            monitor-exit(this);
            return;
        L7:
            com.obric.oui.popover.v2.a.f36043a.a(r6, false, r4, r5);     // Catch: Throwable -> L10
            monitor-exit(this);
            return;
        L10:
            th = move-exception;
            throw th;
        }
    }

    static {
        f36047a = a.f36048a;
    }

    void cancelPopoverAnimatorInternal();

    OPopoverLayout createPopoverBubbleLayout(View r1, int r2);

    void finishPopoverDismissInternal();

    View getContentViewInternal();

    float getPopoverAnchorCenterX();

    float getPopoverAnchorCenterY();

    long getPopoverAnimationDurationMillis();

    boolean getPopoverAnimationIsWindowMode();

    AnimatorSet getPopoverAnimator();

    int getPopoverBgColor();

    int getPopoverBorderColor();

    int getPopoverBorderWidth();

    OPopoverLayout getPopoverBubbleLayout();

    Context getPopoverContext();

    boolean getPopoverCoverPreviousWhenStacked();

    int getPopoverDisplayOrientation();

    boolean getPopoverEnableBubbleMaterial();

    Animator getPopoverEnterAnimator();

    Animator getPopoverExitAnimator();

    int getPopoverGravity();

    int getPopoverHeight();

    d.h.a.b<Boolean, com.obric.oui.material.c[]> getPopoverMaterials();

    int getPopoverPopupOriginX();

    int getPopoverPopupOriginY();

    boolean getPopoverPushedToStack();

    boolean getPopoverRemovedFromStack();

    boolean getPopoverShowWithAnimation();

    float getPopoverStackAlphaPrevious();

    int getPopoverStackCoverColor();

    float getPopoverStackScalePrevious();

    boolean getPopoverTransparentBg();

    int getPopoverWidth();

    ViewGroup getPopoverWindowFrame();

    boolean isPopoverBubbleLayoutInitialized();

    boolean isPopoverShowing();

    void measurePopoverContent(View r1, int r2, int r3);

    void onPopoverShownInternal();

    void onPopoverStartDismissInternal();

    void resetPopoverAnimatedViewState(View r1);

    int resolvePopoverAnimationGravityInternal();

    float resolvePopoverPivot(float r1, int r2, float r3);

    void setMaxContentHeightInternal(int r1, View r2);

    void setPopoverAnimator(AnimatorSet r1);

    void setPopoverGravity(int r1);

    void setPopoverMaxContentHeight(int r1, View r2, int r3, int r4);

    void setPopoverPushedToStack(boolean r1);

    void setPopoverRemovedFromStack(boolean r1);

    void setPopoverXOffset(int r1);

    void setPopoverYOffset(int r1);

    void showPopoverDirectlyInternal(ViewGroup r1, d.h.a.a<x> r2);

    AnimatorSet startPopoverVisibilityAnimationInternal(boolean r1, int r2, boolean r3, Animator r4, d.h.a.a<x> r5, d.h.a.a<x> r6);

    void updatePopoverPivotInternal();
}
