package com.bytedance.android.shopping.anchorv4.launcher;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.n;
import com.bytedance.android.shopping.anchorv4.launcher.bizHandler.g;
import com.bytedance.android.shopping.anchorv4.launcher.bizHandler.i;
import com.bytedance.android.shopping.anchorv4.perf.helper.PdpNetworkWarmup;
import com.bytedance.android.shopping.anchorv4.schemav2.o;
import com.bytedance.android.shopping.pre_purchase.arch.launch.ChainName;
import com.bytedance.android.shopping.pre_purchase.arch.launch.d;
import com.bytedance.android.shopping.pre_purchase.arch.launch.e;
import com.bytedance.android.shopping.slice.PdpSliceRegister;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import p83.h;

/* JADX INFO: loaded from: classes12.dex */
public final class PdpLauncher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f167002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f167003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f167004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f167005d;

    public final o a() {
        return (o) this.f167003b.getValue();
    }

    public final Context getContext() {
        return this.f167005d;
    }

    public PdpLauncher(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f167005d = r100;
        PdpSliceRegister.c();
        PdpSliceRegister.b(r100);
        PdpNetworkWarmup.a("PdpLauncher");
        this.f167002a = LazyKt.lazy(PdpLauncher$sessionId$2.INSTANCE);
        this.f167003b = LazyKt.lazy(new PdpLauncher$openPdpTrackListener$2(this));
    }

    public final void c(final Uri r100, final h r101) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, "pdpParams");
        Long r102 = r101.f528187u;
        if (r102 == null) goto L5;
        long r103 = r102.longValue();
    L6:
        this.f167004c = Long.valueOf(r103);
        Context r104 = this.f167005d;
        boolean r105 = true;
        if (r101.f528167a == true) goto L10;
        r105 = false;
    L10:
        n.c(r104, r105, new PdpLauncher$getCheckSuccessCB$1(this, r100, r101), new PdpLauncher$getCheckErrorCB$1(this, r100, r101));
        return;
    L5:
        r103 = System.currentTimeMillis();
        goto L6
    }

    public final void b(Uri r100, h r110, ze.a r111) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r110, "pdpParams");
        Intrinsics.checkNotNullParameter(r111, "preloadStrategy");
        e r101 = new e(this.f167005d, (String) this.f167002a.getValue(), null, null, this.f167004c, 12);
        a r102 = new a(r100, r110, a());
        com.bytedance.android.shopping.pre_purchase.arch.launch.c r103 = new com.bytedance.android.shopping.pre_purchase.arch.launch.c(ChainName.PDP_PRELOAD, r101, r102);
        Intrinsics.checkNotNullParameter(r103, "launchChain");
        com.bytedance.android.shopping.anchorv4.launcher.stage.c r104 = new com.bytedance.android.shopping.anchorv4.launcher.stage.c();
        r104.b(new g());
        r104.b(new i(r111));
        PdpLauncher$preload$1 r112 = PdpLauncher$preload$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r112, "callback");
        r104.f180671c = r112;
        Intrinsics.checkNotNullParameter(r104, "stage");
        Intrinsics.checkNotNullParameter(r104, "stage");
        com.bytedance.android.shopping.pre_purchase.arch.launch.b r113 = new com.bytedance.android.shopping.pre_purchase.arch.launch.b(r103, r104);
        Intrinsics.checkNotNullParameter(r113, "observer");
        r104.f180670b = r113;
        if (r103.f180655c != null) goto L5;
        r103.f180655c = r104;
    L8:
        r103.f180654b = r104;
        Intrinsics.checkNotNullParameter(r103, "launchChain");
        r103.a().k(r103.f180657e);
        Iterator<d> r114 = r103.f180653a.iterator();
    L10:
        if (r114.hasNext() == false) goto L17;
        r114.next().k(r103.f180657e);
        goto L10
    L17:
        int r115 = com.bytedance.android.shopping.pre_purchase.arch.launch.g.f180668e;     // Catch: Exception -> L14
        com.bytedance.android.shopping.pre_purchase.arch.launch.g.a.a(r103.f180658f, r103.f180655c, r103.f180659g);     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        ECExceptionMonitor.e(e);
        r103.b(e);
        throw e;
    L5:
        com.bytedance.android.shopping.pre_purchase.arch.launch.g<?, ?> r116 = r103.f180654b;
        if (r116 == null) goto L8;
        r116.f180672d = r104;
        goto L8
    }
}
