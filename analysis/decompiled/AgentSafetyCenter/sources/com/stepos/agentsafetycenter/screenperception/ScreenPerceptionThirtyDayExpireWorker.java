package com.stepos.agentsafetycenter.screenperception;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class ScreenPerceptionThirtyDayExpireWorker extends CoroutineWorker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenPerceptionThirtyDayExpireWorker(Context context, WorkerParameters workerParameters) {
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
    public final java.lang.Object b(pb.c r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof i9.e0
            if (r0 == 0) goto L13
            r0 = r7
            i9.e0 r0 = (i9.e0) r0
            int r1 = r0.f5858g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5858g = r1
            goto L18
        L13:
            i9.e0 r0 = new i9.e0
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f5856c
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f5858g
            r3 = 1
            if (r2 == 0) goto L2e
            if (r2 != r3) goto L27
            id.c.I(r7)
            goto L49
        L27:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r6)
            r6 = 0
            return r6
        L2e:
            id.c.I(r7)
            android.content.Context r6 = r6.f4338a
            r6.getClass()
            f8.b r7 = i9.b0.f5839d
            i9.b0 r6 = r7.m(r6)
            long r4 = java.lang.System.currentTimeMillis()
            r0.f5858g = r3
            java.lang.Object r6 = r6.f(r4, r0)
            if (r6 != r1) goto L49
            return r1
        L49:
            g5.r r6 = g5.s.a()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentsafetycenter.screenperception.ScreenPerceptionThirtyDayExpireWorker.b(pb.c):java.lang.Object");
    }
}
