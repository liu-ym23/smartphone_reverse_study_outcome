package com.bytedanceos.common.model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class Head implements Serializable {
    private int code;
    private String message;

    public Head() {
        this.code = 0;
        this.message = "";
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(int r10) {
        this.code = r10;
    }

    public void setMessage(String r10) {
        this.message = r10;
    }
}
