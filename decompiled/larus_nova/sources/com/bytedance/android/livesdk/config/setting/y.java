package com.bytedance.android.livesdk.config.setting;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/config/setting/y;", "", "", "ogc", "Z", "f", "()Z", "setOgc", "(Z)V", "fastGift", "c", "setFastGift", "hideToolbar", "e", "setHideToolbar", "endPage", "b", "setEndPage", "bottomPanel", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setBottomPanel", "profileCard", "getProfileCard", "setProfileCard", "giftSkin", "d", "setGiftSkin", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class y {

    @SerializedName("bottom_panel")
    private boolean bottomPanel;

    @SerializedName("end_page")
    private boolean endPage;

    @SerializedName("fast_gift")
    private boolean fastGift;

    @SerializedName("gift_skin")
    private boolean giftSkin;

    @SerializedName("hide_toolbar")
    private boolean hideToolbar;

    /* JADX INFO: renamed from: ogc, reason: collision with root package name */
    @SerializedName("ogc")
    private boolean f121221ogc;

    @SerializedName("profile_card")
    private boolean profileCard;

    public y() {
        this.f121221ogc = true;
        this.fastGift = true;
        this.hideToolbar = true;
        this.endPage = true;
        this.bottomPanel = true;
        this.profileCard = true;
        this.giftSkin = true;
    }

    public final boolean a() {
        return this.bottomPanel;
    }

    public final boolean b() {
        return this.endPage;
    }

    public final boolean c() {
        return this.fastGift;
    }

    public final boolean d() {
        return this.giftSkin;
    }

    public final boolean e() {
        return this.hideToolbar;
    }

    public final boolean f() {
        return this.f121221ogc;
    }
}
