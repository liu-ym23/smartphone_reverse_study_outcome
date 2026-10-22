package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.data.BetOption")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\b¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/h1;", "", "", DBDefinition.ID, "J", "get_id", "()J", "set_id", "(J)V", "", "_optionName", "Ljava/lang/String;", "get_optionName", "()Ljava/lang/String;", "set_optionName", "(Ljava/lang/String;)V", "_money", "get_money", "set_money", "_rate", "get_rate", "set_rate", "", "_win", "Z", "get_win", "()Z", "set_win", "(Z)V", "_canBet", "get_canBet", "set_canBet", "_canBetMoney", "get_canBetMoney", "set_canBetMoney", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h1 implements vh7.h {

    @SerializedName("can_bet")
    protected boolean _canBet;

    @SerializedName("can_bet_money")
    protected long _canBetMoney;

    @SerializedName("id")
    protected long _id;

    @SerializedName("money")
    protected long _money;

    @SerializedName("option_name")
    protected String _optionName;

    @SerializedName("rate")
    protected long _rate;

    @SerializedName("win")
    protected boolean _win;

    public h1() {
    }

    public h1(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        switch(r102) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        this._canBetMoney = r100.j();
        goto L3
    L8:
        this._canBet = am3.h.a(r100);
        goto L3
    L9:
        this._win = am3.h.a(r100);
        goto L3
    L10:
        this._rate = r100.j();
        goto L3
    L11:
        this._money = r100.j();
        goto L3
    L12:
        this._optionName = am3.h.c(r100);
        goto L3
    L13:
        this._id = r100.j();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
    }
}
