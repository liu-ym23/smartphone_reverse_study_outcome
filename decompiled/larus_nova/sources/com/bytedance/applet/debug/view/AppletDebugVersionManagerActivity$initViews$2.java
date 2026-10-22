package com.bytedance.applet.debug.view;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class AppletDebugVersionManagerActivity$initViews$2 extends FunctionReferenceImpl implements Function0<Unit> {
    public AppletDebugVersionManagerActivity$initViews$2(Object r100) {
        super(0, r100, AppletDebugVersionManagerActivity.class, "updateConfirmButtonState", "updateConfirmButtonState()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        AppletDebugVersionManagerActivity r100 = (AppletDebugVersionManagerActivity) this.receiver;
        int r101 = AppletDebugVersionManagerActivity.f191605q;
        r100.S1();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
