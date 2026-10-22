package com.obric.autogui.resourcemanage.a;

import com.obric.autogui.common.api.AOSystemTools;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;

/* JADX INFO: compiled from: ResourceEnvConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f30587a = null;

    static {
        f30587a = new a();
    }

    private a() {
    }

    public final long a() {
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L5;
        return 1;
    L5:
        return DownloadConstants.HOUR;
    }
}
