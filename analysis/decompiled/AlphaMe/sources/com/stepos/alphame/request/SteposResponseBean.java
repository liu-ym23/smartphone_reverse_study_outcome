package com.stepos.alphame.request;

import B0.g;
import com.stepos.alphame.NotProguard;

@NotProguard
/* loaded from: classes.dex */
public class SteposResponseBean {
    private int code;
    private String msg;
    private String redirect;
    private String value;

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getRedirect() {
        return this.redirect;
    }

    public String getValue() {
        return this.value;
    }

    public void setCode(int i4) {
        this.code = i4;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setRedirect(String str) {
        this.redirect = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ResponseBean{code=");
        sb.append(this.code);
        sb.append(", msg='");
        sb.append(this.msg);
        sb.append("', value='");
        sb.append(this.value);
        sb.append("', redirect='");
        return g.r(sb, this.redirect, "'}");
    }
}
