package com.byted.cast.common.sink;

import android.content.Context;
import com.byted.cast.common.config.Config;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public interface IServer {

    /* JADX INFO: renamed from: com.byted.cast.common.sink.IServer$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$deInit(IServer r100) {
        }
    }

    void addProtocols(List<String> r100);

    void deInit();

    void init(Context r100, Config r101);

    void reStartServer();

    void setOption(int r100, Object... r101);

    void setPrivateChannel(String r100);

    void setServerListener(com.byted.cast.common.api.IServerListener r100);

    void startServer(String r100, List<String> r101);

    void stopServer();
}
