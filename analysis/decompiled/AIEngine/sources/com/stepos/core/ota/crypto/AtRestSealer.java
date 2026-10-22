package com.stepos.core.ota.crypto;

import com.stepos.core.ota.domain.port.OtaLogger;
import gc.a;
import gc.i;
import gc.o;
import java.io.File;
import java.util.List;
import java.util.Locale;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import kotlin.text.Regex;
import mb.m;
import wb.d;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AtRestSealer {
    public static final Companion Companion = new Companion(null);
    public static final String DEK_WRAP = "dek.wrap";
    public static final String MANIFEST = "at_rest_manifest.json";
    public static final String MIGRATING_MARKER = ".at_rest_migrating";
    public static final String MODEL_MANIFEST = "model_manifest.json";
    private static final String SEAL_SUFFIX = ".sealing";
    private static final String TAG = "AtRestSealer";
    private final l<String, Boolean> classify;
    private final ModelCryptoImpl crypto;
    private final AtRestKeyStore keyStore;
    private final OtaLogger log;
    private final l<String, Boolean> shouldEncrypt;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: com.stepos.core.ota.crypto.AtRestSealer$1, reason: invalid class name */
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements l<String, Boolean> {
        public AnonymousClass1(Object obj) {
            super(1, obj, Companion.class, "defaultClassify", "defaultClassify(Ljava/lang/String;)Z", 0);
        }

        @Override // zb.l
        public final Boolean invoke(String p02) {
            g.f(p02, "p0");
            return Boolean.valueOf(((Companion) this.receiver).defaultClassify(p02));
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final boolean defaultClassify(String relPath) {
            g.f(relPath, "relPath");
            String lowerCase = o.h0(relPath, '\\', '/').toLowerCase(Locale.ROOT);
            g.e(lowerCase, "toLowerCase(...)");
            return o.e0(lowerCase, ".mnn", false) || o.e0(lowerCase, ".serialized.bin", false) || o.e0(lowerCase, ".gguf", false) || o.e0(lowerCase, ".onnx", false);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AtRestSealer(AtRestKeyStore keyStore, ModelCryptoImpl crypto, OtaLogger log, l<? super String, Boolean> shouldEncrypt, l<? super String, Boolean> classify) {
        g.f(keyStore, "keyStore");
        g.f(crypto, "crypto");
        g.f(log, "log");
        g.f(shouldEncrypt, "shouldEncrypt");
        g.f(classify, "classify");
        this.keyStore = keyStore;
        this.crypto = crypto;
        this.log = log;
        this.shouldEncrypt = shouldEncrypt;
        this.classify = classify;
    }

    private final String manifestJson(List<String> list) {
        StringBuilder sb2 = new StringBuilder("{\"formatVersion\":1,\"sealed\":[");
        int i10 = 0;
        for (Object obj : list) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                m.f0();
                throw null;
            }
            String str = (String) obj;
            if (i10 > 0) {
                sb2.append(',');
            }
            sb2.append('\"');
            sb2.append(o.i0(o.i0(str, "\\", "\\\\"), "\"", "\\\""));
            sb2.append('\"');
            i10 = i11;
        }
        sb2.append("]}");
        return sb2.toString();
    }

    private final String readModelId(File file) {
        Object objA;
        i iVarB;
        File file2 = new File(file, MODEL_MANIFEST);
        if (!file2.isFile()) {
            file2 = null;
        }
        if (file2 != null) {
            try {
                objA = d.Z(file2, a.f9106b);
            } catch (Throwable th) {
                objA = c.a(th);
            }
            if (objA instanceof Result.Failure) {
                objA = null;
            }
            String str = (String) objA;
            if (str == null || (iVarB = new Regex("\"modelId\"\\s*:\\s*\"([^\"]+)\"").b(str, 0)) == null) {
                return null;
            }
            return (String) kotlin.collections.a.w0(1, iVarB.a());
        }
        return null;
    }

    private final boolean requiresEncryption(File file) {
        String modelId = readModelId(file);
        if (modelId == null) {
            return false;
        }
        return this.shouldEncrypt.invoke(modelId).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean sealDir_gIAlu_s$lambda$2$lambda$1(File it) {
        g.f(it, "it");
        return it.isFile();
    }

    public final boolean requiresEncryptionDir(File dir) {
        g.f(dir, "dir");
        return requiresEncryption(dir);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00ef A[Catch: all -> 0x0126, TryCatch #1 {all -> 0x0126, blocks: (B:44:0x0195, B:46:0x019e, B:48:0x01a4, B:30:0x00e9, B:32:0x00ef, B:34:0x0116, B:36:0x011e, B:40:0x012b, B:54:0x01e5, B:49:0x01b2, B:50:0x01c8, B:51:0x01c9, B:52:0x01df), top: B:64:0x0195 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x019e A[Catch: all -> 0x0126, TryCatch #1 {all -> 0x0126, blocks: (B:44:0x0195, B:46:0x019e, B:48:0x01a4, B:30:0x00e9, B:32:0x00ef, B:34:0x0116, B:36:0x011e, B:40:0x012b, B:54:0x01e5, B:49:0x01b2, B:50:0x01c8, B:51:0x01c9, B:52:0x01df), top: B:64:0x0195 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01c9 A[Catch: all -> 0x0126, TryCatch #1 {all -> 0x0126, blocks: (B:44:0x0195, B:46:0x019e, B:48:0x01a4, B:30:0x00e9, B:32:0x00ef, B:34:0x0116, B:36:0x011e, B:40:0x012b, B:54:0x01e5, B:49:0x01b2, B:50:0x01c8, B:51:0x01c9, B:52:0x01df), top: B:64:0x0195 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x0189 -> B:64:0x0195). Please report as a decompilation issue!!! */
    /* renamed from: sealDir-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m118sealDirgIAlus(java.io.File r21, qb.b<? super kotlin.Result<java.lang.Integer>> r22) {
        /*
            Method dump skipped, instructions count: 574
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.crypto.AtRestSealer.m118sealDirgIAlus(java.io.File, qb.b):java.lang.Object");
    }

    public /* synthetic */ AtRestSealer(AtRestKeyStore atRestKeyStore, ModelCryptoImpl modelCryptoImpl, OtaLogger otaLogger, l lVar, l lVar2, int i10, e eVar) {
        this(atRestKeyStore, modelCryptoImpl, otaLogger, lVar, (i10 & 16) != 0 ? new AnonymousClass1(Companion) : lVar2);
    }
}
