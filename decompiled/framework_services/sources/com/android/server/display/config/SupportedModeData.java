package com.android.server.display.config;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SupportedModeData {
    public final float refreshRate;
    public final float vsyncRate;

    public SupportedModeData(float refreshRate, float vsyncRate) {
        this.refreshRate = refreshRate;
        this.vsyncRate = vsyncRate;
    }

    public String toString() {
        return "SupportedModeData{refreshRate= " + this.refreshRate + ", vsyncRate= " + this.vsyncRate + '}';
    }

    static List<SupportedModeData> load(NonNegativeFloatToFloatMap configMap) {
        ArrayList<SupportedModeData> supportedModes = new ArrayList();
        if (configMap == null) goto L8;
        Iterator<NonNegativeFloatToFloatPoint> r1 = configMap.getPoint().iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        NonNegativeFloatToFloatPoint supportedMode = r1.next();
        supportedModes.add(new SupportedModeData(supportedMode.getFirst().floatValue(), supportedMode.getSecond().floatValue()));
    L8:
        return supportedModes;
    }
}
