package com.byted.cast.linkcommon.cybergarage.cast;

import android.os.Build;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.byted.cast.linkcommon.cybergarage.http.HTTPHeader;
import com.byted.cast.linkcommon.cybergarage.upnp.device.MAN;
import com.byted.cast.linkcommon.cybergarage.upnp.device.NTS;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Method;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class CastSSDPPacket {
    private static final String TAG = null;
    private static final boolean isAndroid6 = false;
    private static Method newStringFromBytesProxyByteCast;
    private DatagramPacket dgmPacket;
    private String localAddr;
    public byte[] packetBytes;
    private String remoteAddr;
    private int remotePort;
    private long timeStamp;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        TAG = "CastSSDPPacket";
        if (Build.VERSION.SDK_INT != 23) goto L5;
        boolean r100 = true;
    L6:
        isAndroid6 = r100;
        if (r100 == false) goto L13;
        Class r101 = INVOKESTATIC_com_byted_cast_linkcommon_cybergarage_cast_CastSSDPPacket_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("java.lang.StringFactory");     // Catch: Throwable -> L10
        Class<?> r102 = Integer.TYPE;     // Catch: Throwable -> L10
        Method r103 = r101.getDeclaredMethod("newStringFromBytes", new Class[]{byte[].class, r102, r102, Charset.class});     // Catch: Throwable -> L10
        newStringFromBytesProxyByteCast = r103;     // Catch: Throwable -> L10
        r103.setAccessible(true);     // Catch: Throwable -> L10
        return;
    L14:
        return;
    L13:
        return;
    L5:
        r100 = false;
        goto L6
    }

    public byte[] getData() {
        byte[] r100 = this.packetBytes;
        if (r100 == null) goto L5;
        return r100;
    L5:
        DatagramPacket r101 = getDatagramPacket();
        if (r101 == null) goto L8;
        int r102 = r101.getLength();
        byte[] r103 = newString(r101.getData(), 0, r102).getBytes();
        this.packetBytes = r103;
        return r103;
    L8:
        return this.packetBytes;
    }

    public String toString() {
        return new String(getData());
    }

    public String getDeviceId() {
        return HTTPHeader.getValue(getData(), HTTP.DEVICEID);
    }

    public String getHost() {
        return HTTPHeader.getValue(getData(), HTTP.HOST);
    }

    public InetAddress getHostInetAddress() {
        String r100 = getHost();
        int r101 = r100.lastIndexOf(":");
        if (r101 < 0) goto L10;
        String r102 = r100.substring(0, r101);
        if (r102.charAt(0) != '[') goto L8;
        r102 = r102.substring(1, r102.length());
    L8:
        if (r102.charAt(r102.length() - 1) != ']') goto L12;
        r102 = r102.substring(0, r102.length() - 1);
    L12:
        return new InetSocketAddress(r102, 0).getAddress();
    L10:
        r102 = "127.0.0.1";
        goto L12
    }

    public String getIp() {
        return HTTPHeader.getValue(getData(), HTTP.IP);
    }

    public String getMAN() {
        byte[] r100 = getData();
        if (r100 != null) goto L5;
        return "";
    L5:
        if (r100.length != 0) goto L8;
        return "";
    L8:
        return HTTPHeader.getValue(getData(), HTTP.MAN);
    }

    public String getMyName() {
        return HTTPHeader.getValue(getData(), HTTP.MYNAME);
    }

    public String getNTS() {
        return HTTPHeader.getValue(getData(), HTTP.NTS);
    }

    public String getPort() {
        return HTTPHeader.getValue(getData(), HTTP.PORT);
    }

    public String getProtocol() {
        return HTTPHeader.getValue(getData(), HTTP.PROTOCOL);
    }

    public String getProtocolVersion() {
        return HTTPHeader.getValue(getData(), HTTP.PROTOCOLVERSION);
    }

    public String getRemoteAddress() {
        if (getDatagramPacket().getAddress() == null) goto L5;
        this.remoteAddr = getDatagramPacket().getAddress().getHostAddress();
        return getDatagramPacket().getAddress().getHostAddress();
    L5:
        return this.remoteAddr;
    }

    public InetAddress getRemoteInetAddress() {
        return getDatagramPacket().getAddress();
    }

    public int getRemotePort() {
        if (getDatagramPacket().getPort() == 0) goto L5;
        int r100 = getDatagramPacket().getPort();
        this.remotePort = r100;
        return r100;
    L5:
        return this.remotePort;
    }

    public String getSearchTarget() {
        return HTTPHeader.getValue(getData(), HTTP.SEARCHTARGET);
    }

    public String getServer() {
        return HTTPHeader.getValue(getData(), HTTP.SERVER);
    }

    public String getService() {
        return HTTPHeader.getValue(getData(), HTTP.SERVICE);
    }

    public String getSinkVersion() {
        return HTTPHeader.getValue(getData(), HTTP.SINKVERSION);
    }

    public String getSourceVersion() {
        return HTTPHeader.getValue(getData(), HTTP.SOURCEVERSION);
    }

    public boolean isAlive() {
        return NTS.isAlive(getNTS());
    }

    public boolean isByeBye() {
        return NTS.isByeBye(getNTS());
    }

    public boolean isDiscover() {
        return MAN.isDiscover(getMAN());
    }

    public DatagramPacket getDatagramPacket() {
        return this.dgmPacket;
    }

    public String getLocalAddress() {
        return this.localAddr;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_byted_cast_linkcommon_cybergarage_cast_CastSSDPPacket_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public void setLocalAddress(String r100) {
        this.localAddr = r100;
    }

    public void setRemotePort(int r100) {
        this.remotePort = r100;
    }

    public void setTimeStamp(long r100) {
        this.timeStamp = r100;
    }

    public CastSSDPPacket(byte[] r100, int r101) {
        this.dgmPacket = null;
        this.localAddr = "";
        this.remoteAddr = "";
        this.remotePort = 0;
        this.packetBytes = null;
        this.dgmPacket = new DatagramPacket(r100, r101);
    }

    public static String newString(byte[] r100, int r101, int r102) {
        if (isAndroid6 == false) goto L7;
        return newString(r100, r101, r102, Charset.defaultCharset());
    L7:
        return new String(r100, r101, r102);
    }

    public static String newString(byte[] r100, int r101, int r102, Charset r103) {
        if (isAndroid6 == false) goto L10;
        Method r104 = newStringFromBytesProxyByteCast;
        if (r104 == null) goto L10;
        return (String) r104.invoke(null, new Object[]{r100, Integer.valueOf(r101), Integer.valueOf(r102), r103});
    L10:
        return new String(r100, r101, r102, r103);
    }
}
