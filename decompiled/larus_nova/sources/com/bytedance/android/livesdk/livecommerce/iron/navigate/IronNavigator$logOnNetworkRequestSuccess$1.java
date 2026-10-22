package com.bytedance.android.livesdk.livecommerce.iron.navigate;

import androidx.exifinterface.media.ExifInterface;
import cl.d;
import com.bytedance.android.ec.sdk.helper.k;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class IronNavigator$logOnNetworkRequestSuccess$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $path;
    final /* synthetic */ Object $responseRawData;

    public IronNavigator$logOnNetworkRequestSuccess$1(String r100, Object r101) {
        this.$path = r100;
        this.$responseRawData = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        d r100 = k.a();
        if (r100 == null) goto L6;
        new Pair(this.$path, this.$responseRawData);
        r100.j("response");
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
