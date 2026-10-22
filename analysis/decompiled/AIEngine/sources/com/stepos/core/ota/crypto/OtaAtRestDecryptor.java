package com.stepos.core.ota.crypto;

import androidx.datastore.preferences.protobuf.b1;
import c7.c;
import com.stepos.core.common.memory.NativeMemfd;
import com.stepos.core.ota.domain.port.OtaLogger;
import gc.o;
import gc.q;
import java.io.File;
import java.io.IOException;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import lb.n;
import qb.b;
import wb.d;
import zb.a;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaAtRestDecryptor implements c {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final int MAX_UP = 4;

    @Deprecated
    public static final String TAG = "OtaAtRestDecryptor";
    private final ThreadLocal<byte[]> armedDek;
    private volatile byte[] armedDekGlobal;
    private final ModelCryptoImpl crypto;
    private final AtRestKeyStore keyStore;
    private final OtaLogger log;
    private final a<Boolean> migrationGate;
    private final AtRestSealer sealer;
    private final l<String, Boolean> shouldEncrypt;
    private final a<File> tempDir;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ota.crypto.OtaAtRestDecryptor", f = "OtaAtRestDecryptor.kt", l = {124}, m = "migrateIfNeeded")
    /* renamed from: com.stepos.core.ota.crypto.OtaAtRestDecryptor$migrateIfNeeded$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
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
            return OtaAtRestDecryptor.this.migrateIfNeeded(null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ota.crypto.OtaAtRestDecryptor", f = "OtaAtRestDecryptor.kt", l = {55, 56, 59}, m = "resolveForBackend")
    /* renamed from: com.stepos.core.ota.crypto.OtaAtRestDecryptor$resolveForBackend$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03871 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C03871(b<? super C03871> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OtaAtRestDecryptor.this.resolveForBackend(null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ota.crypto.OtaAtRestDecryptor", f = "OtaAtRestDecryptor.kt", l = {138}, m = "resolveViaMemfd")
    /* renamed from: com.stepos.core.ota.crypto.OtaAtRestDecryptor$resolveViaMemfd$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03881 extends ContinuationImpl {
        int I$0;
        int label;
        /* synthetic */ Object result;

        public C03881(b<? super C03881> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OtaAtRestDecryptor.this.resolveViaMemfd(null, null, 0L, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OtaAtRestDecryptor(AtRestKeyStore keyStore, ModelCryptoImpl crypto, OtaLogger log, a<? extends File> tempDir, a<Boolean> migrationGate, l<? super String, Boolean> shouldEncrypt) {
        g.f(keyStore, "keyStore");
        g.f(crypto, "crypto");
        g.f(log, "log");
        g.f(tempDir, "tempDir");
        g.f(migrationGate, "migrationGate");
        g.f(shouldEncrypt, "shouldEncrypt");
        this.keyStore = keyStore;
        this.crypto = crypto;
        this.log = log;
        this.tempDir = tempDir;
        this.migrationGate = migrationGate;
        this.shouldEncrypt = shouldEncrypt;
        this.sealer = new AtRestSealer(keyStore, crypto, log, shouldEncrypt, null, 16, null);
        this.armedDek = new ThreadLocal<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$1(String it) {
        g.f(it, "it");
        return false;
    }

    private final File findBundleDir(File file) {
        if (!file.isDirectory()) {
            file = file.getParentFile();
        }
        for (int i10 = 0; file != null && i10 <= 4; i10++) {
            if (new File(file, AtRestSealer.DEK_WRAP).isFile() || new File(file, AtRestSealer.MANIFEST).isFile()) {
                return file;
            }
            file = file.getParentFile();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n resolveForBackend$lambda$5(File file) {
        file.delete();
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0078 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:12:0x0029, B:31:0x006d, B:33:0x0078, B:35:0x0088, B:36:0x0099), top: B:43:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0088 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:12:0x0029, B:31:0x006d, B:33:0x0078, B:35:0x0088, B:36:0x0099), top: B:43:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object resolveViaMemfd(java.io.File r7, byte[] r8, long r9, qb.b<? super c7.d> r11) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.String r0 = "memfd seal failed fd="
            java.lang.String r1 = "memfd buffer null fd="
            boolean r2 = r11 instanceof com.stepos.core.ota.crypto.OtaAtRestDecryptor.C03881
            if (r2 == 0) goto L17
            r2 = r11
            com.stepos.core.ota.crypto.OtaAtRestDecryptor$resolveViaMemfd$1 r2 = (com.stepos.core.ota.crypto.OtaAtRestDecryptor.C03881) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.label = r3
            goto L1c
        L17:
            com.stepos.core.ota.crypto.OtaAtRestDecryptor$resolveViaMemfd$1 r2 = new com.stepos.core.ota.crypto.OtaAtRestDecryptor$resolveViaMemfd$1
            r2.<init>(r11)
        L1c:
            java.lang.Object r11 = r2.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r3 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L3c
            if (r4 != r5) goto L34
            int r6 = r2.I$0
            kotlin.c.b(r11)     // Catch: java.lang.Throwable -> L31
            kotlin.Result r11 = (kotlin.Result) r11     // Catch: java.lang.Throwable -> L31
            java.lang.Object r7 = r11.f9987a     // Catch: java.lang.Throwable -> L31
            goto L6d
        L31:
            r7 = move-exception
            goto Laf
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            kotlin.c.b(r11)
            com.stepos.core.common.memory.NativeMemfd r11 = com.stepos.core.common.memory.NativeMemfd.INSTANCE
            boolean r4 = r11.isAvailable()
            if (r4 != 0) goto L48
            goto L4e
        L48:
            int r9 = r11.createWritable(r9)
            if (r9 >= 0) goto L50
        L4e:
            r6 = 0
            return r6
        L50:
            java.nio.ByteBuffer r10 = r11.bufferFor(r9)     // Catch: java.lang.Throwable -> L9a
            if (r10 == 0) goto L9d
            com.stepos.core.ota.crypto.ModelCryptoImpl r6 = r6.crypto     // Catch: java.lang.Throwable -> L9a
            java.lang.String r7 = r7.getPath()     // Catch: java.lang.Throwable -> L9a
            java.lang.String r11 = "getPath(...)"
            kotlin.jvm.internal.g.e(r7, r11)     // Catch: java.lang.Throwable -> L9a
            r2.I$0 = r9     // Catch: java.lang.Throwable -> L9a
            r2.label = r5     // Catch: java.lang.Throwable -> L9a
            java.lang.Object r7 = r6.mo122decryptToBufferBWLJW6A(r7, r8, r10, r2)     // Catch: java.lang.Throwable -> L9a
            if (r7 != r3) goto L6c
            return r3
        L6c:
            r6 = r9
        L6d:
            kotlin.c.b(r7)     // Catch: java.lang.Throwable -> L31
            com.stepos.core.common.memory.NativeMemfd r7 = com.stepos.core.common.memory.NativeMemfd.INSTANCE     // Catch: java.lang.Throwable -> L31
            boolean r8 = r7.seal(r6)     // Catch: java.lang.Throwable -> L31
            if (r8 == 0) goto L88
            c7.d r8 = new c7.d     // Catch: java.lang.Throwable -> L31
            java.lang.String r7 = r7.pathOf(r6)     // Catch: java.lang.Throwable -> L31
            com.stepos.aicgroup.b r9 = new com.stepos.aicgroup.b     // Catch: java.lang.Throwable -> L31
            r10 = 1
            r9.<init>(r6, r10)     // Catch: java.lang.Throwable -> L31
            r8.<init>(r7, r9)     // Catch: java.lang.Throwable -> L31
            return r8
        L88:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L31
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L31
            r8.<init>(r0)     // Catch: java.lang.Throwable -> L31
            r8.append(r6)     // Catch: java.lang.Throwable -> L31
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L31
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L31
            throw r7     // Catch: java.lang.Throwable -> L31
        L9a:
            r7 = move-exception
            r6 = r9
            goto Laf
        L9d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L9a
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9a
            r7.<init>(r1)     // Catch: java.lang.Throwable -> L9a
            r7.append(r9)     // Catch: java.lang.Throwable -> L9a
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L9a
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L9a
            throw r6     // Catch: java.lang.Throwable -> L9a
        Laf:
            com.stepos.core.common.memory.NativeMemfd r8 = com.stepos.core.common.memory.NativeMemfd.INSTANCE
            r8.close(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.crypto.OtaAtRestDecryptor.resolveViaMemfd(java.io.File, byte[], long, qb.b):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n resolveViaMemfd$lambda$10(int i10) {
        NativeMemfd.INSTANCE.close(i10);
        return n.f10413a;
    }

    private final boolean sealedInManifest(File file, File file2) throws IOException {
        Object objA;
        File file3 = new File(file, AtRestSealer.MANIFEST);
        if (file3.isFile()) {
            try {
                String path = d.a0(file2, file).getPath();
                g.e(path, "getPath(...)");
                objA = o.h0(path, '\\', '/');
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            if (objA instanceof Result.Failure) {
                objA = null;
            }
            String str = (String) objA;
            if (str != null) {
                return q.l0(d.Z(file3, gc.a.f9106b), "\"" + str + "\"", false);
            }
        }
        return false;
    }

    @Override // c7.c
    public boolean armNativeDecrypt(File hint) {
        g.f(hint, "hint");
        File fileFindBundleDir = findBundleDir(hint);
        if (fileFindBundleDir == null) {
            return false;
        }
        File file = new File(fileFindBundleDir, AtRestSealer.DEK_WRAP);
        if (!file.isFile()) {
            return false;
        }
        byte[] bArrUnwrapDek = this.keyStore.unwrapDek(d.X(file));
        this.armedDek.set(bArrUnwrapDek);
        this.armedDekGlobal = bArrUnwrapDek;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0070  */
    @Override // c7.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean decryptWeightInto(java.lang.String r12, java.nio.ByteBuffer r13) {
        /*
            r11 = this;
            java.lang.String r1 = "OtaAtRestDecryptor"
            java.lang.String r0 = "decryptWeightInto "
            java.lang.String r2 = "srcPath"
            kotlin.jvm.internal.g.f(r12, r2)
            java.lang.String r2 = "out"
            kotlin.jvm.internal.g.f(r13, r2)
            java.lang.ThreadLocal<byte[]> r2 = r11.armedDek
            java.lang.Object r2 = r2.get()
            byte[] r2 = (byte[]) r2
            if (r2 != 0) goto L1e
            byte[] r2 = r11.armedDekGlobal
            if (r2 != 0) goto L1e
            r11 = 0
            return r11
        L1e:
            r5 = r2
            long r8 = java.lang.System.nanoTime()
            r10 = 1
            com.stepos.core.ota.crypto.OtaAtRestDecryptor$decryptWeightInto$1$1 r2 = new com.stepos.core.ota.crypto.OtaAtRestDecryptor$decryptWeightInto$1$1     // Catch: java.lang.Throwable -> L62
            r7 = 0
            r3 = r11
            r4 = r12
            r6 = r13
            r2.<init>(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L5f
            r11 = 0
            kotlinx.coroutines.BuildersKt.runBlocking$default(r11, r2, r10, r11)     // Catch: java.lang.Throwable -> L5f
            long r11 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L5f
            long r11 = r11 - r8
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r11 = r11 / r5
            com.stepos.core.ota.domain.port.OtaLogger r13 = r3.log     // Catch: java.lang.Throwable -> L5f
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L5f
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L5f
            java.lang.String r2 = r2.getName()     // Catch: java.lang.Throwable -> L5f
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5f
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L5f
            r5.append(r2)     // Catch: java.lang.Throwable -> L5f
            java.lang.String r0 = " decryptMs="
            r5.append(r0)     // Catch: java.lang.Throwable -> L5f
            r5.append(r11)     // Catch: java.lang.Throwable -> L5f
            java.lang.String r11 = r5.toString()     // Catch: java.lang.Throwable -> L5f
            r13.i(r1, r11)     // Catch: java.lang.Throwable -> L5f
            lb.n r11 = lb.n.f10413a     // Catch: java.lang.Throwable -> L5f
            goto L6a
        L5f:
            r0 = move-exception
        L60:
            r11 = r0
            goto L66
        L62:
            r0 = move-exception
            r3 = r11
            r4 = r12
            goto L60
        L66:
            kotlin.Result$Failure r11 = kotlin.c.a(r11)
        L6a:
            java.lang.Throwable r12 = kotlin.Result.b(r11)
            if (r12 == 0) goto L81
            com.stepos.core.ota.domain.port.OtaLogger r13 = r3.log
            java.lang.String r12 = r12.getMessage()
            java.lang.String r0 = "decryptWeightInto failed for "
            java.lang.String r2 = ": "
            java.lang.String r12 = ai.onnxruntime.a.l(r0, r4, r2, r12)
            r13.i(r1, r12)
        L81:
            boolean r11 = r11 instanceof kotlin.Result.Failure
            r11 = r11 ^ r10
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.crypto.OtaAtRestDecryptor.decryptWeightInto(java.lang.String, java.nio.ByteBuffer):boolean");
    }

    @Override // c7.c
    public void disarmNativeDecrypt() {
        byte[] bArr = this.armedDek.get();
        if (bArr == null) {
            bArr = this.armedDekGlobal;
        }
        if (bArr != null) {
            b1.H(bArr);
        }
        this.armedDek.remove();
        this.armedDekGlobal = null;
    }

    @Override // c7.c
    public boolean isEncryptedFile(File file) {
        g.f(file, "file");
        return AtRestFormat.INSTANCE.isEncrypted(file);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // c7.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object migrateIfNeeded(java.io.File r6, qb.b<? super java.lang.Boolean> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.stepos.core.ota.crypto.OtaAtRestDecryptor.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.core.ota.crypto.OtaAtRestDecryptor$migrateIfNeeded$1 r0 = (com.stepos.core.ota.crypto.OtaAtRestDecryptor.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ota.crypto.OtaAtRestDecryptor$migrateIfNeeded$1 r0 = new com.stepos.core.ota.crypto.OtaAtRestDecryptor$migrateIfNeeded$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r5 = r0.L$1
            r6 = r5
            java.io.File r6 = (java.io.File) r6
            java.lang.Object r5 = r0.L$0
            com.stepos.core.ota.crypto.OtaAtRestDecryptor r5 = (com.stepos.core.ota.crypto.OtaAtRestDecryptor) r5
            kotlin.c.b(r7)
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r7 = r7.f9987a
            goto L87
        L34:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3c:
            kotlin.c.b(r7)
            zb.a<java.lang.Boolean> r7 = r5.migrationGate
            java.lang.Object r7 = r7.invoke()
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L50
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            return r5
        L50:
            java.io.File r7 = new java.io.File
            java.lang.String r2 = "dek.wrap"
            r7.<init>(r6, r2)
            java.io.File r2 = new java.io.File
            java.lang.String r4 = ".at_rest_migrating"
            r2.<init>(r6, r4)
            boolean r7 = r7.isFile()
            if (r7 == 0) goto L6d
            boolean r7 = r2.isFile()
            if (r7 != 0) goto L6d
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            return r5
        L6d:
            com.stepos.core.ota.crypto.AtRestSealer r7 = r5.sealer
            boolean r7 = r7.requiresEncryptionDir(r6)
            if (r7 != 0) goto L78
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            return r5
        L78:
            com.stepos.core.ota.crypto.AtRestSealer r7 = r5.sealer
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r7 = r7.m118sealDirgIAlus(r6, r0)
            if (r7 != r1) goto L87
            return r1
        L87:
            java.lang.Throwable r0 = kotlin.Result.b(r7)
            if (r0 == 0) goto La4
            com.stepos.core.ota.domain.port.OtaLogger r5 = r5.log
            java.lang.String r6 = r6.getName()
            java.lang.String r0 = r0.getMessage()
            java.lang.String r1 = "lazy migrate failed for "
            java.lang.String r2 = ": "
            java.lang.String r6 = ai.onnxruntime.a.l(r1, r6, r2, r0)
            java.lang.String r0 = "OtaAtRestDecryptor"
            r5.i(r0, r6)
        La4:
            boolean r5 = r7 instanceof kotlin.Result.Failure
            if (r5 != 0) goto Lb6
            java.lang.Number r7 = (java.lang.Number) r7
            int r5 = r7.intValue()
            if (r5 <= 0) goto Lb1
            goto Lb2
        Lb1:
            r3 = 0
        Lb2:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r3)
        Lb6:
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            boolean r6 = r7 instanceof kotlin.Result.Failure
            if (r6 == 0) goto Lbd
            return r5
        Lbd:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.crypto.OtaAtRestDecryptor.migrateIfNeeded(java.io.File, qb.b):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0124 A[Catch: all -> 0x0048, TRY_ENTER, TryCatch #2 {all -> 0x0048, blocks: (B:15:0x003f, B:60:0x016f, B:22:0x0061, B:52:0x011c, B:56:0x0124, B:25:0x0073), top: B:75:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v14, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r11v24 */
    @Override // c7.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object resolveForBackend(java.io.File r11, qb.b<? super c7.d> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 447
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.crypto.OtaAtRestDecryptor.resolveForBackend(java.io.File, qb.b):java.lang.Object");
    }

    public /* synthetic */ OtaAtRestDecryptor(AtRestKeyStore atRestKeyStore, ModelCryptoImpl modelCryptoImpl, OtaLogger otaLogger, a aVar, a aVar2, l lVar, int i10, e eVar) {
        this(atRestKeyStore, modelCryptoImpl, otaLogger, aVar, (i10 & 16) != 0 ? new a9.b(18) : aVar2, (i10 & 32) != 0 ? new com.stepos.core.common.cloud.d(16) : lVar);
    }
}
