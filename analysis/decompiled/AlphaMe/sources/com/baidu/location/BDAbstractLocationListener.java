package com.baidu.location;

/* loaded from: classes.dex */
public abstract class BDAbstractLocationListener {
    public void onConnectHotSpotMessage(String str, int i4) {
    }

    public void onLocDiagnosticMessage(int i4, int i5, String str) {
    }

    public void onReceiveLocString(String str) {
    }

    public abstract void onReceiveLocation(BDLocation bDLocation);

    public void onReceiveVdrLocation(BDLocation bDLocation) {
    }
}
