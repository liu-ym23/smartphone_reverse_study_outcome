package com.stepos.ability.voicewakeup.training;

import C7.r;
import S7.n;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@J7.c(c = "com.stepos.ability.voicewakeup.training.TrainingActivity$startTrainingFlow$1", f = "TrainingActivity.kt", l = {368, 371, 382, 392, 410}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class TrainingActivity$startTrainingFlow$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public ByteBuffer f3387a;
    public int b;
    public /* synthetic */ Object c;
    public final /* synthetic */ TrainingActivity d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrainingActivity$startTrainingFlow$1(TrainingActivity trainingActivity, H7.c cVar) {
        super(2, cVar);
        this.d = trainingActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        TrainingActivity$startTrainingFlow$1 trainingActivity$startTrainingFlow$1 = new TrainingActivity$startTrainingFlow$1(this.d, cVar);
        trainingActivity$startTrainingFlow$1.c = obj;
        return trainingActivity$startTrainingFlow$1;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((TrainingActivity$startTrainingFlow$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:156:0x0285, code lost:
    
        if (com.stepos.ability.voicewakeup.training.TrainingActivity.q(r0, r18) != r6) goto L158;
     */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01f4 A[PHI: r0
      0x01f4: PHI (r0v70 com.stepos.ability.voicewakeup.training.TrainingActivity) = 
      (r0v13 com.stepos.ability.voicewakeup.training.TrainingActivity)
      (r0v54 com.stepos.ability.voicewakeup.training.TrainingActivity)
      (r0v76 com.stepos.ability.voicewakeup.training.TrainingActivity)
     binds: [B:152:0x0273, B:119:0x01f2, B:180:0x02dc] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01f9 A[Catch: all -> 0x016c, TRY_ENTER, TryCatch #5 {all -> 0x016c, blocks: (B:84:0x013e, B:87:0x0145, B:89:0x014d, B:155:0x0278, B:92:0x016f, B:93:0x0172, B:94:0x0173, B:96:0x0179, B:121:0x01f9, B:122:0x01fc, B:80:0x0134, B:123:0x01fd, B:70:0x0108, B:124:0x01fe, B:129:0x0204, B:154:0x0277, B:49:0x00ae, B:43:0x009d), top: B:208:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ee A[Catch: all -> 0x00fc, TRY_LEAVE, TryCatch #11 {all -> 0x00fc, blocks: (B:59:0x00e6, B:61:0x00ee), top: B:209:0x00e6, outer: #14 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x013e A[Catch: all -> 0x016c, TRY_ENTER, TryCatch #5 {all -> 0x016c, blocks: (B:84:0x013e, B:87:0x0145, B:89:0x014d, B:155:0x0278, B:92:0x016f, B:93:0x0172, B:94:0x0173, B:96:0x0179, B:121:0x01f9, B:122:0x01fc, B:80:0x0134, B:123:0x01fd, B:70:0x0108, B:124:0x01fe, B:129:0x0204, B:154:0x0277, B:49:0x00ae, B:43:0x009d), top: B:208:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x014d A[Catch: all -> 0x016c, TryCatch #5 {all -> 0x016c, blocks: (B:84:0x013e, B:87:0x0145, B:89:0x014d, B:155:0x0278, B:92:0x016f, B:93:0x0172, B:94:0x0173, B:96:0x0179, B:121:0x01f9, B:122:0x01fc, B:80:0x0134, B:123:0x01fd, B:70:0x0108, B:124:0x01fe, B:129:0x0204, B:154:0x0277, B:49:0x00ae, B:43:0x009d), top: B:208:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x016f A[Catch: all -> 0x016c, TryCatch #5 {all -> 0x016c, blocks: (B:84:0x013e, B:87:0x0145, B:89:0x014d, B:155:0x0278, B:92:0x016f, B:93:0x0172, B:94:0x0173, B:96:0x0179, B:121:0x01f9, B:122:0x01fc, B:80:0x0134, B:123:0x01fd, B:70:0x0108, B:124:0x01fe, B:129:0x0204, B:154:0x0277, B:49:0x00ae, B:43:0x009d), top: B:208:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0179 A[Catch: all -> 0x016c, TRY_LEAVE, TryCatch #5 {all -> 0x016c, blocks: (B:84:0x013e, B:87:0x0145, B:89:0x014d, B:155:0x0278, B:92:0x016f, B:93:0x0172, B:94:0x0173, B:96:0x0179, B:121:0x01f9, B:122:0x01fc, B:80:0x0134, B:123:0x01fd, B:70:0x0108, B:124:0x01fe, B:129:0x0204, B:154:0x0277, B:49:0x00ae, B:43:0x009d), top: B:208:0x001b }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 827
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.voicewakeup.training.TrainingActivity$startTrainingFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
