package com.bytedance.bdtracker;

import android.text.TextUtils;
import com.bytedance.applog.store.kv.IKVStore;
import java.util.UUID;

/* loaded from: classes.dex */
public final class x5 {
    public static w5<String> a = new a();

    public static class a extends w5<String> {
        @Override // com.bytedance.bdtracker.w5
        public String a(Object[] objArr) {
            IKVStore iKVStore = (IKVStore) objArr[0];
            String string = iKVStore.getString("cdid", "");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            String string2 = UUID.randomUUID().toString();
            iKVStore.putString("cdid", string2);
            return string2;
        }
    }
}
