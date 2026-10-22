package com.stepos.backend.qnn;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class GenieConfigResolution {
    private final String configPath;
    private final List<c7.d> handles;
    private final File rewrittenFile;

    public GenieConfigResolution(String configPath, List<c7.d> handles, File file) {
        kotlin.jvm.internal.g.f(configPath, "configPath");
        kotlin.jvm.internal.g.f(handles, "handles");
        this.configPath = configPath;
        this.handles = handles;
        this.rewrittenFile = file;
    }

    public final String getConfigPath() {
        return this.configPath;
    }

    public final void release() {
        Iterator<T> it = this.handles.iterator();
        while (it.hasNext()) {
            ((c7.d) it.next()).close();
        }
        File file = this.rewrittenFile;
        if (file != null) {
            try {
                file.delete();
            } catch (Throwable th) {
                kotlin.c.a(th);
            }
        }
    }
}
