package l7;

import I4.l;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import c6.ServiceConnectionC0879a;
import com.zyql.agentfront.IMessageBridge;
import com.zyql.agentfront.bean.Message;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.k;

/* renamed from: l7.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC1663a {

    /* renamed from: a, reason: collision with root package name */
    public IMessageBridge f5289a;
    public int b;
    public b c;
    public int d;
    public boolean e;
    public volatile boolean h;
    public final Handler f = new Handler(Looper.getMainLooper());
    public final ArrayList g = new ArrayList();
    public final ServiceConnectionC0879a i = new ServiceConnectionC0879a(this, 1);

    public AbstractC1663a(c cVar) {
    }

    public final void a(Context context) {
        k.f(context, "context");
        if (d() || this.b == 1) {
            return;
        }
        this.e = false;
        this.b = 1;
        Intent intent = new Intent("com.zyql.agentfront.BIND_MESSAGE_BRIDGE");
        intent.setPackage("com.zyql.agentfront");
        try {
            if (context.bindService(intent, this.i, 1)) {
                return;
            }
            c(context, "Failed to bind service: service not found");
        } catch (SecurityException e) {
            c(context, "SecurityException: " + e.getMessage());
        } catch (Exception e6) {
            c(context, "Exception: " + e6.getMessage());
        }
    }

    public final void b(Context context) {
        k.f(context, "context");
        this.e = true;
        this.f.removeCallbacksAndMessages(null);
        this.d = 0;
        if (this.b != 0) {
            this.b = 3;
            try {
                context.unbindService(this.i);
            } catch (Exception unused) {
            }
        }
        this.f5289a = null;
        this.b = 0;
        this.g.clear();
    }

    public final void c(Context context, String str) {
        this.b = 0;
        b bVar = this.c;
        if (bVar != null) {
            bVar.onBindFailed(str);
        }
        if (this.e || this.d >= 3 || this.h) {
            return;
        }
        f(context);
    }

    public final boolean d() {
        return this.b == 2 && this.f5289a != null;
    }

    public final void e(S7.k kVar) {
        synchronized (this.g) {
            Iterator it = this.g.iterator();
            while (it.hasNext()) {
                try {
                    kVar.invoke((Message) it.next());
                    it.remove();
                } catch (Exception unused) {
                }
            }
        }
    }

    public final void f(Context context) {
        int i = this.d + 1;
        this.d = i;
        b bVar = this.c;
        if (bVar != null) {
            bVar.onRetrying(i, 3);
        }
        this.f.postDelayed(new l(24, this, context), Math.min((long) (Math.pow(1.5f, this.d - 1) * 1000), 10000L));
    }
}
