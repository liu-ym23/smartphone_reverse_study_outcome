package com.bytedance.android.live.liveinteract.voicechat.radio;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"startSubtitleRTC", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
final class RadioSubtitleComponent$startSubTitleWithDependence$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ com.bytedance.android.live.liveinteract.voicechat.subtitle.a $interceptCallback;
    final /* synthetic */ m this$0;

    public RadioSubtitleComponent$startSubTitleWithDependence$1(m r100, com.bytedance.android.live.liveinteract.voicechat.subtitle.a r101) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        m r100 = this.this$0;
        int r101 = m.f80567j;
        r100.getClass();
        if (gh0.a.d() == false) goto L6;
        m.h(this.this$0);
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
