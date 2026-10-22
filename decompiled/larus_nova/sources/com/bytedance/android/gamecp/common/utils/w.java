package com.bytedance.android.gamecp.common.utils;

import android.media.MediaScannerConnection;
import android.net.Uri;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes44.dex */
public final class w implements MediaScannerConnection.OnScanCompletedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f57324a;

    public w(Function1 r100) {
        this.f57324a = r100;
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public final void onScanCompleted(String r100, Uri r101) {
        Function1 r102 = this.f57324a;
        if (r101 == null) goto L5;
        String r103 = r101.toString();
    L6:
        r102.invoke(r103);
        return;
    L5:
        r103 = null;
        goto L6
    }
}
