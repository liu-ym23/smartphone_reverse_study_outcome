package com.obric.autogui.platforms.tools.input.inject;

import android.hardware.input.InputManager;
import android.view.InputEvent;
import android.view.KeyEvent;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.annotation.CallingPlatform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: KeyCodeSender.kt */
/* JADX INFO: loaded from: classes3.dex */
@CallingPlatform
public final class a {
    private static final String TAG = "KeyCodeSender";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f30267a = null;

    static {
        f30267a = new a();
    }

    private a() {
    }

    public final boolean a(int r20, int r21, long r22, long r24) {
        KeyEvent r10 = new KeyEvent(r22, r22, 0, r20, 0);
        KeyEvent r2 = new KeyEvent(r24, r24, 1, r20, 0);
        boolean r3 = false;
    L10:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "pressRawKeycode exception", th);     // Catch: Throwable -> L14
        com.obric.autogui.platforms.tools.internal.a.f.f30329a.a(r10);
        com.obric.autogui.platforms.tools.internal.a.f.f30329a.a(r2);
        return false;
    L14:
        th = move-exception;
        com.obric.autogui.platforms.tools.internal.a.f.f30329a.a(r10);
        com.obric.autogui.platforms.tools.internal.a.f.f30329a.a(r2);
        throw th;
    L4:
        if (a(r21, r10) == false) goto L8;
        if (a(r21, r2) == false) goto L8;
        r3 = true;
    L8:
        com.obric.autogui.platforms.tools.internal.a.f.f30329a.a(r10);
        com.obric.autogui.platforms.tools.internal.a.f.f30329a.a(r2);
        return r3;
    }

    public final boolean a(int r6, KeyEvent r7) {
        o.e(r7, "keyEvent");
        InputManager r5 = com.obric.autogui.platforms.tools.input.c.f30257a.a();
        if (r5 != null) goto L5;
        return false;
    L5:
        Method r1 = com.obric.autogui.platforms.tools.input.c.f30257a.b();
        if (r1 != null) goto L13;
        return false;
    L13:
        com.obric.autogui.platforms.tools.internal.a.f.f30329a.a((InputEvent) ZeusTransformUtils.preCheckCast(r7, InputEvent.class, "com.obric.aiagent.plugin"), r6);     // Catch: Throwable -> L10
        r1.invoke(r5, new Object[]{r7, 0});     // Catch: Throwable -> L10
        return true;
    L10:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "injectRawKeyEvent (" + r7 + ") exception", th);
        return false;
    }
}
