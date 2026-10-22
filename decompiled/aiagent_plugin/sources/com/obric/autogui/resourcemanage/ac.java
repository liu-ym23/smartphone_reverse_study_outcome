package com.obric.autogui.resourcemanage;

import android.content.Context;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: ScriptResourceManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ac {
    private static final String TAG = "ScriptResourceManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ac f30597a = null;

    static {
        f30597a = new ac();
    }

    public static /* synthetic */ j lambda$lzFYGKsokzbR6DQJHlMx08c9wZY(v r0) {
        return a(r0);
    }

    private ac() {
    }

    private static final j a(v r11) {
        d.h.b.o.e(r11, "it");
        return new j(null, 0, 0, false, false, 31, null);
    }

    public static /* synthetic */ q a(ac r17, u r18, p r19, d.h.a.b r20, d.h.a.b r21, t r22, d.h.a.b r23, d.h.a.b r24, d.h.a.m r25, d.h.a.m r26, d.h.a.b r27, int r28, Object r29) {
        u r4 = (u) ZeusTransformUtils.wrapperContextForParams(r18, u.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super v, j> r1 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r20, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super String, ? extends Map<String, String>> r3 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r21, d.h.a.b.class, "com.obric.aiagent.plugin");
        t r5 = (t) ZeusTransformUtils.wrapperContextForParams(r22, t.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super o, d.x> r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r23, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super o, d.x> r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r24, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.m<? super o, ? super File, d.x> r8 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r25, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.a.m<? super o, ? super File, d.x> r9 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r26, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super JSONObject, d.x> r10 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r27, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r28 & 4) == 0) goto L6;
        r1 = $$Lambda$ac$lzFYGKsokzbR6DQJHlMx08c9wZY.INSTANCE;
    L6:
        if ((r28 & 8) == 0) goto L8;
        d.h.a.b<? super String, ? extends Map<String, String>> r11 = null;
    L10:
        if ((r28 & 16) == 0) goto L12;
        t r2 = (t) ZeusTransformUtils.preCheckCast(new a(), t.class, "com.obric.aiagent.plugin");
    L14:
        if ((r28 & 32) == 0) goto L16;
        d.h.a.b<? super o, d.x> r13 = null;
    L18:
        if ((r28 & 64) == 0) goto L20;
        d.h.a.b<? super o, d.x> r14 = null;
    L22:
        if ((r28 & 128) == 0) goto L24;
        d.h.a.m<? super o, ? super File, d.x> r15 = null;
    L26:
        if ((r28 & 256) == 0) goto L28;
        d.h.a.m<? super o, ? super File, d.x> r16 = null;
    L30:
        if ((r28 & 512) == 0) goto L32;
        d.h.a.b<? super JSONObject, d.x> r0 = null;
    L34:
        return r17.a(r4, r19, r1, r11, r2, r13, r14, r15, r16, r0);
    L32:
        r0 = r10;
        goto L34
    L28:
        r16 = r9;
        goto L30
    L24:
        r15 = r8;
        goto L26
    L20:
        r14 = r7;
        goto L22
    L16:
        r13 = r6;
        goto L18
    L12:
        r2 = r5;
        goto L14
    L8:
        r11 = r3;
        goto L10
    }

    public final q a(u r14, p r15, d.h.a.b<? super v, j> r16, d.h.a.b<? super String, ? extends Map<String, String>> r17, t r18, d.h.a.b<? super o, d.x> r19, d.h.a.b<? super o, d.x> r20, d.h.a.m<? super o, ? super File, d.x> r21, d.h.a.m<? super o, ? super File, d.x> r22, d.h.a.b<? super JSONObject, d.x> r23) {
        u r3 = (u) ZeusTransformUtils.wrapperContextForParams(r14, u.class, "com.obric.aiagent.plugin");
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r16, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r17, d.h.a.b.class, "com.obric.aiagent.plugin");
        t r7 = (t) ZeusTransformUtils.wrapperContextForParams(r18, t.class, "com.obric.aiagent.plugin");
        d.h.a.b r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r19, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r20, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.m r10 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r21, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.a.m r11 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r22, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.a.b r12 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r23, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "requestFactory");
        d.h.b.o.e(r15, "config");
        d.h.b.o.e(r5, "requestPolicyProvider");
        d.h.b.o.e(r7, "installer");
        return new q(r3, r15, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public final File a(Context r3, String r4, s r5) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        s r6 = (s) ZeusTransformUtils.wrapperContextForParams(r5, s.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "context");
        d.h.b.o.e(r4, "packageName");
        d.h.b.o.e(r6, "selector");
        File r7 = d.f30616a.a(r2, r4);
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L9;
        Loog r8 = Loog.INSTANCE;
        StringBuilder r0 = new StringBuilder().append("getResourceFile, installDir = ");
        if (r7 == null) goto L7;
        String r1 = r7.getAbsolutePath();
    L8:
        r8.i(TAG, r0.append(r1).toString());
        goto L9
    L7:
        r1 = null;
    L9:
        if (r7 != null) goto L12;
        return null;
    L12:
        return r6.a(r7);
    }

    public final File a(Context r2, String r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "context");
        d.h.b.o.e(r3, "packageName");
        return d.f30616a.a(r1, r3);
    }

    public final o a(String r1) {
        d.h.b.o.e(r1, "packageName");
        return d.f30616a.a(r1);
    }

    public static /* synthetic */ n a(ac r1, Context r2, String r3, String r4, String r5, int r6, Object r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if ((r6 & 4) == 0) goto L6;
        r4 = "resource_download";
    L6:
        if ((r6 & 8) == 0) goto L9;
        r5 = "com.larus.nova";
    L9:
        return r1.a(r8, r3, r4, r5);
    }

    public final n a(Context r2, String r3, String r4, String r5) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "context");
        d.h.b.o.e(r3, "packageName");
        d.h.b.o.e(r4, "baseDirName");
        d.h.b.o.e(r5, "appPkg");
        n r6 = d.f30616a.a(r1, r3, r4, r5);
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L5;
        Loog.INSTANCE.i(TAG, "clearLocalResource, packageName=" + r3 + ", deleted=" + r6.b().size() + ", failed=" + r6.c().size() + ", remaining=" + r6.d().size());
    L5:
        return r6;
    }
}
