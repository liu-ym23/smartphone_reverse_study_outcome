package com.bytedance.bdturing.ttnet;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.volcengine.zeus.provider.PluginContentProvider;

/* JADX INFO: loaded from: classes.dex */
public class BdTuringInitProvider extends PluginContentProvider {
    public int delete(Uri r1, String r2, String[] r3) {
        return 0;
    }

    public String getType(Uri r1) {
        return null;
    }

    public Uri insert(Uri r1, ContentValues r2) {
        return null;
    }

    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        return null;
    }

    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        return 0;
    }

    public BdTuringInitProvider() {
    }

    public boolean onCreate() {
        c.a();     // Catch: Exception -> L4
        return true;
    L4:
        e = move-exception;
        e.printStackTrace();
        return true;
    }
}
