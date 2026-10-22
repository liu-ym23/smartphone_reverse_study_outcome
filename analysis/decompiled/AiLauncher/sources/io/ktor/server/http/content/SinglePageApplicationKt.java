package io.ktor.server.http.content;

import io.ktor.server.routing.Route;
import java.io.File;
import java.net.URL;
import java.util.Iterator;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u000b\u001a'\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\n\u001a\u00020\u0003*\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a\u0019\u0010\r\u001a\u00020\u0003*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a\u0019\u0010\u000f\u001a\u00020\u0003*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u000e\u001a\u0019\u0010\u0010\u001a\u00020\u0003*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u000e\u001a\u0019\u0010\u0011\u001a\u00020\u0003*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u000e\u001a\u0019\u0010\u0012\u001a\u00020\u0003*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u000e¨\u0006\u0013"}, d2 = {"Lio/ktor/server/routing/Route;", "Lkotlin/Function1;", "Lio/ktor/server/http/content/SPAConfig;", "LY8/t;", "configBuilder", "singlePageApplication", "(Lio/ktor/server/routing/Route;Lp9/l;)V", "", "", "block", "ignoreFiles", "(Lio/ktor/server/http/content/SPAConfig;Lp9/l;)V", "filesPath", "angular", "(Lio/ktor/server/http/content/SPAConfig;Ljava/lang/String;)V", "react", "vue", "ember", "backbone", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SinglePageApplicationKt {
    public static final void angular(SPAConfig sPAConfig, String filesPath) {
        kotlin.jvm.internal.p.i(sPAConfig, "<this>");
        kotlin.jvm.internal.p.i(filesPath, "filesPath");
        sPAConfig.setFilesPath(filesPath);
    }

    public static final void backbone(SPAConfig sPAConfig, String filesPath) {
        kotlin.jvm.internal.p.i(sPAConfig, "<this>");
        kotlin.jvm.internal.p.i(filesPath, "filesPath");
        sPAConfig.setFilesPath(filesPath);
    }

    public static final void ember(SPAConfig sPAConfig, String filesPath) {
        kotlin.jvm.internal.p.i(sPAConfig, "<this>");
        kotlin.jvm.internal.p.i(filesPath, "filesPath");
        sPAConfig.setFilesPath(filesPath);
    }

    public static final void ignoreFiles(SPAConfig sPAConfig, InterfaceC5074l<? super String, Boolean> block) {
        kotlin.jvm.internal.p.i(sPAConfig, "<this>");
        kotlin.jvm.internal.p.i(block, "block");
        sPAConfig.getIgnoredFiles$ktor_server_core().add(block);
    }

    public static final void react(SPAConfig sPAConfig, String filesPath) {
        kotlin.jvm.internal.p.i(sPAConfig, "<this>");
        kotlin.jvm.internal.p.i(filesPath, "filesPath");
        sPAConfig.setFilesPath(filesPath);
    }

    public static final void singlePageApplication(Route route, InterfaceC5074l<? super SPAConfig, Y8.t> configBuilder) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(configBuilder, "configBuilder");
        final SPAConfig sPAConfig = new SPAConfig(null, null, null, false, null, 31, null);
        configBuilder.invoke(sPAConfig);
        if (sPAConfig.getUseResources()) {
            StaticContentKt.staticResources(route, sPAConfig.getApplicationRoute(), sPAConfig.getFilesPath(), sPAConfig.getDefaultPage(), new InterfaceC5074l() { // from class: io.ktor.server.http.content.p
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return SinglePageApplicationKt.singlePageApplication$lambda$3(sPAConfig, (StaticContentConfig) obj);
                }
            });
        } else {
            StaticContentKt.staticFiles(route, sPAConfig.getApplicationRoute(), new File(sPAConfig.getFilesPath()), sPAConfig.getDefaultPage(), new InterfaceC5074l() { // from class: io.ktor.server.http.content.q
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return SinglePageApplicationKt.singlePageApplication$lambda$6(sPAConfig, (StaticContentConfig) obj);
                }
            });
        }
    }

    public static /* synthetic */ void singlePageApplication$default(Route route, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.server.http.content.t
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return SinglePageApplicationKt.singlePageApplication$lambda$0((SPAConfig) obj2);
                }
            };
        }
        singlePageApplication(route, interfaceC5074l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t singlePageApplication$lambda$0(SPAConfig sPAConfig) {
        kotlin.jvm.internal.p.i(sPAConfig, "<this>");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t singlePageApplication$lambda$3(SPAConfig sPAConfig, StaticContentConfig staticResources) {
        kotlin.jvm.internal.p.i(staticResources, "$this$staticResources");
        staticResources.m172default(sPAConfig.getDefaultPage());
        Iterator<T> it = sPAConfig.getIgnoredFiles$ktor_server_core().iterator();
        while (it.hasNext()) {
            final InterfaceC5074l interfaceC5074l = (InterfaceC5074l) it.next();
            staticResources.exclude(new InterfaceC5074l() { // from class: io.ktor.server.http.content.s
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(SinglePageApplicationKt.singlePageApplication$lambda$3$lambda$2$lambda$1(interfaceC5074l, (URL) obj));
                }
            });
        }
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean singlePageApplication$lambda$3$lambda$2$lambda$1(InterfaceC5074l interfaceC5074l, URL url) {
        kotlin.jvm.internal.p.i(url, "url");
        String path = url.getPath();
        kotlin.jvm.internal.p.h(path, "getPath(...)");
        return ((Boolean) interfaceC5074l.invoke(path)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t singlePageApplication$lambda$6(SPAConfig sPAConfig, StaticContentConfig staticFiles) {
        kotlin.jvm.internal.p.i(staticFiles, "$this$staticFiles");
        staticFiles.m172default(sPAConfig.getDefaultPage());
        Iterator<T> it = sPAConfig.getIgnoredFiles$ktor_server_core().iterator();
        while (it.hasNext()) {
            final InterfaceC5074l interfaceC5074l = (InterfaceC5074l) it.next();
            staticFiles.exclude(new InterfaceC5074l() { // from class: io.ktor.server.http.content.r
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(SinglePageApplicationKt.singlePageApplication$lambda$6$lambda$5$lambda$4(interfaceC5074l, (File) obj));
                }
            });
        }
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean singlePageApplication$lambda$6$lambda$5$lambda$4(InterfaceC5074l interfaceC5074l, File url) {
        kotlin.jvm.internal.p.i(url, "url");
        String path = url.getPath();
        kotlin.jvm.internal.p.h(path, "getPath(...)");
        return ((Boolean) interfaceC5074l.invoke(path)).booleanValue();
    }

    public static final void vue(SPAConfig sPAConfig, String filesPath) {
        kotlin.jvm.internal.p.i(sPAConfig, "<this>");
        kotlin.jvm.internal.p.i(filesPath, "filesPath");
        sPAConfig.setFilesPath(filesPath);
    }
}
