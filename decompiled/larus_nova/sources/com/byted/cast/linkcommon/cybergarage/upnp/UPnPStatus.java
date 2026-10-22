package com.byted.cast.linkcommon.cybergarage.upnp;

import com.byted.cast.linkcommon.cybergarage.http.HTTPStatus;

/* JADX INFO: loaded from: classes28.dex */
public class UPnPStatus {
    public static final int ACTION_FAILED = 501;
    public static final int INVALID_ACTION = 401;
    public static final int INVALID_ARGS = 402;
    public static final int INVALID_VAR = 404;
    public static final int OUT_OF_SYNC = 403;
    public static final int PRECONDITION_FAILED = 412;
    private int code;
    private String description;

    public String toString() {
        return "UPnPStatus{code='" + this.code + "', description='" + this.description + "'}";
    }

    public UPnPStatus() {
        this.description = "";
        setCode(0);
        setDescription("");
    }

    public int getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    public static final String code2String(int r100) {
        if (r100 != 412) goto L5;
        return "Precondition Failed";
    L5:
        if (r100 == 501) goto L17;
        switch(r100) {
            case 401: goto L15;
            case 402: goto L13;
            case 403: goto L11;
            case 404: goto L9;
            default: goto L8;
        };
    L9:
        return "Invalid Var";
    L11:
        return "Out of Sync";
    L13:
        return "Invalid Args";
    L15:
        return "Invalid Action";
    L8:
        return HTTPStatus.code2String(r100);
    L17:
        return "Action Failed";
    }

    public void setCode(int r100) {
        this.code = r100;
    }

    public void setDescription(String r100) {
        this.description = r100;
    }

    public UPnPStatus(int r100, String r101) {
        this.description = "";
        setCode(r100);
        setDescription(r101);
    }
}
