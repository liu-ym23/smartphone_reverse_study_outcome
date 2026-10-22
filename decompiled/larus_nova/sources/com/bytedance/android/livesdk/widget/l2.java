package com.bytedance.android.livesdk.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class l2<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScreenShotShareDialog f161789a;

    public l2(ScreenShotShareDialog r100) {
        this.f161789a = r100;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<Bitmap> r100) {
        Intrinsics.checkNotNullParameter(r100, "emmiter");
        Bitmap r101 = BitmapFactory.decodeFile(this.f161789a.f161281p);
        if (r101 == null) goto L5;
        r100.onSuccess(r101);
        return;
    L5:
        r100.tryOnError(new NullPointerException("bitmap is null, url=" + this.f161789a.f161281p));
    }
}
