package com.bytedance.android.anniex.detect.detection;

import android.graphics.Bitmap;
import android.view.PixelCopy;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements PixelCopy.OnPixelCopyFinishedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StringBuilder f40670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Continuation<Bitmap> f40671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Bitmap f40672c;

    public a(StringBuilder r100, SafeContinuation r101, Bitmap r102) {
        this.f40670a = r100;
        this.f40671b = r101;
        this.f40672c = r102;
    }

    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
    public final void onPixelCopyFinished(int r100) {
        if (r100 != 0) goto L5;
        StringBuilder r101 = this.f40670a;
        r101.append("PixelCopy SUCCESS and scaled at draw time");
        r101.append('\n');
        Continuation<Bitmap> r102 = this.f40671b;
        Result.Companion r103 = Result.Companion;
        r102.resumeWith(Result.m9449constructorimpl(this.f40672c));
        return;
    L5:
        StringBuilder r104 = this.f40670a;
        r104.append("PixelCopy FAILED: " + r100);
        r104.append('\n');
        this.f40671b.resumeWith(Result.m9449constructorimpl(null));
    }
}
