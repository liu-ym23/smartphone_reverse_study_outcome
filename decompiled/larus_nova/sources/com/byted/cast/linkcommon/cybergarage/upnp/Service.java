package com.byted.cast.linkcommon.cybergarage.upnp;

import android.text.TextUtils;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.utils.DLNAOptionUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.byted.cast.linkcommon.cybergarage.upnp.control.ActionListener;
import com.byted.cast.linkcommon.cybergarage.upnp.control.QueryListener;
import com.byted.cast.linkcommon.cybergarage.upnp.device.InvalidDescriptionException;
import com.byted.cast.linkcommon.cybergarage.upnp.device.NTS;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.byted.cast.linkcommon.cybergarage.upnp.event.NotifyRequest;
import com.byted.cast.linkcommon.cybergarage.upnp.event.Subscriber;
import com.byted.cast.linkcommon.cybergarage.upnp.event.SubscriberList;
import com.byted.cast.linkcommon.cybergarage.upnp.ssdp.SSDPNotifyRequest;
import com.byted.cast.linkcommon.cybergarage.upnp.ssdp.SSDPNotifySocket;
import com.byted.cast.linkcommon.cybergarage.upnp.ssdp.SSDPPacket;
import com.byted.cast.linkcommon.cybergarage.upnp.xml.ServiceData;
import com.byted.cast.linkcommon.cybergarage.util.Mutex;
import com.byted.cast.linkcommon.cybergarage.util.StringUtil;
import com.byted.cast.linkcommon.cybergarage.xml.Node;
import com.byted.cast.linkcommon.cybergarage.xml.ParserException;
import com.byted.cast.linkcommon.cybergarage.xml.ParserType;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;

/* JADX INFO: loaded from: classes28.dex */
public class Service {
    private static final String CONFIG_ID = "configId";
    private static final String CONTROL_URL = "controlURL";
    public static final String CUSTOMIZED_SERVICE = "urn:schemas-upnp-org:service:CustomizedService";
    public static final String ELEM_NAME = "service";
    private static final String EVENT_SUB_URL = "eventSubURL";
    public static final String MAJOR = "major";
    public static final String MAJOR_VALUE = "1";
    public static final String MINOR = "minor";
    public static final String MINOR_VALUE = "0";
    private static final String SCPDURL = "SCPDURL";
    public static final String SCPD_ROOTNODE = "scpd";
    public static final String SCPD_ROOTNODE_NS = "urn:schemas-upnp-org:service-1-0";
    private static final String SERVICE_ID = "serviceId";
    private static final String SERVICE_TYPE = "serviceType";
    public static final String SPEC_VERSION = "specVersion";
    private ContextManager.CastContext mCastContext;
    private Mutex mutex;
    private Node serviceNode;
    private Object userData;

    private String getNotifyServiceTypeUSN() {
        return getDevice().getUDN() + "::" + getServiceType();
    }

    public void clearSID() {
        setSID("");
        setTimeout(0);
    }

    public ActionList getActionList() {
        ActionList r100 = new ActionList();
        Node r101 = getSCPDNode();
        if (r101 != null) goto L7;
        r101 = retryGetSCPDNode();
        if (r101 != null) goto L7;
        return r100;
    L7:
        Node r102 = r101.getNode(ActionList.ELEM_NAME);
        if (r102 != null) goto L10;
        return r100;
    L10:
        int r103 = r102.getNNodes();
        int r104 = 0;
    L11:
        if (r104 >= r103) goto L17;
        Node r105 = r102.getNode(r104);
        if (Action.isActionNode(r105) == false) goto L16;
        r100.add(new Action(this.mCastContext, this.serviceNode, r105));
    L16:
        r104 = r104 + 1;
        goto L11
    L17:
        return r100;
    }

    public Device getDevice() {
        return new Device(getRootNode(), getDeviceNode());
    }

    public ServiceStateTable getServiceStateTable() {
        ServiceStateTable r100 = new ServiceStateTable();
        Node r101 = getSCPDNode();
        if (r101 != null) goto L5;
        return r100;
    L5:
        Node r102 = r101.getNode(ServiceStateTable.ELEM_NAME);
        if (r102 != null) goto L8;
        return r100;
    L8:
        Node r103 = getServiceNode();
        int r104 = r102.getNNodes();
        int r105 = 0;
    L9:
        if (r105 >= r104) goto L15;
        Node r106 = r102.getNode(r105);
        if (StateVariable.isStateVariableNode(r106) == false) goto L14;
        r100.add(new StateVariable(this.mCastContext, r103, r106));
    L14:
        r105 = r105 + 1;
        goto L9
    L15:
        return r100;
    }

    public void lock() {
        this.mutex.lock();
    }

    public void unlock() {
        this.mutex.unlock();
    }

    private Node getDeviceNode() {
        Node r100 = getServiceNode().getParentNode();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getParentNode();
    }

    private Node getDeviceOfflineSCPDNode() {
        Device r100 = getRootDevice();
        if (r100 != null) goto L5;
        return null;
    L5:
        String r101 = getSCPDURL();
        String r102 = r100.getDescriptionFilePath();
        if (r102 == null) goto L26;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r102.concat(r101));
        if (r103.exists() == false) goto L26;
        Node r104 = getSCPDNode(r103);     // Catch: ParserException -> L11
    L12:
        if (r104 == null) goto L26;
        return r104;
    L11:
        r104 = null;
    L26:
        URL r105 = new URL(r100.getAbsoluteURL(r101));     // Catch: Exception -> L16
    L18:
        Node r106 = getSCPDNode(r105, true);     // Catch: ParserException -> L25
        if (r106 == null) goto L30;
        return r106;
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: ParserException -> L25
        r105 = null;
    L30:
        return getSCPDNode(new PolarisFileWrapper(r100.getDescriptionFilePath() + HTTP.toRelativeURL(r101)));
    L24:
        return null;
    }

    private String getNotifyServiceTypeNT() {
        return getServiceType();
    }

    private Node getRootNode() {
        return getServiceNode().getRootNode();
    }

    public int getConfigId() {
        Node r100 = getSCPDNode();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getAttributeIntegerValue(CONFIG_ID);
    }

    public String getControlURL() {
        return getServiceNode().getNodeValue(CONTROL_URL);
    }

    public String getDescriptionURL() {
        return getServiceData().getDescriptionURL();
    }

    public String getEventSubURL() {
        return getServiceNode().getNodeValue(EVENT_SUB_URL);
    }

    public Device getRootDevice() {
        return getDevice().getRootDevice();
    }

    public byte[] getSCPDData() {
        Node r100 = getSCPDNode();
        if (r100 != null) goto L7;
        return new byte[0];
    L7:
        return ("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" + r100.toString()).getBytes();
    }

    public Node getSCPDNode() {
        ServiceData r100 = getServiceData();
        Node r101 = r100.getSCPDNode();
        if (r101 == null) goto L5;
        return r101;
    L5:
        Device r102 = getRootDevice();
        if (r102 != null) goto L8;
        return null;
    L8:
        String r103 = getSCPDURL();
        String r104 = r102.getDescriptionFilePath();
        if (r104 == null) goto L37;
        PolarisFileWrapper r105 = new PolarisFileWrapper(r104.concat(r103));
        if (r105.exists() == false) goto L37;
        r101 = getSCPDNode(r105);     // Catch: ParserException -> L14
    L16:
        if (r101 == null) goto L37;
        r100.setSCPDNode(r101);
        return r101;
    L14:
        e = move-exception;
        e.printStackTrace();
    L37:
        URL r106 = new URL(r102.getAbsoluteURL(r103));     // Catch: Exception -> L21
    L23:
        Node r107 = getSCPDNode(r106, false);     // Catch: ParserException -> L27
        if (r107 == null) goto L35;
        r100.setSCPDNode(r107);     // Catch: ParserException -> L27
        return r107;
    L35:
        return getSCPDNode(new PolarisFileWrapper(r102.getDescriptionFilePath() + HTTP.toRelativeURL(r103)));
    L32:
        e = move-exception;
        e.printStackTrace();
        return null;
    L27:
        e = move-exception;
        e.printStackTrace();
    L21:
        e = move-exception;
        e.printStackTrace();     // Catch: ParserException -> L27
        r106 = null;
        goto L23
    }

    public String getSCPDURL() {
        return getServiceNode().getNodeValue(SCPDURL);
    }

    public String getSID() {
        return getServiceData().getSID();
    }

    public ServiceData getServiceData() {
        Node r100 = getServiceNode();
        ServiceData r101 = (ServiceData) r100.getUserData();
        if (r101 != null) goto L6;
        ServiceData r102 = new ServiceData();
        r100.setUserData(r102);
        r102.setNode(r100);
        return r102;
    L6:
        return r101;
    }

    public String getServiceID() {
        return getServiceNode().getNodeValue(SERVICE_ID);
    }

    public String getServiceType() {
        return getServiceNode().getNodeValue("serviceType");
    }

    public SubscriberList getSubscriberList() {
        return getServiceData().getSubscriberList();
    }

    public long getTimeout() {
        return getServiceData().getTimeout();
    }

    public boolean hasSID() {
        return StringUtil.hasData(getSID());
    }

    public boolean isSCPDNodeRequestSuccess() {
        Node r100 = getDeviceOfflineSCPDNode();
        if (r100 != null) goto L5;
        r100 = retryGetSCPDNode();
    L5:
        if (r100 == null) goto L7;
        return true;
    L7:
        return false;
    }

    public boolean isSubscribed() {
        return hasSID();
    }

    public void notifyAllStateVariables() {
        ServiceStateTable r100 = getServiceStateTable();
        int r101 = r100.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        StateVariable r103 = r100.getStateVariable(r102);
        if (r103.isSendEvents() != true) goto L7;
        notify(r103);
    L7:
        r102 = r102 + 1;
        goto L3
    }

    public Node retryGetSCPDNode() {
        ServiceData r100 = getServiceData();
        Node r101 = r100.getSCPDNode();
        if (r101 == null) goto L5;
        return r101;
    L5:
        Device r102 = getRootDevice();
        if (r102 != null) goto L8;
        return null;
    L8:
        String r103 = getSCPDURL();
        String r104 = r102.getDescriptionFilePath();
        if (r104 == null) goto L37;
        PolarisFileWrapper r105 = new PolarisFileWrapper(r104.concat(r103));
        if (r105.exists() == false) goto L37;
        r101 = getSCPDNode(r105);     // Catch: ParserException -> L14
    L15:
        if (r101 == null) goto L37;
        r100.setSCPDNode(r101);
        return r101;
    L37:
        URL r106 = new URL(r102.retryGetAbsoluteURL(r103));     // Catch: Exception -> L20
    L33:
        Node r107 = getSCPDNode(r106, false);     // Catch: ParserException -> L30
        if (r107 == null) goto L31;
        r100.setSCPDNode(r107);     // Catch: ParserException -> L30
        return r107;
    L31:
        return getSCPDNode(new PolarisFileWrapper(r102.getDescriptionFilePath() + HTTP.toRelativeURL(r103)));
    L29:
        return null;
    L20:
        r106 = null;
        goto L33
    }

    public void updateConfigId() {
        Node r100 = getSCPDNode();
        if (r100 != null) goto L5;
        return;
    L5:
        r100.setAttribute(CONFIG_ID, UPnP.caluculateConfigId(r100.toString()));
    }

    public Node getServiceNode() {
        return this.serviceNode;
    }

    public Object getUserData() {
        return this.userData;
    }

    public Service(ContextManager.CastContext r100) {
        this(r100, new Node("service"));
        Node r101 = new Node("specVersion");
        Node r102 = new Node("major");
        r102.setValue("1");
        r101.addNode(r102);
        Node r103 = new Node("minor");
        r103.setValue("0");
        r101.addNode(r103);
        Node r104 = new Node(SCPD_ROOTNODE);
        r104.addAttribute("xmlns", SCPD_ROOTNODE_NS);
        r104.addNode(r101);
        getServiceData().setSCPDNode(r104);
    }

    private Node getSCPDNode(File r100) throws ParserException {
        return UPnP.getXMLParser(this.mCastContext).parse(r100);
    }

    public static boolean isServiceNode(Node r100) {
        return "service".equals(r100.getName());
    }

    public void addAction(Action r100) {
        Iterator r101 = r100.getArgumentList().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((Argument) r101.next()).setService(this);
        goto L4
    L6:
        Node r102 = getSCPDNode();
        Node r103 = r102.getNode(ActionList.ELEM_NAME);
        if (r103 != null) goto L9;
        r103 = new Node(ActionList.ELEM_NAME);
        r102.addNode(r103);
    L9:
        r103.addNode(r100.getActionNode());
    }

    public void addStateVariable(StateVariable r100) {
        Node r101 = getSCPDNode().getNode(ServiceStateTable.ELEM_NAME);
        if (r101 != null) goto L5;
        r101 = new Node(ServiceStateTable.ELEM_NAME);
        getSCPDNode().addNode(r101);
    L5:
        r100.setServiceNode(getServiceNode());
        r101.addNode(r100.getStateVariableNode());
    }

    public void addSubscriber(Subscriber r100) {
        getSubscriberList().add(r100);
    }

    public void announce(String r100) {
        String r101 = getRootDevice().getLocationURL(r100);
        String r102 = getNotifyServiceTypeNT();
        String r103 = getNotifyServiceTypeUSN();
        if (DLNAOptionUtils.isEnableDlnaSinkCustomizedService(null) == false) goto L5;
    L9:
        Device r104 = getDevice();
        SSDPNotifyRequest r105 = new SSDPNotifyRequest(this.mCastContext);
        r105.setServer(UPnP.getServerName());
        r105.setLeaseTime(r104.getLeaseTime());
        r105.setLocation(r101);
        r105.setNTS(NTS.ALIVE);
        r105.setNT(r102);
        r105.setUSN(r103);
        if (DLNAOptionUtils.isEnableDlnaSinkCustomizedService(this.mCastContext) == false) goto L12;
        r105.setPrivateService(4);
    L12:
        SSDPNotifySocket r106 = new SSDPNotifySocket(this.mCastContext);
        Device.notifyWait();
        r106.post(r105, r100, 0);
        return;
    L5:
        if (TextUtils.isEmpty(r102) == true) goto L9;
        if (r102.contains(CUSTOMIZED_SERVICE) == false) goto L9;
    }

    public void byebye(String r100) {
        String r101 = getNotifyServiceTypeNT();
        String r102 = getNotifyServiceTypeUSN();
        SSDPNotifyRequest r103 = new SSDPNotifyRequest(this.mCastContext);
        r103.setNTS(NTS.BYEBYE);
        r103.setNT(r101);
        r103.setUSN(r102);
        SSDPNotifySocket r104 = new SSDPNotifySocket(this.mCastContext);
        Device.notifyWait();
        r104.post(r103, r100, 0);
    }

    public Action getAction(String r100) {
        ActionList r101 = getActionList();
        int r102 = r101.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        Action r104 = r101.getAction(r103);
        String r105 = r104.getName();
        if (r105 == null) goto L10;
        if (r105.equals(r100) == false) goto L10;
        return r104;
    L10:
        r103 = r103 + 1;
        goto L3
    L11:
        return null;
    }

    public StateVariable getStateVariable(String r100) {
        ServiceStateTable r101 = getServiceStateTable();
        int r102 = r101.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        StateVariable r104 = r101.getStateVariable(r103);
        String r105 = r104.getName();
        if (r105 == null) goto L10;
        if (r105.equals(r100) != true) goto L10;
        return r104;
    L10:
        r103 = r103 + 1;
        goto L3
    L11:
        return null;
    }

    public Subscriber getSubscriber(String r100) {
        SubscriberList r101 = getSubscriberList();
        int r102 = r101.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L14;
        Subscriber r104 = r101.getSubscriber(r103);
        if (r104 == null) goto L13;
        String r105 = r104.getSID();
        if (r105 == null) goto L13;
        if (r105.equals(r100) != true) goto L13;
        return r104;
    L13:
        r103 = r103 + 1;
        goto L3
    L14:
        return null;
    }

    public boolean hasStateVariable(String r100) {
        if (getStateVariable(r100) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isControlURL(String r100) {
        return isURL(getControlURL(), r100);
    }

    public boolean isEventSubURL(String r100) {
        return isURL(getEventSubURL(), r100);
    }

    public boolean isSCPDURL(String r100) {
        return isURL(getSCPDURL(), r100);
    }

    public boolean isService(String r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(getServiceType()) == true) goto L11;
        if (getServiceType().contains(r100) == false) goto L11;
        return true;
    L11:
        if (TextUtils.isEmpty(getServiceID()) == false) goto L13;
    L15:
        return false;
    L13:
        if (getServiceID().contains(r100) == false) goto L15;
        return true;
    }

    public boolean loadSCPD(String r100) throws InvalidDescriptionException {
        Node r101 = UPnP.getXMLParser(this.mCastContext).parse(r100);     // Catch: ParserException -> L9
        if (r101 != null) goto L6;
        return false;
    L6:
        getServiceData().setSCPDNode(r101);     // Catch: ParserException -> L9
        return true;
    L9:
        e = move-exception;
        throw new InvalidDescriptionException(e);
    }

    public void notify(StateVariable r100) {
        SubscriberList r101 = getSubscriberList();
        int r102 = r101.size();
        Subscriber[] r103 = new Subscriber[r102];
        int r104 = 0;
        int r105 = 0;
    L3:
        if (r105 >= r102) goto L5;
        r103[r105] = r101.getSubscriber(r105);
        r105 = r105 + 1;
        goto L3
    L5:
        int r106 = 0;
    L6:
        if (r106 >= r102) goto L14;
        Subscriber r107 = r103[r106];
        if (r107 == null) goto L13;
        if (r107.isExpired() != true) goto L13;
        removeSubscriber(r107);
    L13:
        r106 = r106 + 1;
        goto L6
    L14:
        int r108 = r101.size();
        Subscriber[] r109 = new Subscriber[r108];
        int r110 = 0;
    L15:
        if (r110 >= r108) goto L17;
        r109[r110] = r101.getSubscriber(r110);
        r110 = r110 + 1;
    L17:
        if (r104 >= r108) goto L23;
        Subscriber r111 = r109[r104];
        if (r111 == null) goto L22;
        notify(r111, r100);
    L22:
        r104 = r104 + 1;
        goto L17
    }

    public void removeSubscriber(Subscriber r100) {
        getSubscriberList().remove(r100);
    }

    public boolean serviceSearchResponse(SSDPPacket r100) {
        String r101 = r100.getST();
        if (r101 != null) goto L5;
        return false;
    L5:
        Device r102 = getDevice();
        String r103 = getNotifyServiceTypeNT();
        String r104 = getNotifyServiceTypeUSN();
        if (DLNAOptionUtils.isEnableDlnaSinkCustomizedService(null) == true) goto L13;
        if (TextUtils.isEmpty(r103) == true) goto L13;
        if (r103.contains(CUSTOMIZED_SERVICE) == false) goto L13;
        return false;
    L13:
        if (ST.isAllDevice(r101) != true) goto L16;
        r102.postSearchResponse(r100, r103, r104);
    L20:
        return true;
    L16:
        if (ST.isURNService(r101) != true) goto L20;
        String r105 = getServiceType();
        if (r101.equals(r105) != true) goto L20;
        r102.postSearchResponse(r100, r105, r104);
        goto L20
    }

    public void setActionListener(ActionListener r100) {
        ActionList r101 = getActionList();
        int r102 = r101.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.getAction(r103).setActionListener(r100);
        r103 = r103 + 1;
        goto L3
    }

    public void setControlURL(String r100) {
        getServiceNode().setNode(CONTROL_URL, r100);
    }

    public void setDescriptionURL(String r100) {
        getServiceData().setDescriptionURL(r100);
    }

    public void setEventSubURL(String r100) {
        getServiceNode().setNode(EVENT_SUB_URL, r100);
    }

    public void setQueryListener(QueryListener r100) {
        ServiceStateTable r101 = getServiceStateTable();
        int r102 = r101.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.getStateVariable(r103).setQueryListener(r100);
        r103 = r103 + 1;
        goto L3
    }

    public void setSCPDURL(String r100) {
        getServiceNode().setNode(SCPDURL, r100);
    }

    public void setSID(String r100) {
        getServiceData().setSID(r100);
    }

    public void setServiceID(String r100) {
        getServiceNode().setNode(SERVICE_ID, r100);
    }

    public void setServiceType(String r100) {
        getServiceNode().setNode("serviceType", r100);
    }

    public void setTimeout(long r100) {
        getServiceData().setTimeout(r100);
    }

    public void setUserData(Object r100) {
        this.userData = r100;
    }

    public boolean loadSCPD(File r100) throws ParserException {
        Node r101 = UPnP.getXMLParser(this.mCastContext).parse(r100);
        if (r101 != null) goto L6;
        return false;
    L6:
        getServiceData().setSCPDNode(r101);
        return true;
    }

    public boolean loadSCPD(InputStream r100) throws ParserException {
        Node r101 = UPnP.getXMLParser(this.mCastContext).parse(r100);
        if (r101 != null) goto L6;
        return false;
    L6:
        getServiceData().setSCPDNode(r101);
        return true;
    }

    public Service(ContextManager.CastContext r100, Node r101) {
        this.mutex = new Mutex();
        this.userData = null;
        this.serviceNode = r101;
        this.mCastContext = r100;
    }

    private Node getSCPDNode(URL r100, boolean r101) throws ParserException {
        return UPnP.getXMLParser(this.mCastContext).parse(r100, ParserType.SERVICE, r101);
    }

    private boolean isURL(String r100, String r101) {
        if (r100 == null) goto L12;
        if (r101 == null) goto L12;
        if (r101.equals(r100) != true) goto L10;
        return true;
    L10:
        if (r101.equals(HTTP.toRelativeURL(r100, false)) != true) goto L12;
        return true;
    L12:
        return false;
    }

    private boolean notify(Subscriber r100, StateVariable r101) {
        String r102 = r101.getName();
        String r103 = r101.getValue();
        String r104 = r100.getDeliveryHost();
        int r105 = r100.getDeliveryPort();
        NotifyRequest r106 = new NotifyRequest(this.mCastContext);
        r106.setRequest(r100, r102, r103);
        if (r106.post(r104, r105).isSuccessful() == true) goto L6;
        return false;
    L6:
        r100.incrementNotifyCount();
        return true;
    }
}
