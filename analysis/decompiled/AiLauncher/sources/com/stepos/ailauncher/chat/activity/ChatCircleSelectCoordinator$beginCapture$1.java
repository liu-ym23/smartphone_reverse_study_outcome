package com.stepos.ailauncher.chat.activity;

import com.stepos.ailauncher.chat.wake.circle.CircleSelectController;
import com.stepos.ailauncher.screenshot.ScreenshotClient;
import com.stepos.ailauncher.screenshot.a;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.activity.ChatCircleSelectCoordinator$beginCapture$1", f = "ChatCircleSelectCoordinator.kt", l = {66}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ChatCircleSelectCoordinator$beginCapture$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ ScreenshotClient $client;
    final /* synthetic */ I0 $gate;
    final /* synthetic */ long $screenshotRound;
    int label;
    final /* synthetic */ ChatCircleSelectCoordinator this$0;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/stepos/ailauncher/screenshot/a;", "event", "LY8/t;", "<anonymous>", "(Lcom/stepos/ailauncher/screenshot/a;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.chat.activity.ChatCircleSelectCoordinator$beginCapture$1$1", f = "ChatCircleSelectCoordinator.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.chat.activity.ChatCircleSelectCoordinator$beginCapture$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<com.stepos.ailauncher.screenshot.a, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ I0 $gate;
        final /* synthetic */ long $screenshotRound;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ChatCircleSelectCoordinator this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(I0 i02, ChatCircleSelectCoordinator chatCircleSelectCoordinator, long j10, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$gate = i02;
            this.this$0 = chatCircleSelectCoordinator;
            this.$screenshotRound = j10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$gate, this.this$0, this.$screenshotRound, interfaceC4014c);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // p9.p
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(com.stepos.ailauncher.screenshot.a aVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass1) create(aVar, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            com.stepos.ailauncher.screenshot.a aVar = (com.stepos.ailauncher.screenshot.a) this.L$0;
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (aVar instanceof a.Status) {
                a.Status status = (a.Status) aVar;
                C4148a.d("ChatCircleSelect", "capture status=" + com.stepos.ailauncher.screenshot.f.INSTANCE.b(status.getStatus()), false, 4, null);
                if (this.$gate.d(status.getStatus())) {
                    this.this$0.h();
                }
                if (status.getStatus() == 2) {
                    this.this$0.p();
                }
            } else if (aVar instanceof a.Success) {
                a.Success success = (a.Success) aVar;
                C4148a.d("ChatCircleSelect", "capture success uri=" + success.getUri(), false, 4, null);
                if (this.$gate.c()) {
                    this.this$0.h();
                }
                if (this.this$0.o() && !CircleSelectController.INSTANCE.e() && this.this$0.activity.j6()) {
                    this.this$0.q(success.getUri(), this.$screenshotRound);
                }
            } else {
                if (!(aVar instanceof a.Failure)) {
                    throw new NoWhenBranchMatchedException();
                }
                a.Failure failure = (a.Failure) aVar;
                C4148a.u("ChatCircleSelect", "capture failed code=" + failure.getCode() + " msg=" + failure.getMessage(), false, 4, null);
                this.this$0.p();
            }
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatCircleSelectCoordinator$beginCapture$1(ScreenshotClient screenshotClient, I0 i02, ChatCircleSelectCoordinator chatCircleSelectCoordinator, long j10, InterfaceC4014c<? super ChatCircleSelectCoordinator$beginCapture$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$client = screenshotClient;
        this.$gate = i02;
        this.this$0 = chatCircleSelectCoordinator;
        this.$screenshotRound = j10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ChatCircleSelectCoordinator$beginCapture$1(this.$client, this.$gate, this.this$0, this.$screenshotRound, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ChatCircleSelectCoordinator$beginCapture$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Xa.b<com.stepos.ailauncher.screenshot.a> bVarF = this.$client.f();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$gate, this.this$0, this.$screenshotRound, null);
            this.label = 1;
            if (Xa.d.j(bVarF, anonymousClass1, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return Y8.t.f7040a;
    }
}
