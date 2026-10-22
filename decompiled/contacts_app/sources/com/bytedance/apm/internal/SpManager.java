package com.bytedance.apm.internal;

import android.content.SharedPreferences;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.core.MonitorSharedPreferences;

/* JADX INFO: loaded from: classes2.dex */
public class SpManager {
    private final SharedPreferences mSharedPreferences;

    /* JADX INFO: renamed from: com.bytedance.apm.internal.SpManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class Holder {
        private static final SpManager INSTANCE = null;

        private Holder() {
        }

        static /* synthetic */ SpManager access$100() {
            return INSTANCE;
        }

        static {
            INSTANCE = new SpManager(null);
        }
    }

    /* synthetic */ SpManager(AnonymousClass1 r1) {
        this();
    }

    private SpManager() {
        this.mSharedPreferences = MonitorSharedPreferences.getSharedPreferences(ApmContext.getContext(), "monitor_config");
    }

    public static SpManager getInstance() {
        return Holder.access$100();
    }

    public String getString(String r2) {
        return this.mSharedPreferences.getString(r2, null);
    }

    public int getInt(String r2) {
        return this.mSharedPreferences.getInt(r2, -1);
    }

    public long getLong(String r3) {
        return this.mSharedPreferences.getLong(r3, 0);
    }

    public void saveAsync(String r1, String r2) {
        this.mSharedPreferences.edit().putString(r1, r2).apply();
    }

    public void saveAsync(String r1, long r2) {
        this.mSharedPreferences.edit().putLong(r1, r2).apply();
    }

    public void saveAsync(String r1, int r2) {
        this.mSharedPreferences.edit().putInt(r1, r2).apply();
    }
}
