package com.android.contacts.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class NumberMarkResource {
    private static NumberMarkResource mNumberMarkResource;
    private Context mContext;
    private HashMap<Integer, Bitmap> mResourceMap;
    private Resources mResources;

    static {
    }

    private NumberMarkResource(Context r2) {
        this.mContext = null;
        this.mResources = null;
        this.mResourceMap = new HashMap();
        this.mContext = r2;
        this.mResources = r2.getResources();
    }

    public static synchronized NumberMarkResource getInstance(Context r2) {
        monitor-enter(NumberMarkResource.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (mNumberMarkResource != null) goto L7;
        mNumberMarkResource = new NumberMarkResource(r2.getApplicationContext());     // Catch: Throwable -> L10
    L7:
        NumberMarkResource r3 = mNumberMarkResource;     // Catch: Throwable -> L10
        monitor-exit(NumberMarkResource.class);
        return r3;
    }

    public Bitmap getResource(int r3) {
        Bitmap r0 = this.mResourceMap.get(Integer.valueOf(r3));
        if (r0 != null) goto L6;
        Bitmap r1 = BitmapFactory.decodeResource(this.mResources, r3);
        this.mResourceMap.put(Integer.valueOf(r3), r1);
        return r1;
    L6:
        return r0;
    }

    public boolean contains(int r1) {
        return this.mResourceMap.containsKey(Integer.valueOf(r1));
    }
}
