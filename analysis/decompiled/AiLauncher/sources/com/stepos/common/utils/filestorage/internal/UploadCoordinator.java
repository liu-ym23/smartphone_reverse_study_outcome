package com.stepos.common.utils.filestorage.internal;

import La.D;
import P6.AuditResult;
import P6.SensitiveResult;
import P6.UploadRequest;
import P6.UploadResult;
import Y8.t;
import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.common.utils.filestorage.FileStorageConfig;
import e9.InterfaceC4014c;
import java.io.File;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.r;
import p9.s;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u0000 12\u00020\u0001:\u000223B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJº\u0001\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\f2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\"\u0010\u0013\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f20\b\u0002\u0010\u0016\u001a*\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001426\b\u0002\u0010\u0019\u001a0\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0017H\u0086@¢\u0006\u0004\b\u001a\u0010\u001bJ2\u0010!\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0082@¢\u0006\u0004\b!\u0010\"J2\u0010#\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0082@¢\u0006\u0004\b#\u0010\"J\u0017\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020\u0015H\u0002¢\u0006\u0004\b&\u0010'J!\u0010)\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010(\u001a\u00020%H\u0002¢\u0006\u0004\b)\u0010*J'\u0010,\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010(\u001a\u00020%2\u0006\u0010+\u001a\u00020\u0015H\u0002¢\u0006\u0004\b,\u0010-R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010.R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010/R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u00100¨\u00064"}, d2 = {"Lcom/stepos/common/utils/filestorage/internal/UploadCoordinator;", "", "Lcom/stepos/common/utils/filestorage/b;", "config", "Lcom/stepos/common/utils/filestorage/internal/FileStorageApi;", "api", "Lcom/stepos/common/utils/filestorage/internal/TosUploader;", "tos", "<init>", "(Lcom/stepos/common/utils/filestorage/b;Lcom/stepos/common/utils/filestorage/internal/FileStorageApi;Lcom/stepos/common/utils/filestorage/internal/TosUploader;)V", "Landroid/content/Context;", "context", "", "LP6/l;", DidiCardProvider.KEY_ITEMS, "Lkotlin/Function2;", "", "Le9/c;", "LY8/t;", "onTotalProgress", "Lkotlin/Function4;", "", "onFileProgress", "Lkotlin/Function5;", "LP6/m;", "onFileFinished", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroid/content/Context;Ljava/util/List;Lp9/p;Lp9/r;Lp9/s;Le9/c;)Ljava/lang/Object;", "req", "", "sizeHint", "Lcom/stepos/common/utils/filestorage/internal/a;", "tracker", "l", "(Landroid/content/Context;LP6/l;Ljava/lang/Long;Lcom/stepos/common/utils/filestorage/internal/a;Le9/c;)Ljava/lang/Object;", "k", "uriOrPath", "Landroid/net/Uri;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;)Landroid/net/Uri;", "uri", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/Long;", "fileName", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;)Ljava/lang/String;", "Lcom/stepos/common/utils/filestorage/b;", "Lcom/stepos/common/utils/filestorage/internal/FileStorageApi;", "Lcom/stepos/common/utils/filestorage/internal/TosUploader;", "Companion", "NonRetryable", Const.INTENT_KEY_APIKEY, "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UploadCoordinator {
    private static final long PROGRESS_POLL_MS = 80;
    private static final String TAG = "FileStorage.Coord";
    private static final long UNKNOWN_SIZE_FALLBACK_BYTES = 1048576;
    private final FileStorageApi api;
    private final FileStorageConfig config;
    private final TosUploader tos;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0017\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002BU\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b%\u0010!¨\u0006&"}, d2 = {"Lcom/stepos/common/utils/filestorage/internal/UploadCoordinator$NonRetryable;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "", "success", "LP6/a;", "audit", "LP6/h;", "sensitive", "detectPassed", "", "fileId", "", "fileSize", "downloadUrl", "", "cause", "<init>", "(ZLP6/a;LP6/h;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Throwable;)V", "Z", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Z", "LP6/a;", Const.INTENT_KEY_APIKEY, "()LP6/a;", "LP6/h;", "f", "()LP6/h;", "Ljava/lang/Boolean;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/Boolean;", "Ljava/lang/String;", Const.INTENT_KEY_UMID, "()Ljava/lang/String;", "Ljava/lang/Long;", "e", "()Ljava/lang/Long;", "c", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class NonRetryable extends RuntimeException {
        private final AuditResult audit;
        private final Boolean detectPassed;
        private final String downloadUrl;
        private final String fileId;
        private final Long fileSize;
        private final SensitiveResult sensitive;
        private final boolean success;

        public NonRetryable(boolean z10, AuditResult auditResult, SensitiveResult sensitiveResult, Boolean bool, String str, Long l10, String str2, Throwable th) {
            super(th);
            this.success = z10;
            this.audit = auditResult;
            this.sensitive = sensitiveResult;
            this.detectPassed = bool;
            this.fileId = str;
            this.fileSize = l10;
            this.downloadUrl = str2;
        }

        /* renamed from: a, reason: from getter */
        public final AuditResult getAudit() {
            return this.audit;
        }

        /* renamed from: b, reason: from getter */
        public final Boolean getDetectPassed() {
            return this.detectPassed;
        }

        /* renamed from: c, reason: from getter */
        public final String getDownloadUrl() {
            return this.downloadUrl;
        }

        /* renamed from: d, reason: from getter */
        public final String getFileId() {
            return this.fileId;
        }

        /* renamed from: e, reason: from getter */
        public final Long getFileSize() {
            return this.fileSize;
        }

        /* renamed from: f, reason: from getter */
        public final SensitiveResult getSensitive() {
            return this.sensitive;
        }

        /* renamed from: g, reason: from getter */
        public final boolean getSuccess() {
            return this.success;
        }
    }

    public UploadCoordinator(FileStorageConfig config, FileStorageApi api, TosUploader tos) {
        p.i(config, "config");
        p.i(api, "api");
        p.i(tos, "tos");
        this.config = config;
        this.api = api;
        this.tos = tos;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a3 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x011e A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0135 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String g(android.content.Context r1, android.net.Uri r2, java.lang.String r3) {
        /*
            Method dump skipped, instructions count: 390
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.utils.filestorage.internal.UploadCoordinator.g(android.content.Context, android.net.Uri, java.lang.String):java.lang.String");
    }

    public final Uri h(String uriOrPath) {
        if (D.X(uriOrPath, "content://", false, 2, null) || D.X(uriOrPath, "file://", false, 2, null)) {
            return Uri.parse(uriOrPath);
        }
        Uri uriFromFile = Uri.fromFile(new File(uriOrPath));
        p.h(uriFromFile, "fromFile(...)");
        return uriFromFile;
    }

    public final Long i(Context context, Uri uri) throws IOException {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
        if (parcelFileDescriptorOpenFileDescriptor == null) {
            return null;
        }
        try {
            Long lValueOf = Long.valueOf(parcelFileDescriptorOpenFileDescriptor.getStatSize());
            if (lValueOf.longValue() <= 0) {
                lValueOf = null;
            }
            l9.b.a(parcelFileDescriptorOpenFileDescriptor, null);
            return lValueOf;
        } finally {
        }
    }

    public final Object j(Context context, List<UploadRequest> list, p9.p<? super Integer, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, r<? super Integer, ? super String, ? super Integer, ? super InterfaceC4014c<? super t>, ? extends Object> rVar, s<? super Integer, ? super UploadResult, ? super Integer, ? super Integer, ? super InterfaceC4014c<? super t>, ? extends Object> sVar, InterfaceC4014c<? super List<UploadResult>> interfaceC4014c) {
        return kotlinx.coroutines.d.f(new UploadCoordinator$uploadBatch$4(list, this, context, pVar, rVar, sVar, null), interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(android.content.Context r26, P6.UploadRequest r27, java.lang.Long r28, com.stepos.common.utils.filestorage.internal.a r29, e9.InterfaceC4014c<? super P6.UploadResult> r30) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 860
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.utils.filestorage.internal.UploadCoordinator.k(android.content.Context, P6.l, java.lang.Long, com.stepos.common.utils.filestorage.internal.a, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x03bd  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x0321 -> B:81:0x0328). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:83:0x0333 -> B:82:0x032f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object l(android.content.Context r31, P6.UploadRequest r32, java.lang.Long r33, com.stepos.common.utils.filestorage.internal.a r34, e9.InterfaceC4014c<? super P6.UploadResult> r35) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1039
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.utils.filestorage.internal.UploadCoordinator.l(android.content.Context, P6.l, java.lang.Long, com.stepos.common.utils.filestorage.internal.a, e9.c):java.lang.Object");
    }
}
