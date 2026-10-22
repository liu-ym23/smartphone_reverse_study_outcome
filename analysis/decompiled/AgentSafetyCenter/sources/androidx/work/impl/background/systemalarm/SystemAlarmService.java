package androidx.work.impl.background.systemalarm;

import a2.i;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.lifecycle.a0;
import g5.a;
import g5.j;
import g5.u;
import h5.d;
import h5.k;
import h5.r;
import j5.b;
import j5.h;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import p5.c;
import p5.e;
import q5.n;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class SystemAlarmService extends a0 {

    /* renamed from: h, reason: collision with root package name */
    public static final String f1671h = u.f("SystemAlarmService");

    /* renamed from: f, reason: collision with root package name */
    public h f1672f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1673g;

    public final void a() {
        h hVar = new h();
        Context applicationContext = getApplicationContext();
        hVar.f6588c = applicationContext;
        c cVarA = k.a();
        r rVarB = r.b(this);
        a aVar = rVarB.f5371b;
        hVar.i = rVarB;
        j jVar = aVar.f4271d;
        b bVar = new b();
        bVar.f6560c = applicationContext;
        bVar.f6563h = jVar;
        bVar.i = cVarA;
        bVar.f6561f = new HashMap();
        bVar.f6562g = new Object();
        VarHandle.storeStoreFence();
        hVar.f6592j = bVar;
        i iVar = aVar.f4274g;
        n nVar = new n();
        nVar.f10098b = new HashMap();
        nVar.f10099c = new HashMap();
        nVar.f10100d = new Object();
        nVar.f10097a = iVar;
        VarHandle.storeStoreFence();
        hVar.f6590g = nVar;
        d dVar = rVarB.f5375f;
        hVar.f6591h = dVar;
        p5.i iVar2 = rVarB.f5373d;
        hVar.f6589f = iVar2;
        hVar.f6596n = new e(dVar, iVar2);
        dVar.a(hVar);
        hVar.f6593k = new ArrayList();
        hVar.f6594l = null;
        VarHandle.storeStoreFence();
        this.f1672f = hVar;
        if (hVar.f6595m != null) {
            u.d().b(h.f6587o, "A completion listener for SystemAlarmDispatcher already exists.");
        } else {
            hVar.f6595m = this;
        }
    }

    public final void b() {
        this.f1673g = true;
        u.d().a(f1671h, "All commands completed in dispatcher");
        String str = q5.h.f10090a;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        synchronized (q5.i.f10091a) {
            linkedHashMap.putAll(q5.i.f10092b);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            PowerManager.WakeLock wakeLock = (PowerManager.WakeLock) entry.getKey();
            String str2 = (String) entry.getValue();
            if (wakeLock != null && wakeLock.isHeld()) {
                u.d().g(q5.h.f10090a, "WakeLock held for " + str2);
            }
        }
        stopSelf();
    }

    @Override // androidx.lifecycle.a0, android.app.Service
    public final void onCreate() {
        super.onCreate();
        a();
        this.f1673g = false;
    }

    @Override // androidx.lifecycle.a0, android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        this.f1673g = true;
        h hVar = this.f1672f;
        hVar.getClass();
        u.d().a(h.f6587o, "Destroying SystemAlarmDispatcher");
        hVar.f6591h.f(hVar);
        hVar.f6595m = null;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i3) {
        super.onStartCommand(intent, i, i3);
        if (this.f1673g) {
            u.d().e(f1671h, "Re-initializing SystemAlarmDispatcher after a request to shut-down.");
            h hVar = this.f1672f;
            hVar.getClass();
            u.d().a(h.f6587o, "Destroying SystemAlarmDispatcher");
            hVar.f6591h.f(hVar);
            hVar.f6595m = null;
            a();
            this.f1673g = false;
        }
        if (intent == null) {
            return 3;
        }
        this.f1672f.a(intent, i3);
        return 3;
    }
}
