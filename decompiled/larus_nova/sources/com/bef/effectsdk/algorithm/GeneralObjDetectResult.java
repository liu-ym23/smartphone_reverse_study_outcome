package com.bef.effectsdk.algorithm;

/* JADX INFO: loaded from: classes39.dex */
public class GeneralObjDetectResult {
    public static final int DETECT_FAIL = -1;
    public static final int DETECT_SUCCESS = 0;
    private ObjectInfo[] obj_infos;
    private String obj_infos_data;
    private int obj_num;
    private int res;

    public void logData() {
        int r100 = 0;
    L4:
        if (r100 >= this.obj_num) goto L7;
        this.obj_infos[r100].logData();
        r100 = r100 + 1;
        goto L4
    }

    public GeneralObjDetectResult() {
        this.res = -1;
    }

    public ObjectInfo[] getObjectInfos() {
        return this.obj_infos;
    }

    public String getObjectInfosData() {
        return this.obj_infos_data;
    }

    public int getObjectNum() {
        return this.obj_num;
    }

    public int getResult() {
        return this.res;
    }

    public void ObjectInfosData(String r100) {
        this.obj_infos_data = r100;
    }

    public void setObjectInfos(ObjectInfo[] r100) {
        this.obj_infos = r100;
    }

    public void setObjectNum(int r100) {
        this.obj_num = r100;
    }

    public void setResult(int r100) {
        this.res = r100;
    }

    public GeneralObjDetectResult(int r100, ObjectInfo[] r101) {
        this.res = 0;
        this.obj_num = r100;
        this.obj_infos = r101;
    }

    public GeneralObjDetectResult(int r100, ObjectInfo[] r101, String r102) {
        this.res = 0;
        this.obj_num = r100;
        this.obj_infos = r101;
        this.obj_infos_data = r102;
    }
}
