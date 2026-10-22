package com.bytedance.bdtracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.applog.InitConfig;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.applog.store.kv.IKVStore;
import com.bytedance.applog.store.kv.KVStoreConfig;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class v4 {
    public static final Map<String, IKVStore> a = new HashMap();

    public static IKVStore a(Context context, String str) {
        Map<String, IKVStore> map = a;
        if (map.containsKey(str)) {
            LoggerImpl.global().debug("[{}][KVStore]KVStoreUtil find KVStore cache, sp_name: {}", "global", str);
            return map.get(str);
        }
        LoggerImpl.global().debug("[{}][KVStore]KVStoreUtil create global default KVStore, sp_name: {}", "global", str);
        u4 u4Var = new u4("global", context, str);
        map.put(str, u4Var);
        return u4Var;
    }

    public static IKVStore a(InitConfig initConfig, Context context, String str) {
        String aid;
        IKVStore u4Var;
        KVStoreConfig kvStoreConfig = KVStoreConfig.DEFAULT_CONFIG;
        if (initConfig != null) {
            kvStoreConfig = initConfig.getKvStoreConfig();
            aid = initConfig.getAid();
        } else {
            LoggerImpl.global().warn("[{}][KVStore]KVStoreUtil createKVStore init config is null", "");
            aid = "";
        }
        Map<String, IKVStore> map = a;
        if (map.containsKey(str)) {
            LoggerImpl.global().debug("[{}][KVStore]KVStoreUtil find KVStore cache, sp_name: {}", aid, str);
            return map.get(str);
        }
        if (kvStoreConfig.isSecurityMode()) {
            String aesKey = kvStoreConfig.getAesKey();
            try {
                LoggerImpl.global().debug("[{}][KVStore]KVStoreUtil createKVStore use SecurityKVStore, sp_name: {}", aid, str);
                u4Var = TextUtils.isEmpty(aesKey) ? new w4(aid, context, str) : new w4(aid, context, str, aesKey);
            } catch (Exception e) {
                LoggerImpl.global().error("[{}][KVStore]KVStoreUtil createKVStore use SecurityKVStore failed, use DefaultKVStore, sp_name: {}", e, aid, str);
                a(q4.a(context, str, 0), aid);
                u4Var = new u4(aid, context, str);
            }
        } else {
            LoggerImpl.global().debug("[{}][KVStore]KVStoreUtil createKVStore use DefaultKVStore, sp_name: {}", aid, str);
            u4Var = new u4(aid, context, str);
        }
        a.put(str, u4Var);
        return u4Var;
    }

    public static void a(SharedPreferences sharedPreferences, String str) {
        if (sharedPreferences == null) {
            LoggerImpl.global().debug("[{}][KVStore]kv clear failed, preferences == null: {}", str);
            return;
        }
        for (String str2 : sharedPreferences.getAll().keySet()) {
            sharedPreferences.edit().remove(str2).apply();
            LoggerImpl.global().debug("[{}][KVStore]SecurityKVStore kv change, delete key: {}", str, str2);
        }
    }
}
