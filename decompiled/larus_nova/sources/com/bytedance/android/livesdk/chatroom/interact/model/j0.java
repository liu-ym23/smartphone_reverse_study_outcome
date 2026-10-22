package com.bytedance.android.livesdk.chatroom.interact.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.battle.RivalsRecommendResponse.SearchBar")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/interact/model/j0;", "Lcom/bytedance/android/livesdk/chatroom/interact/model/h;", "", "tabName", "Ljava/lang/String;", "getTabName", "()Ljava/lang/String;", "setTabName", "(Ljava/lang/String;)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j0 extends h implements vh7.h {

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME)
    protected String tabName;

    public j0() {
    }

    public j0(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.backgroundImage = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.content = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.tabName = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }
}
