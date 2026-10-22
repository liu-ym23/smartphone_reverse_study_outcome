package com.bytedance.android.livesdkapi.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public class BackendGeneratedData {
    private final Map<Class<?>, BackendItem> backendDataMap;
    public boolean hasDataAllEmitted;
    public long localBackendResponseTimeStamp;
    public String logId;
    public long now;
    public int requestType;
    public long roomId;
    public String screencastData;
    public String traceId;
    private final Map<Class<?>, Object> typedDataMap;
    private final Map<Class<?>, Long> typedErrorCodeMap;
    private final Map<Class<?>, String> typedErrorMsgMap;
    private final Map<Class<?>, Long> typedRoomIdMap;
    private final Map<Class<?>, Long> typedWaitTimeMap;

    public BackendGeneratedData() {
        this.backendDataMap = new HashMap();
        this.typedDataMap = new HashMap();
        this.typedWaitTimeMap = new HashMap();
        this.typedRoomIdMap = new HashMap();
        this.typedErrorCodeMap = new HashMap();
        this.typedErrorMsgMap = new HashMap();
        this.hasDataAllEmitted = false;
    }

    public Map<Class<?>, BackendItem> getBackendItemMap() {
        return this.backendDataMap;
    }

    public BackendItem getBackendItem(Class<?> r100) {
        return this.backendDataMap.get(r100);
    }

    public <T> T getTypedData(Class<T> r100) {
        if (this.typedDataMap.get(r100) != null) goto L7;
        return null;
    L7:
        return (T) this.typedDataMap.get(r100);
    }

    public <T> List<T> getTypedDataList(Class<T> r100) {
        if ((this.typedDataMap.get(r100) instanceof List) == false) goto L7;
        return (List) this.typedDataMap.get(r100);
    L7:
        if (this.typedDataMap.get(r100) == null) goto L10;
        ArrayList r101 = new ArrayList();
        r101.add(getTypedData(r100));
        return r101;
    L10:
        return null;
    }

    public Long getTypedErrorCode(Class<?> r100) {
        if (this.typedErrorCodeMap.get(r100) != null) goto L7;
        return 0L;
    L7:
        return this.typedErrorCodeMap.get(r100);
    }

    public String getTypedErrorMsgMap(Class<?> r100) {
        if (this.typedErrorMsgMap.get(r100) != null) goto L7;
        return "";
    L7:
        return this.typedErrorMsgMap.get(r100);
    }

    public Long getTypedRoomId(Class<?> r100) {
        if (this.typedRoomIdMap.get(r100) != null) goto L7;
        return 0L;
    L7:
        return this.typedRoomIdMap.get(r100);
    }

    public Long getTypedWaitTime(Class<?> r100) {
        return this.typedWaitTimeMap.get(r100);
    }

    public void setBackendItem(Class<?> r100, BackendItem r101) {
        this.backendDataMap.put(r100, r101);
    }

    public void setTypedData(Class<?> r100, Object r101) {
        this.typedDataMap.put(r100, r101);
    }

    public void setTypedErrorCodeMap(Class<?> r100, Long r101) {
        this.typedErrorCodeMap.put(r100, r101);
    }

    public void setTypedErrorMsgMap(Class<?> r100, String r101) {
        this.typedErrorMsgMap.put(r100, r101);
    }

    public void setTypedRoomId(Class<?> r100, Long r101) {
        this.typedRoomIdMap.put(r100, r101);
    }

    public void setTypedWaitTime(Class<?> r100, Long r101) {
        this.typedWaitTimeMap.put(r100, r101);
    }
}
