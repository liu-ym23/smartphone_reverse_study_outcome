package com.stepos.ailauncher.chat.media;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.chat.media.ScreenshotOverlayTracker", f = "ScreenshotOverlayTracker.kt", l = {202}, m = "drainRefresh", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ScreenshotOverlayTracker$drainRefresh$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ScreenshotOverlayTracker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenshotOverlayTracker$drainRefresh$1(ScreenshotOverlayTracker screenshotOverlayTracker, InterfaceC4014c<? super ScreenshotOverlayTracker$drainRefresh$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = screenshotOverlayTracker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.r(null, 0, this);
    }
}
