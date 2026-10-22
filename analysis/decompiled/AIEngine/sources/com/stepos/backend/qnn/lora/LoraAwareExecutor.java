package com.stepos.backend.qnn.lora;

import android.util.Log;
import com.stepos.backend.qnn.QnnNative;
import com.stepos.backend.qnn.lora.SwitchResult;
import com.stepos.core.data.base.Content;
import com.stepos.deepbinder.core.exception.ErrorCodes;
import gc.q;
import java.io.File;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import lb.n;
import qb.b;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class LoraAwareExecutor {
    private static final long DRAIN_TIMEOUT_MS = 15000;
    public static final LoraAwareExecutor INSTANCE = new LoraAwareExecutor();
    private static final String TAG = "LoraAwareExecutor";

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.backend.qnn.lora.LoraAwareExecutor", f = "LoraAwareExecutor.kt", l = {Content.Types.TYPE_DOUBLE_ARRAY}, m = "drainPermits")
    /* renamed from: com.stepos.backend.qnn.lora.LoraAwareExecutor$drainPermits$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(b<? super AnonymousClass1> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LoraAwareExecutor.this.drainPermits(null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.backend.qnn.lora.LoraAwareExecutor$resetLora$2", f = "LoraAwareExecutor.kt", l = {81}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.qnn.lora.LoraAwareExecutor$resetLora$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<CoroutineScope, b<? super SwitchResult>, Object> {
        final /* synthetic */ long $handle;
        final /* synthetic */ String $loraId;
        final /* synthetic */ long $startMs;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, long j10, long j11, b<? super AnonymousClass2> bVar) {
            super(2, bVar);
            this.$loraId = str;
            this.$handle = j10;
            this.$startMs = j11;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<n> create(Object obj, b<?> bVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$loraId, this.$handle, this.$startMs, bVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                LoraAwareExecutor loraAwareExecutor = LoraAwareExecutor.INSTANCE;
                String str = this.$loraId;
                this.L$0 = coroutineScope;
                this.label = 1;
                obj = loraAwareExecutor.drainPermits(str, this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            Integer num = (Integer) obj;
            if (num == null) {
                return new SwitchResult.Timeout(this.$loraId, System.currentTimeMillis() - this.$startMs);
            }
            int iIntValue = num.intValue();
            try {
                Log.i(LoraAwareExecutor.TAG, "[" + this.$loraId + "] Resetting LoRA to base model");
                QnnNative.nativeResetLoRA(this.$handle);
                long jCurrentTimeMillis = System.currentTimeMillis() - this.$startMs;
                Log.i(LoraAwareExecutor.TAG, "[" + this.$loraId + "] ✅ LoRA reset | cost: " + jCurrentTimeMillis + "ms");
                return new SwitchResult.Reset(this.$loraId, jCurrentTimeMillis);
            } catch (Exception e10) {
                Log.e(LoraAwareExecutor.TAG, "[" + this.$loraId + "] resetLora failed: " + e10.getMessage());
                String str2 = this.$loraId;
                String message = e10.getMessage();
                if (message == null) {
                    message = "unknown";
                }
                return new SwitchResult.Error(str2, message);
            } finally {
                LoraAwareExecutor.INSTANCE.releasePermits(iIntValue);
            }
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, b<? super SwitchResult> bVar) {
            return ((AnonymousClass2) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.backend.qnn.lora.LoraAwareExecutor$switchLora$2", f = "LoraAwareExecutor.kt", l = {ErrorCodes.SERVICE_RECYCLE_ERROR}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.qnn.lora.LoraAwareExecutor$switchLora$2, reason: invalid class name and case insensitive filesystem */
    public static final class C02822 extends SuspendLambda implements p<CoroutineScope, b<? super SwitchResult>, Object> {
        final /* synthetic */ long $handle;
        final /* synthetic */ String $loraId;
        final /* synthetic */ String $loraPath;
        final /* synthetic */ long $startMs;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02822(String str, String str2, long j10, long j11, b<? super C02822> bVar) {
            super(2, bVar);
            this.$loraId = str;
            this.$loraPath = str2;
            this.$handle = j10;
            this.$startMs = j11;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<n> create(Object obj, b<?> bVar) {
            C02822 c02822 = new C02822(this.$loraId, this.$loraPath, this.$handle, this.$startMs, bVar);
            c02822.L$0 = obj;
            return c02822;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object error;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                LoraAwareExecutor loraAwareExecutor = LoraAwareExecutor.INSTANCE;
                String str = this.$loraId;
                this.L$0 = coroutineScope;
                this.label = 1;
                obj = loraAwareExecutor.drainPermits(str, this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            Integer num = (Integer) obj;
            if (num == null) {
                return new SwitchResult.Timeout(this.$loraId, System.currentTimeMillis() - this.$startMs);
            }
            int iIntValue = num.intValue();
            try {
                Log.i(LoraAwareExecutor.TAG, "[" + this.$loraId + "] All " + iIntValue + " DSP permits acquired, switching: " + this.$loraPath);
                boolean zNativeSwitchLoRA = QnnNative.nativeSwitchLoRA(this.$handle, this.$loraPath);
                long jCurrentTimeMillis = System.currentTimeMillis() - this.$startMs;
                if (zNativeSwitchLoRA) {
                    Log.i(LoraAwareExecutor.TAG, "[" + this.$loraId + "] ✅ LoRA switched | cost: " + jCurrentTimeMillis + "ms");
                    error = new SwitchResult.Success(this.$loraId, jCurrentTimeMillis);
                } else {
                    Log.e(LoraAwareExecutor.TAG, "[" + this.$loraId + "] ❌ nativeSwitchLoRA returned false");
                    error = new SwitchResult.Error(this.$loraId, "nativeSwitchLoRA returned false");
                }
                LoraAwareExecutor.INSTANCE.releasePermits(iIntValue);
                return error;
            } catch (Throwable th) {
                LoraAwareExecutor.INSTANCE.releasePermits(iIntValue);
                throw th;
            }
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, b<? super SwitchResult> bVar) {
            return ((C02822) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    private LoraAwareExecutor() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0065 -> B:20:0x0068). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object drainPermits(java.lang.String r10, qb.b<? super java.lang.Integer> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.stepos.backend.qnn.lora.LoraAwareExecutor.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r11
            com.stepos.backend.qnn.lora.LoraAwareExecutor$drainPermits$1 r0 = (com.stepos.backend.qnn.lora.LoraAwareExecutor.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.backend.qnn.lora.LoraAwareExecutor$drainPermits$1 r0 = new com.stepos.backend.qnn.lora.LoraAwareExecutor$drainPermits$1
            r0.<init>(r11)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r11 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r0.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L3c
            if (r1 != r3) goto L34
            int r10 = r0.I$1
            int r1 = r0.I$0
            java.lang.Object r4 = r0.L$1
            kotlin.jvm.internal.Ref$IntRef r4 = (kotlin.jvm.internal.Ref$IntRef) r4
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.c.b(r9)
            goto L68
        L34:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3c:
            kotlin.c.b(r9)
            com.stepos.backend.qnn.QnnNative r9 = com.stepos.backend.qnn.QnnNative.INSTANCE
            int r9 = r9.dspPermitCapacity()
            kotlin.jvm.internal.Ref$IntRef r1 = new kotlin.jvm.internal.Ref$IntRef
            r1.<init>()
            r4 = r1
            r1 = r9
            r9 = r10
            r10 = r2
        L4e:
            if (r10 >= r1) goto La3
            com.stepos.backend.qnn.QnnNative r5 = com.stepos.backend.qnn.QnnNative.INSTANCE
            r0.L$0 = r9
            r0.L$1 = r4
            r0.I$0 = r1
            r0.I$1 = r10
            r0.label = r3
            r6 = 15000(0x3a98, double:7.411E-320)
            java.lang.Object r5 = r5.acquireRawPermitWithTimeout(r6, r0)
            if (r5 != r11) goto L65
            return r11
        L65:
            r8 = r5
            r5 = r9
            r9 = r8
        L68:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L78
            int r9 = r4.f10074a
            int r9 = r9 + r3
            r4.f10074a = r9
            int r10 = r10 + r3
            r9 = r5
            goto L4e
        L78:
            int r9 = r4.f10074a
            java.lang.String r10 = "] Timeout waiting for infer permit ("
            java.lang.String r11 = "/"
            java.lang.String r0 = "["
            java.lang.StringBuilder r9 = h0.e.f(r0, r5, r10, r9, r11)
            r9.append(r1)
            java.lang.String r10 = ")"
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            java.lang.String r10 = "LoraAwareExecutor"
            android.util.Log.w(r10, r9)
            int r9 = r4.f10074a
        L97:
            if (r2 >= r9) goto La1
            com.stepos.backend.qnn.QnnNative r10 = com.stepos.backend.qnn.QnnNative.INSTANCE
            r10.releaseRawPermit()
            int r2 = r2 + 1
            goto L97
        La1:
            r9 = 0
            return r9
        La3:
            int r9 = r4.f10074a
            java.lang.Integer r10 = new java.lang.Integer
            r10.<init>(r9)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.lora.LoraAwareExecutor.drainPermits(java.lang.String, qb.b):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void releasePermits(int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            QnnNative.INSTANCE.releaseRawPermit();
        }
    }

    public final Object resetLora(String str, long j10, b<? super SwitchResult> bVar) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(str, j10, System.currentTimeMillis(), null), bVar);
    }

    public final Object switchLora(String str, String str2, long j10, b<? super SwitchResult> bVar) {
        if (q.l0(str2, "..", false)) {
            Log.e(TAG, "[" + str + "] Path traversal rejected: " + str2);
            return new SwitchResult.Error(str, "Path traversal rejected: ".concat(str2));
        }
        if (new File(str2).exists()) {
            return BuildersKt.withContext(Dispatchers.getIO(), new C02822(str, str2, j10, System.currentTimeMillis(), null), bVar);
        }
        Log.e(TAG, "[" + str + "] LoRA file not found: " + str2);
        return new SwitchResult.Error(str, "LoRA file not found: ".concat(str2));
    }
}
