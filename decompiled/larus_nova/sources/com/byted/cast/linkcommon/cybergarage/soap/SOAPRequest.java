package com.byted.cast.linkcommon.cybergarage.soap;

import com.byted.cast.common.CommandExecuteStatus;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.ErrorCode;
import com.byted.cast.linkcommon.cybergarage.http.HTTPRequest;
import com.byted.cast.linkcommon.cybergarage.http.HTTPResponse;
import com.byted.cast.linkcommon.cybergarage.util.Debug;
import com.byted.cast.linkcommon.cybergarage.xml.Node;
import com.byted.cast.linkcommon.cybergarage.xml.Parser;
import com.byted.cast.linkcommon.cybergarage.xml.ParserException;
import java.io.ByteArrayInputStream;

/* JADX INFO: loaded from: classes28.dex */
public class SOAPRequest extends HTTPRequest {
    private static final String SOAPACTION = "SOAPACTION";
    private Node rootNode;

    private synchronized Node getRootNode() {
        monitor-enter(this);
        Node r100 = this.rootNode;     // Catch: Throwable -> L18
        if (r100 == null) goto L23;
        monitor-exit(this);
        return r100;
    L23:
        ByteArrayInputStream r101 = new ByteArrayInputStream(getContent());     // Catch: Exception -> L11 ParserException -> L13 Throwable -> L18
        Parser r102 = SOAP.getXMLParser();     // Catch: Exception -> L11 ParserException -> L13 Throwable -> L18
        if (r102 == null) goto L15;
        this.rootNode = r102.parse(r101);     // Catch: Exception -> L11 ParserException -> L13 Throwable -> L18
    L15:
        Node r103 = this.rootNode;     // Catch: Throwable -> L18
        monitor-exit(this);
        return r103;
    L13:
        e = move-exception;
        Debug.warning(e);     // Catch: Throwable -> L18
    L11:
        e = move-exception;
        Debug.warning(e);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public String getSOAPAction() {
        return getStringHeaderValue("SOAPACTION");
    }

    public Node getBodyNode() {
        Node r100 = getEnvelopeNode();
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.hasNodes() == true) goto L9;
        return null;
    L9:
        return r100.getNode(0);
    }

    public Node getEnvelopeNode() {
        return getRootNode();
    }

    @Override // com.byted.cast.linkcommon.cybergarage.http.HTTPRequest
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

    public SOAPRequest(ContextManager.CastContext r100) {
        super(r100);
        setContentType("text/xml; charset=\"utf-8\"");
        setMethod("POST");
    }

    private void setRootNode(Node r100) {
        this.rootNode = r100;
    }

    public boolean isSOAPAction(String r100) {
        String r101 = getHeaderValue("SOAPACTION");
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r101.equals(r100) != true) goto L8;
        return true;
    L8:
        String r102 = getSOAPAction();
        if (r102 != null) goto L12;
        return false;
    L12:
        return r102.equals(r100);
    }

    public void setContent(Node r100) {
        setContent("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" + r100.toString());
    }

    public void setEnvelopeNode(Node r100) {
        setRootNode(r100);
    }

    public void setSOAPAction(String r100) {
        setStringHeader("SOAPACTION", r100);
    }

    public SOAPRequest(ContextManager.CastContext r100, HTTPRequest r101) {
        super(r100);
        set(r101);
    }

    public SOAPResponse postMessage(String r100, int r101) {
        HTTPResponse r102 = post(r100, r101);
        SOAPResponse r103 = new SOAPResponse(this.mCastContext, r102);
        r103.setCommandExecuteStatus(r102.getCommandExecuteStatus());
        byte[] r104 = r103.getContent();
        if (r104.length > 0) goto L14;
        return r103;
    L14:
        ByteArrayInputStream r105 = new ByteArrayInputStream(r104);     // Catch: Exception -> L7
        r103.setEnvelopeNode(SOAP.getXMLParser().parse(r105));     // Catch: Exception -> L7
    L13:
        return r103;
    L7:
        e = move-exception;
        Debug.warning(e);
        CommandExecuteStatus r106 = new CommandExecuteStatus();
        if (e.getCause() == null) goto L11;
        r106.setDescription(e.getCause().toString());
    L12:
        r106.setException(e.getLocalizedMessage());
        r103.setCommandExecuteStatus(r106);
        goto L13
    L11:
        r106.setDescription(ErrorCode.DLNA_HTTP_PARSER_STREAM_ERROR_CODE_DESC);
        goto L12
    }
}
