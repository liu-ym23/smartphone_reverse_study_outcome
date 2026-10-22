package com.bytedance.applet.block.permissionapplycard.view;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class PermissionApplyCardView$bind$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public PermissionApplyCardView$bind$1(Object r100) {
        super(0, r100, mi8.e.class, "onAllow", "onAllow()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((mi8.e) this.receiver).a();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
