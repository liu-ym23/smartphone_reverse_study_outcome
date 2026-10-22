package com.obric.oui.searchbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.k;
import com.obric.oui.forms.OInputView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.b;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;
import d.x;

/* JADX INFO: compiled from: OSearchBar.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OSearchBar extends ConstraintLayout {
    private final OInputView inputView;
    private final FrameLayout leftContainer;
    private FrameLayout rightContainer;
    private final OButton searchAction;

    /* JADX INFO: compiled from: OSearchBar.kt */
    static final class a extends p implements b<FrameLayout, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSearchBar f36131a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f36132b;

        a(OSearchBar r1, int r2) {
            this.f36131a = r1;
            this.f36132b = r2;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(FrameLayout r3) {
            a((FrameLayout) ZeusTransformUtils.preCheckCast(r3, FrameLayout.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(FrameLayout r4) {
            o.e(r4, "it");
            OSearchBar.access$setRightContainer$p(this.f36131a, r4);
            ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f36131a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), this.f36132b, (ViewGroup) ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OSearchBar(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "originContext");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void lambda$QwWqvxD7L570O7PgR1eeIz7Xeic(OSearchBar r0, View.OnClickListener r1, View r2) {
        m1150setSearchAction$lambda1(r0, r1, r2);
    }

    public /* synthetic */ OSearchBar(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public static final /* synthetic */ void access$setRightContainer$p(OSearchBar r0, FrameLayout r1) {
        r0.rightContainer = r1;
    }

    public OSearchBar(Context r8, AttributeSet r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r10, "originContext");
        super(r10, r11);
        ConstraintLayout.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.layout.o_widget_search_bar, "layout", "o_widget_search_bar"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"));
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.input_view, DbHelper.COL_ID, "input_view"));
        o.c(r12, "findViewById(R.id.input_view)");
        this.inputView = (OInputView) ZeusTransformUtils.preCheckCast(r12, OInputView.class, "com.obric.aiagent.plugin");
        View r13 = findViewById(ZeusTransformUtils.mapRes(R.id.o_input_left_view_container, DbHelper.COL_ID, "o_input_left_view_container"));
        o.c(r13, "findViewById(R.id.o_input_left_view_container)");
        FrameLayout r14 = (FrameLayout) ZeusTransformUtils.preCheckCast(r13, FrameLayout.class, "com.obric.aiagent.plugin");
        this.leftContainer = r14;
        View r0 = findViewById(ZeusTransformUtils.mapRes(R.id.search_action, DbHelper.COL_ID, "search_action"));
        o.c(r0, "findViewById(R.id.search_action)");
        this.searchAction = (OButton) ZeusTransformUtils.preCheckCast(r0, OButton.class, "com.obric.aiagent.plugin");
        TypedArray r15 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getTheme().obtainStyledAttributes(r11, R.styleable.OSearchBar, 0, 0);
        getInputView().setHint(r15.getString(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_android_hint, "styleable", "OSearchBar_android_hint")));
        getInputView().setText(r15.getString(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_android_text, "styleable", "OSearchBar_android_text")));
        if (r15.hasValue(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_android_ellipsize, "styleable", "OSearchBar_android_ellipsize")) == false) goto L5;
        setEllipsize(parseEllipsize(r15.getInt(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_android_ellipsize, "styleable", "OSearchBar_android_ellipsize"), 0)));
    L5:
        int r1 = r15.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_oui_search_postfixView, "styleable", "OSearchBar_oui_search_postfixView"), 0);
        if (r1 == 0) goto L8;
        getInputView().setActionView((b) ZeusTransformUtils.preCheckCast(new a(this, r1), b.class, "com.obric.aiagent.plugin"));
    L8:
        if (r1 != 0) goto L12;
        int r2 = r15.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_oui_search_prefixView, "styleable", "OSearchBar_oui_search_prefixView"), ZeusTransformUtils.mapRes(R.layout.o_widget_search_bar_prefix, "layout", "o_widget_search_bar_prefix"));
        if (r2 == 0) goto L12;
        ConstraintLayout.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r2, (ViewGroup) ZeusTransformUtils.preCheckCast(r14, ViewGroup.class, "com.obric.aiagent.plugin"));
        k.a((View) ZeusTransformUtils.preCheckCast(r14, View.class, "com.obric.aiagent.plugin"));
    L12:
        String r16 = r15.getString(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_oui_search_actionText, "styleable", "OSearchBar_oui_search_actionText"));
        if (r16 != null) goto L15;
        r16 = "";
    L15:
        setSearchActionText(r16);
    }

    public final OInputView getInputView() {
        return this.inputView;
    }

    @Override // android.view.View
    public void setEnabled(boolean r2) {
        this.inputView.setEnabled(r2);
        super.setEnabled(r2);
    }

    public final void setText(String r2) {
        o.e(r2, "text");
        this.inputView.setText(r2);
    }

    public final String getText() {
        String r0 = this.inputView.getText();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public final void setEllipsize(TextUtils.TruncateAt r1) {
        this.inputView.setEllipsize(r1);
    }

    public final TextUtils.TruncateAt getEllipsize() {
        return this.inputView.getEllipsize();
    }

    public final void setSearchActionText(String r4) {
        o.e(r4, "searchActionText");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        k.b((View) ZeusTransformUtils.preCheckCast(this.searchAction, View.class, "com.obric.aiagent.plugin"));
        return;
    L8:
        this.searchAction.setText((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"));
        k.a((View) ZeusTransformUtils.preCheckCast(this.searchAction, View.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setSearchAction(View.OnClickListener r3) {
        final View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.aiagent.plugin");
        o.e(r4, "click");
        this.searchAction.setOnClickListener(new $$Lambda$OSearchBar$QwWqvxD7L570O7PgR1eeIz7Xeic(this, r4));
    }

    /* JADX INFO: renamed from: setSearchAction$lambda-1, reason: not valid java name */
    private static final void m1150setSearchAction$lambda1(OSearchBar r2, View.OnClickListener r3, View r4) {
        View.OnClickListener r5 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.aiagent.plugin");
        o.e(r2, "this$0");
        o.e(r5, "$click");
        com.obric.oui.b.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), 1);
        r5.onClick(r4);
    }

    public final void setOnInputFocusChange(View.OnFocusChangeListener r3) {
        View.OnFocusChangeListener r4 = (View.OnFocusChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnFocusChangeListener.class, "com.obric.aiagent.plugin");
        o.e(r4, "onFocusChangeListener");
        this.inputView.setOnFocusChangeListener(r4);
    }

    public final View getPrefixView() {
        if (this.leftContainer.getChildCount() > 0) goto L7;
        return null;
    L7:
        return this.leftContainer.getChildAt(0);
    }

    public final View getPostfixView() {
        FrameLayout r2 = this.rightContainer;
        if (r2 != null) goto L6;
        return null;
    L6:
        if (r2.getChildCount() > 0) goto L8;
        return null;
    L8:
        return r2.getChildAt(0);
    }

    private final TextUtils.TruncateAt parseEllipsize(int r1) {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L19;
        if (r1 == 3) goto L18;
        if (r1 == 4) goto L17;
        return null;
    L17:
        return TextUtils.TruncateAt.MARQUEE;
    L18:
        return TextUtils.TruncateAt.END;
    L19:
        return TextUtils.TruncateAt.MIDDLE;
    L15:
        return TextUtils.TruncateAt.START;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }
}
