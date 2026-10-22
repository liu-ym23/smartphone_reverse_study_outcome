package com.obric.oui.lisitem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.obric.oui.oswitch.OSwitch;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OListItemSwitch.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OListItemSwitch extends OListItemSettings {
    private final OSwitch mOSwitch;
    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener;

    /* JADX INFO: renamed from: lambda$bqL3dzCrCn2gUP7MWkmLH-lprVg, reason: not valid java name */
    public static /* synthetic */ void m1103lambda$bqL3dzCrCn2gUP7MWkmLHlprVg(OListItemSwitch r0, CompoundButton r1, boolean r2) {
        m1104lambda1$lambda0(r0, r1, r2);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout
    public boolean isPressable() {
        return false;
    }

    public /* synthetic */ OListItemSwitch(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public OListItemSwitch(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        super(r3, r11);
        setClickable(false);
        OSwitch r12 = new OSwitch(r3, null, 0, 6, null);
        r12.setClickable(true);
        r12.setOnCheckedChangeListener(new $$Lambda$OListItemSwitch$bqL3dzCrCn2gUP7MWkmLHlprVg(this));
        this.mOSwitch = r12;
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(-2, -2);
        r13.gravity = 17;
        r13.leftMargin = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 4);
        r13.rightMargin = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 4);
        setTrailingView((View) ZeusTransformUtils.preCheckCast(r12, View.class, "com.obric.aiagent.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r13, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: lambda-1$lambda-0, reason: not valid java name */
    private static final void m1104lambda1$lambda0(OListItemSwitch r1, CompoundButton r2, boolean r3) {
        o.e(r1, "this$0");
        CompoundButton.OnCheckedChangeListener r4 = r1.mOnCheckedChangeListener;
        if (r4 == null) goto L7;
        r4.onCheckedChanged(r2, r3);
        return;
    }

    @Override // com.obric.oui.lisitem.OListItemSettings, com.obric.oui.lisitem.OListItemGeneral
    public void inflateContent() {
        ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.o_listitem_switch, "layout", "o_listitem_switch"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    }

    public final void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener r3) {
        this.mOnCheckedChangeListener = (CompoundButton.OnCheckedChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, CompoundButton.OnCheckedChangeListener.class, "com.obric.aiagent.plugin");
    }

    public final void setChecked(boolean r1) {
        this.mOSwitch.setChecked(r1);
    }

    public final boolean isChecked() {
        return this.mOSwitch.isChecked();
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral, com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        this.mOSwitch.setAlpha(1.0f);
    }

    public final OSwitch getSwitch() {
        return this.mOSwitch;
    }
}
