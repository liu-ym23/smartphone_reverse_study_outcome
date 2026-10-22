package com.stepos.core.ota.crypto;

import com.stepos.core.ability.speech.PcmDumpBudget;
import com.stepos.core.ota.d;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.e;
import lb.n;
import qb.b;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelCryptoImpl implements IModelCrypto {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final int MAGIC_BYTES = 4;

    @Deprecated
    public static final int MAX_DECRYPT_THREADS = 8;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CryptoAlgorithm.values().length];
            try {
                iArr[CryptoAlgorithm.AES_256_GCM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CryptoAlgorithm.CHACHA20_POLY1305.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CryptoAlgorithm.SM4_GCM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.crypto.ModelCryptoImpl", f = "ModelCryptoImpl.kt", l = {101}, m = "decryptBlocksParallel")
    /* renamed from: com.stepos.core.ota.crypto.ModelCryptoImpl$decryptBlocksParallel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(b<? super AnonymousClass1> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ModelCryptoImpl.this.decryptBlocksParallel(null, null, null, null, 0, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object decryptBlocksParallel(java.lang.String r22, byte[] r23, com.stepos.core.ota.crypto.CryptoHeader r24, java.nio.ByteBuffer r25, int r26, qb.b<? super lb.n> r27) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.crypto.ModelCryptoImpl.decryptBlocksParallel(java.lang.String, byte[], com.stepos.core.ota.crypto.CryptoHeader, java.nio.ByteBuffer, int, qb.b):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int decryptThreads(int i10) {
        if (i10 <= 1) {
            return 1;
        }
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        if (i10 > iAvailableProcessors) {
            i10 = iAvailableProcessors;
        }
        if (i10 > 8) {
            return 8;
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InputStream openStream(String str, byte[] bArr) {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(str), PcmDumpBudget.HARD_MAX_DIR_MB);
        try {
            byte[] bArr2 = new byte[38];
            readFully(bufferedInputStream, bArr2);
            CryptoHeader cryptoHeader = CryptoHeaderParser.INSTANCE.parse(bArr2);
            int i10 = WhenMappings.$EnumSwitchMapping$0[cryptoHeader.getAlgorithm().ordinal()];
            if (i10 == 1) {
                return new BlockDecryptingInputStream(bufferedInputStream, bArr, cryptoHeader);
            }
            if (i10 != 2 && i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            throw new UnsupportedOperationException("algorithm " + cryptoHeader.getAlgorithm() + " not implemented");
        } catch (Throwable th) {
            try {
                bufferedInputStream.close();
                n nVar = n.f10413a;
            } catch (Throwable th2) {
                kotlin.c.a(th2);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int readBlock(InputStream inputStream, byte[] bArr) {
        int i10;
        int i11 = 0;
        while (i11 < bArr.length && (i10 = inputStream.read(bArr, i11, bArr.length - i11)) >= 0) {
            i11 += i10;
        }
        return i11;
    }

    private final void readFully(InputStream inputStream, byte[] bArr) throws IOException {
        int i10 = 0;
        while (i10 < bArr.length) {
            int i11 = inputStream.read(bArr, i10, bArr.length - i10);
            if (i11 < 0) {
                throw new EOFException(d.e(i10, "payload truncated: got ", bArr.length, " of ", " bytes"));
            }
            i10 += i11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void readFullyAt(FileChannel fileChannel, long j10, ByteBuffer byteBuffer) throws IOException {
        while (byteBuffer.hasRemaining()) {
            int i10 = fileChannel.read(byteBuffer, j10);
            if (i10 < 0) {
                throw new EOFException(d.f(j10, "ciphertext truncated at offset "));
            }
            j10 += i10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] readHead(String str, int i10) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(str);
        try {
            byte[] bArr = new byte[i10];
            readFully(fileInputStream, bArr);
            fileInputStream.close();
            return bArr;
        } finally {
        }
    }

    /* renamed from: sealToFile-yxL6bBk$default, reason: not valid java name */
    public static /* synthetic */ Object m133sealToFileyxL6bBk$default(ModelCryptoImpl modelCryptoImpl, String str, String str2, byte[] bArr, int i10, b bVar, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            i10 = CryptoHeaderParser.MAX_BLOCK_SIZE;
        }
        return modelCryptoImpl.m134sealToFileyxL6bBk(str, str2, bArr, i10, bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.core.ota.crypto.IModelCrypto
    /* renamed from: decryptToBuffer-BWLJW6A */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo122decryptToBufferBWLJW6A(java.lang.String r11, byte[] r12, java.nio.ByteBuffer r13, qb.b<? super kotlin.Result<lb.n>> r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof com.stepos.core.ota.crypto.ModelCryptoImpl$decryptToBuffer$1
            if (r0 == 0) goto L13
            r0 = r14
            com.stepos.core.ota.crypto.ModelCryptoImpl$decryptToBuffer$1 r0 = (com.stepos.core.ota.crypto.ModelCryptoImpl$decryptToBuffer$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ota.crypto.ModelCryptoImpl$decryptToBuffer$1 r0 = new com.stepos.core.ota.crypto.ModelCryptoImpl$decryptToBuffer$1
            r0.<init>(r10, r14)
        L18:
            java.lang.Object r14 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.c.b(r14)
            goto L49
        L27:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L2f:
            kotlin.c.b(r14)
            kotlinx.coroutines.CoroutineDispatcher r14 = kotlinx.coroutines.Dispatchers.getIO()
            com.stepos.core.ota.crypto.ModelCryptoImpl$decryptToBuffer$2 r4 = new com.stepos.core.ota.crypto.ModelCryptoImpl$decryptToBuffer$2
            r9 = 0
            r5 = r10
            r6 = r11
            r7 = r12
            r8 = r13
            r4.<init>(r5, r6, r7, r8, r9)
            r0.label = r3
            java.lang.Object r14 = kotlinx.coroutines.BuildersKt.withContext(r14, r4, r0)
            if (r14 != r1) goto L49
            return r1
        L49:
            kotlin.Result r14 = (kotlin.Result) r14
            java.lang.Object r10 = r14.f9987a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.crypto.ModelCryptoImpl.mo122decryptToBufferBWLJW6A(java.lang.String, byte[], java.nio.ByteBuffer, qb.b):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.core.ota.crypto.IModelCrypto
    /* renamed from: decryptToFile-BWLJW6A */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo123decryptToFileBWLJW6A(java.lang.String r11, java.lang.String r12, byte[] r13, qb.b<? super kotlin.Result<java.lang.String>> r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof com.stepos.core.ota.crypto.ModelCryptoImpl$decryptToFile$1
            if (r0 == 0) goto L13
            r0 = r14
            com.stepos.core.ota.crypto.ModelCryptoImpl$decryptToFile$1 r0 = (com.stepos.core.ota.crypto.ModelCryptoImpl$decryptToFile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ota.crypto.ModelCryptoImpl$decryptToFile$1 r0 = new com.stepos.core.ota.crypto.ModelCryptoImpl$decryptToFile$1
            r0.<init>(r10, r14)
        L18:
            java.lang.Object r14 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.c.b(r14)
            goto L49
        L27:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L2f:
            kotlin.c.b(r14)
            kotlinx.coroutines.CoroutineDispatcher r14 = kotlinx.coroutines.Dispatchers.getIO()
            com.stepos.core.ota.crypto.ModelCryptoImpl$decryptToFile$2 r4 = new com.stepos.core.ota.crypto.ModelCryptoImpl$decryptToFile$2
            r9 = 0
            r5 = r10
            r6 = r11
            r8 = r12
            r7 = r13
            r4.<init>(r5, r6, r7, r8, r9)
            r0.label = r3
            java.lang.Object r14 = kotlinx.coroutines.BuildersKt.withContext(r14, r4, r0)
            if (r14 != r1) goto L49
            return r1
        L49:
            kotlin.Result r14 = (kotlin.Result) r14
            java.lang.Object r10 = r14.f9987a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.crypto.ModelCryptoImpl.mo123decryptToFileBWLJW6A(java.lang.String, java.lang.String, byte[], qb.b):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.core.ota.crypto.IModelCrypto
    /* renamed from: isEncrypted-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo124isEncryptedgIAlus(java.lang.String r6, qb.b<? super kotlin.Result<java.lang.Boolean>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.stepos.core.ota.crypto.ModelCryptoImpl$isEncrypted$1
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.core.ota.crypto.ModelCryptoImpl$isEncrypted$1 r0 = (com.stepos.core.ota.crypto.ModelCryptoImpl$isEncrypted$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ota.crypto.ModelCryptoImpl$isEncrypted$1 r0 = new com.stepos.core.ota.crypto.ModelCryptoImpl$isEncrypted$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.c.b(r7)
            goto L45
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            kotlin.c.b(r7)
            kotlinx.coroutines.CoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getIO()
            com.stepos.core.ota.crypto.ModelCryptoImpl$isEncrypted$2 r2 = new com.stepos.core.ota.crypto.ModelCryptoImpl$isEncrypted$2
            r4 = 0
            r2.<init>(r5, r6, r4)
            r0.label = r3
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r2, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r5 = r7.f9987a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.crypto.ModelCryptoImpl.mo124isEncryptedgIAlus(java.lang.String, qb.b):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.core.ota.crypto.IModelCrypto
    /* renamed from: openDecryptedStream-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo125openDecryptedStream0E7RQCE(java.lang.String r6, byte[] r7, qb.b<? super kotlin.Result<? extends java.io.InputStream>> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.stepos.core.ota.crypto.ModelCryptoImpl$openDecryptedStream$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.core.ota.crypto.ModelCryptoImpl$openDecryptedStream$1 r0 = (com.stepos.core.ota.crypto.ModelCryptoImpl$openDecryptedStream$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ota.crypto.ModelCryptoImpl$openDecryptedStream$1 r0 = new com.stepos.core.ota.crypto.ModelCryptoImpl$openDecryptedStream$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.c.b(r8)
            goto L45
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            kotlin.c.b(r8)
            kotlinx.coroutines.CoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.getIO()
            com.stepos.core.ota.crypto.ModelCryptoImpl$openDecryptedStream$2 r2 = new com.stepos.core.ota.crypto.ModelCryptoImpl$openDecryptedStream$2
            r4 = 0
            r2.<init>(r5, r6, r7, r4)
            r0.label = r3
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r2, r0)
            if (r8 != r1) goto L45
            return r1
        L45:
            kotlin.Result r8 = (kotlin.Result) r8
            java.lang.Object r5 = r8.f9987a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.crypto.ModelCryptoImpl.mo125openDecryptedStream0E7RQCE(java.lang.String, byte[], qb.b):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.core.ota.crypto.IModelCrypto
    /* renamed from: readHeader-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo126readHeadergIAlus(java.lang.String r6, qb.b<? super kotlin.Result<com.stepos.core.ota.crypto.CryptoHeader>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.stepos.core.ota.crypto.ModelCryptoImpl$readHeader$1
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.core.ota.crypto.ModelCryptoImpl$readHeader$1 r0 = (com.stepos.core.ota.crypto.ModelCryptoImpl$readHeader$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ota.crypto.ModelCryptoImpl$readHeader$1 r0 = new com.stepos.core.ota.crypto.ModelCryptoImpl$readHeader$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.c.b(r7)
            goto L45
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            kotlin.c.b(r7)
            kotlinx.coroutines.CoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getIO()
            com.stepos.core.ota.crypto.ModelCryptoImpl$readHeader$2 r2 = new com.stepos.core.ota.crypto.ModelCryptoImpl$readHeader$2
            r4 = 0
            r2.<init>(r5, r6, r4)
            r0.label = r3
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r2, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r5 = r7.f9987a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.crypto.ModelCryptoImpl.mo126readHeadergIAlus(java.lang.String, qb.b):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* renamed from: sealToFile-yxL6bBk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m134sealToFileyxL6bBk(java.lang.String r12, java.lang.String r13, byte[] r14, int r15, qb.b<? super kotlin.Result<java.lang.String>> r16) {
        /*
            r11 = this;
            r0 = r16
            boolean r1 = r0 instanceof com.stepos.core.ota.crypto.ModelCryptoImpl$sealToFile$1
            if (r1 == 0) goto L15
            r1 = r0
            com.stepos.core.ota.crypto.ModelCryptoImpl$sealToFile$1 r1 = (com.stepos.core.ota.crypto.ModelCryptoImpl$sealToFile$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            com.stepos.core.ota.crypto.ModelCryptoImpl$sealToFile$1 r1 = new com.stepos.core.ota.crypto.ModelCryptoImpl$sealToFile$1
            r1.<init>(r11, r0)
        L1a:
            java.lang.Object r0 = r1.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r9 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r1.label
            r10 = 1
            if (r2 == 0) goto L31
            if (r2 != r10) goto L29
            kotlin.c.b(r0)
            goto L4c
        L29:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L31:
            kotlin.c.b(r0)
            kotlinx.coroutines.CoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.getIO()
            com.stepos.core.ota.crypto.ModelCryptoImpl$sealToFile$2 r2 = new com.stepos.core.ota.crypto.ModelCryptoImpl$sealToFile$2
            r8 = 0
            r7 = r11
            r4 = r12
            r6 = r13
            r5 = r14
            r3 = r15
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r1.label = r10
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.withContext(r0, r2, r1)
            if (r0 != r9) goto L4c
            return r9
        L4c:
            kotlin.Result r0 = (kotlin.Result) r0
            java.lang.Object r0 = r0.f9987a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.crypto.ModelCryptoImpl.m134sealToFileyxL6bBk(java.lang.String, java.lang.String, byte[], int, qb.b):java.lang.Object");
    }
}
