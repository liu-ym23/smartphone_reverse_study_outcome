package com.bytedance.bdtracker;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.applog.store.kv.IKVStore;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public abstract class t4 implements IKVStore {
    public final AtomicReference<SharedPreferences> a;
    public final String b;
    public final Context c;

    public t4(String str, Context context, String str2) {
        AtomicReference<SharedPreferences> atomicReference = new AtomicReference<>();
        this.a = atomicReference;
        this.b = str;
        this.c = context;
        atomicReference.set(q4.a(context, str2, 0));
    }

    public abstract String a();

    public abstract void a(String str);

    public abstract void a(String str, int i);

    public abstract void a(String str, long j);

    public abstract void a(String str, String str2);

    public abstract void a(String str, Set<String> set);

    public abstract void a(String str, boolean z);

    @Override // com.bytedance.applog.store.kv.IKVStore
    public IKVStore clear() {
        SharedPreferences sharedPreferences = this.a.get();
        if (sharedPreferences != null) {
            sharedPreferences.edit().clear().apply();
            return this;
        }
        LoggerImpl.global().warn("[{}][KVStore]clear failed, preferences == null, key: {}", this.b);
        return this;
    }

    @Override // com.bytedance.applog.store.kv.IKVStore
    public boolean contains(String str) {
        SharedPreferences sharedPreferences = this.a.get();
        if (sharedPreferences == null) {
            LoggerImpl.global().warn("[{}][KVStore]contains failed, preferences == null, key: {}", this.b, str);
            return false;
        }
        return sharedPreferences.contains(a() + str);
    }

    @Override // com.bytedance.applog.store.kv.IKVStore
    public Map<String, ?> getAll() {
        SharedPreferences sharedPreferences = this.a.get();
        if (sharedPreferences != null) {
            return sharedPreferences.getAll();
        }
        LoggerImpl.global().warn("[{}][KVStore]getAll failed, preferences == null, key: {}", this.b);
        return null;
    }

    @Override // com.bytedance.applog.store.kv.IKVStore
    public IKVStore putBoolean(String str, boolean z) {
        a(str);
        a(str, z);
        return this;
    }

    @Override // com.bytedance.applog.store.kv.IKVStore
    public IKVStore putInt(String str, int i) {
        a(str);
        a(str, i);
        return this;
    }

    @Override // com.bytedance.applog.store.kv.IKVStore
    public IKVStore putLong(String str, long j) {
        a(str);
        a(str, j);
        return this;
    }

    @Override // com.bytedance.applog.store.kv.IKVStore
    public IKVStore putString(String str, String str2) {
        a(str);
        a(str, str2);
        return this;
    }

    @Override // com.bytedance.applog.store.kv.IKVStore
    public IKVStore putStringSet(String str, Set<String> set) {
        a(str);
        if (set == null) {
            set = new HashSet<>();
        }
        a(str, set);
        return this;
    }

    @Override // com.bytedance.applog.store.kv.IKVStore
    public IKVStore remove(String str) {
        SharedPreferences sharedPreferences = this.a.get();
        if (sharedPreferences == null) {
            LoggerImpl.global().warn("[{}][KVStore]remove failed, preferences == null, key: {}", this.b, str);
            return this;
        }
        sharedPreferences.edit().remove(a() + str).apply();
        return this;
    }
}
