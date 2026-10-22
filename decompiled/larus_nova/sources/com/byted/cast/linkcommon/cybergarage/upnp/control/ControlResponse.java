package com.byted.cast.linkcommon.cybergarage.upnp.control;

import com.byted.cast.common.ContextManager;
import com.byted.cast.linkcommon.cybergarage.soap.SOAP;
import com.byted.cast.linkcommon.cybergarage.soap.SOAPResponse;
import com.byted.cast.linkcommon.cybergarage.upnp.UPnP;
import com.byted.cast.linkcommon.cybergarage.upnp.UPnPStatus;
import com.byted.cast.linkcommon.cybergarage.xml.Node;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;

/* JADX INFO: loaded from: classes28.dex */
public class ControlResponse extends SOAPResponse {
    public static final String FAULT_CODE = "Client";
    public static final String FAULT_STRING = "UPnPError";
    private UPnPStatus upnpErr;

    private Node getUPnPErrorCodeNode() {
        Node r100 = getUPnPErrorNode();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getNodeEndsWith("errorCode");
    }

    private Node getUPnPErrorDescriptionNode() {
        Node r100 = getUPnPErrorNode();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getNodeEndsWith(SOAP.ERROR_DESCRIPTION);
    }

    private Node getUPnPErrorNode() {
        Node r100 = getFaultDetailNode();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getNodeEndsWith("UPnPError");
    }

    public UPnPStatus getUPnPError() {
        int r100 = getUPnPErrorCode();
        String r101 = getUPnPErrorDescription();
        this.upnpErr.setCode(r100);
        this.upnpErr.setDescription(r101);
        return this.upnpErr;
    }

    public int getUPnPErrorCode() {
        Node r100 = getUPnPErrorCodeNode();
        if (r100 != null) goto L9;
        return -1;
    L9:
        return CastIntegerProtector.parseInt(r100.getValue());
    L8:
        return -1;
    }

    public String getUPnPErrorDescription() {
        Node r100 = getUPnPErrorDescriptionNode();
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.getValue();
    }

    public ControlResponse(ContextManager.CastContext r100) {
        super(r100);
        this.upnpErr = new UPnPStatus();
        setServer(UPnP.getServerName());
    }

    private Node createFaultResponseNode(int r100) {
        return createFaultResponseNode(r100, UPnPStatus.code2String(r100));
    }

    public void setFaultResponse(int r100) {
        setFaultResponse(r100, UPnPStatus.code2String(r100));
    }

    public ControlResponse(ContextManager.CastContext r100, SOAPResponse r101) {
        super(r100, r101);
        this.upnpErr = new UPnPStatus();
    }

    private Node createFaultResponseNode(int r100, String r101) {
        Node r102 = new Node("s:Fault");
        Node r103 = new Node(SOAP.FAULT_CODE);
        r103.setValue("s:Client");
        r102.addNode(r103);
        Node r104 = new Node(SOAP.FAULT_STRING);
        r104.setValue("UPnPError");
        r102.addNode(r104);
        Node r105 = new Node("detail");
        r102.addNode(r105);
        Node r106 = new Node("UPnPError");
        r106.setAttribute("xmlns", Control.XMLNS);
        r105.addNode(r106);
        Node r107 = new Node("errorCode");
        r107.setValue(r100);
        r106.addNode(r107);
        Node r108 = new Node(SOAP.ERROR_DESCRIPTION);
        r108.setValue(r101);
        r106.addNode(r108);
        return r102;
    }

    public void setFaultResponse(int r100, String r101) {
        setStatusCode(500);
        getBodyNode().addNode(createFaultResponseNode(r100, r101));
        setContent(getEnvelopeNode());
    }
}
