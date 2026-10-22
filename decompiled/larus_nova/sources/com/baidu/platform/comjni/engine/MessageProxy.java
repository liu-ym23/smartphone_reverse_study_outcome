package com.baidu.platform.comjni.engine;

import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class MessageProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SparseArray<List<Handler>> f33436a = null;

    static {
        f33436a = new SparseArray();
    }

    public static void destroy() {
        int r100 = f33436a.size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L8;
        SparseArray<List<Handler>> r102 = f33436a;
        List<Handler> r103 = r102.get(r102.keyAt(r101));
        if (r103 == null) goto L7;
        r103.clear();
    L7:
        r101 = r101 + 1;
        goto L3
    L8:
        f33436a.clear();
    }

    public MessageProxy() {
    }

    public static void registerMessageHandler(int r100, Handler r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        SparseArray<List<Handler>> r102 = f33436a;
        monitor-enter(r102);
        List<Handler> r103 = r102.get(r100);     // Catch: Throwable -> L14
        if (r103 != null) goto L9;
        ArrayList r104 = new ArrayList();     // Catch: Throwable -> L14
        r104.add(r101);     // Catch: Throwable -> L14
        r102.put(r100, r104);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r102);     // Catch: Throwable -> L14
        return;
    L9:
        if (r103.contains(r101) == true) goto L12;
        r103.add(r101);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public static void unRegisterMessageHandler(int r100, Handler r101) {
        if (r101 == null) goto L13;
        r101.removeCallbacksAndMessages(null);
        SparseArray<List<Handler>> r102 = f33436a;
        monitor-enter(r102);
        List<Handler> r103 = r102.get(r100);     // Catch: Throwable -> L10
        if (r103 == null) goto L8;
        r103.remove(r101);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r102);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static void dispatchMessage(int r100, int r101, int r102, long r103) {
        SparseArray<List<Handler>> r104 = f33436a;
        monitor-enter(r104);
        List<Handler> r105 = r104.get(r100);     // Catch: Throwable -> L20
        if (r105 != null) goto L7;
    L18:
        monitor-exit(r104);     // Catch: Throwable -> L20
        return;
    L7:
        if (r105.isEmpty() == true) goto L18;
        Iterator<Handler> r106 = r105.iterator();     // Catch: Throwable -> L20
    L10:
        if (r106.hasNext() == false) goto L18;
        Handler r107 = r106.next();     // Catch: Throwable -> L20
        Message r108 = Message.obtain(r107, r100, r101, r102, Long.valueOf(r103));     // Catch: Throwable -> L20
        if (r100 != 39) goto L17;
        if (r101 == 0) goto L16;
        if (r101 != 1) goto L17;
    L16:
        r107.handleMessage(r108);     // Catch: Throwable -> L20
    L17:
        r108.sendToTarget();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }
}
