package com.obric.autogui.common.a;

import android.content.Context;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.n;
import d.o;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: compiled from: ComputerControlRuntimeConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private static final String TAG = "ComputerControlRuntimeConfig";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f28972a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d.f f28973b = null;

    /* JADX INFO: renamed from: lambda$k7FFou3wbg352cPLYpu-aSQ0RJk, reason: not valid java name */
    public static /* synthetic */ b m800lambda$k7FFou3wbg352cPLYpuaSQ0RJk() {
        return c();
    }

    private c() {
    }

    static {
        f28972a = new c();
        f28973b = d.g.a($$Lambda$c$k7FFou3wbg352cPLYpuaSQ0RJk.INSTANCE);
    }

    public final b a() {
        return (b) ZeusTransformUtils.preCheckCast(f28973b.b(), b.class, "com.obric.aiagent.plugin");
    }

    private static final b c() {
        b r0 = f28972a.b();
        if (r0 == null) goto L5;
        return r0;
    L5:
        boolean r2 = d.f28974a.d();
        if (r2 == false) goto L14;
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContextOrNull(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L33;
        Loog.INSTANCE.w(TAG, "Computer Control disabled because app context is not ready.");
        goto L14
    L33:
        boolean r4 = AOPlatformTools.INSTANCE.computerControl().isSupported(r3);     // Catch: Throwable -> L12
    L16:
        if (r2 == false) goto L19;
        if (r4 == false) goto L19;
        boolean r5 = true;
    L21:
        if (r5 == true) goto L23;
    L25:
        boolean r6 = false;
    L26:
        if (r5 == true) goto L28;
    L30:
        boolean r8 = false;
    L31:
        b r7 = new b(r2, r4, r5, r6, r8);
        Loog.INSTANCE.i(TAG, "Computer Control config snapshot: mode=" + f28972a.a(r7) + ", source=settings, settingEnabled=" + r7.a() + ", systemSupported=" + r7.b() + ", enabled=" + r7.c() + ", guiActionEnabled=" + r7.d() + ", mirrorViewEnabled=" + r7.e());
        return r7;
    L28:
        if (d.f28974a.f() == false) goto L30;
        r8 = true;
        goto L31
    L23:
        if (d.f28974a.e() == false) goto L25;
        r6 = true;
    L19:
        r5 = false;
    L12:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "Computer Control support check failed.", th);
    L14:
        r4 = false;
        goto L16
    }

    private final b b() {
        Object r2 = null;
        if (IAppContext.Companion.isDebug() == true) goto L6;
        Loog.INSTANCE.i(TAG, "Skip local Computer Control settings because aiagent is not debug.");
        return null;
    L6:
        File r1 = new File("/data/local/tmp/oauto-settings/computer-control-settings.json");
        if (r1.isFile() == true) goto L10;
        Loog.INSTANCE.i(TAG, "Skip local Computer Control settings because file is missing.");
        return null;
    L10:
        Loog.INSTANCE.i(TAG, "Read local Computer Control settings from " + r1.getAbsolutePath() + '.');
        n.a r5 = n.f38560a;     // Catch: Throwable -> L13
        c r13 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        Object r14 = n.f(new JSONObject(d.f.k.a(r1, null, 1, null)));     // Catch: Throwable -> L13
    L16:
        if (n.a(r14) == false) goto L35;
        n.a r3 = n.f38560a;
        JSONObject r15 = (JSONObject) ZeusTransformUtils.preCheckCast(r14, JSONObject.class, "com.obric.aiagent.plugin");
        boolean r9 = r15.optBoolean("enable", false);
        if (r9 == false) goto L25;
        JSONObject r6 = r15.optJSONObject("gui_action");
        if (r6 == null) goto L22;
        boolean r7 = r6.optBoolean("enable", false);
    L23:
        if (r7 == false) goto L25;
        boolean r10 = true;
    L26:
        if (r9 == false) goto L33;
        JSONObject r16 = r15.optJSONObject("mirror_view");
        if (r16 == null) goto L30;
        boolean r17 = r16.optBoolean("enable", false);
    L31:
        if (r17 == false) goto L33;
        boolean r11 = true;
    L34:
        Object r18 = n.f(new b(r9, r9, r9, r10, r11));
    L37:
        if (n.a(r18) == false) goto L39;
        b r4 = (b) ZeusTransformUtils.preCheckCast(r18, b.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.i(TAG, "Computer Control config snapshot: mode=" + f28972a.a(r4) + ", source=local-dev-settings, settingEnabled=" + r4.a() + ", systemSupported=" + r4.b() + ", enabled=" + r4.c() + ", guiActionEnabled=" + r4.d() + ", mirrorViewEnabled=" + r4.e());
    L39:
        Throwable r8 = n.c(r18);
        if (r8 == null) goto L43;
        Loog.INSTANCE.e(TAG, "Failed to read local Computer Control settings.", r8);
    L43:
        if (n.b(r18) == true) goto L47;
        r2 = r18;
    L47:
        return (b) ZeusTransformUtils.preCheckCast(r2, b.class, "com.obric.aiagent.plugin");
    L30:
        r17 = false;
    L33:
        r11 = false;
        goto L34
    L22:
        r7 = false;
    L25:
        r10 = false;
        goto L26
    L35:
        r18 = n.f(r14);
    L13:
        th = move-exception;
        n.a r12 = n.f38560a;
        r14 = n.f(o.a(th));
        goto L16
    }

    private final String a(b r1) {
        if (r1.c() == true) goto L7;
        return "vd";
    L7:
        if (r1.d() == false) goto L13;
        if (r1.e() == false) goto L13;
        return "cc-full";
    L13:
        if (r1.d() == false) goto L17;
        return "cc-gui-action";
    L17:
        if (r1.e() == false) goto L20;
        return "cc-mirror";
    L20:
        return "cc-surface";
    }
}
