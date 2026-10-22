package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import android.os.PowerManager;
import androidx.lifecycle.u;
import h2.j;
import java.util.LinkedHashMap;
import java.util.Map;
import k2.f;
import r2.m;
import r2.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class SystemAlarmService extends u {

    /* renamed from: d, reason: collision with root package name */
    public static final String f2892d = j.f("SystemAlarmService");

    /* renamed from: b, reason: collision with root package name */
    public f f2893b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2894c;

    public final void a() {
        this.f2894c = true;
        j.d().a(f2892d, "All commands completed in dispatcher");
        String str = m.f11706a;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        synchronized (n.f11707a) {
            linkedHashMap.putAll(n.f11708b);
            lb.n nVar = lb.n.f10413a;
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            PowerManager.WakeLock wakeLock = (PowerManager.WakeLock) entry.getKey();
            String str2 = (String) entry.getValue();
            if (wakeLock != null && wakeLock.isHeld()) {
                j.d().g(m.f11706a, "WakeLock held for " + str2);
            }
        }
        stopSelf();
    }

    @Override // androidx.lifecycle.u, android.app.Service
    public final void onCreate() {
        super.onCreate();
        f fVar = new f(this);
        this.f2893b = fVar;
        if (fVar.f9890l != null) {
            j.d().b(f.f9882n, "A completion listener for SystemAlarmDispatcher already exists.");
        } else {
            fVar.f9890l = this;
        }
        this.f2894c = false;
    }

    @Override // androidx.lifecycle.u, android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        this.f2894c = true;
        f fVar = this.f2893b;
        fVar.getClass();
        j.d().a(f.f9882n, "Destroying SystemAlarmDispatcher");
        fVar.f9886d.f(fVar);
        fVar.f9890l = null;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i10, int i11) {
        super.onStartCommand(intent, i10, i11);
        if (this.f2894c) {
            j.d().e(f2892d, "Re-initializing SystemAlarmDispatcher after a request to shut-down.");
            f fVar = this.f2893b;
            fVar.getClass();
            j jVarD = j.d();
            String str = f.f9882n;
            jVarD.a(str, "Destroying SystemAlarmDispatcher");
            fVar.f9886d.f(fVar);
            fVar.f9890l = null;
            f fVar2 = new f(this);
            this.f2893b = fVar2;
            if (fVar2.f9890l != null) {
                j.d().b(str, "A completion listener for SystemAlarmDispatcher already exists.");
            } else {
                fVar2.f9890l = this;
            }
            this.f2894c = false;
        }
        if (intent == null) {
            return 3;
        }
        this.f2893b.b(i11, intent);
        return 3;
    }
}
