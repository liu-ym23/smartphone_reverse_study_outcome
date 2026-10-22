package com.bytedance.frameworks.baselib.network.http.d;

import android.text.TextUtils;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.b.f;
import com.bytedance.frameworks.baselib.network.http.b.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: CookieManagerWrap.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private static final String TAG = "CookieManagerWrap";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f8275b = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.frameworks.baselib.network.http.b.d f8276a;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.d.b$1, reason: invalid class name */
    /* JADX INFO: compiled from: CookieManagerWrap.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: CookieManagerWrap.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f8277a = null;

        static /* synthetic */ b a() {
            return f8277a;
        }

        static {
            f8277a = new b(null);
        }
    }

    static {
    }

    /* synthetic */ b(AnonymousClass1 r1) {
        this();
    }

    private b() {
        long r0 = System.nanoTime();
        if (com.bytedance.frameworks.baselib.network.b.b.l() == false) goto L5;
        this.f8276a = null;
    L6:
        f8275b = (System.nanoTime() - r0) / 1000;
        return;
    L5:
        this.f8276a = new g();
        goto L6
    }

    public static b a() {
        return a.a();
    }

    boolean b() {
        com.bytedance.frameworks.baselib.network.http.b.d r0 = this.f8276a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a();
    }

    public String a(URI r3) {
        com.bytedance.frameworks.baselib.network.http.b.d r2 = this.f8276a;
        if (r2 != null) goto L10;
        return null;
    L10:
        return r2.a(r3);
    L7:
        th = move-exception;
        Logger.e(TAG, "getCookie error", th);
        return null;
    }

    Pair<String, Map<String, Set<f>>> b(URI r3) {
        com.bytedance.frameworks.baselib.network.http.b.d r2 = this.f8276a;
        if (r2 != null) goto L10;
        return null;
    L10:
        return r2.b(r3);
    L7:
        th = move-exception;
        Logger.e(TAG, "getCookieForRelTest error", th);
        return null;
    }

    void a(URI r8, List<String> r9, ValueCallback<Boolean> r10, boolean r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        ValueCallback r13 = (ValueCallback) ZeusTransformUtils.wrapperContextForParams(r10, ValueCallback.class, "com.obric.aiagent.plugin");
        if (this.f8276a == null) goto L23;
        if (r8 == null) goto L23;
        if (com.bytedance.common.utility.f.a(r12) == true) goto L23;
        boolean r1 = true;
        Iterator r14 = r12.iterator();
    L10:
        if (r14.hasNext() == false) goto L20;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r4) == true) goto L13;
    L18:
        th = move-exception;
        Logger.d(TAG, "setCookies error: " + r4, th);
        goto L13
    L15:
        if (this.f8276a.a(r8, r4, r11) == true) goto L10;
        Logger.d(TAG, "setCookies failed: " + r4);     // Catch: Throwable -> L18
    L13:
        r1 = false;
        goto L10
    L20:
        if (r13 == null) goto L34;
        r13.onReceiveValue(Boolean.valueOf(r1));
        return;
    L34:
        return;
    L23:
        if (r13 == null) goto L35;
        r13.onReceiveValue(false);
        return;
    }

    public boolean a(f r1) {
        com.bytedance.frameworks.baselib.network.http.b.d r0 = this.f8276a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a(r1);
    }

    public static long c() {
        return f8275b;
    }
}
