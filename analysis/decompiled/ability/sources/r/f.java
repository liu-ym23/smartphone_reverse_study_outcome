package r;

import com.stepos.taskrobot.llmapi.stepfun.TaskTimeouts;
import t.C2011a;

/* loaded from: classes2.dex */
public final class f extends AbstractC1869a {
    public static final long[] g = {10000};
    public C2011a f;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0256 A[Catch: all -> 0x0263, LOOP:2: B:238:0x0250->B:120:0x0256, LOOP_END, TRY_LEAVE, TryCatch #2 {all -> 0x0263, blocks: (B:118:0x0250, B:120:0x0256), top: B:238:0x0250 }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x01ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:288:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r16v12 */
    /* JADX WARN: Type inference failed for: r16v13 */
    /* JADX WARN: Type inference failed for: r16v14 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v9 */
    @Override // r.AbstractC1869a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c() {
        /*
            Method dump skipped, instructions count: 1139
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r.f.c():boolean");
    }

    @Override // r.AbstractC1869a
    public final String d() {
        return "sender";
    }

    @Override // r.AbstractC1869a
    public final long[] e() {
        return g;
    }

    @Override // r.AbstractC1869a
    public final long f() {
        s.g gVar = this.f5661a.c;
        long j5 = gVar.l;
        return (j5 < 10000 || j5 > TaskTimeouts.TAKEOVER_IDLE_MS) ? gVar.e.getLong("batch_event_interval", 60000L) : j5;
    }
}
