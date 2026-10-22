package io.ktor.server.engine;

import Z8.C1172u;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.server.application.ApplicationEnvironment;
import io.ktor.server.engine.ApplicationEngine;
import io.ktor.util.CharsetKt;
import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import kotlin.Metadata;
import kotlin.Pair;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u001aI\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\t\u0010\n\u001a!\u0010\u000e\u001a\u00020\b*\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\fH\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a!\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00110\u0010H\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0014\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001f\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0017\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lio/ktor/server/engine/ApplicationEngine$Configuration;", "", "host", "sslPort", "sslKeyStorePath", "sslKeyStorePassword", "sslPrivateKeyPassword", "sslKeyAlias", "LY8/t;", "configureSSLConnectors", "(Lio/ktor/server/engine/ApplicationEngine$Configuration;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lio/ktor/server/engine/ApplicationEnvironmentBuilder;", "", "args", "configurePlatformProperties", "(Lio/ktor/server/engine/ApplicationEnvironmentBuilder;[Ljava/lang/String;)V", "", "Lkotlin/Pair;", "getKtorEnvironmentProperties", "()Ljava/util/List;", "key", "getEnvironmentProperty", "(Ljava/lang/String;)Ljava/lang/String;", UxipConstants.f30680s, "setEnvironmentProperty", "(Ljava/lang/String;Ljava/lang/String;)V", "clearEnvironmentProperty", "(Ljava/lang/String;)V", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EnvironmentUtilsJvmKt {
    public static final void clearEnvironmentProperty(String key) {
        kotlin.jvm.internal.p.i(key, "key");
        System.clearProperty(key);
    }

    public static final void configurePlatformProperties(ApplicationEnvironmentBuilder applicationEnvironmentBuilder, String[] args) {
        ClassLoader classLoader;
        kotlin.jvm.internal.p.i(applicationEnvironmentBuilder, "<this>");
        kotlin.jvm.internal.p.i(args, "args");
        ArrayList arrayList = new ArrayList();
        for (String str : args) {
            Pair<String, String> pairSplitPair = CommandLineKt.splitPair(str, '=');
            if (pairSplitPair != null) {
                arrayList.add(pairSplitPair);
            }
        }
        String str2 = (String) kotlin.collections.a.y(arrayList).get("-jar");
        URL url = str2 != null ? (La.D.X(str2, "file:", false, 2, null) || La.D.X(str2, "jrt:", false, 2, null) || La.D.X(str2, "jar:", false, 2, null)) ? new URI(str2).toURL() : new File(str2).toURI().toURL() : null;
        if (url != null) {
            classLoader = new URLClassLoader(new URL[]{url}, ApplicationEnvironment.class.getClassLoader());
        } else {
            classLoader = ApplicationEnvironment.class.getClassLoader();
            kotlin.jvm.internal.p.h(classLoader, "getClassLoader(...)");
        }
        applicationEnvironmentBuilder.setClassLoader(classLoader);
    }

    public static final void configureSSLConnectors(ApplicationEngine.Configuration configuration, String host, String sslPort, String str, final String str2, final String str3, String sslKeyAlias) {
        kotlin.jvm.internal.p.i(configuration, "<this>");
        kotlin.jvm.internal.p.i(host, "host");
        kotlin.jvm.internal.p.i(sslPort, "sslPort");
        kotlin.jvm.internal.p.i(sslKeyAlias, "sslKeyAlias");
        if (str == null) {
            throw new IllegalArgumentException("SSL requires keystore: use -sslKeyStore=path or ktor.security.ssl.keyStore config");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("SSL requires keystore password: use ktor.security.ssl.keyStorePassword config");
        }
        if (str3 == null) {
            throw new IllegalArgumentException("SSL requires certificate password: use ktor.security.ssl.privateKeyPassword config");
        }
        File file = new File(str);
        if (!file.exists() && !file.isAbsolute()) {
            file = new File(".", str).getAbsoluteFile();
        }
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            keyStore.load(fileInputStream, CharsetKt.toCharArray(str2));
            Y8.t tVar = Y8.t.f7040a;
            l9.b.a(fileInputStream, null);
            if (keyStore.getKey(sslKeyAlias, CharsetKt.toCharArray(str3)) == null) {
                throw new IllegalArgumentException(("The specified key " + sslKeyAlias + " doesn't exist in the key store " + str).toString());
            }
            kotlin.jvm.internal.p.f(keyStore);
            InterfaceC5063a interfaceC5063a = new InterfaceC5063a() { // from class: io.ktor.server.engine.A
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return CharsetKt.toCharArray(str2);
                }
            };
            InterfaceC5063a interfaceC5063a2 = new InterfaceC5063a() { // from class: io.ktor.server.engine.B
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return CharsetKt.toCharArray(str3);
                }
            };
            List<EngineConnectorConfig> connectors = configuration.getConnectors();
            EngineSSLConnectorBuilder engineSSLConnectorBuilder = new EngineSSLConnectorBuilder(keyStore, sslKeyAlias, interfaceC5063a, interfaceC5063a2);
            engineSSLConnectorBuilder.setHost(host);
            engineSSLConnectorBuilder.setPort(Integer.parseInt(sslPort));
            engineSSLConnectorBuilder.setKeyStorePath(file);
            connectors.add(engineSSLConnectorBuilder);
        } finally {
        }
    }

    public static final String getEnvironmentProperty(String key) {
        kotlin.jvm.internal.p.i(key, "key");
        return System.getProperty(key);
    }

    public static final List<Pair<String, String>> getKtorEnvironmentProperties() {
        List listC = C1172u.c();
        Properties properties = System.getProperties();
        kotlin.jvm.internal.p.h(properties, "getProperties(...)");
        for (Map.Entry entry : properties.entrySet()) {
            Object key = entry.getKey();
            String str = key instanceof String ? (String) key : null;
            if (str != null && La.D.X(str, "ktor.", false, 2, null)) {
                Object value = entry.getValue();
                String str2 = value instanceof String ? (String) value : null;
                if (str2 != null) {
                    listC.add(Y8.j.a(str, str2));
                }
            }
        }
        return C1172u.a(listC);
    }

    public static final void setEnvironmentProperty(String key, String value) {
        kotlin.jvm.internal.p.i(key, "key");
        kotlin.jvm.internal.p.i(value, "value");
        System.setProperty(key, value);
    }
}
