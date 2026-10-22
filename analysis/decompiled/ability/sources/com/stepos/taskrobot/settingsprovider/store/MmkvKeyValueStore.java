package com.stepos.taskrobot.settingsprovider.store;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.tencent.mmkv.MMKV;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/taskrobot/settingsprovider/store/MmkvKeyValueStore;", "Lcom/stepos/taskrobot/settingsprovider/store/KeyValueStore;", "Lcom/tencent/mmkv/MMKV;", "mmkv", AppAgent.CONSTRUCT, "(Lcom/tencent/mmkv/MMKV;)V", "", "key", "getString", "(Ljava/lang/String;)Ljava/lang/String;", "value", "LC7/r;", "putString", "(Ljava/lang/String;Ljava/lang/String;)V", "", "defaultValue", "getBoolean", "(Ljava/lang/String;Z)Z", "putBoolean", "(Ljava/lang/String;Z)V", "contains", "(Ljava/lang/String;)Z", "Lcom/tencent/mmkv/MMKV;", "settingsprovider_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MmkvKeyValueStore implements KeyValueStore {
    private final MMKV mmkv;

    public MmkvKeyValueStore(MMKV mmkv) {
        k.f(mmkv, "mmkv");
        this.mmkv = mmkv;
    }

    @Override // com.stepos.taskrobot.settingsprovider.store.KeyValueStore
    public boolean contains(String key) {
        k.f(key, "key");
        return this.mmkv.containsKey(key);
    }

    @Override // com.stepos.taskrobot.settingsprovider.store.KeyValueStore
    public boolean getBoolean(String key, boolean defaultValue) {
        k.f(key, "key");
        return this.mmkv.decodeBool(key, defaultValue);
    }

    @Override // com.stepos.taskrobot.settingsprovider.store.KeyValueStore
    public String getString(String key) {
        k.f(key, "key");
        return this.mmkv.decodeString(key, null);
    }

    @Override // com.stepos.taskrobot.settingsprovider.store.KeyValueStore
    public void putBoolean(String key, boolean value) {
        k.f(key, "key");
        this.mmkv.encode(key, value);
    }

    @Override // com.stepos.taskrobot.settingsprovider.store.KeyValueStore
    public void putString(String key, String value) {
        k.f(key, "key");
        k.f(value, "value");
        this.mmkv.encode(key, value);
    }
}
