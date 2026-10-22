package com.byted.cast.proxy.impl;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.byted.cast.proxy.CastProxyMonitor;
import com.byted.cast.proxy.ErrorCode;
import com.byted.cast.proxy.Event;
import com.byted.cast.proxy.INetwork;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.miui.easygo.constant.EasyGoConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import org.nanohttpd.protocols.http.response.Response;
import org.nanohttpd.protocols.http.response.Status;

/* JADX INFO: loaded from: classes39.dex */
public class Utils {
    public static final String TAG = "CastProxy";
    public static volatile int discardFrameDelay = 0;
    private static volatile Utils instance = null;
    public static volatile boolean isAVFrameOpt = false;
    public static volatile boolean isOpenInputOpt = false;
    public static volatile INetwork network = null;
    public static volatile String outputResolution = null;
    public static int queueLength = 4096;
    public static volatile String requestId = null;
    public static int socketBufferLength = 6144;
    public static int socketTimeout = 30000;
    public static volatile boolean switchSocketOptimization;
    public volatile LinkedBlockingQueue<byte[]> QUEUE;
    private int consumeCount;
    private int consumeSleepCount;
    private final Runnable discardFrameRunnable;
    private volatile boolean isDiscasdingFrame;
    public volatile boolean isWriteOver;
    private boolean needRecord;
    private int produceCount;
    private int produceSleepCount;
    private final Runnable recordRunnable;
    private volatile long startDiscardTime;
    private final Handler statisticsHandler;

    public static String getMimeType(String r100) {
        return "";
    }

    public void clear() {
        this.isWriteOver = false;
        this.QUEUE.clear();
        this.needRecord = true;
        this.statisticsHandler.removeCallbacks(this.recordRunnable);
        this.statisticsHandler.removeCallbacks(this.discardFrameRunnable);
        this.produceSleepCount = 0;
        this.produceCount = 0;
        this.consumeSleepCount = 0;
        this.consumeCount = 0;
        System.gc();
    }

    public static String getDefaultLocalIpAddr() {
        String r100 = "";
        INetwork r101 = network;     // Catch: Exception -> L43
        if (r101 == null) goto L6;
        Enumeration<NetworkInterface> r102 = r101.getNetworkInterfaces();     // Catch: Exception -> L43
    L7:
        String r103 = "";
        String r104 = r103;
        boolean r105 = true;
    L8:
        if (r102 == null) goto L47;
    L41:
        e = e;
    L45:
        e.printStackTrace();
        goto L47
    L10:
        if (r102.hasMoreElements() == false) goto L47;
        NetworkInterface r106 = r102.nextElement();     // Catch: Exception -> L41
        Enumeration<InetAddress> r107 = r106.getInetAddresses();     // Catch: Exception -> L41
    L13:
        if (r107.hasMoreElements() == false) goto L8;
        InetAddress r110 = r107.nextElement();     // Catch: Exception -> L41
        if (r110.isLoopbackAddress() == true) goto L13;
        if ((r110 instanceof Inet4Address) == false) goto L13;
        if (r105 == false) goto L21;
        r100 = r110.getHostAddress();     // Catch: Exception -> L41
        r105 = false;
    L21:
        if (r106.getName().contains("wlan") == true) goto L39;
        if (r106.getDisplayName().contains("wlan") == true) goto L39;
        if (r106.getName().contains("ap") == true) goto L30;
        if (r106.getDisplayName().contains("ap") == true) goto L30;
    L33:
        if (r106.getName().contains("eth") == true) goto L37;
        if (r106.getDisplayName().contains("eth") == false) goto L13;
    L37:
        if (TextUtils.isEmpty(r104) == false) goto L13;
        r104 = r110.getHostAddress();     // Catch: Exception -> L41
    L30:
        if (TextUtils.isEmpty(r103) == false) goto L33;
        r103 = r110.getHostAddress();     // Catch: Exception -> L41
    L39:
        return r110.getHostAddress();
    L47:
        if (TextUtils.isEmpty(r103) == true) goto L50;
        return r103;
    L50:
        if (TextUtils.isEmpty(r104) == false) goto L52;
        return r100;
    L52:
        return r104;
    L6:
        r102 = NetworkInterface.getNetworkInterfaces();     // Catch: Exception -> L43
    L43:
        e = e;
        r103 = "";
        r104 = r103;
        goto L45
    }

    public static Utils getInstance() {
        if (instance != null) goto L15;
        monitor-enter(Utils.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new Utils();     // Catch: Throwable -> L11
    L9:
        monitor-exit(Utils.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    public static List<String> getLocalIpAddr() {
        ArrayList r100 = new ArrayList();
        INetwork r101 = network;     // Catch: Exception -> L18
        if (r101 == null) goto L6;
        Enumeration<NetworkInterface> r102 = r101.getNetworkInterfaces();     // Catch: Exception -> L18
    L7:
        if (r102.hasMoreElements() == false) goto L20;
        Enumeration<InetAddress> r103 = r102.nextElement().getInetAddresses();     // Catch: Exception -> L18
    L11:
        if (r103.hasMoreElements() == false) goto L7;
        InetAddress r104 = r103.nextElement();     // Catch: Exception -> L18
        if (r104.isLoopbackAddress() == true) goto L11;
        if ((r104 instanceof Inet4Address) == false) goto L11;
        r100.add(r104.getHostAddress().toString());     // Catch: Exception -> L18
    L20:
        return r100;
    L6:
        r102 = NetworkInterface.getNetworkInterfaces();     // Catch: Exception -> L18
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L20
    }

    public byte[] consume() {
        if (this.needRecord == false) goto L6;
        this.needRecord = false;
        this.statisticsHandler.removeCallbacks(this.recordRunnable);
        this.statisticsHandler.postDelayed(this.recordRunnable, 30000);
    L6:
        if (discardFrameDelay <= 0) goto L8;
        this.statisticsHandler.removeCallbacks(this.discardFrameRunnable);
        stopDiscardFrame();
        this.statisticsHandler.postDelayed(this.discardFrameRunnable, ((long) discardFrameDelay) * 1000);
    L8:
        this.consumeCount++;
    L10:
        if (this.QUEUE.size() > 0) goto L18;
        if (this.isWriteOver == true) goto L18;
        this.consumeSleepCount++;     // Catch: InterruptedException -> L15
        Thread.sleep(200);     // Catch: InterruptedException -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
    L18:
        return this.QUEUE.poll();
    }

    public void stopDiscardFrame() {
    L6:
        e = move-exception;
        e.getMessage();
        return;
    L3:
        if (this.isDiscasdingFrame == false) goto L11;
        int[] r100 = DecodeUtil.getDiscardEvent();     // Catch: Exception -> L6
        Arrays.toString(r100);     // Catch: Exception -> L6
        HashMap r101 = new HashMap();     // Catch: Exception -> L6
        r101.put("discarded_video_packet_count", String.valueOf(r100[0]));     // Catch: Exception -> L6
        r101.put("discarded_video_packet_size", String.valueOf(r100[1]));     // Catch: Exception -> L6
        r101.put("discarded_audio_packet_count", String.valueOf(r100[2]));     // Catch: Exception -> L6
        r101.put("discarded_audio_packet_size", String.valueOf(r100[3]));     // Catch: Exception -> L6
        r101.put("discard_duration", String.valueOf(System.currentTimeMillis() - this.startDiscardTime));     // Catch: Exception -> L6
        CastProxyMonitor.getInstance().notifyEvent(Event.BYTECASTSDK_INDICATOR_CASTPROXY_STOP_DISCARD_PKT, r101);     // Catch: Exception -> L6
        DecodeUtil.stopDiscardFrame();     // Catch: Exception -> L6
        this.isDiscasdingFrame = false;     // Catch: Exception -> L6
        return;
    }

    private Utils() {
        this.QUEUE = new LinkedBlockingQueue();
        this.consumeCount = 0;
        this.consumeSleepCount = 0;
        this.produceCount = 0;
        this.produceSleepCount = 0;
        this.needRecord = true;
        this.isDiscasdingFrame = false;
        this.recordRunnable = new AnonymousClass1(this);
        this.discardFrameRunnable = new AnonymousClass2(this);
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("Statistics");
        ThreadMethodProxy.start(r100);
        this.statisticsHandler = new Handler(r100.getLooper());
    }

    public static /* synthetic */ int access$000(Utils r100) {
        return r100.consumeCount;
    }

    public static /* synthetic */ int access$100(Utils r100) {
        return r100.consumeSleepCount;
    }

    public static /* synthetic */ int access$200(Utils r100) {
        return r100.produceCount;
    }

    public static /* synthetic */ int access$300(Utils r100) {
        return r100.produceSleepCount;
    }

    public static /* synthetic */ boolean access$600(Utils r100) {
        return r100.isDiscasdingFrame;
    }

    public static int conversionIpToInt(String r100) {
        int r101 = 0;
        if (r100 != null) goto L5;
        return 0;
    L5:
        String[] r102 = r100.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        int r103 = r102.length;
        int r104 = 0;
    L6:
        if (r101 >= r103) goto L8;
        r104 = (r104 << 8) ^ CastIntegerProtector.parseInt(r102[r101]);
        r101 = r101 + 1;
        goto L6
    L8:
        return r104;
    }

    public static String getConnectionIP(String r100) {
        List<String> r101 = getLocalIpAddr();
        String r102 = null;
        if (r101 != null) goto L5;
    L13:
        return r102;
    L5:
        if (r101.size() == 0) goto L13;
        int r103 = conversionIpToInt(r100);
        Iterator<String> r104 = r101.iterator();
        int r105 = Integer.MAX_VALUE;
    L9:
        if (r104.hasNext() == false) goto L13;
        String r106 = r104.next();
        int r107 = Math.abs(conversionIpToInt(r106) ^ r103);
        if (r107 >= r105) goto L9;
        r102 = r106;
        r105 = r107;
        goto L9
    }

    public static String getFilePath(String r100) {
        return UriProtector.parse(r100).getPath();
    }

    public void notifyJniEvent(String r100) {
        notifyEvent(r100, new HashMap());
    }

    public void produce(byte[] r100) {
        this.produceCount++;
    L4:
        if (this.QUEUE.size() >= queueLength) goto L16;
        this.QUEUE.offer(r100);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        e.getMessage();
        return;
    L16:
        this.produceSleepCount++;     // Catch: InterruptedException -> L7
        Thread.sleep(200);     // Catch: InterruptedException -> L7
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L4
    }

    public static /* synthetic */ int access$002(Utils r100, int r101) {
        r100.consumeCount = r101;
        return r101;
    }

    public static /* synthetic */ int access$102(Utils r100, int r101) {
        r100.consumeSleepCount = r101;
        return r101;
    }

    public static /* synthetic */ int access$202(Utils r100, int r101) {
        r100.produceCount = r101;
        return r101;
    }

    public static /* synthetic */ int access$302(Utils r100, int r101) {
        r100.produceSleepCount = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$502(Utils r100, boolean r101) {
        r100.needRecord = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$602(Utils r100, boolean r101) {
        r100.isDiscasdingFrame = r101;
        return r101;
    }

    public static /* synthetic */ long access$702(Utils r100, long r101) {
        r100.startDiscardTime = r101;
        return r101;
    }

    public static boolean hasPermissions(Context r100, String r101) {
        if (r100.getPackageManager().checkPermission(r101, r100.getPackageName()) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void notifyError(int r100, String r101) {
        CastProxyMonitor.getInstance().notifyError(r100, r101);
    }

    private void notifyEvent(String r100, Map<String, String> r101) {
        CastProxyMonitor.getInstance().notifyEvent(r100, r101);
    }

    public void notifyJniError(int r100, String r101) {
        CastProxyMonitor.getInstance().notifyError(r100 + ErrorCode.ERROR_CODE_JNI, ErrorCode.ERROR_MSG_JNI_ERROR + r101);
    }

    public static /* synthetic */ void access$400(Utils r100, String r101, Map r102) {
        r100.notifyEvent(r101, r102);
    }

    public static Response getPartialResponse(File r210, String r211, String r212) throws IOException {
        String r100 = r211.trim().substring(6);
        long r101 = r210.length();
        if (r100.startsWith("-") == false) goto L5;
        long r102 = r101 - 1;
        long r103 = r102 - CastLongProtector.parseLong(r100.substring(1));
    L10:
        long r110 = r101 - 1;
        if (r102 <= r110) goto L14;
        r102 = r110;
    L14:
        if (r103 > r102) goto L18;
        long r111 = (r102 - r103) + 1;
        PolarisFileInputStreamWrapper r112 = new PolarisFileInputStreamWrapper(r210);
        r112.skip(r103);
        Response r104 = new Response(Status.PARTIAL_CONTENT, r212, r112, r111);
        r104.f526205e.put("Content-Range", "bytes " + r103 + "-" + r102 + HTTP.URL_DEFAULT + r101);
        r104.f526205e.put("Content-Length", r111 + "");
        return r104;
    L18:
        return Response.h(Status.RANGE_NOT_SATISFIABLE, "text/html", r211);
    L5:
        String[] r105 = r100.split("-");
        long r106 = CastLongProtector.parseLong(r105[0]);
        if (r105.length <= 1) goto L8;
        long r107 = CastLongProtector.parseLong(r105[1]);
    L9:
        long r113 = r107;
        r103 = r106;
        r102 = r113;
        goto L10
    L8:
        r107 = r101 - 1;
        goto L9
    }
}
