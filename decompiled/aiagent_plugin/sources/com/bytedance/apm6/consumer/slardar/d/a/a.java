package com.bytedance.apm6.consumer.slardar.d.a;

import android.content.Context;
import com.bytedance.common.wschannel.WsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: DowngradeController.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile c f5117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f5118b;

    /* JADX INFO: renamed from: com.bytedance.apm6.consumer.slardar.d.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DowngradeController.java */
    private static class C0125a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f5119a = null;

        static /* synthetic */ a a() {
            return f5119a;
        }

        static {
            f5119a = new a();
        }
    }

    public a() {
    }

    public void a(Context r3) {
        b r0 = new b((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
        this.f5118b = r0;
        a(r0.a(), false);
    }

    public void a(c r1, boolean r2) {
        if (r1 == null) goto L13;
        monitor-enter(this);
        this.f5117a = r1;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        if (r2 == false) goto L16;
        b r0 = this.f5118b;
        if (r0 == null) goto L17;
        r0.a(r1);
        return;
    L17:
        return;
    L16:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public boolean a(JSONObject r7, int r8) {
        boolean r1 = true;
        if (this.f5117a != null) goto L5;
    L46:
        return true;
    L5:
        if (System.currentTimeMillis() > this.f5117a.f5121a) goto L46;
        String r9 = String.valueOf(r8);
        String r0 = r7.optString("log_type");
        monitor-enter(this);
    L43:
        th = move-exception;
        throw th;
    L10:
        if (c.a.f5124b.f5126c.equals(r0) == false) goto L26;
        String r10 = r7.optString(WsConstants.KEY_SERVICE);     // Catch: Throwable -> L43
        c.b r2 = (c.b) ZeusTransformUtils.preCheckCast(this.f5117a.f5122b.get(c.a.f5124b), c.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L43
        if (r2 == null) goto L41;
        JSONObject r11 = (JSONObject) ZeusTransformUtils.preCheckCast(r2.f5128b.get(r9), JSONObject.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L43
        if (r11 != null) goto L16;
    L23:
        boolean r12 = r2.f5127a;     // Catch: Throwable -> L43
        monitor-exit(this);     // Catch: Throwable -> L43
        return r12;
    L16:
        if (r11.optInt(r10, -1) == (-1)) goto L23;
        if (r11.optInt(r10, -1) == 1) goto L21;
        r1 = false;
    L21:
        monitor-exit(this);     // Catch: Throwable -> L43
        return r1;
    L41:
        monitor-exit(this);     // Catch: Throwable -> L43
        return true;
    L26:
        c.b r13 = (c.b) ZeusTransformUtils.preCheckCast(this.f5117a.f5122b.get(c.a.f5123a), c.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L43
        if (r13 == null) goto L41;
        JSONObject r14 = (JSONObject) ZeusTransformUtils.preCheckCast(r13.f5128b.get(r9), JSONObject.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L43
        if (r14 != null) goto L31;
    L38:
        boolean r15 = r13.f5127a;     // Catch: Throwable -> L43
        monitor-exit(this);     // Catch: Throwable -> L43
        return r15;
    L31:
        if (r14.optInt(r0, -1) == (-1)) goto L38;
        if (r14.optInt(r0, -1) == 1) goto L36;
        r1 = false;
    L36:
        monitor-exit(this);     // Catch: Throwable -> L43
        return r1;
    }

    public static a a() {
        return C0125a.a();
    }
}
