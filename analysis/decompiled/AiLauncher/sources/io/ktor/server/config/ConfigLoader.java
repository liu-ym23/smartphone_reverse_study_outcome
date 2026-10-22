package io.ktor.server.config;

import Z8.r;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lio/ktor/server/config/ConfigLoader;", "", "", "path", "Lio/ktor/server/config/ApplicationConfig;", "load", "(Ljava/lang/String;)Lio/ktor/server/config/ApplicationConfig;", "Companion", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ConfigLoader {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00072\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/server/config/ConfigLoader$Companion;", "", "<init>", "()V", "", "", "configPaths", "Lio/ktor/server/config/ApplicationConfig;", "loadAll", "([Ljava/lang/String;)Lio/ktor/server/config/ApplicationConfig;", "path", "load", "(Ljava/lang/String;)Lio/ktor/server/config/ApplicationConfig;", "loadDefault", "()Lio/ktor/server/config/ApplicationConfig;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public static /* synthetic */ ApplicationConfig load$default(Companion companion, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = null;
            }
            return companion.load(str);
        }

        private final ApplicationConfig loadDefault() {
            for (String str : ConfigLoadersJvmKt.getCONFIG_PATH()) {
                Iterator<ConfigLoader> it = ConfigLoadersJvmKt.getConfigLoaders().iterator();
                while (it.hasNext()) {
                    ApplicationConfig applicationConfigLoad = it.next().load(str);
                    if (applicationConfigLoad != null) {
                        return applicationConfigLoad;
                    }
                }
            }
            return null;
        }

        public final ApplicationConfig load(String path) {
            ApplicationConfig applicationConfigLoadDefault;
            if (path == null && (applicationConfigLoadDefault = loadDefault()) != null) {
                return applicationConfigLoadDefault;
            }
            Iterator<ConfigLoader> it = ConfigLoadersJvmKt.getConfigLoaders().iterator();
            while (it.hasNext()) {
                ApplicationConfig applicationConfigLoad = it.next().load(path);
                if (applicationConfigLoad != null) {
                    return applicationConfigLoad;
                }
            }
            return new MapApplicationConfig();
        }

        public final ApplicationConfig loadAll(String... configPaths) {
            p.i(configPaths, "configPaths");
            int length = configPaths.length;
            if (length == 0) {
                return load$default(this, null, 1, null);
            }
            if (length == 1) {
                return load((String) r.E0(configPaths));
            }
            ArrayList arrayList = new ArrayList(configPaths.length);
            for (String str : configPaths) {
                arrayList.add(load(str));
            }
            Iterator it = arrayList.iterator();
            if (!it.hasNext()) {
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
            Object next = it.next();
            while (it.hasNext()) {
                next = MergedApplicationConfigKt.mergeWith((ApplicationConfig) next, (ApplicationConfig) it.next());
            }
            return (ApplicationConfig) next;
        }
    }

    ApplicationConfig load(String path);
}
