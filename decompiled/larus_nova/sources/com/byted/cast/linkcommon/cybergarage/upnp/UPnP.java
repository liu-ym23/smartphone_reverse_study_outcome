package com.byted.cast.linkcommon.cybergarage.upnp;

import com.byted.cast.common.ContextManager;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.byted.cast.linkcommon.cybergarage.net.HostInterface;
import com.byted.cast.linkcommon.cybergarage.soap.SOAP;
import com.byted.cast.linkcommon.cybergarage.upnp.ssdp.SSDP;
import com.byted.cast.linkcommon.cybergarage.xml.Parser;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class UPnP {
    public static final int CONFIGID_UPNP_ORG_MAX = 16777215;
    public static final int DEFAULT_EXPIRED_DEVICE_EXTRA_TIME = 60;
    public static final int DEFAULT_TTL = 4;
    public static final String INMPR03 = "INMPR03";
    public static final int INMPR03_DISCOVERY_OVER_WIRELESS_COUNT = 4;
    public static final String INMPR03_VERSION = "1.0";
    public static final String NAME = "CyberLinkJava";
    private static final String TAG = "UPnP";
    public static final int USE_IPV6_ADMINISTRATIVE_SCOPE = 5;
    public static final int USE_IPV6_GLOBAL_SCOPE = 7;
    public static final int USE_IPV6_LINK_LOCAL_SCOPE = 3;
    public static final int USE_IPV6_SITE_LOCAL_SCOPE = 6;
    public static final int USE_IPV6_SUBNET_SCOPE = 4;
    public static final int USE_LOOPBACK_ADDR = 2;
    public static final int USE_ONLY_IPV4_ADDR = 9;
    public static final int USE_ONLY_IPV6_ADDR = 1;
    public static final int USE_SSDP_SEARCHRESPONSE_MULTIPLE_INTERFACES = 8;
    public static final String VERSION = "3.0";
    public static final String XML_CLASS_PROPERTTY = "cyberlink.upnp.xml.parser";
    public static final String XML_DECLARATION = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
    private static int timeToLive = 4;
    private static Parser xmlParser;

    static {
        setTimeToLive(4);
    }

    public UPnP() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static final void initialize() {
    }

    public static final String getServerName() {
        return System.getProperty("os.name") + HTTP.URL_DEFAULT + System.getProperty("os.version") + " UPnP/1.0 CyberLinkJava/3.0";
    }

    public static final int createBootId() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    public static final String createUUID() {
        long r100 = System.currentTimeMillis();
        long r101 = (long) (System.currentTimeMillis() * Math.random());
        return toUUID((int) (r100 & 65535)) + "-" + toUUID(((int) ((r100 >> 32) | 40960)) & 65535) + "-" + toUUID((int) (65535 & r101)) + "-" + toUUID(65535 & ((int) ((r101 >> 32) | 57344)));
    }

    public static final int getTimeToLive() {
        return timeToLive;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_byted_cast_linkcommon_cybergarage_upnp_UPnP_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static final int caluculateConfigId(String r100) {
        int r101 = 0;
        if (r100 != null) goto L5;
        return 0;
    L5:
        int r102 = r100.length();
        int r103 = 0;
    L6:
        if (r101 >= r102) goto L12;
        r103 = r103 + r100.codePointAt(r101);
        if (r103 < 16777215) goto L11;
        r103 = r103 % 16777215;
    L11:
        r101 = r101 + 1;
        goto L6
    L12:
        return r103;
    }

    public static final Parser getXMLParser(ContextManager.CastContext r100) {
        if (xmlParser != null) goto L10;
        Parser r101 = loadDefaultXMLParser(r100);
        xmlParser = r101;
        if (r101 == null) goto L8;
        SOAP.setXMLParser(r101);
        goto L10
    L8:
        throw new RuntimeException("No XML parser defined. And unable to laod any. \nTry to invoke UPnP.setXMLParser before UPnP.getXMLParser");
    L10:
        return xmlParser;
    }

    public static final boolean isEnabled(int r100) {
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L13;
        if (r100 == 9) goto L11;
        return false;
    L11:
        return HostInterface.USE_ONLY_IPV4_ADDR;
    L13:
        return HostInterface.USE_LOOPBACK_ADDR;
    L15:
        return HostInterface.USE_ONLY_IPV6_ADDR;
    }

    private static Parser loadDefaultXMLParser(ContextManager.CastContext r100) {
        String[] r101 = {System.getProperty(XML_CLASS_PROPERTTY), "com.byted.cast.linkcommon.cybergarage.xml.parser.XmlPullParser", "com.byted.cast.linkcommon.cybergarage.xml.parser.JaxpParser", "com.byted.cast.linkcommon.cybergarage.xml.parser.kXML2Parser", "com.byted.cast.linkcommon.cybergarage.xml.parser.XercesParser"};
        int r102 = 0;
    L3:
        if (r102 >= 5) goto L12;
        String r103 = r101[r102];
        if (r103 == null) goto L11;
        return (Parser) INVOKESTATIC_com_byted_cast_linkcommon_cybergarage_upnp_UPnP_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r103).getDeclaredConstructor(new Class[]{ContextManager.CastContext.class}).newInstance(new Object[]{r100});
    L9:
        th = move-exception;
        th.printStackTrace();
    L11:
        r102 = r102 + 1;
        goto L3
    L12:
        return null;
    }

    public static final void setDisable(int r100) {
        if (r100 != 1) goto L5;
        HostInterface.USE_ONLY_IPV6_ADDR = false;
        return;
    L5:
        if (r100 != 2) goto L7;
        HostInterface.USE_LOOPBACK_ADDR = false;
        return;
    L7:
        if (r100 != 9) goto L15;
        HostInterface.USE_ONLY_IPV4_ADDR = false;
        return;
    }

    public static final void setEnable(int r100) {
        switch(r100) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L21;
            case 9: goto L5;
            default: goto L21;
        };
    L5:
        HostInterface.USE_ONLY_IPV4_ADDR = true;
        return;
    L6:
        SSDP.setIPv6Address(SSDP.IPV6_GLOBAL_ADDRESS);
        return;
    L7:
        SSDP.setIPv6Address(SSDP.IPV6_SITE_LOCAL_ADDRESS);
        return;
    L8:
        SSDP.setIPv6Address(SSDP.IPV6_ADMINISTRATIVE_ADDRESS);
        return;
    L9:
        SSDP.setIPv6Address(SSDP.IPV6_SUBNET_ADDRESS);
        return;
    L10:
        SSDP.setIPv6Address(SSDP.IPV6_LINK_LOCAL_ADDRESS);
        return;
    L11:
        HostInterface.USE_LOOPBACK_ADDR = true;
        return;
    L12:
        HostInterface.USE_ONLY_IPV6_ADDR = true;
        return;
    }

    public static final void setTimeToLive(int r100) {
        timeToLive = r100;
    }

    public static final void setXMLParser(Parser r100) {
        xmlParser = r100;
        SOAP.setXMLParser(r100);
    }

    private static final String toUUID(int r100) {
        String r101 = Integer.toString(r100 & 65535, 16);
        String r102 = "";
        int r103 = 0;
    L4:
        if (r103 >= (4 - r101.length())) goto L7;
        r102 = r102 + "0";
        r103 = r103 + 1;
        goto L4
    L7:
        return r102 + r101;
    }
}
