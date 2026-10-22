package com.stepos.statsapp.v3.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.stepos.statsapp.v3.utils.log.Logger;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class SharedPreferencesHelper {
    private static final String TAG = "SharedPreferencesHelper";
    private final SharedPreferences sharedPreferences;

    public SharedPreferencesHelper(Context context, String str) {
        Logger.i(TAG, "init SharedPreferences, name: " + str);
        this.sharedPreferences = context.getSharedPreferences(str, 0);
        Logger.d(TAG, str + " structure complete");
    }

    public void applyClear() {
        this.sharedPreferences.edit().clear().apply();
    }

    public void applyConfig(String str, boolean z10) {
        this.sharedPreferences.edit().putBoolean(str, z10).apply();
    }

    public void applyRemove(String str) {
        this.sharedPreferences.edit().remove(str).apply();
    }

    public void commitClear() {
        this.sharedPreferences.edit().clear().commit();
    }

    public void commitConfig(String str, boolean z10) {
        this.sharedPreferences.edit().putBoolean(str, z10).commit();
    }

    public void commitRemove(String str) {
        this.sharedPreferences.edit().remove(str).commit();
    }

    public SharedPreferences.Editor edit() {
        return this.sharedPreferences.edit();
    }

    public Set<? extends Map.Entry<String, ?>> getAllEntries() {
        return this.sharedPreferences.getAll().entrySet();
    }

    public int getAllSize() {
        return this.sharedPreferences.getAll().size();
    }

    public boolean getConfig(String str, boolean z10) {
        return this.sharedPreferences.getBoolean(str, z10);
    }

    public void applyConfig(String str, int i10) {
        this.sharedPreferences.edit().putInt(str, i10).apply();
    }

    public void commitConfig(String str, int i10) {
        this.sharedPreferences.edit().putInt(str, i10).commit();
    }

    public int getConfig(String str, int i10) {
        return this.sharedPreferences.getInt(str, i10);
    }

    public void applyConfig(String str, long j10) {
        this.sharedPreferences.edit().putLong(str, j10).apply();
    }

    public void commitConfig(String str, long j10) {
        this.sharedPreferences.edit().putLong(str, j10).commit();
    }

    public long getConfig(String str, long j10) {
        return this.sharedPreferences.getLong(str, j10);
    }

    public void applyConfig(String str, String str2) {
        this.sharedPreferences.edit().putString(str, str2).apply();
    }

    public void commitConfig(String str, String str2) {
        this.sharedPreferences.edit().putString(str, str2).commit();
    }

    public String getConfig(String str, String str2) {
        return this.sharedPreferences.getString(str, str2);
    }
}
