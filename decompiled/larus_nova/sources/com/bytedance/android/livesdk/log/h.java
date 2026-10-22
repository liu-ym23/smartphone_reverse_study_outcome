package com.bytedance.android.livesdk.log;

import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public interface h {
    boolean addSendLogFilter(Object r100, com.bytedance.android.livesdk.log.filter.v r101);

    Map<Class<?>, com.bytedance.android.livesdk.log.filter.o<?>> getFakeTempMap();

    Map<Class<?>, com.bytedance.android.livesdk.log.filter.o<?>> getMap();

    Map<Object, com.bytedance.android.livesdk.log.filter.v> getSendLogFilter();

    void initConfig();

    <T> void register(Class<? extends T> r100, com.bytedance.android.livesdk.log.filter.o<? extends T> r101);

    com.bytedance.android.livesdk.log.filter.v removeSendLogFilter(Object r100);

    <T> void unregister(Class<? extends T> r100);
}
