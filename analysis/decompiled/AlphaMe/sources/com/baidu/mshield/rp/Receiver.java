package com.baidu.mshield.rp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import ch.qos.logback.core.CoreConstants;
import com.baidu.mshield.utility.b;

/* loaded from: classes.dex */
public class Receiver extends BroadcastReceiver {

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f8292a;

        public a(Receiver receiver, Context context) {
            this.f8292a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.mshield.sharedpreferences.a aVarA = com.baidu.mshield.sharedpreferences.a.a(this.f8292a);
            com.baidu.mshield.utility.a.a(this.f8292a, aVarA.J() * CoreConstants.MILLIS_IN_ONE_HOUR);
            aVarA.b(System.currentTimeMillis());
        }
    }

    public void a(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            new Thread(new a(this, context)).start();
            b.a(context).d();
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action) && action.equals("com.b.r.p")) {
                a(context, intent);
            }
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }
}
