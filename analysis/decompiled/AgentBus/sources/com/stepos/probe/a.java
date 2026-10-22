package com.stepos.probe;

import android.content.Context;
import android.content.Intent;
import com.stepos.agentbus.push.PushReceiver;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import nb.i;
import o4.d0;
import x2.n;
import x2.o;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f2723f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f2724g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f2725h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f2726i;

    public /* synthetic */ a(Object obj, Object obj2, Object obj3, int i2) {
        this.f2723f = i2;
        this.f2724g = obj;
        this.f2725h = obj2;
        this.f2726i = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        switch (this.f2723f) {
            case 0:
                ProbeStore.append$lambda$0((File) this.f2724g, (String) this.f2725h, (String) this.f2726i);
                return;
            case 1:
                PushReceiver pushReceiver = (PushReceiver) this.f2724g;
                Context context = (Context) this.f2725h;
                Intent intent = (Intent) this.f2726i;
                Context applicationContext = context.getApplicationContext();
                q6.b bVar = q6.a.f8785a;
                String str = (String) bVar.f8788h;
                j6.a.b(str, "processMessage start");
                try {
                    for (Map.Entry entry : ((HashMap) bVar.f8787g).entrySet()) {
                        j6.a.a(str, "processMessage, method: " + ((String) entry.getKey()));
                        if (((s6.a) entry.getValue()).e(applicationContext, intent, pushReceiver)) {
                            return;
                        }
                    }
                    return;
                } catch (Exception e10) {
                    j6.a.c(str, "processMessage error " + e10.getMessage());
                    return;
                }
            default:
                d0 d0Var = (d0) this.f2724g;
                n7.a aVar = (n7.a) this.f2725h;
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) this.f2726i;
                try {
                    o oVarO = i.o((Context) d0Var.f7326g);
                    if (oVarO == null) {
                        throw new RuntimeException("EmojiCompat font provider not available on this device.");
                    }
                    n nVar = (n) oVarO.f11140a;
                    synchronized (nVar.f11134i) {
                        nVar.f11136k = threadPoolExecutor;
                    }
                    oVarO.f11140a.B(new x2.i(aVar, threadPoolExecutor));
                    return;
                } catch (Throwable th) {
                    aVar.t(th);
                    threadPoolExecutor.shutdown();
                    return;
                }
        }
    }
}
