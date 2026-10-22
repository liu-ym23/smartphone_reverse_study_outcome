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
public final class e extends BaseBitmapDataSubscriber {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f145097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f145098b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bitmap f145099a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f145100b;

        public a(Bitmap r100, e r101) {
            this.f145099a = r100;
            this.f145100b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            e r100 = this.f145100b;     // Catch: Throwable -> L6
            i r101 = r100.f145097a;     // Catch: Throwable -> L6
            String r102 = r100.f145098b;     // Catch: Throwable -> L6
            Bitmap r103 = this.f145099a;     // Catch: Throwable -> L6
            c r104 = r101.f145121s;     // Catch: Throwable -> L6
            r104.f144982o = r102;     // Catch: Throwable -> L6
            r104.d(r103);     // Catch: Throwable -> L6
            r101.f145121s.f145265g = true;     // Catch: Throwable -> L6
            AnimatorSet r105 = r101.f145122t;     // Catch: Throwable -> L6
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
        if (r101 == null) goto L19;
        this.f145097a.f145119q.f145265g = true;
        this.f145097a.f145120r.f145265g = true;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L15;
        i r102 = this.f145097a;
        String r103 = this.f145098b;
        c r104 = r102.f145121s;
        r104.f144982o = r103;
        r104.d(r101);
        r102.f145121s.f145265g = true;
        AnimatorSet r105 = r102.f145122t;
        if (r105 == null) goto L20;
        r105.start();
        return;
    L20:
        return;
    L15:
        i0.h(new a(r101, this));
        return;
    L19:
        return;
    }

    public e(i r100, String r101) {
        this.f145097a = r100;
        this.f145098b = r101;
    }
}
