package com.baidu.mapapi.map.bmsdk.ui;

import com.baidu.platform.comapi.bmsdk.ui.BmBaseUI;

/* loaded from: classes.dex */
public abstract class BaseUI {

    /* renamed from: a, reason: collision with root package name */
    private BmBaseUI f7136a;

    /* renamed from: b, reason: collision with root package name */
    private String f7137b;
    protected onBaseUIListener listener;

    public interface onBaseUIListener {
        void onBaseUIRemove(BaseUI baseUI);

        void onBaseUIUpdate(BaseUI baseUI);
    }

    public BmBaseUI getBmBaseUI() {
        return this.f7136a;
    }

    public String getClickAction() {
        return this.f7137b;
    }

    public void remove() {
        onBaseUIListener onbaseuilistener = this.listener;
        if (onbaseuilistener != null) {
            onbaseuilistener.onBaseUIRemove(this);
        }
    }

    public void setClickAction(String str) {
        this.f7137b = str;
    }

    public void setListener(onBaseUIListener onbaseuilistener) {
        this.listener = onbaseuilistener;
    }
}
