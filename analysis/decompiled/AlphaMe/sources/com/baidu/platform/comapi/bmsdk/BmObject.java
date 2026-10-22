package com.baidu.platform.comapi.bmsdk;

import com.baidu.platform.comapi.util.MapTaskManager;

/* loaded from: classes.dex */
public abstract class BmObject implements AutoCloseable {
    private static final boolean DEBUG = false;
    private boolean isRelease;
    private String mName;
    protected final int mObjType;
    private String mTag;
    protected final long nativeInstance;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f8650a;

        public a(long j4) {
            this.f8650a = j4;
        }

        @Override // java.lang.Runnable
        public void run() {
            BmFinalizerObject.a(this.f8650a);
        }
    }

    private BmObject() {
        this.mName = "";
        this.mTag = "";
        this.isRelease = false;
        this.mObjType = 0;
        this.nativeInstance = 0L;
    }

    private synchronized void dispose() {
        long j4 = this.nativeInstance;
        if (j4 != 0 && !this.isRelease) {
            this.isRelease = true;
            MapTaskManager.getSingleThreadPool().submit(new a(j4));
        }
    }

    private static native void nativeFinalizer(long j4);

    private static native boolean nativeSetLayerTag(long j4, String str);

    private void printDebugFinalize() {
    }

    private void printDebugNew() {
    }

    @Override // java.lang.AutoCloseable
    public void close() throws Exception {
        try {
            dispose();
        } catch (Throwable unused) {
        }
    }

    public String getName() {
        return this.mName;
    }

    public long getNativeInstance() {
        return this.nativeInstance;
    }

    public int getObjType() {
        return this.mObjType;
    }

    public String getTag() {
        return this.mTag;
    }

    public boolean setLayerTag(String str) {
        return nativeSetLayerTag(this.nativeInstance, str);
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setTag(String str) {
        this.mTag = str;
    }

    public BmObject(int i4, long j4) {
        this.mName = "";
        this.mTag = "";
        this.isRelease = false;
        this.mObjType = i4;
        this.nativeInstance = j4;
    }
}
