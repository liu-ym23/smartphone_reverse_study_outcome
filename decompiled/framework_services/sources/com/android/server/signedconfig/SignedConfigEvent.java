package com.android.server.signedconfig;

import com.android.internal.util.FrameworkStatsLog;

/* JADX INFO: loaded from: classes3.dex */
public class SignedConfigEvent {
    public String fromPackage;
    public int status;
    public int type;
    public int verifiedWith;
    public int version;

    public SignedConfigEvent() {
        this.type = 0;
        this.status = 0;
        this.version = 0;
        this.fromPackage = null;
        this.verifiedWith = 0;
    }

    public void send() {
        FrameworkStatsLog.write(123, this.type, this.status, this.version, this.fromPackage, this.verifiedWith);
    }
}
