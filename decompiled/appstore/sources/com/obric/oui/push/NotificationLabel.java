package com.obric.oui.push;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.customview.widget.b;
import com.bytedance.apm.constant.CommonKey;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.d;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001PB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ'\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u0019\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0018H\u0014¢\u0006\u0004\b\u001d\u0010\u001cJ\u0019\u0010 \u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0004\b \u0010!R\u001a\u0010'\u001a\u00020\"8\u0006X\u0086D¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R.\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010(\u001a\u0004\u0018\u00010\u001e8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010!R$\u00103\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u0010:\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010>\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u00105\u001a\u0004\b<\u00107\"\u0004\b=\u00109R\u0018\u0010A\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010E\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\"\u0010I\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u00105\u001a\u0004\bG\u00107\"\u0004\bH\u00109R$\u0010O\u001a\u0012\u0012\u0004\u0012\u00020K0Jj\b\u0012\u0004\u0012\u00020K`L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010N¨\u0006Q"}, d2 = {"Lcom/obric/oui/push/NotificationLabel;", "Landroidx/cardview/widget/CardView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/view/View;", "child", FixCard.FixStyle.KEY_X, FixCard.FixStyle.KEY_Y, "", "c", "(Landroid/view/View;II)Z", "Landroid/view/MotionEvent;", "event", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "onTouchEvent", "Landroid/view/View$OnClickListener;", "l", "", "setOnClickListener", "(Landroid/view/View$OnClickListener;)V", "computeScroll", "()V", "onAttachedToWindow", "Landroid/view/ViewGroup;", "parent", "b", "(Landroid/view/ViewGroup;)V", "", "a", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", CommonKey.KEY_VALUE, "Landroid/view/ViewGroup;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "Landroidx/customview/widget/b;", "Landroidx/customview/widget/b;", "getViewDragHelper", "()Landroidx/customview/widget/b;", "setViewDragHelper", "(Landroidx/customview/widget/b;)V", "viewDragHelper", "d", "Z", "getDismissSettling", "()Z", "setDismissSettling", "(Z)V", "dismissSettling", "e", "getOpenSettling", "setOpenSettling", "openSettling", "f", "Landroid/view/View$OnClickListener;", "mOnClickListener", "Landroidx/customview/widget/b$c;", "g", "Landroidx/customview/widget/b$c;", "dragCallback", "h", "getInterceptingEvents", "setInterceptingEvents", "interceptingEvents", "Ljava/util/ArrayList;", "Lcom/obric/oui/push/NotificationLabel$GestureListener;", "Lkotlin/collections/ArrayList;", "i", "Ljava/util/ArrayList;", "dragDismissListeners", "GestureListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NotificationLabel extends CardView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f16496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f16497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f16498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f16499e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View.OnClickListener f16500f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b.c f16501g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f16502h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList f16503i;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/push/NotificationLabel$GestureListener;", "", "onDragDismiss", "", "onDragOpen", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface GestureListener {
        void onDragDismiss();

        void onDragOpen();
    }

    public static final class a extends b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f16504a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f16505b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f16506c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f16507d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f16508e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ NotificationLabel f16509f;

        public a(NotificationLabel r10) {
            this.f16509f = r10;
            this.f16504a = -1;
            this.f16505b = -1;
        }

        public final float a(Pair r10, Pair r11) {
            double r12 = 2.0f;
            return (float) Math.sqrt(((float) Math.pow(((Number) r10.getSecond()).intValue() - ((Number) r11.getSecond()).intValue(), r12)) + ((float) Math.pow(((Number) r10.getFirst()).intValue() - ((Number) r11.getFirst()).intValue(), r12)));
        }

        @Override // androidx.customview.widget.b.c
        public int clampViewPositionHorizontal(View r10, int r11, int r12) {
            q.g(r10, "child");
            return r10.getLeft();
        }

        @Override // androidx.customview.widget.b.c
        public int clampViewPositionVertical(View r10, int r11, int r12) {
            q.g(r10, "child");
            float r13 = r10.getTop();
            float r14 = r12;
            if (r12 >= 0) goto L5;
            float r15 = 2.0f;
        L7:
            return (int) (r13 + (r14 / r15));
        L5:
            r15 = 10.0f;
            goto L7
        }

        @Override // androidx.customview.widget.b.c
        public void onViewCaptured(View r10, int r11) {
            q.g(r10, "capturedChild");
            this.f16505b = r11;
            this.f16507d = r10.getTop();
            this.f16506c = r10.getLeft();
            this.f16508e = System.currentTimeMillis();
        }

        @Override // androidx.customview.widget.b.c
        public void onViewReleased(View r10, float r11, float r12) {
            q.g(r10, "child");
            long r13 = System.currentTimeMillis() - this.f16508e;
            float r14 = a(d.a(Integer.valueOf(this.f16507d), Integer.valueOf(this.f16506c)), d.a(Integer.valueOf(r10.getTop()), Integer.valueOf(r10.getLeft())));
            b r15 = this.f16509f.getViewDragHelper();
            if (r15 != null) goto L5;
            Integer r16 = null;
        L6:
            if (r16 != null) goto L8;
            int r17 = f.r(this.f16509f, 15);
        L10:
            if (r14 < r17) goto L12;
        L17:
            this.f16505b = this.f16504a;
            int r18 = r10.getHeight();
            if (shouldDismiss(r10, r12) == false) goto L21;
            Log.i(this.f16509f.getTAG(), "should dismiss");
            Triple r19 = new Triple(Integer.valueOf(-r18), Boolean.TRUE, Boolean.FALSE);
        L24:
            int r20 = ((Number) r19.component1()).intValue();
            boolean r21 = ((Boolean) r19.component2()).booleanValue();
            boolean r22 = ((Boolean) r19.component3()).booleanValue();
            this.f16509f.setDismissSettling(r21);
            this.f16509f.setOpenSettling(r22);
            b r23 = this.f16509f.getViewDragHelper();
            if (r23 != null) goto L28;
        L30:
            this.f16509f.setOpenSettling(false);
            this.f16509f.setDismissSettling(false);
        L31:
            this.f16509f.invalidate();
            return;
        L28:
            if (r23.O(this.f16506c, r20) != true) goto L30;
        L21:
            if (r10.getTop() > this.f16507d) goto L23;
            Log.i(this.f16509f.getTAG(), "should move to origin position");
            Integer r24 = Integer.valueOf(this.f16507d);
            Boolean r25 = Boolean.FALSE;
            r19 = new Triple(r24, r25, r25);
            goto L24
        L23:
            Log.i(this.f16509f.getTAG(), "should do something");
            r19 = new Triple(Integer.valueOf(this.f16507d), Boolean.FALSE, Boolean.TRUE);
            goto L24
        L12:
            if (r13 >= 300) goto L17;
            View.OnClickListener r26 = NotificationLabel.a(this.f16509f);
            if (r26 == null) goto L17;
            r26.onClick(this.f16509f);
            goto L17
        L8:
            r17 = r16.intValue();
            goto L10
        L5:
            r16 = Integer.valueOf(r15.B());
            goto L6
        }

        public final boolean shouldDismiss(View r10, float r11) {
            if (r11 <= 0.0f) goto L6;
            return false;
        L6:
            if (r11 < 0.0f) goto L8;
            int r12 = r10.getTop() - this.f16507d;
            if (r12 <= 0) goto L14;
            return false;
        L14:
            int r13 = f.r(this.f16509f, 30);
            if (Math.abs(r12) >= r13) goto L17;
            return false;
        L17:
            return true;
        L8:
            if (r11 < (-50.0f)) goto L10;
            return false;
        L10:
            return true;
        }

        @Override // androidx.customview.widget.b.c
        public boolean tryCaptureView(View r10, int r11) {
            q.g(r10, "child");
            int r12 = this.f16505b;
            if (r12 == this.f16504a) goto L7;
            if (r11 == r12) goto L7;
            return false;
        L7:
            return true;
        }
    }

    @JvmOverloads
    public NotificationLabel(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static final /* synthetic */ View.OnClickListener a(NotificationLabel r10) {
        return r10.f16500f;
    }

    public final void b(ViewGroup r10) {
        if (this.f16497c != null) goto L7;
        if (r10 == null) goto L8;
        this.f16497c = b.o(r10, 1.0f, this.f16501g);
        return;
    L8:
        return;
    }

    public final boolean c(View r10, int r11, int r12) {
        q.g(r10, "child");
        Rect r13 = new Rect();
        androidx.coordinatorlayout.widget.b.a(this.f16496b, r10, r13);
        return r13.contains(r11, r12);
    }

    @Override // android.view.View
    public void computeScroll() {
        b r10 = this.f16497c;
        if (r10 == null) goto L19;
        q.d(r10);
        if (r10.n(true) == false) goto L7;
        Log.d(this.f16495a, "scrolling");
        invalidate();
        return;
    L7:
        Log.d(this.f16495a, "settled");
        if (this.f16498d == false) goto L14;
        this.f16498d = false;
        Log.i(this.f16495a, "onDrag dismiss");
        Iterator r11 = this.f16503i.iterator();
    L11:
        if (r11.hasNext() == false) goto L24;
        ((GestureListener) r11.next()).onDragDismiss();
        goto L11
    L24:
        return;
    L14:
        if (this.f16499e == false) goto L23;
        this.f16499e = false;
        Log.i(this.f16495a, "onDrag open");
        Iterator r12 = this.f16503i.iterator();
    L17:
        if (r12.hasNext() == false) goto L25;
        ((GestureListener) r12.next()).onDragOpen();
        goto L17
    L25:
        return;
    L23:
        return;
    }

    public final boolean getDismissSettling() {
        return this.f16498d;
    }

    public final boolean getInterceptingEvents() {
        return this.f16502h;
    }

    public final boolean getOpenSettling() {
        return this.f16499e;
    }

    @Override // android.view.View, android.view.ViewParent
    @Nullable
    public final ViewGroup getParent() {
        return this.f16496b;
    }

    @NotNull
    public final String getTAG() {
        return this.f16495a;
    }

    @Nullable
    public final b getViewDragHelper() {
        return this.f16497c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        q.g(r10, "event");
        boolean r11 = this.f16502h;
        int r12 = r10.getActionMasked();
        if (r12 != 0) goto L5;
        r11 = c(this, (int) r10.getX(), (int) r10.getY());
        this.f16502h = r11;
        Log.i(this.f16495a, q.p("intercept: ", Boolean.valueOf(r11)));
    L11:
        if (r11 == false) goto L14;
        b(this.f16496b);
        b r13 = this.f16497c;
        q.d(r13);
        return r13.P(r10);
    L14:
        return false;
    L5:
        if (r12 != 1) goto L7;
    L9:
        this.f16502h = false;
        goto L11
    L7:
        if (r12 == 3) goto L9;
        goto L9
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        q.g(r10, "event");
        b r11 = this.f16497c;
        if (r11 == null) goto L9;
        if (r11 == null) goto L11;
        r11.processTouchEvent(r10);
        return true;
    L11:
        return true;
    L9:
        return false;
    }

    public final void setDismissSettling(boolean r10) {
        this.f16498d = r10;
    }

    public final void setInterceptingEvents(boolean r10) {
        this.f16502h = r10;
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener r10) {
        this.f16500f = r10;
    }

    public final void setOpenSettling(boolean r10) {
        this.f16499e = r10;
    }

    public final void setParent(@Nullable ViewGroup r10) {
        this.f16496b = r10;
        b(r10);
    }

    public final void setViewDragHelper(@Nullable b r10) {
        this.f16497c = r10;
    }

    @JvmOverloads
    public NotificationLabel(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ NotificationLabel(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public NotificationLabel(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f16495a = "NotificationLabel";
        this.f16501g = new a(this);
        this.f16503i = new ArrayList();
    }
}
