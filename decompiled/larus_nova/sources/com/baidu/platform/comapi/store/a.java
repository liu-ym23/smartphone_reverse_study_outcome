package com.baidu.platform.comapi.store;

import com.baidu.platform.comapi.cache.sp.AbsStoreClient;
import com.baidu.platform.comapi.cache.sp.SpStorageConfig;

/* JADX INFO: loaded from: classes39.dex */
class a extends AbsStoreClient {
    public a(String r100) {
        super(new SpStorageConfig.Builder().setStorageName("map_config_record").setCacheModel(true).build(), r100);
    }
}
