package com.obric.oui.searchbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.apm.constant.CommonKey;
import com.bytedanceos.common.toolbox.ServerElements;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.button.OButton;
import com.obric.oui.forms.OInputView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.l;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u0012¢\u0006\u0004\b\u001e\u0010\u0015J\u0015\u0010!\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u0015\u0010%\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\u000f\u0010(\u001a\u0004\u0018\u00010'¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u0004\u0018\u00010'¢\u0006\u0004\b*\u0010)J\u001f\u0010-\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\bH\u0014¢\u0006\u0004\b-\u0010.J7\u00104\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\r2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\bH\u0014¢\u0006\u0004\b4\u00105R\u0017\u0010;\u001a\u0002068\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0014\u0010?\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010A\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010>R\u0014\u0010E\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010D¨\u0006F"}, d2 = {"Lcom/obric/oui/searchbar/OSearchBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "originContext", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", CommonKey.KEY_VALUE, "Landroid/text/TextUtils$TruncateAt;", "i", "(I)Landroid/text/TextUtils$TruncateAt;", "", "enabled", "", "setEnabled", "(Z)V", "", "text", "setText", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "where", "setEllipsize", "(Landroid/text/TextUtils$TruncateAt;)V", "getEllipsize", "()Landroid/text/TextUtils$TruncateAt;", "searchActionText", "setSearchActionText", "Landroid/view/View$OnClickListener;", ServerElements.ADS_CLICK, "setSearchAction", "(Landroid/view/View$OnClickListener;)V", "Landroid/view/View$OnFocusChangeListener;", "onFocusChangeListener", "setOnInputFocusChange", "(Landroid/view/View$OnFocusChangeListener;)V", "Landroid/view/View;", "getPrefixView", "()Landroid/view/View;", "getPostfixView", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "Lcom/obric/oui/forms/OInputView;", "a", "Lcom/obric/oui/forms/OInputView;", "getInputView", "()Lcom/obric/oui/forms/OInputView;", "inputView", "Landroid/widget/FrameLayout;", "b", "Landroid/widget/FrameLayout;", "leftContainer", "c", "rightContainer", "Lcom/obric/oui/button/OButton;", "d", "Lcom/obric/oui/button/OButton;", "searchAction", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OSearchBar extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OInputView f16516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f16517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f16518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OButton f16519d;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OSearchBar(@NotNull Context r10) {
        q.g(r10, "originContext");
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void g(OSearchBar r10, View.OnClickListener r11, View r12) {
        j(r10, r11, r12);
    }

    public static final /* synthetic */ void h(OSearchBar r10, FrameLayout r11) {
        r10.f16518c = r11;
    }

    private final TextUtils.TruncateAt i(int r10) {
        if (r10 == 1) goto L15;
        if (r10 == 2) goto L19;
        if (r10 == 3) goto L18;
        if (r10 == 4) goto L17;
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

    public static final void j(OSearchBar r10, View.OnClickListener r11, View r12) {
        q.g(r10, "this$0");
        q.g(r11, "$click");
        dd.a.b(r10.getContext(), 1);
        r11.onClick(r12);
    }

    @Nullable
    public final TextUtils.TruncateAt getEllipsize() {
        return this.f16516a.getEllipsize();
    }

    @NotNull
    public final OInputView getInputView() {
        return this.f16516a;
    }

    @Nullable
    public final View getPostfixView() {
        FrameLayout r10 = this.f16518c;
        if (r10 != null) goto L6;
        return null;
    L6:
        if (r10.getChildCount() > 0) goto L8;
        return null;
    L8:
        return r10.getChildAt(0);
    }

    @Nullable
    public final View getPrefixView() {
        if (this.f16517b.getChildCount() > 0) goto L7;
        return null;
    L7:
        return this.f16517b.getChildAt(0);
    }

    @NotNull
    public final String getText() {
        String r10 = this.f16516a.getText();
        if (r10 != null) goto L6;
        return "";
    L6:
        return r10;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }

    public final void setEllipsize(@Nullable TextUtils.TruncateAt r10) {
        this.f16516a.setEllipsize(r10);
    }

    @Override // android.view.View
    public void setEnabled(boolean r10) {
        this.f16516a.setEnabled(r10);
        super.setEnabled(r10);
    }

    public final void setOnInputFocusChange(@NotNull View.OnFocusChangeListener r10) {
        q.g(r10, "onFocusChangeListener");
        this.f16516a.setOnFocusChangeListener(r10);
    }

    public final void setSearchAction(@NotNull final View.OnClickListener r10) {
        q.g(r10, ServerElements.ADS_CLICK);
        this.f16519d.setOnClickListener(new a(this, r10));
    }

    public final void setSearchActionText(@NotNull String r10) {
        q.g(r10, "searchActionText");
        if (r10.length() != 0) goto L5;
        l.k(this.f16519d);
        return;
    L5:
        this.f16519d.setText(r10);
        l.m(this.f16519d);
    }

    public final void setText(@NotNull String r10) {
        q.g(r10, "text");
        this.f16516a.setText(r10);
    }

    public /* synthetic */ OSearchBar(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    @JvmOverloads
    public OSearchBar(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "originContext");
        super(r10, r11);
        ViewGroup.inflate(getContext(), R$layout.o_widget_search_bar, this);
        View r12 = findViewById(R$id.input_view);
        q.f(r12, "findViewById(R.id.input_view)");
        this.f16516a = (OInputView) r12;
        View r13 = findViewById(R$id.o_input_left_view_container);
        q.f(r13, "findViewById(R.id.o_input_left_view_container)");
        FrameLayout r14 = (FrameLayout) r13;
        this.f16517b = r14;
        View r15 = findViewById(R$id.search_action);
        q.f(r15, "findViewById(R.id.search_action)");
        this.f16519d = (OButton) r15;
        TypedArray r16 = getContext().getTheme().obtainStyledAttributes(r11, R$styleable.OSearchBar, 0, 0);
        getInputView().setHint(r16.getString(R$styleable.OSearchBar_android_hint));
        getInputView().setText(r16.getString(R$styleable.OSearchBar_android_text));
        int r17 = R$styleable.OSearchBar_android_ellipsize;
        if (r16.hasValue(r17) == false) goto L5;
        setEllipsize(i(r16.getInt(r17, 0)));
    L5:
        final int r18 = r16.getResourceId(R$styleable.OSearchBar_oui_search_postfixView, 0);
        if (r18 == 0) goto L8;
        getInputView().setActionView(new OSearchBar$1$1(this, r18));
    L8:
        if (r18 != 0) goto L12;
        int r19 = r16.getResourceId(R$styleable.OSearchBar_oui_search_prefixView, R$layout.o_widget_search_bar_prefix);
        if (r19 == 0) goto L12;
        ViewGroup.inflate(getContext(), r19, r14);
        l.m(r14);
    L12:
        String r20 = r16.getString(R$styleable.OSearchBar_oui_search_actionText);
        if (r20 != null) goto L15;
        r20 = "";
    L15:
        setSearchActionText(r20);
    }
}
