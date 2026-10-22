package com.byted.cast.linkcommon.cybergarage.http;

import java.net.URL;

/* JADX INFO: loaded from: classes28.dex */
public class HTTP {
    public static final String BOOTID_UPNP_ORG = "BOOTID.UPNP.ORG";
    public static final String CACHE_CONTROL = "CACHE-CONTROL";
    public static final String CALLBACK = "CALLBACK";
    public static final String CHARSET = "charset";
    public static final String CHUNKED = "Chunked";
    public static final String CLOSE = "close";
    public static final String CONNECTION = "Connection";
    public static final String CONTENT_LANGUAGE = "Content-Language";
    public static final String CONTENT_LENGTH = "Content-Length";
    public static final String CONTENT_RANGE = "Content-Range";
    public static final String CONTENT_RANGE_BYTES = "bytes";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final byte CR = 13;
    public static final String CRLF = "\r\n";
    public static final String DATE = "Date";
    public static final int DEFAULT_CHUNK_SIZE = 524288;
    public static final int DEFAULT_PORT = 80;
    public static final int DEFAULT_TIMEOUT = 30;
    public static final String DEVICEID = "DEVICEID";
    public static final String ENCRYPT = "ENCRYPT";
    public static final String EXT = "EXT";
    public static final String GET = "GET";
    public static final String HEAD = "HEAD";
    public static final String HEADER_LINE_DELIM = " :";
    public static final String HOST = "HOST";
    public static final String IP = "IP";
    public static final String KEEP_ALIVE = "Keep-Alive";
    public static final byte LF = 10;
    public static final String LOCATION = "LOCATION";
    public static final String MAN = "MAN";
    public static final String MAX_AGE = "max-age";
    public static final String MX = "MX";
    public static final String MYNAME = "MYNAME";
    public static final String M_SEARCH = "M-SEARCH";
    public static final String NOTIFY = "NOTIFY";
    public static final String NO_CACHE = "no-cache";
    public static final String NT = "NT";
    public static final String NTS = "NTS";
    public static final String PORT = "PORT";
    public static final String POST = "POST";
    public static final String PRIVATE_SERVICE = "PRIVATESERVICE";
    public static final String PROTOCOL = "PROTOCOL";
    public static final String PROTOCOLVERSION = "PROTOCOLVERSION";
    public static final String RANGE = "Range";
    public static final String REQEST_LINE_DELIM = " ";
    public static final String SEARCHTARGET = "SEARCHTARGET";
    public static final String SEQ = "SEQ";
    public static final String SERVER = "SERVER";
    public static final String SERVICE = "SERVICE";
    public static final String SID = "SID";
    public static final String SINKVERSION = "SINKVERSION";
    public static final String SOAP_ACTION = "SOAPACTION";
    public static final String SOURCEVERSION = "SOURCEVERSION";
    public static final String ST = "ST";
    public static final String STATUS_LINE_DELIM = " ";
    public static final String SUBSCRIBE = "SUBSCRIBE";
    public static final String TAB = "\t";
    public static final String TIMEOUT = "TIMEOUT";
    public static final String TRANSFER_ENCODING = "Transfer-Encoding";
    public static final String UNSUBSCRIBE = "UNSUBSCRIBE";
    public static final String URL_DEFAULT = "/";
    public static final String USN = "USN";
    public static final String VERSION = "1.1";
    public static final String VERSION_10 = "1.0";
    public static final String VERSION_11 = "1.1";
    private static int chunkSize = 524288;

    public HTTP() {
    }

    public static final int getChunkSize() {
        return chunkSize;
    }

    public static final String getHost(String r100) {
        return new URL(r100).getHost();
    L4:
        return "";
    }

    public static final int getPort(String r100) {
        int r101 = new URL(r100).getPort();     // Catch: Exception -> L8
        if (r101 > 0) goto L7;
        return 80;
    L7:
        return r101;
    L12:
        return 80;
    }

    public static final boolean isAbsoluteURL(String r100) {
        new URL(r100);     // Catch: Exception -> L5
        return true;
    L5:
        return false;
    }

    public static final void setChunkSize(int r100) {
        chunkSize = r100;
    }

    public static final String toRelativeURL(String r100) {
        return toRelativeURL(r100, true);
    }

    public static final String getAbsoluteURL(String r100, String r101) {
        URL r102 = new URL(r100);     // Catch: Exception -> L4
        return r102.getProtocol() + "://" + r102.getHost() + ":" + r102.getPort() + toRelativeURL(r101);
    L4:
        return "";
    }

    public static final String getRequestHostURL(String r100, int r101) {
        return "http://" + r100 + ":" + r101;
    }

    public static final String toRelativeURL(String r100, boolean r101) {
        if (isAbsoluteURL(r100) == false) goto L5;
        URL r102 = new URL(r100);     // Catch: Exception -> L18
        String r103 = r102.getPath();     // Catch: Exception -> L18
        if (r101 != true) goto L15;
        String r104 = r102.getQuery();     // Catch: Exception -> L18
        if (r104.equals("") == true) goto L15;
        r103 = r103 + "?" + r104;     // Catch: Exception -> L18
    L15:
        if (r103.endsWith(URL_DEFAULT) == false) goto L24;
        return r103.substring(0, r103.length() - 1);
    L24:
        return r103;
    L25:
        return r100;
    L5:
        if (r100.length() > 0) goto L7;
        return r100;
    L7:
        if (r100.charAt(0) != '/') goto L23;
        return r100;
    L23:
        return URL_DEFAULT.concat(r100);
    }
}
