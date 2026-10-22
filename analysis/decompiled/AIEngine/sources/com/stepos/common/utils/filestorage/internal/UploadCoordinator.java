package com.stepos.common.utils.filestorage.internal;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.stepos.common.utils.filestorage.exceptions.FileStorageException;
import gc.o;
import java.io.File;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.CoroutineScopeKt;
import lb.n;
import o8.e;
import o8.h;
import o8.i;
import zb.p;
import zb.r;
import zb.s;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class UploadCoordinator {

    /* renamed from: a, reason: collision with root package name */
    public final m8.b f6683a;

    /* renamed from: b, reason: collision with root package name */
    public final a f6684b;

    /* renamed from: c, reason: collision with root package name */
    public final stepos.support.v7.app.palette.b f6685c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class NonRetryable extends RuntimeException {

        /* renamed from: a, reason: collision with root package name */
        public final o8.a f6686a;

        /* renamed from: b, reason: collision with root package name */
        public final e f6687b;

        /* renamed from: c, reason: collision with root package name */
        public final Boolean f6688c;

        /* renamed from: d, reason: collision with root package name */
        public final String f6689d;

        /* renamed from: e, reason: collision with root package name */
        public final Long f6690e;
        public final String h;

        public NonRetryable(o8.a aVar, e eVar, Boolean bool, String str, Long l10, String str2, FileStorageException fileStorageException) {
            super(fileStorageException);
            this.f6686a = aVar;
            this.f6687b = eVar;
            this.f6688c = bool;
            this.f6689d = str;
            this.f6690e = l10;
            this.h = str2;
        }
    }

    public UploadCoordinator(m8.b bVar, a aVar, stepos.support.v7.app.palette.b bVar2) {
        this.f6683a = bVar;
        this.f6684b = aVar;
        this.f6685c = bVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0288  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:102:0x02b2 -> B:103:0x02b4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:104:0x02ba -> B:32:0x00b3). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(com.stepos.common.utils.filestorage.internal.UploadCoordinator r28, android.content.Context r29, o8.h r30, java.lang.Long r31, n8.a r32, kotlin.coroutines.jvm.internal.ContinuationImpl r33) {
        /*
            Method dump skipped, instructions count: 868
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.utils.filestorage.internal.UploadCoordinator.a(com.stepos.common.utils.filestorage.internal.UploadCoordinator, android.content.Context, o8.h, java.lang.Long, n8.a, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static Uri b(String str) {
        if (o.k0(str, "content://", false) || o.k0(str, "file://", false)) {
            return Uri.parse(str);
        }
        Uri uriFromFile = Uri.fromFile(new File(str));
        g.e(uriFromFile, "fromFile(...)");
        return uriFromFile;
    }

    public static Long c(Context context, Uri uri) throws IOException {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
        if (parcelFileDescriptorOpenFileDescriptor == null) {
            return null;
        }
        try {
            long statSize = parcelFileDescriptorOpenFileDescriptor.getStatSize();
            Long lValueOf = statSize > 0 ? Long.valueOf(statSize) : null;
            parcelFileDescriptorOpenFileDescriptor.close();
            return lValueOf;
        } finally {
        }
    }

    public final Object d(Context context, List<h> list, p<? super Integer, ? super qb.b<? super n>, ? extends Object> pVar, r<? super Integer, ? super String, ? super Integer, ? super qb.b<? super n>, ? extends Object> rVar, s<? super Integer, ? super i, ? super Integer, ? super Integer, ? super qb.b<? super n>, ? extends Object> sVar, qb.b<? super List<i>> bVar) {
        return CoroutineScopeKt.coroutineScope(new UploadCoordinator$uploadBatch$4(list, this, context, pVar, rVar, sVar, null), bVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(android.content.Context r27, o8.h r28, java.lang.Long r29, n8.a r30, kotlin.coroutines.jvm.internal.ContinuationImpl r31) throws java.lang.IllegalStateException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException {
        /*
            Method dump skipped, instructions count: 1042
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.utils.filestorage.internal.UploadCoordinator.e(android.content.Context, o8.h, java.lang.Long, n8.a, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
