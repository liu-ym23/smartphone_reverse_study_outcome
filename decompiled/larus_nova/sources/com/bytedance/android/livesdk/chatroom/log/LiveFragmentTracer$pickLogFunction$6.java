package com.bytedance.android.livesdk.chatroom.log;

import com.bytedance.android.live.core.log.g;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "p1", "", "kotlin.jvm.PlatformType", "p2", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class LiveFragmentTracer$pickLogFunction$6 extends FunctionReferenceImpl implements Function2<String, String, Unit> {
    public LiveFragmentTracer$pickLogFunction$6(b0 r100) {
        super(2, r100, b0.class, "e", "e(Ljava/lang/String;Ljava/lang/String;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100, String r101) {
        ((b0) this.receiver).getClass();
        g.c(r100, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String r100, String r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
