package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b,\u0010-R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR\"\u0010&\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u000b\u001a\u0004\b'\u0010\r\"\u0004\b(\u0010\u000fR\"\u0010)\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u000b\u001a\u0004\b*\u0010\r\"\u0004\b+\u0010\u000f¨\u0006."}, d2 = {"Lcom/bytedance/android/livesdk/config/fi1;", "", "", "waitingTime", "J", "getWaitingTime", "()J", "setWaitingTime", "(J)V", "", "maxTimes", "I", "getMaxTimes", "()I", "setMaxTimes", "(I)V", "giftGuideFollowShowDelay", "getGiftGuideFollowShowDelay", "setGiftGuideFollowShowDelay", "giftGuideUnFollowShowDelay", "getGiftGuideUnFollowShowDelay", "setGiftGuideUnFollowShowDelay", "giftGuideLoopTime", "getGiftGuideLoopTime", "setGiftGuideLoopTime", "giftGuideMaxTimes", "getGiftGuideMaxTimes", "setGiftGuideMaxTimes", "", "giftWebpUrl", "Ljava/lang/String;", "getGiftWebpUrl", "()Ljava/lang/String;", "setGiftWebpUrl", "(Ljava/lang/String;)V", "ecShopCartLoopTime", "getEcShopCartLoopTime", "setEcShopCartLoopTime", "localLifeLoopTime", "getLocalLifeLoopTime", "setLocalLifeLoopTime", "vrButtonLoopTime", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setVrButtonLoopTime", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class fi1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f120206a = 0;

    @SerializedName("ec_shop_cart_loop_time")
    private long ecShopCartLoopTime;

    @SerializedName("gift_guide_follow_show_delay")
    private long giftGuideFollowShowDelay;

    @SerializedName("gift_guide_loop_time")
    private long giftGuideLoopTime;

    @SerializedName("gift_guide_max_times")
    private int giftGuideMaxTimes;

    @SerializedName("gift_guide_unfollow_show_delay")
    private long giftGuideUnFollowShowDelay;

    @SerializedName("gift_webp_url")
    private String giftWebpUrl;

    @SerializedName("local_life_loop_time")
    private int localLifeLoopTime;

    @SerializedName("follow_max_times")
    private int maxTimes;

    @SerializedName("vr_loop_time")
    private int vrButtonLoopTime;

    @SerializedName("follow_waiting_time")
    private long waitingTime;

    public static final class a {
        public static boolean a() {
            Integer r100 = zu0.f121793a.getValue();
            if (r100 != null) goto L6;
        L7:
            if (r100 != null) goto L10;
        L12:
            return false;
        L10:
            if (r100.intValue() != 5) goto L12;
        L13:
            return true;
        L6:
            if (r100.intValue() == 3) goto L13;
            goto L7
        }

        public static boolean b() {
            Integer r100 = zu0.f121793a.getValue();
            if (r100 != null) goto L6;
        L7:
            if (r100 != null) goto L10;
        L11:
            if (r100 != null) goto L14;
        L16:
            return false;
        L14:
            if (r100.intValue() != 5) goto L16;
            return true;
        L10:
            if (r100.intValue() != 4) goto L11;
            return true;
        L6:
            if (r100.intValue() != 1) goto L7;
            return true;
        }

        public static boolean c() {
            Integer r100 = zu0.f121793a.getValue();
            if (r100 != null) goto L6;
        L7:
            if (r100 != null) goto L10;
        L12:
            return false;
        L10:
            if (r100.intValue() != 4) goto L12;
        L13:
            return true;
        L6:
            if (r100.intValue() == 2) goto L13;
            goto L7
        }
    }

    static {
    }

    public fi1() {
        this.waitingTime = 60000;
        this.maxTimes = 5;
        this.giftGuideFollowShowDelay = 10000;
        this.giftGuideUnFollowShowDelay = 70000;
        this.giftGuideLoopTime = 10000;
        this.giftGuideMaxTimes = 10;
        boolean r100 = tb1.c.f545229a;
        this.giftWebpUrl = "https://p3.douyinpic.com/aweme-client-static-resource/dy_gift_motion.webp~tplv-obj.image";
        this.ecShopCartLoopTime = 10000;
        this.localLifeLoopTime = 10000;
        this.vrButtonLoopTime = 10000;
    }

    public final int a() {
        return this.vrButtonLoopTime;
    }
}
