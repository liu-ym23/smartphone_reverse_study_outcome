package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import py.k;
import vh7.f;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001a\u0010\u0007\u001a\u00020\u00068\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u00068\u0006X\u0087D¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\nR\u001a\u0010\r\u001a\u00020\u00068\u0006X\u0087D¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\nR\u001a\u0010\u000f\u001a\u00020\u00068\u0006X\u0087D¢\u0006\f\n\u0004\b\u000f\u0010\b\u001a\u0004\b\u0010\u0010\nR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006X\u0087D¢\u0006\f\n\u0004\b\u0011\u0010\b\u001a\u0004\b\u0012\u0010\nR\u0011\u0010\u0016\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/CoinConfig;", "", "", "isNew", "Z", "()Z", "", "point", "Ljava/lang/String;", "getPoint", "()Ljava/lang/String;", "coin", "getCoin", "coinDesc", "getCoinDesc", "coinFullDesc", "getCoinFullDesc", "icCoin", "getIcCoin", "Lpy/k;", "getCoinImageModel", "()Lpy/k;", "coinImageModel", "<init>", "()V", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CoinConfig {
    public static final Companion Companion = null;
    public static final String DIAMOND_ICON = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_ic_coin_diamond.png";

    @SerializedName("coin")
    private final String coin;

    @SerializedName("coin_desc")
    private final String coinDesc;

    @SerializedName("coin_full_desc")
    private final String coinFullDesc;

    @SerializedName("ic_coin")
    private final String icCoin;

    @SerializedName("is_new")
    private final boolean isNew;

    @SerializedName("point")
    private final String point;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/CoinConfig$Companion;", "", "()V", "DIAMOND_ICON", "", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final k getCoinImageModel() {
        k r100 = (k) f.c(k.class);
        ArrayList r101 = new ArrayList();
        String r102 = this.icCoin;
        if (r102 != null) goto L5;
        r102 = DIAMOND_ICON;
    L5:
        r101.add(r102);
        r100.setUrls(r101);
        return r100;
    }

    public CoinConfig() {
        this.isNew = true;
        this.point = "音浪";
        this.coin = "钻";
        this.coinDesc = "钻石";
        this.coinFullDesc = "抖音钻石";
        this.icCoin = DIAMOND_ICON;
    }

    public final String getCoin() {
        return this.coin;
    }

    public final String getCoinDesc() {
        return this.coinDesc;
    }

    public final String getCoinFullDesc() {
        return this.coinFullDesc;
    }

    public final String getIcCoin() {
        return this.icCoin;
    }

    public final String getPoint() {
        return this.point;
    }

    public final boolean isNew() {
        return this.isNew;
    }
}
