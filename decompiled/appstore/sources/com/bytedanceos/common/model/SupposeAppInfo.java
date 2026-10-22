package com.bytedanceos.common.model;

import com.bytedanceos.common.ui.listener.ISupposeListener;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SupposeAppInfo implements IAppExtra, Serializable {
    private Body body;
    private Head head;
    private AppInfo superInfo;
    private String superName;
    private int superPos;
    private ISupposeListener supposeListener;

    public static class Body implements Serializable {
        private List<BaseAppInfo> ad_apps;
        private List<BaseAppInfo> promote_apps;

        public Body() {
        }

        public List<BaseAppInfo> getAd_apps() {
            return this.ad_apps;
        }

        public List<BaseAppInfo> getPromote_apps() {
            return this.promote_apps;
        }

        public boolean isAvailable() {
            if (com.bytedanceos.common.toolbox.c.a(this.promote_apps) == true) goto L5;
        L8:
            return true;
        L5:
            if (com.bytedanceos.common.toolbox.c.a(this.ad_apps) == false) goto L8;
            return false;
        }

        public void setAd_apps(List<BaseAppInfo> r10) {
            this.ad_apps = r10;
        }

        public void setPromote_apps(List<BaseAppInfo> r10) {
            this.promote_apps = r10;
        }
    }

    public SupposeAppInfo() {
        this.superPos = -1;
        this.superName = "";
    }

    public Body getBody() {
        return this.body;
    }

    public Head getHead() {
        return this.head;
    }

    @Override // com.bytedanceos.common.model.IAppExtra
    public int getItemType() {
        return 1;
    }

    public AppInfo getSuperInfo() {
        return this.superInfo;
    }

    public String getSuperName() {
        return this.superName;
    }

    public int getSuperPos() {
        return this.superPos;
    }

    public ISupposeListener getSupposeListener() {
        return this.supposeListener;
    }

    public boolean isAvailable() {
        Body r10 = this.body;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isAvailable() == false) goto L7;
        return true;
    }

    public void setBody(Body r10) {
        this.body = r10;
    }

    public void setHead(Head r10) {
        this.head = r10;
    }

    public void setSuperInfo(AppInfo r10) {
        this.superInfo = r10;
    }

    public void setSuperName(String r10) {
        this.superName = r10;
    }

    public void setSuperPos(int r10) {
        this.superPos = r10;
    }

    public void setSupposeListener(ISupposeListener r10) {
        this.supposeListener = r10;
    }
}
