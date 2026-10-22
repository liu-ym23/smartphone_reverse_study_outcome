package com.bytedance.android.livesdk.wgamex.gameinvite;

import com.bytedance.android.livesdk.message.model.z4;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.game.api.StatusResponse.Data")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/wgamex/gameinvite/g;", "", "Lcom/bytedance/android/livesdk/message/model/z4$a;", "inviteItem", "Lcom/bytedance/android/livesdk/message/model/z4$a;", "", "Lcom/bytedance/android/livesdk/wgamex/gameinvite/e;", "candidates", "Ljava/util/List;", "Lcom/bytedance/android/livesdk/message/model/z4$b;", "switch", "Lcom/bytedance/android/livesdk/message/model/z4$b;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g implements vh7.h {

    @SerializedName("candidates")
    public List<e> candidates;

    @SerializedName("invite_item")
    public z4.a inviteItem;

    /* JADX INFO: renamed from: switch, reason: not valid java name */
    @SerializedName("switch")
    public z4.b f87switch;

    public g() {
    }

    public g(am3.g r100) {
        this.candidates = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.inviteItem = new z4.a(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.candidates.add(new e(r100));
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.f87switch = new z4.b(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }
}
