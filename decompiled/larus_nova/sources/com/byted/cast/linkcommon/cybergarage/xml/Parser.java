package com.byted.cast.linkcommon.cybergarage.xml;

import android.text.TextUtils;
import com.byted.cast.common.CastLogger;
import com.byted.cast.common.CastMonitor;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.ErrorCode;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.byted.cast.linkcommon.cybergarage.http.HTTPRequest;
import com.byted.cast.linkcommon.cybergarage.http.HTTPResponse;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.a;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public abstract class Parser {
    private static final int HTTP_TIMEOUT = 5000;
    private static final String TAG = null;
    private ContextManager.CastContext mCastContext;
    private CastLogger mLogger;
    private CastMonitor mMonitor;

    public abstract Node parse(InputStream r100) throws ParserException;

    static {
        TAG = "Parser";
    }

    public Parser(ContextManager.CastContext r100) {
        this.mCastContext = r100;
        this.mLogger = ContextManager.getLogger(r100);
        this.mMonitor = ContextManager.getMonitor(this.mCastContext);
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_com_byted_cast_linkcommon_cybergarage_xml_Parser_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r100) throws IOException {
        String r101 = r100.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r102 = r100.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (a.c(r101, r102) == false) goto L11;
        FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r101 + " path=" + r102);     // Catch: Throwable -> L8 IOException -> L12
        a.b(a.a(r101, r102), r101, r102);     // Catch: Throwable -> L8 IOException -> L12
        throw new IOException("[NetGuard] dropped " + r100);     // Catch: Throwable -> L8 IOException -> L12
    L11:
        return r100.openConnection();
    L12:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.f375446a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L11
    }

    public Node parse(String r100) throws ParserException {
        return parse(new ByteArrayInputStream(r100.getBytes()));
    L4:
        e = move-exception;
        throw new ParserException(e);
    }

    public Node parse(File r100) throws ParserException {
        PolarisFileInputStreamWrapper r101 = new PolarisFileInputStreamWrapper(r100);     // Catch: Exception -> L4
        Node r102 = parse(r101);     // Catch: Exception -> L4
        r101.close();     // Catch: Exception -> L4
        return r102;
    L4:
        e = move-exception;
        throw new ParserException(e);
    }

    public Node parse(URL r110, ParserType r111, boolean r112) throws ParserException {
        InputStream r100 = null;
        if (r110 != null) goto L5;
        return null;
    L5:
        String r101 = r110.getHost();
        int r102 = r110.getPort();
        String r103 = r110.getPath();
        HttpURLConnection r104 = (HttpURLConnection) INVOKEVIRTUAL_com_byted_cast_linkcommon_cybergarage_xml_Parser_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(r110);     // Catch: Exception -> L17
        r104.setRequestMethod("GET");     // Catch: Exception -> L15
        r104.setRequestProperty("Content-Length", "0");     // Catch: Exception -> L15
        if (r112 == false) goto L10;
        r104.setReadTimeout(5000);     // Catch: Exception -> L15
        r104.setConnectTimeout(5000);     // Catch: Exception -> L15
    L11:
        if (r101 == null) goto L13;
        r104.setRequestProperty(HTTP.HOST, r101 + ":" + r102);     // Catch: Exception -> L15
    L13:
        r100 = r104.getInputStream();     // Catch: Exception -> L15
        Node r105 = parse(r100);     // Catch: Exception -> L15
        r105.setApplicationUrl(r104.getHeaderField("Application-URL"));     // Catch: Exception -> L15
        return r105;
    L10:
        r104.setReadTimeout(10000);     // Catch: Exception -> L15
        r104.setConnectTimeout(10000);     // Catch: Exception -> L15
    L15:
        e = e;
    L19:
        String r106 = e.getMessage();
        if (r100 != null) goto L43;
    L24:
        if (r104 == null) goto L26;
        r104.disconnect();
    L26:
        HTTPRequest r107 = new HTTPRequest(this.mCastContext);
        r107.setMethod("GET");
        r107.setURI(r103);
        if (r112 == false) goto L29;
        HTTPResponse r108 = r107.post(r101, r102, 5000, 5000);
    L31:
        if (r108.isSuccessful() == true) goto L42;
        if (r112 == true) goto L42;
        if (r108.getCommandExecuteStatus() != null) goto L36;
    L38:
        String r113 = "";
    L39:
        this.mMonitor.getSourceMonitor().trackBDDLNAParseUrlFailureInfo(r111.getTypeName(), r110.toString(), r106, r113);
        throw new ParserException(ErrorCode.DLNA_SEARCH_LOCATION_CONNECT_ERROR_DESC + r110);
    L36:
        if (TextUtils.isEmpty(r108.getCommandExecuteStatus().getException()) == true) goto L38;
        r113 = r108.getCommandExecuteStatus().getException();
    L42:
        return parse(new ByteArrayInputStream(new String(r108.getContent()).getBytes()));
    L29:
        r108 = r107.post(r101, r102);
        goto L31
    L43:
        r100.close();     // Catch: IOException -> L23
    L17:
        e = e;
        r104 = null;
        goto L19
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.byted.cast.linkcommon.cybergarage.xml.Parser] */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.net.URL] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.net.HttpURLConnection] */
    public int isRequestLocationSuccess(URL r110, boolean r111, int r112, int r113) {
        if (r110 != 0) goto L6;
        this.mLogger.d(TAG, " isRequestLocationSuccess location is null");
        return ErrorCode.ERROR_CODE_DETECT_DEVICE_NULL_LOCATION_URL;
    L6:
        String r100 = r110.getHost();
        int r101 = r110.getPort();
        if (r101 >= 0) goto L9;
    L10:
        r101 = 80;
    L11:
        String r102 = r110.getPath();
        InputStream r103 = null;
        HttpURLConnection r114 = (HttpURLConnection) INVOKEVIRTUAL_com_byted_cast_linkcommon_cybergarage_xml_Parser_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(r110);     // Catch: Throwable -> L29 Exception -> L31
        r114.setRequestMethod("GET");     // Catch: Exception -> L27 Throwable -> L81
        r114.setRequestProperty("Content-Length", "0");     // Catch: Exception -> L27 Throwable -> L81
        if (r111 == false) goto L16;
        r114.setConnectTimeout(r112);     // Catch: Exception -> L27 Throwable -> L81
        r114.setReadTimeout(r113);     // Catch: Exception -> L27 Throwable -> L81
    L17:
        if (r100 == null) goto L19;
        r114.setRequestProperty(HTTP.HOST, r100 + ":" + r101);     // Catch: Exception -> L27 Throwable -> L81
    L19:
        r103 = r114.getInputStream();     // Catch: Exception -> L27 Throwable -> L81
        parse(r103);     // Catch: Exception -> L27 Throwable -> L81
        this.mLogger.d(TAG, " isRequestLocationSuccess parse success by connect");     // Catch: Exception -> L27 Throwable -> L81
        if (r103 != null) goto L90;
    L25:
        r114.disconnect();
        return 0;
    L90:
        r103.close();     // Catch: IOException -> L23
    L23:
        e = move-exception;
        e.printStackTrace();
        goto L25
    L16:
        r114.setConnectTimeout(5000);     // Catch: Exception -> L27 Throwable -> L81
        r114.setReadTimeout(5000);     // Catch: Exception -> L27 Throwable -> L81
    L27:
        e = e;
    L33:
        e.printStackTrace();     // Catch: Throwable -> L81
        if (r103 != null) goto L93;
    L39:
        if (r114 == null) goto L41;
        r114.disconnect();
    L41:
        HTTPRequest r115 = new HTTPRequest(this.mCastContext);
        r115.setMethod("GET");
        r115.setURI(r102);
        if (r111 == false) goto L44;
        HTTPResponse r116 = r115.post(r100, r101, r112, r113);
    L46:
        if (r116.isSuccessful() == true) goto L59;
        this.mLogger.d(TAG, " isRequestLocationSuccess parse false by socket");
        if (r116.getCommandExecuteStatus() == null) goto L54;
        if (r116.getCommandExecuteStatus().getPlayErrorCode() == 0) goto L54;
        return r116.getCommandExecuteStatus().getPlayErrorCode();
    L54:
        if (r116.getStatusCode() != 0) goto L56;
        return ErrorCode.ERROR_CODE_DETECT_DEVICE_DEFAULT;
    L56:
        return r116.getStatusCode() + ErrorCode.ERROR_CODE_DLNA_PLAY_HTTP;
    L59:
        ByteArrayInputStream r117 = new ByteArrayInputStream(new String(r116.getContent()).getBytes());
        parse(r117);     // Catch: Throwable -> L66 Exception -> L68
        this.mLogger.d(TAG, " isRequestLocationSuccess parse success by socket");     // Catch: Throwable -> L66 Exception -> L68
    L105:
        r117.close();     // Catch: Exception -> L63
    L65:
        return 0;
    L63:
        e = move-exception;
        e.printStackTrace();
    L66:
        th = move-exception;
        r117.close();     // Catch: Exception -> L78
    L80:
        throw th;
    L78:
        e = move-exception;
        e.printStackTrace();
    L68:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L66
        this.mLogger.d(TAG, " isRequestLocationSuccess parse false by socket");     // Catch: Throwable -> L66
        r117.close();     // Catch: Exception -> L72
        return ErrorCode.ERROR_CODE_DETECT_DEVICE_PARSER_EXCEPTION;
    L72:
        e = move-exception;
        e.printStackTrace();
        return ErrorCode.ERROR_CODE_DETECT_DEVICE_PARSER_EXCEPTION;
    L44:
        r116 = r115.post(r100, r101, 5000, 5000);
        goto L46
    L93:
        r103.close();     // Catch: IOException -> L37
    L37:
        e = move-exception;
        e.printStackTrace();
        goto L39
    L81:
        th = th;
    L82:
        if (0 != 0) goto L99;
    L87:
        if (r110 == 0) goto L108;
        r110.disconnect();
        throw th;
    L108:
        throw th;
    L99:
        r103.close();     // Catch: IOException -> L85
    L85:
        e = move-exception;
        e.printStackTrace();
    L31:
        e = e;
        r114 = null;
    L29:
        th = th;
        r110 = 0;
        goto L82
    L9:
        if (r101 <= 65535) goto L11;
        goto L10
    }

    public int isRequestLocationSuccessBySocket(URL r100, boolean r101, int r102, int r103) {
        if (r100 != null) goto L5;
        this.mLogger.d(TAG, " isRequestLocationSuccessBySocket location is null");
        return ErrorCode.ERROR_CODE_DETECT_DEVICE_NULL_LOCATION_URL;
    L5:
        String r104 = r100.getHost();
        int r105 = r100.getPort();
        if (r105 >= 0) goto L8;
    L9:
        r105 = 80;
    L10:
        String r106 = r100.getPath();
        HTTPRequest r107 = new HTTPRequest(this.mCastContext);
        r107.setMethod("GET");
        r107.setURI(r106);
        if (r101 == false) goto L13;
        HTTPResponse r108 = r107.post(r104, r105, r102, r103);
    L15:
        if (r108.isSuccessful() == true) goto L28;
        this.mLogger.d(TAG, " isRequestLocationSuccessBySocket parse false by socket");
        if (r108.getCommandExecuteStatus() == null) goto L23;
        if (r108.getCommandExecuteStatus().getPlayErrorCode() == 0) goto L23;
        return r108.getCommandExecuteStatus().getPlayErrorCode();
    L23:
        if (r108.getStatusCode() != 0) goto L25;
        return ErrorCode.ERROR_CODE_DETECT_DEVICE_DEFAULT;
    L25:
        return r108.getStatusCode() + ErrorCode.ERROR_CODE_DLNA_PLAY_HTTP;
    L28:
        ByteArrayInputStream r109 = new ByteArrayInputStream(new String(r108.getContent()).getBytes());
        parse(r109);     // Catch: Throwable -> L36 Exception -> L38
        this.mLogger.d(TAG, " isRequestLocationSuccessBySocket parse success by socket");     // Catch: Throwable -> L36 Exception -> L38
        r109.close();     // Catch: Exception -> L32
        return 0;
    L32:
        e = move-exception;
        e.printStackTrace();
        return 0;
    L36:
        th = move-exception;
        r109.close();     // Catch: Exception -> L48
    L50:
        throw th;
    L48:
        e = move-exception;
        e.printStackTrace();
    L38:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L36
        this.mLogger.d(TAG, " isRequestLocationSuccessBySocket parse false by socket");     // Catch: Throwable -> L36
        r109.close();     // Catch: Exception -> L42
        return ErrorCode.ERROR_CODE_DETECT_DEVICE_PARSER_EXCEPTION;
    L42:
        e = move-exception;
        e.printStackTrace();
        return ErrorCode.ERROR_CODE_DETECT_DEVICE_PARSER_EXCEPTION;
    L13:
        r108 = r107.post(r104, r105, 5000, 5000);
        goto L15
    L8:
        if (r105 <= 65535) goto L10;
        goto L9
    }
}
