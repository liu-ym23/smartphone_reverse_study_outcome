package com.bytedance.android.live.broadcastgame.opengame.runtime;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0006B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/runtime/BootInfoService;", "Ly10/a;", "Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;", "pluginContext", "<init>", "(Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BootInfoService implements y10.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f60767c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f60768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PluginContext f60769b;

    public static final class a {
    }

    static {
    }

    public final g c() {
        return (g) this.f60768a.getValue();
    }

    @Override // y10.a
    public final void g() {
    }

    public final boolean a() {
        g r100 = c();
        if (r100 == null) goto L15;
        j r101 = r100.f60835b;
        if (r101 == null) goto L20;
        List<com.bytedance.android.live.broadcastgame.opengame.network.a.C0989a> r102 = r101.f60839a;
        if (r102 == null) goto L21;
        Iterator<T> r103 = r102.iterator();
    L10:
        if (r103.hasNext() == false) goto L22;
        if (Intrinsics.areEqual(((com.bytedance.android.live.broadcastgame.opengame.network.a.C0989a) r103.next()).c(), "switchScreen") == false) goto L10;
        return true;
    L22:
        return false;
    L21:
        return false;
    L20:
        return false;
    L15:
        return false;
    }

    public final String e() {
        g r100 = c();
        if (r100 == null) goto L8;
        j r101 = r100.f60835b;
        if (r101 == null) goto L8;
        String r102 = r101.f60844f;
        if (r102 == null) goto L8;
        return r102;
    L8:
        return "unknown";
    }

    public BootInfoService(PluginContext r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginContext");
        this.f60769b = r100;
        this.f60768a = LazyKt.lazy(new BootInfoService$bootInfo$2(this));
    }

    public final String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cipherText");
        long r101 = this.f60769b.f60809m.f61075a;
        g r102 = c();
        if (r102 == null) goto L5;
        String r103 = r102.f60834a;
    L6:
        if (r103 != null) goto L8;
    L15:
        return null;
    L8:
        if (r100.length() != 0) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == true) goto L15;
        return com.bytedance.android.live.broadcastgame.opengame.utils.f.b(r100, r101, r103);
    L10:
        r104 = false;
        goto L11
    L5:
        r103 = null;
        goto L6
    }

    public final com.bytedance.android.live.broadcastgame.opengame.openapi.p d(String r100) {
        Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
        g r101 = c();
        if (r101 == null) goto L15;
        j r102 = r101.f60835b;
        if (r102 == null) goto L20;
        List<com.bytedance.android.live.broadcastgame.opengame.network.a.C0989a> r103 = r102.f60839a;
        if (r103 == null) goto L21;
        Iterator<T> r104 = r103.iterator();
    L10:
        if (r104.hasNext() == false) goto L22;
        com.bytedance.android.live.broadcastgame.opengame.network.a.C0989a r105 = (com.bytedance.android.live.broadcastgame.opengame.network.a.C0989a) r104.next();
        if (Intrinsics.areEqual(r100, r105.c()) == false) goto L10;
        return new com.bytedance.android.live.broadcastgame.opengame.openapi.p(r105.b(), r105.d());
    L22:
        return null;
    L21:
        return null;
    L20:
        return null;
    L15:
        return null;
    }
}
