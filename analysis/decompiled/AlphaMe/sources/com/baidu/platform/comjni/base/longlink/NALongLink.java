package com.baidu.platform.comjni.base.longlink;

import B0.g;
import android.util.Log;
import com.baidu.platform.comapi.JNIInitializer;
import com.baidu.platform.comapi.longlink.ELongLinkStatus;
import com.baidu.platform.comapi.longlink.LongLinkDataCallback;
import com.baidu.platform.comapi.longlink.LongLinkFileData;
import com.baidu.platform.comjni.JNIBaseApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class NALongLink extends JNIBaseApi {

    /* renamed from: a, reason: collision with root package name */
    private static Map<Integer, LinkedList<Object>> f9309a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private static ELongLinkStatus[] f9310b = {ELongLinkStatus.OK, ELongLinkStatus.SendFormatError, ELongLinkStatus.SendUnRegistered, ELongLinkStatus.SendLimited, ELongLinkStatus.SendDataLenLimited, ELongLinkStatus.SendInvalidReqID, ELongLinkStatus.ResultConnectError, ELongLinkStatus.ResultSendError, ELongLinkStatus.ResultTimeout, ELongLinkStatus.ResultServerError, ELongLinkStatus.CloudStop, ELongLinkStatus.CloudRestart};

    public static long create() {
        return nativeCreate();
    }

    public static boolean init(long j4, String str, String str2) {
        return nativeInit(j4, str, str2);
    }

    private static native long nativeCreate();

    private static native boolean nativeInit(long j4, String str, String str2);

    private static native boolean nativeRegister(long j4, int i4);

    private static native int nativeRelease(long j4);

    private static native int nativeSendData(long j4, int i4, int i5, byte[] bArr);

    private static native int nativeSendFileData(long j4, int i4, int i5, String str, ArrayList<LongLinkFileData> arrayList);

    private static native boolean nativeStart(long j4);

    private static native boolean nativeStop(long j4);

    private static native boolean nativeUnRegister(long j4, int i4);

    public static boolean onJNILongLinkDataCallback(int i4, int i5, int i6, byte[] bArr, boolean z4) throws Exception {
        LinkedList linkedList;
        StringBuilder sbU = g.u("onJNILongLinkDataCallback:", i4, " status:", i5, " reqId:");
        sbU.append(i6);
        sbU.append(" isPush:");
        sbU.append(z4);
        Log.e("JNILongLink", sbU.toString());
        if (i5 < 0 || i5 >= f9310b.length) {
            Log.e("JNILongLink", "invalid status = " + i5);
            if (JNIInitializer.isDebug()) {
                throw new IndexOutOfBoundsException();
            }
            return false;
        }
        if (bArr == null || bArr.length <= 0) {
            bArr = new byte[0];
        }
        synchronized (NALongLink.class) {
            try {
                LinkedList<Object> linkedList2 = f9309a.get(Integer.valueOf(i4));
                linkedList = linkedList2 != null ? new LinkedList(linkedList2) : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (linkedList == null || linkedList.size() <= 0) {
            return true;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next != null) {
                try {
                    if (next instanceof LongLinkDataCallback) {
                        ELongLinkStatus eLongLinkStatus = f9310b[i5];
                        eLongLinkStatus.setRequestId(i6);
                        String name = next.getClass().getName();
                        Log.d("JNILongLink", "className = " + name);
                        ((LongLinkDataCallback) next).onReceiveData(eLongLinkStatus, i6, bArr, z4);
                        Log.d("JNILongLink", "className = " + name + "done");
                    }
                } catch (Exception e4) {
                    Log.e("JNILongLink", "className = " + next.getClass().getName() + ",exception = " + e4.toString());
                    if (JNIInitializer.isDebug()) {
                        throw e4;
                    }
                }
            }
        }
        return true;
    }

    public static boolean register(long j4, int i4, Object obj) {
        boolean z4;
        if (obj != null) {
            StringBuilder sbT = g.t("register moduleId = ", i4, ", callback = ");
            sbT.append(obj.getClass().getName());
            Log.e("JNILongLink", sbT.toString());
        } else {
            Log.e("JNILongLink", "register moduleId = " + i4 + ", callback = " + obj);
        }
        synchronized (NALongLink.class) {
            try {
                LinkedList<Object> linkedList = f9309a.get(Integer.valueOf(i4));
                if (linkedList == null) {
                    LinkedList<Object> linkedList2 = new LinkedList<>();
                    linkedList2.add(obj);
                    f9309a.put(Integer.valueOf(i4), linkedList2);
                    z4 = true;
                } else {
                    z4 = false;
                    if (!linkedList.contains(obj)) {
                        linkedList.add(obj);
                        f9309a.put(Integer.valueOf(i4), linkedList);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z4) {
            return nativeRegister(j4, i4);
        }
        return true;
    }

    public static int release(long j4) {
        return nativeRelease(j4);
    }

    public static int sendData(long j4, int i4, int i5, byte[] bArr) {
        return nativeSendData(j4, i4, i5, bArr);
    }

    public static int sendFileData(long j4, int i4, int i5, String str, ArrayList<LongLinkFileData> arrayList) {
        return nativeSendFileData(j4, i4, i5, str, arrayList);
    }

    public static boolean start(long j4) {
        return nativeStart(j4);
    }

    public static boolean stop(long j4) {
        return nativeStop(j4);
    }

    public static boolean unRegister(long j4, int i4, Object obj) {
        LinkedList<Object> linkedList;
        if (obj != null) {
            StringBuilder sbT = g.t("unegister moduleId = ", i4, ", callback = ");
            sbT.append(obj.getClass().getName());
            Log.e("JNILongLink", sbT.toString());
        } else {
            Log.e("JNILongLink", "unregister moduleId = " + i4 + ", callback = " + obj);
        }
        synchronized (NALongLink.class) {
            try {
                linkedList = f9309a.get(Integer.valueOf(i4));
                if (linkedList != null) {
                    if (obj != null) {
                        linkedList.remove(obj);
                    }
                    if (linkedList.isEmpty()) {
                        f9309a.remove(Integer.valueOf(i4));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (linkedList == null) {
            return false;
        }
        if (linkedList.isEmpty()) {
            return nativeUnRegister(j4, i4);
        }
        return true;
    }
}
