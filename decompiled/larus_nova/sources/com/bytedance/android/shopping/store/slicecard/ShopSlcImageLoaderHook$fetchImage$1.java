package com.bytedance.android.shopping.store.slicecard;

import android.net.Uri;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "Lcom/facebook/imagepipeline/request/ImageRequest;", "p1", "Landroid/net/Uri;", AbsMethodDelegate.TAG_INVOKE, "(Landroid/net/Uri;)[Lcom/facebook/imagepipeline/request/ImageRequest;"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ShopSlcImageLoaderHook$fetchImage$1 extends FunctionReferenceImpl implements Function1<Uri, ImageRequest[]> {
    public ShopSlcImageLoaderHook$fetchImage$1(g r100) {
        super(1, r100, g.class, "createImageRequests", "createImageRequests(Landroid/net/Uri;)[Lcom/facebook/imagepipeline/request/ImageRequest;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ImageRequest[] invoke2(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        ((g) this.receiver).getClass();
        Intrinsics.checkNotNullParameter(r100, "uri");
        ConcurrentHashMap<String, ImageRequest[]> r101 = c.f186329a;
        String r102 = r100.toString();
        Intrinsics.checkNotNullParameter(r102, "key");
        return c.f186329a.get(r102);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ImageRequest[] invoke(Uri r100) {
        return invoke2(r100);
    }
}
