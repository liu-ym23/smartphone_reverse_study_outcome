package com.bytedance.android.livesdk.gift.relay.model;

import am3.g;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes9.dex */
@IgnoreProtoFieldCheck
@ProtoMessage("webcast.data.FreeCellData")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b5\u00106R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R$\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010,\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0004\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\bR\"\u0010/\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0004\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u0010\bR\"\u00102\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010\u0004\u001a\u0004\b3\u0010\u0006\"\u0004\b4\u0010\b¨\u00067"}, d2 = {"Lcom/bytedance/android/livesdk/gift/relay/model/a;", "", "", "mGiftId", "J", "getMGiftId", "()J", "setMGiftId", "(J)V", "mTimeNowMs", "getMTimeNowMs", "setMTimeNowMs", "mTimeStartMs", "getMTimeStartMs", "setMTimeStartMs", "mTimeFreezeEndMs", "getMTimeFreezeEndMs", "setMTimeFreezeEndMs", "mTimeDoubleEndMs", "getMTimeDoubleEndMs", "setMTimeDoubleEndMs", "mTimeEndMs", "getMTimeEndMs", "setMTimeEndMs", "mFreeCellLength", "getMFreeCellLength", "setMFreeCellLength", "", "mIsFreeze", "Z", "getMIsFreeze", "()Z", "setMIsFreeze", "(Z)V", "mIsDouble", "getMIsDouble", "setMIsDouble", "Lcom/bytedance/android/live/base/model/user/User;", "mContributeMostUser", "Lcom/bytedance/android/live/base/model/user/User;", "getMContributeMostUser", "()Lcom/bytedance/android/live/base/model/user/User;", "setMContributeMostUser", "(Lcom/bytedance/android/live/base/model/user/User;)V", "mContributeMostCoins", "getMContributeMostCoins", "setMContributeMostCoins", "mDistanceFromPreviousOne", "getMDistanceFromPreviousOne", "setMDistanceFromPreviousOne", "mIndexInDayRankList", "getMIndexInDayRankList", "setMIndexInDayRankList", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName("contribute_most_coins")
    protected long mContributeMostCoins;

    @SerializedName("contribute_most_user")
    protected User mContributeMostUser;

    @SerializedName("distance_from_previous_one")
    protected long mDistanceFromPreviousOne;

    @SerializedName("free_cell_length")
    protected long mFreeCellLength;

    @SerializedName(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID)
    protected long mGiftId;

    @SerializedName("index_in_day_ranklist")
    protected long mIndexInDayRankList;

    @SerializedName("is_double")
    protected boolean mIsDouble;

    @SerializedName("is_freeze")
    protected boolean mIsFreeze;

    @SerializedName("time_double_end_ms")
    protected long mTimeDoubleEndMs;

    @SerializedName("time_end_ms")
    protected long mTimeEndMs;

    @SerializedName("time_freeze_end_ms")
    protected long mTimeFreezeEndMs;

    @SerializedName("time_now_ms")
    protected long mTimeNowMs;

    @SerializedName("time_start_ms")
    protected long mTimeStartMs;

    public a() {
    }

    public a(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L20;
        switch(r102) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L10;
            case 11: goto L9;
            case 12: goto L8;
            case 13: goto L7;
            default: goto L6;
        };
    L7:
        this.mGiftId = r100.j();
        goto L3
    L8:
        this.mIndexInDayRankList = r100.j();
        goto L3
    L9:
        this.mDistanceFromPreviousOne = r100.j();
        goto L3
    L10:
        this.mContributeMostCoins = r100.j();
        goto L3
    L11:
        this.mContributeMostUser = new User(r100);
        goto L3
    L12:
        this.mIsDouble = am3.h.a(r100);
        goto L3
    L13:
        this.mIsFreeze = am3.h.a(r100);
        goto L3
    L14:
        this.mFreeCellLength = r100.j();
        goto L3
    L15:
        this.mTimeEndMs = r100.j();
        goto L3
    L16:
        this.mTimeDoubleEndMs = r100.j();
        goto L3
    L17:
        this.mTimeFreezeEndMs = r100.j();
        goto L3
    L18:
        this.mTimeStartMs = r100.j();
        goto L3
    L19:
        this.mTimeNowMs = r100.j();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L20:
        r100.d(r101);
    }
}
