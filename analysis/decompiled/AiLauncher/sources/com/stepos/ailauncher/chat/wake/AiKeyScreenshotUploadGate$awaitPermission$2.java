package com.stepos.ailauncher.chat.wake;

import com.stepos.ailauncher.chat.wake.AiKeyScreenshotUploadGate;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/AiKeyScreenshotUploadGate$b;", "it", "", "<anonymous>", "(Lcom/stepos/ailauncher/chat/wake/AiKeyScreenshotUploadGate$b;)Z"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.wake.AiKeyScreenshotUploadGate$awaitPermission$2", f = "AiKeyScreenshotUploadGate.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AiKeyScreenshotUploadGate$awaitPermission$2 extends SuspendLambda implements p9.p<AiKeyScreenshotUploadGate.State, InterfaceC4014c<? super Boolean>, Object> {
    final /* synthetic */ long $round;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiKeyScreenshotUploadGate$awaitPermission$2(long j10, InterfaceC4014c<? super AiKeyScreenshotUploadGate$awaitPermission$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$round = j10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AiKeyScreenshotUploadGate$awaitPermission$2 aiKeyScreenshotUploadGate$awaitPermission$2 = new AiKeyScreenshotUploadGate$awaitPermission$2(this.$round, interfaceC4014c);
        aiKeyScreenshotUploadGate$awaitPermission$2.L$0 = obj;
        return aiKeyScreenshotUploadGate$awaitPermission$2;
    }

    @Override // p9.p
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(AiKeyScreenshotUploadGate.State bVar, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return ((AiKeyScreenshotUploadGate$awaitPermission$2) create(bVar, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        AiKeyScreenshotUploadGate.State bVar = (AiKeyScreenshotUploadGate.State) this.L$0;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        return C4109a.a((bVar.getRound() == this.$round && bVar.getDecision() == AiKeyScreenshotUploadGate.Decision.PENDING) ? false : true);
    }
}
