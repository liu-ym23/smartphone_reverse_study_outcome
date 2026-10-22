package com.android.contacts.common.testing;

import android.content.ContentResolver;
import android.content.SharedPreferences;
import com.google.common.collect.Maps;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class InjectedServices {
    private ContentResolver mContentResolver;
    private SharedPreferences mSharedPreferences;
    private HashMap<String, Object> mSystemServices;

    public InjectedServices() {
    }

    public void setContentResolver(ContentResolver r1) {
        this.mContentResolver = r1;
    }

    public ContentResolver getContentResolver() {
        return this.mContentResolver;
    }

    public void setSharedPreferences(SharedPreferences r1) {
        this.mSharedPreferences = r1;
    }

    public SharedPreferences getSharedPreferences() {
        return this.mSharedPreferences;
    }

    public void setSystemService(String r2, Object r3) {
        if (this.mSystemServices != null) goto L5;
        this.mSystemServices = Maps.newHashMap();
    L5:
        this.mSystemServices.put(r2, r3);
    }

    public Object getSystemService(String r1) {
        HashMap<String, Object> r0 = this.mSystemServices;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.get(r1);
    }
}
