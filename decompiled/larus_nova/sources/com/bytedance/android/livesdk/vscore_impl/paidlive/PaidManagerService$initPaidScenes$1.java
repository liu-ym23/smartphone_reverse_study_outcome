package com.bytedance.android.livesdk.vscore_impl.paidlive;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_api/paidlive/e;", "scene", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/vscore_api/paidlive/e;)Lcom/bytedance/android/livesdk/vscore_api/paidlive/e;", "onInit"}, k = 3, mv = {1, 4, 3})
public final class PaidManagerService$initPaidScenes$1 extends Lambda implements Function1<com.bytedance.android.livesdk.vscore_api.paidlive.e, com.bytedance.android.livesdk.vscore_api.paidlive.e> {
    public static final PaidManagerService$initPaidScenes$1 INSTANCE = null;

    static {
        INSTANCE = new PaidManagerService$initPaidScenes$1();
    }

    public PaidManagerService$initPaidScenes$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final com.bytedance.android.livesdk.vscore_api.paidlive.e invoke2(com.bytedance.android.livesdk.vscore_api.paidlive.e r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        r100.onInit();
        return r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ com.bytedance.android.livesdk.vscore_api.paidlive.e invoke(com.bytedance.android.livesdk.vscore_api.paidlive.e r100) {
        return invoke2(r100);
    }
}
