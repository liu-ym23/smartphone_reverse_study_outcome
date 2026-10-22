package com.bytedance.applet.impl;

import com.ss.bduploader.BDImageXE2EEncryptionInfo;
import com.ss.bduploader.BDImageXInfo;
import com.ss.bduploader.BDImageXUploader;
import com.ss.bduploader.BDImageXUploaderListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class i2 implements BDImageXUploaderListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zd7.b f191948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BDImageXUploader f191949b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f191950a;

        public a(BDImageXInfo r100) {
            if (r100 == null) goto L7;
            BDImageXE2EEncryptionInfo r101 = r100.mEnd2EndEncryption;
            if (r101 == null) goto L7;
            String r102 = r101.mAESKey;
        L8:
            this.f191950a = r102;
            return;
        L7:
            r102 = null;
            goto L8
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f191951a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Integer f191952b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f191953c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final a f191954d;

        public b(BDImageXInfo r100, a r101) {
            String r102 = null;
            if (r100 == null) goto L5;
            String r103 = r100.mImageTosKey;
        L6:
            this.f191951a = r103;
            if (r100 == null) goto L9;
            Integer r104 = Integer.valueOf(r100.mFileIndex);
        L10:
            this.f191952b = r104;
            if (r100 == null) goto L13;
            r102 = r100.mMetaInfo;
        L13:
            this.f191953c = r102;
            this.f191954d = r101;
            return;
        L9:
            r104 = null;
            goto L10
        L5:
            r103 = null;
            goto L6
        }
    }

    @Override // com.ss.bduploader.BDImageXUploaderListener
    public final int imageXUploadCheckNetState(int r100, int r101) {
        return 0;
    }

    @Override // com.ss.bduploader.BDImageXUploaderListener
    public final void onLog(int r100, int r101, String r102) {
    }

    public i2(zd7.b r100, BDImageXUploader r101) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        Intrinsics.checkNotNullParameter(r101, "uploader");
        this.f191948a = r100;
        this.f191949b = r101;
    }

    @Override // com.ss.bduploader.BDImageXUploaderListener
    public final void onNotify(int r100, long r101, BDImageXInfo r102) {
        b r103 = new b(r102, new a(r102));
        String r104 = null;
        if (r100 != 0) goto L5;
        this.f191948a.onComplete();     // Catch: Exception -> L39
        this.f191949b.close();     // Catch: Exception -> L39
        return;
    L5:
        if (r100 != 1) goto L7;
        zd7.b r105 = this.f191948a;     // Catch: Exception -> L39
        if (r102 == null) goto L35;
        Integer r106 = Integer.valueOf(r102.mFileIndex);     // Catch: Exception -> L39
    L36:
        r105.c(r106, r101);     // Catch: Exception -> L39
        return;
    L35:
        r106 = null;
        goto L36
    L7:
        if (r100 != 2) goto L9;
    L24:
        zd7.b r107 = this.f191948a;     // Catch: Exception -> L39
        if (r102 == null) goto L27;
        Long r108 = Long.valueOf(r102.mErrorCode);     // Catch: Exception -> L39
    L28:
        if (r102 == null) goto L30;
        String r109 = r102.mMetaInfo;     // Catch: Exception -> L39
    L31:
        r107.e(r108, r109);     // Catch: Exception -> L39
        this.f191949b.close();     // Catch: Exception -> L39
        return;
    L30:
        r109 = null;
        goto L31
    L27:
        r108 = null;
        goto L28
    L9:
        if (r100 != 3) goto L11;
        zd7.b r110 = this.f191948a;     // Catch: Exception -> L39
        if (r102 == null) goto L19;
        Long r111 = Long.valueOf(r102.mErrorCode);     // Catch: Exception -> L39
    L20:
        if (r102 == null) goto L22;
        String r112 = r102.mMetaInfo;     // Catch: Exception -> L39
    L23:
        r110.a(r111, r112);     // Catch: Exception -> L39
        this.f191949b.close();     // Catch: Exception -> L39
        return;
    L22:
        r112 = null;
        goto L23
    L19:
        r111 = null;
        goto L20
    L11:
        if (r100 != 6) goto L13;
        this.f191948a.b(r103);     // Catch: Exception -> L39
        return;
    L13:
        if (r100 == 7) goto L24;
        return;
    L39:
        e = move-exception;
        zd7.b r113 = this.f191948a;
        if (r102 == null) goto L43;
        Long r114 = Long.valueOf(r102.mErrorCode);
    L44:
        if (r102 == null) goto L46;
        r104 = r102.mMetaInfo;
    L46:
        r113.d(e, r114, r104);
        this.f191949b.close();
        return;
    L43:
        r114 = null;
        goto L44
    }
}
