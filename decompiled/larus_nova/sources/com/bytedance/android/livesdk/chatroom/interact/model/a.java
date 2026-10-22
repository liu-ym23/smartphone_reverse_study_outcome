package com.bytedance.android.livesdk.chatroom.interact.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.battle.BattleGetSettingsResponse.ResponseData")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/interact/model/a;", "", "Lcom/bytedance/android/livesdk/chatroom/interact/model/b;", "anchorBattleUserSettings", "Lcom/bytedance/android/livesdk/chatroom/interact/model/b;", "getAnchorBattleUserSettings", "()Lcom/bytedance/android/livesdk/chatroom/interact/model/b;", "setAnchorBattleUserSettings", "(Lcom/bytedance/android/livesdk/chatroom/interact/model/b;)V", "Lcom/bytedance/android/livesdk/chatroom/interact/model/f;", "anchorPrecisionMatchSettings", "Lcom/bytedance/android/livesdk/chatroom/interact/model/f;", "getAnchorPrecisionMatchSettings", "()Lcom/bytedance/android/livesdk/chatroom/interact/model/f;", "setAnchorPrecisionMatchSettings", "(Lcom/bytedance/android/livesdk/chatroom/interact/model/f;)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements vh7.h {

    @SerializedName("settings")
    protected b anchorBattleUserSettings;

    @SerializedName("precision_match_settings")
    protected f anchorPrecisionMatchSettings;

    public a() {
    }

    public a(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.anchorBattleUserSettings = new b(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.anchorPrecisionMatchSettings = new f(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }
}
