package com.bytedance.android.shopping.sku.common.utils;

import android.content.Context;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ui.ec.widget.tools.ECToastUtils;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class SkuCommonToast$showToast$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $longLength;
    final /* synthetic */ String $str;

    public SkuCommonToast$showToast$1(Context r100, String r101, boolean r102) {
        this.$context = r100;
        this.$str = r101;
        this.$longLength = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ECToastUtils r100 = ECToastUtils.INSTANCE;
        Context r101 = this.$context;
        if (r101 != null) goto L5;
        r101 = ECAppInfoService.f48114e.getCurrentActivity();
    L5:
        String r102 = this.$str;
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        r100.showToast(r101, r102, Boolean.valueOf(!this.$longLength));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
