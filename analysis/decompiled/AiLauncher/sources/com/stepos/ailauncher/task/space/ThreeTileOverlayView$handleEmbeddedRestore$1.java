package com.stepos.ailauncher.task.space;

import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.ailauncher.chat.view.HomeChatPagerView;
import com.stepos.ailauncher.chat.wake.RestoreSessionResolver;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.space.ThreeTileOverlayView$handleEmbeddedRestore$1", f = "ThreeTileOverlayView.kt", l = {2066}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ThreeTileOverlayView$handleEmbeddedRestore$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ SessionHandler $handler;
    final /* synthetic */ int $seq;
    final /* synthetic */ String $sessionId;
    int label;
    final /* synthetic */ ThreeTileOverlayView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreeTileOverlayView$handleEmbeddedRestore$1(String str, SessionHandler sessionHandler, int i10, ThreeTileOverlayView threeTileOverlayView, InterfaceC4014c<? super ThreeTileOverlayView$handleEmbeddedRestore$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$sessionId = str;
        this.$handler = sessionHandler;
        this.$seq = i10;
        this.this$0 = threeTileOverlayView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ThreeTileOverlayView$handleEmbeddedRestore$1(this.$sessionId, this.$handler, this.$seq, this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ThreeTileOverlayView$handleEmbeddedRestore$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        HomeChatPagerView homeChatPagerView;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            RestoreSessionResolver restoreSessionResolver = RestoreSessionResolver.INSTANCE;
            String str = this.$sessionId;
            SessionHandler sessionHandler = this.$handler;
            this.label = 1;
            obj = restoreSessionResolver.a(str, sessionHandler, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        String str2 = (String) obj;
        if (this.$seq != this.this$0.restoreSeq) {
            return Y8.t.f7040a;
        }
        if (str2 != null && str2.length() != 0 && !kotlin.jvm.internal.p.d(str2, this.$sessionId) && (homeChatPagerView = this.this$0.pagerView) != null) {
            homeChatPagerView.i0(str2);
        }
        return Y8.t.f7040a;
    }
}
