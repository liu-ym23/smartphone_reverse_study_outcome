package com.bytedanceos.common.model;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RelatedAppInfos implements IAppExtra {
    private List<RelatedAppInfo> ad_apps;
    private String category;
    private List<RelatedAppInfo> mTotalAppsList;
    private List<RelatedAppInfo> promote_apps;

    public RelatedAppInfos() {
        this.category = "";
    }

    public List<RelatedAppInfo> getAd_apps() {
        return this.ad_apps;
    }

    public String getCategory() {
        return this.category;
    }

    @Override // com.bytedanceos.common.model.IAppExtra
    public int getItemType() {
        return 4;
    }

    public List<RelatedAppInfo> getPromote_apps() {
        return this.promote_apps;
    }

    public synchronized List<RelatedAppInfo> getTotalAppsList() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mTotalAppsList != null) goto L13;
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L8
        this.mTotalAppsList = r10;     // Catch: Throwable -> L8
        List<RelatedAppInfo> r11 = this.ad_apps;     // Catch: Throwable -> L8
        if (r11 == null) goto L10;
        r10.addAll(r11);     // Catch: Throwable -> L8
    L10:
        List<RelatedAppInfo> r12 = this.promote_apps;     // Catch: Throwable -> L8
        if (r12 == null) goto L13;
        this.mTotalAppsList.addAll(r12);     // Catch: Throwable -> L8
    L13:
        List<RelatedAppInfo> r13 = this.mTotalAppsList;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r13;
    }

    public synchronized boolean isAvailable() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (getTotalAppsList().isEmpty() == false) goto L11;
        if (TextUtils.isEmpty(this.category) == false) goto L11;
        boolean r10 = false;
    L12:
        monitor-exit(this);
        return r10;
    L11:
        r10 = true;
        goto L12
    }

    public void setAd_apps(List<RelatedAppInfo> r10) {
        this.ad_apps = r10;
    }

    public void setCategory(String r10) {
        this.category = r10;
    }

    public void setPromote_apps(List<RelatedAppInfo> r10) {
        this.promote_apps = r10;
    }

    public synchronized void setTotalAppsList(List<RelatedAppInfo> r10) {
        monitor-enter(this);
        if (r10 != null) goto L17;
        monitor-exit(this);
        return;
    L17:
        List<RelatedAppInfo> r11 = this.mTotalAppsList;     // Catch: Throwable -> L9
        if (r11 == null) goto L11;
        r11.clear();     // Catch: Throwable -> L9
    L12:
        this.mTotalAppsList.addAll(r10);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L11:
        this.mTotalAppsList = new ArrayList(r10.size());     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }
}
