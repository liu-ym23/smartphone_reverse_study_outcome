package com.baidu.platform.comjni.base.longlink;

import com.baidu.platform.comapi.JNIInitializer;
import com.baidu.platform.comapi.longlink.ELongLinkStatus;
import com.baidu.platform.comapi.longlink.LongLinkDataCallback;
import com.baidu.platform.comapi.longlink.LongLinkFileData;
import com.baidu.platform.comjni.JNIBaseApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes39.dex */
public class NALongLink extends JNIBaseApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<Integer, LinkedList<Object>> f33430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ELongLinkStatus[] f33431b;

    private static native long nativeCreate();

    private static native boolean nativeInit(long r100, String r101, String r102);

    private static native boolean nativeRegister(long r100, int r101);

    private static native int nativeRelease(long r100);

    private static native int nativeSendData(long r100, int r101, int r102, byte[] r103);

    private static native int nativeSendFileData(long r100, int r101, int r102, String r103, ArrayList<LongLinkFileData> r104);

    private static native boolean nativeStart(long r100);

    private static native boolean nativeStop(long r100);

    private static native boolean nativeUnRegister(long r100, int r101);

    static {
        f33430a = new ConcurrentHashMap();
        f33431b = new ELongLinkStatus[]{ELongLinkStatus.OK, ELongLinkStatus.SendFormatError, ELongLinkStatus.SendUnRegistered, ELongLinkStatus.SendLimited, ELongLinkStatus.SendDataLenLimited, ELongLinkStatus.SendInvalidReqID, ELongLinkStatus.ResultConnectError, ELongLinkStatus.ResultSendError, ELongLinkStatus.ResultTimeout, ELongLinkStatus.ResultServerError, ELongLinkStatus.CloudStop, ELongLinkStatus.CloudRestart};
    }

    public static long create() {
        return nativeCreate();
    }

    public NALongLink() {
    }

    public static int release(long r100) {
        return nativeRelease(r100);
    }

    public static boolean start(long r100) {
        return nativeStart(r100);
    }

    public static boolean stop(long r100) {
        return nativeStop(r100);
    }

    public static boolean init(long r100, String r101, String r102) {
        return nativeInit(r100, r101, r102);
    }

    public static boolean register(long r100, int r101, Object r102) {
        if (r102 != null) goto L6;
        Objects.toString(r102);
    L6:
        monitor-enter(NALongLink.class);
        LinkedList<Object> r103 = f33430a.get(Integer.valueOf(r101));     // Catch: Throwable -> L18
        if (r103 != null) goto L10;
        LinkedList<Object> r104 = new LinkedList();     // Catch: Throwable -> L18
        r104.add(r102);     // Catch: Throwable -> L18
        f33430a.put(Integer.valueOf(r101), r104);     // Catch: Throwable -> L18
        boolean r105 = true;
    L13:
        monitor-exit(NALongLink.class);     // Catch: Throwable -> L18
        if (r105 == true) goto L16;
        return true;
    L16:
        return nativeRegister(r100, r101);
    L10:
        r105 = false;
        if (r103.contains(r102) == true) goto L13;
        r103.add(r102);     // Catch: Throwable -> L18
        f33430a.put(Integer.valueOf(r101), r103);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public static boolean unRegister(long r100, int r101, Object r102) {
        if (r102 != null) goto L6;
        Objects.toString(r102);
    L6:
        monitor-enter(NALongLink.class);
        LinkedList<Object> r103 = f33430a.get(Integer.valueOf(r101));     // Catch: Throwable -> L24
        if (r103 == null) goto L14;
        if (r102 == null) goto L12;
        r103.remove(r102);     // Catch: Throwable -> L24
    L12:
        if (r103.isEmpty() == false) goto L14;
        f33430a.remove(Integer.valueOf(r101));     // Catch: Throwable -> L24
    L14:
        monitor-exit(NALongLink.class);     // Catch: Throwable -> L24
        if (r103 != null) goto L17;
        return false;
    L17:
        if (r103.isEmpty() == true) goto L19;
        return true;
    L19:
        return nativeUnRegister(r100, r101);
    L24:
        th = move-exception;
        throw th;
    }

    public static int sendData(long r100, int r101, int r102, byte[] r103) {
        return nativeSendData(r100, r101, r102, r103);
    }

    public static boolean onJNILongLinkDataCallback(int r100, int r101, int r102, byte[] r103, boolean r104) {
        if (r101 < 0) goto L42;
        if (r101 >= f33431b.length) goto L42;
        if (r103 != null) goto L9;
    L10:
        r103 = new byte[0];
    L12:
        monitor-enter(NALongLink.class);
        LinkedList<Object> r105 = f33430a.get(Integer.valueOf(r100));     // Catch: Throwable -> L38
        if (r105 == null) goto L16;
        LinkedList r106 = new LinkedList(r105);     // Catch: Throwable -> L38
    L17:
        monitor-exit(NALongLink.class);     // Catch: Throwable -> L38
        if (r106 != null) goto L20;
        return true;
    L20:
        if (r106.size() <= 0) goto L58;
        Iterator r107 = r106.iterator();
    L23:
        if (r107.hasNext() == false) goto L59;
        Object r108 = r107.next();
        if (r108 == null) goto L23;
    L31:
        e = move-exception;
        e.toString();
        if (JNIInitializer.isDebug() == false) goto L23;
        throw e;
    L28:
        if ((r108 instanceof LongLinkDataCallback) == false) goto L23;
        ELongLinkStatus r109 = f33431b[r101];     // Catch: Exception -> L31
        r109.setRequestId(r102);     // Catch: Exception -> L31
        ((LongLinkDataCallback) r108).onReceiveData(r109, r102, r103, r104);     // Catch: Exception -> L31
        goto L23
    L59:
        return true;
    L58:
        return true;
    L16:
        r106 = null;
    L38:
        th = move-exception;
        throw th;
    L9:
        if (r103.length > 0) goto L12;
    L42:
        if (JNIInitializer.isDebug() == true) goto L45;
        return false;
    L45:
        throw new IndexOutOfBoundsException();
    }

    public static int sendFileData(long r100, int r101, int r102, String r103, ArrayList<LongLinkFileData> r104) {
        return nativeSendFileData(r100, r101, r102, r103, r104);
    }
}
