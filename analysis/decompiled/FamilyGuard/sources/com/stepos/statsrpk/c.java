package com.stepos.statsrpk;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import f3.C0720b;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private Context f15943a;

    /* renamed from: b, reason: collision with root package name */
    private b f15944b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f15945c;

    /* renamed from: d, reason: collision with root package name */
    private final int f15946d = 1;

    /* renamed from: e, reason: collision with root package name */
    private C0720b f15947e;

    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            long time;
            if (message.what == 1) {
                try {
                    time = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(c.this.f15947e.m("getTime", BuildConfig.FLAVOR)).getTime();
                } catch (ParseException unused) {
                    time = 0;
                }
                if (System.currentTimeMillis() - time > c.this.a(1440, 2880) * 60000) {
                    c.this.d();
                }
            }
        }
    }

    public c(Context context, b bVar) {
        this.f15943a = context;
        this.f15944b = bVar;
        this.f15947e = new C0720b(context, "statsrpk_config_" + bVar.f15938a);
        HandlerThread handlerThread = new HandlerThread("rpk.ConfigControllerWorker", 5);
        handlerThread.start();
        this.f15945c = new a(handlerThread.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i5, int i6) {
        return new Random().nextInt((i6 - i5) + 1) + i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d() {
        /*
            Method dump skipped, instructions count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.statsrpk.c.d():void");
    }

    private void e(int i5) {
        if (this.f15945c.hasMessages(1)) {
            this.f15945c.removeMessages(1);
        }
        this.f15945c.sendEmptyMessageDelayed(1, i5);
    }

    void f(f fVar) {
        e(1000);
    }
}
