package com.bytedance.android.live.soloktv.util;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
final class VideoPublishUtil$saveDraft$1$onDraftSaveFailed$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ t this$0;

    public VideoPublishUtil$saveDraft$1$onDraftSaveFailed$1(t r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.f101647a.invoke(Boolean.FALSE, "cancel download", "close");
        String r100 = rm3.c.f538539a;
        rm3.c.f(this.this$0.f101648b, R.string.ttlive_solo_ktv_save_draft_failed, false, 28);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
