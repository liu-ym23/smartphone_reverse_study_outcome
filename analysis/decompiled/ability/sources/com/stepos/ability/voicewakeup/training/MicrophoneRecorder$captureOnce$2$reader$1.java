package com.stepos.ability.voicewakeup.training;

import C7.r;
import H4.q;
import S7.n;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.C1724q;
import m9.InterfaceC1733z;

@J7.c(c = "com.stepos.ability.voicewakeup.training.MicrophoneRecorder$captureOnce$2$reader$1", f = "MicrophoneRecorder.kt", l = {}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Ljava/nio/ShortBuffer;", "<anonymous>", "(Lm9/z;)Ljava/nio/ShortBuffer;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class MicrophoneRecorder$captureOnce$2$reader$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3353a;
    public final /* synthetic */ a b;
    public final /* synthetic */ int c;
    public final /* synthetic */ q d;
    public final /* synthetic */ n e;
    public final /* synthetic */ C1724q f;
    public final /* synthetic */ S7.a g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MicrophoneRecorder$captureOnce$2$reader$1(a aVar, int i, q qVar, n nVar, C1724q c1724q, S7.a aVar2, H7.c cVar) {
        super(2, cVar);
        this.b = aVar;
        this.c = i;
        this.d = qVar;
        this.e = nVar;
        this.f = c1724q;
        this.g = aVar2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        MicrophoneRecorder$captureOnce$2$reader$1 microphoneRecorder$captureOnce$2$reader$1 = new MicrophoneRecorder$captureOnce$2$reader$1(this.b, this.c, this.d, this.e, this.f, this.g, cVar);
        microphoneRecorder$captureOnce$2$reader$1.f3353a = obj;
        return microphoneRecorder$captureOnce$2$reader$1;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((MicrophoneRecorder$captureOnce$2$reader$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0088, code lost:
    
        if (r16 == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x008a, code lost:
    
        monitor-enter(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x008d, code lost:
    
        if (r4.d == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x008f, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0091, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0092, code lost:
    
        monitor-exit(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0093, code lost:
    
        if (r0 != false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x009f, code lost:
    
        if (((java.lang.Boolean) r7.invoke()).booleanValue() == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a7, code lost:
    
        throw new com.stepos.ability.voicewakeup.training.MicrophoneRecorder$CaptureFailedDuringHandoff(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a8, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a9, code lost:
    
        r1 = r0;
        r3 = r9;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01d2 A[Catch: all -> 0x01f0, TRY_ENTER, TRY_LEAVE, TryCatch #10 {all -> 0x01f0, blocks: (B:140:0x01d2, B:145:0x01da, B:147:0x01dd, B:150:0x01ea, B:151:0x01ef, B:156:0x01f4, B:157:0x01f5, B:168:0x020e, B:141:0x01d3), top: B:198:0x0039, inners: #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0213  */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [com.stepos.ability.voicewakeup.training.TrainingAudioInput] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:137:0x01cb -> B:138:0x01ce). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 551
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.voicewakeup.training.MicrophoneRecorder$captureOnce$2$reader$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
