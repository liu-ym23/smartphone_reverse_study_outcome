package com.obric.oui.push;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.customview.widget.c;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.oui.common.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.m;
import d.r;
import d.s;
import java.util.ArrayList;
import java.util.Iterator;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: NotificationLabel.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class NotificationLabel extends CardView {
    private final String TAG;
    private boolean dismissSettling;
    private final c.a dragCallback;
    private final ArrayList<a> dragDismissListeners;
    private boolean interceptingEvents;
    private View.OnClickListener mOnClickListener;
    private boolean openSettling;
    private ViewGroup parent;
    private c viewDragHelper;

    /* JADX INFO: compiled from: NotificationLabel.kt */
    public interface a {
        void a();

        void b();
    }

    /* JADX INFO: compiled from: NotificationLabel.kt */
    public static final class b extends c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ NotificationLabel f36117a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f36118b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f36119c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f36120d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f36121e;
        private long f;

        b(NotificationLabel r1) {
            this.f36117a = r1;
            this.f36118b = -1;
            this.f36119c = -1;
        }

        @Override // androidx.customview.widget.c.a
        public boolean b(View r2, int r3) {
            o.e(r2, "child");
            int r4 = this.f36119c;
            if (r4 == this.f36118b) goto L7;
            if (r3 == r4) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // androidx.customview.widget.c.a
        public void a(View r2, int r3) {
            o.e(r2, "capturedChild");
            this.f36119c = r3;
            this.f36121e = r2.getTop();
            this.f36120d = r2.getLeft();
            this.f = System.currentTimeMillis();
        }

        @Override // androidx.customview.widget.c.a
        public int b(View r1, int r2, int r3) {
            o.e(r1, "child");
            float r0 = r1.getTop();
            float r4 = r3;
            if (r3 >= 0) goto L5;
            float r5 = 2.0f;
        L7:
            return (int) (r0 + (r4 / r5));
        L5:
            r5 = 10.0f;
            goto L7
        }

        @Override // androidx.customview.widget.c.a
        public int a(View r1, int r2, int r3) {
            o.e(r1, "child");
            return r1.getLeft();
        }

        @Override // androidx.customview.widget.c.a
        public void a(View r7, float r8, float r9) {
            o.e(r7, "child");
            long r0 = System.currentTimeMillis() - this.f;
            float r10 = a(s.a(Integer.valueOf(this.f36121e), Integer.valueOf(this.f36120d)), s.a(Integer.valueOf(r7.getTop()), Integer.valueOf(r7.getLeft())));
            c r2 = this.f36117a.getViewDragHelper();
            if (r2 != null) goto L5;
            Integer r3 = null;
        L7:
            if (r3 != null) goto L9;
            int r4 = g.a((View) ZeusTransformUtils.preCheckCast(this.f36117a, View.class, "com.obric.aiagent.plugin"), 15);
        L11:
            if (r10 < r4) goto L13;
        L18:
            this.f36119c = this.f36118b;
            int r11 = r7.getHeight();
            boolean r1 = true;
            if (a(r7, r9) == false) goto L22;
            a(this.f36117a.getTAG(), "should dismiss");
            r r12 = new r(Integer.valueOf(-r11), true, false);
        L25:
            int r13 = ((Number) ZeusTransformUtils.preCheckCast(r12.d(), Number.class, "com.obric.aiagent.plugin")).intValue();
            boolean r14 = ((Boolean) ZeusTransformUtils.preCheckCast(r12.e(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
            boolean r15 = ((Boolean) ZeusTransformUtils.preCheckCast(r12.f(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
            this.f36117a.setDismissSettling(r14);
            this.f36117a.setOpenSettling(r15);
            c r16 = this.f36117a.getViewDragHelper();
            if (r16 != null) goto L29;
        L27:
            r1 = false;
        L30:
            if (r1 == true) goto L32;
            this.f36117a.setOpenSettling(false);
            this.f36117a.setDismissSettling(false);
        L32:
            this.f36117a.invalidate();
            return;
        L29:
            if (r16.a(this.f36120d, r13) != true) goto L27;
        L22:
            if (r7.getTop() > this.f36121e) goto L24;
            a(this.f36117a.getTAG(), "should move to origin position");
            r12 = new r(Integer.valueOf(this.f36121e), false, false);
            goto L25
        L24:
            a(this.f36117a.getTAG(), "should do something");
            r12 = new r(Integer.valueOf(this.f36121e), false, true);
            goto L25
        L13:
            if (r0 >= 300) goto L18;
            View.OnClickListener r17 = NotificationLabel.access$getMOnClickListener$p(this.f36117a);
            if (r17 == null) goto L18;
            r17.onClick((View) ZeusTransformUtils.preCheckCast(this.f36117a, View.class, "com.obric.aiagent.plugin"));
            goto L18
        L9:
            r4 = r3.intValue();
            goto L11
        L5:
            r3 = Integer.valueOf(r2.f());
            goto L7
        }

        private final boolean a(View r4, float r5) {
            if (r5 <= 0.0f) goto L6;
            return false;
        L6:
            if (r5 < 0.0f) goto L8;
            int r6 = r4.getTop() - this.f36121e;
            if (r6 <= 0) goto L14;
            return false;
        L14:
            int r3 = g.a((View) ZeusTransformUtils.preCheckCast(this.f36117a, View.class, "com.obric.aiagent.plugin"), 30);
            if (Math.abs(r6) >= r3) goto L17;
            return false;
        L17:
            return true;
        L8:
            if (r5 < (-50.0f)) goto L10;
            return false;
        L10:
            return true;
        }

        private final float a(m<Integer, Integer> r7, m<Integer, Integer> r8) {
            double r4 = 2.0f;
            return (float) Math.sqrt(((float) Math.pow(((Number) ZeusTransformUtils.preCheckCast(r7.b(), Number.class, "com.obric.aiagent.plugin")).intValue() - ((Number) ZeusTransformUtils.preCheckCast(r8.b(), Number.class, "com.obric.aiagent.plugin")).intValue(), r4)) + ((float) Math.pow(((Number) ZeusTransformUtils.preCheckCast(r7.a(), Number.class, "com.obric.aiagent.plugin")).intValue() - ((Number) ZeusTransformUtils.preCheckCast(r8.a(), Number.class, "com.obric.aiagent.plugin")).intValue(), r4)));
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.i(r1, r2);
        }
    }

    public NotificationLabel(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public NotificationLabel(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.i(r0, r1);
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.d(r0, r1);
    }

    public /* synthetic */ NotificationLabel(Context r2, AttributeSet r3, int r4, int r5, h r6) {
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

    public static final /* synthetic */ View.OnClickListener access$getMOnClickListener$p(NotificationLabel r0) {
        return r0.mOnClickListener;
    }

    public NotificationLabel(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7, r5);
        this.TAG = "NotificationLabel";
        this.dragCallback = (c.a) ZeusTransformUtils.preCheckCast(new b(this), c.a.class, "com.obric.aiagent.plugin");
        this.dragDismissListeners = new ArrayList();
    }

    public final String getTAG() {
        return this.TAG;
    }

    @Override // android.view.View, android.view.ViewParent
    public final ViewGroup getParent() {
        return this.parent;
    }

    public final void setParent(ViewGroup r1) {
        this.parent = r1;
        ensureViewDragHelper(r1);
    }

    public final c getViewDragHelper() {
        return this.viewDragHelper;
    }

    public final void setViewDragHelper(c r1) {
        this.viewDragHelper = r1;
    }

    public final boolean getDismissSettling() {
        return this.dismissSettling;
    }

    public final void setDismissSettling(boolean r1) {
        this.dismissSettling = r1;
    }

    public final boolean getOpenSettling() {
        return this.openSettling;
    }

    public final void setOpenSettling(boolean r1) {
        this.openSettling = r1;
    }

    private final void ensureViewDragHelper(ViewGroup r3) {
        if (this.viewDragHelper != null) goto L7;
        if (r3 == null) goto L8;
        this.viewDragHelper = c.a(r3, 1.0f, this.dragCallback);
        return;
    L8:
        return;
    }

    public final boolean getInterceptingEvents() {
        return this.interceptingEvents;
    }

    public final void setInterceptingEvents(boolean r1) {
        this.interceptingEvents = r1;
    }

    public final boolean isPointInChildBounds(View r2, int r3, int r4) {
        o.e(r2, "child");
        Rect r0 = new Rect();
        androidx.coordinatorlayout.widget.b.b(this.parent, r2, r0);
        return r0.contains(r3, r4);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r6) {
        o.e(r6, "event");
        boolean r0 = this.interceptingEvents;
        int r1 = r6.getActionMasked();
        if (r1 != 0) goto L5;
        r0 = isPointInChildBounds((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), (int) r6.getX(), (int) r6.getY());
        this.interceptingEvents = r0;
        INVOKESTATIC_com_obric_oui_push_NotificationLabel_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(this.TAG, o.a("intercept: ", Boolean.valueOf(r0)));
    L11:
        if (r0 == false) goto L14;
        ensureViewDragHelper(this.parent);
        c r5 = this.viewDragHelper;
        o.a(r5);
        return r5.a(r6);
    L14:
        return false;
    L5:
        if (r1 != 1) goto L7;
    L9:
        this.interceptingEvents = false;
        goto L11
    L7:
        if (r1 == 3) goto L9;
        goto L9
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r2) {
        o.e(r2, "event");
        c r1 = this.viewDragHelper;
        if (r1 == null) goto L9;
        if (r1 == null) goto L11;
        r1.b(r2);
        return true;
    L11:
        return true;
    L9:
        return false;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r3) {
        this.mOnClickListener = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.aiagent.plugin");
    }

    public final void addOnDragDismissListener(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        o.e(r4, "dragDismissListener");
        this.dragDismissListeners.add(r4);
    }

    public final void removeOnDragDismissListener(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        o.e(r4, "dragDismissListener");
        this.dragDismissListeners.remove(r4);
    }

    public final void removeAllListeners$OUI_standardRelease() {
        this.dragDismissListeners.clear();
    }

    @Override // android.view.View
    public void computeScroll() {
        c r0 = this.viewDragHelper;
        if (r0 == null) goto L19;
        o.a(r0);
        if (r0.a(true) == false) goto L7;
        INVOKESTATIC_com_obric_oui_push_NotificationLabel_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(this.TAG, "scrolling");
        invalidate();
        return;
    L7:
        INVOKESTATIC_com_obric_oui_push_NotificationLabel_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(this.TAG, "settled");
        if (this.dismissSettling == false) goto L14;
        this.dismissSettling = false;
        INVOKESTATIC_com_obric_oui_push_NotificationLabel_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(this.TAG, "onDrag dismiss");
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.dragDismissListeners, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L11:
        if (r3.hasNext() == false) goto L24;
        ((a) ZeusTransformUtils.preCheckCast(r3.next(), a.class, "com.obric.aiagent.plugin")).a();
        goto L11
    L24:
        return;
    L14:
        if (this.openSettling == false) goto L23;
        this.openSettling = false;
        INVOKESTATIC_com_obric_oui_push_NotificationLabel_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(this.TAG, "onDrag open");
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(this.dragDismissListeners, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L17:
        if (r4.hasNext() == false) goto L25;
        ((a) ZeusTransformUtils.preCheckCast(r4.next(), a.class, "com.obric.aiagent.plugin")).b();
        goto L17
    L25:
        return;
    L23:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_push_NotificationLabel_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_push_NotificationLabel_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }
}
