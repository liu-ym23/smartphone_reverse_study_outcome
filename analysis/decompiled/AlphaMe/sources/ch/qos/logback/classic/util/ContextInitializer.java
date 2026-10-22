package ch.qos.logback.classic.util;

import B0.g;
import ch.qos.logback.classic.BasicConfigurator;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.gaffer.GafferUtil;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.LogbackException;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.status.ErrorStatus;
import ch.qos.logback.core.status.InfoStatus;
import ch.qos.logback.core.status.StatusManager;
import ch.qos.logback.core.status.WarnStatus;
import ch.qos.logback.core.util.Loader;
import java.io.IOException;
import java.net.URL;
import java.util.Set;

/* loaded from: classes.dex */
public class ContextInitializer {
    public static final String AUTOCONFIG_FILE = "logback.xml";
    public static final String CONFIG_FILE_PROPERTY = "logback.configurationFile";
    public static final String GROOVY_AUTOCONFIG_FILE = "logback.groovy";
    public static final String STATUS_LISTENER_CLASS = "logback.statusListenerClass";
    public static final String SYSOUT = "SYSOUT";
    public static final String TEST_AUTOCONFIG_FILE = "logback-test.xml";
    final LoggerContext loggerContext;

    public ContextInitializer(LoggerContext loggerContext) {
        this.loggerContext = loggerContext;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.net.URL findConfigFileURLFromSystemProperties(java.lang.ClassLoader r7, boolean r8) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.String r0 = "logback.configurationFile"
            java.lang.String r0 = ch.qos.logback.core.util.OptionHelper.getSystemProperty(r0)
            r1 = 0
            if (r0 == 0) goto L52
            java.net.URL r2 = new java.net.URL     // Catch: java.lang.Throwable -> L14 java.net.MalformedURLException -> L16
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L14 java.net.MalformedURLException -> L16
            if (r8 == 0) goto L13
            r6.statusOnResourceSearch(r0, r7, r2)
        L13:
            return r2
        L14:
            r2 = move-exception
            goto L4c
        L16:
            java.net.URL r2 = ch.qos.logback.core.util.Loader.getResource(r0, r7)     // Catch: java.lang.Throwable -> L14
            if (r2 == 0) goto L22
            if (r8 == 0) goto L21
            r6.statusOnResourceSearch(r0, r7, r2)
        L21:
            return r2
        L22:
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L41
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L41
            boolean r4 = r3.exists()     // Catch: java.lang.Throwable -> L41
            if (r4 == 0) goto L46
            boolean r4 = r3.isFile()     // Catch: java.lang.Throwable -> L41
            if (r4 == 0) goto L46
            java.net.URI r3 = r3.toURI()     // Catch: java.lang.Throwable -> L41 java.net.MalformedURLException -> L46
            java.net.URL r1 = r3.toURL()     // Catch: java.lang.Throwable -> L41 java.net.MalformedURLException -> L46
            if (r8 == 0) goto L40
            r6.statusOnResourceSearch(r0, r7, r1)
        L40:
            return r1
        L41:
            r1 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
            goto L4c
        L46:
            if (r8 == 0) goto L52
            r6.statusOnResourceSearch(r0, r7, r2)
            goto L52
        L4c:
            if (r8 == 0) goto L51
            r6.statusOnResourceSearch(r0, r7, r1)
        L51:
            throw r2
        L52:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ch.qos.logback.classic.util.ContextInitializer.findConfigFileURLFromSystemProperties(java.lang.ClassLoader, boolean):java.net.URL");
    }

    private URL getResource(String str, ClassLoader classLoader, boolean z4) {
        URL resource = Loader.getResource(str, classLoader);
        if (z4) {
            statusOnResourceSearch(str, classLoader, resource);
        }
        return resource;
    }

    private void multiplicityWarning(String str, ClassLoader classLoader) {
        Set<URL> resourceOccurrenceCount;
        StatusManager statusManager = this.loggerContext.getStatusManager();
        try {
            resourceOccurrenceCount = Loader.getResourceOccurrenceCount(str, classLoader);
        } catch (IOException e4) {
            statusManager.add(new ErrorStatus(g.n("Failed to get url list for resource [", str, "]"), this.loggerContext, e4));
            resourceOccurrenceCount = null;
        }
        if (resourceOccurrenceCount == null || resourceOccurrenceCount.size() <= 1) {
            return;
        }
        statusManager.add(new WarnStatus(g.n("Resource [", str, "] occurs multiple times on the classpath."), this.loggerContext));
        for (URL url : resourceOccurrenceCount) {
            StringBuilder sbW = g.w("Resource [", str, "] occurs at [");
            sbW.append(url.toString());
            sbW.append("]");
            statusManager.add(new WarnStatus(sbW.toString(), this.loggerContext));
        }
    }

    private void statusOnResourceSearch(String str, ClassLoader classLoader, URL url) {
        StatusManager statusManager = this.loggerContext.getStatusManager();
        if (url == null) {
            statusManager.add(new InfoStatus(g.n("Could NOT find resource [", str, "]"), this.loggerContext));
            return;
        }
        StringBuilder sbW = g.w("Found resource [", str, "] at [");
        sbW.append(url.toString());
        sbW.append("]");
        statusManager.add(new InfoStatus(sbW.toString(), this.loggerContext));
        multiplicityWarning(str, classLoader);
    }

    public void autoConfig() throws JoranException {
        StatusListenerConfigHelper.installIfAsked(this.loggerContext);
        URL urlFindURLOfDefaultConfigurationFile = findURLOfDefaultConfigurationFile(true);
        if (urlFindURLOfDefaultConfigurationFile != null) {
            configureByResource(urlFindURLOfDefaultConfigurationFile);
        } else {
            BasicConfigurator.configure(this.loggerContext);
        }
    }

    public void configureByResource(URL url) throws JoranException, IOException {
        if (url == null) {
            throw new IllegalArgumentException("URL argument cannot be null");
        }
        if (url.toString().endsWith("groovy")) {
            if (EnvUtil.isGroovyAvailable()) {
                GafferUtil.runGafferConfiguratorOn(this.loggerContext, this, url);
                return;
            } else {
                this.loggerContext.getStatusManager().add(new ErrorStatus("Groovy classes are not available on the class path. ABORTING INITIALIZATION.", this.loggerContext));
                return;
            }
        }
        if (url.toString().endsWith("xml")) {
            JoranConfigurator joranConfigurator = new JoranConfigurator();
            joranConfigurator.setContext(this.loggerContext);
            joranConfigurator.doConfigure(url);
        } else {
            throw new LogbackException("Unexpected filename extension of file [" + url.toString() + "]. Should be either .groovy or .xml");
        }
    }

    public URL findURLOfDefaultConfigurationFile(boolean z4) throws Throwable {
        ClassLoader classLoaderOfObject = Loader.getClassLoaderOfObject(this);
        URL urlFindConfigFileURLFromSystemProperties = findConfigFileURLFromSystemProperties(classLoaderOfObject, z4);
        if (urlFindConfigFileURLFromSystemProperties != null) {
            return urlFindConfigFileURLFromSystemProperties;
        }
        URL resource = getResource(GROOVY_AUTOCONFIG_FILE, classLoaderOfObject, z4);
        if (resource != null) {
            return resource;
        }
        URL resource2 = getResource(TEST_AUTOCONFIG_FILE, classLoaderOfObject, z4);
        return resource2 != null ? resource2 : getResource(AUTOCONFIG_FILE, classLoaderOfObject, z4);
    }

    public void joranConfigureByResource(URL url) throws JoranException, IOException {
        JoranConfigurator joranConfigurator = new JoranConfigurator();
        joranConfigurator.setContext(this.loggerContext);
        joranConfigurator.doConfigure(url);
    }
}
