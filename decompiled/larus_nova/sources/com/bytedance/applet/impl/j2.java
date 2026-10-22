package com.bytedance.applet.impl;

import com.ss.bduploader.BDVideoInfo;
import com.ss.bduploader.BDVideoUploader;
import com.ss.bduploader.BDVideoUploaderListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class j2 implements BDVideoUploaderListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zd7.c f191956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BDVideoUploader f191957b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f191958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f191959b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Long f191960c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f191961d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f191962e;

        public a(BDVideoInfo r100) {
            String r101 = null;
            if (r100 == null) goto L5;
            String r102 = r100.mVideoId;
        L6:
            this.f191958a = r102;
            if (r100 == null) goto L9;
            String r103 = r100.mCoverUri;
        L10:
            this.f191959b = r103;
            if (r100 == null) goto L13;
            Long r104 = Long.valueOf(r100.mErrorCode);
        L14:
            this.f191960c = r104;
            if (r100 == null) goto L17;
            String r105 = r100.mErrorMsg;
        L18:
            this.f191961d = r105;
            if (r100 == null) goto L21;
            r101 = r100.mVideoMediaInfo;
        L21:
            this.f191962e = r101;
            return;
        L17:
            r105 = null;
            goto L18
        L13:
            r104 = null;
            goto L14
        L9:
            r103 = null;
            goto L10
        L5:
            r102 = null;
            goto L6
        }
    }

    @Override // com.ss.bduploader.BDVideoUploaderListener
    public final String getStringFromExtern(int r100) {
        return "";
    }

    @Override // com.ss.bduploader.BDVideoUploaderListener
    public final void onLog(int r100, int r101, String r102) {
    }

    @Override // com.ss.bduploader.BDVideoUploaderListener
    public final void onUploadVideoStage(int r100, long r101) {
    }

    @Override // com.ss.bduploader.BDVideoUploaderListener
    public final int videoUploadCheckNetState(int r100, int r101) {
        return 0;
    }

    public j2(zd7.c r100, BDVideoUploader r101) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        Intrinsics.checkNotNullParameter(r101, "uploader");
        this.f191956a = r100;
        this.f191957b = r101;
    }

    @Override // com.ss.bduploader.BDVideoUploaderListener
    public final void onNotify(int r100, long r101, BDVideoInfo r102) {
        a r103 = new a(r102);
        if (r100 != 0) goto L5;
        this.f191956a.a(r103);     // Catch: Exception -> L16
        this.f191957b.close();     // Catch: Exception -> L16
    L19:
        return;
    L5:
        if (r100 != 1) goto L7;
        this.f191956a.d(r101);     // Catch: Exception -> L16
        goto L19
    L7:
        if (r100 != 2) goto L9;
        this.f191956a.c(r103);     // Catch: Exception -> L16
        this.f191957b.close();     // Catch: Exception -> L16
        goto L19
    L9:
        if (r100 != 3) goto L23;
        this.f191956a.e(r103);     // Catch: Exception -> L16
        this.f191957b.close();     // Catch: Exception -> L16
        goto L19
    L23:
        return;
    L16:
        e = move-exception;
        this.f191956a.b(e, r103);
        this.f191957b.close();
    }
}
