package com.obric.oui.filter;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.a;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.StringTokenizer;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public class CenterIconButton extends AppCompatButton {
    private static final String DELIMITERS = "\n";
    private static final int DRAWABLES_LENGTH = 4;
    private static final int DRAWABLE_BOTTOM_POSITION = 3;
    private static final int DRAWABLE_LEFT_POSITION = 0;
    private static final int DRAWABLE_RIGHT_POSITION = 2;
    private static final int DRAWABLE_TOP_POSITION = 1;
    protected int mDrawableSize;
    protected int mLeftPadding;
    protected int mRightPadding;
    protected int mTintColor;
    private Rect textBoundsRect;

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.d(r0, r1);
    }

    public CenterIconButton(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        super(r4);
        this.mTintColor = 0;
        init(r4, null);
    }

    public CenterIconButton(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r5, r6);
        this.mTintColor = 0;
        init(r5, r6);
    }

    public CenterIconButton(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r6, r7, r5);
        this.mTintColor = 0;
        init(r6, r7);
    }

    private void init(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L5;
        TypedArray r7 = r5.obtainStyledAttributes(r6, R.styleable.OCenterIconButton);
        this.mTintColor = r7.getColor(ZeusTransformUtils.mapRes(R.styleable.OCenterIconButton_oui_drawableTint, "styleable", "OCenterIconButton_oui_drawableTint"), 0);
        this.mDrawableSize = r7.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OCenterIconButton_oui_drawableSize, "styleable", "OCenterIconButton_oui_drawableSize"), g.a(12));
        setCompoundDrawablePadding((int) r7.getDimension(ZeusTransformUtils.mapRes(R.styleable.OCenterIconButton_android_drawablePadding, "styleable", "OCenterIconButton_android_drawablePadding"), g.a(4)));
        updateDrawables();
        r7.recycle();
    L5:
        this.mLeftPadding = getPaddingLeft();
        this.mRightPadding = getPaddingRight();
    }

    public void updateDrawables() {
        if (this.mTintColor == 0) goto L5;
    L6:
        Drawable[] r0 = getCompoundDrawables();
        if (r0.length == 4) goto L9;
        return;
    L9:
        Drawable[] r1 = new Drawable[4];
        int r4 = 0;
    L10:
        if (r4 >= 4) goto L22;
        Drawable r5 = r0[r4];
        if (r5 == null) goto L20;
        if (this.mTintColor == 0) goto L17;
        r5 = getTintedDrawable(r5);
    L17:
        if (this.mDrawableSize <= 0) goto L19;
        r5 = updateDrawableBounds(r5);
    L19:
        r1[r4] = r5;
    L20:
        r4 = r4 + 1;
        goto L10
    L22:
        if (this.mDrawableSize <= 0) goto L24;
        setCompoundDrawables(r1[0], r1[1], r1[2], r1[3]);
        return;
    L24:
        setCompoundDrawablesWithIntrinsicBounds(r1[0], r1[1], r1[2], r1[3]);
        return;
    L5:
        if (this.mDrawableSize != (-1)) goto L6;
    }

    private Drawable getTintedDrawable(Drawable r1) {
        Drawable r2 = a.g(r1).mutate();
        a.a(r2, this.mTintColor);
        return r2;
    }

    private Drawable updateDrawableBounds(Drawable r3) {
        Rect r0 = r3.getBounds();
        int r2 = this.mDrawableSize;
        r0.set(0, 0, r2, r2);
        return r3;
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
        super.setCompoundDrawables(r1, r2, r3, r4);
        updatePadding();
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
        super.setCompoundDrawablesWithIntrinsicBounds(r1, r2, r3, r4);
        updatePadding();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence r3, TextView.BufferType r4) {
        super.setText((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"), r4);
        updatePadding();
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        updatePadding(r1);
    }

    private void updatePadding() {
        updatePadding(getMeasuredWidth());
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int r1, int r2, int r3, int r4) {
        super.setPadding(r1, r2, r3, r4);
        this.mLeftPadding = r1;
        this.mRightPadding = r3;
        updatePadding();
    }

    private void updatePadding(int r10) {
        if (r10 != 0) goto L4;
        return;
    L4:
        Drawable[] r0 = getCompoundDrawables();
        if (r0.length == 4) goto L7;
        return;
    L7:
        Drawable r3 = r0[0];
        Drawable r1 = r0[2];
        if (r3 != null) goto L11;
        if (r1 != null) goto L11;
        return;
    L11:
        int r5 = getTextWidth();
        int r6 = Math.max(getCompoundDrawablePadding(), 1);
        if (r3 != null) goto L14;
        int r7 = 0;
    L15:
        if (r1 != null) goto L17;
        int r8 = 0;
    L18:
        if (r3 == null) goto L21;
        if (r1 == null) goto L21;
        int r11 = ((((r10 - r7) - r8) - r5) - (r6 * 4)) / 2;
    L24:
        INVOKESTATIC_com_obric_oui_filter_CenterIconButton_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("CenterIconButton", "paddingSize:" + r11);
        INVOKESTATIC_com_obric_oui_filter_CenterIconButton_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("CenterIconButton", "leftPadding:" + this.mLeftPadding);
        INVOKESTATIC_com_obric_oui_filter_CenterIconButton_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("CenterIconButton", "rightPadding:" + this.mRightPadding);
        setIncludeFontPadding(false);
        INVOKESTATIC_com_obric_oui_filter_CenterIconButton_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("CenterIconButton", "paddingLeft:" + Math.max(this.mLeftPadding, r11));
        INVOKESTATIC_com_obric_oui_filter_CenterIconButton_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("CenterIconButton", "paddingTop:" + getPaddingTop());
        INVOKESTATIC_com_obric_oui_filter_CenterIconButton_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("CenterIconButton", "paddingRight:" + Math.max(r11, this.mRightPadding));
        INVOKESTATIC_com_obric_oui_filter_CenterIconButton_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("CenterIconButton", "paddingBottom:" + getPaddingBottom());
        super.setPadding(Math.max(this.mLeftPadding, r11), getPaddingTop(), Math.max(r11, this.mRightPadding), getPaddingBottom());
        return;
    L21:
        if (r3 == null) goto L23;
        r11 = (((r10 - r7) - r6) - r5) / 2;
        goto L24
    L23:
        r11 = (((r10 - r8) - r6) - r5) / 2;
        goto L24
    L17:
        r8 = r1.getBounds().width();
        goto L18
    L14:
        r7 = r3.getBounds().width();
        goto L15
    }

    private int getTextWidth() {
        if (this.textBoundsRect != null) goto L5;
        this.textBoundsRect = new Rect();
    L5:
        TextPaint r0 = getPaint();
        String r1 = divideText();
        INVOKESTATIC_com_obric_oui_filter_CenterIconButton_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("CenterIconButton", "text:" + r1);
        r0.getTextBounds(r1, 0, r1.length(), this.textBoundsRect);
        INVOKESTATIC_com_obric_oui_filter_CenterIconButton_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("CenterIconButton", "textHeight" + this.textBoundsRect.height());
        return this.textBoundsRect.width();
    }

    private String divideText() {
        String r0 = getText().toString();
        if (r0.isEmpty() == false) goto L6;
        return "";
    L6:
        ArrayList r1 = new ArrayList();
        int r4 = 0;
        StringTokenizer r2 = new StringTokenizer(r0, DELIMITERS, false);
    L8:
        if (r2.hasMoreTokens() == false) goto L11;
        r1.add(r2.nextToken());
        goto L8
    L11:
        if (r1.size() == 1) goto L13;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.get(0), String.class, "com.obric.aiagent.plugin");
    L19:
        if (r4 >= (r1.size() - 1)) goto L25;
        int r5 = r4 + 1;
        if (((String) ZeusTransformUtils.preCheckCast(r1.get(r5), String.class, "com.obric.aiagent.plugin")).length() <= ((String) ZeusTransformUtils.preCheckCast(r1.get(r4), String.class, "com.obric.aiagent.plugin")).length()) goto L23;
        r3 = (String) ZeusTransformUtils.preCheckCast(r1.get(r5), String.class, "com.obric.aiagent.plugin");
    L23:
        r4 = r5;
        goto L19
    L25:
        if (isAllCaps() == true) goto L27;
        return r3;
    L27:
        return r3.toUpperCase();
    L13:
        if (isAllCaps() == false) goto L16;
        return ((String) ZeusTransformUtils.preCheckCast(r1.get(0), String.class, "com.obric.aiagent.plugin")).toUpperCase();
    L16:
        return (String) ZeusTransformUtils.preCheckCast(r1.get(0), String.class, "com.obric.aiagent.plugin");
    }

    @Override // android.widget.TextView
    public boolean isAllCaps() {
        TransformationMethod r1 = getTransformationMethod();
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.getClass().getSimpleName().equals("AllCapsTransformationMethod");
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_filter_CenterIconButton_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
