package j9;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.stepos.deepbinder.client.channel.remote.c;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f9742a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final LinkedHashMap f9743b = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name */
    public static int f9744c = 300000;

    /* renamed from: d, reason: collision with root package name */
    public static final LinkedHashMap f9745d = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    public static final HandlerC0097a f9746e = new HandlerC0097a(Looper.getMainLooper());

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: j9.a$a, reason: collision with other inner class name */
    public static final class HandlerC0097a extends Handler {
        @Override // android.os.Handler
        public final void handleMessage(Message msg) {
            Object next;
            g.f(msg, "msg");
            super.handleMessage(msg);
            Iterator it = a.f9743b.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (((ComponentName) ((Map.Entry) next).getKey()).hashCode() == msg.what) {
                        break;
                    }
                }
            }
            Map.Entry entry = (Map.Entry) next;
            if (entry != null) {
                a.f9742a.c((ComponentName) entry.getKey());
            }
        }
    }

    public final synchronized com.stepos.deepbinder.client.channel.remote.a a(ComponentName componentName) {
        g.f(componentName, "componentName");
        return b(componentName, null);
    }

    public final synchronized com.stepos.deepbinder.client.channel.remote.a b(ComponentName componentName, c cVar) {
        com.stepos.deepbinder.client.channel.remote.a aVar;
        try {
            g.f(componentName, "componentName");
            LinkedHashMap linkedHashMap = f9743b;
            aVar = (com.stepos.deepbinder.client.channel.remote.a) linkedHashMap.get(componentName);
            if (aVar == null) {
                if (cVar == null) {
                    cVar = new c(componentName);
                }
                linkedHashMap.put(componentName, cVar);
                aVar = cVar;
            }
            int iHashCode = componentName.hashCode();
            HandlerC0097a handlerC0097a = f9746e;
            if (handlerC0097a.hasMessages(iHashCode)) {
                handlerC0097a.removeMessages(iHashCode);
            }
            Integer num = (Integer) f9745d.get(Integer.valueOf(iHashCode));
            int iIntValue = num != null ? num.intValue() : f9744c;
            if (iIntValue != -1) {
                handlerC0097a.sendEmptyMessageDelayed(iHashCode, iIntValue);
            }
        } catch (Throwable th) {
            throw th;
        }
        return aVar;
    }

    public final synchronized void c(ComponentName componentName) {
        g.f(componentName, "componentName");
        com.stepos.deepbinder.client.channel.remote.a aVar = (com.stepos.deepbinder.client.channel.remote.a) f9743b.remove(componentName);
        if (aVar != null) {
            aVar.release();
        }
    }
}
