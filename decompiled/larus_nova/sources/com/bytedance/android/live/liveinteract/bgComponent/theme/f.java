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
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes46.dex */
public final class f extends AbsDownloadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f71743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f71744b;

    /* JADX WARN: Multi-variable type inference failed */
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
        if (Intrinsics.areEqual(r104.getKey(), (String) this.f71744b.element) == false) goto L8;
        r102.put(r104.getKey(), r104.getValue());
        goto L8
    L12:
        VideoThemeDownloadManager.f71683b.remove((String) this.f71744b.element);
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

    public f(Ref.ObjectRef r100, Ref.ObjectRef r101) {
        this.f71743a = r100;
        this.f71744b = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onFailed(DownloadInfo r100, BaseException r101) {
        super.onFailed(r100, r101);
        ALogger.e("VoiceLiveTheme", "download theme video error:" + ((String) this.f71743a.element));
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getUrl() == null) goto L35;
        HashMap<String, VideoThemeDownloadManager.a> r102 = VideoThemeDownloadManager.f71683b;
        LinkedHashMap r103 = new LinkedHashMap();
        Iterator<Map.Entry<String, VideoThemeDownloadManager.a>> r104 = r102.entrySet().iterator();
    L8:
        if (r104.hasNext() == false) goto L12;
        Map.Entry<String, VideoThemeDownloadManager.a> r105 = r104.next();
        if (Intrinsics.areEqual(r105.getKey(), (String) this.f71744b.element) == false) goto L8;
        r103.put(r105.getKey(), r105.getValue());
        goto L8
    L12:
        VideoThemeDownloadManager.f71683b.remove((String) this.f71744b.element);
        Iterator r106 = r103.entrySet().iterator();
    L14:
        if (r106.hasNext() == false) goto L36;
        Iterator<WeakReference<com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.b>> r107 = ((VideoThemeDownloadManager.a) ((Map.Entry) r106.next()).getValue()).f71685b.iterator();
    L17:
        if (r107.hasNext() == false) goto L14;
        com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.b r108 = r107.next().get();
        if (r108 == null) goto L17;
        if (r101 == null) goto L22;
        r101.getErrorMessage();
    L22:
        r108.b();
        goto L17
    L36:
        return;
    }
}
