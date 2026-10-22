package com.byted.cast.linkcommon.cybergarage.soap;

import com.byted.cast.common.ContextManager;
import com.byted.cast.linkcommon.cybergarage.http.HTTPResponse;
import com.byted.cast.linkcommon.cybergarage.util.Debug;
import com.byted.cast.linkcommon.cybergarage.xml.Node;

/* JADX INFO: loaded from: classes28.dex */
public class SOAPResponse extends HTTPResponse {
    private Node rootNode;

    public Node getBodyNode() {
        Node r100 = getEnvelopeNode();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getNodeEndsWith(SOAP.BODY);
    }

    public Node getEnvelopeNode() {
        return getRootNode();
    }

    public String getFaultActor() {
        Node r100 = getFaultActorNode();
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.getValue();
    }

    public Node getFaultActorNode() {
        Node r100 = getFaultNode();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getNodeEndsWith(SOAP.FAULTACTOR);
    }

    public String getFaultCode() {
        Node r100 = getFaultCodeNode();
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.getValue();
    }

    public Node getFaultCodeNode() {
        Node r100 = getFaultNode();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getNodeEndsWith(SOAP.FAULT_CODE);
    }

    public Node getFaultDetailNode() {
        Node r100 = getFaultNode();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getNodeEndsWith("detail");
    }

    public Node getFaultNode() {
        Node r100 = getBodyNode();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getNodeEndsWith(SOAP.FAULT);
    }

    public String getFaultString() {
        Node r100 = getFaultStringNode();
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.getValue();
    }

    public Node getFaultStringNode() {
        Node r100 = getFaultNode();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getNodeEndsWith(SOAP.FAULT_STRING);
    }

    @Override // com.byted.cast.linkcommon.cybergarage.http.HTTPResponse
    public void print() {
        Debug.message(toString());
        if (hasContent() != true) goto L5;
        return;
    L5:
        Node r100 = getRootNode();
        if (r100 != null) goto L8;
        return;
    L8:
        Debug.message(r100.toString());
    }

    private Node getRootNode() {
        return this.rootNode;
    }

    public SOAPResponse(ContextManager.CastContext r100) {
        super(r100);
        setRootNode(SOAP.createEnvelopeBodyNode());
        setContentType("text/xml; charset=\"utf-8\"");
    }

    private void setRootNode(Node r100) {
        this.rootNode = r100;
    }

    public Node getMethodResponseNode(String r100) {
        Node r101 = getBodyNode();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getNodeEndsWith(r100 + SOAP.RESPONSE);
    }

    public void setContent(Node r100) {
        setContent("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" + r100.toString());
    }

    public void setEnvelopeNode(Node r100) {
        setRootNode(r100);
    }

    public SOAPResponse(ContextManager.CastContext r100, HTTPResponse r101) {
        super(r100, r101);
        setRootNode(SOAP.createEnvelopeBodyNode());
        setContentType("text/xml; charset=\"utf-8\"");
    }

    public SOAPResponse(ContextManager.CastContext r100, SOAPResponse r101) {
        super(r100, r101);
        setEnvelopeNode(r101.getEnvelopeNode());
        setContentType("text/xml; charset=\"utf-8\"");
    }
}
