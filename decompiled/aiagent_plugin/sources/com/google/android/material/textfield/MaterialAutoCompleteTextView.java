package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.ListPopupWindow;
import com.google.android.material.internal.l;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialAutoCompleteTextView extends AppCompatAutoCompleteTextView {
    private static final int MAX_ITEMS_MEASURED = 15;
    private final AccessibilityManager accessibilityManager;
    private final ListPopupWindow modalListPopup;
    private final int simpleItemLayout;
    private final Rect tempRect;

    static /* synthetic */ ListPopupWindow access$000(MaterialAutoCompleteTextView r0) {
        return r0.modalListPopup;
    }

    static /* synthetic */ void access$100(MaterialAutoCompleteTextView r0, Object r1) {
        r0.updateText(r1);
    }

    public MaterialAutoCompleteTextView(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public MaterialAutoCompleteTextView(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.attr.autoCompleteTextViewStyle, "attr", "autoCompleteTextViewStyle"));
    }

    public MaterialAutoCompleteTextView(Context r9, AttributeSet r10, int r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.google.android.material.theme.a.a.a(r12, r3, r11, 0), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r3, r11);
        this.tempRect = new Rect();
        Context r13 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        TypedArray r14 = l.a(r13, r3, R.styleable.MaterialAutoCompleteTextView, r11, ZeusTransformUtils.mapRes(R.style.Widget_AppCompat_AutoCompleteTextView, "style", "Widget_AppCompat_AutoCompleteTextView"), new int[0]);
        if (r14.hasValue(ZeusTransformUtils.mapRes(R.styleable.MaterialAutoCompleteTextView_android_inputType, "styleable", "MaterialAutoCompleteTextView_android_inputType")) == true) goto L5;
    L7:
        this.simpleItemLayout = r14.getResourceId(ZeusTransformUtils.mapRes(R.styleable.MaterialAutoCompleteTextView_simpleItemLayout, "styleable", "MaterialAutoCompleteTextView_simpleItemLayout"), ZeusTransformUtils.mapRes(R.layout.mtrl_auto_complete_simple_item, "layout", "mtrl_auto_complete_simple_item"));
        this.accessibilityManager = (AccessibilityManager) ZeusTransformUtils.preCheckCast(r13.getSystemService("accessibility"), AccessibilityManager.class, "com.obric.aiagent.plugin");
        ListPopupWindow r0 = new ListPopupWindow(r13);
        this.modalListPopup = r0;
        r0.a(true);
        r0.b(this);
        r0.f(2);
        r0.setAdapter(getAdapter());
        r0.a(new AnonymousClass1(this));
        if (r14.hasValue(ZeusTransformUtils.mapRes(R.styleable.MaterialAutoCompleteTextView_simpleItems, "styleable", "MaterialAutoCompleteTextView_simpleItems")) == false) goto L10;
        setSimpleItems(r14.getResourceId(ZeusTransformUtils.mapRes(R.styleable.MaterialAutoCompleteTextView_simpleItems, "styleable", "MaterialAutoCompleteTextView_simpleItems"), 0));
    L10:
        r14.recycle();
        return;
    L5:
        if (r14.getInt(ZeusTransformUtils.mapRes(R.styleable.MaterialAutoCompleteTextView_android_inputType, "styleable", "MaterialAutoCompleteTextView_android_inputType"), 0) != 0) goto L7;
        setKeyListener(null);
        goto L7
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        AccessibilityManager r0 = this.accessibilityManager;
        if (r0 != null) goto L5;
    L7:
        super.showDropDown();
        return;
    L5:
        if (r0.isTouchExplorationEnabled() == false) goto L7;
        this.modalListPopup.show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T r3) {
        super.setAdapter((ListAdapter) ZeusTransformUtils.wrapperContextForParams(r3, ListAdapter.class, "com.obric.aiagent.plugin"));
        this.modalListPopup.setAdapter(getAdapter());
    }

    public void setSimpleItems(int r2) {
        setSimpleItems(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getStringArray(r2));
    }

    public void setSimpleItems(String[] r5) {
        setAdapter(new ArrayAdapter((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.simpleItemLayout, r5));
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout r0 = findTextInputLayoutAncestor();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isProvidingHint() == true) goto L7;
        return;
    L7:
        if (super.getHint() == null) goto L9;
        return;
    L9:
        if (com.google.android.material.internal.f.a() == false) goto L15;
        setHint("");
        return;
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout r0 = findTextInputLayoutAncestor();
        if (r0 == null) goto L9;
        if (r0.isProvidingHint() == false) goto L9;
        return r0.getHint();
    L9:
        return super.getHint();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r2, int r3) {
        super.onMeasure(r2, r3);
        if (View.MeasureSpec.getMode(r2) != Integer.MIN_VALUE) goto L6;
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), measureContentWidth()), View.MeasureSpec.getSize(r2)), getMeasuredHeight());
        return;
    }

    private int measureContentWidth() {
        ListAdapter r0 = getAdapter();
        TextInputLayout r1 = findTextInputLayoutAncestor();
        int r2 = 0;
        if (r0 == null) goto L20;
        if (r1 == null) goto L20;
        int r3 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int r4 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int r5 = Math.min(r0.getCount(), Math.max(0, this.modalListPopup.i()) + 15);
        int r8 = Math.max(0, r5 - 15);
        View r9 = null;
        int r6 = 0;
    L7:
        if (r8 >= r5) goto L15;
        int r10 = r0.getItemViewType(r8);
        if (r10 == r2) goto L11;
        r9 = null;
        r2 = r10;
    L11:
        r9 = r0.getView(r8, r9, r1);
        if (r9.getLayoutParams() != null) goto L14;
        r9.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    L14:
        r9.measure(r3, r4);
        r6 = Math.max(r6, r9.getMeasuredWidth());
        r8 = r8 + 1;
        goto L7
    L15:
        Drawable r7 = this.modalListPopup.getBackground();
        if (r7 == null) goto L19;
        r7.getPadding(this.tempRect);
        r6 = r6 + (this.tempRect.left + this.tempRect.right);
    L19:
        return r6 + r1.getEndIconView().getMeasuredWidth();
    L20:
        return 0;
    }

    private TextInputLayout findTextInputLayoutAncestor() {
        ViewParent r2 = getParent();
    L3:
        if (r2 == null) goto L9;
        if (ZeusTransformUtils.instanceOf(r2, TextInputLayout.class) == true) goto L7;
        r2 = r2.getParent();
        goto L3
    L7:
        return (TextInputLayout) ZeusTransformUtils.preCheckCast(r2, TextInputLayout.class, "com.obric.aiagent.plugin");
    L9:
        return null;
    }

    private <T extends ListAdapter & Filterable> void updateText(Object r3) {
        if (Build.VERSION.SDK_INT < 17) goto L5;
        setText(convertSelectionToString(r3), false);
        return;
    L5:
        ListAdapter r0 = getAdapter();
        setAdapter(null);
        setText(convertSelectionToString(r3));
        setAdapter(r0);
    }
}
