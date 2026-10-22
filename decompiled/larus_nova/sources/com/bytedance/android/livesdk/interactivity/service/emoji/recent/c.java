package com.bytedance.android.livesdk.interactivity.service.emoji.recent;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/service/emoji/recent/c;", "", "", "Lcom/bytedance/android/livesdk/interactivity/service/emoji/recent/b;", "recentEmojiList", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setRecentEmojiList", "(Ljava/util/List;)V", "community-service_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("recent_emoji_list")
    private List<b> recentEmojiList;

    public c() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.recentEmojiList, ((c) r100).recentEmojiList) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        List<b> r100 = this.recentEmojiList;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "RecentEmojiData(recentEmojiList=" + this.recentEmojiList + ")";
    }

    public final List<b> a() {
        return this.recentEmojiList;
    }

    public c(List<b> r100) {
        this.recentEmojiList = r100;
    }
}
