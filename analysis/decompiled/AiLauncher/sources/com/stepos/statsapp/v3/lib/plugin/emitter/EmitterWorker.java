package com.stepos.statsapp.v3.lib.plugin.emitter;

import android.content.Context;

/* loaded from: classes2.dex */
public abstract class EmitterWorker {
    private static final String TAG = "EmitterWorker";
    protected Context context;

    public EmitterWorker(Context context) {
        this.context = context;
    }
}
