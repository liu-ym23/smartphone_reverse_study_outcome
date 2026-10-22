package com.bytedance.android.livehostapi.foundation;

import android.graphics.Bitmap;
import android.net.Uri;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.foundation.base.IBaseHostFrescoHelper;
import py.k;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostFrescoHelper extends IService, IBaseHostFrescoHelper {

    public static class BitmapDataSource {
        public Throwable error;

        public BitmapDataSource() {
        }
    }

    public interface DownloadImageCallBack {
        void onFailureImpl();

        void onNewResultImpl();
    }

    public interface GetBitmapCallBack {
        void fail(BitmapDataSource r100);

        void onNewResultImpl(Bitmap r100);
    }

    String getImageFilePath(String r100);

    String getImageFilePath(k r100);

    void initImageLib();

    boolean isDownloaded(Uri r100);

    boolean isDownloaded(k r100);

    BitmapDataSource loadFirstAvailableImageBitmap(k r100, GetBitmapCallBack r101);

    void tryDownloadImage(String r100);

    void tryDownloadImage(String r100, DownloadImageCallBack r101);

    void updateAnimatedFrameScheduler(boolean r100);
}
