package com.stepos.ability.voicewakeup.training;

import C4.g;
import C7.r;
import E4.d;
import E4.e;
import S7.n;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.k;
import m9.InterfaceC1733z;

@J7.c(c = "com.stepos.ability.voicewakeup.training.TrainingActivity$generateAndSaveModel$2", f = "TrainingActivity.kt", l = {}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class TrainingActivity$generateAndSaveModel$2 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef f3377a;
    public final /* synthetic */ TrainingActivity b;
    public final /* synthetic */ ByteBuffer c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrainingActivity$generateAndSaveModel$2(Ref$ObjectRef ref$ObjectRef, TrainingActivity trainingActivity, ByteBuffer byteBuffer, H7.c cVar) {
        super(2, cVar);
        this.f3377a = ref$ObjectRef;
        this.b = trainingActivity;
        this.c = byteBuffer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new TrainingActivity$generateAndSaveModel$2(this.f3377a, this.b, this.c, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) throws IOException {
        TrainingActivity$generateAndSaveModel$2 trainingActivity$generateAndSaveModel$2 = (TrainingActivity$generateAndSaveModel$2) create((InterfaceC1733z) obj, (H7.c) obj2);
        r rVar = r.f317a;
        trainingActivity$generateAndSaveModel$2.invokeSuspend(rVar);
        return rVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws IOException {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        kotlin.b.b(obj);
        TrainingActivity trainingActivity = this.b;
        e eVar = (e) trainingActivity.n.getF4884a();
        g gVar = trainingActivity.u;
        if (gVar == null) {
            k.n("wakeupWord");
            throw null;
        }
        String wordId = gVar.f296a;
        eVar.getClass();
        k.f(wordId, "wordId");
        ByteBuffer byteBuffer = this.c;
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        File fileA = eVar.a(wordId);
        File fileCreateTempFile = File.createTempFile(B7.a.m(".", fileA.getName(), "-"), ".pending", fileA.getParentFile());
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.close();
                k.c(fileCreateTempFile);
                this.f3377a.f4920a = new d(fileCreateTempFile, fileA);
                return r.f317a;
            } finally {
            }
        } catch (Throwable th) {
            try {
                fileCreateTempFile.delete();
            } catch (Throwable th2) {
                kotlin.b.a(th2);
            }
            throw th;
        }
    }
}
