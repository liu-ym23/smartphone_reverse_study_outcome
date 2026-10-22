package com.baidu.platform.comapi.map;

/* JADX INFO: loaded from: classes39.dex */
public class ItsMapObj {
    public MapObj baseMapObj;
    public String strTrafficDetail;
    public long tTrafficEnd;
    public long tTrafficStart;

    public ItsMapObj() {
        this.baseMapObj = new MapObj();
        this.tTrafficStart = 0;
        this.tTrafficEnd = 0;
        this.strTrafficDetail = "";
    }
}
