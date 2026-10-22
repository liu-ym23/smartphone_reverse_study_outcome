package com.byted.cast.linkcommon.cybergarage.upnp;

import android.text.TextUtils;
import com.byted.cast.common.CastLogger;
import com.byted.cast.common.CastMonitor;
import com.byted.cast.common.CommandExecuteStatus;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.Dispatcher;
import com.byted.cast.common.ErrorCode;
import com.byted.cast.common.TeaEventTrack;
import com.byted.cast.common.Utils;
import com.byted.cast.common.threadpool.CastThreadExecutorsUtils;
import com.byted.cast.common.utils.DLNAOptionUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.byted.cast.linkcommon.cybergarage.http.HTTPRequest;
import com.byted.cast.linkcommon.cybergarage.http.HTTPRequestListener;
import com.byted.cast.linkcommon.cybergarage.http.HTTPServer;
import com.byted.cast.linkcommon.cybergarage.http.HTTPServerList;
import com.byted.cast.linkcommon.cybergarage.http.HTTPServerType;
import com.byted.cast.linkcommon.cybergarage.net.HostInterface;
import com.byted.cast.linkcommon.cybergarage.upnp.control.RenewSubscriber;
import com.byted.cast.linkcommon.cybergarage.upnp.device.DeviceChangeListener;
import com.byted.cast.linkcommon.cybergarage.upnp.device.Disposer;
import com.byted.cast.linkcommon.cybergarage.upnp.device.NotifyListener;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.byted.cast.linkcommon.cybergarage.upnp.device.SearchResponseListener;
import com.byted.cast.linkcommon.cybergarage.upnp.device.USN;
import com.byted.cast.linkcommon.cybergarage.upnp.event.CustomizedEventListener;
import com.byted.cast.linkcommon.cybergarage.upnp.event.EventListener;
import com.byted.cast.linkcommon.cybergarage.upnp.event.NotifyRequest;
import com.byted.cast.linkcommon.cybergarage.upnp.event.Property;
import com.byted.cast.linkcommon.cybergarage.upnp.event.PropertyList;
import com.byted.cast.linkcommon.cybergarage.upnp.event.SubscriptionRequest;
import com.byted.cast.linkcommon.cybergarage.upnp.event.SubscriptionResponse;
import com.byted.cast.linkcommon.cybergarage.upnp.ssdp.SSDPNotifySocketList;
import com.byted.cast.linkcommon.cybergarage.upnp.ssdp.SSDPPacket;
import com.byted.cast.linkcommon.cybergarage.upnp.ssdp.SSDPSearchRequest;
import com.byted.cast.linkcommon.cybergarage.upnp.ssdp.SSDPSearchResponseSocketList;
import com.byted.cast.linkcommon.cybergarage.util.Debug;
import com.byted.cast.linkcommon.cybergarage.util.ListenerList;
import com.byted.cast.linkcommon.cybergarage.util.Mutex;
import com.byted.cast.linkcommon.cybergarage.xml.Node;
import com.byted.cast.linkcommon.cybergarage.xml.NodeList;
import com.byted.cast.linkcommon.cybergarage.xml.Parser;
import com.byted.cast.linkcommon.cybergarage.xml.ParserException;
import com.byted.cast.linkcommon.cybergarage.xml.ParserType;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes28.dex */
public class ControlPoint implements HTTPRequestListener {
    public static final String AV_TRANSPORT = "urn:schemas-upnp-org:service:AVTransport";
    private static final int DEFAULT_EVENTSUB_PORT = 8058;
    private static final String DEFAULT_EVENTSUB_URI = "/evetSub";
    private static final int DEFAULT_EXPIRED_DEVICE_MONITORING_INTERVAL = 60;
    private static final int DEFAULT_SSDP_CYCLE_SEARCH_COUNT = 60;
    private static final int DEFAULT_SSDP_PORT = 8008;
    private static final String TAG = "ControlPoint";
    private final NodeList devNodeList;
    private final ReentrantReadWriteLock devNodeListLock;
    ListenerList deviceChangeListenerList;
    private Disposer deviceDisposer;
    private ListenerList deviceNotifyListenerList;
    private ListenerList deviceSearchResponseListenerList;
    private boolean enableCallBackDIAL;
    private ListenerList eventListenerList;
    private String eventSubURI;
    private long expiredDeviceMonitoringInterval;
    private int httpPort;
    private String httpServerIp;
    private HTTPServerList httpServerList;
    private ContextManager.CastContext mCastContext;
    private Device mCurrentDevice;
    private ArrayList<CustomizedEventListener> mCustomizedEventListeners;
    private boolean mIsSearchSendSuccess;
    private boolean mIsStart;
    private CastLogger mLogger;
    private CastMonitor mMonitor;
    private int mSsdpCycleSearchCount;
    private TeaEventTrack mTeaEventTrack;
    private CopyOnWriteArrayList<String> mTimeConsumingDeviceList;
    private ExecutorService mTimeConsumingSingleThreadPool;
    private Mutex mutex;
    private boolean nmprMode;
    private RenewSubscriber renewSubscriber;
    private int searchMx;
    private SSDPNotifySocketList ssdpNotifySocketList;
    private Map<String, SSDPPacket> ssdpPackets;
    private int ssdpPort;
    private SSDPSearchResponseSocketList ssdpSearchResponseSocketList;
    private Object userData;

    public void resetSsdpCycleSearchCount() {
        this.mSsdpCycleSearchCount = 0;
    }

    public ControlPoint() {
        this(8008, DEFAULT_EVENTSUB_PORT);
    }

    private int getDlnaCycleSearchCount() {
        int r100 = DLNAOptionUtils.getDlnaCycleSearchCount(this.mCastContext);
        if (r100 <= 0) goto L5;
        return r100;
    L5:
        return 60;
    }

    private ExecutorService getTimeConsumingSingleThreadPool() {
        ExecutorService r100 = this.mTimeConsumingSingleThreadPool;
        if (r100 == null) goto L5;
        return r100;
    L5:
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.mTimeConsumingSingleThreadPool != null) goto L9;
        this.mTimeConsumingSingleThreadPool = CastThreadExecutorsUtils.newSingleThreadExecutor();     // Catch: Throwable -> L12
    L9:
        monitor-exit(this);     // Catch: Throwable -> L12
        return this.mTimeConsumingSingleThreadPool;
    }

    private void handleDeviceCache() {
        Map<String, SSDPPacket> r100 = this.ssdpPackets;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.size() == 0) goto L10;
        Dispatcher.getInstance().enqueue(new AnonymousClass3(this));
        ArrayList r101 = new ArrayList(this.ssdpPackets.keySet());
        this.mMonitor.sendSourceEvent(CastMonitor.BDDLNA_BROWSE_CACHE_CHECK, r101.toString());
        return;
    }

    public DeviceList getDeviceList() {
        this.devNodeListLock.readLock().lock();
        DeviceList r100 = new DeviceList();     // Catch: Throwable -> L12
        int r101 = this.devNodeList.size();     // Catch: Throwable -> L12
        int r102 = 0;
    L4:
        if (r102 >= r101) goto L10;
        Device r103 = getDevice(this.devNodeList.getNode(r102));     // Catch: Throwable -> L12
        if (r103 == null) goto L9;
        r100.add(r103);     // Catch: Throwable -> L12
    L9:
        r102 = r102 + 1;
        goto L4
    L10:
        this.devNodeListLock.readLock().unlock();
        return r100;
    L12:
        th = move-exception;
        this.devNodeListLock.readLock().unlock();
        throw th;
    }

    public void lock() {
        this.mutex.lock();
    }

    public void renewSubscriberService() {
        renewSubscriberService(-1);
    }

    public void search() {
        if (SSDPPacketCache.isEnableCache(this.mCastContext) == false) goto L5;
        handleDeviceCache();
    L5:
        search("upnp:rootdevice", 3);
    }

    public void searchMediaRenderAndAvtransport() {
        SSDPSearchRequest r100 = new SSDPSearchRequest(this.mCastContext, ST.MEDIA_RENDERER, 3);
        SSDPSearchRequest r101 = new SSDPSearchRequest(this.mCastContext, ST.AV_TRANSPORT, 3);
        SSDPSearchResponseSocketList r102 = getSSDPSearchResponseSocketList();
        r102.postIpv4(r100, true);
        r102.postIpv4(r101, true);
        if (Utils.enableCallBackDIAL(this.mCastContext).booleanValue() == false) goto L5;
        SSDPSearchRequest r103 = new SSDPSearchRequest(this.mCastContext, ST.DIAL_DEVICE, 3);
        r102.postIpv4(r103, true);
    L7:
        if (DLNAOptionUtils.isEnableBroadcastSearch(this.mCastContext) == false) goto L12;
        r102.postIpv4(r100, false);
        r102.postIpv4(r101, false);
        if (r103 == null) goto L13;
        r102.postIpv4(r103, false);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r103 = null;
        goto L7
    }

    public boolean stop() {
        this.mLogger.i(TAG, "_DLNA_SEARCH stop begin");
        unsubscribe();
        SSDPNotifySocketList r100 = getSSDPNotifySocketList();
        r100.stop();
        r100.close();
        r100.clear();
        SSDPSearchResponseSocketList r101 = getSSDPSearchResponseSocketList();
        r101.stop();
        r101.close();
        r101.clear();
        HTTPServerList r102 = getHTTPServerList();
        r102.stop();
        r102.close();
        r102.clear();
        Disposer r103 = getDeviceDisposer();
        if (r103 == null) goto L5;
        r103.stop();
        setDeviceDisposer(null);
    L5:
        RenewSubscriber r104 = getRenewSubscriber();
        if (r104 == null) goto L8;
        r104.stop();
        setRenewSubscriber(null);
    L8:
        this.mIsStart = false;
        this.mLogger.i(TAG, "_DLNA_SEARCH stop end");
        return true;
    }

    public void unlock() {
        this.mutex.unlock();
    }

    public void print() {
        DeviceList r100 = getDeviceList();
        int r101 = r100.size();
        Debug.message("Device Num = " + r101);
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        Device r103 = r100.getDevice(r102);
        Debug.message("[" + r102 + "] " + r103.getFriendlyName() + ", " + r103.getLeaseTime() + ", " + r103.getElapsedTime());
        r102 = r102 + 1;
        goto L3
    }

    public void removeExpiredDevices() {
        DeviceList r100 = getDeviceList();
        int r101 = r100.size();
        Device[] r102 = new Device[r101];
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        r102[r103] = r100.getDevice(r103);
        r103 = r103 + 1;
        goto L3
    L5:
        int r104 = 0;
    L6:
        if (r104 >= r101) goto L34;
        if (r102[r104].isExpired() == false) goto L18;
        Device r105 = r102[r104];
        if (r105 != null) goto L12;
    L16:
        this.mLogger.d("removeExpiredDevices Expired device = " + r102[r104].getFriendlyName());
        removeDevice(r102[r104], true);
    L33:
        r104 = r104 + 1;
        goto L6
    L12:
        if (this.mCurrentDevice == null) goto L16;
        if (TextUtils.equals(r105.getUDN(), this.mCurrentDevice.getUDN()) == false) goto L16;
        this.mLogger.d("removeExpiredDevices Expired mCurrentDevice no need check ");
        goto L33
    L18:
        if (DLNAOptionUtils.isEnableDeviceOffline(this.mCastContext) == false) goto L33;
        Device r106 = r102[r104];
        if (r106 == null) goto L28;
        if (this.mCurrentDevice == null) goto L28;
        if (TextUtils.equals(r106.getUDN(), this.mCurrentDevice.getUDN()) == false) goto L28;
        this.mLogger.d("removeExpiredDevices mCurrentDevice no need check ");
    L28:
        if (r102[r104].getDeviceType().contains(ST.MEDIA_RENDERER_NO_VERSION) == true) goto L31;
        this.mLogger.d(TAG, " removeExpiredDevices  device is not MediaRender device");
        goto L33
    L31:
        if (isDeviceOnline(r102[r104], false, 0, 0) == 0) goto L33;
        this.mLogger.d("removeExpiredDevices dev is " + r102[r104].toString());
        removeDevice(r102[r104], false);
        goto L33
    }

    public boolean start() {
        return start("upnp:rootdevice", 3);
    }

    public void unsubscribe() {
        DeviceList r100 = getDeviceList();
        int r101 = r100.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        unsubscribe(r100.getDevice(r102));
        r102 = r102 + 1;
        goto L3
    }

    static {
        UPnP.initialize();
    }

    private HTTPServerList getHTTPServerList() {
        return this.httpServerList;
    }

    private SSDPNotifySocketList getSSDPNotifySocketList() {
        return this.ssdpNotifySocketList;
    }

    private SSDPSearchResponseSocketList getSSDPSearchResponseSocketList() {
        return this.ssdpSearchResponseSocketList;
    }

    public void finalize() {
        stop();
    }

    public Disposer getDeviceDisposer() {
        return this.deviceDisposer;
    }

    public String getEventSubURI() {
        return this.eventSubURI;
    }

    public long getExpiredDeviceMonitoringInterval() {
        return this.expiredDeviceMonitoringInterval;
    }

    public int getHTTPPort() {
        return this.httpPort;
    }

    public String getHttpServerIp() {
        return this.httpServerIp;
    }

    public RenewSubscriber getRenewSubscriber() {
        return this.renewSubscriber;
    }

    public int getSSDPPort() {
        return this.ssdpPort;
    }

    public int getSearchMx() {
        return this.searchMx;
    }

    public Object getUserData() {
        return this.userData;
    }

    public boolean isNMPRMode() {
        return this.nmprMode;
    }

    public boolean isSendSearchSuccess() {
        return this.mIsSearchSendSuccess;
    }

    public boolean isStart() {
        return this.mIsStart;
    }

    public ControlPoint(ContextManager.CastContext r100) {
        this(r100, 8008, DEFAULT_EVENTSUB_PORT);
    }

    public static /* synthetic */ CastLogger access$000(ControlPoint r100) {
        return r100.mLogger;
    }

    public static /* synthetic */ ContextManager.CastContext access$200(ControlPoint r100) {
        return r100.mCastContext;
    }

    public static /* synthetic */ int access$300(ControlPoint r100) {
        return r100.mSsdpCycleSearchCount;
    }

    public static /* synthetic */ int access$308(ControlPoint r100) {
        int r101 = r100.mSsdpCycleSearchCount;
        r100.mSsdpCycleSearchCount = r101 + 1;
        return r101;
    }

    public static /* synthetic */ int access$400(ControlPoint r100) {
        return r100.getDlnaCycleSearchCount();
    }

    public static /* synthetic */ Map access$500(ControlPoint r100) {
        return r100.ssdpPackets;
    }

    private void addCacheDevice(SSDPPacket r100) {
        this.mLogger.d(TAG, "_DLNA_SEARCH addCacheDevice");
        if (r100.isRootDevice() == false) goto L5;
    L14:
        String r101 = r100.getLocation();
        Node r102 = UPnP.getXMLParser(this.mCastContext).parse(new URL(r101), ParserType.DEVICE, false);     // Catch: ParserException -> L28 MalformedURLException -> L30
        Device r103 = getDevice(r102);     // Catch: ParserException -> L28 MalformedURLException -> L30
        if (r103 != null) goto L20;
        this.mLogger.i(TAG, "_DLNA_SEARCH addCacheDevice this device no device node ，ssdpPacket is : " + r100);     // Catch: ParserException -> L28 MalformedURLException -> L30
        return;
    L20:
        if (SSDPPacketCache.isEnableCache(this.mCastContext) == false) goto L22;
        SSDPPacketCache.ssdpPackets.put(r101, r100);     // Catch: ParserException -> L28 MalformedURLException -> L30
    L22:
        r103.setSSDPPacket(r100);     // Catch: ParserException -> L28 MalformedURLException -> L30
        if (getDevice(USN.getUDN(r100.getUSN())) == null) goto L26;
        this.mLogger.d(TAG, " addCacheDevice request scpd failed");     // Catch: ParserException -> L28 MalformedURLException -> L30
        return;
    L26:
        r103.setAddDeviceMode(1);     // Catch: ParserException -> L28 MalformedURLException -> L30
        addDevice(r102);     // Catch: ParserException -> L28 MalformedURLException -> L30
        performAddDeviceListener(r103);     // Catch: ParserException -> L28 MalformedURLException -> L30
        return;
    L28:
        e = move-exception;
        this.mLogger.d(TAG, "_DLNA_SEARCH addCacheDevice ParserException pe : " + e.getLocalizedMessage());
        return;
    L30:
        e = move-exception;
        this.mLogger.d(TAG, "_DLNA_SEARCH addCacheDevice location is : " + r101 + " MalformedURLException me : " + e.getLocalizedMessage());
        return;
    L5:
        if (r100.isMediaRenderDevice() == true) goto L14;
        if (r100.hasAvTransportService() == true) goto L14;
        if (Utils.enableCallBackDIAL(this.mCastContext).booleanValue() == true) goto L11;
    L12:
        this.mLogger.d(TAG, "_DLNA_SEARCH this device is not root device && is not mediaRender device && has no avtransport service, ssdpPacket is : " + r100);
        return;
    L11:
        if (r100.isDIALDevice() == true) goto L14;
        goto L12
    }

    private void addDevice(SSDPPacket r110) {
        this.mLogger.d(TAG, "_DLNA_SEARCH addDevice");
        String r100 = USN.getUDN(r110.getUSN());
        Device r101 = getDevice(r100);
        if (r101 != null) goto L5;
    L11:
        boolean r102 = false;
    L12:
        String r103 = r110.getLocation();
        Node r104 = UPnP.getXMLParser(this.mCastContext).parse(new URL(r103), ParserType.DEVICE, true);     // Catch: ParserException -> L26 MalformedURLException -> L34
        Device r111 = getDevice(r104);     // Catch: ParserException -> L26 MalformedURLException -> L34
        if (r111 != null) goto L18;
        this.mLogger.i(TAG, "_DLNA_SEARCH this device no device node ，ssdpPacket is : " + r110);     // Catch: ParserException -> L26 MalformedURLException -> L34
        this.mTimeConsumingDeviceList.add(r100);     // Catch: ParserException -> L26 MalformedURLException -> L34
        trackDlnaBrowseError(null, ErrorCode.DLNA_SEARCH_NO_DEVICE_NODE, " this device no device node ", "");     // Catch: ParserException -> L26 MalformedURLException -> L34
        return;
    L18:
        if (SSDPPacketCache.isEnableCache(this.mCastContext) == false) goto L20;
        SSDPPacketCache.ssdpPackets.put(r103, r110);     // Catch: ParserException -> L26 MalformedURLException -> L34
    L20:
        r111.setSSDPPacket(r110);     // Catch: ParserException -> L26 MalformedURLException -> L34
        r111.setAddDeviceMode(0);     // Catch: ParserException -> L26 MalformedURLException -> L34
        if (r102 == false) goto L23;
        updateDevice(r101.getRootNode(), r104);     // Catch: ParserException -> L26 MalformedURLException -> L34
    L24:
        this.mTimeConsumingDeviceList.remove(r100);     // Catch: ParserException -> L26 MalformedURLException -> L34
        this.mLogger.i(TAG, "_DLNA_SEARCH this device ，getFriendlyName is : " + r111.getFriendlyName() + "applicationURL, " + r111.getApplicationUrl());     // Catch: ParserException -> L26 MalformedURLException -> L34
        performAddDeviceListener(r111);     // Catch: ParserException -> L26 MalformedURLException -> L34
        return;
    L23:
        addDevice(r104);     // Catch: ParserException -> L26 MalformedURLException -> L34
    L26:
        e = move-exception;
        this.mLogger.e(TAG, "_DLNA_SEARCH ParserException pe : ", e);
        this.mTimeConsumingDeviceList.add(r100);
        String r105 = e.getLocalizedMessage();
        if (TextUtils.isEmpty(r105) == false) goto L30;
    L33:
        trackDlnaBrowseError(null, ErrorCode.DLNA_SEARCH_PARSER_ERROR, e.getMessage(), e.getLocalizedMessage());
        return;
    L30:
        if (r105.contains(ErrorCode.DLNA_SEARCH_LOCATION_CONNECT_ERROR_DESC) == false) goto L33;
        trackDlnaBrowseError(null, ErrorCode.DLNA_SEARCH_LOCATION_CONNECT_ERROR, e.getMessage(), e.getLocalizedMessage());
        return;
    L34:
        e = move-exception;
        this.mLogger.e(TAG, "_DLNA_SEARCH location is : " + r103 + " MalformedURLException me : ", e);
        trackDlnaBrowseError(null, ErrorCode.DLNA_SEARCH_URL_INVALID_ERROR, e.getMessage(), e.getLocalizedMessage());
        this.mTimeConsumingDeviceList.add(r100);
        return;
    L5:
        if (r101.isRootDevice() == false) goto L11;
        String r106 = r110.getLocation();
        if (TextUtils.equals(r106, r101.getLocation()) == false) goto L10;
        r101.setSSDPPacket(r110);
        performAddDeviceListener(r101);
        this.mLogger.d(TAG, "_DLNA_SEARCH this device has find ,location is : " + r106);
        return;
    L10:
        this.mLogger.d(TAG, "_DLNA_SEARCH location is change");
        r102 = true;
        goto L12
    }

    private void checkAndAddSsdpPacket(final SSDPPacket r100) {
        if (r100 != null) goto L7;
        this.mLogger.d(TAG, "_DLNA_SEARCH ssdpPacket is null");
        return;
    L7:
        if (r100.isRootDevice() == true) goto L19;
        if (r100.isMediaRenderDevice() == true) goto L19;
        if (r100.hasAvTransportService() == true) goto L19;
        if (Utils.enableCallBackDIAL(this.mCastContext).booleanValue() == true) goto L15;
    L16:
        this.mLogger.d(TAG, "_DLNA_SEARCH this device is not root device && is not mediaRender device && has no avtransport service, ssdpPacket is : " + r100);
        return;
    L15:
        if (r100.isDIALDevice() == false) goto L16;
    L19:
        if (this.mTimeConsumingDeviceList.contains(USN.getUDN(r100.getUSN())) == false) goto L21;
        getTimeConsumingSingleThreadPool().execute(new AnonymousClass1(this, r100));
        return;
    L21:
        addDevice(r100);
    }

    private String getEventSubCallbackURL(String r100) {
        return HostInterface.getHostURL(r100, getHTTPPort(), getEventSubURI());
    }

    private int isGetTransportStateSuccess(Device r100) {
        Service r101 = r100.getService("urn:schemas-upnp-org:service:AVTransport");
        if (r101 != null) goto L6;
        this.mLogger.d(TAG, " isGetTransportStateSuccess avtransport is null");
        return ErrorCode.ERROR_CODE_DETECT_DEVICE_NULL_AVTRANS_SERVICE;
    L6:
        Action r102 = r101.getAction("GetTransportInfo");
        if (r102 != null) goto L10;
        this.mLogger.d(TAG, "isGetTransportStateSuccess action null");
        return ErrorCode.ERROR_CODE_DETECT_DEVICE_NULL_TRANS_ACTION;
    L10:
        r102.setArgumentValue("InstanceID", "0");
        boolean r103 = r102.postControlAction();
        this.mLogger.d(TAG, "isGetTransportStateSuccess result is : " + r103 + " dev name is : " + r100.getFriendlyName());
        if (r103 == true) goto L36;
        CommandExecuteStatus r104 = r102.getCommandExecuteStatus();
        if (r104 != null) goto L15;
    L20:
        UPnPStatus r105 = r102.getControlStatus();
        if (r105 != null) goto L23;
    L28:
        UPnPStatus r106 = r102.getStatus();
        if (r106 != null) goto L31;
        return ErrorCode.ERROR_CODE_DETECT_DEVICE_DEFAULT;
    L31:
        if (r106.getCode() != 0) goto L33;
        return ErrorCode.ERROR_CODE_DETECT_DEVICE_DEFAULT;
    L33:
        return r106.getCode() + ErrorCode.ERROR_CODE_DLNA_PLAY_HTTP;
    L23:
        if (r105.getCode() == 0) goto L28;
        if (TextUtils.isEmpty(r105.getDescription()) == true) goto L28;
        return r105.getCode() + ErrorCode.ERROR_CODE_DLNA_PLAY_UPNP;
    L15:
        if (r104.getPlayErrorCode() == 0) goto L20;
        if (TextUtils.isEmpty(r104.getException()) == true) goto L20;
        return r104.getPlayErrorCode();
    L36:
        return 0;
    }

    private void removeDevice(SSDPPacket r100) {
        if (r100.isByeBye() == true) goto L5;
        return;
    L5:
        removeDevice(USN.getUDN(r100.getUSN()));
        if (SSDPPacketCache.isEnableCache(this.mCastContext) == true) goto L8;
        return;
    L8:
        if (r100.getLocation() == null) goto L12;
        SSDPPacketCache.ssdpPackets.remove(r100.getLocation());
        return;
    }

    public void addCustomizedEventListener(CustomizedEventListener r100) {
        this.mCustomizedEventListeners.add(r100);
    }

    public void addDeviceChangeListener(DeviceChangeListener r100) {
        this.deviceChangeListenerList.add(r100);
    }

    public void addEventListener(EventListener r100) {
        this.eventListenerList.add(r100);
    }

    public void addNotifyListener(NotifyListener r100) {
        this.deviceNotifyListenerList.add(r100);
    }

    public void addSearchResponseListener(SearchResponseListener r100) {
        this.deviceSearchResponseListenerList.add(r100);
    }

    public Device getDevice(String r100) {
        this.devNodeListLock.readLock().lock();
        int r101 = this.devNodeList.size();     // Catch: Throwable -> L19
        int r102 = 0;
    L4:
        if (r102 >= r101) goto L17;
        Device r103 = getDevice(this.devNodeList.getNode(r102));     // Catch: Throwable -> L19
        if (r103 != null) goto L10;
    L16:
        r102 = r102 + 1;
        goto L4
    L10:
        if (r103.isDevice(r100) == true) goto L11;
        r103 = r103.getDevice(r100);     // Catch: Throwable -> L19
        if (r103 == null) goto L16;
    L11:
        this.devNodeListLock.readLock().unlock();
        return r103;
    L17:
        this.devNodeListLock.readLock().unlock();
        return null;
    L19:
        th = move-exception;
        this.devNodeListLock.readLock().unlock();
        throw th;
    }

    public Service getSubscriberService(String r100) {
        DeviceList r101 = getDeviceList();
        int r102 = r101.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        Service r104 = r101.getDevice(r103).getSubscriberService(r100);
        if (r104 != null) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public boolean hasDevice(String r100) {
        if (getDevice(r100) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.byted.cast.linkcommon.cybergarage.http.HTTPRequestListener
    public void httpRequestRecieved(HTTPRequest r110) {
        if (Debug.isOn() != true) goto L6;
        r110.print();
    L6:
        if (r110.isNotifyRequest() == false) goto L20;
        NotifyRequest r100 = new NotifyRequest(this.mCastContext, r110);
        if (isSupportCustomizedService(r100) == true) goto L10;
        String r101 = r100.getSID();
        long r102 = r100.getSEQ();
        PropertyList r103 = r100.getPropertyList();
        int r104 = r103.size();
        int r111 = 0;
    L16:
        if (r111 >= r104) goto L18;
        Property r105 = r103.getProperty(r111);
        performEventListener(r101, r102, r105.getName(), r105.getValue());
        r111 = r111 + 1;
        goto L16
    L18:
        r110.returnOK();
        return;
    L10:
        if (DLNAOptionUtils.isEnableDlnaSourceCustomizedService(this.mCastContext) == true) goto L13;
        this.mLogger.d(TAG, " isSupportCustomizedService is false");
        r110.returnBadRequest();
        return;
    L13:
        performCustomizedEventListener(r100);
        r110.returnOK();
        return;
    L20:
        r110.returnBadRequest();
    }

    public boolean isSubscribed(Service r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return r100.isSubscribed();
    }

    public boolean isSupportCustomizedService(NotifyRequest r100) {
        if (r100 != null) goto L7;
        this.mLogger.d(TAG, " isSupportCustomizedService is false , request is null");
        return false;
    L7:
        if (r100.getPrivateService() < 2) goto L10;
        return true;
    L10:
        return false;
    }

    public void notifyReceived(SSDPPacket r100) {
        if (r100.isRootDevice() == true) goto L5;
    L10:
        performNotifyListener(r100);
        return;
    L5:
        if (r100.isAlive() != true) goto L8;
        checkAndAddSsdpPacket(r100);
        goto L10
    L8:
        if (r100.isByeBye() != true) goto L10;
        removeDevice(r100);
        goto L10
    }

    public void performAddDeviceListener(Device r100) {
        int r101 = this.deviceChangeListenerList.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        ((DeviceChangeListener) this.deviceChangeListenerList.get(r102)).deviceAdded(r100);
        r102 = r102 + 1;
        goto L3
    }

    public void performCustomizedEventListener(NotifyRequest r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.mCustomizedEventListeners.size()) goto L6;
        ((CustomizedEventListener) ListProtector.get(this.mCustomizedEventListeners, r101)).NotifyReceived(r100);
        r101 = r101 + 1;
        goto L4
    }

    public void performNotifyListener(SSDPPacket r100) {
        int r101 = this.deviceNotifyListenerList.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L10;
        ((NotifyListener) this.deviceNotifyListenerList.get(r102)).deviceNotifyReceived(r100);     // Catch: Exception -> L7
    L9:
        r102 = r102 + 1;
    L7:
        e = move-exception;
        Debug.warning("NotifyListener returned an error:", e);
        goto L9
    }

    public void performSearchResponseListener(SSDPPacket r100) {
        this.mLogger.i(TAG, "performSearchResponseListener");
        int r101 = this.deviceSearchResponseListenerList.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L10;
        ((SearchResponseListener) this.deviceSearchResponseListenerList.get(r102)).deviceSearchResponseReceived(r100);     // Catch: Exception -> L7
    L9:
        r102 = r102 + 1;
    L7:
        e = move-exception;
        Debug.warning("SearchResponseListener returned an error:", e);
        goto L9
    }

    public void removeCustomizedEventListener(CustomizedEventListener r100) {
        this.mCustomizedEventListeners.remove(r100);
    }

    public void removeDeviceChangeListener(DeviceChangeListener r100) {
        this.deviceChangeListenerList.remove(r100);
    }

    public void removeEventListener(EventListener r100) {
        this.eventListenerList.remove(r100);
    }

    public void removeNotifyListener(NotifyListener r100) {
        this.deviceNotifyListenerList.remove(r100);
    }

    public void removeSearchResponseListener(SearchResponseListener r100) {
        this.deviceSearchResponseListenerList.remove(r100);
    }

    public void renewSubscriberService(long r100) {
        DeviceList r101 = getDeviceList();
        int r102 = r101.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        renewSubscriberService(r101.getDevice(r103), r100);
        r103 = r103 + 1;
        goto L3
    }

    public void search(String r100) {
        search(r100, 3);
    }

    public void searchResponseReceived(SSDPPacket r100) {
        checkAndAddSsdpPacket(r100);
    }

    public void setCurrentDevice(Device r100) {
        this.mCurrentDevice = r100;
    }

    public void setDeviceDisposer(Disposer r100) {
        this.deviceDisposer = r100;
    }

    public void setEventSubURI(String r100) {
        this.eventSubURI = r100;
    }

    public void setExpiredDeviceMonitoringInterval(long r100) {
        this.expiredDeviceMonitoringInterval = r100;
    }

    public void setHTTPPort(int r100) {
        this.httpPort = r100;
    }

    public void setHttpServerIp(String r100) {
        this.httpServerIp = r100;
    }

    public void setNMPRMode(boolean r100) {
        this.nmprMode = r100;
    }

    public void setRenewSubscriber(RenewSubscriber r100) {
        this.renewSubscriber = r100;
    }

    public void setSSDPPort(int r100) {
        this.ssdpPort = r100;
    }

    public void setSearchMx(int r100) {
        this.searchMx = r100;
    }

    public void setSendSearchSuccess(boolean r100) {
        this.mIsSearchSendSuccess = r100;
    }

    public void setSsdpPackets(Map<String, SSDPPacket> r100) {
        this.ssdpPackets = r100;
    }

    public void setUserData(Object r100) {
        this.userData = r100;
    }

    public boolean start(String r100) {
        return start(r100, 3);
    }

    public boolean subscribe(Service r100) {
        return subscribe(r100, -1);
    }

    public void unsubscribe(Device r100) {
        ServiceList r101 = r100.getServiceList();
        int r102 = r101.size();
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L8;
        Service r105 = r101.getService(r104);
        if (r105.hasSID() != true) goto L7;
        unsubscribe(r105);
    L7:
        r104 = r104 + 1;
        goto L3
    L8:
        DeviceList r106 = r100.getDeviceList();
        int r107 = r106.size();
    L9:
        if (r103 >= r107) goto L11;
        unsubscribe(r106.getDevice(r103));
        r103 = r103 + 1;
        goto L9
    }

    private void addDevice(Node r100) {
        this.devNodeListLock.writeLock().lock();
        this.devNodeList.add(r100);     // Catch: Throwable -> L6
        this.devNodeListLock.writeLock().unlock();
        return;
    L6:
        th = move-exception;
        this.devNodeListLock.writeLock().unlock();
        throw th;
    }

    private Device getDevice(Node r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Node r101 = r100.getNode("device");
        if (r101 != null) goto L9;
        return null;
    L9:
        return new Device(r100, r101);
    }

    public void removeDevice(String r100) {
        removeDevice(getDevice(r100), true);
    }

    public boolean unsubscribe(Service r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        SubscriptionRequest r101 = new SubscriptionRequest(this.mCastContext);
        r101.setUnsubscribeRequest(r100);
        if (r101.post().isSuccessful() != true) goto L9;
        r100.clearSID();
        return true;
    L9:
        return false;
    }

    public ControlPoint(int r100, int r101) {
        this(null, r100, r101, null);
    }

    public static /* synthetic */ void access$100(ControlPoint r100, SSDPPacket r101) {
        r100.addDevice(r101);
    }

    public static /* synthetic */ void access$600(ControlPoint r100, SSDPPacket r101) {
        r100.addCacheDevice(r101);
    }

    private void removeDevice(Node r100, boolean r101) {
        Device r102 = getDevice(r100);
        if (r102 != null) goto L5;
    L7:
        this.devNodeListLock.writeLock().lock();
        this.devNodeList.remove(r100);     // Catch: Throwable -> L11
        this.devNodeListLock.writeLock().unlock();
        return;
    L11:
        th = move-exception;
        this.devNodeListLock.writeLock().unlock();
        throw th;
    L5:
        if (r102.isRootDevice() == false) goto L7;
        performRemoveDeviceListener(r102, r101);
        goto L7
    }

    private void updateDevice(Node r100, Node r101) {
        this.devNodeListLock.writeLock().lock();
        this.devNodeList.remove(r100);     // Catch: Throwable -> L6
        this.devNodeList.add(r101);     // Catch: Throwable -> L6
        this.devNodeListLock.writeLock().unlock();
        return;
    L6:
        th = move-exception;
        this.devNodeListLock.writeLock().unlock();
        throw th;
    }

    public void performRemoveDeviceListener(Device r100, boolean r101) {
        int r102 = this.deviceChangeListenerList.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        ((DeviceChangeListener) this.deviceChangeListenerList.get(r103)).deviceRemoved(r100, r101);
        r103 = r103 + 1;
        goto L3
    }

    public void renewSubscriberService(Device r100, long r101) {
        ServiceList r102 = r100.getServiceList();
        int r103 = r102.size();
        int r104 = 0;
        int r105 = 0;
    L3:
        if (r105 >= r103) goto L11;
        Service r106 = r102.getService(r105);
        if (r106.isSubscribed() == false) goto L10;
        if (subscribe(r106, r106.getSID(), r101) == true) goto L10;
        subscribe(r106, r101);
    L10:
        r105 = r105 + 1;
        goto L3
    L11:
        DeviceList r107 = r100.getDeviceList();
        int r108 = r107.size();
    L12:
        if (r104 >= r108) goto L14;
        renewSubscriberService(r107.getDevice(r104), r101);
        r104 = r104 + 1;
        goto L12
    }

    public void search(String r100, int r101) {
        final SSDPSearchRequest r102 = new SSDPSearchRequest(this.mCastContext, r100, r101);
        final SSDPSearchResponseSocketList r103 = getSSDPSearchResponseSocketList();
        boolean r104 = DLNAOptionUtils.isEnableDlnaSearch(this.mCastContext);
        this.mLogger.d(TAG, "_DLNA_SEARCH dlna search enable:" + r104);
        this.mMonitor.sendSourceEvent(CastMonitor.BDDLNA_BROWSE_SCHEDULE, "" + r104);
        if (r104 == false) goto L5;
        Dispatcher.getInstance().schedule(Dispatcher.SCHEDULE_DLNA_BROWSE_TASK, new AnonymousClass2(this, r103, r102), DLNAOptionUtils.getDlnaCycleSearchInterval(this.mCastContext), 0);
        return;
    L5:
        r103.post(r102, true);
        if (DLNAOptionUtils.isEnableBroadcastSearch(this.mCastContext) == false) goto L8;
        r103.postIpv4(r102, false);
    L8:
        searchMediaRenderAndAvtransport();
    }

    public boolean start(String r110, int r111) {
        this.mLogger.i(TAG, "_DLNA_SEARCH start begin");
        stop();
        if (DLNAOptionUtils.isEnableSourceDlnaIpv6(this.mCastContext) == true) goto L5;
        UPnP.setEnable(9);
        this.mLogger.d(TAG, "_DLNA_SEARCH  close ipv6 ");
    L5:
        int r100 = getHTTPPort();
        HTTPServerList r101 = getHTTPServerList();
        if (r101.open(r100) == true) goto L10;
        setHTTPPort(0);
        if (r101.open(getHTTPPort()) == true) goto L10;
        this.mLogger.w(TAG, "_DLNA_SEARCH httpserver open port failed");
        trackDlnaBrowseError(null, ErrorCode.DLNA_SEARCH_START_HTTP_SERVER_OPEN_ERROR, "http server open failed", "");
    L10:
        r101.addRequestListener(this);
        r101.start();
        int r102 = 0;
    L12:
        if (r102 >= r101.size()) goto L21;
        HTTPServer r103 = r101.getHTTPServer(r102);
        if (r103 == null) goto L20;
        String r104 = r103.getBindAddress();
        if (TextUtils.isEmpty(r104) == true) goto L19;
        r104 = r104.replace(HTTP.URL_DEFAULT, "");
    L19:
        setHttpServerIp(r104);
        setHTTPPort(r103.getBindPort());
    L20:
        r102 = r102 + 1;
        goto L12
    L21:
        SSDPNotifySocketList r105 = getSSDPNotifySocketList();
        if (r105.open() == true) goto L24;
        this.mLogger.w(TAG, "_DLNA_SEARCH ssdp notify socket open failed");
        trackDlnaBrowseError(null, ErrorCode.DLNA_SEARCH_START_NOTIFY_SOCKET_OPEN_ERROR, "ssdp notify socket open failed", "");
        boolean r106 = false;
    L25:
        r105.setControlPoint(this);
        r105.start();
        int r107 = getSSDPPort();
        SSDPSearchResponseSocketList r108 = getSSDPSearchResponseSocketList();
        if (r108.open(r107) == true) goto L32;
        setSSDPPort(0);
        if (r108.open(getSSDPPort()) == true) goto L32;
        this.mLogger.i(TAG, "_DLNA_SEARCH ssdp search response socket open failed");
        trackDlnaBrowseError(null, ErrorCode.DLNA_SEARCH_START_SEARCH_RESPONSE_SOCKET_OPEN_ERROR, "ssdp search response socket open failed", "");
        if (r106 == true) goto L32;
        return false;
    L32:
        r108.setControlPoint(this);
        r108.start();
        search(r110, r111);
        Disposer r112 = new Disposer(this);
        setDeviceDisposer(r112);
        r112.start();
        if (isNMPRMode() == false) goto L35;
        RenewSubscriber r113 = new RenewSubscriber(this);
        setRenewSubscriber(r113);
        r113.start();
    L35:
        this.mIsStart = true;
        this.mLogger.i(TAG, "_DLNA_SEARCH start end");
        return true;
    L24:
        r106 = true;
        goto L25
    }

    public boolean subscribe(Service r100, long r101) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.isSubscribed() == true) goto L8;
        Device r102 = r100.getRootDevice();
        if (r102 != null) goto L12;
        return false;
    L12:
        String r103 = r102.getInterfaceAddress();
        SubscriptionRequest r104 = new SubscriptionRequest(this.mCastContext);
        r104.setSubscribeRequest(r100, getEventSubCallbackURL(r103), r101);
        if (r100.isService(Service.CUSTOMIZED_SERVICE) == false) goto L15;
        r104.setPrivateService(4);
    L15:
        SubscriptionResponse r105 = r104.post();
        if (r105.isSuccessful() == false) goto L19;
        r100.setSID(r105.getSID());
        r100.setTimeout(r105.getTimeout());
        return true;
    L19:
        r100.clearSID();
        return false;
    L8:
        return subscribe(r100, r100.getSID(), r101);
    }

    public void removeDevice(Device r100, boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        removeDevice(r100.getRootNode(), r101);
    }

    public boolean subscribe(Service r100, String r101) {
        return subscribe(r100, r101, -1);
    }

    public ControlPoint(ContextManager.CastContext r100, int r101, int r102) {
        this(r100, r101, r102, null);
    }

    public Device addDeviceByIp(String r100, int r101, String r102) {
        this.mLogger.d(TAG, "_DLNA_SEARCH addDeviceByIp");
        String r103 = "http://" + r100 + ":" + r101 + HTTP.URL_DEFAULT + r102;
        Node r104 = UPnP.getXMLParser(this.mCastContext).parse(new URL(r103), ParserType.DEVICE, true);     // Catch: ParserException -> L13 MalformedURLException -> L15
        Device r105 = getDevice(r104);     // Catch: ParserException -> L13 MalformedURLException -> L15
        if (r105 != null) goto L7;
        this.mLogger.i(TAG, "_DLNA_SEARCH addDeviceByIp this device no device node  ");     // Catch: ParserException -> L13 MalformedURLException -> L15
        return null;
    L7:
        r105.setAddDeviceMode(2);     // Catch: ParserException -> L13 MalformedURLException -> L15
        r105.setLocation(r103);     // Catch: ParserException -> L13 MalformedURLException -> L15
        Device r106 = getDevice(r105.getUDN());     // Catch: ParserException -> L13 MalformedURLException -> L15
        if (r106 == null) goto L11;
        performAddDeviceListener(r106);     // Catch: ParserException -> L13 MalformedURLException -> L15
        return r106;
    L11:
        addDevice(r104);     // Catch: ParserException -> L13 MalformedURLException -> L15
        performAddDeviceListener(r105);     // Catch: ParserException -> L13 MalformedURLException -> L15
        return r105;
    L13:
        e = move-exception;
        this.mLogger.d(TAG, "_DLNA_SEARCH addDeviceByIp ParserException pe : " + e.getLocalizedMessage());
    L17:
        return null;
    L15:
        e = move-exception;
        this.mLogger.d(TAG, "_DLNA_SEARCH addDeviceByIp MalformedURLException me : " + e.getLocalizedMessage());
        goto L17
    }

    public int isCurrentDeviceOnline(Device r100, int r101, int r102) {
        int r103 = isDeviceOnline(r100, true, r101, r102);
        if (r103 == 0) goto L5;
        removeDevice(r100, false);
        this.mLogger.d(TAG, " isCurrentDeviceOnline remove current device is : " + r100);
    L5:
        return r103;
    }

    public boolean subscribe(Service r100, String r101, long r102) {
        SubscriptionRequest r103 = new SubscriptionRequest(this.mCastContext);
        r103.setRenewRequest(r100, r101, r102);
        if (r100.isService(Service.CUSTOMIZED_SERVICE) == false) goto L5;
        r103.setPrivateService(4);
    L5:
        SubscriptionResponse r104 = r103.post();
        if (r104.isSuccessful() == false) goto L9;
        r100.setSID(r104.getSID());
        r100.setTimeout(r104.getTimeout());
        return true;
    L9:
        r100.clearSID();
        return false;
    }

    public ControlPoint(ContextManager.CastContext r100, int r101, int r102, InetAddress[] r103) {
        this.mSsdpCycleSearchCount = 0;
        this.mIsStart = false;
        this.mIsSearchSendSuccess = false;
        this.mTimeConsumingDeviceList = new CopyOnWriteArrayList();
        this.mCustomizedEventListeners = new ArrayList();
        this.mutex = new Mutex();
        this.ssdpPort = 0;
        this.httpPort = 0;
        this.httpServerIp = "";
        this.devNodeList = new NodeList();
        this.devNodeListLock = new ReentrantReadWriteLock();
        this.deviceNotifyListenerList = new ListenerList();
        this.deviceSearchResponseListenerList = new ListenerList();
        this.deviceChangeListenerList = new ListenerList();
        this.searchMx = 3;
        this.eventListenerList = new ListenerList();
        this.eventSubURI = DEFAULT_EVENTSUB_URI;
        this.userData = null;
        this.mCastContext = r100;
        this.mLogger = ContextManager.getLogger(r100);
        this.mMonitor = ContextManager.getMonitor(r100);
        this.mTeaEventTrack = ContextManager.getTeaEventTrack(r100);
        this.ssdpNotifySocketList = new SSDPNotifySocketList(this.mCastContext, r103);
        this.ssdpSearchResponseSocketList = new SSDPSearchResponseSocketList(r103, r100);
        this.httpServerList = new HTTPServerList(this.mCastContext, HTTPServerType.DLNA_SOURCE);
        setSSDPPort(r101);
        setHTTPPort(r102);
        setDeviceDisposer(null);
        setExpiredDeviceMonitoringInterval(60);
        setRenewSubscriber(null);
        setNMPRMode(false);
        setRenewSubscriber(null);
    }

    public int isDeviceOnline(Device r110, boolean r111, int r112, int r113) {
        if (r110 != null) goto L6;
        this.mLogger.d(TAG, " isDeviceOnline  device is null");
        return ErrorCode.ERROR_CODE_DETECT_DEVICE_NULL_DEVICE;
    L6:
        int r100 = DLNAOptionUtils.getDlnaDetectDeviceMode(this.mCastContext);
        this.mLogger.d(TAG, " isDeviceOnline mode is " + r100);
        if (r100 == 1) goto L27;
        if (r100 == 2) goto L25;
        if (r100 != 3) goto L13;
        Service r114 = r110.getService("urn:schemas-upnp-org:service:AVTransport");
        if (r114 != null) goto L19;
        this.mLogger.d(TAG, " isDeviceOnline  avtransport is null");
        return ErrorCode.ERROR_CODE_DETECT_DEVICE_NULL_AVTRANS_SERVICE;
    L19:
        if (r114.isSCPDNodeRequestSuccess() == false) goto L22;
        this.mLogger.d(TAG, " isDeviceOnline request scpdNode success");
        return 0;
    L22:
        this.mLogger.d(TAG, " isDeviceOnline request scpdNode failed");
        return ErrorCode.ERROR_CODE_DETECT_DEVICE_NULL_SCPD;
    L13:
        return isRequestLocationSuccess(r110, r111, r112, r113, false);
    L25:
        return isGetTransportStateSuccess(r110);
    L27:
        return isRequestLocationSuccess(r110, r111, r112, r113, true);
    }

    public void performEventListener(String r110, long r111, String r112, String r113) {
        int r100 = this.eventListenerList.size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L5;
        ((EventListener) this.eventListenerList.get(r101)).eventNotifyReceived(r110, r111, r112, r113);
        r101 = r101 + 1;
        goto L3
    }

    public void trackDlnaBrowseError(Device r100, int r101, String r102, String r103) {
        if (r100 == null) goto L5;
        HashMap<String, String> r104 = new HashMap();
        r104.put("manufacture", r100.getManufacture());
        r104.put("friendlyName", r100.getFriendlyName());
        r104.put("location", r100.getLocation());
        r104.put("urlBase", r100.getURLBase());
        r104.put("modelName", r100.getModelName());
        r104.put("err_exception", r103);
    L6:
        this.mMonitor.getSourceMonitor().sendDlnaBrowseError(r101, r102, r104);
        if (this.mTeaEventTrack == null) goto L13;
        HashMap<String, String> r105 = new HashMap();
        if (r100 == null) goto L11;
        r105.putAll(r100.getDeviceMap());
    L11:
        r105.put("err_code", String.valueOf(r101));
        r105.put(LocationMonitorConst.ERR_MSG, r102);
        r105.put("err_exception", r103);
        this.mTeaEventTrack.trackDlnaBrowse("failure", r105);
        return;
    L13:
        return;
    L5:
        r104 = null;
        goto L6
    }

    private int isRequestLocationSuccess(Device r100, boolean r101, int r102, int r103, boolean r110) {
        String r104 = r100.getLocation();
        if (TextUtils.isEmpty(r104) == false) goto L14;
        this.mLogger.d(TAG, " isRequestLocationSuccess location is null");
        return ErrorCode.ERROR_CODE_DETECT_DEVICE_NULL_LOCATION;
    L14:
        URL r105 = new URL(r104);     // Catch: MalformedURLException -> L12
        Parser r106 = UPnP.getXMLParser(this.mCastContext);     // Catch: MalformedURLException -> L12
        if (r110 == false) goto L9;
        int r107 = r106.isRequestLocationSuccessBySocket(r105, r101, r102, r103);     // Catch: MalformedURLException -> L12
    L10:
        this.mLogger.d(TAG, " isRequestLocationSuccess is online result is :" + r107 + " dev name is : " + r100.getFriendlyName());     // Catch: MalformedURLException -> L12
        return r107;
    L9:
        r107 = r106.isRequestLocationSuccess(r105, r101, r102, r103);     // Catch: MalformedURLException -> L12
    L12:
        this.mLogger.d(TAG, " isRequestLocationSuccess dev offline name is : " + r100.getFriendlyName() + "location is : " + r104);
        return ErrorCode.ERROR_CODE_DETECT_DEVICE_MALFORMED_URL_EXCEPTION;
    }
}
