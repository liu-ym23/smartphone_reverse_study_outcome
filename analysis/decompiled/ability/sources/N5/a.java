package N5;

import android.os.Looper;
import android.os.SystemClock;
import com.stepos.statsrpk.service.e;
import com.stepos.taskrobot.llmapi.stepfun.TaskTimeouts;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final long f1009a;
    public long b;
    public boolean c;
    public final Q5.a d;
    public final /* synthetic */ int e;
    public final /* synthetic */ c f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(c cVar, int i) {
        this(30000L);
        this.e = i;
        switch (i) {
            case 1:
                this.f = cVar;
                this(TaskTimeouts.TAKEOVER_IDLE_MS);
                break;
            default:
                this.f = cVar;
                break;
        }
    }

    public final synchronized void a() {
        this.c = true;
        this.d.removeMessages(1);
        this.d.removeMessages(-1);
    }

    public final void b() {
        switch (this.e) {
            case 0:
                c cVar = this.f;
                Iterator it = cVar.c.iterator();
                while (it.hasNext()) {
                    e eVar = (e) it.next();
                    if (eVar != null) {
                        eVar.c.execute(new A.a(11, eVar, "CHANGE_NAME_NETWORKCONNECT"));
                    }
                }
                cVar.f1011a.a();
                break;
            default:
                c cVar2 = this.f;
                Iterator it2 = cVar2.c.iterator();
                while (it2.hasNext()) {
                    e eVar2 = (e) it2.next();
                    if (eVar2 != null) {
                        eVar2.c.execute(new A.a(11, eVar2, "CHANGE_NAME_POWER"));
                    }
                }
                cVar2.b.a();
                break;
        }
    }

    public final synchronized void c() {
        this.c = false;
        this.b = SystemClock.elapsedRealtime() + this.f1009a;
        Q5.a aVar = this.d;
        aVar.sendMessage(aVar.obtainMessage(1));
    }

    public a(long j5) {
        this.c = false;
        this.f1009a = j5;
        this.d = new Q5.a(this, Looper.getMainLooper(), 2);
    }
}
