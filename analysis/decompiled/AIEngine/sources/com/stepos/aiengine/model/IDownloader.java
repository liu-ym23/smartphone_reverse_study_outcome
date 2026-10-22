package com.stepos.aiengine.model;

import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import com.stepos.core.download.IDownloadCallback;
import e6.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface IDownloader {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class DefaultImpls {
        public static /* synthetic */ void start$default(IDownloader iDownloader, Bundle bundle, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: start");
            }
            if ((i10 & 1) != 0) {
                bundle = null;
            }
            iDownloader.start(bundle);
        }
    }

    void cancel();

    void destroy();

    ParcelFileDescriptor getFileDescriptor();

    Uri getFileUri();

    int getProgress();

    int getStatus();

    void pause();

    void registerCallback(String str, IDownloadCallback iDownloadCallback);

    void registerCallback(String str, IDownloadCallback iDownloadCallback, a aVar);

    void resume();

    void start(Bundle bundle);

    void unregisterCallback(String str);
}
