package com.byted.cast.common.api;

import android.content.Context;
import android.content.Intent;
import com.byted.cast.common.api.cloud.ICastIdListener;
import com.byted.cast.common.api.multiple.IMultipleActiveControl;
import com.byted.cast.common.api.multiple.IMultipleLoader;
import com.byted.cast.common.bean.DeviceInfo;
import com.byted.cast.common.config.Config;
import com.byted.cast.common.config.IInitListener;
import com.byted.cast.common.sink.CastInfo;
import com.byted.cast.common.sink.ClientInfo;
import com.byted.cast.common.sink.IMessageListener;
import com.byted.cast.common.sink.IMirrorListener;
import com.byted.cast.common.sink.IPreemptListener;
import com.byted.cast.common.sink.ISourceDeviceInfoListener;
import com.byted.cast.common.sink.ServiceInfo;
import com.byted.cast.common.sink.Statistics;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public interface ICastSink {

    /* JADX INFO: renamed from: com.byted.cast.common.api.ICastSink$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$addCastIdListener(ICastSink r100, ICastIdListener r101) {
        }

        public static void $default$deliverIntent(ICastSink r100, Intent r101) {
        }

        public static DeviceInfo $default$getDeviceInfo(ICastSink r100, String r101) {
            return null;
        }

        public static IMultipleActiveControl $default$getMultipleActiveControl(ICastSink r100) {
            return null;
        }

        public static IMultipleLoader $default$getMultipleLoader(ICastSink r100) {
            return null;
        }

        public static Object $default$getOption(ICastSink r100, int r101, Object... r102) {
            return null;
        }

        public static ServiceInfo $default$getServiceInfo(ICastSink r100) {
            return null;
        }

        public static Statistics $default$getStatistics(ICastSink r100) {
            return null;
        }

        public static boolean $default$notifyPreempt(ICastSink r100, boolean r101, ClientInfo r102) {
            return false;
        }

        public static void $default$requestIdrFromSource(ICastSink r100, CastInfo r101) {
        }

        public static boolean $default$reverseConnect(ICastSink r100, String r101, int r102) {
            return false;
        }

        public static boolean $default$reverseDisconnect(ICastSink r100) {
            return false;
        }

        public static boolean $default$reverseInvite(ICastSink r100, String r101) {
            return false;
        }

        public static void $default$send(ICastSink r100, CastInfo r101, String r102, ISendResultListener r103) {
        }

        public static void $default$send(ICastSink r100, ServiceInfo r101, String r102, com.byted.cast.common.sink.ISendResultListener r103) {
        }

        public static String $default$sendSync(ICastSink r100, ServiceInfo r101, String r102) {
            return "";
        }

        public static void $default$setActionListener(ICastSink r100, IActionListener r101) {
        }

        public static void $default$setBrowseDataListener(ICastSink r100, IBrowseDataListener r101) {
        }

        public static void $default$setLogEnabled(ICastSink r100, boolean r101) {
        }

        public static void $default$setMediaServiceEnable(ICastSink r100, boolean r101) {
        }

        public static void $default$setMediaServiceListener(ICastSink r100, IMediaServiceListener r101) {
        }

        public static void $default$setMessageListener(ICastSink r100, IMessageListener r101) {
        }

        public static void $default$setMirrorListener(ICastSink r100, IMirrorListener r101) {
        }

        public static Object $default$setOption(ICastSink r100, int r101, Object... r102) {
            return null;
        }

        public static void $default$setPreemptListener(ICastSink r100, IPreemptListener r101) {
        }

        public static void $default$setPrivateChannel(ICastSink r100, String r101) {
        }

        public static void $default$setReverseControl(ICastSink r100, IReverseControl r101) {
        }

        public static void $default$setServerListener(ICastSink r100, com.byted.cast.common.sink.IServerListener r101) {
        }

        public static void $default$setSourceDeviceInfoListener(ICastSink r100, ISourceDeviceInfoListener r101) {
        }

        public static void $default$setSsdpPrivateChannel(ICastSink r100, String r101) {
        }

        public static void $default$startSsdpServer(ICastSink r100, String r101) {
        }

        public static boolean $default$stopInvite(ICastSink r100, String r101) {
            return false;
        }

        public static void $default$stopSsdpServer(ICastSink r100) {
        }

        public static void $default$upDateServerName(ICastSink r100, String r101) {
        }

        public static List $default$getRegisterList(ICastSink r100) {
            return new ArrayList();
        }
    }

    void addCastIdListener(ICastIdListener r100);

    void deliverIntent(Intent r100);

    void destroy();

    DeviceInfo getDeviceInfo(String r100);

    IMultipleActiveControl getMultipleActiveControl();

    IMultipleLoader getMultipleLoader();

    Object getOption(int r100, Object... r101);

    List<ServiceInfo> getRegisterList();

    ServiceInfo getServiceInfo();

    Statistics getStatistics();

    String getVersion();

    void init(Context r100, Config r101, IInitListener r102);

    boolean notifyPreempt(boolean r100, ClientInfo r101);

    void requestIdrFromSource(CastInfo r100);

    boolean reverseConnect(String r100, int r101);

    boolean reverseDisconnect();

    boolean reverseInvite(String r100);

    void send(CastInfo r100, String r101, ISendResultListener r102);

    void send(ServiceInfo r100, String r101, com.byted.cast.common.sink.ISendResultListener r102);

    String sendSync(ServiceInfo r100, String r101);

    void setActionListener(IActionListener r100);

    void setBrowseDataListener(IBrowseDataListener r100);

    void setLogEnabled(boolean r100);

    void setMediaServiceEnable(boolean r100);

    void setMediaServiceListener(IMediaServiceListener r100);

    void setMessageListener(IMessageListener r100);

    void setMirrorListener(IMirrorListener r100);

    Object setOption(int r100, Object... r101);

    void setPreemptListener(IPreemptListener r100);

    void setPrivateChannel(String r100);

    void setReverseControl(IReverseControl r100);

    void setServerListener(IServerListener r100);

    void setServerListener(com.byted.cast.common.sink.IServerListener r100);

    void setSourceDeviceInfoListener(ISourceDeviceInfoListener r100);

    void setSsdpPrivateChannel(String r100);

    void startServer(String r100);

    void startSsdpServer(String r100);

    boolean stopInvite(String r100);

    void stopServer();

    void stopSsdpServer();

    void upDateServerName(String r100);
}
