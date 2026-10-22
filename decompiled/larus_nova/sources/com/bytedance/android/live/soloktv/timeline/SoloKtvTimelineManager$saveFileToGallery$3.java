package com.bytedance.android.live.soloktv.timeline;

import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
final class SoloKtvTimelineManager$saveFileToGallery$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ njc.a $callbackHandlerProxy;
    final /* synthetic */ BPEAException $e;

    public SoloKtvTimelineManager$saveFileToGallery$3(njc.a r100, BPEAException r101) {
        this.$callbackHandlerProxy = r100;
        this.$e = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        njc.a r100 = this.$callbackHandlerProxy;
        if (r100 == null) goto L6;
        r100.a(0, "BPEAException " + this.$e.getErrorMsg(), this.$e);
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
