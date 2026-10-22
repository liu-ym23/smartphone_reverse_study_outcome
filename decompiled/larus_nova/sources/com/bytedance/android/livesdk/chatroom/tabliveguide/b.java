package com.bytedance.android.livesdk.chatroom.tabliveguide;

import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/tabliveguide/b;", "", "Lcom/bytedance/android/livesdk/chatroom/tabliveguide/a;", "feedInnerCardData", "Lcom/bytedance/android/livesdk/chatroom/tabliveguide/a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/chatroom/tabliveguide/a;", "Lcom/bytedance/android/live/base/model/feed/FeedExtra;", "extra", "Lcom/bytedance/android/live/base/model/feed/FeedExtra;", "getExtra", "()Lcom/bytedance/android/live/base/model/feed/FeedExtra;", "livesdkshell_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("extra")
    private final FeedExtra extra;

    @SerializedName("data")
    private final a feedInnerCardData;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.feedInnerCardData, r101.feedInnerCardData) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        a r100 = this.feedInnerCardData;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        FeedExtra r104 = this.extra;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "FeedInnerCardResponse(feedInnerCardData=" + this.feedInnerCardData + ", extra=" + this.extra + ")";
    }

    public b() {
        this.feedInnerCardData = null;
        this.extra = null;
    }

    public final a a() {
        return this.feedInnerCardData;
    }
}
