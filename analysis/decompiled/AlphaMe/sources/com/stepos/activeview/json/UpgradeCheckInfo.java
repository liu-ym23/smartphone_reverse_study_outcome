package com.stepos.activeview.json;

import java.util.List;

/* loaded from: classes.dex */
public class UpgradeCheckInfo {
    private String code;
    private String message;
    private String redirect;
    private List<UpgradeActiveBean> value;

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getRedirect() {
        return this.redirect;
    }

    public List<UpgradeActiveBean> getValue() {
        return this.value;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setRedirect(String str) {
        this.redirect = str;
    }

    public void setValue(List<UpgradeActiveBean> list) {
        this.value = list;
    }
}
