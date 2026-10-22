package com.bytedance.android.livesdk.utils;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes11.dex */
public final class SettingKeyUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f158785a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f158786b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f158787c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f158788d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f158789e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f158790f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f158791g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f158792h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f158793i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy f158794j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Lazy f158795k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Lazy f158796l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Lazy f158797m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Lazy f158798n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Lazy f158799o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Lazy f158800p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Lazy f158801q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Lazy f158802r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Lazy f158803s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Lazy f158804t = null;

    public static boolean a() {
        return ((Boolean) f158788d.getValue()).booleanValue();
    }

    public static boolean b() {
        return ((Boolean) f158794j.getValue()).booleanValue();
    }

    public static boolean c() {
        return ((Boolean) f158801q.getValue()).booleanValue();
    }

    public static boolean d() {
        return ((Boolean) f158799o.getValue()).booleanValue();
    }

    public static boolean e() {
        return ((Boolean) f158800p.getValue()).booleanValue();
    }

    static {
        f158785a = LazyKt.lazy(SettingKeyUtils$uhdLoginConfig$2.INSTANCE);
        f158786b = LazyKt.lazy(SettingKeyUtils$disableOldContainerFansGroup$2.INSTANCE);
        f158787c = LazyKt.lazy(SettingKeyUtils$disableOldContainerTaskPacket$2.INSTANCE);
        f158788d = LazyKt.lazy(SettingKeyUtils$disableOldContainerChatroomUI$2.INSTANCE);
        f158789e = LazyKt.lazy(SettingKeyUtils$disableOldContainerChatroomAdmin$2.INSTANCE);
        f158790f = LazyKt.lazy(SettingKeyUtils$disableOldContainerChatroomToolbar$2.INSTANCE);
        f158791g = LazyKt.lazy(SettingKeyUtils$disableOldContainerChatroom$2.INSTANCE);
        f158792h = LazyKt.lazy(SettingKeyUtils$disableOldContainerPreview$2.INSTANCE);
        f158793i = LazyKt.lazy(SettingKeyUtils$disableOldContainerLive$2.INSTANCE);
        f158794j = LazyKt.lazy(SettingKeyUtils$disableOldContainerWelfare$2.INSTANCE);
        f158795k = LazyKt.lazy(SettingKeyUtils$disableOldContainer$2.INSTANCE);
        f158796l = LazyKt.lazy(SettingKeyUtils$liveAutoResolutionIndex$2.INSTANCE);
        f158797m = LazyKt.lazy(SettingKeyUtils$liveClearOldResolutionMemoryWhenSet$2.INSTANCE);
        f158798n = LazyKt.lazy(SettingKeyUtils$settingByLazyOpt$2.INSTANCE);
        f158799o = LazyKt.lazy(SettingKeyUtils$vrUseNewStyle$2.INSTANCE);
        f158800p = LazyKt.lazy(SettingKeyUtils$vrUseNewUI$2.INSTANCE);
        f158801q = LazyKt.lazy(SettingKeyUtils$vrUseNewGesture$2.INSTANCE);
        f158802r = LazyKt.lazy(SettingKeyUtils$vrUseNewGestureGuide$2.INSTANCE);
        f158803s = LazyKt.lazy(SettingKeyUtils$vrSupportLandscapeWatch$2.INSTANCE);
        f158804t = LazyKt.lazy(SettingKeyUtils$enableLynxPopupPrefetch$2.INSTANCE);
    }
}
