package com.bytedance.android.ui.ec.widget.searchbar;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import com.bytedance.android.ui.base.widget.round.RoundConstraintLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0012J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0012J\u000e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u000eJ\u0006\u0010\u001b\u001a\u00020\u0012J\u000e\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u001eJ\u000e\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0017J\u000e\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020'J\u0006\u0010(\u001a\u00020\u0012J\u0010\u0010)\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u000eH\u0002J\u0006\u0010*\u001a\u00020\u0012R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/searchbar/ECSearchBar;", "Lcom/bytedance/android/ui/base/widget/round/RoundConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defaultFocusChangeListener", "Landroid/view/View$OnFocusChangeListener;", "editText", "Landroidx/appcompat/widget/AppCompatEditText;", "ivClear", "Landroid/view/View;", "tvAction", "Landroid/widget/TextView;", "addTextChangedListener", "", "textWatcher", "Landroid/text/TextWatcher;", "clearEditFocus", "getText", "", "hideClear", "hideSoftInput", "view", "hideTextAction", "setActionText", "text", "", "setHint", "hint", "setOnEditorActionListener", "editorActionListener", "Landroid/widget/TextView$OnEditorActionListener;", "setText", "setTextActionClickListener", "onClickListener", "Landroid/view/View$OnClickListener;", "showClear", "showSoftInput", "showTextAction", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchBar extends RoundConstraintLayout {
    private final View.OnFocusChangeListener defaultFocusChangeListener;
    private final AppCompatEditText editText;
    private final View ivClear;
    private final TextView tvAction;

    public ECSearchBar(Context r100) {
        this(r100, null, 0, 6, null);
    }

    public ECSearchBar(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 4, null);
    }

    public final void clearEditFocus() {
        this.editText.clearFocus();
    }

    public final String getText() {
        return String.valueOf(this.editText.getText());
    }

    public final void hideClear() {
        this.ivClear.setVisibility(8);
    }

    public final void hideTextAction() {
        this.tvAction.setVisibility(8);
    }

    public final void showClear() {
        this.ivClear.setVisibility(0);
    }

    public final void showTextAction() {
        this.tvAction.setVisibility(0);
    }

    private final void showSoftInput(View r100) {
        Object r101 = getContext().getSystemService("input_method");
        if ((r101 instanceof InputMethodManager) == true) goto L5;
        r101 = null;
    L5:
        InputMethodManager r102 = (InputMethodManager) r101;
        if (r102 == null) goto L9;
        r102.showSoftInput(r100, 0);
        return;
    }

    public final void addTextChangedListener(TextWatcher r100) {
        Intrinsics.checkNotNullParameter(r100, "textWatcher");
        this.editText.addTextChangedListener(r100);
    }

    public final void hideSoftInput(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Object r101 = getContext().getSystemService("input_method");
        if ((r101 instanceof InputMethodManager) == true) goto L5;
        r101 = null;
    L5:
        InputMethodManager r102 = (InputMethodManager) r101;
        if (r102 == null) goto L9;
        r102.hideSoftInputFromWindow(r100.getWindowToken(), 0);
        return;
    }

    public final void setActionText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.tvAction.setText(r100);
    }

    public final void setHint(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "hint");
        this.editText.setHint(r100);
    }

    public final void setOnEditorActionListener(TextView.OnEditorActionListener r100) {
        Intrinsics.checkNotNullParameter(r100, "editorActionListener");
        this.editText.setOnEditorActionListener(r100);
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.editText.setText(r100);
    }

    public final void setTextActionClickListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "onClickListener");
        this.tvAction.setOnClickListener(r100);
    }

    public static final /* synthetic */ void access$showSoftInput(ECSearchBar r100, View r101) {
        r100.showSoftInput(r101);
    }

    public ECSearchBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View.OnFocusChangeListener r103 = new ECSearchBar$defaultFocusChangeListener$1(this);
        this.defaultFocusChangeListener = r103;
        LayoutInflater.from(r100).inflate(R.layout.ec_dux_search_bar_layout, this, true);
        AppCompatEditText r104 = (AppCompatEditText) findViewById(R.id.search_input);
        this.editText = r104;
        View r105 = findViewById(R.id.search_clear);
        this.ivClear = r105;
        this.tvAction = (TextView) findViewById(R.id.search_action);
        r104.setOnFocusChangeListener(r103);
        r105.setOnClickListener(new AnonymousClass1(this));
    }

    public /* synthetic */ ECSearchBar(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}
