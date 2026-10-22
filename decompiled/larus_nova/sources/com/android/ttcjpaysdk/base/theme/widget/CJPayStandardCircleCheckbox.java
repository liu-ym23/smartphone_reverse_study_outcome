package com.android.ttcjpaysdk.base.theme.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.android.ttcjpaysdk.base.ktextension.CJPayColorHelper;
import com.android.ttcjpaysdk.base.theme.CJPayColorConstants;
import com.android.ttcjpaysdk.base.theme.CJPayThemeManager;
import com.android.ttcjpaysdk.base.theme.CJPayThemeUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\nH\u0016J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\nH\u0016J\b\u0010\u0019\u001a\u00020\u0011H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/android/ttcjpaysdk/base/theme/widget/CJPayStandardCircleCheckbox;", "Lcom/android/ttcjpaysdk/base/theme/widget/CJPayCheckBoxAdapter;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isChecked", "", "mBackgroundColor", "mCheckBox", "Landroid/widget/ImageView;", "mRootView", "Landroid/view/View;", "changeCheckStatus", "", "performClick", "setChecked", "checked", "setIESNewStyle", "isNewStyle", "setWithCircleWhenUnchecked", "with", "updateCircleBackground", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayStandardCircleCheckbox extends CJPayCheckBoxAdapter {
    private boolean isChecked;
    private int mBackgroundColor;
    private ImageView mCheckBox;
    private View mRootView;

    public CJPayStandardCircleCheckbox(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 6, null);
    }

    public CJPayStandardCircleCheckbox(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 4, null);
    }

    @Override // com.android.ttcjpaysdk.base.theme.widget.CJPayCheckBoxAdapter
    public void setIESNewStyle(boolean r100) {
    }

    @Override // com.android.ttcjpaysdk.base.theme.widget.CJPayCheckBoxAdapter
    public void setWithCircleWhenUnchecked(boolean r100) {
    }

    private final void updateCircleBackground() {
        if (this.isChecked == false) goto L10;
        ImageView r100 = this.mCheckBox;
        if (r100 == null) goto L7;
        r100.setImageResource(R.drawable.cj_pay_checked_no_noise);
    L7:
        View r101 = this.mRootView;
        if (r101 == null) goto L17;
        r101.setBackgroundColor(this.mBackgroundColor);
        return;
    L17:
        return;
    L10:
        ImageView r102 = this.mCheckBox;
        if (r102 == null) goto L13;
        r102.setImageDrawable(CJPayThemeUtils.getDrawable(getContext(), R.attr.cj_pay_icon_check_box_normal3));
    L13:
        View r103 = this.mRootView;
        if (r103 == null) goto L19;
        r103.setBackgroundColor(0);
        return;
    }

    @Override // com.android.ttcjpaysdk.base.theme.widget.CJPayCheckBoxAdapter
    public void changeCheckStatus() {
        setChecked(!this.isChecked);
    }

    @Override // android.view.View
    public boolean performClick() {
        changeCheckStatus();
        return super.performClick();
    }

    @Override // com.android.ttcjpaysdk.base.theme.widget.CJPayCheckBoxAdapter
    public boolean isChecked() {
        return this.isChecked;
    }

    @Override // com.android.ttcjpaysdk.base.theme.widget.CJPayCheckBoxAdapter
    public void setChecked(boolean r100) {
        if (this.isChecked != r100) goto L5;
        return;
    L5:
        this.isChecked = r100;
        updateCircleBackground();
    }

    public CJPayStandardCircleCheckbox(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.mBackgroundColor = CJPayColorHelper.safeParseColor$default(CJPayColorConstants.CJ_PAY_RED, 0, 2, null);
        CJPayThemeManager.ThemeInfo r103 = CJPayThemeManager.getInstance().getThemeInfo();     // Catch: Exception -> L19
        if (r103 == null) goto L8;
        CJPayThemeManager.CheckBoxInfo r104 = r103.checkBoxInfo;     // Catch: Exception -> L19
        if (r104 == null) goto L8;
        String r105 = r104.bgColor;     // Catch: Exception -> L19
    L9:
        if (r105 != null) goto L11;
    L14:
        boolean r106 = true;
    L15:
        if (r106 == true) goto L17;
        int r107 = Color.parseColor(r105);     // Catch: Exception -> L19
    L20:
        this.mBackgroundColor = r107;
        this.mRootView = LayoutInflater.from(r100).inflate(R.layout.cj_pay_standard_circle_checkbox_layout, this, true);
        View r108 = LayoutInflater.from(r100).inflate(R.layout.cj_pay_standard_circle_checkbox_layout, this, true);
        this.mRootView = r108;
        if (r108 == null) goto L24;
        r108.setClipToOutline(true);
    L24:
        View r109 = this.mRootView;
        if (r109 == null) goto L28;
        r109.setOutlineProvider(new AnonymousClass1());
    L28:
        this.mCheckBox = (ImageView) findViewById(R.id.cj_pay_custom_checkbox);
        this.isChecked = true;
        updateCircleBackground();
        return;
    L17:
        r107 = CJPayColorHelper.safeParseColor$default(CJPayColorConstants.CJ_PAY_RED, 0, 2, null);     // Catch: Exception -> L19
        goto L20
    L11:
        if (r105.length() == 0) goto L14;
        r106 = false;
    L8:
        r105 = null;
    L19:
        r107 = CJPayColorHelper.safeParseColor$default(CJPayColorConstants.CJ_PAY_RED, 0, 2, null);
        goto L20
    }

    public /* synthetic */ CJPayStandardCircleCheckbox(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}
