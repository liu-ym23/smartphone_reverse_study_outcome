package io.ktor.server.engine;

import La.H;
import La.K;
import Z8.C1174w;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.server.application.ApplicationKt;
import io.ktor.server.application.ServerConfig;
import io.ktor.server.application.ServerConfigBuilder;
import io.ktor.server.config.ApplicationConfig;
import io.ktor.server.config.ApplicationConfigKt;
import io.ktor.server.config.ApplicationConfigValue;
import io.ktor.server.config.ConfigLoader;
import io.ktor.server.config.MapApplicationConfig;
import io.ktor.server.config.MergedApplicationConfigKt;
import io.ktor.server.engine.ApplicationEngine;
import io.ktor.server.engine.BaseApplicationEngine;
import io.ktor.util.PlatformUtils;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00008\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0004\u001a\u001b\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a)\u0010\t\u001a\u00020\b2\u0018\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00070\u0006H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0019\u0010\u000e\u001a\u00020\r*\u00020\u000b2\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000f\u001a)\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"", "", "args", "Lio/ktor/server/engine/CommandLineConfig;", "CommandLineConfig", "([Ljava/lang/String;)Lio/ktor/server/engine/CommandLineConfig;", "", "Lkotlin/Pair;", "Lio/ktor/server/config/ApplicationConfig;", "buildApplicationConfig", "(Ljava/util/List;)Lio/ktor/server/config/ApplicationConfig;", "Lio/ktor/server/engine/ApplicationEngine$Configuration;", "deploymentConfig", "LY8/t;", "loadCommonConfiguration", "(Lio/ktor/server/engine/ApplicationEngine$Configuration;Lio/ktor/server/config/ApplicationConfig;)V", "", "ch", "splitPair", "(Ljava/lang/String;C)Lkotlin/Pair;", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CommandLineKt {
    public static final CommandLineConfig CommandLineConfig(final String[] args) {
        kotlin.jvm.internal.p.i(args, "args");
        ArrayList arrayList = new ArrayList();
        for (String str : args) {
            Pair<String, String> pairSplitPair = splitPair(str, '=');
            if (pairSplitPair != null) {
                arrayList.add(pairSplitPair);
            }
        }
        final Map mapY = kotlin.collections.a.y(arrayList);
        final ApplicationConfig applicationConfigBuildApplicationConfig = buildApplicationConfig(arrayList);
        String strTryGetString = ApplicationConfigKt.tryGetString(applicationConfigBuildApplicationConfig, ConfigKeys.applicationIdPath);
        if (strTryGetString == null) {
            strTryGetString = "Application";
        }
        final vc.c cVarKtorSimpleLogger = KtorSimpleLoggerJvmKt.KtorSimpleLogger(strTryGetString);
        ServerConfig serverConfig = ApplicationKt.serverConfig(ApplicationEnvironmentBuilderKt.applicationEnvironment(new InterfaceC5074l() { // from class: io.ktor.server.engine.g
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return CommandLineKt.CommandLineConfig$lambda$1(cVarKtorSimpleLogger, args, applicationConfigBuildApplicationConfig, (ApplicationEnvironmentBuilder) obj);
            }
        }), new InterfaceC5074l() { // from class: io.ktor.server.engine.h
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return CommandLineKt.CommandLineConfig$lambda$4(mapY, applicationConfigBuildApplicationConfig, (ServerConfigBuilder) obj);
            }
        });
        String strTryGetString2 = (String) mapY.get("-host");
        if (strTryGetString2 == null && (strTryGetString2 = ApplicationConfigKt.tryGetString(applicationConfigBuildApplicationConfig, ConfigKeys.hostConfigPath)) == null) {
            strTryGetString2 = "0.0.0.0";
        }
        String str2 = strTryGetString2;
        String strTryGetString3 = (String) mapY.get("-port");
        if (strTryGetString3 == null) {
            strTryGetString3 = ApplicationConfigKt.tryGetString(applicationConfigBuildApplicationConfig, ConfigKeys.hostPortPath);
        }
        String strTryGetString4 = (String) mapY.get("-sslPort");
        if (strTryGetString4 == null) {
            strTryGetString4 = ApplicationConfigKt.tryGetString(applicationConfigBuildApplicationConfig, ConfigKeys.hostSslPortPath);
        }
        String str3 = strTryGetString4;
        String strTryGetString5 = (String) mapY.get("-sslKeyStore");
        if (strTryGetString5 == null) {
            strTryGetString5 = ApplicationConfigKt.tryGetString(applicationConfigBuildApplicationConfig, ConfigKeys.hostSslKeyStore);
        }
        String str4 = strTryGetString5;
        String strTryGetString6 = ApplicationConfigKt.tryGetString(applicationConfigBuildApplicationConfig, ConfigKeys.hostSslKeyStorePassword);
        String string = strTryGetString6 != null ? H.D1(strTryGetString6).toString() : null;
        String strTryGetString7 = ApplicationConfigKt.tryGetString(applicationConfigBuildApplicationConfig, ConfigKeys.hostSslPrivateKeyPassword);
        String string2 = strTryGetString7 != null ? H.D1(strTryGetString7).toString() : null;
        String strTryGetString8 = ApplicationConfigKt.tryGetString(applicationConfigBuildApplicationConfig, ConfigKeys.hostSslKeyAlias);
        if (strTryGetString8 == null) {
            strTryGetString8 = "mykey";
        }
        String str5 = strTryGetString8;
        if (strTryGetString3 == null && str3 == null) {
            throw new IllegalArgumentException("Neither port nor sslPort specified. Use command line options -port/-sslPort or configure connectors in application.conf");
        }
        BaseApplicationEngine.Configuration configuration = new BaseApplicationEngine.Configuration();
        if (strTryGetString3 != null) {
            List<EngineConnectorConfig> connectors = configuration.getConnectors();
            EngineConnectorBuilder engineConnectorBuilder = new EngineConnectorBuilder(null, 1, null);
            engineConnectorBuilder.setHost(str2);
            engineConnectorBuilder.setPort(Integer.parseInt(strTryGetString3));
            connectors.add(engineConnectorBuilder);
        }
        if (str3 != null) {
            EnvironmentUtilsJvmKt.configureSSLConnectors(configuration, str2, str3, str4, string, string2, str5);
        }
        return new CommandLineConfig(serverConfig, configuration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t CommandLineConfig$lambda$1(vc.c cVar, String[] strArr, ApplicationConfig applicationConfig, ApplicationEnvironmentBuilder applicationEnvironment) {
        kotlin.jvm.internal.p.i(applicationEnvironment, "$this$applicationEnvironment");
        applicationEnvironment.setLog(cVar);
        EnvironmentUtilsJvmKt.configurePlatformProperties(applicationEnvironment, strArr);
        applicationEnvironment.setConfig(applicationConfig);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t CommandLineConfig$lambda$4(Map map, ApplicationConfig applicationConfig, ServerConfigBuilder serverConfig) {
        List<String> listTryGetStringList;
        kotlin.jvm.internal.p.i(serverConfig, "$this$serverConfig");
        String strTryGetString = (String) map.get("-path");
        if (strTryGetString == null && (strTryGetString = ApplicationConfigKt.tryGetString(applicationConfig, ConfigKeys.rootPathPath)) == null) {
            strTryGetString = "";
        }
        serverConfig.setRootPath(strTryGetString);
        String strTryGetString2 = ApplicationConfigKt.tryGetString(applicationConfig, ConfigKeys.developmentModeKey);
        serverConfig.setDevelopmentMode(strTryGetString2 != null ? Boolean.parseBoolean(strTryGetString2) : PlatformUtils.INSTANCE.getIS_DEVELOPMENT_MODE());
        String str = (String) map.get("-watch");
        if (str == null || (listTryGetStringList = H.b1(str, new String[]{Const.STR_MART_COMMA}, false, 0, 6, null)) == null) {
            listTryGetStringList = ApplicationConfigKt.tryGetStringList(applicationConfig, ConfigKeys.hostWatchPaths);
        }
        if (listTryGetStringList != null) {
            serverConfig.setWatchPaths(listTryGetStringList);
        }
        return Y8.t.f7040a;
    }

    public static final ApplicationConfig buildApplicationConfig(List<Pair<String, String>> args) {
        ApplicationConfig applicationConfigLoad$default;
        kotlin.jvm.internal.p.i(args, "args");
        List<Pair<String, String>> list = args;
        ArrayList<Pair> arrayList = new ArrayList();
        for (Object obj : list) {
            if (La.D.X((String) ((Pair) obj).e(), "-P:", false, 2, null)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
        for (Pair pair : arrayList) {
            arrayList2.add(Y8.j.a(H.R0((String) pair.e(), "-P:"), pair.f()));
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : list) {
            if (kotlin.jvm.internal.p.d(((Pair) obj2).e(), "-config")) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = new ArrayList(C1174w.x(arrayList3, 10));
        Iterator it = arrayList3.iterator();
        while (it.hasNext()) {
            arrayList4.add((String) ((Pair) it.next()).f());
        }
        MapApplicationConfig mapApplicationConfig = new MapApplicationConfig(arrayList2);
        MapApplicationConfig mapApplicationConfig2 = new MapApplicationConfig(EnvironmentUtilsJvmKt.getKtorEnvironmentProperties());
        int size = arrayList4.size();
        if (size == 0) {
            applicationConfigLoad$default = ConfigLoader.Companion.load$default(ConfigLoader.INSTANCE, null, 1, null);
        } else if (size != 1) {
            ArrayList arrayList5 = new ArrayList(C1174w.x(arrayList4, 10));
            Iterator it2 = arrayList4.iterator();
            while (it2.hasNext()) {
                arrayList5.add(ConfigLoader.INSTANCE.load((String) it2.next()));
            }
            Iterator it3 = arrayList5.iterator();
            if (!it3.hasNext()) {
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
            Object next = it3.next();
            while (it3.hasNext()) {
                next = MergedApplicationConfigKt.mergeWith((ApplicationConfig) next, (ApplicationConfig) it3.next());
            }
            applicationConfigLoad$default = (ApplicationConfig) next;
        } else {
            applicationConfigLoad$default = ConfigLoader.INSTANCE.load((String) Z8.F.X0(arrayList4));
        }
        return MergedApplicationConfigKt.mergeWith(MergedApplicationConfigKt.mergeWith(applicationConfigLoad$default, mapApplicationConfig2), mapApplicationConfig);
    }

    public static final void loadCommonConfiguration(ApplicationEngine.Configuration configuration, ApplicationConfig deploymentConfig) {
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        kotlin.jvm.internal.p.i(configuration, "<this>");
        kotlin.jvm.internal.p.i(deploymentConfig, "deploymentConfig");
        ApplicationConfigValue applicationConfigValuePropertyOrNull = deploymentConfig.propertyOrNull("callGroupSize");
        if (applicationConfigValuePropertyOrNull != null && (string5 = applicationConfigValuePropertyOrNull.getString()) != null) {
            configuration.setCallGroupSize(Integer.parseInt(string5));
        }
        ApplicationConfigValue applicationConfigValuePropertyOrNull2 = deploymentConfig.propertyOrNull("connectionGroupSize");
        if (applicationConfigValuePropertyOrNull2 != null && (string4 = applicationConfigValuePropertyOrNull2.getString()) != null) {
            configuration.setConnectionGroupSize(Integer.parseInt(string4));
        }
        ApplicationConfigValue applicationConfigValuePropertyOrNull3 = deploymentConfig.propertyOrNull("workerGroupSize");
        if (applicationConfigValuePropertyOrNull3 != null && (string3 = applicationConfigValuePropertyOrNull3.getString()) != null) {
            configuration.setWorkerGroupSize(Integer.parseInt(string3));
        }
        ApplicationConfigValue applicationConfigValuePropertyOrNull4 = deploymentConfig.propertyOrNull("shutdownGracePeriod");
        if (applicationConfigValuePropertyOrNull4 != null && (string2 = applicationConfigValuePropertyOrNull4.getString()) != null) {
            configuration.setShutdownGracePeriod(Long.parseLong(string2));
        }
        ApplicationConfigValue applicationConfigValuePropertyOrNull5 = deploymentConfig.propertyOrNull("shutdownTimeout");
        if (applicationConfigValuePropertyOrNull5 == null || (string = applicationConfigValuePropertyOrNull5.getString()) == null) {
            return;
        }
        configuration.setShutdownTimeout(Long.parseLong(string));
    }

    public static final Pair<String, String> splitPair(String str, char c10) {
        kotlin.jvm.internal.p.i(str, "<this>");
        int iT0 = H.t0(str, c10, 0, false, 6, null);
        if (iT0 == -1) {
            return null;
        }
        return new Pair<>(K.R1(str, iT0), K.L1(str, iT0 + 1));
    }
}
