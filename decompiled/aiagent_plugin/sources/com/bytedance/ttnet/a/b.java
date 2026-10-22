package com.bytedance.ttnet.a;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.i.k;
import com.bytedance.ttnet.TTNetInit;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: CronetRetryEventHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private static final String TAG = "CronetRetryEventHandler";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f11261a;

    public static b a() {
        if (f11261a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f11261a != null) goto L9;
        f11261a = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f11261a;
    }

    private b() {
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    public void a(ArrayList<String> r27, String r28) {
        String r1 = "GET";
        String r3 = "x-tt-tnc-abtest";
        String r4 = "x-tt-tnc-config";
        if (r27 != null) goto L5;
        return;
    L5:
        if (r27.isEmpty() == true) goto L131;
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TTNetInit.getTTNetDepend().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L11;
        return;
    L11:
        if (Logger.debug() == false) goto L13;
        Logger.d(TAG, "start get-domain request.");
    L13:
        Iterator<String> r11 = r27.iterator();
    L15:
        if (r11.hasNext() == false) goto L132;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.aiagent.plugin");
        com.bytedance.ttnet.d.a r12 = new com.bytedance.ttnet.d.a();     // Catch: Throwable -> L101
        r12.f = true;     // Catch: Throwable -> L101
        r12.g = false;     // Catch: Throwable -> L101
        k r2 = new k(r0);     // Catch: Throwable -> L101
        r2.a("tnc_src", "7");     // Catch: Throwable -> L101
        String r5 = r2.toString();     // Catch: Throwable -> L101
        HashMap r14 = new HashMap();     // Catch: Throwable -> L101
        HashMap r15 = new HashMap();     // Catch: Throwable -> L101
        if (TextUtils.isEmpty(r28) == false) goto L20;
        Iterator<String> r29 = r11;
    L26:
        if (com.bytedance.ttnet.tnc.c.c().a(r1, r5, r15, "") == false) goto L27;
        String r13 = com.bytedance.ttnet.d.c.a(r5, r15, r14, r12);     // Catch: Throwable -> L99
        if (Logger.debug() == false) goto L32;
        Logger.d(TAG, "response: " + r13);     // Catch: Throwable -> L99
    L32:
        if (com.bytedance.ttnet.tnc.c.c().b(r1, r5, r14, r13) == false) goto L33;
        if (com.bytedance.common.utility.j.a(r13) == true) goto L36;
        if ("success".equals(new JSONObject(r13).getString("message")) == false) goto L36;
        if (r14.get("x-ss-etag") != null) goto L43;
    L45:
        String r6 = "";
    L47:
        if (r14.get("x-ss-canary") != null) goto L49;
    L51:
        String r16 = "";
    L53:
        if (r14.get(r4) != null) goto L55;
        String r23 = r1;
    L60:
        String r7 = "";
    L62:
        if (r14.get(r3) != null) goto L113;
        String r24 = r4;
    L71:
        String r8 = "";
    L73:
        if (r14.get("x-tt-tnc-control") == null) goto L79;
        String r25 = r3;
    L86:
        th = th;
    L111:
        th.printStackTrace();     // Catch: Throwable -> L97
        return;
    L97:
        th = th;
    L103:
        th.printStackTrace();
        r11 = r29;
        r1 = r23;
        r4 = r24;
        r3 = r25;
        goto L15
    L77:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(((List) ZeusTransformUtils.preCheckCast(r14.get("x-tt-tnc-control"), List.class, "com.obric.aiagent.plugin")).get(0), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L80;
        String r21 = (String) ZeusTransformUtils.preCheckCast(((List) ZeusTransformUtils.preCheckCast(r14.get("x-tt-tnc-control"), List.class, "com.obric.aiagent.plugin")).get(0), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L86
    L82:
        if (Logger.debug() == false) goto L84;
        Logger.d(TAG, "tnc verion: " + r6 + " canary: " + r16 + " configid: " + r7 + " abtest: " + r8);     // Catch: Throwable -> L86
    L84:
        com.bytedance.frameworks.baselib.network.http.cronet.b.i.a(r9).a(r6, r16, r7, r8, r21, r13);     // Catch: Throwable -> L86
        return;
    L80:
        r21 = "";
    L88:
        th = th;
    L89:
        r25 = r3;
        goto L111
    L79:
        r25 = r3;
        goto L80
    L113:
        r24 = r4;
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(((List) ZeusTransformUtils.preCheckCast(r14.get(r3), List.class, "com.obric.aiagent.plugin")).get(0), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L71;
        r8 = (String) ZeusTransformUtils.preCheckCast(((List) ZeusTransformUtils.preCheckCast(r14.get(r3), List.class, "com.obric.aiagent.plugin")).get(0), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L88
    L68:
        th = th;
        r24 = r4;
        goto L89
    L55:
        r23 = r1;
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(((List) ZeusTransformUtils.preCheckCast(r14.get(r4), List.class, "com.obric.aiagent.plugin")).get(0), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L60;
        r7 = (String) ZeusTransformUtils.preCheckCast(((List) ZeusTransformUtils.preCheckCast(r14.get(r4), List.class, "com.obric.aiagent.plugin")).get(0), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L90
    L90:
        th = th;
    L94:
        r25 = r3;
        r24 = r4;
        goto L111
    L49:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(((List) ZeusTransformUtils.preCheckCast(r14.get("x-ss-canary"), List.class, "com.obric.aiagent.plugin")).get(0), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L51;
        r16 = (String) ZeusTransformUtils.preCheckCast(((List) ZeusTransformUtils.preCheckCast(r14.get("x-ss-canary"), List.class, "com.obric.aiagent.plugin")).get(0), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L92
        goto L53
    L43:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(((List) ZeusTransformUtils.preCheckCast(r14.get("x-ss-etag"), List.class, "com.obric.aiagent.plugin")).get(0), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L45;
        r6 = (String) ZeusTransformUtils.preCheckCast(((List) ZeusTransformUtils.preCheckCast(r14.get("x-ss-etag"), List.class, "com.obric.aiagent.plugin")).get(0), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L92
    L92:
        th = th;
        r23 = r1;
    L36:
        r11 = r29;
        goto L15
    L33:
        return;
    L27:
        return;
    L20:
        r29 = r11;
        r15.put("x-tt-tnc-summary", r28);     // Catch: Throwable -> L99
    L99:
        th = th;
        r23 = r1;
        r25 = r3;
        r24 = r4;
    L101:
        th = th;
        r23 = r1;
        r25 = r3;
        r24 = r4;
        r29 = r11;
        goto L103
    L132:
        return;
    }
}
