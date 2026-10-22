package com.byted.cast.common.api;

import android.content.Context;
import android.media.projection.MediaProjection;
import android.net.Uri;
import android.view.Surface;
import com.byted.cast.common.bean.DanmakuBean;
import com.byted.cast.common.bean.DeviceInfo;
import com.byted.cast.common.bean.DramaBean;
import com.byted.cast.common.bean.Resolution;
import com.byted.cast.common.bean.Speed;
import com.byted.cast.common.bean.Subtitle;
import com.byted.cast.common.config.Config;
import com.byted.cast.common.config.IInitListener;
import com.byted.cast.common.config.IMediaInfoListener;
import com.byted.cast.common.source.IMessageListener;
import com.byted.cast.common.source.IMirrorListener;
import com.byted.cast.common.source.ISinkDeviceInfoListener;
import com.byted.cast.common.source.ISinkRuntimeInfoListener;
import com.byted.cast.common.source.ServiceInfo;
import com.byted.cast.common.source.Statistics;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public interface ICastSource {

    /* JADX INFO: renamed from: com.byted.cast.common.api.ICastSource$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$addDramaList(ICastSource r100, DramaBean[] r101, String r102, IResultListener r103) {
        }

        public static void $default$addOutputSurface(ICastSource r100, Surface r101) {
        }

        public static void $default$addVolume(ICastSource r100) {
        }

        public static void $default$changeCameraID(ICastSource r100, int r101) {
        }

        public static void $default$changeDanmakuSetting(ICastSource r100, DanmakuBean r101) {
        }

        public static void $default$changeResolution(ICastSource r100, Resolution r101) {
        }

        public static void $default$changeSpeed(ICastSource r100, Speed r101) {
        }

        public static void $default$clearDramaList(ICastSource r100) {
        }

        public static void $default$connect(ICastSource r100, ServiceInfo r101) {
        }

        public static void $default$deleteDramaList(ICastSource r100, List r101) {
        }

        public static void $default$destroy(ICastSource r100) {
        }

        public static int $default$detect(ICastSource r100, ServiceInfo r101, int r102, int r103) {
            return 1;
        }

        public static boolean $default$disConnect(ICastSource r100, ServiceInfo r101) {
            return false;
        }

        public static void $default$disableQueryPlayState(ICastSource r100) {
        }

        public static void $default$enableAudio(ICastSource r100, boolean r101) {
        }

        public static void $default$enableFlash(ICastSource r100, boolean r101) {
        }

        public static void $default$enableQueryPlayState(ICastSource r100) {
        }

        public static ServiceInfo $default$getCurrentPlayServiceInfo(ICastSource r100) {
            return null;
        }

        public static void $default$getDeviceInfo(ICastSource r100, ServiceInfo r101, IGetDeviceInfoListener r102) {
        }

        public static void $default$getMediaInfo(ICastSource r100, ServiceInfo r101) {
        }

        public static void $default$getMsg(ICastSource r100, ServiceInfo r101, String r102, com.byted.cast.common.source.ISendResultListener r103) {
        }

        public static Object $default$getOption(ICastSource r100, int r101, Object... r102) {
            return null;
        }

        public static ServiceInfo $default$getServiceInfo(ICastSource r100) {
            return null;
        }

        public static void $default$getSinkDeviceInfo(ICastSource r100, ServiceInfo r101, ISinkDeviceInfoListener r102) {
        }

        public static List $default$getSsdpServiceInfoList(ICastSource r100) {
            return null;
        }

        public static void $default$getStatusAndMediaInfo(ICastSource r100, ServiceInfo r101, IResultListener r102) {
        }

        public static void $default$getStatusInfo(ICastSource r100, ServiceInfo r101, IResultListener r102) {
        }

        public static void $default$getVolume(ICastSource r100, IResultListener r101) {
        }

        public static void $default$init(ICastSource r100, Context r101, Config r102, IInitListener r103) {
        }

        public static void $default$onDiskCacheFoundService(ICastSource r100, ServiceInfo r101) {
        }

        public static void $default$onNetworkChangeReady(ICastSource r100) {
        }

        public static void $default$onSsdpDeviceOffline(ICastSource r100, ServiceInfo r101) {
        }

        public static void $default$pause(ICastSource r100) {
        }

        public static boolean $default$ping(ICastSource r100, String r101, int r102) {
            return false;
        }

        public static void $default$play(ICastSource r100, PlayerInfo r101) {
        }

        public static void $default$play(ICastSource r100, PlayerInfo r101, IResultListener r102) {
        }

        public static void $default$play(ICastSource r100, ServiceInfo r101, Uri r102, int r103) {
        }

        public static void $default$playDramaId(ICastSource r100, String r101, IResultListener r102) {
        }

        public static void $default$playDramaList(ICastSource r100, ServiceInfo r101, List r102, String r103, IResultListener r104) {
        }

        public static void $default$playNextDrama(ICastSource r100) {
        }

        public static void $default$playPreDrama(ICastSource r100) {
        }

        public static void $default$register(ICastSource r100, ServiceInfo r101, IRegisterResultListener r102) {
        }

        public static void $default$removeOutputSurface(ICastSource r100, Surface r101) {
        }

        public static void $default$resetConnect(ICastSource r100, ServiceInfo r101, IResultListener r102) {
        }

        public static void $default$resume(ICastSource r100) {
        }

        public static void $default$seekTo(ICastSource r100, long r101, int r102) {
        }

        public static void $default$send(ICastSource r100, ServiceInfo r101, String r102, com.byted.cast.common.source.ISendResultListener r103) {
        }

        public static void $default$sendData(ICastSource r100, int r101, byte[] r102, long r103, long r104, long r105, long r106) {
        }

        public static String $default$sendSync(ICastSource r100, ServiceInfo r101, String r102) {
            return "";
        }

        public static void $default$setAudioMixScale(ICastSource r100, int r101) {
        }

        public static void $default$setAuthorizationResult(ICastSource r100, int r101) {
        }

        public static void $default$setConnectListener(ICastSource r100, IConnectListener r101) {
        }

        public static void $default$setInheritConfig(ICastSource r100, int r101, IResultListener r102) {
        }

        public static void $default$setInputSurfaceCallback(ICastSource r100, ISurfaceListener r101) {
        }

        public static void $default$setLibraryLoader(ICastSource r100, ILibraryLoader r101) {
        }

        public static void $default$setLogger(ICastSource r100, ILogger r101) {
        }

        public static void $default$setLoopMode(ICastSource r100, int r101, int r102, IResultListener r103) {
        }

        public static void $default$setMediaInfoListener(ICastSource r100, IMediaInfoListener r101) {
        }

        public static void $default$setMediaProjection(ICastSource r100, MediaProjection r101) {
        }

        public static void $default$setMessageListener(ICastSource r100, IMessageListener r101) {
        }

        public static void $default$setMirrorInfo(ICastSource r100, MirrorInfo r101) {
        }

        public static void $default$setMirrorListener(ICastSource r100, IMirrorListener r101) {
        }

        public static void $default$setOption(ICastSource r100, int r101, Object... r102) {
        }

        public static void $default$setPlayerListener(ICastSource r100, IPlayerListener r101) {
        }

        public static void $default$setPlayerListener(ICastSource r100, com.byted.cast.common.source.IPlayerListener r101) {
        }

        public static void $default$setPrivateChannel(ICastSource r100, String r101) {
        }

        public static void $default$setRepeatMode(ICastSource r100, int r101, IResultListener r102) {
        }

        public static void $default$setServerInfo(ICastSource r100, PlayerInfo r101) {
        }

        public static void $default$setServerListener(ICastSource r100, IServerListener r101) {
        }

        public static void $default$setShouldRestartBrowse(ICastSource r100, boolean r101) {
        }

        public static void $default$setSinkRuntimeInfoListener(ICastSource r100, ISinkRuntimeInfoListener r101) {
        }

        public static void $default$setSkip(ICastSource r100, int r101, IResultListener r102) {
        }

        public static void $default$setSsdpBrowseResultListener(ICastSource r100, IBrowseListener r101) {
        }

        public static void $default$setSsdpPrivateChannel(ICastSource r100, String r101) {
        }

        public static void $default$setSsdpWriteCacheListener(ICastSource r100, IWriteCacheListener r101) {
        }

        public static void $default$setStretchMode(ICastSource r100, int r101, IResultListener r102) {
        }

        public static void $default$setSubtitle(ICastSource r100, Subtitle r101, IResultListener r102) {
        }

        public static void $default$setSurfaceFillType(ICastSource r100, int r101) {
        }

        public static void $default$setVolume(ICastSource r100, int r101) {
        }

        public static void $default$startMirror(ICastSource r100, MirrorInfo r101) {
        }

        public static void $default$startRecorder(ICastSource r100) {
        }

        public static void $default$startServer(ICastSource r100, String r101) {
        }

        public static void $default$startSsdpBrowse(ICastSource r100) {
        }

        public static void $default$stop(ICastSource r100) {
        }

        public static void $default$stopMirror(ICastSource r100) {
        }

        public static void $default$stopRecorder(ICastSource r100) {
        }

        public static void $default$stopServer(ICastSource r100) {
        }

        public static void $default$stopSsdpBrowse(ICastSource r100) {
        }

        public static void $default$subVolume(ICastSource r100) {
        }

        public static void $default$unregister(ICastSource r100, ServiceInfo r101, IRegisterResultListener r102) {
        }

        public static Statistics $default$getStatistics(ICastSource r100) {
            return new Statistics();
        }

        public static DeviceInfo $default$getSinkDeviceInfo(ICastSource r100, String r101, int r102) {
            return new DeviceInfo();
        }
    }

    void addDramaList(DramaBean[] r100, String r101, IResultListener r102);

    void addOutputSurface(Surface r100);

    void addVolume();

    void changeCameraID(int r100);

    void changeDanmakuSetting(DanmakuBean r100);

    void changeResolution(Resolution r100);

    void changeSpeed(Speed r100);

    void clearDramaList();

    void connect(ServiceInfo r100);

    void deleteDramaList(List<String> r100);

    void destroy();

    int detect(ServiceInfo r100, int r101, int r102);

    boolean disConnect(ServiceInfo r100);

    void disableQueryPlayState();

    void enableAudio(boolean r100);

    void enableFlash(boolean r100);

    void enableQueryPlayState();

    ServiceInfo getCurrentPlayServiceInfo();

    void getDeviceInfo(ServiceInfo r100, IGetDeviceInfoListener r101);

    void getMediaInfo(ServiceInfo r100);

    void getMsg(ServiceInfo r100, String r101, com.byted.cast.common.source.ISendResultListener r102);

    Object getOption(int r100, Object... r101);

    ServiceInfo getServiceInfo();

    DeviceInfo getSinkDeviceInfo(String r100, int r101);

    void getSinkDeviceInfo(ServiceInfo r100, ISinkDeviceInfoListener r101);

    List<ServiceInfo> getSsdpServiceInfoList();

    Statistics getStatistics();

    void getStatusAndMediaInfo(ServiceInfo r100, IResultListener r101);

    void getStatusInfo(ServiceInfo r100, IResultListener r101);

    String getVersion();

    void getVolume(IResultListener r100);

    void init(Context r100, Config r101, IInitListener r102);

    void onDiskCacheFoundService(ServiceInfo r100);

    void onNetworkChangeReady();

    void onSsdpDeviceOffline(ServiceInfo r100);

    void pause();

    boolean ping(String r100, int r101);

    void play(PlayerInfo r100);

    void play(PlayerInfo r100, IResultListener r101);

    void play(ServiceInfo r100, Uri r101, int r102);

    void playDramaId(String r100, IResultListener r101);

    void playDramaList(ServiceInfo r100, List<DramaBean> r101, String r102, IResultListener r103);

    void playNextDrama();

    void playPreDrama();

    void register(ServiceInfo r100, IRegisterResultListener r101);

    void removeOutputSurface(Surface r100);

    void resetConnect(ServiceInfo r100, IResultListener r101);

    void resume();

    void seekTo(long r100, int r101);

    void send(ServiceInfo r100, String r101, com.byted.cast.common.source.ISendResultListener r102);

    void sendData(int r100, byte[] r101, long r102, long r103, long r104, long r105);

    String sendSync(ServiceInfo r100, String r101);

    void setAudioMixScale(int r100);

    void setAuthorizationResult(int r100);

    void setBrowseResultListener(IBrowseListener r100);

    void setConnectListener(IConnectListener r100);

    void setInheritConfig(int r100, IResultListener r101);

    void setInputSurfaceCallback(ISurfaceListener r100);

    void setLibraryLoader(ILibraryLoader r100);

    void setLogger(ILogger r100);

    void setLoopMode(int r100, int r101, IResultListener r102);

    void setMediaInfoListener(IMediaInfoListener r100);

    void setMediaProjection(MediaProjection r100);

    void setMessageListener(IMessageListener r100);

    void setMirrorInfo(MirrorInfo r100);

    void setMirrorListener(IMirrorListener r100);

    void setOption(int r100, Object... r101);

    void setPlayerListener(IPlayerListener r100);

    void setPlayerListener(com.byted.cast.common.source.IPlayerListener r100);

    void setPrivateChannel(String r100);

    void setRepeatMode(int r100, IResultListener r101);

    void setServerInfo(PlayerInfo r100);

    void setServerListener(IServerListener r100);

    void setShouldRestartBrowse(boolean r100);

    void setSinkRuntimeInfoListener(ISinkRuntimeInfoListener r100);

    void setSkip(int r100, IResultListener r101);

    void setSsdpBrowseResultListener(IBrowseListener r100);

    void setSsdpPrivateChannel(String r100);

    void setSsdpWriteCacheListener(IWriteCacheListener r100);

    void setStretchMode(int r100, IResultListener r101);

    void setSubtitle(Subtitle r100, IResultListener r101);

    void setSurfaceFillType(int r100);

    void setVolume(int r100);

    void startBrowse();

    void startMirror(MirrorInfo r100);

    void startRecorder();

    void startServer(String r100);

    void startSsdpBrowse();

    void stop();

    void stopBrowse();

    void stopMirror();

    void stopRecorder();

    void stopServer();

    void stopSsdpBrowse();

    void subVolume();

    void unregister(ServiceInfo r100, IRegisterResultListener r101);
}
