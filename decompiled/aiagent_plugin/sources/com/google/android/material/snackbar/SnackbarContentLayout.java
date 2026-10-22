package com.google.android.material.snackbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class SnackbarContentLayout extends LinearLayout implements a {
    private Button actionView;
    private int maxInlineActionWidth;
    private TextView messageView;

    public SnackbarContentLayout(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public SnackbarContentLayout(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.messageView = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.snackbar_text, DbHelper.COL_ID, "snackbar_text")), TextView.class, "com.obric.aiagent.plugin");
        this.actionView = (Button) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.snackbar_action, DbHelper.COL_ID, "snackbar_action")), Button.class, "com.obric.aiagent.plugin");
    }

    public TextView getMessageView() {
        return this.messageView;
    }

    public Button getActionView() {
        return this.actionView;
    }

    void updateActionTextColorAlphaIfNeeded(float r5) {
        if (r5 == 1.0f) goto L6;
        int r0 = this.actionView.getCurrentTextColor();
        int r6 = com.google.android.material.color.b.a(com.google.android.material.color.b.a(this, ZeusTransformUtils.mapRes(R.attr.colorSurface, "attr", "colorSurface")), r0, r5);
        this.actionView.setTextColor(r6);
        return;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r8, int r9) {
        super.onMeasure(r8, r9);
        boolean r1 = true;
        if (getOrientation() != 1) goto L5;
        return;
    L5:
        int r2 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.design_snackbar_padding_vertical_2lines, "dimen", "design_snackbar_padding_vertical_2lines"));
        int r0 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.design_snackbar_padding_vertical, "dimen", "design_snackbar_padding_vertical"));
        if (this.messageView.getLayout().getLineCount() <= 1) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == true) goto L11;
    L17:
        if (r3 == true) goto L21;
        r2 = r0;
    L21:
        if (updateViewsWithinLayout(0, r2, r2) == true) goto L24;
    L23:
        r1 = false;
    L24:
        if (r1 == false) goto L27;
        super.onMeasure(r8, r9);
        return;
    L27:
        return;
    L11:
        if (this.maxInlineActionWidth <= 0) goto L17;
        if (this.actionView.getMeasuredWidth() <= this.maxInlineActionWidth) goto L17;
        if (updateViewsWithinLayout(1, r2, r2 - r0) == false) goto L23;
    L8:
        r3 = false;
        goto L9
    }

    private boolean updateViewsWithinLayout(int r3, int r4, int r5) {
        if (r3 == getOrientation()) goto L5;
        setOrientation(r3);
        boolean r6 = true;
    L7:
        if (this.messageView.getPaddingTop() == r4) goto L9;
    L12:
        updateTopBottomPadding(this.messageView, r4, r5);
        return true;
    L9:
        if (this.messageView.getPaddingBottom() != r5) goto L12;
        return r6;
    L5:
        r6 = false;
        goto L7
    }

    private static void updateTopBottomPadding(View r2, int r3, int r4) {
        if (ViewCompat.A(r2) == false) goto L5;
        ViewCompat.b(r2, ViewCompat.l(r2), r3, ViewCompat.m(r2), r4);
        return;
    L5:
        r2.setPadding(r2.getPaddingLeft(), r3, r2.getPaddingRight(), r4);
    }

    @Override // com.google.android.material.snackbar.a
    public void animateContentIn(int r8, int r9) {
        this.messageView.setAlpha(0.0f);
        long r3 = r9;
        long r5 = r8;
        this.messageView.animate().alpha(1.0f).setDuration(r3).setStartDelay(r5).start();
        if (this.actionView.getVisibility() != 0) goto L6;
        this.actionView.setAlpha(0.0f);
        this.actionView.animate().alpha(1.0f).setDuration(r3).setStartDelay(r5).start();
        return;
    }

    @Override // com.google.android.material.snackbar.a
    public void animateContentOut(int r8, int r9) {
        this.messageView.setAlpha(1.0f);
        long r3 = r9;
        long r5 = r8;
        this.messageView.animate().alpha(0.0f).setDuration(r3).setStartDelay(r5).start();
        if (this.actionView.getVisibility() != 0) goto L6;
        this.actionView.setAlpha(1.0f);
        this.actionView.animate().alpha(0.0f).setDuration(r3).setStartDelay(r5).start();
        return;
    }

    public void setMaxInlineActionWidth(int r1) {
        this.maxInlineActionWidth = r1;
    }
}
