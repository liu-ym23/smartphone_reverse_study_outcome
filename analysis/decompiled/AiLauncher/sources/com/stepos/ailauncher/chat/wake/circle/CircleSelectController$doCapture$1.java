package com.stepos.ailauncher.chat.wake.circle;

import Ua.M;
import android.graphics.RectF;
import android.net.Uri;
import android.widget.Toast;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.view.BaseInputView;
import com.stepos.ailauncher.chat.wake.circle.CircleSelectController$doCapture$1;
import com.stepos.ailauncher.screenshot.a;
import com.stepos.picker.screenperception.ScreenRegion;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.Arrays;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.N;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.wake.circle.CircleSelectController$doCapture$1", f = "CircleSelectController.kt", l = {475}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class CircleSelectController$doCapture$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ RectF $rect;
    final /* synthetic */ ScreenRegion $region;
    final /* synthetic */ int $requestId;
    final /* synthetic */ long $screenshotRound;
    int label;
    final /* synthetic */ CircleSelectController this$0;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/stepos/ailauncher/screenshot/a;", "event", "LY8/t;", "<anonymous>", "(Lcom/stepos/ailauncher/screenshot/a;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.chat.wake.circle.CircleSelectController$doCapture$1$1", f = "CircleSelectController.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.chat.wake.circle.CircleSelectController$doCapture$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<com.stepos.ailauncher.screenshot.a, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ RectF $rect;
        final /* synthetic */ int $requestId;
        final /* synthetic */ long $screenshotRound;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ CircleSelectController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i10, CircleSelectController circleSelectController, RectF rectF, long j10, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$requestId = i10;
            this.this$0 = circleSelectController;
            this.$rect = rectF;
            this.$screenshotRound = j10;
        }

        public static final Y8.t n(CircleSelectController circleSelectController, boolean z10) {
            if (z10) {
                circleSelectController.inputView.J8();
                circleSelectController.U0();
            } else {
                circleSelectController.inputView.L8();
            }
            return Y8.t.f7040a;
        }

        public static final void y(CircleSelectController circleSelectController, int i10) {
            if (circleSelectController.H0()) {
                kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
                String str = String.format("requestCapture #%d: post-inject overlay bounds update", Arrays.copyOf(new Object[]{Integer.valueOf(i10)}, 1));
                kotlin.jvm.internal.p.h(str, "format(...)");
                C4148a.d("CircleSelect", str, false, 4, null);
                circleSelectController.b1();
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$requestId, this.this$0, this.$rect, this.$screenshotRound, interfaceC4014c);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // p9.p
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
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
                kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
                a.Status status = (a.Status) aVar;
                String str = String.format("requestCapture #%d: received status=%s (%d)", Arrays.copyOf(new Object[]{C4109a.f(this.$requestId), com.stepos.ailauncher.screenshot.f.INSTANCE.b(status.getStatus()), C4109a.f(status.getStatus())}, 3));
                kotlin.jvm.internal.p.h(str, "format(...)");
                C4148a.d("CircleSelect", str, false, 4, null);
                if (status.getStatus() == 2) {
                    String str2 = String.format("requestCapture #%d: permission DENIED by picker", Arrays.copyOf(new Object[]{C4109a.f(this.$requestId)}, 1));
                    kotlin.jvm.internal.p.h(str2, "format(...)");
                    C4148a.u("CircleSelect", str2, false, 4, null);
                }
            } else if (aVar instanceof a.Success) {
                kotlin.jvm.internal.y yVar2 = kotlin.jvm.internal.y.f34840a;
                a.Success success = (a.Success) aVar;
                String str3 = String.format("requestCapture #%d: SUCCESS uri=%s (previous=%s)", Arrays.copyOf(new Object[]{C4109a.f(this.$requestId), success.getUri(), this.this$0.latestCapturedUri}, 3));
                kotlin.jvm.internal.p.h(str3, "format(...)");
                C4148a.d("CircleSelect", str3, false, 4, null);
                this.this$0.latestCapturedUri = success.getUri();
                CircleSelectController circleSelectController = this.this$0;
                circleSelectController.lastCapturedRectPx = circleSelectController.Z0(this.$rect);
                this.this$0.captureInflight = false;
                this.this$0.safetyBlocked = false;
                String str4 = String.format("requestCapture #%d: replacing image in-place", Arrays.copyOf(new Object[]{C4109a.f(this.$requestId)}, 1));
                kotlin.jvm.internal.p.h(str4, "format(...)");
                C4148a.d("CircleSelect", str4, false, 4, null);
                this.this$0.inputView.H5();
                BaseInputView baseInputView = this.this$0.inputView;
                Uri uri = success.getUri();
                long j10 = this.$screenshotRound;
                final CircleSelectController circleSelectController2 = this.this$0;
                baseInputView.X9(uri, j10, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.wake.circle.z
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj2) {
                        return CircleSelectController$doCapture$1.AnonymousClass1.n(circleSelectController2, ((Boolean) obj2).booleanValue());
                    }
                });
                N.a("screen_circle_shot", "circle", kotlin.collections.a.i());
                BaseInputView baseInputView2 = this.this$0.inputView;
                final CircleSelectController circleSelectController3 = this.this$0;
                final int i10 = this.$requestId;
                baseInputView2.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.chat.wake.circle.A
                    @Override // java.lang.Runnable
                    public final void run() {
                        CircleSelectController$doCapture$1.AnonymousClass1.y(circleSelectController3, i10);
                    }
                }, 400L);
                this.this$0.I0();
            } else {
                if (!(aVar instanceof a.Failure)) {
                    throw new NoWhenBranchMatchedException();
                }
                kotlin.jvm.internal.y yVar3 = kotlin.jvm.internal.y.f34840a;
                a.Failure failure = (a.Failure) aVar;
                String str5 = String.format("requestCapture #%d: FAILED code=%d msg=%s", Arrays.copyOf(new Object[]{C4109a.f(this.$requestId), C4109a.f(failure.getCode()), failure.getMessage()}, 3));
                kotlin.jvm.internal.p.h(str5, "format(...)");
                C4148a.u("CircleSelect", str5, false, 4, null);
                this.this$0.captureInflight = false;
                this.this$0.inputView.L8();
                Toast.makeText(this.this$0.context, R$string.screenshot_failed, 0).show();
                this.this$0.I0();
            }
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleSelectController$doCapture$1(CircleSelectController circleSelectController, ScreenRegion screenRegion, int i10, RectF rectF, long j10, InterfaceC4014c<? super CircleSelectController$doCapture$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = circleSelectController;
        this.$region = screenRegion;
        this.$requestId = i10;
        this.$rect = rectF;
        this.$screenshotRound = j10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new CircleSelectController$doCapture$1(this.this$0, this.$region, this.$requestId, this.$rect, this.$screenshotRound, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((CircleSelectController$doCapture$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Xa.b<com.stepos.ailauncher.screenshot.a> bVarG = this.this$0.screenshotClient.g(this.$region);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$requestId, this.this$0, this.$rect, this.$screenshotRound, null);
            this.label = 1;
            if (Xa.d.j(bVarG, anonymousClass1, this) == objG) {
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
