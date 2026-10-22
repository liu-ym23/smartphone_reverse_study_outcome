package com.bytedance.android.live.ktv.common.model.bean;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.message.model.UserHighScoreSongTag;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR,\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/bean/d;", "", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "user", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "f", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "", "", "orderSongs", "Ljava/util/List;", "getOrderSongs", "()Ljava/util/List;", "setOrderSongs", "(Ljava/util/List;)V", "applyTime", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setApplyTime", "(Ljava/lang/String;)V", "Lcom/bytedance/android/livesdk/message/model/UserHighScoreSongTag;", "highScoreSongTag", "Lcom/bytedance/android/livesdk/message/model/UserHighScoreSongTag;", "d", "()Lcom/bytedance/android/livesdk/message/model/UserHighScoreSongTag;", "setHighScoreSongTag", "(Lcom/bytedance/android/livesdk/message/model/UserHighScoreSongTag;)V", "Lcom/bytedance/android/live/ktv/common/model/bean/i;", "userMultiChorusSong", "Lcom/bytedance/android/live/ktv/common/model/bean/i;", "getUserMultiChorusSong", "()Lcom/bytedance/android/live/ktv/common/model/bean/i;", "setUserMultiChorusSong", "(Lcom/bytedance/android/live/ktv/common/model/bean/i;)V", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class d implements vh7.h {

    @SerializedName("apply_time_text")
    protected String applyTime;

    @SerializedName("high_score_song_tag")
    protected UserHighScoreSongTag highScoreSongTag;

    @SerializedName("ordered_song_names")
    protected List<String> orderSongs;

    @SerializedName("user")
    protected IBaseUser user;

    @SerializedName("multi_chorus_song_info")
    protected i userMultiChorusSong;

    public d() {
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [com.bytedance.android.live.base.model.user.IBaseUser, java.lang.Object] */
    public d(am3.g r100) {
        this.orderSongs = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.user = vh7.f.a(r100, IBaseUser.class);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.orderSongs.add(am3.h.c(r100));
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.applyTime = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.highScoreSongTag = new UserHighScoreSongTag(r100);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.userMultiChorusSong = new i(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
    }

    public final String b() {
        i r100 = this.userMultiChorusSong;
        if (r100 == null) goto L10;
        List<e> r101 = r100.songList;
        if (r101 == null) goto L10;
        e r102 = (e) CollectionsKt.firstOrNull(r101);
        if (r102 == null) goto L10;
        String r103 = String.valueOf(r102.songId);
        if (r103 == null) goto L10;
        return r103;
    L10:
        return "";
    }

    public final String c() {
        i r100 = this.userMultiChorusSong;
        if (r100 == null) goto L5;
        List<e> r101 = r100.songList;
    L6:
        List<e> r102 = r101;
        if (r102 != null) goto L9;
    L12:
        boolean r103 = true;
    L14:
        if (r103 == true) goto L24;
        i r104 = this.userMultiChorusSong;
        if (r104 == null) goto L31;
        List<e> r105 = r104.songList;
        if (r105 == null) goto L32;
        e r106 = (e) CollectionsKt.firstOrNull(r105);
        if (r106 == null) goto L33;
        String r107 = r106.songName;
        if (r107 != null) goto L30;
        return "";
    L30:
        return r107;
    L33:
        return "";
    L32:
        return "";
    L31:
        return "";
    L24:
        List<String> r108 = this.orderSongs;
        if (r108 == null) goto L34;
        r107 = (String) CollectionsKt.firstOrNull(r108);
        if (r107 != null) goto L30;
        return "";
    L34:
        return "";
    L9:
        if (r102.isEmpty() == true) goto L12;
        r103 = false;
        goto L14
    L5:
        r101 = null;
        goto L6
    }

    public final long e() {
        i r100 = this.userMultiChorusSong;
        if (r100 == null) goto L5;
        List<e> r101 = r100.songList;
    L6:
        List<e> r102 = r101;
        if (r102 != null) goto L9;
    L12:
        boolean r103 = true;
    L14:
        if (r103 == true) goto L18;
        i r104 = this.userMultiChorusSong;
        if (r104 != null) goto L23;
        return 0;
    L23:
        return r104.totalCount;
    L18:
        List<String> r105 = this.orderSongs;
        if (r105 != null) goto L21;
        return 0;
    L21:
        return r105.size();
    L9:
        if (r102.isEmpty() == true) goto L12;
        r103 = false;
        goto L14
    L5:
        r101 = null;
        goto L6
    }

    public final int hashCode() {
        IBaseUser r100 = this.user;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.orderSongs;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.applyTime;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        UserHighScoreSongTag r110 = this.highScoreSongTag;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        i r113 = this.userMultiChorusSong;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
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

    public final String a() {
        return this.applyTime;
    }

    public final UserHighScoreSongTag d() {
        return this.highScoreSongTag;
    }

    public final IBaseUser f() {
        return this.user;
    }

    public final boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this != r100) goto L9;
        return true;
    L9:
        if ((!Intrinsics.areEqual(d.class, r100.getClass())) == false) goto L11;
        return false;
    L11:
        d r101 = (d) r100;
        IBaseUser r102 = this.user;
        String r103 = null;
        if (r102 == null) goto L14;
        String r104 = r102.getIdString();
    L15:
        IBaseUser r105 = r101.user;
        if (r105 == null) goto L19;
        r103 = r105.getIdString();
    L19:
        if ((!Intrinsics.areEqual(r104, r103)) == false) goto L22;
        return false;
    L22:
        if ((!Intrinsics.areEqual(this.orderSongs, r101.orderSongs)) == false) goto L25;
        return false;
    L25:
        if ((!Intrinsics.areEqual(this.applyTime, r101.applyTime)) == false) goto L28;
        return false;
    L28:
        if ((!Intrinsics.areEqual(this.highScoreSongTag, r101.highScoreSongTag)) == false) goto L31;
        return false;
    L31:
        if ((!Intrinsics.areEqual(this.userMultiChorusSong, r101.userMultiChorusSong)) == false) goto L33;
        return false;
    L33:
        return true;
    L14:
        r104 = null;
        goto L15
    }
}
