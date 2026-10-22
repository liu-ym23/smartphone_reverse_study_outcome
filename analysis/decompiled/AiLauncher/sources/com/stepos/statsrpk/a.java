package com.stepos.statsrpk;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.statsapp.v3.utils.SharedPreferencesHelper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public Context f31026a;

    /* renamed from: b, reason: collision with root package name */
    public RpkInfo f31027b;

    /* renamed from: c, reason: collision with root package name */
    public Handler f31028c;

    /* renamed from: d, reason: collision with root package name */
    public final int f31029d = 1;

    /* renamed from: e, reason: collision with root package name */
    public SharedPreferencesHelper f31030e;

    /* renamed from: com.stepos.statsrpk.a$a, reason: collision with other inner class name */
    public class HandlerC0373a extends Handler {
        public HandlerC0373a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            long time;
            if (message.what == 1) {
                try {
                    time = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(a.this.f31030e.getConfig(UxipConstants.f30686y, "")).getTime();
                } catch (ParseException unused) {
                    time = 0;
                }
                if (System.currentTimeMillis() - time > a.this.a(1440, 2880) * 60000) {
                    a.this.d();
                }
            }
        }
    }

    public a(Context context, RpkInfo rpkInfo) {
        this.f31026a = context;
        this.f31027b = rpkInfo;
        this.f31030e = new SharedPreferencesHelper(context, "statsrpk_config_" + rpkInfo.f31011a);
        HandlerThread handlerThread = new HandlerThread("rpk.ConfigControllerWorker", 5);
        handlerThread.start();
        this.f31028c = new HandlerC0373a(handlerThread.getLooper());
    }

    public final int a(int i10, int i11) {
        return new Random().nextInt((i11 - i10) + 1) + i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d() {
        /*
            Method dump skipped, instructions count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.statsrpk.a.d():void");
    }

    public final void e(int i10) {
        if (this.f31028c.hasMessages(1)) {
            this.f31028c.removeMessages(1);
        }
        this.f31028c.sendEmptyMessageDelayed(1, i10);
    }

    public void f(d dVar) {
        e(1000);
    }
}
