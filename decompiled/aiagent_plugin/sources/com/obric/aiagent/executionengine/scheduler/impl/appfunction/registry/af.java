package com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry;

import android.app.Application;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ITraceDepend;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AppFunctionSkillSpellManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class af {
    private static final String TAG = "AppFunctionSkillSpell";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final af f18217a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Uri f18218b = null;

    public static /* synthetic */ CharSequence lambda$TPU60LsCfBCjmyYu3UXa2uwp8TY(byte r0) {
        return a(r0);
    }

    private af() {
    }

    static {
        f18217a = new af();
        f18218b = Uri.parse("content://com.obric.agentskills.appfunction.skills");
    }

    public final Object a(List<ad> r14, d.c.d<? super d.x> r15) {
        List<ad> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.aiagent.plugin");
        d.c.d r17 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
        String r18 = UUID.randomUUID().toString();
        d.h.b.o.c(r18, "toString(...)");
        String r19 = r18.toLowerCase(Locale.ROOT);
        d.h.b.o.c(r19, "toLowerCase(...)");
        if (a() == true) goto L56;
        int r8 = r16.size();
        ILogDepend.Companion.w(TAG, "Spell sync skipped: ContentProvider not found authority=com.obric.agentskills.appfunction.skills snapshot=" + r19 + " skills=" + r8);
        a(r19, r8, 1, "content_provider_not_found", "transport_error", r8, 0);
        return d.x.f38692a;
    L56:
        List<aj> r0 = a(r16);     // Catch: Exception -> L45 CancellationException -> L52
        byte[] r2 = a(r19, r0);     // Catch: Exception -> L45 CancellationException -> L52
        long r3 = r2.length;     // Catch: Exception -> L45 CancellationException -> L52
        boolean r6 = false;
        if (1 <= r3) goto L9;
    L11:
        if (r6 == false) goto L44;
        String r4 = a(r2);     // Catch: Exception -> L45 CancellationException -> L52
        am r7 = null;
        int r5 = 1;
    L15:
        if (r5 >= 3) goto L39;
        ak r9 = a(r2, r4, r19);     // Catch: Exception -> L18 CancellationException -> L37
    L29:
        if (ZeusTransformUtils.instanceOf(r9, ak.a.class) == true) goto L30;
        if (ZeusTransformUtils.instanceOf(r9, ak.b.class) == false) goto L36;
        am r10 = new am(((ak.b) ZeusTransformUtils.preCheckCast(r9, ak.b.class, "com.obric.aiagent.plugin")).a(), ((ak.b) ZeusTransformUtils.preCheckCast(r9, ak.b.class, "com.obric.aiagent.plugin")).b(), r5);     // Catch: Exception -> L45 CancellationException -> L52
        ILogDepend.Companion.w(TAG, "Spell sync rejected snapshot=" + r19 + " attempt=" + r5 + "/2 code=" + ((ak.b) ZeusTransformUtils.preCheckCast(r9, ak.b.class, "com.obric.aiagent.plugin")).a() + " message=" + ((ak.b) ZeusTransformUtils.preCheckCast(r9, ak.b.class, "com.obric.aiagent.plugin")).b());     // Catch: Exception -> L45 CancellationException -> L52
        r5 = r5 + 1;     // Catch: Exception -> L45 CancellationException -> L52
        r7 = r10;
        goto L15
    L36:
        throw new d.k();     // Catch: Exception -> L45 CancellationException -> L52
    L30:
        a(r19, r0.size(), r5, (ak.a) ZeusTransformUtils.preCheckCast(r9, ak.a.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L45 CancellationException -> L52
        return d.x.f38692a;
    L37:
        e = move-exception;
        throw e;     // Catch: Exception -> L45 CancellationException -> L52
    L18:
        e = move-exception;
        String r11 = e.getMessage();     // Catch: Exception -> L45 CancellationException -> L52
        if (r11 != null) goto L22;
    L26:
        r11 = e.getClass().getSimpleName();     // Catch: Exception -> L45 CancellationException -> L52
    L27:
        d.h.b.o.a(r11);     // Catch: Exception -> L45 CancellationException -> L52
        r9 = (ak) ZeusTransformUtils.preCheckCast(new ak.b(1, r11), ak.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L45 CancellationException -> L52
        goto L29
    L22:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L25;
        r11 = null;
    L25:
        if (r11 != null) goto L27;
    L39:
        if (r7 == null) goto L42;
        a(r19, r0.size(), r7.a(), r7.b(), "transport_error", r0.size(), r7.c());     // Catch: Exception -> L45 CancellationException -> L52
    L51:
        return d.x.f38692a;
    L42:
        throw new IllegalStateException("Required value was null.".toString());     // Catch: Exception -> L45 CancellationException -> L52
    L44:
        throw new IllegalArgumentException("sync_payload_too_large".toString());     // Catch: Exception -> L45 CancellationException -> L52
    L9:
        if (r3 >= 20971521) goto L11;
        r6 = true;
    L52:
        e = move-exception;
        throw e;
    L45:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "Spell sync payload build failed snapshot=" + r19 + " sources=" + r16.size(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        int r12 = r16.size();
        String r1 = e.getMessage();
        if (r1 != null) goto L49;
        r1 = "";
    L49:
        a(r19, r12, 1, r1, "client_error", r16.size(), 0);
        goto L51
    }

    private final boolean a() {
        PackageManager r5 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageManager();
    L11:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "Failed to resolve ContentProvider authority=com.obric.agentskills.appfunction.skills", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return false;
    L5:
        if (Build.VERSION.SDK_INT >= 33) goto L7;
        ProviderInfo r6 = r5.resolveContentProvider("com.obric.agentskills.appfunction.skills", 0);     // Catch: Exception -> L11
    L9:
        if (r6 != null) goto L16;
        return false;
    L16:
        return true;
    L7:
        r6 = r5.resolveContentProvider("com.obric.agentskills.appfunction.skills", PackageManager.ComponentInfoFlags.of(0));     // Catch: Exception -> L11
        goto L9
    }

    private final List<aj> a(List<ad> r7) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        if (r6.size() > 256) goto L5;
        boolean r8 = true;
    L6:
        if (r8 == false) goto L25;
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r9, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r11 = r9.iterator();
    L9:
        if (r11.hasNext() == false) goto L23;
        ad r3 = (ad) ZeusTransformUtils.preCheckCast(r11.next(), ad.class, "com.obric.aiagent.plugin");
        aj r4 = ag.f18219a.a(r3, f18217a.a(r3.a()));
        if (r4 == null) goto L21;
        byte[] r5 = r4.b().getBytes(d.o.d.f38623b);
        d.h.b.o.c(r5, "getBytes(...)");
        if (r5.length > 2097152) goto L15;
        boolean r12 = true;
    L16:
        if (r12 == false) goto L19;
        r10.add(r4);
        goto L9
    L19:
        throw new IllegalArgumentException("skill_markdown_too_large".toString());
    L15:
        r12 = false;
        goto L16
    L21:
        throw new IllegalArgumentException("invalid_spell_skill_metadata".toString());
    L23:
        return (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.aiagent.plugin");
    L25:
        throw new IllegalArgumentException("too_many_skills".toString());
    L5:
        r8 = false;
        goto L6
    }

    private final String a(String r3) {
        return String.valueOf(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageManager().getPackageInfo(r3, 0).getLongVersionCode());
    }

    private final byte[] a(String r6, List<aj> r7) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        JSONObject r8 = new JSONObject().put("schema_version", 3).put("snapshot_id", r6).put("mode", "full_snapshot");
        JSONArray r9 = new JSONArray();
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        aj r1 = (aj) ZeusTransformUtils.preCheckCast(r10.next(), aj.class, "com.obric.aiagent.plugin");
        r9.put(new JSONObject().put("package_name", r1.a()).put("skill_md", r1.b()));
        goto L4
    L6:
        d.x r11 = d.x.f38692a;
        String r12 = r8.put("skills", r9).toString();
        d.h.b.o.c(r12, "toString(...)");
        byte[] r13 = r12.getBytes(d.o.d.f38623b);
        d.h.b.o.c(r13, "getBytes(...)");
        return r13;
    }

    private final ak a(byte[] r17, String r18, String r19) {
        ContentResolver r3 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getContentResolver();
        String r5 = UUID.randomUUID().toString();
        d.h.b.o.c(r5, "toString(...)");
        String r6 = r5.toLowerCase(Locale.ROOT);
        d.h.b.o.c(r6, "toLowerCase(...)");
        Uri r7 = f18218b;
        Uri r11 = r7.buildUpon().appendPath("uploads").appendPath(r6).build();
        OutputStream r8 = r3.openOutputStream(r11, "wt");     // Catch: Throwable -> L48
        if (r8 != null) goto L11;
        ak r1 = (ak) ZeusTransformUtils.preCheckCast(new ak.b(1, "sync_upload_unavailable"), ak.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L48
        d.n.a r9 = d.n.f38560a;     // Catch: Throwable -> L8
        af r0 = (af) ZeusTransformUtils.preCheckCast(this, af.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        d.n.f(Integer.valueOf(ZeusProviderTransform.delete(r3, r11, null, null, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L8
    L10:
        return r1;
    L8:
        th = move-exception;
        d.n.a r2 = d.n.f38560a;
        d.n.f(d.o.a(th));
        goto L10
    L11:
        Closeable r10 = (Closeable) ZeusTransformUtils.preCheckCast(r8, Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L48
        ((OutputStream) ZeusTransformUtils.preCheckCast(r10, OutputStream.class, "com.obric.aiagent.plugin")).write(r17);     // Catch: Throwable -> L41
        d.x r12 = d.x.f38692a;     // Catch: Throwable -> L41
        d.f.c.a(r10, null);     // Catch: Throwable -> L48
        Bundle r13 = new Bundle();     // Catch: Throwable -> L48
        r13.putString("sync_upload_token", r6);     // Catch: Throwable -> L48
        r13.putLong("sync_payload_size", r17.length);     // Catch: Throwable -> L48
        r13.putString("sync_payload_sha256", r18);     // Catch: Throwable -> L48
        d.x r4 = d.x.f38692a;     // Catch: Throwable -> L48
        Bundle r14 = ZeusProviderTransform.call(r3, r7, "sync_app_function_skills", null, r13, "com.obric.aiagent.plugin");     // Catch: Throwable -> L48
        if (r14 != null) goto L21;
        ak r15 = (ak) ZeusTransformUtils.preCheckCast(new ak.b(1, "empty_provider_response"), ak.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L48
        d.n.a r16 = d.n.f38560a;     // Catch: Throwable -> L18
        af r20 = (af) ZeusTransformUtils.preCheckCast(this, af.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        d.n.f(Integer.valueOf(ZeusProviderTransform.delete(r3, r11, null, null, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L18
    L20:
        return r15;
    L18:
        th = move-exception;
        d.n.a r21 = d.n.f38560a;
        d.n.f(d.o.a(th));
        goto L20
    L21:
        int r22 = r14.getInt(MonitorConstants.CODE, 1);     // Catch: Throwable -> L48
        String r23 = r14.getString("message");     // Catch: Throwable -> L48
        if (r23 != null) goto L24;
        r23 = "";
    L24:
        if (r22 == 0) goto L35;
        CharSequence r24 = (CharSequence) ZeusTransformUtils.preCheckCast(r23, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L48
        if (d.o.o.d(r24) == false) goto L28;
        r24 = SensitiveType.UNKNOWN;
    L28:
        ak r25 = (ak) ZeusTransformUtils.preCheckCast(new ak.b(r22, (String) ZeusTransformUtils.preCheckCast(r24, String.class, "com.obric.aiagent.plugin")), ak.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L48
        d.n.a r26 = d.n.f38560a;     // Catch: Throwable -> L31
        af r27 = (af) ZeusTransformUtils.preCheckCast(this, af.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
        d.n.f(Integer.valueOf(ZeusProviderTransform.delete(r3, r11, null, null, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L31
    L33:
        return r25;
    L31:
        th = move-exception;
        d.n.a r28 = d.n.f38560a;
        d.n.f(d.o.a(th));
        goto L33
    L35:
        ak r29 = (ak) ZeusTransformUtils.preCheckCast(a(r14, r22, r23, r19), ak.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L48
        d.n.a r30 = d.n.f38560a;     // Catch: Throwable -> L38
        af r31 = (af) ZeusTransformUtils.preCheckCast(this, af.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L38
        d.n.f(Integer.valueOf(ZeusProviderTransform.delete(r3, r11, null, null, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L38
    L40:
        return r29;
    L38:
        th = move-exception;
        d.n.a r32 = d.n.f38560a;
        d.n.f(d.o.a(th));
        goto L40
    L41:
        th = move-exception;
        throw th;     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        d.f.c.a(r10, th);     // Catch: Throwable -> L48
        throw th;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        d.n.a r33 = d.n.f38560a;     // Catch: Throwable -> L52
        d.n.f(Integer.valueOf(ZeusProviderTransform.delete(r3, r11, null, null, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L52
        throw th;
    L52:
        th = move-exception;
        d.n.a r34 = d.n.f38560a;
        d.n.f(d.o.a(th));
        throw th;
    }

    private final ak.a a(Bundle r17, int r18, String r19, String r20) {
        String r0 = r17.getString("payload_base64");
        if (r0 == null) goto L41;
        byte[] r1 = Base64.decode(r0, 0);
        d.h.b.o.c(r1, "decode(...)");
        JSONObject r2 = new JSONObject(new String(r1, d.o.d.f38623b));
        if (r2.getInt("schema_version") != 3) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L39;
        if (d.h.b.o.a(r2.getString("snapshot_id"), r20) == false) goto L37;
        String r4 = r2.getString("outcome");
        if (d.h.b.o.a(r4, "success") == false) goto L14;
    L17:
        boolean r5 = true;
    L18:
        if (r5 == false) goto L35;
        int r6 = r2.getInt("failed");
        List r7 = d.a.p.a();
        JSONArray r8 = r2.getJSONArray("items");
        int r9 = r8.length();
        int r10 = 0;
    L20:
        if (r10 >= r9) goto L25;
        JSONObject r11 = r8.getJSONObject(r10);
        if (d.h.b.o.a(r11.getString("status"), "failed") == false) goto L24;
        String r12 = r11.optString("slug");
        d.h.b.o.c(r12, "optString(...)");
        String r13 = r11.getString("package_name");
        d.h.b.o.c(r13, "getString(...)");
        String r14 = r11.optString(WsConstants.KEY_APP_VERSION);
        d.h.b.o.c(r14, "optString(...)");
        String r15 = r11.optString("error_code", SensitiveType.UNKNOWN);
        d.h.b.o.c(r15, "optString(...)");
        r7.add(new al(r12, r13, r14, r15));
    L24:
        r10 = r10 + 1;
        goto L20
    L25:
        List r16 = d.a.p.a(r7);
        if (r6 != r16.size()) goto L28;
        boolean r21 = true;
    L29:
        if (r21 == false) goto L33;
        return new ak.a(r18, r19, r4, r16);
    L33:
        throw new IllegalArgumentException("sync_ack_failed_count_mismatch".toString());
    L28:
        r21 = false;
        goto L29
    L35:
        throw new IllegalArgumentException("invalid_sync_ack_outcome".toString());
    L14:
        if (d.h.b.o.a(r4, "partial") == true) goto L17;
        r5 = false;
        goto L18
    L37:
        throw new IllegalArgumentException("sync_ack_snapshot_mismatch".toString());
    L39:
        throw new IllegalArgumentException("invalid_sync_ack_schema".toString());
    L7:
        r3 = false;
        goto L8
    L41:
        throw new IllegalArgumentException("missing_sync_payload".toString());
    }

    private final void a(String r12, int r13, int r14, ak.a r15) {
        ILogDepend.Companion.i(TAG, "Spell sync completed snapshot=" + r12 + " skills=" + r13 + " code=" + r15.a() + " message=" + r15.b() + " outcome=" + r15.c() + " failed=" + r15.d().size() + " attempt=" + r14);
        a(r12, r13, r15.a(), r15.b(), r15.c(), r15.d().size(), r14);
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r15.d(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        al r16 = (al) ZeusTransformUtils.preCheckCast(r11.next(), al.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.e(TAG, "Spell sync item failed snapshot=" + r12 + " slug=" + r16.a() + " package=" + r16.b() + " version=" + r16.c() + " error=" + r16.d());
        ITraceDepend.Companion r17 = ITraceDepend.Companion;
        JSONObject r18 = new JSONObject().put("snapshot_id", r12).put("slug", r16.a()).put("package_name", r16.b()).put(WsConstants.KEY_APP_VERSION, r16.c()).put("error_code", r16.d());
        d.h.b.o.c(r18, "put(...)");
        r17.report("app_function_spell_skill_sync_failed_item", r18);
        goto L4
    }

    private final void a(String r3, int r4, int r5, String r6, String r7, int r8, int r9) {
        ITraceDepend.Companion r2 = ITraceDepend.Companion;
        JSONObject r10 = new JSONObject().put("snapshot_id", r3).put("skill_count", r4).put("provider_code", r5).put("provider_message", r6).put("outcome", r7).put("failed_count", r8).put("attempt", r9);
        d.h.b.o.c(r10, "put(...)");
        r2.report("app_function_spell_skill_sync", r10);
    }

    private final String a(byte[] r10) {
        byte[] r0 = MessageDigest.getInstance("SHA-256").digest(r10);
        d.h.b.o.c(r0, "digest(...)");
        return d.a.i.a(r0, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, $$Lambda$af$TPU60LsCfBCjmyYu3UXa2uwp8TY.INSTANCE, 30, null);
    }

    private static final CharSequence a(byte r3) {
        String r4 = String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(r3 & 255)}, 1));
        d.h.b.o.c(r4, "format(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
    }
}
