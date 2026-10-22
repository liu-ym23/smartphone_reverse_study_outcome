package androidx.camera.camera2.impl;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.camera.camera2.impl.CapturePipelineImpl", f = "CapturePipeline.kt", l = {544, 871, 551, 556}, m = "invokeScreenFlashPreCaptureTasks", v = 1)
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CapturePipelineImpl$invokeScreenFlashPreCaptureTasks$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public int f9650a;

    /* renamed from: b, reason: collision with root package name */
    public Object f9651b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f9652c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ CapturePipelineImpl f9653d;

    /* renamed from: e, reason: collision with root package name */
    public int f9654e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CapturePipelineImpl$invokeScreenFlashPreCaptureTasks$1(CapturePipelineImpl capturePipelineImpl, InterfaceC4014c<? super CapturePipelineImpl$invokeScreenFlashPreCaptureTasks$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f9653d = capturePipelineImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f9652c = obj;
        this.f9654e |= Integer.MIN_VALUE;
        return this.f9653d.N(0, this);
    }
}
