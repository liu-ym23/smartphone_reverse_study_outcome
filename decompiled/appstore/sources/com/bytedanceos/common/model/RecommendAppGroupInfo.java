package com.bytedanceos.common.model;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RecommendAppGroupInfo implements Serializable {
    private static final long serialVersionUID = 9145688279423965023L;
    public List<AppInfo> appInfoList;
    public String identity;
    public String name;
    public String sort;

    public RecommendAppGroupInfo() {
    }

    public String toString() {
        return "RecommendAppGroupInfo{name='" + this.name + "', identity='" + this.identity + "', sort='" + this.sort + "', appInfoList=" + this.appInfoList + '}';
    }
}
