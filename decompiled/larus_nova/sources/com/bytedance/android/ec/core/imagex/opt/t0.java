package com.bytedance.android.ec.core.imagex.opt;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public abstract class t0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f44898d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<? extends Uri> f44899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageRequestBuilder f44900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f44901c;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageRequestBuilder f44902a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageRequest[] f44903b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Uri[] f44904c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ImageRequest f44905d;

        public b(ImageRequestBuilder r100, ImageRequest[] r101, Uri[] r102, ImageRequest r103) {
            Intrinsics.checkNotNullParameter(r100, "builder");
            this.f44902a = r100;
            this.f44903b = r101;
            this.f44904c = r102;
            this.f44905d = r103;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ImageRequest[] f44906a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ImageRequest f44907b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Uri[] f44908c;

        public c(ImageRequest[] r100, ImageRequest r101) {
            this.f44906a = r100;
            this.f44907b = r101;
            this.f44908c = null;
        }
    }

    public final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f44909a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageRequest[] f44910b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ t0 f44911c;

        public d(com.bytedance.android.ec.core.imagex.a0 r100, ImageRequest[] r101) {
            this.f44911c = r100;
            this.f44910b = r101;
        }
    }

    static {
    }

    public abstract void b(ImageRequestBuilder r100);

    public abstract List<Uri> c();

    public abstract void d(c r100);

    public abstract void e();

    public abstract void f(ImageRequestBuilder r100);

    public abstract ImageRequest g(ImageRequest r100);

    public abstract CloseableStaticBitmap h(CacheKey r100);

    public final ImageRequestBuilder a() {
        ImageRequestBuilder r100 = this.f44900b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        List<? extends Uri> r101 = this.f44899a;
        if (r101 == null) goto L12;
        Uri r102 = (Uri) CollectionsKt.firstOrNull(r101);
        if (r102 == null) goto L14;
        ImageRequestBuilder r103 = ImageRequestBuilder.newBuilderWithSource(r102);
        f(r103);
        this.f44900b = r103;
        return r103;
    L14:
        return null;
    L12:
        return null;
    }

    public t0(List<? extends Uri> r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        r100 = null;
    L11:
        this.f44899a = r100;
        this.f44901c = new AtomicBoolean(true);
        return;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }
}
