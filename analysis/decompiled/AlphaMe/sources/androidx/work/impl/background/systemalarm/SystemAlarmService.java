package androidx.work.impl.background.systemalarm;

import C0.r;
import C0.s;
import android.content.Intent;
import android.os.PowerManager;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.J;
import e.EnumC0546d;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import s0.t;
import v0.i;
import v0.j;

@RestrictTo({EnumC0546d.f12493b})
/* loaded from: classes.dex */
public class SystemAlarmService extends J implements i {

    /* renamed from: d, reason: collision with root package name */
    public static final String f4331d = t.f("SystemAlarmService");

    /* renamed from: b, reason: collision with root package name */
    public j f4332b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4333c;

    public final void a() {
        this.f4333c = true;
        t.d().a(f4331d, "All commands completed in dispatcher");
        String str = r.f317a;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        synchronized (s.f318a) {
            linkedHashMap.putAll(s.f319b);
            Unit unit = Unit.INSTANCE;
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            PowerManager.WakeLock wakeLock = (PowerManager.WakeLock) entry.getKey();
            String str2 = (String) entry.getValue();
            if (wakeLock != null && wakeLock.isHeld()) {
                t.d().g(r.f317a, "WakeLock held for " + str2);
            }
        }
        stopSelf();
    }

    @Override // androidx.lifecycle.J, android.app.Service
    public final void onCreate() {
        super.onCreate();
        j jVar = new j(this);
        this.f4332b = jVar;
        if (jVar.f15716i != null) {
            t.d().b(j.f15707k, "A completion listener for SystemAlarmDispatcher already exists.");
        } else {
            jVar.f15716i = this;
        }
        this.f4333c = false;
    }

    @Override // androidx.lifecycle.J, android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        this.f4333c = true;
        j jVar = this.f4332b;
        jVar.getClass();
        t.d().a(j.f15707k, "Destroying SystemAlarmDispatcher");
        jVar.f15711d.f(jVar);
        jVar.f15716i = null;
    }

    @Override // androidx.lifecycle.J, android.app.Service
    public final int onStartCommand(Intent intent, int i4, int i5) {
        super.onStartCommand(intent, i4, i5);
        if (this.f4333c) {
            t.d().e(f4331d, "Re-initializing SystemAlarmDispatcher after a request to shut-down.");
            j jVar = this.f4332b;
            jVar.getClass();
            t tVarD = t.d();
            String str = j.f15707k;
            tVarD.a(str, "Destroying SystemAlarmDispatcher");
            jVar.f15711d.f(jVar);
            jVar.f15716i = null;
            j jVar2 = new j(this);
            this.f4332b = jVar2;
            if (jVar2.f15716i != null) {
                t.d().b(str, "A completion listener for SystemAlarmDispatcher already exists.");
            } else {
                jVar2.f15716i = this;
            }
            this.f4333c = false;
        }
        if (intent == null) {
            return 3;
        }
        this.f4332b.a(i5, intent);
        return 3;
    }
}
