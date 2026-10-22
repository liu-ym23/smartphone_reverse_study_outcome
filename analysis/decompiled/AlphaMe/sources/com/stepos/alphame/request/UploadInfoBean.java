package com.stepos.alphame.request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.stepos.alphame.NotProguard;
import com.stepos.alphame.app.AppStateEngine;

@NotProguard
/* loaded from: classes.dex */
public class UploadInfoBean {
    private int record;
    private int upload;

    public static UploadInfoBean fromJsonString(String str) {
        try {
            JSONObject object = JSON.parseObject(str);
            if (object == null) {
                return newDefault();
            }
            UploadInfoBean uploadInfoBeanNewDefault = newDefault();
            uploadInfoBeanNewDefault.upload = object.getIntValue("upload");
            uploadInfoBeanNewDefault.record = object.getIntValue(AppStateEngine.S_KEY_STATE_RECORD);
            return uploadInfoBeanNewDefault;
        } catch (Exception unused) {
            return newDefault();
        }
    }

    public static UploadInfoBean newDefault() {
        UploadInfoBean uploadInfoBean = new UploadInfoBean();
        uploadInfoBean.upload = 0;
        uploadInfoBean.record = 30;
        return uploadInfoBean;
    }

    public int getRecord() {
        return this.record;
    }

    public int getUpload() {
        return this.upload;
    }

    public void setRecord(int i4) {
        this.record = i4;
    }

    public void setUpload(int i4) {
        this.upload = i4;
    }

    public String toJsonString() {
        return JSON.toJSONString(this);
    }

    public String toString() {
        return "record = " + this.record + ", upload = " + this.upload;
    }
}
