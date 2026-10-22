package com.bytedance.applet.debug.view;

import android.app.Activity;
import android.content.Context;
import com.bytedance.applet.debug.AppletDebugManager;
import com.larus.common.apphost.AppHost;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes14.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f191653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static x f191654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f191655c = null;

    static {
        f191655c = new AtomicBoolean(false);
    }

    public static void b(boolean r100) {
        if (f191655c.get() == false) goto L8;
        Activity r101 = AppHost.f326268a.a().getCurrentActivity();
        if (r101 == null) goto L9;
        a(r100, r101);
        return;
    L9:
        return;
    }

    public static void a(boolean r100, final Activity r101) {
        if (AppletDebugManager.f191566a == false) goto L6;
        if (r100 == false) goto L6;
        final boolean r102 = true;
    L7:
        if (r101 == null) goto L10;
        r101.runOnUiThread(new r(r102, r101));
        return;
    L10:
        return;
    L6:
        r102 = false;
        goto L7
    }
}
