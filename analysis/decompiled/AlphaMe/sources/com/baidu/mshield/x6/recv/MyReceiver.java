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

/* loaded from: classes.dex */
public class MyReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f8534a = true;

    public class a extends com.baidu.mshield.x6.f.m.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f8535b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Intent f8536c;

        public a(MyReceiver myReceiver, Context context, Intent intent) {
            this.f8535b = context;
            this.f8536c = intent;
        }

        @Override // com.baidu.mshield.x6.f.m.a
        public void a() {
            MyReceiver.d(this.f8535b, this.f8536c);
        }
    }

    public static void a(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            if (!EngineImpl.isUnload && intent.getPackage().equals(context.getPackageName())) {
                String action = intent.getAction();
                if (action.equals("com.baidu.mshield.x6.alarm.work.finger")) {
                    try {
                        h.a(context).a(1, false);
                        com.baidu.mshield.b.c.a.a("report static alive for ALARM_WORK_DO_FINGER");
                        com.baidu.mshield.x6.f.a.b(context);
                    } catch (Throwable th) {
                        f.b(th);
                    }
                } else if (action.equals("com.baidu.mshield.x6.alarm.work.zid")) {
                    new b(context).g(false);
                    h.a(context).a(1);
                    com.baidu.mshield.b.c.a.a("report static alive for ALARM_WORK_DO_ZID");
                    com.baidu.mshield.x6.f.a.c(context);
                }
            }
        } catch (Throwable th2) {
            f.b(th2);
        }
    }

    public static synchronized void b(Context context, Intent intent) {
        if (EngineImpl.isUnload) {
            return;
        }
        try {
            if (d.b(context)) {
                if (!new b(context).n() && !h.f8498b) {
                    h.a(context).a(5);
                }
                h.a(context).a(1, false);
            }
        } catch (Throwable th) {
            f.b(th);
        }
    }

    public static void c(Context context, Intent intent) {
        try {
            if (EngineImpl.isUnload) {
                return;
            }
            h.a(context).b();
        } catch (Throwable th) {
            f.b(th);
        }
    }

    public static void d(Context context, Intent intent) {
        if (EngineImpl.isUnload || intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return;
        }
        action.getClass();
        if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            if (f8534a) {
                f8534a = false;
                return;
            } else {
                b(context, intent);
                return;
            }
        }
        if (action.equals("android.intent.action.SIM_STATE_CHANGED")) {
            c(context, intent);
        } else {
            a(context, intent);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        c.b().a(new a(this, context, intent));
    }
}
