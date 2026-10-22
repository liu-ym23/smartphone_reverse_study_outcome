package io.ktor.server.engine;

import io.ktor.server.application.ApplicationEnvironment;
import io.ktor.server.config.ApplicationConfig;
import io.ktor.server.config.ConfigLoader;
import io.ktor.server.config.MergedApplicationConfigKt;
import java.util.Arrays;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0005\u001a\u00020\u00042\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\n\u001a\u00020\u0002*\u00020\u00012\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\"\u00020\b¢\u0006\u0004\b\n\u0010\u000b\u001a%\u0010\n\u001a\u00020\u0002*\u00020\u00012\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u0007\"\u00020\f¢\u0006\u0004\b\n\u0010\u000e¨\u0006\u000f"}, d2 = {"Lkotlin/Function1;", "Lio/ktor/server/engine/ApplicationEnvironmentBuilder;", "LY8/t;", "block", "Lio/ktor/server/application/ApplicationEnvironment;", "applicationEnvironment", "(Lp9/l;)Lio/ktor/server/application/ApplicationEnvironment;", "", "", "configPaths", "configure", "(Lio/ktor/server/engine/ApplicationEnvironmentBuilder;[Ljava/lang/String;)V", "Lio/ktor/server/config/ApplicationConfig;", "configs", "(Lio/ktor/server/engine/ApplicationEnvironmentBuilder;[Lio/ktor/server/config/ApplicationConfig;)V", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ApplicationEnvironmentBuilderKt {
    public static final ApplicationEnvironment applicationEnvironment(InterfaceC5074l<? super ApplicationEnvironmentBuilder, Y8.t> block) {
        kotlin.jvm.internal.p.i(block, "block");
        ApplicationEnvironmentBuilder applicationEnvironmentBuilder = new ApplicationEnvironmentBuilder();
        block.invoke(applicationEnvironmentBuilder);
        return applicationEnvironmentBuilder.build();
    }

    public static /* synthetic */ ApplicationEnvironment applicationEnvironment$default(InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.server.engine.a
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return ApplicationEnvironmentBuilderKt.applicationEnvironment$lambda$0((ApplicationEnvironmentBuilder) obj2);
                }
            };
        }
        return applicationEnvironment(interfaceC5074l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t applicationEnvironment$lambda$0(ApplicationEnvironmentBuilder applicationEnvironmentBuilder) {
        kotlin.jvm.internal.p.i(applicationEnvironmentBuilder, "<this>");
        return Y8.t.f7040a;
    }

    public static final void configure(ApplicationEnvironmentBuilder applicationEnvironmentBuilder, String... configPaths) {
        kotlin.jvm.internal.p.i(applicationEnvironmentBuilder, "<this>");
        kotlin.jvm.internal.p.i(configPaths, "configPaths");
        applicationEnvironmentBuilder.setConfig(ConfigLoader.INSTANCE.loadAll((String[]) Arrays.copyOf(configPaths, configPaths.length)));
    }

    public static final void configure(ApplicationEnvironmentBuilder applicationEnvironmentBuilder, ApplicationConfig... configs) {
        kotlin.jvm.internal.p.i(applicationEnvironmentBuilder, "<this>");
        kotlin.jvm.internal.p.i(configs, "configs");
        if (configs.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        ApplicationConfig applicationConfigMergeWith = configs[0];
        int iF0 = Z8.r.f0(configs);
        int i10 = 1;
        if (1 <= iF0) {
            while (true) {
                applicationConfigMergeWith = MergedApplicationConfigKt.mergeWith(applicationConfigMergeWith, configs[i10]);
                if (i10 == iF0) {
                    break;
                } else {
                    i10++;
                }
            }
        }
        applicationEnvironmentBuilder.setConfig(applicationConfigMergeWith);
    }
}
