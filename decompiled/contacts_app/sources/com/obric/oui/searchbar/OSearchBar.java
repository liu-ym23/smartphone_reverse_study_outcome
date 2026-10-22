package com.obric.oui.searchbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.common.oui.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.forms.OInputView;
import com.obric.oui.haptic.VibratorSmt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OSearchBar.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u0006\u0010\u0015\u001a\u00020\u0016J0\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001cH\u0014J\u0018\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u001cH\u0014J\u0012\u0010#\u001a\u0004\u0018\u00010\u00112\u0006\u0010$\u001a\u00020\u001cH\u0002J\u0010\u0010%\u001a\u00020\u00182\b\u0010&\u001a\u0004\u0018\u00010\u0011J\u0010\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u001aH\u0016J\u000e\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020+J\u000e\u0010,\u001a\u00020\u00182\u0006\u0010-\u001a\u00020.J\u000e\u0010/\u001a\u00020\u00182\u0006\u00100\u001a\u00020\u0016J\u000e\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u00020\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/obric/oui/searchbar/OSearchBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "originContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "inputView", "Lcom/obric/oui/forms/OInputView;", "getInputView", "()Lcom/obric/oui/forms/OInputView;", "leftContainer", "Landroid/widget/FrameLayout;", "rightContainer", "searchAction", "Lcom/obric/oui/button/OButton;", "getEllipsize", "Landroid/text/TextUtils$TruncateAt;", "getPostfixView", "Landroid/view/View;", "getPrefixView", "getText", "", "onLayout", "", "changed", "", "left", "", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "parseEllipsize", "value", "setEllipsize", "where", "setEnabled", "enabled", "setOnInputFocusChange", "onFocusChangeListener", "Landroid/view/View$OnFocusChangeListener;", "setSearchAction", "click", "Landroid/view/View$OnClickListener;", "setSearchActionText", "searchActionText", "setText", "text", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OSearchBar extends ConstraintLayout {
    private final OInputView inputView;
    private final FrameLayout leftContainer;
    private FrameLayout rightContainer;
    private final OButton searchAction;

    public static /* synthetic */ void $r8$lambda$QwWqvxD7L570O7PgR1eeIz7Xeic(OSearchBar r0, View.OnClickListener r1, View r2) {
        m664setSearchAction$lambda1(r0, r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OSearchBar(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "originContext");
        this(r3, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ OSearchBar(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public static final /* synthetic */ void access$setRightContainer$p(OSearchBar r0, FrameLayout r1) {
        r0.rightContainer = r1;
    }

    public OSearchBar(Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r4, "originContext");
        super(r4, r5);
        ConstraintLayout.inflate(getContext(), R.layout.o_widget_search_bar, this);
        View r6 = findViewById(R.id.input_view);
        Intrinsics.checkNotNullExpressionValue(r6, "findViewById(R.id.input_view)");
        this.inputView = (OInputView) r6;
        View r7 = findViewById(R.id.o_input_left_view_container);
        Intrinsics.checkNotNullExpressionValue(r7, "findViewById(R.id.o_input_left_view_container)");
        FrameLayout r8 = (FrameLayout) r7;
        this.leftContainer = r8;
        View r0 = findViewById(R.id.search_action);
        Intrinsics.checkNotNullExpressionValue(r0, "findViewById(R.id.search_action)");
        this.searchAction = (OButton) r0;
        TypedArray r9 = getContext().getTheme().obtainStyledAttributes(r5, R.styleable.OSearchBar, 0, 0);
        getInputView().setHint(r9.getString(R.styleable.OSearchBar_android_hint));
        getInputView().setText(r9.getString(R.styleable.OSearchBar_android_text));
        if (r9.hasValue(R.styleable.OSearchBar_android_ellipsize) == false) goto L5;
        setEllipsize(parseEllipsize(r9.getInt(R.styleable.OSearchBar_android_ellipsize, 0)));
    L5:
        final int r1 = r9.getResourceId(R.styleable.OSearchBar_oui_search_postfixView, 0);
        if (r1 == 0) goto L8;
        getInputView().setActionView(new OSearchBar$1$1(this, r1));
    L8:
        if (r1 != 0) goto L12;
        int r2 = r9.getResourceId(R.styleable.OSearchBar_oui_search_prefixView, R.layout.o_widget_search_bar_prefix);
        if (r2 == 0) goto L12;
        ConstraintLayout.inflate(getContext(), r2, r8);
        ViewExtensionsKt.makeVisible(r8);
    L12:
        String r10 = r9.getString(R.styleable.OSearchBar_oui_search_actionText);
        if (r10 != null) goto L15;
        r10 = "";
    L15:
        setSearchActionText(r10);
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
        Intrinsics.checkNotNullParameter(r2, "text");
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

    public final void setSearchActionText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "searchActionText");
        String r3 = r2;
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        ViewExtensionsKt.makeGone(this.searchAction);
        return;
    L8:
        this.searchAction.setText(r3);
        ViewExtensionsKt.makeVisible(this.searchAction);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setSearchAction(final View.OnClickListener r3) {
        Intrinsics.checkNotNullParameter(r3, "click");
        this.searchAction.setOnClickListener(new OSearchBar$$ExternalSyntheticLambda0(this, r3));
    }

    /* JADX INFO: renamed from: setSearchAction$lambda-1, reason: not valid java name */
    private static final void m664setSearchAction$lambda1(OSearchBar r1, View.OnClickListener r2, View r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$click");
        VibratorSmt.vibrateEffectWithHapticPlayer(r1.getContext(), 1);
        r2.onClick(r3);
    }

    public final void setOnInputFocusChange(View.OnFocusChangeListener r2) {
        Intrinsics.checkNotNullParameter(r2, "onFocusChangeListener");
        this.inputView.setOnFocusChangeListener(r2);
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
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }
}
