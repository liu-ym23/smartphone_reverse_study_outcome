package com.bytedance.android.anniex.container.ui;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 48)
final class AnnieXMorePanel$createOpenBrowserButton$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ia.c $container;
    final /* synthetic */ Context $context;

    public AnnieXMorePanel$createOpenBrowserButton$1(ia.c r100, Context r101) {
        this.$container = r100;
        this.$context = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Intent r100 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(this.$container.getCurrentUrl()));
        r100.addFlags(268435456);
        r100.addCategory("android.intent.category.BROWSABLE");
        ResolveInfo r101 = this.$context.getPackageManager().resolveActivity(r100, 65536);
        if (r101 == null) goto L6;
        Context r102 = this.$context;
        ActivityInfo r103 = r101.activityInfo;
        r100.setClassName(r103.packageName, r103.name);
        r102.startActivity(r100);
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
