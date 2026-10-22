package la;

import android.os.Looper;
import android.os.SystemClock;
import com.stepos.statsrpk.e;
import com.stepos.statsrpk.service.d;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final long f7811a;

    /* renamed from: b, reason: collision with root package name */
    public long f7812b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7813c;

    /* renamed from: d, reason: collision with root package name */
    public final e f7814d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f7815e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ b f7816f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(b bVar, int i) {
        this(30000L);
        this.f7815e = i;
        switch (i) {
            case 1:
                this.f7816f = bVar;
                this(300000L);
                break;
            default:
                this.f7816f = bVar;
                break;
        }
    }

    public final synchronized void a() {
        this.f7813c = true;
        this.f7814d.removeMessages(1);
        this.f7814d.removeMessages(-1);
    }

    public final void b() {
        int i = this.f7815e;
        b bVar = this.f7816f;
        int i3 = 0;
        switch (i) {
            case 0:
                ArrayList arrayList = bVar.f7821c;
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    com.stepos.statsrpk.service.e eVar = (com.stepos.statsrpk.service.e) obj;
                    if (eVar != null) {
                        ScheduledExecutorService scheduledExecutorService = eVar.f2889c;
                        d dVar = new d(i3);
                        dVar.f2886g = eVar;
                        dVar.f2885f = "CHANGE_NAME_NETWORKCONNECT";
                        VarHandle.storeStoreFence();
                        scheduledExecutorService.execute(dVar);
                    }
                }
                bVar.f7819a.a();
                break;
            default:
                ArrayList arrayList2 = bVar.f7821c;
                int size2 = arrayList2.size();
                int i11 = 0;
                while (i11 < size2) {
                    Object obj2 = arrayList2.get(i11);
                    i11++;
                    com.stepos.statsrpk.service.e eVar2 = (com.stepos.statsrpk.service.e) obj2;
                    if (eVar2 != null) {
                        ScheduledExecutorService scheduledExecutorService2 = eVar2.f2889c;
                        d dVar2 = new d(i3);
                        dVar2.f2886g = eVar2;
                        dVar2.f2885f = "CHANGE_NAME_POWER";
                        VarHandle.storeStoreFence();
                        scheduledExecutorService2.execute(dVar2);
                    }
                }
                bVar.f7820b.a();
                break;
        }
    }

    public final synchronized void c() {
        this.f7813c = false;
        this.f7812b = SystemClock.elapsedRealtime() + this.f7811a;
        e eVar = this.f7814d;
        eVar.sendMessage(eVar.obtainMessage(1));
    }

    public a(long j10) {
        this.f7813c = false;
        this.f7811a = j10;
        this.f7814d = new e(this, Looper.getMainLooper(), 4);
    }
}
