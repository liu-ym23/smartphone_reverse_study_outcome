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
public final class g extends BaseBitmapDataSubscriber {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f145105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f145106b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bitmap f145107a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f145108b;

        public a(Bitmap r100, g r101) {
            this.f145107a = r100;
            this.f145108b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            g r100 = this.f145108b;     // Catch: Throwable -> L4
            i.i(r100.f145105a, r100.f145106b, this.f145107a);     // Catch: Throwable -> L4
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
        if (r101 == null) goto L17;
        this.f145105a.f145119q.f145265g = true;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L13;
        i.i(this.f145105a, this.f145106b, r101);
        return;
    L13:
        i0.h(new a(r101, this));
        return;
    L17:
        return;
    }

    public g(i r100, String r101) {
        this.f145105a = r100;
        this.f145106b = r101;
    }
}
