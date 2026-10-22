package com.stepos.core.ota.adapter;

import com.stepos.core.ability.speech.PcmDumpBudget;
import com.stepos.core.ota.domain.port.ArchiveExtractor;
import gc.o;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import jd.b;
import kotlin.jvm.internal.g;
import lb.n;
import wb.c;
import wb.c.b;
import wb.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ZipArchiveExtractor implements ArchiveExtractor {
    /* JADX INFO: Access modifiers changed from: private */
    public final void unzip(InputStream inputStream, String str) throws IOException {
        File file = new File(str);
        file.mkdirs();
        String canonicalPath = file.getCanonicalPath();
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        try {
            for (ZipEntry nextEntry = zipInputStream.getNextEntry(); nextEntry != null; nextEntry = zipInputStream.getNextEntry()) {
                File file2 = new File(file, nextEntry.getName());
                String canonicalPath2 = file2.getCanonicalPath();
                g.e(canonicalPath2, "getCanonicalPath(...)");
                if (!o.k0(canonicalPath2, canonicalPath + File.separator, false) && !g.b(file2.getCanonicalPath(), canonicalPath)) {
                    throw new SecurityException("zip slip detected: " + nextEntry.getName());
                }
                if (nextEntry.isDirectory()) {
                    file2.mkdirs();
                } else {
                    File parentFile = file2.getParentFile();
                    if (parentFile != null) {
                        parentFile.mkdirs();
                    }
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2), PcmDumpBudget.HARD_MAX_DIR_MB);
                    try {
                        b.n(zipInputStream, bufferedOutputStream);
                        bufferedOutputStream.close();
                    } finally {
                    }
                }
                zipInputStream.closeEntry();
            }
            n nVar = n.f10413a;
            zipInputStream.close();
            c.b bVar = d.b0(file).new b();
            while (bVar.hasNext()) {
                bVar.next().setExecutable(true);
            }
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.core.ota.domain.port.ArchiveExtractor
    /* renamed from: extract-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo116extract0E7RQCE(java.lang.String r6, java.lang.String r7, qb.b<? super kotlin.Result<lb.n>> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.stepos.core.ota.adapter.ZipArchiveExtractor$extract$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.core.ota.adapter.ZipArchiveExtractor$extract$1 r0 = (com.stepos.core.ota.adapter.ZipArchiveExtractor$extract$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ota.adapter.ZipArchiveExtractor$extract$1 r0 = new com.stepos.core.ota.adapter.ZipArchiveExtractor$extract$1
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
            com.stepos.core.ota.adapter.ZipArchiveExtractor$extract$2 r2 = new com.stepos.core.ota.adapter.ZipArchiveExtractor$extract$2
            r4 = 0
            r2.<init>(r6, r5, r7, r4)
            r0.label = r3
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r2, r0)
            if (r8 != r1) goto L45
            return r1
        L45:
            kotlin.Result r8 = (kotlin.Result) r8
            java.lang.Object r5 = r8.f9987a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.adapter.ZipArchiveExtractor.mo116extract0E7RQCE(java.lang.String, java.lang.String, qb.b):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.core.ota.domain.port.ArchiveExtractor
    /* renamed from: extractStream-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo117extractStream0E7RQCE(java.io.InputStream r6, java.lang.String r7, qb.b<? super kotlin.Result<lb.n>> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.stepos.core.ota.adapter.ZipArchiveExtractor$extractStream$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.core.ota.adapter.ZipArchiveExtractor$extractStream$1 r0 = (com.stepos.core.ota.adapter.ZipArchiveExtractor$extractStream$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ota.adapter.ZipArchiveExtractor$extractStream$1 r0 = new com.stepos.core.ota.adapter.ZipArchiveExtractor$extractStream$1
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
            com.stepos.core.ota.adapter.ZipArchiveExtractor$extractStream$2 r2 = new com.stepos.core.ota.adapter.ZipArchiveExtractor$extractStream$2
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
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.adapter.ZipArchiveExtractor.mo117extractStream0E7RQCE(java.io.InputStream, java.lang.String, qb.b):java.lang.Object");
    }
}
