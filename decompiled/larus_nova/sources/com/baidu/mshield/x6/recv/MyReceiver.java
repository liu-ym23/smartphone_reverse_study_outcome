package com.baidu.mshield.x6.recv;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.mshield.b.a.d;
import com.baidu.mshield.x6.EngineImpl;
import com.baidu.mshield.x6.b.b;
import com.baidu.mshield.x6.e.h;
import com.baidu.mshield.x6.f.f;
import com.baidu.mshield.x6.f.m.c;

/* JADX INFO: loaded from: classes39.dex */
public class MyReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f32633a = true;

    public class a extends com.baidu.mshield.x6.f.m.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f32634b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Intent f32635c;

        @Override // com.baidu.mshield.x6.f.m.a
        public void a() {
            MyReceiver.d(this.f32634b, this.f32635c);
        }

        public a(MyReceiver r100, Context r101, Intent r102) {
            this.f32634b = r101;
            this.f32635c = r102;
        }
    }

    public MyReceiver() {
    }

    public static void a(Context r100, Intent r101) {
        if (r101 != null) goto L27;
        return;
    L27:
    L21:
        th = move-exception;
        f.b(th);
        return;
    L5:
        if (EngineImpl.isUnload == false) goto L8;
        return;
    L8:
        if (r101.getPackage().equals(r100.getPackageName()) == true) goto L10;
        return;
    L10:
        String r102 = r101.getAction();     // Catch: Throwable -> L21
        if (r102.equals("com.baidu.mshield.x6.alarm.work.finger") == false) goto L18;
        h.a(r100).a(1, false);     // Catch: Throwable -> L15
        com.baidu.mshield.b.c.a.a("report static alive for ALARM_WORK_DO_FINGER");     // Catch: Throwable -> L15
        com.baidu.mshield.x6.f.a.b(r100);     // Catch: Throwable -> L15
    L26:
        return;
    L15:
        th = move-exception;
        f.b(th);     // Catch: Throwable -> L21
        goto L26
    L18:
        if (r102.equals("com.baidu.mshield.x6.alarm.work.zid") == false) goto L26;
        new b(r100).g(false);     // Catch: Throwable -> L21
        h.a(r100).a(1);     // Catch: Throwable -> L21
        com.baidu.mshield.b.c.a.a("report static alive for ALARM_WORK_DO_ZID");     // Catch: Throwable -> L21
        com.baidu.mshield.x6.f.a.c(r100);     // Catch: Throwable -> L21
        goto L26
    }

    public static synchronized void b(Context r100, Intent r101) {
        monitor-enter(MyReceiver.class);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (EngineImpl.isUnload == false) goto L24;
        monitor-exit(MyReceiver.class);
        return;
    L24:
    L17:
        th = move-exception;
        f.b(th);     // Catch: Throwable -> L21
    L19:
        monitor-exit(MyReceiver.class);
        return;
    L9:
        if (d.b(r100) == false) goto L19;
        if (new b(r100).n() == false) goto L13;
    L15:
        h.a(r100).a(1, false);     // Catch: Throwable -> L17
    L13:
        if (h.f32597b == true) goto L15;
        h.a(r100).a(5);     // Catch: Throwable -> L17
        goto L15
    }

    public static void c(Context r100, Intent r101) {
    L7:
        th = move-exception;
        f.b(th);
        return;
    L3:
        if (EngineImpl.isUnload == false) goto L5;
        return;
    L5:
        h.a(r100).b();     // Catch: Throwable -> L7
    }

    public static void d(Context r100, Intent r101) {
        if (EngineImpl.isUnload == false) goto L5;
        return;
    L5:
        if (r101 == null) goto L19;
        String r102 = r101.getAction();
        if (TextUtils.isEmpty(r102) == true) goto L20;
        r102.getClass();
        if (r102.equals("android.net.conn.CONNECTIVITY_CHANGE") == true) goto L15;
        if (r102.equals("android.intent.action.SIM_STATE_CHANGED") == true) goto L13;
        a(r100, r101);
        return;
    L13:
        c(r100, r101);
        return;
    L15:
        if (f32633a == true) goto L17;
        b(r100, r101);
        return;
    L17:
        f32633a = false;
        return;
    L20:
        return;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r100, Intent r101) {
        c.b().a(new a(this, r100, r101));
    }
}
