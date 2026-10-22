package com.byted.cast.render.utils;

import com.byted.cast.mediacommon.render.ILatencyListener;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes43.dex */
public class LatencyControl {
    private String TAG;
    private final Map<Long, Long> decodeInTimes;
    private final Map<Long, Long> decodedTimes;
    private final Map<Long, Long> frameMap;
    private final boolean isCalculateByUser;
    private ILatencyListener latencyListener;
    private final Map<Long, Long> sendInTimes;
    private String userId;

    public void setLatencyListener(ILatencyListener r100) {
        this.latencyListener = r100;
    }

    public LatencyControl(String r100, String r101) {
        this.TAG = "RenderLatency";
        this.isCalculateByUser = true;
        this.frameMap = new HashMap();
        this.sendInTimes = new HashMap();
        this.decodeInTimes = new HashMap();
        this.decodedTimes = new HashMap();
        this.userId = r100;
        this.TAG += "-" + r101;
    }

    public void decodeIn(int r100, long r101) {
        if (this.frameMap.containsKey(Long.valueOf(r101)) == true) goto L10;
        return;
    L10:
        Long r102 = this.frameMap.get(Long.valueOf(r101));     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public void decoded(int r110, long r111) {
        if (this.frameMap.containsKey(Long.valueOf(r111)) == true) goto L12;
        return;
    L12:
        Long r100 = this.frameMap.get(Long.valueOf(r111));     // Catch: Exception -> L9
        ILatencyListener r101 = this.latencyListener;     // Catch: Exception -> L9
        if (r101 == null) goto L14;
        r101.onDecoded(this.userId, r110, r100.longValue(), r111);     // Catch: Exception -> L9
        this.latencyListener.onRenderIn(this.userId, r110, r100.longValue(), r111);     // Catch: Exception -> L9
        return;
    L14:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
    }

    public void rendered(int r100, long r110) {
        if (this.frameMap.containsKey(Long.valueOf(r110)) == true) goto L13;
        return;
    L13:
        Long r101 = this.frameMap.get(Long.valueOf(r110));     // Catch: Exception -> L10
        ILatencyListener r102 = this.latencyListener;     // Catch: Exception -> L10
        if (r102 == null) goto L8;
        r102.onRendered(this.userId, r100, r101.longValue(), r110);     // Catch: Exception -> L10
    L8:
        this.frameMap.remove(Long.valueOf(r110));     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
    }

    public void sendDataIn(int r100, long r101, long r110) {
        ILatencyListener r102 = this.latencyListener;
        if (r102 == null) goto L9;
        r102.onDecodeIn(this.userId, r100, r101, r110);
        if (this.frameMap.size() <= 100) goto L7;
        this.frameMap.clear();
    L7:
        this.frameMap.put(Long.valueOf(r110), Long.valueOf(r101));
        return;
    }
}
