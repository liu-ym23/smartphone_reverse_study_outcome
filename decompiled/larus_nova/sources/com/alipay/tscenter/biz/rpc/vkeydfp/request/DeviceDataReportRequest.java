package com.alipay.tscenter.biz.rpc.vkeydfp.request;

import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public class DeviceDataReportRequest implements Serializable {
    public String apdid;
    public Map<String, String> dataMap;
    public String lastTime;

    /* JADX INFO: renamed from: os, reason: collision with root package name */
    public String f25989os;
    public String priApdid;
    public String pubApdid;
    public String token;
    public String umidToken;
    public String version;

    public DeviceDataReportRequest() {
    }
}
