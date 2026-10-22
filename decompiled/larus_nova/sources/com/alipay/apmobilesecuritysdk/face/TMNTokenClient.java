package com.alipay.apmobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.otherid.UtdidWrapper;
import com.alipay.sdk.m.l.b;
import com.alipay.sdk.m.z.a;
import java.util.HashMap;

/* JADX INFO: loaded from: classes28.dex */
public class TMNTokenClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static TMNTokenClient f25122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f25123b;

    public interface InitResultListener {
        void onResult(String r100, int r101);
    }

    public TMNTokenClient(Context r100) {
        this.f25123b = null;
        if (r100 == null) goto L7;
        this.f25123b = r100;
        return;
    L7:
        throw new IllegalArgumentException("TMNTokenClient initialization error: context is null.");
    }

    public static /* synthetic */ Context a(TMNTokenClient r100) {
        return r100.f25123b;
    }

    public static TMNTokenClient getInstance(Context r100) {
        if (f25122a != null) goto L15;
        monitor-enter(TMNTokenClient.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f25122a != null) goto L9;
        f25122a = new TMNTokenClient(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(TMNTokenClient.class);     // Catch: Throwable -> L11
    L15:
        return f25122a;
    }

    public void intiToken(final String r100, String r101, String r102, final InitResultListener r103) {
        if (a.a(r100) == false) goto L7;
        if (r103 == null) goto L7;
        r103.onResult("", 2);
    L7:
        if (a.a(r101) == false) goto L10;
        if (r103 == null) goto L10;
        r103.onResult("", 3);
    L10:
        final HashMap r104 = new HashMap();
        r104.put(b.f25485g, UtdidWrapper.getUtdid(this.f25123b));
        r104.put("tid", "");
        r104.put("userId", "");
        r104.put("appName", r100);
        r104.put("appKeyClient", r101);
        r104.put("appchannel", "openapi");
        r104.put("sessionId", r102);
        r104.put("rpcVersion", "8");
        com.alipay.apmobilesecuritysdk.f.b.a().a(new AnonymousClass1(this, r104, r103, r100));
    }
}
