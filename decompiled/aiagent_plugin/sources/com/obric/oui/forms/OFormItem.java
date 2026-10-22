package com.obric.oui.forms;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Objects;

/* JADX INFO: compiled from: OFormItem.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OFormItem extends LinearLayoutCompat {
    private final OInputView vInput;
    private final OTextView vLabel;

    public OFormItem(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OFormItem(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public /* synthetic */ OFormItem(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public OFormItem(Context r10, AttributeSet r11, int r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r14 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r13, "context");
        super(r13, r14, r12);
        OTextView r0 = new OTextView((Context) ZeusTransformUtils.preCheckCast(new ContextThemeWrapper(r13, ZeusTransformUtils.mapRes(R.style.Label_L, "style", "Label_L")), Context.class, "com.obric.aiagent.plugin"), null, 0, null, 14, null);
        this.vLabel = r0;
        OInputView r8 = new OInputView(r13, null, 0, 6, null);
        this.vInput = r8;
        setGravity(16);
        TypedArray r15 = r13.obtainStyledAttributes(r14, R.styleable.LinearLayoutCompat, r12, 0);
        int r16 = r15.getInt(ZeusTransformUtils.mapRes(R.styleable.LinearLayoutCompat_android_gravity, "styleable", "LinearLayoutCompat_android_gravity"), -1);
        if (r16 < 0) goto L5;
        setGravity(r16);
    L5:
        r15.recycle();
        addView((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"));
        addView((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin"));
        initViews();
    }

    private final void initViews() {
        this.vInput.setShowLabel(false);
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.vLabel, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type androidx.appcompat.widget.LinearLayoutCompat.LayoutParams");
        ViewGroup.LayoutParams r2 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((LinearLayoutCompat.LayoutParams) ZeusTransformUtils.preCheckCast(r1, LinearLayoutCompat.LayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        LinearLayoutCompat.LayoutParams r4 = (LinearLayoutCompat.LayoutParams) ZeusTransformUtils.preCheckCast(r2, LinearLayoutCompat.LayoutParams.class, "com.obric.aiagent.plugin");
        if (getOrientation() != 0) goto L5;
        int r5 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 72);
    L6:
        r4.width = r5;
        r4.height = -2;
        r0.setLayoutParams(r2);
        this.vLabel.setText((CharSequence) ZeusTransformUtils.preCheckCast("label", CharSequence.class, "com.obric.aiagent.plugin"));
        this.vInput.setHint("hint");
        View r3 = (View) ZeusTransformUtils.preCheckCast(this.vInput, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r6 = r3.getLayoutParams();
        Objects.requireNonNull(r6, "null cannot be cast to non-null type androidx.appcompat.widget.LinearLayoutCompat.LayoutParams");
        ViewGroup.LayoutParams r7 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((LinearLayoutCompat.LayoutParams) ZeusTransformUtils.preCheckCast(r6, LinearLayoutCompat.LayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        LinearLayoutCompat.LayoutParams r8 = (LinearLayoutCompat.LayoutParams) ZeusTransformUtils.preCheckCast(r7, LinearLayoutCompat.LayoutParams.class, "com.obric.aiagent.plugin");
        r8.weight = 1.0f;
        r8.width = -1;
        r8.height = -2;
        if (getOrientation() != 1) goto L10;
        r8.topMargin = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 8);
    L12:
        r3.setLayoutParams(r7);
        return;
    L10:
        if (getOrientation() != 0) goto L12;
        r8.setMarginStart(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12));
        r8.leftMargin = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12);
        goto L12
    L5:
        r5 = -1;
        goto L6
    }

    public final OTextView getLabelView() {
        return this.vLabel;
    }

    public final OInputView getInputView() {
        return this.vInput;
    }
}
