package com.obric.oui.dialog.alert.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.common.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Objects;

/* JADX INFO: compiled from: DialogConfirmView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DialogConfirmView extends ConstraintLayout {
    private final OCheckBox checkBox;
    private final ViewGroup clickContainer;
    private final RelativeLayout linkContainer;
    private final TextView tvLink;
    private final TextView tvNormal;

    /* JADX WARN: Multi-variable type inference failed */
    public DialogConfirmView(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    /* JADX INFO: renamed from: lambda$BsXn_ZPWI6NkLD3Z4h-ZTakIuCE, reason: not valid java name */
    public static /* synthetic */ void m1005lambda$BsXn_ZPWI6NkLD3Z4hZTakIuCE(DialogConfirmView r0, View r1) {
        m1007onAttachedToWindow$lambda1(r0, r1);
    }

    public static /* synthetic */ void lambda$SGfCbP9WVzDAKBw06y1vY_H4cMs(DialogConfirmView r0, View r1) {
        m1006onAttachedToWindow$lambda0(r0, r1);
    }

    public /* synthetic */ DialogConfirmView(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public DialogConfirmView(Context r4, AttributeSet r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7);
        ConstraintLayout.inflate(r6, ZeusTransformUtils.mapRes(R.layout.o_layout_dialog_options, "layout", "o_layout_dialog_options"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"));
        int r8 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 5);
        setPadding(r8, r8, r8, 0);
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.radio, DbHelper.COL_ID, "radio"));
        o.c(r9, "findViewById(R.id.radio)");
        this.checkBox = (OCheckBox) ZeusTransformUtils.preCheckCast(r9, OCheckBox.class, "com.obric.aiagent.plugin");
        View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_normal, DbHelper.COL_ID, "tv_normal"));
        o.c(r10, "findViewById(R.id.tv_normal)");
        this.tvNormal = (TextView) ZeusTransformUtils.preCheckCast(r10, TextView.class, "com.obric.aiagent.plugin");
        View r11 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_link, DbHelper.COL_ID, "tv_link"));
        o.c(r11, "findViewById(R.id.tv_link)");
        this.tvLink = (TextView) ZeusTransformUtils.preCheckCast(r11, TextView.class, "com.obric.aiagent.plugin");
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.link_text_container, DbHelper.COL_ID, "link_text_container"));
        o.c(r12, "findViewById(R.id.link_text_container)");
        this.linkContainer = (RelativeLayout) ZeusTransformUtils.preCheckCast(r12, RelativeLayout.class, "com.obric.aiagent.plugin");
        View r13 = findViewById(ZeusTransformUtils.mapRes(R.id.click_container, DbHelper.COL_ID, "click_container"));
        o.c(r13, "findViewById(R.id.click_container)");
        this.clickContainer = (ViewGroup) ZeusTransformUtils.preCheckCast(r13, ViewGroup.class, "com.obric.aiagent.plugin");
    }

    public final OCheckBox getCheckBox() {
        return this.checkBox;
    }

    public final TextView getNormalTextView() {
        return this.tvNormal;
    }

    public final TextView getLinkTextView() {
        return this.tvLink;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getParent() != null) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(getParent(), ViewGroup.class) == false) goto L9;
        ViewParent r0 = getParent();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r1 = (ViewGroup) ZeusTransformUtils.preCheckCast(r0, ViewGroup.class, "com.obric.aiagent.plugin");
        this.linkContainer.setPadding(0, r1.getPaddingTop(), 0, r1.getPaddingBottom());
        this.linkContainer.setOnClickListener(new $$Lambda$DialogConfirmView$SGfCbP9WVzDAKBw06y1vY_H4cMs(this));
        r1.setPadding(r1.getPaddingLeft(), 0, r1.getPaddingRight(), 0);
        this.clickContainer.setOnClickListener(new $$Lambda$DialogConfirmView$BsXn_ZPWI6NkLD3Z4hZTakIuCE(this));
        return;
    }

    /* JADX INFO: renamed from: onAttachedToWindow$lambda-0, reason: not valid java name */
    private static final void m1006onAttachedToWindow$lambda0(DialogConfirmView r0, View r1) {
        o.e(r0, "this$0");
        r0.tvLink.performClick();
    }

    /* JADX INFO: renamed from: onAttachedToWindow$lambda-1, reason: not valid java name */
    private static final void m1007onAttachedToWindow$lambda1(DialogConfirmView r0, View r1) {
        o.e(r0, "this$0");
        r0.getCheckBox().performClick();
    }
}
