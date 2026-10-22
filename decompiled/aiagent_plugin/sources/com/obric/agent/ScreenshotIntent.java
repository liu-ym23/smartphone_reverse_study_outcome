package com.obric.agent;

import android.graphics.Bitmap;
import android.hardware.input.InputManager;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.InputEvent;
import android.view.KeyEvent;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseSystemScreenshotIntent;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.SystemScreenshotParams;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: ScreenshotIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ScreenshotIntent extends BaseSystemScreenshotIntent {
    public static final a Companion = null;
    private static final String TAG = "ScreenshotIntent";

    /* JADX INFO: compiled from: ScreenshotIntent.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemScreenshotIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public boolean isBlock() {
        return true;
    }

    public ScreenshotIntent() {
    }

    public static final /* synthetic */ Object access$screenshotWithInteractive(ScreenshotIntent r2, d.c.d r3) {
        return r2.screenshotWithInteractive((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemScreenshotIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d.c.d<? super IntentResult<Bitmap>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d.c.d<? super IntentResult<Bitmap>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return doAction((SystemScreenshotParams) ZeusTransformUtils.preCheckCast(r6, SystemScreenshotParams.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemScreenshotIntent
    public Object doAction(SystemScreenshotParams r1, DispatchContext r2, d.c.d<? super IntentResult<Bitmap>> r3) {
        return screenshotWithInteractive((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    private final Object screenshotWithInteractive(d.c.d<? super IntentResult<Bitmap>> r23) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r23, d.c.d.class, "com.obric.aiagent.plugin");
        Object r1 = InputManager.class.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L5
        d.h.b.o.a(r1, "null cannot be cast to non-null type android.hardware.input.InputManager");     // Catch: Exception -> L5
        InputManager r2 = (InputManager) ZeusTransformUtils.preCheckCast(r1, InputManager.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L5
        Method r3 = InputManager.class.getDeclaredMethod("injectInputEvent", new Class[]{InputEvent.class, Integer.TYPE});     // Catch: Exception -> L5
        long r6 = SystemClock.uptimeMillis();     // Catch: Exception -> L5
        r3.invoke(r2, new Object[]{new KeyEvent(r6, r6, 0, 318, 0), d.c.b.a.b.a(0)});     // Catch: Exception -> L5
        r3.invoke(r2, new Object[]{new KeyEvent(r6, r6, 1, 318, 0), d.c.b.a.b.a(0)});     // Catch: Exception -> L5
        return new IntentResult(0, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
    L5:
        e = move-exception;
        ILogDepend.Companion.e("", "screenshotWithInteraction failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return new IntentResult(0, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_IO, null);
    }
}
