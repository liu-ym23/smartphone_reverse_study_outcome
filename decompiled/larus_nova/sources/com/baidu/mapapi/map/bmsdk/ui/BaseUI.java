package com.baidu.mapapi.map.bmsdk.ui;

import com.baidu.platform.comapi.bmsdk.ui.BmBaseUI;

/* JADX INFO: loaded from: classes39.dex */
public abstract class BaseUI {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BmBaseUI f31571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f31572b;
    protected onBaseUIListener listener;

    public interface onBaseUIListener {
        void onBaseUIRemove(BaseUI r100);

        void onBaseUIUpdate(BaseUI r100);
    }

    public void remove() {
        onBaseUIListener r100 = this.listener;
        if (r100 == null) goto L6;
        r100.onBaseUIRemove(this);
        return;
    }

    public BaseUI() {
    }

    public BmBaseUI getBmBaseUI() {
        return this.f31571a;
    }

    public String getClickAction() {
        return this.f31572b;
    }

    public void setClickAction(String r100) {
        this.f31572b = r100;
    }

    public void setListener(onBaseUIListener r100) {
        this.listener = r100;
    }
}
