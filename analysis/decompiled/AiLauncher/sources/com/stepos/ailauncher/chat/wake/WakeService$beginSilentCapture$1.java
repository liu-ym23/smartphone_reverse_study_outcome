package com.stepos.ailauncher.chat.wake;

import com.stepos.ailauncher.screenshot.ScreenshotClient;
import com.stepos.ailauncher.screenshot.a;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.Arrays;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.wake.WakeService$beginSilentCapture$1", f = "WakeService.kt", l = {2421}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class WakeService$beginSilentCapture$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ ScreenshotClient $client;
    final /* synthetic */ long $screenshotRound;
    int label;
    final /* synthetic */ WakeService this$0;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/stepos/ailauncher/screenshot/a;", "event", "LY8/t;", "<anonymous>", "(Lcom/stepos/ailauncher/screenshot/a;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.chat.wake.WakeService$beginSilentCapture$1$1", f = "WakeService.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.chat.wake.WakeService$beginSilentCapture$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<com.stepos.ailauncher.screenshot.a, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ long $screenshotRound;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ WakeService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(WakeService wakeService, long j10, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.this$0 = wakeService;
            this.$screenshotRound = j10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$screenshotRound, interfaceC4014c);
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
            WakeDialogImpl wakeDialogImpl;
            com.stepos.ailauncher.screenshot.a aVar = (com.stepos.ailauncher.screenshot.a) this.L$0;
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (aVar instanceof a.Status) {
                kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
                a.Status status = (a.Status) aVar;
                String str = String.format("silent capture status=%s (%d)", Arrays.copyOf(new Object[]{com.stepos.ailauncher.screenshot.f.INSTANCE.b(status.getStatus()), C4109a.f(status.getStatus())}, 2));
                kotlin.jvm.internal.p.h(str, "format(...)");
                C4148a.d("WakeService", str, false, 4, null);
                if (status.getStatus() == 3 && (wakeDialogImpl = this.this$0.activeDialog) != null) {
                    wakeDialogImpl.g5();
                }
            } else if (aVar instanceof a.Success) {
                kotlin.jvm.internal.y yVar2 = kotlin.jvm.internal.y.f34840a;
                a.Success success = (a.Success) aVar;
                String str2 = String.format("silent capture success uri=%s", Arrays.copyOf(new Object[]{success.getUri()}, 1));
                kotlin.jvm.internal.p.h(str2, "format(...)");
                C4148a.d("WakeService", str2, false, 4, null);
                WakeDialogImpl wakeDialogImpl2 = this.this$0.activeDialog;
                if (wakeDialogImpl2 != null) {
                    wakeDialogImpl2.i5(success.getUri(), this.$screenshotRound);
                }
                WakeDialogImpl wakeDialogImpl3 = this.this$0.activeDialog;
                if (wakeDialogImpl3 != null) {
                    wakeDialogImpl3.C2();
                }
            } else {
                if (!(aVar instanceof a.Failure)) {
                    throw new NoWhenBranchMatchedException();
                }
                kotlin.jvm.internal.y yVar3 = kotlin.jvm.internal.y.f34840a;
                a.Failure failure = (a.Failure) aVar;
                String str3 = String.format("silent capture failed code=%d msg=%s", Arrays.copyOf(new Object[]{C4109a.f(failure.getCode()), failure.getMessage()}, 2));
                kotlin.jvm.internal.p.h(str3, "format(...)");
                C4148a.u("WakeService", str3, false, 4, null);
                WakeDialogImpl wakeDialogImpl4 = this.this$0.activeDialog;
                if (wakeDialogImpl4 != null) {
                    wakeDialogImpl4.C3();
                }
            }
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WakeService$beginSilentCapture$1(ScreenshotClient screenshotClient, WakeService wakeService, long j10, InterfaceC4014c<? super WakeService$beginSilentCapture$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$client = screenshotClient;
        this.this$0 = wakeService;
        this.$screenshotRound = j10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new WakeService$beginSilentCapture$1(this.$client, this.this$0, this.$screenshotRound, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((WakeService$beginSilentCapture$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Xa.b<com.stepos.ailauncher.screenshot.a> bVarF = this.$client.f();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$screenshotRound, null);
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
