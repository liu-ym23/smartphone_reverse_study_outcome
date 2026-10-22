package com.bytedance.bdinstall;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SubpSyncManager.java */
/* JADX INFO: loaded from: classes.dex */
final class az {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, String> f6161a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, List<a>> f6162b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final com.bytedance.bdinstall.j.r<az> f6163c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f6164d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AtomicBoolean f6165e;

    /* JADX INFO: compiled from: SubpSyncManager.java */
    public interface a {
        void a(String r1, String r2);
    }

    /* synthetic */ az(Context r2, AnonymousClass1 r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ Context a(az r0) {
        return r0.f6164d;
    }

    static /* synthetic */ void a(az r0, Uri r1) {
        r0.a(r1);
    }

    static {
        f6161a = new ConcurrentHashMap();
        f6162b = new ConcurrentHashMap();
        f6163c = new AnonymousClass1();
    }

    private az(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        this.f6165e = new AtomicBoolean(false);
        this.f6164d = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
    }

    static az a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        return (az) ZeusTransformUtils.preCheckCast(f6163c.c(new Object[]{r5}), az.class, "com.obric.aiagent.plugin");
    }

    void a(final String r4, String r5, String r6) {
        this.f6164d.getSharedPreferences("ug_install_op_pref", 0).edit().putString(r5 + "_" + r4, r6).apply();     // Catch: Exception -> L7
        Uri r0 = BDInstallProvider.getContentUri(this.f6164d, "install_info_change");     // Catch: Exception -> L7
        if (r0 != null) goto L5;
        return;
    L5:
        final Uri r7 = r0.buildUpon().appendQueryParameter("key", r5).appendQueryParameter(WsConstants.KEY_APP_ID, r4).appendQueryParameter("value", r6).build();     // Catch: Exception -> L7
        final int[] r8 = new int[1];     // Catch: Exception -> L7
        new AnonymousClass2(this, r7, r8, r4).run();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        t.b("sendSubpEvent error", e);
    }

    void a(String r4, String r5, a r6) {
        a r7 = (a) ZeusTransformUtils.wrapperContextForParams(r6, a.class, "com.obric.aiagent.plugin");
        a();
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        monitor-enter(this);
        a(r5, r7);     // Catch: Throwable -> L16
        Map<String, String> r0 = f6161a;     // Catch: Throwable -> L16
        if (r0.containsKey(r5) == false) goto L11;
        b((String) ZeusTransformUtils.preCheckCast(r0.get(r5), String.class, "com.obric.aiagent.plugin"), r4, r7);     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L11:
        String r8 = this.f6164d.getSharedPreferences("ug_install_op_pref", 0).getString(r5 + "_" + r4, null);     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r8) == true) goto L14;
        b(r8, r4, r7);     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    private void a(String r4, a r5) {
        a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.aiagent.plugin");
        Map<String, List<a>> r6 = f6162b;
        List<a> r0 = (List) ZeusTransformUtils.preCheckCast(r6.get(r4), List.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        r0 = new ArrayList();
        r6.put(r4, r0);
    L5:
        r0.add(r3);
    }

    private void b(String r2, String r3, a r4) {
        a r1 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L6;
        r1.a(r2, r3);
        return;
    }

    private void a(Uri r6) {
        monitor-enter(this);
        String r0 = r6.getQueryParameter("key");     // Catch: Throwable -> L21
        String r1 = r6.getQueryParameter("value");     // Catch: Throwable -> L21
        String r7 = r6.getQueryParameter(WsConstants.KEY_APP_ID);     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r0) == false) goto L6;
    L18:
        t.c("multi process: key or value is nullvalue: " + r1 + " aid ：" + r7);     // Catch: Throwable -> L21
        monitor-exit(this);     // Catch: Throwable -> L21
        return;
    L6:
        if (TextUtils.isEmpty(r1) == true) goto L18;
        f6161a.put(r0, r1);     // Catch: Throwable -> L21
        t.a("install_info 发送到子进程 onUpdate " + r1 + " aid ：" + r7);     // Catch: Throwable -> L21
        List r2 = (List) ZeusTransformUtils.preCheckCast(f6162b.get(r0), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        if (r2 == null) goto L16;
        Iterator r3 = r2.iterator();     // Catch: Throwable -> L21
    L12:
        if (r3.hasNext() == false) goto L16;
        a r4 = (a) ZeusTransformUtils.preCheckCast(r3.next(), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        if (r4 == null) goto L12;
        r4.a(r1, r7);     // Catch: Throwable -> L21
    L16:
        monitor-exit(this);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        throw th;
    }

    private void a() {
        if (this.f6165e.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        Uri r0 = BDInstallProvider.getContentUri(this.f6164d, "install_info_change");
        if (r0 != null) goto L8;
        return;
    L8:
        ContentResolver r1 = this.f6164d.getContentResolver();
        final Handler r4 = w.a();
        ZeusProviderTransform.registerContentObserver(r1, r0, true, new SubpSyncManager$3(this, r4), "com.obric.aiagent.plugin");
    }
}
