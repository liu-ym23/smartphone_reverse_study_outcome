package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.utils;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a<\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00022!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"withVisibilityListener", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/utils/ViewVisibilityProxy;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "onVisibilityChanged", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "newVisibility", "", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/utils/ViewVisibilityProxy;", "bdpay-front-counter_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ViewVisibilityProxyKt {
    public static final <T extends View> ViewVisibilityProxy withVisibilityListener(T r100, Function1<? super Integer, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "onVisibilityChanged");
        return new ViewVisibilityProxy(r100, r101);
    }
}
