package com.bytedance.android.livesdk.dslservice.util;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u00012,\u0010\u0002\u001a( \u0007*\u0013\u0018\u00010\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00060\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062,\u0010\b\u001a( \u0007*\u0013\u0018\u00010\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00020\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "p1", "", "Lkotlin/ParameterName;", "name", "p0", "kotlin.jvm.PlatformType", "p2", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class DSLMonitor$logDebugInfo$logFunc$1 extends FunctionReferenceImpl implements Function2<String, String, Unit> {
    public static final DSLMonitor$logDebugInfo$logFunc$1 INSTANCE = null;

    static {
        INSTANCE = new DSLMonitor$logDebugInfo$logFunc$1();
    }

    public DSLMonitor$logDebugInfo$logFunc$1() {
        super(2, ALogger.class, RXScreenCaptureService.KEY_INDEX, "i(Ljava/lang/String;Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String r100, String r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100, String r101) {
        ALogger.i(r100, r101);
    }
}
