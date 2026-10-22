package com.bytedance.android.live.user.api;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes7.dex */
public final class UserSetting {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f102502a = null;

    static {
        f102502a = LazyKt.lazy(UserSetting$opt$2.INSTANCE);
    }

    @JvmStatic
    public static final boolean a() {
        return !((Boolean) f102502a.getValue()).booleanValue();
    }

    @JvmStatic
    public static final boolean b() {
        return ((Boolean) f102502a.getValue()).booleanValue();
    }
}
