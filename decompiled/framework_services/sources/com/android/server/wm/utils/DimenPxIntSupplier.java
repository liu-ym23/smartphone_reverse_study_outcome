package com.android.server.wm.utils;

import android.content.Context;
import java.util.function.IntSupplier;

/* JADX INFO: loaded from: classes3.dex */
public class DimenPxIntSupplier implements IntSupplier {
    private final Context mContext;
    private float mLastDensity;
    private final int mResourceId;
    private int mValue;

    public DimenPxIntSupplier(Context context, int resourceId) {
        this.mLastDensity = Float.MIN_VALUE;
        this.mValue = 0;
        this.mContext = context;
        this.mResourceId = resourceId;
    }

    @Override // java.util.function.IntSupplier
    public int getAsInt() {
        float newDensity = this.mContext.getResources().getDisplayMetrics().density;
        if (newDensity == this.mLastDensity) goto L6;
        this.mLastDensity = newDensity;
        this.mValue = this.mContext.getResources().getDimensionPixelSize(this.mResourceId);
    L6:
        return this.mValue;
    }
}
