package ch.qos.logback.core.util;

import ch.qos.logback.core.Context;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.spi.ContextAwareBase;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

/* loaded from: classes.dex */
public class ContextUtil extends ContextAwareBase {
    public ContextUtil(Context context) {
        setContext(context);
    }

    private static boolean acceptableAddress(InetAddress inetAddress) {
        return (inetAddress == null || inetAddress.isLoopbackAddress() || inetAddress.isAnyLocalAddress() || inetAddress.isLinkLocalAddress()) ? false : true;
    }

    private static String getLocalAddressAsString() throws SocketException, UnknownHostException {
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces != null && networkInterfaces.hasMoreElements()) {
            Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
            while (inetAddresses != null && inetAddresses.hasMoreElements()) {
                InetAddress inetAddressNextElement = inetAddresses.nextElement();
                if (acceptableAddress(inetAddressNextElement)) {
                    return inetAddressNextElement.getHostAddress();
                }
            }
        }
        throw new UnknownHostException();
    }

    public static String getLocalHostName() throws SocketException, UnknownHostException {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException unused) {
            return getLocalAddressAsString();
        }
    }

    public void addFrameworkPackage(List<String> list, String str) {
        if (list.contains(str)) {
            return;
        }
        list.add(str);
    }

    public void addGroovyPackages(List<String> list) {
        addFrameworkPackage(list, "org.codehaus.groovy.runtime");
    }

    public void addHostNameAsProperty() {
        try {
            this.context.putProperty(CoreConstants.HOSTNAME_KEY, getLocalHostName());
        } catch (SecurityException e4) {
            addError("Failed to get local hostname", e4);
        } catch (SocketException e5) {
            addError("Failed to get local hostname", e5);
        } catch (UnknownHostException e6) {
            addError("Failed to get local hostname", e6);
        }
    }

    public void addProperties(Properties properties) {
        if (properties == null) {
            return;
        }
        for (String str : properties.keySet()) {
            this.context.putProperty(str, properties.getProperty(str));
        }
    }
}
