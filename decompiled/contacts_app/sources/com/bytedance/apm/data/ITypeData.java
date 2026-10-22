package com.bytedance.apm.data;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface ITypeData {
    String getSubTypeLabel();

    String getTypeLabel();

    boolean isSampled(JSONObject r1);

    boolean isSaveImmediately();

    boolean isUploadImmediately();

    JSONObject packLog();

    boolean supportFetch();
}
