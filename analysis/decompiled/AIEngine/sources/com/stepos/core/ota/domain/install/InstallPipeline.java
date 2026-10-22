package com.stepos.core.ota.domain.install;

import a0.a;
import com.stepos.core.ota.domain.OtaError;
import com.stepos.core.ota.domain.OtaErrorKt;
import com.stepos.core.ota.domain.port.ModelStorage;
import com.stepos.core.ota.domain.port.OtaLogger;
import java.util.List;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import lb.n;
import qb.b;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class InstallPipeline {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String TAG = "InstallPipeline";
    private final OtaLogger log;
    private final List<InstallStage> stages;
    private final ModelStorage storage;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.domain.install.InstallPipeline", f = "InstallPipeline.kt", l = {99}, m = "run")
    /* renamed from: com.stepos.core.ota.domain.install.InstallPipeline$run$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
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
            return InstallPipeline.this.run(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InstallPipeline(List<? extends InstallStage> stages, ModelStorage storage, OtaLogger log) {
        g.f(stages, "stages");
        g.f(storage, "storage");
        g.f(log, "log");
        this.stages = stages;
        this.storage = storage;
        this.log = log;
    }

    private final void discardDownloadedArtifact(InstallContext installContext, OtaError otaError) {
        Object objA;
        if (OtaErrorKt.requiresCleanRedownload(otaError)) {
            String otaId = installContext.getManifest().getOtaId();
            try {
                this.storage.deleteDir(installContext.getDownloadedFilePath());
                objA = n.f10413a;
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            if (!(objA instanceof Result.Failure)) {
                this.log.i(TAG, "[" + otaId + "] discarded downloaded package for clean redownload");
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                this.log.e(TAG, a.k("[", otaId, "] discard downloaded package failed"), thB);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0071 A[Catch: all -> 0x00e5, TRY_LEAVE, TryCatch #2 {all -> 0x00e5, blocks: (B:33:0x009e, B:37:0x00b3, B:40:0x00bd, B:21:0x006b, B:23:0x0071, B:32:0x0098, B:50:0x0142, B:43:0x00e7, B:45:0x00eb, B:48:0x013c, B:49:0x0141, B:36:0x00a5), top: B:61:0x00bd }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a5 A[Catch: all -> 0x00e5, TryCatch #2 {all -> 0x00e5, blocks: (B:33:0x009e, B:37:0x00b3, B:40:0x00bd, B:21:0x006b, B:23:0x0071, B:32:0x0098, B:50:0x0142, B:43:0x00e7, B:45:0x00eb, B:48:0x013c, B:49:0x0141, B:36:0x00a5), top: B:61:0x00bd }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e7 A[Catch: all -> 0x00e5, TryCatch #2 {all -> 0x00e5, blocks: (B:33:0x009e, B:37:0x00b3, B:40:0x00bd, B:21:0x006b, B:23:0x0071, B:32:0x0098, B:50:0x0142, B:43:0x00e7, B:45:0x00eb, B:48:0x013c, B:49:0x0141, B:36:0x00a5), top: B:61:0x00bd }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0142 A[Catch: all -> 0x00e5, TRY_LEAVE, TryCatch #2 {all -> 0x00e5, blocks: (B:33:0x009e, B:37:0x00b3, B:40:0x00bd, B:21:0x006b, B:23:0x0071, B:32:0x0098, B:50:0x0142, B:43:0x00e7, B:45:0x00eb, B:48:0x013c, B:49:0x0141, B:36:0x00a5), top: B:61:0x00bd }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x008b -> B:28:0x0091). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object run(com.stepos.core.ota.domain.install.InstallContext r20, qb.b<? super com.stepos.core.ota.domain.install.InstallOutcome> r21) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.domain.install.InstallPipeline.run(com.stepos.core.ota.domain.install.InstallContext, qb.b):java.lang.Object");
    }
}
