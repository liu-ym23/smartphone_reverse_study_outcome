package com.bytedance.android.livesdk.feedback.relax;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<no name provided>", "", "value", "", "key", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class RTSFeedbackUtils$Companion$addParams$1 extends Lambda implements Function2<Object, String, Unit> {
    public static final RTSFeedbackUtils$Companion$addParams$1 INSTANCE = null;

    static {
        INSTANCE = new RTSFeedbackUtils$Companion$addParams$1();
    }

    public RTSFeedbackUtils$Companion$addParams$1() {
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Object r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "value");
        Intrinsics.checkNotNullParameter(r101, "key");
        RTSFeedbackUtils.f124765b.getClass();
        Map<String, String> r102 = RTSFeedbackUtils.f124764a;
        com.bytedance.rts.foundation.m.e(r102, r101, (String) r100);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Object r100, String r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
