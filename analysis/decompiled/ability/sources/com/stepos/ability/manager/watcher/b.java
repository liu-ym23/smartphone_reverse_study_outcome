package com.stepos.ability.manager.watcher;

import W3.c;
import android.content.Context;
import android.util.Log;
import com.stepos.ability.commoninternal.AppInfoUtils;
import com.stepos.ability.net.INet;
import d4.d;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import s9.C1923c;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final INet f3169a;
    public String b;
    public final d c;
    public final W3.b d;
    public final c e;
    public Context f;
    public final C1923c g;
    public final a h;

    public b(INet iNet, String deviceId, d uploadGate, W3.b bVar, c cVar) {
        k.f(iNet, "iNet");
        k.f(deviceId, "deviceId");
        k.f(uploadGate, "uploadGate");
        this.f3169a = iNet;
        this.b = deviceId;
        this.c = uploadGate;
        this.d = bVar;
        this.e = cVar;
        u9.d dVar = AbstractC1691I.f5315a;
        this.g = AbstractC1683A.b(u9.c.f6743a);
        this.h = new a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(com.stepos.ability.manager.watcher.b r25, java.lang.String r26, java.util.List r27, java.util.List r28, java.util.List r29, java.util.List r30, java.lang.String r31, android.content.Context r32, com.stepos.mcp.sdk.java.ServerExt r33, kotlin.coroutines.jvm.internal.ContinuationImpl r34) {
        /*
            Method dump skipped, instructions count: 563
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.manager.watcher.b.a(com.stepos.ability.manager.watcher.b, java.lang.String, java.util.List, java.util.List, java.util.List, java.util.List, java.lang.String, android.content.Context, com.stepos.mcp.sdk.java.ServerExt, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final void b(Context context, String str, boolean z10) {
        AppInfoUtils.AppInfo appInfo = AppInfoUtils.INSTANCE.getAppInfo(context, str);
        if (appInfo == null) {
            Log.w("AbilityInstallerWatcher", "handleAppUpdated. appInfo is null.");
        } else {
            AbstractC1683A.n(this.g, null, new AbilityInstallerWatcher$refreshAndUpload$1(this, context, str, z10, appInfo, null), 3);
        }
    }
}
