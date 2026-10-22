package com.bytedance.android.livesdk.chatroom.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/x3;", "", "", EffectConfiguration.KEY_CURSOR, "Ljava/lang/Long;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Long;", "", "hasMore", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "", "Lcom/bytedance/android/livesdk/chatroom/model/j;", "videoList", "Ljava/util/List;", "c", "()Ljava/util/List;", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class x3 {

    @SerializedName(EffectConfiguration.KEY_CURSOR)
    private final Long cursor;

    @SerializedName("has_more")
    private final Boolean hasMore;

    @SerializedName("video_list")
    private final List<j> videoList;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof x3) == false) goto L12;
        x3 r101 = (x3) r100;
        if (Intrinsics.areEqual(this.cursor, r101.cursor) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.hasMore, r101.hasMore) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.videoList, r101.videoList) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Long r100 = this.cursor;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.hasMore;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<j> r107 = this.videoList;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "VideoSearchResponse(cursor=" + this.cursor + ", hasMore=" + this.hasMore + ", videoList=" + this.videoList + ")";
    }

    public x3() {
        this.cursor = null;
        this.hasMore = null;
        this.videoList = null;
    }

    public final Long a() {
        return this.cursor;
    }

    public final Boolean b() {
        return this.hasMore;
    }

    public final List<j> c() {
        return this.videoList;
    }
}
