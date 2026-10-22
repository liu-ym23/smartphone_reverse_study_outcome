package com.bytedance.android.livesdk.feed;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes8.dex */
public class LiveDrawerTabScrollShadow extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f123552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f123553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f123554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f123555d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f123556e;

    public LiveDrawerTabScrollShadow(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        int r100 = this.f123554c;
        if (this.f123555d == false) goto L5;
        int r101 = this.f123553b;
    L7:
        if (this.f123556e == false) goto L9;
        int r102 = this.f123553b;
    L10:
        int[] r103 = {r101, r100, r100, r102};
        RectF r104 = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.f123552a.setShader(new LinearGradient(0.0f, 0.0f, r104.width(), 0.0f, r103, new float[]{0.0f, 0.09f, 0.91f, 1.0f}, Shader.TileMode.REPEAT));
        r110.drawRect(r104, this.f123552a);
        return;
    L9:
        r102 = r100;
        goto L10
    L5:
        r101 = r100;
        goto L7
    }

    public void setShadowEdgeColorRes(int r100) {
        this.f123553b = s1.h(r100);
        invalidate();
    }

    public LiveDrawerTabScrollShadow(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public LiveDrawerTabScrollShadow(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f123553b = s1.h(R.color.black);
        this.f123554c = s1.h(R.color.transparent);
        this.f123555d = false;
        this.f123556e = false;
        Paint r103 = new Paint();
        this.f123552a = r103;
        r103.setAntiAlias(true);
        r103.setStyle(Paint.Style.FILL);
    }
}
