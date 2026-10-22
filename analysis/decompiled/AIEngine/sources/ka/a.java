package ka;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.stepos.core.ability.speech.AsrFilePcmSegmentPolicy;
import com.stepos.core.ota.confirm.InteractiveSessionRegistry;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static a f9952d;

    /* renamed from: e, reason: collision with root package name */
    public static final Object f9953e = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f9956c = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    public final C0102a f9954a = new C0102a();

    /* renamed from: b, reason: collision with root package name */
    public final b f9955b = new b();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: ka.a$a, reason: collision with other inner class name */
    public class C0102a extends qa.b {
        public C0102a() {
            super(AsrFilePcmSegmentPolicy.MAX_SEGMENT_MS);
        }

        @Override // qa.b
        public final void b() {
            a aVar = a.this;
            ArrayList arrayList = aVar.f9956c;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                c cVar = (c) obj;
                if (cVar != null) {
                    cVar.a("CHANGE_NAME_NETWORKCONNECT");
                }
            }
            aVar.f9954a.a();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b extends qa.b {
        public b() {
            super(InteractiveSessionRegistry.DEFAULT_TTL_MS);
        }

        @Override // qa.b
        public final void b() {
            a aVar = a.this;
            ArrayList arrayList = aVar.f9956c;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                c cVar = (c) obj;
                if (cVar != null) {
                    cVar.a("CHANGE_NAME_POWER");
                }
            }
            aVar.f9955b.a();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface c {
        void a(String str);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class d extends BroadcastReceiver {
        public d() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            a aVar = a.this;
            C0102a c0102a = aVar.f9954a;
            b bVar = aVar.f9955b;
            if ("android.intent.action.ACTION_POWER_CONNECTED".equals(intent.getAction())) {
                ta.c.a("EnvironmentReceiver", "ACTION_POWER_CONNECTED, charging = true");
                bVar.c();
                return;
            }
            if ("android.intent.action.ACTION_POWER_DISCONNECTED".equals(intent.getAction())) {
                ta.c.a("EnvironmentReceiver", "ACTION_POWER_DISCONNECTED, charging = false");
                bVar.a();
            } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                boolean zA = qa.c.a(context);
                ta.c.a("EnvironmentReceiver", "CONNECTIVITY_ACTION, isOnline = " + zA);
                if (zA) {
                    c0102a.c();
                } else {
                    c0102a.a();
                }
            }
        }
    }

    public a(Context context) {
        d dVar = new d();
        try {
            context.unregisterReceiver(dVar);
        } catch (Exception unused) {
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            context.registerReceiver(dVar, intentFilter);
        } catch (Exception e10) {
            ta.c.f("EnvironmentReceiver", "Exception: " + e10.toString() + " - Cause: " + e10.getCause());
        }
    }
}
