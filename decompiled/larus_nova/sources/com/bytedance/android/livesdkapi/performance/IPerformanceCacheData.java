package com.bytedance.android.livesdkapi.performance;

import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\tH&J8\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u0005H&J\u001c\u0010\u0018\u001a\u00020\u000b2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u001aH&¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdkapi/performance/IPerformanceCacheData;", "", "getFps", "", "getRoomId", "", "getUIStallRate", "getVideoStallRate", "isDataValid", "", "resetStreamType", "", "setupPrefDataForStart", "roomId", "isAnchor", "setupPrefDataForStop", "fpsAvg", "", "dropFrame", "Lorg/json/JSONObject;", "stall", "", "", "duration", "setupReportParams", "paramsMutableMap", "", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPerformanceCacheData {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void setupPrefDataForStart$default(IPerformanceCacheData r100, long r101, boolean r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = false;
        L6:
            r100.setupPrefDataForStart(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setupPrefDataForStart");
        }
    }

    float getFps();

    long getRoomId();

    float getUIStallRate();

    float getVideoStallRate();

    boolean isDataValid();

    void resetStreamType();

    void setupPrefDataForStart(long r100, boolean r101);

    void setupPrefDataForStop(double r100, JSONObject r101, Map<String, Long> r102, long r103);

    void setupReportParams(Map<String, String> r100);
}
