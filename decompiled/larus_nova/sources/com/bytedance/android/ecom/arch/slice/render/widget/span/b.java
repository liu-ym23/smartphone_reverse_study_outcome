package com.bytedance.android.ecom.arch.slice.render.widget.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f50979a;

    public b() {
        this(null);
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
    }

    public final int hashCode() {
        Integer r100 = this.f50979a;
        if (r100 == null) goto L5;
        int r101 = r100.intValue();
    L7:
        return 31 + r101;
    L5:
        r101 = 0;
        goto L7
    }

    public b(Integer r100) {
        this.f50979a = r100;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if ((true ^ Intrinsics.areEqual(b.class, r100.getClass())) == false) goto L10;
        return false;
    L10:
        return Intrinsics.areEqual(this.f50979a, ((b) r100).f50979a);
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Integer r105 = this.f50979a;
        if (r105 != null) goto L5;
        if (r101 != null) goto L8;
        return 0;
    L8:
        return (int) r100.measureText(r101, r102, r103);
    L5:
        return r105.intValue();
    }
}
