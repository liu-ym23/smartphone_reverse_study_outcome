package com.bytedance.android.livesdkapi.model;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public class BackendItem {
    public long actualRoomId;
    private Object data;
    public long localItemResponseTimeStamp;
    public String logId;
    public long now;
    public int requestType;
    public String traceId;
    public long waitTime;

    public <T> T getData(Class<T> r100) {
        return (T) this.data;
    }

    public <T> List<T> getDataList(Class<T> r100) {
        Object r101 = this.data;
        if ((r101 instanceof List) == true) goto L5;
        if (r101 == null) goto L9;
        ArrayList r102 = new ArrayList();
        r102.add(this.data);
        return r102;
    L9:
        return null;
    L5:
        return (List) r101;
    }

    public BackendItem(long r100, Object r101) {
        this.actualRoomId = r100;
        this.data = r101;
    }

    public BackendItem(String r100, String r101, int r102, long r103, long r104, long r105, long r110, Object r111) {
        this.traceId = r100;
        this.logId = r101;
        this.requestType = r102;
        this.actualRoomId = r103;
        this.waitTime = r104;
        this.now = r105;
        this.localItemResponseTimeStamp = r110;
        this.data = r111;
    }
}
