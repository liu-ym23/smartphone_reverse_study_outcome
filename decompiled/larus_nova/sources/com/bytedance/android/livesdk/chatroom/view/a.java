package com.bytedance.android.livesdk.chatroom.view;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bytedance.android.livesdk.utils.e0;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BlurImageView f114740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bitmap f114741b;

    public a(BlurImageView r100, Bitmap r101) {
        this.f114740a = r100;
        this.f114741b = r101;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Drawable> r110) {
        Intrinsics.checkNotNullParameter(r110, "it");
        if (this.f114741b == null) goto L8;
        BlurImageView r100 = this.f114740a;
        if (r100.f114688a <= 0) goto L8;
        float r101 = r100.getWidth() / this.f114741b.getWidth();
        float r102 = this.f114740a.getHeight() / this.f114741b.getHeight();
        Matrix r103 = new Matrix();
        r103.postScale(r101, r102);
        Bitmap r104 = this.f114741b;
        Bitmap r105 = Bitmap.createBitmap(r104, 0, 0, r104.getWidth(), this.f114741b.getHeight(), r103, true);
        Bitmap r106 = Bitmap.createBitmap(this.f114740a.getWidth(), this.f114740a.getHeight(), Bitmap.Config.ARGB_8888);
        e0.a(r105, r106, this.f114740a.f114688a);
        r110.onNext(new BitmapDrawable(this.f114740a.getContext().getResources(), r106));
        return;
    L8:
        r110.onError(new Throwable("getBlurDrawable fail: bitmap=" + this.f114741b + ", mBlurRadius=" + this.f114740a.f114688a));
    }
}
