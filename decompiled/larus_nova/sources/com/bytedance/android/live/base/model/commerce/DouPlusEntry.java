package com.bytedance.android.live.base.model.commerce;

import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes45.dex */
public class DouPlusEntry implements Serializable {
    public HashMap<String, String> dialogParams;
    public String douPlusEntry;
    public boolean enableShareEntry;
    public boolean hasDouPlusEntry;
    public boolean isEcpEntryMode;
    public HashMap<String, String> urlParams;

    public static DouPlusEntry defaultOne() {
        return new DouPlusEntry(false, "");
    }

    public DouPlusEntry(boolean r100, String r101) {
        this.enableShareEntry = false;
        this.isEcpEntryMode = false;
        this.urlParams = new HashMap();
        this.dialogParams = new HashMap();
        this.hasDouPlusEntry = r100;
        this.douPlusEntry = r101;
    }
}
