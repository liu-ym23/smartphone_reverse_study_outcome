package com.stepos.ailauncher.chat.media;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.media.ScreenshotOverlayTracker$requestRefresh$1$1", f = "ScreenshotOverlayTracker.kt", l = {153}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ScreenshotOverlayTracker$requestRefresh$1$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ int $epoch;
    final /* synthetic */ String $from;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenshotOverlayTracker$requestRefresh$1$1(String str, int i10, InterfaceC4014c<? super ScreenshotOverlayTracker$requestRefresh$1$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$from = str;
        this.$epoch = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ScreenshotOverlayTracker$requestRefresh$1$1(this.$from, this.$epoch, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((ScreenshotOverlayTracker$requestRefresh$1$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            ScreenshotOverlayTracker screenshotOverlayTracker = ScreenshotOverlayTracker.INSTANCE;
            String str = this.$from;
            int i11 = this.$epoch;
            this.label = 1;
            if (screenshotOverlayTracker.r(str, i11, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return t.f7040a;
    }
}
