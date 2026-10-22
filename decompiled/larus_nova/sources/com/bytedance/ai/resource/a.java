package com.bytedance.ai.resource;

import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f37290a = 0;

    /* JADX INFO: renamed from: com.bytedance.ai.resource.a$a, reason: collision with other inner class name */
    public interface InterfaceC0711a {
        void a();

        void onFailed();

        void onSuccess();
    }

    static {
    }

    public a() {
    }

    public static Object a(String r100, String r101, ContinuationImpl r102) {
        if (r100.length() != 0) goto L5;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L9;
    L17:
        com.bytedance.ai.utils.g.f37637a.e("AIPackageManager", "url: " + r100 + ", path: " + r101 + " ===> The download url and path are empty");
        return Boxing.boxBoolean(false);
    L9:
        if (r101.length() != 0) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == true) goto L17;
        SafeContinuation r105 = new SafeContinuation(IntrinsicsKt.intercepted(r102));
        com.bytedance.ai.utils.g r106 = com.bytedance.ai.utils.g.f37637a;
        r106.d("AIPackageManager", "url: " + r100 + ", path: " + r101 + " ===> Start downloading");
        b r107 = new b(r100, r101, r105);
        DownloadTask r108 = Downloader.with(f2.k.a()).url(r100).name(StringsKt.substringAfterLast$default(r100, '/', null, 2, null)).savePath(r101).needPostProgress(true).subThreadListener(new c(r107));
        r108.download();
        r106.i("AIDownloadManager", "start download:  " + r100 + "， download id: " + r108.getDownloadId());
        Object r109 = r105.getOrThrow();
        if (r109 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
        DebugProbesKt.probeCoroutineSuspended(r102);
        return r109;
    L19:
        return r109;
    L11:
        r104 = false;
        goto L12
    L5:
        r103 = false;
        goto L7
    }
}
