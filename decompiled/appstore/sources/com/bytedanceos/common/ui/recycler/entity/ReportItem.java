package com.bytedanceos.common.ui.recycler.entity;

/* JADX INFO: loaded from: classes2.dex */
public class ReportItem {
    private String order;

    public ReportItem() {
        this.order = "";
    }

    public String getOrder() {
        return this.order;
    }

    public void setOrder(String r10) {
        this.order = r10;
    }

    public void setOrder(int r10) {
        this.order = String.valueOf(r10);
    }

    public void setOrder(int r10, int r11) {
        this.order = r10 + "-" + r11;
    }
}
