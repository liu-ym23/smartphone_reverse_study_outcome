package com.stepos.deepbinder.core.utils;

import android.app.ActivityManager;
import android.content.ComponentName;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\"\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\b\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"TAG", "", "activityManager", "Landroid/app/ActivityManager;", "componentInternalInfoMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/content/ComponentName;", "Lcom/stepos/deepbinder/core/utils/ComponentInternalInfo;", "currentProcessName", "deepbinder-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IPCUtilsKt {
    private static final String TAG = "IPCUtils";

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f30125a = 0;
    private static ActivityManager activityManager;
    private static final ConcurrentHashMap<ComponentName, ComponentInternalInfo> componentInternalInfoMap = new ConcurrentHashMap<>();
    private static String currentProcessName;
}
