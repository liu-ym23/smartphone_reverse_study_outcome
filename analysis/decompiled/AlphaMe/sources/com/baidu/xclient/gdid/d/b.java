package com.baidu.xclient.gdid.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.xclient.gdid.d;

/* loaded from: classes.dex */
public class b extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static String f9514a = "action_tir_mshield";

    /* renamed from: b, reason: collision with root package name */
    public boolean f9515b = true;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Intent f9516a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f9517b;

        public a(Intent intent, Context context) {
            this.f9516a = intent;
            this.f9517b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Intent intent = this.f9516a;
                if (intent == null) {
                    return;
                }
                String action = intent.getAction();
                if (b.f9514a.equals(action)) {
                    d.a().a(false, true);
                    return;
                }
                if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                    if (b.this.f9515b) {
                        b.this.f9515b = false;
                    } else if (com.baidu.xclient.gdid.j.d.a(this.f9517b)) {
                        d.a().a(false, false);
                    }
                }
            } catch (Throwable th) {
                com.baidu.xclient.gdid.j.d.a(th);
            }
        }
    }

    public final void a(Context context, Intent intent) {
        com.baidu.xclient.gdid.j.b.a().a(new a(intent, context));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            a(context, intent);
        } catch (Throwable th) {
            com.baidu.xclient.gdid.j.d.a(th);
        }
    }
}
