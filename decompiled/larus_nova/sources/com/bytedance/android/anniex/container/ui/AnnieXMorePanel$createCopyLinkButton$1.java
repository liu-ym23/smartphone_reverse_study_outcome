package com.bytedance.android.anniex.container.ui;

import android.content.Context;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 48)
final class AnnieXMorePanel$createCopyLinkButton$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ia.c $container;
    final /* synthetic */ Context $context;

    public AnnieXMorePanel$createCopyLinkButton$1(ia.c r100, Context r101) {
        this.$container = r100;
        this.$context = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        s26.d r100 = s26.d.f540305c;
        if (((com.bytedance.android.anniex.base.service.a) s26.d.f540305c.d(this.$container.getBid(), com.bytedance.android.anniex.base.service.a.class)) == null) goto L6;
        Context r101 = this.$context;
        la.a r102 = new la.a(0);
        r102.f508146a = this.$container.getCurrentUrl();
        com.bytedance.android.anniex.base.service.a.G0(r101, r102);
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
