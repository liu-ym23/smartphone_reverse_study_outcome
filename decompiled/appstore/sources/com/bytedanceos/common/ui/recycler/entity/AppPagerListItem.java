package com.bytedanceos.common.ui.recycler.entity;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.networkv2.entity.AppEntity;
import com.bytedanceos.common.toolbox.c;
import com.bytedanceos.common.utils.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AppPagerListItem extends BaseItem {
    private List<AppInfo> appInfos;
    private List<AppEntity> apps;

    public AppPagerListItem() {
    }

    public static AppPagerListItem contain(List<AppEntity> r10) {
        AppPagerListItem r11 = new AppPagerListItem();
        r11.setApps(r10);
        ArrayList r12 = new ArrayList();
        Iterator<AppEntity> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r12.add(h.c(r13.next()));
        goto L4
    L6:
        r11.setAppInfos(r12);
        return r11;
    }

    public List<AppInfo> getAppInfos() {
        return this.appInfos;
    }

    public List<AppEntity> getApps() {
        return this.apps;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return 10;
    }

    @Override // com.bytedanceos.common.ui.recycler.entity.BaseItem
    public boolean isAvailable() {
        return !c.a(this.apps);
    }

    public void setAppInfos(List<AppInfo> r10) {
        this.appInfos = r10;
    }

    public void setApps(List<AppEntity> r10) {
        this.apps = r10;
    }
}
