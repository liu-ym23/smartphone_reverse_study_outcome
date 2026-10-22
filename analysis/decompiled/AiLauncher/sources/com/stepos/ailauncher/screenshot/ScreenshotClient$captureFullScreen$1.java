package com.stepos.ailauncher.screenshot;

import Wa.s;
import Y8.t;
import android.net.Uri;
import com.stepos.ailauncher.screenshot.a;
import com.stepos.picker.screenperception.IScreenshotCallback;
import com.stepos.picker.screenperception.IScreenshotService;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import g9.h;
import h8.C4148a;
import java.util.Arrays;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.y;
import kotlinx.coroutines.channels.ProduceKt;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LWa/p;", "Lcom/stepos/ailauncher/screenshot/a;", "LY8/t;", "<anonymous>", "(LWa/p;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.screenshot.ScreenshotClient$captureFullScreen$1", f = "ScreenshotClient.kt", l = {204}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ScreenshotClient$captureFullScreen$1 extends SuspendLambda implements p<Wa.p<? super a>, InterfaceC4014c<? super t>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ScreenshotClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenshotClient$captureFullScreen$1(ScreenshotClient screenshotClient, InterfaceC4014c<? super ScreenshotClient$captureFullScreen$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = screenshotClient;
    }

    public static final t i(final Wa.p pVar, final ScreenshotClient screenshotClient, IScreenshotService iScreenshotService) {
        if (iScreenshotService == null) {
            C4148a.h("ScreenshotClient", "captureFullScreen: service bind failed", false, 4, null);
            pVar.mo0trySendJP2dKIU(new a.Failure(1003, "bind failed"));
            s.a(pVar, null, 1, null);
            return t.f7040a;
        }
        IScreenshotCallback.Stub stub = new IScreenshotCallback.Stub() { // from class: com.stepos.ailauncher.screenshot.ScreenshotClient$captureFullScreen$1$1$cb$1
            @Override // com.stepos.picker.screenperception.IScreenshotCallback
            public void onCaptured(Uri imageUri) {
                kotlin.jvm.internal.p.i(imageUri, "imageUri");
                f.INSTANCE.c(1);
                y yVar = y.f34840a;
                String str = String.format("captureFullScreen callback onCaptured: uri=%s", Arrays.copyOf(new Object[]{imageUri}, 1));
                kotlin.jvm.internal.p.h(str, "format(...)");
                C4148a.d("ScreenshotClient", str, false, 4, null);
                pVar.mo0trySendJP2dKIU(new a.Success(imageUri));
                s.a(pVar, null, 1, null);
            }

            @Override // com.stepos.picker.screenperception.IScreenshotCallback
            public void onFailed(int errCode, String message) {
                f.INSTANCE.c(0);
                y yVar = y.f34840a;
                String str = String.format("captureFullScreen callback onFailed: errCode=%d, msg=%s", Arrays.copyOf(new Object[]{Integer.valueOf(errCode), message}, 2));
                kotlin.jvm.internal.p.h(str, "format(...)");
                C4148a.u("ScreenshotClient", str, false, 4, null);
                Wa.p<a> pVar2 = pVar;
                if (message == null) {
                    message = "";
                }
                pVar2.mo0trySendJP2dKIU(new a.Failure(errCode, message));
                s.a(pVar, null, 1, null);
            }

            @Override // com.stepos.picker.screenperception.IScreenshotCallback
            public void onTrackEvent(String event, String paramsJson) {
                kotlin.jvm.internal.p.i(event, "event");
                kotlin.jvm.internal.p.i(paramsJson, "paramsJson");
                y yVar = y.f34840a;
                String str = String.format("captureFullScreen callback onTrackEvent: event=%s, paramsJson=%s", Arrays.copyOf(new Object[]{event, paramsJson}, 2));
                kotlin.jvm.internal.p.h(str, "format(...)");
                C4148a.u("ScreenshotClient", str, false, 4, null);
                screenshotClient.j(event, paramsJson);
            }
        };
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            int iCaptureFullScreen = iScreenshotService.captureFullScreen(stub);
            f fVar = f.INSTANCE;
            fVar.c(iCaptureFullScreen);
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            y yVar = y.f34840a;
            String str = String.format("captureFullScreen: remote call returned status=%s (%d) in %dms", Arrays.copyOf(new Object[]{fVar.b(iCaptureFullScreen), Integer.valueOf(iCaptureFullScreen), Long.valueOf(jCurrentTimeMillis2)}, 3));
            kotlin.jvm.internal.p.h(str, "format(...)");
            C4148a.d("ScreenshotClient", str, false, 4, null);
            pVar.mo0trySendJP2dKIU(new a.Status(iCaptureFullScreen));
        } catch (Exception e10) {
            C4148a.g("ScreenshotClient", "captureFullScreen: remote call threw exception", e10, false, 8, null);
            String message = e10.getMessage();
            if (message == null) {
                message = "";
            }
            pVar.mo0trySendJP2dKIU(new a.Failure(1003, message));
            s.a(pVar, null, 1, null);
        }
        return t.f7040a;
    }

    public static final t n() {
        C4148a.d("ScreenshotClient", "captureFullScreen: flow closed", false, 4, null);
        return t.f7040a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        ScreenshotClient$captureFullScreen$1 screenshotClient$captureFullScreen$1 = new ScreenshotClient$captureFullScreen$1(this.this$0, interfaceC4014c);
        screenshotClient$captureFullScreen$1.L$0 = obj;
        return screenshotClient$captureFullScreen$1;
    }

    @Override // p9.p
    public final Object invoke(Wa.p<? super a> pVar, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((ScreenshotClient$captureFullScreen$1) create(pVar, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        final Wa.p pVar = (Wa.p) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            C4148a.d("ScreenshotClient", "captureFullScreen: requesting", false, 4, null);
            final ScreenshotClient screenshotClient = this.this$0;
            screenshotClient.h(new InterfaceC5074l() { // from class: com.stepos.ailauncher.screenshot.b
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return ScreenshotClient$captureFullScreen$1.i(pVar, screenshotClient, (IScreenshotService) obj2);
                }
            });
            InterfaceC5063a interfaceC5063a = new InterfaceC5063a() { // from class: com.stepos.ailauncher.screenshot.c
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return ScreenshotClient$captureFullScreen$1.n();
                }
            };
            this.L$0 = h.a(pVar);
            this.label = 1;
            if (ProduceKt.a(pVar, interfaceC5063a, this) == objG) {
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
