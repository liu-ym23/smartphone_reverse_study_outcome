package com.bytedance.android.live.soloktv.model;

import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/soloktv/model/f;", "", "Lcom/bytedance/android/livesdk/message/model/KtvMusic;", Keys.API_EVENT_KEY_SONG, "Lcom/bytedance/android/livesdk/message/model/KtvMusic;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/message/model/KtvMusic;", "", "sungCount", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class f implements vh7.h {

    @SerializedName(Keys.API_EVENT_KEY_SONG)
    protected KtvMusic song;

    @SerializedName("sung_count")
    protected Long sungCount;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L10;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.song, r101.song) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.sungCount, r101.sungCount) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        KtvMusic r100 = this.song;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.sungCount;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PersonalKaraokeAnchorGetSongInfoResponse(song=" + this.song + ", sungCount=" + this.sungCount + ")";
    }

    public f() {
        this.song = null;
        this.sungCount = null;
    }

    public final KtvMusic a() {
        return this.song;
    }

    public final Long b() {
        return this.sungCount;
    }

    public f(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.song = new KtvMusic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.sungCount = Long.valueOf(r100.j());
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        if (this.song != null) goto L16;
        this.song = null;
    L16:
        if (this.sungCount != null) goto L28;
        this.sungCount = null;
        return;
    }
}
