package com.android.contacts.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.GlobalProxyLancet;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class PreloadResourcesManager {
    private static final int BACKUP_POOL_SIZE = 5;
    private static final int CORE_POOL_SIZE = 1;
    private static final int DEFAULT_STACK_SIZE = 10;
    private static final int KEEP_ALIVE_SECONDS = 3;
    private static final int MAXIMUM_POOL_SIZE = 20;
    private static final Executor THREAD_POOL_EXECUTOR = null;
    private static Object mLockObj;
    private static PreloadResourcesManager sManager;
    private static final ThreadFactory sThreadFactory = null;
    private Context mAppContext;
    private Map<Integer, Bitmap> mBitmapStacks;
    private Map<Integer, Drawable> mDrawableStacks;
    private Map<Integer, Stack<View>> mViewStacks;

    static /* synthetic */ Context access$000(PreloadResourcesManager r0) {
        return r0.mAppContext;
    }

    static /* synthetic */ Map access$100(PreloadResourcesManager r0) {
        return r0.mViewStacks;
    }

    static {
        ThreadFactory r7 = new AnonymousClass1();
        sThreadFactory = r7;
        mLockObj = new Object();
        THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(1, 20, 3, TimeUnit.SECONDS, new SynchronousQueue(), r7);
    }

    public static final PreloadResourcesManager getInstance(Context r2) {
        if (sManager != null) goto L15;
        Object r0 = mLockObj;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sManager != null) goto L9;
        sManager = new PreloadResourcesManager(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return sManager;
    }

    private PreloadResourcesManager(Context r1) {
        this.mAppContext = r1.getApplicationContext();
        this.mViewStacks = new HashMap();
        this.mBitmapStacks = new HashMap();
        this.mDrawableStacks = new HashMap();
    }

    public View getView(int r2) {
        Stack<View> r1 = this.mViewStacks.get(Integer.valueOf(r2));
        if (r1 != null) goto L5;
        return null;
    L5:
        if (r1.isEmpty() == true) goto L10;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("xiaor", "size: " + r1.size());
        return r1.pop();
    L10:
        return null;
    }

    public void loadLayout(int r2) {
        loadLayout(r2, 10);
    }

    public void loadLayout(final int r3, final int r4) {
        THREAD_POOL_EXECUTOR.execute(new AnonymousClass2(this, r4, r3));
    }
}
