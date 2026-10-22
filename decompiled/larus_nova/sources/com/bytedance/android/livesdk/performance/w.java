package com.bytedance.android.livesdk.performance;

import android.os.Looper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.android.livesdkapi.service.INetworkChangeListener;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m0 f154821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m0 f154822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentLinkedQueue<INetworkChangeListener> f154823c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f154824d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f154825e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f154826f;

    public w() {
        this.f154823c = new ConcurrentLinkedQueue();
        this.f154824d = -2;
        this.f154825e = System.currentTimeMillis();
        this.f154826f = -2;
    }

    public final void b(int r100, int r101) {
        if (r100 >= 3) goto L5;
    L9:
        StringBuilder r102 = new StringBuilder("THREAD: ");
        if (ThreadMethodProxy.currentThread().getId() != ThreadMethodProxy.getLooperThread(Looper.getMainLooper()).getId()) goto L12;
        boolean r103 = true;
    L13:
        r102.append(r103);
        r102.append(' ');
        ALogger.e("wujl", r102.toString());
        Iterator<T> r104 = this.f154823c.iterator();
    L15:
        if (r104.hasNext() == false) goto L17;
        ((INetworkChangeListener) r104.next()).onChange(r100, r101);
        goto L15
    L17:
        return;
    L12:
        r103 = false;
        goto L13
    L5:
        if (r101 > 2) goto L9;
        if (r101 < (-1)) goto L9;
        this.f154825e = System.currentTimeMillis();
        goto L9
    }

    public static int a(int r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, "resolution");
        int r103 = r101.hashCode();
        if (r103 == 3118) goto L56;
        if (r103 == 3324) goto L49;
        if (r103 == 3448) goto L42;
        if (r103 == 3665) goto L36;
        if (r103 == 115761) goto L28;
        if (r103 == 3005871) goto L25;
        if (r103 == 106009353) goto L18;
        return r102;
    L18:
        if (r101.equals("orgin") == true) goto L20;
        return r102;
    L20:
        if (r100 < 200) goto L58;
        if (r100 < 600) goto L60;
    L61:
        return 3;
    L60:
        return 2;
    L58:
        return 1;
    L25:
        if (r101.equals("auto") == false) goto L64;
    L57:
        if (r100 < 300) goto L58;
        if (r100 >= 600) goto L61;
    L64:
        return r102;
    L28:
        if (r101.equals(PlayerResolution.SDKKEY.UHD) == true) goto L30;
        return r102;
    L30:
        if (r100 < 400) goto L58;
        if (r100 >= 900) goto L61;
    L36:
        if (r101.equals(PlayerResolution.SDKKEY.SD) == false) goto L66;
        if (r100 < 300) goto L58;
        if (r100 >= 600) goto L61;
    L66:
        return r102;
    L42:
        if (r101.equals(PlayerResolution.SDKKEY.LD) == false) goto L67;
        if (r100 < 300) goto L58;
        if (r100 >= 500) goto L61;
    L67:
        return r102;
    L49:
        if (r101.equals(PlayerResolution.SDKKEY.HD) == false) goto L68;
        if (r100 < 300) goto L58;
        if (r100 >= 700) goto L61;
    L68:
        return r102;
    L56:
        if (r101.equals("ao") == true) goto L57;
        return r102;
    }
}
