package com.baidu.mshield.x0.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.mshield.x0.EngineImpl;
import com.baidu.mshield.x0.d.d;
import com.baidu.mshield.x0.d.h.b;
import com.stepos.alphame.bluetooth.VehicleBluetoothManager;
import java.util.List;

/* loaded from: classes.dex */
public class ReceiverWork extends BroadcastReceiver {

    public class a extends b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f8450b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Intent f8451c;

        public a(ReceiverWork receiverWork, Context context, Intent intent) {
            this.f8450b = context;
            this.f8451c = intent;
        }

        @Override // com.baidu.mshield.x0.d.h.b
        public void a() {
            ReceiverWork.b(this.f8450b, this.f8451c);
            ReceiverWork.a(this.f8450b, this.f8451c);
        }
    }

    public static void a(Context context, Intent intent) {
        try {
            if (EngineImpl.isUnload || intent == null || !"com.baidu.mshield.x0.alarm.action".equals(intent.getAction())) {
                return;
            }
            long jB = com.baidu.mshield.x0.d.b.b(context) * 60000;
            new com.baidu.mshield.x0.l.a(context).e(System.currentTimeMillis() + jB);
            com.baidu.mshield.x0.d.b.a(context, jB);
            List<com.baidu.mshield.x0.d.a> listA = com.baidu.mshield.x0.f.a.a(context).a();
            long jCurrentTimeMillis = System.currentTimeMillis() + VehicleBluetoothManager.FAIL_RETRY_TIMEOUT;
            for (com.baidu.mshield.x0.d.a aVar : listA) {
                com.baidu.mshield.b.c.a.b("rec t:" + d.a(aVar.f8378c, "yyyy-MM-dd HH:mm:ss") + " ac:" + aVar.f8376a);
                if (jCurrentTimeMillis >= aVar.f8378c) {
                    com.baidu.mshield.x0.k.a.a(context, aVar.f8376a);
                }
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public static void b(Context context, Intent intent) {
        if (EngineImpl.isUnload) {
            return;
        }
        com.baidu.mshield.x0.k.a.a(context, intent);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        com.baidu.mshield.x0.d.h.d.b().a(new a(this, context, intent));
    }
}
