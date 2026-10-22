package com.byted.cast.linkcommon.cybergarage.http;

import com.byted.cast.common.Logger;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes28.dex */
public class HTTPStatus {
    public static final int BAD_REQUEST = 400;
    public static final int CONTINUE = 100;
    public static final int INTERNAL_SERVER_CONNECT_ERROR = 503;
    public static final int INTERNAL_SERVER_ERROR = 500;
    public static final int INTERNAL_SERVER_IO_ERROR = 504;
    public static final int INTERNAL_SERVER_SOCKET_ERROR = 501;
    public static final int INTERNAL_SERVER_SOCKET_TIMEOUT_ERROR = 502;
    public static final int INVALID_RANGE = 416;
    public static final int NOT_FOUND = 404;
    public static final int OK = 200;
    public static final int PARTIAL_CONTENT = 206;
    public static final int PRECONDITION_FAILED = 412;
    private String reasonPhrase;
    private int statusCode;
    private String version;

    public static final String code2String(int r100) {
        if (r100 != 100) goto L5;
        return "Continue";
    L5:
        if (r100 != 200) goto L7;
        return "OK";
    L7:
        if (r100 != 206) goto L9;
        return "Partial Content";
    L9:
        if (r100 != 400) goto L11;
        return "Bad Request";
    L11:
        if (r100 != 404) goto L13;
        return "Not Found";
    L13:
        if (r100 != 412) goto L15;
        return "Precondition Failed";
    L15:
        if (r100 != 416) goto L17;
        return "Invalid Range";
    L17:
        if (r100 == 500) goto L20;
        return "";
    L20:
        return "Internal Server Error";
    }

    public static final boolean isSuccessful(int r100) {
        if (200 <= r100) goto L5;
        return false;
    L5:
        if (r100 >= 300) goto L10;
        return true;
    L10:
        return false;
    }

    public HTTPStatus() {
        this.version = "";
        this.statusCode = 0;
        this.reasonPhrase = "";
        setVersion("");
        setStatusCode(0);
        setReasonPhrase("");
    }

    public boolean isSuccessful() {
        return isSuccessful(getStatusCode());
    }

    public String getReasonPhrase() {
        return this.reasonPhrase;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getVersion() {
        return this.version;
    }

    public HTTPStatus(String r100) {
        this.version = "";
        this.statusCode = 0;
        this.reasonPhrase = "";
        set(r100);
    }

    public void set(String r100) {
        if (r100 != null) goto L30;
        setVersion("1.1");
        setStatusCode(500);
        setReasonPhrase(code2String(500));
        return;
    L30:
        StringTokenizer r101 = new StringTokenizer(r100, " ");     // Catch: Exception -> L25
        if (r101.hasMoreTokens() == true) goto L9;
        return;
    L9:
        setVersion(r101.nextToken().trim());     // Catch: Exception -> L25
        if (r101.hasMoreTokens() == true) goto L28;
        return;
    L28:
        int r102 = CastIntegerProtector.parseInt(r101.nextToken());     // Catch: Exception -> L15
    L16:
        setStatusCode(r102);     // Catch: Exception -> L25
        String r103 = "";
    L18:
        if (r101.hasMoreTokens() != true) goto L23;
        if (r103.length() < 0) goto L22;
        r103 = r103 + " ";     // Catch: Exception -> L25
    L22:
        r103 = r103 + r101.nextToken();     // Catch: Exception -> L25
        goto L18
    L23:
        setReasonPhrase(r103.trim());     // Catch: Exception -> L25
        return;
    L15:
        r102 = 0;
    L25:
        e = move-exception;
        Logger.e(e.getMessage());
    }

    public void setReasonPhrase(String r100) {
        this.reasonPhrase = r100;
    }

    public void setStatusCode(int r100) {
        this.statusCode = r100;
    }

    public void setVersion(String r100) {
        this.version = r100;
    }

    public HTTPStatus(String r100, int r101, String r102) {
        this.version = "";
        this.statusCode = 0;
        this.reasonPhrase = "";
        setVersion(r100);
        setStatusCode(r101);
        setReasonPhrase(r102);
    }
}
