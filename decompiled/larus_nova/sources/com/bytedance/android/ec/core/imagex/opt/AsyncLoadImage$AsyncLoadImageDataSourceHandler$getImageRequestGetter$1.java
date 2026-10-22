package com.bytedance.android.ec.core.imagex.opt;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.FirstAvailableDataSourceSupplier;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.imagepipeline.request.ImageRequest;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/facebook/imagepipeline/request/ImageRequest;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class AsyncLoadImage$AsyncLoadImageDataSourceHandler$getImageRequestGetter$1 extends Lambda implements Function0<ImageRequest> {
    final /* synthetic */ DataSource $dataSource;

    public AsyncLoadImage$AsyncLoadImageDataSourceHandler$getImageRequestGetter$1(DataSource r100) {
        this.$dataSource = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ImageRequest invoke() {
        DataSource r100 = this.$dataSource;
        Object r101 = null;
        if ((r100 instanceof FirstAvailableDataSourceSupplier.FirstAvailableDataSource) == false) goto L12;
        Supplier r102 = ((FirstAvailableDataSourceSupplier.FirstAvailableDataSource) r100).getCurrentSupplier();
        if ((r102 instanceof AbstractDraweeControllerBuilder.CustomSupplier) == false) goto L13;
        Object r103 = ((AbstractDraweeControllerBuilder.CustomSupplier) r102).getRequest();
        if ((r103 instanceof ImageRequest) == false) goto L11;
        r101 = r103;
    L11:
        return (ImageRequest) r101;
    L13:
        return null;
    L12:
        return null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ImageRequest invoke() {
        return invoke();
    }
}
