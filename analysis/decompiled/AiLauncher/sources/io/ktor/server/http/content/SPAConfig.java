package io.ktor.server.http.content;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u001a\b\u0002\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\t0\b¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR,\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\t0\b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lio/ktor/server/http/content/SPAConfig;", "", "", "defaultPage", "applicationRoute", "filesPath", "", "useResources", "", "Lkotlin/Function1;", "ignoredFiles", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;)V", "Ljava/lang/String;", "getDefaultPage", "()Ljava/lang/String;", "setDefaultPage", "(Ljava/lang/String;)V", "getApplicationRoute", "setApplicationRoute", "getFilesPath", "setFilesPath", "Z", "getUseResources", "()Z", "setUseResources", "(Z)V", "Ljava/util/List;", "getIgnoredFiles$ktor_server_core", "()Ljava/util/List;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SPAConfig {
    private String applicationRoute;
    private String defaultPage;
    private String filesPath;
    private final List<InterfaceC5074l<String, Boolean>> ignoredFiles;
    private boolean useResources;

    public SPAConfig() {
        this(null, null, null, false, null, 31, null);
    }

    public final String getApplicationRoute() {
        return this.applicationRoute;
    }

    public final String getDefaultPage() {
        return this.defaultPage;
    }

    public final String getFilesPath() {
        return this.filesPath;
    }

    public final List<InterfaceC5074l<String, Boolean>> getIgnoredFiles$ktor_server_core() {
        return this.ignoredFiles;
    }

    public final boolean getUseResources() {
        return this.useResources;
    }

    public final void setApplicationRoute(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.applicationRoute = str;
    }

    public final void setDefaultPage(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.defaultPage = str;
    }

    public final void setFilesPath(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.filesPath = str;
    }

    public final void setUseResources(boolean z10) {
        this.useResources = z10;
    }

    public SPAConfig(String defaultPage, String applicationRoute, String filesPath, boolean z10, List<InterfaceC5074l<String, Boolean>> ignoredFiles) {
        kotlin.jvm.internal.p.i(defaultPage, "defaultPage");
        kotlin.jvm.internal.p.i(applicationRoute, "applicationRoute");
        kotlin.jvm.internal.p.i(filesPath, "filesPath");
        kotlin.jvm.internal.p.i(ignoredFiles, "ignoredFiles");
        this.defaultPage = defaultPage;
        this.applicationRoute = applicationRoute;
        this.filesPath = filesPath;
        this.useResources = z10;
        this.ignoredFiles = ignoredFiles;
    }

    public /* synthetic */ SPAConfig(String str, String str2, String str3, boolean z10, List list, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? "index.html" : str, (i10 & 2) != 0 ? "/" : str2, (i10 & 4) != 0 ? "" : str3, (i10 & 8) != 0 ? false : z10, (i10 & 16) != 0 ? new ArrayList() : list);
    }
}
