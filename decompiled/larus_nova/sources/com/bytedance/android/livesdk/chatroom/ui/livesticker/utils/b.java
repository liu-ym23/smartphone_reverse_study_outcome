package com.bytedance.android.livesdk.chatroom.ui.livesticker.utils;

import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes8.dex */
public final class b extends AbsDownloadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f113701a;

    public b(long r100) {
        this.f113701a = r100;
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onSuccessed(DownloadInfo r100) {
        super.onSuccessed(r100);
        Lazy<String> r101 = LiveStickerTtfUtil.f113697a;
        FileUtils.renameFile(LiveStickerTtfUtil.f113697a.getValue() + this.f113701a + ".temp", LiveStickerTtfUtil.c(this.f113701a));
        NextLiveData<Integer> r102 = LiveStickerTtfUtil.f113699c;
        Integer r103 = r102.getValue();
        if (r103 == null) goto L5;
        int r104 = r103.intValue() + 1;
    L6:
        r102.postValue(Integer.valueOf(r104));
        return;
    L5:
        r104 = 0;
        goto L6
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onFailed(DownloadInfo r100, BaseException r101) {
        super.onFailed(r100, r101);
        Lazy<String> r102 = LiveStickerTtfUtil.f113697a;
        NextLiveData<Integer> r103 = LiveStickerTtfUtil.f113699c;
        Integer r104 = r103.getValue();
        if (r104 == null) goto L5;
        int r105 = r104.intValue() + 1;
    L6:
        r103.postValue(Integer.valueOf(r105));
        return;
    L5:
        r105 = 0;
        goto L6
    }
}
