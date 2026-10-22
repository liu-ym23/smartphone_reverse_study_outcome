package com.bytedance.android.live.profit.format.voicechat.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bytedance.android.livesdk.utils.e0;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BlurBackgroundImageView f87782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bitmap f87783b;

    public a(BlurBackgroundImageView r100, Bitmap r101) {
        this.f87782a = r100;
        this.f87783b = r101;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Drawable> r110) {
        Intrinsics.checkNotNullParameter(r110, "it");
        if (this.f87783b == null) goto L12;
        BlurBackgroundImageView r100 = this.f87782a;
        if (r100.f87702a <= 0) goto L12;
        if (r100.getWidth() == 0) goto L12;
        if (this.f87782a.getHeight() == 0) goto L12;
        Bitmap r101 = Bitmap.createBitmap(this.f87783b.getWidth(), this.f87783b.getHeight(), Bitmap.Config.ARGB_8888);
        e0.a(this.f87783b, r101, this.f87782a.f87702a);
        BlurBackgroundImageView r102 = this.f87782a;
        int r103 = r102.getWidth();
        int r104 = this.f87782a.getHeight();
        r102.getClass();
        Bitmap r105 = Bitmap.createBitmap(r103, r104, Bitmap.Config.ARGB_8888);
        Canvas r106 = new Canvas(r105);
        Matrix r107 = new Matrix();
        float r108 = r103;
        float r109 = r104;
        float r111 = Math.max(r108 / r101.getWidth(), r109 / r101.getHeight());
        r107.setScale(r111, r111);
        r107.postTranslate((r108 - (r101.getWidth() * r111)) * 0.5f, (r109 - (r101.getHeight() * r111)) * 0.5f);
        r106.drawBitmap(r101, r107, new Paint(2));
        r110.onNext(new BitmapDrawable(this.f87782a.getContext().getResources(), r105));
        return;
    L12:
        r110.onError(new Throwable("getBlurDrawable fail: bitmap=" + this.f87783b + ", mBlurRadius=" + this.f87782a.f87702a));
    }
}
