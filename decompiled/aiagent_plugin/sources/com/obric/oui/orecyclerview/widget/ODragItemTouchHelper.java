package com.obric.oui.orecyclerview.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: ODragItemTouchHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ODragItemTouchHelper extends ItemTouchHelper {

    /* JADX INFO: compiled from: ODragItemTouchHelper.kt */
    private static final class CallbackImpl extends ItemTouchHelper.a implements ViewTreeObserver.OnPreDrawListener {
        private final RecyclerView.a<?> adapter;
        private final int[] cachedRootLoc;
        private final int[] cachedRvLoc;
        private final int[] cachedViewLoc;
        private final a callback;
        private RecyclerView.v currentDragViewHolder;
        private float dragScale;
        private int dragStartY;
        private final WeakHashMap<RecyclerView.v, com.obric.common.oea.foundation.animation.manager.d> dropAnimators;
        private boolean isLongPressDragEnabled;
        private Float lastTouchBottom;
        private Float lastTouchTop;
        private final WeakHashMap<RecyclerView.v, View> mirrorViews;
        private final WeakHashMap<RecyclerView.v, com.obric.common.oea.foundation.animation.manager.d> pickUpAnimators;
        private final WeakHashMap<RecyclerView.v, Float> recoverRatios;

        /* JADX INFO: compiled from: ODragItemTouchHelper.kt */
        static final class a extends d.h.b.p implements d.h.a.m<Boolean, Throwable, d.x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ View f35590a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ View f35591b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ CallbackImpl f35592c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ RecyclerView.v f35593d;

            a(View r1, View r2, CallbackImpl r3, RecyclerView.v r4) {
                this.f35590a = r1;
                this.f35591b = r2;
                this.f35592c = r3;
                this.f35593d = r4;
                super(2);
            }

            @Override // d.h.a.m
            public /* synthetic */ d.x invoke(Boolean r3, Throwable r4) {
                a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue(), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.aiagent.plugin"));
                return d.x.f38692a;
            }

            public final void a(boolean r2, Throwable r3) {
                this.f35590a.setScaleX(1.0f);
                this.f35590a.setScaleY(1.0f);
                this.f35590a.setVisibility(0);
                this.f35591b.setScaleX(1.0f);
                this.f35591b.setScaleY(1.0f);
                ViewParent r4 = this.f35591b.getParent();
                if (ZeusTransformUtils.instanceOf(r4, ViewGroup.class) == false) goto L5;
                ViewGroup r5 = (ViewGroup) ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.aiagent.plugin");
            L6:
                if (r5 == null) goto L9;
                r5.removeView(this.f35591b);
            L9:
                View r6 = (View) ZeusTransformUtils.preCheckCast(CallbackImpl.access$getMirrorViews$p(this.f35592c).get(this.f35593d), View.class, "com.obric.aiagent.plugin");
                if (r6 == null) goto L17;
                View r7 = this.f35591b;
                CallbackImpl r0 = this.f35592c;
                RecyclerView.v r1 = this.f35593d;
                if (d.h.b.o.a(r6, r7) == false) goto L16;
                CallbackImpl.access$getMirrorViews$p(r0).remove(r1);
                return;
            L16:
                return;
            L17:
                return;
            L5:
                r5 = null;
                goto L6
            }
        }

        /* JADX INFO: compiled from: ODragItemTouchHelper.kt */
        static final class b extends d.h.b.p implements d.h.a.m<Boolean, Throwable, d.x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ View f35594a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ CallbackImpl f35595b;

            b(View r1, CallbackImpl r2) {
                this.f35594a = r1;
                this.f35595b = r2;
                super(2);
            }

            @Override // d.h.a.m
            public /* synthetic */ d.x invoke(Boolean r3, Throwable r4) {
                a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue(), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.aiagent.plugin"));
                return d.x.f38692a;
            }

            public final void a(boolean r1, Throwable r2) {
                this.f35594a.setAlpha(1.0f);
                this.f35594a.setScaleX(CallbackImpl.access$getDragScale$p(this.f35595b));
                this.f35594a.setScaleY(CallbackImpl.access$getDragScale$p(this.f35595b));
            }
        }

        @Override // com.obric.oui.orecyclerview.widget.ItemTouchHelper.a
        public void onSwiped(RecyclerView.v r1, int r2) {
            d.h.b.o.e(r1, "viewHolder");
        }

        public static final /* synthetic */ float access$getDragScale$p(CallbackImpl r0) {
            return r0.dragScale;
        }

        public static final /* synthetic */ WeakHashMap access$getMirrorViews$p(CallbackImpl r0) {
            return r0.mirrorViews;
        }

        public CallbackImpl(RecyclerView.a<?> r3, a r4) {
            a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r3, "adapter");
            d.h.b.o.e(r5, "callback");
            this.adapter = r3;
            this.callback = r5;
            this.dragScale = 1.05f;
            this.cachedRvLoc = new int[2];
            this.cachedRootLoc = new int[2];
            this.cachedViewLoc = new int[2];
            this.recoverRatios = new WeakHashMap();
            this.pickUpAnimators = new WeakHashMap();
            this.dropAnimators = new WeakHashMap();
            this.mirrorViews = new WeakHashMap();
        }

        public final void setDragScale(float r1) {
            this.dragScale = r1;
        }

        public final void setLongPressDragEnabled(boolean r1) {
            this.isLongPressDragEnabled = r1;
        }

        @Override // com.obric.oui.orecyclerview.widget.ItemTouchHelper.a
        public boolean isLongPressDragEnabled() {
            return this.isLongPressDragEnabled;
        }

        @Override // com.obric.oui.orecyclerview.widget.ItemTouchHelper.a
        public int getMovementFlags(RecyclerView r2, RecyclerView.v r3) {
            d.h.b.o.e(r2, "recyclerView");
            d.h.b.o.e(r3, "viewHolder");
            if (findAdapterForViewHolder(r3) != null) goto L7;
            return ItemTouchHelper.a.makeMovementFlags(0, 0);
        L7:
            if (this.callback.a(r3, r3.k()) == false) goto L9;
            int r1 = 3;
        L11:
            return ItemTouchHelper.a.makeMovementFlags(r1, 0);
        L9:
            r1 = 0;
            goto L11
        }

        @Override // com.obric.oui.orecyclerview.widget.ItemTouchHelper.a
        public void onSelectedChanged(RecyclerView.v r6, int r7) {
            super.onSelectedChanged(r6, r7);
            if (r7 != 0) goto L5;
            stopTrackingDragPosition(this.currentDragViewHolder);
            return;
        L5:
            if (r7 != 2) goto L34;
            if (r6 == null) goto L35;
            com.obric.common.oea.foundation.animation.manager.d r8 = (com.obric.common.oea.foundation.animation.manager.d) ZeusTransformUtils.preCheckCast(this.pickUpAnimators.get(r6), com.obric.common.oea.foundation.animation.manager.d.class, "com.obric.aiagent.plugin");
            ViewGroup r3 = null;
            if (r8 == null) goto L13;
            com.obric.common.oea.foundation.animation.manager.d.a(r8, false, 1, null);
        L13:
            com.obric.common.oea.foundation.animation.manager.d r9 = (com.obric.common.oea.foundation.animation.manager.d) ZeusTransformUtils.preCheckCast(this.dropAnimators.get(r6), com.obric.common.oea.foundation.animation.manager.d.class, "com.obric.aiagent.plugin");
            if (r9 == null) goto L17;
            com.obric.common.oea.foundation.animation.manager.d.a(r9, false, 1, null);
        L17:
            View r10 = (View) ZeusTransformUtils.preCheckCast(this.mirrorViews.get(r6), View.class, "com.obric.aiagent.plugin");
            if (r10 == null) goto L26;
            ViewParent r0 = r10.getParent();
            if (ZeusTransformUtils.instanceOf(r0, ViewGroup.class) == false) goto L23;
            r3 = (ViewGroup) ZeusTransformUtils.preCheckCast(r0, ViewGroup.class, "com.obric.aiagent.plugin");
        L23:
            if (r3 == null) goto L26;
            r3.removeView(r10);
        L26:
            this.mirrorViews.remove(r6);
            createMirrorView(r6);
            View r11 = (View) ZeusTransformUtils.preCheckCast(this.mirrorViews.get(r6), View.class, "com.obric.aiagent.plugin");
            if (r11 == null) goto L30;
            animatePickUp(r6, r11);
        L30:
            startTrackingDragPosition(r6);
            this.callback.a(r6);
            return;
        L35:
            return;
        }

        @Override // com.obric.oui.orecyclerview.widget.ItemTouchHelper.a
        public void onChildDraw(Canvas r17, RecyclerView r18, RecyclerView.v r19, float r20, float r21, int r22, boolean r23) {
            d.h.b.o.e(r17, "c");
            d.h.b.o.e(r18, "recyclerView");
            d.h.b.o.e(r19, "viewHolder");
            if (r22 != 2) goto L41;
            float r1 = r19.f35660b.getTop() + r21;
            float r5 = r19.f35660b.getBottom() + r21;
            View r7 = null;
            if (r23 == false) goto L26;
            float r9 = dp2px(40);
            float r10 = r18.getPaddingTop();
            float r11 = r18.getPaddingBottom();
            float r12 = r18.getHeight();
            if (r1 >= r10) goto L13;
            float r13 = r10 - r9;
            Float r14 = this.lastTouchTop;
            if (r14 != null) goto L11;
            float r15 = r10;
        L12:
            float r2 = com.obric.common.oea.style.scene.a.a.f32479a.a(r10, r13, r15, r1);
            float r16 = r2 - r19.f35660b.getTop();
            this.lastTouchTop = Float.valueOf(r2);
        L14:
            float r110 = r12 - r11;
            if (r5 <= r110) goto L21;
            float r24 = r9 + r110;
            Float r3 = this.lastTouchBottom;
            if (r3 != null) goto L19;
            float r4 = r110;
        L20:
            float r6 = com.obric.common.oea.style.scene.a.a.f32479a.a(r110, r24, r4, r5);
            r16 = r6 - r19.f35660b.getBottom();
            this.lastTouchBottom = Float.valueOf(r6);
        L23:
            if (Math.abs(r21) <= 0.001f) goto L25;
            ((Map) ZeusTransformUtils.preCheckCast(this.recoverRatios, Map.class, "com.obric.aiagent.plugin")).put(r19, Float.valueOf(r16 / r21));
        L30:
            View r8 = (View) ZeusTransformUtils.preCheckCast(this.mirrorViews.get(r19), View.class, "com.obric.aiagent.plugin");
            if (r8 == null) goto L40;
            r18.getLocationOnScreen(this.cachedRvLoc);
            ViewParent r25 = r8.getParent();
            if (ZeusTransformUtils.instanceOf(r25, View.class) == false) goto L36;
            r7 = (View) ZeusTransformUtils.preCheckCast(r25, View.class, "com.obric.aiagent.plugin");
        L36:
            if (r7 == null) goto L39;
            r7.getLocationOnScreen(this.cachedRootLoc);
        L39:
            float r26 = (this.cachedRvLoc[0] + r19.f35660b.getLeft()) + r20;
            float r27 = (this.cachedRvLoc[1] + r19.f35660b.getTop()) + r16;
            r8.setX(r26 - this.cachedRootLoc[0]);
            r8.setY(r27 - this.cachedRootLoc[1]);
        L40:
            float r28 = r16;
        L42:
            super.onChildDraw(r17, r18, r19, r20, r28, r22, r23);
            return;
        L25:
            this.recoverRatios.remove(r19);
            goto L30
        L19:
            r4 = r3.floatValue();
            goto L20
        L21:
            this.lastTouchBottom = null;
            goto L23
        L11:
            r15 = r14.floatValue();
            goto L12
        L13:
            this.lastTouchTop = null;
            r16 = r21;
            goto L14
        L26:
            Float r29 = (Float) ZeusTransformUtils.preCheckCast(this.recoverRatios.get(r19), Float.class, "com.obric.aiagent.plugin");
            if (r29 != null) goto L29;
            r29 = Float.valueOf(1.0f);
        L29:
            r16 = ((Number) ZeusTransformUtils.preCheckCast(r29, Number.class, "com.obric.aiagent.plugin")).floatValue() * r21;
            goto L30
        L41:
            r28 = r21;
            goto L42
        }

        private final float dp2px(int r1) {
            return r1 * Resources.getSystem().getDisplayMetrics().density;
        }

        @Override // com.obric.oui.orecyclerview.widget.ItemTouchHelper.a
        public void clearView(RecyclerView r3, RecyclerView.v r4) {
            d.h.b.o.e(r3, "recyclerView");
            d.h.b.o.e(r4, "viewHolder");
            super.clearView(r3, r4);
            View r5 = (View) ZeusTransformUtils.preCheckCast(this.mirrorViews.get(r4), View.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L5;
            animateDrop(r4, r5);
        L6:
            this.callback.b(r4);
            this.recoverRatios.remove(r4);
            return;
        L5:
            r4.f35660b.setVisibility(0);
            goto L6
        }

        private final void animatePickUp(RecyclerView.v r18, View r19) {
            View r3 = r18.f35660b;
            d.h.b.o.c(r3, "viewHolder.itemView");
            r3.setScaleX(this.dragScale);
            r3.setScaleY(this.dragScale);
            r3.setVisibility(4);
            Float r13 = Float.valueOf(1.0f);
            r19.setAlpha(1.0f);
            r19.setScaleX(1.0f);
            r19.setScaleY(1.0f);
            ((Map) ZeusTransformUtils.preCheckCast(this.pickUpAnimators, Map.class, "com.obric.aiagent.plugin")).put(r18, com.obric.common.oea.foundation.animation.a.b.a(com.obric.common.oea.foundation.animation.a.b.a.a(com.obric.common.oea.foundation.animation.a.b.a.a(com.obric.common.oea.foundation.animation.a.c.a(r19, 0.0f, 1, null), com.obric.common.oea.foundation.animation.h.a.EnumC0885a.f32414c, r13, this.dragScale, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(com.obric.common.oea.foundation.animation.h.e.a.f32428a, com.obric.common.oea.foundation.animation.h.e.c.f32441d, 0, 4, null), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 16, null), com.obric.common.oea.foundation.animation.h.a.EnumC0885a.f32415d, r13, this.dragScale, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(com.obric.common.oea.foundation.animation.h.e.a.f32428a, com.obric.common.oea.foundation.animation.h.e.c.f32441d, 0, 4, null), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 16, null).a((d.h.a.m) ZeusTransformUtils.preCheckCast(new b(r19, this), d.h.a.m.class, "com.obric.aiagent.plugin")).b(), null, null, 3, null));
        }

        private final void animateDrop(RecyclerView.v r27, View r28) {
            View r3 = r27.f35660b;
            d.h.b.o.c(r3, "viewHolder.itemView");
            r3.setScaleX(this.dragScale);
            r3.setScaleY(this.dragScale);
            r3.setAlpha(1.0f);
            r3.setVisibility(0);
            r28.setAlpha(0.0f);
            r28.setScaleX(this.dragScale);
            r28.setScaleY(this.dragScale);
            ((Map) ZeusTransformUtils.preCheckCast(this.dropAnimators, Map.class, "com.obric.aiagent.plugin")).put(r27, com.obric.common.oea.foundation.animation.a.b.a(com.obric.common.oea.foundation.animation.a.b.a.a(com.obric.common.oea.foundation.animation.a.b.a.a(com.obric.common.oea.foundation.animation.a.c.a(r3, 0.0f, 1, null), com.obric.common.oea.foundation.animation.h.a.EnumC0885a.f32414c, Float.valueOf(this.dragScale), 1.0f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(com.obric.common.oea.foundation.animation.h.e.a.f32428a, com.obric.common.oea.foundation.animation.h.e.c.f32441d, 0, 4, null), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 16, null), com.obric.common.oea.foundation.animation.h.a.EnumC0885a.f32415d, Float.valueOf(this.dragScale), 1.0f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(com.obric.common.oea.foundation.animation.h.e.a.f32428a, com.obric.common.oea.foundation.animation.h.e.c.f32441d, 0, 4, null), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 16, null).a((d.h.a.m) ZeusTransformUtils.preCheckCast(new a(r3, r28, this, r27), d.h.a.m.class, "com.obric.aiagent.plugin")).b(), null, null, 3, null));
        }

        /* JADX WARN: Type inference failed for: r3v1, types: [com.obric.oui.orecyclerview.widget.ODragItemTouchHelper$CallbackImpl$createMirrorView$mirrorGroup$1, java.lang.Object] */
        private final void createMirrorView(RecyclerView.v r10) {
            final View r0 = r10.f35660b;
            d.h.b.o.c(r0, "viewHolder.itemView");
            final Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            ?? r3 = new ODragItemTouchHelper$CallbackImpl$createMirrorView$mirrorGroup$1(r0, r1);
            r3.setClipChildren(false);
            r3.setClipToPadding(false);
            ViewGroup r4 = (ViewGroup) ZeusTransformUtils.preCheckCast(r0.getRootView().findViewById(R.id.content), ViewGroup.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L8;
            View r5 = r0.getRootView();
            if (ZeusTransformUtils.instanceOf(r5, ViewGroup.class) == false) goto L7;
            r4 = (ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.aiagent.plugin");
            goto L8
        L7:
            r4 = null;
        L8:
            if (r4 == null) goto L12;
            r4.setClipChildren(false);
            r4.setClipToPadding(false);
            r4.addView((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"), new ViewGroup.LayoutParams(r0.getWidth(), r0.getHeight()));
            int[] r6 = new int[2];
            r0.getLocationOnScreen(r6);
            int[] r2 = new int[2];
            r4.getLocationOnScreen(r2);
            r3.setX(r6[0] - r2[0]);
            r3.setY(r6[1] - r2[1]);
            ((Map) ZeusTransformUtils.preCheckCast(this.mirrorViews, Map.class, "com.obric.aiagent.plugin")).put(r10, r3);
            return;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            RecyclerView.v r0 = this.currentDragViewHolder;
            if (r0 == null) goto L8;
            int r2 = getCurrentCoordinate(r0.f35660b)[1];
            int r3 = Math.abs(r2 - this.dragStartY);
            if (r2 != 0) goto L7;
            this.callback.b(r0, 0);
            goto L8
        L7:
            this.callback.b(r0, r3);
        L8:
            return true;
        }

        private final void startTrackingDragPosition(RecyclerView.v r3) {
            this.currentDragViewHolder = r3;
            this.dragStartY = getCurrentCoordinate(r3.f35660b)[1];
            r3.f35660b.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener) ZeusTransformUtils.preCheckCast(this, ViewTreeObserver.OnPreDrawListener.class, "com.obric.aiagent.plugin"));
        }

        private final void stopTrackingDragPosition(RecyclerView.v r3) {
            if (r3 == null) goto L11;
            View r4 = r3.f35660b;
            if (r4 == null) goto L11;
            ViewTreeObserver r5 = r4.getViewTreeObserver();
            if (r5 == null) goto L11;
            r5.removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener) ZeusTransformUtils.preCheckCast(this, ViewTreeObserver.OnPreDrawListener.class, "com.obric.aiagent.plugin"));
        L11:
            this.currentDragViewHolder = null;
        }

        private final int[] getCurrentCoordinate(View r2) {
            if (r2 == null) goto L6;
            r2.getLocationOnScreen(this.cachedViewLoc);
        L6:
            return this.cachedViewLoc;
        }

        private final RecyclerView.a<?> findAdapterForViewHolder(RecyclerView.v r5) {
            if (ZeusTransformUtils.instanceOf(this.adapter, g.class) == false) goto L16;
            int r6 = r5.k();
            if (r6 == (-1)) goto L13;
            int r0 = 0;
            Iterator<? extends RecyclerView.a<? extends RecyclerView.v>> r4 = ((g) ZeusTransformUtils.preCheckCast(this.adapter, g.class, "com.obric.aiagent.plugin")).b().iterator();
        L8:
            if (r4.hasNext() == false) goto L19;
            RecyclerView.a<?> r1 = (RecyclerView.a) ZeusTransformUtils.preCheckCast(r4.next(), RecyclerView.a.class, "com.obric.aiagent.plugin");
            if (r6 < (r1.a() + r0)) goto L11;
            r0 = r0 + r1.a();
            goto L8
        L11:
            return r1;
        L19:
            return null;
        L13:
            return null;
        L16:
            return this.adapter;
        }

        @Override // com.obric.oui.orecyclerview.widget.ItemTouchHelper.a
        public boolean onMove(RecyclerView r2, RecyclerView.v r3, RecyclerView.v r4) {
            d.h.b.o.e(r2, "recyclerView");
            d.h.b.o.e(r3, "viewHolder");
            d.h.b.o.e(r4, "target");
            if (d.h.b.o.a(findAdapterForViewHolder(r3), findAdapterForViewHolder(r4)) == true) goto L6;
            return false;
        L6:
            int r5 = r3.k();
            int r6 = r4.k();
            if (this.callback.a(r3, r5, r6) == false) goto L14;
            View r1 = (View) ZeusTransformUtils.preCheckCast(this.mirrorViews.get(r3), View.class, "com.obric.aiagent.plugin");
            if (r1 == null) goto L15;
            r1.invalidate();
            return true;
        L15:
            return true;
        L14:
            return true;
        }
    }

    /* JADX INFO: compiled from: ODragItemTouchHelper.kt */
    public interface a {
        void a(RecyclerView.v r1);

        boolean a(RecyclerView.v r1, int r2);

        boolean a(RecyclerView.v r1, int r2, int r3);

        void b(RecyclerView.v r1);

        void b(RecyclerView.v r1, int r2);
    }

    public ODragItemTouchHelper(RecyclerView.a<?> r3, a r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "adapter");
        d.h.b.o.e(r5, "callback");
        super((ItemTouchHelper.a) ZeusTransformUtils.preCheckCast(new CallbackImpl(r3, r5), ItemTouchHelper.a.class, "com.obric.aiagent.plugin"));
    }

    private final CallbackImpl d() {
        return (CallbackImpl) ZeusTransformUtils.preCheckCast(this.h, CallbackImpl.class, "com.obric.aiagent.plugin");
    }

    public final void a(boolean r1) {
        d().setLongPressDragEnabled(r1);
    }
}
