package com.obric.autoaction.presentation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: GradientTextView.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class GradientTextView extends AppCompatTextView {
    private int endColor;
    private boolean gradientColorEnabled;
    private LinearGradient linearGradientShader;
    private int startColor;

    public GradientTextView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public GradientTextView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public /* synthetic */ GradientTextView(Context r2, AttributeSet r3, int r4, int r5, h r6) {
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

    public GradientTextView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7, r5);
        this.gradientColorEnabled = true;
        this.startColor = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_ai_a_color2_6, "color", "oui_ai_a_color2_6"));
        this.endColor = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_ai_a_color3_6, "color", "oui_ai_a_color3_6"));
    }

    @Override // android.view.View
    public void onSizeChanged(int r9, int r10, int r11, int r12) {
        super.onSizeChanged(r9, r10, r11, r12);
        if (r9 <= 0) goto L6;
        this.linearGradientShader = new LinearGradient(0.0f, 0.0f, r9, 0.0f, new int[]{this.startColor, this.endColor}, null, Shader.TileMode.CLAMP);
        invalidate();
        return;
    }

    public final void setGradientColorEnabled(boolean r1) {
        this.gradientColorEnabled = r1;
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas r5) {
        o.e(r5, "canvas");
        TextPaint r0 = getPaint();
        if (this.gradientColorEnabled == false) goto L5;
        Shader r1 = (Shader) ZeusTransformUtils.preCheckCast(this.linearGradientShader, Shader.class, "com.obric.aiagent.plugin");
    L6:
        r0.setShader(r1);
        super.onDraw(r5);
        return;
    L5:
        r1 = null;
        goto L6
    }
}
