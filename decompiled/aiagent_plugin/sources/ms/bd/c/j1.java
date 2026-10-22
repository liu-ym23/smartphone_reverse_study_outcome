package ms.bd.c;

import android.app.Activity;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes4.dex */
public final class j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f39526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f39527b;

    public static String a() {
    L32:
        e = move-exception;
        e.toString();
        return "";
    L4:
        if (f39526a == true) goto L29;
        if (((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.a(), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin")) == null) goto L9;
        byte r3 = 1;
    L11:
        if (r3 != 1) goto L29;
        f39526a = true;     // Catch: SocketException -> L32
        Enumeration<NetworkInterface> r2 = NetworkInterface.getNetworkInterfaces();     // Catch: SocketException -> L32
    L14:
        if (r2.hasMoreElements() == false) goto L29;
        NetworkInterface r4 = (NetworkInterface) ZeusTransformUtils.preCheckCast(r2.nextElement(), NetworkInterface.class, "com.obric.aiagent.plugin");     // Catch: SocketException -> L32
        Enumeration<InetAddress> r5 = r4.getInetAddresses();     // Catch: SocketException -> L32
    L17:
        if (r5.hasMoreElements() == false) goto L14;
        InetAddress r6 = (InetAddress) ZeusTransformUtils.preCheckCast(r5.nextElement(), InetAddress.class, "com.obric.aiagent.plugin");     // Catch: SocketException -> L32
        String r7 = r4.getName();     // Catch: SocketException -> L32
        if (TextUtils.isEmpty(r7) == true) goto L17;
        if (r6.isLoopbackAddress() == true) goto L17;
        if (ZeusTransformUtils.instanceOf(r6, Inet4Address.class) == false) goto L17;
        if (r7.startsWith("rmnet") == false) goto L17;
        f39527b = r4.getName();     // Catch: SocketException -> L32
        return r4.getName();
    L9:
        r3 = 0;
    L10:
        r3 = -1;
    L29:
        if (TextUtils.isEmpty(f39527b) == false) goto L31;
        return "";
    L31:
        return f39527b;
    }
}
