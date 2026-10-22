package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.featureplugin;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import u22.e;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lu22/e;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lu22/e;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class AudioMessagePlayPlugin$registerEvents$2 extends FunctionReferenceImpl implements Function1<e, Unit> {
    public AudioMessagePlayPlugin$registerEvents$2(AudioMessagePlayPlugin r100) {
        super(1, r100, AudioMessagePlayPlugin.class, "onEvent", "onEvent(Lcom/bytedance/android/livesdk/interactivity/api/comment/event/AudioCommentStopPlayEvent;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(e r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        ((AudioMessagePlayPlugin) this.receiver).onEvent(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(e r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
