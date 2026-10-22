package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.text.TextUtils;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.PreloadCompConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;

/* JADX INFO: loaded from: classes8.dex */
public final class y3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile x3 f116848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile g3 f116849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile g3 f116850c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile o f116851d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile x3 f116852e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile HashMap<String, x3> f116853f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile HashMap<String, g3> f116854g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile HashMap<String, g3> f116855h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile HashMap<String, o> f116856i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile HashMap<String, x3> f116857j;

    static {
        f116853f = new HashMap();
        f116854g = new HashMap();
        f116855h = new HashMap();
        f116856i = new HashMap();
        f116857j = new HashMap();
    }

    public static o a() {
        if (f116851d != null) goto L15;
        monitor-enter(y3.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f116851d != null) goto L9;
        f116851d = new o(l(), e());     // Catch: Throwable -> L11
    L9:
        monitor-exit(y3.class);     // Catch: Throwable -> L11
    L15:
        return f116851d;
    }

    public static synchronized void d() {
        monitor-enter(y3.class);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (f116848a == null) goto L8;
        f116848a.H(true);     // Catch: Throwable -> L19
    L8:
        if (f116849b == null) goto L11;
        f116849b.H(true);     // Catch: Throwable -> L19
    L11:
        if (f116850c == null) goto L14;
        f116850c.H(true);     // Catch: Throwable -> L19
    L14:
        if (f116852e == null) goto L16;
        f116852e.H(true);     // Catch: Throwable -> L19
    L16:
        f116848a = new x3(true);     // Catch: Throwable -> L19
        f116849b = new g3();     // Catch: Throwable -> L19
        f116850c = new g3();     // Catch: Throwable -> L19
        f116851d = new o(f116848a, f116849b);     // Catch: Throwable -> L19
        f116852e = new x3(true);     // Catch: Throwable -> L19
        monitor-exit(y3.class);
    }

    public static g3 e() {
        if (f116849b != null) goto L15;
        monitor-enter(y3.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f116849b != null) goto L9;
        f116849b = new g3();     // Catch: Throwable -> L11
    L9:
        monitor-exit(y3.class);     // Catch: Throwable -> L11
    L15:
        return f116849b;
    }

    public static synchronized void j() {
        monitor-enter(y3.class);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (f116849b == null) goto L8;
        f116849b.H(true);     // Catch: Throwable -> L21
        f116849b = null;     // Catch: Throwable -> L21
    L8:
        if (f116848a == null) goto L11;
        f116848a.H(true);     // Catch: Throwable -> L21
        f116848a = null;     // Catch: Throwable -> L21
    L11:
        if (f116850c == null) goto L14;
        f116850c.H(true);     // Catch: Throwable -> L21
        f116850c = null;     // Catch: Throwable -> L21
    L14:
        if (f116852e == null) goto L17;
        f116852e.H(true);     // Catch: Throwable -> L21
        f116852e = null;     // Catch: Throwable -> L21
    L17:
        if (f116851d == null) goto L19;
        f116851d = null;     // Catch: Throwable -> L21
    L19:
        monitor-exit(y3.class);
    }

    public static x3 l() {
        if (f116848a != null) goto L15;
        monitor-enter(y3.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f116848a != null) goto L9;
        f116848a = new x3(true);     // Catch: Throwable -> L11
    L9:
        monitor-exit(y3.class);     // Catch: Throwable -> L11
    L15:
        return f116848a;
    }

    public y3() {
    }

    public static c0 b(DataCenter r100) {
        c(r100);
        if (h(r100) == false) goto L10;
        String r101 = (String) r100.get("data_room_unique_id", null);
        if (f116856i.get(r101) != null) goto L8;
        o r102 = new o(m(r100), f(r100));
        f116856i.put(r101, r102);
    L8:
        return f116856i.get(r101);
    L10:
        return a();
    }

    public static void c(DataCenter r100) {
        if (r100 == null) goto L4;
        return;
    L4:
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L9;
        com.bytedance.crash.d.b("ToolbarManagerProvider, dataCenter is null or unique is null");
        return;
    }

    public static g3 f(DataCenter r100) {
        c(r100);
        if (h(r100) == false) goto L10;
        String r101 = (String) r100.get("data_room_unique_id", null);
        if (f116854g.get(r101) != null) goto L8;
        g3 r102 = new g3();
        f116854g.put(r101, r102);
    L8:
        return f116854g.get(r101);
    L10:
        return e();
    }

    public static synchronized void g(DataCenter r100) {
        monitor-enter(y3.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (h(r100) == true) goto L8;
        d();     // Catch: Throwable -> L10
    L8:
        monitor-exit(y3.class);
    }

    public static boolean h(DataCenter r100) {
        if (r100 == null) goto L11;
        boolean r101 = ((Boolean) r100.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        if (TextUtils.isEmpty((String) r100.get("data_room_unique_id", null)) == true) goto L12;
        if (r101 == false) goto L8;
        return false;
    L8:
        if (PreloadCompConfig.INSTANCE.enableToolbar() == false) goto L14;
        return true;
    L14:
        return false;
    L12:
        return false;
    L11:
        return false;
    }

    public static c0 i(DataCenter r100) {
        c(r100);
        if (h(r100) == false) goto L10;
        String r101 = (String) r100.get("data_room_unique_id", null);
        if (f116855h.get(r101) != null) goto L8;
        g3 r102 = new g3();
        f116855h.put(r101, r102);
    L8:
        return f116855h.get(r101);
    L10:
        if (f116850c != null) goto L22;
        monitor-enter(y3.class);
    L18:
        th = move-exception;
        throw th;
    L14:
        if (f116850c != null) goto L16;
        f116850c = new g3();     // Catch: Throwable -> L18
    L16:
        monitor-exit(y3.class);     // Catch: Throwable -> L18
    L22:
        return f116850c;
    }

    public static synchronized void k(DataCenter r100) {
        monitor-enter(y3.class);
        c(r100);     // Catch: Throwable -> L24
        if (h(r100) == false) goto L21;
        String r101 = (String) r100.get("data_room_unique_id", null);     // Catch: Throwable -> L24
        if (f116853f.get(r101) == null) goto L10;
        f116853f.remove(r101).H(true);     // Catch: Throwable -> L24
    L10:
        if (f116854g.get(r101) == null) goto L13;
        f116854g.remove(r101).H(true);     // Catch: Throwable -> L24
    L13:
        if (f116855h.get(r101) == null) goto L16;
        f116855h.remove(r101).H(true);     // Catch: Throwable -> L24
    L16:
        if (f116857j.get(r101) == null) goto L19;
        f116857j.remove(r101).H(true);     // Catch: Throwable -> L24
    L19:
        if (f116856i.get(r101) == null) goto L22;
        f116856i.remove(r101);     // Catch: Throwable -> L24
    L22:
        monitor-exit(y3.class);
        return;
    L21:
        j();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    public static c0 m(DataCenter r100) {
        c(r100);
        if (h(r100) == false) goto L10;
        String r101 = (String) r100.get("data_room_unique_id", null);
        if (f116853f.get(r101) != null) goto L8;
        x3 r102 = new x3(true);
        f116853f.put(r101, r102);
    L8:
        return f116853f.get(r101);
    L10:
        return l();
    }

    public static c0 n(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L12;
        if (PreloadCompConfig.INSTANCE.enableToolbar() == false) goto L12;
        if (f116853f.get(r100) != null) goto L10;
        x3 r101 = new x3(true);
        f116853f.put(r100, r101);
    L10:
        return f116853f.get(r100);
    L12:
        return l();
    }
}
