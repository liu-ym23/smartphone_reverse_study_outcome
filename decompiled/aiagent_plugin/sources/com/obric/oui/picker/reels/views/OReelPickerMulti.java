package com.obric.oui.picker.reels.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.common.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import d.l.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: OReelPickerMulti.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OReelPickerMulti extends ConstraintLayout implements com.obric.oui.picker.reels.a {
    private final LinearLayout reelsContainer;
    private int reelsCount;
    private final List<WheelView> wheelViews;

    /* JADX INFO: compiled from: OReelPickerMulti.kt */
    public static final class a implements com.obric.oui.picker.reels.a.InterfaceC0969a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<com.obric.oui.picker.reels.a.b> f35946a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f35947b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f35948c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f35949d;

        public a() {
            this.f35946a = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
            this.f35947b = -1;
            this.f35948c = -1;
            this.f35949d = 16;
        }

        public final a a(int r1) {
            this.f35947b = r1;
            return this;
        }

        public final a b(int r1) {
            this.f35948c = r1;
            return this;
        }

        public com.obric.oui.picker.reels.a.InterfaceC0969a a(com.obric.oui.picker.reels.a.b r2) {
            o.e(r2, "reel");
            this.f35946a.add(r2);
            return (com.obric.oui.picker.reels.a.InterfaceC0969a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.picker.reels.a.InterfaceC0969a.class, "com.obric.aiagent.plugin");
        }

        public com.obric.oui.picker.reels.a a(Context r4, AttributeSet r5, int r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
            o.e(r7, "context");
            if (this.f35947b != (-1)) goto L6;
            this.f35947b = g.a(r7, 328);
        L6:
            if (this.f35948c != (-1)) goto L8;
            this.f35948c = g.a(r7, 240);
        L8:
            OReelPickerMulti r0 = new OReelPickerMulti(r7, r8, r6);
            r0.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(this.f35947b, this.f35948c), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
            a(r0, this.f35946a, this.f35948c - (g.a(r7, this.f35949d) * 2));
            return (com.obric.oui.picker.reels.a) ZeusTransformUtils.preCheckCast(r0, com.obric.oui.picker.reels.a.class, "com.obric.aiagent.plugin");
        }

        private final void a(OReelPickerMulti r4, List<com.obric.oui.picker.reels.a.b> r5, int r6) {
            List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            OReelPickerMulti.access$setReelsCount$p(r4, r3.size());
            OReelPickerMulti.access$getWheelViews$p(r4).clear();
            OReelPickerMulti.access$getReelsContainer$p(r4).removeAllViews();
            Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L4:
            if (r7.hasNext() == false) goto L6;
            com.obric.oui.picker.reels.a.b r1 = (com.obric.oui.picker.reels.a.b) ZeusTransformUtils.preCheckCast(r7.next(), com.obric.oui.picker.reels.a.b.class, "com.obric.aiagent.plugin");
            OReelPickerMulti.access$addWheelView(r4, r1.e(), r1.d(), r6);
            goto L4
        L6:
            int r8 = 0;
            Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L8:
            if (r9.hasNext() == false) goto L13;
            Object r10 = r9.next();
            int r2 = r8 + 1;
            if (r8 >= 0) goto L12;
            p.c();
        L12:
            r4.configure(r8, (com.obric.oui.picker.reels.a.b) ZeusTransformUtils.preCheckCast(r10, com.obric.oui.picker.reels.a.b.class, "com.obric.aiagent.plugin"));
            r8 = r2;
            goto L8
        }
    }

    /* JADX INFO: compiled from: OReelPickerMulti.kt */
    public static final class b implements com.obric.oui.picker.reels.views.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.oui.picker.reels.a.b f35950a;

        b(com.obric.oui.picker.reels.a.b r1) {
            this.f35950a = r1;
        }

        @Override // com.obric.oui.picker.reels.views.a
        public void a(int r1, int r2) {
            com.obric.oui.picker.reels.a.c r3 = this.f35950a.i();
            if (r3 == null) goto L7;
            r3.onReelChanged(this.f35950a.a(), r2);
            return;
        }

        @Override // com.obric.oui.picker.reels.views.a
        public void a(int r2) {
            com.obric.oui.picker.reels.a.c r0 = this.f35950a.i();
            if (r0 == null) goto L7;
            r0.onReelChanged(this.f35950a.a(), r2);
            return;
        }
    }

    public OReelPickerMulti(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OReelPickerMulti(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public /* synthetic */ OReelPickerMulti(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public static final /* synthetic */ WheelView access$addWheelView(OReelPickerMulti r0, Integer r1, float r2, int r3) {
        return r0.addWheelView(r1, r2, r3);
    }

    public static final /* synthetic */ LinearLayout access$getReelsContainer$p(OReelPickerMulti r0) {
        return r0.reelsContainer;
    }

    public static final /* synthetic */ List access$getWheelViews$p(OReelPickerMulti r0) {
        return r0.wheelViews;
    }

    public static final /* synthetic */ void access$setReelsCount$p(OReelPickerMulti r0, int r1) {
        r0.reelsCount = r1;
    }

    public OReelPickerMulti(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7, r5);
        LinearLayout r8 = new LinearLayout(r6);
        r8.setId(ConstraintLayout.generateViewId());
        r8.setOrientation(0);
        r8.setGravity(17);
        r8.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new ConstraintLayout.LayoutParams(-2, -2), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        this.reelsContainer = r8;
        this.wheelViews = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        addView((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r3) {
        if (getAlpha() >= 1.0f) goto L7;
        return true;
    L7:
        return super.dispatchTouchEvent(r3);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        View r3 = (View) ZeusTransformUtils.preCheckCast(this.reelsContainer, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams r1 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        ConstraintLayout.LayoutParams r2 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r2.startToStart = 0;
        r2.endToEnd = 0;
        r2.topToTop = 0;
        r2.bottomToBottom = 0;
        r3.setLayoutParams(r1);
    }

    private final WheelView addWheelView(Integer r9, float r10, int r11) {
        if (r9 == null) goto L5;
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(r9.intValue(), -1);
    L6:
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r2, "context");
        WheelView r12 = new WheelView(r2, null, 0, 6, null);
        r12.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        r12.setMinimumHeight(r11);
        r12.setCyclic(false);
        this.reelsContainer.addView((View) ZeusTransformUtils.preCheckCast(r12, View.class, "com.obric.aiagent.plugin"));
        this.wheelViews.add(r12);
        return r12;
    L5:
        r0 = new LinearLayout.LayoutParams(-2, -1);
        goto L6
    }

    private final void configure(WheelView r1, com.obric.oui.picker.reels.a.b r2, int r3, int r4) {
        r1.setItemCount(5);
        CharSequence r0 = r2.c();
        if (r0 == null) goto L6;
        r1.setTagText(r0);
    L6:
        Integer r5 = r2.g();
        if (r5 == null) goto L10;
        r1.setTagGap(Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).intValue()));
    L10:
        Integer r6 = r2.f();
        if (r6 == null) goto L14;
        r1.setMinimumWidth(((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).intValue());
    L14:
        r1.setOnWheelChangedListener((com.obric.oui.picker.reels.views.a) ZeusTransformUtils.preCheckCast(new b(r2), com.obric.oui.picker.reels.views.a.class, "com.obric.aiagent.plugin"));
        r1.setEntries(r2.b(), n.a(r2.h(), 0, n.c(r2.b().size() - 1, 0)));
    }

    @Override // com.obric.oui.picker.reels.a
    public View asView() {
        return (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.oui.picker.reels.a
    public WheelView getReelView(int r2) {
        return (WheelView) ZeusTransformUtils.preCheckCast(p.d(this.wheelViews, r2), WheelView.class, "com.obric.aiagent.plugin");
    }

    public void configure(int r3, com.obric.oui.picker.reels.a.b r4) {
        o.e(r4, "reel");
        WheelView r0 = getReelView(r3);
        if (r0 == null) goto L7;
        configure(r0, r4, r3, this.reelsCount - 1);
        return;
    }
}
