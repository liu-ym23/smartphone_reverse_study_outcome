package com.byted.cast.linkcommon.cybergarage.soap;

import com.byted.cast.linkcommon.cybergarage.xml.Node;
import com.byted.cast.linkcommon.cybergarage.xml.Parser;

/* JADX INFO: loaded from: classes28.dex */
public class SOAP {
    public static final String BODY = "Body";
    public static final String CONTENT_TYPE = "text/xml; charset=\"utf-8\"";
    public static final String DELIM = ":";
    public static final String DETAIL = "detail";
    public static final String ENCSTYLE_URL = "http://schemas.xmlsoap.org/soap/encoding/";
    public static final String ENVELOPE = "Envelope";
    public static final String ERROR_CODE = "errorCode";
    public static final String ERROR_DESCRIPTION = "errorDescription";
    public static final String FAULT = "Fault";
    public static final String FAULTACTOR = "faultactor";
    public static final String FAULT_CODE = "faultcode";
    public static final String FAULT_STRING = "faultstring";
    public static final String METHODNS = "u";
    public static final String RESPONSE = "Response";
    public static final String RESULTSTATUS = "ResultStatus";
    public static final String UPNP_ERROR = "UPnPError";
    public static final String VERSION_HEADER = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
    public static final String XMLNS = "s";
    public static final String XMLNS_URL = "http://schemas.xmlsoap.org/soap/envelope/";
    private static Parser xmlParser;

    public SOAP() {
    }

    public static final Node createEnvelopeBodyNode() {
        Node r100 = new Node("s:Envelope");
        r100.setAttribute("xmlns:s", XMLNS_URL);
        r100.setAttribute("s:encodingStyle", ENCSTYLE_URL);
        r100.addNode(new Node("s:Body"));
        return r100;
    }

    public static final Parser getXMLParser() {
        return xmlParser;
    }

    public static final void setXMLParser(Parser r100) {
        xmlParser = r100;
    }
}
