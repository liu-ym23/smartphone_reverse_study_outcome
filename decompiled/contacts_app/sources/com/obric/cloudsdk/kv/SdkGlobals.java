package com.obric.cloudsdk.kv;

import android.content.Context;
import com.obric.cloudsdk.kv.base.AbsSyncInfo;
import com.obric.cloudsdk.kv.base.StubSyncInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SdkGlobals.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/cloudsdk/kv/SdkGlobals;", "", "()V", "appContext", "Landroid/content/Context;", "syncInfo", "Lcom/obric/cloudsdk/kv/base/AbsSyncInfo;", "getContext", "getSyncInfo", "setAppContext", "", "context", "setSyncInfo", "cloudsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SdkGlobals {
    public static final SdkGlobals INSTANCE = null;
    private static Context appContext;
    private static volatile AbsSyncInfo syncInfo;

    private SdkGlobals() {
    }

    static {
        INSTANCE = new SdkGlobals();
        syncInfo = new StubSyncInfo();
    }

    public final void setAppContext(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Context r0 = r1.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r0, "context.applicationContext");
        appContext = r0;
    }

    public final Context getContext() {
        Context r0 = appContext;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("appContext");
        return null;
    L6:
        return r0;
    }

    public final void setSyncInfo(AbsSyncInfo r1) {
        Intrinsics.checkNotNullParameter(r1, "syncInfo");
        syncInfo = r1;
    }

    public final AbsSyncInfo getSyncInfo() {
        return syncInfo;
    }
}
