package com.bytedance.android.livesdkapi.util;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\"\u001a\u0010\u0000\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005\"\u001a\u0010\u0006\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0003\"\u0004\b\b\u0010\u0005\"\u001a\u0010\t\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0003\"\u0004\b\u000b\u0010\u0005\"\u001a\u0010\f\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0003\"\u0004\b\u000e\u0010\u0005\"\u001a\u0010\u000f\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0003\"\u0004\b\u0011\u0010\u0005¨\u0006\u0012"}, d2 = {"hasAdCouponInjected", "", "getHasAdCouponInjected", "()Z", "setHasAdCouponInjected", "(Z)V", "hasAdWindmillInjected", "getHasAdWindmillInjected", "setHasAdWindmillInjected", "hasEcommerceInjected", "getHasEcommerceInjected", "setHasEcommerceInjected", "hasGameCpInjected", "getHasGameCpInjected", "setHasGameCpInjected", "hasLocalLifeInjected", "getHasLocalLifeInjected", "setHasLocalLifeInjected", "livesdkapi-middleware_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class LiveEnterRoomControllerUtilKt {
    private static boolean hasAdCouponInjected;
    private static boolean hasAdWindmillInjected;
    private static boolean hasEcommerceInjected;
    private static boolean hasGameCpInjected;
    private static boolean hasLocalLifeInjected;

    public static final boolean getHasAdCouponInjected() {
        return hasAdCouponInjected;
    }

    public static final boolean getHasAdWindmillInjected() {
        return hasAdWindmillInjected;
    }

    public static final boolean getHasEcommerceInjected() {
        return hasEcommerceInjected;
    }

    public static final boolean getHasGameCpInjected() {
        return hasGameCpInjected;
    }

    public static final boolean getHasLocalLifeInjected() {
        return hasLocalLifeInjected;
    }

    public static final void setHasAdCouponInjected(boolean r100) {
        hasAdCouponInjected = r100;
    }

    public static final void setHasAdWindmillInjected(boolean r100) {
        hasAdWindmillInjected = r100;
    }

    public static final void setHasEcommerceInjected(boolean r100) {
        hasEcommerceInjected = r100;
    }

    public static final void setHasGameCpInjected(boolean r100) {
        hasGameCpInjected = r100;
    }

    public static final void setHasLocalLifeInjected(boolean r100) {
        hasLocalLifeInjected = r100;
    }
}
