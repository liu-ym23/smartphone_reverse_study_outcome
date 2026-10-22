package com.stepos.ailauncher.chat.media;

import Ua.M;
import Y8.t;
import com.stepos.ailauncher.chat.media.ScreenshotOverlayTracker;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)Ljava/lang/Object;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.media.ScreenshotOverlayTracker$drainRefresh$2", f = "ScreenshotOverlayTracker.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ScreenshotOverlayTracker$drainRefresh$2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Object>, Object> {
    final /* synthetic */ Ref$IntRef $epoch;
    final /* synthetic */ Ref$ObjectRef<String> $from;
    final /* synthetic */ ScreenshotOverlayTracker.LatestImage $shot;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenshotOverlayTracker$drainRefresh$2(Ref$ObjectRef<String> ref$ObjectRef, ScreenshotOverlayTracker.LatestImage latestImage, Ref$IntRef ref$IntRef, InterfaceC4014c<? super ScreenshotOverlayTracker$drainRefresh$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$from = ref$ObjectRef;
        this.$shot = latestImage;
        this.$epoch = ref$IntRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ScreenshotOverlayTracker$drainRefresh$2(this.$from, this.$shot, this.$epoch, interfaceC4014c);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(M m10, InterfaceC4014c<Object> interfaceC4014c) {
        return ((ScreenshotOverlayTracker$drainRefresh$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        boolean z10;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        Object obj2 = ScreenshotOverlayTracker.refreshLock;
        Ref$IntRef ref$IntRef = this.$epoch;
        synchronized (obj2) {
            z10 = ref$IntRef.f34818a == ScreenshotOverlayTracker.refreshEpoch;
        }
        if (z10) {
            ScreenshotOverlayTracker.INSTANCE.m(this.$shot, this.$from.f34820a);
            return t.f7040a;
        }
        return C4109a.f(C4148a.k("ScreenshotOverlay", "drop stale refresh from=" + ((Object) this.$from.f34820a), false, 4, null));
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super Object> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<Object>) interfaceC4014c);
    }
}
