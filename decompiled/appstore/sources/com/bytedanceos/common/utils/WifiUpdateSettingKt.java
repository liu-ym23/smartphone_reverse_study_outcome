package com.bytedanceos.common.utils;

import kotlin.Lazy;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: classes2.dex */
public abstract class WifiUpdateSettingKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f10183a = null;

    static {
        f10183a = kotlin.b.b(WifiUpdateSettingKt$_WifiUpdateSettingFlow$2.INSTANCE);
    }

    public static final /* synthetic */ MutableSharedFlow a() {
        return b();
    }

    public static final MutableSharedFlow b() {
        return (MutableSharedFlow) f10183a.getValue();
    }
}
