package com.bes.sdk.message;

import java.io.Serializable;

/* JADX INFO: loaded from: classes39.dex */
public class EQSettings implements Serializable {
    private int categoryId;
    private EQPayload eqPayload;
    private int status;

    public EQSettings() {
    }

    public String toString() {
        return "\nEQSettings{\ncategoryId=" + this.categoryId + "\nstatus=" + this.status + "\neqPayload=" + this.eqPayload + '}';
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public EQPayload getEqPayload() {
        return this.eqPayload;
    }

    public int getStatus() {
        return this.status;
    }

    public void setCategoryId(int r100) {
        this.categoryId = r100;
    }

    public void setEqPayload(EQPayload r100) {
        this.eqPayload = r100;
    }

    public void setStatus(int r100) {
        this.status = r100;
    }
}
