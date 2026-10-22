package android.ss.com.vboost;

import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public class CustomRequest {
    public Bundle bundle;
    public int cluster;
    public int level;
    public int priority;
    public boolean restore;
    public CustomScene scene;
    public int tid;
    public long timeout;
    public int type;

    public CustomRequest() {
    }

    public CustomRequest(CapabilityType r100, CustomScene r101) {
        this.type = r100.getIndex();
        this.scene = r101;
    }

    public CustomRequest(CapabilityType r100, FrequencyLevel r101, long r102) {
        this.type = r100.getIndex();
        this.level = r101.ordinal();
        this.timeout = r102;
    }
}
