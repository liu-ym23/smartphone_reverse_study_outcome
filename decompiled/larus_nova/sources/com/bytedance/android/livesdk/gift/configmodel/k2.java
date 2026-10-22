package com.bytedance.android.livesdk.gift.configmodel;

import androidx.lifecycle.LiveData;
import com.bytedance.live.kmp.core.KmpEnv;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/k2;", "", "", "giftGuideFollowShowDelay", "J", "b", "()J", "setGiftGuideFollowShowDelay", "(J)V", "giftGuideUnFollowShowDelay", "getGiftGuideUnFollowShowDelay", "setGiftGuideUnFollowShowDelay", "giftGuideLoopTime", "getGiftGuideLoopTime", "setGiftGuideLoopTime", "", "giftGuideMaxTimes", "I", "getGiftGuideMaxTimes", "()I", "setGiftGuideMaxTimes", "(I)V", "", "giftWebpUrl", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setGiftWebpUrl", "(Ljava/lang/String;)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f126014b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, String> f126015a;

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

    public static final class a {
    }

    static {
    }

    public final void a() {
        Map<String, String> r100 = new LinkedHashMap();
        LiveData r101 = ((tr2.a) vh6.c.b(tr2.a.class)).Ki("live_rev_animation_config", r100);
        if (r101 == null) goto L8;
        Map<String, String> r102 = (Map) r101.getValue();
        if (r102 == null) goto L8;
        r100 = r102;
    L8:
        this.f126015a = r100;
    }

    public final long d() {
        if (this.f126015a != null) goto L5;
        a();
    L5:
        Map<String, String> r100 = this.f126015a;
        if (r100 != null) goto L8;
    L11:
        boolean r101 = true;
    L12:
        if (r101 == true) goto L23;
        Map<String, String> r102 = this.f126015a;
        if (r102 == null) goto L22;
        String r103 = r102.get("giftGuideFollowShowDelay");
        if (r103 == null) goto L22;
        Long r104 = StringsKt.toLongOrNull(r103);
        if (r104 == null) goto L22;
        return r104.longValue();
    L22:
        return this.giftGuideFollowShowDelay;
    L23:
        return this.giftGuideFollowShowDelay;
    L8:
        if (r100.isEmpty() == true) goto L11;
        r101 = false;
        goto L12
    }

    public final long e() {
        if (this.f126015a != null) goto L5;
        a();
    L5:
        Map<String, String> r100 = this.f126015a;
        if (r100 != null) goto L8;
    L11:
        boolean r101 = true;
    L12:
        if (r101 == true) goto L23;
        Map<String, String> r102 = this.f126015a;
        if (r102 == null) goto L22;
        String r103 = r102.get("giftGuideLoopTime");
        if (r103 == null) goto L22;
        Long r104 = StringsKt.toLongOrNull(r103);
        if (r104 == null) goto L22;
        return r104.longValue();
    L22:
        return this.giftGuideLoopTime;
    L23:
        return this.giftGuideLoopTime;
    L8:
        if (r100.isEmpty() == true) goto L11;
        r101 = false;
        goto L12
    }

    public final int f() {
        if (this.f126015a != null) goto L5;
        a();
    L5:
        Map<String, String> r100 = this.f126015a;
        if (r100 != null) goto L8;
    L11:
        boolean r101 = true;
    L12:
        if (r101 == true) goto L23;
        Map<String, String> r102 = this.f126015a;
        if (r102 == null) goto L22;
        String r103 = r102.get("giftGuideMaxTimes");
        if (r103 == null) goto L22;
        Integer r104 = StringsKt.toIntOrNull(r103);
        if (r104 == null) goto L22;
        return r104.intValue();
    L22:
        return this.giftGuideMaxTimes;
    L23:
        return this.giftGuideMaxTimes;
    L8:
        if (r100.isEmpty() == true) goto L11;
        r101 = false;
        goto L12
    }

    public final long g() {
        if (this.f126015a != null) goto L5;
        a();
    L5:
        Map<String, String> r100 = this.f126015a;
        if (r100 != null) goto L8;
    L11:
        boolean r101 = true;
    L12:
        if (r101 == true) goto L23;
        Map<String, String> r102 = this.f126015a;
        if (r102 == null) goto L22;
        String r103 = r102.get("giftGuideUnFollowShowDelay");
        if (r103 == null) goto L22;
        Long r104 = StringsKt.toLongOrNull(r103);
        if (r104 == null) goto L22;
        return r104.longValue();
    L22:
        return this.giftGuideUnFollowShowDelay;
    L23:
        return this.giftGuideUnFollowShowDelay;
    L8:
        if (r100.isEmpty() == true) goto L11;
        r101 = false;
        goto L12
    }

    public k2() {
        this.giftGuideFollowShowDelay = 10000;
        this.giftGuideUnFollowShowDelay = 70000;
        this.giftGuideLoopTime = 10000;
        this.giftGuideMaxTimes = 10;
        KmpEnv r100 = KmpEnv.f255139a;
        KmpEnv.a();
        this.giftWebpUrl = "https://p3.douyinpic.com/aweme-client-static-resource/dy_gift_motion.webp~tplv-obj.image";
    }

    public final long b() {
        return this.giftGuideFollowShowDelay;
    }

    public final String c() {
        return this.giftWebpUrl;
    }
}
