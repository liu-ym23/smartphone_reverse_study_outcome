package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: loaded from: classes11.dex */
public class GradientTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f160892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f160893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f160894c;

    public GradientTextView(Context r100) {
        this(r100, null);
    }

    public void setColorList(int[] r100) {
        this.f160892a = r100;
    }

    public void setGradient(boolean r100) {
        this.f160893b = r100;
    }

    public void setHorizontal(boolean r100) {
        this.f160894c = r100;
    }

    public GradientTextView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f160893b = true;
        this.f160894c = false;
        this.f160892a = new int[]{-3511839, -8891905};
    }

    public final void x(int r100, int r101) {
        this.f160894c = true;
        this.f160892a = new int[]{r100, r101};
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onLayout(boolean r100, int r110, int r111, int r112, int r113) {
        super.onLayout(r100, r110, r111, r112, r113);
        if (r100 == true) goto L5;
        return;
    L5:
        if (this.f160893b == false) goto L15;
        TextPaint r101 = getPaint();
        if (this.f160894c == false) goto L9;
        float r102 = getWidth();
    L11:
        if (this.f160894c == false) goto L13;
        float r103 = 0.0f;
    L14:
        int[] r114 = this.f160892a;
        r101.setShader(new LinearGradient(0.0f, 0.0f, r102, r103, r114[0], r114[1], Shader.TileMode.CLAMP));
        return;
    L13:
        r103 = getHeight();
        goto L14
    L9:
        r102 = 0.0f;
        goto L11
    L15:
        getPaint().setShader(null);
    }
}
