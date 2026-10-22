package com.bytedance.android.livesdk.chatroom.tabliveguide;

import com.bytedance.android.live.base.model.feed.FeedItem;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/tabliveguide/c;", "", "", "Lcom/bytedance/android/live/base/model/feed/FeedItem;", "items", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "livesdkshell_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("data")
    private List<? extends FeedItem> items;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.items, ((c) r100).items) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        List<? extends FeedItem> r100 = this.items;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "FeedResponse(items=" + this.items + ")";
    }

    public c() {
        this.items = null;
    }

    public final List<FeedItem> a() {
        return this.items;
    }
}
