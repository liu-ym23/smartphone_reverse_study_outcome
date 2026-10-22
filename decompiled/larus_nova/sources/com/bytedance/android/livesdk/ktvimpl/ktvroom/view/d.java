package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import android.animation.AnimatorSet;
import android.graphics.Bitmap;
import android.os.Looper;
import com.bytedance.android.live.core.utils.i0;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class d extends BaseBitmapDataSubscriber {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f145014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f145015b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bitmap f145016a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f145017b;

        public a(Bitmap r100, d r101) {
            this.f145016a = r100;
            this.f145017b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d r100 = this.f145017b;     // Catch: Throwable -> L6
            i r101 = r100.f145014a;     // Catch: Throwable -> L6
            String r102 = r100.f145015b;     // Catch: Throwable -> L6
            Bitmap r103 = this.f145016a;     // Catch: Throwable -> L6
            c r104 = r101.f145117o;     // Catch: Throwable -> L6
            r104.f144982o = r102;     // Catch: Throwable -> L6
            r104.d(r103);     // Catch: Throwable -> L6
            r101.f145117o.f145265g = true;     // Catch: Throwable -> L6
            AnimatorSet r105 = r101.f145123u;     // Catch: Throwable -> L6
            if (r105 == null) goto L9;
            r105.start();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r100) {
    }

    @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
    public final void onNewResultImpl(Bitmap r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if ((!r100.isRecycled()) == true) goto L7;
        r100 = null;
    L7:
        if (r100 == null) goto L18;
        Bitmap r101 = r100.copy(Bitmap.Config.ARGB_8888, false);
        if (r101 != null) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L15;
        i r102 = this.f145014a;
        String r103 = this.f145015b;
        c r104 = r102.f145117o;
        r104.f144982o = r103;
        r104.d(r101);
        r102.f145117o.f145265g = true;
        AnimatorSet r105 = r102.f145123u;
        if (r105 == null) goto L20;
        r105.start();
        return;
    L20:
        return;
    L15:
        i0.h(new a(r101, this));
        return;
    }

    public d(i r100, String r101) {
        this.f145014a = r100;
        this.f145015b = r101;
    }
}
