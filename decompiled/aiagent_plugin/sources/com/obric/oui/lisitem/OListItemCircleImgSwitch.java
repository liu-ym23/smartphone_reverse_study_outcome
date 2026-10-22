package com.obric.oui.lisitem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import com.obric.oui.oswitch.OSwitch;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OListItemCircleImgSwitch.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OListItemCircleImgSwitch extends OListItemCircleImg {
    private final OSwitch mOSwitch;
    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener;

    public static /* synthetic */ void lambda$0kDimHIDyDNfWOiA_NTMyBx1q7g(OListItemCircleImgSwitch r0, CompoundButton r1, boolean r2) {
        m1102lambda1$lambda0(r0, r1, r2);
    }

    public /* synthetic */ OListItemCircleImgSwitch(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public OListItemCircleImgSwitch(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        super(r3, r11);
        OSwitch r12 = new OSwitch(r3, null, 0, 6, null);
        r12.setClickable(true);
        r12.setOnCheckedChangeListener(new $$Lambda$OListItemCircleImgSwitch$0kDimHIDyDNfWOiA_NTMyBx1q7g(this));
        this.mOSwitch = r12;
        setTrailingView((View) ZeusTransformUtils.preCheckCast(r12, View.class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: lambda-1$lambda-0, reason: not valid java name */
    private static final void m1102lambda1$lambda0(OListItemCircleImgSwitch r1, CompoundButton r2, boolean r3) {
        o.e(r1, "this$0");
        CompoundButton.OnCheckedChangeListener r4 = r1.mOnCheckedChangeListener;
        if (r4 == null) goto L7;
        r4.onCheckedChanged(r2, r3);
        return;
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
}
