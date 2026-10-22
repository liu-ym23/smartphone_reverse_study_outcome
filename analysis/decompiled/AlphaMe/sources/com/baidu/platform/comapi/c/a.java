package com.baidu.platform.comapi.c;

import com.baidu.platform.comapi.cache.sp.AbsStoreClient;
import com.baidu.platform.comapi.cache.sp.SpStorageConfig;

/* loaded from: classes.dex */
class a extends AbsStoreClient {
    public a(String str) {
        super(new SpStorageConfig.Builder().setStorageName("map_config_record").setCacheModel(true).build(), str);
    }
}
