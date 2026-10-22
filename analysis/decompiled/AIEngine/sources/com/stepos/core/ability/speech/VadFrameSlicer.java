package com.stepos.core.ability.speech;

import com.stepos.deepbinder.core.exception.ErrorCodes;
import java.io.ByteArrayOutputStream;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class VadFrameSlicer {
    private final ByteArrayOutputStream carry = new ByteArrayOutputStream();
    private final short[] frame;
    private final int frameBytes;
    private final int frameSamples;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.VadFrameSlicer", f = "VadFrameSlicer.kt", l = {ErrorCodes.API_VERSION_CODE_TOO_HIGH}, m = "offer")
    /* renamed from: com.stepos.core.ability.speech.VadFrameSlicer$offer$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(qb.b<? super AnonymousClass1> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return VadFrameSlicer.this.offer(null, null, this);
        }
    }

    public VadFrameSlicer(int i10) {
        this.frameSamples = i10;
        this.frameBytes = i10 * 2;
        this.frame = new short[i10];
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object offer(byte[] r12, zb.p<? super short[], ? super qb.b<? super lb.n>, ? extends java.lang.Object> r13, qb.b<? super java.lang.Integer> r14) {
        /*
            r11 = this;
            boolean r0 = r14 instanceof com.stepos.core.ability.speech.VadFrameSlicer.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r14
            com.stepos.core.ability.speech.VadFrameSlicer$offer$1 r0 = (com.stepos.core.ability.speech.VadFrameSlicer.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ability.speech.VadFrameSlicer$offer$1 r0 = new com.stepos.core.ability.speech.VadFrameSlicer$offer$1
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 != r4) goto L3c
            int r11 = r0.I$1
            int r12 = r0.I$0
            java.lang.Object r13 = r0.L$2
            byte[] r13 = (byte[]) r13
            java.lang.Object r2 = r0.L$1
            zb.p r2 = (zb.p) r2
            java.lang.Object r5 = r0.L$0
            com.stepos.core.ability.speech.VadFrameSlicer r5 = (com.stepos.core.ability.speech.VadFrameSlicer) r5
            kotlin.c.b(r14)
            r14 = r12
            r12 = r2
            r2 = r11
            r11 = r5
            goto L5d
        L3c:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L44:
            kotlin.c.b(r14)
            java.io.ByteArrayOutputStream r14 = r11.carry
            int r2 = r12.length
            r14.write(r12, r3, r2)
            java.io.ByteArrayOutputStream r12 = r11.carry
            byte[] r12 = r12.toByteArray()
            java.io.ByteArrayOutputStream r14 = r11.carry
            r14.reset()
            r14 = r13
            r13 = r12
            r12 = r14
            r14 = r3
            r2 = r14
        L5d:
            int r5 = r11.frameBytes
            int r5 = r5 + r14
            int r6 = r13.length
            if (r5 > r6) goto L98
            int r5 = r11.frameSamples
            r7 = r14
            r6 = r3
        L67:
            if (r6 >= r5) goto L7e
            short[] r8 = r11.frame
            int r9 = r7 + 1
            r9 = r13[r9]
            int r9 = r9 << 8
            r10 = r13[r7]
            r10 = r10 & 255(0xff, float:3.57E-43)
            r9 = r9 | r10
            short r9 = (short) r9
            r8[r6] = r9
            int r7 = r7 + 2
            int r6 = r6 + 1
            goto L67
        L7e:
            int r5 = r11.frameBytes
            int r14 = r14 + r5
            int r2 = r2 + 1
            short[] r5 = r11.frame
            r0.L$0 = r11
            r0.L$1 = r12
            r0.L$2 = r13
            r0.I$0 = r14
            r0.I$1 = r2
            r0.label = r4
            java.lang.Object r5 = r12.invoke(r5, r0)
            if (r5 != r1) goto L5d
            return r1
        L98:
            int r12 = r13.length
            if (r14 >= r12) goto La2
            java.io.ByteArrayOutputStream r11 = r11.carry
            int r12 = r13.length
            int r12 = r12 - r14
            r11.write(r13, r14, r12)
        La2:
            java.lang.Integer r11 = new java.lang.Integer
            r11.<init>(r2)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.VadFrameSlicer.offer(byte[], zb.p, qb.b):java.lang.Object");
    }

    public final int pendingBytes() {
        return this.carry.size();
    }
}
