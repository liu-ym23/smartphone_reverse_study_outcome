package com.stepos.core.ota.domain.install;

import android.util.Log;
import com.stepos.core.ota.crypto.AtRestSealer;
import com.stepos.core.ota.domain.port.ArchiveExtractor;
import com.stepos.core.ota.domain.port.ModelStorage;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.collections.EmptyList;
import kotlin.collections.a;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import lb.n;
import mb.l;
import mb.m;
import qb.b;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ExtractStage implements InstallStage {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String EXTRACT_TAG = "InstallPipeline.Extract";
    private final ArchiveExtractor extractor;
    private final boolean logLayout;
    private final String name;
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
    @c(c = "com.stepos.core.ota.domain.install.ExtractStage", f = "InstallPipeline.kt", l = {242, 244}, m = "execute")
    /* renamed from: com.stepos.core.ota.domain.install.ExtractStage$execute$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
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
            return ExtractStage.this.execute(null, this);
        }
    }

    public ExtractStage(ArchiveExtractor extractor, ModelStorage storage, boolean z) {
        g.f(extractor, "extractor");
        g.f(storage, "storage");
        this.extractor = extractor;
        this.storage = storage;
        this.logLayout = z;
        this.name = "Extract";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r4v6, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.util.List] */
    /* renamed from: logExtractedLayout-gIAlu-s, reason: not valid java name */
    private final Object m138logExtractedLayoutgIAlus(InstallContext installContext, boolean z) {
        Object objA;
        ?? arrayList;
        try {
            File[] fileArrListFiles = new File(installContext.getTempDir()).listFiles();
            Collection<File> collectionK0 = fileArrListFiles != null ? l.k0(fileArrListFiles, new Comparator() { // from class: com.stepos.core.ota.domain.install.ExtractStage$logExtractedLayout_gIAlu_s$lambda$5$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t8, T t10) {
                    return ob.b.a(((File) t8).getName(), ((File) t10).getName());
                }
            }) : EmptyList.f10001a;
            String otaId = installContext.getManifest().getOtaId();
            boolean z3 = false;
            if (collectionK0 == null || !collectionK0.isEmpty()) {
                Iterator it = collectionK0.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    File file = (File) it.next();
                    if (file.isFile() && g.b(file.getName(), AtRestSealer.MODEL_MANIFEST)) {
                        z3 = true;
                        break;
                    }
                }
            }
            Log.i(EXTRACT_TAG, "[" + otaId + " v" + installContext.getManifest().getVersion() + "] 解压完成（" + (z ? "密文流" : "明文 zip") + "） -> " + installContext.getTempDir() + "；model_manifest.json=" + (z3 ? "有" : "无（端侧走兜底）"));
            for (File file2 : collectionK0) {
                if (file2.isDirectory()) {
                    File[] fileArrListFiles2 = file2.listFiles();
                    if (fileArrListFiles2 != null) {
                        List<File> listK0 = l.k0(fileArrListFiles2, new Comparator() { // from class: com.stepos.core.ota.domain.install.ExtractStage$logExtractedLayout_gIAlu_s$lambda$5$lambda$4$$inlined$sortedBy$1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.util.Comparator
                            public final int compare(T t8, T t10) {
                                return ob.b.a(((File) t8).getName(), ((File) t10).getName());
                            }
                        });
                        arrayList = new ArrayList(m.Z(listK0, 10));
                        for (File file3 : listK0) {
                            arrayList.add(file3.isDirectory() ? file3.getName() + "/" : file3.getName() + "(" + file3.length() + ")");
                        }
                    } else {
                        arrayList = EmptyList.f10001a;
                    }
                    Log.i(EXTRACT_TAG, "  [" + otaId + "]   " + file2.getName() + "/  " + a.J0(12, arrayList) + (arrayList.size() > 12 ? " …共 " + arrayList.size() + " 项" : ""));
                } else {
                    Log.i(EXTRACT_TAG, "  [" + otaId + "]   " + file2.getName() + "  " + file2.length() + "B");
                }
            }
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            a0.a.A("logExtractedLayout failed (non-fatal): ", thB.getMessage(), EXTRACT_TAG);
        }
        return objA;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x006f, code lost:
    
        if (r10 == r1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0088, code lost:
    
        if (r10 == r1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x008a, code lost:
    
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.core.ota.domain.install.InstallStage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object execute(com.stepos.core.ota.domain.install.InstallContext r9, qb.b<? super com.stepos.core.ota.domain.install.StageOutcome> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.stepos.core.ota.domain.install.ExtractStage.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.core.ota.domain.install.ExtractStage$execute$1 r0 = (com.stepos.core.ota.domain.install.ExtractStage.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ota.domain.install.ExtractStage$execute$1 r0 = new com.stepos.core.ota.domain.install.ExtractStage$execute$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L43
            if (r2 == r5) goto L27
            if (r2 != r4) goto L3b
        L27:
            int r8 = r0.I$0
            java.lang.Object r9 = r0.L$1
            com.stepos.core.ota.domain.install.InstallContext r9 = (com.stepos.core.ota.domain.install.InstallContext) r9
            java.lang.Object r0 = r0.L$0
            com.stepos.core.ota.domain.install.ExtractStage r0 = (com.stepos.core.ota.domain.install.ExtractStage) r0
            kotlin.c.b(r10)
            kotlin.Result r10 = (kotlin.Result) r10
            java.lang.Object r10 = r10.f9987a
            r2 = r8
            r8 = r0
            goto L8b
        L3b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L43:
            kotlin.c.b(r10)
            com.stepos.core.ota.domain.port.ModelStorage r10 = r8.storage
            java.lang.String r2 = r9.getTempDir()
            r10.deleteDir(r2)
            java.io.InputStream r10 = r9.getDecryptedStream()
            if (r10 == 0) goto L57
            r2 = r5
            goto L58
        L57:
            r2 = r3
        L58:
            if (r2 == 0) goto L72
            com.stepos.core.ota.domain.port.ArchiveExtractor r4 = r8.extractor
            kotlin.jvm.internal.g.c(r10)
            java.lang.String r6 = r9.getTempDir()
            r0.L$0 = r8
            r0.L$1 = r9
            r0.I$0 = r2
            r0.label = r5
            java.lang.Object r10 = r4.mo117extractStream0E7RQCE(r10, r6, r0)
            if (r10 != r1) goto L8b
            goto L8a
        L72:
            com.stepos.core.ota.domain.port.ArchiveExtractor r10 = r8.extractor
            java.lang.String r6 = r9.getDownloadedFilePath()
            java.lang.String r7 = r9.getTempDir()
            r0.L$0 = r8
            r0.L$1 = r9
            r0.I$0 = r2
            r0.label = r4
            java.lang.Object r10 = r10.mo116extract0E7RQCE(r6, r7, r0)
            if (r10 != r1) goto L8b
        L8a:
            return r1
        L8b:
            boolean r0 = r10 instanceof kotlin.Result.Failure
            if (r0 == 0) goto Lbf
            com.stepos.core.ota.domain.port.ModelStorage r8 = r8.storage
            java.lang.String r0 = r9.getTempDir()
            r8.deleteDir(r0)
            java.lang.Throwable r8 = kotlin.Result.b(r10)
            com.stepos.core.ota.domain.install.StageOutcome$Fail r10 = new com.stepos.core.ota.domain.install.StageOutcome$Fail
            if (r8 == 0) goto Lae
            com.stepos.core.ota.domain.model.ModelManifest r0 = r9.getManifest()
            java.lang.String r0 = r0.getOtaId()
            com.stepos.core.ota.domain.OtaError r0 = com.stepos.core.ota.domain.install.InstallPipelineKt.access$payloadErrorOrNull(r8, r0)
            if (r0 != 0) goto Lbb
        Lae:
            com.stepos.core.ota.domain.OtaError$ExtractFailed r0 = new com.stepos.core.ota.domain.OtaError$ExtractFailed
            com.stepos.core.ota.domain.model.ModelManifest r9 = r9.getManifest()
            java.lang.String r9 = r9.getOtaId()
            r0.<init>(r9, r8)
        Lbb:
            r10.<init>(r0)
            return r10
        Lbf:
            boolean r10 = r8.logLayout
            if (r10 == 0) goto Lc9
            if (r2 == 0) goto Lc6
            r3 = r5
        Lc6:
            r8.m138logExtractedLayoutgIAlus(r9, r3)
        Lc9:
            com.stepos.core.ota.domain.install.StageOutcome$Proceed r8 = com.stepos.core.ota.domain.install.StageOutcome.Proceed.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.domain.install.ExtractStage.execute(com.stepos.core.ota.domain.install.InstallContext, qb.b):java.lang.Object");
    }

    @Override // com.stepos.core.ota.domain.install.InstallStage
    public String getName() {
        return this.name;
    }

    public /* synthetic */ ExtractStage(ArchiveExtractor archiveExtractor, ModelStorage modelStorage, boolean z, int i10, e eVar) {
        this(archiveExtractor, modelStorage, (i10 & 4) != 0 ? true : z);
    }
}
