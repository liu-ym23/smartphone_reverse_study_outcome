package com.bytedance.android.livesdk.chatroom.model;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/c3;", "", "", "rankLevel", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setRankLevel", "(Ljava/lang/String;)V", "rankIcon", "c", "setRankIcon", com.bytedance.android.ec.core.event.a.KEY_SCORE, "e", "setScore", "scoreIcon", "f", "setScoreIcon", "heroRank", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setHeroRank", "heroRankIcon", "b", "setHeroRankIcon", "", Keys.API_RETURN_KEY_IS_LOGIN, "Ljava/lang/Boolean;", ce.f26391f, "()Ljava/lang/Boolean;", "setLogin", "(Ljava/lang/Boolean;)V", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c3 {

    @SerializedName("hero_rank")
    private String heroRank;

    @SerializedName("hero_rank_icon")
    private String heroRankIcon;

    @SerializedName("is_login")
    private Boolean isLogin;

    @SerializedName("rank_icon")
    private String rankIcon;

    @SerializedName("rank_level")
    private String rankLevel;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCORE)
    private String score;

    @SerializedName("score_icon")
    private String scoreIcon;

    public final int hashCode() {
        String r100 = this.rankLevel;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.rankIcon;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.score;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.scoreIcon;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.heroRank;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.heroRankIcon;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public c3() {
        this.rankLevel = "";
        this.rankIcon = "";
        this.score = "";
        this.scoreIcon = "";
        this.heroRank = "";
        this.heroRankIcon = "";
        this.isLogin = Boolean.FALSE;
    }

    public final String a() {
        return this.heroRank;
    }

    public final String b() {
        return this.heroRankIcon;
    }

    public final String c() {
        return this.rankIcon;
    }

    public final String d() {
        return this.rankLevel;
    }

    public final String e() {
        return this.score;
    }

    public final String f() {
        return this.scoreIcon;
    }

    public final Boolean g() {
        return this.isLogin;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(c3.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L24;
        c3 r102 = (c3) r100;
        if ((!Intrinsics.areEqual(this.rankLevel, r102.rankLevel)) == false) goto L17;
        return false;
    L17:
        if ((!Intrinsics.areEqual(this.score, r102.score)) == false) goto L20;
        return false;
    L20:
        if ((!Intrinsics.areEqual(this.heroRank, r102.heroRank)) == false) goto L22;
        return false;
    L22:
        return true;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.model.RoleInfo");
    L8:
        r101 = null;
        goto L10
    }
}
