package com.bytedance.android.livesdkapi.service.gamecp;

import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u0004J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u0004J\u000f\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\bJ$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000eH&J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/gamecp/ILiveMonitorService;", "", "getCpuRate", "", "()Ljava/lang/Double;", "getGpuUsed", "getTemperature", "", "()Ljava/lang/Float;", "onModuleStart", "", "name", "", "extra", "", "onModuleStop", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveMonitorService {
    Double getCpuRate();

    Double getGpuUsed();

    Float getTemperature();

    void onModuleStart(String r100, Map<String, String> r101);

    void onModuleStop(String r100);
}
