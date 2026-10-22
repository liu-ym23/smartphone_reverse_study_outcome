package com.bytedance.keva;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class KevaBuilder {
    private static KevaBuilder mInstance;
    Context mContext;
    Executor mExecutor;
    KevaMonitor mMonitor;
    String mPortedRepoName;
    File mWorkDir;

    static {
        mInstance = new KevaBuilder();
    }

    public KevaBuilder() {
    }

    public static void clearInstance() {
        mInstance = null;
    }

    public static KevaBuilder getInstance() {
        KevaBuilder r10 = mInstance;
        if (r10 == null) goto L5;
        return r10;
    L5:
        Log.w(KevaConstants.TAG, "have already did init, builder is invalid now!");
        return new KevaBuilder();
    }

    public KevaBuilder setContext(Context r10) {
        this.mContext = r10;
        return this;
    }

    public KevaBuilder setExecutor(Executor r10) {
        this.mExecutor = r10;
        return this;
    }

    public KevaBuilder setMonitor(KevaMonitor r10) {
        this.mMonitor = r10;
        return this;
    }

    public KevaBuilder setPortedRepoName(String r10) {
        this.mPortedRepoName = r10;
        return this;
    }

    public KevaBuilder setWorkDir(File r10) {
        if (r10.exists() == true) goto L8;
        Log.i(KevaConstants.TAG, "work dir does not exist! try to create " + r10.getPath());
        if (r10.mkdirs() == true) goto L8;
        Log.w(KevaConstants.TAG, "work dir fail to create!");
        return this;
    L8:
        this.mWorkDir = r10;
        return this;
    }
}
