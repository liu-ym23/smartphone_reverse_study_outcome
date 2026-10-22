package com.bytedance.android.live.liveinteract.bgComponent.theme;

import com.bytedance.android.live.core.log.ALogger;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class g extends AbsDownloadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f71745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f71746b;

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onSuccessed(DownloadInfo r100) {
        super.onSuccessed(r100);
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getUrl() == null) goto L33;
        HashMap<String, VideoThemeDownloadManager.a> r101 = VideoThemeDownloadManager.f71683b;
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator<Map.Entry<String, VideoThemeDownloadManager.a>> r103 = r101.entrySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L12;
        Map.Entry<String, VideoThemeDownloadManager.a> r104 = r103.next();
        if (Intrinsics.areEqual(r104.getKey(), this.f71746b) == false) goto L8;
        r102.put(r104.getKey(), r104.getValue());
        goto L8
    L12:
        VideoThemeDownloadManager.f71683b.remove(this.f71746b);
        Iterator r105 = r102.entrySet().iterator();
    L14:
        if (r105.hasNext() == false) goto L34;
        Map.Entry r106 = (Map.Entry) r105.next();
        Iterator<WeakReference<com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.b>> r107 = ((VideoThemeDownloadManager.a) r106.getValue()).f71685b.iterator();
    L17:
        if (r107.hasNext() == false) goto L14;
        com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.b r108 = r107.next().get();
        if (r108 == null) goto L17;
        Lazy r109 = VideoThemeDownloadManager.f71682a;
        r108.a(VideoThemeDownloadManager.d(((VideoThemeDownloadManager.a) r106.getValue()).f71684a));
        goto L17
    L34:
        return;
    }

    public g(String r100, String r101) {
        this.f71745a = r100;
        this.f71746b = r101;
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onFailed(DownloadInfo r100, BaseException r101) {
        super.onFailed(r100, r101);
        StringBuilder r102 = new StringBuilder("download theme video error:");
        r102.append(this.f71745a);
        r102.append(tb2.c.DEFAULT_TEXT);
        if (r101 == null) goto L5;
        String r103 = r101.getMessage();
    L6:
        r102.append(r103);
        ALogger.e("VoiceLiveTheme", r102.toString());
        if (r100 != null) goto L9;
        return;
    L9:
        if (r100.getUrl() == null) goto L39;
        HashMap<String, VideoThemeDownloadManager.a> r104 = VideoThemeDownloadManager.f71683b;
        LinkedHashMap r105 = new LinkedHashMap();
        Iterator<Map.Entry<String, VideoThemeDownloadManager.a>> r106 = r104.entrySet().iterator();
    L12:
        if (r106.hasNext() == false) goto L16;
        Map.Entry<String, VideoThemeDownloadManager.a> r107 = r106.next();
        if (Intrinsics.areEqual(r107.getKey(), this.f71746b) == false) goto L12;
        r105.put(r107.getKey(), r107.getValue());
        goto L12
    L16:
        VideoThemeDownloadManager.f71683b.remove(this.f71746b);
        Iterator r108 = r105.entrySet().iterator();
    L18:
        if (r108.hasNext() == false) goto L40;
        Iterator<WeakReference<com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.b>> r109 = ((VideoThemeDownloadManager.a) ((Map.Entry) r108.next()).getValue()).f71685b.iterator();
    L21:
        if (r109.hasNext() == false) goto L18;
        com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.b r110 = r109.next().get();
        if (r110 == null) goto L21;
        if (r101 == null) goto L26;
        r101.getErrorMessage();
    L26:
        r110.b();
        goto L21
    L40:
        return;
    L39:
        return;
    L5:
        r103 = null;
        goto L6
    }
}
