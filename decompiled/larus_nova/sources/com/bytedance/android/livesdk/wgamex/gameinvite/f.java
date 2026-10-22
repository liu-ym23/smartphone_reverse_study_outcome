package com.bytedance.android.livesdk.wgamex.gameinvite;

import com.bytedance.android.livesdk.message.model.z4;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.game.api.InviteResponse.Data")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/wgamex/gameinvite/f;", "", "Lcom/bytedance/android/livesdk/message/model/z4$a;", "inviteItem", "Lcom/bytedance/android/livesdk/message/model/z4$a;", "Lcom/bytedance/android/livesdk/message/model/z4$b;", "switch", "Lcom/bytedance/android/livesdk/message/model/z4$b;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f implements vh7.h {

    @SerializedName("invite_item")
    public z4.a inviteItem;

    /* JADX INFO: renamed from: switch, reason: not valid java name */
    @SerializedName("switch")
    public z4.b f86switch;

    public f() {
    }

    public f(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.inviteItem = new z4.a(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.f86switch = new z4.b(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }
}
