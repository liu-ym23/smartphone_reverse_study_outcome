package com.bytedance.android.shopping.cache.typecache;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.b;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/b;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Landroid/view/View;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class SimpleDraweeViewCacheKt$cacheSimpleDraweeView$1 extends Lambda implements Function1<View, Boolean> {
    public static final SimpleDraweeViewCacheKt$cacheSimpleDraweeView$1 INSTANCE = null;

    static {
        INSTANCE = new SimpleDraweeViewCacheKt$cacheSimpleDraweeView$1();
    }

    public SimpleDraweeViewCacheKt$cacheSimpleDraweeView$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(View r100) {
        return Boolean.valueOf(invoke2(r100));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(View r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        return r100 instanceof b;
    }
}
