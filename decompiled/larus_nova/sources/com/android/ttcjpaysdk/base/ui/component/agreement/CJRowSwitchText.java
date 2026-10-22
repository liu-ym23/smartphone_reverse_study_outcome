package com.android.ttcjpaysdk.base.ui.component.agreement;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.ui.Utils.CJPayViewTouchUtils;
import com.android.ttcjpaysdk.base.ui.component.CJSwitchView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\r\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0006\u0010\u001d\u001a\u00020\u001cJ\u0012\u0010\u001e\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u0004\u0018\u00010\u0017J\b\u0010\"\u001a\u00020\u001cH\u0002J\b\u0010#\u001a\u00020\u001cH\u0002J\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\nJ\u0010\u0010&\u001a\u00020\u001c2\b\b\u0001\u0010'\u001a\u00020\u0010J\u000e\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u0010J\u000e\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020,J\u000e\u0010-\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010.\u001a\u00020\u001c2\b\b\u0001\u0010'\u001a\u00020\u0010J\u000e\u0010/\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u0010J\u000e\u00100\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020,J\u000e\u00101\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\nJ\u0006\u00103\u001a\u00020\u001cR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/agreement/CJRowSwitchText;", "Landroid/widget/LinearLayout;", "mContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "getAttrs", "()Landroid/util/AttributeSet;", "isChecked", "", "leftContentTextView", "Landroid/widget/TextView;", "leftText", "", "leftTextSize", "", "listener", "Lcom/android/ttcjpaysdk/base/ui/component/agreement/OnSwitchChangeListener;", "getMContext", "()Landroid/content/Context;", "rightTipsTextView", "spacer", "Landroid/view/View;", "switch", "Lcom/android/ttcjpaysdk/base/ui/component/CJSwitchView;", "tipsText", "addView", "", "clearSwitchChangeListener", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "getTipsView", "initData", "initView", "setChecked", "checked", "setLeftContentColor", "color", "setLeftContentSize", "size", "setLeftContentText", "charSequence", "", "setOnSwitchChangeListener", "setTipsColor", "setTipsSize", "setTipsText", "setTipsTextVisible", "visible", "setViewCenter", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJRowSwitchText extends LinearLayout {
    private final AttributeSet attrs;
    private boolean isChecked;
    private TextView leftContentTextView;
    private String leftText;
    private int leftTextSize;
    private OnSwitchChangeListener listener;
    private final Context mContext;
    private TextView rightTipsTextView;
    private View spacer;

    /* JADX INFO: renamed from: switch, reason: not valid java name */
    private CJSwitchView f52switch;
    private String tipsText;

    public final void clearSwitchChangeListener() {
        this.listener = null;
        CJSwitchView r100 = this.f52switch;
        if (r100 == null) goto L6;
        r100.setOnCheckedChangeListener(new AnonymousClass1());
        return;
    }

    private final void initData() {
        if (this.attrs == null) goto L10;
        TypedArray r100 = getContext().obtainStyledAttributes(this.attrs, new int[]{R.attr.CJRowSwitchChecked, R.attr.CJRowSwitchContent, R.attr.CJRowSwitchContentSize, R.attr.CJRowSwitchTips});
        this.leftText = r100.getString(1);     // Catch: Throwable -> L7
        this.tipsText = r100.getString(3);     // Catch: Throwable -> L7
        this.isChecked = r100.getBoolean(0, false);     // Catch: Throwable -> L7
        this.leftTextSize = r100.getDimensionPixelSize(2, 0);     // Catch: Throwable -> L7
        r100.recycle();
        return;
    L7:
        th = move-exception;
        r100.recycle();
        throw th;
    }

    private final void initView() {
        String r100 = this.leftText;
        if (r100 != null) goto L5;
    L13:
        TextView r101 = this.leftContentTextView;
        if (r101 == null) goto L17;
        r101.setMovementMethod(LinkMovementMethod.getInstance());
    L17:
        TextView r102 = this.leftContentTextView;
        if (r102 == null) goto L21;
        r102.setHighlightColor(ContextCompat.getColor(getContext(), R.color.cj_pay_color_trans));
    L21:
        CJSwitchView r103 = this.f52switch;
        if (r103 == null) goto L24;
        r103.setIsChecked(this.isChecked);
        CJPayViewTouchUtils.INSTANCE.increaseTouchArea((View) r103.getParent(), r103, CJPayBasicExtensionKt.dp(6));
    L24:
        int r104 = this.leftTextSize;
        if (r104 <= 0) goto L33;
        TextView r105 = this.leftContentTextView;
        if (r105 == null) goto L29;
        r105.setTextSize(0, r104);
    L29:
        TextView r106 = this.rightTipsTextView;
        if (r106 == null) goto L34;
        r106.setTextSize(0, this.leftTextSize);
        return;
    L34:
        return;
    L33:
        return;
    L5:
        if ((!StringsKt.isBlank(r100)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L13;
        TextView r107 = this.leftContentTextView;
        if (r107 == null) goto L13;
        r107.setText(r100);
        goto L13
    }

    public final boolean isChecked() {
        CJSwitchView r100 = this.f52switch;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isChecked();
    }

    public final void setViewCenter() {
        View r100 = this.spacer;
        if (r100 == null) goto L7;
        r100.setVisibility(8);
        return;
    }

    private final void addView() {
        View r100 = LayoutInflater.from(getContext()).inflate(R.layout.cj_pay_component_row_agreement_layout, this, true);
        this.leftContentTextView = (TextView) r100.findViewById(R.id.cj_pay_component_row_agreement_text);
        this.rightTipsTextView = (TextView) r100.findViewById(R.id.cj_pay_component_row_tips_text);
        this.f52switch = (CJSwitchView) r100.findViewById(R.id.cj_pay_component_row_agreement_switch);
        this.spacer = r100.findViewById(R.id.cj_pay_component_row_agreement_spacer);
    }

    public final AttributeSet getAttrs() {
        return this.attrs;
    }

    public final Context getMContext() {
        return this.mContext;
    }

    public final View getTipsView() {
        return this.rightTipsTextView;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r100) {
        return super.dispatchTouchEvent(r100);
    }

    public final void setChecked(boolean r100) {
        CJSwitchView r101 = this.f52switch;
        if (r101 == null) goto L6;
        r101.setIsChecked(r100);
        return;
    }

    public final void setLeftContentColor(int r100) {
        TextView r101 = this.leftContentTextView;
        if (r101 == null) goto L6;
        r101.setTextColor(r100);
        return;
    }

    public final void setLeftContentSize(int r100) {
        TextView r101 = this.leftContentTextView;
        if (r101 == null) goto L6;
        r101.setTextSize(2, r100);
        return;
    }

    public final void setLeftContentText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "charSequence");
        TextView r101 = this.leftContentTextView;
        if (r101 == null) goto L7;
        r101.setText(r100);
        return;
    }

    public final void setOnSwitchChangeListener(final OnSwitchChangeListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.listener = r100;
        CJSwitchView r101 = this.f52switch;
        if (r101 == null) goto L6;
        r101.setOnCheckedChangeListener(new C88791(r100));
        return;
    }

    public final void setTipsColor(int r100) {
        TextView r101 = this.rightTipsTextView;
        if (r101 == null) goto L6;
        r101.setTextColor(r100);
        return;
    }

    public final void setTipsSize(int r100) {
        TextView r101 = this.rightTipsTextView;
        if (r101 == null) goto L6;
        r101.setTextSize(2, r100);
        return;
    }

    public final void setTipsText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "charSequence");
        TextView r101 = this.rightTipsTextView;
        if (r101 == null) goto L7;
        r101.setText(r100);
        return;
    }

    public final void setTipsTextVisible(boolean r100) {
        TextView r101 = this.rightTipsTextView;
        if (r101 == null) goto L10;
        if (r100 == false) goto L7;
        int r102 = 0;
    L8:
        r101.setVisibility(r102);
        return;
    L7:
        r102 = 4;
        goto L8
    }

    public CJRowSwitchText(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100, r101);
        this.mContext = r100;
        this.attrs = r101;
        initData();
        addView();
        initView();
    }

    public /* synthetic */ CJRowSwitchText(Context r100, AttributeSet r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}
