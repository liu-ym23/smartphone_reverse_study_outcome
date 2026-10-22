package com.stepos.ability.voicewakeup.training;

import C4.g;
import C7.r;
import E4.e;
import M0.i;
import S7.n;
import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.InterfaceC1733z;

@J7.c(c = "com.stepos.ability.voicewakeup.training.TrainingActivity$startTrainingFlow$1$loaded$1", f = "TrainingActivity.kt", l = {}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Ljava/nio/ByteBuffer;", "<anonymous>", "(Lm9/z;)Ljava/nio/ByteBuffer;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class TrainingActivity$startTrainingFlow$1$loaded$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TrainingActivity f3390a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrainingActivity$startTrainingFlow$1$loaded$1(TrainingActivity trainingActivity, H7.c cVar) {
        super(2, cVar);
        this.f3390a = trainingActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new TrainingActivity$startTrainingFlow$1$loaded$1(this.f3390a, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((TrainingActivity$startTrainingFlow$1$loaded$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws IOException {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        kotlin.b.b(obj);
        TrainingActivity trainingActivity = this.f3390a;
        e eVar = (e) trainingActivity.n.getF4884a();
        g gVar = trainingActivity.u;
        if (gVar == null) {
            k.n("wakeupWord");
            throw null;
        }
        eVar.getClass();
        String str = gVar.d;
        Context context = eVar.f475a;
        File file = new File(context.getFilesDir(), B7.a.m("base_", gVar.f296a, ".uim"));
        if (!file.exists() || file.length() <= 0) {
            if (file.exists()) {
                file.delete();
            }
            InputStream inputStreamOpen = context.getAssets().open(str);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    k.c(inputStreamOpen);
                    i.s(inputStreamOpen, fileOutputStream);
                    fileOutputStream.close();
                    inputStreamOpen.close();
                    if (file.length() == 0) {
                        file.delete();
                        throw new IOException(B7.a.m("assets/", str, " is empty"));
                    }
                } finally {
                }
            } finally {
            }
        }
        byte[] bArrV = O7.i.V(file);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(bArrV.length);
        byteBufferAllocateDirect.put(bArrV);
        byteBufferAllocateDirect.rewind();
        return byteBufferAllocateDirect;
    }
}
