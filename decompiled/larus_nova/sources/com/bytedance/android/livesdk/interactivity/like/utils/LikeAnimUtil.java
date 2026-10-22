package com.bytedance.android.livesdk.interactivity.like.utils;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes9.dex */
public final class LikeAnimUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f137709a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f137710b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f137711c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f137712d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f137713e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f137714f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f137715g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f137716h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f137717i = null;

    public static AccelerateDecelerateInterpolator a() {
        return (AccelerateDecelerateInterpolator) f137710b.getValue();
    }

    public static LinearInterpolator b() {
        return (LinearInterpolator) f137711c.getValue();
    }

    static {
        f137709a = com.bytedance.android.livesdk.interactivity.api.base.utils.a.a(LikeAnimUtil$pathInterpolator$2.INSTANCE);
        f137710b = com.bytedance.android.livesdk.interactivity.api.base.utils.a.a(LikeAnimUtil$accelerateDecelerateInterpolator$2.INSTANCE);
        f137711c = com.bytedance.android.livesdk.interactivity.api.base.utils.a.a(LikeAnimUtil$linearInterpolator$2.INSTANCE);
        f137712d = com.bytedance.android.livesdk.interactivity.api.base.utils.a.a(LikeAnimUtil$othersLikeAlphaValuesHolder$2.INSTANCE);
        f137713e = com.bytedance.android.livesdk.interactivity.api.base.utils.a.a(LikeAnimUtil$hotRoomOthersLikeAlphaValuesHolder$2.INSTANCE);
        f137714f = com.bytedance.android.livesdk.interactivity.api.base.utils.a.a(LikeAnimUtil$selfOneLikePropertyValuesHolder$2.INSTANCE);
        f137715g = com.bytedance.android.livesdk.interactivity.api.base.utils.a.a(LikeAnimUtil$selfTwoLikePropertyValuesHolder$2.INSTANCE);
        f137716h = com.bytedance.android.livesdk.interactivity.api.base.utils.a.a(LikeAnimUtil$tapLikeScaleValuesHolder$2.INSTANCE);
        f137717i = com.bytedance.android.livesdk.interactivity.api.base.utils.a.a(LikeAnimUtil$tapLikeAlphaValuesHolder$2.INSTANCE);
    }
}
