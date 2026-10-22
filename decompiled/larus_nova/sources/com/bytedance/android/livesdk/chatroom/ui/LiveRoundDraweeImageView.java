package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes8.dex */
public class LiveRoundDraweeImageView extends HSImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f112337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f112338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f112339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f112340d;

    public LiveRoundDraweeImageView(Context r100) {
        this(r100, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        int r101 = getWidth();
        int r102 = getHeight();
        int r103 = Math.max(this.f112337a, this.f112339c) + Math.max(this.f112338b, this.f112340d);
        int r104 = Math.max(this.f112337a, this.f112338b) + Math.max(this.f112339c, this.f112340d);
        if (r101 < r103) goto L6;
        if (r102 <= r104) goto L6;
        Path r105 = new Path();
        r105.moveTo(this.f112337a, 0.0f);
        r105.lineTo(r101 - this.f112338b, 0.0f);
        float r106 = r101;
        r105.quadTo(r106, 0.0f, r106, this.f112338b);
        r105.lineTo(r106, r102 - this.f112340d);
        float r107 = r102;
        r105.quadTo(r106, r107, r101 - this.f112340d, r107);
        r105.lineTo(this.f112339c, r107);
        r105.quadTo(0.0f, r107, 0.0f, r102 - this.f112339c);
        r105.lineTo(0.0f, this.f112337a);
        r105.quadTo(0.0f, 0.0f, this.f112337a, 0.0f);
        r100.clipPath(r105);
    L6:
        super.onDraw(r100);
    }

    public LiveRoundDraweeImageView(Context r100, AttributeSet r101) {
        super(r100, r101);
        if (r101 == null) goto L15;
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.ttlive_radius, R.attr.ttlive_radius_bottom_left, R.attr.ttlive_radius_bottom_right, R.attr.ttlive_radius_top_left, R.attr.ttlive_radius_top_right});
        int r103 = r102.getDimensionPixelOffset(0, 0);
        int r104 = r102.getDimensionPixelOffset(3, 0);
        this.f112337a = r104;
        int r105 = r102.getDimensionPixelOffset(4, 0);
        this.f112338b = r105;
        int r106 = r102.getDimensionPixelOffset(1, 0);
        this.f112339c = r106;
        int r107 = r102.getDimensionPixelOffset(2, 0);
        this.f112340d = r107;
        if (r104 != 0) goto L7;
        this.f112337a = r103;
    L7:
        if (r105 != 0) goto L9;
        this.f112338b = r103;
    L9:
        if (r106 != 0) goto L11;
        this.f112339c = r103;
    L11:
        if (r107 != 0) goto L13;
        this.f112340d = r103;
    L13:
        r102.recycle();
        return;
    }
}
