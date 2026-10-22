package com.bytedance.android.bcm.impl.monitor;

import com.bytedance.android.btm.impl.setting.i;
import com.bytedance.android.btm.impl.setting.k;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f41838a = 0;

    public b() {
    }

    static {
    }

    public static final k a(i r100, JSONObject r101) {
        Iterator<k> r102 = r100.a().iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        k r103 = r102.next();
        if (r103.c().isEmpty() == true) goto L16;
        if (r103.c().contains(r101.optString(r103.b())) == false) goto L4;
        return r103;
    L16:
        return r103;
    L11:
        return new k();
    }

    public static void b(final int r100, String r110, String r111, String r112, Throwable r113, Function1 r114, int r115) {
        if ((r115 & 2) == 0) goto L5;
        r110 = "";
    L5:
        final String r101 = r110;
        if ((r115 & 4) == 0) goto L8;
        final String r102 = null;
    L10:
        if ((r115 & 8) == 0) goto L12;
        final String r103 = null;
    L13:
        final boolean r104 = false;
        if ((r115 & 32) == 0) goto L16;
        final BcmMonitor$monitor$1 r105 = BcmMonitor$monitor$1.INSTANCE;
    L18:
        if ((r115 & 64) == 0) goto L20;
        final Throwable r106 = null;
    L22:
        if ((r115 & 128) == 0) goto L24;
        r114 = BcmMonitor$monitor$2.INSTANCE;
    L24:
        final Function1 r107 = r114;
        com.bytedance.android.btm.impl.thread.b.f42488e.a(new BcmMonitor$monitor$runnable$1(r103, r100, r107, r101, r105, r106, r104, r102), true);
        return;
    L20:
        r106 = r113;
        goto L22
    L16:
        r105 = null;
        goto L18
    L12:
        r103 = r112;
        goto L13
    L8:
        r102 = r111;
        goto L10
    }

    public static void c(final int r110, final com.bytedance.android.bcm.impl.paramcheck.checker.b r111, String r112, String r113, final String r114, String r115, int r116) {
        if ((r116 & 4) == 0) goto L5;
        final String r100 = null;
    L7:
        if ((r116 & 8) == 0) goto L9;
        final String r101 = null;
    L11:
        if ((r116 & 32) == 0) goto L13;
        final String r102 = null;
    L14:
        final String r103 = null;
        final boolean r117 = false;
        com.bytedance.android.btm.impl.thread.b.f42488e.a(new BcmMonitor$monitorParamsCheck$runnable$1(r100, r110, r101, r102, r114, r103, r111, r117), true);
        return;
    L13:
        r102 = r115;
        goto L14
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
