package com.stepos.ailauncher.speech.asr;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.speech.asr.MicCapturePrewarm$startReading$1", f = "MicCapturePrewarm.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class MicCapturePrewarm$startReading$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ CountDownLatch $exitLatch;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MicCapturePrewarm this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MicCapturePrewarm$startReading$1(MicCapturePrewarm micCapturePrewarm, CountDownLatch countDownLatch, InterfaceC4014c<? super MicCapturePrewarm$startReading$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = micCapturePrewarm;
        this.$exitLatch = countDownLatch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        MicCapturePrewarm$startReading$1 micCapturePrewarm$startReading$1 = new MicCapturePrewarm$startReading$1(this.this$0, this.$exitLatch, interfaceC4014c);
        micCapturePrewarm$startReading$1.L$0 = obj;
        return micCapturePrewarm$startReading$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((MicCapturePrewarm$startReading$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        M m10 = (M) this.L$0;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        try {
            int i10 = this.this$0.chunkSize;
            byte[] bArr = new byte[i10];
            while (this.this$0.running.get() && kotlinx.coroutines.d.h(m10) && !this.this$0.released.get() && this.this$0.getRecorder().getRecordingState() == 3) {
                MicCapturePrewarm micCapturePrewarm = this.this$0;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objB = Result.b(C4109a.f(micCapturePrewarm.getRecorder().read(bArr, 0, i10)));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                Integer numF = C4109a.f(0);
                if (Result.g(objB)) {
                    objB = numF;
                }
                int iIntValue = ((Number) objB).intValue();
                if (iIntValue > 0) {
                    byte[] bArrCopyOf = Arrays.copyOf(bArr, iIntValue);
                    kotlin.jvm.internal.p.h(bArrCopyOf, "copyOf(...)");
                    Object obj2 = this.this$0.lock;
                    MicCapturePrewarm micCapturePrewarm2 = this.this$0;
                    synchronized (obj2) {
                        try {
                            micCapturePrewarm2.ring.addLast(bArrCopyOf);
                            while (micCapturePrewarm2.ring.size() > micCapturePrewarm2.ringFrames) {
                                micCapturePrewarm2.ring.removeFirst();
                                micCapturePrewarm2.droppedFrames++;
                            }
                            t tVar = t.f7040a;
                        } finally {
                        }
                    }
                } else if (iIntValue < 0) {
                    break;
                }
            }
            this.$exitLatch.countDown();
            return t.f7040a;
        } catch (Throwable th2) {
            this.$exitLatch.countDown();
            throw th2;
        }
    }
}
