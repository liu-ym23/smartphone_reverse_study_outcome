package com.byted.cast.common.auth;

import com.byted.cast.common.CastLogger;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class DefaultAuthWrapper implements ICastAuth {
    private static final String TAG = null;
    private static volatile DefaultAuthWrapper sInstance;

    private DefaultAuthWrapper() {
    }

    @Override // com.byted.cast.common.auth.ICastAuth
    public void destroy() {
    }

    @Override // com.byted.cast.common.auth.ICastAuth
    public String getLicenseParam(String r100) {
        return "";
    }

    @Override // com.byted.cast.common.auth.ICastAuth
    public List<String> getServiceContentList(String r100) {
        return null;
    }

    @Override // com.byted.cast.common.auth.ICastAuth
    public String getServiceEdition(String r100) {
        return null;
    }

    @Override // com.byted.cast.common.auth.ICastAuth
    public void init(String r100) {
    }

    static {
        TAG = "DefaultAuthWrapper";
    }

    public static DefaultAuthWrapper getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(DefaultAuthWrapper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new DefaultAuthWrapper();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DefaultAuthWrapper.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    @Override // com.byted.cast.common.auth.ICastAuth
    public void verifyLicense(String r100, IAuthListener r101) {
        CastLogger.getInstance().i(TAG, "verifyLicense: " + r101);
        if (r101 == null) goto L6;
        r101.onSuccess();
        return;
    }
}
