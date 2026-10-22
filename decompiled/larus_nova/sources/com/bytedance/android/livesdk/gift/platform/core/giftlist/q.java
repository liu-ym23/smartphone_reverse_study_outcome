package com.bytedance.android.livesdk.gift.platform.core.giftlist;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/giftlist/q;", "", "", "giftImageWebp", "Z", "b", "()Z", "setGiftImageWebp", "(Z)V", "userGradeWebp", "d", "setUserGradeWebp", "fansClubBadgeWebp", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setFansClubBadgeWebp", "payGradeBadgeWebp", "c", "setPayGradeBadgeWebp", "webpToHeicEnable", "e", "setWebpToHeicEnable", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q {

    @SerializedName("fans_club_badge_webp")
    private boolean fansClubBadgeWebp;

    @SerializedName("gift_image_webp")
    private boolean giftImageWebp;

    @SerializedName("pay_grade_badge_webp")
    private boolean payGradeBadgeWebp;

    @SerializedName("user_grade_webp")
    private boolean userGradeWebp;

    @SerializedName("webp_to_heic")
    private boolean webpToHeicEnable;

    public q() {
    }

    public final boolean a() {
        return this.fansClubBadgeWebp;
    }

    public final boolean b() {
        return this.giftImageWebp;
    }

    public final boolean c() {
        return this.payGradeBadgeWebp;
    }

    public final boolean d() {
        return this.userGradeWebp;
    }

    public final boolean e() {
        return this.webpToHeicEnable;
    }
}
