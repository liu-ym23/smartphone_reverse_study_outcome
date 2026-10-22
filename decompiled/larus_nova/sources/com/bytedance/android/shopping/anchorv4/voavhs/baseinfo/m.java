package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.style.ReplacementSpan;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class m extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f167971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f167972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f167973c;

    public m(int r100, int r101) {
        this.f167972b = r100;
        this.f167973c = r101;
        Paint r102 = new Paint();
        r102.setColor(0);
        r102.setStyle(Paint.Style.FILL);
        Unit r103 = Unit.INSTANCE;
        this.f167971a = r102;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        Rect r105 = new Rect(0, 0, this.f167972b, this.f167973c);
        if (r104 == null) goto L6;
        Paint.FontMetricsInt r106 = r100.getFontMetricsInt();
        int r107 = r106.bottom - r106.top;
        int r108 = (r105.bottom - r105.top) / 2;
        int r109 = r107 / 4;
        int r110 = r108 - r109;
        int r111 = -(r108 + r109);
        r104.ascent = r111;
        r104.top = r111;
        r104.bottom = r110;
        r104.descent = r110;
    L6:
        return r105.right;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r110, float r111, int r112, int r113, int r114, Paint r115) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r115, "paint");
        r100.drawRect(r111, r112, r111 + this.f167972b, r114, this.f167971a);
    }
}
