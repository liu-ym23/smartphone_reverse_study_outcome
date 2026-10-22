package com.bytedance.android.live.messagewindow.preview.widget;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import o70.b;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lo70/b;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lo70/b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class PreviewMsgWinBottomRightWidget$onLoad$5$1 extends FunctionReferenceImpl implements Function1<b, Unit> {
    public PreviewMsgWinBottomRightWidget$onLoad$5$1(PreviewMsgWinBottomRightWidget r100) {
        super(1, r100, PreviewMsgWinBottomRightWidget.class, "onEvent", "onEvent(Lcom/bytedance/android/live/core/tetris/layer/core/event/LayerEvent;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(b r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        ((PreviewMsgWinBottomRightWidget) this.receiver).onEvent(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(b r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
