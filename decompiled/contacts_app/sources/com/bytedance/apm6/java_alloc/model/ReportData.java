package com.bytedance.apm6.java_alloc.model;

import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class ReportData {
    public JSONObject config;
    public long duration;
    public List<ReportInfo> infoList;

    public ReportData(List<ReportInfo> r1, long r2, JSONObject r4) {
        this.infoList = r1;
        this.duration = r2;
        this.config = r4;
    }
}
