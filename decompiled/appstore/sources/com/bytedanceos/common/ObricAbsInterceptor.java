package com.bytedanceos.common;

import android.app.Activity;
import android.content.Context;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\u001a\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH&J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&¨\u0006\u000f"}, d2 = {"Lcom/bytedanceos/common/ObricAbsInterceptor;", "", "getAppDetailActivityClass", "Ljava/lang/Class;", "onInitCacheFinish", "", "onInitCacheStart", "openAppManager", "context", "Landroid/content/Context;", "tabTitle", "", "openDebug", "activity", "Landroid/app/Activity;", "appstorecommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface ObricAbsInterceptor {
    @Nullable
    Class<?> getAppDetailActivityClass();

    void onInitCacheFinish();

    void onInitCacheStart();

    void openAppManager(@NotNull Context r10, int r11);

    void openDebug(@Nullable Activity r10);
}
