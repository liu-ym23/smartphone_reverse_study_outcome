package com.bes.sdk.message;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class A2DPConnection implements Serializable {
    private List<String> addressList;
    private boolean connected;

    public A2DPConnection() {
    }

    public String toString() {
        return "A2DPConnection{connected=" + this.connected + '}';
    }

    public List<String> getAddressList() {
        return this.addressList;
    }

    public boolean isConnected() {
        return this.connected;
    }

    public void setAddressList(List<String> r100) {
        this.addressList = r100;
    }

    public void setConnected(boolean r100) {
        this.connected = r100;
    }
}
