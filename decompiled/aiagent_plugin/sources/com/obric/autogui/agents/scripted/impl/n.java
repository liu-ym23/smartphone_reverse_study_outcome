package com.obric.autogui.agents.scripted.impl;

import android.util.Log;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: ScriptDecryptTelemetry.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n {
    private static final String TAG = "Script-DecryptTelemetry";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f27031a = null;

    static {
        f27031a = new n();
    }

    private n() {
    }

    public final void a(String r7, String r8, String r9, String r10, long r11, int r13, String r14, String r15) {
        d.h.b.o.e(r7, "packageName");
        d.h.b.o.e(r8, "moduleName");
        d.h.b.o.e(r10, "result");
        d.h.b.o.e(r14, "reason");
        JSONObject r3 = new JSONObject();     // Catch: Exception -> L22
        n r5 = f27031a;     // Catch: Exception -> L22
        r3.put("package_type", r5.a(r7));     // Catch: Exception -> L22
        r3.put("shortcut_name", r5.b(r8));     // Catch: Exception -> L22
        CharSequence r12 = SensitiveType.UNKNOWN;
        if (r9 == null) goto L10;
        CharSequence r16 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L22
        if (d.o.o.d(r16) == false) goto L9;
        r16 = SensitiveType.UNKNOWN;
    L9:
        String r17 = (String) ZeusTransformUtils.preCheckCast(r16, String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L22
    L11:
        r3.put("ver_code", r17);     // Catch: Exception -> L22
        r3.put("result", r10);     // Catch: Exception -> L22
        r3.put("time_consumption_ms", r11);     // Catch: Exception -> L22
        r3.put("decrypted_size_bytes", r13);     // Catch: Exception -> L22
        r3.put("reason", r14);     // Catch: Exception -> L22
        if (r15 == null) goto L18;
        CharSequence r18 = (CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L22
        if (d.o.o.d(r18) == true) goto L17;
        r12 = r18;
    L17:
        r12 = (String) ZeusTransformUtils.preCheckCast(r12, String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L22
    L18:
        r3.put("session_id", r12);     // Catch: Exception -> L22
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default((IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin"), "script_decrypt_performance", r3, false, false, null, 28, null);     // Catch: Exception -> L22
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L27;
        Loog.INSTANCE.d(TAG, "[script_decrypt_performance] " + r3);     // Catch: Exception -> L22
        return;
    L27:
        return;
    L10:
        r17 = SensitiveType.UNKNOWN;
    L22:
        e = move-exception;
        com.obric.autogui.agents.scripted.c.c.a(TAG, "report decrypt telemetry failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    public final String a(Throwable r13) {
        d.h.b.o.e(r13, "e");
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(d.a.p.e(new String[]{aa.b(r13.getClass()).b(), r13.getMessage()}), Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L8;
        Object r3 = r14.next();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L4;
        r0.add(r3);
        goto L4
    L8:
        String r15 = d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(": ", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null) + '\n' + Log.getStackTraceString(r13);
        if (r15.length() > 2048) goto L11;
        return r15;
    L11:
        return d.o.o.e(r15, 2048);
    }

    private final String a(String r1) {
        if (d.h.b.o.a(r1, "com.obric.script_engine") == false) goto L6;
        return "engine";
    L6:
        if (d.h.b.o.a(r1, "com.obric.ability.script") == false) goto L8;
        return "script";
    L8:
        return SensitiveType.UNKNOWN;
    }

    private final String b(String r5) {
        if (d.h.b.o.a(r5, "auto-shortcut-engine.js") == false) goto L6;
        return "engine";
    L6:
        if (d.h.b.o.a(r5, "manifest.json") == false) goto L9;
        return "manifest";
    L9:
        if (d.h.b.o.a(r5, "pre-check-bundle.js") == false) goto L12;
        return "pre_check_bundle";
    L12:
        if (d.o.o.b(r5, "scripts/", false, 2, null) == true) goto L14;
        return r5;
    L14:
        return d.o.o.a(d.o.o.a(r5, (CharSequence) ZeusTransformUtils.preCheckCast("scripts/", CharSequence.class, "com.obric.aiagent.plugin")), "/", null, 2, null);
    }
}
