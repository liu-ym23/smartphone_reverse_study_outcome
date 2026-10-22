package com.bytedance.android.live.core.utils;

import android.graphics.Bitmap;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class n2<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DataSource f66232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ py.k f66233b;

    public static final class a extends BaseBitmapDataSubscriber {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n2 f66234a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter f66235b;

        @Override // com.facebook.datasource.BaseDataSubscriber
        public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r100) {
            Intrinsics.checkNotNullParameter(r100, "dataSource");
            if (this.f66235b.isDisposed() == true) goto L6;
            ObservableEmitter r101 = this.f66235b;
            Throwable r102 = r100.getFailureCause();
            Intrinsics.checkNotNull(r102);
            r101.onError(r102);
            return;
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public final void onNewResultImpl(Bitmap r100) {
            if (this.f66235b.isDisposed() == true) goto L9;
            if (r100 != null) goto L7;
            this.f66235b.onError(new IllegalStateException("No bitmap loaded for imageModel: " + this.f66234a.f66233b));
            return;
        L7:
            this.f66235b.onNext(r100);
            this.f66235b.onComplete();
            return;
        }

        public a(n2 r100, ObservableEmitter r101) {
            this.f66234a = r100;
            this.f66235b = r101;
        }
    }

    public n2(DataSource r100, py.k r101) {
        this.f66232a = r100;
        this.f66233b = r101;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Bitmap> r100) {
        Intrinsics.checkNotNullParameter(r100, "subscriber");
        a r101 = new a(this, r100);
        this.f66232a.subscribe(r101, TTExecutors.getNormalExecutor());
    }
}
