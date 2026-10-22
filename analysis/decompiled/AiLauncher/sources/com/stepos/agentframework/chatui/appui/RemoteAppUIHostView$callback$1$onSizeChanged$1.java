package com.stepos.agentframework.chatui.appui;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatui.appui.RemoteAppUIHostView$callback$1$onSizeChanged$1", f = "RemoteAppUIHostView.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class RemoteAppUIHostView$callback$1$onSizeChanged$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ int $height;
    final /* synthetic */ int $width;
    int label;
    final /* synthetic */ RemoteAppUIHostView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteAppUIHostView$callback$1$onSizeChanged$1(RemoteAppUIHostView remoteAppUIHostView, int i10, int i11, InterfaceC4014c<? super RemoteAppUIHostView$callback$1$onSizeChanged$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = remoteAppUIHostView;
        this.$width = i10;
        this.$height = i11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new RemoteAppUIHostView$callback$1$onSizeChanged$1(this.this$0, this.$width, this.$height, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((RemoteAppUIHostView$callback$1$onSizeChanged$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        com.stepos.agentframework.chatui.appui.taskrobot.b surfaceView = this.this$0.getSurfaceView();
        if (surfaceView != null) {
            surfaceView.c(this.$width, this.$height);
        }
        return t.f7040a;
    }
}
