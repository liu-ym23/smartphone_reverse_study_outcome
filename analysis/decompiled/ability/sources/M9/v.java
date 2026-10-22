package M9;

import com.stepos.taskrobot.llmapi.stepfun.InjectExperienceResult;
import java.net.SocketTimeoutException;
import okhttp3.internal.http2.ErrorCode;

/* loaded from: classes4.dex */
public final class v extends V9.d {
    public final /* synthetic */ w m;

    public v(w wVar) {
        this.m = wVar;
    }

    @Override // V9.d
    public final void j() {
        this.m.e(ErrorCode.CANCEL);
        o oVar = this.m.b;
        synchronized (oVar) {
            long j5 = oVar.n;
            long j6 = oVar.m;
            if (j5 < j6) {
                return;
            }
            oVar.m = j6 + 1;
            oVar.o = System.nanoTime() + 1000000000;
            oVar.h.c(new I9.b(2, oVar, B7.a.q(new StringBuilder(), oVar.c, " ping")), 0L);
        }
    }

    public final void k() {
        if (i()) {
            throw new SocketTimeoutException(InjectExperienceResult.REASON_TIMEOUT);
        }
    }
}
