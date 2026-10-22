package com.bytedanceos.common.model;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PageDataBean implements Serializable {
    public int adCount;
    public List<AppInfo> apps;
    public Category category;
    public String cid;
    public String groupId;
    public String name;
    public int rows;

    public PageDataBean() {
    }
}
