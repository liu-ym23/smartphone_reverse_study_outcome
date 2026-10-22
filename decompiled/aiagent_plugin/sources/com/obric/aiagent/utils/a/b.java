package com.obric.aiagent.utils.a;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: ScreenStateManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final String TAG = "ScreenStateManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f22307a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f22308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f22309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final IntentFilter f22310d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final CopyOnWriteArraySet<a> f22311e = null;
    private static final C0485b f = null;

    /* JADX INFO: compiled from: ScreenStateManager.kt */
    public interface a {
        void onScreenStateChanged(boolean r1);
    }

    /* JADX INFO: renamed from: com.obric.aiagent.utils.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ScreenStateManager.kt */
    public static final class C0485b extends PluginBroadcastReceiver {
        C0485b() {
        }

        public void onReceive(Context r2, Intent r3) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            if (r3 == null) goto L5;
            String r4 = r3.getAction();
        L6:
            if (r4 == null) goto L27;
            int r5 = r4.hashCode();
            if (r5 == (-2128145023)) goto L23;
            if (r5 == (-1454123155)) goto L19;
            if (r5 == 823795052) goto L15;
            return;
        L15:
            if (r4.equals("android.intent.action.USER_PRESENT") == false) goto L31;
            b.b(b.f22307a);
            return;
        L31:
            return;
        L19:
            if (r4.equals("android.intent.action.SCREEN_ON") == false) goto L32;
            b.b(b.f22307a);
            return;
        L32:
            return;
        L23:
            if (r4.equals("android.intent.action.SCREEN_OFF") == false) goto L33;
            b.a(b.f22307a);
            return;
        L33:
            return;
        L27:
            return;
        L5:
            r4 = null;
            goto L6
        }
    }

    private b() {
    }

    public static final /* synthetic */ void a(b r0) {
        r0.c();
    }

    public static final /* synthetic */ void b(b r0) {
        r0.d();
    }

    public final boolean a() {
        return f22308b;
    }

    static {
        f22307a = new b();
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.intent.action.SCREEN_OFF");
        r0.addAction("android.intent.action.SCREEN_ON");
        r0.addAction("android.intent.action.USER_PRESENT");
        f22310d = r0;
        f22311e = new CopyOnWriteArraySet();
        C0485b r1 = new C0485b();
        f = r1;
        ZeusTransformUtils.registerReceiver((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(r1, PluginBroadcastReceiver.class, "com.obric.aiagent.plugin"), r0, "com.obric.aiagent.plugin");
        PowerManager r2 = (PowerManager) ZeusTransformUtils.preCheckCast(androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), PowerManager.class), PowerManager.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L5;
        boolean r3 = r2.isInteractive();
    L6:
        ILogDepend.Companion r4 = ILogDepend.Companion;
        StringBuilder r5 = new StringBuilder().append("init state -> ");
        if (r3 == false) goto L9;
        String r6 = "on";
    L10:
        r4.i(TAG, r5.append(r6).toString());
        f22308b = r3;
        f22309c = IAppContext.Companion.getCurrentTimeMillis();
        return;
    L9:
        r6 = "off";
        goto L10
    L5:
        r3 = true;
        goto L6
    }

    private final void c() {
        if (f22308b == true) goto L5;
        return;
    L5:
        f22308b = false;
        ILogDepend.Companion.i(TAG, "screen state -> off");
        f22309c = IAppContext.Companion.getCurrentTimeMillis();
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(f22311e, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((a) ZeusTransformUtils.preCheckCast(r0.next(), a.class, "com.obric.aiagent.plugin")).onScreenStateChanged(false);
        goto L7
    }

    private final void d() {
        if (f22308b == false) goto L5;
        return;
    L5:
        f22308b = true;
        ILogDepend.Companion.i(TAG, "screen state -> on");
        f22309c = IAppContext.Companion.getCurrentTimeMillis();
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(f22311e, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((a) ZeusTransformUtils.preCheckCast(r0.next(), a.class, "com.obric.aiagent.plugin")).onScreenStateChanged(true);
        goto L7
    }

    public final void a(a r2) {
        a r1 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
        o.e(r1, "listener");
        f22311e.add(r1);
    }

    public final long b() {
        return IAppContext.Companion.getCurrentTimeMillis() - f22309c;
    }
}
