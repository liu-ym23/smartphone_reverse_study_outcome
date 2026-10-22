package com.bytedance.android.livesdk.interactivity.barrage.view;

import android.graphics.Canvas;
import com.bytedance.live.artist.render.RenderRequest;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final class CarnivalRenderEngineView$render$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Canvas $canvas;
    final /* synthetic */ RenderRequest $request;
    final /* synthetic */ CarnivalRenderEngineView this$0;

    public CarnivalRenderEngineView$render$1(CarnivalRenderEngineView r100, RenderRequest r101, Canvas r102) {
        this.this$0 = r100;
        this.$request = r101;
        this.$canvas = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$request.a(new AnonymousClass1(this));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
