package com.bytedance.android.gamecp.business.download.recovery;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.gamecp.business.m0;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.extend.DownloadCompletedListener;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class DisasterRecoveryManager implements DownloadCompletedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f52892a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f52893b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, ConcurrentHashMap<String, Runnable>> f52894c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Integer> f52895d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f52896e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f52897f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicInteger f52898g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f52899h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final DisasterRecoveryManager f52900i = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f52901a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f52902b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f52903c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f52904d;

        public a() {
            String r100 = RomUtils.getName();
            String r101 = RomUtils.getVersion();
            int r102 = Build.VERSION.SDK_INT;
            String r103 = m0.c();
            Intrinsics.checkNotNullParameter(r100, "romName");
            Intrinsics.checkNotNullParameter(r101, "romVersion");
            Intrinsics.checkNotNullParameter(r103, "hmVersion");
            this.f52901a = r100;
            this.f52902b = r101;
            this.f52903c = r102;
            this.f52904d = r103;
        }
    }

    public DisasterRecoveryManager() {
    }

    @Override // com.ss.android.download.api.download.extend.DownloadCompletedListener
    public final void onInstalled(DownloadInfo r100, String r101) {
    }

    static {
        f52900i = new DisasterRecoveryManager();
        f52892a = LazyKt.lazy(DisasterRecoveryManager$globalContext$2.INSTANCE);
        f52893b = new Handler(Looper.getMainLooper());
        f52894c = new ConcurrentHashMap();
        f52895d = new ConcurrentHashMap();
        f52896e = LazyKt.lazy(DisasterRecoveryManager$config$2.INSTANCE);
        f52898g = new AtomicInteger(0);
        f52899h = LazyKt.lazy(DisasterRecoveryManager$configMap$2.INSTANCE);
    }

    @Override // com.ss.android.download.api.download.extend.DownloadCompletedListener
    public final void onCanceled(DownloadInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "downloadInfo");
        Intrinsics.checkNotNullParameter(r100, "downloadInfo");
    }

    @Override // com.ss.android.download.api.download.extend.DownloadCompletedListener
    public final void onDownloadFinished(DownloadInfo r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "downloadInfo");
        Intrinsics.checkNotNullParameter(r100, "downloadInfo");
    }

    @Override // com.ss.android.download.api.download.extend.DownloadCompletedListener
    public final void onDownloadFailed(DownloadInfo r100, BaseException r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "downloadInfo");
        if (r101 == null) goto L12;
        String r103 = r100.getUrl();
        if (r103 == null) goto L13;
        List r104 = StringsKt.split$default(r103, new String[]{"?"}, false, 0, 6, null);
        if (r104 == null) goto L14;
        String r105 = (String) CollectionsKt.getOrNull(r104, 0);
        if (r105 == null) goto L15;
        f52895d.put(r105, Integer.valueOf(r101.getErrorCode()));
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    @Override // com.ss.android.download.api.download.extend.DownloadCompletedListener
    public final void onDownloadStart(DownloadModel r100, DownloadController r101, DownloadEventConfig r102) {
        Intrinsics.checkNotNullParameter(r100, "downloadModel");
        Intrinsics.checkNotNullParameter(r100, "downloadModel");
    }
}
