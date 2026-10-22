package com.stepos.core.common.cloud;

import android.content.Context;
import android.os.SystemClock;
import com.stepos.common.utils.filestorage.exceptions.FileStorageException;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import gc.q;
import java.io.File;
import java.util.List;
import java.util.UUID;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$LongRef;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Job;
import lb.n;
import o8.i;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class FileStorageUploader implements s6.a {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final long LOG_HEARTBEAT_MS = 5000;

    @Deprecated
    public static final int LOG_STEP_PERCENT = 20;

    @Deprecated
    public static final String TAG = "FileStorageUploader";
    private final Context context;
    private final FileStorageUploadGateway gateway;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    public FileStorageUploader(Context context, FileStorageUploadGateway gateway) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(gateway, "gateway");
        this.context = context;
        this.gateway = gateway;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fetchDownloadUrl(final String str, final Integer num, qb.b<? super String> bVar) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(jd.b.w(bVar), 1);
        cancellableContinuationImpl.initCancellability();
        this.gateway.fetchDownloadUrl(str, num, new l<String, n>() { // from class: com.stepos.core.common.cloud.FileStorageUploader$fetchDownloadUrl$2$1
            @Override // zb.l
            public /* bridge */ /* synthetic */ n invoke(String str2) {
                invoke2(str2);
                return n.f10413a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String url) {
                kotlin.jvm.internal.g.f(url, "url");
                if (q.t0(url)) {
                    this.this$0.resumeFailure(cancellableContinuationImpl, new IllegalStateException(ai.onnxruntime.a.k("download url blank fileId=", str)));
                    return;
                }
                AIEngineLogger.i(LogModule.ABILITY, FileStorageUploader.TAG, "FileStorageUploader: got download url fileId=" + str + " expiresSeconds=" + num);
                cancellableContinuationImpl.resumeWith(url);
            }
        }, new l<Throwable, n>() { // from class: com.stepos.core.common.cloud.FileStorageUploader$fetchDownloadUrl$2$2
            @Override // zb.l
            public /* bridge */ /* synthetic */ n invoke(Throwable th) {
                invoke2(th);
                return n.f10413a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable throwable) {
                kotlin.jvm.internal.g.f(throwable, "throwable");
                FileStorageUploader fileStorageUploader = this.this$0;
                fileStorageUploader.resumeFailure(cancellableContinuationImpl, fileStorageUploader.mapUploadError(throwable));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Throwable mapUploadError(Throwable th) {
        if (th instanceof FileStorageException.NotInitialized) {
            return new IllegalStateException("FileStorage not initialized");
        }
        if (!(th instanceof FileStorageException.AuditBlocked)) {
            if (th instanceof FileStorageException.AuditFailed) {
                return new IllegalStateException(ai.onnxruntime.a.k("audit failed fileId=", ((FileStorageException.AuditFailed) th).f6642a));
            }
            if (th instanceof FileStorageException.GatewayException.TokenInvalid) {
                AccountTokenCache.INSTANCE.invalidate("upload_token_invalid");
                return new IllegalStateException("gateway token invalid");
            }
            if (th instanceof FileStorageException.GatewayException) {
                return new IllegalStateException(ai.onnxruntime.providers.a.a(((FileStorageException.GatewayException) th).f6645a, "gateway error code="));
            }
            if (!(th instanceof FileStorageException.BizError)) {
                return th instanceof FileStorageException.TosPutFailed ? new IllegalStateException(ai.onnxruntime.providers.a.a(((FileStorageException.TosPutFailed) th).f6647a, "tos put failed http=")) : th;
            }
            FileStorageException.BizError bizError = (FileStorageException.BizError) th;
            return new IllegalStateException(com.stepos.core.ota.d.h("biz error code=", bizError.f6644b, bizError.f6643a, " http="));
        }
        LogModule logModule = LogModule.ABILITY;
        FileStorageException.AuditBlocked auditBlocked = (FileStorageException.AuditBlocked) th;
        String str = auditBlocked.f6639c;
        Boolean bool = auditBlocked.f6641e;
        String str2 = auditBlocked.f6640d;
        String str3 = auditBlocked.f6638b;
        String str4 = auditBlocked.f6637a;
        boolean zB = kotlin.jvm.internal.g.b(str, "BLOCK");
        StringBuilder sb2 = new StringBuilder("FileStorageUploader: upload blocked bySensitive=");
        sb2.append(zB);
        sb2.append(" audit=");
        sb2.append(str4);
        sb2.append("/");
        ai.onnxruntime.a.z(sb2, str3, " sensitive=", str, "/");
        sb2.append(str2);
        sb2.append(" detectPassed=");
        sb2.append(bool);
        AIEngineLogger.w(logModule, TAG, sb2.toString());
        boolean zB2 = kotlin.jvm.internal.g.b(str, "BLOCK");
        StringBuilder sb3 = new StringBuilder("audit blocked: bySensitive=");
        sb3.append(zB2);
        sb3.append(" decision=");
        sb3.append(str4);
        sb3.append(" risk=");
        ai.onnxruntime.a.z(sb3, str3, " sensitive=", str, " sensitiveLevel=");
        sb3.append(str2);
        sb3.append(" detectPassed=");
        sb3.append(bool);
        return new SecurityException(sb3.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> void resumeFailure(CancellableContinuation<? super T> cancellableContinuation, Throwable th) {
        if (cancellableContinuation.isActive()) {
            cancellableContinuation.resumeWith(kotlin.c.a(th));
        }
    }

    private final Integer sanitizeExpiresSeconds(Integer num) {
        if (num == null) {
            return null;
        }
        int i10 = p6.a.r;
        dc.e eVar = new dc.e(i10, 604800, 1);
        int iIntValue = num.intValue();
        if (i10 <= iIntValue && iIntValue <= eVar.f8452b) {
            return num;
        }
        AIEngineLogger.w(LogModule.ABILITY, TAG, "FileStorageUploader: expiresSeconds=" + num + " out of range [" + i10 + ",604800], falling back to " + i10 + "s");
        return Integer.valueOf(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object startSingleUpload(final File file, String str, String str2, qb.b<? super String> bVar) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(jd.b.w(bVar), 1);
        cancellableContinuationImpl.initCancellability();
        String absolutePath = file.getAbsolutePath();
        kotlin.jvm.internal.g.e(absolutePath, "getAbsolutePath(...)");
        o8.h hVar = new o8.h(absolutePath, str, str2);
        final String str3 = "asr-" + UUID.randomUUID();
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        final Ref$IntRef ref$IntRef2 = new Ref$IntRef();
        ref$IntRef2.f10074a = -1;
        final Ref$LongRef ref$LongRef = new Ref$LongRef();
        ref$LongRef.f10075a = SystemClock.elapsedRealtime();
        final Job jobEnqueueSingle = this.gateway.enqueueSingle(hVar, str3, new l<Integer, n>() { // from class: com.stepos.core.common.cloud.FileStorageUploader$startSingleUpload$2$job$1
            @Override // zb.l
            public /* bridge */ /* synthetic */ n invoke(Integer num) {
                invoke(num.intValue());
                return n.f10413a;
            }

            public final void invoke(int i10) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                int i11 = i10 / 20;
                Ref$IntRef ref$IntRef3 = ref$IntRef;
                boolean z = false;
                boolean z3 = i11 > ref$IntRef3.f10074a;
                Ref$IntRef ref$IntRef4 = ref$IntRef2;
                if (i10 != ref$IntRef4.f10074a && jElapsedRealtime - ref$LongRef.f10075a >= FileStorageUploader.LOG_HEARTBEAT_MS) {
                    z = true;
                }
                if (z3 || z) {
                    ref$IntRef3.f10074a = i11;
                    ref$IntRef4.f10074a = i10;
                    ref$LongRef.f10075a = jElapsedRealtime;
                    LogModule logModule = LogModule.ABILITY;
                    String name = file.getName();
                    String str4 = str3;
                    StringBuilder sbF = h0.e.f("FileStorageUploader: upload progress file=", name, " pct=", i10, "% taskId=");
                    sbF.append(str4);
                    AIEngineLogger.d(logModule, FileStorageUploader.TAG, sbF.toString());
                }
            }
        }, new l<List<? extends i>, n>() { // from class: com.stepos.core.common.cloud.FileStorageUploader$startSingleUpload$2$job$2
            @Override // zb.l
            public /* bridge */ /* synthetic */ n invoke(List<? extends i> list) {
                invoke2((List<i>) list);
                return n.f10413a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<i> results) {
                kotlin.jvm.internal.g.f(results, "results");
                if (cancellableContinuationImpl.isActive()) {
                    i iVar = (i) kotlin.collections.a.v0(results);
                    if (iVar == null) {
                        this.resumeFailure(cancellableContinuationImpl, new IllegalStateException("upload returned no result"));
                        return;
                    }
                    Boolean bool = iVar.h;
                    o8.e eVar = iVar.f10831g;
                    o8.a aVar = iVar.f10830f;
                    String str4 = iVar.f10826b;
                    if (!iVar.f10829e) {
                        Throwable illegalStateException = iVar.f10832i;
                        if (illegalStateException == null) {
                            illegalStateException = new IllegalStateException("upload failed without error");
                        }
                        FileStorageUploader fileStorageUploader = this;
                        fileStorageUploader.resumeFailure(cancellableContinuationImpl, fileStorageUploader.mapUploadError(illegalStateException));
                        return;
                    }
                    if ((aVar == null || !kotlin.jvm.internal.g.b(aVar.f10779b, "BLOCK")) && ((eVar == null || !kotlin.jvm.internal.g.b(eVar.f10801b, "BLOCK")) && !kotlin.jvm.internal.g.b(bool, Boolean.FALSE))) {
                        if (str4 == null || q.t0(str4)) {
                            this.resumeFailure(cancellableContinuationImpl, new IllegalStateException("upload succeeded but fileId blank"));
                            return;
                        } else {
                            AIEngineLogger.i(LogModule.ABILITY, FileStorageUploader.TAG, ai.onnxruntime.a.l("FileStorageUploader: upload ok fileId=", str4, " taskId=", str3));
                            cancellableContinuationImpl.resumeWith(str4);
                            return;
                        }
                    }
                    FileStorageUploader fileStorageUploader2 = this;
                    CancellableContinuation<String> cancellableContinuation = cancellableContinuationImpl;
                    String str5 = aVar != null ? aVar.f10779b : null;
                    String str6 = eVar != null ? eVar.f10801b : null;
                    String str7 = eVar != null ? eVar.f10802c : null;
                    StringBuilder sbS = ai.onnxruntime.a.s("upload blocked: audit=", str5, " sensitive=", str6, " level=");
                    sbS.append(str7);
                    sbS.append(" detectPassed=");
                    sbS.append(bool);
                    fileStorageUploader2.resumeFailure(cancellableContinuation, new SecurityException(sbS.toString()));
                }
            }
        });
        cancellableContinuationImpl.invokeOnCancellation(new l<Throwable, n>() { // from class: com.stepos.core.common.cloud.FileStorageUploader$startSingleUpload$2$1
            @Override // zb.l
            public /* bridge */ /* synthetic */ n invoke(Throwable th) {
                invoke2(th);
                return n.f10413a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Job.DefaultImpls.cancel$default(jobEnqueueSingle, null, 1, null);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        return result;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    @Override // s6.a
    /* renamed from: upload-yxL6bBk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo101uploadyxL6bBk(java.io.File r16, java.lang.String r17, java.lang.String r18, java.lang.Integer r19, qb.b<? super kotlin.Result<java.lang.String>> r20) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.common.cloud.FileStorageUploader.mo101uploadyxL6bBk(java.io.File, java.lang.String, java.lang.String, java.lang.Integer, qb.b):java.lang.Object");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FileStorageUploader(Context context) {
        this(context, new RealFileStorageUploadGateway(context));
        kotlin.jvm.internal.g.f(context, "context");
    }
}
