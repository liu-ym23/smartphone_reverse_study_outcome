package com.stepos.stepclaw.chroot;

import android.os.SystemClock;
import com.stepos.stepclaw.SecurePrefs;
import h5.c;
import h5.e;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p5.a;
import p5.l;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\f\u0010\rJ;\u0010\u0011\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012JJ\u0010\u0015\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\u001e\b\u0004\u0010\u0010\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013H\u0086H¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0019"}, d2 = {"Lcom/stepos/stepclaw/chroot/StepClawStartupTiming;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "mark", "()J", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "phase", "startMs", "extra", "Lb5/a0;", "logPhase", "(Ljava/lang/String;JLjava/lang/String;)V", "T", "Lkotlin/Function0;", "block", "measure", "(Ljava/lang/String;Ljava/lang/String;Lp5/a;)Ljava/lang/Object;", "Lkotlin/Function1;", "Lf5/c;", "measureSuspend", "(Ljava/lang/String;Ljava/lang/String;Lp5/l;Lf5/c;)Ljava/lang/Object;", "TAG", "Ljava/lang/String;", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class StepClawStartupTiming {
    public static final StepClawStartupTiming INSTANCE = new StepClawStartupTiming();
    public static final String TAG = "StepClawPerf";

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 176)
    @e(c = "com.stepos.stepclaw.chroot.StepClawStartupTiming", f = "StepClawStartupTiming.kt", l = {45}, m = "measureSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.chroot.StepClawStartupTiming$measureSuspend$1, reason: invalid class name */
    public static final class AnonymousClass1<T> extends c {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StepClawStartupTiming.this.measureSuspend(null, null, null, this);
        }
    }

    private StepClawStartupTiming() {
    }

    public static /* synthetic */ void logPhase$default(StepClawStartupTiming stepClawStartupTiming, String str, long j4, String str2, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            str2 = null;
        }
        stepClawStartupTiming.logPhase(str, j4, str2);
    }

    public static /* synthetic */ Object measure$default(StepClawStartupTiming stepClawStartupTiming, String phase, String str, a block, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            str = null;
        }
        p.e(phase, "phase");
        p.e(block, "block");
        long jMark = stepClawStartupTiming.mark();
        Object objInvoke = block.invoke();
        stepClawStartupTiming.logPhase(phase, jMark, str);
        return objInvoke;
    }

    private final <T> Object measureSuspend$$forInline(String str, String str2, l lVar, f5.c cVar) {
        long jMark = mark();
        Object objInvoke = lVar.invoke(cVar);
        logPhase(str, jMark, str2);
        return objInvoke;
    }

    public static /* synthetic */ Object measureSuspend$default(StepClawStartupTiming stepClawStartupTiming, String str, String str2, l lVar, f5.c cVar, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            str2 = null;
        }
        long jMark = stepClawStartupTiming.mark();
        Object objInvoke = lVar.invoke(cVar);
        stepClawStartupTiming.logPhase(str, jMark, str2);
        return objInvoke;
    }

    public final void logPhase(String phase, long startMs, String extra) {
        p.e(phase, "phase");
    }

    public final long mark() {
        return SystemClock.elapsedRealtime();
    }

    public final <T> T measure(String phase, String extra, a block) {
        p.e(phase, "phase");
        p.e(block, "block");
        long jMark = mark();
        T t8 = (T) block.invoke();
        logPhase(phase, jMark, extra);
        return t8;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <T> java.lang.Object measureSuspend(java.lang.String r7, java.lang.String r8, p5.l r9, f5.c r10) {
        /*
            r6 = this;
            boolean r0 = r10 instanceof com.stepos.stepclaw.chroot.StepClawStartupTiming.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.stepclaw.chroot.StepClawStartupTiming$measureSuspend$1 r0 = (com.stepos.stepclaw.chroot.StepClawStartupTiming.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.stepclaw.chroot.StepClawStartupTiming$measureSuspend$1 r0 = new com.stepos.stepclaw.chroot.StepClawStartupTiming$measureSuspend$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            g5.a r1 = g5.a.f2984a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            long r7 = r0.J$0
            java.lang.Object r9 = r0.L$2
            p5.l r9 = (p5.l) r9
            java.lang.Object r9 = r0.L$1
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r0 = r0.L$0
            java.lang.String r0 = (java.lang.String) r0
            a.a.c0(r10)
            r4 = r7
            r8 = r9
            r7 = r0
            goto L5c
        L38:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L40:
            a.a.c0(r10)
            long r4 = r6.mark()
            r0.L$0 = r7
            r0.L$1 = r8
            r10 = 0
            r0.L$2 = r10
            r10 = 0
            r0.I$0 = r10
            r0.J$0 = r4
            r0.label = r3
            java.lang.Object r10 = r9.invoke(r0)
            if (r10 != r1) goto L5c
            return r1
        L5c:
            r6.logPhase(r7, r4, r8)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.chroot.StepClawStartupTiming.measureSuspend(java.lang.String, java.lang.String, p5.l, f5.c):java.lang.Object");
    }
}
