package com.baidu.platform.comapi.bmsdk;

import com.baidu.platform.comapi.util.MapTaskManager;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public abstract class BmObject implements AutoCloseable {
    private static final boolean DEBUG = false;
    protected static final int LOCK_WAIT_TIME = 2000;
    private boolean isRelease;
    private String mName;
    protected final ReadWriteLock mNativeLock;
    protected final int mObjType;
    private String mTag;
    protected final long nativeInstance;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f32788a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BmObject f32789b;

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_platform_comapi_bmsdk_BmObject$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_baidu_platform_comapi_bmsdk_BmObject$a__run$___twin___() {
            BmFinalizerObject.a(this.f32788a);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_platform_comapi_bmsdk_BmObject$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_baidu_platform_comapi_bmsdk_BmObject$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(BmObject r100, long r101) {
            this.f32789b = r100;
            this.f32788a = r101;
        }
    }

    private void dispose() {
        boolean r100 = false;
        r100 = this.mNativeLock.writeLock().tryLock(2000, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L11 Throwable -> L14
        if (r100 == false) goto L12;
        long r101 = this.nativeInstance;     // Catch: InterruptedException -> L11 Throwable -> L14
        if (r101 == 0) goto L12;
        if (this.isRelease == true) goto L12;
        this.isRelease = true;     // Catch: InterruptedException -> L11 Throwable -> L14
        MapTaskManager.getSingleThreadPool().submit(new a(this, r101));     // Catch: InterruptedException -> L11 Throwable -> L14
    L12:
        if (r100 == false) goto L23;
    L19:
        this.mNativeLock.writeLock().unlock();
        return;
    L23:
        return;
    L14:
        th = move-exception;
        if (r100 == false) goto L17;
        this.mNativeLock.writeLock().unlock();
    L17:
        throw th;
    L18:
        if (r100 == true) goto L19;
    }

    private static native void nativeFinalizer(long r100);

    private static native boolean nativeSetLayerTag(long r100, String r101);

    private void printDebugFinalize() {
    }

    private void printDebugNew() {
    }

    public long getNativeInstance() {
        if (this.isRelease == false) goto L7;
        return 0;
    L7:
        return this.nativeInstance;
    }

    private BmObject() {
        this.mName = "";
        this.mTag = "";
        this.isRelease = false;
        this.mNativeLock = new ReentrantReadWriteLock(true);
        this.mObjType = 0;
        this.nativeInstance = 0;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws Exception {
        dispose();     // Catch: Throwable -> L4
        return;
    }

    public String getName() {
        return this.mName;
    }

    public int getObjType() {
        return this.mObjType;
    }

    public String getTag() {
        return this.mTag;
    }

    public boolean setLayerTag(String r100) {
        return nativeSetLayerTag(this.nativeInstance, r100);
    }

    public void setName(String r100) {
        this.mName = r100;
    }

    public void setTag(String r100) {
        this.mTag = r100;
    }

    public BmObject(int r100, long r101) {
        this.mName = "";
        this.mTag = "";
        this.isRelease = false;
        this.mNativeLock = new ReentrantReadWriteLock(true);
        this.mObjType = r100;
        this.nativeInstance = r101;
    }
}
