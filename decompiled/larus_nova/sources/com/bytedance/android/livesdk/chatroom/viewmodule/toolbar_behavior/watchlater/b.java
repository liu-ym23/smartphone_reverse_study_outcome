package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@ProtoMessage("webcast.api.distribution.AddWatchLaterResponse")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar_behavior/watchlater/b;", "", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar_behavior/watchlater/a;", "data", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar_behavior/watchlater/a;", "getData", "()Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar_behavior/watchlater/a;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b implements vh7.h {

    @SerializedName("data")
    protected a data;

    public b() {
    }

    public b(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this.data = new a(r100);
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
    }
}
