package com.bytedance.android.ec.sdk.initalizer;

import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ECSdkInitializer$initWithLoading$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ Function0 $res;
    final /* synthetic */ pl.a $snapshot;

    public ECSdkInitializer$initWithLoading$1(pl.a r100, Function0 r101) {
        this.$snapshot = r100;
        this.$res = r101;
        super(1);
    }

    public final void invoke(boolean r100) {
        boolean r101 = ECServiceManager.f42805a;
        hj.c r102 = (hj.c) ECServiceManager.b(hj.c.class);
        if (r102 == null) goto L5;
        r102.e();
    L5:
        if (r100 == false) goto L8;
        this.$res.invoke();
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean r100) {
        invoke(r100.booleanValue());
        return Unit.INSTANCE;
    }
}
