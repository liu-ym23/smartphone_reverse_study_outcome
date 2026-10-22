package com.bytedance.android.gamecp.business.compress;

import com.bytedance.android.gamecp.common.utils.ToastUtil;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class AirCompressManager$showToast$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $gameName;
    final /* synthetic */ String $toastText;

    public AirCompressManager$showToast$1(String r100, String r101) {
        this.$gameName = r100;
        this.$toastText = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ToastUtil.b(this.$gameName + ' ' + this.$toastText, 1);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
