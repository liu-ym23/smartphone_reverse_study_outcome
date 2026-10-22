package com.byted.cast.common.source;

import android.content.Context;
import com.byted.cast.common.api.IBrowseListener;
import com.byted.cast.common.api.IConnectListener;
import com.byted.cast.common.api.ILibraryLoader;
import com.byted.cast.common.api.ILogger;
import com.byted.cast.common.api.IWriteCacheListener;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public interface IClient {

    /* JADX INFO: renamed from: com.byted.cast.common.source.IClient$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$setLibraryLoader(IClient r100, ILibraryLoader r101) {
        }

        public static void $default$setLogger(IClient r100, ILogger r101) {
        }
    }

    void destroy();

    List<ServiceInfo> getDeviceList(SearchType r100);

    void init(Context r100);

    void onAppendBDLinkInfoSuccess(ServiceInfo r100);

    void onDeviceOffline(ServiceInfo r100);

    void onDiskCacheFoundService(ServiceInfo r100);

    void setBrowseResultListener(IBrowseListener r100);

    void setBrowseTime(int r100);

    void setConnectListener(IConnectListener r100);

    void setLibraryLoader(ILibraryLoader r100);

    void setLogger(ILogger r100);

    void setOption(int r100, Object... r101);

    void setPlayerListener(com.byted.cast.common.api.IPlayerListener r100);

    void setPrivateChannel(String r100);

    void setWriteCacheListener(IWriteCacheListener r100);

    void startBrowse();

    void stopBrowse();
}
