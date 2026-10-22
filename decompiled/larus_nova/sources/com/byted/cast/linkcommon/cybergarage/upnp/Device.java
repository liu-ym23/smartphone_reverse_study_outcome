package com.byted.cast.linkcommon.cybergarage.upnp;

import android.text.TextUtils;
import com.byted.cast.common.CastLogger;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.Logger;
import com.byted.cast.common.Utils;
import com.byted.cast.common.utils.DLNAOptionUtils;
import com.byted.cast.linkcommon.cybergarage.cast.CastSSDPPacket;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.byted.cast.linkcommon.cybergarage.http.HTTPRequest;
import com.byted.cast.linkcommon.cybergarage.http.HTTPRequestListener;
import com.byted.cast.linkcommon.cybergarage.http.HTTPResponse;
import com.byted.cast.linkcommon.cybergarage.http.HTTPServerList;
import com.byted.cast.linkcommon.cybergarage.net.HostInterface;
import com.byted.cast.linkcommon.cybergarage.soap.SOAPResponse;
import com.byted.cast.linkcommon.cybergarage.upnp.control.ActionListener;
import com.byted.cast.linkcommon.cybergarage.upnp.control.ActionRequest;
import com.byted.cast.linkcommon.cybergarage.upnp.control.ActionResponse;
import com.byted.cast.linkcommon.cybergarage.upnp.control.ControlRequest;
import com.byted.cast.linkcommon.cybergarage.upnp.control.CustomizedSubscriberListener;
import com.byted.cast.linkcommon.cybergarage.upnp.control.QueryListener;
import com.byted.cast.linkcommon.cybergarage.upnp.control.QueryRequest;
import com.byted.cast.linkcommon.cybergarage.upnp.device.Advertiser;
import com.byted.cast.linkcommon.cybergarage.upnp.device.Description;
import com.byted.cast.linkcommon.cybergarage.upnp.device.InvalidDescriptionException;
import com.byted.cast.linkcommon.cybergarage.upnp.device.NTS;
import com.byted.cast.linkcommon.cybergarage.upnp.device.PresentationListener;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.byted.cast.linkcommon.cybergarage.upnp.device.SearchListener;
import com.byted.cast.linkcommon.cybergarage.upnp.event.Subscriber;
import com.byted.cast.linkcommon.cybergarage.upnp.event.Subscription;
import com.byted.cast.linkcommon.cybergarage.upnp.event.SubscriptionRequest;
import com.byted.cast.linkcommon.cybergarage.upnp.event.SubscriptionResponse;
import com.byted.cast.linkcommon.cybergarage.upnp.ssdp.SSDPNotifyRequest;
import com.byted.cast.linkcommon.cybergarage.upnp.ssdp.SSDPNotifySocket;
import com.byted.cast.linkcommon.cybergarage.upnp.ssdp.SSDPPacket;
import com.byted.cast.linkcommon.cybergarage.upnp.ssdp.SSDPSearchResponse;
import com.byted.cast.linkcommon.cybergarage.upnp.ssdp.SSDPSearchResponseSocket;
import com.byted.cast.linkcommon.cybergarage.upnp.ssdp.SSDPSearchSocketList;
import com.byted.cast.linkcommon.cybergarage.upnp.xml.DeviceData;
import com.byted.cast.linkcommon.cybergarage.util.Debug;
import com.byted.cast.linkcommon.cybergarage.util.Mutex;
import com.byted.cast.linkcommon.cybergarage.util.TimerUtil;
import com.byted.cast.linkcommon.cybergarage.xml.Node;
import com.byted.cast.linkcommon.cybergarage.xml.ParserException;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public class Device implements HTTPRequestListener, SearchListener {
    private static final String CONFIG_ID = "configId";
    public static final String DEFAULT_DESCRIPTION_URI = "/description.xml";
    public static final int DEFAULT_DISCOVERY_WAIT_TIME = 300;
    public static final int DEFAULT_LEASE_TIME = 1800;
    public static final String DEFAULT_PRESENTATION_URI = "/presentation";
    public static final int DEFAULT_STARTUP_WAIT_TIME = 1000;
    private static final String DEVICE_TYPE = "deviceType";
    private static final String DLNA_VERSION = "bddlnaVersion";
    public static final String ELEM_NAME = "device";
    private static final String FRIENDLY_NAME = "friendlyName";
    public static final int HTTP_DEFAULT_PORT = 4004;
    private static final String MANUFACTURE = "manufacturer";
    private static final String MANUFACTURE_URL = "manufacturerURL";
    private static final String MODEL_DESCRIPTION = "modelDescription";
    private static final String MODEL_NAME = "modelName";
    private static final String MODEL_NUMBER = "modelNumber";
    private static final String MODEL_URL = "modelURL";
    private static final String SERIAL_NUMBER = "serialNumber";
    private static final String TAG = "cybergarageDevice";
    private static final String UDN = "UDN";
    private static final String UPC = "UPC";
    public static final String UPNP_ROOTDEVICE = "upnp:rootdevice";
    private static final String URLBASE_NAME = "URLBase";
    private static Calendar cal = null;
    private static final String presentationURL = "presentationURL";
    private String applicationUrl;
    private int bootId;
    private ContextManager.CastContext castContext;
    private String data;
    private String devUUID;
    private Node deviceNode;
    private HashMap<String, byte[]> iconBytesMap;
    private boolean isSupportSubscriber;
    private int mAddDeviceMode;
    protected CustomizedSubscriberListener mCustomizedSubscriberListener;
    private boolean mIsDeviceStart;
    private CastLogger mLogger;
    private Mutex mutex;
    private PresentationListener presentationListener;
    private Node rootNode;
    private Object userData;
    private boolean wirelessMode;

    public Device() {
        this(null, null);
    }

    @Override // com.byted.cast.linkcommon.cybergarage.upnp.device.SearchListener
    public final /* synthetic */ void bdlinkDeviceSearchReceived(CastSSDPPacket r100) {
        SearchListener.CC.$default$bdlinkDeviceSearchReceived(this, r100);
    }

    public boolean stop() {
        return stop(true);
    }

    private String getNotifyDeviceTypeUSN() {
        return getUDN() + "::" + getDeviceType();
    }

    private boolean initializeLoadedDescription() {
        setDescriptionURI(DEFAULT_DESCRIPTION_URI);
        setLeaseTime(1800);
        setHTTPPort(4004);
        if (hasUDN() == true) goto L7;
        updateUDN();
        return true;
    L7:
        return true;
    }

    public static final void notifyWait() {
        TimerUtil.waitRandom(300);
    }

    private void updateUDN() {
        setUDN(Subscription.UUID + getUUID());
    }

    public DeviceList getDeviceList() {
        DeviceList r100 = new DeviceList();
        Node r101 = getDeviceNode().getNode(DeviceList.ELEM_NAME);
        if (r101 != null) goto L5;
        return r100;
    L5:
        int r102 = r101.getNNodes();
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L12;
        Node r104 = r101.getNode(r103);
        if (isDeviceNode(r104) == false) goto L11;
        r100.add(new Device(r104));
    L11:
        r103 = r103 + 1;
        goto L6
    L12:
        return r100;
    }

    public Map<String, String> getDeviceMap() {
        HashMap r100 = new HashMap();
        r100.put("dlna_manufacture", getManufacture());
        r100.put("manufacturer_url", getManufactureURL());
        r100.put("friendly_name", getFriendlyName());
        r100.put("model_name", getModelName());
        r100.put("model_url", getModelURL());
        r100.put("location", getLocation());
        r100.put("url_base", getURLBase());
        r100.put("device_type", getDeviceType());
        r100.put("linux_version", getLinuxVersion());
        r100.put("dlna_server", getServer());
        r100.put("dlna_ip", getRemoteAddress());
        r100.put("dlna_port", String.valueOf(getRemotePort()));
        r100.put("dlna_location_suffix", getLocationSuffix());
        r100.put("dlna_add_cache", String.valueOf(getAddDeviceMode()));
        return r100;
    }

    public IconList getIconList() {
        IconList r100 = new IconList();
        Node r101 = getDeviceNode().getNode(IconList.ELEM_NAME);
        if (r101 != null) goto L5;
        return r100;
    L5:
        int r102 = r101.getNNodes();
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L17;
        Node r104 = r101.getNode(r103);
        if (Icon.isIconNode(r104) == false) goto L16;
        Icon r105 = new Icon(r104);
        if (r105.hasURL() == false) goto L15;
        String r106 = r105.getURL();
        byte[] r107 = this.iconBytesMap.get(r106);
        if (r107 == null) goto L15;
        r105.setBytes(r107);
    L15:
        r100.add(r105);
    L16:
        r103 = r103 + 1;
        goto L6
    L17:
        return r100;
    }

    public Node getRootNode() {
        Node r100 = this.rootNode;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Node r101 = this.deviceNode;
        if (r101 != null) goto L10;
        return null;
    L10:
        return r101.getRootNode();
    }

    public ServiceList getServiceList() {
        ServiceList r100 = new ServiceList();
        Node r101 = getDeviceNode().getNode("serviceList");
        if (r101 != null) goto L5;
        return r100;
    L5:
        int r102 = r101.getNNodes();
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L12;
        Node r104 = r101.getNode(r103);
        if (Service.isServiceNode(r104) == false) goto L11;
        r100.add(new Service(this.castContext, r104));
    L11:
        r103 = r103 + 1;
        goto L6
    L12:
        return r100;
    }

    public String getServiceTypeAndId() {
        StringBuilder r100 = new StringBuilder("ServiceListInfo:");
        ServiceList r101 = getServiceList();
        int r102 = r101.size();
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L8;
        Service r105 = r101.getService(r104);
        if (r105 == null) goto L7;
        r100.append("[serviceType = ");
        r100.append(r105.getServiceType());
        r100.append(", serviceId = ");
        r100.append(r105.getServiceID());
        r100.append("]");
    L7:
        r104 = r104 + 1;
        goto L3
    L8:
        DeviceList r106 = getDeviceList();
        int r107 = r106.size();
    L9:
        if (r103 >= r107) goto L15;
        Device r108 = r106.getDevice(r103);
        if (r108 == null) goto L13;
        r100.append(r108.getServiceTypeAndId());
    L13:
        r103 = r103 + 1;
        goto L9
    L15:
        return r100.toString();
    }

    public boolean hasPresentationListener() {
        if (this.presentationListener == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void lock() {
        this.mutex.lock();
    }

    public String toString() {
        return "Device{rootNode=" + this.rootNode + ", deviceNode=" + this.deviceNode + ", mutex=" + this.mutex + ", wirelessMode=" + this.wirelessMode + ", devUUID='" + this.devUUID + "', bootId=" + this.bootId + ", presentationListener=" + this.presentationListener + ", iconBytesMap=" + this.iconBytesMap + ", userData=" + this.userData + '}';
    }

    public void unlock() {
        this.mutex.unlock();
    }

    static {
        UPnP.initialize();
        cal = Calendar.getInstance();
    }

    private Advertiser getAdvertiser() {
        return getDeviceData().getAdvertiser();
    }

    private String getDescriptionURI() {
        return getDeviceData().getDescriptionURI();
    }

    private DeviceData getDeviceData() {
        Node r100 = getDeviceNode();
        DeviceData r101 = (DeviceData) r100.getUserData();
        if (r101 != null) goto L6;
        DeviceData r102 = new DeviceData(this.castContext);
        r100.setUserData(r102);
        r102.setNode(r100);
        return r102;
    L6:
        return r101;
    }

    private String getLinuxVersion() {
        if (getSSDPPacket() == null) goto L5;
        String r100 = getSSDPPacket().getServer();
    L7:
        if (TextUtils.isEmpty(r100) == true) goto L15;
        String[] r101 = r100.split("\\s+");
        int r102 = r101.length;
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L15;
        String r104 = r101[r103];
        if (r104.toLowerCase(Locale.ROOT).contains("linux") == true) goto L13;
        r103 = r103 + 1;
        goto L9
    L13:
        return r104.substring(r104.indexOf(HTTP.URL_DEFAULT) + 1);
    L15:
        return "";
    L5:
        r100 = "";
        goto L7
    }

    private String getLocationSuffix() {
        String r100 = getLocation();
        if (TextUtils.isEmpty(r100) == false) goto L9;
        return "";
    L9:
        return new URL(r100).getPath();
    L7:
        this.mLogger.d(TAG, " getLocationSuffix MalformedURLException");
        return "";
    }

    private String getNotifyDeviceNT() {
        if (isRootDevice() == false) goto L5;
        return "upnp:rootdevice";
    L5:
        return getUDN();
    }

    private String getNotifyDeviceTypeNT() {
        return getDeviceType();
    }

    private String getNotifyDeviceUSN() {
        if (isRootDevice() == true) goto L7;
        return getUDN();
    L7:
        return getUDN() + "::upnp:rootdevice";
    }

    private SSDPSearchSocketList getSSDPSearchSocketList() {
        return getDeviceData().getSSDPSearchSocketList();
    }

    private String getServer() {
        if (getSSDPPacket() != null) goto L7;
        return "";
    L7:
        return getSSDPPacket().getServer();
    }

    private void updateBootId() {
        this.bootId = UPnP.createBootId();
    }

    public void announce() {
        notifyWait();
        InetAddress[] r100 = getHTTPBindAddress();
        if (r100 == null) goto L8;
        String[] r101 = new String[r100.length];
        int r102 = 0;
    L6:
        if (r102 >= r100.length) goto L11;
        r101[r102] = r100[r102].getHostAddress();
        r102 = r102 + 1;
    L11:
        int r103 = 0;
    L13:
        if (r103 >= r101.length) goto L23;
        String r104 = r101[r103];
        if (r104 == null) goto L22;
        if (r104.length() == 0) goto L22;
        int r105 = getSSDPAnnounceCount();
        int r106 = 0;
    L20:
        if (r106 >= r105) goto L22;
        announce(r101[r103]);
        r106 = r106 + 1;
    L22:
        r103 = r103 + 1;
        goto L13
    L23:
        return;
    L8:
        int r107 = HostInterface.getNHostAddresses();
        r101 = new String[r107];
        int r108 = 0;
    L9:
        if (r108 >= r107) goto L11;
        r101[r108] = HostInterface.getHostAddress(r108);
        r108 = r108 + 1;
        goto L9
    }

    public void byebye() {
        InetAddress[] r100 = getHTTPBindAddress();
        if (r100 == null) goto L11;
        String[] r101 = new String[r100.length];
        int r102 = 0;
    L6:
        if (r102 >= r100.length) goto L14;
        InetAddress r103 = r100[r102];
        if (r103 == null) goto L10;
        r101[r102] = r103.getHostAddress();
    L10:
        r102 = r102 + 1;
    L14:
        int r104 = 0;
    L16:
        if (r104 >= r101.length) goto L26;
        String r105 = r101[r104];
        if (r105 == null) goto L25;
        if (r105.length() <= 0) goto L25;
        int r106 = getSSDPAnnounceCount();
        int r107 = 0;
    L23:
        if (r107 >= r106) goto L25;
        byebye(r101[r104]);
        r107 = r107 + 1;
    L25:
        r104 = r104 + 1;
        goto L16
    L26:
        return;
    L11:
        int r108 = HostInterface.getNHostAddresses();
        r101 = new String[r108];
        int r109 = 0;
    L12:
        if (r109 >= r108) goto L14;
        r101[r109] = HostInterface.getHostAddress(r109);
        r109 = r109 + 1;
        goto L12
    }

    public int getConfigId() {
        Node r100 = getDeviceNode();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getAttributeIntegerValue(CONFIG_ID);
    }

    public String getDLNAVersion() {
        return getDeviceNode().getNodeValue(DLNA_VERSION);
    }

    public File getDescriptionFile() {
        return getDeviceData().getDescriptionFile();
    }

    public String getDescriptionFilePath() {
        File r100 = getDescriptionFile();
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.getAbsoluteFile().getParent();
    }

    public String getDeviceType() {
        return getDeviceNode().getNodeValue("deviceType");
    }

    public long getElapsedTime() {
        return (System.currentTimeMillis() - getTimeStamp()) / 1000;
    }

    public String getFriendlyName() {
        return getDeviceNode().getNodeValue(FRIENDLY_NAME);
    }

    public InetAddress[] getHTTPBindAddress() {
        return getDeviceData().getHTTPBindAddress();
    }

    public int getHTTPPort() {
        return getDeviceData().getHTTPPort();
    }

    public HTTPServerList getHTTPServerList() {
        return getDeviceData().getHTTPServerList();
    }

    public String getInterfaceAddress() {
        SSDPPacket r100 = getSSDPPacket();
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.getLocalAddress();
    }

    public int getLeaseTime() {
        SSDPPacket r100 = getSSDPPacket();
        if (r100 == null) goto L7;
        return r100.getLeaseTime();
    L7:
        return getDeviceData().getLeaseTime();
    }

    public String getLocation() {
        SSDPPacket r100 = getSSDPPacket();
        if (r100 == null) goto L7;
        return r100.getLocation();
    L7:
        return getDeviceData().getLocation();
    }

    public String getManufacture() {
        return getDeviceNode().getNodeValue(MANUFACTURE);
    }

    public String getManufactureURL() {
        return getDeviceNode().getNodeValue(MANUFACTURE_URL);
    }

    public String getModelDescription() {
        return getDeviceNode().getNodeValue(MODEL_DESCRIPTION);
    }

    public String getModelName() {
        return getDeviceNode().getNodeValue(MODEL_NAME);
    }

    public String getModelNumber() {
        return getDeviceNode().getNodeValue(MODEL_NUMBER);
    }

    public String getModelURL() {
        return getDeviceNode().getNodeValue("modelURL");
    }

    public String getMulticastIPv4Address() {
        return getDeviceData().getMulticastIPv4Address();
    }

    public String getMulticastIPv6Address() {
        return getDeviceData().getMulticastIPv6Address();
    }

    public Device getParentDevice() {
        if (isRootDevice() == false) goto L7;
        return null;
    L7:
        return new Device(getDeviceNode().getParentNode().getParentNode());
    }

    public String getPresentationURL() {
        return getDeviceNode().getNodeValue(presentationURL);
    }

    public String getRemoteAddress() {
        String r100 = getLocation();
        if (TextUtils.isEmpty(r100) == true) goto L9;
        return new URL(r100).getHost();
    L6:
        e = move-exception;
        e.printStackTrace();
    L9:
        if (getSSDPPacket() != null) goto L11;
        return "";
    L11:
        return getSSDPPacket().getRemoteAddress();
    }

    public int getRemotePort() {
        String r100 = getLocation();
        if (TextUtils.isEmpty(r100) == true) goto L9;
        return new URL(r100).getPort();
    L6:
        e = move-exception;
        e.printStackTrace();
    L9:
        if (getSSDPPacket() != null) goto L11;
        return 0;
    L11:
        return getSSDPPacket().getRemotePort();
    }

    public Device getRootDevice() {
        Node r100 = getRootNode();
        if (r100 != null) goto L5;
        return null;
    L5:
        Node r101 = r100.getNode("device");
        if (r101 != null) goto L9;
        return null;
    L9:
        return new Device(r100, r101);
    }

    public int getSSDPAnnounceCount() {
        if (isNMPRMode() == true) goto L5;
    L8:
        return 1;
    L5:
        if (isWirelessMode() != true) goto L8;
        return 4;
    }

    public InetAddress[] getSSDPBindAddress() {
        return getDeviceData().getSSDPBindAddress();
    }

    public String getSSDPIPv4MulticastAddress() {
        return getDeviceData().getMulticastIPv4Address();
    }

    public String getSSDPIPv6MulticastAddress() {
        return getDeviceData().getMulticastIPv6Address();
    }

    public SSDPPacket getSSDPPacket() {
        if (isRootDevice() == true) goto L7;
        return null;
    L7:
        return getDeviceData().getSSDPPacket();
    }

    public int getSSDPPort() {
        return getDeviceData().getSSDPPort();
    }

    public String getST() {
        return getDeviceType();
    }

    public String getSerialNumber() {
        return getDeviceNode().getNodeValue(SERIAL_NUMBER);
    }

    public Icon getSmallestIcon() {
        IconList r100 = getIconList();
        int r101 = r100.size();
        Icon r102 = null;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L11;
        Icon r104 = r100.getIcon(r103);
        if (r102 != null) goto L8;
    L9:
        r102 = r104;
    L10:
        r103 = r103 + 1;
        goto L3
    L8:
        if (r104.getWidth() >= r102.getWidth()) goto L10;
    L11:
        return r102;
    }

    public long getTimeStamp() {
        SSDPPacket r100 = getSSDPPacket();
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getTimeStamp();
    }

    public String getUDN() {
        return getDeviceNode().getNodeValue(UDN);
    }

    public String getUPC() {
        return getDeviceNode().getNodeValue(UPC);
    }

    public String getURLBase() {
        if (isRootDevice() == true) goto L5;
        return "";
    L5:
        return getRootNode().getNodeValue(URLBASE_NAME);
    }

    public boolean hasUDN() {
        String r100 = getUDN();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.length() <= 0) goto L11;
        return true;
    L11:
        return false;
    }

    public boolean isExpired() {
        if ((getLeaseTime() + 60) >= getElapsedTime()) goto L6;
        return true;
    L6:
        return false;
    }

    public boolean isNMPRMode() {
        Node r100 = getDeviceNode();
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getNode(UPnP.INMPR03) == null) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean isRootDevice() {
        return getRootNode().getNode("device").getNodeValue(UDN).equals(getUDN());
    }

    public boolean isRunning() {
        if (getAdvertiser() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean removePresentationURL() {
        return getDeviceNode().removeNode(presentationURL);
    }

    public boolean start() {
        if (DLNAOptionUtils.isOpenDlnaLowPerformanceMode() == false) goto L7;
        InetAddress[] r100 = HostInterface.getHostAddress();
        if (r100.length <= 0) goto L7;
        setHTTPBindAddress(r100);
        setSSDPBindAddress(r100);
    L7:
        stop(true);
        int r101 = getHTTPPort();
        HTTPServerList r102 = getHTTPServerList();
        if (r102.open(r101, false) == true) goto L12;
        setHTTPPort(0);
        if (r102.open(0, true) == true) goto L12;
        return false;
    L12:
        r102.addRequestListener(this);
        r102.start();
        SSDPSearchSocketList r103 = getSSDPSearchSocketList();
        if (r103.open() == true) goto L15;
        return false;
    L15:
        r103.addSearchListener(this);
        r103.start();
        updateBootId();
        updateConfigId();
        this.mIsDeviceStart = true;
        announce();
        Advertiser r104 = new Advertiser(this, this.castContext);
        setAdvertiser(r104);
        r104.start();
        this.mLogger.d(TAG, "start success");
        return true;
    }

    public int getAddDeviceMode() {
        return this.mAddDeviceMode;
    }

    public String getApplicationUrl() {
        return this.applicationUrl;
    }

    public int getBootId() {
        return this.bootId;
    }

    public String getData() {
        return this.data;
    }

    public Node getDeviceNode() {
        return this.deviceNode;
    }

    public PresentationListener getPresentationListener() {
        return this.presentationListener;
    }

    public String getUUID() {
        return this.devUUID;
    }

    public Object getUserData() {
        return this.userData;
    }

    public boolean isDeviceStart() {
        return this.mIsDeviceStart;
    }

    public boolean isSupportSubscriber() {
        return this.isSupportSubscriber;
    }

    public boolean isWirelessMode() {
        return this.wirelessMode;
    }

    public void updateConfigId() {
        updateConfigId(this);
    }

    public Device(String r100) throws InvalidDescriptionException {
        this(new PolarisFileWrapper(r100));
    }

    private void deviceEventSubscriptionRecieved(SubscriptionRequest r100) {
        Service r101 = getServiceByEventSubURL(r100.getURI());
        if (r101 != null) goto L7;
        r100.returnBadRequest();
        return;
    L7:
        if (r101.isService(Service.CUSTOMIZED_SERVICE) == false) goto L17;
        if (DLNAOptionUtils.isEnableDlnaSinkCustomizedService(this.castContext) == true) goto L12;
        Logger.d(TAG, " deviceEventSubscriptionRecieved customized is not open");
        r100.returnBadRequest();
        return;
    L12:
        CustomizedSubscriberListener r102 = this.mCustomizedSubscriberListener;
        if (r102 == null) goto L15;
        r102.onSubscriberReceived(r100);
        goto L17
    L15:
        Logger.d(TAG, " deviceEventSubscriptionRecieved mCustomizedSubscriberListener is null");
        r100.returnBadRequest();
    L17:
        if (r100.hasCallback() == true) goto L23;
        if (r100.hasSID() == true) goto L23;
        upnpBadSubscriptionRecieved(r100, 412);
        return;
    L23:
        if (r100.isUnsubscribeRequest() != true) goto L27;
        deviceEventUnsubscriptionRecieved(r101, r100);
        return;
    L27:
        if (r100.hasCallback() != true) goto L31;
        deviceEventNewSubscriptionRecieved(r101, r100);
        return;
    L31:
        if (r100.hasSID() != true) goto L34;
        deviceEventRenewSubscriptionRecieved(r101, r100);
        return;
    L34:
        upnpBadSubscriptionRecieved(r100, 412);
    }

    private synchronized byte[] getDescriptionData(String r100) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (isNMPRMode() == true) goto L7;
        updateURLBase(r100);     // Catch: Throwable -> L15
    L7:
        Node r101 = getRootNode();     // Catch: Throwable -> L15
        if (r101 != null) goto L12;
        byte[] r102 = new byte[0];     // Catch: Throwable -> L15
        monitor-exit(this);
        return r102;
    L12:
        byte[] r103 = ("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" + r101.toString()).getBytes();     // Catch: Throwable -> L15
        monitor-exit(this);
        return r103;
    }

    private void httpGetRequestRecieved(HTTPRequest r100) {
        String r101 = r100.getURI();
        if (r101 != null) goto L6;
        r100.returnBadRequest();
        this.mLogger.d(TAG, " httpGetRequestRecieved uri is null");
        return;
    L6:
        byte[] r102 = new byte[0];
        String r103 = "en";
        String r104 = "text/xml; charset=\"utf-8\"";
        if (isDescriptionURI(r101) != true) goto L14;
        String r105 = r100.getLocalAddress();
        if (r105 != null) goto L11;
    L12:
        r105 = HostInterface.getInterface();
    L13:
        byte[] r106 = getDescriptionData(r105);
    L27:
        HTTPResponse r107 = new HTTPResponse(this.castContext);
        r107.setStatusCode(200);
        if (r104 == null) goto L30;
        r107.setContentType(r104);
    L30:
        if (r103 == null) goto L32;
        r107.setContentLanguage(r103);
    L32:
        r107.setContent(r106);
        r100.post(r107);
        return;
    L11:
        if (r105.length() > 0) goto L13;
    L14:
        Device r108 = getDeviceByDescriptionURI(r101);
        if (r108 == null) goto L17;
        r106 = r108.getDescriptionData(r100.getLocalAddress());
        goto L27
    L17:
        Service r109 = getServiceBySCPDURL(r101);
        if (r109 == null) goto L21;
        r106 = r109.getSCPDData();
        goto L27
    L21:
        if (isIconBytesURI(r101) != true) goto L34;
        Icon r110 = getIconByURI(r101);
        r103 = null;
        if (r110 == null) goto L25;
        String r111 = r110.getMimeType();
        r102 = r110.getBytes();
        r104 = r111;
    L26:
        r106 = r102;
        goto L27
    L25:
        r104 = null;
        goto L26
    L34:
        r100.returnBadRequest();
        this.mLogger.d(TAG, " httpGetRequestRecieved  return bad ,uri is : ".concat(r101));
    }

    private void httpPostRequestRecieved(HTTPRequest r100) {
        if (r100.isSOAPAction() != true) goto L6;
        soapActionRecieved(r100);
        return;
    L6:
        this.mLogger.d(TAG, " httpPostRequestRecieved return bad , httpReq is : " + r100);
        r100.returnBadRequest();
    }

    private void invalidActionControlRecieved(ControlRequest r100) {
        ActionResponse r101 = new ActionResponse(this.castContext);
        r101.setFaultResponse(401);
        r100.post(r101);
    }

    private void invalidArgumentsControlRecieved(ControlRequest r100) {
        ActionResponse r101 = new ActionResponse(this.castContext);
        r101.setFaultResponse(402);
        r100.post(r101);
    }

    private boolean isDescriptionURI(String r100) {
        String r101 = getDescriptionURI();
        if (r100 == null) goto L8;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.equals(r100);
    L8:
        return false;
    }

    public static boolean isDeviceNode(Node r100) {
        return "device".equals(r100.getName());
    }

    private boolean isPresentationRequest(HTTPRequest r100) {
        if (r100.isGetRequest() == true) goto L5;
        return false;
    L5:
        String r101 = r100.getURI();
        if (r101 != null) goto L8;
        return false;
    L8:
        String r102 = getPresentationURL();
        if (r102 != null) goto L12;
        return false;
    L12:
        return r101.startsWith(r102);
    }

    private void setAdvertiser(Advertiser r100) {
        getDeviceData().setAdvertiser(r100);
    }

    private void setDescriptionFile(File r100) {
        getDeviceData().setDescriptionFile(r100);
    }

    private void setDescriptionURI(String r100) {
        getDeviceData().setDescriptionURI(r100);
    }

    private void setURLBase(String r100) {
        if (isRootDevice() != true) goto L10;
        Node r101 = getRootNode().getNode(URLBASE_NAME);
        if (r101 == null) goto L8;
        r101.setValue(r100);
        return;
    L8:
        Node r102 = new Node(URLBASE_NAME);
        r102.setValue(r100);
        getRootNode().hasNodes();
        getRootNode().insertNode(r102, 1);
        return;
    }

    private void setUUID(String r100) {
        this.devUUID = r100;
    }

    private void soapActionRecieved(HTTPRequest r100) {
        Service r101 = getServiceByControlURL(r100.getURI());
        if (r101 == null) goto L6;
        deviceControlRequestRecieved(new ActionRequest(this.castContext, r100), r101);
        return;
    L6:
        soapBadActionRecieved(r100);
    }

    private void soapBadActionRecieved(HTTPRequest r100) {
        SOAPResponse r101 = new SOAPResponse(this.castContext);
        r101.setStatusCode(400);
        r100.post(r101);
    }

    private boolean stop(boolean r100) {
        this.mIsDeviceStart = false;
        if (r100 != true) goto L5;
        byebye();
    L5:
        HTTPServerList r101 = getHTTPServerList();
        r101.stop();
        r101.close();
        r101.clear();
        SSDPSearchSocketList r102 = getSSDPSearchSocketList();
        r102.stop();
        r102.close();
        r102.clear();
        Advertiser r103 = getAdvertiser();
        if (r103 == null) goto L8;
        r103.stop();
        setAdvertiser(null);
    L8:
        this.mLogger.d(TAG, "stop success");
        return true;
    }

    private void updateConfigId(Device r100) {
        DeviceList r101 = r100.getDeviceList();
        int r102 = r101.size();
        int r103 = 0;
        int r104 = 0;
        int r105 = 0;
    L4:
        if (r104 >= r102) goto L6;
        Device r106 = r101.getDevice(r104);
        updateConfigId(r106);
        r105 = (r105 + r106.getConfigId()) & 16777215;
        r104 = r104 + 1;
        goto L4
    L6:
        ServiceList r107 = r100.getServiceList();
        int r108 = r107.size();
    L7:
        if (r103 >= r108) goto L9;
        Service r109 = r107.getService(r103);
        r109.updateConfigId();
        r105 = (r105 + r109.getConfigId()) & 16777215;
        r103 = r103 + 1;
        goto L7
    L9:
        Node r110 = getDeviceNode();
        if (r110 != null) goto L12;
        return;
    L12:
        r110.setAttribute(CONFIG_ID, (r105 + UPnP.caluculateConfigId(r110.toString())) & 16777215);
    }

    private void updateURLBase(String r100) {
        setURLBase(HostInterface.getHostURL(r100, getHTTPPort(), ""));
    }

    public void addDevice(Device r100) {
        Node r101 = getDeviceNode().getNode(DeviceList.ELEM_NAME);
        if (r101 != null) goto L5;
        r101 = new Node(DeviceList.ELEM_NAME);
        getDeviceNode().addNode(r101);
    L5:
        r101.addNode(r100.getDeviceNode());
        r100.setRootNode(null);
        if (getRootNode() != null) goto L9;
        Node r102 = new Node(RootDescription.ROOT_ELEMENT);
        r102.setNameSpace("", RootDescription.ROOT_ELEMENT_NAMESPACE);
        Node r103 = new Node("specVersion");
        Node r104 = new Node("major");
        r104.setValue("1");
        Node r105 = new Node("minor");
        r105.setValue("0");
        r103.addNode(r104);
        r103.addNode(r105);
        r102.addNode(r103);
        setRootNode(r102);
        return;
    }

    public boolean addIcon(Icon r100) {
        Node r101 = getDeviceNode();
        if (r101 != null) goto L6;
        return false;
    L6:
        Node r102 = r101.getNode(IconList.ELEM_NAME);
        if (r102 != null) goto L9;
        r102 = new Node(IconList.ELEM_NAME);
        r101.addNode(r102);
    L9:
        Node r103 = new Node("icon");
        if (r100.getIconNode() == null) goto L12;
        r103.set(r100.getIconNode());
    L12:
        r102.addNode(r103);
        if (r100.hasURL() == true) goto L15;
        return true;
    L15:
        if (r100.hasBytes() == false) goto L20;
        this.iconBytesMap.put(r100.getURL(), r100.getBytes());
        return true;
    L20:
        return true;
    }

    public void addService(Service r100) {
        Node r101 = getDeviceNode().getNode("serviceList");
        if (r101 != null) goto L5;
        r101 = new Node("serviceList");
        getDeviceNode().addNode(r101);
    L5:
        r101.addNode(r100.getServiceNode());
    }

    public void announce(String r100) {
        this.mLogger.d(TAG, "announce bindAddr : " + r100);
        String r101 = getLocationURL(r100);
        SSDPNotifySocket r102 = new SSDPNotifySocket(this.castContext);
        SSDPNotifyRequest r103 = new SSDPNotifyRequest(this.castContext);
        r103.setServer(UPnP.getServerName());
        r103.setLeaseTime(getLeaseTime());
        r103.setLocation(r101);
        r103.setNTS(NTS.ALIVE);
        r103.setBootId(getBootId());
        r103.setST(getST());
        if (DLNAOptionUtils.isEnableDlnaSinkCustomizedService(this.castContext) == false) goto L5;
        r103.setPrivateService(4);
    L5:
        int r104 = 0;
        if (isRootDevice() != true) goto L13;
        String r105 = getNotifyDeviceNT();
        String r106 = getNotifyDeviceUSN();
        r103.setNT(r105);
        r103.setUSN(r106);
        r102.post(r103, r100, 0);
        if (DLNAOptionUtils.isEnableSinkDlnaUdpBroadcast(this.castContext) == false) goto L10;
        r102.postWithBroadcast(r103, r100, 0);
    L10:
        String r107 = getUDN();
        r103.setNT(r107);
        r103.setUSN(r107);
        r102.post(r103, r100, 0);
        if (DLNAOptionUtils.isEnableSinkDlnaUdpBroadcast(this.castContext) == false) goto L13;
        r102.postWithBroadcast(r103, r100, 0);
    L13:
        String r108 = getNotifyDeviceTypeNT();
        String r109 = getNotifyDeviceTypeUSN();
        r103.setNT(r108);
        r103.setUSN(r109);
        r102.post(r103, r100, 0);
        if (DLNAOptionUtils.isEnableSinkDlnaUdpBroadcast(this.castContext) == false) goto L16;
        r102.postWithBroadcast(r103, r100, 0);
    L16:
        ServiceList r110 = getServiceList();
        int r111 = r110.size();
        int r112 = 0;
    L17:
        if (r112 >= r111) goto L19;
        r110.getService(r112).announce(r100);
        r112 = r112 + 1;
        goto L17
    L19:
        DeviceList r113 = getDeviceList();
        int r114 = r113.size();
    L20:
        if (r104 >= r114) goto L22;
        r113.getDevice(r104).announce(r100);
        r104 = r104 + 1;
        goto L20
    }

    public void byebye(String r100) {
        SSDPNotifySocket r101 = new SSDPNotifySocket(this.castContext);
        SSDPNotifyRequest r102 = new SSDPNotifyRequest(this.castContext);
        r102.setNTS(NTS.BYEBYE);
        int r103 = 0;
        if (isRootDevice() != true) goto L7;
        String r104 = getNotifyDeviceNT();
        String r105 = getNotifyDeviceUSN();
        r102.setNT(r104);
        r102.setUSN(r105);
        r101.post(r102, r100, 0);
        if (DLNAOptionUtils.isEnableSinkDlnaUdpBroadcast(this.castContext) == false) goto L7;
        r101.postWithBroadcast(r102, r100, 0);
    L7:
        String r106 = getNotifyDeviceTypeNT();
        String r107 = getNotifyDeviceTypeUSN();
        r102.setNT(r106);
        r102.setUSN(r107);
        if (DLNAOptionUtils.isEnableDlnaSinkCustomizedService(this.castContext) == false) goto L10;
        r102.setPrivateService(4);
    L10:
        r101.post(r102, r100, 0);
        if (DLNAOptionUtils.isEnableSinkDlnaUdpBroadcast(this.castContext) == false) goto L13;
        r101.postWithBroadcast(r102, r100, 0);
    L13:
        ServiceList r108 = getServiceList();
        int r109 = r108.size();
        int r110 = 0;
    L14:
        if (r110 >= r109) goto L16;
        r108.getService(r110).byebye(r100);
        r110 = r110 + 1;
        goto L14
    L16:
        DeviceList r111 = getDeviceList();
        int r112 = r111.size();
    L17:
        if (r103 >= r112) goto L19;
        r111.getDevice(r103).byebye(r100);
        r103 = r103 + 1;
        goto L17
    }

    @Override // com.byted.cast.linkcommon.cybergarage.upnp.device.SearchListener
    public void deviceSearchReceived(SSDPPacket r100) {
        deviceSearchResponse(r100);
    }

    public void deviceSearchResponse(SSDPPacket r100) {
        String r101 = r100.getST();
        this.mLogger.i(TAG, "deviceSearchResponse, ssdpPacket:" + r100.getRemoteInetAddress() + " ssdpST " + r101);
        if (r101 != null) goto L5;
        return;
    L5:
        boolean r102 = isRootDevice();
        String r103 = getUDN();
        if (r102 != true) goto L8;
        r103 = r103 + "::upnp:rootdevice";
    L8:
        int r104 = 0;
        if (ST.isAllDevice(r101) != true) goto L18;
        String r105 = getNotifyDeviceNT();
        if (r102 != true) goto L13;
        int r106 = 3;
    L14:
        int r107 = 0;
    L15:
        if (r107 >= r106) goto L31;
        postSearchResponse(r100, r105, r103);
        r107 = r107 + 1;
    L31:
        ServiceList r108 = getServiceList();
        int r109 = r108.size();
        int r110 = 0;
    L32:
        if (r110 >= r109) goto L34;
        r108.getService(r110).serviceSearchResponse(r100);
        r110 = r110 + 1;
        goto L32
    L34:
        DeviceList r111 = getDeviceList();
        int r112 = r111.size();
    L35:
        if (r104 >= r112) goto L37;
        r111.getDevice(r104).deviceSearchResponse(r100);
        r104 = r104 + 1;
        goto L35
    L37:
        return;
    L13:
        r106 = 2;
        goto L14
    L18:
        if (ST.isRootDevice(r101) != true) goto L22;
        if (r102 != true) goto L31;
        postSearchResponse(r100, "upnp:rootdevice", r103);
        goto L31
    L22:
        if (ST.isUUIDDevice(r101) != true) goto L27;
        String r113 = getUDN();
        if (r101.equals(r113) != true) goto L31;
        postSearchResponse(r100, r113, r103);
        goto L31
    L27:
        if (ST.isURNDevice(r101) != true) goto L31;
        String r114 = getDeviceType();
        if (r101.equals(r114) != true) goto L31;
        postSearchResponse(r100, r114, getUDN() + "::" + r114);
        goto L31
    }

    public String getAbsoluteURL(String r100) {
        Device r101 = getRootDevice();
        if (r101 == null) goto L5;
        String r102 = r101.getURLBase();
        String r103 = r101.getLocation();
    L7:
        return getAbsoluteURL(r100, r102, r103);
    L5:
        r102 = null;
        r103 = null;
        goto L7
    }

    public Action getAction(String r110) {
        ServiceList r100 = getServiceList();
        int r101 = r100.size();
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L14;
        ActionList r104 = r100.getService(r103).getActionList();
        int r105 = r104.size();
        int r106 = 0;
    L5:
        if (r106 >= r105) goto L13;
        Action r107 = r104.getAction(r106);
        String r108 = r107.getName();
        if (r108 == null) goto L12;
        if (r108.equals(r110) != true) goto L12;
        return r107;
    L12:
        r106 = r106 + 1;
        goto L5
    L13:
        r103 = r103 + 1;
        goto L3
    L14:
        DeviceList r109 = getDeviceList();
        int r111 = r109.size();
    L15:
        if (r102 >= r111) goto L20;
        Action r112 = r109.getDevice(r102).getAction(r110);
        if (r112 != null) goto L18;
        r102 = r102 + 1;
        goto L15
    L18:
        return r112;
    L20:
        return null;
    }

    public Device getDevice(String r100) {
        DeviceList r101 = getDeviceList();
        int r102 = r101.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        Device r104 = r101.getDevice(r103);
        if (r104.isDevice(r100) == true) goto L6;
        Device r105 = r104.getDevice(r100);
        if (r105 != null) goto L9;
        r103 = r103 + 1;
        goto L3
    L9:
        return r105;
    L6:
        return r104;
    L11:
        return null;
    }

    public Device getDeviceByDescriptionURI(String r100) {
        DeviceList r101 = getDeviceList();
        int r102 = r101.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        Device r104 = r101.getDevice(r103);
        if (r104.isDescriptionURI(r100) == true) goto L6;
        Device r105 = r104.getDeviceByDescriptionURI(r100);
        if (r105 != null) goto L9;
        r103 = r103 + 1;
        goto L3
    L9:
        return r105;
    L6:
        return r104;
    L11:
        return null;
    }

    public String getDeviceValue(String r100) {
        if (getDeviceNode() != null) goto L5;
        return "";
    L5:
        Node r101 = getDeviceNode().getNode(r100);
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101.toString();
    }

    public Icon getIcon(int r100) {
        IconList r101 = getIconList();
        if (r100 >= 0) goto L9;
        if ((r101.size() - 1) >= r100) goto L9;
        return null;
    L9:
        return r101.getIcon(r100);
    }

    public Icon getIconByURI(String r100) {
        IconList r101 = getIconList();
        if (r101.size() > 0) goto L5;
        return null;
    L5:
        int r102 = r101.size();
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L11;
        Icon r104 = r101.getIcon(r103);
        if (r104.isURL(r100) == true) goto L9;
        r103 = r103 + 1;
        goto L6
    L9:
        return r104;
    L11:
        return null;
    }

    public String getLocationURL(String r100) {
        return HostInterface.getHostURL(r100, getHTTPPort(), getDescriptionURI());
    }

    public String getRootValue(String r100) {
        if (getRootNode() != null) goto L5;
        return "";
    L5:
        Node r101 = getRootNode().getNode(r100);
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101.toString();
    }

    public void getSSDPIPv4MulticastAddress(String r100) {
        getDeviceData().setMulticastIPv4Address(r100);
    }

    public void getSSDPIPv6MulticastAddress(String r100) {
        getDeviceData().setMulticastIPv6Address(r100);
    }

    public Service getService(String r100) {
        ServiceList r101 = getServiceList();
        int r102 = r101.size();
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L8;
        Service r105 = r101.getService(r104);
        if (r105.isService(r100) == true) goto L6;
        r104 = r104 + 1;
        goto L3
    L6:
        return r105;
    L8:
        DeviceList r106 = getDeviceList();
        int r107 = r106.size();
    L9:
        if (r103 >= r107) goto L14;
        Service r108 = r106.getDevice(r103).getService(r100);
        if (r108 != null) goto L12;
        r103 = r103 + 1;
        goto L9
    L12:
        return r108;
    L14:
        return null;
    }

    public Service getServiceByControlURL(String r100) {
        ServiceList r101 = getServiceList();
        int r102 = r101.size();
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L8;
        Service r105 = r101.getService(r104);
        if (r105.isControlURL(r100) == true) goto L6;
        r104 = r104 + 1;
        goto L3
    L6:
        return r105;
    L8:
        DeviceList r106 = getDeviceList();
        int r107 = r106.size();
    L9:
        if (r103 >= r107) goto L14;
        Service r108 = r106.getDevice(r103).getServiceByControlURL(r100);
        if (r108 != null) goto L12;
        r103 = r103 + 1;
        goto L9
    L12:
        return r108;
    L14:
        return null;
    }

    public Service getServiceByEventSubURL(String r100) {
        ServiceList r101 = getServiceList();
        int r102 = r101.size();
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L8;
        Service r105 = r101.getService(r104);
        if (r105.isEventSubURL(r100) == true) goto L6;
        r104 = r104 + 1;
        goto L3
    L6:
        return r105;
    L8:
        DeviceList r106 = getDeviceList();
        int r107 = r106.size();
    L9:
        if (r103 >= r107) goto L14;
        Service r108 = r106.getDevice(r103).getServiceByEventSubURL(r100);
        if (r108 != null) goto L12;
        r103 = r103 + 1;
        goto L9
    L12:
        return r108;
    L14:
        return null;
    }

    public Service getServiceBySCPDURL(String r100) {
        ServiceList r101 = getServiceList();
        int r102 = r101.size();
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L8;
        Service r105 = r101.getService(r104);
        if (r105.isSCPDURL(r100) == true) goto L6;
        r104 = r104 + 1;
        goto L3
    L6:
        return r105;
    L8:
        DeviceList r106 = getDeviceList();
        int r107 = r106.size();
    L9:
        if (r103 >= r107) goto L14;
        Service r108 = r106.getDevice(r103).getServiceBySCPDURL(r100);
        if (r108 != null) goto L12;
        r103 = r103 + 1;
        goto L9
    L12:
        return r108;
    L14:
        return null;
    }

    public StateVariable getStateVariable(String r100) {
        return getStateVariable(null, r100);
    }

    public Service getSubscriberService(String r100) {
        ServiceList r101 = getServiceList();
        int r102 = r101.size();
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L8;
        Service r105 = r101.getService(r104);
        if (r100.equals(r105.getSID()) == true) goto L6;
        r104 = r104 + 1;
        goto L3
    L6:
        return r105;
    L8:
        DeviceList r106 = getDeviceList();
        int r107 = r106.size();
    L9:
        if (r103 >= r107) goto L14;
        Service r108 = r106.getDevice(r103).getSubscriberService(r100);
        if (r108 != null) goto L12;
        r103 = r103 + 1;
        goto L9
    L12:
        return r108;
    L14:
        return null;
    }

    @Override // com.byted.cast.linkcommon.cybergarage.http.HTTPRequestListener
    public void httpRequestRecieved(HTTPRequest r100) {
        if (this.mIsDeviceStart == true) goto L7;
        this.mLogger.d(TAG, " httpRequestRecieved device is not start, httpReq is : " + r100);
        r100.returnBadRequest();
        return;
    L7:
        if (hasPresentationListener() == false) goto L13;
        if (isPresentationRequest(r100) == false) goto L13;
        getPresentationListener().httpRequestRecieved(r100);
        return;
    L13:
        if (r100.isGetRequest() != true) goto L15;
    L30:
        httpGetRequestRecieved(r100);
        return;
    L15:
        if (r100.isHeadRequest() == true) goto L30;
        if (r100.isPostRequest() != true) goto L22;
        httpPostRequestRecieved(r100);
        return;
    L22:
        if (r100.isSubscribeRequest() != true) goto L24;
    L28:
        deviceEventSubscriptionRecieved(new SubscriptionRequest(this.castContext, r100));
        return;
    L24:
        if (r100.isUnsubscribeRequest() == true) goto L28;
        this.mLogger.d(TAG, " httpRequestRecieved return bad , httpReq is : " + r100);
        r100.returnBadRequest();
    }

    public boolean isDevice(String r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.endsWith(getUDN()) != true) goto L9;
        return true;
    L9:
        if (r100.equals(getFriendlyName()) != true) goto L12;
        return true;
    L12:
        if (r100.endsWith(getDeviceType()) != true) goto L14;
        return true;
    L14:
        return false;
    }

    public boolean isDeviceType(String r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return r100.equals(getDeviceType());
    }

    public boolean isIconBytesURI(String r100) {
        if (this.iconBytesMap.get(r100) != null) goto L10;
        Icon r101 = getIconByURI(r100);
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.hasBytes();
    L10:
        return true;
    }

    public boolean isSupportEncrypt(ContextManager.CastContext r100) {
        if (DLNAOptionUtils.isEnableDlnaSourceCustomizedService(r100) == true) goto L7;
        this.mLogger.d(TAG, " isSupportEncrypt not open dlna customize");
        return false;
    L7:
        if (getSSDPPacket() == null) goto L16;
        String r101 = getSSDPPacket().getCustomizedService();
        if (TextUtils.isEmpty(r101) == false) goto L21;
        this.mLogger.d(TAG, " isSupportEncrypt version is null");
        return false;
    L21:
        int r102 = CastIntegerProtector.parseInt(r101);     // Catch: NumberFormatException -> L14
    L18:
        if (r102 < 3) goto L23;
        return true;
    L23:
        return false;
    L14:
        e = move-exception;
        this.mLogger.d(TAG, " isSupportEncrypt " + e.getLocalizedMessage());
    L16:
        r102 = 0;
        goto L18
    }

    public boolean loadDescription(InputStream r100) throws InvalidDescriptionException {
        Node r101 = UPnP.getXMLParser(this.castContext).parse(r100);     // Catch: ParserException -> L16
        this.rootNode = r101;     // Catch: ParserException -> L16
        if (r101 == null) goto L15;
        Node r102 = r101.getNode("device");     // Catch: ParserException -> L16
        this.deviceNode = r102;     // Catch: ParserException -> L16
        if (r102 == null) goto L13;
        if (initializeLoadedDescription() == true) goto L10;
        return false;
    L10:
        setDescriptionFile(null);
        return true;
    L13:
        throw new InvalidDescriptionException(Description.NOROOTDEVICE_EXCEPTION);     // Catch: ParserException -> L16
    L15:
        throw new InvalidDescriptionException(Description.NOROOT_EXCEPTION);     // Catch: ParserException -> L16
    L16:
        e = move-exception;
        throw new InvalidDescriptionException(e);
    }

    public String retryGetAbsoluteURL(String r100) {
        Device r101 = getRootDevice();
        if (r101 == null) goto L5;
        String r102 = r101.getLocation();
    L7:
        return retryGetAbsoluteURL(r100, r102);
    L5:
        r102 = null;
        goto L7
    }

    public void setActionListener(ActionListener r100) {
        ServiceList r101 = getServiceList();
        int r102 = r101.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.getService(r103).setActionListener(r100);
        r103 = r103 + 1;
        goto L3
    }

    public void setAddDeviceMode(int r100) {
        this.mAddDeviceMode = r100;
    }

    public void setApplicationUrl(String r100) {
        this.applicationUrl = r100;
    }

    public void setCustomizedSubscriberListener(CustomizedSubscriberListener r100) {
        this.mCustomizedSubscriberListener = r100;
    }

    public void setDLNAVersion(String r100) {
        getDeviceNode().setNode(DLNA_VERSION, r100);
    }

    public void setData(String r100) {
        this.data = r100;
    }

    public void setDeviceNode(Node r100) {
        this.deviceNode = r100;
    }

    public void setDeviceType(String r100) {
        getDeviceNode().setNode("deviceType", r100);
    }

    public void setFriendlyName(String r100) {
        getDeviceNode().setNode(FRIENDLY_NAME, r100);
    }

    public void setHTTPBindAddress(InetAddress[] r100) {
        getDeviceData().setHTTPBindAddress(r100);
    }

    public void setHTTPPort(int r100) {
        getDeviceData().setHTTPPort(r100);
    }

    public void setLeaseTime(int r100) {
        getDeviceData().setLeaseTime(r100);
        Advertiser r101 = getAdvertiser();
        if (r101 == null) goto L6;
        announce();
        r101.restart();
        return;
    }

    public void setLocation(String r100) {
        getDeviceData().setLocation(r100);
    }

    public void setManufacture(String r100) {
        getDeviceNode().setNode(MANUFACTURE, r100);
    }

    public void setManufactureURL(String r100) {
        getDeviceNode().setNode(MANUFACTURE_URL, r100);
    }

    public void setModelDescription(String r100) {
        getDeviceNode().setNode(MODEL_DESCRIPTION, r100);
    }

    public void setModelName(String r100) {
        getDeviceNode().setNode(MODEL_NAME, r100);
    }

    public void setModelNumber(String r100) {
        getDeviceNode().setNode(MODEL_NUMBER, r100);
    }

    public void setModelURL(String r100) {
        getDeviceNode().setNode("modelURL", r100);
    }

    public void setMulticastIPv4Address(String r100) {
        getDeviceData().setMulticastIPv4Address(r100);
    }

    public void setMulticastIPv6Address(String r100) {
        getDeviceData().setMulticastIPv6Address(r100);
    }

    public void setNMPRMode(boolean r100) {
        Node r101 = getDeviceNode();
        if (r101 != null) goto L6;
        return;
    L6:
        if (r100 != true) goto L8;
        r101.setNode(UPnP.INMPR03, "1.0");
        r101.removeNode(URLBASE_NAME);
        return;
    L8:
        r101.removeNode(UPnP.INMPR03);
    }

    public void setPresentationListener(PresentationListener r100) {
        this.presentationListener = r100;
        if (r100 == null) goto L5;
        setPresentationURL(DEFAULT_PRESENTATION_URI);
        return;
    L5:
        removePresentationURL();
    }

    public void setPresentationURL(String r100) {
        getDeviceNode().setNode(presentationURL, r100);
    }

    public void setQueryListener(QueryListener r100) {
        ServiceList r101 = getServiceList();
        int r102 = r101.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.getService(r103).setQueryListener(r100);
        r103 = r103 + 1;
        goto L3
    }

    public void setRootNode(Node r100) {
        this.rootNode = r100;
    }

    public void setSSDPBindAddress(InetAddress[] r100) {
        getDeviceData().setSSDPBindAddress(r100);
    }

    public void setSSDPPacket(SSDPPacket r100) {
        getDeviceData().setSSDPPacket(r100);
    }

    public void setSSDPPort(int r100) {
        getDeviceData().setSSDPPort(r100);
    }

    public void setSerialNumber(String r100) {
        getDeviceNode().setNode(SERIAL_NUMBER, r100);
    }

    public void setSupportSubscriber(boolean r100) {
        this.isSupportSubscriber = r100;
    }

    public void setUDN(String r100) {
        getDeviceNode().setNode(UDN, Subscription.UUID + r100);
    }

    public void setUPC(String r100) {
        getDeviceNode().setNode(UPC, r100);
    }

    public void setUserData(Object r100) {
        this.userData = r100;
    }

    public void setWirelessMode(boolean r100) {
        this.wirelessMode = r100;
    }

    public Device(File r100) throws InvalidDescriptionException {
        this(null, null);
        loadDescription(r100);
    }

    public boolean loadDescription(String r100) throws InvalidDescriptionException {
        Node r101 = UPnP.getXMLParser(this.castContext).parse(r100);     // Catch: ParserException -> L16
        this.rootNode = r101;     // Catch: ParserException -> L16
        if (r101 == null) goto L15;
        Node r102 = r101.getNode("device");     // Catch: ParserException -> L16
        this.deviceNode = r102;     // Catch: ParserException -> L16
        if (r102 == null) goto L13;
        if (initializeLoadedDescription() == true) goto L10;
        return false;
    L10:
        setDescriptionFile(null);
        return true;
    L13:
        throw new InvalidDescriptionException(Description.NOROOTDEVICE_EXCEPTION);     // Catch: ParserException -> L16
    L15:
        throw new InvalidDescriptionException(Description.NOROOT_EXCEPTION);     // Catch: ParserException -> L16
    L16:
        e = move-exception;
        throw new InvalidDescriptionException(e);
    }

    public Device(InputStream r100) throws InvalidDescriptionException {
        this(null, null);
        loadDescription(r100);
    }

    public boolean loadDescription(File r100) throws InvalidDescriptionException {
        Node r101 = UPnP.getXMLParser(this.castContext).parse(r100);     // Catch: ParserException -> L16
        this.rootNode = r101;     // Catch: ParserException -> L16
        if (r101 == null) goto L15;
        Node r102 = r101.getNode("device");     // Catch: ParserException -> L16
        this.deviceNode = r102;     // Catch: ParserException -> L16
        if (r102 == null) goto L13;
        if (initializeLoadedDescription() == true) goto L10;
        return false;
    L10:
        setDescriptionFile(r100);
        return true;
    L13:
        throw new InvalidDescriptionException(Description.NOROOTDEVICE_EXCEPTION, r100);     // Catch: ParserException -> L16
    L15:
        throw new InvalidDescriptionException(Description.NOROOT_EXCEPTION, r100);     // Catch: ParserException -> L16
    L16:
        e = move-exception;
        throw new InvalidDescriptionException(e);
    }

    public Device(Node r100) {
        this(null, r100);
    }

    public Device(Node r100, Node r101) {
        this.castContext = null;
        this.mIsDeviceStart = false;
        this.mAddDeviceMode = 0;
        this.isSupportSubscriber = false;
        this.mutex = new Mutex();
        this.iconBytesMap = new HashMap();
        this.userData = null;
        this.rootNode = r100;
        this.deviceNode = r101;
        if (r100 == null) goto L5;
        this.applicationUrl = r100.getApplicationUrl();
    L5:
        setUUID(UPnP.createUUID());
        setWirelessMode(false);
        this.mLogger = ContextManager.getLogger(this.castContext);
    }

    private void deviceActionControlRecieved(ActionRequest r100, Service r101) {
        if (Debug.isOn() != true) goto L6;
        r100.print();
    L6:
        if (Utils.shouldTrackAction(r100.getActionName()) == false) goto L8;
        ContextManager.getMonitor(null).receiveAction(r100.getActionName(), r100.getHeader(), r100.getContentString());
    L8:
        Action r102 = r101.getAction(r100.getActionName());
        if (r102 != null) goto L20;
        invalidActionControlRecieved(r100);
        return;
    L20:
        r102.getArgumentList().setReqArgs(r100.getArgumentList());     // Catch: IllegalArgumentException -> L18
        if (r102.performActionListener(r100) == true) goto L22;
        invalidActionControlRecieved(r100);
        return;
    L22:
        return;
    L18:
        invalidArgumentsControlRecieved(r100);
    }

    private void deviceControlRequestRecieved(ControlRequest r100, Service r101) {
        if (r100.isQueryControl() != true) goto L5;
        deviceQueryControlRecieved(new QueryRequest(this.castContext, r100), r101);
        return;
    L5:
        deviceActionControlRecieved(new ActionRequest(this.castContext, r100), r101);
    }

    private void deviceEventNewSubscriptionRecieved(Service r100, SubscriptionRequest r101) {
        String r102 = r101.getCallback();
        new URL(r102);     // Catch: Exception -> L6
        long r103 = r101.getTimeout();
        String r104 = Subscription.createSID();
        Subscriber r105 = new Subscriber();
        r105.setDeliveryURL(r102);
        r105.setTimeOut(r103);
        r105.setSID(r104);
        r100.addSubscriber(r105);
        SubscriptionResponse r106 = new SubscriptionResponse(this.castContext);
        r106.setStatusCode(200);
        r106.setSID(r104);
        r106.setTimeout(r103);
        r101.post(r106);
        r100.notifyAllStateVariables();
        return;
    L6:
        upnpBadSubscriptionRecieved(r101, 412);
    }

    private void deviceEventRenewSubscriptionRecieved(Service r100, SubscriptionRequest r101) {
        String r102 = r101.getSID();
        Subscriber r103 = r100.getSubscriber(r102);
        if (r103 != null) goto L6;
        upnpBadSubscriptionRecieved(r101, 412);
        return;
    L6:
        long r104 = r101.getTimeout();
        r103.setTimeOut(r104);
        r103.renew();
        SubscriptionResponse r105 = new SubscriptionResponse(this.castContext);
        r105.setStatusCode(200);
        r105.setSID(r102);
        r105.setTimeout(r104);
        r101.post(r105);
        if (Debug.isOn() != true) goto L10;
        r105.print();
        return;
    }

    private void deviceEventUnsubscriptionRecieved(Service r100, SubscriptionRequest r101) {
        Subscriber r102 = r100.getSubscriber(r101.getSID());
        if (r102 != null) goto L6;
        upnpBadSubscriptionRecieved(r101, 412);
        return;
    L6:
        r100.removeSubscriber(r102);
        SubscriptionResponse r103 = new SubscriptionResponse(this.castContext);
        r103.setStatusCode(200);
        r101.post(r103);
    }

    private void deviceQueryControlRecieved(QueryRequest r100, Service r101) {
        if (Debug.isOn() != true) goto L5;
        r100.print();
    L5:
        String r102 = r100.getVarName();
        if (r101.hasStateVariable(r102) == true) goto L10;
        invalidActionControlRecieved(r100);
        return;
    L10:
        if (getStateVariable(r102).performQueryListener(r100) == true) goto L13;
        invalidActionControlRecieved(r100);
        return;
    }

    private void upnpBadSubscriptionRecieved(SubscriptionRequest r100, int r101) {
        SubscriptionResponse r102 = new SubscriptionResponse(this.castContext);
        r102.setErrorResponse(r101);
        r100.post(r102);
    }

    public StateVariable getStateVariable(String r100, String r101) {
        if (r100 != null) goto L6;
        if (r101 != null) goto L6;
        return null;
    L6:
        ServiceList r102 = getServiceList();
        int r103 = r102.size();
        int r104 = 0;
        int r105 = 0;
    L7:
        if (r105 >= r103) goto L17;
        Service r106 = r102.getService(r105);
        if (r100 != null) goto L11;
    L13:
        StateVariable r107 = r106.getStateVariable(r101);
        if (r107 == null) goto L16;
        return r107;
    L16:
        r105 = r105 + 1;
        goto L7
    L11:
        if (r106.getServiceType().equals(r100) == true) goto L13;
    L17:
        DeviceList r108 = getDeviceList();
        int r109 = r108.size();
    L18:
        if (r104 >= r109) goto L23;
        StateVariable r110 = r108.getDevice(r104).getStateVariable(r100, r101);
        if (r110 != null) goto L21;
        r104 = r104 + 1;
        goto L18
    L21:
        return r110;
    L23:
        return null;
    }

    public String retryGetAbsoluteURL(String r100, String r101) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.length() <= 0) goto L23;
        return new URL(r100).toString();
    L8:
        e = move-exception;
        e.printStackTrace();
        if (TextUtils.isEmpty(r101) == false) goto L19;
    L16:
        return r100;
    L19:
        return new URL(HTTP.getAbsoluteURL(r101, r100)).toString();
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    L23:
        return "";
    }

    public void setActionListener(ActionListener r100, boolean r101) {
        setActionListener(r100);
        if (r101 != true) goto L7;
        DeviceList r102 = getDeviceList();
        int r103 = r102.size();
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L9;
        r102.getDevice(r104).setActionListener(r100, true);
        r104 = r104 + 1;
        goto L5
    L9:
        return;
    }

    public void setQueryListener(QueryListener r100, boolean r101) {
        setQueryListener(r100);
        if (r101 != true) goto L7;
        DeviceList r102 = getDeviceList();
        int r103 = r102.size();
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L9;
        r102.getDevice(r104).setQueryListener(r100, true);
        r104 = r104 + 1;
        goto L5
    L9:
        return;
    }

    public Device(Node r100, Node r101, String r102) {
        this.castContext = null;
        this.mIsDeviceStart = false;
        this.mAddDeviceMode = 0;
        this.isSupportSubscriber = false;
        this.mutex = new Mutex();
        this.iconBytesMap = new HashMap();
        this.userData = null;
        this.rootNode = r100;
        this.deviceNode = r101;
        this.applicationUrl = r102;
        setUUID(UPnP.createUUID());
        setWirelessMode(false);
        this.mLogger = ContextManager.getLogger(this.castContext);
    }

    public String getAbsoluteURL(String r100, String r101, String r102) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.length() <= 0) goto L63;
        return new URL(r100).toString();
    L8:
        e = move-exception;
        e.printStackTrace();
        if (r101 != null) goto L12;
    L13:
        if (r102 != null) goto L15;
    L32:
        if (r101 != null) goto L34;
        return r100;
    L34:
        if (r101.length() > 0) goto L52;
        return r100;
    L52:
        if (r101.endsWith(HTTP.URL_DEFAULT) == false) goto L45;
        if (r100.startsWith(HTTP.URL_DEFAULT) == false) goto L45;
        return new URL(r101 + r100.substring(1)).toString();
    L45:
        return new URL(r101.concat(r100)).toString();
    L53:
        return new URL(HTTP.getAbsoluteURL(r101, r100)).toString();
    L62:
        return r100;
    L15:
        if (r102.length() <= 0) goto L32;
        if (r102.endsWith(HTTP.URL_DEFAULT) == false) goto L25;
        if (r100.startsWith(HTTP.URL_DEFAULT) == false) goto L25;
        return new URL(r102 + r100.substring(1)).toString();
    L25:
        return new URL(r102.substring(0, r102.length() - new URL(r102).getPath().toString().length()) + r100).toString();
    L56:
        return new URL(HTTP.getAbsoluteURL(r102, r100)).toString();
    L29:
        Device r103 = getRootDevice();
        if (r103 == null) goto L32;
        String r104 = r103.getLocation();
        r101 = HTTP.getRequestHostURL(HTTP.getHost(r104), HTTP.getPort(r104));
        goto L32
    L12:
        if (r101.length() > 0) goto L32;
    L63:
        return "";
    }

    public boolean postSearchResponse(SSDPPacket r100, String r101, String r102) {
        String r103 = r100.getLocalAddress();
        String r104 = getRootDevice().getLocationURL(r103);
        SSDPSearchResponse r105 = new SSDPSearchResponse(this.castContext);
        r105.setLeaseTime(getLeaseTime());
        r105.setDate(cal);
        r105.setST(r101);
        r105.setUSN(r102);
        r105.setLocation(r104);
        r105.setBootId(getBootId());
        if (DLNAOptionUtils.isEnableDlnaSinkCustomizedService(this.castContext) == false) goto L5;
        r105.setPrivateService(4);
    L5:
        TimerUtil.waitTime(10);
        String r106 = r100.getRemoteAddress();
        int r107 = r100.getRemotePort();
        SSDPSearchResponseSocket r108 = new SSDPSearchResponseSocket(this.castContext);
        r108.open();
        int r109 = getSSDPAnnounceCount();
        int r110 = 0;
    L6:
        if (r110 >= r109) goto L8;
        r108.post(r106, r107, r105);
        r110 = r110 + 1;
        goto L6
    L8:
        return true;
    }
}
