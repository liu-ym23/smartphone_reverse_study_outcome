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
public final class h extends BaseBitmapDataSubscriber {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f145109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f145110b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bitmap f145111a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f145112b;

        public a(Bitmap r100, h r101) {
            this.f145111a = r100;
            this.f145112b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            h r100 = this.f145112b;     // Catch: Throwable -> L4
            i.i(r100.f145109a, r100.f145110b, this.f145111a);     // Catch: Throwable -> L4
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
        i.i(this.f145109a, this.f145110b, r101);
        return;
    L13:
        i0.h(new a(r101, this));
        return;
    }

    public h(i r100, String r101) {
        this.f145109a = r100;
        this.f145110b = r101;
    }
}
