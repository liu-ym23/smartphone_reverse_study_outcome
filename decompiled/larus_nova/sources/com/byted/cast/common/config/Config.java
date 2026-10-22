package com.byted.cast.common.config;

import android.text.TextUtils;
import com.byted.cast.common.Constants;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.PreferenceUtils;
import com.byted.cast.common.UrlUtils;
import com.byted.cast.common.api.DisPlayType;
import com.byted.cast.common.api.IAppCommonDataListener;
import com.byted.cast.common.api.IAppStateListener;
import com.byted.cast.common.api.IAudioRecordAdapter;
import com.byted.cast.common.api.IBindSdkInfoListener;
import com.byted.cast.common.api.ICameraAdapter;
import com.byted.cast.common.api.IExperiment;
import com.byted.cast.common.api.IHostAddressAdapter;
import com.byted.cast.common.api.IHttpNetWork;
import com.byted.cast.common.api.ILibraryLoader;
import com.byted.cast.common.api.ILogger;
import com.byted.cast.common.api.IMonitor;
import com.byted.cast.common.api.ISinkDataListener;
import com.byted.cast.common.api.IWifiAdapter;
import com.byted.cast.common.bean.ConnectStatusSetting;
import com.byted.cast.common.bean.DeviceOfflineDetectSettings;
import com.byted.cast.common.bean.DlnaCycleSearchSettings;
import com.byted.cast.common.bean.DlnaUpnpErrorRepushSetting;
import com.byted.cast.common.bean.GetPositionSetting;
import com.byted.cast.common.bean.GetStateSetting;
import com.byted.cast.common.bean.PrivateStateConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes39.dex */
public class Config {
    private String aId;
    private String aesKey;
    private String appId;
    private String appSecret;
    private WeakReference<IAppStateListener> appStateListenerRef;
    private IAudioRecordAdapter audioRecordAdapter;
    private boolean autoPlayAudio;
    private long bdlinkDiskCacheDetectIntervalMills;
    private int bdlinkSinkMessageTimeout;
    private List<WeakReference<IBindSdkInfoListener>> bindSdkInfoListenerRefs;
    private ICameraAdapter cameraAdapter;
    private int channelId;
    private String chromeCastId;
    private WeakReference<IAppCommonDataListener> commonDataListenerRef;
    private ConnectStatusSetting connectStatusSetting;
    private int connectTimeout;
    private int cryptoMode;
    private String deviceId;
    private DeviceOfflineDetectSettings deviceOfflineDetectSettings;
    private String dialAppName;
    private DisPlayType[] disPlayTypeList;
    private int disconnectReason;
    private DlnaCycleSearchSettings dlnaCycleSearchSettings;
    private int dlnaDetectDeviceMode;
    private boolean dlnaLowPerformanceMode;
    private String dlnaSetManufacturer;
    private int dlnaSinkNotifyInterval;
    private DlnaUpnpErrorRepushSetting dlnaUpnpErrorRepushSetting;
    private String dlnaXMLParserKeys;
    private boolean enableAddEncryptShell;
    private boolean enableAudioPlaying;
    private Boolean enableBDLinkSSDPCycleSearch;
    private Boolean enableBDLinkSSDPSwitch;
    private Boolean enableBDLinkSinkBroadcast;
    private Boolean enableBDLinkSinkSSDPSwitch;
    private Boolean enableBDLinkSourceBroadcast;
    private Boolean enableBLE;
    private boolean enableBdLePrivateProtocol;
    private boolean enableBdlinkMultipleIpCorrect;
    private boolean enableBdlinkSinkLinkLocalIPv6;
    private boolean enableBdlinkSourceMdnsIpv6;
    private boolean enableCallbackData;
    private boolean enableCallbackPcm;
    private boolean enableClearCurrentIpWhenNetLost;
    private Boolean enableDLNABroadCast;
    private Boolean enableDLNACache;
    private Boolean enableDLNASearch;
    private boolean enableDebug;
    private Boolean enableDlnaNewDeviceOffline;
    private Boolean enableDlnaSinkCustomizedService;
    private Boolean enableDlnaSourceCustomizedService;
    private boolean enableDlnaUserAgent;
    private boolean enableFileLog;
    private boolean enableFindDeviceByName;
    private boolean enableNewSeekLogic;
    private boolean enablePlaying;
    private boolean enablePrivateProtPlayOpt;
    private boolean enableSinkDlnaUdpBroadcast;
    private boolean enableVideoNativeDecode;
    private boolean enableWifiP2PSearch;
    private IExperiment experiment;
    private Boolean forceDnssd;
    private Boolean forceJmDNS;
    private GetPositionSetting getPositionSetting;
    private GetStateSetting getStateSetting;
    private boolean hasInitByteSync;
    private IHostAddressAdapter hostAddressAdapter;
    private Map<String, String> identityMap;
    private String installId;
    private boolean isInitialModeBind;
    private String lelinkAppId;
    private String lelinkAppSecret;
    private ILibraryLoader libraryLoader;
    private String licensePath;
    private String localProtocols;
    private ILogger logger;
    private ContextManager.CastContext mCastContext;
    private IMonitor monitor;
    private IHttpNetWork netAdapter;
    private String overseasGrayConfigDomain;
    private ArrayList<String> overseasMonitorConfigUrls;
    private String overseasTokenDomain;
    private String privateChannel;
    private PrivateStateConfig privateStateConfig;
    private String projectId;
    private String pullConfigDomain;
    private int serviceId;
    private String serviceName;
    private WeakReference<ISinkDataListener> sinkDataListenerRef;
    private String smartViewReceiverId;
    private boolean startUsbServer;
    private boolean stopDlnaSearchWithoutClearingDevices;
    private String toBDid;
    private String userId;
    private String webOSAppId;
    private IWifiAdapter wifiAdapter;
    private Object wsChannelService;

    public static class Builder {
        private String aId;
        private String aesKey;
        private String appId;
        private String appSecret;
        private IAppStateListener appStateListener;
        private IAudioRecordAdapter audioRecordAdapter;
        private boolean autoPlayAudio;
        private long bdlinkDiskCacheDetectIntervalMills;
        private int bdlinkSinkMessageTimeout;
        private List<IBindSdkInfoListener> bindSdkInfoListeners;
        private ICameraAdapter cameraAdapter;
        private int channelId;
        private String chromeCastId;
        private IAppCommonDataListener commonDataListener;
        private ConnectStatusSetting connectStatusSetting;
        private int connectTimeout;
        private int cryptoMode;
        private String deviceId;
        private DeviceOfflineDetectSettings deviceOfflineDetectSettings;
        private String dialAppName;
        private DisPlayType[] disPlayTypeList;
        private int disconnectReason;
        private DlnaCycleSearchSettings dlnaCycleSearchSettings;
        private int dlnaDetectDeviceMode;
        private boolean dlnaLowPerformanceMode;
        private String dlnaSetManufacturer;
        private int dlnaSinkNotifyInterval;
        private DlnaUpnpErrorRepushSetting dlnaUpnpErrorRepushSetting;
        private String dlnaXMLParserKeys;
        private boolean enableAddEncryptShell;
        private boolean enableAudioPlaying;
        private Boolean enableBDLinkSSDPCycleSearch;
        private Boolean enableBDLinkSSDPSwitch;
        private Boolean enableBDLinkSinkBroadcast;
        private Boolean enableBDLinkSinkSSDPSwitch;
        private Boolean enableBDLinkSourceBroadcast;
        private Boolean enableBLE;
        private boolean enableBdLePrivateProtocol;
        private boolean enableBdlinkMultipleIpCorrect;
        private boolean enableBdlinkSinkLinkLocalIPv6;
        private boolean enableBdlinkSourceMdnsIpv6;
        private boolean enableCallbackData;
        private boolean enableCallbackPcm;
        private boolean enableClearCurrentIpWhenNetLost;
        private Boolean enableDLNABroadCast;
        private Boolean enableDLNACache;
        private Boolean enableDLNASearch;
        private boolean enableDebug;
        private Boolean enableDlnaNewDeviceOffline;
        private Boolean enableDlnaSinkCustomizedService;
        private Boolean enableDlnaSourceCustomizedService;
        private boolean enableDlnaUserAgent;
        private boolean enableFileLog;
        private boolean enableFindDeviceByName;
        private boolean enableNewSeekLogic;
        private boolean enablePlaying;
        private boolean enablePrivateProtPlayOpt;
        private boolean enableSinkDlnaUdpBroadcast;
        private boolean enableVideoNativeDecode;
        private boolean enableWifiP2PSearch;
        private IExperiment experiment;
        private Boolean forceDnssd;
        private Boolean forceJmDNS;
        private GetPositionSetting getPositionSetting;
        private GetStateSetting getStateSetting;
        private boolean hasInitByteSync;
        private IHostAddressAdapter hostAddressAdapter;
        private Map<String, String> identityMap;
        private String installId;
        private String lelinkAppId;
        private String lelinkAppSecret;
        private ILibraryLoader libraryLoader;
        private String licensePath;
        private String localProtocols;
        private ILogger logger;
        private IMonitor monitor;
        private IHttpNetWork netAdapter;
        private String overseasGrayConfigDomain;
        private ArrayList<String> overseasMonitorConfigUrls;
        private String overseasTokenDomain;
        private String privateChannel;
        private PrivateStateConfig privateStateConfig;
        private String projectId;
        private String pullConfigDomain;
        private int serviceId;
        private String serviceName;
        private ISinkDataListener sinkDataListener;
        private String smartViewReceiverId;
        private boolean startUsbServer;
        private boolean stopDlnaSearchWithoutClearingDevices;
        private String userId;
        private String webOSAppId;
        private IWifiAdapter wifiAdapter;
        private Object wsChannelService;

        public Config build() {
            Config r100 = new Config();
            Config.access$002(r100, this.appId);
            Config.access$102(r100, this.appSecret);
            Config.access$202(r100, this.deviceId);
            Config.access$302(r100, this.projectId);
            Config.access$402(r100, this.enableDebug);
            Config.access$502(r100, this.monitor);
            Config.access$602(r100, this.logger);
            Config.access$702(r100, this.libraryLoader);
            Config.access$802(r100, this.hostAddressAdapter);
            Config.access$902(r100, this.audioRecordAdapter);
            Config.access$1002(r100, this.cameraAdapter);
            Config.access$1102(r100, this.wifiAdapter);
            Config.access$1202(r100, this.netAdapter);
            Config.access$1302(r100, this.experiment);
            Config.access$1402(r100, this.lelinkAppId);
            Config.access$1502(r100, this.lelinkAppSecret);
            Config.access$1602(r100, this.smartViewReceiverId);
            Config.access$1702(r100, this.privateChannel);
            Config.access$1802(r100, this.bdlinkDiskCacheDetectIntervalMills);
            Config.access$1902(r100, this.bdlinkSinkMessageTimeout);
            Config.access$2002(r100, this.enableBdlinkSinkLinkLocalIPv6);
            Config.access$2102(r100, this.enableBdlinkSourceMdnsIpv6);
            Config.access$2202(r100, this.enableBdlinkMultipleIpCorrect);
            Config.access$2302(r100, this.dlnaXMLParserKeys);
            Config.access$2402(r100, this.dlnaSetManufacturer);
            Config.access$2502(r100, new WeakReference(this.commonDataListener));
            Config.access$2602(r100, new WeakReference(this.sinkDataListener));
            Config.access$2702(r100, new WeakReference(this.appStateListener));
            Config.access$2802(r100, this.enableFileLog);
            Config.access$2902(r100, this.autoPlayAudio);
            Config.access$3002(r100, this.enableCallbackData);
            Config.access$3102(r100, this.enableCallbackPcm);
            Config.access$3202(r100, this.enablePlaying);
            Config.access$3302(r100, this.enableAudioPlaying);
            Config.access$3402(r100, this.aesKey);
            Config.access$3502(r100, this.enableVideoNativeDecode);
            Config.access$3602(r100, this.startUsbServer);
            Config.access$3702(r100, this.chromeCastId);
            Config.access$3802(r100, this.disconnectReason);
            Config.access$3902(r100, this.connectTimeout);
            Config.access$4002(r100, this.wsChannelService);
            Config.access$4102(r100, this.channelId);
            Config.access$4202(r100, this.aId);
            Config.access$4302(r100, this.installId);
            Config.access$4402(r100, this.serviceId);
            Config.access$4502(r100, this.hasInitByteSync);
            Config.access$4602(r100, this.localProtocols);
            Config.access$4702(r100, this.licensePath);
            Config.access$4802(r100, this.forceDnssd);
            Config.access$4902(r100, this.forceJmDNS);
            Config.access$5002(r100, this.enableBLE);
            Config.access$5102(r100, this.enableDLNACache);
            Config.access$5202(r100, this.enableDLNASearch);
            Config.access$5302(r100, this.enableDLNABroadCast);
            Config.access$5402(r100, this.enableBDLinkSinkBroadcast);
            Config.access$5502(r100, this.enableBDLinkSourceBroadcast);
            Config.access$5602(r100, this.enableBDLinkSSDPSwitch);
            Config.access$5702(r100, this.enableBDLinkSinkSSDPSwitch);
            Config.access$5802(r100, this.enableBDLinkSSDPCycleSearch);
            Config.access$5900(r100, this.bindSdkInfoListeners);
            Config.access$6002(r100, this.deviceOfflineDetectSettings);
            Config.access$6102(r100, this.enableWifiP2PSearch);
            Config.access$6202(r100, this.enableClearCurrentIpWhenNetLost);
            Config.access$6302(r100, this.enableDlnaNewDeviceOffline);
            Config.access$6402(r100, this.serviceName);
            Config.access$6502(r100, this.enableDlnaSourceCustomizedService);
            Config.access$6602(r100, this.enableDlnaSinkCustomizedService);
            Config.access$6702(r100, this.overseasTokenDomain);
            Config.access$6802(r100, this.overseasGrayConfigDomain);
            Config.access$6902(r100, this.overseasMonitorConfigUrls);
            Config.access$7002(r100, this.userId);
            Config.access$7102(r100, this.dlnaSinkNotifyInterval);
            Config.access$7202(r100, this.dlnaLowPerformanceMode);
            Config.access$7302(r100, this.dlnaCycleSearchSettings);
            Config.access$7402(r100, this.enableFindDeviceByName);
            Config.access$7502(r100, this.dlnaDetectDeviceMode);
            Config.access$7602(r100, this.enableNewSeekLogic);
            Config.access$7702(r100, this.getStateSetting);
            Config.access$7802(r100, this.identityMap);
            Config.access$7902(r100, this.disPlayTypeList);
            Config.access$8002(r100, this.dialAppName);
            Config.access$8102(r100, this.webOSAppId);
            Config.access$8202(r100, this.dlnaUpnpErrorRepushSetting);
            Config.access$8302(r100, this.enableSinkDlnaUdpBroadcast);
            Config.access$8402(r100, this.getPositionSetting);
            Config.access$8502(r100, this.stopDlnaSearchWithoutClearingDevices);
            Config.access$8602(r100, this.pullConfigDomain);
            Config.access$8702(r100, this.privateStateConfig);
            Config.access$8802(r100, this.enableBdLePrivateProtocol);
            Config.access$8902(r100, this.enableAddEncryptShell);
            Config.access$9002(r100, this.cryptoMode);
            Config.access$9102(r100, this.enablePrivateProtPlayOpt);
            Config.access$9202(r100, this.connectStatusSetting);
            Config.access$9302(r100, this.enableDlnaUserAgent);
            return r100;
        }

        public Builder() {
            this.enableClearCurrentIpWhenNetLost = true;
            this.connectTimeout = 20;
            this.bdlinkDiskCacheDetectIntervalMills = 15000;
            this.enableBdlinkSourceMdnsIpv6 = false;
            this.enableBdlinkMultipleIpCorrect = false;
            this.bdlinkSinkMessageTimeout = 5000;
            this.enableBdlinkSinkLinkLocalIPv6 = false;
            this.dlnaSinkNotifyInterval = 0;
            this.dlnaLowPerformanceMode = false;
            this.enableFindDeviceByName = true;
            this.dlnaDetectDeviceMode = 0;
            this.enableNewSeekLogic = false;
            this.enableSinkDlnaUdpBroadcast = false;
            this.stopDlnaSearchWithoutClearingDevices = false;
            this.enableDlnaUserAgent = false;
            this.enableBdLePrivateProtocol = true;
            this.enableAddEncryptShell = true;
            this.cryptoMode = 1;
            this.enablePrivateProtPlayOpt = false;
        }

        public Builder addBindSdkInfoListener(IBindSdkInfoListener r100) {
            if (this.bindSdkInfoListeners != null) goto L5;
            this.bindSdkInfoListeners = new ArrayList();
        L5:
            this.bindSdkInfoListeners.add(r100);
            return this;
        }

        public Builder enableAudioPlaying(boolean r100) {
            this.enableAudioPlaying = r100;
            return this;
        }

        public Builder enableAutoPlayAudio(boolean r100) {
            this.autoPlayAudio = r100;
            return this;
        }

        public Builder enableBDLinkSSDPCycleSearch(Boolean r100) {
            this.enableBDLinkSSDPCycleSearch = r100;
            return this;
        }

        public Builder enableBDLinkSSDPSwitch(Boolean r100) {
            this.enableBDLinkSSDPSwitch = r100;
            return this;
        }

        public Builder enableBDLinkSinkBroadCast(Boolean r100) {
            this.enableBDLinkSinkBroadcast = r100;
            return this;
        }

        public Builder enableBDLinkSinkLinkLocalIPv6(boolean r100) {
            this.enableBdlinkSinkLinkLocalIPv6 = r100;
            return this;
        }

        public Builder enableBDLinkSinkSSDPSwitch(Boolean r100) {
            this.enableBDLinkSinkSSDPSwitch = r100;
            return this;
        }

        public Builder enableBDLinkSourceBroadCast(Boolean r100) {
            this.enableBDLinkSourceBroadcast = r100;
            return this;
        }

        public Builder enableBDLinkSourceMdnsIPv6(boolean r100) {
            this.enableBdlinkSourceMdnsIpv6 = r100;
            return this;
        }

        public Builder enableBLE(Boolean r100) {
            this.enableBLE = r100;
            return this;
        }

        public Builder enableBdlinkMultipleIpCorrect(boolean r100) {
            this.enableBdlinkMultipleIpCorrect = r100;
            return this;
        }

        public Builder enableCallbackMediaStream(boolean r100) {
            this.enableCallbackData = r100;
            return this;
        }

        public Builder enableCallbackPcm(boolean r100) {
            this.enableCallbackPcm = r100;
            return this;
        }

        public Builder enableClearCurrentIpWhenNetLost(boolean r100) {
            this.enableClearCurrentIpWhenNetLost = r100;
            return this;
        }

        public Builder enableDLNABroadCast(Boolean r100) {
            this.enableDLNABroadCast = r100;
            return this;
        }

        public Builder enableDLNACache(Boolean r100) {
            this.enableDLNACache = r100;
            return this;
        }

        public Builder enableDLNASearch(Boolean r100) {
            this.enableDLNASearch = r100;
            return this;
        }

        public Builder enableDebug(boolean r100) {
            this.enableDebug = r100;
            return this;
        }

        public Builder enableFileLog(boolean r100) {
            this.enableFileLog = r100;
            return this;
        }

        public Builder enableForceDnssd(Boolean r100) {
            this.forceDnssd = r100;
            return this;
        }

        public Builder enableForceJmDNS(Boolean r100) {
            this.forceJmDNS = r100;
            return this;
        }

        public Builder enablePlaying(boolean r100) {
            this.enablePlaying = r100;
            return this;
        }

        public Builder enableStartUsbServer(boolean r100) {
            this.startUsbServer = r100;
            return this;
        }

        public Builder enableVideoNativeDecode(boolean r100) {
            this.enableVideoNativeDecode = r100;
            return this;
        }

        public Builder enableWifiP2P(boolean r100) {
            this.enableWifiP2PSearch = r100;
            return this;
        }

        public Builder modifyOverseasGrayConfigDomain(String r100) {
            this.overseasGrayConfigDomain = r100;
            UrlUtils.setGrayConfigDomain(r100);
            return this;
        }

        public Builder modifyOverseasMonitorConfigUrls(ArrayList<String> r100) {
            this.overseasMonitorConfigUrls = r100;
            UrlUtils.setDefaultMonitorConfigUrl(r100);
            return this;
        }

        public Builder modifyOverseasTokenDomain(String r100) {
            this.overseasTokenDomain = r100;
            UrlUtils.modifyOverseasTokenDomain(r100);
            return this;
        }

        public Builder setAesKey(String r100) {
            this.aesKey = r100;
            return this;
        }

        public Builder setAppCommonDataListener(IAppCommonDataListener r100) {
            this.commonDataListener = r100;
            return this;
        }

        public Builder setAppId(String r100) {
            this.appId = r100;
            return this;
        }

        public Builder setAppSecret(String r100) {
            this.appSecret = r100;
            return this;
        }

        public Builder setAppStateListener(IAppStateListener r100) {
            this.appStateListener = r100;
            return this;
        }

        public Builder setAudioRecordAdapter(IAudioRecordAdapter r100) {
            this.audioRecordAdapter = r100;
            return this;
        }

        public Builder setBDLinkDiskCacheDetectIntervalMills(long r100) {
            this.bdlinkDiskCacheDetectIntervalMills = r100;
            return this;
        }

        public Builder setBDLinkSinkMessageTimeout(int r100) {
            this.bdlinkSinkMessageTimeout = r100;
            return this;
        }

        public Builder setCameraAdapter(ICameraAdapter r100) {
            this.cameraAdapter = r100;
            return this;
        }

        public Builder setChannelId(int r100) {
            this.channelId = r100;
            return this;
        }

        public Builder setChromeCastId(String r100) {
            this.chromeCastId = r100;
            return this;
        }

        public Builder setConnectStatusSetting(ConnectStatusSetting r100) {
            this.connectStatusSetting = r100;
            return this;
        }

        public Builder setConnectTimeout(int r100) {
            this.connectTimeout = r100;
            return this;
        }

        public Builder setCryptoMode(int r100) {
            this.cryptoMode = r100;
            return this;
        }

        public Builder setDeviceId(String r100) {
            this.deviceId = r100;
            return this;
        }

        public Builder setDeviceMac(String r100) {
            return addDeviceIdentity("mac", r100);
        }

        public Builder setDeviceOfflineDetectSettings(DeviceOfflineDetectSettings r100) {
            this.deviceOfflineDetectSettings = r100;
            return this;
        }

        public Builder setDeviceSn(String r100) {
            return addDeviceIdentity("sn", r100);
        }

        public Builder setDialAppName(String r100) {
            this.dialAppName = r100;
            return this;
        }

        public Builder setDisPlayTypes(DisPlayType[] r100) {
            this.disPlayTypeList = r100;
            return this;
        }

        public Builder setDisconnectReason(int r100) {
            this.disconnectReason = r100;
            return this;
        }

        public Builder setDlnaCycleSearchSettings(DlnaCycleSearchSettings r100) {
            this.dlnaCycleSearchSettings = r100;
            return this;
        }

        public Builder setDlnaDetectDeviceMode(int r100) {
            this.dlnaDetectDeviceMode = r100;
            return this;
        }

        public Builder setDlnaLowPerformanceMode(boolean r100) {
            this.dlnaLowPerformanceMode = r100;
            return this;
        }

        public Builder setDlnaSetManufacturer(String r100) {
            this.dlnaSetManufacturer = r100;
            return this;
        }

        public Builder setDlnaSinkNotifyInterval(int r100) {
            this.dlnaSinkNotifyInterval = r100;
            return this;
        }

        public Builder setDlnaUpnpErrorRepushSetting(DlnaUpnpErrorRepushSetting r100) {
            this.dlnaUpnpErrorRepushSetting = r100;
            return this;
        }

        public Builder setDlnaXMLParserKeys(String r100) {
            this.dlnaXMLParserKeys = r100;
            return this;
        }

        public Builder setEnableAddEncryptShell(boolean r100) {
            this.enableAddEncryptShell = r100;
            return this;
        }

        public Builder setEnableBdLePrivateProtocol(boolean r100) {
            this.enableBdLePrivateProtocol = r100;
            return this;
        }

        public Builder setEnableDlnaNewDeviceOffline(Boolean r100) {
            this.enableDlnaNewDeviceOffline = r100;
            return this;
        }

        public Builder setEnableDlnaSinkCustomizedService(Boolean r100) {
            this.enableDlnaSinkCustomizedService = r100;
            return this;
        }

        public Builder setEnableDlnaSourceCustomizedService(Boolean r100) {
            this.enableDlnaSourceCustomizedService = r100;
            return this;
        }

        public Builder setEnableDlnaUserAgent(boolean r100) {
            this.enableDlnaUserAgent = r100;
            return this;
        }

        public Builder setEnableFindDeviceByName(boolean r100) {
            this.enableFindDeviceByName = r100;
            return this;
        }

        public Builder setEnableNewSeekLogic(boolean r100) {
            this.enableNewSeekLogic = r100;
            return this;
        }

        public Builder setEnablePrivateProtPlayOpt(boolean r100) {
            this.enablePrivateProtPlayOpt = r100;
            return this;
        }

        public Builder setEnableSinkDlnaUdpBroadcast(boolean r100) {
            this.enableSinkDlnaUdpBroadcast = r100;
            return this;
        }

        public Builder setExperiment(IExperiment r100) {
            this.experiment = r100;
            return this;
        }

        public Builder setGetPositionSetting(GetPositionSetting r100) {
            this.getPositionSetting = r100;
            return this;
        }

        public Builder setGetStateSetting(GetStateSetting r100) {
            this.getStateSetting = r100;
            return this;
        }

        public Builder setHasInitByteSync(boolean r100) {
            this.hasInitByteSync = r100;
            return this;
        }

        public Builder setHostAddressAdapter(IHostAddressAdapter r100) {
            this.hostAddressAdapter = r100;
            return this;
        }

        public Builder setInstallId(String r100) {
            this.installId = r100;
            return this;
        }

        public Builder setLelinkAppId(String r100) {
            this.lelinkAppId = r100;
            return this;
        }

        public Builder setLelinkAppSecret(String r100) {
            this.lelinkAppSecret = r100;
            return this;
        }

        public Builder setLibraryLoader(ILibraryLoader r100) {
            this.libraryLoader = r100;
            return this;
        }

        public Builder setLicensePath(String r100) {
            this.licensePath = r100;
            return this;
        }

        public Builder setLocalProtocols(String r100) {
            this.localProtocols = r100;
            return this;
        }

        public Builder setLogger(ILogger r100) {
            this.logger = r100;
            return this;
        }

        public Builder setMonitor(IMonitor r100) {
            this.monitor = r100;
            return this;
        }

        public Builder setNetAdapter(IHttpNetWork r100) {
            this.netAdapter = r100;
            return this;
        }

        public Builder setPrivateChannel(String r100) {
            this.privateChannel = r100;
            return this;
        }

        public Builder setPrivateStateConfig(PrivateStateConfig r100) {
            this.privateStateConfig = r100;
            return this;
        }

        public Builder setProjectId(String r100) {
            this.projectId = r100;
            return this;
        }

        public Builder setPullConfigDomain(String r100) {
            this.pullConfigDomain = r100;
            return this;
        }

        public Builder setServiceId(int r100) {
            this.serviceId = r100;
            return this;
        }

        public Builder setServiceName(String r100) {
            this.serviceName = r100;
            return this;
        }

        public Builder setSinkDataListener(ISinkDataListener r100) {
            this.sinkDataListener = r100;
            return this;
        }

        public Builder setSmartViewReceiverId(String r100) {
            this.smartViewReceiverId = r100;
            return this;
        }

        public Builder setStopDlnaSearchWithoutClearingDevices(boolean r100) {
            this.stopDlnaSearchWithoutClearingDevices = r100;
            return this;
        }

        public Builder setUserId(String r100) {
            this.userId = r100;
            return this;
        }

        public Builder setWebOSAppId(String r100) {
            this.webOSAppId = r100;
            return this;
        }

        public Builder setWifiAdapter(IWifiAdapter r100) {
            this.wifiAdapter = r100;
            return this;
        }

        public Builder setWsChannelService(Object r100) {
            this.wsChannelService = r100;
            return this;
        }

        public Builder setaId(String r100) {
            this.aId = r100;
            return this;
        }

        public Builder addDeviceIdentity(String r100, String r101) {
            if (this.identityMap != null) goto L6;
            this.identityMap = new TreeMap();
        L6:
            if (TextUtils.isEmpty(r100) == false) goto L8;
        L10:
            return this;
        L8:
            if (TextUtils.isEmpty(r101) == true) goto L10;
            this.identityMap.put(r100, r101);
            goto L10
        }
    }

    public String getAppId() {
        if (TextUtils.isEmpty(this.appId) == false) goto L6;
        return Constants.DEMO_HOST_AID;
    L6:
        return this.appId;
    }

    public IAppStateListener getAppStateListener() {
        WeakReference<IAppStateListener> r100 = this.appStateListenerRef;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    public List<IBindSdkInfoListener> getBindSdkInfoListeners() {
        ArrayList r100 = new ArrayList();
        List<WeakReference<IBindSdkInfoListener>> r101 = this.bindSdkInfoListenerRefs;
        if (r101 != null) goto L5;
    L16:
        return r100;
    L5:
        if (r101.size() <= 0) goto L16;
        Iterator<WeakReference<IBindSdkInfoListener>> r102 = this.bindSdkInfoListenerRefs.iterator();
    L8:
        if (r102.hasNext() == false) goto L16;
        WeakReference<IBindSdkInfoListener> r103 = r102.next();
        if (r103 == null) goto L8;
        IBindSdkInfoListener r104 = r103.get();
        if (r104 == null) goto L8;
        r100.add(r104);
        goto L8
    }

    public IAppCommonDataListener getCommonDataListener() {
        WeakReference<IAppCommonDataListener> r100 = this.commonDataListenerRef;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    public String getDeviceId() {
        String r100 = this.deviceId;
        if (TextUtils.isEmpty(r100) == true) goto L7;
        if (PreferenceUtils.isByteUserToB() == true) goto L7;
        return r100;
    L7:
        return getToBDid();
    }

    public ISinkDataListener getSinkDataListener() {
        WeakReference<ISinkDataListener> r100 = this.sinkDataListenerRef;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    public String getToBDid() {
        if (TextUtils.isEmpty(this.toBDid) == false) goto L5;
    L6:
        this.toBDid = PreferenceUtils.getToBCastDid("1234567890", this.mCastContext);
    L8:
        return this.toBDid;
    L5:
        if (TextUtils.equals("1234567890", this.toBDid) == false) goto L8;
        goto L6
    }

    public String toString() {
        return "Config[deviceId: " + this.deviceId + ", projectId: " + this.projectId + ", isInitialModeBind: " + this.isInitialModeBind + ", enableDebug: " + this.enableDebug + ", startUsbServer: " + this.startUsbServer + ", localProtocols: " + this.localProtocols + ", chromeCastId: " + this.chromeCastId + ", disconnectReason: " + this.disconnectReason + ", connectTimeout: " + this.connectTimeout + ", localProtocols: " + this.localProtocols + ", licensePath: " + this.licensePath + ", lelinkAppId: " + this.lelinkAppId + ", lelinkAppSecret: " + this.lelinkAppSecret + ", smartViewReceiverId: " + this.smartViewReceiverId + ", privateChannel: " + this.privateChannel + ", bdlinkSinkMessageTimeout: " + this.bdlinkSinkMessageTimeout + ", enableBdlinkSinkLinkLocalIPv6: " + this.enableBdlinkSinkLinkLocalIPv6 + ", enableBdlinkSourceMdnsIpv6: " + this.enableBdlinkSourceMdnsIpv6 + ", enableBdlinkMultipleIpCorrect: " + this.enableBdlinkMultipleIpCorrect + ", dlnaXMLParserKeys: " + this.dlnaXMLParserKeys + ", dlnaSetManufacturer: " + this.dlnaSetManufacturer + ", enableFileLog: " + this.enableFileLog + ", autoPlayAudio: " + this.autoPlayAudio + ", enableCallbackData: " + this.enableCallbackData + ", enableCallbackPcm: " + this.enableCallbackPcm + ", enablePlaying: " + this.enablePlaying + ", enableAudioPlaying: " + this.enableAudioPlaying + ", aesKey: " + this.aesKey + ", enableVideoNativeDecode: " + this.enableVideoNativeDecode + ", appId: " + this.appId + ", appSecret: " + this.appSecret + ", forceDnssd: " + this.forceDnssd + ", forceJmDNS: " + this.forceJmDNS + ", enableBLE: " + this.enableBLE + ", enableDLNACache: " + this.enableDLNACache + ", enableDLNASearch: " + this.enableDLNASearch + ", enableDLNABroadCast: " + this.enableDLNABroadCast + ", enableBDLinkSinkBroadcast: " + this.enableBDLinkSinkBroadcast + ", enableBDLinkSourceBroadcast: " + this.enableBDLinkSourceBroadcast + ", enableBDLinkSSDPSwitch: " + this.enableBDLinkSSDPSwitch + ", enableBDLinkSinkSSDPSwitch: " + this.enableBDLinkSinkSSDPSwitch + ", enableBDLinkSSDPCycleSearch: " + this.enableBDLinkSSDPCycleSearch + ", deviceOfflineDetectSettings: " + this.deviceOfflineDetectSettings + ", enableWifiP2PSearch: " + this.enableWifiP2PSearch + ", enableClearCurrentIpWhenNetLost: " + this.enableClearCurrentIpWhenNetLost + ", enableDlnaNewDeviceOffline: " + this.enableDlnaNewDeviceOffline + ", overseasTokenDomain: " + this.overseasTokenDomain + ", overseasGrayConfigDomain: " + this.overseasGrayConfigDomain + ", overseasMonitorConfigUrls: " + this.overseasMonitorConfigUrls + ", enableDlnaSourceCustomizedService: " + this.enableDlnaSourceCustomizedService + ", enableDlnaSinkCustomizedService: " + this.enableDlnaSinkCustomizedService + ", identityMap: " + this.identityMap + ", dlnaSinkNotifyInterval: " + this.dlnaSinkNotifyInterval + ", dlnaLowPerformanceMode: " + this.dlnaLowPerformanceMode + ", dlnaCycleSearchSettings: " + this.dlnaCycleSearchSettings + ", enableFindDeviceByName: " + this.enableFindDeviceByName + ", dlnaDetectDeviceMode: " + this.dlnaDetectDeviceMode + ", enableNewSeekLogic: " + this.enableNewSeekLogic + ", getStateSetting: " + this.getStateSetting + ", dlnaUpnpErrorRepushSetting: " + this.dlnaUpnpErrorRepushSetting + ", enableSinkDlnaUdpBroadcast: " + this.enableSinkDlnaUdpBroadcast + ", pullConfigDomain: " + this.pullConfigDomain + ", cryptoMode: " + this.cryptoMode + "]";
    }

    public Config() {
        this.enableClearCurrentIpWhenNetLost = true;
        this.enableBdlinkSourceMdnsIpv6 = false;
        this.enableBdlinkMultipleIpCorrect = false;
        this.bdlinkSinkMessageTimeout = 5000;
        this.enableBdlinkSinkLinkLocalIPv6 = false;
        this.dlnaSinkNotifyInterval = 0;
        this.dlnaLowPerformanceMode = false;
        this.enableFindDeviceByName = false;
        this.dlnaDetectDeviceMode = 0;
        this.enableNewSeekLogic = false;
        this.enableSinkDlnaUdpBroadcast = false;
        this.stopDlnaSearchWithoutClearingDevices = false;
        this.enableDlnaUserAgent = false;
        this.enableBdLePrivateProtocol = false;
        this.enableAddEncryptShell = true;
        this.enablePrivateProtPlayOpt = false;
        this.cryptoMode = 1;
    }

    public String getAesKey() {
        return this.aesKey;
    }

    public String getAppSecret() {
        return this.appSecret;
    }

    public IAudioRecordAdapter getAudioRecordAdapter() {
        return this.audioRecordAdapter;
    }

    public long getBDLinkDiskCacheDetectIntervalMills() {
        return this.bdlinkDiskCacheDetectIntervalMills;
    }

    public int getBdlinkSinkMessageTimeout() {
        return this.bdlinkSinkMessageTimeout;
    }

    public ICameraAdapter getCameraAdapter() {
        return this.cameraAdapter;
    }

    public int getChannelId() {
        return this.channelId;
    }

    public String getChromeCastId() {
        return this.chromeCastId;
    }

    public ConnectStatusSetting getConnectStatusSetting() {
        return this.connectStatusSetting;
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public int getCryptoMode() {
        return this.cryptoMode;
    }

    public DeviceOfflineDetectSettings getDeviceOfflineDetectSettings() {
        return this.deviceOfflineDetectSettings;
    }

    public String getDialAppName() {
        return this.dialAppName;
    }

    public DisPlayType[] getDisPlayTypes() {
        return this.disPlayTypeList;
    }

    public int getDisconnectReason() {
        return this.disconnectReason;
    }

    public DlnaCycleSearchSettings getDlnaCycleSearchSettings() {
        return this.dlnaCycleSearchSettings;
    }

    public int getDlnaDetectDeviceMode() {
        return this.dlnaDetectDeviceMode;
    }

    public boolean getDlnaLowPerformanceMode() {
        return this.dlnaLowPerformanceMode;
    }

    public String getDlnaSetManufacturer() {
        return this.dlnaSetManufacturer;
    }

    public int getDlnaSinkNotifyInterval() {
        return this.dlnaSinkNotifyInterval;
    }

    public DlnaUpnpErrorRepushSetting getDlnaUpnpErrorRepushSetting() {
        return this.dlnaUpnpErrorRepushSetting;
    }

    public String getDlnaXMLParserKeys() {
        return this.dlnaXMLParserKeys;
    }

    public IExperiment getExperiment() {
        return this.experiment;
    }

    public GetPositionSetting getGetPositionSetting() {
        return this.getPositionSetting;
    }

    public GetStateSetting getGetStateSetting() {
        return this.getStateSetting;
    }

    public IHostAddressAdapter getHostAddressAdapter() {
        return this.hostAddressAdapter;
    }

    public Map<String, String> getIdentityMap() {
        return this.identityMap;
    }

    public String getInstallId() {
        return this.installId;
    }

    public String getLelinkAppId() {
        return this.lelinkAppId;
    }

    public String getLelinkAppSecret() {
        return this.lelinkAppSecret;
    }

    public ILibraryLoader getLibraryLoader() {
        return this.libraryLoader;
    }

    public String getLicensePath() {
        return this.licensePath;
    }

    public String getLocalProtocols() {
        return this.localProtocols;
    }

    public ILogger getLogger() {
        return this.logger;
    }

    public IMonitor getMonitor() {
        return this.monitor;
    }

    public IHttpNetWork getNetAdapter() {
        return this.netAdapter;
    }

    public String getOriginDeviceId() {
        return this.deviceId;
    }

    public String getPrivateChannel() {
        return this.privateChannel;
    }

    public PrivateStateConfig getPrivateStateConfig() {
        return this.privateStateConfig;
    }

    public String getProjectId() {
        return this.projectId;
    }

    public String getPullConfigDomain() {
        return this.pullConfigDomain;
    }

    public int getServiceId() {
        return this.serviceId;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public String getSmartViewReceiverId() {
        return this.smartViewReceiverId;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getWebOSAppId() {
        return this.webOSAppId;
    }

    public IWifiAdapter getWifiAdapter() {
        return this.wifiAdapter;
    }

    public Object getWsChannelService() {
        return this.wsChannelService;
    }

    public String getaId() {
        return this.aId;
    }

    public boolean isAutoPlayAudio() {
        return this.autoPlayAudio;
    }

    public boolean isEnableAddEncryptShell() {
        return this.enableAddEncryptShell;
    }

    public boolean isEnableAudioPlaying() {
        return this.enableAudioPlaying;
    }

    public Boolean isEnableBDLinkSSDPCycleSearch() {
        return this.enableBDLinkSSDPCycleSearch;
    }

    public Boolean isEnableBDLinkSSDPSwitch() {
        return this.enableBDLinkSSDPSwitch;
    }

    public Boolean isEnableBDLinkSinkBroadcast() {
        return this.enableBDLinkSinkBroadcast;
    }

    public Boolean isEnableBDLinkSinkSSDPSwitch() {
        return this.enableBDLinkSinkSSDPSwitch;
    }

    public Boolean isEnableBDLinkSourceBroadcast() {
        return this.enableBDLinkSourceBroadcast;
    }

    public Boolean isEnableBLE() {
        return this.enableBLE;
    }

    public boolean isEnableBdLePrivateProtocol() {
        return this.enableBdLePrivateProtocol;
    }

    public boolean isEnableBdlinkMultipleIpCorrect() {
        return this.enableBdlinkMultipleIpCorrect;
    }

    public boolean isEnableBdlinkSinkLinkLocalIPv6() {
        return this.enableBdlinkSinkLinkLocalIPv6;
    }

    public boolean isEnableBdlinkSourceMdnsIpv6() {
        return this.enableBdlinkSourceMdnsIpv6;
    }

    public boolean isEnableCallbackData() {
        return this.enableCallbackData;
    }

    public boolean isEnableCallbackPcm() {
        return this.enableCallbackPcm;
    }

    public boolean isEnableClearCurrentIpWhenNetLost() {
        return this.enableClearCurrentIpWhenNetLost;
    }

    public Boolean isEnableDLNABroadCast() {
        return this.enableDLNABroadCast;
    }

    public Boolean isEnableDLNACache() {
        return this.enableDLNACache;
    }

    public Boolean isEnableDLNASearch() {
        return this.enableDLNASearch;
    }

    public boolean isEnableDebug() {
        return this.enableDebug;
    }

    public Boolean isEnableDlnaSinkCustomizedService() {
        return this.enableDlnaSinkCustomizedService;
    }

    public Boolean isEnableDlnaSourceCustomizedService() {
        return this.enableDlnaSourceCustomizedService;
    }

    public boolean isEnableDlnaUserAgent() {
        return this.enableDlnaUserAgent;
    }

    public boolean isEnableFileLog() {
        return this.enableFileLog;
    }

    public boolean isEnableFindDeviceByName() {
        return this.enableFindDeviceByName;
    }

    public Boolean isEnableNewDlnaDeviceOffline() {
        return this.enableDlnaNewDeviceOffline;
    }

    public boolean isEnableNewSeekLogic() {
        return this.enableNewSeekLogic;
    }

    public boolean isEnablePlaying() {
        return this.enablePlaying;
    }

    public boolean isEnablePrivateProtPlayOpt() {
        return this.enablePrivateProtPlayOpt;
    }

    public boolean isEnableSinkDlnaUdpBroadcast() {
        return this.enableSinkDlnaUdpBroadcast;
    }

    public boolean isEnableVideoNativeDecode() {
        return this.enableVideoNativeDecode;
    }

    public boolean isEnableWifiP2PSearch() {
        return this.enableWifiP2PSearch;
    }

    public Boolean isForceDnssd() {
        return this.forceDnssd;
    }

    public Boolean isForceJmDNS() {
        return this.forceJmDNS;
    }

    public boolean isHasInitByteSync() {
        return this.hasInitByteSync;
    }

    public boolean isInitialModeBind() {
        return this.isInitialModeBind;
    }

    public boolean isStartUsbServer() {
        return this.startUsbServer;
    }

    public boolean isStopDlnaSearchWithoutClearingDevices() {
        return this.stopDlnaSearchWithoutClearingDevices;
    }

    private void addBindSdkInfoListeners(List<IBindSdkInfoListener> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == true) goto L12;
        Iterator<IBindSdkInfoListener> r101 = r100.iterator();
    L8:
        if (r101.hasNext() == false) goto L13;
        addBindSdkInfoListener(r101.next());
        goto L8
    L13:
        return;
    }

    public void addBindSdkInfoListener(IBindSdkInfoListener r100) {
        if (this.bindSdkInfoListenerRefs != null) goto L5;
        this.bindSdkInfoListenerRefs = new ArrayList();
    L5:
        this.bindSdkInfoListenerRefs.add(new WeakReference(r100));
    }

    public void attachCastContext(ContextManager.CastContext r100) {
        this.mCastContext = r100;
    }

    public void enableWifiP2PSearch(boolean r100) {
        this.enableWifiP2PSearch = r100;
    }

    public void setAesKey(String r100) {
        this.aesKey = r100;
    }

    public void setAppId(String r100) {
        this.appId = r100;
    }

    public void setAppSecret(String r100) {
        this.appSecret = r100;
    }

    public void setAppStateListener(IAppStateListener r100) {
        this.appStateListenerRef = new WeakReference(r100);
    }

    public void setAudioRecordAdapter(IAudioRecordAdapter r100) {
        this.audioRecordAdapter = r100;
    }

    public void setAutoPlayAudio(boolean r100) {
        this.autoPlayAudio = r100;
    }

    public void setCameraAdapter(ICameraAdapter r100) {
        this.cameraAdapter = r100;
    }

    public void setChannelId(int r100) {
        this.channelId = r100;
    }

    public void setChromeCastId(String r100) {
        this.chromeCastId = r100;
    }

    public void setCommonDataListener(IAppCommonDataListener r100) {
        this.commonDataListenerRef = new WeakReference(r100);
    }

    public void setConnectTimeout(int r100) {
        this.connectTimeout = r100;
    }

    public void setDebugMode(boolean r100) {
        this.enableDebug = r100;
    }

    public void setDeviceId(String r100) {
        this.deviceId = r100;
    }

    public void setDeviceOfflineDetectSettings(DeviceOfflineDetectSettings r100) {
        this.deviceOfflineDetectSettings = r100;
    }

    public void setDisconnectReason(int r100) {
        this.disconnectReason = r100;
    }

    public void setDlnaSetManufacturer(String r100) {
        this.dlnaSetManufacturer = r100;
    }

    public void setDlnaXMLParserKeys(String r100) {
        this.dlnaXMLParserKeys = r100;
    }

    public void setEnableAudioPlaying(boolean r100) {
        this.enableAudioPlaying = r100;
    }

    public void setEnableBDLinkSSDPCycleSearch(Boolean r100) {
        this.enableBDLinkSSDPCycleSearch = r100;
    }

    public void setEnableBDLinkSSDPSwitch(Boolean r100) {
        this.enableBDLinkSSDPSwitch = r100;
    }

    public void setEnableBDLinkSinkBroadcast(Boolean r100) {
        this.enableBDLinkSinkBroadcast = r100;
    }

    public void setEnableBDLinkSinkSSDPSwitch(Boolean r100) {
        this.enableBDLinkSinkSSDPSwitch = r100;
    }

    public void setEnableBDLinkSourceBroadcast(Boolean r100) {
        this.enableBDLinkSourceBroadcast = r100;
    }

    public void setEnableBLE(Boolean r100) {
        this.enableBLE = r100;
    }

    public void setEnableCallbackData(boolean r100) {
        this.enableCallbackData = r100;
    }

    public void setEnableCallbackPcm(boolean r100) {
        this.enableCallbackPcm = r100;
    }

    public void setEnableClearCurrentIpWhenNetLost(boolean r100) {
        this.enableClearCurrentIpWhenNetLost = r100;
    }

    public void setEnableDLNABroadCast(Boolean r100) {
        this.enableDLNABroadCast = r100;
    }

    public void setEnableDLNACache(Boolean r100) {
        this.enableDLNACache = r100;
    }

    public void setEnableDLNASearch(Boolean r100) {
        this.enableDLNASearch = r100;
    }

    public void setEnableDlnaNewDeviceOffline(Boolean r100) {
        this.enableDlnaNewDeviceOffline = r100;
    }

    public void setEnableFileLog(boolean r100) {
        this.enableFileLog = r100;
    }

    public void setEnablePlaying(boolean r100) {
        this.enablePlaying = r100;
    }

    public void setEnableVideoNativeDecode(boolean r100) {
        this.enableVideoNativeDecode = r100;
    }

    public void setExperiment(IExperiment r100) {
        this.experiment = r100;
    }

    public void setForceDnssd(Boolean r100) {
        this.forceDnssd = r100;
    }

    public void setForceJmDNS(Boolean r100) {
        this.forceJmDNS = r100;
    }

    public void setGetStateSetting(GetStateSetting r100) {
        this.getStateSetting = r100;
    }

    public void setHasInitByteSync(boolean r100) {
        this.hasInitByteSync = r100;
    }

    public void setHostAddressAdapter(IHostAddressAdapter r100) {
        this.hostAddressAdapter = r100;
    }

    public void setInitialMode(boolean r100) {
        this.isInitialModeBind = r100;
    }

    public void setInstallId(String r100) {
        this.installId = r100;
    }

    public void setLelinkAppId(String r100) {
        this.lelinkAppId = r100;
    }

    public void setLelinkAppSecret(String r100) {
        this.lelinkAppSecret = r100;
    }

    public void setLibraryLoader(ILibraryLoader r100) {
        this.libraryLoader = r100;
    }

    public void setLocalProtocols(String r100) {
        this.localProtocols = r100;
    }

    public void setLogger(ILogger r100) {
        this.logger = r100;
    }

    public void setMonitor(IMonitor r100) {
        this.monitor = r100;
    }

    public void setNetAdapter(IHttpNetWork r100) {
        this.netAdapter = r100;
    }

    public void setPrivateChannel(String r100) {
        this.privateChannel = r100;
    }

    public void setProjectId(String r100) {
        this.projectId = r100;
    }

    public void setPullConfigDomain(String r100) {
        this.pullConfigDomain = r100;
    }

    public void setServiceId(int r100) {
        this.serviceId = r100;
    }

    public void setServiceName(String r100) {
        this.serviceName = r100;
    }

    public void setSinkDataListener(ISinkDataListener r100) {
        this.sinkDataListenerRef = new WeakReference(r100);
    }

    public void setSmartViewReceiverId(String r100) {
        this.smartViewReceiverId = r100;
    }

    public void setStartUsbServer(boolean r100) {
        this.startUsbServer = r100;
    }

    public void setWifiAdapter(IWifiAdapter r100) {
        this.wifiAdapter = r100;
    }

    public void setWsChannelService(Object r100) {
        this.wsChannelService = r100;
    }

    public void setaId(String r100) {
        this.aId = r100;
    }

    public static /* synthetic */ String access$002(Config r100, String r101) {
        r100.appId = r101;
        return r101;
    }

    public static /* synthetic */ ICameraAdapter access$1002(Config r100, ICameraAdapter r101) {
        r100.cameraAdapter = r101;
        return r101;
    }

    public static /* synthetic */ String access$102(Config r100, String r101) {
        r100.appSecret = r101;
        return r101;
    }

    public static /* synthetic */ IWifiAdapter access$1102(Config r100, IWifiAdapter r101) {
        r100.wifiAdapter = r101;
        return r101;
    }

    public static /* synthetic */ IHttpNetWork access$1202(Config r100, IHttpNetWork r101) {
        r100.netAdapter = r101;
        return r101;
    }

    public static /* synthetic */ IExperiment access$1302(Config r100, IExperiment r101) {
        r100.experiment = r101;
        return r101;
    }

    public static /* synthetic */ String access$1402(Config r100, String r101) {
        r100.lelinkAppId = r101;
        return r101;
    }

    public static /* synthetic */ String access$1502(Config r100, String r101) {
        r100.lelinkAppSecret = r101;
        return r101;
    }

    public static /* synthetic */ String access$1602(Config r100, String r101) {
        r100.smartViewReceiverId = r101;
        return r101;
    }

    public static /* synthetic */ String access$1702(Config r100, String r101) {
        r100.privateChannel = r101;
        return r101;
    }

    public static /* synthetic */ long access$1802(Config r100, long r101) {
        r100.bdlinkDiskCacheDetectIntervalMills = r101;
        return r101;
    }

    public static /* synthetic */ int access$1902(Config r100, int r101) {
        r100.bdlinkSinkMessageTimeout = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$2002(Config r100, boolean r101) {
        r100.enableBdlinkSinkLinkLocalIPv6 = r101;
        return r101;
    }

    public static /* synthetic */ String access$202(Config r100, String r101) {
        r100.deviceId = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$2102(Config r100, boolean r101) {
        r100.enableBdlinkSourceMdnsIpv6 = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$2202(Config r100, boolean r101) {
        r100.enableBdlinkMultipleIpCorrect = r101;
        return r101;
    }

    public static /* synthetic */ String access$2302(Config r100, String r101) {
        r100.dlnaXMLParserKeys = r101;
        return r101;
    }

    public static /* synthetic */ String access$2402(Config r100, String r101) {
        r100.dlnaSetManufacturer = r101;
        return r101;
    }

    public static /* synthetic */ WeakReference access$2502(Config r100, WeakReference r101) {
        r100.commonDataListenerRef = r101;
        return r101;
    }

    public static /* synthetic */ WeakReference access$2602(Config r100, WeakReference r101) {
        r100.sinkDataListenerRef = r101;
        return r101;
    }

    public static /* synthetic */ WeakReference access$2702(Config r100, WeakReference r101) {
        r100.appStateListenerRef = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$2802(Config r100, boolean r101) {
        r100.enableFileLog = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$2902(Config r100, boolean r101) {
        r100.autoPlayAudio = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$3002(Config r100, boolean r101) {
        r100.enableCallbackData = r101;
        return r101;
    }

    public static /* synthetic */ String access$302(Config r100, String r101) {
        r100.projectId = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$3102(Config r100, boolean r101) {
        r100.enableCallbackPcm = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$3202(Config r100, boolean r101) {
        r100.enablePlaying = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$3302(Config r100, boolean r101) {
        r100.enableAudioPlaying = r101;
        return r101;
    }

    public static /* synthetic */ String access$3402(Config r100, String r101) {
        r100.aesKey = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$3502(Config r100, boolean r101) {
        r100.enableVideoNativeDecode = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$3602(Config r100, boolean r101) {
        r100.startUsbServer = r101;
        return r101;
    }

    public static /* synthetic */ String access$3702(Config r100, String r101) {
        r100.chromeCastId = r101;
        return r101;
    }

    public static /* synthetic */ int access$3802(Config r100, int r101) {
        r100.disconnectReason = r101;
        return r101;
    }

    public static /* synthetic */ int access$3902(Config r100, int r101) {
        r100.connectTimeout = r101;
        return r101;
    }

    public static /* synthetic */ Object access$4002(Config r100, Object r101) {
        r100.wsChannelService = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$402(Config r100, boolean r101) {
        r100.enableDebug = r101;
        return r101;
    }

    public static /* synthetic */ int access$4102(Config r100, int r101) {
        r100.channelId = r101;
        return r101;
    }

    public static /* synthetic */ String access$4202(Config r100, String r101) {
        r100.aId = r101;
        return r101;
    }

    public static /* synthetic */ String access$4302(Config r100, String r101) {
        r100.installId = r101;
        return r101;
    }

    public static /* synthetic */ int access$4402(Config r100, int r101) {
        r100.serviceId = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$4502(Config r100, boolean r101) {
        r100.hasInitByteSync = r101;
        return r101;
    }

    public static /* synthetic */ String access$4602(Config r100, String r101) {
        r100.localProtocols = r101;
        return r101;
    }

    public static /* synthetic */ String access$4702(Config r100, String r101) {
        r100.licensePath = r101;
        return r101;
    }

    public static /* synthetic */ Boolean access$4802(Config r100, Boolean r101) {
        r100.forceDnssd = r101;
        return r101;
    }

    public static /* synthetic */ Boolean access$4902(Config r100, Boolean r101) {
        r100.forceJmDNS = r101;
        return r101;
    }

    public static /* synthetic */ Boolean access$5002(Config r100, Boolean r101) {
        r100.enableBLE = r101;
        return r101;
    }

    public static /* synthetic */ IMonitor access$502(Config r100, IMonitor r101) {
        r100.monitor = r101;
        return r101;
    }

    public static /* synthetic */ Boolean access$5102(Config r100, Boolean r101) {
        r100.enableDLNACache = r101;
        return r101;
    }

    public static /* synthetic */ Boolean access$5202(Config r100, Boolean r101) {
        r100.enableDLNASearch = r101;
        return r101;
    }

    public static /* synthetic */ Boolean access$5302(Config r100, Boolean r101) {
        r100.enableDLNABroadCast = r101;
        return r101;
    }

    public static /* synthetic */ Boolean access$5402(Config r100, Boolean r101) {
        r100.enableBDLinkSinkBroadcast = r101;
        return r101;
    }

    public static /* synthetic */ Boolean access$5502(Config r100, Boolean r101) {
        r100.enableBDLinkSourceBroadcast = r101;
        return r101;
    }

    public static /* synthetic */ Boolean access$5602(Config r100, Boolean r101) {
        r100.enableBDLinkSSDPSwitch = r101;
        return r101;
    }

    public static /* synthetic */ Boolean access$5702(Config r100, Boolean r101) {
        r100.enableBDLinkSinkSSDPSwitch = r101;
        return r101;
    }

    public static /* synthetic */ Boolean access$5802(Config r100, Boolean r101) {
        r100.enableBDLinkSSDPCycleSearch = r101;
        return r101;
    }

    public static /* synthetic */ void access$5900(Config r100, List r101) {
        r100.addBindSdkInfoListeners(r101);
    }

    public static /* synthetic */ DeviceOfflineDetectSettings access$6002(Config r100, DeviceOfflineDetectSettings r101) {
        r100.deviceOfflineDetectSettings = r101;
        return r101;
    }

    public static /* synthetic */ ILogger access$602(Config r100, ILogger r101) {
        r100.logger = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$6102(Config r100, boolean r101) {
        r100.enableWifiP2PSearch = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$6202(Config r100, boolean r101) {
        r100.enableClearCurrentIpWhenNetLost = r101;
        return r101;
    }

    public static /* synthetic */ Boolean access$6302(Config r100, Boolean r101) {
        r100.enableDlnaNewDeviceOffline = r101;
        return r101;
    }

    public static /* synthetic */ String access$6402(Config r100, String r101) {
        r100.serviceName = r101;
        return r101;
    }

    public static /* synthetic */ Boolean access$6502(Config r100, Boolean r101) {
        r100.enableDlnaSourceCustomizedService = r101;
        return r101;
    }

    public static /* synthetic */ Boolean access$6602(Config r100, Boolean r101) {
        r100.enableDlnaSinkCustomizedService = r101;
        return r101;
    }

    public static /* synthetic */ String access$6702(Config r100, String r101) {
        r100.overseasTokenDomain = r101;
        return r101;
    }

    public static /* synthetic */ String access$6802(Config r100, String r101) {
        r100.overseasGrayConfigDomain = r101;
        return r101;
    }

    public static /* synthetic */ ArrayList access$6902(Config r100, ArrayList r101) {
        r100.overseasMonitorConfigUrls = r101;
        return r101;
    }

    public static /* synthetic */ String access$7002(Config r100, String r101) {
        r100.userId = r101;
        return r101;
    }

    public static /* synthetic */ ILibraryLoader access$702(Config r100, ILibraryLoader r101) {
        r100.libraryLoader = r101;
        return r101;
    }

    public static /* synthetic */ int access$7102(Config r100, int r101) {
        r100.dlnaSinkNotifyInterval = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$7202(Config r100, boolean r101) {
        r100.dlnaLowPerformanceMode = r101;
        return r101;
    }

    public static /* synthetic */ DlnaCycleSearchSettings access$7302(Config r100, DlnaCycleSearchSettings r101) {
        r100.dlnaCycleSearchSettings = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$7402(Config r100, boolean r101) {
        r100.enableFindDeviceByName = r101;
        return r101;
    }

    public static /* synthetic */ int access$7502(Config r100, int r101) {
        r100.dlnaDetectDeviceMode = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$7602(Config r100, boolean r101) {
        r100.enableNewSeekLogic = r101;
        return r101;
    }

    public static /* synthetic */ GetStateSetting access$7702(Config r100, GetStateSetting r101) {
        r100.getStateSetting = r101;
        return r101;
    }

    public static /* synthetic */ Map access$7802(Config r100, Map r101) {
        r100.identityMap = r101;
        return r101;
    }

    public static /* synthetic */ DisPlayType[] access$7902(Config r100, DisPlayType[] r101) {
        r100.disPlayTypeList = r101;
        return r101;
    }

    public static /* synthetic */ String access$8002(Config r100, String r101) {
        r100.dialAppName = r101;
        return r101;
    }

    public static /* synthetic */ IHostAddressAdapter access$802(Config r100, IHostAddressAdapter r101) {
        r100.hostAddressAdapter = r101;
        return r101;
    }

    public static /* synthetic */ String access$8102(Config r100, String r101) {
        r100.webOSAppId = r101;
        return r101;
    }

    public static /* synthetic */ DlnaUpnpErrorRepushSetting access$8202(Config r100, DlnaUpnpErrorRepushSetting r101) {
        r100.dlnaUpnpErrorRepushSetting = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$8302(Config r100, boolean r101) {
        r100.enableSinkDlnaUdpBroadcast = r101;
        return r101;
    }

    public static /* synthetic */ GetPositionSetting access$8402(Config r100, GetPositionSetting r101) {
        r100.getPositionSetting = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$8502(Config r100, boolean r101) {
        r100.stopDlnaSearchWithoutClearingDevices = r101;
        return r101;
    }

    public static /* synthetic */ String access$8602(Config r100, String r101) {
        r100.pullConfigDomain = r101;
        return r101;
    }

    public static /* synthetic */ PrivateStateConfig access$8702(Config r100, PrivateStateConfig r101) {
        r100.privateStateConfig = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$8802(Config r100, boolean r101) {
        r100.enableBdLePrivateProtocol = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$8902(Config r100, boolean r101) {
        r100.enableAddEncryptShell = r101;
        return r101;
    }

    public static /* synthetic */ int access$9002(Config r100, int r101) {
        r100.cryptoMode = r101;
        return r101;
    }

    public static /* synthetic */ IAudioRecordAdapter access$902(Config r100, IAudioRecordAdapter r101) {
        r100.audioRecordAdapter = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$9102(Config r100, boolean r101) {
        r100.enablePrivateProtPlayOpt = r101;
        return r101;
    }

    public static /* synthetic */ ConnectStatusSetting access$9202(Config r100, ConnectStatusSetting r101) {
        r100.connectStatusSetting = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$9302(Config r100, boolean r101) {
        r100.enableDlnaUserAgent = r101;
        return r101;
    }
}
