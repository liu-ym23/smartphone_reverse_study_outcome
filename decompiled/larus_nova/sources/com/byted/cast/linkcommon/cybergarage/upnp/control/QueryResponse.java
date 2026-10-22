package com.byted.cast.linkcommon.cybergarage.upnp.control;

import com.byted.cast.common.ContextManager;
import com.byted.cast.linkcommon.cybergarage.soap.SOAPResponse;
import com.byted.cast.linkcommon.cybergarage.upnp.StateVariable;
import com.byted.cast.linkcommon.cybergarage.xml.Node;

/* JADX INFO: loaded from: classes28.dex */
public class QueryResponse extends ControlResponse {
    private Node getReturnNode() {
        Node r100 = getBodyNode();
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.hasNodes() == true) goto L8;
        return null;
    L8:
        Node r101 = r100.getNode(0);
        if (r101 != null) goto L12;
        return null;
    L12:
        if (r101.hasNodes() == true) goto L15;
        return null;
    L15:
        return r101.getNode(0);
    }

    public String getReturnValue() {
        Node r100 = getReturnNode();
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.getValue();
    }

    public QueryResponse(ContextManager.CastContext r100) {
        super(r100);
    }

    private Node createResponseNode(String r100) {
        Node r101 = new Node();
        r101.setName("u", Control.QUERY_STATE_VARIABLE_RESPONSE);
        r101.setNameSpace("u", Control.XMLNS);
        Node r102 = new Node();
        r102.setName("return");
        r102.setValue(r100);
        r101.addNode(r102);
        return r101;
    }

    public void setResponse(StateVariable r100) {
        String r101 = r100.getValue();
        setStatusCode(200);
        getBodyNode().addNode(createResponseNode(r101));
        setContent(getEnvelopeNode());
    }

    public QueryResponse(ContextManager.CastContext r100, SOAPResponse r101) {
        super(r100, r101);
    }
}
