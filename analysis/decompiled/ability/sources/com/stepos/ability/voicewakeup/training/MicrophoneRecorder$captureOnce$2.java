package com.stepos.ability.voicewakeup.training;

import C7.r;
import H4.q;
import S7.n;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1686D;
import m9.InterfaceC1733z;

@J7.c(c = "com.stepos.ability.voicewakeup.training.MicrophoneRecorder$captureOnce$2", f = "MicrophoneRecorder.kt", l = {144, 144, 147, 154}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Ljava/nio/ShortBuffer;", "<anonymous>", "(Lm9/z;)Ljava/nio/ShortBuffer;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class MicrophoneRecorder$captureOnce$2 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public q f3351a;
    public InterfaceC1686D b;
    public int c;
    public /* synthetic */ Object d;
    public final /* synthetic */ int e;
    public final /* synthetic */ int f;
    public final /* synthetic */ S7.a g;
    public final /* synthetic */ n h;
    public final /* synthetic */ a i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ n f3352j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MicrophoneRecorder$captureOnce$2(int i, int i6, S7.a aVar, n nVar, a aVar2, n nVar2, H7.c cVar) {
        super(2, cVar);
        this.e = i;
        this.f = i6;
        this.g = aVar;
        this.h = nVar;
        this.i = aVar2;
        this.f3352j = nVar2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        MicrophoneRecorder$captureOnce$2 microphoneRecorder$captureOnce$2 = new MicrophoneRecorder$captureOnce$2(this.e, this.f, this.g, this.h, this.i, this.f3352j, cVar);
        microphoneRecorder$captureOnce$2.d = obj;
        return microphoneRecorder$captureOnce$2;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((MicrophoneRecorder$captureOnce$2) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0097, code lost:
    
        if (r6 == r7) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x013b, code lost:
    
        if (r0 == r7) goto L82;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00bc A[PHI: r0 r1
      0x00bc: PHI (r0v12 java.lang.Object) = (r0v5 java.lang.Object), (r0v14 java.lang.Object) binds: [B:36:0x00ba, B:70:0x0146] A[DONT_GENERATE, DONT_INLINE]
      0x00bc: PHI (r1v24 kotlinx.coroutines.c) = (r1v20 kotlinx.coroutines.c), (r1v26 kotlinx.coroutines.c) binds: [B:36:0x00ba, B:70:0x0146] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0124 A[Catch: all -> 0x0027, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0027, blocks: (B:9:0x0020, B:68:0x013e, B:16:0x0036, B:52:0x0104, B:58:0x0124, B:63:0x012b, B:65:0x012e, B:73:0x014b, B:74:0x0152, B:77:0x0155, B:19:0x003d, B:22:0x0048, B:26:0x008b, B:59:0x0125), top: B:87:0x0014, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x015e  */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22, types: [m9.D] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v3, types: [m9.D] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v9 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 357
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.voicewakeup.training.MicrophoneRecorder$captureOnce$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
