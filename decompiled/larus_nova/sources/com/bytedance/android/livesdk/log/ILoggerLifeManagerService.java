package com.bytedance.android.livesdk.log;

import com.bytedance.android.live.base.IService;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public interface ILoggerLifeManagerService extends h, IService {
    @Override // com.bytedance.android.livesdk.log.h
    /* synthetic */ boolean addSendLogFilter(Object r100, com.bytedance.android.livesdk.log.filter.v r101);

    /* synthetic */ void afterExecuteLogFilter();

    /* synthetic */ void afterSendAppLog(String r100, Map<String, String> r101);

    /* synthetic */ void beforeExecuteLogFilter(Map<String, String> r100);

    /* synthetic */ void beforeSendAppLog(String r100, Map<String, String> r101);

    @Override // com.bytedance.android.livesdk.log.h
    /* synthetic */ Map<Class<?>, com.bytedance.android.livesdk.log.filter.o<?>> getFakeTempMap();

    @Override // com.bytedance.android.livesdk.log.h
    /* synthetic */ Map<Class<?>, com.bytedance.android.livesdk.log.filter.o<?>> getMap();

    ILoggerLifeManagerService getNewInstance(String r100);

    @Override // com.bytedance.android.livesdk.log.h
    /* synthetic */ Map<Object, com.bytedance.android.livesdk.log.filter.v> getSendLogFilter();

    @Override // com.bytedance.android.livesdk.log.h
    /* synthetic */ void initConfig();

    /* synthetic */ boolean needDropEventBySampling(String r100);

    /* synthetic */ String onChangeEventName(boolean r100, String r101);

    /* synthetic */ void onExecuteLogFilter(Map<String, String> r100, Map<String, String> r101, Object... r102);

    /* synthetic */ void onSendAppLog(String r100, Map<String, String> r101);

    @Override // com.bytedance.android.livesdk.log.h
    /* synthetic */ <T> void register(Class<? extends T> r100, com.bytedance.android.livesdk.log.filter.o<? extends T> r101);

    @Override // com.bytedance.android.livesdk.log.h
    /* synthetic */ com.bytedance.android.livesdk.log.filter.v removeSendLogFilter(Object r100);

    @Override // com.bytedance.android.livesdk.log.h
    /* synthetic */ <T> void unregister(Class<? extends T> r100);
}
