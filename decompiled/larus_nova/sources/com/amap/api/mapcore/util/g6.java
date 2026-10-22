package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.ttm.player.MediaPlayer;
import java.lang.ref.WeakReference;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public final class g6 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f27318c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static g6 f27319d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f27320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f27321b;

    public class a extends PthreadThreadV2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f27322a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f27323b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ g6 f27324c;

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public final void run() {
            com_amap_api_mapcore_util_g6$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public final void com_amap_api_mapcore_util_g6$a__run$___twin___() {
            String r100 = l6.b(this.f27322a);
            if (TextUtils.isEmpty(r100) == false) goto L5;
            return;
        L5:
            if ((this.f27323b & 1) <= 0) goto L15;
            if (Build.VERSION.SDK_INT >= 23) goto L9;
            Settings.System.putString(g6.a(this.f27324c).getContentResolver(), g6.b(this.f27324c), r100);     // Catch: Exception -> L13
        L21:
            goto L15
        L9:
            if (Settings.System.canWrite(g6.a(this.f27324c)) == false) goto L21;
            Settings.System.putString(g6.a(this.f27324c).getContentResolver(), g6.b(this.f27324c), r100);     // Catch: Exception -> L13
        L15:
            if ((this.f27323b & 16) <= 0) goto L18;
            i6.a(g6.a(this.f27324c), g6.b(this.f27324c), r100);
        L18:
            if ((this.f27323b & 256) <= 0) goto L25;
            SharedPreferences.Editor r101 = g6.a(this.f27324c).getSharedPreferences(g6.f27318c, 0).edit();
            r101.putString(g6.b(this.f27324c), r100);
            r101.apply();
            return;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_amap_api_mapcore_util_g6$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_amap_api_mapcore_util_g6$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(g6 r100, String r101, int r102) {
            this.f27324c = r100;
            this.f27322a = r101;
            this.f27323b = r102;
            super("ore/util/g6$a");
        }
    }

    public static final class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<g6> f27325a;

        public b(g6 r100) {
            this.f27325a = new WeakReference(r100);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            g6 r101 = this.f27325a.get();
            if (r101 != null) goto L5;
            return;
        L5:
            if (r100 == null) goto L11;
            Object r102 = r100.obj;
            if (r102 == null) goto L12;
            g6.a(r101, (String) r102, r100.what);
            return;
        L12:
            return;
        }

        public b(Looper r100, g6 r101) {
            super(r100);
            this.f27325a = new WeakReference(r101);
        }
    }

    static {
        f27318c = x5.b("SU2hhcmVkUHJlZmVyZW5jZUFkaXU");
    }

    private g6(Context r100) {
        this.f27321b = r100.getApplicationContext();
        if (Looper.myLooper() != null) goto L6;
        new b(Looper.getMainLooper(), this);
        return;
    L6:
        new b(this);
    }

    public static g6 a(Context r100) {
        if (f27319d != null) goto L15;
        monitor-enter(g6.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f27319d != null) goto L9;
        f27319d = new g6(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(g6.class);     // Catch: Throwable -> L11
    L15:
        return f27319d;
    }

    public final void b(String r100) {
        a(r100, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME);
    }

    public static /* synthetic */ Context a(g6 r100) {
        return r100.f27321b;
    }

    public static /* synthetic */ String b(g6 r100) {
        return r100.f27320a;
    }

    public final void a(String r100) {
        this.f27320a = r100;
    }

    private synchronized void a(String r100, int r101) {
        monitor-enter(this);
    L28:
        th = move-exception;
        throw th;
    L4:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L8;
        ThreadMethodProxy.start(new a(this, r100, r101));     // Catch: Throwable -> L28
        monitor-exit(this);
        return;
    L8:
        String r102 = l6.b(r100);     // Catch: Throwable -> L28
        if (TextUtils.isEmpty(r102) == false) goto L11;
    L26:
        monitor-exit(this);
        return;
    L11:
        if ((r101 & 1) <= 0) goto L19;
        if (Build.VERSION.SDK_INT < 23) goto L15;
        Settings.System.putString(this.f27321b.getContentResolver(), this.f27320a, r102);     // Catch: Exception -> L17 Throwable -> L28
    L32:
        goto L19
    L15:
        Settings.System.putString(this.f27321b.getContentResolver(), this.f27320a, r102);     // Catch: Exception -> L17 Throwable -> L28
    L19:
        if ((r101 & 16) <= 0) goto L22;
        i6.a(this.f27321b, this.f27320a, r102);     // Catch: Throwable -> L28
    L22:
        if ((r101 & 256) <= 0) goto L26;
        SharedPreferences.Editor r103 = this.f27321b.getSharedPreferences(f27318c, 0).edit();     // Catch: Throwable -> L28
        r103.putString(this.f27320a, r102);     // Catch: Throwable -> L28
        r103.apply();     // Catch: Throwable -> L28
        monitor-exit(this);
    }

    public static /* synthetic */ void a(g6 r100, String r101, int r102) {
        r100.a(r101, r102);
    }
}
