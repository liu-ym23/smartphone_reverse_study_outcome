package com.obric.oui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroupKt;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.common.oui.R$styleable;
import com.obric.oui.common.style.IOUIAlpha;
import com.obric.oui.utils.log.L;
import com.tmall.wireless.tangram.structure.card.FixCard;
import com.tmall.wireless.tangram.structure.card.SlideCard;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 B2\u00020\u0001:\u0001CB1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ3\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u000f¢\u0006\u0004\b!\u0010\"J\u0015\u0010#\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u0006¢\u0006\u0004\b#\u0010\u0014J\r\u0010$\u001a\u00020\u000f¢\u0006\u0004\b$\u0010\"J\r\u0010%\u001a\u00020\u0006¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001e\u001a\u00020\u0006¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u0017H\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u000fH\u0002¢\u0006\u0004\b,\u0010\"J\u000f\u0010-\u001a\u00020\u000fH\u0002¢\u0006\u0004\b-\u0010\"J\u000f\u0010.\u001a\u00020\u000fH\u0002¢\u0006\u0004\b.\u0010\"J\u0017\u00100\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\u001aH\u0002¢\u0006\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010\u0012\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u00107R\u0016\u0010;\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00107R\u0018\u0010>\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010A\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@¨\u0006D"}, d2 = {"Lcom/obric/oui/button/OButtonGroup;", "Lcom/obric/oui/button/OShadowFrame;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Landroid/widget/FrameLayout;", "contentView", "Landroid/content/res/TypedArray;", "typedArray", "", "c", "(Landroid/content/Context;Landroid/widget/FrameLayout;Landroid/util/AttributeSet;Landroid/content/res/TypedArray;)V", "minWidth", "setWidthMin", "(I)V", "Landroid/view/MotionEvent;", "event", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "Landroid/view/View;", "itemView", "Landroid/view/ViewGroup$MarginLayoutParams;", "layoutParams", SlideCard.KEY_INDEX, "l", "(Landroid/view/View;Landroid/view/ViewGroup$MarginLayoutParams;I)V", "q", "()V", "r", "p", "getItemCount", "()I", "o", "(I)Landroid/view/View;", "enabled", "setEnabled", "(Z)V", "n", "t", "s", "view", "m", "(Landroid/view/View;)V", "Landroid/view/ViewGroup;", "w", "Landroid/view/ViewGroup;", "itemContainer", FixCard.FixStyle.KEY_X, "I", "itemMargin", FixCard.FixStyle.KEY_Y, "z", PerfConsts.KEY_CURRENT_CAPACITY, "A", "Landroid/view/View;", "singleItemView", "B", "Z", "singleItemSuppressPressEffectApplied", "C", "a", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OButtonGroup extends OShadowFrame {
    public static final a C = null;
    public View A;
    public boolean B;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ViewGroup f12490w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f12491x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f12492y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f12493z;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        C = new a(null);
    }

    @JvmOverloads
    public OButtonGroup(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        int r13 = 0;
        this(r10, r11, r12, r13, 14, null);
    }

    @Override // com.obric.oui.button.OShadowFrame
    public void c(Context r10, FrameLayout r11, AttributeSet r12, TypedArray r13) {
        q.g(r10, "context");
        q.g(r11, "contentView");
        if (r13 != null) goto L5;
        return;
    L5:
        r11.removeAllViews();
        setChangeAlphaWhenPress(false);
        getContentView().setDuplicateParentStateEnabled(false);
        LinearLayout r14 = new LinearLayout(r10);
        r14.setOrientation(0);
        r14.setGravity(17);
        this.f12490w = r14;
        r11.addView(r14);
        setWidthMin(this.f12492y);
        getContentView().setWidthMin(this.f12492y);
        t();
        n();
        if (getEnableMaterial() == false) goto L9;
        d(r10, r13);
        return;
    }

    @Override // com.obric.oui.button.OShadowFrame, com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r10) {
        q.g(r10, "event");
        boolean r11 = false;
        if (getItemCount() != 1) goto L5;
        boolean r12 = true;
    L6:
        boolean r13 = super.dispatchTouchEvent(r10);
        if (r12 == false) goto L28;
        int r14 = r10.getActionMasked();
        if (r14 == 0) goto L27;
        if (r14 != 1) goto L12;
    L26:
        getContentView().setPressed(false);
        goto L28
    L12:
        if (r14 == 2) goto L17;
        if (r14 == 3) goto L26;
    L17:
        if (r10.getX() >= 0.0f) goto L19;
    L25:
        getContentView().setPressed(r11);
        goto L28
    L19:
        if (r10.getX() >= getWidth()) goto L25;
        if (r10.getY() < 0.0f) goto L25;
        if (r10.getY() >= getHeight()) goto L25;
        r11 = true;
        goto L25
    L27:
        getContentView().setPressed(true);
    L28:
        return r13;
    L5:
        r12 = false;
        goto L6
    }

    public final int getItemCount() {
        ViewGroup r10 = this.f12490w;
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.getChildCount();
    }

    public final void l(View r10, ViewGroup.MarginLayoutParams r11, int r12) {
        q.g(r10, "itemView");
        q.g(r11, "layoutParams");
        ViewGroup r13 = this.f12490w;
        if (r13 != null) goto L6;
        L.b("OButtonGroup", "itemContainer is null");
        return;
    L6:
        q.d(r13);
        int r14 = r13.getChildCount();
        int r15 = this.f12493z;
        if (r14 < r15) goto L10;
        L.j("OButtonGroup", q.p("itemContainer is full, capacity: ", Integer.valueOf(r15)));
        return;
    L10:
        if (r12 < 0) goto L13;
        ViewGroup r16 = this.f12490w;
        q.d(r16);
        if (r12 > r16.getChildCount()) goto L13;
    L14:
        ViewGroup r17 = this.f12490w;
        q.d(r17);
        if (r17.getChildCount() <= 0) goto L25;
        if (r12 <= 0) goto L18;
        r11.setMarginStart(this.f12491x);
    L26:
        ViewGroup r18 = this.f12490w;
        q.d(r18);
        r18.addView(r10, r12, r11);
        t();
        n();
        return;
    L18:
        r11.setMarginStart(0);
        ViewGroup r19 = this.f12490w;
        q.d(r19);
        View r20 = r19.getChildAt(0);
        ViewGroup.LayoutParams r21 = r20.getLayoutParams();
        if ((r21 instanceof ViewGroup.MarginLayoutParams) == false) goto L21;
        ViewGroup.MarginLayoutParams r22 = (ViewGroup.MarginLayoutParams) r21;
    L22:
        if (r22 == null) goto L26;
        r22.setMarginStart(this.f12491x);
        r20.setLayoutParams(r22);
        goto L26
    L21:
        r22 = null;
        goto L22
    L25:
        r11.setMarginStart(0);
    L13:
        ViewGroup r23 = this.f12490w;
        q.d(r23);
        r12 = r23.getChildCount();
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void m(View r10) {
        if ((r10 instanceof IOUIAlpha) == false) goto L5;
        IOUIAlpha r11 = (IOUIAlpha) r10;
    L6:
        if (r11 != null) goto L8;
        return;
    L8:
        r11.setChangeAlphaWhenPress(false);
        this.B = true;
        return;
    L5:
        r11 = null;
        goto L6
    }

    public final void n() {
        if (getItemCount() != 0) goto L5;
        setVisibility(8);
        return;
    L5:
        setVisibility(0);
    }

    public final View o(int r10) {
        ViewGroup r11 = this.f12490w;
        if (r11 != null) goto L6;
        return null;
    L6:
        return r11.getChildAt(r10);
    }

    public final void p() {
        ViewGroup r10 = this.f12490w;
        if (r10 != null) goto L6;
        L.b("OButtonGroup", "itemContainer is null");
        return;
    L6:
        q.d(r10);
        r10.removeAllViews();
        t();
        n();
    }

    public final void q() {
        ViewGroup r10 = this.f12490w;
        if (r10 != null) goto L6;
        L.b("OButtonGroup", "itemContainer is null");
        return;
    L6:
        q.d(r10);
        if (r10.getChildCount() != 0) goto L10;
        L.j("OButtonGroup", "itemContainer is empty");
        return;
    L10:
        ViewGroup r11 = this.f12490w;
        q.d(r11);
        r(r11.getChildCount() - 1);
    }

    public final void r(int r10) {
        ViewGroup r11 = this.f12490w;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r10 < 0) goto L22;
        q.d(r11);
        if (r10 >= r11.getChildCount()) goto L23;
        ViewGroup r12 = this.f12490w;
        q.d(r12);
        r12.removeViewAt(r10);
        if (r10 != 0) goto L20;
        ViewGroup r13 = this.f12490w;
        q.d(r13);
        if (r13.getChildCount() <= 0) goto L20;
        ViewGroup r14 = this.f12490w;
        q.d(r14);
        View r15 = r14.getChildAt(0);
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        if ((r16 instanceof ViewGroup.MarginLayoutParams) == false) goto L16;
        ViewGroup.MarginLayoutParams r17 = (ViewGroup.MarginLayoutParams) r16;
    L17:
        if (r17 == null) goto L20;
        r17.setMarginStart(0);
        r15.setLayoutParams(r17);
        goto L20
    L16:
        r17 = null;
    L20:
        t();
        n();
        return;
    L23:
        return;
    }

    public final void s() {
        KeyEvent.Callback r10 = this.A;
        if (r10 != null) goto L5;
    L13:
        this.A = null;
        this.B = false;
        return;
    L5:
        if (this.B == false) goto L13;
        if ((r10 instanceof IOUIAlpha) == false) goto L9;
        IOUIAlpha r11 = (IOUIAlpha) r10;
    L10:
        if (r11 == null) goto L13;
        r11.setChangeAlphaWhenPress(true);
        goto L13
    L9:
        r11 = null;
        goto L10
    }

    @Override // com.obric.oui.button.OShadowFrame, com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        ViewGroup r11 = this.f12490w;
        if (r11 == null) goto L9;
        r11.setEnabled(r10);
        Iterator r12 = ViewGroupKt.a(r11).iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        ((View) r12.next()).setEnabled(r10);
    L9:
        t();
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, com.obric.oui.common.style.IOUILayout
    public void setWidthMin(int r10) {
        getLayoutHelper().setWidthMin(r10);
    }

    public final void t() {
        ViewGroup r10 = this.f12490w;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.getChildCount() != 1) goto L11;
        View r11 = r10.getChildAt(0);
        if (this.A == r11) goto L10;
        s();
        this.A = r11;
    L10:
        q.f(r11, "only");
        m(r11);
        getContentView().setChangeAlphaWhenPress(isEnabled());
        return;
    L11:
        getContentView().setChangeAlphaWhenPress(false);
        s();
    }

    @JvmOverloads
    public OButtonGroup(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        int r13 = 0;
        this(r10, r11, r12, r13, 12, null);
    }

    @JvmOverloads
    public OButtonGroup(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        int r13 = 0;
        this(r10, r11, r12, r13, 8, null);
    }

    public /* synthetic */ OButtonGroup(Context r10, AttributeSet r11, int r12, int r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = 0;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = 0;
    L11:
        this(r10, r11, r12, r13);
    }

    public OButtonGroup(Context r10, AttributeSet r11, int r12, int r13) {
        q.g(r10, "context");
        int r14 = 0;
        super(r10, r11, r12, r14, 8, null);
        this.f12493z = 5;
        int[] r15 = R$styleable.OButtonGroup;
        q.f(r15, "OButtonGroup");
        TypedArray r16 = r10.obtainStyledAttributes(r11, r15, 0, 0);
        q.f(r16, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        this.f12492y = r16.getDimensionPixelSize(R$styleable.OButtonGroup_oui_widgetMinWidth, 0);
        this.f12491x = r16.getDimensionPixelSize(R$styleable.OButtonGroup_oui_widgetInnerItemMargin, 0);
        this.f12493z = r16.getDimensionPixelSize(R$styleable.OButtonGroup_oui_OButtonGroupCapacity, 5);
        r16.recycle();
    }
}
