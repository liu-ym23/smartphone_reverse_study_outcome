package com.bytedance.android.livesdk.chatroom.utils.uhdLogin;

import com.bytedance.android.livesdk.config.y81;
import com.bytedance.android.livesdk.utils.SettingKeyUtils;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes8.dex */
public final class UhdLoginManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<Integer, a> f114644a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f114645b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final y81 f114646c = null;

    static {
        f114644a = new HashMap();
        f114645b = LazyKt.lazy(UhdLoginManager$uhdLoginTipShowStatistics$2.INSTANCE);
        f114646c = (y81) SettingKeyUtils.f158785a.getValue();
    }
}
