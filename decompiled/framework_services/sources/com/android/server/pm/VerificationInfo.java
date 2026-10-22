package com.android.server.pm;

import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
final class VerificationInfo {
    final int mInstallerUid;
    final int mOriginatingUid;
    final Uri mOriginatingUri;
    final Uri mReferrer;

    VerificationInfo(Uri originatingUri, Uri referrer, int originatingUid, int installerUid) {
        this.mOriginatingUri = originatingUri;
        this.mReferrer = referrer;
        this.mOriginatingUid = originatingUid;
        this.mInstallerUid = installerUid;
    }
}
