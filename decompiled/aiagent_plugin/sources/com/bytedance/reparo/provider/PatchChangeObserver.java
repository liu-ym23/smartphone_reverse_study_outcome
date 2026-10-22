package com.bytedance.reparo.provider;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import com.bytedance.reparo.c.e;
import com.bytedance.reparo.d;

/* JADX INFO: loaded from: classes.dex */
public class PatchChangeObserver extends ContentObserver {
    private static final String SEPARATOR = ";";
    private static final String TAG = "PatchChangeObserver";

    public PatchChangeObserver(Handler r1) {
        super(r1);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean r1, Uri r2) {
        d.a().d();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        e.a(TAG, "PatchChangeObserver -> onChanged failed:", th);
    }
}
