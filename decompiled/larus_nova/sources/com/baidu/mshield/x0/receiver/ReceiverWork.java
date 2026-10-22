package com.baidu.mshield.x0.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.mshield.x0.EngineImpl;
import com.baidu.mshield.x0.d.d;
import com.baidu.mshield.x0.d.h.b;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class ReceiverWork extends BroadcastReceiver {

    public class a extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f32549b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Intent f32550c;

        @Override // com.baidu.mshield.x0.d.h.b
        public void a() {
            ReceiverWork.b(this.f32549b, this.f32550c);
            ReceiverWork.a(this.f32549b, this.f32550c);
        }

        public a(ReceiverWork r100, Context r101, Intent r102) {
            this.f32549b = r101;
            this.f32550c = r102;
        }
    }

    public ReceiverWork() {
    }

    public static void a(Context r100, Intent r101) {
    L15:
        th = move-exception;
        d.a(th);
        return;
    L3:
        if (EngineImpl.isUnload == false) goto L5;
        return;
    L5:
        if (r101 != null) goto L7;
        return;
    L7:
        if ("com.baidu.mshield.x0.alarm.action".equals(r101.getAction()) == false) goto L26;
        com.baidu.mshield.x0.l.a r102 = new com.baidu.mshield.x0.l.a(r100);     // Catch: Throwable -> L15
        long r103 = ((long) com.baidu.mshield.x0.d.b.b(r100)) * 60000;     // Catch: Throwable -> L15
        r102.e(System.currentTimeMillis() + r103);     // Catch: Throwable -> L15
        com.baidu.mshield.x0.d.b.a(r100, r103);     // Catch: Throwable -> L15
        List<com.baidu.mshield.x0.d.a> r104 = com.baidu.mshield.x0.f.a.a(r100).a();     // Catch: Throwable -> L15
        long r105 = System.currentTimeMillis() + 300000;     // Catch: Throwable -> L15
        Iterator<com.baidu.mshield.x0.d.a> r106 = r104.iterator();     // Catch: Throwable -> L15
    L10:
        if (r106.hasNext() == false) goto L27;
        com.baidu.mshield.x0.d.a r107 = r106.next();     // Catch: Throwable -> L15
        com.baidu.mshield.b.c.a.b("rec t:" + d.a(r107.f32477c, "yyyy-MM-dd HH:mm:ss") + " ac:" + r107.f32475a);     // Catch: Throwable -> L15
        if (r105 < r107.f32477c) goto L10;
        com.baidu.mshield.x0.k.a.a(r100, r107.f32475a);     // Catch: Throwable -> L15
        goto L10
    L27:
        return;
    }

    public static void b(Context r100, Intent r101) {
        if (EngineImpl.isUnload == false) goto L5;
        return;
    L5:
        com.baidu.mshield.x0.k.a.a(r100, r101);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r100, Intent r101) {
        com.baidu.mshield.x0.d.h.d.b().a(new a(this, r100, r101));
    }
}
