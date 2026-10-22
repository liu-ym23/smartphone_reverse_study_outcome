package ch.qos.logback.classic.jmx;

import ch.qos.logback.core.joran.spi.JoranException;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;

/* loaded from: classes.dex */
public interface JMXConfiguratorMBean {
    String getLoggerEffectiveLevel(String str);

    String getLoggerLevel(String str);

    List<String> getLoggerList();

    List<String> getStatuses();

    void reloadByFileName(String str) throws JoranException, FileNotFoundException;

    void reloadByURL(URL url) throws JoranException;

    void reloadDefaultConfiguration() throws JoranException;

    void setLoggerLevel(String str, String str2);
}
