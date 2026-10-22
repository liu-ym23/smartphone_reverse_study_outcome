package com.bytedance.android.live.ktv.common.model.api;

import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.ig;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\b8\u0006X\u0087D¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\b8\u0006X\u0087D¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/h;", "", "", "Lcom/bytedance/android/live/ktv/common/model/api/h$a;", "listIfs", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "", "wantSingCount", "J", "getWantSingCount", "()J", "wantSingSongThreshold", "c", "displayChallengeCardThreshold", "getDisplayChallengeCardThreshold", "Lcom/bytedance/android/live/ktv/common/model/api/k0;", "userInfoBase", "Lcom/bytedance/android/live/ktv/common/model/api/k0;", "b", "()Lcom/bytedance/android/live/ktv/common/model/api/k0;", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class h implements vh7.h {

    @SerializedName("display_challenge_card_threshold")
    protected long displayChallengeCardThreshold;

    @SerializedName("list_info")
    protected List<a> listIfs;

    @SerializedName("multi_chorus_song_list_item")
    protected k0 userInfoBase;

    @SerializedName("want_sing_count")
    protected long wantSingCount;

    @SerializedName("want_sing_song_threshold")
    protected long wantSingSongThreshold;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/h$a;", "", "Lcom/bytedance/android/livesdk/message/model/KtvMusic;", "music", "Lcom/bytedance/android/livesdk/message/model/KtvMusic;", "b", "()Lcom/bytedance/android/livesdk/message/model/KtvMusic;", "setMusic", "(Lcom/bytedance/android/livesdk/message/model/KtvMusic;)V", "", "isSelfSeeing", "Z", "c", "()Z", "setSelfSeeing", "(Z)V", "Lcom/bytedance/android/livesdk/message/model/ig;", "multiChorusSongItem", "Lcom/bytedance/android/livesdk/message/model/ig;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/message/model/ig;", "setMultiChorusSongItem", "(Lcom/bytedance/android/livesdk/message/model/ig;)V", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class a implements vh7.h {

        @SerializedName("is_self_seeing")
        protected boolean isSelfSeeing;

        @SerializedName("multi_chorus_song_item")
        protected ig multiChorusSongItem;

        @SerializedName("music")
        protected KtvMusic music;

        public a() {
        }

        public a(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L15;
            if (r102 != 1) goto L8;
            this.music = new KtvMusic(r100);
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.isSelfSeeing = am3.h.a(r100);
            goto L3
        L10:
            if (r102 != 3) goto L11;
            this.multiChorusSongItem = new ig(r100);
            goto L3
        L11:
            am3.h.e(r100);
            goto L3
        L15:
            r100.d(r101);
        }

        public final ig a() {
            return this.multiChorusSongItem;
        }

        public final KtvMusic b() {
            return this.music;
        }

        public final boolean c() {
            return this.isSelfSeeing;
        }
    }

    public h() {
        this.listIfs = new ArrayList();
        this.wantSingSongThreshold = -1;
        this.displayChallengeCardThreshold = -1;
    }

    public final List<a> a() {
        return this.listIfs;
    }

    public final k0 b() {
        return this.userInfoBase;
    }

    public final long c() {
        return this.wantSingSongThreshold;
    }

    public h(am3.g r100) {
        this.listIfs = new ArrayList();
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L20;
        if (r103 != 1) goto L7;
        this.listIfs.add(new a(r100));
        goto L3
    L7:
        if (r103 != 2) goto L9;
        this.wantSingCount = r100.j();
        goto L3
    L9:
        if (r103 != 3) goto L11;
        this.wantSingSongThreshold = r100.j();
        r102 = r102 | 1;
        goto L3
    L11:
        if (r103 != 4) goto L13;
        this.displayChallengeCardThreshold = r100.j();
        r102 = r102 | 2;
        goto L3
    L13:
        if (r103 != 6) goto L14;
        this.userInfoBase = new k0(r100);
        goto L3
    L14:
        am3.h.e(r100);
        goto L3
    L20:
        r100.d(r101);
        if (this.listIfs.isEmpty() == false) goto L24;
        this.listIfs = new ArrayList();
    L24:
        if ((r102 & 1) != 0) goto L27;
        this.wantSingSongThreshold = -1;
    L27:
        if ((r102 & 2) != 0) goto L48;
        this.displayChallengeCardThreshold = -1;
        return;
    }
}
