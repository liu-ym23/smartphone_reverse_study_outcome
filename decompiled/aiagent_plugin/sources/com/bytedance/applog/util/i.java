package com.bytedance.applog.util;

import android.content.Context;
import org.json.JSONArray;

/* JADX INFO: compiled from: IEventsSender.java */
/* JADX INFO: loaded from: classes.dex */
public interface i {
    boolean isEnable();

    void putEvent(String r1, JSONArray r2);

    void setEnable(boolean r1, Context r2);

    void setEventVerifyUrl(String r1);
}
