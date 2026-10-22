package com.baidu.platform.comjni.engine;

import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class MessageProxy {

    /* renamed from: a, reason: collision with root package name */
    private static final SparseArray<List<Handler>> f9315a = new SparseArray<>();

    public static void destroy() {
        int size = f9315a.size();
        for (int i4 = 0; i4 < size; i4++) {
            SparseArray<List<Handler>> sparseArray = f9315a;
            List<Handler> list = sparseArray.get(sparseArray.keyAt(i4));
            if (list != null) {
                list.clear();
            }
        }
        f9315a.clear();
    }

    public static void dispatchMessage(int i4, int i5, int i6, long j4) {
        SparseArray<List<Handler>> sparseArray = f9315a;
        synchronized (sparseArray) {
            try {
                List<Handler> list = sparseArray.get(i4);
                if (list != null && !list.isEmpty()) {
                    for (Handler handler : list) {
                        Message messageObtain = Message.obtain(handler, i4, i5, i6, Long.valueOf(j4));
                        if (i4 == 39 && (i5 == 0 || i5 == 1)) {
                            handler.handleMessage(messageObtain);
                        } else {
                            messageObtain.sendToTarget();
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void registerMessageHandler(int i4, Handler handler) {
        if (handler == null) {
            return;
        }
        SparseArray<List<Handler>> sparseArray = f9315a;
        synchronized (sparseArray) {
            try {
                List<Handler> list = sparseArray.get(i4);
                if (list == null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(handler);
                    sparseArray.put(i4, arrayList);
                } else if (!list.contains(handler)) {
                    list.add(handler);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void unRegisterMessageHandler(int i4, Handler handler) {
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            SparseArray<List<Handler>> sparseArray = f9315a;
            synchronized (sparseArray) {
                try {
                    List<Handler> list = sparseArray.get(i4);
                    if (list != null) {
                        list.remove(handler);
                    }
                } finally {
                }
            }
        }
    }
}
