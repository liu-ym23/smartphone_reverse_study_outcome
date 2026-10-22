package com.obric.oui.stepper;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.apm.constant.CommonKey;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.button.OButton;
import com.obric.oui.layout.OUIConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.text.n;
import kotlin.text.o;
import kotlinx.coroutines.channels.Channel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 K2\u00020\u0001:\u0002'LB\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\nJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0010J\u0015\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0015\u0010\u0013J\r\u0010\u0016\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0010J\u0015\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0017\u0010\u0013J\u0015\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0018\u0010\u0013J\u000f\u0010\u0019\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\nJ\u001f\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ7\u0010$\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000eH\u0014¢\u0006\u0004\b$\u0010%R$\u0010-\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00103\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00100R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010=\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010:R$\u0010A\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b>\u0010?\"\u0004\b@\u0010\u0013R$\u0010D\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\bB\u0010?\"\u0004\bC\u0010\u0013R$\u0010G\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\bE\u0010?\"\u0004\bF\u0010\u0013R$\u0010J\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\bH\u0010?\"\u0004\bI\u0010\u0013¨\u0006M"}, d2 = {"Lcom/obric/oui/stepper/OSteppers;", "Lcom/obric/oui/layout/OUIConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "p", "()V", "u", "n", "o", "", "getValue", "()I", CommonKey.KEY_VALUE, "setValue", "(I)V", "getMinValue", "setMinValue", "getMaxValue", "setMaxValue", "setStepValue", "clearFocus", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "Lcom/obric/oui/stepper/OSteppers$OnValueChangeListener;", "a", "Lcom/obric/oui/stepper/OSteppers$OnValueChangeListener;", "getOnValueChangeListener", "()Lcom/obric/oui/stepper/OSteppers$OnValueChangeListener;", "setOnValueChangeListener", "(Lcom/obric/oui/stepper/OSteppers$OnValueChangeListener;)V", "onValueChangeListener", "Lcom/obric/oui/button/OButton;", "b", "Lcom/obric/oui/button/OButton;", "tvAdd", "c", "tvDec", "Landroid/widget/EditText;", "d", "Landroid/widget/EditText;", "etCounter", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "addContainerView", "f", "decContainerView", "g", "I", "setMValue", "mValue", "h", "setMMinValue", "mMinValue", "i", "setMMaxValue", "mMaxValue", "j", "setMStepValue", "mStepValue", "k", "OnValueChangeListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSteppers extends OUIConstraintLayout {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f17010k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OnValueChangeListener f17011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OButton f17012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OButton f17013c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final EditText f17014d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewGroup f17015e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ViewGroup f17016f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f17017g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f17018h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f17019i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f17020j;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\f"}, d2 = {"Lcom/obric/oui/stepper/OSteppers$OnValueChangeListener;", "", "onInputBeyondLimit", "", "input", "", "onTryToExceedMaximum", "onTryToExceedMinimum", "onValueChange", "oldValue", "newValue", "onValueEmpty", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnValueChangeListener {
        void onInputBeyondLimit(int r10);

        void onTryToExceedMaximum();

        void onTryToExceedMinimum();

        void onValueChange(int r10, int r11);

        void onValueEmpty();
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public static final class b implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OSteppers f17021a;

        public b(OSteppers r10) {
            this.f17021a = r10;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r10) {
            if (r10 != null) goto L4;
            String r11 = null;
        L5:
            if (r11 != null) goto L7;
        L8:
            OnValueChangeListener r12 = this.f17021a.getOnValueChangeListener();
            if (r12 == null) goto L12;
            r12.onValueEmpty();
        L12:
            int r13 = 0;
            if (r10 != null) goto L27;
        L22:
            OSteppers.m(this.f17021a, r13);     // Catch: Exception -> L24
        L25:
            OSteppers.l(this.f17021a);
            return;
        L24:
            tc.d.c(tc.d.f24779a, "OSteppers", "input type error", null, 4, null);
            goto L25
        L27:
            String r14 = r10.toString();     // Catch: Exception -> L24
            if (r14 == null) goto L22;
            Integer r15 = n.g(r14);     // Catch: Exception -> L24
            if (r15 == null) goto L22;
            r13 = r15.intValue();     // Catch: Exception -> L24
            goto L22
        L7:
            if (o.r(r11) == false) goto L12;
        L4:
            r11 = r10.toString();
            goto L5
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r10, int r11, int r12, int r13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r10, int r11, int r12, int r13) {
        }
    }

    static {
        f17010k = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OSteppers(@NotNull Context r10) {
        q.g(r10, "context");
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void g(OSteppers r10, View r11) {
        q(r10, r11);
    }

    public static /* synthetic */ void h(OSteppers r10, View r11) {
        s(r10, r11);
    }

    public static /* synthetic */ void i(OSteppers r10, int r11) {
        v(r10, r11);
    }

    public static /* synthetic */ void j(OSteppers r10, View r11) {
        t(r10, r11);
    }

    public static /* synthetic */ void k(OSteppers r10, View r11) {
        r(r10, r11);
    }

    public static final /* synthetic */ void l(OSteppers r10) {
        r10.n();
    }

    public static final /* synthetic */ void m(OSteppers r10, int r11) {
        r10.setMValue(r11);
    }

    public static final void q(OSteppers r10, View r11) {
        q.g(r10, "this$0");
        int r12 = r10.f17017g + r10.f17020j;
        if (r12 >= r10.f17018h) goto L5;
        return;
    L5:
        if (r12 > r10.f17019i) goto L10;
        r10.setMValue(r12);
        r10.f17014d.clearFocus();
        dd.a.b(r10.getContext(), 3);
        return;
    }

    public static final void r(OSteppers r10, View r11) {
        q.g(r10, "this$0");
        int r12 = r10.f17017g - r10.f17020j;
        if (r12 >= r10.f17018h) goto L5;
        return;
    L5:
        if (r12 > r10.f17019i) goto L10;
        r10.setMValue(r12);
        r10.f17014d.clearFocus();
        dd.a.b(r10.getContext(), 3);
        return;
    }

    public static final void s(OSteppers r10, View r11) {
        q.g(r10, "this$0");
        OnValueChangeListener r12 = r10.f17011a;
        if (r12 == null) goto L7;
        r12.onTryToExceedMaximum();
        return;
    }

    private final void setMMaxValue(int r10) {
        this.f17019i = r10;
        u();
        o();
    }

    private final void setMMinValue(int r10) {
        this.f17018h = r10;
        u();
        o();
    }

    private final void setMStepValue(int r10) {
        this.f17020j = r10;
        o();
    }

    private final void setMValue(int r10) {
        if (this.f17017g != r10) goto L5;
        return;
    L5:
        this.f17017g = r10;
        OnValueChangeListener r11 = this.f17011a;
        if (r11 == null) goto L9;
        r11.onValueChange(r10, r10);
    L9:
        o();
    }

    public static final void t(OSteppers r10, View r11) {
        q.g(r10, "this$0");
        OnValueChangeListener r12 = r10.f17011a;
        if (r12 == null) goto L7;
        r12.onTryToExceedMinimum();
        return;
    }

    public static final void v(OSteppers r10, int r11) {
        q.g(r10, "this$0");
        OnValueChangeListener r12 = r10.f17011a;
        if (r12 == null) goto L7;
        r12.onInputBeyondLimit(r11);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        super.clearFocus();
        this.f17014d.clearFocus();
    }

    public final int getMaxValue() {
        return this.f17019i;
    }

    public final int getMinValue() {
        return this.f17018h;
    }

    @Nullable
    public final OnValueChangeListener getOnValueChangeListener() {
        return this.f17011a;
    }

    public final int getValue() {
        return this.f17017g;
    }

    public final void n() {
        OButton r10 = this.f17012b;
        boolean r11 = false;
        if (getValue() >= this.f17019i) goto L5;
        boolean r12 = true;
    L6:
        r10.setEnabled(r12);
        OButton r13 = this.f17012b;
        if (getValue() >= this.f17019i) goto L9;
        boolean r14 = true;
    L10:
        r13.setClickable(r14);
        OButton r15 = this.f17013c;
        if (getValue() <= this.f17018h) goto L13;
        boolean r16 = true;
    L14:
        r15.setEnabled(r16);
        OButton r17 = this.f17013c;
        if (getValue() <= this.f17018h) goto L17;
        r11 = true;
    L17:
        r17.setClickable(r11);
        return;
    L13:
        r16 = false;
        goto L14
    L9:
        r14 = false;
        goto L10
    L5:
        r12 = false;
        goto L6
    }

    public final void o() {
        this.f17014d.setText(String.valueOf(this.f17017g), TextView.BufferType.EDITABLE);
        n();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // com.obric.oui.layout.OUIConstraintLayout, androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }

    public final void p() {
        this.f17012b.setOnClickListener(new com.obric.oui.stepper.b(this));
        this.f17013c.setOnClickListener(new c(this));
        this.f17015e.setOnClickListener(new d(this));
        this.f17016f.setOnClickListener(new e(this));
        this.f17014d.addTextChangedListener(new b(this));
    }

    public final void setMaxValue(int r10) {
        setMMaxValue(r10);
        setMValue(Math.min(r10, this.f17017g));
    }

    public final void setMinValue(int r10) {
        setMMinValue(r10);
        setMValue(Math.max(r10, this.f17017g));
    }

    public final void setOnValueChangeListener(@Nullable OnValueChangeListener r10) {
        this.f17011a = r10;
    }

    public final void setStepValue(int r10) {
        if (this.f17020j <= 0) goto L7;
        setMStepValue(r10);
        return;
    L7:
        throw new IllegalArgumentException("step value should be a positive integer");
    }

    public final void setValue(int r10) {
        if (r10 < this.f17018h) goto L9;
        if (r10 > this.f17019i) goto L9;
        setMValue(r10);
        return;
    L9:
        throw new IllegalArgumentException(r10 + " is not in [" + this.f17018h + ", " + this.f17019i + "].");
    }

    public final void u() {
        this.f17014d.setFilters(new InputFilterMinMax[]{new InputFilterMinMax(this.f17018h, this.f17019i, new com.obric.oui.stepper.a(this))});
    }

    public /* synthetic */ OSteppers(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    @JvmOverloads
    public OSteppers(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11, 0, null, 12, null);
        this.f17019i = 100;
        this.f17020j = 1;
        setFocusable(true);
        setFocusableInTouchMode(true);
        setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        LayoutInflater.from(r10).inflate(R$layout.o_widget_steppers, this);
        View r12 = findViewById(R$id.tv_add);
        q.f(r12, "findViewById(R.id.tv_add)");
        this.f17012b = (OButton) r12;
        View r13 = findViewById(R$id.tv_dec);
        q.f(r13, "findViewById(R.id.tv_dec)");
        this.f17013c = (OButton) r13;
        View r14 = findViewById(R$id.et_counter);
        q.f(r14, "findViewById(R.id.et_counter)");
        this.f17014d = (EditText) r14;
        View r15 = findViewById(R$id.increase_container);
        q.f(r15, "findViewById(R.id.increase_container)");
        this.f17015e = (ViewGroup) r15;
        View r16 = findViewById(R$id.decrease_container);
        q.f(r16, "findViewById(R.id.decrease_container)");
        this.f17016f = (ViewGroup) r16;
        TypedArray r17 = r10.obtainStyledAttributes(r11, R$styleable.OSteppers, 0, 0);
        setMValue(r17.getInt(R$styleable.OSteppers_oui_stepper_value, 0));
        setMMinValue(r17.getInt(R$styleable.OSteppers_oui_min_value, Integer.MIN_VALUE));
        setMMaxValue(r17.getInt(R$styleable.OSteppers_oui_max_value, Channel.UNLIMITED));
        setMStepValue(r17.getInt(R$styleable.OSteppers_oui_step, 1));
        r17.recycle();
        int r18 = f.r(this, 4);
        setPadding(r18, r18, r18, r18);
        setRadius(r10.getResources().getDimensionPixelSize(R$dimen.oui_r_m2_rect));
        setBackgroundResource(R$color.oui_fill_sunken_variable);
        p();
        o();
    }
}
