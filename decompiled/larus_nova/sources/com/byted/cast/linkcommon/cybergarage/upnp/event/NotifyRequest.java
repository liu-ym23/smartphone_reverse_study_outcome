package com.byted.cast.linkcommon.cybergarage.upnp.event;

import com.byted.cast.common.ContextManager;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.byted.cast.linkcommon.cybergarage.http.HTTPRequest;
import com.byted.cast.linkcommon.cybergarage.soap.SOAPRequest;
import com.byted.cast.linkcommon.cybergarage.upnp.device.NT;
import com.byted.cast.linkcommon.cybergarage.upnp.device.NTS;
import com.byted.cast.linkcommon.cybergarage.xml.Node;

/* JADX INFO: loaded from: classes28.dex */
public class NotifyRequest extends SOAPRequest {
    private static final String PROPERTY = "property";
    private static final String PROPERTYSET = "propertyset";
    private static final String XMLNS = "e";

    public int getEncrypt() {
        return getIntegerHeaderValue(HTTP.ENCRYPT);
    }

    public int getPrivateService() {
        return getIntegerHeaderValue(HTTP.PRIVATE_SERVICE);
    }

    public PropertyList getPropertyList() {
        PropertyList r100 = new PropertyList();
        Node r101 = getEnvelopeNode();
        if (r101 != null) goto L5;
        return r100;
    L5:
        int r102 = 0;
    L7:
        if (r102 >= r101.getNNodes()) goto L13;
        Node r103 = r101.getNode(r102);
        if (r103 == null) goto L12;
        r100.add(getProperty(r103.getNode(0)));
    L12:
        r102 = r102 + 1;
        goto L7
    L13:
        return r100;
    }

    public long getSEQ() {
        return getLongHeaderValue(HTTP.SEQ);
    }

    public String getSID() {
        return Subscription.getSID(getHeaderValue(HTTP.SID));
    }

    private Node getVariableNode() {
        Node r100 = getEnvelopeNode();
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.hasNodes() == true) goto L8;
        return null;
    L8:
        Node r101 = r100.getNode(0);
        if (r101.hasNodes() == true) goto L12;
        return null;
    L12:
        return r101.getNode(0);
    }

    public NotifyRequest(ContextManager.CastContext r100) {
        super(r100);
    }

    private Property getProperty(Node r100) {
        Property r101 = new Property();
        if (r100 != null) goto L5;
        return r101;
    L5:
        String r102 = r100.getName();
        int r103 = r102.lastIndexOf(58);
        if (r103 == (-1)) goto L8;
        r102 = r102.substring(r103 + 1);
    L8:
        r101.setName(r102);
        r101.setValue(r100.getValue());
        return r101;
    }

    public void setEncrypt(int r100) {
        setHeader(HTTP.ENCRYPT, r100);
    }

    public void setNT(String r100) {
        setHeader(HTTP.NT, r100);
    }

    public void setNTS(String r100) {
        setHeader(HTTP.NTS, r100);
    }

    public void setPrivateService(int r100) {
        setHeader(HTTP.PRIVATE_SERVICE, r100);
    }

    public void setSEQ(long r100) {
        setHeader(HTTP.SEQ, Long.toString(r100));
    }

    public void setSID(String r100) {
        setHeader(HTTP.SID, Subscription.toSIDHeaderString(r100));
    }

    public NotifyRequest(ContextManager.CastContext r100, HTTPRequest r101) {
        super(r100);
        set(r101);
    }

    private Node createPropertySetNode(String r100, String r101) {
        Node r102 = new Node(PROPERTYSET);
        r102.setNameSpace("e", Subscription.XMLNS);
        Node r103 = new Node("property");
        r102.addNode(r103);
        Node r104 = new Node(r100);
        r104.setValue(r101);
        r103.addNode(r104);
        return r102;
    }

    public boolean setRequest(Subscriber r100, String r101, String r102) {
        r100.getDeliveryURL();
        String r103 = r100.getSID();
        long r104 = r100.getNotifyCount();
        String r105 = r100.getDeliveryHost();
        String r106 = r100.getDeliveryPath();
        int r107 = r100.getDeliveryPort();
        setMethod(HTTP.NOTIFY);
        setURI(r106);
        setHost(r105, r107);
        setNT(NT.EVENT);
        setNTS(NTS.PROPCHANGE);
        setSID(r103);
        setSEQ(r104);
        setContentType("text/xml; charset=\"utf-8\"");
        setContent(createPropertySetNode(r101, r102));
        return true;
    }
}
