package H0;

import H.h;
import com.stepos.taskrobot.llmapi.stepfun.TaskTimeouts;
import com.zyql.common.utils.upload.TOSUploader;
import java.util.List;
import u1.C2031a;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final a f725a;
    public volatile long b;
    public boolean c;
    public int d;

    public b(String str) {
        this.f725a = new a(this, h.f711a, new B1.c(str), new C2031a(this));
    }

    public static void a(b bVar, boolean z10) {
        if (z10) {
            bVar.b = TOSUploader.EXPIRED_TIMES;
            bVar.d = 3;
        } else {
            int i = bVar.d;
            if (i == 0) {
                bVar.b = TaskTimeouts.TAKEOVER_IDLE_MS;
                bVar.d++;
            } else if (i == 1) {
                bVar.b = 900000L;
                bVar.d++;
            } else if (i == 2) {
                bVar.b = TOSUploader.EXPIRED_TIMES;
                bVar.d++;
            } else {
                bVar.b = TOSUploader.EXPIRED_TIMES;
                bVar.d++;
            }
        }
        N.c.f1004a.getClass();
        List list = F0.c.f517D;
        F0.c cVar = F0.b.f516a;
        long j5 = bVar.b;
        cVar.d = false;
        cVar.h = true;
        cVar.p = System.currentTimeMillis();
        cVar.f524q = j5;
    }
}
