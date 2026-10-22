package com.bytedance.android.ec.core.imagex;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public abstract class t0 extends BaseBitmapDataSubscriber {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataSource<CloseableReference<CloseableImage>> f44953a;

    public abstract void a(Bitmap r100);

    public t0(DataSource<CloseableReference<CloseableImage>> r100) {
        Intrinsics.checkNotNullParameter(r100, "dataSource");
        this.f44953a = r100;
    }

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        Boolean r102 = null;
        a(null);     // Catch: Throwable -> L7
        if (r100 == null) goto L5;
        r102 = Boolean.valueOf(r100.close());     // Catch: Throwable -> L7
    L5:
        Result.m9449constructorimpl(r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
    public final void onNewResultImpl(Bitmap r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        if (this.f44953a.isFinished() == false) goto L6;
        if (r100 == null) goto L6;
        a(Bitmap.createBitmap(r100));     // Catch: Throwable -> L9
        Object r102 = Boolean.valueOf(this.f44953a.close());     // Catch: Throwable -> L9
    L7:
        Result.m9449constructorimpl(r102);     // Catch: Throwable -> L9
        return;
    L6:
        a(null);     // Catch: Throwable -> L9
        r102 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
