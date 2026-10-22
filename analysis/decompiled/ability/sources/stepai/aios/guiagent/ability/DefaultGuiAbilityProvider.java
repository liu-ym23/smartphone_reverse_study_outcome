package stepai.aios.guiagent.ability;

import J7.c;
import N9.j;
import S7.a;
import S7.k;
import android.accessibilityservice.AccessibilityService;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.hardware.HardwareBuffer;
import android.util.Size;
import androidx.annotation.RequiresApi;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.WindowStateInfo;
import com.stepos.taskrobot.llmapi.stepfun.g;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.e;
import m9.C1718k;
import stepai.aios.accessibility.DefaultAccessibilityService;
import ta.b;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0019\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H\u0083@¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\tH\u0096@¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0015R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00120\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lstepai/aios/guiagent/ability/DefaultGuiAbilityProvider;", "Lstepai/aios/guiagent/ability/GuiAbilityProvider;", "Lkotlin/Function0;", "Landroid/util/Size;", "compressSizeProvider", AppAgent.CONSTRUCT, "(LS7/a;)V", "", WindowStateInfo.KEY_DISPLAY_ID, "Landroid/graphics/Bitmap;", "takeScreenshotOnDisplay", "(ILH7/c;)Ljava/lang/Object;", "Lstepai/aios/guiagent/ability/CaptureOptions;", "options", "Lstepai/aios/guiagent/ability/CaptureResult;", "captureScreenResult", "(Lstepai/aios/guiagent/ability/CaptureOptions;LH7/c;)Ljava/lang/Object;", "bitmap", "", "bitmap2Base64", "(Landroid/graphics/Bitmap;LH7/c;)Ljava/lang/Object;", "LS7/a;", "Lkotlin/Function1;", "bitmap2Base64Converter", "LS7/k;", "Lstepai/aios/accessibility/DefaultAccessibilityService;", "getAccessibilityService", "()Lstepai/aios/accessibility/DefaultAccessibilityService;", "accessibilityService", "Companion", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DefaultGuiAbilityProvider implements GuiAbilityProvider {
    private static final String TAG = "DefaultGuiAbilityProvider";
    private final k bitmap2Base64Converter;
    private final a compressSizeProvider;

    @c(c = "stepai.aios.guiagent.ability.DefaultGuiAbilityProvider", f = "DefaultGuiAbilityProvider.kt", l = {41}, m = "captureScreenResult", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: stepai.aios.guiagent.ability.DefaultGuiAbilityProvider$captureScreenResult$1, reason: invalid class name and case insensitive filesystem */
    public static final class C19291 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C19291(H7.c<? super C19291> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultGuiAbilityProvider.this.captureScreenResult(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultGuiAbilityProvider() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String bitmap2Base64Converter$lambda$0(DefaultGuiAbilityProvider defaultGuiAbilityProvider, Bitmap bitmap) {
        kotlin.jvm.internal.k.f(bitmap, "bitmap");
        return Fa.a.b(new Fa.a(), bitmap, (Size) defaultGuiAbilityProvider.compressSizeProvider.invoke());
    }

    private final DefaultAccessibilityService getAccessibilityService() {
        if (DefaultAccessibilityService.d == null) {
            j.J("BabelfishAccessibilityService getInstance: service is null", "DefaultAccessibilityService");
        }
        WeakReference weakReference = DefaultAccessibilityService.d;
        if (weakReference != null) {
            return (DefaultAccessibilityService) weakReference.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(30)
    public final Object takeScreenshotOnDisplay(int i, H7.c<? super Bitmap> cVar) {
        DefaultAccessibilityService accessibilityService = getAccessibilityService();
        if (accessibilityService == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        Executor mainExecutor = accessibilityService.getMainExecutor();
        kotlin.jvm.internal.k.e(mainExecutor, "getMainExecutor(...)");
        final C1718k c1718k = new C1718k(1, U7.a.I(cVar));
        c1718k.y();
        accessibilityService.takeScreenshot(i, mainExecutor, new AccessibilityService.TakeScreenshotCallback() { // from class: stepai.aios.guiagent.ability.DefaultGuiAbilityProvider$takeScreenshotOnDisplay$2$1
            @Override // android.accessibilityservice.AccessibilityService.TakeScreenshotCallback
            public void onFailure(int errorCode) {
                if (c1718k.isActive()) {
                    c1718k.resumeWith(null);
                }
            }

            @Override // android.accessibilityservice.AccessibilityService.TakeScreenshotCallback
            public void onSuccess(AccessibilityService.ScreenshotResult screenshot) {
                HardwareBuffer hardwareBuffer;
                kotlin.jvm.internal.k.f(screenshot, "screenshot");
                try {
                    hardwareBuffer = screenshot.getHardwareBuffer();
                } catch (Throwable unused) {
                    hardwareBuffer = null;
                }
                try {
                    ColorSpace colorSpace = screenshot.getColorSpace();
                    kotlin.jvm.internal.k.e(colorSpace, "getColorSpace(...)");
                    Bitmap bitmapWrapHardwareBuffer = Bitmap.wrapHardwareBuffer(hardwareBuffer, colorSpace);
                    if (bitmapWrapHardwareBuffer == null) {
                        if (c1718k.isActive()) {
                            c1718k.resumeWith(null);
                        }
                        if (hardwareBuffer != null) {
                            return;
                        } else {
                            return;
                        }
                    }
                    b bVar = ta.c.f6684a;
                    Bitmap bitmap = (Bitmap) ta.c.f6684a.f6683a.invoke(bitmapWrapHardwareBuffer);
                    if (c1718k.isActive()) {
                        c1718k.resumeWith(bitmap);
                    }
                    if (hardwareBuffer != null) {
                        hardwareBuffer.close();
                    }
                } catch (Throwable unused2) {
                    try {
                        if (c1718k.isActive()) {
                            c1718k.resumeWith(null);
                        }
                        if (hardwareBuffer != null) {
                            hardwareBuffer.close();
                        }
                    } finally {
                        if (hardwareBuffer != null) {
                            hardwareBuffer.close();
                        }
                    }
                }
            }
        });
        Object objX = c1718k.x();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        return objX;
    }

    @Override // stepai.aios.guiagent.ability.GuiAbilityProvider
    public Object bitmap2Base64(Bitmap bitmap, H7.c<? super String> cVar) {
        return this.bitmap2Base64Converter.invoke(bitmap);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // stepai.aios.guiagent.ability.GuiAbilityProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object captureScreenResult(stepai.aios.guiagent.ability.CaptureOptions r10, H7.c<? super stepai.aios.guiagent.ability.CaptureResult> r11) {
        /*
            r9 = this;
            boolean r10 = r11 instanceof stepai.aios.guiagent.ability.DefaultGuiAbilityProvider.C19291
            if (r10 == 0) goto L13
            r10 = r11
            stepai.aios.guiagent.ability.DefaultGuiAbilityProvider$captureScreenResult$1 r10 = (stepai.aios.guiagent.ability.DefaultGuiAbilityProvider.C19291) r10
            int r0 = r10.label
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r10.label = r0
            goto L18
        L13:
            stepai.aios.guiagent.ability.DefaultGuiAbilityProvider$captureScreenResult$1 r10 = new stepai.aios.guiagent.ability.DefaultGuiAbilityProvider$captureScreenResult$1
            r10.<init>(r11)
        L18:
            java.lang.Object r11 = r10.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r10.label
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            java.lang.Object r9 = r10.L$0
            stepai.aios.guiagent.ability.CaptureOptions r9 = (stepai.aios.guiagent.ability.CaptureOptions) r9
            kotlin.b.b(r11)
            goto L54
        L2b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L33:
            kotlin.b.b(r11)
            java.lang.ThreadLocal r11 = Ca.C0202a.f344a
            java.lang.Object r11 = r11.get()
            java.lang.Integer r11 = (java.lang.Integer) r11
            if (r11 == 0) goto L45
            int r11 = r11.intValue()
            goto L46
        L45:
            r11 = 0
        L46:
            r1 = 0
            r10.L$0 = r1
            r10.I$0 = r11
            r10.label = r2
            java.lang.Object r11 = r9.takeScreenshotOnDisplay(r11, r10)
            if (r11 != r0) goto L54
            return r0
        L54:
            r1 = r11
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            stepai.aios.guiagent.ability.CaptureResult r0 = new stepai.aios.guiagent.ability.CaptureResult
            r7 = 40
            r8 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.ability.DefaultGuiAbilityProvider.captureScreenResult(stepai.aios.guiagent.ability.CaptureOptions, H7.c):java.lang.Object");
    }

    public DefaultGuiAbilityProvider(a compressSizeProvider) {
        kotlin.jvm.internal.k.f(compressSizeProvider, "compressSizeProvider");
        this.compressSizeProvider = compressSizeProvider;
        this.bitmap2Base64Converter = new g(this, 9);
    }

    public /* synthetic */ DefaultGuiAbilityProvider(a aVar, int i, e eVar) {
        this((i & 1) != 0 ? new a() { // from class: stepai.aios.guiagent.ability.DefaultGuiAbilityProvider.1
            @Override // S7.a
            public final Void invoke() {
                return null;
            }
        } : aVar);
    }
}
