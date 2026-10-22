package com.byted.cast.linkcommon.cybergarage.http;

import android.text.TextUtils;
import com.byted.cast.common.CastLogger;
import com.byted.cast.common.CastMonitor;
import com.byted.cast.common.CommandExecuteStatus;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.source.IPlayerListener;
import com.byted.cast.linkcommon.cybergarage.net.HostInterface;
import com.byted.cast.linkcommon.cybergarage.util.Debug;
import com.byted.cast.linkcommon.cybergarage.util.StringUtil;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.Calendar;
import java.util.StringTokenizer;
import java.util.Vector;

/* JADX INFO: loaded from: classes28.dex */
public class HTTPPacket {
    private CommandExecuteStatus commandExecuteStatus;
    private byte[] content;
    private InputStream contentInput;
    private String firstLine;
    private Vector httpHeaderList;
    protected ContextManager.CastContext mCastContext;
    protected CastLogger mCastLogger;
    protected CastMonitor mCastMonitor;
    private String version;

    public long[] getContentRange() {
        long[] r100 = {0, 0, 0};
        if (hasContentRange() == true) goto L5;
        return r100;
    L5:
        String r101 = getHeaderValue("Content-Range");
        if (r101.length() > 0) goto L9;
        r101 = getHeaderValue("Range");
    L9:
        if (r101.length() > 0) goto L11;
        return r100;
    L11:
        StringTokenizer r102 = new StringTokenizer(r101, " =");
        if (r102.hasMoreTokens() == true) goto L14;
        return r100;
    L14:
        r102.nextToken(" ");
        if (r102.hasMoreTokens() == true) goto L37;
        return r100;
    L37:
        r100[0] = CastLongProtector.parseLong(r102.nextToken(" -"));     // Catch: NumberFormatException -> L20
    L22:
        if (r102.hasMoreTokens() == true) goto L35;
        return r100;
    L35:
        r100[1] = CastLongProtector.parseLong(r102.nextToken("-/"));     // Catch: NumberFormatException -> L27
    L29:
        if (r102.hasMoreTokens() == true) goto L39;
        return r100;
    L39:
        r100[2] = CastLongProtector.parseLong(r102.nextToken(HTTP.URL_DEFAULT));     // Catch: NumberFormatException -> L34
    L33:
        return r100;
    }

    public void clearHeaders() {
        this.httpHeaderList.clear();
        this.httpHeaderList = new Vector();
    }

    public String getCacheControl() {
        return getHeaderValue(HTTP.CACHE_CONTROL);
    }

    public String getConnection() {
        return getHeaderValue("Connection");
    }

    public String getContentLanguage() {
        return getHeaderValue(HTTP.CONTENT_LANGUAGE);
    }

    public long getContentLength() {
        return getLongHeaderValue("Content-Length");
    }

    public String getContentType() {
        return getHeaderValue("Content-Type");
    }

    public String getDate() {
        return getHeaderValue("Date");
    }

    public String getHeaderString() {
        StringBuffer r100 = new StringBuffer();
        int r101 = getNHeaders();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L6;
        HTTPHeader r103 = getHeader(r102);
        r100.append(r103.getName());
        r100.append(": ");
        r100.append(r103.getValue());
        r100.append("\r\n");
        r102 = r102 + 1;
        goto L3
    L6:
        return r100.toString();
    }

    public String getHost() {
        return getHeaderValue(HTTP.HOST);
    }

    public int getNHeaders() {
        return this.httpHeaderList.size();
    }

    public String getServer() {
        return getHeaderValue(HTTP.SERVER);
    }

    public String getTransferEncoding() {
        return getHeaderValue("Transfer-Encoding");
    }

    public boolean hasConnection() {
        return hasHeader("Connection");
    }

    public boolean hasContent() {
        if (this.content.length <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasContentInputStream() {
        if (this.contentInput == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasContentRange() {
        if (hasHeader("Content-Range") == false) goto L5;
    L8:
        return true;
    L5:
        if (hasHeader("Range") == true) goto L8;
        return false;
    }

    public boolean hasFirstLine() {
        if (this.firstLine.length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasTransferEncoding() {
        return hasHeader("Transfer-Encoding");
    }

    public void init() {
        setFirstLine("");
        clearHeaders();
        setContent(new byte[0], false);
        setContentInputStream(null);
    }

    private HTTPPacket() {
        this.firstLine = "";
        this.httpHeaderList = new Vector();
        this.content = new byte[0];
        this.contentInput = null;
    }

    public String getCharSet() {
        String r100 = getContentType();
        if (r100 != null) goto L5;
        return "";
    L5:
        String r101 = r100.toLowerCase();
        int r102 = r101.indexOf("charset");
        if (r102 >= 0) goto L8;
        return "";
    L8:
        int r103 = (r102 + 7) + 1;
        String r104 = new String(r101.getBytes(), r103, r101.length() - r103);
        if (r104.length() >= 0) goto L12;
        return "";
    L12:
        if (r104.charAt(0) != '\"') goto L15;
        r104 = r104.substring(1, r104.length() - 1);
    L15:
        if (r104.length() >= 0) goto L18;
        return "";
    L18:
        if (r104.charAt(r104.length() - 1) == '\"') goto L20;
        return r104;
    L20:
        return r104.substring(0, r104.length() - 1);
    }

    public long getContentRangeFirstPosition() {
        return getContentRange()[0];
    }

    public long getContentRangeInstanceLength() {
        return getContentRange()[2];
    }

    public long getContentRangeLastPosition() {
        return getContentRange()[1];
    }

    public String getContentString() {
        String r100 = getCharSet();
        if (r100 == null) goto L13;
        if (r100.length() <= 0) goto L13;
        return new String(this.content, r100);
    L9:
        e = move-exception;
        this.mCastLogger.e(e.getMessage());
        return new String(this.content);
    L13:
        return new String(this.content);
    }

    public boolean isChunked() {
        if (hasTransferEncoding() == true) goto L5;
        return false;
    L5:
        String r100 = getTransferEncoding();
        if (r100 != null) goto L9;
        return false;
    L9:
        return r100.equalsIgnoreCase(HTTP.CHUNKED);
    }

    public boolean isCloseConnection() {
        if (hasConnection() == true) goto L5;
        return false;
    L5:
        String r100 = getConnection();
        if (r100 != null) goto L9;
        return false;
    L9:
        return r100.equalsIgnoreCase("close");
    }

    public boolean isKeepAliveConnection() {
        if (hasConnection() == true) goto L5;
        return false;
    L5:
        String r100 = getConnection();
        if (r100 != null) goto L9;
        return false;
    L9:
        return r100.equalsIgnoreCase(HTTP.KEEP_ALIVE);
    }

    public CommandExecuteStatus getCommandExecuteStatus() {
        return this.commandExecuteStatus;
    }

    public byte[] getContent() {
        return this.content;
    }

    public InputStream getContentInputStream() {
        return this.contentInput;
    }

    public String getFirstLine() {
        return this.firstLine;
    }

    public String getVersion() {
        return this.version;
    }

    public HTTPPacket(ContextManager.CastContext r100) {
        this.firstLine = "";
        this.httpHeaderList = new Vector();
        this.content = new byte[0];
        this.contentInput = null;
        this.mCastContext = r100;
        this.mCastLogger = ContextManager.getLogger(r100);
        this.mCastMonitor = ContextManager.getMonitor(this.mCastContext);
        setVersion("1.1");
        setContentInputStream(null);
    }

    private String readLine(BufferedInputStream r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        byte[] r102 = new byte[1];
        int r103 = r100.read(r102);     // Catch: Throwable -> L15 IOException -> L17 InterruptedIOException -> L26
    L4:
        if (r103 <= 0) goto L13;
        byte r104 = r102[0];     // Catch: Throwable -> L15 IOException -> L17 InterruptedIOException -> L26
        if (r104 == 10) goto L13;
        if (r104 == 13) goto L11;
        r101.write(r104);     // Catch: Throwable -> L15 IOException -> L17 InterruptedIOException -> L26
    L11:
        r103 = r100.read(r102);     // Catch: Throwable -> L15 IOException -> L17 InterruptedIOException -> L26
        goto L4
    L13:
        r101.flush();     // Catch: IOException -> L28
        r101.close();     // Catch: IOException -> L28
    L35:
    L31:
        return r101.toString();
    L15:
        th = move-exception;
        r101.flush();     // Catch: IOException -> L23
        r101.close();     // Catch: IOException -> L23
    L25:
        throw th;
    L23:
        e = move-exception;
        e.printStackTrace();
    L26:
        r101.flush();     // Catch: IOException -> L28
        r101.close();     // Catch: IOException -> L28
    L17:
        e = move-exception;
        this.mCastLogger.e(e.getMessage());     // Catch: Throwable -> L15
        r101.flush();     // Catch: IOException -> L28
        r101.close();     // Catch: IOException -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
        goto L31
    }

    private void setFirstLine(String r100) {
        this.firstLine = r100;
    }

    public void addHeader(HTTPHeader r100) {
        this.httpHeaderList.add(r100);
    }

    public String getFirstLineToken(int r100) {
        StringTokenizer r101 = new StringTokenizer(this.firstLine, " ");
        int r102 = 0;
        String r103 = "";
    L3:
        if (r102 > r100) goto L8;
        if (r101.hasMoreTokens() == false) goto L6;
        r103 = r101.nextToken();
        r102 = r102 + 1;
        goto L3
    L6:
        return "";
    L8:
        return r103;
    }

    public HTTPHeader getHeader(String r100) {
        int r101 = getNHeaders();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L10;
        HTTPHeader r103 = getHeader(r102);
        String r104 = r103.getName();
        if (TextUtils.isEmpty(r104) == true) goto L9;
        if (r104.equalsIgnoreCase(r100) == false) goto L9;
        return r103;
    L9:
        r102 = r102 + 1;
        goto L3
    L10:
        return null;
    }

    public String getHeaderValue(String r100) {
        HTTPHeader r101 = getHeader(r100);
        if (r101 != null) goto L7;
        return "";
    L7:
        return r101.getValue();
    }

    public int getIntegerHeaderValue(String r100) {
        HTTPHeader r101 = getHeader(r100);
        if (r101 != null) goto L7;
        return 0;
    L7:
        return StringUtil.toInteger(r101.getValue());
    }

    public long getLongHeaderValue(String r100) {
        HTTPHeader r101 = getHeader(r100);
        if (r101 != null) goto L7;
        return 0;
    L7:
        return StringUtil.toLong(r101.getValue());
    }

    public String getStringHeaderValue(String r100) {
        return getStringHeaderValue(r100, "\"", "\"");
    }

    public boolean hasHeader(String r100) {
        if (getHeader(r100) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean read(HTTPSocket r100) {
        init();
        return set(r100);
    }

    public void set(HTTPPacket r100) {
        setFirstLine(r100.getFirstLine());
        clearHeaders();
        int r101 = r100.getNHeaders();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        addHeader(r100.getHeader(r102));
        r102 = r102 + 1;
        goto L3
    L5:
        setContent(r100.getContent());
    }

    public void setCacheControl(int r100) {
        setCacheControl(HTTP.MAX_AGE, r100);
    }

    public void setCommandExecuteStatus(CommandExecuteStatus r100) {
        this.commandExecuteStatus = r100;
    }

    public void setConnection(String r100) {
        setHeader("Connection", r100);
    }

    public void setContent(String r100) {
        setContent(r100, true);
    }

    public void setContentInputStream(InputStream r100) {
        this.contentInput = r100;
    }

    public void setContentLanguage(String r100) {
        setHeader(HTTP.CONTENT_LANGUAGE, r100);
    }

    public void setContentLength(long r100) {
        setLongHeader("Content-Length", r100);
    }

    public void setContentType(String r100) {
        setHeader("Content-Type", r100);
    }

    public void setDate(Calendar r100) {
        setHeader("Date", new Date(r100).getDateString());
    }

    public void setHeader(HTTPHeader r100) {
        setHeader(r100.getName(), r100.getValue());
    }

    public void setHost(String r100) {
        if (HostInterface.isIPv6Address(r100) != true) goto L5;
        r100 = "[" + r100 + "]";
    L5:
        setHeader(HTTP.HOST, r100);
    }

    public void setServer(String r100) {
        setHeader(HTTP.SERVER, r100);
    }

    public void setTransferEncoding(String r100) {
        setHeader("Transfer-Encoding", r100);
    }

    public void setVersion(String r100) {
        this.version = r100;
    }

    public HTTPHeader getHeader(int r100) {
        return (HTTPHeader) this.httpHeaderList.get(r100);
    }

    public boolean set(HTTPSocket r100) {
        return set(r100.getInputStream());
    }

    public void setCacheControl(String r100) {
        setHeader(HTTP.CACHE_CONTROL, r100);
    }

    public void setContent(byte[] r100) {
        setContent(r100, true);
    }

    public boolean set(InputStream r100) {
        return set(r100, false);
    }

    public HTTPPacket(ContextManager.CastContext r100, HTTPPacket r101) {
        this.firstLine = "";
        this.httpHeaderList = new Vector();
        this.content = new byte[0];
        this.contentInput = null;
        this.mCastContext = r100;
        this.mCastLogger = ContextManager.getLogger(r100);
        this.mCastMonitor = ContextManager.getMonitor(this.mCastContext);
        setVersion("1.1");
        set(r101);
        setContentInputStream(null);
    }

    public void addHeader(String r100, String r101) {
        HTTPHeader r102 = new HTTPHeader(r100, r101);
        this.httpHeaderList.add(r102);
    }

    public boolean set(InputStream r210, boolean r211) {
        BufferedInputStream r100 = new BufferedInputStream(r210);     // Catch: Exception -> L91
        String r101 = readLine(r100);     // Catch: Exception -> L91
        if (r101 != null) goto L6;
    L89:
        Debug.warning("HTTPPacket set firstLine is null");     // Catch: Exception -> L91
        CommandExecuteStatus r102 = new CommandExecuteStatus();     // Catch: Exception -> L91
        r102.setPlayErrorCode(IPlayerListener.ERROR_CODE_BDDLNA_INVALID_RESPONSE_STATUS);     // Catch: Exception -> L91
        r102.setDescription(IPlayerListener.ERROR_MSG_BDDLNA_INVALID_RESPONSE_STATUS);     // Catch: Exception -> L91
        r102.setException(IPlayerListener.ERROR_MSG_BDDLNA_INVALID_RESPONSE_STATUS);     // Catch: Exception -> L91
        setCommandExecuteStatus(r102);     // Catch: Exception -> L91
        return false;
    L6:
        if (r101.length() <= 0) goto L89;
        setFirstLine(r101);     // Catch: Exception -> L91
        if (new HTTPStatus(r101).getStatusCode() != 100) goto L24;
        String r103 = readLine(r100);     // Catch: Exception -> L91
    L11:
        if (r103 == null) goto L18;
        if (r103.length() <= 0) goto L18;
        HTTPHeader r104 = new HTTPHeader(r103);     // Catch: Exception -> L91
        if (r104.hasName() != true) goto L17;
        setHeader(r104);     // Catch: Exception -> L91
    L17:
        r103 = readLine(r100);     // Catch: Exception -> L91
    L18:
        String r105 = readLine(r100);     // Catch: Exception -> L91
        if (r105 != null) goto L21;
    L23:
        return true;
    L21:
        if (r105.length() <= 0) goto L23;
        setFirstLine(r105);     // Catch: Exception -> L91
    L24:
        String r106 = readLine(r100);     // Catch: Exception -> L91
    L25:
        if (r106 == null) goto L33;
        if (r106.length() <= 0) goto L33;
        HTTPHeader r107 = new HTTPHeader(r106);     // Catch: Exception -> L91
        if (r107.hasName() != true) goto L31;
        setHeader(r107);     // Catch: Exception -> L91
    L31:
        r106 = readLine(r100);     // Catch: Exception -> L91
    L33:
        if (r211 != true) goto L36;
        setContent("", false);     // Catch: Exception -> L91
        return true;
    L36:
        boolean r108 = isChunked();     // Catch: Exception -> L91
        long r109 = 0;
        if (r108 == true) goto L100;
        long r110 = getContentLength();     // Catch: Exception -> L91
    L47:
        ByteArrayOutputStream r111 = new ByteArrayOutputStream();     // Catch: Exception -> L91
    L49:
        if (r109 >= r110) goto L87;
        long r112 = HTTP.getChunkSize();     // Catch: Exception -> L91
        if (r110 <= r112) goto L53;
        long r113 = r112;
    L54:
        byte[] r114 = new byte[(int) r113];     // Catch: Exception -> L91
        long r115 = r109;
    L57:
        if (r115 >= r110) goto L70;
        long r116 = r110 - r115;
        if (r112 >= r116) goto L61;
        long r117 = r112;
    L102:
        int r118 = r100.read(r114, 0, (int) r117);     // Catch: Exception -> L68
        if (r118 < 0) goto L70;
        r111.write(r114, 0, r118);     // Catch: Exception -> L68
        r115 = r115 + ((long) r118);
        goto L57
    L68:
        e = move-exception;
        this.mCastLogger.d(e.getMessage());     // Catch: Exception -> L91
        goto L70
    L61:
        r117 = r116;
    L70:
        if (r108 != true) goto L85;
        long r119 = 0;
    L72:
        long r120 = 2;
        long r121 = r100.skip(r120 - r119);     // Catch: Exception -> L91
        long r122 = 0;
        if (r121 < 0) goto L98;
        r119 = r119 + r121;
        if (r119 < r120) goto L72;
    L98:
        String r123 = readLine(r100);     // Catch: Exception -> L82
        long r124 = CastLongProtector.parseLong(new String(r123.getBytes(), 0, r123.length() - 2), 16);     // Catch: Exception -> L94
    L84:
        r110 = r124;
    L86:
        r109 = r122;
    L83:
        r124 = 0;
        goto L84
    L85:
        r122 = 0;
        r110 = 0;
        goto L86
    L53:
        r113 = r110;
        goto L54
    L87:
        setContent(r111.toByteArray(), false);     // Catch: Exception -> L91
        return true;
    L100:
        String r125 = readLine(r100);     // Catch: Exception -> L43
        if (r125 == null) goto L45;
        r110 = CastLongProtector.parseLong(r125.trim(), 16);     // Catch: Exception -> L43
    L45:
        r110 = 0;
    L43:
        e = move-exception;
        Debug.warning("set ", e);     // Catch: Exception -> L91
    L91:
        e = move-exception;
        this.mCastLogger.d(e.getMessage());
        CommandExecuteStatus r126 = new CommandExecuteStatus();
        r126.setPlayErrorCode(IPlayerListener.ERROR_CODE_BDDLNA_PARSE_EXCEPTION);
        r126.setDescription(IPlayerListener.ERROR_MSG_BDDLNA_PARSE_EXCEPTION);
        r126.setException(e.getLocalizedMessage());
        setCommandExecuteStatus(r126);
        return false;
    }

    public void setCacheControl(String r100, int r101) {
        setHeader(HTTP.CACHE_CONTROL, r100 + ContainerUtils.KEY_VALUE_DELIMITER + Integer.toString(r101));
    }

    public void setContent(byte[] r100, boolean r101) {
        this.content = r100;
        if (r101 != true) goto L6;
        setContentLength(r100.length);
        return;
    }

    public void setHeader(String r100, String r101) {
        HTTPHeader r102 = getHeader(r100);
        if (r102 == null) goto L6;
        r102.setValue(r101);
        return;
    L6:
        addHeader(r100, r101);
    }

    public void setHost(String r100, int r101) {
        if (HostInterface.isIPv6Address(r100) != true) goto L5;
        r100 = "[" + r100 + "]";
    L5:
        setHeader(HTTP.HOST, r100 + ":" + Integer.toString(r101));
    }

    public void setIntegerHeader(String r100, int r101) {
        setHeader(r100, Integer.toString(r101));
    }

    public void setLongHeader(String r100, long r101) {
        setHeader(r100, Long.toString(r101));
    }

    public void setStringHeader(String r100, String r101) {
        setStringHeader(r100, r101, "\"", "\"");
    }

    public HTTPPacket(ContextManager.CastContext r100, InputStream r101) {
        this.firstLine = "";
        this.httpHeaderList = new Vector();
        this.content = new byte[0];
        this.contentInput = null;
        this.mCastContext = r100;
        this.mCastLogger = ContextManager.getLogger(r100);
        this.mCastMonitor = ContextManager.getMonitor(this.mCastContext);
        setVersion("1.1");
        set(r101);
        setContentInputStream(null);
    }

    public void setContent(String r100, boolean r101) {
        setContent(r100.getBytes(), r101);
    }

    public void setHeader(String r100, int r101) {
        setHeader(r100, Integer.toString(r101));
    }

    public void setHeader(String r100, long r101) {
        setHeader(r100, Long.toString(r101));
    }

    public String getStringHeaderValue(String r100, String r101, String r102) {
        String r103 = getHeaderValue(r100);
        if (r103.startsWith(r101) != true) goto L6;
        r103 = r103.substring(1, r103.length());
    L6:
        if (r103.endsWith(r102) == true) goto L8;
        return r103;
    L8:
        return r103.substring(0, r103.length() - 1);
    }

    public void setContentRange(long r100, long r101, long r102) {
        String r103 = ("bytes " + Long.toString(r100) + "-") + Long.toString(r101) + HTTP.URL_DEFAULT;
        StringBuilder r104 = new StringBuilder();
        r104.append(r103);
        if (0 >= r102) goto L5;
        String r105 = Long.toString(r102);
    L6:
        r104.append(r105);
        setHeader("Content-Range", r104.toString());
        return;
    L5:
        r105 = "*";
        goto L6
    }

    public void setStringHeader(String r100, String r101, String r102, String r103) {
        if (r101.startsWith(r102) == true) goto L6;
        r101 = r102 + r101;
    L6:
        if (r101.endsWith(r103) == true) goto L8;
        r101 = r101 + r103;
    L8:
        setHeader(r100, r101);
    }
}
