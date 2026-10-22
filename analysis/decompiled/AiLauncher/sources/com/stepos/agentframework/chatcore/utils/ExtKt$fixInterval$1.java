package com.stepos.agentframework.chatcore.utils;

import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$LongRef;
import p9.p;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LXa/c;", "LY8/t;", "<anonymous>", "(LXa/c;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.utils.ExtKt$fixInterval$1", f = "Ext.kt", l = {39}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class ExtKt$fixInterval$1<T> extends SuspendLambda implements p<Xa.c<? super T>, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ long $interval;
    final /* synthetic */ Xa.b<T> $this_fixInterval;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.utils.ExtKt$fixInterval$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Xa.c {
        final /* synthetic */ Xa.c<T> $$this$flow;
        final /* synthetic */ long $interval;
        final /* synthetic */ Ref$LongRef $lastTime;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Ref$LongRef ref$LongRef, long j10, Xa.c<? super T> cVar) {
            this.$lastTime = ref$LongRef;
            this.$interval = j10;
            this.$$this$flow = cVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x007d, code lost:
        
            if (r12.emit(r13, r0) != r1) goto L26;
         */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // Xa.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(T r13, e9.InterfaceC4014c<? super Y8.t> r14) throws java.lang.Throwable {
            /*
                r12 = this;
                boolean r0 = r14 instanceof com.stepos.agentframework.chatcore.utils.ExtKt$fixInterval$1$1$emit$1
                if (r0 == 0) goto L13
                r0 = r14
                com.stepos.agentframework.chatcore.utils.ExtKt$fixInterval$1$1$emit$1 r0 = (com.stepos.agentframework.chatcore.utils.ExtKt$fixInterval$1$1$emit$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.stepos.agentframework.chatcore.utils.ExtKt$fixInterval$1$1$emit$1 r0 = new com.stepos.agentframework.chatcore.utils.ExtKt$fixInterval$1$1$emit$1
                r0.<init>(r12, r14)
            L18:
                java.lang.Object r14 = r0.result
                java.lang.Object r1 = f9.C4063a.g()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L3e
                if (r2 == r4) goto L34
                if (r2 != r3) goto L2c
                kotlin.C4849c.b(r14)
                goto L80
            L2c:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r13)
                throw r12
            L34:
                long r4 = r0.J$1
                long r6 = r0.J$0
                java.lang.Object r13 = r0.L$0
                kotlin.C4849c.b(r14)
                goto L62
            L3e:
                kotlin.C4849c.b(r14)
                long r6 = android.os.SystemClock.elapsedRealtime()
                kotlin.jvm.internal.Ref$LongRef r14 = r12.$lastTime
                long r8 = r14.f34819a
                long r8 = r6 - r8
                long r10 = r12.$interval
                int r14 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                if (r14 >= 0) goto L63
                long r10 = r10 - r8
                r0.L$0 = r13
                r0.J$0 = r6
                r0.J$1 = r8
                r0.label = r4
                java.lang.Object r14 = Ua.U.a(r10, r0)
                if (r14 != r1) goto L61
                goto L7f
            L61:
                r4 = r8
            L62:
                r8 = r4
            L63:
                kotlin.jvm.internal.Ref$LongRef r14 = r12.$lastTime
                long r4 = android.os.SystemClock.elapsedRealtime()
                r14.f34819a = r4
                Xa.c<T> r12 = r12.$$this$flow
                java.lang.Object r14 = g9.h.a(r13)
                r0.L$0 = r14
                r0.J$0 = r6
                r0.J$1 = r8
                r0.label = r3
                java.lang.Object r12 = r12.emit(r13, r0)
                if (r12 != r1) goto L80
            L7f:
                return r1
            L80:
                Y8.t r12 = Y8.t.f7040a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.utils.ExtKt$fixInterval$1.AnonymousClass1.emit(java.lang.Object, e9.c):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ExtKt$fixInterval$1(Xa.b<? extends T> bVar, long j10, InterfaceC4014c<? super ExtKt$fixInterval$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$this_fixInterval = bVar;
        this.$interval = j10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        ExtKt$fixInterval$1 extKt$fixInterval$1 = new ExtKt$fixInterval$1(this.$this_fixInterval, this.$interval, interfaceC4014c);
        extKt$fixInterval$1.L$0 = obj;
        return extKt$fixInterval$1;
    }

    @Override // p9.p
    public final Object invoke(Xa.c<? super T> cVar, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((ExtKt$fixInterval$1) create(cVar, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Xa.c cVar = (Xa.c) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Ref$LongRef ref$LongRef = new Ref$LongRef();
            Xa.b<T> bVar = this.$this_fixInterval;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(ref$LongRef, this.$interval, cVar);
            this.L$0 = g9.h.a(cVar);
            this.L$1 = g9.h.a(ref$LongRef);
            this.label = 1;
            if (bVar.collect(anonymousClass1, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return t.f7040a;
    }
}
