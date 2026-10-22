package com.bytedance.android.ecom.arch.slice.background;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b extends BaseBitmapDataSubscriber {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f50031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f50032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ImagePipeline f50033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ List f50034d;

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r100) {
        Intrinsics.checkNotNullParameter(r100, "dataSource");
        HashMap<String, WeakReference<Bitmap>> r101 = PdpBackgroundUtil.f50015a;
        ImagePipeline r102 = this.f50033c;
        List r103 = this.f50034d;
        int r104 = this.f50031a;
        this.f50031a = r104 + 1;
        if (PdpBackgroundUtil.a(r102, r103, r104, this) == true) goto L6;
        this.f50032b.invoke(null);
        return;
    }

    @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
    public final void onNewResultImpl(Bitmap r100) {
        Function1 r101 = this.f50032b;
        if (r100 == null) goto L5;
        Bitmap r102 = Bitmap.createBitmap(r100);
    L6:
        r101.invoke(r102);
        return;
    L5:
        r102 = null;
        goto L6
    }

    public b(Function1 r100, ImagePipeline r101, List r102) {
        this.f50032b = r100;
        this.f50033c = r101;
        this.f50034d = r102;
        this.f50031a = 1;
    }
}
