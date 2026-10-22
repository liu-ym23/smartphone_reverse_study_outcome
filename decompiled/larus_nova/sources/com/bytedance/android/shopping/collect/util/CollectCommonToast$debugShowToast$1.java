package com.bytedance.android.shopping.collect.util;

import android.app.Activity;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ui.ec.widget.tools.ECToastUtils;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class CollectCommonToast$debugShowToast$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $str;

    public CollectCommonToast$debugShowToast$1(String r100) {
        this.$str = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ECAppInfoService r100 = ECAppInfoService.f48114e;
        if (r100.i() == false) goto L9;
        ECToastUtils r101 = ECToastUtils.INSTANCE;
        Activity r102 = r100.getCurrentActivity();
        String r103 = this.$str;
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        r101.showToast(r102, r103, Boolean.TRUE);
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
