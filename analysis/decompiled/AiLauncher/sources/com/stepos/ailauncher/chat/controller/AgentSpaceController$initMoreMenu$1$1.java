package com.stepos.ailauncher.chat.controller;

import Z8.C1173v;
import android.view.View;
import com.amap.api.services.core.AMapException;
import com.stepos.ailauncher.chat.view.ChatView;
import com.stepos.ailauncher.chat.view.SessionArtifactSource;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.controller.AgentSpaceController$initMoreMenu$1$1", f = "AgentSpaceController.kt", l = {AMapException.CODE_AMAP_CLIENT_OVER_PASSAREA_ITEM_POINT_COUNT_EXCEPTION}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentSpaceController$initMoreMenu$1$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ View $anchor;
    Object L$0;
    int label;
    final /* synthetic */ AgentSpaceController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentSpaceController$initMoreMenu$1$1(AgentSpaceController agentSpaceController, View view, InterfaceC4014c<? super AgentSpaceController$initMoreMenu$1$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = agentSpaceController;
        this.$anchor = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentSpaceController$initMoreMenu$1$1(this.this$0, this.$anchor, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentSpaceController$initMoreMenu$1$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        SessionArtifactSource.Result result;
        Object objG = C4063a.g();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                ChatView chatView = this.this$0.chatView;
                List<String> listP1 = chatView != null ? chatView.P1() : null;
                if (listP1 == null) {
                    listP1 = C1173v.m();
                }
                SessionArtifactSource sessionArtifactSource = SessionArtifactSource.INSTANCE;
                this.L$0 = g9.h.a(listP1);
                this.label = 1;
                obj = sessionArtifactSource.c(listP1, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            result = (SessionArtifactSource.Result) obj;
        } catch (CancellationException e10) {
            throw e10;
        } catch (Exception e11) {
            C4148a.t("AILauncher-AgentSpaceController", "load session artifacts failed", e11, false, 8, null);
            result = new SessionArtifactSource.Result(C1173v.m(), null);
        }
        if (!this.this$0.isPageResumed) {
            C4148a.d("AILauncher-AgentSpaceController", "skip more menu: page not resumed", false, 4, null);
            return Y8.t.f7040a;
        }
        if (!this.$anchor.isAttachedToWindow() || this.$anchor.getWindowToken() == null) {
            C4148a.d("AILauncher-AgentSpaceController", "skip more menu: anchor not attached", false, 4, null);
            return Y8.t.f7040a;
        }
        this.this$0.moreMenuPopup.g(this.$anchor, result.b(), result.getFileTree());
        return Y8.t.f7040a;
    }
}
