package com.stepos.ability.voicewakeup.training;

import C7.r;
import S7.k;
import android.util.Log;
import kotlin.Result;

/* loaded from: classes3.dex */
public final class a {
    public static final long[] h = {0, 100, 250, 500};

    /* renamed from: a, reason: collision with root package name */
    public final S7.a f3394a;
    public final S7.a b;
    public final S7.a c;
    public final k d;
    public final S7.a e;
    public boolean f;
    public volatile TrainingAudioInput g;

    public a() {
        Ba.a aVar = new Ba.a(22);
        Ba.a aVar2 = new Ba.a(23);
        Ba.a aVar3 = new Ba.a(24);
        MicrophoneRecorder$4 createInput = MicrophoneRecorder$4.f3348a;
        MicrophoneRecorder$5 nowNanos = MicrophoneRecorder$5.f3349a;
        kotlin.jvm.internal.k.f(createInput, "createInput");
        kotlin.jvm.internal.k.f(nowNanos, "nowNanos");
        this.f3394a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = createInput;
        this.e = nowNanos;
    }

    public final void a() {
        Object objA;
        try {
            TrainingAudioInput trainingAudioInput = this.g;
            if (trainingAudioInput != null) {
                trainingAudioInput.stop();
                objA = r.f317a;
            } else {
                objA = null;
            }
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            Log.w("MicrophoneRecorder", "stop active recording failed", thA);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:30|31|84|33|34|74|35|36|78|37|38|80|39|40|82|41|(5:44|72|45|46|(0)(2:(1:65)|66))) */
    /* JADX WARN: Can't wrap try/catch for region: R(6:12|(3:76|13|14)|72|45|46|(2:67|(1:87)(2:70|(2:22|(2:25|(3:27|(17:30|31|84|33|34|74|35|36|78|37|38|80|39|40|82|41|(5:44|72|45|46|(0)(2:(1:65)|66)))|43)(17:32|84|33|34|74|35|36|78|37|38|80|39|40|82|41|(0)|43))(1:86))(1:24)))(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0152, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0154, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0156, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0157, code lost:
    
        r19 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x015a, code lost:
    
        r6 = r3;
        r2 = r11;
        r3 = r13;
        r9 = r19;
        r11 = r5;
        r13 = r8;
        r8 = r15;
        r15 = r20;
        r5 = r4;
        r4 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0167, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0168, code lost:
    
        r19 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x016a, code lost:
    
        r20 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x016d, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x016e, code lost:
    
        r19 = r2;
        r20 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0174, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0175, code lost:
    
        r19 = r2;
        r20 = r9;
        r18 = r12;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a9 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r0v28, types: [S7.n] */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v15, types: [S7.a] */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v13, types: [S7.n] */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r14v13, types: [S7.a] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0137 -> B:72:0x0143). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x017c -> B:63:0x018c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Comparable b(int r24, int r25, H4.l r26, H4.f r27, S7.n r28, kotlin.coroutines.jvm.internal.ContinuationImpl r29) {
        /*
            Method dump skipped, instructions count: 465
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.voicewakeup.training.a.b(int, int, H4.l, H4.f, S7.n, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Comparable");
    }

    public final void c(boolean z10) {
        Object objA;
        if (this.f) {
            this.f = false;
            if (!z10) {
                this.c.invoke();
                return;
            }
            try {
                this.b.invoke();
                objA = r.f317a;
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
            Throwable thA = Result.a(objA);
            if (thA != null) {
                Log.w("MicrophoneRecorder", "restore voice wakeup failed", thA);
            }
        }
    }
}
