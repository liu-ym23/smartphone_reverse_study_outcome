package com.bytedance.bdtracker;

import android.content.Context;
import com.bytedance.applog.store.kv.IKVStore;

/* loaded from: classes.dex */
public class m5 {
    public static boolean a;
    public static final a5<IKVStore> b = new a();

    public static class a extends a5<IKVStore> {
        @Override // com.bytedance.bdtracker.a5
        public IKVStore a(Object[] objArr) {
            return v4.a((Context) objArr[0], "ug_install_settings_pref");
        }
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        if (a) {
            return true;
        }
        return b.b(context).getBoolean("_install_started_v2", false);
    }
}
