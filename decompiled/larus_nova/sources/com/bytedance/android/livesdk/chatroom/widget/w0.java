package com.bytedance.android.livesdk.chatroom.widget;

import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: classes8.dex */
public final class w0 implements MediaScannerConnection.OnScanCompletedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f119255a;

    public w0(Context r100) {
        this.f119255a = r100;
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public final void onScanCompleted(String r100, Uri r101) {
        Intent r102 = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        r102.setData(r101);
        this.f119255a.sendBroadcast(r102);
        ALogger.d(z0.f119266u, "onScanCompleted,path=" + r100);
    }
}
