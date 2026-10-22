package com.stepos.agentsafetycenter.sync;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class PendingSyncWorker extends CoroutineWorker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PendingSyncWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        context.getClass();
        workerParameters.getClass();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.work.CoroutineWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(pb.c r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof k9.d
            if (r0 == 0) goto L13
            r0 = r7
            k9.d r0 = (k9.d) r0
            int r1 = r0.f7367g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f7367g = r1
            goto L18
        L13:
            k9.d r0 = new k9.d
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f7365c
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f7367g
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L2e
            if (r2 != r4) goto L28
            id.c.I(r7)
            goto L44
        L28:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r6)
            return r3
        L2e:
            id.c.I(r7)
            rc.e r7 = kc.e0.f7430a
            rc.d r7 = rc.d.f10552f
            androidx.room.e r2 = new androidx.room.e
            r5 = 5
            r2.<init>(r6, r3, r5)
            r0.f7367g = r4
            java.lang.Object r7 = kc.w.E(r7, r2, r0)
            if (r7 != r1) goto L44
            return r1
        L44:
            r7.getClass()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentsafetycenter.sync.PendingSyncWorker.b(pb.c):java.lang.Object");
    }
}
