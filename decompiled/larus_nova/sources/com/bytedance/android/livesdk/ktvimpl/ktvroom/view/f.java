package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

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
public final class f extends BaseBitmapDataSubscriber {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f145101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f145102b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bitmap f145103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f145104b;

        public a(Bitmap r100, f r101) {
            this.f145103a = r100;
            this.f145104b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            f r100 = this.f145104b;     // Catch: Throwable -> L4
            i.i(r100.f145101a, r100.f145102b, this.f145103a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
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
        if (r100 == null) goto L16;
        Bitmap r101 = r100.copy(Bitmap.Config.ARGB_8888, false);
        if (r101 != null) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L13;
        i.i(this.f145101a, this.f145102b, r101);
        return;
    L13:
        i0.h(new a(r101, this));
        return;
    }

    public f(i r100, String r101) {
        this.f145101a = r100;
        this.f145102b = r101;
    }
}
